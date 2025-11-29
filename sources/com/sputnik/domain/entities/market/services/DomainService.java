package com.sputnik.domain.entities.market.services;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainService.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000232BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eBW\b\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J(\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017HÇ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b.\u0010\u001dR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/sputnik/domain/entities/market/services/DomainService;", "", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "state", "", "serviceConfigIdentifier", "Lcom/sputnik/domain/entities/market/services/DomainServiceAppearance;", "appearance", "Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "activatedAt", "", "requiresSubscription", "<init>", "(Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/String;Lcom/sputnik/domain/entities/market/services/DomainServiceAppearance;Lcom/sputnik/domain/entities/market/services/DomainOriginSub;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/String;Lcom/sputnik/domain/entities/market/services/DomainServiceAppearance;Lcom/sputnik/domain/entities/market/services/DomainOriginSub;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/services/DomainService;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "getState", "()Lcom/sputnik/domain/entities/market/services/ServiceState;", "Ljava/lang/String;", "getServiceConfigIdentifier", "Lcom/sputnik/domain/entities/market/services/DomainServiceAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/market/services/DomainServiceAppearance;", "Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "getOrigin", "()Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "getActivatedAt", "Ljava/lang/Boolean;", "getRequiresSubscription", "()Ljava/lang/Boolean;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainService {
    private final String activatedAt;
    private final DomainServiceAppearance appearance;
    private final DomainOriginSub origin;
    private final Boolean requiresSubscription;
    private final String serviceConfigIdentifier;
    private final ServiceState state;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new EnumSerializer("com.sputnik.domain.entities.market.services.ServiceState", ServiceState.values()), null, null, null, null, null};

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainService)) {
            return false;
        }
        DomainService domainService = (DomainService) other;
        return this.state == domainService.state && Intrinsics.areEqual(this.serviceConfigIdentifier, domainService.serviceConfigIdentifier) && Intrinsics.areEqual(this.appearance, domainService.appearance) && Intrinsics.areEqual(this.origin, domainService.origin) && Intrinsics.areEqual(this.activatedAt, domainService.activatedAt) && Intrinsics.areEqual(this.requiresSubscription, domainService.requiresSubscription);
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        String str = this.serviceConfigIdentifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DomainServiceAppearance domainServiceAppearance = this.appearance;
        int iHashCode3 = (iHashCode2 + (domainServiceAppearance == null ? 0 : domainServiceAppearance.hashCode())) * 31;
        DomainOriginSub domainOriginSub = this.origin;
        int iHashCode4 = (iHashCode3 + (domainOriginSub == null ? 0 : domainOriginSub.hashCode())) * 31;
        String str2 = this.activatedAt;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.requiresSubscription;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DomainService(state=" + this.state + ", serviceConfigIdentifier=" + this.serviceConfigIdentifier + ", appearance=" + this.appearance + ", origin=" + this.origin + ", activatedAt=" + this.activatedAt + ", requiresSubscription=" + this.requiresSubscription + ")";
    }

    /* compiled from: DomainService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/services/DomainService$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainService> serializer() {
            return DomainService$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainService(int i, ServiceState serviceState, String str, DomainServiceAppearance domainServiceAppearance, DomainOriginSub domainOriginSub, String str2, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, DomainService$$serializer.INSTANCE.getDescriptor());
        }
        this.state = serviceState;
        if ((i & 2) == 0) {
            this.serviceConfigIdentifier = null;
        } else {
            this.serviceConfigIdentifier = str;
        }
        if ((i & 4) == 0) {
            this.appearance = null;
        } else {
            this.appearance = domainServiceAppearance;
        }
        if ((i & 8) == 0) {
            this.origin = null;
        } else {
            this.origin = domainOriginSub;
        }
        if ((i & 16) == 0) {
            this.activatedAt = null;
        } else {
            this.activatedAt = str2;
        }
        if ((i & 32) == 0) {
            this.requiresSubscription = null;
        } else {
            this.requiresSubscription = bool;
        }
    }

    public DomainService(ServiceState state, String str, DomainServiceAppearance domainServiceAppearance, DomainOriginSub domainOriginSub, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.serviceConfigIdentifier = str;
        this.appearance = domainServiceAppearance;
        this.origin = domainOriginSub;
        this.activatedAt = str2;
        this.requiresSubscription = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainService self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.state);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.serviceConfigIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.serviceConfigIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appearance != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, DomainServiceAppearance$$serializer.INSTANCE, self.appearance);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.origin != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DomainOriginSub$$serializer.INSTANCE, self.origin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.activatedAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.activatedAt);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.requiresSubscription == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.requiresSubscription);
    }

    public final ServiceState getState() {
        return this.state;
    }

    public final String getServiceConfigIdentifier() {
        return this.serviceConfigIdentifier;
    }

    public final DomainServiceAppearance getAppearance() {
        return this.appearance;
    }

    public final DomainOriginSub getOrigin() {
        return this.origin;
    }

    public final String getActivatedAt() {
        return this.activatedAt;
    }

    public final Boolean getRequiresSubscription() {
        return this.requiresSubscription;
    }
}
