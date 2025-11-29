package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class d {
    public final Map<Integer, b> a = new HashMap();
    public CredentialClient b;
    public Context c;
    public NetworkCapability d;
    public x e;
    public int f;

    public static final class a {
        public CredentialClient a;
        public Context b;
        public NetworkCapability c;
        public x d;
    }

    public d(a aVar) throws UcsException {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        b();
    }

    public Credential a(int i, String str, String str2, String str3, String str4, d dVar) throws UcsException {
        this.f = i;
        b bVar = this.a.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar.a(str, str2, str3, str4, dVar);
        }
        throw new UcsException(2001L, "applyCredential get inner error, apply flag not found.");
    }

    public String a() {
        int i = this.f;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : "Huks_EC" : "AndroidKS_EC" : "AndroidKS" : "Kid";
    }

    public final void b() throws UcsException {
        this.a.put(0, new e0(this.b, this.c, this.d, this.e));
        this.a.put(1, new a0(this.b, this.c, this.d));
        this.a.put(2, new z(this.b, this.c, this.d));
        this.a.put(3, new q(this.b, this.c, this.d));
    }
}
