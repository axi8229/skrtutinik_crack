package ru.yoomoney.sdk.kassa.payments.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import kotlin.Metadata;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod.PaymentMethodDeserializer;
import ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod.PaymentMethodResponse;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"jacksonBaseObjectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getJacksonBaseObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JacksonBaseObjectMapperKt {
    private static final ObjectMapper jacksonBaseObjectMapper;

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(PaymentOptionResponse.class, new c());
        simpleModule.addDeserializer(PaymentMethodResponse.class, new PaymentMethodDeserializer());
        objectMapper.registerModule(simpleModule);
        jacksonBaseObjectMapper = ExtensionsKt.registerKotlinModule(objectMapper);
    }

    public static final ObjectMapper getJacksonBaseObjectMapper() {
        return jacksonBaseObjectMapper;
    }
}
