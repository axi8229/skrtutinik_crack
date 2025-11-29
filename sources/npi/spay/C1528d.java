package npi.spay;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.R$style;

/* renamed from: npi.spay.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1528d extends RecyclerView.Adapter {
    public final List a;

    public C1528d(List payments) {
        Intrinsics.checkNotNullParameter(payments, "payments");
        this.a = payments;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        C1503c holder = (C1503c) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Jd jd = (Jd) this.a.get(i);
        AppCompatTextView appCompatTextView = holder.c;
        Bk bk = jd.a;
        Context context = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        appCompatTextView.setText(AbstractC1550dl.a(bk, context));
        AppCompatTextView actvAmount = holder.d;
        Intrinsics.checkNotNullExpressionValue(actvAmount, "actvAmount");
        long j = jd.b;
        int i2 = R$string.spay_rub_amount_template;
        String str = jd.c;
        Intrinsics.checkNotNullParameter(actvAmount, "<this>");
        Context context2 = actvAmount.getContext();
        String strA = AbstractC2095zi.a(j);
        if (str == null) {
            str = "";
        }
        actvAmount.setText(context2.getString(i2, strA, str));
        if (jd.d) {
            AppCompatTextView actvWriteOffDate = holder.c;
            Intrinsics.checkNotNullExpressionValue(actvWriteOffDate, "actvWriteOffDate");
            int i3 = R$style.SpayMainTextStyle;
            actvWriteOffDate.setTextAppearance(i3);
            Resources resources = actvWriteOffDate.getResources();
            int i4 = R$dimen.spay_bnpl_graph_bold_text_size;
            actvWriteOffDate.setTextSize(0, resources.getDimension(i4));
            actvWriteOffDate.setTypeface(actvWriteOffDate.getTypeface(), 1);
            AppCompatTextView actvAmount2 = holder.d;
            Intrinsics.checkNotNullExpressionValue(actvAmount2, "actvAmount");
            actvAmount2.setTextAppearance(i3);
            actvAmount2.setTextSize(0, actvAmount2.getResources().getDimension(i4));
            actvAmount2.setTypeface(actvAmount2.getTypeface(), 1);
            AppCompatImageView appCompatImageView = holder.b;
            View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            int i5 = R$color.spay_main_bank_green_color;
            Intrinsics.checkNotNullParameter(itemView, "<this>");
            appCompatImageView.setImageTintList(ColorStateList.valueOf(ResourcesCompat.getColor(itemView.getResources(), i5, null)));
            AppCompatImageView acivBulletBackground = holder.a;
            Intrinsics.checkNotNullExpressionValue(acivBulletBackground, "acivBulletBackground");
            acivBulletBackground.setVisibility(!jd.e ? 0 : 8);
        }
        AppCompatImageView divider = holder.e;
        Intrinsics.checkNotNullExpressionValue(divider, "divider");
        divider.setVisibility(jd.e ? 4 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.spay_payment_in_installments_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …ents_item, parent, false)");
        return new C1503c(viewInflate);
    }
}
