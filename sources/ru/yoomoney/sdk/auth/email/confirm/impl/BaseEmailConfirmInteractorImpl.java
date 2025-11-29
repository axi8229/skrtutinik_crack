package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendSuccessResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractorImpl;", "Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractor;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePasswordRecoveryConfirmEmailResendResponse", "response", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResendResponse;", "handlePasswordRecoveryConfirmEmailResponse", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResponse;", "handlePasswordRecoveryProcess", "process", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "passwordRecoveryConfirmEmail", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecoveryConfirmEmailResend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateCode", "secretLength", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseEmailConfirmInteractorImpl implements BaseEmailConfirmInteractor {
    private final PasswordRecoveryRepository passwordRecoveryRepository;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl", f = "BaseEmailConfirmInteractor.kt", l = {78, 85}, m = "passwordRecoveryConfirmEmail")
    public static final class a extends ContinuationImpl {
        public BaseEmailConfirmInteractorImpl a;
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
            return BaseEmailConfirmInteractorImpl.this.passwordRecoveryConfirmEmail(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl", f = "BaseEmailConfirmInteractor.kt", l = {67}, m = "passwordRecoveryConfirmEmailResend")
    public static final class b extends ContinuationImpl {
        public BaseEmailConfirmInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return BaseEmailConfirmInteractorImpl.this.passwordRecoveryConfirmEmailResend(null, this);
        }
    }

    public BaseEmailConfirmInteractorImpl(PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.passwordRecoveryRepository = passwordRecoveryRepository;
        this.serverTimeRepository = serverTimeRepository;
    }

    private final EmailConfirm.Action handlePasswordRecoveryConfirmEmailResendResponse(PasswordRecoveryConfirmEmailResendResponse response) {
        if (response instanceof PasswordRecoveryConfirmEmailResendSuccessResponse) {
            return new EmailConfirm.Action.ConfirmEmailSuccess(((PasswordRecoveryConfirmEmailResendSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordRecoveryConfirmEmailResendErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((PasswordRecoveryConfirmEmailResendErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handlePasswordRecoveryConfirmEmailResponse(PasswordRecoveryConfirmEmailResponse response) {
        if (response instanceof PasswordRecoveryConfirmEmailSuccessResponse) {
            return handlePasswordRecoveryProcess(((PasswordRecoveryConfirmEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof PasswordRecoveryConfirmEmailErrorResponse) {
            return new EmailConfirm.Action.ConfirmEmailFail(((PasswordRecoveryConfirmEmailErrorResponse) response).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EmailConfirm.Action handlePasswordRecoveryProcess(PasswordRecoveryProcess process) {
        return process instanceof PasswordRecoveryProcessFailure ? new EmailConfirm.Action.ConfirmEmailFail(((PasswordRecoveryProcessFailure) process).getError()) : new EmailConfirm.Action.ConfirmEmailSuccess(process);
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public final Object checkExpiration(ProcessType processType, String str, OffsetDateTime offsetDateTime, Continuation<? super EmailConfirm.Action> continuation) {
        return offsetDateTime.isAfter(this.serverTimeRepository.getCurrentDateTime()) ? new EmailConfirm.Action.Submit(processType, str) : EmailConfirm.Action.Expired.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object passwordRecoveryConfirmEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl.passwordRecoveryConfirmEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object passwordRecoveryConfirmEmailResend(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.confirm.EmailConfirm.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.getValue()
            goto L4a
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository r6 = r4.passwordRecoveryRepository
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.mo3288confirmEmailResendgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L57
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendResponse r6 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendResponse) r6
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action r5 = r5.handlePasswordRecoveryConfirmEmailResendResponse(r6)
            goto L63
        L57:
            ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError r5 = new ru.yoomoney.sdk.auth.email.confirm.EmailConfirm$Action$ConfirmEmailTechnicalError
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractorImpl.passwordRecoveryConfirmEmailResend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.email.confirm.impl.BaseEmailConfirmInteractor
    public final Object validateCode(String str, int i, Continuation<? super EmailConfirm.Action> continuation) {
        return str.length() >= i ? new EmailConfirm.Action.CodeValid(str, i) : new EmailConfirm.Action.CodeInvalid(str, i);
    }
}
