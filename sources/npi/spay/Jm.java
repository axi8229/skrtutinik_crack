package npi.spay;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class Jm implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Boolean.valueOf(((ListOfCardsResponseBody.PaymentToolInfo.Tool) obj2).getPriorityCard()), Boolean.valueOf(((ListOfCardsResponseBody.PaymentToolInfo.Tool) obj).getPriorityCard()));
    }
}
