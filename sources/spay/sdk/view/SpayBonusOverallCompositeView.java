package spay.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1765mc;
import npi.spay.Lh;
import ru.yoomoney.sdk.kassa.payments.R$styleable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lspay/sdk/view/SpayBonusOverallCompositeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "bonusCount", "", "setBonusCount", "(I)V", "Lnpi/spay/Lh;", "a", "Lnpi/spay/Lh;", "getBinding", "()Lnpi/spay/Lh;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SpayBonusOverallCompositeView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    public final Lh binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayBonusOverallCompositeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SpayBonusOverallCompositeView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…,\n            0\n        )");
        setBonusCount(typedArrayObtainStyledAttributes.getInteger(R$styleable.SpayBonusOverallCompositeView_spay_bonus_overall_view_count, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final Lh getBinding() {
        return this.binding;
    }

    public final void setBonusCount(int bonusCount) {
        Lh lh = this.binding;
        if (bonusCount <= 0 || !AbstractC1765mc.a) {
            ConstraintLayout root = lh.a;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            root.setVisibility(8);
        } else {
            ConstraintLayout root2 = lh.a;
            Intrinsics.checkNotNullExpressionValue(root2, "root");
            root2.setVisibility(0);
            lh.b.setBonusCount(bonusCount);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpayBonusOverallCompositeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayBonusOverallCompositeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Lh lhA = Lh.a(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(lhA, "inflate(\n        LayoutI… this,\n        true\n    )");
        this.binding = lhA;
        a(context, attributeSet);
    }

    public /* synthetic */ SpayBonusOverallCompositeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
