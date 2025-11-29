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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainService.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/market/services/DomainService.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainService$$serializer implements GeneratedSerializer<DomainService> {
    public static final DomainService$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainService$$serializer domainService$$serializer = new DomainService$$serializer();
        INSTANCE = domainService$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.market.services.DomainService", domainService$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("state", false);
        pluginGeneratedSerialDescriptor.addElement("serviceConfigIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("appearance", true);
        pluginGeneratedSerialDescriptor.addElement(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, true);
        pluginGeneratedSerialDescriptor.addElement("activatedAt", true);
        pluginGeneratedSerialDescriptor.addElement("requiresSubscription", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainService$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = DomainService.$childSerializers[0];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(DomainServiceAppearance$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainOriginSub$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainService deserialize(Decoder decoder) {
        int i;
        ServiceState serviceState;
        String str;
        DomainServiceAppearance domainServiceAppearance;
        DomainOriginSub domainOriginSub;
        String str2;
        Boolean bool;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = DomainService.$childSerializers;
        int i2 = 5;
        ServiceState serviceState2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ServiceState serviceState3 = (ServiceState) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, stringSerializer, null);
            DomainServiceAppearance domainServiceAppearance2 = (DomainServiceAppearance) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, DomainServiceAppearance$$serializer.INSTANCE, null);
            DomainOriginSub domainOriginSub2 = (DomainOriginSub) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, DomainOriginSub$$serializer.INSTANCE, null);
            serviceState = serviceState3;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            domainOriginSub = domainOriginSub2;
            i = 63;
            domainServiceAppearance = domainServiceAppearance2;
            str = str3;
        } else {
            boolean z = true;
            int i3 = 0;
            String str4 = null;
            DomainServiceAppearance domainServiceAppearance3 = null;
            DomainOriginSub domainOriginSub3 = null;
            String str5 = null;
            Boolean bool2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        serviceState2 = (ServiceState) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], serviceState2);
                        i3 |= 1;
                        i2 = 5;
                        continue;
                    case 1:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str4);
                        i3 |= 2;
                        break;
                    case 2:
                        domainServiceAppearance3 = (DomainServiceAppearance) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, DomainServiceAppearance$$serializer.INSTANCE, domainServiceAppearance3);
                        i3 |= 4;
                        break;
                    case 3:
                        domainOriginSub3 = (DomainOriginSub) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, DomainOriginSub$$serializer.INSTANCE, domainOriginSub3);
                        i3 |= 8;
                        break;
                    case 4:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str5);
                        i3 |= 16;
                        break;
                    case 5:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, BooleanSerializer.INSTANCE, bool2);
                        i3 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i3;
            serviceState = serviceState2;
            str = str4;
            domainServiceAppearance = domainServiceAppearance3;
            domainOriginSub = domainOriginSub3;
            str2 = str5;
            bool = bool2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainService(i, serviceState, str, domainServiceAppearance, domainOriginSub, str2, bool, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DomainService value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DomainService.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
