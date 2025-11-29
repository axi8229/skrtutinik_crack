package ru.yoomoney.sdk.auth.yandexAcquire.login.commands;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/LoginCommandExecutor;", "ACTION", "", "Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/LoginCommand;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "(Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/yooprofiler/YooProfiler;)V", "execute", "command", "(Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/LoginCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoginCommandExecutor<ACTION> implements CommandExecutor<ACTION, LoginCommand<ACTION>> {
    private final LoginRepository loginRepository;
    private final Origin origin;
    private final YooProfiler profiler;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor", f = "YandexAcquireLoginCommands.kt", l = {26}, m = "execute")
    public static final class a extends ContinuationImpl {
        public LoginCommandExecutor a;
        public LoginCommand b;
        public /* synthetic */ Object c;
        public final /* synthetic */ LoginCommandExecutor<ACTION> d;
        public int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LoginCommandExecutor<ACTION> loginCommandExecutor, Continuation<? super a> continuation) {
            super(continuation);
            this.d = loginCommandExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.execute((LoginCommand) null, (Continuation) this);
        }
    }

    public LoginCommandExecutor(Origin origin, LoginRepository loginRepository, YooProfiler profiler) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        this.origin = origin;
        this.loginRepository = loginRepository;
        this.profiler = profiler;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.yandexAcquire.login.commands.CommandExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommand<ACTION> r13, kotlin.coroutines.Continuation<? super ACTION> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor.a
            if (r0 == 0) goto L13
            r0 = r14
            ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor$a r0 = (ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor$a r0 = new ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor$a
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommand r13 = r0.b
            ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r14 = r14.getValue()
            goto L56
        L34:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3c:
            kotlin.ResultKt.throwOnFailure(r14)
            ru.yoomoney.sdk.auth.api.login.LoginRepository r14 = r12.loginRepository
            ru.yoomoney.sdk.auth.api.login.method.LoginIdentifierRequest r2 = new ru.yoomoney.sdk.auth.api.login.method.LoginIdentifierRequest
            ru.yoomoney.sdk.auth.api.Origin r5 = r12.origin
            r2.<init>(r5, r3)
            r0.a = r12
            r0.b = r13
            r0.e = r4
            java.lang.Object r14 = r14.mo3270logingIAlus(r2, r0)
            if (r14 != r1) goto L55
            return r1
        L55:
            r0 = r12
        L56:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r14)
            if (r1 == 0) goto La3
            r1 = r14
            ru.yoomoney.sdk.auth.api.login.method.LoginResponse r1 = (ru.yoomoney.sdk.auth.api.login.method.LoginResponse) r1
            boolean r2 = r1 instanceof ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse
            if (r2 == 0) goto La3
            ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse r1 = (ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse) r1
            java.lang.String r2 = r1.getTmxSessionId()
            if (r2 == 0) goto La3
            ru.yoomoney.sdk.yooprofiler.YooProfiler r5 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r7 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.LOGIN
            r10 = 12
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r2
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result r14 = ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = r14 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success
            if (r0 == 0) goto L84
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Success r14 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success) r14
            java.lang.String r2 = r14.getSessionId()
            goto L88
        L84:
            boolean r14 = r14 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail
            if (r14 == 0) goto L9d
        L88:
            kotlin.jvm.functions.Function1 r13 = r13.getTransform()
            ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse r14 = ru.yoomoney.sdk.auth.api.login.method.LoginSuccessResponse.copy$default(r1, r3, r2, r4, r3)
            java.lang.Object r14 = kotlin.Result.m2628constructorimpl(r14)
        L94:
            kotlin.Result r14 = kotlin.Result.m2627boximpl(r14)
            java.lang.Object r13 = r13.invoke(r14)
            return r13
        L9d:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        La3:
            kotlin.jvm.functions.Function1 r13 = r13.getTransform()
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommandExecutor.execute(ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommand, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
