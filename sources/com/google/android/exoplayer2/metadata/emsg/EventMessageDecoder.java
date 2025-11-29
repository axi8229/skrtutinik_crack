package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class EventMessageDecoder implements MetadataDecoder {
    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer inputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(inputBuffer.data);
        Assertions.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return new Metadata(decode(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage decode(ParsableByteArray emsgData) {
        return new EventMessage((String) Assertions.checkNotNull(emsgData.readNullTerminatedString()), (String) Assertions.checkNotNull(emsgData.readNullTerminatedString()), emsgData.readUnsignedInt(), emsgData.readUnsignedInt(), Arrays.copyOfRange(emsgData.data, emsgData.getPosition(), emsgData.limit()));
    }
}
