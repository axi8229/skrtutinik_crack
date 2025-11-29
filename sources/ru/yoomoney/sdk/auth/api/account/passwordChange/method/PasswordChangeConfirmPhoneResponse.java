package ru.yoomoney.sdk.auth.api.account.passwordChange.method;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.account.passwordChange.deserializer.ConfirmPhoneResponseDeserializer;

@JsonAdapter(ConfirmPhoneResponseDeserializer.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResponse;", "", "()V", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneErrorResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneSuccessResponse;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PasswordChangeConfirmPhoneResponse {
    private PasswordChangeConfirmPhoneResponse() {
    }

    public /* synthetic */ PasswordChangeConfirmPhoneResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
