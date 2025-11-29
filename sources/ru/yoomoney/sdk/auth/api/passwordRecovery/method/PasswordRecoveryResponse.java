package ru.yoomoney.sdk.auth.api.passwordRecovery.method;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.passwordRecovery.deserializer.PasswordRecoveryResponseDeserializer;

@JsonAdapter(PasswordRecoveryResponseDeserializer.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryResponse;", "", "()V", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySuccessResponse;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PasswordRecoveryResponse {
    private PasswordRecoveryResponse() {
    }

    public /* synthetic */ PasswordRecoveryResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
