package ru.yoomoney.sdk.gui.widget.form;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;

/* compiled from: FormSelectView.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u000f\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b$\u0010%¨\u0006."}, d2 = {"Lru/yoomoney/sdk/gui/widget/form/FormSelectView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrow", "Landroidx/appcompat/widget/AppCompatImageView;", "getArrow", "()Landroidx/appcompat/widget/AppCompatImageView;", "arrow$delegate", "Lkotlin/Lazy;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "iconTintColor", "getIconTintColor", "()I", "setIconTintColor", "(I)V", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "titleView$delegate", "getValue", "setValue", "valueView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getValueView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "valueView$delegate", "setEnabled", "", "enabled", "", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class FormSelectView extends ConstraintLayout {

    /* renamed from: arrow$delegate, reason: from kotlin metadata */
    private final Lazy arrow;
    private int iconTintColor;
    private CharSequence title;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;
    private CharSequence value;

    /* renamed from: valueView$delegate, reason: from kotlin metadata */
    private final Lazy valueView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FormSelectView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FormSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FormSelectView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleView = LazyKt.lazy(new Function0<TextCaption1View>() { // from class: ru.yoomoney.sdk.gui.widget.form.FormSelectView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextCaption1View invoke() {
                return (TextCaption1View) this.this$0.findViewById(R$id.title);
            }
        });
        this.valueView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widget.form.FormSelectView$valueView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.value);
            }
        });
        this.arrow = LazyKt.lazy(new Function0<AppCompatImageView>() { // from class: ru.yoomoney.sdk.gui.widget.form.FormSelectView$arrow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppCompatImageView invoke() {
                return (AppCompatImageView) this.this$0.findViewById(R$id.arrow);
            }
        });
        this.iconTintColor = GuiContextExtensions.getThemedColor(context, R$attr.colorTint);
        View.inflate(context, R$layout.view_form_select, this);
        setMinHeight(ViewExtensions.getDimensionPixelOffset(this, R$dimen.item_min_height_very_large));
        setBackground(AppCompatResources.getDrawable(context, R$drawable.bg_selectable_item));
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_ListItem, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setTitle(typedArrayObtainStyledAttributes.getString(R$styleable.ym_ListItem_ym_title));
        setValue(typedArrayObtainStyledAttributes.getString(R$styleable.ym_ListItem_ym_value));
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private final TextCaption1View getTitleView() {
        Object value = this.titleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextCaption1View) value;
    }

    private final TextBodyView getValueView() {
        Object value = this.valueView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextBodyView) value;
    }

    private final AppCompatImageView getArrow() {
        Object value = this.arrow.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AppCompatImageView) value;
    }

    public final CharSequence getTitle() {
        return getTitleView().getText();
    }

    public final void setTitle(CharSequence charSequence) {
        this.title = charSequence;
        getTitleView().setText(charSequence);
    }

    public final CharSequence getValue() {
        return getValueView().getText();
    }

    public final void setValue(CharSequence charSequence) {
        this.value = charSequence;
        getValueView().setText(charSequence);
    }

    public final int getIconTintColor() {
        return this.iconTintColor;
    }

    public final void setIconTintColor(int i) {
        this.iconTintColor = i;
        ImageViewCompat.setImageTintList(getArrow(), ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ViewExtensions.setVisible(getArrow(), enabled && hasOnClickListeners());
        getValueView().setEnabled(enabled);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        super.setOnClickListener(l);
        ViewExtensions.setVisible(getArrow(), l != null && isEnabled());
    }
}
