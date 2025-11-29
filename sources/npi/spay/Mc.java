package npi.spay;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.view.CardLogoCompositeView;

/* loaded from: classes4.dex */
public final class Mc implements FlowCollector {
    public final /* synthetic */ C1790nc a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ C1940td c;

    public Mc(C1790nc c1790nc, Context context, C1940td c1940td) {
        this.a = c1790nc;
        this.b = context;
        this.c = c1940td;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        CardLogoCompositeView cardLogoCompositeView;
        C2083z6 c2083z6 = (C2083z6) obj;
        if (c2083z6.f() != null) {
            ConstraintLayout constraintLayout = this.a.e.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "spaySloIncludeCompoundWallet.root");
            constraintLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = this.a.f.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "spaySloIncludeSelectedCard.root");
            ConstraintLayout constraintLayout3 = this.a.e.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout3, "spaySloIncludeCompoundWallet.root");
            constraintLayout2.setVisibility(constraintLayout3.getVisibility() == 0 ? 8 : 0);
            C1500bl c1500bl = this.a.e;
            c1500bl.c.setText(AbstractC1550dl.a(c2083z6.h(), this.b));
            Integer numF = c2083z6.f();
            String quantityString = numF != null ? this.c.getResources().getQuantityString(numF.intValue(), AbstractC2095zi.a(c2083z6.a()), Boxing.boxInt(AbstractC2095zi.a(c2083z6.a()))) : null;
            c1500bl.d.setText(c2083z6.e() ? this.c.getString(c2083z6.d(), c2083z6.c(), quantityString) : this.c.getString(c2083z6.d(), c2083z6.b(), c2083z6.c(), quantityString));
            cardLogoCompositeView = c1500bl.e;
        } else {
            ConstraintLayout constraintLayout4 = this.a.e.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout4, "spaySloIncludeCompoundWallet.root");
            constraintLayout4.setVisibility(8);
            ConstraintLayout constraintLayout5 = this.a.f.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout5, "spaySloIncludeSelectedCard.root");
            ConstraintLayout constraintLayout6 = this.a.e.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout6, "spaySloIncludeCompoundWallet.root");
            constraintLayout5.setVisibility(constraintLayout6.getVisibility() == 0 ? 8 : 0);
            Bl bl = this.a.f;
            bl.e.setText(AbstractC1550dl.a(c2083z6.h(), this.b));
            bl.d.setText(c2083z6.e() ? this.c.getString(c2083z6.d(), c2083z6.c()) : this.c.getString(c2083z6.d(), c2083z6.b(), c2083z6.c()));
            cardLogoCompositeView = bl.b;
        }
        cardLogoCompositeView.a(c2083z6.g);
        return Unit.INSTANCE;
    }
}
