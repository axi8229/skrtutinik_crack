package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs_credential.f;
import com.huawei.wisesecurity.ucs_credential.l;
import com.huawei.wisesecurity.ucs_credential.o;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class CredentialDecryptHandler implements DecryptHandler {
    private CredentialCipherText cipherText;
    private Credential credential;
    private CredentialClient credentialClient;

    public CredentialDecryptHandler(Credential credential, CredentialCipherText credentialCipherText, CredentialClient credentialClient) {
        this.credential = credential;
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient;
    }

    private void doDecrypt() throws UcsCryptoException {
        o oVar = (o) new o().a().setApiName("appAuth.decrypt").setCallTime();
        try {
            try {
                this.cipherText.checkParam(false);
                this.cipherText.setPlainBytes(new AESCipher.Builder().withKey(new SecretKeySpec(SkDkEntity.from(this.credential.getDataKeyBytes()).decryptSkDk(l.a(this.credential)), "AES")).withAlg(CipherAlg.AES_GCM).withIv(this.cipherText.getIv()).build().getDecryptHandler().from(this.cipherText.getCipherBytes()).to());
                oVar.setStatusCode(0);
            } catch (CryptoException e) {
                e = e;
                String str = "Fail to decrypt, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str);
                throw new UcsCryptoException(1003L, str);
            } catch (UcsParamException e2) {
                String str2 = "Fail to decrypt, errorMessage : " + e2.getMessage();
                oVar.setStatusCode(1001).setErrorMsg(str2);
                throw new UcsCryptoException(1001L, str2);
            } catch (UcsException e3) {
                e = e3;
                String str3 = "Fail to decrypt, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str3);
                throw new UcsCryptoException(1003L, str3);
            }
        } finally {
            this.credentialClient.reportLogs(oVar);
        }
    }

    private CredentialDecryptHandler from(String str, Decoder decoder) throws UcsCryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to decode cipher text: ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    private String to(Encoder encoder) throws UcsCryptoException {
        try {
            return encoder.encode(to());
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to encode plain text: ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler
    public CredentialDecryptHandler from(byte[] bArr) throws UcsCryptoException {
        if (bArr == null) {
            throw new UcsCryptoException(1001L, "cipherBytes cannot null..");
        }
        this.cipherText.setCipherBytes(bArr);
        return this;
    }

    public CredentialDecryptHandler fromBase64(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64);
    }

    public CredentialDecryptHandler fromBase64Url(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64URL);
    }

    public CredentialDecryptHandler fromHex(String str) throws UcsCryptoException {
        return from(str, Decoder.HEX);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler
    public byte[] to() throws UcsCryptoException {
        doDecrypt();
        return this.cipherText.getPlainBytes();
    }

    public String toBase64() throws UcsCryptoException {
        return to(Encoder.BASE64);
    }

    public String toHex() throws UcsCryptoException {
        return to(Encoder.HEX);
    }

    public String toRawString() throws UcsCryptoException {
        return to(Encoder.RAW);
    }
}
