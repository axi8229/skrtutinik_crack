package com.sputnik.domain.entities.market.subscription;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle;
import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle$$serializer;
import com.sputnik.domain.entities.market.appearance.DomainDetailedLayout;
import com.sputnik.domain.entities.market.appearance.DomainDetailedLayout$$serializer;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainSubscriptionAppearance.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainSubscriptionAppearance$$serializer implements GeneratedSerializer<DomainSubscriptionAppearance> {
    public static final DomainSubscriptionAppearance$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainSubscriptionAppearance$$serializer domainSubscriptionAppearance$$serializer = new DomainSubscriptionAppearance$$serializer();
        INSTANCE = domainSubscriptionAppearance$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance", domainSubscriptionAppearance$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("specialDescription", true);
        pluginGeneratedSerialDescriptor.addElement("special", true);
        pluginGeneratedSerialDescriptor.addElement("badge", true);
        pluginGeneratedSerialDescriptor.addElement("list", true);
        pluginGeneratedSerialDescriptor.addElement("finale", true);
        pluginGeneratedSerialDescriptor.addElement("link", true);
        pluginGeneratedSerialDescriptor.addElement("priceVerbose", true);
        pluginGeneratedSerialDescriptor.addElement("detailedLayout", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainSubscriptionAppearance$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = DomainSubscriptionAppearance.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainBadgeStyle$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(DomainDetailedLayout$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainSubscriptionAppearance deserialize(Decoder decoder) {
        int i;
        DomainDetailedLayout domainDetailedLayout;
        String str;
        List list;
        String str2;
        DomainBadgeStyle domainBadgeStyle;
        String str3;
        Boolean bool;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = DomainSubscriptionAppearance.$childSerializers;
        int i2 = 9;
        String str7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            DomainBadgeStyle domainBadgeStyle2 = (DomainBadgeStyle) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, DomainBadgeStyle$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, stringSerializer, null);
            list = list2;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, stringSerializer, null);
            domainDetailedLayout = (DomainDetailedLayout) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, DomainDetailedLayout$$serializer.INSTANCE, null);
            str3 = str12;
            str2 = str11;
            bool = bool2;
            i = 1023;
            domainBadgeStyle = domainBadgeStyle2;
            str4 = str10;
            str6 = str9;
            str5 = str8;
        } else {
            boolean z = true;
            int i3 = 0;
            DomainDetailedLayout domainDetailedLayout2 = null;
            String str13 = null;
            List list3 = null;
            String str14 = null;
            DomainBadgeStyle domainBadgeStyle3 = null;
            String str15 = null;
            Boolean bool3 = null;
            String str16 = null;
            String str17 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str7);
                        i3 |= 1;
                        i2 = 9;
                    case 1:
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str17);
                        i3 |= 2;
                        i2 = 9;
                    case 2:
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str16);
                        i3 |= 4;
                        i2 = 9;
                    case 3:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool3);
                        i3 |= 8;
                        i2 = 9;
                    case 4:
                        domainBadgeStyle3 = (DomainBadgeStyle) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, DomainBadgeStyle$$serializer.INSTANCE, domainBadgeStyle3);
                        i3 |= 16;
                        i2 = 9;
                    case 5:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], list3);
                        i3 |= 32;
                        i2 = 9;
                    case 6:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str14);
                        i3 |= 64;
                        i2 = 9;
                    case 7:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str15);
                        i3 |= 128;
                        i2 = 9;
                    case 8:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str13);
                        i3 |= 256;
                        i2 = 9;
                    case 9:
                        domainDetailedLayout2 = (DomainDetailedLayout) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, DomainDetailedLayout$$serializer.INSTANCE, domainDetailedLayout2);
                        i3 |= 512;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i3;
            domainDetailedLayout = domainDetailedLayout2;
            str = str13;
            list = list3;
            str2 = str14;
            domainBadgeStyle = domainBadgeStyle3;
            str3 = str15;
            bool = bool3;
            str4 = str16;
            str5 = str7;
            str6 = str17;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainSubscriptionAppearance(i, str5, str6, str4, bool, domainBadgeStyle, list, str2, str3, str, domainDetailedLayout, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DomainSubscriptionAppearance value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DomainSubscriptionAppearance.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
