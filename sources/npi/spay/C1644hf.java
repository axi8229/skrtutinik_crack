package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.hf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1644hf implements FlowCollector {
    public final /* synthetic */ C2017wf a;

    public C1644hf(C2017wf c2017wf) {
        this.a = c2017wf;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        O4 o4 = (O4) obj;
        C2017wf c2017wf = this.a;
        int i = C2017wf.$r8$clinit;
        ViewBinding viewBinding = c2017wf.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((C1586f7) viewBinding).g.setClientData(o4);
        C2017wf c2017wf2 = this.a;
        ViewBinding viewBinding2 = c2017wf2.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((C1586f7) viewBinding2).g.setOnClickListener(new C1469af(c2017wf2));
        return Unit.INSTANCE;
    }
}
