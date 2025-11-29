package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import coil.ImageLoader;
import coil.content.Bitmaps;
import coil.content.Utils;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* compiled from: BitmapFactoryDecoder.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0013\u0010\u000e\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "Lcoil/decode/ImageSource;", "source", "Lcoil/request/Options;", "options", "Lkotlinx/coroutines/sync/Semaphore;", "parallelismLock", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "Landroid/graphics/BitmapFactory$Options;", "Lcoil/decode/DecodeResult;", "decode", "(Landroid/graphics/BitmapFactory$Options;)Lcoil/decode/DecodeResult;", "Lcoil/decode/ExifData;", "exifData", "", "configureConfig", "(Landroid/graphics/BitmapFactory$Options;Lcoil/decode/ExifData;)V", "configureScale", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/decode/ImageSource;", "Lcoil/request/Options;", "Lkotlinx/coroutines/sync/Semaphore;", "Lcoil/decode/ExifOrientationPolicy;", "Companion", "ExceptionCatchingSource", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitmapFactoryDecoder implements Decoder {
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", l = {232, 46}, m = "decode")
    /* renamed from: coil.decode.BitmapFactoryDecoder$decode$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BitmapFactoryDecoder.this.decode(this);
        }
    }

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphore;
        this.exifOrientationPolicy = exifOrientationPolicy;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil.decode.BitmapFactoryDecoder.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = (coil.decode.BitmapFactoryDecoder.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = new coil.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L30
            goto L70
        L30:
            r8 = move-exception
            goto L7a
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3a:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r2 = (kotlinx.coroutines.sync.Semaphore) r2
            java.lang.Object r5 = r0.L$0
            coil.decode.BitmapFactoryDecoder r5 = (coil.decode.BitmapFactoryDecoder) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L5a
        L47:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.parallelismLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.acquire(r0)
            if (r2 != r1) goto L59
            return r1
        L59:
            r5 = r7
        L5a:
            coil.decode.BitmapFactoryDecoder$decode$2$1 r2 = new coil.decode.BitmapFactoryDecoder$decode$2$1     // Catch: java.lang.Throwable -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L76
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L76
            r0.label = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r5, r2, r0, r4, r5)     // Catch: java.lang.Throwable -> L76
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r6 = r0
            r0 = r8
            r8 = r6
        L70:
            coil.decode.DecodeResult r8 = (coil.decode.DecodeResult) r8     // Catch: java.lang.Throwable -> L30
            r0.release()
            return r8
        L76:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L7a:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DecodeResult decode(BitmapFactory.Options options) throws Exception {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.source.source());
        BufferedSource bufferedSourceBuffer = Okio.buffer(exceptionCatchingSource);
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedSourceBuffer.peek().inputStream(), null, options);
        Exception exception = exceptionCatchingSource.getException();
        if (exception != null) {
            throw exception;
        }
        options.inJustDecodeBounds = false;
        ExifUtils exifUtils = ExifUtils.INSTANCE;
        ExifData exifData = exifUtils.getExifData(options.outMimeType, bufferedSourceBuffer, this.exifOrientationPolicy);
        Exception exception2 = exceptionCatchingSource.getException();
        if (exception2 != null) {
            throw exception2;
        }
        options.inMutable = false;
        if (Build.VERSION.SDK_INT >= 26 && this.options.getColorSpace() != null) {
            options.inPreferredColorSpace = this.options.getColorSpace();
        }
        options.inPremultiplied = this.options.getPremultipliedAlpha();
        configureConfig(options, exifData);
        configureScale(options, exifData);
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedSourceBuffer.inputStream(), null, options);
            CloseableKt.closeFinally(bufferedSourceBuffer, null);
            Exception exception3 = exceptionCatchingSource.getException();
            if (exception3 != null) {
                throw exception3;
            }
            if (bitmapDecodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
            }
            bitmapDecodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), exifUtils.reverseTransformations(bitmapDecodeStream, exifData));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z = false;
            }
            return new DecodeResult(bitmapDrawable, z);
        } finally {
        }
    }

    private final void configureConfig(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config config = this.options.getConfig();
        if (exifData.getIsFlipped() || ExifUtilsKt.isRotated(exifData)) {
            config = Bitmaps.toSoftware(config);
        }
        if (this.options.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && config != Bitmap.Config.HARDWARE) {
            config = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = config;
    }

    private final void configureScale(BitmapFactory.Options options, ExifData exifData) {
        ImageSource.Metadata metadata = this.source.getMetadata();
        if ((metadata instanceof ResourceMetadata) && Sizes.isOriginal(this.options.getSize())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((ResourceMetadata) metadata).getDensity();
            options.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i = ExifUtilsKt.isSwapped(exifData) ? options.outHeight : options.outWidth;
        int i2 = ExifUtilsKt.isSwapped(exifData) ? options.outWidth : options.outHeight;
        Size size = this.options.getSize();
        int px = Sizes.isOriginal(size) ? i : Utils.toPx(size.getWidth(), this.options.getScale());
        Size size2 = this.options.getSize();
        int px2 = Sizes.isOriginal(size2) ? i2 : Utils.toPx(size2.getHeight(), this.options.getScale());
        int iCalculateInSampleSize = DecodeUtils.calculateInSampleSize(i, i2, px, px2, this.options.getScale());
        options.inSampleSize = iCalculateInSampleSize;
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i / iCalculateInSampleSize, i2 / iCalculateInSampleSize, px, px2, this.options.getScale());
        if (this.options.getAllowInexactSize()) {
            dComputeSizeMultiplier = RangesKt.coerceAtMost(dComputeSizeMultiplier, 1.0d);
        }
        boolean z = dComputeSizeMultiplier == 1.0d;
        options.inScaled = !z;
        if (z) {
            return;
        }
        if (dComputeSizeMultiplier > 1.0d) {
            options.inDensity = MathKt.roundToInt(Integer.MAX_VALUE / dComputeSizeMultiplier);
            options.inTargetDensity = Integer.MAX_VALUE;
        } else {
            options.inDensity = Integer.MAX_VALUE;
            options.inTargetDensity = MathKt.roundToInt(Integer.MAX_VALUE * dComputeSizeMultiplier);
        }
    }

    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "", "maxParallelism", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(ILcoil/decode/ExifOrientationPolicy;)V", "Lcoil/fetch/SourceResult;", "result", "Lcoil/request/Options;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/decode/Decoder;", "create", "(Lcoil/fetch/SourceResult;Lcoil/request/Options;Lcoil/ImageLoader;)Lcoil/decode/Decoder;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lcoil/decode/ExifOrientationPolicy;", "Lkotlinx/coroutines/sync/Semaphore;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        public Factory(int i, ExifOrientationPolicy exifOrientationPolicy) {
            this.exifOrientationPolicy = exifOrientationPolicy;
            this.parallelismLock = SemaphoreKt.Semaphore$default(i, 0, 2, null);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(result.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object other) {
            return other instanceof Factory;
        }

        public int hashCode() {
            return Factory.class.hashCode();
        }
    }

    /* compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long byteCount) throws Exception {
            try {
                return super.read(sink, byteCount);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }
}
