package npi.spay;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.bf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1494bf implements FlowCollector {
    public final /* synthetic */ C2017wf a;

    public C1494bf(C2017wf c2017wf) {
        this.a = c2017wf;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        List list = (List) obj;
        C1989vc c1989vc = this.a.e;
        if (c1989vc == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpersAdapter");
            c1989vc = null;
        }
        c1989vc.a(list);
        return Unit.INSTANCE;
    }
}
