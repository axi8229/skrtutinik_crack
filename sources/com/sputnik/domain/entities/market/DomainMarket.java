package com.sputnik.domain.entities.market;

import com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance$$serializer;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionDetail;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionDetail$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainMarket.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0002;:B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011Ba\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0010\u0010\u0015J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019HÇ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/sputnik/domain/entities/market/DomainMarket;", "", "", "identifier", "Lcom/sputnik/domain/entities/market/MarketTypes;", "type", "", "order", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionDetail;", "subscriptionDetails", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "appearance", "Lcom/sputnik/domain/entities/market/DomainBillDetails;", "billDetails", "Lcom/sputnik/domain/entities/market/DomainOuterServiceDetails;", "outerServiceDetails", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/MarketTypes;Ljava/lang/Integer;Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionDetail;Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;Lcom/sputnik/domain/entities/market/DomainBillDetails;Lcom/sputnik/domain/entities/market/DomainOuterServiceDetails;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sputnik/domain/entities/market/MarketTypes;Ljava/lang/Integer;Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionDetail;Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;Lcom/sputnik/domain/entities/market/DomainBillDetails;Lcom/sputnik/domain/entities/market/DomainOuterServiceDetails;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/DomainMarket;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/MarketTypes;", "getType", "()Lcom/sputnik/domain/entities/market/MarketTypes;", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionDetail;", "getSubscriptionDetails", "()Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionDetail;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "Lcom/sputnik/domain/entities/market/DomainBillDetails;", "getBillDetails", "()Lcom/sputnik/domain/entities/market/DomainBillDetails;", "Lcom/sputnik/domain/entities/market/DomainOuterServiceDetails;", "getOuterServiceDetails", "()Lcom/sputnik/domain/entities/market/DomainOuterServiceDetails;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainMarket {
    private final DomainSubscriptionAppearance appearance;
    private final DomainBillDetails billDetails;
    private final String identifier;
    private final Integer order;
    private final DomainOuterServiceDetails outerServiceDetails;
    private final DomainSubscriptionDetail subscriptionDetails;
    private final MarketTypes type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new EnumSerializer("com.sputnik.domain.entities.market.MarketTypes", MarketTypes.values()), null, null, null, null, null};

    public DomainMarket() {
        this((String) null, (MarketTypes) null, (Integer) null, (DomainSubscriptionDetail) null, (DomainSubscriptionAppearance) null, (DomainBillDetails) null, (DomainOuterServiceDetails) null, 127, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainMarket)) {
            return false;
        }
        DomainMarket domainMarket = (DomainMarket) other;
        return Intrinsics.areEqual(this.identifier, domainMarket.identifier) && this.type == domainMarket.type && Intrinsics.areEqual(this.order, domainMarket.order) && Intrinsics.areEqual(this.subscriptionDetails, domainMarket.subscriptionDetails) && Intrinsics.areEqual(this.appearance, domainMarket.appearance) && Intrinsics.areEqual(this.billDetails, domainMarket.billDetails) && Intrinsics.areEqual(this.outerServiceDetails, domainMarket.outerServiceDetails);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        MarketTypes marketTypes = this.type;
        int iHashCode2 = (iHashCode + (marketTypes == null ? 0 : marketTypes.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        DomainSubscriptionDetail domainSubscriptionDetail = this.subscriptionDetails;
        int iHashCode4 = (iHashCode3 + (domainSubscriptionDetail == null ? 0 : domainSubscriptionDetail.hashCode())) * 31;
        DomainSubscriptionAppearance domainSubscriptionAppearance = this.appearance;
        int iHashCode5 = (iHashCode4 + (domainSubscriptionAppearance == null ? 0 : domainSubscriptionAppearance.hashCode())) * 31;
        DomainBillDetails domainBillDetails = this.billDetails;
        int iHashCode6 = (iHashCode5 + (domainBillDetails == null ? 0 : domainBillDetails.hashCode())) * 31;
        DomainOuterServiceDetails domainOuterServiceDetails = this.outerServiceDetails;
        return iHashCode6 + (domainOuterServiceDetails != null ? domainOuterServiceDetails.hashCode() : 0);
    }

    public String toString() {
        return "DomainMarket(identifier=" + this.identifier + ", type=" + this.type + ", order=" + this.order + ", subscriptionDetails=" + this.subscriptionDetails + ", appearance=" + this.appearance + ", billDetails=" + this.billDetails + ", outerServiceDetails=" + this.outerServiceDetails + ")";
    }

    /* compiled from: DomainMarket.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/DomainMarket$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/DomainMarket;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainMarket> serializer() {
            return DomainMarket$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainMarket(int i, String str, MarketTypes marketTypes, Integer num, DomainSubscriptionDetail domainSubscriptionDetail, DomainSubscriptionAppearance domainSubscriptionAppearance, DomainBillDetails domainBillDetails, DomainOuterServiceDetails domainOuterServiceDetails, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.identifier = null;
        } else {
            this.identifier = str;
        }
        if ((i & 2) == 0) {
            this.type = null;
        } else {
            this.type = marketTypes;
        }
        if ((i & 4) == 0) {
            this.order = 0;
        } else {
            this.order = num;
        }
        if ((i & 8) == 0) {
            this.subscriptionDetails = null;
        } else {
            this.subscriptionDetails = domainSubscriptionDetail;
        }
        if ((i & 16) == 0) {
            this.appearance = null;
        } else {
            this.appearance = domainSubscriptionAppearance;
        }
        if ((i & 32) == 0) {
            this.billDetails = null;
        } else {
            this.billDetails = domainBillDetails;
        }
        if ((i & 64) == 0) {
            this.outerServiceDetails = null;
        } else {
            this.outerServiceDetails = domainOuterServiceDetails;
        }
    }

    public DomainMarket(String str, MarketTypes marketTypes, Integer num, DomainSubscriptionDetail domainSubscriptionDetail, DomainSubscriptionAppearance domainSubscriptionAppearance, DomainBillDetails domainBillDetails, DomainOuterServiceDetails domainOuterServiceDetails) {
        this.identifier = str;
        this.type = marketTypes;
        this.order = num;
        this.subscriptionDetails = domainSubscriptionDetail;
        this.appearance = domainSubscriptionAppearance;
        this.billDetails = domainBillDetails;
        this.outerServiceDetails = domainOuterServiceDetails;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainMarket self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.identifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.identifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || (num = self.order) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.order);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.subscriptionDetails != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DomainSubscriptionDetail$$serializer.INSTANCE, self.subscriptionDetails);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.appearance != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, DomainSubscriptionAppearance$$serializer.INSTANCE, self.appearance);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.billDetails != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, DomainBillDetails$$serializer.INSTANCE, self.billDetails);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.outerServiceDetails == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, DomainOuterServiceDetails$$serializer.INSTANCE, self.outerServiceDetails);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final MarketTypes getType() {
        return this.type;
    }

    public /* synthetic */ DomainMarket(String str, MarketTypes marketTypes, Integer num, DomainSubscriptionDetail domainSubscriptionDetail, DomainSubscriptionAppearance domainSubscriptionAppearance, DomainBillDetails domainBillDetails, DomainOuterServiceDetails domainOuterServiceDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : marketTypes, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? null : domainSubscriptionDetail, (i & 16) != 0 ? null : domainSubscriptionAppearance, (i & 32) != 0 ? null : domainBillDetails, (i & 64) != 0 ? null : domainOuterServiceDetails);
    }

    public final DomainSubscriptionDetail getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final DomainSubscriptionAppearance getAppearance() {
        return this.appearance;
    }
}
