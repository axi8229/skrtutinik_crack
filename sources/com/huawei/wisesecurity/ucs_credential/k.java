package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs_credential.d;

/* loaded from: classes3.dex */
public class k {
    public Context a;
    public NetworkCapability b;
    public String c;
    public p d;
    public x e;
    public CredentialClient f;
    public String g;

    public k(CredentialClient credentialClient, Context context, NetworkCapability networkCapability, p pVar, String str) {
        this.f = credentialClient;
        this.a = context;
        this.b = networkCapability;
        this.c = str;
        this.d = pVar;
        this.e = new x(context, pVar, networkCapability);
    }

    public final Credential a(int i, String str, String str2) throws UcsException {
        d.a aVar = new d.a();
        aVar.a = this.f;
        aVar.b = this.a;
        aVar.d = this.e;
        aVar.c = this.b;
        d dVar = new d(aVar);
        try {
            return dVar.a(i, this.d.b(), this.c, str, str2, dVar);
        } finally {
            this.g = dVar.a();
        }
    }
}
