package com.huawei.location.vdr.listener;

import android.location.Location;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LW {
    private static final byte[] Vw = new byte[0];
    private static volatile LW yn;
    private List<IVdrLocationListener> FB = new ArrayList(10);

    public static LW yn() {
        if (yn == null) {
            synchronized (Vw) {
                try {
                    if (yn == null) {
                        yn = new LW();
                    }
                } finally {
                }
            }
        }
        return yn;
    }

    private void yn(IVdrLocationListener iVdrLocationListener) {
        synchronized (Vw) {
            try {
                if (Vw()) {
                    this.FB.add(iVdrLocationListener);
                    LogLocation.i("VdrLocationListenerManager", "vdrLocationListenerList is empty, add uuid here, uuid is: " + iVdrLocationListener.getUuid());
                    return;
                }
                for (int i = 0; i < this.FB.size(); i++) {
                    if (this.FB.get(i).getUuid().equals(iVdrLocationListener.getUuid())) {
                        this.FB.set(i, iVdrLocationListener);
                        LogLocation.i("VdrLocationListenerManager", "replace uuid here, uuid is: " + iVdrLocationListener.getUuid());
                        return;
                    }
                }
                this.FB.add(iVdrLocationListener);
                LogLocation.i("VdrLocationListenerManager", "new add uuid here, uuid is: " + iVdrLocationListener.getUuid());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Vw(IVdrLocationListener iVdrLocationListener) {
        synchronized (Vw) {
            try {
                if (iVdrLocationListener == null) {
                    return;
                }
                if (this.FB == null) {
                    this.FB = new ArrayList();
                }
                yn(iVdrLocationListener);
                LogLocation.i("VdrLocationListenerManager", "add vdrLocationListener to vdrLocationListenerList, size is : " + this.FB.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean Vw() {
        boolean z;
        synchronized (Vw) {
            try {
                List<IVdrLocationListener> list = this.FB;
                z = list == null || list.size() == 0;
            } finally {
            }
        }
        return z;
    }

    public void yn(Location location) {
        synchronized (Vw) {
            try {
                List<IVdrLocationListener> list = this.FB;
                if (list != null && list.size() != 0) {
                    for (int i = 0; i < this.FB.size(); i++) {
                        this.FB.get(i).onVdrLocationChanged(location);
                    }
                }
            } finally {
            }
        }
    }

    public boolean yn(String str) {
        synchronized (Vw) {
            if (str != null) {
                try {
                    List<IVdrLocationListener> list = this.FB;
                    if (list != null && list.size() != 0) {
                        for (IVdrLocationListener iVdrLocationListener : this.FB) {
                            if (iVdrLocationListener.getUuid().equals(str)) {
                                this.FB.remove(iVdrLocationListener);
                                LogLocation.i("VdrLocationListenerManager", "remove vdrLocationListener from vdrLocationListenerList, size is : " + this.FB.size() + ", uuid is: " + str);
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
}
