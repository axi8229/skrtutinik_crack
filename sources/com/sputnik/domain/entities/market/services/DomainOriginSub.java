package com.sputnik.domain.entities.market.services;

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
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainOriginSub.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0002:9B}\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012B}\b\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0011\u0010\u0016J(\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aHÇ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010 R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b+\u0010 R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b/\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b0\u0010 R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b1\u0010 R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b2\u0010 R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00106\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "", "Lcom/sputnik/domain/entities/market/services/OriginType;", "type", "", "productId", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "price", "fullExpires", "phone", "website", "originTitle", "", "showBadge", "Lcom/sputnik/domain/entities/subscriptions/services/DomainServiceAppearance;", "appearance", "<init>", "(Lcom/sputnik/domain/entities/market/services/OriginType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/entities/subscriptions/services/DomainServiceAppearance;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/sputnik/domain/entities/market/services/OriginType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/entities/subscriptions/services/DomainServiceAppearance;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/services/DomainOriginSub;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/entities/market/services/OriginType;", "getType", "()Lcom/sputnik/domain/entities/market/services/OriginType;", "Ljava/lang/String;", "getProductId", "getTitle", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "getFullExpires", "getPhone", "getWebsite", "getOriginTitle", "Z", "getShowBadge", "()Z", "Lcom/sputnik/domain/entities/subscriptions/services/DomainServiceAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/subscriptions/services/DomainServiceAppearance;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainOriginSub {
    private final com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance appearance;
    private final String fullExpires;
    private final String originTitle;
    private final String phone;
    private final Integer price;
    private final String productId;
    private final boolean showBadge;
    private final String title;
    private final OriginType type;
    private final String website;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new EnumSerializer("com.sputnik.domain.entities.market.services.OriginType", OriginType.values()), null, null, null, null, null, null, null, null, null};

    public DomainOriginSub() {
        this((OriginType) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance) null, 1023, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainOriginSub)) {
            return false;
        }
        DomainOriginSub domainOriginSub = (DomainOriginSub) other;
        return this.type == domainOriginSub.type && Intrinsics.areEqual(this.productId, domainOriginSub.productId) && Intrinsics.areEqual(this.title, domainOriginSub.title) && Intrinsics.areEqual(this.price, domainOriginSub.price) && Intrinsics.areEqual(this.fullExpires, domainOriginSub.fullExpires) && Intrinsics.areEqual(this.phone, domainOriginSub.phone) && Intrinsics.areEqual(this.website, domainOriginSub.website) && Intrinsics.areEqual(this.originTitle, domainOriginSub.originTitle) && this.showBadge == domainOriginSub.showBadge && Intrinsics.areEqual(this.appearance, domainOriginSub.appearance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        OriginType originType = this.type;
        int iHashCode = (originType == null ? 0 : originType.hashCode()) * 31;
        String str = this.productId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.fullExpires;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phone;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.website;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.originTitle;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z = this.showBadge;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode8 + i) * 31;
        com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance domainServiceAppearance = this.appearance;
        return i2 + (domainServiceAppearance != null ? domainServiceAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DomainOriginSub(type=" + this.type + ", productId=" + this.productId + ", title=" + this.title + ", price=" + this.price + ", fullExpires=" + this.fullExpires + ", phone=" + this.phone + ", website=" + this.website + ", originTitle=" + this.originTitle + ", showBadge=" + this.showBadge + ", appearance=" + this.appearance + ")";
    }

    /* compiled from: DomainOriginSub.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/services/DomainOriginSub$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainOriginSub> serializer() {
            return DomainOriginSub$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainOriginSub(int i, OriginType originType, String str, String str2, Integer num, String str3, String str4, String str5, String str6, boolean z, com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance domainServiceAppearance, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.type = null;
        } else {
            this.type = originType;
        }
        if ((i & 2) == 0) {
            this.productId = null;
        } else {
            this.productId = str;
        }
        if ((i & 4) == 0) {
            this.title = null;
        } else {
            this.title = str2;
        }
        if ((i & 8) == 0) {
            this.price = null;
        } else {
            this.price = num;
        }
        if ((i & 16) == 0) {
            this.fullExpires = null;
        } else {
            this.fullExpires = str3;
        }
        if ((i & 32) == 0) {
            this.phone = null;
        } else {
            this.phone = str4;
        }
        if ((i & 64) == 0) {
            this.website = null;
        } else {
            this.website = str5;
        }
        if ((i & 128) == 0) {
            this.originTitle = null;
        } else {
            this.originTitle = str6;
        }
        if ((i & 256) == 0) {
            this.showBadge = true;
        } else {
            this.showBadge = z;
        }
        if ((i & 512) == 0) {
            this.appearance = null;
        } else {
            this.appearance = domainServiceAppearance;
        }
    }

    public DomainOriginSub(OriginType originType, String str, String str2, Integer num, String str3, String str4, String str5, String str6, boolean z, com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance domainServiceAppearance) {
        this.type = originType;
        this.productId = str;
        this.title = str2;
        this.price = num;
        this.fullExpires = str3;
        this.phone = str4;
        this.website = str5;
        this.originTitle = str6;
        this.showBadge = z;
        this.appearance = domainServiceAppearance;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainOriginSub self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.productId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.productId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fullExpires != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.fullExpires);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.phone != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.website != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.website);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.originTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.originTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !self.showBadge) {
            output.encodeBooleanElement(serialDesc, 8, self.showBadge);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.appearance == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance$$serializer.INSTANCE, self.appearance);
    }

    public /* synthetic */ DomainOriginSub(OriginType originType, String str, String str2, Integer num, String str3, String str4, String str5, String str6, boolean z, com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance domainServiceAppearance, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : originType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? true : z, (i & 512) == 0 ? domainServiceAppearance : null);
    }

    public final OriginType getType() {
        return this.type;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getFullExpires() {
        return this.fullExpires;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance getAppearance() {
        return this.appearance;
    }
}
