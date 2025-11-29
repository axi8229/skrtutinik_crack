package com.sputnik.domain.entities.prefs;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.prefs.LoginState;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: LoginState.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sputnik/domain/entities/prefs/LoginState.Session.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sputnik/domain/entities/prefs/LoginState$Session;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", FFmpegMediaMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/encoding/Encoder;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated
/* loaded from: classes3.dex */
public final class LoginState$Session$$serializer implements GeneratedSerializer<LoginState.Session> {
    public static final LoginState$Session$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        LoginState$Session$$serializer loginState$Session$$serializer = new LoginState$Session$$serializer();
        INSTANCE = loginState$Session$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sputnik.domain.entities.prefs.LoginState.Session", loginState$Session$$serializer, 18);
        pluginGeneratedSerialDescriptor.addElement(AppMeasurementSdk.ConditionalUserProperty.NAME, false);
        pluginGeneratedSerialDescriptor.addElement("countryCode", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("jwt", false);
        pluginGeneratedSerialDescriptor.addElement("isVisible", false);
        pluginGeneratedSerialDescriptor.addElement("image", false);
        pluginGeneratedSerialDescriptor.addElement("profileSettings", false);
        pluginGeneratedSerialDescriptor.addElement("isAvatarLoaded", false);
        pluginGeneratedSerialDescriptor.addElement("avatarUrl", false);
        pluginGeneratedSerialDescriptor.addElement("way", false);
        pluginGeneratedSerialDescriptor.addElement("codeExpiresAt", false);
        pluginGeneratedSerialDescriptor.addElement("requestId", false);
        pluginGeneratedSerialDescriptor.addElement("userSmsCode", true);
        pluginGeneratedSerialDescriptor.addElement("userSmsPhone", true);
        pluginGeneratedSerialDescriptor.addElement("isIntercomOpened", true);
        pluginGeneratedSerialDescriptor.addElement("haveSubscription", true);
        pluginGeneratedSerialDescriptor.addElement("haveLoadingVideo", true);
        pluginGeneratedSerialDescriptor.addElement("addresses", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LoginState$Session$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = LoginState.Session.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{nullable, stringSerializer, stringSerializer, nullable2, BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(ProfileSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[9]), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), BuiltinSerializersKt.getNullable(booleanSerializer), kSerializerArr[17]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LoginState.Session deserialize(Decoder decoder) {
        String str;
        String str2;
        Boolean bool;
        String str3;
        int i;
        String str4;
        Long l;
        RegistrationWay registrationWay;
        String str5;
        ProfileSettings profileSettings;
        Boolean bool2;
        String str6;
        Boolean bool3;
        Boolean bool4;
        String str7;
        Boolean bool5;
        String str8;
        List list;
        String str9;
        KSerializer[] kSerializerArr;
        String str10;
        Boolean bool6;
        String str11;
        String str12;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr2 = LoginState.Session.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, booleanSerializer, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, stringSerializer, null);
            ProfileSettings profileSettings2 = (ProfileSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ProfileSettings$$serializer.INSTANCE, null);
            Boolean bool8 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, booleanSerializer, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, stringSerializer, null);
            RegistrationWay registrationWay2 = (RegistrationWay) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr2[9], null);
            Long l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, LongSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, stringSerializer, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, stringSerializer, null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, stringSerializer, null);
            Boolean bool9 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, booleanSerializer, null);
            Boolean bool10 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, booleanSerializer, null);
            Boolean bool11 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, booleanSerializer, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 17, kSerializerArr2[17], null);
            bool3 = bool11;
            bool5 = bool9;
            profileSettings = profileSettings2;
            str9 = strDecodeStringElement;
            str = str13;
            i = 262143;
            bool2 = bool8;
            str5 = str16;
            str2 = str15;
            str3 = str14;
            bool = bool7;
            str6 = str17;
            bool4 = bool10;
            str8 = str19;
            str4 = str18;
            l = l2;
            str7 = strDecodeStringElement2;
            registrationWay = registrationWay2;
        } else {
            boolean z = true;
            String str20 = null;
            String str21 = null;
            String strDecodeStringElement3 = null;
            Boolean bool12 = null;
            Long l3 = null;
            RegistrationWay registrationWay3 = null;
            String str22 = null;
            ProfileSettings profileSettings3 = null;
            Boolean bool13 = null;
            String str23 = null;
            String strDecodeStringElement4 = null;
            String str24 = null;
            String str25 = null;
            Boolean bool14 = null;
            Boolean bool15 = null;
            Boolean bool16 = null;
            List list2 = null;
            int i2 = 0;
            String str26 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        kSerializerArr = kSerializerArr2;
                        str10 = strDecodeStringElement3;
                        bool6 = bool16;
                        z = false;
                        kSerializerArr2 = kSerializerArr;
                        strDecodeStringElement3 = str10;
                        bool16 = bool6;
                    case 0:
                        str10 = strDecodeStringElement3;
                        bool6 = bool16;
                        kSerializerArr = kSerializerArr2;
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str20);
                        i2 |= 1;
                        kSerializerArr2 = kSerializerArr;
                        strDecodeStringElement3 = str10;
                        bool16 = bool6;
                    case 1:
                        str11 = str20;
                        bool6 = bool16;
                        i2 |= 2;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        str20 = str11;
                        bool16 = bool6;
                    case 2:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i2 |= 4;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 3:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str26);
                        i2 |= 8;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 4:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        bool12 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool12);
                        i2 |= 16;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 5:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str21);
                        i2 |= 32;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 6:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        profileSettings3 = (ProfileSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ProfileSettings$$serializer.INSTANCE, profileSettings3);
                        i2 |= 64;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 7:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        bool13 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, bool13);
                        i2 |= 128;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 8:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str22);
                        i2 |= 256;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 9:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        registrationWay3 = (RegistrationWay) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr2[9], registrationWay3);
                        i2 |= 512;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 10:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, LongSerializer.INSTANCE, l3);
                        i2 |= 1024;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 11:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str23);
                        i2 |= 2048;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 12:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str24);
                        i2 |= 4096;
                        str25 = str25;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 13:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str25);
                        i2 |= 8192;
                        bool14 = bool14;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 14:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        bool14 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, BooleanSerializer.INSTANCE, bool14);
                        i2 |= 16384;
                        bool15 = bool15;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 15:
                        str11 = str20;
                        str12 = strDecodeStringElement3;
                        bool6 = bool16;
                        bool15 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, BooleanSerializer.INSTANCE, bool15);
                        i2 |= pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP;
                        strDecodeStringElement3 = str12;
                        str20 = str11;
                        bool16 = bool6;
                    case 16:
                        String str27 = strDecodeStringElement3;
                        Boolean bool17 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, BooleanSerializer.INSTANCE, bool16);
                        i2 |= pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
                        list2 = list2;
                        str20 = str20;
                        bool16 = bool17;
                        strDecodeStringElement3 = str27;
                    case 17:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 17, kSerializerArr2[17], list2);
                        i2 |= 131072;
                        strDecodeStringElement3 = strDecodeStringElement3;
                        str20 = str20;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str20;
            str2 = str21;
            bool = bool12;
            str3 = str26;
            i = i2;
            str4 = str24;
            l = l3;
            registrationWay = registrationWay3;
            str5 = str22;
            profileSettings = profileSettings3;
            bool2 = bool13;
            str6 = str23;
            bool3 = bool16;
            bool4 = bool15;
            str7 = strDecodeStringElement4;
            bool5 = bool14;
            str8 = str25;
            list = list2;
            str9 = strDecodeStringElement3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new LoginState.Session(i, str, str9, str7, str3, bool, str2, profileSettings, bool2, str5, registrationWay, l, str6, str4, str8, bool5, bool4, bool3, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LoginState.Session value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        LoginState.Session.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
