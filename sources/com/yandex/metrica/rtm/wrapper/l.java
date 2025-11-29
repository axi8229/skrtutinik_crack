package com.yandex.metrica.rtm.wrapper;

import android.content.Context;
import android.os.Bundle;
import com.yandex.metrica.rtm.service.EventToReporterProxy;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class l implements f {
    private final EventToReporterProxy a;

    public l(i iVar, Context context, Executor executor, j jVar) {
        this(new EventToReporterProxy(new a(iVar), context, executor, new c(jVar)));
    }

    @Override // com.yandex.metrica.rtm.wrapper.f
    public void reportData(Bundle bundle) {
        try {
            this.a.reportData(bundle);
        } catch (Throwable unused) {
        }
    }

    l(EventToReporterProxy eventToReporterProxy) {
        this.a = eventToReporterProxy;
    }
}
