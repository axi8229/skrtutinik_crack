package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.webrtc.EglBase14;
import org.webrtc.EncodedImage;
import org.webrtc.GlRectDrawer;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoCodecStatus;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrameDrawer;
import org.webrtc.YuvHelper;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapper;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapperFactory;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.VideoCodecMimeType;

/* loaded from: classes5.dex */
class HardwareVideoEncoder implements VideoEncoder {
    private int adjustedBitrate;
    private boolean automaticResizeOn;
    private final BitrateAdjuster bitrateAdjuster;
    private VideoEncoder.Callback callback;
    private MediaCodecWrapper codec;
    private final String codecName;
    private final VideoCodecMimeType codecType;
    private ByteBuffer configBuffer;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private final long forcedKeyFrameNs;
    private int height;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private long nextPresentationTimestampUs;
    private final BusyCount outputBuffersBusyCount;
    private Thread outputThread;
    private final ThreadUtils.ThreadChecker outputThreadChecker;
    private final Map<String, String> params;
    private volatile boolean running;
    private final EglBase14.Context sharedContext;
    private volatile Exception shutdownException;
    private int sliceHeight;
    private int stride;
    private final Integer surfaceColorFormat;
    private EglBase14 textureEglBase;
    private Surface textureInputSurface;
    private boolean useSurfaceMode;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;
    private final GlRectDrawer textureDrawer = new GlRectDrawer();
    private final VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();
    private final BlockingDeque<EncodedImage.Builder> outputBuilders = new LinkedBlockingDeque();

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecMimeType videoCodecMimeType, Integer num, Integer num2, Map<String, String> map, int i, int i2, BitrateAdjuster bitrateAdjuster, EglBase14.Context context) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = threadChecker;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.outputBuffersBusyCount = new BusyCount();
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecMimeType;
        this.surfaceColorFormat = num;
        this.yuvColorFormat = num2;
        this.yuvFormat = YuvFormat.valueOf(num2.intValue());
        this.params = map;
        this.keyFrameIntervalSec = i;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(i2);
        this.bitrateAdjuster = bitrateAdjuster;
        this.sharedContext = context;
        threadChecker.detachThread();
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        int i;
        this.encodeThreadChecker.checkIsOnValidThread();
        this.callback = callback;
        this.automaticResizeOn = settings.automaticResizeOn;
        int i2 = settings.width;
        if (i2 % 16 == 0) {
            int i3 = settings.height;
            if (i3 % 16 == 0) {
                this.width = i2;
                this.height = i3;
                this.useSurfaceMode = canUseSurface();
                int i4 = settings.startBitrate;
                if (i4 != 0 && (i = settings.maxFramerate) != 0) {
                    this.bitrateAdjuster.setTargets(i4 * 1000, i);
                }
                this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
                Logging.d("HardwareVideoEncoder", "initEncode: " + this.width + " x " + this.height + ". @ " + settings.startBitrate + "kbps. Fps: " + settings.maxFramerate + " Use surface mode: " + this.useSurfaceMode);
                return initEncodeInternal();
            }
        }
        Logging.e("HardwareVideoEncoder", "MediaCodec is only tested with resolutions that are 16x16 aligned.");
        return VideoCodecStatus.ERR_SIZE;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[Catch: IllegalStateException -> 0x0088, TryCatch #1 {IllegalStateException -> 0x0088, blocks: (B:9:0x0026, B:11:0x0060, B:15:0x006f, B:31:0x0098, B:32:0x00ad, B:20:0x007e, B:25:0x008b, B:33:0x00bb, B:35:0x00d9, B:36:0x00f5), top: B:45:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.webrtc.VideoCodecStatus initEncodeInternal() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder.initEncodeInternal():org.webrtc.VideoCodecStatus");
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus release() {
        VideoCodecStatus videoCodecStatus;
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.outputThread == null) {
            videoCodecStatus = VideoCodecStatus.OK;
        } else {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, DeviceOrientationRequest.OUTPUT_PERIOD_FAST)) {
                Logging.e("HardwareVideoEncoder", "Media encoder release timeout");
                videoCodecStatus = VideoCodecStatus.TIMEOUT;
            } else if (this.shutdownException != null) {
                Logging.e("HardwareVideoEncoder", "Media encoder release exception", this.shutdownException);
                videoCodecStatus = VideoCodecStatus.ERROR;
            } else {
                videoCodecStatus = VideoCodecStatus.OK;
            }
        }
        this.textureDrawer.release();
        this.videoFrameDrawer.release();
        EglBase14 eglBase14 = this.textureEglBase;
        if (eglBase14 != null) {
            eglBase14.release();
            this.textureEglBase = null;
        }
        Surface surface = this.textureInputSurface;
        if (surface != null) {
            surface.release();
            this.textureInputSurface = null;
        }
        this.outputBuilders.clear();
        this.codec = null;
        this.outputThread = null;
        this.encodeThreadChecker.detachThread();
        return videoCodecStatus;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        VideoCodecStatus videoCodecStatusResetCodec;
        VideoCodecStatus videoCodecStatusEncodeByteBuffer;
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.codec == null) {
            return VideoCodecStatus.UNINITIALIZED;
        }
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        boolean z = buffer instanceof VideoFrame.TextureBuffer;
        int width = videoFrame.getBuffer().getWidth();
        int height = videoFrame.getBuffer().getHeight();
        boolean z2 = canUseSurface() && z;
        if ((width != this.width || height != this.height || z2 != this.useSurfaceMode) && (videoCodecStatusResetCodec = resetCodec(width, height, z2)) != VideoCodecStatus.OK) {
            return videoCodecStatusResetCodec;
        }
        if (this.outputBuilders.size() > 2) {
            Logging.e("HardwareVideoEncoder", "Dropped frame, encoder queue full");
            return VideoCodecStatus.NO_OUTPUT;
        }
        boolean z3 = false;
        for (EncodedImage.FrameType frameType : encodeInfo.frameTypes) {
            if (frameType == EncodedImage.FrameType.VideoFrameKey) {
                z3 = true;
            }
        }
        if (z3 || shouldForceKeyFrame(videoFrame.getTimestampNs())) {
            requestKeyFrame(videoFrame.getTimestampNs());
        }
        int height2 = ((buffer.getHeight() * buffer.getWidth()) * 3) / 2;
        this.outputBuilders.offer(EncodedImage.builder().setCaptureTimeNs(videoFrame.getTimestampNs()).setEncodedWidth(videoFrame.getBuffer().getWidth()).setEncodedHeight(videoFrame.getBuffer().getHeight()).setRotation(videoFrame.getRotation()));
        long j = this.nextPresentationTimestampUs;
        this.nextPresentationTimestampUs += (long) (TimeUnit.SECONDS.toMicros(1L) / this.bitrateAdjuster.getAdjustedFramerateFps());
        if (this.useSurfaceMode) {
            videoCodecStatusEncodeByteBuffer = encodeTextureBuffer(videoFrame, j);
        } else {
            videoCodecStatusEncodeByteBuffer = encodeByteBuffer(videoFrame, j, buffer, height2);
        }
        if (videoCodecStatusEncodeByteBuffer != VideoCodecStatus.OK) {
            this.outputBuilders.pollLast();
        }
        return videoCodecStatusEncodeByteBuffer;
    }

    private VideoCodecStatus encodeTextureBuffer(VideoFrame videoFrame, long j) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            GLES20.glClear(16384);
            this.videoFrameDrawer.drawFrame(new VideoFrame(videoFrame.getBuffer(), 0, videoFrame.getTimestampNs()), this.textureDrawer, null);
            this.textureEglBase.swapBuffers(TimeUnit.MICROSECONDS.toNanos(j));
            return VideoCodecStatus.OK;
        } catch (RuntimeException e) {
            Logging.e("HardwareVideoEncoder", "encodeTexture failed", e);
            return VideoCodecStatus.ERROR;
        }
    }

    private VideoCodecStatus encodeByteBuffer(VideoFrame videoFrame, long j, VideoFrame.Buffer buffer, int i) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            int iDequeueInputBuffer = this.codec.dequeueInputBuffer(0L);
            if (iDequeueInputBuffer == -1) {
                Logging.d("HardwareVideoEncoder", "Dropped frame, no input buffers available");
                return VideoCodecStatus.NO_OUTPUT;
            }
            try {
                fillInputBuffer(this.codec.getInputBuffer(iDequeueInputBuffer), buffer);
                try {
                    this.codec.queueInputBuffer(iDequeueInputBuffer, 0, i, j, 0);
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e) {
                    Logging.e("HardwareVideoEncoder", "queueInputBuffer failed", e);
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e2) {
                Logging.e("HardwareVideoEncoder", "getInputBuffer with index=" + iDequeueInputBuffer + " failed", e2);
                return VideoCodecStatus.ERROR;
            }
        } catch (IllegalStateException e3) {
            Logging.e("HardwareVideoEncoder", "dequeueInputBuffer failed", e3);
            return VideoCodecStatus.ERROR;
        }
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i) {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (i > 30) {
            i = 30;
        }
        this.bitrateAdjuster.setTargets(bitrateAllocation.getSum(), i);
        return VideoCodecStatus.OK;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoCodecStatus setRates(VideoEncoder.RateControlParameters rateControlParameters) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.bitrateAdjuster.setTargets(rateControlParameters.bitrate.getSum(), rateControlParameters.framerateFps);
        return VideoCodecStatus.OK;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoEncoder.ScalingSettings getScalingSettings() {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.automaticResizeOn) {
            VideoCodecMimeType videoCodecMimeType = this.codecType;
            if (videoCodecMimeType == VideoCodecMimeType.VP8) {
                return new VideoEncoder.ScalingSettings(29, 95);
            }
            if (videoCodecMimeType == VideoCodecMimeType.H264) {
                return new VideoEncoder.ScalingSettings(24, 37);
            }
        }
        return VideoEncoder.ScalingSettings.OFF;
    }

    @Override // org.webrtc.VideoEncoder
    public String getImplementationName() {
        return this.codecName;
    }

    @Override // org.webrtc.VideoEncoder
    public VideoEncoder.EncoderInfo getEncoderInfo() {
        return new VideoEncoder.EncoderInfo(16, false);
    }

    private VideoCodecStatus resetCodec(int i, int i2, boolean z) {
        this.encodeThreadChecker.checkIsOnValidThread();
        VideoCodecStatus videoCodecStatusRelease = release();
        if (videoCodecStatusRelease != VideoCodecStatus.OK) {
            return videoCodecStatusRelease;
        }
        if (i % 16 == 0 && i2 % 16 == 0) {
            this.width = i;
            this.height = i2;
            this.useSurfaceMode = z;
            return initEncodeInternal();
        }
        Logging.e("HardwareVideoEncoder", "MediaCodec is only tested with resolutions that are 16x16 aligned.");
        return VideoCodecStatus.ERR_SIZE;
    }

    private boolean shouldForceKeyFrame(long j) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long j2 = this.forcedKeyFrameNs;
        return j2 > 0 && j > this.lastKeyFrameNs + j2;
    }

    private void requestKeyFrame(long j) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.codec.setParameters(bundle);
            this.lastKeyFrameNs = j;
        } catch (IllegalStateException e) {
            Logging.e("HardwareVideoEncoder", "requestKeyFrame failed", e);
        }
    }

    private Thread createOutputThread() {
        return new Thread() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (HardwareVideoEncoder.this.running) {
                    HardwareVideoEncoder.this.deliverEncodedImage();
                }
                HardwareVideoEncoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    protected void deliverEncodedImage() {
        ByteBuffer byteBufferSlice;
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            final int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 100000L);
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -3) {
                    this.outputBuffersBusyCount.waitForZero();
                    return;
                }
                return;
            }
            ByteBuffer outputBuffer = this.codec.getOutputBuffer(iDequeueOutputBuffer);
            outputBuffer.position(bufferInfo.offset);
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            if ((bufferInfo.flags & 2) != 0) {
                Logging.d("HardwareVideoEncoder", "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                this.configBuffer = byteBufferAllocateDirect;
                byteBufferAllocateDirect.put(outputBuffer);
                return;
            }
            this.bitrateAdjuster.reportEncodedFrame(bufferInfo.size);
            if (this.adjustedBitrate != this.bitrateAdjuster.getAdjustedBitrateBps()) {
                updateBitrate();
            }
            boolean z = true;
            if ((bufferInfo.flags & 1) == 0) {
                z = false;
            }
            if (z) {
                Logging.d("HardwareVideoEncoder", "Sync frame generated");
            }
            if (z && this.codecType == VideoCodecMimeType.H264) {
                Logging.d("HardwareVideoEncoder", "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                byteBufferSlice = ByteBuffer.allocateDirect(bufferInfo.size + this.configBuffer.capacity());
                this.configBuffer.rewind();
                byteBufferSlice.put(this.configBuffer);
                byteBufferSlice.put(outputBuffer);
                byteBufferSlice.rewind();
            } else {
                byteBufferSlice = outputBuffer.slice();
            }
            EncodedImage.FrameType frameType = z ? EncodedImage.FrameType.VideoFrameKey : EncodedImage.FrameType.VideoFrameDelta;
            this.outputBuffersBusyCount.increment();
            EncodedImage encodedImageCreateEncodedImage = this.outputBuilders.poll().setBuffer(byteBufferSlice, new Runnable() { // from class: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deliverEncodedImage$0(iDequeueOutputBuffer);
                }
            }).setFrameType(frameType).createEncodedImage();
            this.callback.onEncodedFrame(encodedImageCreateEncodedImage, new VideoEncoder.CodecSpecificInfo());
            encodedImageCreateEncodedImage.release();
        } catch (IllegalStateException e) {
            Logging.e("HardwareVideoEncoder", "deliverOutput failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deliverEncodedImage$0(int i) {
        try {
            this.codec.releaseOutputBuffer(i, false);
        } catch (Exception e) {
            Logging.e("HardwareVideoEncoder", "releaseOutputBuffer failed", e);
        }
        this.outputBuffersBusyCount.decrement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d("HardwareVideoEncoder", "Releasing MediaCodec on output thread");
        this.outputBuffersBusyCount.waitForZero();
        try {
            this.codec.stop();
        } catch (Exception e) {
            Logging.e("HardwareVideoEncoder", "Media encoder stop failed", e);
        }
        try {
            this.codec.release();
        } catch (Exception e2) {
            Logging.e("HardwareVideoEncoder", "Media encoder release failed", e2);
            this.shutdownException = e2;
        }
        this.configBuffer = null;
        Logging.d("HardwareVideoEncoder", "Release on output thread done");
    }

    private VideoCodecStatus updateBitrate() {
        this.outputThreadChecker.checkIsOnValidThread();
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.adjustedBitrate);
            this.codec.setParameters(bundle);
            return VideoCodecStatus.OK;
        } catch (IllegalStateException e) {
            Logging.e("HardwareVideoEncoder", "updateBitrate failed", e);
            return VideoCodecStatus.ERROR;
        }
    }

    private boolean canUseSurface() {
        return (this.sharedContext == null || this.surfaceColorFormat == null) ? false : true;
    }

    private static int getStride(MediaFormat mediaFormat, int i) {
        return (mediaFormat == null || !mediaFormat.containsKey("stride")) ? i : mediaFormat.getInteger("stride");
    }

    private static int getSliceHeight(MediaFormat mediaFormat, int i) {
        return (mediaFormat == null || !mediaFormat.containsKey("slice-height")) ? i : mediaFormat.getInteger("slice-height");
    }

    protected void fillInputBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
        this.yuvFormat.fillBuffer(byteBuffer, buffer, this.stride, this.sliceHeight);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class YuvFormat {
        public static final YuvFormat I420 = new AnonymousClass1("I420", 0);
        public static final YuvFormat NV12 = new AnonymousClass2("NV12", 1);
        private static final /* synthetic */ YuvFormat[] $VALUES = $values();

        abstract void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer, int i, int i2);

        /* renamed from: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder$YuvFormat$1, reason: invalid class name */
        enum AnonymousClass1 extends YuvFormat {
            private AnonymousClass1(String str, int i) {
                super(str, i);
            }

            @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer, int i, int i2) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420Copy(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight(), i, i2, i / 2, i2 / 2);
                i420.release();
            }
        }

        private static /* synthetic */ YuvFormat[] $values() {
            return new YuvFormat[]{I420, NV12};
        }

        public static YuvFormat valueOf(String str) {
            return (YuvFormat) Enum.valueOf(YuvFormat.class, str);
        }

        public static YuvFormat[] values() {
            return (YuvFormat[]) $VALUES.clone();
        }

        /* renamed from: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder$YuvFormat$2, reason: invalid class name */
        enum AnonymousClass2 extends YuvFormat {
            private AnonymousClass2(String str, int i) {
                super(str, i);
            }

            @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.HardwareVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer, int i, int i2) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420ToNV12(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight(), i, i2);
                i420.release();
            }
        }

        private YuvFormat(String str, int i) {
        }

        static YuvFormat valueOf(int i) {
            if (i == 19) {
                return I420;
            }
            if (i == 21 || i == 2141391872 || i == 2141391876) {
                return NV12;
            }
            throw new IllegalArgumentException("Unsupported colorFormat: " + i);
        }
    }

    private static class BusyCount {
        private int count;
        private final Object countLock;

        private BusyCount() {
            this.countLock = new Object();
        }

        public void increment() {
            synchronized (this.countLock) {
                this.count++;
            }
        }

        public void decrement() {
            synchronized (this.countLock) {
                try {
                    int i = this.count - 1;
                    this.count = i;
                    if (i == 0) {
                        this.countLock.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void waitForZero() {
            boolean z;
            synchronized (this.countLock) {
                z = false;
                while (this.count > 0) {
                    try {
                        this.countLock.wait();
                    } catch (InterruptedException e) {
                        Logging.e("HardwareVideoEncoder", "Interrupted while waiting on busy count", e);
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
