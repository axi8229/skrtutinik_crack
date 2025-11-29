package ru.yoomoney.sdk.auth.api.passwordRecovery.method;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.passwordRecovery.deserializer.ConfirmPhoneResendDeserializer;

@JsonAdapter(ConfirmPhoneResendDeserializer.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResendResponse;", "", "()V", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResendErrorResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResendSuccessResponse;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PasswordRecoveryConfirmPhoneResendResponse {
    private PasswordRecoveryConfirmPhoneResendResponse() {
    }

    public /* synthetic */ PasswordRecoveryConfirmPhoneResendResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
