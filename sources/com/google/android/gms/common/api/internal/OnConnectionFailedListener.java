package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface OnConnectionFailedListener {
    @ShowFirstParty
    @KeepForSdk
    void onConnectionFailed(ConnectionResult connectionResult);
}
