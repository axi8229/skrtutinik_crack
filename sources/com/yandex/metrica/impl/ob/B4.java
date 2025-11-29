package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.networktasks.api.ConfigProvider;
import com.yandex.metrica.networktasks.api.DefaultResponseParser;
import com.yandex.metrica.networktasks.api.FullUrlFormer;
import com.yandex.metrica.networktasks.api.NetworkResponseHandler;
import com.yandex.metrica.networktasks.api.RequestDataHolder;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import com.yandex.metrica.networktasks.api.UnderlyingNetworkTask;
import java.io.UnsupportedEncodingException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class B4 implements UnderlyingNetworkTask {
    private final ConfigProvider a;
    private final C0836c0 b;
    private final E4 c;
    private final TimeProvider d = new SystemTimeProvider();
    private final Ql e = new Ql();
    private final String f = B4.class.getName() + "@" + Integer.toHexString(hashCode());
    private final C0819b8 g;
    private final FullUrlFormer h;
    private final RequestDataHolder i;
    private final ResponseDataHolder j;
    private final NetworkResponseHandler k;

    public B4(ConfigProvider configProvider, C0836c0 c0836c0, E4 e4, C0819b8 c0819b8, NetworkResponseHandler networkResponseHandler, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, FullUrlFormer fullUrlFormer) {
        this.a = configProvider;
        this.b = c0836c0;
        this.c = e4;
        this.g = c0819b8;
        this.i = requestDataHolder;
        this.j = responseDataHolder;
        this.k = networkResponseHandler;
        this.h = fullUrlFormer;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public String description() {
        return this.f;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public FullUrlFormer getFullUrlFormer() {
        return this.h;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public RequestDataHolder getRequestDataHolder() {
        return this.i;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public ResponseDataHolder getResponseDataHolder() {
        return this.j;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public RetryPolicyConfig getRetryPolicyConfig() {
        return null;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public SSLSocketFactory getSslSocketFactory() {
        F0.g().t().getClass();
        return null;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onCreateTask() throws UnsupportedEncodingException {
        byte[] bArrCompress;
        D4 d4 = (D4) this.a.getConfig();
        boolean zX = d4.x();
        boolean zB = A2.b(d4.C());
        if (!zX || zB) {
            return false;
        }
        this.h.setHosts(d4.C());
        byte[] bArrA = new C4(this.b, d4, this.c, new O3(this.g), new C0859cn(1024, "diagnostic event name"), new C0859cn(204800, "diagnostic event value"), new SystemTimeProvider()).a();
        try {
            bArrCompress = this.e.compress(bArrA);
        } catch (Throwable unused) {
            bArrCompress = null;
        }
        if (!A2.a(bArrCompress)) {
            this.i.setHeader("Content-Encoding", "gzip");
            bArrA = bArrCompress;
        }
        this.i.setPostData(bArrA);
        return true;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPerformRequest() {
        this.i.applySendTime(this.d.currentTimeMillis());
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPostRequestComplete(boolean z) {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onRequestComplete() {
        DefaultResponseParser.Response response = (DefaultResponseParser.Response) this.k.handle(this.j);
        return response != null && "accepted".equals(response.mStatus);
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onRequestError(Throwable th) {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onShouldNotExecute() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onSuccessfulTaskFinished() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onTaskAdded() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onTaskFinished() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onTaskRemoved() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onUnsuccessfulTaskFinished() {
    }
}
