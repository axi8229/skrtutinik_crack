package com.huawei.hms.location;

import android.os.Parcel;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class NavigationResult extends LocationBaseResponse {
    public static final int MAG_POSITION_IS_SUPPORT = 21;
    public static final int MAG_POSITION_NOT_SUPPORT = 22;
    private Map<String, Object> extras;
    private int possibility;
    private int state;

    public NavigationResult() {
        this.state = -1;
        this.possibility = -1;
    }

    protected NavigationResult(Parcel parcel) {
        this.state = -1;
        this.possibility = -1;
        this.state = parcel.readInt();
        this.possibility = parcel.readInt();
        this.extras = new HashMap();
        SafeBundle safeBundle = new SafeBundle(parcel.readBundle(getClass().getClassLoader()));
        for (String str : safeBundle.keySet()) {
            Object obj = safeBundle.get(str);
            if (obj != null) {
                this.extras.put(str, obj);
            }
        }
    }

    private Map<String, Object> getExtras() {
        return this.extras;
    }

    private void setExtras(Map<String, Object> map) {
        this.extras = map;
    }

    public final int getPossibility() {
        return this.possibility;
    }

    public final int getState() {
        return this.state;
    }

    public void setPossibility(int i) throws ApiException {
        if (i > 100 || i < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.possibility = i;
    }

    public void setState(int i) {
        this.state = i;
    }
}
