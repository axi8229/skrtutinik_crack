package npi.spay;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Xj extends LinearSnapHelper {
    public boolean b;
    public int c;
    public boolean d;
    public OrientationHelper h;
    public OrientationHelper i;
    public final Vj j;
    public RecyclerView k;
    public final float e = 100.0f;
    public final int f = -1;
    public final float g = -1.0f;
    public final Pk l = new Pk(this);
    public final int a = 8388611;

    public Xj(Vj vj) {
        this.j = vj;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View a(androidx.recyclerview.widget.RecyclerView.LayoutManager r9, androidx.recyclerview.widget.OrientationHelper r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Xj.a(androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.OrientationHelper, int, boolean):android.view.View");
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.k;
        if (recyclerView2 != null) {
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.removeOnScrollListener(this.l);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            int i = this.a;
            if (i == 8388611 || i == 8388613) {
                this.b = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
            }
            recyclerView.addOnScrollListener(this.l);
            this.k = recyclerView;
        } else {
            this.k = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] calculateDistanceToFinalSnap(androidx.recyclerview.widget.RecyclerView.LayoutManager r8, android.view.View r9) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Xj.calculateDistanceToFinalSnap(androidx.recyclerview.widget.RecyclerView$LayoutManager, android.view.View):int[]");
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] calculateScrollDistance(int i, int i2) {
        int width;
        int i3;
        if (this.k == null || ((this.h == null && this.i == null) || (this.f == -1 && this.g == -1.0f))) {
            int[] iArrCalculateScrollDistance = super.calculateScrollDistance(i, i2);
            Intrinsics.checkNotNullExpressionValue(iArrCalculateScrollDistance, "super.calculateScrollDis…nce(velocityX, velocityY)");
            return iArrCalculateScrollDistance;
        }
        RecyclerView recyclerView = this.k;
        Intrinsics.checkNotNull(recyclerView);
        Scroller scroller = new Scroller(recyclerView.getContext(), new DecelerateInterpolator());
        if (this.g == -1.0f) {
            i3 = this.f;
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
        } else {
            if (this.h != null) {
                RecyclerView recyclerView2 = this.k;
                Intrinsics.checkNotNull(recyclerView2);
                width = recyclerView2.getHeight();
            } else {
                if (this.i != null) {
                    RecyclerView recyclerView3 = this.k;
                    Intrinsics.checkNotNull(recyclerView3);
                    width = recyclerView3.getWidth();
                }
                i3 = Integer.MAX_VALUE;
            }
            i3 = (int) (width * this.g);
        }
        int i4 = i3;
        int i5 = -i4;
        scroller.fling(0, 0, i, i2, i5, i4, i5, i4);
        return new int[]{scroller.getFinalX(), scroller.getFinalY()};
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.k) == null) {
            return null;
        }
        Intrinsics.checkNotNull(recyclerView);
        return new Wj(this, recyclerView.getContext());
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager lm) {
        Intrinsics.checkNotNullParameter(lm, "lm");
        return a(lm, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View a(androidx.recyclerview.widget.RecyclerView.LayoutManager r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "lm"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r4.a
            r1 = 17
            if (r0 == r1) goto L87
            r1 = 48
            r2 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 == r1) goto L71
            r1 = 80
            r3 = 8388613(0x800005, float:1.175495E-38)
            if (r0 == r1) goto L5b
            if (r0 == r2) goto L3e
            if (r0 == r3) goto L20
            r5 = 0
            goto Lc0
        L20:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.i
            if (r0 == 0) goto L2d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == r5) goto L33
        L2d:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(r5)
            r4.i = r0
        L33:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.i
        L35:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.view.View r5 = r4.a(r5, r0, r3, r6)
            goto Lc0
        L3e:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.i
            if (r0 == 0) goto L4b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == r5) goto L51
        L4b:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(r5)
            r4.i = r0
        L51:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.i
        L53:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.view.View r5 = r4.a(r5, r0, r2, r6)
            goto Lc0
        L5b:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.h
            if (r0 == 0) goto L68
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == r5) goto L6e
        L68:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(r5)
            r4.h = r0
        L6e:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.h
            goto L35
        L71:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.h
            if (r0 == 0) goto L7e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == r5) goto L84
        L7e:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(r5)
            r4.h = r0
        L84:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.h
            goto L53
        L87:
            boolean r0 = r5.canScrollHorizontally()
            if (r0 == 0) goto Laa
            androidx.recyclerview.widget.OrientationHelper r0 = r4.i
            if (r0 == 0) goto L9a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == r5) goto La0
        L9a:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(r5)
            r4.i = r0
        La0:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.i
        La2:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.view.View r5 = r4.a(r5, r0, r1, r6)
            goto Lc0
        Laa:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.h
            if (r0 == 0) goto Lb7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == r5) goto Lbd
        Lb7:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(r5)
            r4.h = r0
        Lbd:
            androidx.recyclerview.widget.OrientationHelper r0 = r4.h
            goto La2
        Lc0:
            if (r5 == 0) goto Lce
            androidx.recyclerview.widget.RecyclerView r6 = r4.k
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.getChildAdapterPosition(r5)
        Lcb:
            r4.c = r6
            goto Ld0
        Lce:
            r6 = -1
            goto Lcb
        Ld0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Xj.a(androidx.recyclerview.widget.RecyclerView$LayoutManager, boolean):android.view.View");
    }
}
