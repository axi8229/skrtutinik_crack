package bz;

import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.io.Serializable;

/* renamed from: bz.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0568y extends R0 {
    public final /* synthetic */ C0571z a;

    public C0568y(C0571z c0571z) {
        this.a = c0571z;
    }

    public final /* synthetic */ void a(zone.bi.mobile.fingerprint.api.c cVar, Task task) {
        if (task.isSuccessful() && task.getResult() != null) {
            this.a.a(Integer.valueOf(((SafetyNetApi.VerifyAppsUserResponse) task.getResult()).isVerifyAppsEnabled() ? 1 : 0));
        }
        if (cVar != null) {
            this.a.getClass();
            cVar.a();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        final zone.bi.mobile.fingerprint.api.c cVar = null;
        this.a.a((Serializable) null);
        Task taskIsVerifyAppsEnabled = SafetyNet.getClient(this.a.c).isVerifyAppsEnabled();
        taskIsVerifyAppsEnabled.addOnFailureListener(new OnFailureListener(cVar) { // from class: bz.y$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.a((zone.bi.mobile.fingerprint.api.c) null, exc);
            }
        });
        taskIsVerifyAppsEnabled.addOnCompleteListener(S0.o, new OnCompleteListener(cVar) { // from class: bz.y$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.a((zone.bi.mobile.fingerprint.api.c) null, task);
            }
        });
    }

    public final void a(zone.bi.mobile.fingerprint.api.c cVar, Exception exc) {
        if (cVar != null) {
            zone.bi.mobile.fingerprint.api.f fVar = this.a.a;
            cVar.a();
        }
    }
}
