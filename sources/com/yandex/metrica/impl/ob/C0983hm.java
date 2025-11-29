package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.UserManager;

/* renamed from: com.yandex.metrica.impl.ob.hm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0983hm {
    public boolean a(Context context) {
        Boolean boolValueOf;
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        Boolean bool = Boolean.TRUE;
        if (userManager != null) {
            try {
                boolValueOf = Boolean.valueOf(userManager.isUserUnlocked());
            } catch (Throwable unused) {
            }
        } else {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            bool = boolValueOf;
        }
        return bool.booleanValue();
    }
}
