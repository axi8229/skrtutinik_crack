package com.yandex.metrica.appsetid;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b implements d {
    private final Object a = new Object();
    private final List<OnCompleteListener<AppSetIdInfo>> b = new ArrayList();

    public static final class a implements OnCompleteListener<AppSetIdInfo> {
        final /* synthetic */ com.yandex.metrica.appsetid.a b;

        a(com.yandex.metrica.appsetid.a aVar) {
            this.b = aVar;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<AppSetIdInfo> task) {
            synchronized (b.this.a) {
                b.this.b.remove(this);
            }
            if (!task.isSuccessful()) {
                this.b.a(task.getException());
                return;
            }
            com.yandex.metrica.appsetid.a aVar = this.b;
            AppSetIdInfo result = task.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "completedTask.result");
            String id = result.getId();
            b bVar = b.this;
            AppSetIdInfo result2 = task.getResult();
            Intrinsics.checkNotNullExpressionValue(result2, "completedTask.result");
            int scope = result2.getScope();
            bVar.getClass();
            aVar.a(id, scope != 1 ? scope != 2 ? c.UNKNOWN : c.DEVELOPER : c.APP);
        }
    }

    @Override // com.yandex.metrica.appsetid.d
    public void a(Context context, com.yandex.metrica.appsetid.a aVar) throws Throwable {
        AppSetIdClient client = AppSet.getClient(context);
        Intrinsics.checkNotNullExpressionValue(client, "AppSet.getClient(context)");
        Task<AppSetIdInfo> appSetIdInfo = client.getAppSetIdInfo();
        Intrinsics.checkNotNullExpressionValue(appSetIdInfo, "client.appSetIdInfo");
        a aVar2 = new a(aVar);
        synchronized (this.a) {
            this.b.add(aVar2);
        }
        appSetIdInfo.addOnCompleteListener(aVar2);
    }
}
