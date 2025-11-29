package ru.yoomoney.sdk.auth.api.account.model;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.account.passwordChange.deserializer.ChangePasswordProcessDeserializer;

@JsonAdapter(ChangePasswordProcessDeserializer.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\u0003\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordProcess;", "Lru/yoomoney/sdk/auth/api/Process;", "()V", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordConfirmEmail;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordConfirmPhone;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordEnterPassword;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordFailure;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordSetPassword;", "Lru/yoomoney/sdk/auth/api/account/model/ChangePasswordSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ChangePasswordProcess implements Process {
    private ChangePasswordProcess() {
    }

    public /* synthetic */ ChangePasswordProcess(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
