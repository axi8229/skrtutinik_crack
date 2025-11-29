package ru.yoomoney.sdk.kassa.payments.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$styleable;
import ru.yoomoney.sdk.kassa.payments.databinding.n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/SwitchWithDescriptionView;", "Landroid/widget/FrameLayout;", "Lru/yoomoney/sdk/kassa/payments/databinding/n;", "binding", "Lru/yoomoney/sdk/kassa/payments/databinding/n;", "Lru/yoomoney/sdk/kassa/payments/ui/ItemSwitchView;", "switchView", "Lru/yoomoney/sdk/kassa/payments/ui/ItemSwitchView;", "getSwitchView", "()Lru/yoomoney/sdk/kassa/payments/ui/ItemSwitchView;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getDescription", "setDescription", "description", "", "isChecked", "()Z", "setChecked", "(Z)V", "Landroid/text/method/MovementMethod;", "getMovementMethod", "()Landroid/text/method/MovementMethod;", "setMovementMethod", "(Landroid/text/method/MovementMethod;)V", "movementMethod", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public class SwitchWithDescriptionView extends FrameLayout {
    public static final int $stable = 8;
    private final n binding;
    private final ItemSwitchView switchView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchWithDescriptionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CharSequence getDescription() {
        return this.binding.b.getText();
    }

    public final MovementMethod getMovementMethod() {
        MovementMethod movementMethod = this.binding.c.getMovementMethod();
        Intrinsics.checkNotNullExpressionValue(movementMethod, "getMovementMethod(...)");
        return movementMethod;
    }

    public final ItemSwitchView getSwitchView() {
        return this.switchView;
    }

    public final CharSequence getTitle() {
        return this.binding.c.getText();
    }

    public final boolean isChecked() {
        return this.binding.c.isChecked();
    }

    public final void setChecked(boolean z) {
        this.binding.c.setChecked(z);
    }

    public final void setDescription(CharSequence charSequence) {
        this.binding.b.setText(charSequence);
    }

    public final void setMovementMethod(MovementMethod value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.binding.c.setMovementMethod(value);
    }

    public final void setTitle(CharSequence charSequence) {
        this.binding.c.setText(charSequence);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchWithDescriptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchWithDescriptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        n nVarA = n.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(nVarA, "inflate(...)");
        this.binding = nVarA;
        ItemSwitchView switchView = nVarA.c;
        Intrinsics.checkNotNullExpressionValue(switchView, "switchView");
        this.switchView = switchView;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_ListItemSwitchWithDescription, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        CharSequence text = typedArrayObtainStyledAttributes.getText(R$styleable.ym_ListItemSwitchWithDescription_ym_title);
        if (text != null) {
            setTitle(text);
        }
        setChecked(typedArrayObtainStyledAttributes.getBoolean(R$styleable.ym_ListItemSwitchWithDescription_ym_isChecked, false));
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(R$styleable.ym_ListItemSwitchWithDescription_ym_description);
        if (text2 != null) {
            setDescription(text2);
        }
    }

    public /* synthetic */ SwitchWithDescriptionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
