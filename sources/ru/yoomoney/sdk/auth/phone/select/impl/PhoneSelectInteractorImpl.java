package ru.yoomoney.sdk.auth.phone.select.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.select.PhoneSelect;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectInteractorImpl;", "Lru/yoomoney/sdk/auth/phone/select/impl/PhoneSelectInteractor;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/phone/select/PhoneSelect$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleMigrationSetPhoneResponse", "result", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneResponse;", "setPhone", "suggestionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneSelectInteractorImpl implements PhoneSelectInteractor {
    private final MigrationRepository migrationRepository;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl", f = "PhoneSelectInteractor.kt", l = {33}, m = "setPhone")
    public static final class a extends ContinuationImpl {
        public PhoneSelectInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return PhoneSelectInteractorImpl.this.setPhone(null, null, this);
        }
    }

    public PhoneSelectInteractorImpl(MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.migrationRepository = migrationRepository;
        this.serverTimeRepository = serverTimeRepository;
    }

    private final PhoneSelect.Action handleMigrationSetPhoneResponse(MigrationSetPhoneResponse result) {
        if (result instanceof MigrationSetPhoneSuccessResponse) {
            return new PhoneSelect.Action.SetPhoneSuccess(((MigrationSetPhoneSuccessResponse) result).getProcess());
        }
        if (result instanceof MigrationSetPhoneErrorResponse) {
            return new PhoneSelect.Action.ShowFailure(ProcessErrorExtensionsKt.toFailure(((MigrationSetPhoneErrorResponse) result).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractor
    public Object checkExpiration(String str, OffsetDateTime offsetDateTime, Continuation<? super PhoneSelect.Action> continuation) {
        return offsetDateTime.isAfter(this.serverTimeRepository.getCurrentDateTime()) ? new PhoneSelect.Action.Submit(str) : PhoneSelect.Action.Expired.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setPhone(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.phone.select.PhoneSelect.Action> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.getValue()
            goto L4f
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.migration.MigrationRepository r7 = r4.migrationRepository
            ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneSuggestionRequest r2 = new ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneSuggestionRequest
            r2.<init>(r6)
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r7.mo3279setPhone0E7RQCE(r5, r2, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r5 = r4
        L4f:
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r7 != 0) goto L5c
            ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse r6 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse) r6
            ru.yoomoney.sdk.auth.phone.select.PhoneSelect$Action r5 = r5.handleMigrationSetPhoneResponse(r6)
            goto L68
        L5c:
            ru.yoomoney.sdk.auth.phone.select.PhoneSelect$Action$ShowFailure r5 = new ru.yoomoney.sdk.auth.phone.select.PhoneSelect$Action$ShowFailure
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r7 = (ru.yoomoney.sdk.auth.api.model.Failure) r7
            r5.<init>(r7)
        L68:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractorImpl.setPhone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
