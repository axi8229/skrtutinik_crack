package ru.yoomoney.sdk.kassa.payments.ui.swipe;

import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/AnimationTracker;", "", "trackingAnimations", "", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "([Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;)V", "animatedViewHolders", "Ljava/util/HashSet;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "finishedAnimations", "Landroidx/collection/ArrayMap;", "Ljava/util/ArrayList;", "runningAnimations", "checkWhetherAnimationTracking", "", "type", "finish", "viewHolder", "hasRunningAnimations", "", "isAnimated", "isTrackingType", "reset", "viewHolders", "start", "Companion", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationTracker {
    private static final int DEFAULT_CAPACITY = 2;
    private final HashSet<RecyclerView.ViewHolder> animatedViewHolders;
    private final ArrayMap<SwipeItem.RecoverAnimationType, ArrayList<RecyclerView.ViewHolder>> finishedAnimations;
    private final ArrayMap<SwipeItem.RecoverAnimationType, ArrayList<RecyclerView.ViewHolder>> runningAnimations;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/AnimationTracker$Companion;", "", "()V", "DEFAULT_CAPACITY", "", "withPossibleValues", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/AnimationTracker;", "dismiss", "", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "([Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;)Lru/yoomoney/sdk/kassa/payments/ui/swipe/AnimationTracker;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AnimationTracker withPossibleValues(SwipeItem.RecoverAnimationType... dismiss) {
            Intrinsics.checkNotNullParameter(dismiss, "dismiss");
            return new AnimationTracker((SwipeItem.RecoverAnimationType[]) Arrays.copyOf(dismiss, dismiss.length), null);
        }
    }

    private AnimationTracker(SwipeItem.RecoverAnimationType... recoverAnimationTypeArr) {
        this.animatedViewHolders = new HashSet<>(2);
        if (recoverAnimationTypeArr.length == 0) {
            throw new IllegalArgumentException("You must set at least one tracking animation");
        }
        this.runningAnimations = new ArrayMap<>(recoverAnimationTypeArr.length);
        this.finishedAnimations = new ArrayMap<>(recoverAnimationTypeArr.length);
        for (SwipeItem.RecoverAnimationType recoverAnimationType : recoverAnimationTypeArr) {
            this.runningAnimations.put(recoverAnimationType, new ArrayList<>(2));
            this.finishedAnimations.put(recoverAnimationType, new ArrayList<>(2));
        }
    }

    private final void checkWhetherAnimationTracking(SwipeItem.RecoverAnimationType type) {
        if (isTrackingType(type)) {
            return;
        }
        throw new IllegalArgumentException(("Animation tracker monitors only " + this.runningAnimations.keySet() + " but you try " + type).toString());
    }

    private final void reset(ArrayList<RecyclerView.ViewHolder> viewHolders) {
        this.animatedViewHolders.removeAll(viewHolders);
        viewHolders.clear();
    }

    @JvmStatic
    public static final AnimationTracker withPossibleValues(SwipeItem.RecoverAnimationType... recoverAnimationTypeArr) {
        return INSTANCE.withPossibleValues(recoverAnimationTypeArr);
    }

    public final void finish(RecyclerView.ViewHolder viewHolder, SwipeItem.RecoverAnimationType type) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(type, "type");
        checkWhetherAnimationTracking(type);
        ArrayList<RecyclerView.ViewHolder> arrayList = this.runningAnimations.get(type);
        if (arrayList != null) {
            arrayList.remove(viewHolder);
        }
        ArrayList<RecyclerView.ViewHolder> arrayList2 = this.finishedAnimations.get(type);
        if (arrayList2 != null) {
            arrayList2.add(viewHolder);
        }
    }

    public final boolean hasRunningAnimations(SwipeItem.RecoverAnimationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        checkWhetherAnimationTracking(type);
        ArrayList<RecyclerView.ViewHolder> arrayList = this.runningAnimations.get(type);
        return arrayList != null && (arrayList.isEmpty() ^ true);
    }

    public final boolean isAnimated(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return this.animatedViewHolders.contains(viewHolder);
    }

    public final boolean isTrackingType(SwipeItem.RecoverAnimationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (this.runningAnimations.get(type) == null || this.finishedAnimations.get(type) == null) ? false : true;
    }

    public final void start(RecyclerView.ViewHolder viewHolder, SwipeItem.RecoverAnimationType type) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(type, "type");
        checkWhetherAnimationTracking(type);
        ArrayList<RecyclerView.ViewHolder> arrayList = this.runningAnimations.get(type);
        if (arrayList != null) {
            arrayList.add(viewHolder);
        }
        this.animatedViewHolders.add(viewHolder);
    }

    public /* synthetic */ AnimationTracker(SwipeItem.RecoverAnimationType[] recoverAnimationTypeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(recoverAnimationTypeArr);
    }

    public final void reset(SwipeItem.RecoverAnimationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        checkWhetherAnimationTracking(type);
        ArrayList<RecyclerView.ViewHolder> arrayList = this.runningAnimations.get(type);
        if (arrayList != null) {
            reset(arrayList);
        }
        ArrayList<RecyclerView.ViewHolder> arrayList2 = this.finishedAnimations.get(type);
        if (arrayList2 != null) {
            reset(arrayList2);
        }
    }
}
