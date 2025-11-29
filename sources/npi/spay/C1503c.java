package npi.spay;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;

/* renamed from: npi.spay.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1503c extends RecyclerView.ViewHolder {
    public final AppCompatImageView a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatImageView e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1503c(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.a = (AppCompatImageView) itemView.findViewById(R$id.spay_aciv_bullet_background);
        this.b = (AppCompatImageView) itemView.findViewById(R$id.spay_aciv_bullet);
        this.c = (AppCompatTextView) itemView.findViewById(R$id.spay_actv_write_off_date);
        this.d = (AppCompatTextView) itemView.findViewById(R$id.spay_actv_amount);
        this.e = (AppCompatImageView) itemView.findViewById(R$id.spay_incl_bottom_divider);
        itemView.getResources();
    }
}
