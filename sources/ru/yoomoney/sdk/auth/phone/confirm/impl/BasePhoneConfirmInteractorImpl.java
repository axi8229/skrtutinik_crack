package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractor;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "(Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;)V", "passwordRecoveryConfirmPhone", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "code", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecoveryConfirmPhoneResend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateCode", "action", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeChanged;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeChanged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BasePhoneConfirmInteractorImpl implements BasePhoneConfirmInteractor {
    private final PasswordRecoveryRepository passwordRecoveryRepository;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl", f = "BasePhoneConfirmInteractor.kt", l = {50, 57}, m = "passwordRecoveryConfirmPhone")
    public static final class a extends ContinuationImpl {
        public BasePhoneConfirmInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return BasePhoneConfirmInteractorImpl.this.passwordRecoveryConfirmPhone(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl", f = "BasePhoneConfirmInteractor.kt", l = {77}, m = "passwordRecoveryConfirmPhoneResend")
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return BasePhoneConfirmInteractorImpl.this.passwordRecoveryConfirmPhoneResend(null, this);
        }
    }

    public BasePhoneConfirmInteractorImpl(ServerTimeRepository serverTimeRepository, PasswordRecoveryRepository passwordRecoveryRepository) {
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        this.serverTimeRepository = serverTimeRepository;
        this.passwordRecoveryRepository = passwordRecoveryRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object passwordRecoveryConfirmPhone(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl.passwordRecoveryConfirmPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object passwordRecoveryConfirmPhoneResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository r6 = r4.passwordRecoveryRepository
            r0.c = r3
            java.lang.Object r5 = r6.mo3290confirmPhoneResendgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L77
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendResponse r5 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendResponse) r5
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendSuccessResponse
            if (r6 == 0) goto L5d
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneSuccess
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendSuccessResponse r5 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendSuccessResponse) r5
            ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess r5 = r5.getProcess()
            r6.<init>(r5)
            goto L84
        L5d:
            boolean r6 = r5 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendErrorResponse
            if (r6 == 0) goto L71
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail r6 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$ConfirmPhoneFail
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendErrorResponse r5 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendErrorResponse) r5
            ru.yoomoney.sdk.auth.api.model.ProcessError r5 = r5.getError()
            ru.yoomoney.sdk.auth.api.model.FeatureFailure r5 = ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt.toFailure(r5)
            r6.<init>(r5)
            goto L84
        L71:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L77:
            ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError r5 = new ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm$Action$TechnicalError
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractorImpl.passwordRecoveryConfirmPhoneResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.impl.BasePhoneConfirmInteractor
    public final Object validateCode(PhoneConfirm.Action.CodeChanged codeChanged, Continuation<? super PhoneConfirm.Action> continuation) {
        return codeChanged.getValue().length() >= codeChanged.getSecretLength() ? codeChanged.getExpireAt().isAfter(this.serverTimeRepository.getCurrentDateTime()) ? new PhoneConfirm.Action.CodeValid(codeChanged.getValue(), codeChanged.getProcessId(), codeChanged.getProcessType()) : PhoneConfirm.Action.Expired.INSTANCE : new PhoneConfirm.Action.CodeInvalid(codeChanged.getValue());
    }
}
