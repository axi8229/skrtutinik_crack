package com.google.crypto.tink.internal;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.util.Bytes;

/* loaded from: classes2.dex */
public final class ProtoParametersSerialization implements Serialization {
    private final KeyTemplate keyTemplate;
    private final Bytes objectIdentifier;

    private ProtoParametersSerialization(KeyTemplate keyTemplate) {
        this.keyTemplate = keyTemplate;
        this.objectIdentifier = Util.toBytesFromPrintableAscii(keyTemplate.getTypeUrl());
    }

    public static ProtoParametersSerialization create(String typeUrl, OutputPrefixType outputPrefixType, MessageLite value) {
        return create(KeyTemplate.newBuilder().setTypeUrl(typeUrl).setOutputPrefixType(outputPrefixType).setValue(value.toByteString()).build());
    }

    public static ProtoParametersSerialization create(KeyTemplate keyTemplate) {
        return new ProtoParametersSerialization(keyTemplate);
    }

    public KeyTemplate getKeyTemplate() {
        return this.keyTemplate;
    }

    @Override // com.google.crypto.tink.internal.Serialization
    public Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }
}
