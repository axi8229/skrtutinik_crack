package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.networktasks.api.ConfigProvider;
import com.yandex.metrica.networktasks.api.DefaultNetworkResponseHandler;
import com.yandex.metrica.networktasks.api.FullUrlFormer;
import com.yandex.metrica.networktasks.api.RequestBodyEncrypter;
import com.yandex.metrica.networktasks.api.RequestDataHolder;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import com.yandex.metrica.networktasks.api.SendingDataTaskHelper;
import com.yandex.metrica.networktasks.api.UnderlyingNetworkTask;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.yandex.metrica.impl.ob.cd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0849cd implements UnderlyingNetworkTask {
    private final C1233s2 a;
    private final C1097mc b;
    private final C0794a8 c;
    private final C0899ed d;
    private final Fc e;
    private final Pg f;
    private final FullUrlFormer g;
    private final ConfigProvider h;
    private final RequestDataHolder i;
    private final ResponseDataHolder j;
    private final SendingDataTaskHelper k;
    private long l;
    private C0874dd m;

    public C0849cd(Context context, C1233s2 c1233s2, Fc fc, Pg pg, ConfigProvider configProvider, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, FullUrlFormer fullUrlFormer, RequestBodyEncrypter requestBodyEncrypter) {
        this(c1233s2, fc, F0.g().w().a(), pg, new C0899ed(context), fullUrlFormer, requestDataHolder, responseDataHolder, configProvider, new SendingDataTaskHelper(requestBodyEncrypter, new Ql(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler()));
    }

    private boolean a() {
        C0874dd c0874ddA = this.d.a(this.b.d);
        this.m = c0874ddA;
        C1175pf c1175pf = c0874ddA.c;
        if (c1175pf.b.length == 0 && c1175pf.a.length == 0) {
            return false;
        }
        return this.k.prepareAndSetPostData(MessageNano.toByteArray(c1175pf));
    }

    private void b() {
        long jF = this.c.f() + 1;
        this.l = jF;
        this.f.a(jF);
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public String description() {
        return "LocationTask";
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public FullUrlFormer getFullUrlFormer() {
        return this.g;
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
        return ((C0949gd) this.h.getConfig()).q();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public SSLSocketFactory getSslSocketFactory() {
        F0.g().t().getClass();
        return null;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onCreateTask() {
        C0949gd c0949gd = (C0949gd) this.h.getConfig();
        if (this.a.d() || TextUtils.isEmpty(c0949gd.g()) || TextUtils.isEmpty(c0949gd.w()) || A2.b(this.g.getAllHosts())) {
            return false;
        }
        return a();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPerformRequest() {
        this.k.onPerformRequest();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPostRequestComplete(boolean z) {
        if (z || A2.b(this.j.getResponseCode())) {
            this.d.a(this.m);
        }
        this.c.c(this.l);
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onRequestComplete() {
        return this.k.isResponseValid();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onRequestError(Throwable th) {
        this.c.c(this.l);
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onShouldNotExecute() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onSuccessfulTaskFinished() {
        this.e.a();
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

    C0849cd(C1233s2 c1233s2, Fc fc, C0794a8 c0794a8, Pg pg, C0899ed c0899ed, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, ConfigProvider configProvider, SendingDataTaskHelper sendingDataTaskHelper) {
        this.k = sendingDataTaskHelper;
        this.a = c1233s2;
        this.e = fc;
        this.h = configProvider;
        C0949gd c0949gd = (C0949gd) configProvider.getConfig();
        this.b = c0949gd.z();
        this.c = c0794a8;
        this.d = c0899ed;
        this.f = pg;
        this.i = requestDataHolder;
        this.j = responseDataHolder;
        this.g = fullUrlFormer;
        b();
        fullUrlFormer.setHosts(c0949gd.A());
    }
}
