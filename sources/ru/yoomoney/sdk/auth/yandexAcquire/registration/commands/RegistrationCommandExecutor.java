package ru.yoomoney.sdk.auth.yandexAcquire.registration.commands;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/commands/RegistrationCommandExecutor;", "ACTION", "", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/commands/RegistrationCommand;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "(Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;Lru/yoomoney/sdk/yooprofiler/YooProfiler;)V", "execute", "command", "(Lru/yoomoney/sdk/auth/yandexAcquire/registration/commands/RegistrationCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RegistrationCommandExecutor<ACTION> implements CommandExecutor<ACTION, RegistrationCommand<ACTION>> {
    private final Origin origin;
    private final YooProfiler profiler;
    private final RegistrationV2Repository registrationV2Repository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor", f = "YandexAcquireRegistrationCommands.kt", l = {26}, m = "execute")
    public static final class a extends ContinuationImpl {
        public RegistrationCommandExecutor a;
        public RegistrationCommand b;
        public /* synthetic */ Object c;
        public final /* synthetic */ RegistrationCommandExecutor<ACTION> d;
        public int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RegistrationCommandExecutor<ACTION> registrationCommandExecutor, Continuation<? super a> continuation) {
            super(continuation);
            this.d = registrationCommandExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.execute((RegistrationCommand) null, (Continuation) this);
        }
    }

    public RegistrationCommandExecutor(Origin origin, RegistrationV2Repository registrationV2Repository, YooProfiler profiler) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        this.origin = origin;
        this.registrationV2Repository = registrationV2Repository;
        this.profiler = profiler;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.CommandExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommand<ACTION> r12, kotlin.coroutines.Continuation<? super ACTION> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor.a
            if (r0 == 0) goto L13
            r0 = r13
            ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor$a r0 = (ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor$a r0 = new ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor$a
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommand r12 = r0.b
            ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r13 = r13.getValue()
            goto L55
        L33:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3b:
            kotlin.ResultKt.throwOnFailure(r13)
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository r13 = r11.registrationV2Repository
            ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration$Identifier r2 = new ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration$Identifier
            ru.yoomoney.sdk.auth.api.Origin r4 = r11.origin
            r2.<init>(r4)
            r0.a = r11
            r0.b = r12
            r0.e = r3
            java.lang.Object r13 = r13.mo3297initRegistrationgIAlus(r2, r0)
            if (r13 != r1) goto L54
            return r1
        L54:
            r0 = r11
        L55:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r13)
            if (r1 == 0) goto L9d
            r1 = r13
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit r1 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit) r1
            java.lang.String r2 = r1.getTmxSessionId()
            if (r2 == 0) goto L9d
            ru.yoomoney.sdk.yooprofiler.YooProfiler r4 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r6 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.REGISTRATION
            r9 = 12
            r10 = 0
            r7 = 0
            r8 = 0
            r5 = r2
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result r13 = ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = r13 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success
            if (r0 == 0) goto L7d
            ru.yoomoney.sdk.yooprofiler.YooProfiler$Result$Success r13 = (ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Success) r13
            java.lang.String r2 = r13.getSessionId()
            goto L81
        L7d:
            boolean r13 = r13 instanceof ru.yoomoney.sdk.yooprofiler.YooProfiler.Result.Fail
            if (r13 == 0) goto L97
        L81:
            kotlin.jvm.functions.Function1 r12 = r12.getTransform()
            r13 = 0
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit r13 = ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit.copy$default(r1, r13, r2, r3, r13)
            java.lang.Object r13 = kotlin.Result.m2628constructorimpl(r13)
        L8e:
            kotlin.Result r13 = kotlin.Result.m2627boximpl(r13)
            java.lang.Object r12 = r12.invoke(r13)
            return r12
        L97:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        L9d:
            kotlin.jvm.functions.Function1 r12 = r12.getTransform()
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommandExecutor.execute(ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommand, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
