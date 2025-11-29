package ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large;

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
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
import ru.yoomoney.sdk.gui.widget.button.TagButtonView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasSubTitle;
import ru.yoomoney.sdk.gui.widgetV2.list.item_modifier.HasTitle;

/* compiled from: ItemTagLargeView.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010B\u001a\u00020CH\u0014J\u001a\u0010D\u001a\u00020C2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020GH\u0014J\u0018\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0014J\b\u0010K\u001a\u00020CH\u0014J\u0010\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020NH\u0016R\u001b\u0010\u000b\u001a\u00020\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010%\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R*\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b0\u00101R(\u00103\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R+\u00106\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010$\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R$\u0010:\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\b?\u0010@¨\u0006O"}, d2 = {"Lru/yoomoney/sdk/gui/widgetV2/list/item_tag_large/ItemTagLargeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasTitle;", "Lru/yoomoney/sdk/gui/widgetV2/list/item_modifier/HasSubTitle;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "iconContainer$delegate", "Lkotlin/Lazy;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "subTitle", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "subTitleView", "Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "getSubTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextCaption1View;", "subTitleView$delegate", "<set-?>", "subtitleAppearance", "getSubtitleAppearance", "()I", "setSubtitleAppearance", "(I)V", "subtitleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", RemoteMessageConst.Notification.TAG, "getTag", "setTag", "tagColor", "getTagColor", "()Ljava/lang/Integer;", "setTagColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tagView", "Lru/yoomoney/sdk/gui/widget/button/TagButtonView;", "getTagView", "()Lru/yoomoney/sdk/gui/widget/button/TagButtonView;", "tagView$delegate", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "setTitle", "titleAppearance", "getTitleAppearance", "setTitleAppearance", "titleAppearance$delegate", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "titleView$delegate", "inflate", "", "init", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onViewInflated", "setEnabled", "enabled", "", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ItemTagLargeView extends ConstraintLayout implements HasTitle, HasSubTitle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemTagLargeView.class, "titleAppearance", "getTitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ItemTagLargeView.class, "subtitleAppearance", "getSubtitleAppearance()I", 0))};

    /* renamed from: iconContainer$delegate, reason: from kotlin metadata */
    private final Lazy iconContainer;

    /* renamed from: subTitleView$delegate, reason: from kotlin metadata */
    private final Lazy subTitleView;

    /* renamed from: subtitleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty subtitleAppearance;
    private Integer tagColor;

    /* renamed from: tagView$delegate, reason: from kotlin metadata */
    private final Lazy tagView;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;
    private int titleMaxLines;

    /* renamed from: titleView$delegate, reason: from kotlin metadata */
    private final Lazy titleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemTagLargeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected void onViewInflated() {
    }

    public /* synthetic */ ItemTagLargeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemTagLargeView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleView = LazyKt.lazy(new Function0<TextBodyView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemTagLargeView$titleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextBodyView invoke() {
                return (TextBodyView) this.this$0.findViewById(R$id.title);
            }
        });
        this.tagView = LazyKt.lazy(new Function0<TagButtonView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemTagLargeView$tagView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TagButtonView invoke() {
                return (TagButtonView) this.this$0.findViewById(R$id.tag);
            }
        });
        this.subTitleView = LazyKt.lazy(new Function0<TextCaption1View>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemTagLargeView$subTitleView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TextCaption1View invoke() {
                return (TextCaption1View) this.this$0.findViewById(R$id.sub_title);
            }
        });
        this.iconContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemTagLargeView$iconContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R$id.left_image_container);
            }
        });
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemTagLargeView$titleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.subtitleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemTagLargeView$subtitleAppearance$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final TextBodyView getTitleView() {
        Object value = this.titleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextBodyView) value;
    }

    private final TagButtonView getTagView() {
        Object value = this.tagView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TagButtonView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextCaption1View getSubTitleView() {
        Object value = this.subTitleView.getValue();
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

    @Override // android.view.View
    public final CharSequence getTag() {
        return getTagView().getText();
    }

    public final void setTag(CharSequence charSequence) {
        TextViewExtensions.setTextAndVisibility(getTagView(), charSequence);
    }

    public final Integer getTagColor() {
        return this.tagColor;
    }

    public final void setTagColor(Integer num) {
        if (num != null) {
            getTagView().setTextColor(num.intValue());
        }
        this.tagColor = num;
    }

    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_item_tag_l, this);
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

    protected void obtainAttrs(TypedArray a) {
        Intrinsics.checkNotNullParameter(a, "a");
        setTitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_TitleTextAppearance, -1));
        setSubtitleAppearance(a.getResourceId(R$styleable.ym_ListItem_ym_SubtitleTextAppearance, -1));
        setTitleMaxLines(a.getInt(R$styleable.ym_ListItem_ym_title_maxLines, 2));
        setTitle(a.getText(R$styleable.ym_ListItem_ym_title));
        setSubTitle(a.getText(R$styleable.ym_ListItem_ym_subtitle));
        setTag(a.getText(R$styleable.ym_ListItem_ym_buttonText));
        setEnabled(a.getBoolean(R$styleable.ym_ListItem_ym_item_enabled, true));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getTagView().setEnabled(enabled);
        float f = enabled ? 1.0f : 0.3f;
        getTitleView().setAlpha(f);
        getSubTitleView().setAlpha(f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getTagView().setMaxWidth(View.MeasureSpec.getSize(widthMeasureSpec) / 3);
    }
}
