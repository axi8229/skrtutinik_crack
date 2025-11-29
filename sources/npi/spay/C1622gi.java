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

/* renamed from: npi.spay.gi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1622gi implements FlowCollector {
    public final /* synthetic */ C1771mi a;

    public C1622gi(C1771mi c1771mi) {
        this.a = c1771mi;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        int iIntValue = ((Number) obj).intValue();
        C1771mi c1771mi = this.a;
        int i = C1771mi.$r8$clinit;
        if (iIntValue != 0) {
            ViewBinding viewBinding = c1771mi.c;
            if (viewBinding == null) {
                throw C2040xd.a;
            }
            AppCompatTextView handleCommissionState$lambda$16 = ((C1570eg) viewBinding).d;
            Intrinsics.checkNotNullExpressionValue(handleCommissionState$lambda$16, "handleCommissionState$lambda$16");
            Intrinsics.checkNotNullParameter(handleCommissionState$lambda$16, "<this>");
            handleCommissionState$lambda$16.setVisibility(0);
            int i2 = R$string.spay_bnpl_commission_message;
            Object[] args = {Integer.valueOf(iIntValue / 100)};
            Intrinsics.checkNotNullParameter(args, "args");
            C2097zk c2097zk = new C2097zk(i2, ArraysKt.toList(args));
            Context contextRequireContext = c1771mi.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "this@BnplPartsOrderFragment.requireContext()");
            handleCommissionState$lambda$16.setText(AbstractC1550dl.a(c2097zk, contextRequireContext));
        } else {
            c1771mi.getClass();
        }
        return Unit.INSTANCE;
    }
}
