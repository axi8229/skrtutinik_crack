package com.sputnik.domain.entities.market.appearance;

import com.sputnik.domain.entities.subscriptions.subscriptions.DomainNoticeBody;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainNoticeBody$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: DomainDetailedLayout.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000243BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rBM\b\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016HÇ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;", "", "Lcom/sputnik/domain/entities/market/appearance/DomainHeader;", "header", "Lcom/sputnik/domain/entities/market/appearance/DomainFeatures;", "features", "Lcom/sputnik/domain/entities/market/appearance/DomainIncludedServices;", "includedServices", "Lcom/sputnik/domain/entities/market/appearance/DomainAppearancePlans;", "plans", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;", "notice", "<init>", "(Lcom/sputnik/domain/entities/market/appearance/DomainHeader;Lcom/sputnik/domain/entities/market/appearance/DomainFeatures;Lcom/sputnik/domain/entities/market/appearance/DomainIncludedServices;Lcom/sputnik/domain/entities/market/appearance/DomainAppearancePlans;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/sputnik/domain/entities/market/appearance/DomainHeader;Lcom/sputnik/domain/entities/market/appearance/DomainFeatures;Lcom/sputnik/domain/entities/market/appearance/DomainIncludedServices;Lcom/sputnik/domain/entities/market/appearance/DomainAppearancePlans;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/market/appearance/DomainHeader;", "getHeader", "()Lcom/sputnik/domain/entities/market/appearance/DomainHeader;", "Lcom/sputnik/domain/entities/market/appearance/DomainFeatures;", "getFeatures", "()Lcom/sputnik/domain/entities/market/appearance/DomainFeatures;", "Lcom/sputnik/domain/entities/market/appearance/DomainIncludedServices;", "getIncludedServices", "()Lcom/sputnik/domain/entities/market/appearance/DomainIncludedServices;", "Lcom/sputnik/domain/entities/market/appearance/DomainAppearancePlans;", "getPlans", "()Lcom/sputnik/domain/entities/market/appearance/DomainAppearancePlans;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;", "getNotice", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainDetailedLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainFeatures features;
    private final DomainHeader header;
    private final DomainIncludedServices includedServices;
    private final DomainNoticeBody notice;
    private final DomainAppearancePlans plans;

    public DomainDetailedLayout() {
        this((DomainHeader) null, (DomainFeatures) null, (DomainIncludedServices) null, (DomainAppearancePlans) null, (DomainNoticeBody) null, 31, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainDetailedLayout)) {
            return false;
        }
        DomainDetailedLayout domainDetailedLayout = (DomainDetailedLayout) other;
        return Intrinsics.areEqual(this.header, domainDetailedLayout.header) && Intrinsics.areEqual(this.features, domainDetailedLayout.features) && Intrinsics.areEqual(this.includedServices, domainDetailedLayout.includedServices) && Intrinsics.areEqual(this.plans, domainDetailedLayout.plans) && Intrinsics.areEqual(this.notice, domainDetailedLayout.notice);
    }

    public int hashCode() {
        DomainHeader domainHeader = this.header;
        int iHashCode = (domainHeader == null ? 0 : domainHeader.hashCode()) * 31;
        DomainFeatures domainFeatures = this.features;
        int iHashCode2 = (iHashCode + (domainFeatures == null ? 0 : domainFeatures.hashCode())) * 31;
        DomainIncludedServices domainIncludedServices = this.includedServices;
        int iHashCode3 = (iHashCode2 + (domainIncludedServices == null ? 0 : domainIncludedServices.hashCode())) * 31;
        DomainAppearancePlans domainAppearancePlans = this.plans;
        int iHashCode4 = (iHashCode3 + (domainAppearancePlans == null ? 0 : domainAppearancePlans.hashCode())) * 31;
        DomainNoticeBody domainNoticeBody = this.notice;
        return iHashCode4 + (domainNoticeBody != null ? domainNoticeBody.hashCode() : 0);
    }

    public String toString() {
        return "DomainDetailedLayout(header=" + this.header + ", features=" + this.features + ", includedServices=" + this.includedServices + ", plans=" + this.plans + ", notice=" + this.notice + ")";
    }

    /* compiled from: DomainDetailedLayout.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainDetailedLayout> serializer() {
            return DomainDetailedLayout$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainDetailedLayout(int i, DomainHeader domainHeader, DomainFeatures domainFeatures, DomainIncludedServices domainIncludedServices, DomainAppearancePlans domainAppearancePlans, DomainNoticeBody domainNoticeBody, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.header = null;
        } else {
            this.header = domainHeader;
        }
        if ((i & 2) == 0) {
            this.features = null;
        } else {
            this.features = domainFeatures;
        }
        if ((i & 4) == 0) {
            this.includedServices = null;
        } else {
            this.includedServices = domainIncludedServices;
        }
        if ((i & 8) == 0) {
            this.plans = null;
        } else {
            this.plans = domainAppearancePlans;
        }
        if ((i & 16) == 0) {
            this.notice = null;
        } else {
            this.notice = domainNoticeBody;
        }
    }

    public DomainDetailedLayout(DomainHeader domainHeader, DomainFeatures domainFeatures, DomainIncludedServices domainIncludedServices, DomainAppearancePlans domainAppearancePlans, DomainNoticeBody domainNoticeBody) {
        this.header = domainHeader;
        this.features = domainFeatures;
        this.includedServices = domainIncludedServices;
        this.plans = domainAppearancePlans;
        this.notice = domainNoticeBody;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainDetailedLayout self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.header != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DomainHeader$$serializer.INSTANCE, self.header);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.features != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, DomainFeatures$$serializer.INSTANCE, self.features);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.includedServices != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, DomainIncludedServices$$serializer.INSTANCE, self.includedServices);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.plans != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DomainAppearancePlans$$serializer.INSTANCE, self.plans);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.notice == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, DomainNoticeBody$$serializer.INSTANCE, self.notice);
    }

    public /* synthetic */ DomainDetailedLayout(DomainHeader domainHeader, DomainFeatures domainFeatures, DomainIncludedServices domainIncludedServices, DomainAppearancePlans domainAppearancePlans, DomainNoticeBody domainNoticeBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : domainHeader, (i & 2) != 0 ? null : domainFeatures, (i & 4) != 0 ? null : domainIncludedServices, (i & 8) != 0 ? null : domainAppearancePlans, (i & 16) != 0 ? null : domainNoticeBody);
    }

    public final DomainHeader getHeader() {
        return this.header;
    }

    public final DomainFeatures getFeatures() {
        return this.features;
    }

    public final DomainIncludedServices getIncludedServices() {
        return this.includedServices;
    }

    public final DomainAppearancePlans getPlans() {
        return this.plans;
    }
}
