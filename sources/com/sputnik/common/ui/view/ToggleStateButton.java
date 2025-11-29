package com.sputnik.common.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sputnik.common.R$color;
import com.sputnik.common.R$drawable;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;
import com.sputnik.common.extensions.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToggleStateButton.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000e¢\u0006\u0004\b \u0010!R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0016\u0010*\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010&R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010&R$\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010\"¨\u0006;"}, d2 = {"Lcom/sputnik/common/ui/view/ToggleStateButton;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "updateButtonAppearance", "()V", "toggle", "", "isToggled", "()Z", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnToggleListener", "(Lkotlin/jvm/functions/Function1;)V", "", "text", "iconRes", "background", "textColor", "iconTint", "setFirstState", "(Ljava/lang/String;IIII)V", "backgroundColorRes", "setSecondState", "isFirstState", "lockState", "(Z)V", "Z", "firstStateText", "Ljava/lang/String;", "firstStateIcon", "I", "firstStateBackground", "firstStateTextColor", "firstStateIconTintColor", "secondStateText", "secondStateIcon", "secondStateBackground", "secondStateTextColor", "secondStateIconTintColor", "onToggleListener", "Lkotlin/jvm/functions/Function1;", "Landroid/widget/TextView;", "tvText", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "ivEndIcon", "Landroid/widget/ImageView;", "ivStartIcon", "rootLayout", "Landroid/widget/LinearLayout;", "isStateLocked", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToggleStateButton extends LinearLayout {
    private int firstStateBackground;
    private int firstStateIcon;
    private int firstStateIconTintColor;
    private String firstStateText;
    private int firstStateTextColor;
    private boolean isStateLocked;
    private boolean isToggled;
    private final ImageView ivEndIcon;
    private final ImageView ivStartIcon;
    private Function1<? super Boolean, Unit> onToggleListener;
    private final LinearLayout rootLayout;
    private int secondStateBackground;
    private int secondStateIcon;
    private int secondStateIconTintColor;
    private String secondStateText;
    private int secondStateTextColor;
    private final TextView tvText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToggleStateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ToggleStateButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleStateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.firstStateText = "";
        this.firstStateIcon = R$drawable.ic_notification_warning_m;
        this.firstStateBackground = R$drawable.background_button_pink_12;
        int i2 = R$color.white;
        this.firstStateTextColor = i2;
        this.firstStateIconTintColor = i2;
        this.secondStateText = "";
        this.secondStateIcon = R$drawable.ic_checkmark_outline_green;
        this.secondStateBackground = R$drawable.btn_transparent;
        this.secondStateTextColor = i2;
        this.secondStateIconTintColor = i2;
        LayoutInflater.from(context).inflate(R$layout.view_toggle_button, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.rootLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tvText = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.iv_icon_end);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.ivEndIcon = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.iv_icon_start);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.ivStartIcon = (ImageView) viewFindViewById4;
        updateButtonAppearance();
        setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.ui.view.ToggleStateButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToggleStateButton._init_$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(ToggleStateButton this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggle();
    }

    public final void toggle() {
        if (this.isStateLocked) {
            return;
        }
        this.isToggled = !this.isToggled;
        if (getIsToggled()) {
            this.isStateLocked = true;
        }
        updateButtonAppearance();
        Function1<? super Boolean, Unit> function1 = this.onToggleListener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.isToggled));
        }
    }

    /* renamed from: isToggled, reason: from getter */
    public final boolean getIsToggled() {
        return this.isToggled;
    }

    public final void setOnToggleListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onToggleListener = listener;
    }

    private final void updateButtonAppearance() {
        if (!this.isToggled) {
            this.tvText.setText(this.firstStateText);
            this.tvText.setTextColor(ContextCompat.getColor(getContext(), this.firstStateTextColor));
            this.ivEndIcon.setImageResource(this.firstStateIcon);
            ViewKt.gone(this.ivStartIcon);
            ViewKt.visible(this.ivEndIcon);
            this.ivEndIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), this.firstStateIconTintColor)));
            this.rootLayout.setBackgroundResource(this.firstStateBackground);
            return;
        }
        this.tvText.setText(this.secondStateText);
        this.tvText.setTextColor(ContextCompat.getColor(getContext(), this.secondStateTextColor));
        ViewKt.gone(this.ivEndIcon);
        ViewKt.visible(this.ivStartIcon);
        this.ivStartIcon.setImageResource(this.secondStateIcon);
        this.ivStartIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), this.secondStateIconTintColor)));
        this.rootLayout.setBackgroundResource(this.secondStateBackground);
    }

    public final void setFirstState(String text, int iconRes, int background, int textColor, int iconTint) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.firstStateText = text;
        this.firstStateIcon = iconRes;
        this.firstStateBackground = background;
        this.firstStateTextColor = textColor;
        this.firstStateIconTintColor = iconTint;
        if (this.isToggled) {
            return;
        }
        updateButtonAppearance();
    }

    public final void setSecondState(String text, int iconRes, int backgroundColorRes, int textColor, int iconTint) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.secondStateText = text;
        this.secondStateIcon = iconRes;
        this.secondStateBackground = backgroundColorRes;
        this.secondStateTextColor = textColor;
        this.secondStateIconTintColor = iconTint;
        if (this.isToggled) {
            updateButtonAppearance();
        }
    }

    public final void lockState(boolean isFirstState) {
        if (this.isToggled != (!isFirstState)) {
            toggle();
        }
        this.isStateLocked = true;
    }
}
