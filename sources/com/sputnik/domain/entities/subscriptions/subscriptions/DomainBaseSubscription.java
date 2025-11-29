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
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainBaseSubscription.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b'\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002LKBu\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u009f\u0001\b\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0013\u0010\u0018J(\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cHÇ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010)\u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010\"R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010-\u0012\u0004\b0\u0010,\u001a\u0004\b.\u0010/R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010-\u0012\u0004\b2\u0010,\u001a\u0004\b1\u0010/R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010)\u0012\u0004\b4\u0010,\u001a\u0004\b3\u0010\"R\"\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010)\u0012\u0004\b6\u0010,\u001a\u0004\b5\u0010\"R\"\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010)\u0012\u0004\b8\u0010,\u001a\u0004\b7\u0010\"R\"\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010)\u0012\u0004\b:\u0010,\u001a\u0004\b9\u0010\"R\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010;\u0012\u0004\b>\u0010,\u001a\u0004\b<\u0010=R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010?\u0012\u0004\bB\u0010,\u001a\u0004\b@\u0010AR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010C\u0012\u0004\bF\u0010,\u001a\u0004\bD\u0010ER\"\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010G\u0012\u0004\bJ\u0010,\u001a\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "", "", "identifier", "", "order", "version", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "expires", "plan", "productId", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "state", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "type", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "appearance", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionDetails;", "subscriptionDetails", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionDetails;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionDetails;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentifier", "getIdentifier$annotations", "()V", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "getOrder$annotations", "getVersion", "getVersion$annotations", "getDuration", "getDuration$annotations", "getExpires", "getExpires$annotations", "getPlan", "getPlan$annotations", "getProductId", "getProductId$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "getState", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "getState$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "getType", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "getType$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "getAppearance", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "getAppearance$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionDetails;", "getSubscriptionDetails", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionDetails;", "getSubscriptionDetails$annotations", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainBaseSubscription {
    private final DomainSubscriptionAppearance appearance;
    private final String duration;
    private final String expires;
    private final String identifier;
    private final Integer order;
    private final String plan;
    private final String productId;
    private final SubscriptionStates state;
    private final DomainSubscriptionDetails subscriptionDetails;
    private final SubscriptionTypes type;
    private final Integer version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new EnumSerializer("com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionStates", SubscriptionStates.values()), new EnumSerializer("com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes", SubscriptionTypes.values()), null, null};

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainBaseSubscription)) {
            return false;
        }
        DomainBaseSubscription domainBaseSubscription = (DomainBaseSubscription) other;
        return Intrinsics.areEqual(this.identifier, domainBaseSubscription.identifier) && Intrinsics.areEqual(this.order, domainBaseSubscription.order) && Intrinsics.areEqual(this.version, domainBaseSubscription.version) && Intrinsics.areEqual(this.duration, domainBaseSubscription.duration) && Intrinsics.areEqual(this.expires, domainBaseSubscription.expires) && Intrinsics.areEqual(this.plan, domainBaseSubscription.plan) && Intrinsics.areEqual(this.productId, domainBaseSubscription.productId) && this.state == domainBaseSubscription.state && this.type == domainBaseSubscription.type && Intrinsics.areEqual(this.appearance, domainBaseSubscription.appearance) && Intrinsics.areEqual(this.subscriptionDetails, domainBaseSubscription.subscriptionDetails);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.order;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.version;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.duration;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expires;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.plan;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.productId;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        SubscriptionStates subscriptionStates = this.state;
        int iHashCode8 = (iHashCode7 + (subscriptionStates == null ? 0 : subscriptionStates.hashCode())) * 31;
        SubscriptionTypes subscriptionTypes = this.type;
        int iHashCode9 = (iHashCode8 + (subscriptionTypes == null ? 0 : subscriptionTypes.hashCode())) * 31;
        DomainSubscriptionAppearance domainSubscriptionAppearance = this.appearance;
        int iHashCode10 = (iHashCode9 + (domainSubscriptionAppearance == null ? 0 : domainSubscriptionAppearance.hashCode())) * 31;
        DomainSubscriptionDetails domainSubscriptionDetails = this.subscriptionDetails;
        return iHashCode10 + (domainSubscriptionDetails != null ? domainSubscriptionDetails.hashCode() : 0);
    }

    public String toString() {
        return "DomainBaseSubscription(identifier=" + this.identifier + ", order=" + this.order + ", version=" + this.version + ", duration=" + this.duration + ", expires=" + this.expires + ", plan=" + this.plan + ", productId=" + this.productId + ", state=" + this.state + ", type=" + this.type + ", appearance=" + this.appearance + ", subscriptionDetails=" + this.subscriptionDetails + ")";
    }

    /* compiled from: DomainBaseSubscription.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainBaseSubscription> serializer() {
            return DomainBaseSubscription$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainBaseSubscription(int i, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, SubscriptionStates subscriptionStates, SubscriptionTypes subscriptionTypes, DomainSubscriptionAppearance domainSubscriptionAppearance, DomainSubscriptionDetails domainSubscriptionDetails, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2047, DomainBaseSubscription$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.order = num;
        this.version = num2;
        this.duration = str2;
        this.expires = str3;
        this.plan = str4;
        this.productId = str5;
        this.state = subscriptionStates;
        this.type = subscriptionTypes;
        this.appearance = domainSubscriptionAppearance;
        this.subscriptionDetails = domainSubscriptionDetails;
    }

    public DomainBaseSubscription(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, SubscriptionStates subscriptionStates, SubscriptionTypes subscriptionTypes, DomainSubscriptionAppearance domainSubscriptionAppearance, DomainSubscriptionDetails domainSubscriptionDetails) {
        this.identifier = str;
        this.order = num;
        this.version = num2;
        this.duration = str2;
        this.expires = str3;
        this.plan = str4;
        this.productId = str5;
        this.state = subscriptionStates;
        this.type = subscriptionTypes;
        this.appearance = domainSubscriptionAppearance;
        this.subscriptionDetails = domainSubscriptionDetails;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainBaseSubscription self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.identifier);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, intSerializer, self.order);
        output.encodeNullableSerializableElement(serialDesc, 2, intSerializer, self.version);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.duration);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.expires);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.plan);
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.productId);
        output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.state);
        output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.type);
        output.encodeNullableSerializableElement(serialDesc, 9, DomainSubscriptionAppearance$$serializer.INSTANCE, self.appearance);
        output.encodeNullableSerializableElement(serialDesc, 10, DomainSubscriptionDetails$$serializer.INSTANCE, self.subscriptionDetails);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getExpires() {
        return this.expires;
    }

    public final String getPlan() {
        return this.plan;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final SubscriptionStates getState() {
        return this.state;
    }

    public final SubscriptionTypes getType() {
        return this.type;
    }

    public final DomainSubscriptionAppearance getAppearance() {
        return this.appearance;
    }

    public final DomainSubscriptionDetails getSubscriptionDetails() {
        return this.subscriptionDetails;
    }
}
