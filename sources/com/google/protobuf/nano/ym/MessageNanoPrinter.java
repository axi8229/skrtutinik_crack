package com.google.protobuf.nano.ym;

import com.fasterxml.jackson.core.JsonFactory;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class MessageNanoPrinter {
    private static final String INDENT = "  ";
    private static final int MAX_STRING_LEN = 200;

    private MessageNanoPrinter() {
    }

    private static void appendQuotedBytes(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        for (byte b : bArr) {
            int i = b & 255;
            if (i == 92 || i == 34) {
                stringBuffer.append('\\');
            } else {
                if (i < 32 || i >= 127) {
                    stringBuffer.append(String.format("\\%03o", Integer.valueOf(i)));
                }
            }
            stringBuffer.append((char) i);
        }
        stringBuffer.append(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    private static String deCamelCaseify(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (i == 0) {
                cCharAt = Character.toLowerCase(cCharAt);
            } else if (Character.isUpperCase(cCharAt)) {
                stringBuffer.append('_');
                cCharAt = Character.toLowerCase(cCharAt);
            }
            stringBuffer.append(cCharAt);
        }
        return stringBuffer.toString();
    }

    private static String escapeString(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\'') {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String print(MessageNano messageNano) throws SecurityException, IllegalArgumentException {
        StringBuilder sb;
        if (messageNano == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            print(null, messageNano, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("Error printing proto: ");
            sb.append(e.getMessage());
            return sb.toString();
        } catch (InvocationTargetException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("Error printing proto: ");
            sb.append(e.getMessage());
            return sb.toString();
        }
    }

    private static void print(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        String str2;
        if (obj == null) {
            return;
        }
        if (obj instanceof MessageNano) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(deCamelCaseify(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append(INDENT);
            }
            Class<?> cls = obj.getClass();
            for (Field field : cls.getFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if ((modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        print(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i = 0; i < length2; i++) {
                            print(name, Array.get(obj2, i), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String strSubstring = name2.substring(3);
                    try {
                        if (((Boolean) cls.getMethod("has" + strSubstring, null).invoke(obj, null)).booleanValue()) {
                            print(strSubstring, cls.getMethod("get" + strSubstring, null).invoke(obj, null), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str == null) {
                return;
            }
            stringBuffer.setLength(length);
            stringBuffer2.append(stringBuffer);
            str2 = ">\n";
        } else {
            String strDeCamelCaseify = deCamelCaseify(str);
            stringBuffer2.append(stringBuffer);
            stringBuffer2.append(strDeCamelCaseify);
            stringBuffer2.append(": ");
            if (obj instanceof String) {
                String strSanitizeString = sanitizeString((String) obj);
                stringBuffer2.append("\"");
                stringBuffer2.append(strSanitizeString);
                stringBuffer2.append("\"");
            } else if (obj instanceof byte[]) {
                appendQuotedBytes((byte[]) obj, stringBuffer2);
            } else {
                stringBuffer2.append(obj);
            }
            str2 = "\n";
        }
        stringBuffer2.append(str2);
    }

    private static String sanitizeString(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = str.substring(0, 200) + "[...]";
        }
        return escapeString(str);
    }
}
