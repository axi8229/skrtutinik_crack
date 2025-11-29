package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$plurals;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* renamed from: npi.spay.y4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2056y4 extends SuspendLambda implements Function2 {
    public /* synthetic */ long a;

    public C2056y4(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2056y4 c2056y4 = new C2056y4(continuation);
        c2056y4.a = ((Number) obj).longValue();
        return c2056y4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        C2056y4 c2056y4 = new C2056y4((Continuation) obj2);
        c2056y4.a = jLongValue;
        return c2056y4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        long j = this.a;
        if (j <= -1) {
            return j == -1 ? new C1906s4(R$string.spay_otp_code_resend_btn, null, R$color.spay_otp_primary_button_color, null, true, 10) : new C1906s4(R$string.spay_empty_string, null, 0, null, false, 30);
        }
        return new C1906s4(R$string.spay_otp_code_resend_btn_countdown, Boxing.boxInt(R$plurals.spay_otp_secs_f), R$color.spay_otp_code_info_text_color, Boxing.boxLong(j), false, 16);
    }
}
