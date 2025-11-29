package npi.spay;

import android.content.Context;
import android.media.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$raw;

/* loaded from: classes4.dex */
public final class J0 extends Lambda implements Function1 {
    public final /* synthetic */ D a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J0(D d) {
        super(1);
        this.a = d;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws IllegalStateException {
        if (((Boolean) obj).booleanValue()) {
            Context context = this.a.requireContext();
            Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
            Intrinsics.checkNotNullParameter(context, "context");
            MediaPlayer.create(context, R$raw.failure_payment_sound).start();
        }
        return Unit.INSTANCE;
    }
}
