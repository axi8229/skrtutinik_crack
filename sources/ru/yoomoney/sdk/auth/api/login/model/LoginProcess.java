package ru.yoomoney.sdk.auth.api.login.model;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.login.deserializer.LoginProcessDeserializer;

@JsonAdapter(LoginProcessDeserializer.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "Lru/yoomoney/sdk/auth/api/Process;", "()V", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessAcquireAuthorization;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessChooseAccount;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessConfirmEmail;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessConfirmPhone;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterIdentifier;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterPassword;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessFailure;", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class LoginProcess implements Process {
    private LoginProcess() {
    }

    public /* synthetic */ LoginProcess(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
