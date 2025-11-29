package ru.yoomoney.sdk.two_fa.phoneCall.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;

/* compiled from: PhoneCallInteractor.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractorImpl;", "Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "repository", "Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;", "(Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;)V", "getRepository", "()Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;", "checkCode", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "code", "", "codeLength", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmCode", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "attemptsLeft", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextAvailableSessionOption", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthSession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneCallInteractorImpl implements PhoneCallInteractor {
    public static final int $stable = 8;
    private final AuthenticatorRepository repository;

    /* compiled from: PhoneCallInteractor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl", f = "PhoneCallInteractor.kt", l = {32}, m = "confirmCode")
    /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$confirmCode$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PhoneCallInteractorImpl.this.confirmCode(null, null, 0, this);
        }
    }

    /* compiled from: PhoneCallInteractor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl", f = "PhoneCallInteractor.kt", l = {56}, m = "startAuthSession")
    /* renamed from: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$startAuthSession$1, reason: invalid class name and case insensitive filesystem */
    static final class C26121 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C26121(Continuation<? super C26121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PhoneCallInteractorImpl.this.startAuthSession(null, this);
        }
    }

    public PhoneCallInteractorImpl(AuthenticatorRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final AuthenticatorRepository getRepository() {
        return this.repository;
    }

    @Override // ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor
    public Object checkCode(String str, int i, Continuation<? super PhoneCall.Action> continuation) {
        if (str.length() == i) {
            return new PhoneCall.Action.ConfirmCode(str);
        }
        return new PhoneCall.Action.UpdateCode(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object confirmCode(java.lang.String r5, java.lang.String r6, int r7, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall.Action> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$confirmCode$1 r0 = (ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$confirmCode$1 r0 = new ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$confirmCode$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r7 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.getValue()
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository r8 = r4.repository
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r5 = r8.mo3511checkAuthSession0E7RQCE(r5, r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L54
            java.lang.String r5 = (java.lang.String) r5
            ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$ConfirmSuccess r5 = ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall.Action.ConfirmSuccess.INSTANCE
            goto L75
        L54:
            java.lang.String r5 = "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.exception.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r5)
            ru.yoomoney.sdk.two_fa.exception.Failure r6 = (ru.yoomoney.sdk.two_fa.exception.Failure) r6
            boolean r5 = r6 instanceof ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure.InvalidSecretFailure
            if (r5 == 0) goto L66
            ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$ConfirmFail r5 = new ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$ConfirmFail
            int r7 = r7 - r3
            r5.<init>(r6, r7)
            goto L75
        L66:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure
            if (r5 == 0) goto L70
            ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$ConfirmFail r5 = new ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$ConfirmFail
            r5.<init>(r6, r7)
            goto L75
        L70:
            ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$TechnicalFail r5 = new ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$TechnicalFail
            r5.<init>(r6)
        L75:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl.confirmCode(java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object startAuthSession(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl.C26121
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$startAuthSession$1 r0 = (ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl.C26121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$startAuthSession$1 r0 = new ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl$startAuthSession$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L47
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository r6 = r4.repository
            ru.yoomoney.sdk.two_fa.domain.SessionType r2 = ru.yoomoney.sdk.two_fa.domain.SessionType.PHONE_CALL
            r0.label = r3
            java.lang.Object r5 = r6.mo3514startAuthSession0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L5c
            ru.yoomoney.sdk.two_fa.domain.Session r5 = (ru.yoomoney.sdk.two_fa.domain.Session) r5
            ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$SessionStartSuccess r6 = new ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$SessionStartSuccess
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.domain.SessionPhoneCall"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r0)
            ru.yoomoney.sdk.two_fa.domain.SessionPhoneCall r5 = (ru.yoomoney.sdk.two_fa.domain.SessionPhoneCall) r5
            r6.<init>(r5)
            goto L69
        L5c:
            ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$SessionStartFail r5 = new ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall$Action$SessionStartFail
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.two_fa.exception.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.two_fa.exception.Failure r6 = (ru.yoomoney.sdk.two_fa.exception.Failure) r6
            r5.<init>(r6)
            r6 = r5
        L69:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractorImpl.startAuthSession(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor
    public Object nextAvailableSessionOption(SessionType sessionType, Continuation<? super PhoneCall.Action> continuation) {
        PhoneCall.Action.ForwardToNextAvailableSession forwardToNextAvailableSession;
        return (sessionType == null || (forwardToNextAvailableSession = PhoneCall.Action.ForwardToNextAvailableSession.INSTANCE) == null) ? PhoneCall.Action.RestartSession.INSTANCE : forwardToNextAvailableSession;
    }
}
