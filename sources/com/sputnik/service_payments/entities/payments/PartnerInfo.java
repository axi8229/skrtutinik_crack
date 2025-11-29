package com.sputnik.service_payments.entities.payments;

import com.sputnik.common.entities.localization.CommonDaysShort;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PartnerInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u0014R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\"\u0010\u0014R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b#\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b$\u0010\u0014R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b%\u0010\u0014¨\u0006&"}, d2 = {"Lcom/sputnik/service_payments/entities/payments/PartnerInfo;", "", "", "organisation", "contactPhone", "address", "", "", "workingDays", "firstWorkingHour", "lastWorkingHour", "weekendFirstWorkingHour", "weekendLastWorkingHour", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/sputnik/common/entities/localization/CommonDaysShort;", "days", "getWorkingHoursString", "(Lcom/sputnik/common/entities/localization/CommonDaysShort;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOrganisation", "getContactPhone", "getAddress", "Ljava/util/List;", "getWorkingDays", "()Ljava/util/List;", "getFirstWorkingHour", "getLastWorkingHour", "getWeekendFirstWorkingHour", "getWeekendLastWorkingHour", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PartnerInfo {
    private final String address;
    private final String contactPhone;
    private final String firstWorkingHour;
    private final String lastWorkingHour;
    private final String organisation;
    private final String weekendFirstWorkingHour;
    private final String weekendLastWorkingHour;
    private final List<Integer> workingDays;

    public PartnerInfo() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartnerInfo)) {
            return false;
        }
        PartnerInfo partnerInfo = (PartnerInfo) other;
        return Intrinsics.areEqual(this.organisation, partnerInfo.organisation) && Intrinsics.areEqual(this.contactPhone, partnerInfo.contactPhone) && Intrinsics.areEqual(this.address, partnerInfo.address) && Intrinsics.areEqual(this.workingDays, partnerInfo.workingDays) && Intrinsics.areEqual(this.firstWorkingHour, partnerInfo.firstWorkingHour) && Intrinsics.areEqual(this.lastWorkingHour, partnerInfo.lastWorkingHour) && Intrinsics.areEqual(this.weekendFirstWorkingHour, partnerInfo.weekendFirstWorkingHour) && Intrinsics.areEqual(this.weekendLastWorkingHour, partnerInfo.weekendLastWorkingHour);
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
        return "PartnerInfo(organisation=" + this.organisation + ", contactPhone=" + this.contactPhone + ", address=" + this.address + ", workingDays=" + this.workingDays + ", firstWorkingHour=" + this.firstWorkingHour + ", lastWorkingHour=" + this.lastWorkingHour + ", weekendFirstWorkingHour=" + this.weekendFirstWorkingHour + ", weekendLastWorkingHour=" + this.weekendLastWorkingHour + ")";
    }

    public PartnerInfo(String str, String str2, String str3, List<Integer> list, String str4, String str5, String str6, String str7) {
        this.organisation = str;
        this.contactPhone = str2;
        this.address = str3;
        this.workingDays = list;
        this.firstWorkingHour = str4;
        this.lastWorkingHour = str5;
        this.weekendFirstWorkingHour = str6;
        this.weekendLastWorkingHour = str7;
    }

    public /* synthetic */ PartnerInfo(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final String getWorkingHoursString(CommonDaysShort days) {
        String str;
        Intrinsics.checkNotNullParameter(days, "days");
        String str2 = this.firstWorkingHour + "-" + this.lastWorkingHour;
        String str3 = this.weekendFirstWorkingHour + "-" + this.weekendLastWorkingHour;
        List<Integer> list = this.workingDays;
        List listSorted = list != null ? CollectionsKt.sorted(list) : null;
        Integer numValueOf = listSorted != null ? Integer.valueOf(listSorted.size()) : null;
        if (numValueOf != null && numValueOf.intValue() == 7) {
            return days.getMonday() + "-" + days.getFriday() + ", " + str2 + ";\n" + days.getSaturday() + "," + days.getSunday() + ", " + str3;
        }
        String str4 = "";
        if (listSorted == null) {
            return "";
        }
        if (listSorted.contains(0) && listSorted.contains(1) && listSorted.contains(2) && listSorted.contains(3) && listSorted.contains(4) && listSorted.contains(5)) {
            return days.getMonday() + "-" + days.getFriday() + ", " + str2 + ";\n" + days.getSaturday() + ", " + str3;
        }
        if (listSorted.contains(0) && listSorted.contains(1) && listSorted.contains(2) && listSorted.contains(3) && listSorted.contains(4) && listSorted.contains(6)) {
            return days.getMonday() + "-" + days.getFriday() + ", " + str2 + ";\n" + days.getSunday() + ", " + str3;
        }
        if (listSorted.contains(0) && listSorted.contains(1) && listSorted.contains(2) && listSorted.contains(3) && listSorted.contains(4)) {
            return days.getMonday() + "-" + days.getFriday() + ", " + str2;
        }
        Iterator it = listSorted.iterator();
        while (it.hasNext()) {
            switch (((Number) it.next()).intValue()) {
                case 0:
                    str = ((Object) str4) + days.getMonday() + ",";
                    str4 = str;
                    break;
                case 1:
                    str = ((Object) str4) + days.getTuesday() + ",";
                    str4 = str;
                    break;
                case 2:
                    str = ((Object) str4) + days.getWednesday() + ",";
                    str4 = str;
                    break;
                case 3:
                    str = ((Object) str4) + days.getThursday() + ",";
                    str4 = str;
                    break;
                case 4:
                    str = ((Object) str4) + days.getFriday() + ", " + str2 + ";\n";
                    str4 = str;
                    break;
                case 5:
                    str = ((Object) str4) + days.getSaturday() + ",";
                    str4 = str;
                    break;
                case 6:
                    str = ((Object) str4) + days.getSunday() + ", " + str3;
                    str4 = str;
                    break;
            }
        }
        return StringsKt.dropLast(str4, 1);
    }
}
