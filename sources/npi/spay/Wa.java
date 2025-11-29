package npi.spay;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;

/* loaded from: classes4.dex */
public final class Wa implements FlowCollector {
    public final /* synthetic */ C1888rb a;

    public Wa(C1888rb c1888rb) {
        this.a = c1888rb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        PaymentPlanBnplResponseBody paymentPlanBnplResponseBody = (PaymentPlanBnplResponseBody) obj;
        C1888rb c1888rb = this.a;
        int i = C1888rb.$r8$clinit;
        ViewBinding viewBinding = c1888rb.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatTextView appCompatTextView = ((Ed) viewBinding).f;
        ButtonBnpl buttonBnpl = paymentPlanBnplResponseBody.getButtonBnpl();
        String header = buttonBnpl != null ? buttonBnpl.getHeader() : null;
        if (header == null) {
            header = "";
        }
        appCompatTextView.setText(header);
        return Unit.INSTANCE;
    }
}
