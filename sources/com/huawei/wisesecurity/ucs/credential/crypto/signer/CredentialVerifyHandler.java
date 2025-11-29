package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
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
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class CredentialVerifyHandler implements VerifyHandler {
    private Credential credential;
    private CredentialClient credentialClient;
    private CredentialSignText signText;

    public CredentialVerifyHandler(Credential credential, CredentialSignText credentialSignText, CredentialClient credentialClient) {
        this.credential = credential;
        this.signText = credentialSignText;
        this.credentialClient = credentialClient;
    }

    private boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean doVerify() throws UcsCryptoException {
        o oVar = (o) new o().a().setApiName("appAuth.verify").setCallTime();
        try {
            try {
                this.signText.checkParam(false);
                boolean zCheckSignature = checkSignature(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(l.a(this.credential))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(this.signText.getDataBytes()).sign(), this.signText.getSignature());
                oVar.setStatusCode(0);
                return zCheckSignature;
            } catch (CryptoException e) {
                e = e;
                String str = "Fail to verify, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str);
                throw new UcsCryptoException(1003L, str);
            } catch (UcsParamException e2) {
                String str2 = "Fail to verify, errorMessage : " + e2.getMessage();
                oVar.setStatusCode(1001).setErrorMsg(str2);
                throw new UcsCryptoException(1001L, str2);
            } catch (UcsException e3) {
                e = e3;
                String str3 = "Fail to verify, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str3);
                throw new UcsCryptoException(1003L, str3);
            }
        } finally {
            this.credentialClient.reportLogs(oVar);
        }
    }

    private CredentialVerifyHandler fromData(String str, Decoder decoder) throws UcsCryptoException {
        try {
            fromData(decoder.decode(str));
            return this;
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to decode sign data: ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    private boolean verify(String str, Decoder decoder) throws UcsCryptoException {
        try {
            return verify(decoder.decode(str));
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to decode signature : ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    public CredentialVerifyHandler fromBase64Data(String str) throws UcsCryptoException {
        return fromData(str, Decoder.BASE64);
    }

    public CredentialVerifyHandler fromBase64UrlData(String str) throws UcsCryptoException {
        return fromData(str, Decoder.BASE64URL);
    }

    public CredentialVerifyHandler fromData(String str) throws UcsCryptoException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsCryptoException(1001L, "dataString cannot empty..");
        }
        return fromData(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler
    public CredentialVerifyHandler fromData(byte[] bArr) {
        this.signText.setDataBytes(bArr);
        return this;
    }

    public CredentialVerifyHandler fromHexData(String str) throws UcsCryptoException {
        return fromData(str, Decoder.HEX);
    }

    public boolean verify(String str) throws UcsCryptoException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsCryptoException(1001L, "signature cannot empty..");
        }
        return verify(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler
    public boolean verify(byte[] bArr) throws UcsCryptoException {
        this.signText.setSignature(bArr);
        return doVerify();
    }

    public boolean verifyBase64(String str) throws UcsCryptoException {
        return verify(str, Decoder.BASE64);
    }

    public boolean verifyBase64Url(String str) throws UcsCryptoException {
        return verify(str, Decoder.BASE64URL);
    }

    public boolean verifyHex(String str) throws UcsCryptoException {
        return verify(str, Decoder.HEX);
    }
}
