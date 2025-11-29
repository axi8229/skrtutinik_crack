package ru.yoomoney.sdk.gui.widget.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.DeviceUtilKt;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.TypedArrayExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;

/* compiled from: PrimaryButtonView.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0016J0\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0018\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J&\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J\u0010\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020.H\u0016J\u0012\u0010?\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010B\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010CH\u0016J\u000e\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020\u0012J\u0010\u0010D\u001a\u00020'2\b\b\u0001\u0010F\u001a\u00020\u0007J\u0010\u0010\u001f\u001a\u00020'2\b\b\u0001\u0010G\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020'2\u0006\u0010F\u001a\u00020\u0012J\u000e\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020.J\b\u0010J\u001a\u00020'H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006K"}, d2 = {"Lru/yoomoney/sdk/gui/widget/button/PrimaryButtonView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "button", "Landroidx/appcompat/widget/AppCompatButton;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroid/graphics/drawable/Drawable;", RemoteMessageConst.Notification.ICON, "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/content/res/ColorStateList;", "iconStateColor", "getIconStateColor", "()Landroid/content/res/ColorStateList;", "setIconStateColor", "(Landroid/content/res/ColorStateList;)V", "progress", "Landroid/widget/ProgressBar;", "progressSize", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "()I", "setTextColor", "(I)V", "addView", "", "child", "Landroid/view/View;", "createProgressBar", "typedArray", "Landroid/content/res/TypedArray;", "hasOnClickListeners", "", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setButtonPadding", "left", "top", "right", "bottom", "setEnabled", "enabled", "setOnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "setSchemeColor", "colorStateList", RemoteMessageConst.Notification.COLOR, "textRes", "showProgress", "show", "updateIcon", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class PrimaryButtonView extends ViewGroup {
    private final AppCompatButton button;
    private Drawable icon;
    private ColorStateList iconStateColor;
    private final ProgressBar progress;
    private final int progressSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrimaryButtonView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrimaryButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PrimaryButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_PrimaryButton_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimaryButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_Button, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_Button_ym_button_horizontal_padding, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_Button_ym_button_vertical_padding, 0);
        this.progressSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_Button_ym_progress_size, -2);
        if (getBackground() == null) {
            setBackground(ButtonUtilsKt.getPrimaryButtonBackground$default(context, null, 2, null));
        }
        AppCompatButton appCompatButton = new AppCompatButton(context);
        appCompatButton.setSingleLine();
        appCompatButton.setGravity(17);
        appCompatButton.setEllipsize(TextUtils.TruncateAt.END);
        appCompatButton.setTransformationMethod(null);
        appCompatButton.setCompoundDrawablePadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ym_Button_android_drawablePadding, 0));
        appCompatButton.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        appCompatButton.setBackground(null);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ym_Button_ym_ButtonTextAppearance, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(appCompatButton, resourceId);
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.ym_Button_ym_text_color);
        if (colorStateList != null) {
            appCompatButton.setTextColor(colorStateList);
        }
        this.button = appCompatButton;
        ProgressBar progressBarCreateProgressBar = createProgressBar(typedArrayObtainStyledAttributes);
        this.progress = progressBarCreateProgressBar;
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_Button_ym_enabled, true));
        CharSequence text = typedArrayObtainStyledAttributes.getText(R$styleable.ym_Button_ym_text);
        if (text != null) {
            setText(text);
        }
        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.ym_Button_ym_icon_color);
        if (colorStateList2 != null) {
            setIconStateColor(colorStateList2);
        }
        Drawable styleableDrawable = TypedArrayExtensions.getStyleableDrawable(typedArrayObtainStyledAttributes, context, R$styleable.ym_Button_ym_icon);
        if (styleableDrawable != null) {
            setIcon(styleableDrawable);
        }
        addView(appCompatButton);
        addView(progressBarCreateProgressBar);
        typedArrayObtainStyledAttributes.recycle();
        setAddStatesFromChildren(true);
    }

    public final ColorStateList getIconStateColor() {
        return this.iconStateColor;
    }

    public final void setIconStateColor(ColorStateList colorStateList) {
        this.iconStateColor = colorStateList;
        updateIcon();
    }

    public final CharSequence getText() {
        return this.button.getText();
    }

    public final void setText(CharSequence charSequence) {
        this.button.setText(charSequence);
    }

    public final int getTextColor() {
        return this.button.getCurrentTextColor();
    }

    public final void setTextColor(int i) {
        this.button.setTextColor(i);
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
        updateIcon();
    }

    @Override // android.view.ViewGroup
    public final void addView(View child) {
        super.addView(child);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.button.measure(widthMeasureSpec, heightMeasureSpec);
        this.progress.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), this.progressSize), ViewGroup.getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), this.progressSize));
        setMeasuredDimension(View.resolveSize(Math.max(this.button.getMeasuredWidth(), this.progress.getMeasuredWidth()), widthMeasureSpec), View.resolveSize(Math.max(this.button.getMeasuredHeight(), this.progress.getMeasuredHeight()), heightMeasureSpec));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.button.layout(0, 0, getWidth(), getHeight());
        int width = (getWidth() - this.progress.getMeasuredWidth()) / 2;
        int height = (getHeight() - this.progress.getMeasuredHeight()) / 2;
        ProgressBar progressBar = this.progress;
        progressBar.layout(width, height, progressBar.getMeasuredWidth() + width, this.progress.getMeasuredHeight() + height);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener listener) {
        this.button.setOnClickListener(listener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener listener) {
        this.button.setOnLongClickListener(listener);
    }

    @Override // android.view.View
    public boolean hasOnClickListeners() {
        return this.button.hasOnClickListeners();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.button.setEnabled(enabled);
        this.progress.setEnabled(enabled);
    }

    public final void setText(int textRes) {
        setText(getContext().getResources().getText(textRes));
    }

    public final void showProgress(boolean show) {
        ViewExtensions.setVisible(this.progress, show);
        ViewExtensions.setVisible(this.button, !show);
    }

    public final void setSchemeColor(int color) {
        this.button.setTextColor(color);
        Drawable indeterminateDrawable = this.progress.getIndeterminateDrawable();
        Intrinsics.checkNotNullExpressionValue(indeterminateDrawable, "getIndeterminateDrawable(...)");
        DrawableExtensions.tint(indeterminateDrawable, color);
    }

    public final void setSchemeColor(ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        this.button.setTextColor(colorStateList);
        Drawable indeterminateDrawable = this.progress.getIndeterminateDrawable();
        Intrinsics.checkNotNullExpressionValue(indeterminateDrawable, "getIndeterminateDrawable(...)");
        DrawableExtensions.tint(indeterminateDrawable, colorStateList);
    }

    public final void setTextColor(ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.button.setTextColor(color);
    }

    public final void setButtonPadding(int left, int top, int right, int bottom) {
        this.button.setPadding(left, top, right, bottom);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateIcon() {
        /*
            r3 = this;
            android.content.res.ColorStateList r0 = r3.iconStateColor
            r1 = 0
            if (r0 == 0) goto L11
            android.graphics.drawable.Drawable r2 = r3.icon
            if (r2 == 0) goto Le
            android.graphics.drawable.Drawable r0 = ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions.tint(r2, r0)
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 != 0) goto L13
        L11:
            android.graphics.drawable.Drawable r0 = r3.icon
        L13:
            androidx.appcompat.widget.AppCompatButton r2 = r3.button
            r2.setCompoundDrawablesWithIntrinsicBounds(r0, r1, r1, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView.updateIcon():void");
    }

    private final ProgressBar createProgressBar(TypedArray typedArray) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_progressbar, (ViewGroup) this, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) viewInflate;
        int color = typedArray.getColor(R$styleable.ym_Button_ym_progress_color, ContextCompat.getColor(progressBar.getContext(), R$color.color_type_inverse));
        if (DeviceUtilKt.supportLollipop()) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(color));
        } else {
            Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
            Intrinsics.checkNotNullExpressionValue(indeterminateDrawable, "getIndeterminateDrawable(...)");
            DrawableExtensions.tint(indeterminateDrawable, color);
        }
        ViewExtensions.hide(progressBar);
        return progressBar;
    }
}
