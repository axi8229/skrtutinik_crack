package com.huawei.agconnect;

import android.content.Context;

/* loaded from: classes3.dex */
public interface AGConnectOptions {
    Context getContext();

    String getIdentifier();

    AGCRoutePolicy getRoutePolicy();

    String getString(String str);
}
