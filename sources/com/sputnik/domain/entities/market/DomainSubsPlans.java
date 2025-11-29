package com.sputnik.domain.entities.market;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Deprecated;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainSubsPlans.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000254Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fBk\b\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000e\u0010\u0013J(\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017HÇ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJp\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b-\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b1\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b2\u0010\u001fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b3\u0010\u001f¨\u00066"}, d2 = {"Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "", "", "identifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "price", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "special", "specialDescription", "specialBadgeTitle", "priceVerbose", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/DomainSubsPlans;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "copy", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "getTitle", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "getSpecialDescription", "getSpecialBadgeTitle", "getPriceVerbose", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainSubsPlans {
    private final PlansDuration duration;
    private final String identifier;
    private final Integer price;
    private final String priceVerbose;
    private final Boolean special;
    private final String specialBadgeTitle;
    private final String specialDescription;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new EnumSerializer("com.sputnik.domain.entities.market.PlansDuration", PlansDuration.values()), null, null, null, null, null, null};

    public DomainSubsPlans() {
        this((String) null, (PlansDuration) null, (Integer) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    public final DomainSubsPlans copy(String identifier, PlansDuration duration, Integer price, String title, Boolean special, String specialDescription, String specialBadgeTitle, String priceVerbose) {
        return new DomainSubsPlans(identifier, duration, price, title, special, specialDescription, specialBadgeTitle, priceVerbose);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSubsPlans)) {
            return false;
        }
        DomainSubsPlans domainSubsPlans = (DomainSubsPlans) other;
        return Intrinsics.areEqual(this.identifier, domainSubsPlans.identifier) && this.duration == domainSubsPlans.duration && Intrinsics.areEqual(this.price, domainSubsPlans.price) && Intrinsics.areEqual(this.title, domainSubsPlans.title) && Intrinsics.areEqual(this.special, domainSubsPlans.special) && Intrinsics.areEqual(this.specialDescription, domainSubsPlans.specialDescription) && Intrinsics.areEqual(this.specialBadgeTitle, domainSubsPlans.specialBadgeTitle) && Intrinsics.areEqual(this.priceVerbose, domainSubsPlans.priceVerbose);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode2 = (iHashCode + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.specialDescription;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.specialBadgeTitle;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.priceVerbose;
        return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DomainSubsPlans(identifier=" + this.identifier + ", duration=" + this.duration + ", price=" + this.price + ", title=" + this.title + ", special=" + this.special + ", specialDescription=" + this.specialDescription + ", specialBadgeTitle=" + this.specialBadgeTitle + ", priceVerbose=" + this.priceVerbose + ")";
    }

    /* compiled from: DomainSubsPlans.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/DomainSubsPlans$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainSubsPlans> serializer() {
            return DomainSubsPlans$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainSubsPlans(int i, String str, PlansDuration plansDuration, Integer num, String str2, Boolean bool, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.identifier = null;
        } else {
            this.identifier = str;
        }
        if ((i & 2) == 0) {
            this.duration = null;
        } else {
            this.duration = plansDuration;
        }
        if ((i & 4) == 0) {
            this.price = null;
        } else {
            this.price = num;
        }
        if ((i & 8) == 0) {
            this.title = null;
        } else {
            this.title = str2;
        }
        if ((i & 16) == 0) {
            this.special = null;
        } else {
            this.special = bool;
        }
        if ((i & 32) == 0) {
            this.specialDescription = null;
        } else {
            this.specialDescription = str3;
        }
        if ((i & 64) == 0) {
            this.specialBadgeTitle = null;
        } else {
            this.specialBadgeTitle = str4;
        }
        if ((i & 128) == 0) {
            this.priceVerbose = null;
        } else {
            this.priceVerbose = str5;
        }
    }

    public DomainSubsPlans(String str, PlansDuration plansDuration, Integer num, String str2, Boolean bool, String str3, String str4, String str5) {
        this.identifier = str;
        this.duration = plansDuration;
        this.price = num;
        this.title = str2;
        this.special = bool;
        this.specialDescription = str3;
        this.specialBadgeTitle = str4;
        this.priceVerbose = str5;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainSubsPlans self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.identifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.identifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.duration != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.special != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.special);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.specialDescription != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.specialDescription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.specialBadgeTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.specialBadgeTitle);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.priceVerbose == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.priceVerbose);
    }

    public /* synthetic */ DomainSubsPlans(String str, PlansDuration plansDuration, Integer num, String str2, Boolean bool, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : plansDuration, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) == 0 ? str5 : null);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final PlansDuration getDuration() {
        return this.duration;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean getSpecial() {
        return this.special;
    }

    public final String getSpecialDescription() {
        return this.specialDescription;
    }

    public final String getSpecialBadgeTitle() {
        return this.specialBadgeTitle;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }
}
