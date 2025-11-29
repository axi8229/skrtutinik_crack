package ru.yoomoney.sdk.gui.widget.state_screen;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.TypedArrayExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.utils.properties.TextAppearanceProperty;
import ru.yoomoney.sdk.gui.utils.properties.TextValueProperty;
import ru.yoomoney.sdk.gui.widget.button.FlatButtonView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle3View;
import ru.yoomoney.sdk.gui.widgetV2.image.AbstractIconImageView;

/* compiled from: EmptyStateLargeView.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010<\u001a\u00020\u0012H\u0014J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020\u0012H\u0014J\u0010\u0010A\u001a\u00020\u00122\b\b\u0001\u0010B\u001a\u00020\u0007R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR/\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR+\u0010%\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R/\u00100\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010$\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR+\u00104\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010+\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lru/yoomoney/sdk/gui/widget/state_screen/EmptyStateLargeView;", "Lru/yoomoney/sdk/gui/widget/state_screen/AbstractStateView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "action", "getAction", "()Ljava/lang/CharSequence;", "setAction", "(Ljava/lang/CharSequence;)V", "actionListener", "Lkotlin/Function0;", "", "getActionListener", "()Lkotlin/jvm/functions/Function0;", "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "actionView", "Lru/yoomoney/sdk/gui/widget/button/FlatButtonView;", "getActionView", "()Lru/yoomoney/sdk/gui/widget/button/FlatButtonView;", "iconView", "Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "getIconView", "()Lru/yoomoney/sdk/gui/widgetV2/image/AbstractIconImageView;", "<set-?>", "subtitle", "getSubtitle", "setSubtitle", "subtitle$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextValueProperty;", "subtitleAppearance", "getSubtitleAppearance", "()I", "setSubtitleAppearance", "(I)V", "subtitleAppearance$delegate", "Lru/yoomoney/sdk/gui/utils/properties/TextAppearanceProperty;", "subtitleView", "Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", "getSubtitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextBodyView;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "setTitle", "title$delegate", "titleAppearance", "getTitleAppearance", "setTitleAppearance", "titleAppearance$delegate", "titleView", "Lru/yoomoney/sdk/gui/widget/text/TextTitle3View;", "getTitleView", "()Lru/yoomoney/sdk/gui/widget/text/TextTitle3View;", "inflate", "obtainAttrs", "a", "Landroid/content/res/TypedArray;", "onViewInflated", "setActionTextColor", RemoteMessageConst.Notification.COLOR, "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class EmptyStateLargeView extends AbstractStateView {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(EmptyStateLargeView.class, "titleAppearance", "getTitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(EmptyStateLargeView.class, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle()Ljava/lang/CharSequence;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(EmptyStateLargeView.class, "subtitleAppearance", "getSubtitleAppearance()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(EmptyStateLargeView.class, "subtitle", "getSubtitle()Ljava/lang/CharSequence;", 0))};
    private CharSequence action;
    private Function0<Unit> actionListener;

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final TextValueProperty subtitle;

    /* renamed from: subtitleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty subtitleAppearance;

    /* renamed from: title$delegate, reason: from kotlin metadata */
    private final TextValueProperty title;

    /* renamed from: titleAppearance$delegate, reason: from kotlin metadata */
    private final TextAppearanceProperty titleAppearance;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateLargeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateLargeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EmptyStateLargeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_StateEmptyLarge_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateLargeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView$titleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.title = new TextValueProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView$title$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getTitleView();
            }
        });
        this.subtitleAppearance = new TextAppearanceProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView$subtitleAppearance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getSubtitleView();
            }
        });
        this.subtitle = new TextValueProperty(new Function0<TextView>() { // from class: ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView$subtitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return this.this$0.getSubtitleView();
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_State, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        obtainAttrs(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextTitle3View getTitleView() {
        View viewFindViewById = findViewById(R$id.title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return (TextTitle3View) viewFindViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextBodyView getSubtitleView() {
        View viewFindViewById = findViewById(R$id.subtitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return (TextBodyView) viewFindViewById;
    }

    private final FlatButtonView getActionView() {
        View viewFindViewById = findViewById(R$id.action);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return (FlatButtonView) viewFindViewById;
    }

    public final int getTitleAppearance() {
        return this.titleAppearance.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    public final void setTitleAppearance(int i) {
        this.titleAppearance.setValue(this, $$delegatedProperties[0], i);
    }

    public final CharSequence getTitle() {
        return this.title.getValue((Object) this, $$delegatedProperties[1]);
    }

    public final void setTitle(CharSequence charSequence) {
        this.title.setValue2((Object) this, $$delegatedProperties[1], charSequence);
    }

    public final int getSubtitleAppearance() {
        return this.subtitleAppearance.getValue((Object) this, $$delegatedProperties[2]).intValue();
    }

    public final void setSubtitleAppearance(int i) {
        this.subtitleAppearance.setValue(this, $$delegatedProperties[2], i);
    }

    public final CharSequence getSubtitle() {
        return this.subtitle.getValue((Object) this, $$delegatedProperties[3]);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.subtitle.setValue2((Object) this, $$delegatedProperties[3], charSequence);
    }

    @Override // ru.yoomoney.sdk.gui.widget.state_screen.AbstractStateView
    protected AbstractIconImageView getIconView() {
        View viewFindViewById = findViewById(R$id.icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return (AbstractIconImageView) viewFindViewById;
    }

    public final CharSequence getAction() {
        return this.action;
    }

    public final void setAction(CharSequence charSequence) {
        Unit unit;
        this.action = charSequence;
        FlatButtonView actionView = getActionView();
        if (charSequence != null) {
            ViewExtensions.show(actionView);
            actionView.setText(charSequence);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ViewExtensions.hide(actionView);
        }
    }

    public final void setActionTextColor(int color) {
        FlatButtonView actionView = getActionView();
        actionView.setIconStateColor(ColorStateList.valueOf(color));
        actionView.setTextColor(color);
    }

    public final Function0<Unit> getActionListener() {
        return this.actionListener;
    }

    public final void setActionListener(Function0<Unit> function0) {
        this.actionListener = function0;
    }

    @Override // ru.yoomoney.sdk.gui.widget.state_screen.AbstractStateView
    protected void inflate() {
        View.inflate(getContext(), R$layout.ym_gui_empty_state_large_view, this);
    }

    private final void obtainAttrs(TypedArray a) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setIcon(TypedArrayExtensions.getStyleableDrawable(a, context, R$styleable.ym_State_ym_state_icon));
        setTitleAppearance(a.getResourceId(R$styleable.ym_State_ym_StateTitleAppearance, -1));
        setTitle(a.getString(R$styleable.ym_State_ym_state_title));
        setSubtitleAppearance(a.getResourceId(R$styleable.ym_State_ym_StateSubtitleAppearance, -1));
        setSubtitle(a.getString(R$styleable.ym_State_ym_state_subtitle));
        setAction(a.getString(R$styleable.ym_State_ym_state_action));
    }

    @Override // ru.yoomoney.sdk.gui.widget.state_screen.AbstractStateView
    protected void onViewInflated() {
        getActionView().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmptyStateLargeView.onViewInflated$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewInflated$lambda$3(EmptyStateLargeView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.actionListener;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
