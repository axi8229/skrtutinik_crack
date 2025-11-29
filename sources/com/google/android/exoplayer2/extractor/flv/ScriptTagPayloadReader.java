package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.yandex.varioqub.config.model.ConfigValue;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class ScriptTagPayloadReader extends TagPayloadReader {
    private long durationUs;

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray data) {
        return true;
    }

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
        this.durationUs = -9223372036854775807L;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parsePayload(ParsableByteArray data, long timeUs) throws ParserException {
        if (readAmfType(data) != 2) {
            throw new ParserException();
        }
        if (!"onMetaData".equals(readAmfString(data)) || readAmfType(data) != 8) {
            return false;
        }
        HashMap<String, Object> amfEcmaArray = readAmfEcmaArray(data);
        if (amfEcmaArray.containsKey(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)) {
            double dDoubleValue = ((Double) amfEcmaArray.get(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)).doubleValue();
            if (dDoubleValue > ConfigValue.DOUBLE_DEFAULT_VALUE) {
                this.durationUs = (long) (dDoubleValue * 1000000.0d);
            }
        }
        return false;
    }

    private static int readAmfType(ParsableByteArray data) {
        return data.readUnsignedByte();
    }

    private static Boolean readAmfBoolean(ParsableByteArray data) {
        return Boolean.valueOf(data.readUnsignedByte() == 1);
    }

    private static Double readAmfDouble(ParsableByteArray data) {
        return Double.valueOf(Double.longBitsToDouble(data.readLong()));
    }

    private static String readAmfString(ParsableByteArray data) {
        int unsignedShort = data.readUnsignedShort();
        int position = data.getPosition();
        data.skipBytes(unsignedShort);
        return new String(data.data, position, unsignedShort);
    }

    private static ArrayList<Object> readAmfStrictArray(ParsableByteArray data) {
        int unsignedIntToInt = data.readUnsignedIntToInt();
        ArrayList<Object> arrayList = new ArrayList<>(unsignedIntToInt);
        for (int i = 0; i < unsignedIntToInt; i++) {
            Object amfData = readAmfData(data, readAmfType(data));
            if (amfData != null) {
                arrayList.add(amfData);
            }
        }
        return arrayList;
    }

    private static HashMap<String, Object> readAmfObject(ParsableByteArray data) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String amfString = readAmfString(data);
            int amfType = readAmfType(data);
            if (amfType == 9) {
                return map;
            }
            Object amfData = readAmfData(data, amfType);
            if (amfData != null) {
                map.put(amfString, amfData);
            }
        }
    }

    private static HashMap<String, Object> readAmfEcmaArray(ParsableByteArray data) {
        int unsignedIntToInt = data.readUnsignedIntToInt();
        HashMap<String, Object> map = new HashMap<>(unsignedIntToInt);
        for (int i = 0; i < unsignedIntToInt; i++) {
            String amfString = readAmfString(data);
            Object amfData = readAmfData(data, readAmfType(data));
            if (amfData != null) {
                map.put(amfString, amfData);
            }
        }
        return map;
    }

    private static Date readAmfDate(ParsableByteArray data) {
        Date date = new Date((long) readAmfDouble(data).doubleValue());
        data.skipBytes(2);
        return date;
    }

    private static Object readAmfData(ParsableByteArray data, int type) {
        if (type == 0) {
            return readAmfDouble(data);
        }
        if (type == 1) {
            return readAmfBoolean(data);
        }
        if (type == 2) {
            return readAmfString(data);
        }
        if (type == 3) {
            return readAmfObject(data);
        }
        if (type == 8) {
            return readAmfEcmaArray(data);
        }
        if (type == 10) {
            return readAmfStrictArray(data);
        }
        if (type != 11) {
            return null;
        }
        return readAmfDate(data);
    }
}
