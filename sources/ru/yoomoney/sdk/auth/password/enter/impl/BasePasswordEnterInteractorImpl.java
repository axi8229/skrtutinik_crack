package ru.yoomoney.sdk.auth.password.enter.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.model.ErrorContactTechnicalSupport;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcessFailure;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0004J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/yooprofiler/YooProfiler;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "action", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$CheckExpiration;", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$CheckExpiration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePasswordEnterFailure", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "handlePasswordRecoveryFailure", "handlePasswordRecoverySuccessResponse", "result", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySuccessResponse;", "recoverPassword", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BasePasswordEnterInteractorImpl implements BasePasswordEnterInteractor {
    private final Origin origin;
    private final PasswordRecoveryRepository passwordRecoveryRepository;
    private final YooProfiler profiler;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl", f = "BasePasswordEnterInteractor.kt", l = {41, 43}, m = "recoverPassword")
    public static final class a extends ContinuationImpl {
        public BasePasswordEnterInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return BasePasswordEnterInteractorImpl.this.recoverPassword(this);
        }
    }

    public BasePasswordEnterInteractorImpl(PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, Origin origin, YooProfiler profiler) {
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        this.passwordRecoveryRepository = passwordRecoveryRepository;
        this.serverTimeRepository = serverTimeRepository;
        this.origin = origin;
        this.profiler = profiler;
    }

    private final PasswordEnter.Action handlePasswordRecoveryFailure(Failure failure) {
        if (failure instanceof FeatureFailure) {
            FeatureFailure featureFailure = (FeatureFailure) failure;
            if (featureFailure.getError() instanceof ErrorContactTechnicalSupport) {
                return new PasswordEnter.Action.PasswordRecoveryTechnicalFailure(featureFailure);
            }
        }
        return new PasswordEnter.Action.PasswordRecoveryFailure(failure);
    }

    private final PasswordEnter.Action handlePasswordRecoverySuccessResponse(PasswordRecoverySuccessResponse result) {
        PasswordRecoveryProcess process = result.getProcess();
        return process instanceof PasswordRecoveryProcessFailure ? handlePasswordRecoveryFailure(ProcessErrorExtensionsKt.toFailure(((PasswordRecoveryProcessFailure) process).getError())) : new PasswordEnter.Action.PasswordRecoverySuccess(process);
    }

    @Override // ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractor
    public final Object checkExpiration(PasswordEnter.Action.CheckExpiration checkExpiration, Continuation<? super PasswordEnter.Action> continuation) {
        return checkExpiration.getExpireAt().isAfter(this.serverTimeRepository.getCurrentDateTime()) ? new PasswordEnter.Action.Submit(checkExpiration.getPassword(), checkExpiration.getProcessType(), checkExpiration.getProcessId()) : PasswordEnter.Action.Expired.INSTANCE;
    }

    public final PasswordEnter.Action handlePasswordEnterFailure(Failure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        return failure instanceof FeatureFailure ? new PasswordEnter.Action.PasswordEnterFeatureFailure((FeatureFailure) failure) : new PasswordEnter.Action.PasswordEnterFailure(failure);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object recoverPassword(kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.password.enter.PasswordEnter.Action> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L68
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L53
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r10 = r9.serverTimeRepository
            r0.a = r9
            r0.d = r4
            java.lang.Object r10 = r10.init(r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            r2 = r9
        L53:
            ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository r10 = r2.passwordRecoveryRepository
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryIdentifierRequest r4 = new ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryIdentifierRequest
            ru.yoomoney.sdk.auth.api.Origin r5 = r2.origin
            r4.<init>(r5)
            r0.a = r2
            r0.d = r3
            java.lang.Object r10 = r10.mo3292passwordRecoverygIAlus(r4, r0)
            if (r10 != r1) goto L67
            return r1
        L67:
            r0 = r2
        L68:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r10)
            if (r1 == 0) goto L89
            r1 = r10
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse r1 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse) r1
            boolean r2 = r1 instanceof ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse
            if (r2 == 0) goto L89
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse r1 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse) r1
            java.lang.String r3 = r1.getTmxSessionId()
            if (r3 == 0) goto L89
            ru.yoomoney.sdk.yooprofiler.YooProfiler r2 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r4 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.PASSWORD_RESET
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r2, r3, r4, r5, r6, r7, r8)
        L89:
            java.lang.Throwable r1 = kotlin.Result.m2631exceptionOrNullimpl(r10)
            if (r1 != 0) goto L9d
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse r10 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse) r10
            java.lang.String r1 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r1)
            ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse r10 = (ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySuccessResponse) r10
            ru.yoomoney.sdk.auth.password.enter.PasswordEnter$Action r10 = r0.handlePasswordRecoverySuccessResponse(r10)
            goto La8
        L9d:
            java.lang.String r10 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r10)
            ru.yoomoney.sdk.auth.api.model.Failure r1 = (ru.yoomoney.sdk.auth.api.model.Failure) r1
            ru.yoomoney.sdk.auth.password.enter.PasswordEnter$Action r10 = r0.handlePasswordRecoveryFailure(r1)
        La8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractorImpl.recoverPassword(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
