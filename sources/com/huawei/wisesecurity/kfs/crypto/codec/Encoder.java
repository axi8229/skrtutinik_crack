package com.huawei.wisesecurity.kfs.crypto.codec;

import android.util.Base64;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.util.HexUtil;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public interface Encoder {
    public static final Encoder BASE64 = new Encoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Encoder.1
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Encoder
        public String encode(byte[] bArr) throws CodecException {
            return Base64.encodeToString(bArr, 2);
        }
    };
    public static final Encoder BASE64URL = new Encoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Encoder.2
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Encoder
        public String encode(byte[] bArr) throws CodecException {
            return Base64.encodeToString(bArr, 10);
        }
    };
    public static final Encoder HEX = new Encoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Encoder.3
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Encoder
        public String encode(byte[] bArr) throws CodecException {
            if (bArr == null) {
                return null;
            }
            return HexUtil.encodeHexString(bArr, false);
        }
    };
    public static final Encoder RAW = new Encoder() { // from class: com.huawei.wisesecurity.kfs.crypto.codec.Encoder.4
        @Override // com.huawei.wisesecurity.kfs.crypto.codec.Encoder
        public String encode(byte[] bArr) throws CodecException {
            return new String(bArr, StandardCharsets.UTF_8);
        }
    };

    String encode(byte[] bArr) throws CodecException;
}
