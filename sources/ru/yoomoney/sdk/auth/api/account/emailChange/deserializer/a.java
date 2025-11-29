package ru.yoomoney.sdk.auth.api.account.emailChange.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static JsonObject a(Type type, String str, JsonDeserializationContext jsonDeserializationContext, String str2, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(type, str);
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, str2);
        return jsonElement.getAsJsonObject();
    }
}
