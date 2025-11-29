package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.nio.charset.StandardCharsets;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e0 extends b {
    public x h;
    public boolean i;

    public e0(CredentialClient credentialClient, Context context, NetworkCapability networkCapability, x xVar) throws UcsException {
        super(credentialClient, context, networkCapability);
        this.i = true;
        this.h = xVar;
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public Credential a(String str, String str2, String str3, String str4, d dVar) throws UcsException {
        LogUcs.i("KidHandler", "applyCredential use KidHandler.", new Object[0]);
        return a(str, str2, str3, str4);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public String a(NetworkResponse networkResponse) throws UcsException {
        boolean zIsSuccessful = networkResponse.isSuccessful();
        String body = networkResponse.getBody();
        if (zIsSuccessful) {
            return body;
        }
        ErrorBody errorBodyFromString = ErrorBody.fromString(body);
        StringBuilder sbA = f.a("tsms service error, ");
        sbA.append(errorBodyFromString.getErrorMessage());
        String string = sbA.toString();
        throw h.a("KidHandler", string, new Object[0], RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, string);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public void a() throws UcsException {
        x xVar = this.h;
        g0 g0Var = new g0();
        if (g0Var.b(xVar.b)) {
            xVar.a(false, g0Var);
            return;
        }
        try {
            w.a(xVar.b, g0Var);
        } catch (UcsException e) {
            LogUcs.w("KeyComponentManger", "Init using local file failed, code = {0}, msg = {1}", Long.valueOf(e.getErrorCode()), e.getMessage());
            LogUcs.i("KeyComponentManger", "Try update data = componnet from server", new Object[0]);
            xVar.a(true, g0Var);
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public String b() throws UcsException {
        int i = SpUtil.getInt("Local-C1-Version", -1, this.b);
        LogUcs.d("KidHandler", "c1 version is " + i + ", so version is " + ((int) UcsLib.ucsGetSoVersion()), new Object[0]);
        return new String(UcsLib.genReqJws(this.b, this.d, this.e, 0, i), StandardCharsets.UTF_8);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.b
    public Credential a(String str) throws NumberFormatException, UcsException {
        try {
            int i = Integer.parseInt(new JSONObject(str).getString("expire"));
            if (i == 0) {
                return this.g.genCredentialFromString(str);
            }
            if (i != 1) {
                if (i != 2) {
                    throw new UcsException(1017L, "unenable expire.");
                }
                throw new UcsException(1016L, "so version is unenable.");
            }
            if (!this.i) {
                throw new UcsException(1021L, "c1 vision is unenable.");
            }
            LogUcs.d("KidHandler", "c1 version expired, start to force update c1!", new Object[0]);
            this.h.a(true, new g0());
            this.i = false;
            return a(this.c, this.d, this.e, this.f);
        } catch (NumberFormatException e) {
            StringBuilder sbA = f.a("parse TSMS resp expire error : ");
            sbA.append(e.getMessage());
            throw new UcsException(2001L, sbA.toString());
        } catch (JSONException e2) {
            StringBuilder sbA2 = f.a("parse TSMS resp get json error : ");
            sbA2.append(e2.getMessage());
            throw new UcsException(1002L, sbA2.toString());
        }
    }
}
