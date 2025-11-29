package com.sputnik.domain.entities.subscriptions.subscriptions;

import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainSubscriptionAppearance.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b+\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0003HGIB\u0081\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014B§\u0001\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J(\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dHÇ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010)\u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010#R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010)\u0012\u0004\b.\u0010,\u001a\u0004\b-\u0010#R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b/\u0010#R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u00100\u0012\u0004\b3\u0010,\u001a\u0004\b1\u00102R\"\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010)\u0012\u0004\b5\u0010,\u001a\u0004\b4\u0010#R\"\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010)\u0012\u0004\b7\u0010,\u001a\u0004\b6\u0010#R\"\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010)\u0012\u0004\b9\u0010,\u001a\u0004\b8\u0010#R\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010:\u0012\u0004\b=\u0010,\u001a\u0004\b;\u0010<R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010>\u0012\u0004\bA\u0010,\u001a\u0004\b?\u0010@R(\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010B\u0012\u0004\bE\u0010,\u001a\u0004\bC\u0010DR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010B\u001a\u0004\bF\u0010D¨\u0006J"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "", "", "finale", "priceVerbose", "priceText", "", "special", "specialDescription", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "description", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;", "badge", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;", "detailedLayout", "", "featuresList", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance$DomainFeaturePoint;", "featuresPoints", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;Ljava/util/List;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFinale", "getFinale$annotations", "()V", "getPriceVerbose", "getPriceVerbose$annotations", "getPriceText", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "getSpecial$annotations", "getSpecialDescription", "getSpecialDescription$annotations", "getTitle", "getTitle$annotations", "getDescription", "getDescription$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;", "getBadge", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBadge;", "getBadge$annotations", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;", "getDetailedLayout$annotations", "Ljava/util/List;", "getFeaturesList", "()Ljava/util/List;", "getFeaturesList$annotations", "getFeaturesPoints", "Companion", "$serializer", "DomainFeaturePoint", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainSubscriptionAppearance {
    private final DomainBadge badge;
    private final String description;
    private final DomainDetailedLayout detailedLayout;
    private final List<String> featuresList;
    private final List<DomainFeaturePoint> featuresPoints;
    private final String finale;
    private final String priceText;
    private final String priceVerbose;
    private final Boolean special;
    private final String specialDescription;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(DomainSubscriptionAppearance$DomainFeaturePoint$$serializer.INSTANCE)};

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSubscriptionAppearance)) {
            return false;
        }
        DomainSubscriptionAppearance domainSubscriptionAppearance = (DomainSubscriptionAppearance) other;
        return Intrinsics.areEqual(this.finale, domainSubscriptionAppearance.finale) && Intrinsics.areEqual(this.priceVerbose, domainSubscriptionAppearance.priceVerbose) && Intrinsics.areEqual(this.priceText, domainSubscriptionAppearance.priceText) && Intrinsics.areEqual(this.special, domainSubscriptionAppearance.special) && Intrinsics.areEqual(this.specialDescription, domainSubscriptionAppearance.specialDescription) && Intrinsics.areEqual(this.title, domainSubscriptionAppearance.title) && Intrinsics.areEqual(this.description, domainSubscriptionAppearance.description) && Intrinsics.areEqual(this.badge, domainSubscriptionAppearance.badge) && Intrinsics.areEqual(this.detailedLayout, domainSubscriptionAppearance.detailedLayout) && Intrinsics.areEqual(this.featuresList, domainSubscriptionAppearance.featuresList) && Intrinsics.areEqual(this.featuresPoints, domainSubscriptionAppearance.featuresPoints);
    }

    public int hashCode() {
        String str = this.finale;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.priceVerbose;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.priceText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.specialDescription;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.description;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        DomainBadge domainBadge = this.badge;
        int iHashCode8 = (iHashCode7 + (domainBadge == null ? 0 : domainBadge.hashCode())) * 31;
        DomainDetailedLayout domainDetailedLayout = this.detailedLayout;
        int iHashCode9 = (iHashCode8 + (domainDetailedLayout == null ? 0 : domainDetailedLayout.hashCode())) * 31;
        List<String> list = this.featuresList;
        int iHashCode10 = (iHashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        List<DomainFeaturePoint> list2 = this.featuresPoints;
        return iHashCode10 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "DomainSubscriptionAppearance(finale=" + this.finale + ", priceVerbose=" + this.priceVerbose + ", priceText=" + this.priceText + ", special=" + this.special + ", specialDescription=" + this.specialDescription + ", title=" + this.title + ", description=" + this.description + ", badge=" + this.badge + ", detailedLayout=" + this.detailedLayout + ", featuresList=" + this.featuresList + ", featuresPoints=" + this.featuresPoints + ")";
    }

    /* compiled from: DomainSubscriptionAppearance.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DomainSubscriptionAppearance> serializer() {
            return DomainSubscriptionAppearance$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ DomainSubscriptionAppearance(int i, String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, DomainBadge domainBadge, DomainDetailedLayout domainDetailedLayout, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2047, DomainSubscriptionAppearance$$serializer.INSTANCE.getDescriptor());
        }
        this.finale = str;
        this.priceVerbose = str2;
        this.priceText = str3;
        this.special = bool;
        this.specialDescription = str4;
        this.title = str5;
        this.description = str6;
        this.badge = domainBadge;
        this.detailedLayout = domainDetailedLayout;
        this.featuresList = list;
        this.featuresPoints = list2;
    }

    public DomainSubscriptionAppearance(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, DomainBadge domainBadge, DomainDetailedLayout domainDetailedLayout, List<String> list, List<DomainFeaturePoint> list2) {
        this.finale = str;
        this.priceVerbose = str2;
        this.priceText = str3;
        this.special = bool;
        this.specialDescription = str4;
        this.title = str5;
        this.description = str6;
        this.badge = domainBadge;
        this.detailedLayout = domainDetailedLayout;
        this.featuresList = list;
        this.featuresPoints = list2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainSubscriptionAppearance self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.finale);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.priceVerbose);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.priceText);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.special);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.specialDescription);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.title);
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.description);
        output.encodeNullableSerializableElement(serialDesc, 7, DomainBadge$$serializer.INSTANCE, self.badge);
        output.encodeNullableSerializableElement(serialDesc, 8, DomainDetailedLayout$$serializer.INSTANCE, self.detailedLayout);
        output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.featuresList);
        output.encodeNullableSerializableElement(serialDesc, 10, kSerializerArr[10], self.featuresPoints);
    }

    public final String getFinale() {
        return this.finale;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }

    public final String getPriceText() {
        return this.priceText;
    }

    public final Boolean getSpecial() {
        return this.special;
    }

    public final String getSpecialDescription() {
        return this.specialDescription;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final DomainBadge getBadge() {
        return this.badge;
    }

    public final DomainDetailedLayout getDetailedLayout() {
        return this.detailedLayout;
    }

    public final List<String> getFeaturesList() {
        return this.featuresList;
    }

    /* compiled from: DomainSubscriptionAppearance.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fHÇ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance$DomainFeaturePoint;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "badge", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance$DomainFeaturePoint;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getBadge", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class DomainFeaturePoint {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String badge;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DomainFeaturePoint)) {
                return false;
            }
            DomainFeaturePoint domainFeaturePoint = (DomainFeaturePoint) other;
            return Intrinsics.areEqual(this.title, domainFeaturePoint.title) && Intrinsics.areEqual(this.badge, domainFeaturePoint.badge);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.badge;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DomainFeaturePoint(title=" + this.title + ", badge=" + this.badge + ")";
        }

        /* compiled from: DomainSubscriptionAppearance.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance$DomainFeaturePoint$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance$DomainFeaturePoint;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DomainFeaturePoint> serializer() {
                return DomainSubscriptionAppearance$DomainFeaturePoint$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ DomainFeaturePoint(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, DomainSubscriptionAppearance$DomainFeaturePoint$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            this.badge = str2;
        }

        public DomainFeaturePoint(String str, String str2) {
            this.title = str;
            this.badge = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(DomainFeaturePoint self, CompositeEncoder output, SerialDescriptor serialDesc) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.title);
            output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.badge);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBadge() {
            return this.badge;
        }
    }

    public final List<DomainFeaturePoint> getFeaturesPoints() {
        return this.featuresPoints;
    }
}
