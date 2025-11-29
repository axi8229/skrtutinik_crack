package npi.spay;

import android.content.Context;
import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class H5 extends Lambda implements Function1 {
    public final /* synthetic */ I5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5(I5 i5) {
        super(1);
        this.a = i5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Bk message = (Bk) obj;
        Intrinsics.checkNotNullParameter(message, "message");
        I5 i5 = this.a;
        int i = I5.$r8$clinit;
        i5.getClass();
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            Context contextRequireContext = i5.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            intent.putExtra("android.intent.extra.TEXT", AbstractC1550dl.a(message, contextRequireContext));
            i5.startActivity(Intent.createChooser(intent, i5.getString(R$string.spay_bnpl_share_link_choose_application)));
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        return Unit.INSTANCE;
    }
}
