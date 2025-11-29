package ru.yoomoney.sdk.auth.api.serverTime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;
import ru.yoomoney.sdk.auth.api.core.CoreApiRepository;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "coreApiRepository", "Lru/yoomoney/sdk/auth/api/core/CoreApiRepository;", "(Lru/yoomoney/sdk/auth/api/core/CoreApiRepository;)V", "deviceTimeDiff", "", "getCurrentDateTime", "Lorg/threeten/bp/OffsetDateTime;", "getCurrentTimeMillis", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerTimeRepositoryImpl implements ServerTimeRepository {
    private final CoreApiRepository coreApiRepository;
    private long deviceTimeDiff;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl", f = "ServerTimeRepositoryImpl.kt", l = {15}, m = "init")
    public static final class a extends ContinuationImpl {
        public ServerTimeRepositoryImpl a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return ServerTimeRepositoryImpl.this.init(this);
        }
    }

    public ServerTimeRepositoryImpl(CoreApiRepository coreApiRepository) {
        Intrinsics.checkNotNullParameter(coreApiRepository, "coreApiRepository");
        this.coreApiRepository = coreApiRepository;
    }

    @Override // ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository
    public OffsetDateTime getCurrentDateTime() {
        Instant instantOfEpochMilli = Instant.ofEpochMilli(getCurrentTimeMillis());
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        OffsetDateTime offsetDateTimeOf = OffsetDateTime.of(instantOfEpochMilli.atZone(zoneOffset).toLocalDateTime(), zoneOffset);
        Intrinsics.checkNotNullExpressionValue(offsetDateTimeOf, "of(...)");
        return offsetDateTimeOf;
    }

    @Override // ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis() + this.deviceTimeDiff;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object init(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.getValue()
            goto L4a
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.auth.api.core.CoreApiRepository r8 = r7.coreApiRepository
            r0.a = r7
            r0.d = r3
            java.lang.Object r8 = r8.mo3245getUnixTimeIoAF18A(r0)
            if (r8 != r1) goto L49
            return r1
        L49:
            r0 = r7
        L4a:
            java.lang.Throwable r1 = kotlin.Result.m2631exceptionOrNullimpl(r8)
            if (r1 != 0) goto L60
            ru.yoomoney.sdk.auth.api.core.model.UnixTime r8 = (ru.yoomoney.sdk.auth.api.core.model.UnixTime) r8
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r8.getValue()
            r8 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r8
            long r3 = r3 * r5
            long r3 = r3 - r1
            goto L62
        L60:
            r3 = 0
        L62:
            r0.deviceTimeDiff = r3
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl.init(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
