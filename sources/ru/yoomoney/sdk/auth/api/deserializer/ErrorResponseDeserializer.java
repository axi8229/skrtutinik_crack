package ru.yoomoney.sdk.auth.api.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.emailChange.deserializer.a;
import ru.yoomoney.sdk.auth.api.model.ErrorResponse;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersErrorResponse;
import ru.yoomoney.sdk.auth.api.model.InvalidTokenErrorResponse;
import ru.yoomoney.sdk.auth.api.model.RulesViolationErrorResponse;
import ru.yoomoney.sdk.auth.api.model.TechnicalErrorResponse;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/deserializer/ErrorResponseDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lru/yoomoney/sdk/auth/api/model/ErrorResponse;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorResponseDeserializer implements JsonDeserializer<ErrorResponse> {
    @Override // com.google.gson.JsonDeserializer
    public ErrorResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Type type;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonObject asJsonObject = a.a(typeOfT, "typeOfT", context, "context", json).get("error").getAsJsonObject();
        String asString = asJsonObject.get("type").getAsString();
        if (asString != null) {
            int iHashCode = asString.hashCode();
            if (iHashCode != 681234018) {
                if (iHashCode != 866301289) {
                    if (iHashCode == 1924634080 && asString.equals("IllegalParameters")) {
                        type = IllegalParametersErrorResponse.class;
                        Object objDeserialize = context.deserialize(asJsonObject, type);
                        Intrinsics.checkNotNullExpressionValue(objDeserialize, "deserialize(...)");
                        return (ErrorResponse) objDeserialize;
                    }
                } else if (asString.equals("RuleViolation")) {
                    type = RulesViolationErrorResponse.class;
                    Object objDeserialize2 = context.deserialize(asJsonObject, type);
                    Intrinsics.checkNotNullExpressionValue(objDeserialize2, "deserialize(...)");
                    return (ErrorResponse) objDeserialize2;
                }
            } else if (asString.equals("InvalidToken")) {
                return InvalidTokenErrorResponse.INSTANCE;
            }
        }
        JsonElement jsonElement = asJsonObject.get("retryAfter");
        return new TechnicalErrorResponse(jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null);
    }
}
