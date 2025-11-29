package com.sputnik.domain.entities.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;

/* compiled from: DomainProfileCardInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/sputnik/domain/entities/profile/DomainProfileCardInfo;", "", "", "first6", "last4", BankCardViewKt.EXTRA_EXPIRY_MONTH, BankCardViewKt.EXTRA_EXPIRY_YEAR, "cardType", "issuerCountry", "issuerName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFirst6", "getLast4", "getExpiryMonth", "getExpiryYear", "getCardType", "getIssuerCountry", "getIssuerName", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainProfileCardInfo {
    private final String cardType;
    private final String expiryMonth;
    private final String expiryYear;
    private final String first6;
    private final String issuerCountry;
    private final String issuerName;
    private final String last4;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainProfileCardInfo)) {
            return false;
        }
        DomainProfileCardInfo domainProfileCardInfo = (DomainProfileCardInfo) other;
        return Intrinsics.areEqual(this.first6, domainProfileCardInfo.first6) && Intrinsics.areEqual(this.last4, domainProfileCardInfo.last4) && Intrinsics.areEqual(this.expiryMonth, domainProfileCardInfo.expiryMonth) && Intrinsics.areEqual(this.expiryYear, domainProfileCardInfo.expiryYear) && Intrinsics.areEqual(this.cardType, domainProfileCardInfo.cardType) && Intrinsics.areEqual(this.issuerCountry, domainProfileCardInfo.issuerCountry) && Intrinsics.areEqual(this.issuerName, domainProfileCardInfo.issuerName);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.first6.hashCode() * 31) + this.last4.hashCode()) * 31) + this.expiryMonth.hashCode()) * 31) + this.expiryYear.hashCode()) * 31) + this.cardType.hashCode()) * 31) + this.issuerCountry.hashCode()) * 31;
        String str = this.issuerName;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DomainProfileCardInfo(first6=" + this.first6 + ", last4=" + this.last4 + ", expiryMonth=" + this.expiryMonth + ", expiryYear=" + this.expiryYear + ", cardType=" + this.cardType + ", issuerCountry=" + this.issuerCountry + ", issuerName=" + this.issuerName + ")";
    }

    public DomainProfileCardInfo(String first6, String last4, String expiryMonth, String expiryYear, String cardType, String issuerCountry, String str) {
        Intrinsics.checkNotNullParameter(first6, "first6");
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(issuerCountry, "issuerCountry");
        this.first6 = first6;
        this.last4 = last4;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cardType = cardType;
        this.issuerCountry = issuerCountry;
        this.issuerName = str;
    }

    public final String getFirst6() {
        return this.first6;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    public final String getExpiryYear() {
        return this.expiryYear;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getIssuerCountry() {
        return this.issuerCountry;
    }

    public final String getIssuerName() {
        return this.issuerName;
    }
}
