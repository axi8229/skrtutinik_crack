package com.huawei.location.vdr.listener;

import android.location.Location;

/* loaded from: classes3.dex */
public interface IVdrLocationListener {
    String getUuid();

    void onVdrLocationChanged(Location location);
}
