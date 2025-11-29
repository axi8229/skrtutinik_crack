package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class b {
    public NetworkCapability a;
    public Context b;
    public String c;
    public String d;
    public String e;
    public String f;
    public CredentialClient g;

    public b(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) {
        this.g = credentialClient;
        this.b = context;
        this.a = networkCapability;
    }

    public static boolean b(String str) {
        return "tsms.1018".equalsIgnoreCase(str) || "tsms.1019".equalsIgnoreCase(str);
    }

    public abstract Credential a(String str) throws UcsException;

    public Credential a(String str, String str2, String str3, String str4) throws UcsException {
        try {
            a();
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            NetworkResponse networkResponsePost = this.a.post(new NetworkRequest(str, m.a(str2, str3, str4), m.a(b())));
            int code = networkResponsePost.getCode();
            if ((code < 200 || code >= 300) && code != 400 && code != 403 && code != 500) {
                throw new UcsException(1013L, "tsms req error, return " + networkResponsePost.getCode());
            }
            return a(a(networkResponsePost));
        } catch (IOException e) {
            StringBuilder sbA = f.a("get credential from TSMS fail : ");
            sbA.append(e.getMessage());
            String string = sbA.toString();
            throw h.a("ApplyCredentialHandler", string, new Object[0], 1006L, string);
        }
    }

    public abstract Credential a(String str, String str2, String str3, String str4, d dVar) throws UcsException;

    public abstract String a(NetworkResponse networkResponse) throws UcsException;

    public abstract void a() throws UcsException;

    public abstract String b() throws UcsException;
}
