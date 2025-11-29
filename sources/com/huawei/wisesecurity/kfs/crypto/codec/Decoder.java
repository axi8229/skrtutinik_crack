package com.huawei.wisesecurity.kfs.crypto.codec;

import android.util.Base64;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.util.HexUtil;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public interface Decoder {
    public static final Decoder BASE64 = new Decoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Decoder.1
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Decoder
        public byte[] decode(String str) throws CodecException {
            try {
                return Base64.decode(str, 0);
            } catch (Exception e) {
                throw new CodecException(e.a(e, f.a("Base64 decode fail : ")));
            }
        }
    };
    public static final Decoder BASE64URL = new Decoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Decoder.2
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Decoder
        public byte[] decode(String str) throws CodecException {
            try {
                return Base64.decode(str, 8);
            } catch (Exception e) {
                throw new CodecException(e.a(e, f.a("Base64 decode fail : ")));
            }
        }
    };
    public static final Decoder HEX = new Decoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Decoder.3
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Decoder
        public byte[] decode(String str) throws CodecException {
            return HexUtil.decodeHexString(str);
        }
    };
    public static final Decoder RAW_BYTES = new Decoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Decoder.4
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Decoder
        public byte[] decode(String str) throws CodecException {
            return str.getBytes(StandardCharsets.UTF_8);
        }
    };

    byte[] decode(String str) throws CodecException;
}
