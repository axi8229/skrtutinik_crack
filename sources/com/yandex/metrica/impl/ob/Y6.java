package com.yandex.metrica.impl.ob;

import android.os.FileObserver;
import java.io.File;

/* loaded from: classes3.dex */
public class Y6 {
    private final FileObserver a;
    private final File b;
    private final C1091m6 c;

    public Y6(File file, InterfaceC1107mm<File> interfaceC1107mm) {
        this(new FileObserverC1066l6(file, interfaceC1107mm), file, new C1091m6());
    }

    public void a() {
        this.c.a(this.b);
        this.a.startWatching();
    }

    Y6(FileObserver fileObserver, File file, C1091m6 c1091m6) {
        this.a = fileObserver;
        this.b = file;
        this.c = c1091m6;
    }
}
