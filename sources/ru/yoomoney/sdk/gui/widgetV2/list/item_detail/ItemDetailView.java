package ru.yoomoney.sdk.gui.widgetV2.list.item_detail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import ru.yoomoney.sdk.gui.utils.properties.TextAppearanceProperty;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasValue;

/* compiled from: ItemDetailView.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00101\u001a\u000202H\u0014J\u001a\u00103\u001a\u0002022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u00104\u001a\u0002022\u0006\u00105\u001a\u000206H\u0014J\u0018\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0014J\b\u0010:\u001a\u000202H\u0014J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=H\u0016R\u001b\u0010\u000b\u001a\u00020\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&R(\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R+\u0010*\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001f\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001b\u0010.\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b/\u0010&¨\u0006>"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_detail/ItemDetailView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasValue;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "iconContainer$delegate", "Lkotlin/Lazy;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "<set-?>", "titleAppearance", "getTitleAppearance", "()I", "setTitleAppearance", "(I)V", "titleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "titleView$delegate", "getValue", "setValue", "valueAppearance", "getValueAppearance", "setValueAppearance", "valueAppearance$delegate", "valueView", "getValueView", "valueView$delegate", "inflate", "", "init", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onViewInflated", "setEnabled", "enabled", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemDetailView extends ConstraintLayout implements HasTitle, HasValue {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemDetailView.class, "titleAppearance", "getTitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemDetailView.class, "valueAppearance", "getValueAppearance()I", 0))};

    /* renamed from: iconContainer$delegate, reason: from kotlin metadata */
    private final Lazy iconContainer;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;
    private int titleMaxLines;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;

    /* renamed from: valueAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty valueAppearance;

    /* renamed from: valueView$delegate, reason: from kotlin metadata */
    private final Lazy valueView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemDetailView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ItemDetailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemDetailView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.title);
            }
        });
        this.valueView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemDetailView$valueView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.value);
            }
        });
        this.iconContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemDetailView$iconContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R$id.left_image_container);
            }
        });
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemDetailView$titleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.valueAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_detail.ItemDetailView$valueAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getValueView();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final TextBodyView getValueView() {
        Object value = this.valueView.getValue();
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

    public int getValueAppearance() {
        return this.valueAppearance.getValue((Object) this, $$delegatedProperties[1]).intValue();
    }

    public void setValueAppearance(int i) {
        this.valueAppearance.setValue(this, $$delegatedProperties[1], i);
    }

    public CharSequence getTitle() {
        return getTitleView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle
    public void setTitle(CharSequence charSequence) {
        getTitleView().setText(charSequence);
    }

    public CharSequence getValue() {
        return getValueView().getText();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasValue
    public void setValue(CharSequence charSequence) {
        getValueView().setText(charSequence);
    }

    public final int getTitleMaxLines() {
        return this.titleMaxLines;
    }

    public final void setTitleMaxLines(int i) {
        getTitleView().setMaxLines(i > 0 ? i : Integer.MAX_VALUE);
        this.titleMaxLines = i;
    }

    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_item_detail, this);
    }

    protected void onViewInflated() {
        if (getId() == -1) {
            setId(View.generateViewId());
        }
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

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        float f = enabled ? 1.0f : 0.3f;
        getTitleView().setAlpha(f);
        getValueView().setAlpha(f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getValueView().setMaxWidth(View.MeasureSpec.getSize(widthMeasureSpec) / 2);
    }

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setTitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_TitleTextAppearance, -1));
        setValueAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_ValueTextAppearance, -1));
        setTitle(a.getText(R$styleable.ym_ListItem_ym_title));
        setValue(a.getText(R$styleable.ym_ListItem_ym_value));
        setTitleMaxLines(a.getInt(R$styleable.ym_ListItem_ym_title_maxLines, 1));
        setEnabled(a.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
    }
}
