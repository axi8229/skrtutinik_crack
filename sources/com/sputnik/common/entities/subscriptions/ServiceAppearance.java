package com.sputnik.common.entities.subscriptions;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceAppearance.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eBC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/ServiceAppearance;", "", "", "description", "fullDescription", "introduction", "resume", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/subscriptions/ServiceAppearance$ServiceBadges;", "badge", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/subscriptions/ServiceAppearance$ServiceBadges;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getFullDescription", "getIntroduction", "getResume", "getTitle", "Lcom/sputnik/common/entities/subscriptions/ServiceAppearance$ServiceBadges;", "getBadge", "()Lcom/sputnik/common/entities/subscriptions/ServiceAppearance$ServiceBadges;", "ServiceBadges", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServiceAppearance {
    private final ServiceBadges badge;
    private final String description;
    private final String fullDescription;
    private final String introduction;
    private final String resume;
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceAppearance)) {
            return false;
        }
        ServiceAppearance serviceAppearance = (ServiceAppearance) other;
        return Intrinsics.areEqual(this.description, serviceAppearance.description) && Intrinsics.areEqual(this.fullDescription, serviceAppearance.fullDescription) && Intrinsics.areEqual(this.introduction, serviceAppearance.introduction) && Intrinsics.areEqual(this.resume, serviceAppearance.resume) && Intrinsics.areEqual(this.title, serviceAppearance.title) && this.badge == serviceAppearance.badge;
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fullDescription;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.introduction;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resume;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ServiceBadges serviceBadges = this.badge;
        return iHashCode5 + (serviceBadges != null ? serviceBadges.hashCode() : 0);
    }

    public String toString() {
        return "ServiceAppearance(description=" + this.description + ", fullDescription=" + this.fullDescription + ", introduction=" + this.introduction + ", resume=" + this.resume + ", title=" + this.title + ", badge=" + this.badge + ")";
    }

    public ServiceAppearance(String str, String str2, String str3, String str4, String str5, ServiceBadges serviceBadges) {
        this.description = str;
        this.fullDescription = str2;
        this.introduction = str3;
        this.resume = str4;
        this.title = str5;
        this.badge = serviceBadges;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFullDescription() {
        return this.fullDescription;
    }

    public final String getIntroduction() {
        return this.introduction;
    }

    public final String getResume() {
        return this.resume;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ServiceBadges getBadge() {
        return this.badge;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ServiceAppearance.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/ServiceAppearance$ServiceBadges;", "", "(Ljava/lang/String;I)V", "beta", "new", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ServiceBadges {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ServiceBadges[] $VALUES;
        public static final ServiceBadges beta = new ServiceBadges("beta", 0);

        /* renamed from: new, reason: not valid java name */
        public static final ServiceBadges f24new = new ServiceBadges("new", 1);

        private static final /* synthetic */ ServiceBadges[] $values() {
            return new ServiceBadges[]{beta, f24new};
        }

        public static ServiceBadges valueOf(String str) {
            return (ServiceBadges) Enum.valueOf(ServiceBadges.class, str);
        }

        public static ServiceBadges[] values() {
            return (ServiceBadges[]) $VALUES.clone();
        }

        private ServiceBadges(String str, int i) {
        }

        static {
            ServiceBadges[] serviceBadgesArr$values = $values();
            $VALUES = serviceBadgesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(serviceBadgesArr$values);
        }
    }
}
