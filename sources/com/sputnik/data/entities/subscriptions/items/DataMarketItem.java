package com.sputnik.data.entities.subscriptions.items;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.market.ItemTypes;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DataMarketItem.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "identifier", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/ItemTypes;", "type", "Lcom/sputnik/domain/entities/market/ItemTypes;", "getType", "()Lcom/sputnik/domain/entities/market/ItemTypes;", "order", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance;", "appearance", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance;", "DataMarketItemAppearance", "DetailedLayout", "Notice", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataMarketItem {
    private final DataMarketItemAppearance appearance;
    private final String identifier;
    private final Integer order;
    private final ItemTypes type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataMarketItem)) {
            return false;
        }
        DataMarketItem dataMarketItem = (DataMarketItem) other;
        return Intrinsics.areEqual(this.identifier, dataMarketItem.identifier) && this.type == dataMarketItem.type && Intrinsics.areEqual(this.order, dataMarketItem.order) && Intrinsics.areEqual(this.appearance, dataMarketItem.appearance);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ItemTypes itemTypes = this.type;
        int iHashCode2 = (iHashCode + (itemTypes == null ? 0 : itemTypes.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        DataMarketItemAppearance dataMarketItemAppearance = this.appearance;
        return iHashCode3 + (dataMarketItemAppearance != null ? dataMarketItemAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DataMarketItem(identifier=" + this.identifier + ", type=" + this.type + ", order=" + this.order + ", appearance=" + this.appearance + ")";
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ItemTypes getType() {
        return this.type;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final DataMarketItemAppearance getAppearance() {
        return this.appearance;
    }

    /* compiled from: DataMarketItem.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0002%&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Ljava/lang/String;", "getTitle", "", "featuresList", "Ljava/util/List;", "getFeaturesList", "()Ljava/util/List;", "imageLink", "getImageLink", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle;", "finale", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle;", "getFinale", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink;", "onTap", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink;", "getOnTap", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout;", "detailedLayout", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout;", "getDetailedLayout", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout;", "Deeplink", "TextTitle", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMarketItemAppearance {

        @SerializedName("detailed_layout")
        private final DetailedLayout detailedLayout;

        @SerializedName("features_list")
        private final List<String> featuresList;
        private final TextTitle finale;

        @SerializedName("image_link")
        private final String imageLink;

        @SerializedName("on_tap")
        private final Deeplink onTap;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMarketItemAppearance)) {
                return false;
            }
            DataMarketItemAppearance dataMarketItemAppearance = (DataMarketItemAppearance) other;
            return Intrinsics.areEqual(this.title, dataMarketItemAppearance.title) && Intrinsics.areEqual(this.featuresList, dataMarketItemAppearance.featuresList) && Intrinsics.areEqual(this.imageLink, dataMarketItemAppearance.imageLink) && Intrinsics.areEqual(this.finale, dataMarketItemAppearance.finale) && Intrinsics.areEqual(this.onTap, dataMarketItemAppearance.onTap) && Intrinsics.areEqual(this.detailedLayout, dataMarketItemAppearance.detailedLayout);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<String> list = this.featuresList;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.imageLink;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.finale;
            int iHashCode4 = (iHashCode3 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            Deeplink deeplink = this.onTap;
            int iHashCode5 = (iHashCode4 + (deeplink == null ? 0 : deeplink.hashCode())) * 31;
            DetailedLayout detailedLayout = this.detailedLayout;
            return iHashCode5 + (detailedLayout != null ? detailedLayout.hashCode() : 0);
        }

        public String toString() {
            return "DataMarketItemAppearance(title=" + this.title + ", featuresList=" + this.featuresList + ", imageLink=" + this.imageLink + ", finale=" + this.finale + ", onTap=" + this.onTap + ", detailedLayout=" + this.detailedLayout + ")";
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<String> getFeaturesList() {
            return this.featuresList;
        }

        public final String getImageLink() {
            return this.imageLink;
        }

        public final TextTitle getFinale() {
            return this.finale;
        }

        public final Deeplink getOnTap() {
            return this.onTap;
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f\u001eB/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eHÇ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014¨\u0006 "}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle;", "", "", "seen1", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "link", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getLink", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class TextTitle {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String link;
            private final String title;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextTitle)) {
                    return false;
                }
                TextTitle textTitle = (TextTitle) other;
                return Intrinsics.areEqual(this.title, textTitle.title) && Intrinsics.areEqual(this.link, textTitle.link);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.link;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "TextTitle(title=" + this.title + ", link=" + this.link + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$TextTitle;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<TextTitle> serializer() {
                    return DataMarketItem$DataMarketItemAppearance$TextTitle$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ TextTitle(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, DataMarketItem$DataMarketItemAppearance$TextTitle$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                this.link = str2;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(TextTitle self, CompositeEncoder output, SerialDescriptor serialDesc) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.title);
                output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.link);
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getLink() {
                return this.link;
            }
        }

        public final DetailedLayout getDetailedLayout() {
            return this.detailedLayout;
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001cB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rHÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink;", "", "", "seen1", "", "deeplink", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeeplink", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Deeplink {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String deeplink;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Deeplink) && Intrinsics.areEqual(this.deeplink, ((Deeplink) other).deeplink);
            }

            public int hashCode() {
                String str = this.deeplink;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Deeplink(deeplink=" + this.deeplink + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DataMarketItemAppearance$Deeplink;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Deeplink> serializer() {
                    return DataMarketItem$DataMarketItemAppearance$Deeplink$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Deeplink(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, DataMarketItem$DataMarketItemAppearance$Deeplink$$serializer.INSTANCE.getDescriptor());
                }
                this.deeplink = str;
            }

            public final String getDeeplink() {
                return this.deeplink;
            }
        }
    }

    /* compiled from: DataMarketItem.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001cB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rHÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$Notice;", "", "", "seen1", "", "body", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$Notice;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBody", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Notice {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String body;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Notice) && Intrinsics.areEqual(this.body, ((Notice) other).body);
        }

        public int hashCode() {
            String str = this.body;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Notice(body=" + this.body + ")";
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$Notice$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$Notice;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Notice> serializer() {
                return DataMarketItem$Notice$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Notice(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, DataMarketItem$Notice$$serializer.INSTANCE.getDescriptor());
            }
            this.body = str;
        }
    }

    /* compiled from: DataMarketItem.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0006&'()*+J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Header;", "header", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Header;", "getHeader", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Header;", "", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$FeatureObject;", "features", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures;", "upcomingFeatures", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures;", "getUpcomingFeatures", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice;", "notice", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice;", "getNotice", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button;", "button", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button;", "getButton", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button;", "Button", "Feature", "FeatureObject", "Header", "Notice", "UpcomingFeatures", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DetailedLayout {
        private final Button button;
        private final List<FeatureObject> features;
        private final Header header;
        private final Notice notice;

        @SerializedName("upcoming_features")
        private final UpcomingFeatures upcomingFeatures;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailedLayout)) {
                return false;
            }
            DetailedLayout detailedLayout = (DetailedLayout) other;
            return Intrinsics.areEqual(this.header, detailedLayout.header) && Intrinsics.areEqual(this.features, detailedLayout.features) && Intrinsics.areEqual(this.upcomingFeatures, detailedLayout.upcomingFeatures) && Intrinsics.areEqual(this.notice, detailedLayout.notice) && Intrinsics.areEqual(this.button, detailedLayout.button);
        }

        public int hashCode() {
            Header header = this.header;
            int iHashCode = (header == null ? 0 : header.hashCode()) * 31;
            List<FeatureObject> list = this.features;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            UpcomingFeatures upcomingFeatures = this.upcomingFeatures;
            int iHashCode3 = (iHashCode2 + (upcomingFeatures == null ? 0 : upcomingFeatures.hashCode())) * 31;
            Notice notice = this.notice;
            int iHashCode4 = (iHashCode3 + (notice == null ? 0 : notice.hashCode())) * 31;
            Button button = this.button;
            return iHashCode4 + (button != null ? button.hashCode() : 0);
        }

        public String toString() {
            return "DetailedLayout(header=" + this.header + ", features=" + this.features + ", upcomingFeatures=" + this.upcomingFeatures + ", notice=" + this.notice + ", button=" + this.button + ")";
        }

        public final Header getHeader() {
            return this.header;
        }

        public final List<FeatureObject> getFeatures() {
            return this.features;
        }

        public final UpcomingFeatures getUpcomingFeatures() {
            return this.upcomingFeatures;
        }

        public final Notice getNotice() {
            return this.notice;
        }

        public final Button getButton() {
            return this.button;
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Header;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Ljava/lang/String;", "getTitle", "imageLink", "getImageLink", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Header {

            @SerializedName("image_link")
            private final String imageLink;
            private final String title;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return Intrinsics.areEqual(this.title, header.title) && Intrinsics.areEqual(this.imageLink, header.imageLink);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.imageLink;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Header(title=" + this.title + ", imageLink=" + this.imageLink + ")";
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getImageLink() {
                return this.imageLink;
            }
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f\u001eB/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eHÇ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014¨\u0006 "}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;", "", "", "seen1", "", "description", "imageLink", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getImageLink", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Feature {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String description;

            @SerializedName("image_link")
            private final String imageLink;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) other;
                return Intrinsics.areEqual(this.description, feature.description) && Intrinsics.areEqual(this.imageLink, feature.imageLink);
            }

            public int hashCode() {
                String str = this.description;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.imageLink;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Feature(description=" + this.description + ", imageLink=" + this.imageLink + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Feature> serializer() {
                    return DataMarketItem$DetailedLayout$Feature$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Feature(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, DataMarketItem$DetailedLayout$Feature$$serializer.INSTANCE.getDescriptor());
                }
                this.description = str;
                this.imageLink = str2;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(Feature self, CompositeEncoder output, SerialDescriptor serialDesc) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.description);
                output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.imageLink);
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getImageLink() {
                return this.imageLink;
            }
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f\u001eB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rHÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$FeatureObject;", "", "", "seen1", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;", "feature", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$FeatureObject;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;", "getFeature", "()Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Feature;", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class FeatureObject {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Feature feature;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FeatureObject) && Intrinsics.areEqual(this.feature, ((FeatureObject) other).feature);
            }

            public int hashCode() {
                Feature feature = this.feature;
                if (feature == null) {
                    return 0;
                }
                return feature.hashCode();
            }

            public String toString() {
                return "FeatureObject(feature=" + this.feature + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$FeatureObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$FeatureObject;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<FeatureObject> serializer() {
                    return DataMarketItem$DetailedLayout$FeatureObject$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ FeatureObject(int i, Feature feature, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, DataMarketItem$DetailedLayout$FeatureObject$$serializer.INSTANCE.getDescriptor());
                }
                this.feature = feature;
            }

            public final Feature getFeature() {
                return this.feature;
            }
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B7\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R!\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures;", "", "", "seen1", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$FeatureObject;", "features", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class UpcomingFeatures {
            private final List<FeatureObject> features;
            private final String title;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(BuiltinSerializersKt.getNullable(DataMarketItem$DetailedLayout$FeatureObject$$serializer.INSTANCE))};

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpcomingFeatures)) {
                    return false;
                }
                UpcomingFeatures upcomingFeatures = (UpcomingFeatures) other;
                return Intrinsics.areEqual(this.title, upcomingFeatures.title) && Intrinsics.areEqual(this.features, upcomingFeatures.features);
            }

            public int hashCode() {
                String str = this.title;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<FeatureObject> list = this.features;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                return "UpcomingFeatures(title=" + this.title + ", features=" + this.features + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$UpcomingFeatures;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<UpcomingFeatures> serializer() {
                    return DataMarketItem$DetailedLayout$UpcomingFeatures$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ UpcomingFeatures(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, DataMarketItem$DetailedLayout$UpcomingFeatures$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                this.features = list;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(UpcomingFeatures self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
                output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.features);
            }

            public final String getTitle() {
                return this.title;
            }

            public final List<FeatureObject> getFeatures() {
                return this.features;
            }
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001cB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rHÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice;", "", "", "seen1", "", "body", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBody", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Notice {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String body;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Notice) && Intrinsics.areEqual(this.body, ((Notice) other).body);
            }

            public int hashCode() {
                String str = this.body;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Notice(body=" + this.body + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Notice;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Notice> serializer() {
                    return DataMarketItem$DetailedLayout$Notice$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Notice(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, DataMarketItem$DetailedLayout$Notice$$serializer.INSTANCE.getDescriptor());
                }
                this.body = str;
            }

            public final String getBody() {
                return this.body;
            }
        }

        /* compiled from: DataMarketItem.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"BC\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b \u0010\u0016R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b!\u0010\u0016¨\u0006$"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button;", "", "", "seen1", "", "type", RemoteMessageConst.Notification.COLOR, FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "link", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self", "(Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "getColor", "getTitle", "getLink", "Companion", "$serializer", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Button {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String color;
            private final String link;
            private final String title;
            private final String type;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Button)) {
                    return false;
                }
                Button button = (Button) other;
                return Intrinsics.areEqual(this.type, button.type) && Intrinsics.areEqual(this.color, button.color) && Intrinsics.areEqual(this.title, button.title) && Intrinsics.areEqual(this.link, button.link);
            }

            public int hashCode() {
                String str = this.type;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.color;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.title;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.link;
                return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                return "Button(type=" + this.type + ", color=" + this.color + ", title=" + this.title + ", link=" + this.link + ")";
            }

            /* compiled from: DataMarketItem.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem$DetailedLayout$Button;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Button> serializer() {
                    return DataMarketItem$DetailedLayout$Button$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Button(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
                if (15 != (i & 15)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 15, DataMarketItem$DetailedLayout$Button$$serializer.INSTANCE.getDescriptor());
                }
                this.type = str;
                this.color = str2;
                this.title = str3;
                this.link = str4;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(Button self, CompositeEncoder output, SerialDescriptor serialDesc) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.type);
                output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.color);
                output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.title);
                output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.link);
            }

            public final String getType() {
                return this.type;
            }

            public final String getColor() {
                return this.color;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getLink() {
                return this.link;
            }
        }
    }
}
