package ru.yoomoney.sdk.kassa.payments.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.JacksonBaseObjectMapperKt;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.HostParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC2334s {
    public static final Config a(String str, HostParameters hostParameters) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hostParameters, "hostParameters");
        Config config = (Config) JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper().readValue(str, Config.class);
        boolean isDevHost = hostParameters.getIsDevHost();
        Intrinsics.checkNotNull(config);
        return isDevHost ? config.copy((575 & 1) != 0 ? config.yooMoneyLogoUrlLight : null, (575 & 2) != 0 ? config.yooMoneyLogoUrlDark : null, (575 & 4) != 0 ? config.paymentMethods : null, (575 & 8) != 0 ? config.savePaymentMethodOptionTexts : null, (575 & 16) != 0 ? config.userAgreementUrl : null, (575 & 32) != 0 ? config.googlePayGateway : null, (575 & 64) != 0 ? config.yooMoneyApiEndpoint : hostParameters.getHost(), (575 & 128) != 0 ? config.yooMoneyPaymentAuthorizationApiEndpoint : hostParameters.getPaymentAuthorizationHost(), (575 & 256) != 0 ? config.yooMoneyAuthApiEndpoint : hostParameters.getAuthHost(), (575 & 512) != 0 ? config.agentSchemeProviderAgreement : null) : config;
    }

    public static final String a(Config config) throws JsonProcessingException {
        Intrinsics.checkNotNullParameter(config, "<this>");
        String strWriteValueAsString = JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper().writeValueAsString(config);
        Intrinsics.checkNotNullExpressionValue(strWriteValueAsString, "writeValueAsString(...)");
        return strWriteValueAsString;
    }
}
