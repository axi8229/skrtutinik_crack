package ru.yoomoney.sdk.auth.api.passwordRecovery.model;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.passwordRecovery.deserializer.PasswordRecoveryProcessDeserializer;

@JsonAdapter(PasswordRecoveryProcessDeserializer.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\u0003\u0004\u0005\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcess;", "Lru/yoomoney/sdk/auth/api/Process;", "()V", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessChooseAccount;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessConfirmEmail;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessConfirmPhone;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessEnterPhone;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessFailure;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessSetPassword;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/model/PasswordRecoveryProcessSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PasswordRecoveryProcess implements Process {
    private PasswordRecoveryProcess() {
    }

    public /* synthetic */ PasswordRecoveryProcess(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
