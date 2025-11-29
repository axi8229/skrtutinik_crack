package com.sputnik.domain.entities.market.subscription;

import com.sputnik.domain.entities.card.PaymentState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainSubscriptionStart.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionStart;", "", "", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionInfo;", "subscription", "", "delayed", "Lcom/sputnik/domain/entities/card/PaymentState;", "paymentState", "", "confirmationUrl", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/card/PaymentState;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSubscription", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getDelayed", "()Ljava/lang/Boolean;", "Lcom/sputnik/domain/entities/card/PaymentState;", "getPaymentState", "()Lcom/sputnik/domain/entities/card/PaymentState;", "Ljava/lang/String;", "getConfirmationUrl", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainSubscriptionStart {
    private final String confirmationUrl;
    private final Boolean delayed;
    private final PaymentState paymentState;
    private final List<DomainSubscriptionInfo> subscription;

    public DomainSubscriptionStart() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSubscriptionStart)) {
            return false;
        }
        DomainSubscriptionStart domainSubscriptionStart = (DomainSubscriptionStart) other;
        return Intrinsics.areEqual(this.subscription, domainSubscriptionStart.subscription) && Intrinsics.areEqual(this.delayed, domainSubscriptionStart.delayed) && this.paymentState == domainSubscriptionStart.paymentState && Intrinsics.areEqual(this.confirmationUrl, domainSubscriptionStart.confirmationUrl);
    }

    public int hashCode() {
        List<DomainSubscriptionInfo> list = this.subscription;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.delayed;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        PaymentState paymentState = this.paymentState;
        int iHashCode3 = (iHashCode2 + (paymentState == null ? 0 : paymentState.hashCode())) * 31;
        String str = this.confirmationUrl;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DomainSubscriptionStart(subscription=" + this.subscription + ", delayed=" + this.delayed + ", paymentState=" + this.paymentState + ", confirmationUrl=" + this.confirmationUrl + ")";
    }

    public DomainSubscriptionStart(List<DomainSubscriptionInfo> list, Boolean bool, PaymentState paymentState, String str) {
        this.subscription = list;
        this.delayed = bool;
        this.paymentState = paymentState;
        this.confirmationUrl = str;
    }

    public /* synthetic */ DomainSubscriptionStart(List list, Boolean bool, PaymentState paymentState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : paymentState, (i & 8) != 0 ? null : str);
    }

    public final String getConfirmationUrl() {
        return this.confirmationUrl;
    }
}
