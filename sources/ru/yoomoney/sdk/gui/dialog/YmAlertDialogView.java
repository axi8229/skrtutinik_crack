package ru.yoomoney.sdk.gui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.widget.button.FlatAlertButtonView;
import ru.yoomoney.sdk.gui.widget.button.FlatButtonView;

/* compiled from: YmAlertDialogView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0014R\u0011\u0010\u0007\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/gui/dialog/YmAlertDialogView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "additionalContentView", "getAdditionalContentView", "()Landroid/widget/FrameLayout;", "adjustedWidth", "", "buttonNegative", "Lru/yoomoney/sdk/gui/widget/button/FlatButtonView;", "getButtonNegative", "()Lru/yoomoney/sdk/gui/widget/button/FlatButtonView;", "buttonNegativeAlert", "Lru/yoomoney/sdk/gui/widget/button/FlatAlertButtonView;", "getButtonNegativeAlert", "()Lru/yoomoney/sdk/gui/widget/button/FlatAlertButtonView;", "buttonPositive", "getButtonPositive", "buttonPositiveAlert", "getButtonPositiveAlert", "messageView", "Landroidx/appcompat/widget/AppCompatTextView;", "getMessageView", "()Landroidx/appcompat/widget/AppCompatTextView;", "titleView", "getTitleView", "getWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YmAlertDialogView extends FrameLayout {
    private final FrameLayout additionalContentView;
    private int adjustedWidth;
    private final FlatButtonView buttonNegative;
    private final FlatAlertButtonView buttonNegativeAlert;
    private final FlatButtonView buttonPositive;
    private final FlatAlertButtonView buttonPositiveAlert;
    private final AppCompatTextView messageView;
    private final AppCompatTextView titleView;

    public /* synthetic */ YmAlertDialogView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YmAlertDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R$layout.view_alert_dialog, this);
        View viewFindViewById = findViewById(R$id.title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleView = (AppCompatTextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.messageView = (AppCompatTextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.additional_content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.additionalContentView = (FrameLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.button_positive);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.buttonPositive = (FlatButtonView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R$id.button_positive_alert);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.buttonPositiveAlert = (FlatAlertButtonView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R$id.button_negative);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.buttonNegative = (FlatButtonView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R$id.button_negative_alert);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.buttonNegativeAlert = (FlatAlertButtonView) viewFindViewById7;
        setBackground(AppCompatResources.getDrawable(context, R$drawable.bg_dialog));
        this.adjustedWidth = getWidth(context);
    }

    public final AppCompatTextView getTitleView() {
        return this.titleView;
    }

    public final AppCompatTextView getMessageView() {
        return this.messageView;
    }

    public final FrameLayout getAdditionalContentView() {
        return this.additionalContentView;
    }

    public final FlatButtonView getButtonPositive() {
        return this.buttonPositive;
    }

    public final FlatAlertButtonView getButtonPositiveAlert() {
        return this.buttonPositiveAlert;
    }

    public final FlatButtonView getButtonNegative() {
        return this.buttonNegative;
    }

    public final FlatAlertButtonView getButtonNegativeAlert() {
        return this.buttonNegativeAlert;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.adjustedWidth, pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), heightMeasureSpec);
    }

    private final int getWidth(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        float f = i / displayMetrics.density;
        TypedValue typedValue = new TypedValue();
        if (360.0f <= f && f <= 600.0f) {
            return resources.getDimensionPixelSize(R$dimen.hint_details_dialog_width);
        }
        resources.getValue(R$dimen.hint_details_dialog_width_proportion, typedValue, true);
        return (int) (i * typedValue.getFloat());
    }
}
