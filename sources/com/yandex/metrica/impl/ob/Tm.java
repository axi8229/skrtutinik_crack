package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Tm extends Sm<byte[]> {
    public Tm(int i, String str, C0858cm c0858cm) {
        super(i, str, c0858cm);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0934fn
    public Object a(Object obj) {
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length <= super.b()) {
            return bArr;
        }
        byte[] bArr2 = new byte[super.b()];
        System.arraycopy(bArr, 0, bArr2, 0, super.b());
        if (this.c.isEnabled()) {
            this.c.fw("\"%s\" %s exceeded limit of %d bytes", super.a(), bArr, Integer.valueOf(super.b()));
        }
        return bArr2;
    }
}
