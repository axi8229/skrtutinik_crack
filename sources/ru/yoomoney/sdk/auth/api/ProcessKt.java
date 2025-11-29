package ru.yoomoney.sdk.auth.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.model.ChangeEmailProcess;
import ru.yoomoney.sdk.auth.api.account.model.ChangePasswordProcess;
import ru.yoomoney.sdk.auth.api.account.model.ChangePhoneProcess;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess;
import ru.yoomoney.sdk.auth.api.passwordRecovery.model.PasswordRecoveryProcess;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toProcessType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "Lru/yoomoney/sdk/auth/api/Process;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessKt {
    public static final ProcessType toProcessType(Process process) {
        Intrinsics.checkNotNullParameter(process, "<this>");
        if (process instanceof EnrollmentProcess) {
            return ProcessType.ENROLLMENT;
        }
        if (process instanceof MigrationProcess) {
            return ProcessType.MIGRATION;
        }
        if (process instanceof LoginProcess) {
            return ProcessType.LOGIN;
        }
        if (process instanceof ChangeEmailProcess) {
            return ProcessType.CHANGE_EMAIL;
        }
        if (process instanceof ChangePhoneProcess) {
            return ProcessType.CHANGE_PHONE;
        }
        if (process instanceof ChangePasswordProcess) {
            return ProcessType.CHANGE_PASSWORD;
        }
        if (process instanceof PasswordRecoveryProcess) {
            return ProcessType.PASSWORD_RECOVERY;
        }
        throw new IllegalArgumentException("no type for process " + process);
    }
}
