package ru.yoomoney.sdk.kassa.payments.ui.swipe;

import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.RecoverAnimation;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 *2\u00020\u0001:\u0005)*+,-B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0018J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "config", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;", "animationCallback", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$AnimationCallback;", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$AnimationCallback;)V", "getAnimationCallback", "()Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$AnimationCallback;", "getConfig", "()Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;", "contentContainer", "Landroid/view/View;", "getContentContainer", "()Landroid/view/View;", "isDismissed", "", "()Z", "isSwipeItemAvailable", "maxRightOffset", "", "startDx", "", "swipeMenuContainer", "width", "animate", "", "type", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "withSwipe", "animateFrom", "translationX", "cancel", "getSwipeTranslation", "touchDx", "isSwipeAvailable", "setContentTranslation", "showOnlyInvolvedHints", "translateItem", "AnimationCallback", "Companion", "Presenter", "RecoverAnimationConfig", "RecoverAnimationType", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwipeItem {
    private static final Property<SwipeItem, Float> CONTENT_TRANSLATION_X;
    private final AnimationCallback animationCallback;
    private final SwipeConfig config;
    private final View contentContainer;
    private final boolean isSwipeItemAvailable;
    private final int maxRightOffset;
    private final float startDx;
    private final View swipeMenuContainer;
    private final RecyclerView.ViewHolder viewHolder;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$AnimationCallback;", "", "onAnimationEnd", "", "item", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "type", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "withSwipe", "", "onAnimationStart", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnimationCallback {
        void onAnimationEnd(SwipeItem item, RecoverAnimationType type, boolean withSwipe);

        void onAnimationStart(SwipeItem item, RecoverAnimationType type, boolean withSwipe);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$Companion;", "", "()V", "CONTENT_TRANSLATION_X", "Landroid/util/Property;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;", "", "getCONTENT_TRANSLATION_X", "()Landroid/util/Property;", "hideView", "", "view", "Landroid/view/View;", "showView", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void hideView(View view) {
            if (view.getVisibility() != 4) {
                view.setVisibility(4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showView(View view) {
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
            }
        }

        public final Property<SwipeItem, Float> getCONTENT_TRANSLATION_X() {
            return SwipeItem.CONTENT_TRANSLATION_X;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$Presenter;", "", "isSwipeAvailable", "", "()Z", "getContentContainer", "Landroid/view/View;", "getSwipeMenuContainer", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Presenter {
        View getContentContainer();

        View getSwipeMenuContainer();

        boolean isSwipeAvailable();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationConfig;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationConfig;", "type", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "withSwipe", "", "(Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem;Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;Z)V", "animationDuration", "", "getAnimationDuration", "()I", "targetTranslation", "", "getTargetTranslation", "()F", "getType", "()Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "getWithSwipe", "()Z", "getAnimationListener", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/RecoverAnimation$AnimationListener;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RecoverAnimationConfig implements RecoverAnimation.AnimationConfig {
        final /* synthetic */ SwipeItem this$0;
        private final RecoverAnimationType type;
        private final boolean withSwipe;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RecoverAnimationType.values().length];
                try {
                    iArr[RecoverAnimationType.CANCEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RecoverAnimationType.OPEN_MENU.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public RecoverAnimationConfig(SwipeItem swipeItem, RecoverAnimationType type, boolean z) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.this$0 = swipeItem;
            this.type = type;
            this.withSwipe = z;
        }

        @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeAnimation.AnimationConfig
        public int getAnimationDuration() {
            return this.this$0.getConfig().getAnimationDuration();
        }

        @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.RecoverAnimation.AnimationConfig
        public RecoverAnimation.AnimationListener getAnimationListener() {
            final SwipeItem swipeItem = this.this$0;
            return new RecoverAnimation.AnimationListener() { // from class: ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem$RecoverAnimationConfig$getAnimationListener$1
                @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.RecoverAnimation.AnimationListener
                public void onPostAnimation() {
                    SwipeItem swipeItem2 = swipeItem;
                    swipeItem2.showOnlyInvolvedHints(swipeItem2.getContentContainer().getTranslationX());
                    swipeItem.getAnimationCallback().onAnimationEnd(swipeItem, this.getType(), this.getWithSwipe());
                }

                @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.RecoverAnimation.AnimationListener
                public void onPreAnimation() {
                    swipeItem.getAnimationCallback().onAnimationStart(swipeItem, this.getType(), this.getWithSwipe());
                }
            };
        }

        @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.RecoverAnimation.AnimationConfig
        public float getTargetTranslation() {
            int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
            if (i == 1) {
                return 0.0f;
            }
            if (i == 2) {
                return -this.this$0.getConfig().getMenuOpenedWidth();
            }
            throw new NoWhenBranchMatchedException();
        }

        public final RecoverAnimationType getType() {
            return this.type;
        }

        public final boolean getWithSwipe() {
            return this.withSwipe;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeItem$RecoverAnimationType;", "", "(Ljava/lang/String;I)V", "CANCEL", "OPEN_MENU", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecoverAnimationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecoverAnimationType[] $VALUES;
        public static final RecoverAnimationType CANCEL = new RecoverAnimationType("CANCEL", 0);
        public static final RecoverAnimationType OPEN_MENU = new RecoverAnimationType("OPEN_MENU", 1);

        private static final /* synthetic */ RecoverAnimationType[] $values() {
            return new RecoverAnimationType[]{CANCEL, OPEN_MENU};
        }

        static {
            RecoverAnimationType[] recoverAnimationTypeArr$values = $values();
            $VALUES = recoverAnimationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(recoverAnimationTypeArr$values);
        }

        private RecoverAnimationType(String str, int i) {
        }

        public static EnumEntries<RecoverAnimationType> getEntries() {
            return $ENTRIES;
        }

        public static RecoverAnimationType valueOf(String str) {
            return (RecoverAnimationType) Enum.valueOf(RecoverAnimationType.class, str);
        }

        public static RecoverAnimationType[] values() {
            return (RecoverAnimationType[]) $VALUES.clone();
        }
    }

    static {
        final Class cls = Float.TYPE;
        CONTENT_TRANSLATION_X = new Property<SwipeItem, Float>(cls) { // from class: ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem$Companion$CONTENT_TRANSLATION_X$1
            @Override // android.util.Property
            public Float get(SwipeItem swipeItem) {
                Intrinsics.checkNotNullParameter(swipeItem, "swipeItem");
                return Float.valueOf(swipeItem.getContentContainer().getTranslationX());
            }

            @Override // android.util.Property
            public /* bridge */ /* synthetic */ void set(SwipeItem swipeItem, Float f) {
                set(swipeItem, f.floatValue());
            }

            public void set(SwipeItem swipeItem, float value) {
                Intrinsics.checkNotNullParameter(swipeItem, "swipeItem");
                swipeItem.setContentTranslation(value);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeItem(RecyclerView.ViewHolder viewHolder, SwipeConfig config, AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(animationCallback, "animationCallback");
        this.viewHolder = viewHolder;
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.Presenter");
        Presenter presenter = (Presenter) viewHolder;
        View contentContainer = presenter.getContentContainer();
        this.contentContainer = contentContainer;
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.Presenter");
        View swipeMenuContainer = presenter.getSwipeMenuContainer();
        this.swipeMenuContainer = swipeMenuContainer;
        Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.Presenter");
        this.isSwipeItemAvailable = presenter.isSwipeAvailable();
        this.config = config;
        this.animationCallback = animationCallback;
        this.width = viewHolder.itemView.getWidth();
        this.maxRightOffset = swipeMenuContainer.getWidth();
        this.startDx = contentContainer.getTranslationX();
    }

    private final void animate(RecoverAnimationType type, boolean withSwipe) {
        new RecoverAnimation(this, new RecoverAnimationConfig(this, type, withSwipe)).start();
    }

    public final void animateFrom(float translationX) {
        animate(Math.abs(translationX) < ((float) this.config.getMenuOpenThreshold()) ? RecoverAnimationType.CANCEL : RecoverAnimationType.OPEN_MENU, true);
    }

    public final void cancel() {
        animate(RecoverAnimationType.CANCEL, false);
    }

    public final AnimationCallback getAnimationCallback() {
        return this.animationCallback;
    }

    public final SwipeConfig getConfig() {
        return this.config;
    }

    public final View getContentContainer() {
        return this.contentContainer;
    }

    public final float getSwipeTranslation(float touchDx) {
        float f = this.startDx + touchDx;
        if (f < 0.0f) {
            return Math.max(f, -this.maxRightOffset);
        }
        return 0.0f;
    }

    public final boolean isDismissed() {
        return MathKt.roundToInt(this.contentContainer.getTranslationX()) == (-this.width);
    }

    /* renamed from: isSwipeAvailable, reason: from getter */
    public final boolean getIsSwipeItemAvailable() {
        return this.isSwipeItemAvailable;
    }

    public final void setContentTranslation(float translationX) {
        this.contentContainer.setTranslationX(translationX);
        if (translationX < 0.0f) {
            this.swipeMenuContainer.setTranslationX(translationX + this.width);
        }
    }

    public final void showOnlyInvolvedHints(float translationX) {
        if (translationX <= 0.0f && translationX < 0.0f) {
            INSTANCE.showView(this.swipeMenuContainer);
        } else {
            INSTANCE.hideView(this.swipeMenuContainer);
        }
    }

    public final void translateItem(float translationX) {
        setContentTranslation(translationX);
        showOnlyInvolvedHints(translationX);
    }

    /* renamed from: viewHolder, reason: from getter */
    public final RecyclerView.ViewHolder getViewHolder() {
        return this.viewHolder;
    }
}
