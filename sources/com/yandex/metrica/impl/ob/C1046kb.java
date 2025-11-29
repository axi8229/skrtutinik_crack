package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1021jb;
import com.yandex.metrica.network.NetworkClient;
import com.yandex.metrica.network.Request;
import com.yandex.metrica.network.Response;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.kb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1046kb {
    private final C1021jb a;
    private final Uh b;

    public C1046kb(C1021jb c1021jb, Uh uh) {
        this.a = c1021jb;
        this.b = uh;
    }

    public final void a() {
        Request requestBuild = new Request.Builder(this.b.c()).build();
        NetworkClient.Builder builder = new NetworkClient.Builder();
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        f0G.t().getClass();
        String string = null;
        NetworkClient.Builder builderWithSslSocketFactory = builder.withSslSocketFactory(null);
        int i = C1098md.a;
        NetworkClient networkClientBuild = builderWithSslSocketFactory.withConnectTimeout(i).withReadTimeout(i).withUseCaches(false).withInstanceFollowRedirects(true).build();
        Intrinsics.checkNotNullExpressionValue(networkClientBuild, "NetworkClient.Builder()\n…rue)\n            .build()");
        Response responseExecute = networkClientBuild.newCall(requestBuild).execute();
        Intrinsics.checkNotNullExpressionValue(responseExecute, "client.newCall(request).execute()");
        C1021jb c1021jb = this.a;
        boolean z = responseExecute.getCode() == 200;
        int length = responseExecute.getResponseData().length;
        int code = responseExecute.getCode();
        Throwable it = responseExecute.getException();
        if (it != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(it.getClass().getSimpleName());
            sb.append(" : ");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            sb.append(it.getLocalizedMessage());
            string = sb.toString();
        }
        c1021jb.a(new C1021jb.a(z, code, length, string));
    }
}
