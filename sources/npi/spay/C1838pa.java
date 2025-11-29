package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ru.yoomoney.sdk.kassa.payments.R$id;

/* renamed from: npi.spay.pa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1838pa implements FlowCollector {
    public final /* synthetic */ Nb a;

    public C1838pa(Nb nb) {
        this.a = nb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Pair pair;
        Bc bc = (Bc) obj;
        Nb nb = this.a;
        int i = Nb.$r8$clinit;
        ViewBinding viewBinding = nb.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        int iOrdinal = bc.ordinal();
        if (iOrdinal == 0) {
            pair = new Pair(new S5(), "FraudMonOtpReviewFragment");
        } else if (iOrdinal == 1) {
            pair = new Pair(new Cg(), "FraudMonReviewHintFragment");
        } else if (iOrdinal == 2) {
            pair = new Pair(new C1754m1(), "FraudMonDenyFragment");
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pair = new Pair(new C1526cm(), "FraudMonDenyBlockFragment");
        }
        this.a.getParentFragmentManager().beginTransaction().replace(R$id.spay_root_fc, (Z7) pair.component1(), (String) pair.component2()).commit();
        return Unit.INSTANCE;
    }
}
