package ru.yoomoney.sdk.kassa.payments.navigation;

import java.io.Serializable;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class n implements Serializable {
    public static final n a;
    public static final /* synthetic */ n[] b;

    static {
        n nVar = new n();
        a = nVar;
        n[] nVarArr = {nVar};
        b = nVarArr;
        EnumEntriesKt.enumEntries(nVarArr);
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) b.clone();
    }
}
