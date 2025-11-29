package ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
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
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.TextViewExtensions;
import ru.yoomoney.sdk.gui.utils.properties.TextAppearanceProperty;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubValue;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasValue;

/* compiled from: ItemDetailLargeView.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B%\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010I\u001a\u00020JH\u0014J\u001a\u0010K\u001a\u00020J2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020NH\u0014J\u0018\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000bH\u0014J\b\u0010R\u001a\u00020JH\u0014J\u0010\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020UH\u0016J\u000e\u0010V\u001a\u00020J2\u0006\u0010W\u001a\u00020XJ\b\u0010Y\u001a\u00020JH\u0002R\u001b\u0010\r\u001a\u00020\u000e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001b\u0010'\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b(\u0010\"R+\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR+\u00100\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR(\u00104\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R+\u00107\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010/\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0012\u001a\u0004\b=\u0010>R(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R+\u0010B\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010/\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\u001b\u0010F\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0012\u001a\u0004\bG\u0010>¨\u0006Z"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_detail_large/ItemDetailLargeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasSubTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasValue;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasSubValue;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "iconContainer$delegate", "Lkotlin/Lazy;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "subTitle", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "subTitleMaxLines", "getSubTitleMaxLines", "()I", "setSubTitleMaxLines", "(I)V", "subTitleView", "Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "getSubTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "subTitleView$delegate", "subValue", "getSubValue", "setSubValue", "subValueView", "getSubValueView", "subValueView$delegate", "<set-?>", "subtitleAppearance", "getSubtitleAppearance", "setSubtitleAppearance", "subtitleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", "subvalueAppearance", "getSubvalueAppearance", "setSubvalueAppearance", "subvalueAppearance$delegate", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "setTitle", "titleAppearance", "getTitleAppearance", "setTitleAppearance", "titleAppearance$delegate", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "titleView$delegate", "getValue", "setValue", "valueAppearance", "getValueAppearance", "setValueAppearance", "valueAppearance$delegate", "valueView", "getValueView", "valueView$delegate", "inflate", "", "init", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onViewInflated", "setEnabled", "enabled", "", "setValueContentDescription", "contentDescription", "", "updateConstraints", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemDetailLargeView extends ConstraintLayout implements HasTitle, HasSubTitle, HasValue, HasSubValue {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemDetailLargeView.class, "titleAppearance", "getTitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemDetailLargeView.class, "subtitleAppearance", "getSubtitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemDetailLargeView.class, "valueAppearance", "getValueAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemDetailLargeView.class, "subvalueAppearance", "getSubvalueAppearance()I", 0))};

    /* renamed from: iconContainer$delegate, reason: from kotlin metadata */
    private final Lazy iconContainer;
    private int subTitleMaxLines;

    /* renamed from: subTitleView$delegate, reason: from kotlin metadata */
    private final Lazy subTitleView;

    /* renamed from: subValueView$delegate, reason: from kotlin metadata */
    private final Lazy subValueView;

    /* renamed from: subtitleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty subtitleAppearance;

    /* renamed from: subvalueAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty subvalueAppearance;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;

    /* renamed from: valueAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty valueAppearance;

    /* renamed from: valueView$delegate, reason: from kotlin metadata */
    private final Lazy valueView;

    public /* synthetic */ ItemDetailLargeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemDetailLargeView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.title);
            }
        });
        this.valueView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$valueView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.value);
            }
        });
        this.subTitleView = LazyKt.lazy(new Function0<TextCaption1View>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$subTitleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextCaption1View invoke() {
                return (TextCaption1View) this.this$0.findViewById(R$id.sub_title);
            }
        });
        this.subValueView = LazyKt.lazy(new Function0<TextCaption1View>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$subValueView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextCaption1View invoke() {
                return (TextCaption1View) this.this$0.findViewById(R$id.sub_value);
            }
        });
        this.iconContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$iconContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R$id.left_image_container);
            }
        });
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$titleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.subtitleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$subtitleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getSubTitleView();
            }
        });
        this.valueAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$valueAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getValueView();
            }
        });
        this.subvalueAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail_large.ItemDetailLargeView$subvalueAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getSubValueView();
            }
        });
        this.subTitleMaxLines = 1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final TextBodyView getValueView() {
        Object value = this.valueView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextBodyView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextCaption1View getSubTitleView() {
        Object value = this.subTitleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextCaption1View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextCaption1View getSubValueView() {
        Object value = this.subValueView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextCaption1View) value;
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

    public int getValueAppearance() {
        return this.valueAppearance.getValue((Object) this, $$delegatedProperties[2]).intValue();
    }

    public void setValueAppearance(int i) {
        this.valueAppearance.setValue(this, $$delegatedProperties[2], i);
    }

    public int getSubvalueAppearance() {
        return this.subvalueAppearance.getValue((Object) this, $$delegatedProperties[3]).intValue();
    }

    public void setSubvalueAppearance(int i) {
        this.subvalueAppearance.setValue(this, $$delegatedProperties[3], i);
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
        updateConstraints();
    }

    public CharSequence getValue() {
        return getValueView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasValue
    public void setValue(CharSequence charSequence) {
        getValueView().setText(charSequence);
    }

    public CharSequence getSubValue() {
        return getSubValueView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubValue
    public void setSubValue(CharSequence charSequence) {
        TextViewExtensions.setTextAndVisibility(getSubValueView(), charSequence);
        updateConstraints();
    }

    public final int getSubTitleMaxLines() {
        return this.subTitleMaxLines;
    }

    public final void setSubTitleMaxLines(int i) {
        this.subTitleMaxLines = i;
        TextCaption1View subTitleView = getSubTitleView();
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        subTitleView.setMaxLines(i);
    }

    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_item_detail_l, this);
    }

    protected void onViewInflated() {
        if (getId() == -1) {
            setId(View.generateViewId());
        }
    }

    protected void init(AttributeSet attrs, int defStyleAttr) throws Resources.NotFoundException {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(getResources().getDimensionPixelSize(R$dimen.item_min_height_very_large));
        setBackground(AppCompatResources.getDrawable(getContext(), R$drawable.bg_selectable_item));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ym_spaceM);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R$styleable.ym_ListItem, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        obtainAttrs(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        float f = enabled ? 1.0f : 0.3f;
        getTitleView().setAlpha(f);
        getSubTitleView().setAlpha(f);
        getValueView().setAlpha(f);
        getSubValueView().setAlpha(f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getValueView().setMaxWidth(View.MeasureSpec.getSize(widthMeasureSpec) / 2);
        getSubValueView().setMaxWidth(View.MeasureSpec.getSize(widthMeasureSpec) / 2);
    }

    public final void setValueContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        getValueView().setContentDescription(contentDescription);
    }

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setTitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_TitleTextAppearance, -1));
        setSubtitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_SubtitleTextAppearance, -1));
        setValueAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_ValueTextAppearance, -1));
        setSubvalueAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_SubvalueTextAppearance, -1));
        setSubTitleMaxLines(a.getInt(R$styleable.ym_ListItem_ym_subtitle_maxLines, 1));
        setTitle(a.getText(R$styleable.ym_ListItem_ym_title));
        setSubTitle(a.getText(R$styleable.ym_ListItem_ym_subtitle));
        setValue(a.getText(R$styleable.ym_ListItem_ym_value));
        setSubValue(a.getText(R$styleable.ym_ListItem_ym_subvalue));
        setEnabled(a.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
    }

    private final void updateConstraints() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.clear(getTitleView().getId(), 3);
        constraintSet.clear(getTitleView().getId(), 4);
        if (getSubTitleView().getVisibility() == 8 && getSubValueView().getVisibility() == 8) {
            constraintSet.connect(getTitleView().getId(), 3, getId(), 3);
            constraintSet.connect(getTitleView().getId(), 4, getId(), 4);
        }
        constraintSet.applyTo(this);
    }
}
