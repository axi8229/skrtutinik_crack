package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.p0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2504p0 extends RecyclerView.Adapter {
    public final InterfaceC2502o0 a;
    public final List b;

    public C2504p0(InterfaceC2502o0 paymentOptionClickListener, List paymentOptionsListItem) {
        Intrinsics.checkNotNullParameter(paymentOptionClickListener, "paymentOptionClickListener");
        Intrinsics.checkNotNullParameter(paymentOptionsListItem, "paymentOptionsListItem");
        this.a = paymentOptionClickListener;
        this.b = paymentOptionsListItem;
    }

    public static final void a(C2504p0 this$0, C2493l0 paymentOption, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paymentOption, "$paymentOption");
        ((RuntimeViewModel) ((C2487j0) this$0.a).e.getValue()).handleAction(new C2522z(paymentOption.a, paymentOption.b));
    }

    public static final void b(C2504p0 this$0, C2493l0 paymentOption, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paymentOption, "$paymentOption");
        ((RuntimeViewModel) ((C2487j0) this$0.a).e.getValue()).handleAction(new C2522z(paymentOption.a, paymentOption.b));
    }

    public static final void c(C2504p0 this$0, C2493l0 paymentOption, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paymentOption, "$paymentOption");
        ((RuntimeViewModel) ((C2487j0) this$0.a).e.getValue()).handleAction(new C2514v(paymentOption.a, paymentOption.b));
    }

    public static final void d(C2504p0 this$0, C2493l0 paymentOption, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paymentOption, "$paymentOption");
        ((RuntimeViewModel) ((C2487j0) this$0.a).e.getValue()).handleAction(new C2516w(paymentOption.a, paymentOption.b));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final C2493l0 c2493l0 = (C2493l0) this.b.get(i);
        J1 j1 = (J1) holder;
        j1.b = (!c2493l0.h || (str = c2493l0.b) == null || str.length() == 0) ? false : true;
        Drawable drawable = c2493l0.d;
        C2507r0 c2507r0 = j1.a;
        c2507r0.getImage().setImageDrawable(drawable);
        String str2 = c2493l0.c;
        if (str2 != null) {
            Picasso.get().load(Uri.parse(str2)).placeholder(drawable).into(c2507r0.getImage());
        }
        c2507r0.getPrimaryText().setText(c2493l0.e);
        c2507r0.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.p0$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2504p0.a(this.f$0, c2493l0, view);
            }
        });
        TextView secondaryText = c2507r0.getSecondaryText();
        ru.yoomoney.sdk.kassa.payments.extensions.l.a(secondaryText, c2493l0.f != null);
        secondaryText.setText(c2493l0.f);
        c2507r0.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.p0$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2504p0.b(this.f$0, c2493l0, view);
            }
        });
        ru.yoomoney.sdk.kassa.payments.extensions.l.a(c2507r0.getDivider(), i != this.b.size() - 1);
        ImageView options = c2507r0.getOptions();
        ru.yoomoney.sdk.kassa.payments.extensions.l.a(options, c2493l0.h);
        options.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.p0$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2504p0.c(this.f$0, c2493l0, view);
            }
        });
        c2507r0.getDelete().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.paymentOptionList.p0$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2504p0.d(this.f$0, c2493l0, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        C2507r0 c2507r0 = new C2507r0(context, null, 0);
        c2507r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new J1(c2507r0);
    }
}
