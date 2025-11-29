package npi.spay;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Sc implements FlowCollector {
    public final /* synthetic */ C1790nc a;

    public Sc(C1790nc c1790nc) {
        this.a = c1790nc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        AppCompatImageView appCompatImageView = this.a.f.c;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "spaySloIncludeSelectedCard.spaySilscIvMoreCards");
        appCompatImageView.setVisibility(zBooleanValue ? 0 : 8);
        AppCompatImageView appCompatImageView2 = this.a.e.b;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "spaySloIncludeCompoundWa…CompoundWalletIvMoreCards");
        appCompatImageView2.setVisibility(zBooleanValue ? 0 : 8);
        return Unit.INSTANCE;
    }
}
