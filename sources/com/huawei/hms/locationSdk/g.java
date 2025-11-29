package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.api.location.common.LocationClientStateManager;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes3.dex */
public class g extends AbstractClientBuilder<s, w> {

    public static class a implements BaseHmsClient.ConnectionCallbacks {
        private BaseHmsClient.ConnectionCallbacks a;

        public a(BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
            this.a = connectionCallbacks;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i("LocationClientBuilder", "onConnected, send suspended requests,reStartState:" + LocationClientStateManager.getInstance().getResendState());
            BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.a;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnected();
            }
            if (LocationClientStateManager.getInstance().getResendState() == 2) {
                LocationClientStateManager.getInstance().reStartHmsLocation();
            }
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            HMSLog.i("LocationClientBuilder", "onConnectionSuspended reason:" + i);
            BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.a;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(i);
            }
            LocationClientStateManager.getInstance().checkCanResend();
        }
    }

    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public s buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new s(context, clientSettings, onConnectionFailedListener, new a(connectionCallbacks));
    }
}
