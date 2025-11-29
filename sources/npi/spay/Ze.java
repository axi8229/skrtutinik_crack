package npi.spay;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ze extends RecyclerView.ItemDecoration {
    public final int a;

    public Ze(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView parent, RecyclerView.State s) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(s, "s");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            rect.right = (childAdapterPosition == -1 || childAdapterPosition == adapter.getItemCount() + (-1)) ? 0 : this.a;
        }
    }
}
