package com.sputnik.domain.entities.subscriptions.subscriptions;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainIncludedService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\"\u0012\u0004\b$\u0010!\u001a\u0004\b#\u0010\u0016¨\u0006'"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedService;", "", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServiceAppearance;", "appearance", "", "serviceConfigIdentifier", "<init>", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServiceAppearance;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServiceAppearance;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedService;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServiceAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServiceAppearance;", "getAppearance$annotations", "()V", "Ljava/lang/String;", "getServiceConfigIdentifier", "getServiceConfigIdentifier$annotations", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainIncludedService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainIncludedServiceAppearance appearance;
    private final String serviceConfigIdentifier;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainIncludedService)) {
            return false;
        }
        DomainIncludedService domainIncludedService = (DomainIncludedService) other;
        return Intrinsics.areEqual(this.appearance, domainIncludedService.appearance) && Intrinsics.areEqual(this.serviceConfigIdentifier, domainIncludedService.serviceConfigIdentifier);
    }

    public int hashCode() {
        DomainIncludedServiceAppearance domainIncludedServiceAppearance = this.appearance;
        int iHashCode = (domainIncludedServiceAppearance == null ? 0 : domainIncludedServiceAppearance.hashCode()) * 31;
        String str = this.serviceConfigIdentifier;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DomainIncludedService(appearance=" + this.appearance + ", serviceConfigIdentifier=" + this.serviceConfigIdentifier + ")";
    }

    /* compiled from: DomainIncludedService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedService$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedService;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainIncludedService> serializer() {
            return DomainIncludedService$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainIncludedService(int i, DomainIncludedServiceAppearance domainIncludedServiceAppearance, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, DomainIncludedService$$serializer.INSTANCE.getDescriptor());
        }
        this.appearance = domainIncludedServiceAppearance;
        this.serviceConfigIdentifier = str;
    }

    public DomainIncludedService(DomainIncludedServiceAppearance domainIncludedServiceAppearance, String str) {
        this.appearance = domainIncludedServiceAppearance;
        this.serviceConfigIdentifier = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainIncludedService self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, DomainIncludedServiceAppearance$$serializer.INSTANCE, self.appearance);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.serviceConfigIdentifier);
    }

    public final DomainIncludedServiceAppearance getAppearance() {
        return this.appearance;
    }

    public final String getServiceConfigIdentifier() {
        return this.serviceConfigIdentifier;
    }
}
