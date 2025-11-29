package com.huawei.hms.locationSdk;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.locationSdk.g;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.interfaces.IRouterCallback;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class s1<TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> implements IRouterCallback {
    private TaskApiCall<TClient, TResult> a;
    private TaskCompletionSource<TResult> b;
    private AbstractClientBuilder<TClient, TOption> c;
    private String d;

    class a implements BaseHmsClient.OnConnectionFailedListener {
        a(s1 s1Var) {
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
        }
    }

    class b implements BaseHmsClient.ConnectionCallbacks {
        b(s1 s1Var) {
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
        }
    }

    s1(TaskApiCall<TClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource, AbstractClientBuilder<TClient, TOption> abstractClientBuilder) {
        this.a = taskApiCall;
        this.b = taskCompletionSource;
        this.c = abstractClientBuilder;
    }

    private ClientSettings a() {
        Context context = ContextUtil.getContext();
        ClientSettings clientSettings = new ClientSettings(context.getPackageName(), context.getClass().getName(), new ArrayList(), Util.getAppId(ContextUtil.getContext()), null);
        clientSettings.setCpID(Util.getCpId(context));
        if (TextUtils.isEmpty(this.d)) {
            this.d = HMSPackageManager.getInstance(context).getHMSPackageName();
            HMSLog.i("LiteApiListener", "inner hms is empty,hms pkg name is " + this.d);
        }
        clientSettings.setInnerHmsPkg(this.d);
        return clientSettings;
    }

    private void a(RouterResponse routerResponse) {
        if (routerResponse == null || this.a == null) {
            return;
        }
        this.a.onResponse(b(), new w1(routerResponse.getStatusInfo(), routerResponse.getTransactionId()), routerResponse.getBody(), this.b);
        HMSLog.d("LiteApiListener", "doTaskExecute onResponse success");
    }

    private TClient b() {
        return (TClient) this.c.buildClient(ContextUtil.getContext(), a(), new a(this), new g.a(new b(this)));
    }

    @Override // com.huawei.location.router.interfaces.IRouterCallback
    public void doExecute(RouterResponse routerResponse) {
        a(routerResponse);
    }

    @Override // com.huawei.location.router.interfaces.IRouterCallback
    public void onComplete(RouterResponse routerResponse) {
        a(routerResponse);
    }
}
