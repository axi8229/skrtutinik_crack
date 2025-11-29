package ru.yoomoney.sdk.auth.api.migration.hardMigration.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.hardMigration.HardMigration;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse;
import ru.yoomoney.sdk.auth.api.model.Failure;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"handleMigrationSuccessResponse", "Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "response", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationResponse;", "migrationTransform", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/api/migration/hardMigration/HardMigration$Action;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardMigrationBusinessLogicKt {
    private static final HardMigration.Action handleMigrationSuccessResponse(MigrationResponse migrationResponse) {
        if (migrationResponse instanceof MigrationSuccessResponse) {
            return new HardMigration.Action.MigrationSuccess(((MigrationSuccessResponse) migrationResponse).getProcess());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final HardMigration.Action migrationTransform(Object obj) {
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(obj);
        if (thM2631exceptionOrNullimpl == null) {
            return handleMigrationSuccessResponse((MigrationResponse) obj);
        }
        Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
        return new HardMigration.Action.ShowFailure((Failure) thM2631exceptionOrNullimpl);
    }
}
