package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes4.dex */
public final class Uh implements FlowCollector {
    public final /* synthetic */ C1570eg a;

    public Uh(C1570eg c1570eg) {
        this.a = c1570eg;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Kd kd = (Kd) obj;
        AppCompatTextView spaySlobActvTotal = this.a.k;
        Intrinsics.checkNotNullExpressionValue(spaySlobActvTotal, "spaySlobActvTotal");
        long j = kd.a;
        int i = R$string.spay_currency_pattern;
        String str = kd.b;
        Intrinsics.checkNotNullParameter(spaySlobActvTotal, "<this>");
        Context context = spaySlobActvTotal.getContext();
        String strA = AbstractC2095zi.a(j);
        if (str == null) {
            str = "";
        }
        spaySlobActvTotal.setText(context.getString(i, strA, str));
        return Unit.INSTANCE;
    }
}
