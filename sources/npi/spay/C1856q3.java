package npi.spay;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.q3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1856q3 implements FlowCollector {
    public final /* synthetic */ C1930t3 a;

    public C1856q3(C1930t3 c1930t3) {
        this.a = c1930t3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        String str = (String) obj;
        C1930t3 c1930t3 = this.a;
        int i = C1930t3.$r8$clinit;
        ViewBinding viewBinding = c1930t3.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        V7 v7 = (V7) viewBinding;
        AppCompatTextView spaySllActvLocalSessionId = v7.b;
        Intrinsics.checkNotNullExpressionValue(spaySllActvLocalSessionId, "spaySllActvLocalSessionId");
        spaySllActvLocalSessionId.setVisibility(str == null || str.length() == 0 ? 8 : 0);
        if (str != null) {
            v7.b.setText(str);
        }
        return Unit.INSTANCE;
    }
}
