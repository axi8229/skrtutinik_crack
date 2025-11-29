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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002-,BK\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011HÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010#\u0012\u0004\b%\u0010\"\u001a\u0004\b$\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010&\u0012\u0004\b)\u0010\"\u001a\u0004\b'\u0010(R\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010#\u0012\u0004\b+\u0010\"\u001a\u0004\b*\u0010\u0017¨\u0006."}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainService;", "", "", "seen1", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainServiceAppearance;", "appearance", "", "identifier", "order", "type", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILcom/sputnik/domain/entities/subscriptions/subscriptions/DomainServiceAppearance;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainService;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainServiceAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainServiceAppearance;", "getAppearance$annotations", "()V", "Ljava/lang/String;", "getIdentifier", "getIdentifier$annotations", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "getOrder$annotations", "getType", "getType$annotations", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainServiceAppearance appearance;
    private final String identifier;
    private final Integer order;
    private final String type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainService)) {
            return false;
        }
        DomainService domainService = (DomainService) other;
        return Intrinsics.areEqual(this.appearance, domainService.appearance) && Intrinsics.areEqual(this.identifier, domainService.identifier) && Intrinsics.areEqual(this.order, domainService.order) && Intrinsics.areEqual(this.type, domainService.type);
    }

    public int hashCode() {
        DomainServiceAppearance domainServiceAppearance = this.appearance;
        int iHashCode = (domainServiceAppearance == null ? 0 : domainServiceAppearance.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.type;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DomainService(appearance=" + this.appearance + ", identifier=" + this.identifier + ", order=" + this.order + ", type=" + this.type + ")";
    }

    /* compiled from: DomainService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainService$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainService;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public /* synthetic */ DomainService(int i, DomainServiceAppearance domainServiceAppearance, String str, Integer num, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, DomainService$$serializer.INSTANCE.getDescriptor());
        }
        this.appearance = domainServiceAppearance;
        this.identifier = str;
        this.order = num;
        this.type = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainService self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, DomainServiceAppearance$$serializer.INSTANCE, self.appearance);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.identifier);
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.order);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.type);
    }
}
