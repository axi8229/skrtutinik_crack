package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes4.dex */
public final class Za implements FlowCollector {
    public final /* synthetic */ C1888rb a;

    public Za(C1888rb c1888rb) {
        this.a = c1888rb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Kd kd = (Kd) obj;
        C1888rb c1888rb = this.a;
        int i = C1888rb.$r8$clinit;
        ViewBinding viewBinding = c1888rb.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatTextView appCompatTextView = ((Ed) viewBinding).g;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.spaySlobActvTotal");
        long j = kd.a;
        int i2 = R$string.spay_currency_pattern;
        String str = kd.b;
        Intrinsics.checkNotNullParameter(appCompatTextView, "<this>");
        Context context = appCompatTextView.getContext();
        String strA = AbstractC2095zi.a(j);
        if (str == null) {
            str = "";
        }
        appCompatTextView.setText(context.getString(i2, strA, str));
        return Unit.INSTANCE;
    }
}
