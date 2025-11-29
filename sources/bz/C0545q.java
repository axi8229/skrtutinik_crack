package bz;

import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: bz.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0545q extends R0 {
    public final /* synthetic */ r a;

    public C0545q(r rVar) {
        this.a = rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void a(zone.bi.mobile.fingerprint.api.f r3, com.google.android.gms.appset.AppSetIdInfo r4) {
        /*
            r2 = this;
            bz.r r0 = r2.a
            int r1 = r4.getScope()
            r0.f = r1
            bz.r r0 = r2.a
            java.lang.String r4 = r4.getId()
            r0.e = r4
            zone.bi.mobile.fingerprint.api.f r4 = zone.bi.mobile.fingerprint.api.f.AppSetIdScopeApp
            if (r3 != r4) goto L1e
            bz.r r4 = r2.a
            int r0 = r4.f
            r1 = 1
            if (r0 != r1) goto L1e
            java.lang.String r3 = r4.e
            goto L2b
        L1e:
            zone.bi.mobile.fingerprint.api.f r4 = zone.bi.mobile.fingerprint.api.f.AppSetIdScopeDeveloper
            if (r3 != r4) goto L2e
            bz.r r4 = r2.a
            int r3 = r4.f
            r0 = 2
            if (r3 != r0) goto L2e
            java.lang.String r3 = r4.e
        L2b:
            r4.a(r3)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.C0545q.a(zone.bi.mobile.fingerprint.api.f, com.google.android.gms.appset.AppSetIdInfo):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.a;
        final zone.bi.mobile.fingerprint.api.f fVar = rVar.a;
        if (rVar.a(A0.n) != null) {
            return;
        }
        AppSet.getClient(this.a.c).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener() { // from class: bz.q$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.a(fVar, (AppSetIdInfo) obj);
            }
        });
    }
}
