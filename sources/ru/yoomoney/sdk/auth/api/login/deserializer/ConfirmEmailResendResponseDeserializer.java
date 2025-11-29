package ru.yoomoney.sdk.auth.api.login.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.emailChange.deserializer.a;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendErrorResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendSuccessResponse;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/deserializer/ConfirmEmailResendResponseDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResendResponse;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfirmEmailResendResponseDeserializer implements JsonDeserializer<LoginConfirmEmailResendResponse> {
    @Override // com.google.gson.JsonDeserializer
    public LoginConfirmEmailResendResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.checkNotNullParameter(json, "json");
        LoginConfirmEmailResendResponse loginConfirmEmailResendResponse = (LoginConfirmEmailResendResponse) context.deserialize(json, a.a(typeOfT, "typeOfT", context, "context", json).has("error") ? LoginConfirmEmailResendErrorResponse.class : LoginConfirmEmailResendSuccessResponse.class);
        Intrinsics.checkNotNullExpressionValue(loginConfirmEmailResendResponse, "with(...)");
        return loginConfirmEmailResendResponse;
    }
}
