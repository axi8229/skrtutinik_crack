package ru.roadar.facerecog;

import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class Yuv {

    public enum Type {
        YUV_NV21,
        YUV_420
    }

    public static class Converted {
        public final ByteBuffer buffer;
        public final Type type;

        private Converted(Type type, ByteBuffer byteBuffer) {
            this.type = type;
            this.buffer = byteBuffer;
        }
    }

    public static Converted toBuffer(ImageProxy imageProxy, ByteBuffer byteBuffer) {
        return toBuffer(wrap(imageProxy), byteBuffer);
    }

    private static ImageWrapper wrap(ImageProxy imageProxy) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        ImageProxy.PlaneProxy[] planes = imageProxy.getPlanes();
        int i = width / 2;
        int i2 = height / 2;
        return new ImageWrapper(width, height, wrap(width, height, planes[0]), wrap(i, i2, planes[1]), wrap(i, i2, planes[2]));
    }

    private static PlaneWrapper wrap(int i, int i2, ImageProxy.PlaneProxy planeProxy) {
        return new PlaneWrapper(i, i2, planeProxy.getBuffer(), planeProxy.getRowStride(), planeProxy.getPixelStride());
    }

    static Type detectType(ImageWrapper imageWrapper) {
        if (imageWrapper.u.pixelStride == 1) {
            return Type.YUV_420;
        }
        return Type.YUV_NV21;
    }

    static Converted toBuffer(ImageWrapper imageWrapper, ByteBuffer byteBuffer) {
        Type typeDetectType = detectType(imageWrapper);
        ByteBuffer byteBufferPrepareOutput = prepareOutput(imageWrapper, byteBuffer);
        removePadding(imageWrapper, typeDetectType, byteBufferPrepareOutput);
        return new Converted(typeDetectType, byteBufferPrepareOutput);
    }

    private static ByteBuffer prepareOutput(ImageWrapper imageWrapper, ByteBuffer byteBuffer) {
        int i = ((imageWrapper.width * imageWrapper.height) * 3) / 2;
        if (byteBuffer == null || byteBuffer.capacity() != i || byteBuffer.isReadOnly()) {
            byteBuffer = ByteBuffer.allocateDirect(i);
        }
        byteBuffer.rewind();
        return byteBuffer;
    }

    private static void removePadding(ImageWrapper imageWrapper, Type type, ByteBuffer byteBuffer) {
        PlaneWrapper planeWrapper = imageWrapper.y;
        int i = planeWrapper.width;
        int i2 = planeWrapper.height * i;
        PlaneWrapper planeWrapper2 = imageWrapper.u;
        int i3 = planeWrapper2.width * planeWrapper2.height;
        if (planeWrapper.rowStride > i) {
            removePaddingCompact(planeWrapper, byteBuffer, 0);
        } else {
            byteBuffer.position(0);
            byteBuffer.put(imageWrapper.y.buffer);
        }
        if (type.equals(Type.YUV_420)) {
            PlaneWrapper planeWrapper3 = imageWrapper.u;
            if (planeWrapper3.rowStride > planeWrapper3.width) {
                removePaddingCompact(planeWrapper3, byteBuffer, i2);
                removePaddingCompact(imageWrapper.v, byteBuffer, i2 + i3);
            } else {
                byteBuffer.position(i2);
                byteBuffer.put(imageWrapper.u.buffer);
                byteBuffer.position(i2 + i3);
                byteBuffer.put(imageWrapper.v.buffer);
            }
        } else {
            PlaneWrapper planeWrapper4 = imageWrapper.u;
            if (planeWrapper4.rowStride > planeWrapper4.width * 2) {
                removePaddingNotCompact(imageWrapper, byteBuffer, i2);
            } else {
                byteBuffer.position(i2);
                byteBuffer.put(imageWrapper.u.buffer);
                byteBuffer.put(imageWrapper.v.buffer.get(r6.capacity() - 1));
            }
        }
        byteBuffer.rewind();
    }

    private static void removePaddingCompact(PlaneWrapper planeWrapper, ByteBuffer byteBuffer, int i) {
        if (planeWrapper.pixelStride != 1) {
            throw new IllegalArgumentException("removePaddingCompact must be used with pixelStride == 1");
        }
        ByteBuffer byteBuffer2 = planeWrapper.buffer;
        int i2 = planeWrapper.rowStride;
        byteBuffer.position(i);
        for (int i3 = 0; i3 < planeWrapper.height; i3++) {
            byteBuffer.put(clipBuffer(byteBuffer2, i3 * i2, planeWrapper.width));
        }
    }

    private static void removePaddingNotCompact(ImageWrapper imageWrapper, ByteBuffer byteBuffer, int i) {
        PlaneWrapper planeWrapper = imageWrapper.u;
        if (planeWrapper.pixelStride != 2) {
            throw new IllegalArgumentException("removePaddingNotCompact must be used with pixelStride == 2");
        }
        int i2 = planeWrapper.width;
        int i3 = planeWrapper.height;
        int i4 = planeWrapper.rowStride;
        byteBuffer.position(i);
        int i5 = 0;
        while (true) {
            if (i5 < i3 - 1) {
                byteBuffer.put(clipBuffer(imageWrapper.u.buffer, i5 * i4, i2 * 2));
                i5++;
            } else {
                byteBuffer.put(clipBuffer(imageWrapper.v.buffer, (r4 * i4) - 1, i2 * 2));
                return;
            }
        }
    }

    private static ByteBuffer clipBuffer(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(i + i2);
        return byteBufferDuplicate.slice();
    }

    static class ImageWrapper {
        final int height;
        final PlaneWrapper u;
        final PlaneWrapper v;
        final int width;
        final PlaneWrapper y;

        ImageWrapper(int i, int i2, PlaneWrapper planeWrapper, PlaneWrapper planeWrapper2, PlaneWrapper planeWrapper3) {
            this.width = i;
            this.height = i2;
            this.y = planeWrapper;
            this.u = planeWrapper2;
            this.v = planeWrapper3;
            checkFormat();
        }

        private void checkFormat() {
            if (this.y.pixelStride != 1) {
                throw new IllegalArgumentException(String.format("Pixel stride for Y plane must be 1 but got %d instead", Integer.valueOf(this.y.pixelStride)));
            }
            PlaneWrapper planeWrapper = this.u;
            int i = planeWrapper.pixelStride;
            PlaneWrapper planeWrapper2 = this.v;
            if (i != planeWrapper2.pixelStride || planeWrapper.rowStride != planeWrapper2.rowStride) {
                throw new IllegalArgumentException(String.format("U and V planes must have the same pixel and row strides but got pixel=%d row=%d for U and pixel=%d and row=%d for V", Integer.valueOf(this.u.pixelStride), Integer.valueOf(this.u.rowStride), Integer.valueOf(this.v.pixelStride), Integer.valueOf(this.v.rowStride)));
            }
            if (i != 1 && i != 2) {
                throw new IllegalArgumentException("Supported pixel strides for U and V planes are 1 and 2");
            }
        }
    }

    static class PlaneWrapper {
        final ByteBuffer buffer;
        final int height;
        final int pixelStride;
        final int rowStride;
        final int width;

        PlaneWrapper(int i, int i2, ByteBuffer byteBuffer, int i3, int i4) {
            this.width = i;
            this.height = i2;
            this.buffer = byteBuffer;
            this.rowStride = i3;
            this.pixelStride = i4;
        }
    }
}
