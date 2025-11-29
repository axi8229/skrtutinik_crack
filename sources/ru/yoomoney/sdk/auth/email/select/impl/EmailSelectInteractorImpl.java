package ru.yoomoney.sdk.auth.email.select.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailErrorResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.select.EmailSelect;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractorImpl;", "Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractor;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "checkExpiration", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleMigrationSetEmailResponse", "response", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailResponse;", "setEmail", "suggestionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailSelectInteractorImpl implements EmailSelectInteractor {
    private final MigrationRepository migrationRepository;
    private final ServerTimeRepository serverTimeRepository;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractorImpl", f = "EmailSelectInteractor.kt", l = {41, 48}, m = "setEmail")
    public static final class a extends ContinuationImpl {
        public EmailSelectInteractorImpl a;
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
            return EmailSelectInteractorImpl.this.setEmail(null, null, this);
        }
    }

    public EmailSelectInteractorImpl(MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.migrationRepository = migrationRepository;
        this.serverTimeRepository = serverTimeRepository;
    }

    private final EmailSelect.Action handleMigrationSetEmailResponse(MigrationSetEmailResponse response) {
        if (response instanceof MigrationSetEmailSuccessResponse) {
            return new EmailSelect.Action.SendEmailSuccess(((MigrationSetEmailSuccessResponse) response).getProcess());
        }
        if (response instanceof MigrationSetEmailErrorResponse) {
            return new EmailSelect.Action.SendEmailFailure(ProcessErrorExtensionsKt.toFailure(((MigrationSetEmailErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractor
    public Object checkExpiration(String str, OffsetDateTime offsetDateTime, Continuation<? super EmailSelect.Action> continuation) {
        return offsetDateTime.isAfter(this.serverTimeRepository.getCurrentDateTime()) ? new EmailSelect.Action.SendEmail(str) : EmailSelect.Action.Expired.INSTANCE;
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
    @Override // ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setEmail(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.email.select.EmailSelect.Action> r13) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractorImpl.setEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
