package com.huawei.hms.support.api.entity.location.binder;

import android.os.Binder;
import android.os.Bundle;

/* loaded from: classes3.dex */
public class InnerBinder extends Binder {
    private static InnerBinder innerBinder;

    public static synchronized Bundle getInnerBinder() {
        Bundle bundle;
        try {
            if (innerBinder == null) {
                innerBinder = new InnerBinder();
            }
            bundle = new Bundle();
            bundle.putBinder("InnerBinder", innerBinder);
        } catch (Throwable th) {
            throw th;
        }
        return bundle;
    }
}
