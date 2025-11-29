package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
abstract class CoderBase {
    private final Class<?>[] acceptableOptions;

    abstract InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException;

    Object getOptionsFromCoder(Coder coder, InputStream inputStream) throws IOException {
        return null;
    }

    protected CoderBase(Class<?>... clsArr) {
        this.acceptableOptions = clsArr;
    }

    boolean canAcceptOptions(Object obj) {
        for (Class<?> cls : this.acceptableOptions) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }
}
