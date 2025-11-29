package npi.spay;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.b8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1487b8 extends Dk {
    public final C2063yb b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1487b8(C2063yb cardPositionListener) {
        super(C1860q7.a);
        Intrinsics.checkNotNullParameter(cardPositionListener, "cardPositionListener");
        this.b = cardPositionListener;
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof M3;
    }

    @Override // npi.spay.Dk
    public final void a(D2 d2, final M3 item) throws Resources.NotFoundException {
        String string;
        Intrinsics.checkNotNullParameter(d2, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = d2.b.getContext();
        CardView spayRicsCvCardItem = d2.d;
        Intrinsics.checkNotNullExpressionValue(spayRicsCvCardItem, "spayRicsCvCardItem");
        int i = item.k;
        Intrinsics.checkNotNullParameter(spayRicsCvCardItem, "<this>");
        spayRicsCvCardItem.setCardBackgroundColor(ResourcesCompat.getColor(spayRicsCvCardItem.getResources(), i, null));
        AppCompatImageView spayRicsIvStatus = d2.e;
        Intrinsics.checkNotNullExpressionValue(spayRicsIvStatus, "spayRicsIvStatus");
        int i2 = item.l;
        Intrinsics.checkNotNullParameter(spayRicsIvStatus, "<this>");
        spayRicsIvStatus.setImageResource(i2);
        AppCompatTextView appCompatTextView = d2.g;
        Bk bk = item.q;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        appCompatTextView.setText(AbstractC1550dl.a(bk, context));
        AppCompatTextView appCompatTextView2 = d2.f;
        Integer num = item.n;
        if (num != null) {
            String quantityString = context.getResources().getQuantityString(num.intValue(), AbstractC2095zi.a(item.p), Integer.valueOf(AbstractC2095zi.a(item.p)));
            string = item.t ? context.getString(item.m, item.o, quantityString) : context.getString(item.m, item.r, item.o, quantityString);
        } else {
            string = item.t ? context.getString(item.m, item.o) : context.getString(item.m, item.r, item.o);
        }
        appCompatTextView2.setText(string);
        d2.b.a(item.s);
        d2.h.setBonusCount(AbstractC2095zi.a(item.u));
        ConstraintLayout constraintLayout = d2.c;
        constraintLayout.setClickable(true);
        constraintLayout.setFocusable(true);
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.b8$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1487b8.a(this.f$0, item, view);
            }
        });
    }

    public static final void a(C1487b8 this$0, M3 item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.b.invoke(item);
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        M3 m3 = (M3) obj;
        Intrinsics.checkNotNullParameter(m3, "<this>");
        return Integer.valueOf(m3.hashCode());
    }
}
