package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.core.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ImageUtil {
    public static Bitmap createBitmapFromPlane(ImageProxy.PlaneProxy[] planeProxyArr, int i, int i2) {
        Preconditions.checkArgument(planeProxyArr.length == 1, "Expect a single plane");
        Preconditions.checkArgument(planeProxyArr[0].getPixelStride() == 4, "Expect pixelStride=4");
        Preconditions.checkArgument(planeProxyArr[0].getRowStride() == i * 4, "Expect rowStride=width*4");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        planeProxyArr[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(bitmapCreateBitmap, planeProxyArr[0].getBuffer(), planeProxyArr[0].getRowStride());
        return bitmapCreateBitmap;
    }

    public static ByteBuffer createDirectByteBuffer(Bitmap bitmap) {
        Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ARGB_8888, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getAllocationByteCount());
        ImageProcessingUtil.copyBitmapToByteBuffer(bitmap, byteBufferAllocateDirect, bitmap.getRowBytes());
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }

    public static Rational getRotatedAspectRatio(int i, Rational rational) {
        if (i == 90 || i == 270) {
            return inverseRational(rational);
        }
        return new Rational(rational.getNumerator(), rational.getDenominator());
    }

    public static byte[] yuvImageToJpegByteArray(ImageProxy imageProxy, Rect rect, int i, int i2) throws CodecFailedException {
        if (imageProxy.getFormat() != 35) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
        }
        YuvImage yuvImage = new YuvImage(yuv_420_888toNv21(imageProxy), 17, imageProxy.getWidth(), imageProxy.getHeight(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ExifOutputStream exifOutputStream = new ExifOutputStream(byteArrayOutputStream, ExifData.create(imageProxy, i2));
        if (rect == null) {
            rect = new Rect(0, 0, imageProxy.getWidth(), imageProxy.getHeight());
        }
        if (!yuvImage.compressToJpeg(rect, i, exifOutputStream)) {
            throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] yuv_420_888toNv21(ImageProxy imageProxy) {
        ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[0];
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.getPlanes()[1];
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.getPlanes()[2];
        ByteBuffer buffer = planeProxy.getBuffer();
        ByteBuffer buffer2 = planeProxy2.getBuffer();
        ByteBuffer buffer3 = planeProxy3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[((imageProxy.getWidth() * imageProxy.getHeight()) / 2) + iRemaining];
        int width = 0;
        for (int i = 0; i < imageProxy.getHeight(); i++) {
            buffer.get(bArr, width, imageProxy.getWidth());
            width += imageProxy.getWidth();
            buffer.position(Math.min(iRemaining, (buffer.position() - imageProxy.getWidth()) + planeProxy.getRowStride()));
        }
        int height = imageProxy.getHeight() / 2;
        int width2 = imageProxy.getWidth() / 2;
        int rowStride = planeProxy3.getRowStride();
        int rowStride2 = planeProxy2.getRowStride();
        int pixelStride = planeProxy3.getPixelStride();
        int pixelStride2 = planeProxy2.getPixelStride();
        byte[] bArr2 = new byte[rowStride];
        byte[] bArr3 = new byte[rowStride2];
        for (int i2 = 0; i2 < height; i2++) {
            buffer3.get(bArr2, 0, Math.min(rowStride, buffer3.remaining()));
            buffer2.get(bArr3, 0, Math.min(rowStride2, buffer2.remaining()));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < width2; i5++) {
                int i6 = width + 1;
                bArr[width] = bArr2[i3];
                width += 2;
                bArr[i6] = bArr3[i4];
                i3 += pixelStride;
                i4 += pixelStride2;
            }
        }
        return bArr;
    }

    private static Rational inverseRational(Rational rational) {
        return rational == null ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static final class CodecFailedException extends Exception {
        private final FailureType mFailureType;

        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(String str, FailureType failureType) {
            super(str);
            this.mFailureType = failureType;
        }
    }
}
