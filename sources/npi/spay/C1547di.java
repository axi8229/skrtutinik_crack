package npi.spay;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.view.CardLogoCompositeView;

/* renamed from: npi.spay.di, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1547di implements FlowCollector {
    public final /* synthetic */ C1570eg a;
    public final /* synthetic */ C1771mi b;

    public C1547di(C1570eg c1570eg, C1771mi c1771mi) {
        this.a = c1570eg;
        this.b = c1771mi;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        CardLogoCompositeView cardLogoCompositeView;
        C2083z6 c2083z6 = (C2083z6) obj;
        if (c2083z6.f() != null) {
            ConstraintLayout constraintLayout = this.a.g.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "spaySloIncludeCompoundWallet.root");
            constraintLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = this.a.h.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "spaySloIncludeSelectedCard.root");
            ConstraintLayout constraintLayout3 = this.a.g.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout3, "spaySloIncludeCompoundWallet.root");
            constraintLayout2.setVisibility(constraintLayout3.getVisibility() == 0 ? 8 : 0);
            C1500bl c1500bl = this.a.g;
            AppCompatTextView appCompatTextView = c1500bl.c;
            Bk bkH = c2083z6.h();
            Context contextRequireContext = this.b.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            appCompatTextView.setText(AbstractC1550dl.a(bkH, contextRequireContext));
            Integer numF = c2083z6.f();
            String quantityString = numF != null ? this.b.getResources().getQuantityString(numF.intValue(), AbstractC2095zi.a(c2083z6.a()), Boxing.boxInt(AbstractC2095zi.a(c2083z6.a()))) : null;
            c1500bl.d.setText(c2083z6.e() ? this.b.getString(c2083z6.d(), c2083z6.c(), quantityString) : this.b.getString(c2083z6.d(), c2083z6.b(), c2083z6.c(), quantityString));
            cardLogoCompositeView = c1500bl.e;
        } else {
            ConstraintLayout constraintLayout4 = this.a.g.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout4, "spaySloIncludeCompoundWallet.root");
            constraintLayout4.setVisibility(8);
            ConstraintLayout constraintLayout5 = this.a.h.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout5, "spaySloIncludeSelectedCard.root");
            ConstraintLayout constraintLayout6 = this.a.g.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout6, "spaySloIncludeCompoundWallet.root");
            constraintLayout5.setVisibility(constraintLayout6.getVisibility() == 0 ? 8 : 0);
            Bl bl = this.a.h;
            AppCompatTextView appCompatTextView2 = bl.e;
            Bk bkH2 = c2083z6.h();
            Context contextRequireContext2 = this.b.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            appCompatTextView2.setText(AbstractC1550dl.a(bkH2, contextRequireContext2));
            bl.d.setText(c2083z6.e() ? this.b.getString(c2083z6.d(), c2083z6.c()) : this.b.getString(c2083z6.d(), c2083z6.b(), c2083z6.c()));
            cardLogoCompositeView = bl.b;
        }
        cardLogoCompositeView.a(c2083z6.g);
        return Unit.INSTANCE;
    }
}
