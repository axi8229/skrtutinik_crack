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

/* compiled from: DomainDetailedLayout.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000232B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBI\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010'\u0012\u0004\b*\u0010&\u001a\u0004\b(\u0010)R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010+\u0012\u0004\b.\u0010&\u001a\u0004\b,\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;", "", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainFeatures;", "features", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainHeader;", "header", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServices;", "includedServices", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;", "notice", "<init>", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainFeatures;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainHeader;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServices;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/sputnik/domain/entities/subscriptions/subscriptions/DomainFeatures;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainHeader;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServices;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainFeatures;", "getFeatures", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainFeatures;", "getFeatures$annotations", "()V", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainHeader;", "getHeader", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainHeader;", "getHeader$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServices;", "getIncludedServices", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainIncludedServices;", "getIncludedServices$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;", "getNotice", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainNoticeBody;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainDetailedLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainFeatures features;
    private final DomainHeader header;
    private final DomainIncludedServices includedServices;
    private final DomainNoticeBody notice;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainDetailedLayout)) {
            return false;
        }
        DomainDetailedLayout domainDetailedLayout = (DomainDetailedLayout) other;
        return Intrinsics.areEqual(this.features, domainDetailedLayout.features) && Intrinsics.areEqual(this.header, domainDetailedLayout.header) && Intrinsics.areEqual(this.includedServices, domainDetailedLayout.includedServices) && Intrinsics.areEqual(this.notice, domainDetailedLayout.notice);
    }

    public int hashCode() {
        DomainFeatures domainFeatures = this.features;
        int iHashCode = (domainFeatures == null ? 0 : domainFeatures.hashCode()) * 31;
        DomainHeader domainHeader = this.header;
        int iHashCode2 = (iHashCode + (domainHeader == null ? 0 : domainHeader.hashCode())) * 31;
        DomainIncludedServices domainIncludedServices = this.includedServices;
        int iHashCode3 = (iHashCode2 + (domainIncludedServices == null ? 0 : domainIncludedServices.hashCode())) * 31;
        DomainNoticeBody domainNoticeBody = this.notice;
        return iHashCode3 + (domainNoticeBody != null ? domainNoticeBody.hashCode() : 0);
    }

    public String toString() {
        return "DomainDetailedLayout(features=" + this.features + ", header=" + this.header + ", includedServices=" + this.includedServices + ", notice=" + this.notice + ")";
    }

    /* compiled from: DomainDetailedLayout.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public /* synthetic */ DomainDetailedLayout(int i, DomainFeatures domainFeatures, DomainHeader domainHeader, DomainIncludedServices domainIncludedServices, DomainNoticeBody domainNoticeBody, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, DomainDetailedLayout$$serializer.INSTANCE.getDescriptor());
        }
        this.features = domainFeatures;
        this.header = domainHeader;
        this.includedServices = domainIncludedServices;
        this.notice = domainNoticeBody;
    }

    public DomainDetailedLayout(DomainFeatures domainFeatures, DomainHeader domainHeader, DomainIncludedServices domainIncludedServices, DomainNoticeBody domainNoticeBody) {
        this.features = domainFeatures;
        this.header = domainHeader;
        this.includedServices = domainIncludedServices;
        this.notice = domainNoticeBody;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainDetailedLayout self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, DomainFeatures$$serializer.INSTANCE, self.features);
        output.encodeNullableSerializableElement(serialDesc, 1, DomainHeader$$serializer.INSTANCE, self.header);
        output.encodeNullableSerializableElement(serialDesc, 2, DomainIncludedServices$$serializer.INSTANCE, self.includedServices);
        output.encodeNullableSerializableElement(serialDesc, 3, DomainNoticeBody$$serializer.INSTANCE, self.notice);
    }

    public final DomainFeatures getFeatures() {
        return this.features;
    }

    public final DomainHeader getHeader() {
        return this.header;
    }

    public final DomainIncludedServices getIncludedServices() {
        return this.includedServices;
    }

    public final DomainNoticeBody getNotice() {
        return this.notice;
    }
}
