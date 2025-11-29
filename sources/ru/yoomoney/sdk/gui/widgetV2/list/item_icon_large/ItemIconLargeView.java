package ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large;

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
import ru.yoomoney.sdk.gui.utils.extensions.TextViewExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.utils.properties.TextAppearanceProperty;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasRightIcon;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;

/* compiled from: ItemIconLargeView.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010F\u001a\u00020GH\u0014J\u001a\u0010H\u001a\u00020G2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u00020KH\u0014J\b\u0010L\u001a\u00020GH\u0014J\u0010\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020OH\u0016J\u0014\u0010P\u001a\u00020G2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020G0RR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\f\u001a\u0004\u0018\u00010$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b,\u0010-R+\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00107\u001a\u0004\u0018\u00010$2\b\u0010\f\u001a\u0004\u0018\u00010$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u0010'\"\u0004\b9\u0010)R+\u0010:\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b=\u00106\u001a\u0004\b;\u00102\"\u0004\b<\u00104R$\u0010>\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00102\"\u0004\b@\u00104R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bC\u0010D¨\u0006S"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_icon_large/ItemIconLargeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasSubTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasRightIcon;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Landroid/graphics/drawable/Drawable;", RemoteMessageConst.Notification.ICON, "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "iconContainer$delegate", "Lkotlin/Lazy;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "iconView$delegate", "Landroid/content/res/ColorStateList;", "rightIconTint", "getRightIconTint", "()Landroid/content/res/ColorStateList;", "setRightIconTint", "(Landroid/content/res/ColorStateList;)V", "", "subTitle", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "subTitleView", "Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "getSubTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "subTitleView$delegate", "<set-?>", "subtitleAppearance", "getSubtitleAppearance", "()I", "setSubtitleAppearance", "(I)V", "subtitleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "setTitle", "titleAppearance", "getTitleAppearance", "setTitleAppearance", "titleAppearance$delegate", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "titleView$delegate", "inflate", "", "init", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onViewInflated", "setEnabled", "enabled", "", "setRightIconClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemIconLargeView extends ConstraintLayout implements HasTitle, HasSubTitle, HasRightIcon {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemIconLargeView.class, "titleAppearance", "getTitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemIconLargeView.class, "subtitleAppearance", "getSubtitleAppearance()I", 0))};

    /* renamed from: iconContainer$delegate, reason: from kotlin metadata */
    private final Lazy iconContainer;

    /* renamed from: iconView$delegate, reason: from kotlin metadata */
    private final Lazy iconView;
    private ColorStateList rightIconTint;

    /* renamed from: subTitleView$delegate, reason: from kotlin metadata */
    private final Lazy subTitleView;

    /* renamed from: subtitleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty subtitleAppearance;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;
    private int titleMaxLines;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;

    protected void onViewInflated() {
    }

    public /* synthetic */ ItemIconLargeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemIconLarge_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemIconLargeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconView = LazyKt.lazy(new Function0<AppCompatImageView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$iconView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppCompatImageView invoke() {
                return (AppCompatImageView) this.this$0.findViewById(R$id.icon);
            }
        });
        this.subTitleView = LazyKt.lazy(new Function0<TextCaption1View>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$subTitleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextCaption1View invoke() {
                return (TextCaption1View) this.this$0.findViewById(R$id.sub_title);
            }
        });
        this.titleView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.title);
            }
        });
        this.iconContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$iconContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R$id.left_image_container);
            }
        });
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$titleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.subtitleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$subtitleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getSubTitleView();
            }
        });
        this.titleMaxLines = 2;
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
    public final TextCaption1View getSubTitleView() {
        Object value = this.subTitleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextCaption1View) value;
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

    public int getSubtitleAppearance() {
        return this.subtitleAppearance.getValue((Object) this, $$delegatedProperties[1]).intValue();
    }

    public void setSubtitleAppearance(int i) {
        this.subtitleAppearance.setValue(this, $$delegatedProperties[1], i);
    }

    public CharSequence getTitle() {
        return getTitleView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle
    public void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public CharSequence getSubTitle() {
        return getSubTitleView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubTitle
    public void setSubTitle(CharSequence charSequence) {
        TextViewExtensions.setTextAndVisibility(getSubTitleView(), charSequence);
    }

    public final int getTitleMaxLines() {
        return this.titleMaxLines;
    }

    public final void setTitleMaxLines(int i) {
        this.titleMaxLines = i;
        TextBodyView titleView = getTitleView();
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        titleView.setMaxLines(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRightIconClickListener$lambda$0(Function0 listener, View view) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.invoke();
    }

    public final void setRightIconClickListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getIconView().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_icon_large.ItemIconLargeView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemIconLargeView.setRightIconClickListener$lambda$0(listener, view);
            }
        });
    }

    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_item_icon_l, this);
    }

    protected void init(AttributeSet attrs, int defStyleAttr) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(getResources().getDimensionPixelSize(R$dimen.item_min_height_very_large));
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R$styleable.ym_ListItem, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        obtainAttrs(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setTitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_TitleTextAppearance, -1));
        setSubtitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_SubtitleTextAppearance, -1));
        setTitleMaxLines(a.getInt(R$styleable.ym_ListItem_ym_title_maxLines, 2));
        setTitle(a.getText(R$styleable.ym_ListItem_ym_title));
        setSubTitle(a.getText(R$styleable.ym_ListItem_ym_subtitle));
        setIcon(a.getDrawable(R$styleable.ym_ListItem_ym_rightIcon));
        setRightIconTint(a.getColorStateList(R$styleable.ym_ListItem_ym_rightIconTintColor));
        setEnabled(a.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getIconView().setEnabled(enabled);
        float f = enabled ? 1.0f : 0.3f;
        getTitleView().setAlpha(f);
        getSubTitleView().setAlpha(f);
    }
}
