package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class Camera2CaptureRequestBuilder {
    private static List<Surface> getConfiguredSurfaces(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            Surface surface = map.get(it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList.add(surface);
        }
        return arrayList;
    }

    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder builder, Config config) {
        CaptureRequestOptions captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(config).build();
        for (Config.Option<?> option : captureRequestOptionsBuild.listOptions()) {
            CaptureRequest.Key key = (CaptureRequest.Key) option.getToken();
            try {
                builder.set(key, captureRequestOptionsBuild.retrieveOption(option));
            } catch (IllegalArgumentException unused) {
                Logger.e("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    private static void applyAeFpsRange(CaptureConfig captureConfig, CaptureRequest.Builder builder) {
        CaptureRequestOptions captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(captureConfig.getImplementationOptions()).build();
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
        if (captureRequestOptionsBuild.containsOption(Camera2ImplConfig.createCaptureRequestOption(key)) || captureConfig.getExpectedFrameRateRange().equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            return;
        }
        builder.set(key, captureConfig.getExpectedFrameRateRange());
    }

    public static CaptureRequest build(CaptureConfig captureConfig, CameraDevice cameraDevice, Map<DeferrableSurface, Surface> map) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> configuredSurfaces = getConfiguredSurfaces(captureConfig.getSurfaces(), map);
        if (configuredSurfaces.isEmpty()) {
            return null;
        }
        CameraCaptureResult cameraCaptureResult = captureConfig.getCameraCaptureResult();
        if (captureConfig.getTemplateType() == 5 && cameraCaptureResult != null && (cameraCaptureResult.getCaptureResult() instanceof TotalCaptureResult)) {
            Logger.d("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            builderCreateCaptureRequest = Api23Impl.createReprocessCaptureRequest(cameraDevice, (TotalCaptureResult) cameraCaptureResult.getCaptureResult());
        } else {
            Logger.d("Camera2CaptureRequestBuilder", "createCaptureRequest");
            builderCreateCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        }
        applyImplementationOptionToCaptureBuilder(builderCreateCaptureRequest, captureConfig.getImplementationOptions());
        applyAeFpsRange(captureConfig, builderCreateCaptureRequest);
        Config implementationOptions = captureConfig.getImplementationOptions();
        Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
        if (implementationOptions.containsOption(option)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
        }
        Config implementationOptions2 = captureConfig.getImplementationOptions();
        Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (implementationOptions2.containsOption(option2)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
        }
        Iterator<Surface> it = configuredSurfaces.iterator();
        while (it.hasNext()) {
            builderCreateCaptureRequest.addTarget(it.next());
        }
        builderCreateCaptureRequest.setTag(captureConfig.getTagBundle());
        return builderCreateCaptureRequest.build();
    }

    public static CaptureRequest buildWithoutTarget(CaptureConfig captureConfig, CameraDevice cameraDevice) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        applyImplementationOptionToCaptureBuilder(builderCreateCaptureRequest, captureConfig.getImplementationOptions());
        return builderCreateCaptureRequest.build();
    }

    static class Api23Impl {
        static CaptureRequest.Builder createReprocessCaptureRequest(CameraDevice cameraDevice, TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }
}
