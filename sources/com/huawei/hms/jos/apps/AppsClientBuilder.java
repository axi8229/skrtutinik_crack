package com.huawei.hms.jos.apps;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.jos.JosClientBuilder;

/* loaded from: classes3.dex */
public class AppsClientBuilder extends JosClientBuilder {
    @Override // com.huawei.hms.jos.JosClientBuilder, com.huawei.hms.common.internal.AbstractClientBuilder
    public AppHmsClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new AppHmsClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
