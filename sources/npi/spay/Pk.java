package npi.spay;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Pk extends RecyclerView.OnScrollListener {
    public final /* synthetic */ Xj a;

    public Pk(Xj xj) {
        this.a = xj;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Vj vj;
        View viewA;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        Xj xj = this.a;
        xj.getClass();
        if (i == 0 && (vj = xj.j) != null && xj.d) {
            if (xj.c != -1) {
                Intrinsics.checkNotNull(vj);
                vj.a(xj.c);
            } else {
                RecyclerView recyclerView2 = xj.k;
                Intrinsics.checkNotNull(recyclerView2);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (layoutManager != null && (viewA = xj.a(layoutManager, false)) != null) {
                    RecyclerView recyclerView3 = xj.k;
                    Intrinsics.checkNotNull(recyclerView3);
                    int childAdapterPosition = recyclerView3.getChildAdapterPosition(viewA);
                    if (childAdapterPosition != -1) {
                        Vj vj2 = xj.j;
                        Intrinsics.checkNotNull(vj2);
                        vj2.a(childAdapterPosition);
                    }
                }
            }
        }
        xj.d = i != 0;
    }
}
