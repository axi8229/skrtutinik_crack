package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.im, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC1007im {
    LOGIN("login"),
    LOGOUT("logout"),
    SWITCH("switch"),
    UPDATE("update");

    private String a;

    EnumC1007im(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
