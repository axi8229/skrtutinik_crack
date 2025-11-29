package com.sputnik.domain.entities.invites;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainInvite.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/sputnik/domain/entities/invites/DomainInvite;", "", "", "id", "phone", "state", "flatUuid", "flatNumber", "fullAddress", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getPhone", "getState", "getFlatUuid", "getFlatNumber", "getFullAddress", "getSource", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainInvite {
    private final String flatNumber;
    private final String flatUuid;
    private final String fullAddress;
    private final String id;
    private final String phone;
    private final String source;
    private final String state;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainInvite)) {
            return false;
        }
        DomainInvite domainInvite = (DomainInvite) other;
        return Intrinsics.areEqual(this.id, domainInvite.id) && Intrinsics.areEqual(this.phone, domainInvite.phone) && Intrinsics.areEqual(this.state, domainInvite.state) && Intrinsics.areEqual(this.flatUuid, domainInvite.flatUuid) && Intrinsics.areEqual(this.flatNumber, domainInvite.flatNumber) && Intrinsics.areEqual(this.fullAddress, domainInvite.fullAddress) && Intrinsics.areEqual(this.source, domainInvite.source);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.phone;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.state;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.flatUuid;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.flatNumber;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fullAddress;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.source;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "DomainInvite(id=" + this.id + ", phone=" + this.phone + ", state=" + this.state + ", flatUuid=" + this.flatUuid + ", flatNumber=" + this.flatNumber + ", fullAddress=" + this.fullAddress + ", source=" + this.source + ")";
    }

    public DomainInvite(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.id = str;
        this.phone = str2;
        this.state = str3;
        this.flatUuid = str4;
        this.flatNumber = str5;
        this.fullAddress = str6;
        this.source = str7;
    }

    public /* synthetic */ DomainInvite(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? null : str7);
    }

    public final String getId() {
        return this.id;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getState() {
        return this.state;
    }

    public final String getFlatUuid() {
        return this.flatUuid;
    }

    public final String getFlatNumber() {
        return this.flatNumber;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getSource() {
        return this.source;
    }
}
