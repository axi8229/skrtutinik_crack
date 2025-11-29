package npi.spay;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class N implements FlowCollector {
    public final /* synthetic */ Na a;
    public final /* synthetic */ C1579f0 b;
    public final /* synthetic */ Context c;

    public N(Na na, C1579f0 c1579f0, Context context) {
        this.a = na;
        this.b = c1579f0;
        this.c = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Resources.NotFoundException {
        String string;
        String str;
        Long l;
        C1906s4 c1906s4 = (C1906s4) obj;
        TextView observeViewModel$lambda$17$lambda$12$lambda$11 = this.a.g;
        observeViewModel$lambda$17$lambda$12$lambda$11.setClickable(c1906s4.e);
        observeViewModel$lambda$17$lambda$12$lambda$11.setFocusable(c1906s4.e);
        C1579f0 c1579f0 = this.b;
        Intrinsics.checkNotNullExpressionValue(observeViewModel$lambda$17$lambda$12$lambda$11, "observeViewModel$lambda$17$lambda$12$lambda$11");
        int i = C1579f0.$r8$clinit;
        c1579f0.getClass();
        if (c1906s4.b == null || (l = c1906s4.d) == null) {
            string = c1579f0.getString(c1906s4.a);
            str = "{\n            getString(…nState.textRes)\n        }";
        } else {
            int iLongValue = (int) (l.longValue() / 1000);
            Resources resources = observeViewModel$lambda$17$lambda$12$lambda$11.getResources();
            Integer num = c1906s4.b;
            Intrinsics.checkNotNull(num);
            String quantityString = resources.getQuantityString(num.intValue(), iLongValue, Integer.valueOf(iLongValue));
            Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…sRes!!, seconds, seconds)");
            string = c1579f0.getString(c1906s4.a, quantityString);
            str = "{\n            val second…xtRes, plurals)\n        }";
        }
        Intrinsics.checkNotNullExpressionValue(string, str);
        observeViewModel$lambda$17$lambda$12$lambda$11.setText(string);
        observeViewModel$lambda$17$lambda$12$lambda$11.setTextColor(ContextCompat.getColor(this.c, c1906s4.c));
        return Unit.INSTANCE;
    }
}
