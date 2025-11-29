package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.l;
import com.huawei.wisesecurity.ucs_credential.o;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class CredentialEncryptHandler implements EncryptHandler {
    private CredentialCipherText cipherText;
    private Credential credential;
    private CredentialClient credentialClient;

    public CredentialEncryptHandler(Credential credential, CredentialCipherText credentialCipherText, CredentialClient credentialClient) {
        this.credential = credential;
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient;
    }

    private void doEncrypt() throws UcsCryptoException {
        o oVar = (o) new o().a().setApiName("appAuth.encrypt").setCallTime();
        try {
            try {
                this.cipherText.checkParam(true);
                this.cipherText.setCipherBytes(new AESCipher.Builder().withKey(new SecretKeySpec(SkDkEntity.from(this.credential.getDataKeyBytes()).decryptSkDk(l.a(this.credential)), "AES")).withAlg(CipherAlg.AES_GCM).withIv(this.cipherText.getIv()).build().getEncryptHandler().from(this.cipherText.getPlainBytes()).to());
                oVar.setStatusCode(0);
            } catch (CryptoException e) {
                e = e;
                String str = "Fail to encrypt, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str);
                throw new UcsCryptoException(1003L, str);
            } catch (UcsParamException e2) {
                String str2 = "Fail to encrypt, errorMessage : " + e2.getMessage();
                oVar.setStatusCode(1001).setErrorMsg(str2);
                throw new UcsCryptoException(1001L, str2);
            } catch (UcsException e3) {
                e = e3;
                String str3 = "Fail to encrypt, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str3);
                throw new UcsCryptoException(1003L, str3);
            }
        } finally {
            this.credentialClient.reportLogs(oVar);
        }
    }

    private CredentialEncryptHandler from(String str, Decoder decoder) throws UcsCryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to decode plain text : ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    private String to(Encoder encoder) throws UcsCryptoException {
        try {
            doEncrypt();
            return encoder.encode(this.cipherText.getCipherBytes());
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to encode cipher bytes: ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    public CredentialEncryptHandler from(String str) throws UcsCryptoException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsCryptoException(1001L, "plainText cannot empty..");
        }
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler
    public CredentialEncryptHandler from(byte[] bArr) throws UcsCryptoException {
        if (bArr == null) {
            throw new UcsCryptoException(1001L, "plainBytes cannot null..");
        }
        this.cipherText.setPlainBytes(ByteUtil.clone(bArr));
        return this;
    }

    public CredentialEncryptHandler fromBase64(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64);
    }

    public CredentialEncryptHandler fromBase64Url(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64URL);
    }

    public CredentialEncryptHandler fromHex(String str) throws UcsCryptoException {
        return from(str, Decoder.HEX);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler
    public byte[] to() throws UcsCryptoException {
        doEncrypt();
        return this.cipherText.getCipherBytes();
    }

    public String toBase64() throws UcsCryptoException {
        return to(Encoder.BASE64);
    }

    public String toBase64Url() throws UcsCryptoException {
        return to(Encoder.BASE64URL);
    }

    public String toHex() throws UcsCryptoException {
        return to(Encoder.HEX);
    }
}
