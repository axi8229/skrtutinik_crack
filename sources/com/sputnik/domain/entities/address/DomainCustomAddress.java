package com.sputnik.domain.entities.address;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DomainCustomAddress.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "", "", "uuid", "city", "street", "house", "flat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toStringAddress", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "getCity", "getStreet", "getHouse", "getFlat", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCustomAddress {
    private final String city;
    private final String flat;
    private final String house;
    private final String street;
    private final String uuid;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCustomAddress)) {
            return false;
        }
        DomainCustomAddress domainCustomAddress = (DomainCustomAddress) other;
        return Intrinsics.areEqual(this.uuid, domainCustomAddress.uuid) && Intrinsics.areEqual(this.city, domainCustomAddress.city) && Intrinsics.areEqual(this.street, domainCustomAddress.street) && Intrinsics.areEqual(this.house, domainCustomAddress.house) && Intrinsics.areEqual(this.flat, domainCustomAddress.flat);
    }

    public int hashCode() {
        int iHashCode = this.uuid.hashCode() * 31;
        String str = this.city;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.street;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.house;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.flat;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DomainCustomAddress(uuid=" + this.uuid + ", city=" + this.city + ", street=" + this.street + ", house=" + this.house + ", flat=" + this.flat + ")";
    }

    public DomainCustomAddress(String uuid, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.city = str;
        this.street = str2;
        this.house = str3;
        this.flat = str4;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getStreet() {
        return this.street;
    }

    public final String getHouse() {
        return this.house;
    }

    public final String getFlat() {
        return this.flat;
    }

    public final String toStringAddress() {
        String str;
        String str2;
        String str3;
        String str4 = this.city;
        String str5 = "";
        if (str4 == null || StringsKt.isBlank(str4)) {
            str = "";
        } else {
            str = "г. " + this.city + " ";
        }
        String str6 = this.street;
        if (str6 == null || StringsKt.isBlank(str6)) {
            str2 = "";
        } else {
            str2 = "ул. " + this.street + " ";
        }
        String str7 = this.house;
        if (str7 == null || StringsKt.isBlank(str7)) {
            str3 = "";
        } else {
            str3 = "д. " + this.house + " ";
        }
        String str8 = this.flat;
        if (str8 != null && !StringsKt.isBlank(str8)) {
            str5 = "кв. " + this.flat + " ";
        }
        return str + str2 + str3 + str5;
    }
}
