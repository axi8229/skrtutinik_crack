package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class P5 implements FlowCollector {
    public final /* synthetic */ S5 a;

    public P5(S5 s5) {
        this.a = s5;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Sj sj = (Sj) obj;
        S5 s5 = this.a;
        int i = S5.$r8$clinit;
        ViewBinding viewBinding = s5.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        C1809o6 c1809o6 = (C1809o6) viewBinding;
        c1809o6.c.setText(sj.a);
        c1809o6.b.setText(sj.b);
        c1809o6.e.setText(sj.d);
        c1809o6.d.setText(sj.e);
        return Unit.INSTANCE;
    }
}
