package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ac.CrashpadHelper;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* renamed from: com.yandex.metrica.impl.ob.y7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1382y7 {
    private static final Set<String> m;
    private final Context a;
    private final ICommonExecutor b;
    private final File c;
    private final List<String> d;
    private final File e;
    private final File f;
    private final InterfaceC1132nm<Void, String> g;
    private final Jl h;
    private final C1358x7 i;
    private final Callable<String> j;
    private final C1191q7 k;
    private final B0 l;

    /* renamed from: com.yandex.metrica.impl.ob.y7$a */
    class a implements InterfaceC1132nm<Void, String> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public String a(Void r1) {
            return CrashpadHelper.getLibraryVersion();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.y7$b */
    class b implements Callable<String> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            return CrashpadHelper.getLibDirInsideApk();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.y7$c */
    static class c implements InterfaceC1132nm<File, Boolean> {
        c() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public /* bridge */ /* synthetic */ Boolean a(File file) {
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.y7$d */
    static class d implements InterfaceC1132nm<File, Boolean> {
        private final String a;

        public d(String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public Boolean a(File file) {
            return Boolean.valueOf(!file.getName().endsWith(this.a));
        }
    }

    static {
        HashSet hashSet = new HashSet();
        m = hashSet;
        hashSet.add("armeabi-v7a");
        hashSet.add("arm64-v8a");
        hashSet.add("x86");
        hashSet.add("x86_64");
    }

    public C1382y7(Context context, B0 b0, ICommonExecutor iCommonExecutor) {
        this(context, b0, iCommonExecutor, Arrays.asList("libappmetrica_crashpad_handler.so", "libappmetrica_handler.so"));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.yandex.metrica.impl.ob.C7 a() throws java.io.IOException {
        /*
            r9 = this;
            java.io.File r0 = r9.c
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L19
            boolean r0 = r0.exists()
            if (r0 != 0) goto Ld
            goto L19
        Ld:
            java.io.File r0 = r9.c
            java.lang.String r0 = r0.getAbsolutePath()
            com.yandex.metrica.impl.ob.C7 r3 = new com.yandex.metrica.impl.ob.C7
            r3.<init>(r0, r2, r1)
            return r3
        L19:
            android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "-"
            r0.append(r3)
            com.yandex.metrica.impl.ob.nm<java.lang.Void, java.lang.String> r3 = r9.g
            java.lang.Object r3 = r3.a(r1)
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.yandex.metrica.impl.ob.Jl r3 = r9.h
            java.lang.String r3 = r3.a()
            if (r3 == 0) goto Lb2
            java.io.File r4 = r9.f
            if (r4 != 0) goto L42
            goto L64
        L42:
            boolean r4 = r4.exists()
            r5 = 1
            if (r4 != 0) goto L65
            java.io.File r4 = r9.f
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L52
            goto L64
        L52:
            java.io.File r4 = r9.e
            if (r4 == 0) goto L64
            boolean r4 = r4.setExecutable(r5, r2)
            if (r4 != 0) goto L5d
            goto L64
        L5d:
            java.io.File r4 = r9.f
            boolean r5 = r4.setExecutable(r5, r2)
            goto L65
        L64:
            r5 = r2
        L65:
            if (r5 == 0) goto Lb2
            com.yandex.metrica.impl.ob.y7$d r4 = new com.yandex.metrica.impl.ob.y7$d
            r4.<init>(r0)
            com.yandex.metrica.core.api.executors.ICommonExecutor r5 = r9.b
            com.yandex.metrica.impl.ob.z7 r6 = new com.yandex.metrica.impl.ob.z7
            r6.<init>(r9, r4)
            r5.execute(r6)
            java.util.List<java.lang.String> r4 = r9.d
            java.util.Iterator r4 = r4.iterator()
        L7c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lb2
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.yandex.metrica.impl.ob.x7 r6 = r9.i
            java.lang.Object[] r7 = new java.lang.Object[]{r3, r5}
            java.lang.String r8 = "lib/%s/%s"
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r0)
            java.lang.String r5 = r8.toString()
            java.lang.String r5 = r6.a(r7, r5)
            android.os.SystemClock.elapsedRealtime()
            if (r5 == 0) goto L7c
            com.yandex.metrica.impl.ob.C7 r0 = new com.yandex.metrica.impl.ob.C7
            r0.<init>(r5, r2, r1)
            r1 = r0
        Lb2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1382y7.a():com.yandex.metrica.impl.ob.C7");
    }

    private File c() {
        String strCall;
        try {
            strCall = this.j.call();
        } catch (Throwable unused) {
            strCall = null;
        }
        if (TextUtils.isEmpty(strCall)) {
            return null;
        }
        this.l.getClass();
        return new File(strCall);
    }

    public C7 b() {
        C1167p7 c1167p7;
        C7 c7 = null;
        if (A2.a(29)) {
            File fileC = c();
            if (fileC == null) {
                return null;
            }
            for (String str : this.d) {
                this.l.getClass();
                File file = new File(fileC, str);
                if (file.exists()) {
                    return new C7(file.getAbsolutePath(), true, null);
                }
            }
            return null;
        }
        if (!A2.a(23)) {
            return a();
        }
        C1191q7 c1191q7 = this.k;
        Context context = this.a;
        String strA = this.h.a();
        c1191q7.getClass();
        try {
            String[] strArrA = D7.a(context, strA);
            c1167p7 = new C1167p7(strArrA[0], strArrA[1], Environment.getDataDirectory().getAbsolutePath());
        } catch (Throwable unused) {
            c1167p7 = null;
        }
        if (c1167p7 != null) {
            File fileC2 = c();
            if (fileC2 != null) {
                Iterator<String> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    this.l.getClass();
                    File file2 = new File(fileC2, next);
                    if (file2.exists()) {
                        c7 = new C7(file2.getAbsolutePath(), false, c1167p7);
                        break;
                    }
                }
            } else {
                c7 = new C7("stub", false, c1167p7);
            }
        }
        if (c7 == null || c7.d == null) {
            return a();
        }
        this.b.execute(new RunnableC1406z7(this, new c()));
        return c7;
    }

    private C1382y7(Context context, B0 b0, ICommonExecutor iCommonExecutor, List<String> list) {
        this(context, iCommonExecutor, list, b0, b0.a(b0.a(context), list.get(0)), b0.b(context.getCacheDir(), "appmetrica_crashpad_handler_extracted"), new a(), new b(), new Jl(m));
    }

    private C1382y7(Context context, ICommonExecutor iCommonExecutor, List<String> list, B0 b0, File file, File file2, InterfaceC1132nm<Void, String> interfaceC1132nm, Callable<String> callable, Jl jl) {
        this(context, iCommonExecutor, list, file, file2, interfaceC1132nm, callable, jl, new C1358x7(context, file2), new C1191q7(), b0);
    }

    C1382y7(Context context, ICommonExecutor iCommonExecutor, List<String> list, File file, File file2, InterfaceC1132nm<Void, String> interfaceC1132nm, Callable<String> callable, Jl jl, C1358x7 c1358x7, C1191q7 c1191q7, B0 b0) {
        this.a = context;
        this.b = iCommonExecutor;
        this.d = list;
        this.c = file;
        this.e = context.getCacheDir();
        this.f = file2;
        this.g = interfaceC1132nm;
        this.j = callable;
        this.h = jl;
        this.i = c1358x7;
        this.k = c1191q7;
        this.l = b0;
    }

    void a(InterfaceC1132nm<File, Boolean> interfaceC1132nm) {
        File[] fileArrListFiles;
        File file = this.f;
        if (file == null || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (interfaceC1132nm.a(file2).booleanValue()) {
                file2.delete();
            }
        }
    }
}
