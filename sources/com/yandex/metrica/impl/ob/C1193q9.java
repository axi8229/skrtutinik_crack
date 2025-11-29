package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.StateSerializer;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.q9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1193q9 implements StateSerializer {
    private final StateSerializer a;
    private final C1349wm b;

    public C1193q9(StateSerializer stateSerializer, C1349wm c1349wm) {
        this.a = stateSerializer;
        this.b = c1349wm;
    }

    @Override // com.yandex.metrica.core.api.StateSerializer
    public Object defaultValue() {
        return this.a.defaultValue();
    }

    @Override // com.yandex.metrica.core.api.StateSerializer
    public byte[] toByteArray(Object obj) {
        try {
            return this.b.a(this.a.toByteArray(obj));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // com.yandex.metrica.core.api.StateSerializer
    public Object toState(byte[] bArr) throws IOException {
        try {
            C1349wm c1349wm = this.b;
            c1349wm.getClass();
            return this.a.toState(c1349wm.a(bArr, 0, bArr.length));
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
