package com.huawei.hms.locationSdk;

import android.os.Looper;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;

/* loaded from: classes3.dex */
public class h1 extends j1 {
    public h1(String str, String str2, String str3, k0 k0Var, Looper looper, String str4) throws ApiException {
        super(str, str2, str3, k0Var, looper, str4);
    }

    @Override // com.huawei.hms.locationSdk.j1
    protected String a() {
        return "RequestLocationExUpdatesTaskApiCall";
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        LocationRequest locationRequestD = ((j1) this).b.d();
        if (locationRequestD == null) {
            HMSLocationLog.e(a(), ((n0) this).a, "locationRequest is null");
            return super.getApiLevel();
        }
        int priority = locationRequestD.getPriority();
        if (priority == 300) {
            return 5;
        }
        if (priority == 400) {
            return 8;
        }
        if (priority == 301) {
            return 9;
        }
        return super.getApiLevel();
    }

    @Override // com.huawei.hms.locationSdk.j1, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003318;
    }
}
