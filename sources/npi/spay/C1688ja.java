package npi.spay;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$anim;
import ru.yoomoney.sdk.kassa.payments.R$color;
import spay.sdk.view.CardLogoCompositeView;

/* renamed from: npi.spay.ja, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1688ja extends Dk {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1688ja(C2088zb cardPositionListener) {
        super(C2036x9.a);
        Intrinsics.checkNotNullParameter(cardPositionListener, "cardPositionListener");
    }

    public static final void a(ConstraintLayout this_apply, Animation animation, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.startAnimation(animation);
    }

    @Override // npi.spay.Dk
    public final boolean b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof N5;
    }

    @Override // npi.spay.Dk
    public final /* bridge */ /* synthetic */ void a(ViewBinding viewBinding, Object obj) throws Resources.NotFoundException {
        a((D2) viewBinding, (N5) obj);
    }

    public static void a(D2 d2, N5 item) throws Resources.NotFoundException {
        String string;
        Intrinsics.checkNotNullParameter(d2, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Context context = d2.b.getContext();
        int color = ContextCompat.getColor(context, R$color.spay_listcards_inactive_text_color);
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$anim.spay_shake);
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
        appCompatTextView.setTextColor(color);
        AppCompatTextView appCompatTextView2 = d2.f;
        Integer num = item.n;
        if (num != null) {
            String quantityString = context.getResources().getQuantityString(num.intValue(), AbstractC2095zi.a(item.p), Integer.valueOf(AbstractC2095zi.a(item.p)));
            string = item.t ? context.getString(item.m, item.o, quantityString) : context.getString(item.m, item.r, item.o, quantityString);
        } else {
            string = item.t ? context.getString(item.m, item.o) : context.getString(item.m, item.r, item.o);
        }
        appCompatTextView2.setText(string);
        appCompatTextView2.setTextColor(color);
        CardLogoCompositeView cardLogoCompositeView = d2.b;
        cardLogoCompositeView.a(item.s);
        cardLogoCompositeView.setAlpha(0.3f);
        d2.h.setBonusCount(AbstractC2095zi.a(item.u));
        final ConstraintLayout constraintLayout = d2.c;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.ja$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1688ja.a(constraintLayout, animationLoadAnimation, view);
            }
        });
    }

    @Override // npi.spay.Dk
    public final Integer a(Object obj) {
        N5 n5 = (N5) obj;
        Intrinsics.checkNotNullParameter(n5, "<this>");
        return Integer.valueOf(n5.hashCode());
    }
}
