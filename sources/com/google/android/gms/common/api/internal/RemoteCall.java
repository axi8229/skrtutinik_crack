package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(T t, U u) throws RemoteException;
}
