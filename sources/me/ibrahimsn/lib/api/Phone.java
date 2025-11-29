package me.ibrahimsn.lib.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Phone.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Lme/ibrahimsn/lib/api/Phone;", "", "", "nationalNumber", "", "countryCode", "", "rawInput", "numberOfLeadingZeros", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getNationalNumber", "()Ljava/lang/Long;", "Ljava/lang/Integer;", "getCountryCode", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getRawInput", "getNumberOfLeadingZeros", "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Phone {
    private final Integer countryCode;
    private final Long nationalNumber;
    private final Integer numberOfLeadingZeros;
    private final String rawInput;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) other;
        return Intrinsics.areEqual(this.nationalNumber, phone.nationalNumber) && Intrinsics.areEqual(this.countryCode, phone.countryCode) && Intrinsics.areEqual(this.rawInput, phone.rawInput) && Intrinsics.areEqual(this.numberOfLeadingZeros, phone.numberOfLeadingZeros);
    }

    public int hashCode() {
        Long l = this.nationalNumber;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.countryCode;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.rawInput;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.numberOfLeadingZeros;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "Phone(nationalNumber=" + this.nationalNumber + ", countryCode=" + this.countryCode + ", rawInput=" + this.rawInput + ", numberOfLeadingZeros=" + this.numberOfLeadingZeros + ")";
    }

    public Phone(Long l, Integer num, String str, Integer num2) {
        this.nationalNumber = l;
        this.countryCode = num;
        this.rawInput = str;
        this.numberOfLeadingZeros = num2;
    }

    public final Integer getCountryCode() {
        return this.countryCode;
    }
}
