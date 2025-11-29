package com.huawei.hms.locationSdk;

import com.huawei.hms.locationSdk.h0;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class i0<T extends h0> {
    private List<T> a = new ArrayList(10);

    public List<T> a() {
        return this.a;
    }

    public void a(T t) {
        if (t == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        HMSLocationLog.i("TidCacheManager", t.a(), "list to add size is:" + this.a.size());
        if (b(t) != null) {
            HMSLocationLog.i("TidCacheManager", t.a(), "this request is included");
        } else {
            HMSLocationLog.i("TidCacheManager", t.a(), "add request");
            this.a.add(t);
        }
    }

    public T b(T t) {
        if (t != null && !CollectionsUtil.isEmpty(this.a)) {
            HMSLocationLog.i("TidCacheManager", t.a(), "list to find size is:" + this.a.size());
            for (int i = 0; i < this.a.size(); i++) {
                T t2 = this.a.get(i);
                if (t2 != null && t2.equals(t)) {
                    HMSLocationLog.i("TidCacheManager", t.a(), "find tid in list, tid:" + t2.a());
                    return t2;
                }
            }
        }
        return null;
    }

    public boolean c(T t) {
        if (t != null && !CollectionsUtil.isEmpty(this.a)) {
            for (T t2 : this.a) {
                if (t2.equals(t)) {
                    HMSLocationLog.i("TidCacheManager", t.a(), "remove request from list");
                    this.a.remove(t2);
                    return true;
                }
            }
        }
        return false;
    }

    public void d(T t) {
        if (t == null) {
            return;
        }
        if (this.a.isEmpty()) {
            HMSLocationLog.i("TidCacheManager", t.a(), "replaceRequestCache add Request");
            this.a.add(t);
            return;
        }
        HMSLocationLog.i("TidCacheManager", t.a(), "list to replace size is:" + this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            T t2 = this.a.get(i);
            if (t2 != null && t2.equals(t)) {
                HMSLocationLog.i("TidCacheManager", t.a(), "replace old tid is " + t2.a() + ". new tid is " + t.a());
                this.a.set(i, t);
                return;
            }
        }
        this.a.add(t);
        HMSLocationLog.i("TidCacheManager", t.a(), "replaceRequestCache add Request.");
    }
}
