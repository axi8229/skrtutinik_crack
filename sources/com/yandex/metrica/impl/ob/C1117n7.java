package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.io.FileUtils;
import java.io.File;

@Deprecated
/* renamed from: com.yandex.metrica.impl.ob.n7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1117n7 implements InterfaceC0893e7<File> {
    private final Context a;
    private final File b;
    private final C0845c9 c;
    private final B0 d;
    private final C0993i7 e;
    private final InterfaceC0918f7<String> f;
    private final ICommonExecutor g;

    /* renamed from: com.yandex.metrica.impl.ob.n7$a */
    static class a implements InterfaceC1107mm<File> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(File file) {
            file.delete();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.n7$b */
    static class b implements InterfaceC1107mm<String> {
        private final InterfaceC0918f7<String> a;

        b(InterfaceC0918f7<String> interfaceC0918f7) {
            this.a = interfaceC0918f7;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.a.b(str2);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.n7$c */
    static class c implements InterfaceC1107mm<String> {
        private final InterfaceC0918f7<String> a;

        c(InterfaceC0918f7<String> interfaceC0918f7) {
            this.a = interfaceC0918f7;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.a.a(str2);
        }
    }

    public C1117n7(Context context, B0 b0, C0993i7 c0993i7, InterfaceC0918f7<String> interfaceC0918f7, ICommonExecutor iCommonExecutor, C0845c9 c0845c9) {
        this.a = context;
        this.d = b0;
        this.b = b0.b(context);
        this.e = c0993i7;
        this.f = interfaceC0918f7;
        this.g = iCommonExecutor;
        this.c = c0845c9;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0893e7
    public void a(File file) {
        this.g.execute(new RunnableC1261t6(file, this.e, new a(), new b(this.f)));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0893e7
    public synchronized void a() {
        File fileB;
        if (FileUtils.needToUseNoBackup() && (fileB = this.d.b(this.a.getFilesDir(), "YandexMetricaNativeCrashes")) != null) {
            if (this.c.o()) {
                if (fileB.exists()) {
                    try {
                        fileB.delete();
                    } catch (Throwable unused) {
                    }
                }
            } else {
                a2(fileB);
                this.c.p();
            }
        }
        a2(this.b);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(File file) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            fileArrListFiles = file.listFiles(new C1092m7(this));
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            }
        } else {
            fileArrListFiles = new File[0];
        }
        for (File file2 : fileArrListFiles) {
            this.g.execute(new RunnableC1261t6(file2, this.e, new a(), new c(this.f)));
        }
    }
}
