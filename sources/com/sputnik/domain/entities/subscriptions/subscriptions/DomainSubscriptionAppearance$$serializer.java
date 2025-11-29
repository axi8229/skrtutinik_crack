package com.sputnik.domain.entities.subscriptions.subscriptions;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainSubscriptionAppearance.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainSubscriptionAppearance;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainSubscriptionAppearance$$serializer implements GeneratedSerializer<DomainSubscriptionAppearance> {
    public static final DomainSubscriptionAppearance$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainSubscriptionAppearance$$serializer domainSubscriptionAppearance$$serializer = new DomainSubscriptionAppearance$$serializer();
        INSTANCE = domainSubscriptionAppearance$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.subscriptions.subscriptions.DomainSubscriptionAppearance", domainSubscriptionAppearance$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("finale", false);
        pluginGeneratedSerialDescriptor.addElement("price_verbose", false);
        pluginGeneratedSerialDescriptor.addElement("priceText", false);
        pluginGeneratedSerialDescriptor.addElement("special", false);
        pluginGeneratedSerialDescriptor.addElement("special_description", false);
        pluginGeneratedSerialDescriptor.addElement(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("badge", false);
        pluginGeneratedSerialDescriptor.addElement("detailed_layout", false);
        pluginGeneratedSerialDescriptor.addElement("features_list", false);
        pluginGeneratedSerialDescriptor.addElement("featuresPoints", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainSubscriptionAppearance$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = DomainSubscriptionAppearance.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(DomainBadge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainDetailedLayout$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[9]), BuiltinSerializersKt.getNullable(kSerializerArr[10])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainSubscriptionAppearance deserialize(Decoder decoder) {
        String str;
        int i;
        DomainDetailedLayout domainDetailedLayout;
        DomainBadge domainBadge;
        String str2;
        String str3;
        List list;
        String str4;
        Boolean bool;
        List list2;
        String str5;
        String str6;
        KSerializer[] kSerializerArr;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr2 = DomainSubscriptionAppearance.$childSerializers;
        String str8 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, stringSerializer, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            DomainBadge domainBadge2 = (DomainBadge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, DomainBadge$$serializer.INSTANCE, null);
            DomainDetailedLayout domainDetailedLayout2 = (DomainDetailedLayout) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, DomainDetailedLayout$$serializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr2[9], null);
            list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, kSerializerArr2[10], null);
            str2 = str14;
            domainBadge = domainBadge2;
            domainDetailedLayout = domainDetailedLayout2;
            str4 = str13;
            bool = bool2;
            list = list3;
            str3 = str12;
            str5 = str11;
            i = 2047;
            str6 = str10;
            str = str9;
        } else {
            boolean z = true;
            int i2 = 0;
            DomainDetailedLayout domainDetailedLayout3 = null;
            DomainBadge domainBadge3 = null;
            String str15 = null;
            String str16 = null;
            List list4 = null;
            String str17 = null;
            Boolean bool3 = null;
            List list5 = null;
            String str18 = null;
            String str19 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        kSerializerArr = kSerializerArr2;
                        z = false;
                        str8 = str8;
                        kSerializerArr2 = kSerializerArr;
                    case 0:
                        kSerializerArr = kSerializerArr2;
                        i2 |= 1;
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str8);
                        kSerializerArr2 = kSerializerArr;
                    case 1:
                        str7 = str8;
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str19);
                        i2 |= 2;
                        str8 = str7;
                    case 2:
                        str7 = str8;
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str18);
                        i2 |= 4;
                        str8 = str7;
                    case 3:
                        str7 = str8;
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 8;
                        str8 = str7;
                    case 4:
                        str7 = str8;
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str16);
                        i2 |= 16;
                        str8 = str7;
                    case 5:
                        str7 = str8;
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str17);
                        i2 |= 32;
                        str8 = str7;
                    case 6:
                        str7 = str8;
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str15);
                        i2 |= 64;
                        str8 = str7;
                    case 7:
                        str7 = str8;
                        domainBadge3 = (DomainBadge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, DomainBadge$$serializer.INSTANCE, domainBadge3);
                        i2 |= 128;
                        str8 = str7;
                    case 8:
                        str7 = str8;
                        domainDetailedLayout3 = (DomainDetailedLayout) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, DomainDetailedLayout$$serializer.INSTANCE, domainDetailedLayout3);
                        i2 |= 256;
                        str8 = str7;
                    case 9:
                        str7 = str8;
                        list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr2[9], list4);
                        i2 |= 512;
                        str8 = str7;
                    case 10:
                        list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, kSerializerArr2[10], list5);
                        i2 |= 1024;
                        str8 = str8;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str8;
            i = i2;
            domainDetailedLayout = domainDetailedLayout3;
            domainBadge = domainBadge3;
            str2 = str15;
            str3 = str16;
            list = list4;
            str4 = str17;
            bool = bool3;
            list2 = list5;
            str5 = str18;
            str6 = str19;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainSubscriptionAppearance(i, str, str6, str5, bool, str3, str4, str2, domainBadge, domainDetailedLayout, list, list2, null);
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
