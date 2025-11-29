package com.huawei.hms.locationSdk;

import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.lite.common.util.ExecutorUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class j0 extends i0 {
    private static volatile j0 c;
    private static final byte[] d = new byte[0];
    private List<LocationCallback> b = new ArrayList(10);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(k0 k0Var) {
        x.b().a(k0Var.a(), LocationRequestHelper.getCpTid(k0Var.d()));
    }

    public static j0 b() {
        if (c == null) {
            synchronized (d) {
                try {
                    if (c == null) {
                        c = new j0();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c() {
        x.b().j();
    }

    public void a(k0 k0Var, int i) throws IllegalArgumentException {
        if (k0Var == null || CollectionsUtil.isEmpty(a())) {
            HMSLog.i("LocationRequestCacheManager", "updateCacheNumUpdates fail, cache or numUpdates is null");
            return;
        }
        for (int i2 = 0; i2 < a().size(); i2++) {
            k0 k0Var2 = a().get(i2) instanceof k0 ? (k0) a().get(i2) : null;
            if (k0Var2 != null && k0Var2.equals(k0Var)) {
                if (i > 0) {
                    k0Var2.d().setNumUpdates(i);
                }
                k0Var2.a(i);
            }
        }
    }

    public boolean a(LocationCallback locationCallback) {
        synchronized (d) {
            if (locationCallback != null) {
                try {
                    if (!CollectionsUtil.isEmpty(this.b)) {
                        for (LocationCallback locationCallback2 : this.b) {
                            if (locationCallback2.equals(locationCallback)) {
                                this.b.remove(locationCallback2);
                                HMSLocationLog.i("LocationRequestCacheManager", "", "remove callback from removingCallbackList, size is : " + this.b.size());
                                return true;
                            }
                        }
                        return false;
                    }
                } finally {
                }
            }
            return false;
        }
    }

    @Override // com.huawei.hms.locationSdk.i0
    public boolean c(h0 h0Var) {
        int priority;
        boolean zC = super.c(h0Var);
        if ((h0Var instanceof k0) && ((priority = ((k0) h0Var).d().getPriority()) == 200 || priority == 100 || priority == 400)) {
            ExecutorUtil.getInstance().execute(new Runnable() { // from class: com.huawei.hms.locationSdk.j0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    j0.c();
                }
            });
        }
        return zC;
    }

    @Override // com.huawei.hms.locationSdk.i0
    public void d(h0 h0Var) {
        super.d(h0Var);
        if (h0Var instanceof k0) {
            final k0 k0Var = (k0) h0Var;
            int priority = k0Var.d().getPriority();
            if (priority == 200 || priority == 100 || priority == 400) {
                ExecutorUtil.getInstance().execute(new Runnable() { // from class: com.huawei.hms.locationSdk.j0$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        j0.a(k0Var);
                    }
                });
            }
        }
    }
}
