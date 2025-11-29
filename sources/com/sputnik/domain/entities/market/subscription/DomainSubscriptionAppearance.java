package com.sputnik.domain.entities.market.subscription;

import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle;
import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle$$serializer;
import com.sputnik.domain.entities.market.appearance.DomainDetailedLayout;
import com.sputnik.domain.entities.market.appearance.DomainDetailedLayout$$serializer;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainSubscriptionAppearance.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0002;:B\u0085\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0085\u0001\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0017J(\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bHÇ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010!R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b4\u0010!R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b5\u0010!R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b6\u0010!R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "description", "specialDescription", "", "special", "Lcom/sputnik/domain/entities/market/appearance/DomainBadgeStyle;", "badge", "", "list", "finale", "link", "priceVerbose", "Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;", "detailedLayout", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/market/appearance/DomainBadgeStyle;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/market/appearance/DomainBadgeStyle;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getDescription", "getSpecialDescription", "Ljava/lang/Boolean;", "getSpecial", "()Ljava/lang/Boolean;", "Lcom/sputnik/domain/entities/market/appearance/DomainBadgeStyle;", "getBadge", "()Lcom/sputnik/domain/entities/market/appearance/DomainBadgeStyle;", "Ljava/util/List;", "getList", "()Ljava/util/List;", "getFinale", "getLink", "getPriceVerbose", "Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/domain/entities/market/appearance/DomainDetailedLayout;", "Companion", "$serializer", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final /* data */ class DomainSubscriptionAppearance {
    private final DomainBadgeStyle badge;
    private final String description;
    private final DomainDetailedLayout detailedLayout;
    private final String finale;
    private final String link;
    private final List<String> list;
    private final String priceVerbose;
    private final Boolean special;
    private final String specialDescription;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null};

    public DomainSubscriptionAppearance() {
        this((String) null, (String) null, (String) null, (Boolean) null, (DomainBadgeStyle) null, (List) null, (String) null, (String) null, (String) null, (DomainDetailedLayout) null, 1023, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainSubscriptionAppearance)) {
            return false;
        }
        DomainSubscriptionAppearance domainSubscriptionAppearance = (DomainSubscriptionAppearance) other;
        return Intrinsics.areEqual(this.title, domainSubscriptionAppearance.title) && Intrinsics.areEqual(this.description, domainSubscriptionAppearance.description) && Intrinsics.areEqual(this.specialDescription, domainSubscriptionAppearance.specialDescription) && Intrinsics.areEqual(this.special, domainSubscriptionAppearance.special) && Intrinsics.areEqual(this.badge, domainSubscriptionAppearance.badge) && Intrinsics.areEqual(this.list, domainSubscriptionAppearance.list) && Intrinsics.areEqual(this.finale, domainSubscriptionAppearance.finale) && Intrinsics.areEqual(this.link, domainSubscriptionAppearance.link) && Intrinsics.areEqual(this.priceVerbose, domainSubscriptionAppearance.priceVerbose) && Intrinsics.areEqual(this.detailedLayout, domainSubscriptionAppearance.detailedLayout);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.specialDescription;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.special;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        DomainBadgeStyle domainBadgeStyle = this.badge;
        int iHashCode5 = (iHashCode4 + (domainBadgeStyle == null ? 0 : domainBadgeStyle.hashCode())) * 31;
        List<String> list = this.list;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.finale;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.link;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.priceVerbose;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        DomainDetailedLayout domainDetailedLayout = this.detailedLayout;
        return iHashCode9 + (domainDetailedLayout != null ? domainDetailedLayout.hashCode() : 0);
    }

    public String toString() {
        return "DomainSubscriptionAppearance(title=" + this.title + ", description=" + this.description + ", specialDescription=" + this.specialDescription + ", special=" + this.special + ", badge=" + this.badge + ", list=" + this.list + ", finale=" + this.finale + ", link=" + this.link + ", priceVerbose=" + this.priceVerbose + ", detailedLayout=" + this.detailedLayout + ")";
    }

    /* compiled from: DomainSubscriptionAppearance.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public /* synthetic */ DomainSubscriptionAppearance(int i, String str, String str2, String str3, Boolean bool, DomainBadgeStyle domainBadgeStyle, List list, String str4, String str5, String str6, DomainDetailedLayout domainDetailedLayout, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.title = null;
        } else {
            this.title = str;
        }
        if ((i & 2) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 4) == 0) {
            this.specialDescription = null;
        } else {
            this.specialDescription = str3;
        }
        if ((i & 8) == 0) {
            this.special = null;
        } else {
            this.special = bool;
        }
        if ((i & 16) == 0) {
            this.badge = null;
        } else {
            this.badge = domainBadgeStyle;
        }
        if ((i & 32) == 0) {
            this.list = null;
        } else {
            this.list = list;
        }
        if ((i & 64) == 0) {
            this.finale = null;
        } else {
            this.finale = str4;
        }
        if ((i & 128) == 0) {
            this.link = null;
        } else {
            this.link = str5;
        }
        if ((i & 256) == 0) {
            this.priceVerbose = null;
        } else {
            this.priceVerbose = str6;
        }
        if ((i & 512) == 0) {
            this.detailedLayout = null;
        } else {
            this.detailedLayout = domainDetailedLayout;
        }
    }

    public DomainSubscriptionAppearance(String str, String str2, String str3, Boolean bool, DomainBadgeStyle domainBadgeStyle, List<String> list, String str4, String str5, String str6, DomainDetailedLayout domainDetailedLayout) {
        this.title = str;
        this.description = str2;
        this.specialDescription = str3;
        this.special = bool;
        this.badge = domainBadgeStyle;
        this.list = list;
        this.finale = str4;
        this.link = str5;
        this.priceVerbose = str6;
        this.detailedLayout = domainDetailedLayout;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(DomainSubscriptionAppearance self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.specialDescription != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.specialDescription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.special != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.special);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.badge != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, DomainBadgeStyle$$serializer.INSTANCE, self.badge);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.list != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.list);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.finale != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.finale);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.link != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.link);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.priceVerbose != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.priceVerbose);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.detailedLayout == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, DomainDetailedLayout$$serializer.INSTANCE, self.detailedLayout);
    }

    public /* synthetic */ DomainSubscriptionAppearance(String str, String str2, String str3, Boolean bool, DomainBadgeStyle domainBadgeStyle, List list, String str4, String str5, String str6, DomainDetailedLayout domainDetailedLayout, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : domainBadgeStyle, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) == 0 ? domainDetailedLayout : null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getSpecialDescription() {
        return this.specialDescription;
    }

    public final Boolean getSpecial() {
        return this.special;
    }

    public final DomainBadgeStyle getBadge() {
        return this.badge;
    }

    public final String getFinale() {
        return this.finale;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getPriceVerbose() {
        return this.priceVerbose;
    }

    public final DomainDetailedLayout getDetailedLayout() {
        return this.detailedLayout;
    }
}
