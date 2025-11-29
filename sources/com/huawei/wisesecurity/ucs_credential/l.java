package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class l {
    public static byte[] a(Credential credential) throws UcsException {
        String kekString = credential.getKekString();
        Map<String, byte[]> map = u.a;
        if (TextUtils.isEmpty(kekString)) {
            throw h.a("KekStore", "getKek param is null.", new Object[0], 1001L, "getKek param is null.");
        }
        if (((ConcurrentHashMap) u.a).containsKey(kekString)) {
            return (byte[]) ((ConcurrentHashMap) u.a).get(kekString);
        }
        throw new UcsException(2001L, "kek is empty");
    }

    public static l b(Credential credential) throws UcsException {
        int kekVersion = credential.getKekVersion();
        return kekVersion == 3 ? new b0() : (kekVersion == 6 || kekVersion == 7) ? new y() : new f0();
    }

    public abstract byte[] a(Credential credential, Context context) throws UcsException;

    public void b(Credential credential, Context context) throws UcsException {
        String kekString = credential.getKekString();
        if (((ConcurrentHashMap) u.a).containsKey(kekString)) {
            return;
        }
        byte[] bArrA = a(credential, context);
        if (TextUtils.isEmpty(kekString) || bArrA == null) {
            throw h.a("KekStore", "putKek param is null.", new Object[0], 1001L, "putKek param is null.");
        }
        ((ConcurrentHashMap) u.a).put(kekString, bArrA);
    }
}
