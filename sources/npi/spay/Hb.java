package npi.spay;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* loaded from: classes4.dex */
public final class Hb implements GeneratedSerializer {
    public static final Hb a;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor b;

    static {
        Hb hb = new Hb();
        a = hb;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.sber.platform.clickstream.clickstreamlite.internal.models.Event", hb, 12);
        pluginGeneratedSerialDescriptor.addElement("eventAction", false);
        pluginGeneratedSerialDescriptor.addElement("eventType", true);
        pluginGeneratedSerialDescriptor.addElement("geoLatitude", true);
        pluginGeneratedSerialDescriptor.addElement("geoLongitude", true);
        pluginGeneratedSerialDescriptor.addElement("cellularProvider", true);
        pluginGeneratedSerialDescriptor.addElement("batteryLevel", true);
        pluginGeneratedSerialDescriptor.addElement("connectionType", true);
        pluginGeneratedSerialDescriptor.addElement("internalIP", true);
        pluginGeneratedSerialDescriptor.addElement("eventCategory", true);
        pluginGeneratedSerialDescriptor.addElement(AppMeasurementSdk.ConditionalUserProperty.VALUE, true);
        pluginGeneratedSerialDescriptor.addElement("properties", true);
        pluginGeneratedSerialDescriptor.addElement("timeStamp", true);
        b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        ArrayListSerializer arrayListSerializer = new ArrayListSerializer(Jk.a);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, arrayListSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        Object objDecodeSerializableElement;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String strDecodeStringElement;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        Object objDecodeSerializableElement2 = null;
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
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 10, new ArrayListSerializer(Jk.a), null);
            str = strDecodeStringElement2;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 11);
            str10 = strDecodeStringElement11;
            str8 = strDecodeStringElement9;
            str7 = strDecodeStringElement8;
            str6 = strDecodeStringElement7;
            str4 = strDecodeStringElement5;
            str9 = strDecodeStringElement10;
            str5 = strDecodeStringElement6;
            str3 = strDecodeStringElement4;
            str2 = strDecodeStringElement3;
            i = 4095;
        } else {
            int i2 = 11;
            boolean z = true;
            int i3 = 0;
            String strDecodeStringElement12 = null;
            String strDecodeStringElement13 = null;
            String strDecodeStringElement14 = null;
            String strDecodeStringElement15 = null;
            String strDecodeStringElement16 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            String strDecodeStringElement19 = null;
            String strDecodeStringElement20 = null;
            String strDecodeStringElement21 = null;
            String strDecodeStringElement22 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 11;
                    case 0:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        i3 |= 1;
                        i2 = 11;
                    case 1:
                        strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                        i3 |= 2;
                        i2 = 11;
                    case 2:
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                        i3 |= 4;
                        i2 = 11;
                    case 3:
                        strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 3);
                        i3 |= 8;
                        i2 = 11;
                    case 4:
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 4);
                        i3 |= 16;
                        i2 = 11;
                    case 5:
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 5);
                        i3 |= 32;
                        i2 = 11;
                    case 6:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 6);
                        i3 |= 64;
                        i2 = 11;
                    case 7:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 7);
                        i3 |= 128;
                        i2 = 11;
                    case 8:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 8);
                        i3 |= 256;
                        i2 = 11;
                    case 9:
                        strDecodeStringElement21 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 9);
                        i3 |= 512;
                        i2 = 11;
                    case 10:
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 10, new ArrayListSerializer(Jk.a), objDecodeSerializableElement2);
                        i3 |= 1024;
                        i2 = 11;
                    case 11:
                        strDecodeStringElement22 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, i2);
                        i3 |= 2048;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i3;
            objDecodeSerializableElement = objDecodeSerializableElement2;
            str = strDecodeStringElement12;
            str2 = strDecodeStringElement13;
            str3 = strDecodeStringElement14;
            str4 = strDecodeStringElement15;
            str5 = strDecodeStringElement16;
            str6 = strDecodeStringElement17;
            str7 = strDecodeStringElement18;
            str8 = strDecodeStringElement19;
            str9 = strDecodeStringElement20;
            str10 = strDecodeStringElement21;
            strDecodeStringElement = strDecodeStringElement22;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new Ib(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (List) objDecodeSerializableElement, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Ib self = (Ib) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(self, "value");
        PluginGeneratedSerialDescriptor serialDesc = b;
        CompositeEncoder output = encoder.beginStructure(serialDesc);
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.a);
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
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.k, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 10, new ArrayListSerializer(Jk.a), self.k);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.l, E2.a())) {
            output.encodeStringElement(serialDesc, 11, self.l);
        }
        output.endStructure(serialDesc);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
