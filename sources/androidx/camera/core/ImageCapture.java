package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.ImagePipeline;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ImageCapture extends UseCase {
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    private final int mCaptureMode;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener;
    private Rational mCropAspectRatio;
    private int mFlashMode;
    private final int mFlashType;
    private final ImageCaptureControl mImageCaptureControl;
    private ImagePipeline mImagePipeline;
    private final AtomicReference<Integer> mLockedFlashMode;
    SessionConfig.Builder mSessionConfigBuilder;
    private TakePictureManager mTakePictureManager;

    public static final class Metadata {
    }

    public static abstract class OnImageCapturedCallback {
        public abstract void onCaptureSuccess(ImageProxy imageProxy);

        public abstract void onError(ImageCaptureException imageCaptureException);
    }

    public interface OnImageSavedCallback {
        void onError(ImageCaptureException imageCaptureException);

        void onImageSaved(OutputFileResults outputFileResults);
    }

    public static final class OutputFileOptions {
        public ContentResolver getContentResolver() {
            throw null;
        }

        public ContentValues getContentValues() {
            throw null;
        }

        public File getFile() {
            throw null;
        }

        public Metadata getMetadata() {
            throw null;
        }

        public OutputStream getOutputStream() {
            throw null;
        }

        public Uri getSaveCollection() {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$submitStillCaptureRequest$4(List list) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            try {
                Log.d("ImageCapture", "Discarding ImageProxy which was inadvertently acquired: " + imageProxyAcquireLatestImage);
                if (imageProxyAcquireLatestImage != null) {
                    imageProxyAcquireLatestImage.close();
                }
            } finally {
            }
        } catch (IllegalStateException e) {
            Log.e("ImageCapture", "Failed to acquire latest image.", e);
        }
    }

    ImageCapture(ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        this.mClosingListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ImageCapture$$ExternalSyntheticLambda1
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ImageCapture.lambda$new$0(imageReaderProxy);
            }
        };
        this.mLockedFlashMode = new AtomicReference<>(null);
        this.mFlashMode = -1;
        this.mCropAspectRatio = null;
        this.mImageCaptureControl = new ImageCaptureControl() { // from class: androidx.camera.core.ImageCapture.1
            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            public void lockFlashMode() {
                ImageCapture.this.lockFlashMode();
            }

            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            public void unlockFlashMode() {
                ImageCapture.this.unlockFlashMode();
            }

            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            public ListenableFuture<Void> submitStillCaptureRequests(List<CaptureConfig> list) {
                return ImageCapture.this.submitStillCaptureRequest(list);
            }
        };
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) getCurrentConfig();
        if (imageCaptureConfig2.containsOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE)) {
            this.mCaptureMode = imageCaptureConfig2.getCaptureMode();
        } else {
            this.mCaptureMode = 1;
        }
        this.mFlashType = imageCaptureConfig2.getFlashType(0);
    }

    private boolean isSessionProcessorEnabledInCurrentCamera() {
        return (getCamera() == null || getCamera().getExtendedConfig().getSessionProcessor(null) == null) ? false : true;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        Config config = useCaseConfigFactory.getConfig(defaults.getConfig().getCaptureType(), getCaptureMode());
        if (z) {
            config = Config.mergeConfigs(config, defaults.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    @Override // androidx.camera.core.UseCase
    protected UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        if (cameraInfoInternal.getCameraQuirks().contains(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            MutableConfig mutableConfig = builder.getMutableConfig();
            Config.Option<Boolean> option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(mutableConfig.retrieveOption(option, bool2))) {
                Logger.w("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                Logger.i("ImageCapture", "Requesting software JPEG due to device quirk.");
                builder.getMutableConfig().insertOption(option, bool2);
            }
        }
        boolean zEnforceSoftwareJpegConstraints = enforceSoftwareJpegConstraints(builder.getMutableConfig());
        Integer num = (Integer) builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        if (num != null) {
            Preconditions.checkArgument(!isSessionProcessorEnabledInCurrentCamera() || num.intValue() == 256, "Cannot set non-JPEG buffer format with Extensions enabled.");
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, Integer.valueOf(zEnforceSoftwareJpegConstraints ? 35 : num.intValue()));
        } else if (zEnforceSoftwareJpegConstraints) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        } else {
            List list = (List) builder.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
            if (list == null || isImageFormatSupported(list, 256)) {
                builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            } else if (isImageFormatSupported(list, 35)) {
                builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
            }
        }
        return builder.getUseCaseConfig();
    }

    private static boolean isImageFormatSupported(List<Pair<Integer, Size[]>> list, int i) {
        if (list == null) {
            return false;
        }
        Iterator<Pair<Integer, Size[]>> it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next().first).equals(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.UseCase
    public void onCameraControlReady() {
        trySetFlashModeToCameraControl();
    }

    public int getFlashMode() {
        int flashMode;
        synchronized (this.mLockedFlashMode) {
            flashMode = this.mFlashMode;
            if (flashMode == -1) {
                flashMode = ((ImageCaptureConfig) getCurrentConfig()).getFlashMode(2);
            }
        }
        return flashMode;
    }

    public void setCropAspectRatio(Rational rational) {
        this.mCropAspectRatio = rational;
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        abortImageCaptureRequests();
    }

    private void abortImageCaptureRequests() {
        TakePictureManager takePictureManager = this.mTakePictureManager;
        if (takePictureManager != null) {
            takePictureManager.abortRequests();
        }
    }

    void lockFlashMode() {
        synchronized (this.mLockedFlashMode) {
            try {
                if (this.mLockedFlashMode.get() != null) {
                    return;
                }
                this.mLockedFlashMode.set(Integer.valueOf(getFlashMode()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void unlockFlashMode() {
        synchronized (this.mLockedFlashMode) {
            try {
                Integer andSet = this.mLockedFlashMode.getAndSet(null);
                if (andSet == null) {
                    return;
                }
                if (andSet.intValue() != getFlashMode()) {
                    trySetFlashModeToCameraControl();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void trySetFlashModeToCameraControl() {
        synchronized (this.mLockedFlashMode) {
            try {
                if (this.mLockedFlashMode.get() != null) {
                    return;
                }
                getCameraControl().setFlashMode(getFlashMode());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    boolean enforceSoftwareJpegConstraints(MutableConfig mutableConfig) {
        boolean z;
        Boolean bool = Boolean.TRUE;
        Config.Option<Boolean> option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean bool2 = Boolean.FALSE;
        boolean z2 = false;
        if (bool.equals(mutableConfig.retrieveOption(option, bool2))) {
            if (isSessionProcessorEnabledInCurrentCamera()) {
                Logger.w("ImageCapture", "Software JPEG cannot be used with Extensions.");
                z = false;
            } else {
                z = true;
            }
            Integer num = (Integer) mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num == null || num.intValue() == 256) {
                z2 = z;
            } else {
                Logger.w("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z2) {
                Logger.w("ImageCapture", "Unable to support software JPEG. Disabling.");
                mutableConfig.insertOption(option, bool2);
            }
        }
        return z2;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        abortImageCaptureRequests();
        clearPipeline();
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        Preconditions.checkNotNull(getCamera(), "Attached camera cannot be null");
    }

    @Override // androidx.camera.core.UseCase
    protected StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        updateSessionConfig(builderCreatePipeline.build());
        notifyActive();
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    protected StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    private SessionConfig.Builder createPipeline(final String str, final ImageCaptureConfig imageCaptureConfig, final StreamSpec streamSpec) {
        Threads.checkMainThread();
        Log.d("ImageCapture", String.format("createPipeline(cameraId: %s, streamSpec: %s)", str, streamSpec));
        Size resolution = streamSpec.getResolution();
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        boolean z = !camera.getHasTransform() || isSessionProcessorEnabledInCurrentCamera();
        if (this.mImagePipeline != null) {
            Preconditions.checkState(z);
            this.mImagePipeline.close();
        }
        this.mImagePipeline = new ImagePipeline(imageCaptureConfig, resolution, getEffect(), z);
        if (this.mTakePictureManager == null) {
            this.mTakePictureManager = new TakePictureManager(this.mImageCaptureControl);
        }
        this.mTakePictureManager.setImagePipeline(this.mImagePipeline);
        SessionConfig.Builder builderCreateSessionConfigBuilder = this.mImagePipeline.createSessionConfigBuilder(streamSpec.getResolution());
        if (getCaptureMode() == 2) {
            getCameraControl().addZslConfig(builderCreateSessionConfigBuilder);
        }
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateSessionConfigBuilder.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        builderCreateSessionConfigBuilder.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.ImageCapture$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.f$0.lambda$createPipeline$3(str, imageCaptureConfig, streamSpec, sessionConfig, sessionError);
            }
        });
        return builderCreateSessionConfigBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$3(String str, ImageCaptureConfig imageCaptureConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (isCurrentCamera(str)) {
            this.mTakePictureManager.pause();
            clearPipeline(true);
            SessionConfig.Builder builderCreatePipeline = createPipeline(str, imageCaptureConfig, streamSpec);
            this.mSessionConfigBuilder = builderCreatePipeline;
            updateSessionConfig(builderCreatePipeline.build());
            notifyReset();
            this.mTakePictureManager.resume();
            return;
        }
        clearPipeline();
    }

    private void clearPipeline() {
        clearPipeline(false);
    }

    private void clearPipeline(boolean z) {
        TakePictureManager takePictureManager;
        Log.d("ImageCapture", "clearPipeline");
        Threads.checkMainThread();
        ImagePipeline imagePipeline = this.mImagePipeline;
        if (imagePipeline != null) {
            imagePipeline.close();
            this.mImagePipeline = null;
        }
        if (z || (takePictureManager = this.mTakePictureManager) == null) {
            return;
        }
        takePictureManager.abortRequests();
        this.mTakePictureManager = null;
    }

    ListenableFuture<Void> submitStillCaptureRequest(List<CaptureConfig> list) {
        Threads.checkMainThread();
        return Futures.transform(getCameraControl().submitStillCaptureRequests(list, this.mCaptureMode, this.mFlashType), new Function() { // from class: androidx.camera.core.ImageCapture$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ImageCapture.lambda$submitStillCaptureRequest$4((List) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    public static final class Defaults {
        private static final ImageCaptureConfig DEFAULT_CONFIG;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR;

        static {
            ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = resolutionSelectorBuild;
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).setResolutionSelector(resolutionSelectorBuild).setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE).setDynamicRange(dynamicRange).getUseCaseConfig();
        }

        public ImageCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    public static class OutputFileResults {
        private final Uri mSavedUri;

        public OutputFileResults(Uri uri) {
            this.mSavedUri = uri;
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls != null && !cls.equals(ImageCapture.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            setTargetClass(ImageCapture.class);
        }

        public static Builder fromConfig(Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public ImageCapture build() {
            Integer num;
            Integer num2 = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num2 != null) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, num2);
            } else {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            }
            ImageCaptureConfig useCaseConfig = getUseCaseConfig();
            ImageOutputConfig.validateConfig(useCaseConfig);
            ImageCapture imageCapture = new ImageCapture(useCaseConfig);
            Size size = (Size) getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null);
            if (size != null) {
                imageCapture.setCropAspectRatio(new Rational(size.getWidth(), size.getHeight()));
            }
            Preconditions.checkNotNull((Executor) getMutableConfig().retrieveOption(IoConfig.OPTION_IO_EXECUTOR, CameraXExecutors.ioExecutor()), "The IO executor can't be null");
            MutableConfig mutableConfig = getMutableConfig();
            Config.Option<Integer> option = ImageCaptureConfig.OPTION_FLASH_MODE;
            if (!mutableConfig.containsOption(option) || ((num = (Integer) getMutableConfig().retrieveOption(option)) != null && (num.intValue() == 0 || num.intValue() == 1 || num.intValue() == 2))) {
                return imageCapture;
            }
            throw new IllegalArgumentException("The flash mode is not allowed to set: " + num);
        }

        public Builder setTargetClass(Class<ImageCapture> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        @Deprecated
        public Builder setTargetAspectRatio(int i) {
            if (i == -1) {
                i = 0;
            }
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetRotation(int i) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @Deprecated
        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        public Builder setResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        public Builder setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        public Builder setCaptureType(UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        public Builder setDynamicRange(DynamicRange dynamicRange) {
            if (!Objects.equals(DynamicRange.SDR, dynamicRange)) {
                throw new UnsupportedOperationException("ImageCapture currently only supports SDR");
            }
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }
    }
}
