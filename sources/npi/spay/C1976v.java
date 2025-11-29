package npi.spay;

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

/* renamed from: npi.spay.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1976v implements GeneratedSerializer {
    public static final C1976v a;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor b;

    static {
        C1976v c1976v = new C1976v();
        a = c1976v;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.sber.platform.clickstream.clickstreamlite.internal.models.MetaData", c1976v, 13);
        pluginGeneratedSerialDescriptor.addElement("apiKey", true);
        pluginGeneratedSerialDescriptor.addElement("platform", true);
        pluginGeneratedSerialDescriptor.addElement("browser", true);
        pluginGeneratedSerialDescriptor.addElement("operationSystem", true);
        pluginGeneratedSerialDescriptor.addElement("operationSystemVersion", true);
        pluginGeneratedSerialDescriptor.addElement("systemLanguage", true);
        pluginGeneratedSerialDescriptor.addElement("deviceVendor", true);
        pluginGeneratedSerialDescriptor.addElement("deviceModel", true);
        pluginGeneratedSerialDescriptor.addElement("screenSize", true);
        pluginGeneratedSerialDescriptor.addElement("deviceMemorySize", true);
        pluginGeneratedSerialDescriptor.addElement("deviceAbi", true);
        pluginGeneratedSerialDescriptor.addElement("applicationName", true);
        pluginGeneratedSerialDescriptor.addElement("timeStamp", true);
        b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        int i;
        String strDecodeStringElement;
        String str2;
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
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        int i2 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 3);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 4);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 5);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 6);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 7);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 8);
            String strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 9);
            String strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 10);
            String strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 11);
            str = strDecodeStringElement2;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 12);
            str2 = strDecodeStringElement13;
            str3 = strDecodeStringElement12;
            str4 = strDecodeStringElement11;
            str5 = strDecodeStringElement9;
            str6 = strDecodeStringElement8;
            str7 = strDecodeStringElement7;
            str8 = strDecodeStringElement5;
            str9 = strDecodeStringElement10;
            str10 = strDecodeStringElement6;
            str11 = strDecodeStringElement4;
            str12 = strDecodeStringElement3;
            i = 8191;
        } else {
            String strDecodeStringElement14 = null;
            String strDecodeStringElement15 = null;
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
            boolean z = true;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        i2 |= 1;
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        continue;
                    case 1:
                        strDecodeStringElement26 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                        i2 |= 2;
                        continue;
                    case 2:
                        strDecodeStringElement25 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        strDecodeStringElement22 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        strDecodeStringElement24 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 4);
                        i2 |= 16;
                        break;
                    case 5:
                        strDecodeStringElement21 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 5);
                        i2 |= 32;
                        break;
                    case 6:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 6);
                        i2 |= 64;
                        break;
                    case 7:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 7);
                        i2 |= 128;
                        break;
                    case 8:
                        strDecodeStringElement23 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 8);
                        i2 |= 256;
                        break;
                    case 9:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 9);
                        i2 |= 512;
                        break;
                    case 10:
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 10);
                        i2 |= 1024;
                        break;
                    case 11:
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 11);
                        i2 |= 2048;
                        break;
                    case 12:
                        strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 12);
                        i2 |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = strDecodeStringElement14;
            i = i2;
            strDecodeStringElement = strDecodeStringElement15;
            str2 = strDecodeStringElement16;
            str3 = strDecodeStringElement17;
            str4 = strDecodeStringElement18;
            str5 = strDecodeStringElement19;
            str6 = strDecodeStringElement20;
            str7 = strDecodeStringElement21;
            str8 = strDecodeStringElement22;
            str9 = strDecodeStringElement23;
            str10 = strDecodeStringElement24;
            str11 = strDecodeStringElement25;
            str12 = strDecodeStringElement26;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new C2001w(i, str, str12, str11, str8, str10, str7, str6, str5, str9, str4, str3, str2, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        C2001w self = (C2001w) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(self, "value");
        PluginGeneratedSerialDescriptor serialDesc = b;
        CompositeEncoder output = encoder.beginStructure(serialDesc);
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.a, "")) {
            output.encodeStringElement(serialDesc, 0, self.a);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.b, "")) {
            output.encodeStringElement(serialDesc, 1, self.b);
        }
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
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.m, E2.a())) {
            output.encodeStringElement(serialDesc, 12, self.m);
        }
        output.endStructure(serialDesc);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
