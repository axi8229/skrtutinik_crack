package com.sputnik.domain.entities.service_payments;

import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainPartnerInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001e\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001f\u0010\u0010R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b \u0010\u0010R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lcom/sputnik/domain/entities/service_payments/DomainPartnerInfo;", "", "", "organisation", "contactPhone", "address", "", "", "workingDays", "firstWorkingHour", "lastWorkingHour", "weekendFirstWorkingHour", "weekendLastWorkingHour", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOrganisation", "getContactPhone", "getAddress", "Ljava/util/List;", "getWorkingDays", "()Ljava/util/List;", "getFirstWorkingHour", "getLastWorkingHour", "getWeekendFirstWorkingHour", "getWeekendLastWorkingHour", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainPartnerInfo {
    private final String address;
    private final String contactPhone;
    private final String firstWorkingHour;
    private final String lastWorkingHour;
    private final String organisation;
    private final String weekendFirstWorkingHour;
    private final String weekendLastWorkingHour;
    private final List<Integer> workingDays;

    public DomainPartnerInfo() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPartnerInfo)) {
            return false;
        }
        DomainPartnerInfo domainPartnerInfo = (DomainPartnerInfo) other;
        return Intrinsics.areEqual(this.organisation, domainPartnerInfo.organisation) && Intrinsics.areEqual(this.contactPhone, domainPartnerInfo.contactPhone) && Intrinsics.areEqual(this.address, domainPartnerInfo.address) && Intrinsics.areEqual(this.workingDays, domainPartnerInfo.workingDays) && Intrinsics.areEqual(this.firstWorkingHour, domainPartnerInfo.firstWorkingHour) && Intrinsics.areEqual(this.lastWorkingHour, domainPartnerInfo.lastWorkingHour) && Intrinsics.areEqual(this.weekendFirstWorkingHour, domainPartnerInfo.weekendFirstWorkingHour) && Intrinsics.areEqual(this.weekendLastWorkingHour, domainPartnerInfo.weekendLastWorkingHour);
    }

    public int hashCode() {
        String str = this.organisation;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.contactPhone;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.address;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Integer> list = this.workingDays;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.firstWorkingHour;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.lastWorkingHour;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.weekendFirstWorkingHour;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.weekendLastWorkingHour;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "DomainPartnerInfo(organisation=" + this.organisation + ", contactPhone=" + this.contactPhone + ", address=" + this.address + ", workingDays=" + this.workingDays + ", firstWorkingHour=" + this.firstWorkingHour + ", lastWorkingHour=" + this.lastWorkingHour + ", weekendFirstWorkingHour=" + this.weekendFirstWorkingHour + ", weekendLastWorkingHour=" + this.weekendLastWorkingHour + ")";
    }

    public DomainPartnerInfo(String str, String str2, String str3, List<Integer> list, String str4, String str5, String str6, String str7) {
        this.organisation = str;
        this.contactPhone = str2;
        this.address = str3;
        this.workingDays = list;
        this.firstWorkingHour = str4;
        this.lastWorkingHour = str5;
        this.weekendFirstWorkingHour = str6;
        this.weekendLastWorkingHour = str7;
    }

    public /* synthetic */ DomainPartnerInfo(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
    }

    public final String getOrganisation() {
        return this.organisation;
    }

    public final String getContactPhone() {
        return this.contactPhone;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<Integer> getWorkingDays() {
        return this.workingDays;
    }

    public final String getFirstWorkingHour() {
        return this.firstWorkingHour;
    }

    public final String getLastWorkingHour() {
        return this.lastWorkingHour;
    }

    public final String getWeekendFirstWorkingHour() {
        return this.weekendFirstWorkingHour;
    }

    public final String getWeekendLastWorkingHour() {
        return this.weekendLastWorkingHour;
    }
}
