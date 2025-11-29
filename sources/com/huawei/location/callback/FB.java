package com.huawei.location.callback;

import android.app.PendingIntent;
import com.huawei.location.callback.LW;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.router.interfaces.IRouterCallback;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public abstract class FB<T extends LW> {
    private List<T> yn = new CopyOnWriteArrayList();

    public void Vw(T t) {
        if (t == null) {
            LogLocation.i(yn(), "setCallBackInfo, null == locationCallBackInfo ");
            return;
        }
        LogLocation.i(yn(), "setCallBackInfo callBackInfoList size is " + this.yn.size());
        if (this.yn.isEmpty()) {
            this.yn.add(t);
            return;
        }
        if (!this.yn.isEmpty()) {
            for (int i = 0; i < this.yn.size(); i++) {
                if (this.yn.get(i).equals(t)) {
                    LogLocation.i(yn(), "setCallBackInfo, update");
                    return;
                }
            }
        }
        this.yn.add(t);
        LogLocation.i(yn(), "setCallBackInfo end callBackInfoList size is " + this.yn.size());
    }

    public LW yn(PendingIntent pendingIntent) {
        if (this.yn.isEmpty()) {
            return null;
        }
        for (T t : this.yn) {
            if (t.yn() != null && t.yn().equals(pendingIntent)) {
                LogLocation.i(yn(), "getInfoFromPendingIntent equals is true");
                return t;
            }
        }
        return null;
    }

    public LW yn(IRouterCallback iRouterCallback) {
        if (this.yn.isEmpty()) {
            return null;
        }
        for (T t : this.yn) {
            if (t.Vw() != null && t.Vw().equals(iRouterCallback)) {
                LogLocation.i(yn(), "getInfoFromRouterCallback equals is true");
                return t;
            }
        }
        return null;
    }

    public abstract String yn();

    public void yn(T t) {
        LogLocation.i(yn(), "removeCallback callBackInfoList size is " + this.yn.size());
        if (this.yn.isEmpty()) {
            return;
        }
        Iterator<T> it = this.yn.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next instanceof LW) {
                T t2 = next;
                if (t2.equals(t)) {
                    LogLocation.i(yn(), "removeCallback true");
                    this.yn.remove(t2);
                    break;
                }
            }
        }
        LogLocation.i(yn(), "removeCallback end callBackInfoList size is " + this.yn.size());
    }
}
