package ru.yoomoney.sdk.kassa.payments.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.lang.reflect.GenericDeclaration;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.InstrumentType;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentInstrumentYooMoney;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionBankCard;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionGooglePay;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionSBP;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentOptionSberbank;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Unknown;

/* loaded from: classes5.dex */
public final class c extends JsonDeserializer {
    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public final Object deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec;
        GenericDeclaration genericDeclaration;
        GenericDeclaration genericDeclaration2;
        Intrinsics.checkNotNullParameter(jsonParser, "jsonParser");
        Intrinsics.checkNotNullParameter(ctxt, "ctxt");
        TreeNode valueAsTree = jsonParser.readValueAsTree();
        Intrinsics.checkNotNullExpressionValue(valueAsTree, "readValueAsTree(...)");
        JsonNode jsonNode = (JsonNode) valueAsTree;
        ObjectCodec codec2 = jsonParser.getCodec();
        PaymentMethodTypeNetwork paymentMethodTypeNetwork = (PaymentMethodTypeNetwork) codec2.treeToValue(jsonNode.get("payment_method_type"), PaymentMethodTypeNetwork.class);
        int i = paymentMethodTypeNetwork == null ? -1 : b.a[paymentMethodTypeNetwork.ordinal()];
        if (i != 1) {
            if (i == 2) {
                genericDeclaration2 = PaymentOptionBankCard.class;
            } else if (i == 3) {
                genericDeclaration2 = PaymentOptionSberbank.class;
            } else if (i == 4) {
                genericDeclaration2 = PaymentOptionGooglePay.class;
            } else {
                if (i != 5) {
                    return Unknown.INSTANCE;
                }
                genericDeclaration2 = PaymentOptionSBP.class;
            }
            Object objTreeToValue = codec2.treeToValue(jsonNode, genericDeclaration2);
            Intrinsics.checkNotNullExpressionValue(objTreeToValue, "treeToValue(...)");
            return (PaymentOptionResponse) objTreeToValue;
        }
        if (!jsonNode.has("instrument_type")) {
            Object objTreeToValue2 = jsonParser.getCodec().treeToValue(jsonNode, PaymentInstrumentYooMoney.AbstractYooMoneyWallet.class);
            Intrinsics.checkNotNull(objTreeToValue2);
            return (PaymentOptionResponse) objTreeToValue2;
        }
        InstrumentType instrumentType = (InstrumentType) jsonParser.getCodec().treeToValue(jsonNode.get("instrument_type"), InstrumentType.class);
        int i2 = instrumentType != null ? b.b[instrumentType.ordinal()] : -1;
        if (i2 == 1) {
            codec = jsonParser.getCodec();
            genericDeclaration = PaymentInstrumentYooMoney.PaymentInstrumentYooMoneyWallet.class;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            codec = jsonParser.getCodec();
            genericDeclaration = PaymentInstrumentYooMoney.PaymentInstrumentYooMoneyLinkedBankCard.class;
        }
        PaymentInstrumentYooMoney paymentInstrumentYooMoney = (PaymentInstrumentYooMoney) codec.treeToValue(jsonNode, genericDeclaration);
        Intrinsics.checkNotNull(paymentInstrumentYooMoney);
        return paymentInstrumentYooMoney;
    }
}
