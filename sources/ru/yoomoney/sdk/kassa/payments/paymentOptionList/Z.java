package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.view.View;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final /* synthetic */ class Z extends FunctionReferenceImpl implements Function1 {
    public Z(Object obj) {
        super(1, obj, C2487j0.class, "showError", "showError(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable p0 = (Throwable) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        C2487j0 c2487j0 = (C2487j0) this.receiver;
        int i = C2487j0.$r8$clinit;
        ComposeView composeView = c2487j0.i;
        ComposeView composeView2 = null;
        if (composeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorComposeView");
            composeView = null;
        }
        View childAt = c2487j0.a().b.getChildAt(0);
        if (childAt == null) {
            c2487j0.a().b.addView(composeView);
        } else if (childAt != composeView) {
            c2487j0.a().b.removeView(childAt);
            c2487j0.a().b.addView(composeView);
        }
        ComposeView composeView3 = c2487j0.i;
        if (composeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorComposeView");
        } else {
            composeView2 = composeView3;
        }
        composeView2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView2.setContent(ComposableLambdaKt.composableLambdaInstance(-449981436, true, new C2472e0(c2487j0, p0)));
        return Unit.INSTANCE;
    }
}
