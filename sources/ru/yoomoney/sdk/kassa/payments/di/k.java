package ru.yoomoney.sdk.kassa.payments.di;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.yoomoney.sdk.kassa.payments.di.module.K;
import ru.yoomoney.sdk.kassa.payments.di.module.M;

/* loaded from: classes5.dex */
public final class k {
    public final Provider a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;
    public final Provider i;
    public final Provider j;
    public final Provider k;
    public final Provider l;

    public k(dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, dagger.internal.Provider provider5, dagger.internal.Provider provider6, dagger.internal.Provider provider7, M m, dagger.internal.Provider provider8, K k, dagger.internal.Provider provider9, Factory factory) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = m;
        this.i = provider8;
        this.j = k;
        this.k = provider9;
        this.l = factory;
    }
}
