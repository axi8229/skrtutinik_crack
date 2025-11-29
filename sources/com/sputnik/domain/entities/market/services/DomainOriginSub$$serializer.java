package com.sputnik.domain.entities.market.services;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import flussonic.media.FFmpegMediaMetadataRetriever;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainOriginSub.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/market/services/DomainOriginSub.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainOriginSub$$serializer implements GeneratedSerializer<DomainOriginSub> {
    public static final DomainOriginSub$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainOriginSub$$serializer domainOriginSub$$serializer = new DomainOriginSub$$serializer();
        INSTANCE = domainOriginSub$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.market.services.DomainOriginSub", domainOriginSub$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("productId", true);
        pluginGeneratedSerialDescriptor.addElement(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, true);
        pluginGeneratedSerialDescriptor.addElement("price", true);
        pluginGeneratedSerialDescriptor.addElement("fullExpires", true);
        pluginGeneratedSerialDescriptor.addElement("phone", true);
        pluginGeneratedSerialDescriptor.addElement("website", true);
        pluginGeneratedSerialDescriptor.addElement("originTitle", true);
        pluginGeneratedSerialDescriptor.addElement("showBadge", true);
        pluginGeneratedSerialDescriptor.addElement("appearance", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainOriginSub$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(DomainOriginSub.$childSerializers[0]);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{nullable, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainOriginSub deserialize(Decoder decoder) {
        boolean z;
        com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance domainServiceAppearance;
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        String str5;
        String str6;
        int i;
        OriginType originType;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = DomainOriginSub.$childSerializers;
        int i2 = 9;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            OriginType originType2 = (OriginType) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, stringSerializer, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, stringSerializer, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 8);
            originType = originType2;
            str = str12;
            domainServiceAppearance = (com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance$$serializer.INSTANCE, null);
            z = zDecodeBooleanElement;
            str2 = str11;
            str4 = str10;
            num = num2;
            i = 1023;
            str3 = str9;
            str5 = str8;
            str6 = str7;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance domainServiceAppearance2 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            Integer num3 = null;
            String str17 = null;
            OriginType originType3 = null;
            String str18 = null;
            int i3 = 0;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 9;
                    case 0:
                        originType3 = (OriginType) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], originType3);
                        i3 |= 1;
                        i2 = 9;
                    case 1:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str18);
                        i3 |= 2;
                        i2 = 9;
                    case 2:
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str17);
                        i3 |= 4;
                        i2 = 9;
                    case 3:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, num3);
                        i3 |= 8;
                        i2 = 9;
                    case 4:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str15);
                        i3 |= 16;
                        i2 = 9;
                    case 5:
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str16);
                        i3 |= 32;
                        i2 = 9;
                    case 6:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str14);
                        i3 |= 64;
                        i2 = 9;
                    case 7:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str13);
                        i3 |= 128;
                        i2 = 9;
                    case 8:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 8);
                        i3 |= 256;
                    case 9:
                        domainServiceAppearance2 = (com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance$$serializer.INSTANCE, domainServiceAppearance2);
                        i3 |= 512;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            z = zDecodeBooleanElement2;
            domainServiceAppearance = domainServiceAppearance2;
            str = str13;
            str2 = str14;
            str3 = str15;
            str4 = str16;
            num = num3;
            str5 = str17;
            str6 = str18;
            i = i3;
            originType = originType3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainOriginSub(i, originType, str6, str5, num, str3, str4, str2, str, z, domainServiceAppearance, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DomainOriginSub value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DomainOriginSub.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
