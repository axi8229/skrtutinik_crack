package com.sputnik.domain.entities.support;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainCompanyContacts.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/sputnik/domain/entities/support/DomainCompanyContacts;", "", "", "organization", "address", "supportPhone", "additionalPhone", "", "Lcom/sputnik/domain/entities/support/DomainCompanyContacts$Schedule;", "schedule", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOrganization", "getAddress", "getSupportPhone", "getAdditionalPhone", "Ljava/util/List;", "getSchedule", "()Ljava/util/List;", "Schedule", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainCompanyContacts {
    private final String additionalPhone;
    private final String address;
    private final String organization;
    private final List<Schedule> schedule;
    private final String supportPhone;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainCompanyContacts)) {
            return false;
        }
        DomainCompanyContacts domainCompanyContacts = (DomainCompanyContacts) other;
        return Intrinsics.areEqual(this.organization, domainCompanyContacts.organization) && Intrinsics.areEqual(this.address, domainCompanyContacts.address) && Intrinsics.areEqual(this.supportPhone, domainCompanyContacts.supportPhone) && Intrinsics.areEqual(this.additionalPhone, domainCompanyContacts.additionalPhone) && Intrinsics.areEqual(this.schedule, domainCompanyContacts.schedule);
    }

    public int hashCode() {
        String str = this.organization;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.address;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.supportPhone;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.additionalPhone;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<Schedule> list = this.schedule;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "DomainCompanyContacts(organization=" + this.organization + ", address=" + this.address + ", supportPhone=" + this.supportPhone + ", additionalPhone=" + this.additionalPhone + ", schedule=" + this.schedule + ")";
    }

    public DomainCompanyContacts(String str, String str2, String str3, String str4, List<Schedule> list) {
        this.organization = str;
        this.address = str2;
        this.supportPhone = str3;
        this.additionalPhone = str4;
        this.schedule = list;
    }

    public final String getOrganization() {
        return this.organization;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getSupportPhone() {
        return this.supportPhone;
    }

    public final String getAdditionalPhone() {
        return this.additionalPhone;
    }

    public final List<Schedule> getSchedule() {
        return this.schedule;
    }

    /* compiled from: DomainCompanyContacts.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/sputnik/domain/entities/support/DomainCompanyContacts$Schedule;", "", "", "days", "hours", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDays", "getHours", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Schedule {
        private final String days;
        private final String hours;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Schedule)) {
                return false;
            }
            Schedule schedule = (Schedule) other;
            return Intrinsics.areEqual(this.days, schedule.days) && Intrinsics.areEqual(this.hours, schedule.hours);
        }

        public int hashCode() {
            String str = this.days;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.hours;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Schedule(days=" + this.days + ", hours=" + this.hours + ")";
        }

        public Schedule(String str, String str2) {
            this.days = str;
            this.hours = str2;
        }

        public final String getDays() {
            return this.days;
        }

        public final String getHours() {
            return this.hours;
        }
    }
}
