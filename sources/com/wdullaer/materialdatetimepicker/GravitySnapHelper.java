package com.wdullaer.materialdatetimepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class GravitySnapHelper extends LinearSnapHelper {
    private int gravity;
    private OrientationHelper horizontalHelper;
    private boolean isRtlHorizontal;
    private SnapListener listener;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.wdullaer.materialdatetimepicker.GravitySnapHelper.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 2) {
                GravitySnapHelper.this.snapping = false;
            }
            if (i != 0 || GravitySnapHelper.this.listener == null) {
                return;
            }
            int snappedPosition = GravitySnapHelper.this.getSnappedPosition(recyclerView);
            if (snappedPosition != -1) {
                GravitySnapHelper.this.listener.onSnap(snappedPosition);
            }
            GravitySnapHelper.this.snapping = false;
        }
    };
    private boolean snapping;
    private OrientationHelper verticalHelper;

    public interface SnapListener {
        void onSnap(int i);
    }

    public GravitySnapHelper(int i, SnapListener snapListener) {
        if (i != 8388611 && i != 8388613 && i != 80 && i != 48) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
        }
        this.gravity = i;
        this.listener = snapListener;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        if (recyclerView != null) {
            int i = this.gravity;
            if (i == 8388611 || i == 8388613) {
                this.isRtlHorizontal = recyclerView.getContext().getResources().getConfiguration().getLayoutDirection() == 1;
            }
            if (this.listener != null) {
                recyclerView.addOnScrollListener(this.mScrollListener);
            }
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            if (this.gravity == 8388611) {
                iArr[0] = distanceToStart(view, getHorizontalHelper(layoutManager), false);
            } else {
                iArr[0] = distanceToEnd(view, getHorizontalHelper(layoutManager), false);
            }
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            if (this.gravity == 48) {
                iArr[1] = distanceToStart(view, getVerticalHelper(layoutManager), false);
            } else {
                iArr[1] = distanceToEnd(view, getVerticalHelper(layoutManager), false);
            }
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 == 0) goto L3d
            int r0 = r2.gravity
            r1 = 48
            if (r0 == r1) goto L34
            r1 = 80
            if (r0 == r1) goto L2b
            r1 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 == r1) goto L22
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 == r1) goto L19
            goto L3d
        L19:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L3e
        L22:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            android.view.View r3 = r2.findStartView(r3, r0)
            goto L3e
        L2b:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L3e
        L34:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
            android.view.View r3 = r2.findStartView(r3, r0)
            goto L3e
        L3d:
            r3 = 0
        L3e:
            if (r3 == 0) goto L42
            r0 = 1
            goto L43
        L42:
            r0 = 0
        L43:
            r2.snapping = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.GravitySnapHelper.findSnapView(androidx.recyclerview.widget.RecyclerView$LayoutManager):android.view.View");
    }

    private int distanceToStart(View view, OrientationHelper orientationHelper, boolean z) {
        if (this.isRtlHorizontal && !z) {
            return distanceToEnd(view, orientationHelper, true);
        }
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    private int distanceToEnd(View view, OrientationHelper orientationHelper, boolean z) {
        if (this.isRtlHorizontal && !z) {
            return distanceToStart(view, orientationHelper, true);
        }
        return orientationHelper.getDecoratedEnd(view) - orientationHelper.getEndAfterPadding();
    }

    private View findStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        LinearLayoutManager linearLayoutManager;
        int iFindFirstVisibleItemPosition;
        float decoratedEnd;
        int decoratedMeasurement;
        if (!(layoutManager instanceof LinearLayoutManager) || (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) == -1) {
            return null;
        }
        View viewFindViewByPosition = layoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        if (this.isRtlHorizontal) {
            decoratedEnd = orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(viewFindViewByPosition);
            decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewFindViewByPosition);
        } else {
            decoratedEnd = orientationHelper.getDecoratedEnd(viewFindViewByPosition);
            decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewFindViewByPosition);
        }
        float f = decoratedEnd / decoratedMeasurement;
        boolean z = linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
        if (f > 0.5f && !z) {
            return viewFindViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(iFindFirstVisibleItemPosition + 1);
    }

    private View findEndView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        LinearLayoutManager linearLayoutManager;
        int iFindLastVisibleItemPosition;
        float totalSpace;
        int decoratedMeasurement;
        if (!(layoutManager instanceof LinearLayoutManager) || (iFindLastVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findLastVisibleItemPosition()) == -1) {
            return null;
        }
        View viewFindViewByPosition = layoutManager.findViewByPosition(iFindLastVisibleItemPosition);
        if (this.isRtlHorizontal) {
            totalSpace = orientationHelper.getDecoratedEnd(viewFindViewByPosition);
            decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewFindViewByPosition);
        } else {
            totalSpace = orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(viewFindViewByPosition);
            decoratedMeasurement = orientationHelper.getDecoratedMeasurement(viewFindViewByPosition);
        }
        float f = totalSpace / decoratedMeasurement;
        boolean z = linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
        if (f > 0.5f && !z) {
            return viewFindViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(iFindLastVisibleItemPosition - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSnappedPosition(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        int i = this.gravity;
        if (i == 8388611 || i == 48) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (i == 8388613 || i == 80) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.verticalHelper == null) {
            this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.verticalHelper;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.horizontalHelper == null) {
            this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.horizontalHelper;
    }
}
