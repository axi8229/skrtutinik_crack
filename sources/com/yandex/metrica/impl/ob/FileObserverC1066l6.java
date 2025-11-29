package com.yandex.metrica.impl.ob;

import android.os.FileObserver;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.l6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class FileObserverC1066l6 extends FileObserver {
    private final InterfaceC1107mm<File> a;
    private final File b;
    private final B0 c;

    public FileObserverC1066l6(File file, InterfaceC1107mm<File> interfaceC1107mm) {
        this(file, interfaceC1107mm, new B0());
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        InterfaceC1107mm<File> interfaceC1107mm = this.a;
        B0 b0 = this.c;
        File file = this.b;
        b0.getClass();
        interfaceC1107mm.b(new File(file, str));
    }

    FileObserverC1066l6(File file, InterfaceC1107mm<File> interfaceC1107mm, B0 b0) {
        super(file.getAbsolutePath(), 8);
        this.a = interfaceC1107mm;
        this.b = file;
        this.c = b0;
    }
}
