package com.huawei.hms.jos;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* loaded from: classes3.dex */
public class JosClientBuilder extends AbstractClientBuilder<JosHmsClient, JosOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public JosHmsClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new JosHmsClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
