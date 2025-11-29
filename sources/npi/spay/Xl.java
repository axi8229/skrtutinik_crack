package npi.spay;

import com.google.android.gms.common.Scopes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
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

/* loaded from: classes4.dex */
public final class Xl implements GeneratedSerializer {
    public static final Xl a;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor b;

    static {
        Xl xl = new Xl();
        a = xl;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.sber.platform.clickstream.clickstreamlite.internal.models.EventsPackage", xl, 3);
        pluginGeneratedSerialDescriptor.addElement("meta", false);
        pluginGeneratedSerialDescriptor.addElement(Scopes.PROFILE, false);
        pluginGeneratedSerialDescriptor.addElement(RemoteMessageConst.DATA, false);
        b = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{C1976v.a, C1722kj.a, new ArrayListSerializer(Hb.a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        Object objDecodeSerializableElement;
        Object objDecodeSerializableElement2;
        Object objDecodeSerializableElement3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        Object objDecodeSerializableElement4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 0, C1976v.a, null);
            objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 1, C1722kj.a, null);
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, new ArrayListSerializer(Hb.a), null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            Object objDecodeSerializableElement5 = null;
            Object objDecodeSerializableElement6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 0, C1976v.a, objDecodeSerializableElement6);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 1, C1722kj.a, objDecodeSerializableElement5);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 2, new ArrayListSerializer(Hb.a), objDecodeSerializableElement4);
                    i2 |= 4;
                }
            }
            i = i2;
            objDecodeSerializableElement = objDecodeSerializableElement4;
            objDecodeSerializableElement2 = objDecodeSerializableElement5;
            objDecodeSerializableElement3 = objDecodeSerializableElement6;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new Yl(i, (C2001w) objDecodeSerializableElement3, (C1747lj) objDecodeSerializableElement2, (List) objDecodeSerializableElement);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Yl self = (Yl) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(self, "value");
        PluginGeneratedSerialDescriptor serialDesc = b;
        CompositeEncoder output = encoder.beginStructure(serialDesc);
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeSerializableElement(serialDesc, 0, C1976v.a, self.a);
        output.encodeSerializableElement(serialDesc, 1, C1722kj.a, self.b);
        output.encodeSerializableElement(serialDesc, 2, new ArrayListSerializer(Hb.a), self.c);
        output.endStructure(serialDesc);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
