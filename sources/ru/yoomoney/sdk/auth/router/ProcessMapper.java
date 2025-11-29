package ru.yoomoney.sdk.auth.router;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/router/ProcessMapper;", "", "toBundle", "Landroid/os/Bundle;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ProcessMapper {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Bundle toBundle(ProcessMapper processMapper, RegistrationProcess process) {
            Intrinsics.checkNotNullParameter(process, "process");
            return new Bundle();
        }
    }

    Bundle toBundle(Process process);

    Bundle toBundle(RegistrationProcess process);
}
