package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.spherical.OrientationListener;
import com.google.android.exoplayer2.ui.spherical.TouchTracker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {
    private boolean isOrientationListenerRegistered;
    private boolean isStarted;
    private final Handler mainHandler;
    private final OrientationListener orientationListener;
    private final Sensor orientationSensor;
    private final SceneRenderer scene;
    private final SensorManager sensorManager;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TouchTracker touchTracker;
    private boolean useSensorRotation;
    private Player.VideoComponent videoComponent;

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mainHandler = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) Assertions.checkNotNull(context.getSystemService("sensor"));
        this.sensorManager = sensorManager;
        Sensor defaultSensor = Util.SDK_INT >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.orientationSensor = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.scene = sceneRenderer;
        Renderer renderer = new Renderer(sceneRenderer);
        TouchTracker touchTracker = new TouchTracker(context, renderer, 25.0f);
        this.touchTracker = touchTracker;
        this.orientationListener = new OrientationListener(((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker, renderer);
        this.useSensorRotation = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker);
    }

    public void setDefaultStereoMode(int stereoMode) {
        this.scene.setDefaultStereoMode(stereoMode);
    }

    public void setVideoComponent(Player.VideoComponent newVideoComponent) {
        Player.VideoComponent videoComponent = this.videoComponent;
        if (newVideoComponent == videoComponent) {
            return;
        }
        if (videoComponent != null) {
            Surface surface = this.surface;
            if (surface != null) {
                videoComponent.clearVideoSurface(surface);
            }
            this.videoComponent.clearVideoFrameMetadataListener(this.scene);
            this.videoComponent.clearCameraMotionListener(this.scene);
        }
        this.videoComponent = newVideoComponent;
        if (newVideoComponent != null) {
            newVideoComponent.setVideoFrameMetadataListener(this.scene);
            this.videoComponent.setCameraMotionListener(this.scene);
            this.videoComponent.setVideoSurface(this.surface);
        }
    }

    public void setSingleTapListener(SingleTapListener listener) {
        this.touchTracker.setSingleTapListener(listener);
    }

    public void setUseSensorRotation(boolean useSensorRotation) {
        this.useSensorRotation = useSensorRotation;
        updateOrientationListenerRegistration();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.isStarted = true;
        updateOrientationListenerRegistration();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.isStarted = false;
        updateOrientationListenerRegistration();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDetachedFromWindow$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDetachedFromWindow$0() {
        Surface surface = this.surface;
        if (surface != null) {
            Player.VideoComponent videoComponent = this.videoComponent;
            if (videoComponent != null) {
                videoComponent.clearVideoSurface(surface);
            }
            releaseSurface(this.surfaceTexture, this.surface);
            this.surfaceTexture = null;
            this.surface = null;
        }
    }

    private void updateOrientationListenerRegistration() {
        boolean z = this.useSensorRotation && this.isStarted;
        Sensor sensor = this.orientationSensor;
        if (sensor == null || z == this.isOrientationListenerRegistered) {
            return;
        }
        if (z) {
            this.sensorManager.registerListener(this.orientationListener, sensor, 0);
        } else {
            this.sensorManager.unregisterListener(this.orientationListener);
        }
        this.isOrientationListenerRegistered = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture) {
        this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSurfaceTextureAvailable$1(surfaceTexture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSurfaceTextureAvailable$1(final SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        Surface surface = this.surface;
        this.surfaceTexture = surfaceTexture;
        Surface surface2 = new Surface(surfaceTexture);
        this.surface = surface2;
        Player.VideoComponent videoComponent = this.videoComponent;
        if (videoComponent != null) {
            videoComponent.setVideoSurface(surface2);
        }
        releaseSurface(surfaceTexture2, surface);
    }

    private static void releaseSurface(SurfaceTexture oldSurfaceTexture, Surface oldSurface) {
        if (oldSurfaceTexture != null) {
            oldSurfaceTexture.release();
        }
        if (oldSurface != null) {
            oldSurface.release();
        }
    }

    class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {
        private final float[] deviceOrientationMatrix;
        private float deviceRoll;
        private final SceneRenderer scene;
        private float touchPitch;
        private final float[] touchPitchMatrix;
        private final float[] touchYawMatrix;
        private final float[] projectionMatrix = new float[16];
        private final float[] viewProjectionMatrix = new float[16];
        private final float[] viewMatrix = new float[16];
        private final float[] tempMatrix = new float[16];

        public Renderer(SceneRenderer scene) {
            float[] fArr = new float[16];
            this.deviceOrientationMatrix = fArr;
            float[] fArr2 = new float[16];
            this.touchPitchMatrix = fArr2;
            float[] fArr3 = new float[16];
            this.touchYawMatrix = fArr3;
            this.scene = scene;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.deviceRoll = 3.1415927f;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl, EGLConfig config) {
            SphericalGLSurfaceView.this.onSurfaceTextureAvailable(this.scene.init());
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);
            float f = width / height;
            Matrix.perspectiveM(this.projectionMatrix, 0, calculateFieldOfViewInYDirection(f), f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl) {
            synchronized (this) {
                Matrix.multiplyMM(this.tempMatrix, 0, this.deviceOrientationMatrix, 0, this.touchYawMatrix, 0);
                Matrix.multiplyMM(this.viewMatrix, 0, this.touchPitchMatrix, 0, this.tempMatrix, 0);
            }
            Matrix.multiplyMM(this.viewProjectionMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
            this.scene.drawFrame(this.viewProjectionMatrix, false);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.OrientationListener.Listener
        public synchronized void onOrientationChange(float[] matrix, float deviceRoll) {
            float[] fArr = this.deviceOrientationMatrix;
            System.arraycopy(matrix, 0, fArr, 0, fArr.length);
            this.deviceRoll = -deviceRoll;
            updatePitchMatrix();
        }

        private void updatePitchMatrix() {
            Matrix.setRotateM(this.touchPitchMatrix, 0, -this.touchPitch, (float) Math.cos(this.deviceRoll), (float) Math.sin(this.deviceRoll), 0.0f);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener
        public synchronized void onScrollChange(PointF scrollOffsetDegrees) {
            this.touchPitch = scrollOffsetDegrees.y;
            updatePitchMatrix();
            Matrix.setRotateM(this.touchYawMatrix, 0, -scrollOffsetDegrees.x, 0.0f, 1.0f, 0.0f);
        }

        private float calculateFieldOfViewInYDirection(float aspect) {
            if (aspect > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / aspect)) * 2.0d);
            }
            return 90.0f;
        }
    }
}
