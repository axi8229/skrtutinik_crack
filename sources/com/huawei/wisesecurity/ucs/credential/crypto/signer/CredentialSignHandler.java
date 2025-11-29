package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.SignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
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

/* loaded from: classes3.dex */
public class CredentialSignHandler implements SignHandler {
    private Credential credential;
    private CredentialClient credentialClient;
    private CredentialSignText signText;

    public CredentialSignHandler(Credential credential, CredentialSignText credentialSignText, CredentialClient credentialClient) {
        this.credential = credential;
        this.signText = credentialSignText;
        this.credentialClient = credentialClient;
    }

    private void doSign() throws UcsCryptoException {
        o oVar = (o) new o().a().setApiName("appAuth.sign").setCallTime();
        try {
            try {
                this.signText.checkParam(true);
                this.signText.setSignature(new HmacSigner.Builder().withKey(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(l.a(this.credential))).withAlg(SignAlg.HMAC_SHA256).build().getSignHandler().from(this.signText.getDataBytes()).sign());
                oVar.setStatusCode(0);
            } catch (CryptoException e) {
                e = e;
                String str = "Fail to sign, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str);
                throw new UcsCryptoException(1003L, str);
            } catch (UcsParamException e2) {
                String str2 = "Fail to sign, errorMessage : " + e2.getMessage();
                oVar.setStatusCode(1001).setErrorMsg(str2);
                throw new UcsCryptoException(1001L, str2);
            } catch (UcsException e3) {
                e = e3;
                String str3 = "Fail to sign, errorMessage : " + e.getMessage();
                oVar.setStatusCode(1003).setErrorMsg(str3);
                throw new UcsCryptoException(1003L, str3);
            }
        } finally {
            this.credentialClient.reportLogs(oVar);
        }
    }

    private CredentialSignHandler from(String str, Decoder decoder) throws UcsCryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to decode plain text : ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    private String sign(Encoder encoder) throws UcsCryptoException {
        try {
            doSign();
            return encoder.encode(this.signText.getSignature());
        } catch (CodecException e) {
            StringBuilder sbA = f.a("Fail to encode signature bytes: ");
            sbA.append(e.getMessage());
            throw new UcsCryptoException(1003L, sbA.toString());
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.SignHandler
    public CredentialSignHandler from(String str) throws UcsCryptoException {
        if (TextUtils.isEmpty(str)) {
            throw new UcsCryptoException(1001L, "dataString cannot empty..");
        }
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.SignHandler
    public CredentialSignHandler from(byte[] bArr) {
        this.signText.setDataBytes(ByteUtil.clone(bArr));
        return this;
    }

    public CredentialSignHandler fromBase64(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64);
    }

    public CredentialSignHandler fromBase64Url(String str) throws UcsCryptoException {
        return from(str, Decoder.BASE64URL);
    }

    public CredentialSignHandler fromHex(String str) throws UcsCryptoException {
        return from(str, Decoder.HEX);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.SignHandler
    public byte[] sign() throws UcsCryptoException {
        doSign();
        return this.signText.getSignature();
    }

    public String signBase64() throws UcsCryptoException {
        return sign(Encoder.BASE64);
    }

    public String signBase64Url() throws UcsCryptoException {
        return sign(Encoder.BASE64URL);
    }

    public String signHex() throws UcsCryptoException {
        return sign(Encoder.HEX);
    }
}
