package ru.yoomoney.sdk.auth.password.enter.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/AuthPasswordEnterInteractorImpl;", "Lru/yoomoney/sdk/auth/password/enter/impl/AuthPasswordEnterInteractor;", "Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractorImpl;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "passwordRecoveryRepository", "Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "(Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/yooprofiler/YooProfiler;)V", "enterPassword", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "action", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$Submit;", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$Submit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPasswordLogin", "password", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthPasswordEnterInteractorImpl extends BasePasswordEnterInteractorImpl implements AuthPasswordEnterInteractor {
    private final LoginRepository loginRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.password.enter.impl.AuthPasswordEnterInteractorImpl", f = "AuthPasswordEnterInteractor.kt", l = {45, 52}, m = "enterPasswordLogin")
    public static final class a extends ContinuationImpl {
        public AuthPasswordEnterInteractorImpl a;
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
            return AuthPasswordEnterInteractorImpl.this.enterPasswordLogin(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthPasswordEnterInteractorImpl(LoginRepository loginRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, Origin origin, YooProfiler profiler) {
        super(passwordRecoveryRepository, serverTimeRepository, origin, profiler);
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(passwordRecoveryRepository, "passwordRecoveryRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        this.loginRepository = loginRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b2 -> B:45:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enterPasswordLogin(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.password.enter.PasswordEnter.Action> r13) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.password.enter.impl.AuthPasswordEnterInteractorImpl.enterPasswordLogin(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.password.enter.impl.BasePasswordEnterInteractor
    public Object enterPassword(PasswordEnter.Action.Submit submit, Continuation<? super PasswordEnter.Action> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[submit.getProcessType().ordinal()];
        if (i == 1) {
            return enterPasswordLogin(submit.getPassword(), submit.getProcessId(), continuation);
        }
        if (i == 2) {
            return recoverPassword(continuation);
        }
        throw new IllegalArgumentException("no command for interaction " + this);
    }
}
