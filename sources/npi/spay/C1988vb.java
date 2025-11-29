package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import timber.log.Timber;

/* renamed from: npi.spay.vb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1988vb implements FlowCollector {
    public final /* synthetic */ Ab a;

    public C1988vb(Ab ab) {
        this.a = ab;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Oi oi = (Oi) obj;
        Timber.INSTANCE.d("cardsList: " + oi, new Object[0]);
        C1989vc c1989vc = this.a.d;
        if (c1989vc == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardsListAdapter");
            c1989vc = null;
        }
        c1989vc.a(oi.a);
        return Unit.INSTANCE;
    }
}
