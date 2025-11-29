package ru.yoomoney.sdk.gui.widget;

import android.R;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.appbar.AppBarLayout;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$string;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;

/* compiled from: TopBarDefault.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0014R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "Lcom/google/android/material/appbar/AppBarLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "isElevated", "setElevated", "(Z)V", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "toolbar", "Lru/yoomoney/sdk/gui/widget/ToolbarWithTint;", "getToolbar", "()Lru/yoomoney/sdk/gui/widget/ToolbarWithTint;", "getBehavior", "Lru/yoomoney/sdk/gui/widget/TopBarBehavior;", "onCreateDrawableState", "", "extraSpace", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class TopBarDefault extends AppBarLayout implements CoordinatorLayout.AttachedBehavior {
    private boolean isElevated;
    private final ToolbarWithTint toolbar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopBarDefault(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopBarDefault(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopBarDefault(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_AppBar_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopBarDefault(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_AppBar, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        TypedValue typedValue = new TypedValue();
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, (context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics()) : 0) + (getFitsSystemWindows() ? GuiContextExtensions.getStatusBarHeight(context) : 0));
        layoutParams.setScrollFlags(16);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ym_AppBar_ym_ToolbarControlsColor, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ym_AppBar_ym_background);
        ToolbarWithTint toolbarWithTint = new ToolbarWithTint(context, null, 2, 0 == true ? 1 : 0);
        toolbarWithTint.setId(R$id.toolbar);
        toolbarWithTint.setTintColor(color);
        toolbarWithTint.setBackground(drawable);
        toolbarWithTint.setNavigationContentDescription(context.getString(R$string.top_bar_content_description_back));
        this.toolbar = toolbarWithTint;
        if (new ContextThemeWrapper(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.ym_AppBar_ym_CollapsingToolbarLayout_Style, 0)).getTheme().resolveAttribute(R$attr.collapsedTitleTextAppearance, typedValue, true)) {
            toolbarWithTint.setTitleTextAppearance(context, typedValue.data);
        }
        addView(toolbarWithTint, layoutParams);
        setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.ym_AppBar_ym_stateListAnimator, 0)));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final ToolbarWithTint getToolbar() {
        return this.toolbar;
    }

    public final CharSequence getTitle() {
        return this.toolbar.getTitle();
    }

    public final void setTitle(CharSequence charSequence) {
        this.toolbar.setTitle(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setElevated(boolean z) {
        this.isElevated = z;
        refreshDrawableState();
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] iArrMergeDrawableStates = View.mergeDrawableStates(super.onCreateDrawableState(extraSpace + 1), new int[]{this.isElevated ? R$attr.ym_state_elevated : -R$attr.ym_state_elevated});
        Intrinsics.checkNotNullExpressionValue(iArrMergeDrawableStates, "mergeDrawableStates(...)");
        return iArrMergeDrawableStates;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public TopBarBehavior getBehavior() {
        return new TopBarBehavior(new Function1<Boolean, Unit>() { // from class: ru.yoomoney.sdk.gui.widget.TopBarDefault.getBehavior.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                TopBarDefault.this.setElevated(z);
            }
        });
    }
}
