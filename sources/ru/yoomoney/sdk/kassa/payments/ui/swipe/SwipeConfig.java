package ru.yoomoney.sdk.kassa.payments.ui.swipe;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$dimen;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;", "", "res", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "animationDuration", "", "menuOpenThreshold", "menuItemsCount", "(III)V", "getAnimationDuration", "()I", "getMenuOpenThreshold", "menuOpenedWidth", "getMenuOpenedWidth", "Companion", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwipeConfig {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SparseArray<SwipeConfig> configurations = new SparseArray<>(2);
    private final int animationDuration;
    private final int menuOpenThreshold;
    private final int menuOpenedWidth;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig$Companion;", "", "()V", "configurations", "Landroid/util/SparseArray;", "Lru/yoomoney/sdk/kassa/payments/ui/swipe/SwipeConfig;", "get", "context", "Landroid/content/Context;", "animationDuration", "", "menuOpenThreshold", "menuItemsCount", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SwipeConfig get(int animationDuration, int menuOpenThreshold, int menuItemsCount) {
            return new SwipeConfig(animationDuration, menuOpenThreshold, menuItemsCount, null);
        }

        public final SwipeConfig get(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = (int) (context.getResources().getDisplayMetrics().density * 100.0f);
            SwipeConfig swipeConfig = (SwipeConfig) SwipeConfig.configurations.get(i);
            if (swipeConfig != null) {
                return swipeConfig;
            }
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            SwipeConfig swipeConfig2 = new SwipeConfig(resources, null);
            SwipeConfig.configurations.put(i, swipeConfig2);
            return swipeConfig2;
        }
    }

    private SwipeConfig(int i, int i2, int i3) {
        this.animationDuration = i;
        this.menuOpenThreshold = i2;
        this.menuOpenedWidth = i2 * i3;
    }

    public final int getAnimationDuration() {
        return this.animationDuration;
    }

    public final int getMenuOpenThreshold() {
        return this.menuOpenThreshold;
    }

    public final int getMenuOpenedWidth() {
        return this.menuOpenedWidth;
    }

    public /* synthetic */ SwipeConfig(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    private SwipeConfig(Resources resources) throws Resources.NotFoundException {
        this.animationDuration = resources.getInteger(R.integer.config_shortAnimTime);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.ym_swipe_menu_button_width);
        this.menuOpenThreshold = dimensionPixelSize;
        this.menuOpenedWidth = dimensionPixelSize * 2;
    }

    public /* synthetic */ SwipeConfig(Resources resources, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources);
    }
}
