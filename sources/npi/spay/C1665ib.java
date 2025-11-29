package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* renamed from: npi.spay.ib, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1665ib implements FlowCollector {
    public final /* synthetic */ C1888rb a;

    public C1665ib(C1888rb c1888rb) {
        this.a = c1888rb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        int iIntValue = ((Number) obj).intValue();
        C1888rb c1888rb = this.a;
        int i = C1888rb.$r8$clinit;
        if (iIntValue != 0) {
            ViewBinding viewBinding = c1888rb.c;
            if (viewBinding == null) {
                throw C2040xd.a;
            }
            AppCompatTextView handleCommissionState$lambda$9 = ((Ed) viewBinding).b;
            Intrinsics.checkNotNullExpressionValue(handleCommissionState$lambda$9, "handleCommissionState$lambda$9");
            Intrinsics.checkNotNullParameter(handleCommissionState$lambda$9, "<this>");
            handleCommissionState$lambda$9.setVisibility(0);
            int i2 = R$string.spay_bnpl_commission_message;
            Object[] args = {Integer.valueOf(iIntValue / 100)};
            Intrinsics.checkNotNullParameter(args, "args");
            C2097zk c2097zk = new C2097zk(i2, ArraysKt.toList(args));
            Context contextRequireContext = c1888rb.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "this@BnplOrderFragment.requireContext()");
            handleCommissionState$lambda$9.setText(AbstractC1550dl.a(c2097zk, contextRequireContext));
        } else {
            c1888rb.getClass();
        }
        return Unit.INSTANCE;
    }
}
