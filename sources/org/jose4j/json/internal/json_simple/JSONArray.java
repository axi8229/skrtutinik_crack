package org.jose4j.json.internal.json_simple;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import okhttp3.HttpUrl;

/* loaded from: classes4.dex */
public class JSONArray extends ArrayList implements JSONAware, JSONStreamAware {
    public static void writeJSONString(Collection collection, Writer writer) throws IOException {
        if (collection == null) {
            writer.write("null");
            return;
        }
        writer.write(91);
        boolean z = true;
        for (Object obj : collection) {
            if (z) {
                z = false;
            } else {
                writer.write(44);
            }
            if (obj == null) {
                writer.write("null");
            } else {
                JSONValue.writeJSONString(obj, writer);
            }
        }
        writer.write(93);
    }

    @Override // org.jose4j.json.internal.json_simple.JSONStreamAware
    public void writeJSONString(Writer writer) throws IOException {
        writeJSONString(this, writer);
    }

    public static String toJSONString(Collection collection) {
        StringWriter stringWriter = new StringWriter();
        try {
            writeJSONString(collection, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJSONString(byte[] bArr, Writer writer) throws IOException {
        if (bArr == null) {
            writer.write("null");
            return;
        }
        if (bArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf((int) bArr[0]));
        for (int i = 1; i < bArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf((int) bArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(short[] sArr, Writer writer) throws IOException {
        if (sArr == null) {
            writer.write("null");
            return;
        }
        if (sArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf((int) sArr[0]));
        for (int i = 1; i < sArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf((int) sArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(int[] iArr, Writer writer) throws IOException {
        if (iArr == null) {
            writer.write("null");
            return;
        }
        if (iArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf(iArr[0]));
        for (int i = 1; i < iArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf(iArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(long[] jArr, Writer writer) throws IOException {
        if (jArr == null) {
            writer.write("null");
            return;
        }
        if (jArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf(jArr[0]));
        for (int i = 1; i < jArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf(jArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(float[] fArr, Writer writer) throws IOException {
        if (fArr == null) {
            writer.write("null");
            return;
        }
        if (fArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf(fArr[0]));
        for (int i = 1; i < fArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf(fArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(double[] dArr, Writer writer) throws IOException {
        if (dArr == null) {
            writer.write("null");
            return;
        }
        if (dArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf(dArr[0]));
        for (int i = 1; i < dArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf(dArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(boolean[] zArr, Writer writer) throws IOException {
        if (zArr == null) {
            writer.write("null");
            return;
        }
        if (zArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        writer.write(String.valueOf(zArr[0]));
        for (int i = 1; i < zArr.length; i++) {
            writer.write(",");
            writer.write(String.valueOf(zArr[i]));
        }
        writer.write("]");
    }

    public static void writeJSONString(char[] cArr, Writer writer) throws IOException {
        if (cArr == null) {
            writer.write("null");
            return;
        }
        if (cArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[\"");
        writer.write(JSONValue.escape(String.valueOf(cArr[0])));
        for (int i = 1; i < cArr.length; i++) {
            writer.write("\",\"");
            writer.write(JSONValue.escape(String.valueOf(cArr[i])));
        }
        writer.write("\"]");
    }

    public static void writeJSONString(Object[] objArr, Writer writer) throws IOException {
        if (objArr == null) {
            writer.write("null");
            return;
        }
        if (objArr.length == 0) {
            writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.write("[");
        JSONValue.writeJSONString(objArr[0], writer);
        for (int i = 1; i < objArr.length; i++) {
            writer.write(",");
            JSONValue.writeJSONString(objArr[i], writer);
        }
        writer.write("]");
    }

    @Override // org.jose4j.json.internal.json_simple.JSONAware
    public String toJSONString() {
        return toJSONString(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return toJSONString();
    }
}
