package npi.spay;

import androidx.cardview.widget.CardView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.bd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1492bd implements FlowCollector {
    public final /* synthetic */ C1790nc a;

    public C1492bd(C1790nc c1790nc) {
        this.a = c1790nc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        CardView cardView;
        boolean z;
        int iOrdinal = ((Af) obj).ordinal();
        if (iOrdinal != 0) {
            z = true;
            if (iOrdinal == 1) {
                cardView = this.a.d;
            }
            return Unit.INSTANCE;
        }
        cardView = this.a.d;
        z = false;
        cardView.setClickable(z);
        cardView.setFocusable(z);
        return Unit.INSTANCE;
    }
}
