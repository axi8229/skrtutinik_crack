package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes2.dex */
public final class PsshAtomUtil {
    public static byte[] buildPsshAtom(UUID systemId, byte[] data) {
        return buildPsshAtom(systemId, null, data);
    }

    public static byte[] buildPsshAtom(UUID systemId, UUID[] keyIds, byte[] data) {
        int length = (data != null ? data.length : 0) + 32;
        if (keyIds != null) {
            length += (keyIds.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(keyIds != null ? Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE : 0);
        byteBufferAllocate.putLong(systemId.getMostSignificantBits());
        byteBufferAllocate.putLong(systemId.getLeastSignificantBits());
        if (keyIds != null) {
            byteBufferAllocate.putInt(keyIds.length);
            for (UUID uuid : keyIds) {
                byteBufferAllocate.putLong(uuid.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
            }
        }
        if (data != null && data.length != 0) {
            byteBufferAllocate.putInt(data.length);
            byteBufferAllocate.put(data);
        }
        return byteBufferAllocate.array();
    }

    public static boolean isPsshAtom(byte[] data) {
        return parsePsshAtom(data) != null;
    }

    public static UUID parseUuid(byte[] atom) {
        PsshAtom psshAtom = parsePsshAtom(atom);
        if (psshAtom == null) {
            return null;
        }
        return psshAtom.uuid;
    }

    public static int parseVersion(byte[] atom) {
        PsshAtom psshAtom = parsePsshAtom(atom);
        if (psshAtom == null) {
            return -1;
        }
        return psshAtom.version;
    }

    public static byte[] parseSchemeSpecificData(byte[] atom, UUID uuid) {
        PsshAtom psshAtom = parsePsshAtom(atom);
        if (psshAtom == null) {
            return null;
        }
        if (uuid != null && !uuid.equals(psshAtom.uuid)) {
            Log.w("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + psshAtom.uuid + ".");
            return null;
        }
        return psshAtom.schemeData;
    }

    private static PsshAtom parsePsshAtom(byte[] atom) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(atom);
        if (parsableByteArray.limit() < 32) {
            return null;
        }
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readInt() != parsableByteArray.bytesLeft() + 4 || parsableByteArray.readInt() != 1886614376) {
            return null;
        }
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (fullAtomVersion > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + fullAtomVersion);
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
        if (fullAtomVersion == 1) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedIntToInt() * 16);
        }
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt != parsableByteArray.bytesLeft()) {
            return null;
        }
        byte[] bArr = new byte[unsignedIntToInt];
        parsableByteArray.readBytes(bArr, 0, unsignedIntToInt);
        return new PsshAtom(uuid, fullAtomVersion, bArr);
    }

    private static class PsshAtom {
        private final byte[] schemeData;
        private final UUID uuid;
        private final int version;

        public PsshAtom(UUID uuid, int version, byte[] schemeData) {
            this.uuid = uuid;
            this.version = version;
            this.schemeData = schemeData;
        }
    }
}
