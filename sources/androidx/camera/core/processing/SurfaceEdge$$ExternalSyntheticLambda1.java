package androidx.camera.core.processing;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SurfaceEdge f$0;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda1(SurfaceEdge surfaceEdge) {
        this.f$0 = surfaceEdge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.disconnectWithoutCheckingClosed();
    }
}
