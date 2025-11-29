package ru.yoomoney.sdk.gui.widgetV2.list.item_icon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.utils.properties.TextAppearanceProperty;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasRightIcon;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;

/* compiled from: ItemIconView.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00109\u001a\u00020:H\u0014J\u001a\u0010;\u001a\u00020:2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020:H\u0014J\u0010\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020BH\u0016J\u0014\u0010C\u001a\u00020:2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020:0ER(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001d@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u000b\u001a\u0004\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00101\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0017\u001a\u0004\b6\u00107¨\u0006F"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_icon/ItemIconView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasRightIcon;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroid/graphics/drawable/Drawable;", RemoteMessageConst.Notification.ICON, "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "iconContainer$delegate", "Lkotlin/Lazy;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "iconView$delegate", "Landroid/content/res/ColorStateList;", "rightIconTint", "getRightIconTint", "()Landroid/content/res/ColorStateList;", "setRightIconTint", "(Landroid/content/res/ColorStateList;)V", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "<set-?>", "titleAppearance", "getTitleAppearance", "()I", "setTitleAppearance", "(I)V", "titleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "titleView$delegate", "inflate", "", "init", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onViewInflated", "setEnabled", "enabled", "", "setRightIconClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemIconView extends ConstraintLayout implements HasTitle, HasRightIcon {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemIconView.class, "titleAppearance", "getTitleAppearance()I", 0))};

    /* renamed from: iconContainer$delegate, reason: from kotlin metadata */
    private final Lazy iconContainer;

    /* renamed from: iconView$delegate, reason: from kotlin metadata */
    private final Lazy iconView;
    private ColorStateList rightIconTint;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;
    private int titleMaxLines;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;

    protected void onViewInflated() {
    }

    public /* synthetic */ ItemIconView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemIcon_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconView = LazyKt.lazy(new Function0<AppCompatImageView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView$iconView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppCompatImageView invoke() {
                return (AppCompatImageView) this.this$0.findViewById(R$id.icon);
            }
        });
        this.titleView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.title);
            }
        });
        this.iconContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView$iconContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R$id.left_image_container);
            }
        });
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView$titleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.titleMaxLines = 1;
        inflate();
        onViewInflated();
        init(attributeSet, i);
    }

    private final AppCompatImageView getIconView() {
        Object value = this.iconView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AppCompatImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextBodyView getTitleView() {
        Object value = this.titleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextBodyView) value;
    }

    protected final FrameLayout getIconContainer() {
        Object value = this.iconContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FrameLayout) value;
    }

    public int getTitleAppearance() {
        return this.titleAppearance.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle
    public void setTitleAppearance(int i) {
        this.titleAppearance.setValue(this, $$delegatedProperties[0], i);
    }

    public CharSequence getTitle() {
        return getTitleView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle
    public void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public Drawable getIcon() {
        return getIconView().getDrawable();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasRightIcon
    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            DrawableExtensions.tint(drawable, getRightIconTint());
        }
        ViewExtensions.setVisible(getIconView(), drawable != null);
        getIconView().setImageDrawable(drawable);
    }

    public ColorStateList getRightIconTint() {
        return this.rightIconTint;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasRightIcon
    public void setRightIconTint(ColorStateList colorStateList) {
        this.rightIconTint = colorStateList;
        Drawable icon = getIcon();
        if (icon != null) {
            DrawableExtensions.tint(icon, colorStateList);
        }
    }

    public final int getTitleMaxLines() {
        return this.titleMaxLines;
    }

    public final void setTitleMaxLines(int i) {
        getTitleView().setMaxLines(i > 0 ? i : Integer.MAX_VALUE);
        this.titleMaxLines = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRightIconClickListener$lambda$0(Function0 listener, View view) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.invoke();
    }

    public final void setRightIconClickListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getIconView().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon.ItemIconView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemIconView.setRightIconClickListener$lambda$0(listener, view);
            }
        });
    }

    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_item_icon, this);
    }

    protected void init(AttributeSet attrs, int defStyleAttr) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(getResources().getDimensionPixelSize(R$dimen.item_min_height_normal));
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R$styleable.ym_ListItem, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        obtainAttrs(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setTitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_TitleTextAppearance, -1));
        setTitle(a.getText(R$styleable.ym_ListItem_ym_title));
        setIcon(a.getDrawable(R$styleable.ym_ListItem_ym_rightIcon));
        setRightIconTint(a.getColorStateList(R$styleable.ym_ListItem_ym_rightIconTintColor));
        setTitleMaxLines(a.getInt(R$styleable.ym_ListItem_ym_title_maxLines, 1));
        setEnabled(a.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getIconView().setEnabled(enabled);
        getTitleView().setAlpha(enabled ? 1.0f : 0.3f);
    }
}
