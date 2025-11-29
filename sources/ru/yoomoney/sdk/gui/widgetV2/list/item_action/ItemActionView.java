package ru.yoomoney.sdk.gui.widgetV2.list.item_action;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.utils.properties.TextAppearanceProperty;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;

/* compiled from: ItemActionView.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010,\u001a\u00020-H\u0014J\u001a\u0010.\u001a\u00020-2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u00020-H\u0014J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010$\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000f\u001a\u0004\b)\u0010*¨\u00069"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_action/ItemActionView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasTitle;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "action", "Landroidx/appcompat/widget/AppCompatImageView;", "getAction", "()Landroidx/appcompat/widget/AppCompatImageView;", "action$delegate", "Lkotlin/Lazy;", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "iconContainer$delegate", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "<set-?>", "titleAppearance", "getTitleAppearance", "()I", "setTitleAppearance", "(I)V", "titleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "titleView$delegate", "inflate", "", "init", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onViewInflated", "setEnabled", "enabled", "", "setOnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemActionView extends ConstraintLayout implements HasTitle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemActionView.class, "titleAppearance", "getTitleAppearance()I", 0))};

    /* renamed from: action$delegate, reason: from kotlin metadata */
    private final Lazy action;

    /* renamed from: iconContainer$delegate, reason: from kotlin metadata */
    private final Lazy iconContainer;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;
    private int titleMaxLines;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected void onViewInflated() {
    }

    public /* synthetic */ ItemActionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ListItemAction_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_action.ItemActionView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.title);
            }
        });
        this.action = LazyKt.lazy(new Function0<AppCompatImageView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_action.ItemActionView$action$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppCompatImageView invoke() {
                return (AppCompatImageView) this.this$0.findViewById(R$id.action);
            }
        });
        this.iconContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_action.ItemActionView$iconContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R$id.left_image_container);
            }
        });
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_action.ItemActionView$titleAppearance$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final TextBodyView getTitleView() {
        Object value = this.titleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextBodyView) value;
    }

    private final AppCompatImageView getAction() {
        Object value = this.action.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AppCompatImageView) value;
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

    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_item_action, this);
    }

    protected void init(AttributeSet attrs, int defStyleAttr) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(getResources().getDimensionPixelSize(R$dimen.item_min_height_normal));
        setBackground(AppCompatResources.getDrawable(getContext(), R$drawable.bg_selectable_item));
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R$styleable.ym_ListItem, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        obtainAttrs(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setTitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_TitleTextAppearance, -1));
        setTitle(a.getText(R$styleable.ym_ListItem_ym_title));
        setTitleMaxLines(a.getInt(R$styleable.ym_ListItem_ym_title_maxLines, 1));
        setEnabled(a.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
        ImageViewCompat.setImageTintList(getAction(), a.getColorStateList(R$styleable.ym_ListItem_ym_rightIconTintColor));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ViewExtensions.setVisible(getAction(), hasOnClickListeners() & enabled);
        getTitleView().setAlpha(enabled ? 1.0f : 0.3f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener listener) {
        super.setOnClickListener(listener);
        ViewExtensions.setVisible(getAction(), isEnabled() && listener != null);
        setClickable(listener != null);
    }
}
