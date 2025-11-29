package com.huawei.updatesdk.b.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class c {
    private static c a = new c();
    private static com.huawei.updatesdk.b.f.a b = new a();

    static class a implements com.huawei.updatesdk.b.f.a {
        private final List<b> a = new ArrayList();

        a() {
        }

        @Override // com.huawei.updatesdk.b.f.a
        public void a(int i, com.huawei.updatesdk.a.b.b.b bVar) {
            synchronized (this.a) {
                try {
                    Iterator<b> it = this.a.iterator();
                    while (it.hasNext()) {
                        it.next().a(i, bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.huawei.updatesdk.b.f.a
        public void a(b bVar) {
            String str;
            String str2;
            synchronized (this.a) {
                try {
                    if (bVar == null) {
                        return;
                    }
                    if (!this.a.contains(bVar)) {
                        try {
                            this.a.add(bVar);
                        } catch (ClassCastException unused) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver ClassCastException";
                            com.huawei.updatesdk.a.a.c.a.a.a.b(str, str2);
                        } catch (IllegalArgumentException unused2) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver IllegalArgumentException";
                            com.huawei.updatesdk.a.a.c.a.a.a.b(str, str2);
                        } catch (UnsupportedOperationException unused3) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver UnsupportedOperationException";
                            com.huawei.updatesdk.a.a.c.a.a.a.b(str, str2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.huawei.updatesdk.b.f.a
        public void b(b bVar) {
            synchronized (this.a) {
                try {
                    this.a.remove(bVar);
                } catch (UnsupportedOperationException unused) {
                    com.huawei.updatesdk.a.a.c.a.a.a.b("InstallObserverManager", "unRegisterObserver UnsupportedOperationException");
                }
            }
        }
    }

    private c() {
    }

    public static com.huawei.updatesdk.b.f.a a() {
        return b;
    }

    public static c b() {
        return a;
    }

    public void a(com.huawei.updatesdk.a.b.b.b bVar) {
        b.a(1, bVar);
    }

    public void b(com.huawei.updatesdk.a.b.b.b bVar) {
        b.a(0, bVar);
    }

    public void c(com.huawei.updatesdk.a.b.b.b bVar) {
        b.a(2, bVar);
    }
}
