package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.ResponseValidityChecker;

/* renamed from: com.yandex.metrica.impl.ob.nd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1123nd implements ResponseValidityChecker {
    @Override // com.yandex.metrica.networktasks.api.ResponseValidityChecker
    public boolean isResponseValid(int i) {
        return (i == 400 || i == 500) ? false : true;
    }
}
