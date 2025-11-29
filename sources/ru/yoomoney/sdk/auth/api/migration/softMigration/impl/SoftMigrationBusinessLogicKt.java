package ru.yoomoney.sdk.auth.api.migration.softMigration.impl;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse;
import ru.yoomoney.sdk.auth.api.migration.softMigration.SoftMigration;
import ru.yoomoney.sdk.auth.api.model.Failure;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"transformSoftMigration", "Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$Action;", "result", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationResponse;", "(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/api/migration/softMigration/SoftMigration$Action;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SoftMigrationBusinessLogicKt {
    public static final SoftMigration.Action transformSoftMigration(Object obj) {
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(obj);
        if (thM2631exceptionOrNullimpl != null) {
            Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
            return new SoftMigration.Action.SoftMigrationFailure((Failure) thM2631exceptionOrNullimpl);
        }
        MigrationResponse migrationResponse = (MigrationResponse) obj;
        Intrinsics.checkNotNull(migrationResponse, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse");
        return new SoftMigration.Action.SoftMigrationSuccess(((MigrationSuccessResponse) migrationResponse).getProcess());
    }
}
