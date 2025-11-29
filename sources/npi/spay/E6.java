package npi.spay;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class E6 implements FlowCollector {
    public final /* synthetic */ H6 a;

    public E6(H6 h6) {
        this.a = h6;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        String str = (String) obj;
        H6 h6 = this.a;
        int i = H6.$r8$clinit;
        ViewBinding viewBinding = h6.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatTextView observeViewModel$lambda$2$lambda$1 = ((Q0) viewBinding).b;
        observeViewModel$lambda$2$lambda$1.setText(str);
        Intrinsics.checkNotNullExpressionValue(observeViewModel$lambda$2$lambda$1, "observeViewModel$lambda$2$lambda$1");
        String strC = AbstractC1946tj.c(str);
        observeViewModel$lambda$2$lambda$1.setVisibility(strC == null || strC.length() == 0 ? 8 : 0);
        return Unit.INSTANCE;
    }
}
