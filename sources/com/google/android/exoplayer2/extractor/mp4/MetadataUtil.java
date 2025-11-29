package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
final class MetadataUtil {
    static final String[] STANDARD_GENRES = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    public static void setFormatMetadata(int trackType, Metadata udtaMetadata, Metadata mdtaMetadata, GaplessInfoHolder gaplessInfoHolder, Format.Builder formatBuilder) {
        if (trackType == 1) {
            if (gaplessInfoHolder.hasGaplessInfo()) {
                formatBuilder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
            }
            if (udtaMetadata != null) {
                formatBuilder.setMetadata(udtaMetadata);
                return;
            }
            return;
        }
        if (trackType != 2 || mdtaMetadata == null) {
            return;
        }
        for (int i = 0; i < mdtaMetadata.length(); i++) {
            Metadata.Entry entry = mdtaMetadata.get(i);
            if (entry instanceof MdtaMetadataEntry) {
                MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                if ("com.android.capture.fps".equals(mdtaMetadataEntry.key)) {
                    formatBuilder.setMetadata(new Metadata(mdtaMetadataEntry));
                }
            }
        }
    }

    public static Metadata.Entry parseIlstElement(ParsableByteArray ilst) {
        int position = ilst.getPosition() + ilst.readInt();
        int i = ilst.readInt();
        int i2 = (i >> 24) & KotlinVersion.MAX_COMPONENT_VALUE;
        try {
            if (i2 == 169 || i2 == 253) {
                int i3 = 16777215 & i;
                if (i3 == 6516084) {
                    return parseCommentAttribute(i, ilst);
                }
                if (i3 == 7233901 || i3 == 7631467) {
                    return parseTextAttribute(i, "TIT2", ilst);
                }
                if (i3 == 6516589 || i3 == 7828084) {
                    return parseTextAttribute(i, "TCOM", ilst);
                }
                if (i3 == 6578553) {
                    return parseTextAttribute(i, "TDRC", ilst);
                }
                if (i3 == 4280916) {
                    return parseTextAttribute(i, "TPE1", ilst);
                }
                if (i3 == 7630703) {
                    return parseTextAttribute(i, "TSSE", ilst);
                }
                if (i3 == 6384738) {
                    return parseTextAttribute(i, "TALB", ilst);
                }
                if (i3 == 7108978) {
                    return parseTextAttribute(i, "USLT", ilst);
                }
                if (i3 == 6776174) {
                    return parseTextAttribute(i, "TCON", ilst);
                }
                if (i3 == 6779504) {
                    return parseTextAttribute(i, "TIT1", ilst);
                }
            } else {
                if (i == 1735291493) {
                    return parseStandardGenreAttribute(ilst);
                }
                if (i == 1684632427) {
                    return parseIndexAndCountAttribute(i, "TPOS", ilst);
                }
                if (i == 1953655662) {
                    return parseIndexAndCountAttribute(i, "TRCK", ilst);
                }
                if (i == 1953329263) {
                    return parseUint8Attribute(i, "TBPM", ilst, true, false);
                }
                if (i == 1668311404) {
                    return parseUint8Attribute(i, "TCMP", ilst, true, true);
                }
                if (i == 1668249202) {
                    return parseCoverArt(ilst);
                }
                if (i == 1631670868) {
                    return parseTextAttribute(i, "TPE2", ilst);
                }
                if (i == 1936682605) {
                    return parseTextAttribute(i, "TSOT", ilst);
                }
                if (i == 1936679276) {
                    return parseTextAttribute(i, "TSO2", ilst);
                }
                if (i == 1936679282) {
                    return parseTextAttribute(i, "TSOA", ilst);
                }
                if (i == 1936679265) {
                    return parseTextAttribute(i, "TSOP", ilst);
                }
                if (i == 1936679791) {
                    return parseTextAttribute(i, "TSOC", ilst);
                }
                if (i == 1920233063) {
                    return parseUint8Attribute(i, "ITUNESADVISORY", ilst, false, false);
                }
                if (i == 1885823344) {
                    return parseUint8Attribute(i, "ITUNESGAPLESS", ilst, false, true);
                }
                if (i == 1936683886) {
                    return parseTextAttribute(i, "TVSHOWSORT", ilst);
                }
                if (i == 1953919848) {
                    return parseTextAttribute(i, "TVSHOW", ilst);
                }
                if (i == 757935405) {
                    return parseInternalAttribute(ilst, position);
                }
            }
            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + Atom.getAtomTypeString(i));
            ilst.setPosition(position);
            return null;
        } finally {
            ilst.setPosition(position);
        }
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray ilst, int endPosition, String key) {
        while (true) {
            int position = ilst.getPosition();
            if (position >= endPosition) {
                return null;
            }
            int i = ilst.readInt();
            if (ilst.readInt() == 1684108385) {
                int i2 = ilst.readInt();
                int i3 = ilst.readInt();
                int i4 = i - 16;
                byte[] bArr = new byte[i4];
                ilst.readBytes(bArr, 0, i4);
                return new MdtaMetadataEntry(key, bArr, i3, i2);
            }
            ilst.setPosition(position + i);
        }
    }

    private static TextInformationFrame parseTextAttribute(int type, String id, ParsableByteArray data) {
        int i = data.readInt();
        if (data.readInt() == 1684108385) {
            data.skipBytes(8);
            return new TextInformationFrame(id, null, data.readNullTerminatedString(i - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + Atom.getAtomTypeString(type));
        return null;
    }

    private static CommentFrame parseCommentAttribute(int type, ParsableByteArray data) {
        int i = data.readInt();
        if (data.readInt() == 1684108385) {
            data.skipBytes(8);
            String nullTerminatedString = data.readNullTerminatedString(i - 16);
            return new CommentFrame("und", nullTerminatedString, nullTerminatedString);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + Atom.getAtomTypeString(type));
        return null;
    }

    private static Id3Frame parseUint8Attribute(int type, String id, ParsableByteArray data, boolean isTextInformationFrame, boolean isBoolean) {
        int uint8AttributeValue = parseUint8AttributeValue(data);
        if (isBoolean) {
            uint8AttributeValue = Math.min(1, uint8AttributeValue);
        }
        if (uint8AttributeValue >= 0) {
            if (isTextInformationFrame) {
                return new TextInformationFrame(id, null, Integer.toString(uint8AttributeValue));
            }
            return new CommentFrame("und", id, Integer.toString(uint8AttributeValue));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(type));
        return null;
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int type, String attributeName, ParsableByteArray data) {
        int i = data.readInt();
        if (data.readInt() == 1684108385 && i >= 22) {
            data.skipBytes(10);
            int unsignedShort = data.readUnsignedShort();
            if (unsignedShort > 0) {
                String str = "" + unsignedShort;
                int unsignedShort2 = data.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    str = str + "/" + unsignedShort2;
                }
                return new TextInformationFrame(attributeName, null, str);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + Atom.getAtomTypeString(type));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray r3) {
        /*
            int r3 = parseUint8AttributeValue(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.google.android.exoplayer2.extractor.mp4.MetadataUtil.STANDARD_GENRES
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.Log.w(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static ApicFrame parseCoverArt(ParsableByteArray data) {
        String str;
        int i = data.readInt();
        if (data.readInt() != 1684108385) {
            Log.w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int fullAtomFlags = Atom.parseFullAtomFlags(data.readInt());
        if (fullAtomFlags == 13) {
            str = "image/jpeg";
        } else {
            str = fullAtomFlags == 14 ? "image/png" : null;
        }
        if (str == null) {
            Log.w("MetadataUtil", "Unrecognized cover art flags: " + fullAtomFlags);
            return null;
        }
        data.skipBytes(4);
        int i2 = i - 16;
        byte[] bArr = new byte[i2];
        data.readBytes(bArr, 0, i2);
        return new ApicFrame(str, null, 3, bArr);
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray data, int endPosition) {
        String nullTerminatedString = null;
        String nullTerminatedString2 = null;
        int i = -1;
        int i2 = -1;
        while (data.getPosition() < endPosition) {
            int position = data.getPosition();
            int i3 = data.readInt();
            int i4 = data.readInt();
            data.skipBytes(4);
            if (i4 == 1835360622) {
                nullTerminatedString = data.readNullTerminatedString(i3 - 12);
            } else if (i4 == 1851878757) {
                nullTerminatedString2 = data.readNullTerminatedString(i3 - 12);
            } else {
                if (i4 == 1684108385) {
                    i = position;
                    i2 = i3;
                }
                data.skipBytes(i3 - 12);
            }
        }
        if (nullTerminatedString == null || nullTerminatedString2 == null || i == -1) {
            return null;
        }
        data.setPosition(i);
        data.skipBytes(16);
        return new InternalFrame(nullTerminatedString, nullTerminatedString2, data.readNullTerminatedString(i2 - 16));
    }

    private static int parseUint8AttributeValue(ParsableByteArray data) {
        data.skipBytes(4);
        if (data.readInt() == 1684108385) {
            data.skipBytes(8);
            return data.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
