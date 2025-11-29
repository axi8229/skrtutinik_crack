package npi.spay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.cb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1515cb implements FlowCollector {
    public final /* synthetic */ C1888rb a;

    public C1515cb(C1888rb c1888rb) {
        this.a = c1888rb;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        C1888rb c1888rb = this.a;
        int i = C1888rb.$r8$clinit;
        c1888rb.getClass();
        C1528d c1528d = new C1528d((List) obj);
        ViewBinding viewBinding = c1888rb.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        RecyclerView recyclerView = ((Ed) viewBinding).i;
        recyclerView.setAdapter(c1528d);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        return Unit.INSTANCE;
    }
}
