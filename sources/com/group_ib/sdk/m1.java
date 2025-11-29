package com.group_ib.sdk;

/* loaded from: classes3.dex */
public final class m1 {
    public byte[] a = null;
    public int b = 0;

    public final void a(int i) {
        if (i > 0) {
            byte[] bArr = this.a;
            if (bArr == null) {
                this.a = new byte[i];
                this.b = 0;
                return;
            }
            int length = bArr.length;
            int i2 = this.b;
            int i3 = i + i2;
            if (length < i3) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                this.a = bArr2;
            }
        }
    }

    public final boolean a() {
        return this.a == null || this.b == 0;
    }
}
