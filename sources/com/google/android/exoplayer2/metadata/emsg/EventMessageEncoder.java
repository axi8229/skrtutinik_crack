package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.byteArrayOutputStream = byteArrayOutputStream;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    public byte[] encode(EventMessage eventMessage) throws IOException {
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            writeNullTerminatedString(this.dataOutputStream, str);
            writeUnsignedInt(this.dataOutputStream, eventMessage.durationMs);
            writeUnsignedInt(this.dataOutputStream, eventMessage.id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream, String value) throws IOException {
        dataOutputStream.writeBytes(value);
        dataOutputStream.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream outputStream, long value) throws IOException {
        outputStream.writeByte(((int) (value >>> 24)) & KotlinVersion.MAX_COMPONENT_VALUE);
        outputStream.writeByte(((int) (value >>> 16)) & KotlinVersion.MAX_COMPONENT_VALUE);
        outputStream.writeByte(((int) (value >>> 8)) & KotlinVersion.MAX_COMPONENT_VALUE);
        outputStream.writeByte(((int) value) & KotlinVersion.MAX_COMPONENT_VALUE);
    }
}
