package com.sputnik.domain.entities.market.services;

import com.sputnik.domain.entities.market.appearance.DomainBaseAppearance;
import com.sputnik.domain.entities.market.appearance.DomainBaseAppearance$$serializer;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainSmallServices.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "", "", "serviceConfigIdentifier", "Lcom/sputnik/domain/entities/market/appearance/DomainBaseAppearance;", "appearance", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/appearance/DomainBaseAppearance;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sputnik/domain/entities/market/appearance/DomainBaseAppearance;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/services/DomainSmallServices;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getServiceConfigIdentifier", "Lcom/sputnik/domain/entities/market/appearance/DomainBaseAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/market/appearance/DomainBaseAppearance;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainSmallServices {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainBaseAppearance appearance;
    private final String serviceConfigIdentifier;

    public DomainSmallServices() {
        this((String) null, (DomainBaseAppearance) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSmallServices)) {
            return false;
        }
        DomainSmallServices domainSmallServices = (DomainSmallServices) other;
        return Intrinsics.areEqual(this.serviceConfigIdentifier, domainSmallServices.serviceConfigIdentifier) && Intrinsics.areEqual(this.appearance, domainSmallServices.appearance);
    }

    public int hashCode() {
        String str = this.serviceConfigIdentifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        DomainBaseAppearance domainBaseAppearance = this.appearance;
        return iHashCode + (domainBaseAppearance != null ? domainBaseAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DomainSmallServices(serviceConfigIdentifier=" + this.serviceConfigIdentifier + ", appearance=" + this.appearance + ")";
    }

    /* compiled from: DomainSmallServices.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/services/DomainSmallServices$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainSmallServices> serializer() {
            return DomainSmallServices$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainSmallServices(int i, String str, DomainBaseAppearance domainBaseAppearance, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.serviceConfigIdentifier = null;
        } else {
            this.serviceConfigIdentifier = str;
        }
        if ((i & 2) == 0) {
            this.appearance = null;
        } else {
            this.appearance = domainBaseAppearance;
        }
    }

    public DomainSmallServices(String str, DomainBaseAppearance domainBaseAppearance) {
        this.serviceConfigIdentifier = str;
        this.appearance = domainBaseAppearance;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainSmallServices self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.serviceConfigIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.serviceConfigIdentifier);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.appearance == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, DomainBaseAppearance$$serializer.INSTANCE, self.appearance);
    }

    public /* synthetic */ DomainSmallServices(String str, DomainBaseAppearance domainBaseAppearance, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : domainBaseAppearance);
    }

    public final String getServiceConfigIdentifier() {
        return this.serviceConfigIdentifier;
    }

    public final DomainBaseAppearance getAppearance() {
        return this.appearance;
    }
}
