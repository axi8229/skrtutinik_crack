package ru.yoomoney.sdk.kassa.payments.navigation;

import java.io.Serializable;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class h implements Serializable {
    public static final h a;
    public static final h b;
    public static final /* synthetic */ h[] c;

    static {
        h hVar = new h("SUCCESS", 0);
        a = hVar;
        h hVar2 = new h("CANCEL", 1);
        b = hVar2;
        h[] hVarArr = {hVar, hVar2};
        c = hVarArr;
        EnumEntriesKt.enumEntries(hVarArr);
    }

    public h(String str, int i) {
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) c.clone();
    }
}
