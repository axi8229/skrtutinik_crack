package npi.spay;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Wj extends LinearSmoothScroller {
    public final /* synthetic */ Xj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wj(Xj xj, Context context) {
        super(context);
        this.a = xj;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return this.a.e / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        RecyclerView recyclerView = this.a.k;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getLayoutManager() == null) {
                return;
            }
            Xj xj = this.a;
            RecyclerView recyclerView2 = xj.k;
            Intrinsics.checkNotNull(recyclerView2);
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            int[] iArrCalculateDistanceToFinalSnap = xj.calculateDistanceToFinalSnap(layoutManager, targetView);
            int i = iArrCalculateDistanceToFinalSnap[0];
            int i2 = iArrCalculateDistanceToFinalSnap[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (iCalculateTimeForDeceleration > 0) {
                action.update(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }
}
