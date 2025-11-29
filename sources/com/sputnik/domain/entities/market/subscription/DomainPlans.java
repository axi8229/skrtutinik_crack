package com.sputnik.domain.entities.market.subscription;

import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.appearance.DomainPlanAppearance;
import com.sputnik.domain.entities.market.appearance.DomainPlanAppearance$$serializer;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Deprecated;
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

/* compiled from: DomainPlans.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u00020/BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rBM\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\f\u0010\u0011J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015HÇ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainPlans;", "", "", "outdated", "", "identifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "", "price", "Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;", "appearance", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Integer;Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/subscription/DomainPlans;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getOutdated", "()Ljava/lang/Boolean;", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/market/appearance/DomainPlanAppearance;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainPlans {
    private final DomainPlanAppearance appearance;
    private final PlansDuration duration;
    private final String identifier;
    private final Boolean outdated;
    private final Integer price;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new EnumSerializer("com.sputnik.domain.entities.market.PlansDuration", PlansDuration.values()), null, null};

    public DomainPlans() {
        this((Boolean) null, (String) null, (PlansDuration) null, (Integer) null, (DomainPlanAppearance) null, 31, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPlans)) {
            return false;
        }
        DomainPlans domainPlans = (DomainPlans) other;
        return Intrinsics.areEqual(this.outdated, domainPlans.outdated) && Intrinsics.areEqual(this.identifier, domainPlans.identifier) && this.duration == domainPlans.duration && Intrinsics.areEqual(this.price, domainPlans.price) && Intrinsics.areEqual(this.appearance, domainPlans.appearance);
    }

    public int hashCode() {
        Boolean bool = this.outdated;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode3 = (iHashCode2 + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        DomainPlanAppearance domainPlanAppearance = this.appearance;
        return iHashCode4 + (domainPlanAppearance != null ? domainPlanAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DomainPlans(outdated=" + this.outdated + ", identifier=" + this.identifier + ", duration=" + this.duration + ", price=" + this.price + ", appearance=" + this.appearance + ")";
    }

    /* compiled from: DomainPlans.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainPlans$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/subscription/DomainPlans;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainPlans> serializer() {
            return DomainPlans$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainPlans(int i, Boolean bool, String str, PlansDuration plansDuration, Integer num, DomainPlanAppearance domainPlanAppearance, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.outdated = null;
        } else {
            this.outdated = bool;
        }
        if ((i & 2) == 0) {
            this.identifier = null;
        } else {
            this.identifier = str;
        }
        if ((i & 4) == 0) {
            this.duration = null;
        } else {
            this.duration = plansDuration;
        }
        if ((i & 8) == 0) {
            this.price = null;
        } else {
            this.price = num;
        }
        if ((i & 16) == 0) {
            this.appearance = null;
        } else {
            this.appearance = domainPlanAppearance;
        }
    }

    public DomainPlans(Boolean bool, String str, PlansDuration plansDuration, Integer num, DomainPlanAppearance domainPlanAppearance) {
        this.outdated = bool;
        this.identifier = str;
        this.duration = plansDuration;
        this.price = num;
        this.appearance = domainPlanAppearance;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainPlans self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.outdated != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.outdated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.identifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.identifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.duration != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.price);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.appearance == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, DomainPlanAppearance$$serializer.INSTANCE, self.appearance);
    }

    public /* synthetic */ DomainPlans(Boolean bool, String str, PlansDuration plansDuration, Integer num, DomainPlanAppearance domainPlanAppearance, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : plansDuration, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : domainPlanAppearance);
    }

    public final DomainPlanAppearance getAppearance() {
        return this.appearance;
    }
}
