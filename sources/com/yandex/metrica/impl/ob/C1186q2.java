package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.ConfigProvider;
import com.yandex.metrica.networktasks.api.FullUrlFormer;
import com.yandex.metrica.networktasks.api.NetworkResponseHandler;
import com.yandex.metrica.networktasks.api.RequestDataHolder;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import com.yandex.metrica.networktasks.api.UnderlyingNetworkTask;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.yandex.metrica.impl.ob.q2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1186q2 implements UnderlyingNetworkTask {
    private final C1225ri a;
    private Ui b;
    private EnumC0954gi c;
    private final RequestDataHolder d;
    private final ConfigProvider e;
    private final ResponseDataHolder f;
    private final FullUrlFormer g;
    private final NetworkResponseHandler h;

    public C1186q2(C1225ri c1225ri, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, ConfigProvider configProvider) {
        this(c1225ri, new C1162p2(), fullUrlFormer, requestDataHolder, responseDataHolder, configProvider);
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public String description() {
        return "Startup task for component: " + this.a.a().toString();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public FullUrlFormer getFullUrlFormer() {
        return this.g;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public RequestDataHolder getRequestDataHolder() {
        return this.d;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public ResponseDataHolder getResponseDataHolder() {
        return this.f;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public RetryPolicyConfig getRetryPolicyConfig() {
        return ((Mg) this.e.getConfig()).q();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public SSLSocketFactory getSslSocketFactory() {
        F0.g().t().getClass();
        return null;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onCreateTask() {
        this.d.setHeader("Accept-Encoding", "encrypted");
        return this.a.e();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPerformRequest() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPostRequestComplete(boolean z) {
        if (z) {
            return;
        }
        this.c = EnumC0954gi.PARSE;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onRequestComplete() {
        Ui ui = (Ui) this.h.handle(this.f);
        this.b = ui;
        return ui != null;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onRequestError(Throwable th) {
        this.c = EnumC0954gi.NETWORK;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onShouldNotExecute() {
        this.c = EnumC0954gi.NETWORK;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onSuccessfulTaskFinished() {
        if (this.b == null || this.f.getResponseHeaders() == null) {
            return;
        }
        this.a.a(this.b, (Mg) this.e.getConfig(), (Map<String, List<String>>) this.f.getResponseHeaders());
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
        if (this.c == null) {
            this.c = EnumC0954gi.UNKNOWN;
        }
        this.a.a(this.c);
    }

    C1186q2(C1225ri c1225ri, C1162p2 c1162p2, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, ConfigProvider configProvider) {
        this.a = c1225ri;
        this.h = c1162p2;
        this.d = requestDataHolder;
        this.f = responseDataHolder;
        this.e = configProvider;
        this.g = fullUrlFormer;
        fullUrlFormer.setHosts(((Mg) configProvider.getConfig()).I());
    }
}
