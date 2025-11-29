package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class StatusCallback extends IStatusCallback.Stub {

    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> resultHolder;

    @KeepForSdk
    public StatusCallback(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.resultHolder = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void onResult(Status status) {
        this.resultHolder.setResult(status);
    }
}
