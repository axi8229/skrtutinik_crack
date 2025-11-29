package ru.yoomoney.sdk.kassa.payments.ui.swipe;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J \u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J \u0010-\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00102\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020,H\u0016J\u0018\u00105\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020*H\u0002J\u0010\u00108\u001a\u00020,2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItemHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$AnimationCallback;", "context", "Landroid/content/Context;", "swipeConfig", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;", "(Landroid/content/Context;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;)V", "dragListener", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItemHelper$DragListener;", "(Landroid/content/Context;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItemHelper$DragListener;)V", "activePointerId", "", "animationTracker", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/AnimationTracker;", "getAnimationTracker", "()Lru/yoomoney/sdk/kassa/payments/ui/swipe/AnimationTracker;", "config", "currentSwipeItem", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "initialTouchX", "", "initialTouchY", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "touchSlop", "attachToRecyclerView", "", "detachFromRecyclerView", "forceCancel", "getViewHolderFromMotionEvent", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "motionEvent", "Landroid/view/MotionEvent;", "onAnimationEnd", "item", "type", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "withSwipe", "", "onAnimationStart", "onChildViewAttachedToWindow", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "onInterceptTouchEvent", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "onTouchEvent", "postCallback", "animationType", "shouldKeepSwipeItem", "DragListener", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwipeItemHelper implements RecyclerView.OnItemTouchListener, RecyclerView.OnChildAttachStateChangeListener, SwipeItem.AnimationCallback {
    public static final int $stable = 8;
    private int activePointerId;
    private final AnimationTracker animationTracker;
    private final SwipeConfig config;
    private SwipeItem currentSwipeItem;
    private final DragListener dragListener;
    private float initialTouchX;
    private float initialTouchY;
    private RecyclerView recyclerView;
    private final int touchSlop;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItemHelper$DragListener;", "", "onStartDrag", "", "onStopDrag", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DragListener {
        void onStartDrag();

        void onStopDrag();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeItemHelper(Context context, SwipeConfig swipeConfig) {
        this(context, swipeConfig, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(swipeConfig, "swipeConfig");
    }

    private final RecyclerView.ViewHolder getViewHolderFromMotionEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (viewFindChildViewUnder != null) {
            return recyclerView.getChildViewHolder(viewFindChildViewUnder);
        }
        return null;
    }

    private final void postCallback(final SwipeItem.RecoverAnimationType animationType) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItemHelper.postCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    RecyclerView recyclerView2;
                    if (SwipeItemHelper.this.getRecyclerView() == null || (recyclerView2 = SwipeItemHelper.this.getRecyclerView()) == null || !recyclerView2.isAttachedToWindow()) {
                        return;
                    }
                    RecyclerView recyclerView3 = SwipeItemHelper.this.getRecyclerView();
                    RecyclerView.ItemAnimator itemAnimator = recyclerView3 != null ? recyclerView3.getItemAnimator() : null;
                    if (itemAnimator == null || !itemAnimator.isRunning()) {
                        SwipeItemHelper.this.getAnimationTracker().reset(animationType);
                        return;
                    }
                    RecyclerView recyclerView4 = SwipeItemHelper.this.getRecyclerView();
                    if (recyclerView4 != null) {
                        recyclerView4.post(this);
                    }
                }
            });
        }
    }

    private final boolean shouldKeepSwipeItem(SwipeItem.RecoverAnimationType type) {
        return type == SwipeItem.RecoverAnimationType.OPEN_MENU;
    }

    public final synchronized void attachToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        recyclerView.addOnItemTouchListener(this);
        recyclerView.addOnChildAttachStateChangeListener(this);
    }

    public final synchronized void detachFromRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this);
            recyclerView.removeOnChildAttachStateChangeListener(this);
            this.recyclerView = null;
        }
    }

    public final void forceCancel() {
        SwipeItem swipeItem = this.currentSwipeItem;
        if (swipeItem != null) {
            swipeItem.cancel();
        }
    }

    public final AnimationTracker getAnimationTracker() {
        return this.animationTracker;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.AnimationCallback
    public void onAnimationEnd(SwipeItem item, SwipeItem.RecoverAnimationType type, boolean withSwipe) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.animationTracker.isTrackingType(type)) {
            this.animationTracker.finish(item.getViewHolder(), type);
            if (this.animationTracker.hasRunningAnimations(type)) {
                return;
            }
            postCallback(type);
        }
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.AnimationCallback
    public void onAnimationStart(SwipeItem item, SwipeItem.RecoverAnimationType type, boolean withSwipe) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.animationTracker.isTrackingType(type)) {
            this.animationTracker.start(item.getViewHolder(), type);
        }
        if (!Intrinsics.areEqual(this.currentSwipeItem, item) || shouldKeepSwipeItem(type)) {
            return;
        }
        this.currentSwipeItem = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        SwipeItem swipeItem;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.activePointerId = motionEvent.getPointerId(0);
            this.initialTouchX = motionEvent.getX();
            this.initialTouchY = motionEvent.getY();
            return false;
        }
        if (actionMasked != 2 || this.activePointerId == -1) {
            return false;
        }
        if (recyclerView.getScrollState() == 1) {
            SwipeItem swipeItem2 = this.currentSwipeItem;
            if (swipeItem2 != null) {
                swipeItem2.cancel();
                this.currentSwipeItem = null;
            }
            return false;
        }
        float x = motionEvent.getX() - this.initialTouchX;
        float y = motionEvent.getY() - this.initialTouchY;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        if (fAbs <= this.touchSlop || fAbs <= fAbs2) {
            return false;
        }
        RecyclerView.ViewHolder viewHolderFromMotionEvent = getViewHolderFromMotionEvent(recyclerView, motionEvent);
        if (viewHolderFromMotionEvent instanceof SwipeItem.Presenter) {
            if (this.animationTracker.isAnimated(viewHolderFromMotionEvent)) {
                return false;
            }
            SwipeItem swipeItem3 = this.currentSwipeItem;
            if ((swipeItem3 != null ? swipeItem3.getViewHolder() : null) != viewHolderFromMotionEvent && (swipeItem = this.currentSwipeItem) != null) {
                swipeItem.cancel();
            }
            SwipeItem swipeItem4 = new SwipeItem(viewHolderFromMotionEvent, this.config, this);
            this.currentSwipeItem = swipeItem4;
            if (!swipeItem4.getIsSwipeItemAvailable()) {
                return false;
            }
            SwipeItem swipeItem5 = this.currentSwipeItem;
            if (swipeItem5 == null || swipeItem5.isDismissed()) {
                this.currentSwipeItem = null;
            } else {
                DragListener dragListener = this.dragListener;
                if (dragListener != null) {
                    dragListener.onStartDrag();
                }
            }
        }
        return this.currentSwipeItem != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.currentSwipeItem == null) {
            return;
        }
        float x = motionEvent.getX() - this.initialTouchX;
        SwipeItem swipeItem = this.currentSwipeItem;
        Float fValueOf = swipeItem != null ? Float.valueOf(swipeItem.getSwipeTranslation(x)) : null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (fValueOf != null) {
                    float fFloatValue = fValueOf.floatValue();
                    SwipeItem swipeItem2 = this.currentSwipeItem;
                    if (swipeItem2 != null) {
                        swipeItem2.translateItem(fFloatValue);
                        return;
                    }
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                return;
            }
        }
        if (fValueOf != null) {
            float fFloatValue2 = fValueOf.floatValue();
            SwipeItem swipeItem3 = this.currentSwipeItem;
            if (swipeItem3 != null) {
                swipeItem3.animateFrom(fFloatValue2);
            }
        }
        DragListener dragListener = this.dragListener;
        if (dragListener != null) {
            dragListener.onStopDrag();
        }
        this.activePointerId = -1;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    private SwipeItemHelper(Context context, SwipeConfig swipeConfig, DragListener dragListener) {
        this.dragListener = dragListener;
        this.animationTracker = AnimationTracker.INSTANCE.withPossibleValues(SwipeItem.RecoverAnimationType.OPEN_MENU);
        this.activePointerId = -1;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.config = swipeConfig;
    }
}
