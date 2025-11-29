package org.jose4j.json.internal.json_simple;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes4.dex */
public class JSONValue {
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static void writeJSONString(Object obj, Writer writer) throws IOException {
        if (obj == null) {
            writer.write("null");
            return;
        }
        if (obj instanceof String) {
            writer.write(34);
            writer.write(escape((String) obj));
            writer.write(34);
            return;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.isInfinite() || d.isNaN()) {
                writer.write("null");
                return;
            } else {
                writer.write(obj.toString());
                return;
            }
        }
        if (obj instanceof Float) {
            Float f = (Float) obj;
            if (f.isInfinite() || f.isNaN()) {
                writer.write("null");
                return;
            } else {
                writer.write(obj.toString());
                return;
            }
        }
        if (obj instanceof Number) {
            writer.write(obj.toString());
            return;
        }
        if (obj instanceof Boolean) {
            writer.write(obj.toString());
            return;
        }
        if (obj instanceof JSONStreamAware) {
            ((JSONStreamAware) obj).writeJSONString(writer);
            return;
        }
        if (obj instanceof JSONAware) {
            writer.write(((JSONAware) obj).toJSONString());
            return;
        }
        if (obj instanceof Map) {
            JSONObject.writeJSONString((Map) obj, writer);
            return;
        }
        if (obj instanceof Collection) {
            JSONArray.writeJSONString((Collection) obj, writer);
            return;
        }
        if (obj instanceof byte[]) {
            JSONArray.writeJSONString((byte[]) obj, writer);
            return;
        }
        if (obj instanceof short[]) {
            JSONArray.writeJSONString((short[]) obj, writer);
            return;
        }
        if (obj instanceof int[]) {
            JSONArray.writeJSONString((int[]) obj, writer);
            return;
        }
        if (obj instanceof long[]) {
            JSONArray.writeJSONString((long[]) obj, writer);
            return;
        }
        if (obj instanceof float[]) {
            JSONArray.writeJSONString((float[]) obj, writer);
            return;
        }
        if (obj instanceof double[]) {
            JSONArray.writeJSONString((double[]) obj, writer);
            return;
        }
        if (obj instanceof boolean[]) {
            JSONArray.writeJSONString((boolean[]) obj, writer);
            return;
        }
        if (obj instanceof char[]) {
            JSONArray.writeJSONString((char[]) obj, writer);
        } else if (obj instanceof Object[]) {
            JSONArray.writeJSONString((Object[]) obj, writer);
        } else {
            writeJSONString(obj.toString(), writer);
        }
    }

    public static String toJSONString(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            writeJSONString(obj, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String escape(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        escape(str, sb);
        return sb.toString();
    }

    static void escape(String str, StringBuilder sb) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\f') {
                if (cCharAt != '\r') {
                    if (cCharAt != '\"') {
                        if (cCharAt == '\\') {
                            sb.append("\\\\");
                        } else {
                            switch (cCharAt) {
                                case '\b':
                                    sb.append("\\b");
                                    break;
                                case '\t':
                                    sb.append("\\t");
                                    break;
                                case '\n':
                                    sb.append("\\n");
                                    break;
                                default:
                                    if ((cCharAt >= 0 && cCharAt <= 31) || ((cCharAt >= 127 && cCharAt <= 159) || (cCharAt >= 8192 && cCharAt <= 8447))) {
                                        String hexString = Integer.toHexString(cCharAt);
                                        sb.append("\\u");
                                        for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                                            sb.append('0');
                                        }
                                        sb.append(hexString.toUpperCase());
                                        break;
                                    } else {
                                        sb.append(cCharAt);
                                        break;
                                    }
                            }
                        }
                    } else {
                        sb.append("\\\"");
                    }
                } else {
                    sb.append("\\r");
                }
            } else {
                sb.append("\\f");
            }
        }
    }
}
