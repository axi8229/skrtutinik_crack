package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.roadar.facerecog.FaceProcessNative;

/* compiled from: ShotFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ShotFragment$onViewCreated$7$1$1 extends FunctionReferenceImpl implements Function2<Boolean, FaceProcessNative.ProcessState, Unit> {
    ShotFragment$onViewCreated$7$1$1(Object obj) {
        super(2, obj, ShotFragment.class, "onFrameProcessed", "onFrameProcessed(ZLru/roadar/facerecog/FaceProcessNative$ProcessState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, FaceProcessNative.ProcessState processState) {
        invoke(bool.booleanValue(), processState);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, FaceProcessNative.ProcessState p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((ShotFragment) this.receiver).onFrameProcessed(z, p1);
    }
}
