package com.huawei.updatesdk.b.d;

/* loaded from: classes3.dex */
public class f {
    private static com.huawei.updatesdk.service.otaupdate.b a;

    private static class a implements com.huawei.updatesdk.a.b.c.c.a {
        private boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // com.huawei.updatesdk.a.b.c.c.a
        public void a(com.huawei.updatesdk.a.b.c.c.c cVar, com.huawei.updatesdk.a.b.c.c.d dVar) {
        }

        @Override // com.huawei.updatesdk.a.b.c.c.a
        public void b(com.huawei.updatesdk.a.b.c.c.c cVar, com.huawei.updatesdk.a.b.c.c.d dVar) {
            if (f.a == null) {
                return;
            }
            if (!(dVar instanceof com.huawei.updatesdk.service.appmgr.bean.b)) {
                f.a.a(dVar.d());
                return;
            }
            com.huawei.updatesdk.service.appmgr.bean.b bVar = (com.huawei.updatesdk.service.appmgr.bean.b) dVar;
            if (!bVar.f()) {
                f.a.b(dVar.d());
                return;
            }
            com.huawei.updatesdk.service.appmgr.bean.c cVarG = bVar.g();
            if (cVarG == null) {
                f.a.a(dVar.d());
                return;
            }
            if (!this.a) {
                com.huawei.updatesdk.b.e.e.a("default").a(cVarG.d());
            }
            f.a.a(cVarG);
        }
    }

    public static void a(com.huawei.updatesdk.service.otaupdate.b bVar) {
        a = bVar;
    }

    public static void a(boolean z) {
        com.huawei.updatesdk.b.g.b.a(new com.huawei.updatesdk.service.appmgr.bean.a(z ? com.huawei.updatesdk.service.otaupdate.f.e().c() : null), new a(z));
    }
}
