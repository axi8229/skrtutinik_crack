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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DomainBaseSubscription.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class DomainBaseSubscription$$serializer implements GeneratedSerializer<DomainBaseSubscription> {
    public static final DomainBaseSubscription$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DomainBaseSubscription$$serializer domainBaseSubscription$$serializer = new DomainBaseSubscription$$serializer();
        INSTANCE = domainBaseSubscription$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription", domainBaseSubscription$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("identifier", false);
        pluginGeneratedSerialDescriptor.addElement("order", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, false);
        pluginGeneratedSerialDescriptor.addElement("expires", false);
        pluginGeneratedSerialDescriptor.addElement("plan", false);
        pluginGeneratedSerialDescriptor.addElement("product_id", false);
        pluginGeneratedSerialDescriptor.addElement("state", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("appearance", false);
        pluginGeneratedSerialDescriptor.addElement("subscription_details", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DomainBaseSubscription$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr = DomainBaseSubscription.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{nullable, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[7]), BuiltinSerializersKt.getNullable(kSerializerArr[8]), BuiltinSerializersKt.getNullable(DomainSubscriptionAppearance$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(DomainSubscriptionDetails$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DomainBaseSubscription deserialize(Decoder decoder) {
        String str;
        int i;
        Integer num;
        SubscriptionTypes subscriptionTypes;
        SubscriptionStates subscriptionStates;
        String str2;
        String str3;
        String str4;
        DomainSubscriptionAppearance domainSubscriptionAppearance;
        DomainSubscriptionDetails domainSubscriptionDetails;
        String str5;
        Integer num2;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = DomainBaseSubscription.$childSerializers;
        String str7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, intSerializer, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, intSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            SubscriptionStates subscriptionStates2 = (SubscriptionStates) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            subscriptionTypes = (SubscriptionTypes) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            str3 = str12;
            num2 = num4;
            domainSubscriptionAppearance = (DomainSubscriptionAppearance) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, DomainSubscriptionAppearance$$serializer.INSTANCE, null);
            subscriptionStates = subscriptionStates2;
            str2 = str11;
            str5 = str9;
            str4 = str10;
            domainSubscriptionDetails = (DomainSubscriptionDetails) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, DomainSubscriptionDetails$$serializer.INSTANCE, null);
            i = 2047;
            num = num3;
            str = str8;
        } else {
            boolean z = true;
            int i2 = 0;
            Integer num5 = null;
            SubscriptionTypes subscriptionTypes2 = null;
            SubscriptionStates subscriptionStates3 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            DomainSubscriptionAppearance domainSubscriptionAppearance2 = null;
            DomainSubscriptionDetails domainSubscriptionDetails2 = null;
            String str16 = null;
            Integer num6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        str7 = str7;
                        kSerializerArr = kSerializerArr;
                    case 0:
                        i2 |= 1;
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str7);
                        kSerializerArr = kSerializerArr;
                    case 1:
                        str6 = str7;
                        num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, num5);
                        i2 |= 2;
                        str7 = str6;
                    case 2:
                        str6 = str7;
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num6);
                        i2 |= 4;
                        str7 = str6;
                    case 3:
                        str6 = str7;
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str16);
                        i2 |= 8;
                        str7 = str6;
                    case 4:
                        str6 = str7;
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str15);
                        i2 |= 16;
                        str7 = str6;
                    case 5:
                        str6 = str7;
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str13);
                        i2 |= 32;
                        str7 = str6;
                    case 6:
                        str6 = str7;
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str14);
                        i2 |= 64;
                        str7 = str6;
                    case 7:
                        str6 = str7;
                        subscriptionStates3 = (SubscriptionStates) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], subscriptionStates3);
                        i2 |= 128;
                        str7 = str6;
                    case 8:
                        str6 = str7;
                        subscriptionTypes2 = (SubscriptionTypes) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], subscriptionTypes2);
                        i2 |= 256;
                        str7 = str6;
                    case 9:
                        domainSubscriptionAppearance2 = (DomainSubscriptionAppearance) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, DomainSubscriptionAppearance$$serializer.INSTANCE, domainSubscriptionAppearance2);
                        i2 |= 512;
                        str7 = str7;
                    case 10:
                        str6 = str7;
                        domainSubscriptionDetails2 = (DomainSubscriptionDetails) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, DomainSubscriptionDetails$$serializer.INSTANCE, domainSubscriptionDetails2);
                        i2 |= 1024;
                        str7 = str6;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str7;
            i = i2;
            num = num5;
            subscriptionTypes = subscriptionTypes2;
            subscriptionStates = subscriptionStates3;
            str2 = str13;
            str3 = str14;
            str4 = str15;
            domainSubscriptionAppearance = domainSubscriptionAppearance2;
            domainSubscriptionDetails = domainSubscriptionDetails2;
            str5 = str16;
            num2 = num6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new DomainBaseSubscription(i, str, num, num2, str5, str4, str2, str3, subscriptionStates, subscriptionTypes, domainSubscriptionAppearance, domainSubscriptionDetails, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DomainBaseSubscription value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        DomainBaseSubscription.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
