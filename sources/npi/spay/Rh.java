package npi.spay;

import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.GraphBnpl;

/* loaded from: classes4.dex */
public final class Rh implements FlowCollector {
    public final /* synthetic */ C1570eg a;

    public Rh(C1570eg c1570eg) {
        this.a = c1570eg;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        AppCompatTextView appCompatTextView = this.a.j;
        GraphBnpl graphBnpl = ((PaymentPlanBnplResponseBody) obj).getGraphBnpl();
        String header = graphBnpl != null ? graphBnpl.getHeader() : null;
        if (header == null) {
            header = "";
        }
        appCompatTextView.setText(header);
        return Unit.INSTANCE;
    }
}
