package ru.yoomoney.sdk.kassa.payments.model.mapper;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthPaymentState;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthTypeStateResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.ErrorCodeNetwork;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.PaymentUsageLimit;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.TokenIssueInitResponse;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;
import ru.yoomoney.sdk.kassa.payments.model.C2319c;
import ru.yoomoney.sdk.kassa.payments.model.C2322f;
import ru.yoomoney.sdk.kassa.payments.model.C2323g;
import ru.yoomoney.sdk.kassa.payments.model.C2324h;
import ru.yoomoney.sdk.kassa.payments.model.C2325i;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;
import ru.yoomoney.sdk.kassa.payments.model.C2327k;
import ru.yoomoney.sdk.kassa.payments.model.C2328l;
import ru.yoomoney.sdk.kassa.payments.model.C2329m;
import ru.yoomoney.sdk.kassa.payments.model.C2337v;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2338w;
import ru.yoomoney.sdk.kassa.payments.model.b0;
import ru.yoomoney.sdk.kassa.payments.model.c0;
import ru.yoomoney.sdk.kassa.payments.model.d0;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.C2434n;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.C2436o;

/* loaded from: classes5.dex */
public abstract class c {
    public static final AbstractC2330n a(AuthTypeStateResponse authTypeStateResponse) {
        Intrinsics.checkNotNullParameter(authTypeStateResponse, "<this>");
        switch (b.a[authTypeStateResponse.getType().ordinal()]) {
            case 1:
                return new C2326j(authTypeStateResponse.getNextSessionTimeLeft(), authTypeStateResponse.getCodeLength(), authTypeStateResponse.getAttemptsCount(), authTypeStateResponse.getAttemptsLeft());
            case 2:
                return C2322f.a;
            case 3:
                return C2328l.a;
            case 4:
                return C2327k.a;
            case 5:
                return C2325i.a;
            case 6:
                return C2324h.a;
            case 7:
            default:
                return C2329m.a;
            case 8:
                return C2323g.a;
        }
    }

    public static final d0 a(TokenIssueInitResponse tokenIssueInitResponse) {
        Intrinsics.checkNotNullParameter(tokenIssueInitResponse, "<this>");
        if (tokenIssueInitResponse.getStatus() == AuthPaymentState.SUCCESS && tokenIssueInitResponse.getResult() != null) {
            return new c0(new C2436o(tokenIssueInitResponse.getResult().getProcessId()));
        }
        if (tokenIssueInitResponse.getStatus() == AuthPaymentState.AUTH_REQUIRED && tokenIssueInitResponse.getResult() != null) {
            return new c0(new C2434n(tokenIssueInitResponse.getResult().getAuthContextId(), tokenIssueInitResponse.getResult().getProcessId()));
        }
        if (tokenIssueInitResponse.getStatus() == AuthPaymentState.UNKNOWN && tokenIssueInitResponse.getError() != null) {
            return new b0(new C2319c(new C2337v(a(tokenIssueInitResponse.getError()), null, null, null, null)));
        }
        EnumC2338w enumC2338w = EnumC2338w.a;
        return new b0(new C2319c());
    }

    public static final EnumC2338w a(ErrorCodeNetwork errorCodeNetwork) {
        Intrinsics.checkNotNullParameter(errorCodeNetwork, "<this>");
        switch (b.b[errorCodeNetwork.ordinal()]) {
            case 1:
                return EnumC2338w.b;
            case 2:
                return EnumC2338w.c;
            case 3:
                return EnumC2338w.e;
            case 4:
                return EnumC2338w.d;
            case 5:
                return EnumC2338w.f;
            case 6:
                return EnumC2338w.g;
            case 7:
                return EnumC2338w.h;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final PaymentUsageLimit a(boolean z) {
        return z ? PaymentUsageLimit.MULTIPLE : PaymentUsageLimit.SINGLE;
    }
}
