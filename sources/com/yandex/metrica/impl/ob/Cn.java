package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class Cn implements Comparator<F2> {
    @Override // java.util.Comparator
    public int compare(F2 f2, F2 f22) {
        F2 f23 = f2;
        F2 f24 = f22;
        return (TextUtils.equals(f23.a, f24.a) && TextUtils.equals(f23.b, f24.b)) ? 0 : 10;
    }
}
