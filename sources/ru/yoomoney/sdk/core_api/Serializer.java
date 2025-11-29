package ru.yoomoney.sdk.core_api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;
import ru.yoomoney.sdk.core_api.deserializer.LocalDateTimeDeserializer;
import ru.yoomoney.sdk.core_api.deserializer.LocalDateTimeSerializer;

/* compiled from: Serializer.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/core_api/Serializer;", "", "()V", "jacksonObjectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getJacksonObjectMapper$annotations", "getJacksonObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Serializer {
    public static final Serializer INSTANCE = new Serializer();
    private static final ObjectMapper jacksonObjectMapper;

    @JvmStatic
    public static /* synthetic */ void getJacksonObjectMapper$annotations() {
    }

    private Serializer() {
    }

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        simpleModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        ObjectMapper objectMapperRegisterModule = objectMapper.registerModule(simpleModule);
        Intrinsics.checkNotNullExpressionValue(objectMapperRegisterModule, "run(...)");
        jacksonObjectMapper = objectMapperRegisterModule;
    }

    public static final ObjectMapper getJacksonObjectMapper() {
        return jacksonObjectMapper;
    }
}
