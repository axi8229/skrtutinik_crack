package npi.spay;

import android.content.Context;
import android.widget.TextView;
import com.google.android.material.imageview.ShapeableImageView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class X9 implements FlowCollector {
    public final /* synthetic */ C2072yk a;
    public final /* synthetic */ Context b;

    public X9(C2072yk c2072yk, Context context) {
        this.a = c2072yk;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        C1840pc c1840pc = (C1840pc) obj;
        this.a.e.setText(AbstractC1550dl.a(c1840pc.a, this.b));
        ShapeableImageView observeViewModel$lambda$6$lambda$5$lambda$2 = this.a.d;
        Intrinsics.checkNotNullExpressionValue(observeViewModel$lambda$6$lambda$5$lambda$2, "observeViewModel$lambda$6$lambda$5$lambda$2");
        AbstractC1923sl.a(observeViewModel$lambda$6$lambda$5$lambda$2, c1840pc.b);
        observeViewModel$lambda$6$lambda$5$lambda$2.invalidate();
        String str = c1840pc.c;
        if (str != null) {
            this.a.f.setText(str);
            TextView spaySlupTvUserPhone = this.a.f;
            Intrinsics.checkNotNullExpressionValue(spaySlupTvUserPhone, "spaySlupTvUserPhone");
            spaySlupTvUserPhone.setVisibility(!StringsKt.isBlank(str) ? 0 : 8);
        }
        return Unit.INSTANCE;
    }
}
