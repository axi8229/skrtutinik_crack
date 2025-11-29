package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Mg implements FlowCollector {
    public final /* synthetic */ Pg a;

    public Mg(Pg pg) {
        this.a = pg;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        String str = (String) obj;
        Pg pg = this.a;
        int i = Pg.$r8$clinit;
        ViewBinding viewBinding = pg.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Vg) viewBinding).b.setText(str);
        return Unit.INSTANCE;
    }
}
