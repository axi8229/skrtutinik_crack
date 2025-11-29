package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Vc implements FlowCollector {
    public final /* synthetic */ C1940td a;

    public Vc(C1940td c1940td) {
        this.a = c1940td;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        O4 o4 = (O4) obj;
        C1940td c1940td = this.a;
        int i = C1940td.$r8$clinit;
        ViewBinding viewBinding = c1940td.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding).l.setClientData(o4);
        C1940td c1940td2 = this.a;
        ViewBinding viewBinding2 = c1940td2.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding2).l.setOnClickListener(new Lc(c1940td2));
        return Unit.INSTANCE;
    }
}
