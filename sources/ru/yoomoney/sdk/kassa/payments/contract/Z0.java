package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;

/* loaded from: classes5.dex */
public final class Z0 implements X0 {
    public final ru.yoomoney.sdk.kassa.payments.payment.c a;
    public final ru.yoomoney.sdk.kassa.payments.payment.a b;
    public final AccountRepository c;
    public final ru.yoomoney.sdk.kassa.payments.userAuth.U d;

    public Z0(ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.payment.a checkPaymentAuthRequiredGateway, AccountRepository accountRepository, ru.yoomoney.sdk.kassa.payments.secure.j userAuthInfoRepository) {
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(checkPaymentAuthRequiredGateway, "checkPaymentAuthRequiredGateway");
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        this.a = getLoadedPaymentOptionListRepository;
        this.b = checkPaymentAuthRequiredGateway;
        this.c = accountRepository;
        this.d = userAuthInfoRepository;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105 A[EDGE_INSN: B:62:0x0105->B:59:0x0105 BREAK  A[LOOP:0: B:54:0x00ef->B:64:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(int r8, java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.contract.Z0.a(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
