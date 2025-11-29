package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.HostRetryInfoProvider;

/* renamed from: com.yandex.metrica.impl.ob.pd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1173pd implements HostRetryInfoProvider {
    private final C0895e9 a;
    private final EnumC1197qd b;

    public C1173pd(C0895e9 c0895e9, EnumC1197qd enumC1197qd) {
        this.a = c0895e9;
        this.b = enumC1197qd;
    }

    @Override // com.yandex.metrica.networktasks.api.HostRetryInfoProvider
    public long getLastAttemptTimeSeconds() {
        return this.a.a(this.b, 0L);
    }

    @Override // com.yandex.metrica.networktasks.api.HostRetryInfoProvider
    public int getNextSendAttemptNumber() {
        return this.a.a(this.b, 1);
    }

    @Override // com.yandex.metrica.networktasks.api.HostRetryInfoProvider
    public void saveLastAttemptTimeSeconds(long j) {
        this.a.b(this.b, j);
    }

    @Override // com.yandex.metrica.networktasks.api.HostRetryInfoProvider
    public void saveNextSendAttemptNumber(int i) {
        this.a.b(this.b, i);
    }
}
