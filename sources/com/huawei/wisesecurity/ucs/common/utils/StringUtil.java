package com.huawei.wisesecurity.ucs.common.utils;

import android.util.Base64;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class StringUtil {
    public static byte[] base64Decode(String str, int i) throws UcsException {
        if (str == null) {
            return new byte[0];
        }
        try {
            return Base64.decode(str, i);
        } catch (Exception unused) {
            throw new UcsException(1005L, "base64 decode error");
        }
    }

    public static String base64DecodeToString(String str, int i) throws UcsException {
        if (str == null) {
            return "";
        }
        try {
            return new String(Base64.decode(str, i), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            throw new UcsException(1005L, "base64 decode to string error");
        }
    }

    public static String base64EncodeToString(byte[] bArr, int i) throws UcsException {
        if (bArr == null) {
            throw new UcsException(1005L, "base64 encodeToString error: data is null");
        }
        try {
            return Base64.encodeToString(bArr, i);
        } catch (Exception unused) {
            throw new UcsException(1005L, "base64 encodeToString error");
        }
    }
}
