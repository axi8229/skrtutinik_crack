package com.sputnik.domain.entities.market;

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

/* compiled from: DomainSubsPlans.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/market/DomainSubsPlans.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/market/DomainSubsPlans;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainSubsPlans$$serializer implements GeneratedSerializer<DomainSubsPlans> {
    public static final DomainSubsPlans$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainSubsPlans$$serializer domainSubsPlans$$serializer = new DomainSubsPlans$$serializer();
        INSTANCE = domainSubsPlans$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.market.DomainSubsPlans", domainSubsPlans$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("identifier", true);
        pluginGeneratedSerialDescriptor.addElement(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, true);
        pluginGeneratedSerialDescriptor.addElement("price", true);
        pluginGeneratedSerialDescriptor.addElement(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, true);
        pluginGeneratedSerialDescriptor.addElement("special", true);
        pluginGeneratedSerialDescriptor.addElement("specialDescription", true);
        pluginGeneratedSerialDescriptor.addElement("specialBadgeTitle", true);
        pluginGeneratedSerialDescriptor.addElement("priceVerbose", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainSubsPlans$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = DomainSubsPlans.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[1]), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainSubsPlans deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        Boolean bool;
        String str4;
        PlansDuration plansDuration;
        Integer num;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = DomainSubsPlans.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        String str6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            PlansDuration plansDuration2 = (PlansDuration) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            plansDuration = plansDuration2;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, stringSerializer, null);
            i = 255;
            str2 = str10;
            str3 = str9;
            str5 = str8;
            bool = bool2;
            num = num2;
            str4 = str7;
        } else {
            boolean z = true;
            int i4 = 0;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            Boolean bool3 = null;
            PlansDuration plansDuration3 = null;
            Integer num3 = null;
            String str14 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 6;
                    case 0:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str6);
                        i4 |= 1;
                        i2 = 7;
                        i3 = 6;
                    case 1:
                        plansDuration3 = (PlansDuration) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], plansDuration3);
                        i4 |= 2;
                        i2 = 7;
                    case 2:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num3);
                        i4 |= 4;
                        i2 = 7;
                    case 3:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str14);
                        i4 |= 8;
                        i2 = 7;
                    case 4:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool3);
                        i4 |= 16;
                        i2 = 7;
                    case 5:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str13);
                        i4 |= 32;
                    case 6:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, StringSerializer.INSTANCE, str12);
                        i4 |= 64;
                    case 7:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str11);
                        i4 |= 128;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i4;
            str = str11;
            str2 = str12;
            str3 = str13;
            bool = bool3;
            str4 = str6;
            plansDuration = plansDuration3;
            num = num3;
            str5 = str14;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainSubsPlans(i, str4, plansDuration, num, str5, bool, str3, str2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DomainSubsPlans value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DomainSubsPlans.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
