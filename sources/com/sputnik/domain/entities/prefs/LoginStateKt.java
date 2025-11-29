package com.sputnik.domain.entities.prefs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: LoginState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"toPhoneHash", "", "str", "domain"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoginStateKt {
    public static final String toPhoneHash(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(new Regex("[^A-Za-z0-9 ]").replace(str, ""), " ", "", false, 4, (Object) null), "+", "", false, 4, (Object) null), "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null), "-", "", false, 4, (Object) null);
    }
}
