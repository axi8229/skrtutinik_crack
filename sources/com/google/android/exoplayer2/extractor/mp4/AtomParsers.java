package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes2.dex */
final class AtomParsers {
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int hdlr) {
        if (hdlr == 1936684398) {
            return 1;
        }
        if (hdlr == 1986618469) {
            return 2;
        }
        if (hdlr == 1952807028 || hdlr == 1935832172 || hdlr == 1937072756 || hdlr == 1668047728) {
            return 3;
        }
        return hdlr == 1835365473 ? 4 : -1;
    }

    public static Track parseTrak(Atom.ContainerAtom trak, Atom.LeafAtom mvhd, long duration, DrmInitData drmInitData, boolean ignoreEditLists, boolean isQuickTime) throws ParserException {
        Atom.LeafAtom leafAtom;
        long j;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> edts;
        Atom.ContainerAtom containerAtomOfType2 = trak.getContainerAtomOfType(1835297121);
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(containerAtomOfType2.getLeafAtomOfType(1751411826).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(trak.getLeafAtomOfType(1953196132).data);
        if (duration == -9223372036854775807L) {
            leafAtom = mvhd;
            j = tkhd.duration;
        } else {
            leafAtom = mvhd;
            j = duration;
        }
        long mvhd2 = parseMvhd(leafAtom.data);
        long jScaleLargeTimestamp = j != -9223372036854775807L ? Util.scaleLargeTimestamp(j, 1000000L, mvhd2) : -9223372036854775807L;
        Atom.ContainerAtom containerAtomOfType3 = containerAtomOfType2.getContainerAtomOfType(1835626086).getContainerAtomOfType(1937007212);
        Pair<Long, String> mdhd = parseMdhd(containerAtomOfType2.getLeafAtomOfType(1835296868).data);
        StsdData stsd = parseStsd(containerAtomOfType3.getLeafAtomOfType(1937011556).data, tkhd.id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, isQuickTime);
        if (ignoreEditLists || (containerAtomOfType = trak.getContainerAtomOfType(1701082227)) == null || (edts = parseEdts(containerAtomOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.id, trackTypeForHdlr, ((Long) mdhd.first).longValue(), mvhd2, jScaleLargeTimestamp, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.google.android.exoplayer2.extractor.mp4.Track r38, com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom r39, com.google.android.exoplayer2.extractor.GaplessInfoHolder r40) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder):com.google.android.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    public static Metadata parseUdta(Atom.LeafAtom udtaAtom, boolean isQuickTime) {
        if (isQuickTime) {
            return null;
        }
        ParsableByteArray parsableByteArray = udtaAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1835365473) {
                parsableByteArray.setPosition(position);
                return parseUdtaMeta(parsableByteArray, position + i);
            }
            parsableByteArray.setPosition(position + i);
        }
        return null;
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom meta) {
        Atom.LeafAtom leafAtomOfType = meta.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = meta.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = meta.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 >= 0 && i5 < i) {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            } else {
                Log.w("AtomParsers", "Skipped metadata with unknown key index: " + i5);
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseUdtaMeta(ParsableByteArray meta, int limit) {
        meta.skipBytes(12);
        while (meta.getPosition() < limit) {
            int position = meta.getPosition();
            int i = meta.readInt();
            if (meta.readInt() == 1768715124) {
                meta.setPosition(position);
                return parseIlst(meta, position + i);
            }
            meta.setPosition(position + i);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray ilst, int limit) {
        ilst.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (ilst.getPosition() < limit) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(ilst);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static long parseMvhd(ParsableByteArray mvhd) {
        mvhd.setPosition(8);
        mvhd.skipBytes(Atom.parseFullAtomVersion(mvhd.readInt()) != 0 ? 16 : 8);
        return mvhd.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray tkhd) {
        long j;
        tkhd.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(tkhd.readInt());
        tkhd.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i = tkhd.readInt();
        tkhd.skipBytes(4);
        int position = tkhd.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i4 < i2) {
                if (tkhd.data[position + i4] != -1) {
                    long unsignedInt = fullAtomVersion == 0 ? tkhd.readUnsignedInt() : tkhd.readUnsignedLongToLong();
                    if (unsignedInt != 0) {
                        j = unsignedInt;
                    }
                } else {
                    i4++;
                }
            } else {
                tkhd.skipBytes(i2);
                break;
            }
        }
        tkhd.skipBytes(16);
        int i5 = tkhd.readInt();
        int i6 = tkhd.readInt();
        tkhd.skipBytes(4);
        int i7 = tkhd.readInt();
        int i8 = tkhd.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = pjsip_status_code.PJSIP_SC_RINGING;
        }
        return new TkhdData(i, j, i3);
    }

    private static int parseHdlr(ParsableByteArray hdlr) {
        hdlr.setPosition(16);
        return hdlr.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray mdhd) {
        mdhd.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(mdhd.readInt());
        mdhd.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = mdhd.readUnsignedInt();
        mdhd.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = mdhd.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray stsd, int trackId, int rotationDegrees, String language, DrmInitData drmInitData, boolean isQuickTime) throws ParserException {
        stsd.setPosition(12);
        int i = stsd.readInt();
        StsdData stsdData = new StsdData(i);
        for (int i2 = 0; i2 < i; i2++) {
            int position = stsd.getPosition();
            int i3 = stsd.readInt();
            Assertions.checkState(i3 > 0, "childAtomSize should be positive");
            int i4 = stsd.readInt();
            if (i4 == 1635148593 || i4 == 1635148595 || i4 == 1701733238 || i4 == 1836070006 || i4 == 1752589105 || i4 == 1751479857 || i4 == 1932670515 || i4 == 1987063864 || i4 == 1987063865 || i4 == 1635135537 || i4 == 1685479798 || i4 == 1685479729 || i4 == 1685481573 || i4 == 1685481521) {
                parseVideoSampleEntry(stsd, i4, position, i3, trackId, rotationDegrees, drmInitData, stsdData, i2);
            } else if (i4 == 1836069985 || i4 == 1701733217 || i4 == 1633889587 || i4 == 1700998451 || i4 == 1633889588 || i4 == 1685353315 || i4 == 1685353317 || i4 == 1685353320 || i4 == 1685353324 || i4 == 1935764850 || i4 == 1935767394 || i4 == 1819304813 || i4 == 1936684916 || i4 == 1953984371 || i4 == 778924083 || i4 == 1634492771 || i4 == 1634492791 || i4 == 1970037111 || i4 == 1332770163 || i4 == 1716281667) {
                parseAudioSampleEntry(stsd, i4, position, i3, trackId, language, isQuickTime, drmInitData, stsdData, i2);
            } else if (i4 == 1414810956 || i4 == 1954034535 || i4 == 2004251764 || i4 == 1937010800 || i4 == 1664495672) {
                parseTextSampleEntry(stsd, i4, position, i3, trackId, language, stsdData);
            } else if (i4 == 1667329389) {
                stsdData.format = new Format.Builder().setId(trackId).setSampleMimeType("application/x-camera-motion").build();
            }
            stsd.setPosition(position + i3);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parent, int atomType, int position, int atomSize, int trackId, String language, StsdData out) {
        parent.setPosition(position + 16);
        String str = "application/ttml+xml";
        List<byte[]> listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (atomType != 1414810956) {
            if (atomType == 1954034535) {
                int i = atomSize - 16;
                byte[] bArr = new byte[i];
                parent.readBytes(bArr, 0, i);
                listSingletonList = Collections.singletonList(bArr);
                str = "application/x-quicktime-tx3g";
            } else if (atomType == 2004251764) {
                str = "application/x-mp4-vtt";
            } else if (atomType == 1937010800) {
                j = 0;
            } else if (atomType == 1664495672) {
                out.requiredSampleTransformation = 1;
                str = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        out.format = new Format.Builder().setId(trackId).setSampleMimeType(str).setLanguage(language).setSubsampleOffsetUs(j).setInitializationData(listSingletonList).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x017c A[PHI: r12
  0x017c: PHI (r12v18 int) = (r12v17 int), (r12v19 int) binds: [B:90:0x0170, B:92:0x0173] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, int r21, int r22, int r23, com.google.android.exoplayer2.drm.DrmInitData r24, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r25, int r26) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, int, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom edtsAtom) {
        Atom.LeafAtom leafAtomOfType = edtsAtom.getLeafAtomOfType(1701606260);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parent, int position) {
        parent.setPosition(position + 8);
        return parent.readUnsignedIntToInt() / parent.readUnsignedIntToInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r19, int r20, int r21, int r22, int r23, java.lang.String r24, boolean r25, com.google.android.exoplayer2.drm.DrmInitData r26, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r27, int r28) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static int findEsdsPosition(ParsableByteArray parent, int position, int size) {
        int position2 = parent.getPosition();
        while (position2 - position < size) {
            parent.setPosition(position2);
            int i = parent.readInt();
            Assertions.checkState(i > 0, "childAtomSize should be positive");
            if (parent.readInt() == 1702061171) {
                return position2;
            }
            position2 += i;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parent, int position) {
        parent.setPosition(position + 12);
        parent.skipBytes(1);
        parseExpandableClassSize(parent);
        parent.skipBytes(2);
        int unsignedByte = parent.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parent.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parent.skipBytes(parent.readUnsignedShort());
        }
        if ((unsignedByte & 32) != 0) {
            parent.skipBytes(2);
        }
        parent.skipBytes(1);
        parseExpandableClassSize(parent);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parent.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parent.skipBytes(12);
        parent.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parent);
        byte[] bArr = new byte[expandableClassSize];
        parent.readBytes(bArr, 0, expandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parent, int position, int size) {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position2 = parent.getPosition();
        while (position2 - position < size) {
            parent.setPosition(position2);
            int i = parent.readInt();
            Assertions.checkState(i > 0, "childAtomSize should be positive");
            if (parent.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parent, position2, i)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position2 += i;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parent, int position, int size) {
        int i = position + 8;
        int i2 = -1;
        int i3 = 0;
        String string = null;
        Integer numValueOf = null;
        while (i - position < size) {
            parent.setPosition(i);
            int i4 = parent.readInt();
            int i5 = parent.readInt();
            if (i5 == 1718775137) {
                numValueOf = Integer.valueOf(parent.readInt());
            } else if (i5 == 1935894637) {
                parent.skipBytes(4);
                string = parent.readString(4);
            } else if (i5 == 1935894633) {
                i2 = i;
                i3 = i4;
            }
            i += i4;
        }
        if (!"cenc".equals(string) && !"cbc1".equals(string) && !"cens".equals(string) && !"cbcs".equals(string)) {
            return null;
        }
        Assertions.checkStateNotNull(numValueOf, "frma atom is mandatory");
        Assertions.checkState(i2 != -1, "schi atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Assertions.checkStateNotNull(parseSchiFromParent(parent, i2, i3, string), "tenc atom is mandatory"));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parent, int position, int size, String schemeType) {
        int i;
        int i2;
        int i3 = position + 8;
        while (true) {
            byte[] bArr = null;
            if (i3 - position >= size) {
                return null;
            }
            parent.setPosition(i3);
            int i4 = parent.readInt();
            if (parent.readInt() == 1952804451) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parent.readInt());
                parent.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parent.skipBytes(1);
                    i2 = 0;
                    i = 0;
                } else {
                    int unsignedByte = parent.readUnsignedByte();
                    i = unsignedByte & 15;
                    i2 = (unsignedByte & 240) >> 4;
                }
                boolean z = parent.readUnsignedByte() == 1;
                int unsignedByte2 = parent.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parent.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parent.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parent.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, schemeType, unsignedByte2, bArr2, i2, i, bArr);
            }
            i3 += i4;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parent, int position, int size) {
        int i = position + 8;
        while (i - position < size) {
            parent.setPosition(i);
            int i2 = parent.readInt();
            if (parent.readInt() == 1886547818) {
                return Arrays.copyOfRange(parent.data, i, i2 + i);
            }
            i += i2;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray data) {
        int unsignedByte = data.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = data.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] timestamps, long duration, long editStartTime, long editEndTime) {
        int length = timestamps.length - 1;
        return timestamps[0] <= editStartTime && editStartTime < timestamps[Util.constrainValue(4, 0, length)] && timestamps[Util.constrainValue(timestamps.length - 4, 0, length)] < editEndTime && editEndTime <= duration;
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray stsc, ParsableByteArray chunkOffsets, boolean chunkOffsetsAreLongs) {
            this.stsc = stsc;
            this.chunkOffsets = chunkOffsets;
            this.chunkOffsetsAreLongs = chunkOffsetsAreLongs;
            chunkOffsets.setPosition(12);
            this.length = chunkOffsets.readUnsignedIntToInt();
            stsc.setPosition(12);
            this.remainingSamplesPerChunkChanges = stsc.readUnsignedIntToInt();
            Assertions.checkState(stsc.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int id, long duration, int rotationDegrees) {
            this.id = id;
            this.duration = duration;
            this.rotationDegrees = rotationDegrees;
        }
    }

    private static final class StsdData {
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int numberOfEntries) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[numberOfEntries];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom stszAtom) {
            ParsableByteArray parsableByteArray = stszAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom stz2Atom) {
            ParsableByteArray parsableByteArray = stz2Atom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & KotlinVersion.MAX_COMPONENT_VALUE;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int unsignedByte = this.data.readUnsignedByte();
                this.currentByte = unsignedByte;
                return (unsignedByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
