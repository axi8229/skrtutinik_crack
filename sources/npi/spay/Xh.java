package npi.spay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Xh implements FlowCollector {
    public final /* synthetic */ C1771mi a;

    public Xh(C1771mi c1771mi) {
        this.a = c1771mi;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        C1771mi c1771mi = this.a;
        int i = C1771mi.$r8$clinit;
        c1771mi.getClass();
        C1528d c1528d = new C1528d((List) obj);
        ViewBinding viewBinding = c1771mi.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        RecyclerView recyclerView = ((C1570eg) viewBinding).f;
        recyclerView.setAdapter(c1528d);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        return Unit.INSTANCE;
    }
}
