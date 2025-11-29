package ru.yoomoney.sdk.gui.widget.pager;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.varioqub.config.model.ConfigValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecyclerViewAttacherPagerIndicator.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/gui/widget/pager/RecyclerViewAttacherPagerIndicator;", "Lru/yoomoney/sdk/gui/widget/pager/AttacherPagerIndicator;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/gui/widget/pager/ScrollListener;", "manager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "measuredChildHeight", "", "measuredChildWidth", "findFirstVisibleView", "Landroid/view/View;", "getActualPosition", "position", "offset", "", "getChildHeight", "getChildWidth", "getCount", "getCurrentFrameBottom", "getCurrentFrameLeft", "setCurrentItem", "", "setItemScrolledListener", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecyclerViewAttacherPagerIndicator implements AttacherPagerIndicator {
    private ScrollListener listener;
    private final LinearLayoutManager manager;
    private int measuredChildHeight;
    private int measuredChildWidth;
    private final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    public final int getActualPosition(int position, float offset) {
        return ((double) offset) >= 0.5d ? position + 1 : position;
    }

    public RecyclerViewAttacherPagerIndicator(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        this.manager = (LinearLayoutManager) layoutManager;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.yoomoney.sdk.gui.widget.pager.RecyclerViewAttacherPagerIndicator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView v, int newState) {
                Intrinsics.checkNotNullParameter(v, "v");
                ScrollListener scrollListener = RecyclerViewAttacherPagerIndicator.this.listener;
                if (scrollListener != null) {
                    scrollListener.onItemScrollStateChanged(newState);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                float currentFrameBottom;
                int measuredHeight;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                View viewFindFirstVisibleView = RecyclerViewAttacherPagerIndicator.this.findFirstVisibleView();
                if (viewFindFirstVisibleView == null) {
                    return;
                }
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(viewFindFirstVisibleView);
                if (RecyclerViewAttacherPagerIndicator.this.manager.getOrientation() == 0) {
                    currentFrameBottom = RecyclerViewAttacherPagerIndicator.this.getCurrentFrameLeft() - viewFindFirstVisibleView.getX();
                    measuredHeight = viewFindFirstVisibleView.getMeasuredWidth();
                } else {
                    currentFrameBottom = RecyclerViewAttacherPagerIndicator.this.getCurrentFrameBottom() - viewFindFirstVisibleView.getY();
                    measuredHeight = viewFindFirstVisibleView.getMeasuredHeight();
                }
                float f = currentFrameBottom / measuredHeight;
                double d = f;
                if (ConfigValue.DOUBLE_DEFAULT_VALUE > d || d > 1.0d || childAdapterPosition >= RecyclerViewAttacherPagerIndicator.this.getCount()) {
                    return;
                }
                int actualPosition = RecyclerViewAttacherPagerIndicator.this.getActualPosition(childAdapterPosition, f);
                ScrollListener scrollListener = RecyclerViewAttacherPagerIndicator.this.listener;
                if (scrollListener != null) {
                    scrollListener.onItemScrolled(actualPosition, f);
                }
                ScrollListener scrollListener2 = RecyclerViewAttacherPagerIndicator.this.listener;
                if (scrollListener2 != null) {
                    scrollListener2.onItemSelected(actualPosition);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[PHI: r6
  0x003e: PHI (r6v3 float) = (r6v2 float), (r6v4 float) binds: [B:20:0x0057, B:15:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View findFirstVisibleView() {
        /*
            r9 = this;
            int r0 = r9.getCount()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            androidx.recyclerview.widget.RecyclerView r0 = r9.recyclerView
            int r0 = r0.getChildCount()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r4 = r1
        L13:
            if (r3 >= r0) goto L5d
            androidx.recyclerview.widget.LinearLayoutManager r5 = r9.manager
            android.view.View r5 = r5.getChildAt(r3)
            if (r5 != 0) goto L1e
            return r1
        L1e:
            androidx.recyclerview.widget.LinearLayoutManager r6 = r9.manager
            int r6 = r6.getOrientation()
            if (r6 != 0) goto L41
            float r6 = r5.getX()
            int r7 = r5.getMeasuredWidth()
            float r7 = (float) r7
            float r7 = r7 + r6
            float r8 = (float) r2
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 >= 0) goto L5a
            int r8 = r9.getCurrentFrameLeft()
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 < 0) goto L5a
        L3e:
            int r2 = (int) r6
            r4 = r5
            goto L5a
        L41:
            float r6 = r5.getY()
            int r7 = r5.getMeasuredHeight()
            float r7 = (float) r7
            float r7 = r7 + r6
            float r8 = (float) r2
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 >= 0) goto L5a
            int r8 = r9.getCurrentFrameBottom()
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 < 0) goto L5a
            goto L3e
        L5a:
            int r3 = r3 + 1
            goto L13
        L5d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.gui.widget.pager.RecyclerViewAttacherPagerIndicator.findFirstVisibleView():android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentFrameLeft() {
        return (this.recyclerView.getMeasuredWidth() - getChildWidth()) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentFrameBottom() {
        return ((this.recyclerView.getMeasuredHeight() - getChildHeight()) / 2) + getChildHeight();
    }

    private final int getChildWidth() {
        if (this.measuredChildWidth == 0) {
            int childCount = this.recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.recyclerView.getChildAt(i);
                if (childAt.getMeasuredWidth() != 0) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    this.measuredChildWidth = measuredWidth;
                    return measuredWidth;
                }
            }
        }
        return this.measuredChildWidth;
    }

    private final int getChildHeight() {
        if (this.measuredChildHeight == 0) {
            int childCount = this.recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.recyclerView.getChildAt(i);
                if (childAt.getMeasuredHeight() != 0) {
                    this.measuredChildWidth = childAt.getMeasuredHeight();
                    return this.measuredChildHeight;
                }
            }
        }
        return this.measuredChildHeight;
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator
    public int getCount() {
        return this.manager.getItemCount();
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator
    public void setCurrentItem(int position) {
        this.recyclerView.scrollToPosition(position);
    }

    @Override // ru.yoomoney.sdk.gui.widget.pager.AttacherPagerIndicator
    public void setItemScrolledListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
