package npi.spay;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$drawable;

/* renamed from: npi.spay.w9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2011w9 extends Ie {
    public final po b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2011w9(po viewBinding) {
        super(viewBinding);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.b = viewBinding;
    }

    @Override // npi.spay.Ie
    public final void a(Object obj) {
        AppCompatImageView spaySribgsSection;
        int i;
        C1462a8 item = (C1462a8) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        po poVar = this.b;
        if (item.a) {
            spaySribgsSection = poVar.b;
            Intrinsics.checkNotNullExpressionValue(spaySribgsSection, "spaySribgsSection");
            i = R$drawable.spay_ic_bnpl_payment_current_section;
        } else {
            spaySribgsSection = poVar.b;
            Intrinsics.checkNotNullExpressionValue(spaySribgsSection, "spaySribgsSection");
            i = R$drawable.spay_ic_bnpl_payment_section;
        }
        AbstractC1923sl.a(spaySribgsSection, i);
    }
}
