package npi.spay;

import com.huawei.hms.push.AttributionReporter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* renamed from: npi.spay.kj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1722kj implements GeneratedSerializer {
    public static final C1722kj a;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor b;

    static {
        C1722kj c1722kj = new C1722kj();
        a = c1722kj;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.sber.platform.clickstream.clickstreamlite.internal.models.ProfileData", c1722kj, 14);
        pluginGeneratedSerialDescriptor.addElement("deviceId", false);
        pluginGeneratedSerialDescriptor.addElement("applicationLanguage", false);
        pluginGeneratedSerialDescriptor.addElement("clientBlock", true);
        pluginGeneratedSerialDescriptor.addElement("sessionId", true);
        pluginGeneratedSerialDescriptor.addElement("partnerId", true);
        pluginGeneratedSerialDescriptor.addElement("appId", true);
        pluginGeneratedSerialDescriptor.addElement("sapId", true);
        pluginGeneratedSerialDescriptor.addElement("subId", true);
        pluginGeneratedSerialDescriptor.addElement("adId", true);
        pluginGeneratedSerialDescriptor.addElement("hashEfsId", true);
        pluginGeneratedSerialDescriptor.addElement(AttributionReporter.APP_VERSION, true);
        pluginGeneratedSerialDescriptor.addElement("appVersionNumber", true);
        pluginGeneratedSerialDescriptor.addElement("hashEpkId", true);
        pluginGeneratedSerialDescriptor.addElement("hashUserLoginId", true);
        b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String strDecodeStringElement;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String strDecodeStringElement2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        int i2 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 3);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 4);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 5);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 6);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 7);
            String strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 8);
            String strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 9);
            String strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 10);
            String strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 11);
            str = strDecodeStringElement3;
            str2 = strDecodeStringElement4;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 12);
            str3 = strDecodeStringElement14;
            str4 = strDecodeStringElement13;
            str5 = strDecodeStringElement12;
            str6 = strDecodeStringElement10;
            str7 = strDecodeStringElement9;
            str8 = strDecodeStringElement8;
            str9 = strDecodeStringElement6;
            str10 = strDecodeStringElement11;
            str11 = strDecodeStringElement7;
            str12 = strDecodeStringElement5;
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 13);
            i = 16383;
        } else {
            int i3 = 13;
            String strDecodeStringElement15 = null;
            boolean z = true;
            String strDecodeStringElement16 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            String strDecodeStringElement19 = null;
            String strDecodeStringElement20 = null;
            String strDecodeStringElement21 = null;
            String strDecodeStringElement22 = null;
            String strDecodeStringElement23 = null;
            String strDecodeStringElement24 = null;
            String strDecodeStringElement25 = null;
            String strDecodeStringElement26 = null;
            String strDecodeStringElement27 = null;
            String strDecodeStringElement28 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 13;
                    case 0:
                        strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        i2 |= 1;
                        i3 = 13;
                    case 1:
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                        i2 |= 2;
                    case 2:
                        strDecodeStringElement27 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                        i2 |= 4;
                    case 3:
                        strDecodeStringElement24 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 3);
                        i2 |= 8;
                    case 4:
                        strDecodeStringElement26 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 4);
                        i2 |= 16;
                    case 5:
                        strDecodeStringElement23 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 5);
                        i2 |= 32;
                    case 6:
                        strDecodeStringElement22 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 6);
                        i2 |= 64;
                    case 7:
                        strDecodeStringElement21 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 7);
                        i2 |= 128;
                    case 8:
                        strDecodeStringElement25 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 8);
                        i2 |= 256;
                    case 9:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 9);
                        i2 |= 512;
                    case 10:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 10);
                        i2 |= 1024;
                    case 11:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 11);
                        i2 |= 2048;
                    case 12:
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 12);
                        i2 |= 4096;
                    case 13:
                        strDecodeStringElement28 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, i3);
                        i2 |= 8192;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i2;
            str = strDecodeStringElement15;
            str2 = strDecodeStringElement16;
            strDecodeStringElement = strDecodeStringElement17;
            str3 = strDecodeStringElement18;
            str4 = strDecodeStringElement19;
            str5 = strDecodeStringElement20;
            str6 = strDecodeStringElement21;
            str7 = strDecodeStringElement22;
            str8 = strDecodeStringElement23;
            str9 = strDecodeStringElement24;
            str10 = strDecodeStringElement25;
            str11 = strDecodeStringElement26;
            str12 = strDecodeStringElement27;
            strDecodeStringElement2 = strDecodeStringElement28;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new C1747lj(i, str, str2, str12, str9, str11, str8, str7, str6, str10, str5, str4, str3, strDecodeStringElement, strDecodeStringElement2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        C1747lj self = (C1747lj) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(self, "value");
        PluginGeneratedSerialDescriptor serialDesc = b;
        CompositeEncoder output = encoder.beginStructure(serialDesc);
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.a);
        output.encodeStringElement(serialDesc, 1, self.b);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.c, "")) {
            output.encodeStringElement(serialDesc, 2, self.c);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.d, "")) {
            output.encodeStringElement(serialDesc, 3, self.d);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.e, "")) {
            output.encodeStringElement(serialDesc, 4, self.e);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.f, "")) {
            output.encodeStringElement(serialDesc, 5, self.f);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.g, "")) {
            output.encodeStringElement(serialDesc, 6, self.g);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.h, "")) {
            output.encodeStringElement(serialDesc, 7, self.h);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.i, "")) {
            output.encodeStringElement(serialDesc, 8, self.i);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.j, "")) {
            output.encodeStringElement(serialDesc, 9, self.j);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.k, "")) {
            output.encodeStringElement(serialDesc, 10, self.k);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.l, "")) {
            output.encodeStringElement(serialDesc, 11, self.l);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.m, "")) {
            output.encodeStringElement(serialDesc, 12, self.m);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.n, "")) {
            output.encodeStringElement(serialDesc, 13, self.n);
        }
        output.endStructure(serialDesc);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
