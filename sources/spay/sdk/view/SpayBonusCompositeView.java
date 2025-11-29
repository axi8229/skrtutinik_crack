package spay.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1765mc;
import npi.spay.AbstractC1923sl;
import npi.spay.Gi;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.R$styleable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lspay/sdk/view/SpayBonusCompositeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "count", "", "setBonusCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SpayBonusCompositeView extends ConstraintLayout {
    public int a;
    public final Gi b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayBonusCompositeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SpayBonusCompositeView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…,\n            0\n        )");
        typedArrayObtainStyledAttributes.getColor(R$styleable.SpayBonusCompositeView_spay_bonus_view_selected_color, ContextCompat.getColor(context, R$color.spay_bonus_selected_color));
        this.a = typedArrayObtainStyledAttributes.getColor(R$styleable.SpayBonusCompositeView_spay_bonus_view_default_color, ContextCompat.getColor(context, R$color.spay_bonus_default_color));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void setBonusCount(int count) {
        Gi gi = this.b;
        if (count <= 0 || !AbstractC1765mc.a) {
            ConstraintLayout spaySclbvRoot = gi.d;
            Intrinsics.checkNotNullExpressionValue(spaySclbvRoot, "spaySclbvRoot");
            spaySclbvRoot.setVisibility(8);
        } else {
            ConstraintLayout spaySclbvRoot2 = gi.d;
            Intrinsics.checkNotNullExpressionValue(spaySclbvRoot2, "spaySclbvRoot");
            spaySclbvRoot2.setVisibility(0);
            gi.b.setText(getContext().getString(R$string.spay_bonus_pattern, new DecimalFormat("#,###").format(Integer.valueOf(count))));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayBonusCompositeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayBonusCompositeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Gi giA = Gi.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(giA, "inflate(\n        LayoutI… this,\n        true\n    )");
        this.b = giA;
        a(context, attributeSet);
        AppCompatImageView appCompatImageView = giA.c;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.spayRicsIvSpasiboIcon");
        AbstractC1923sl.b(appCompatImageView, this.a);
        giA.b.setTextColor(this.a);
    }

    public /* synthetic */ SpayBonusCompositeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
