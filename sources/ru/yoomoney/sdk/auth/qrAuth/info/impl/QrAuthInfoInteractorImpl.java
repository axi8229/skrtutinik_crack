package ru.yoomoney.sdk.auth.qrAuth.info.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.signIn.SignInRepository;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractorImpl;", "Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractor;", "signInRepository", "Lru/yoomoney/sdk/auth/api/signIn/SignInRepository;", "(Lru/yoomoney/sdk/auth/api/signIn/SignInRepository;)V", "accept", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInfo", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthInfoInteractorImpl implements QrAuthInfoInteractor {
    private final SignInRepository signInRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl", f = "QrAuthInfoInteractor.kt", l = {43}, m = "accept")
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return QrAuthInfoInteractorImpl.this.accept(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl", f = "QrAuthInfoInteractor.kt", l = {18}, m = "loadInfo")
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
            return QrAuthInfoInteractorImpl.this.loadInfo(null, this);
        }
    }

    public QrAuthInfoInteractorImpl(SignInRepository signInRepository) {
        Intrinsics.checkNotNullParameter(signInRepository, "signInRepository");
        this.signInRepository = signInRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object accept(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl$a
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
            ru.yoomoney.sdk.auth.api.signIn.SignInRepository r6 = r4.signInRepository
            r0.c = r3
            java.lang.Object r5 = r6.mo3303acceptgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L50
            kotlin.Unit r5 = (kotlin.Unit) r5
            ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$AcceptSuccess r5 = ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo.Action.AcceptSuccess.INSTANCE
            goto L70
        L50:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.auth.api.model.TechnicalFailure
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            if (r5 == 0) goto L57
            goto L5b
        L57:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.auth.api.model.NetworkConnectionFailure
            if (r5 == 0) goto L66
        L5b:
            ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$AcceptError r5 = new ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$AcceptError
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            goto L70
        L66:
            ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$AcceptFailure r5 = new ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$AcceptFailure
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
        L70:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl.accept(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadInfo(java.lang.String r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl$b
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
            ru.yoomoney.sdk.auth.api.signIn.SignInRepository r6 = r4.signInRepository
            r0.c = r3
            java.lang.Object r5 = r6.mo3304checkgIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L83
            ru.yoomoney.sdk.auth.api.signIn.model.SigninQrCheckResponse r5 = (ru.yoomoney.sdk.auth.api.signIn.model.SigninQrCheckResponse) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = r5.getGeolocation()
            java.lang.String r1 = ", "
            if (r0 == 0) goto L60
            r6.append(r0)
            r6.append(r1)
        L60:
            java.lang.String r0 = r5.getIpAddress()
            r6.append(r0)
            java.lang.String r5 = r5.getApplication()
            if (r5 == 0) goto L73
            r6.append(r1)
            r6.append(r5)
        L73:
            ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$LoadInfoSuccess r5 = new ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$LoadInfoSuccess
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            r5.<init>(r6)
            goto La3
        L83:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.auth.api.model.TechnicalFailure
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            if (r5 == 0) goto L8a
            goto L8e
        L8a:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.auth.api.model.NetworkConnectionFailure
            if (r5 == 0) goto L99
        L8e:
            ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$LoadInfoError r5 = new ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$LoadInfoError
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
            goto La3
        L99:
            ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$LoadInfoFailure r5 = new ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo$Action$LoadInfoFailure
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r6 = (ru.yoomoney.sdk.auth.api.model.Failure) r6
            r5.<init>(r6)
        La3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractorImpl.loadInfo(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
