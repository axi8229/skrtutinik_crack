package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.net.Uri;
import android.widget.FrameLayout;
import com.squareup.picasso.Picasso;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.ContextExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.SharedElementTransitionUtilsKt;

/* loaded from: classes5.dex */
public final /* synthetic */ class X extends FunctionReferenceImpl implements Function1 {
    public X(Object obj) {
        super(1, obj, C2487j0.class, "showState", "showState(Lru/yoomoney/sdk/kassa/payments/paymentOptionList/PaymentOptionList$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        S p0 = (S) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        C2487j0 c2487j0 = (C2487j0) this.receiver;
        int i = C2487j0.$r8$clinit;
        c2487j0.getClass();
        Picasso.get().load(Uri.parse(p0.a())).placeholder(c2487j0.a().c.getLogo().getDrawable()).into(c2487j0.a().c.getLogo());
        boolean zIsTablet = ContextExtensionsKt.isTablet(c2487j0);
        C2475f0 c2475f0 = new C2475f0(p0, c2487j0);
        if (zIsTablet) {
            c2475f0.invoke();
        } else {
            FrameLayout contentContainer = c2487j0.a().b;
            Intrinsics.checkNotNullExpressionValue(contentContainer, "contentContainer");
            SharedElementTransitionUtilsKt.changeViewWithAnimation(c2487j0, contentContainer, c2475f0);
        }
        return Unit.INSTANCE;
    }
}
