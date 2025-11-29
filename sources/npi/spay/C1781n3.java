package npi.spay;

import android.content.Context;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.n3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1781n3 implements FlowCollector {
    public final /* synthetic */ C1930t3 a;
    public final /* synthetic */ Context b;

    public C1781n3(C1930t3 c1930t3, Context context) {
        this.a = c1930t3;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Bk bk = (Bk) obj;
        C1930t3 c1930t3 = this.a;
        int i = C1930t3.$r8$clinit;
        ViewBinding viewBinding = c1930t3.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        V7 v7 = (V7) viewBinding;
        Group spaySllGroupSpinner = v7.c;
        Intrinsics.checkNotNullExpressionValue(spaySllGroupSpinner, "spaySllGroupSpinner");
        spaySllGroupSpinner.setVisibility(!StringsKt.isBlank(AbstractC1550dl.a(bk, this.b)) ? 0 : 8);
        LottieAnimationView spaySllLottieSpayLogo = v7.d;
        Intrinsics.checkNotNullExpressionValue(spaySllLottieSpayLogo, "spaySllLottieSpayLogo");
        spaySllLottieSpayLogo.setVisibility(StringsKt.isBlank(AbstractC1550dl.a(bk, this.b)) ? 0 : 8);
        v7.e.setLineSpacing(0.0f, 1.25f);
        v7.e.setText(AbstractC1550dl.a(bk, this.b));
        return Unit.INSTANCE;
    }
}
