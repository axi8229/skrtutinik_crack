package npi.spay;

import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Wb implements FlowCollector {
    public final /* synthetic */ T9 a;

    public Wb(T9 t9) {
        this.a = t9;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        MaterialButton spayLnmcMbIssueCard;
        int i;
        int iOrdinal = ((T8) obj).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                spayLnmcMbIssueCard = this.a.e;
                Intrinsics.checkNotNullExpressionValue(spayLnmcMbIssueCard, "spayLnmcMbIssueCard");
                Intrinsics.checkNotNullParameter(spayLnmcMbIssueCard, "<this>");
                i = 8;
            }
            return Unit.INSTANCE;
        }
        spayLnmcMbIssueCard = this.a.e;
        Intrinsics.checkNotNullExpressionValue(spayLnmcMbIssueCard, "spayLnmcMbIssueCard");
        Intrinsics.checkNotNullParameter(spayLnmcMbIssueCard, "<this>");
        i = 0;
        spayLnmcMbIssueCard.setVisibility(i);
        return Unit.INSTANCE;
    }
}
