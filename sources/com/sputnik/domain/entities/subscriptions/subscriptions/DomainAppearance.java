package com.sputnik.domain.entities.subscriptions.subscriptions;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainAppearance.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B?\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\"\u0012\u0004\b$\u0010!\u001a\u0004\b#\u0010\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\"\u0012\u0004\b&\u0010!\u001a\u0004\b%\u0010\u0016¨\u0006)"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainAppearance;", "", "", "seen1", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;", "badge", "", "description", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainAppearance;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;", "getBadge", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;", "getBadge$annotations", "()V", "Ljava/lang/String;", "getDescription", "getDescription$annotations", "getTitle", "getTitle$annotations", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainAppearance {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DomainBadge badge;
    private final String description;
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainAppearance)) {
            return false;
        }
        DomainAppearance domainAppearance = (DomainAppearance) other;
        return Intrinsics.areEqual(this.badge, domainAppearance.badge) && Intrinsics.areEqual(this.description, domainAppearance.description) && Intrinsics.areEqual(this.title, domainAppearance.title);
    }

    public int hashCode() {
        DomainBadge domainBadge = this.badge;
        int iHashCode = (domainBadge == null ? 0 : domainBadge.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DomainAppearance(badge=" + this.badge + ", description=" + this.description + ", title=" + this.title + ")";
    }

    /* compiled from: DomainAppearance.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainAppearance$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainAppearance;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainAppearance> serializer() {
            return DomainAppearance$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainAppearance(int i, DomainBadge domainBadge, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, DomainAppearance$$serializer.INSTANCE.getDescriptor());
        }
        this.badge = domainBadge;
        this.description = str;
        this.title = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainAppearance self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, DomainBadge$$serializer.INSTANCE, self.badge);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.description);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.title);
    }
}
