package com.sputnik.domain.entities.subscriptions.subscriptions;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: DomainDetailedLayout.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainDetailedLayout;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainDetailedLayout$$serializer implements GeneratedSerializer<DomainDetailedLayout> {
    public static final DomainDetailedLayout$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainDetailedLayout$$serializer domainDetailedLayout$$serializer = new DomainDetailedLayout$$serializer();
        INSTANCE = domainDetailedLayout$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.subscriptions.subscriptions.DomainDetailedLayout", domainDetailedLayout$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("features", false);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("included_services", false);
        pluginGeneratedSerialDescriptor.addElement("notice", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainDetailedLayout$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(DomainFeatures$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainHeader$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainIncludedServices$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainNoticeBody$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainDetailedLayout deserialize(Decoder decoder) {
        int i;
        DomainFeatures domainFeatures;
        DomainHeader domainHeader;
        DomainIncludedServices domainIncludedServices;
        DomainNoticeBody domainNoticeBody;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        DomainFeatures domainFeatures2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            DomainFeatures domainFeatures3 = (DomainFeatures) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, DomainFeatures$$serializer.INSTANCE, null);
            DomainHeader domainHeader2 = (DomainHeader) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, DomainHeader$$serializer.INSTANCE, null);
            DomainIncludedServices domainIncludedServices2 = (DomainIncludedServices) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, DomainIncludedServices$$serializer.INSTANCE, null);
            domainFeatures = domainFeatures3;
            domainNoticeBody = (DomainNoticeBody) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, DomainNoticeBody$$serializer.INSTANCE, null);
            domainIncludedServices = domainIncludedServices2;
            domainHeader = domainHeader2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            DomainHeader domainHeader3 = null;
            DomainIncludedServices domainIncludedServices3 = null;
            DomainNoticeBody domainNoticeBody2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    domainFeatures2 = (DomainFeatures) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, DomainFeatures$$serializer.INSTANCE, domainFeatures2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    domainHeader3 = (DomainHeader) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, DomainHeader$$serializer.INSTANCE, domainHeader3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    domainIncludedServices3 = (DomainIncludedServices) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, DomainIncludedServices$$serializer.INSTANCE, domainIncludedServices3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    domainNoticeBody2 = (DomainNoticeBody) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, DomainNoticeBody$$serializer.INSTANCE, domainNoticeBody2);
                    i2 |= 8;
                }
            }
            i = i2;
            domainFeatures = domainFeatures2;
            domainHeader = domainHeader3;
            domainIncludedServices = domainIncludedServices3;
            domainNoticeBody = domainNoticeBody2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainDetailedLayout(i, domainFeatures, domainHeader, domainIncludedServices, domainNoticeBody, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DomainDetailedLayout value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DomainDetailedLayout.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
