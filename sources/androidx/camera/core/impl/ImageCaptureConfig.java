package androidx.camera.core.impl;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.impl.Config;
import androidx.camera.core.internal.IoConfig;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT;
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE;
    public static final Config.Option<Integer> OPTION_FLASH_MODE;
    public static final Config.Option<Integer> OPTION_FLASH_TYPE;
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE;
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER;
    public static final Config.Option<Integer> OPTION_JPEG_COMPRESSION_QUALITY;
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES;
    public static final Config.Option<Boolean> OPTION_USE_SOFTWARE_JPEG_ENCODER;
    private final OptionsBundle mConfig;

    static {
        Class cls = Integer.TYPE;
        OPTION_IMAGE_CAPTURE_MODE = Config.Option.create("camerax.core.imageCapture.captureMode", cls);
        OPTION_FLASH_MODE = Config.Option.create("camerax.core.imageCapture.flashMode", cls);
        OPTION_CAPTURE_BUNDLE = Config.Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
        OPTION_BUFFER_FORMAT = Config.Option.create("camerax.core.imageCapture.bufferFormat", Integer.class);
        OPTION_MAX_CAPTURE_STAGES = Config.Option.create("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
        OPTION_USE_SOFTWARE_JPEG_ENCODER = Config.Option.create("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
        OPTION_FLASH_TYPE = Config.Option.create("camerax.core.imageCapture.flashType", cls);
        OPTION_JPEG_COMPRESSION_QUALITY = Config.Option.create("camerax.core.imageCapture.jpegCompressionQuality", cls);
    }

    public ImageCaptureConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public boolean hasCaptureMode() {
        return containsOption(OPTION_IMAGE_CAPTURE_MODE);
    }

    public int getCaptureMode() {
        return ((Integer) retrieveOption(OPTION_IMAGE_CAPTURE_MODE)).intValue();
    }

    public int getFlashMode(int i) {
        return ((Integer) retrieveOption(OPTION_FLASH_MODE, Integer.valueOf(i))).intValue();
    }

    public CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE, captureBundle);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return ((Integer) retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) retrieveOption(OPTION_IMAGE_READER_PROXY_PROVIDER, null);
    }

    public int getFlashType(int i) {
        return ((Integer) retrieveOption(OPTION_FLASH_TYPE, Integer.valueOf(i))).intValue();
    }

    public Executor getIoExecutor(Executor executor) {
        return (Executor) retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }
}
