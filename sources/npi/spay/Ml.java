package npi.spay;

import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Ml implements FlowCollector {
    public final /* synthetic */ C1896rj a;

    public Ml(C1896rj c1896rj) {
        this.a = c1896rj;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        String str = (String) obj;
        this.a.b.setText(str);
        AppCompatTextView spaySlspActvLocalSessionId = this.a.b;
        Intrinsics.checkNotNullExpressionValue(spaySlspActvLocalSessionId, "spaySlspActvLocalSessionId");
        String strC = AbstractC1946tj.c(str);
        spaySlspActvLocalSessionId.setVisibility(strC == null || strC.length() == 0 ? 8 : 0);
        return Unit.INSTANCE;
    }
}
