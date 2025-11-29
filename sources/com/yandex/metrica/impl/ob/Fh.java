package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.net.ServerSocket;

/* loaded from: classes3.dex */
public interface Fh {

    public static class a extends Throwable {
        a(String str, Throwable th) {
            super(str, th);
        }
    }

    ServerSocket a(int i) throws a, IOException;
}
