package ru.yoomoney.sdk.kassa.payments.api.model.paymentmethod;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/PaymentMethodDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "Lru/yoomoney/sdk/kassa/payments/api/model/paymentmethod/PaymentMethodResponse;", "()V", "deserialize", "jsonParser", "Lcom/fasterxml/jackson/core/JsonParser;", "deserializationContext", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentMethodDeserializer extends JsonDeserializer<PaymentMethodResponse> {
    public static final int $stable = 0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethodTypeNetwork.values().length];
            try {
                iArr[PaymentMethodTypeNetwork.BANK_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public PaymentMethodResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Intrinsics.checkNotNullParameter(jsonParser, "jsonParser");
        TreeNode valueAsTree = jsonParser.readValueAsTree();
        Intrinsics.checkNotNullExpressionValue(valueAsTree, "readValueAsTree(...)");
        JsonNode jsonNode = (JsonNode) valueAsTree;
        ObjectCodec codec = jsonParser.getCodec();
        PaymentMethodTypeNetwork paymentMethodTypeNetwork = (PaymentMethodTypeNetwork) codec.treeToValue(jsonNode.get("type"), PaymentMethodTypeNetwork.class);
        if (paymentMethodTypeNetwork == null || WhenMappings.$EnumSwitchMapping$0[paymentMethodTypeNetwork.ordinal()] != 1) {
            return Unknown.INSTANCE;
        }
        Object objTreeToValue = codec.treeToValue(jsonNode, PaymentMethodBankCardResponse.class);
        Intrinsics.checkNotNullExpressionValue(objTreeToValue, "treeToValue(...)");
        return (PaymentMethodResponse) objTreeToValue;
    }
}
