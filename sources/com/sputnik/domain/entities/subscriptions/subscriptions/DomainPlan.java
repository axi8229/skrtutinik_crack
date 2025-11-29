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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainPlan.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u00030/1B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBU\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u0019R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010 \u0012\u0004\b%\u0010#\u001a\u0004\b$\u0010\u0019R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010 \u0012\u0004\b'\u0010#\u001a\u0004\b&\u0010\u0019R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010(\u0012\u0004\b+\u0010#\u001a\u0004\b)\u0010*R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan;", "", "", "appstoreProductId", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "identifier", "", "price", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;", "promo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppstoreProductId", "getAppstoreProductId$annotations", "()V", "getDuration", "getDuration$annotations", "getIdentifier", "getIdentifier$annotations", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "getPrice$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;", "getPromo", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;", "Companion", "$serializer", "DomainPromo", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainPlan {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appstoreProductId;
    private final String duration;
    private final String identifier;
    private final Integer price;
    private final DomainPromo promo;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainPlan)) {
            return false;
        }
        DomainPlan domainPlan = (DomainPlan) other;
        return Intrinsics.areEqual(this.appstoreProductId, domainPlan.appstoreProductId) && Intrinsics.areEqual(this.duration, domainPlan.duration) && Intrinsics.areEqual(this.identifier, domainPlan.identifier) && Intrinsics.areEqual(this.price, domainPlan.price) && Intrinsics.areEqual(this.promo, domainPlan.promo);
    }

    public int hashCode() {
        String str = this.appstoreProductId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.duration;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.identifier;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        DomainPromo domainPromo = this.promo;
        return iHashCode4 + (domainPromo != null ? domainPromo.hashCode() : 0);
    }

    public String toString() {
        return "DomainPlan(appstoreProductId=" + this.appstoreProductId + ", duration=" + this.duration + ", identifier=" + this.identifier + ", price=" + this.price + ", promo=" + this.promo + ")";
    }

    /* compiled from: DomainPlan.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainPlan> serializer() {
            return DomainPlan$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainPlan(int i, String str, String str2, String str3, Integer num, DomainPromo domainPromo, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, DomainPlan$$serializer.INSTANCE.getDescriptor());
        }
        this.appstoreProductId = str;
        this.duration = str2;
        this.identifier = str3;
        this.price = num;
        this.promo = domainPromo;
    }

    public DomainPlan(String str, String str2, String str3, Integer num, DomainPromo domainPromo) {
        this.appstoreProductId = str;
        this.duration = str2;
        this.identifier = str3;
        this.price = num;
        this.promo = domainPromo;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainPlan self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.appstoreProductId);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.duration);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.identifier);
        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.price);
        output.encodeNullableSerializableElement(serialDesc, 4, DomainPlan$DomainPromo$$serializer.INSTANCE, self.promo);
    }

    public final String getAppstoreProductId() {
        return this.appstoreProductId;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer getPrice() {
        return this.price;
    }

    /* compiled from: DomainPlan.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002)(B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tBG\b\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\rJ(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011HÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u0017R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010#\u0012\u0004\b'\u0010\"\u001a\u0004\b&\u0010\u0017¨\u0006*"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;", "", "", "discountPrice", "", "description", "link", "linkText", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getDiscountPrice", "()Ljava/lang/Integer;", "getDiscountPrice$annotations", "()V", "Ljava/lang/String;", "getDescription", "getLink", "getLinkText", "getLinkText$annotations", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class DomainPromo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;
        private final Integer discountPrice;
        private final String link;
        private final String linkText;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainPromo)) {
                return false;
            }
            DomainPromo domainPromo = (DomainPromo) other;
            return Intrinsics.areEqual(this.discountPrice, domainPromo.discountPrice) && Intrinsics.areEqual(this.description, domainPromo.description) && Intrinsics.areEqual(this.link, domainPromo.link) && Intrinsics.areEqual(this.linkText, domainPromo.linkText);
        }

        public int hashCode() {
            Integer num = this.discountPrice;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.description;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.link;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.linkText;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "DomainPromo(discountPrice=" + this.discountPrice + ", description=" + this.description + ", link=" + this.link + ", linkText=" + this.linkText + ")";
        }

        /* compiled from: DomainPlan.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainPlan$DomainPromo;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DomainPromo> serializer() {
                return DomainPlan$DomainPromo$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ DomainPromo(int i, Integer num, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, DomainPlan$DomainPromo$$serializer.INSTANCE.getDescriptor());
            }
            this.discountPrice = num;
            this.description = str;
            this.link = str2;
            this.linkText = str3;
        }

        public DomainPromo(Integer num, String str, String str2, String str3) {
            this.discountPrice = num;
            this.description = str;
            this.link = str2;
            this.linkText = str3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(DomainPromo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.discountPrice);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.description);
            output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.link);
            output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.linkText);
        }

        public final Integer getDiscountPrice() {
            return this.discountPrice;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getLinkText() {
            return this.linkText;
        }
    }

    public final DomainPromo getPromo() {
        return this.promo;
    }
}
