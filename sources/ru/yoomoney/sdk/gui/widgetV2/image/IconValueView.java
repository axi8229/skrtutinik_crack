package ru.yoomoney.sdk.gui.widgetV2.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.drawable.TextDrawable;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.color.ColorStateSetKt;

/* compiled from: IconValueView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/image/IconValueView;", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "Landroid/content/res/ColorStateList;", "getBackgroundColor", "()Landroid/content/res/ColorStateList;", "imageColor", "getImageColor", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "getValue", "()Ljava/lang/CharSequence;", "setValue", "(Ljava/lang/CharSequence;)V", "initValue", "Landroid/graphics/drawable/Drawable;", "obtainAttrs", "", "a", "Landroid/content/res/TypedArray;", "resolveTintImage", "setEnabled", "enabled", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class IconValueView extends AbstractIconImageView {
    private final ColorStateList backgroundColor;
    private CharSequence value;

    public /* synthetic */ IconValueView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListVectorView_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconValueView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CharSequence getValue() {
        return this.value;
    }

    public final void setValue(CharSequence charSequence) {
        this.value = charSequence;
        setImage(initValue(charSequence));
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected ColorStateList getImageColor() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ColorStateSetKt.getLinkTextColorState(context);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected ColorStateList getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setValue(a.getText(R$styleable.ym_ListImageView_ym_image_value));
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setImage(initValue(this.value));
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView
    protected Drawable resolveTintImage() {
        return initValue(this.value);
    }

    private final Drawable initValue(CharSequence value) throws Resources.NotFoundException {
        float dimension = getResources().getDimension(R$dimen.ym_text_caption1);
        ColorStateList imageTintColor = getImageTintColor();
        return new TextDrawable(value, dimension, imageTintColor != null ? Integer.valueOf(getColorByState(imageTintColor)) : null, Typeface.create("sans-serif-medium", 0));
    }
}
