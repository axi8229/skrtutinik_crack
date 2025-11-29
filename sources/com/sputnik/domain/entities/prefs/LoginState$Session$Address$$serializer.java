package com.sputnik.domain.entities.prefs;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.profile.AddressStatus;
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

/* compiled from: LoginState.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/prefs/LoginState.Session.Address.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/prefs/LoginState$Session$Address;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class LoginState$Session$Address$$serializer implements GeneratedSerializer<LoginState.Session.Address> {
    public static final LoginState$Session$Address$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        LoginState$Session$Address$$serializer loginState$Session$Address$$serializer = new LoginState$Session$Address$$serializer();
        INSTANCE = loginState$Session$Address$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.prefs.LoginState.Session.Address", loginState$Session$Address$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("fullAddress", true);
        pluginGeneratedSerialDescriptor.addElement("fullAddressWithApartment", true);
        pluginGeneratedSerialDescriptor.addElement("addressVerificationRequired", true);
        pluginGeneratedSerialDescriptor.addElement("apartment", true);
        pluginGeneratedSerialDescriptor.addElement("flatUUID", true);
        pluginGeneratedSerialDescriptor.addElement("entryUUID", true);
        pluginGeneratedSerialDescriptor.addElement("isSelected", true);
        pluginGeneratedSerialDescriptor.addElement(UpdateKey.STATUS, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LoginState$Session$Address$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = LoginState.Session.Address.$childSerializers;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(intSerializer);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), booleanSerializer, kSerializerArr[8]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LoginState.Session.Address deserialize(Decoder decoder) {
        boolean z;
        AddressStatus addressStatus;
        String str;
        String str2;
        Integer num;
        Boolean bool;
        String str3;
        int i;
        Integer num2;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = LoginState.Session.Address.$childSerializers;
        int i2 = 7;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, intSerializer, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, intSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, stringSerializer, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 7);
            addressStatus = (AddressStatus) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            num = num4;
            z = zDecodeBooleanElement;
            str2 = str8;
            str = str7;
            bool = bool2;
            i = 511;
            str3 = str6;
            str4 = str5;
            num2 = num3;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            AddressStatus addressStatus2 = null;
            String str9 = null;
            String str10 = null;
            Integer num5 = null;
            Boolean bool3 = null;
            Integer num6 = null;
            String str11 = null;
            String str12 = null;
            int i3 = 0;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 7;
                    case 0:
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, num6);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str11);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str12);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool3);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num5);
                        i3 |= 16;
                        i2 = 7;
                    case 5:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str9);
                        i3 |= 32;
                        i2 = 7;
                    case 6:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str10);
                        i3 |= 64;
                        i2 = 7;
                    case 7:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i2);
                        i3 |= 128;
                    case 8:
                        addressStatus2 = (AddressStatus) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], addressStatus2);
                        i3 |= 256;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            z = zDecodeBooleanElement2;
            addressStatus = addressStatus2;
            str = str9;
            str2 = str10;
            num = num5;
            bool = bool3;
            str3 = str12;
            i = i3;
            num2 = num6;
            str4 = str11;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new LoginState.Session.Address(i, num2, str4, str3, bool, num, str, str2, z, addressStatus, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LoginState.Session.Address value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        LoginState.Session.Address.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
