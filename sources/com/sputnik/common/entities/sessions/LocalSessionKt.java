package com.sputnik.common.entities.sessions;

import com.sputnik.domain.entities.prefs.LoginStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"toPhoneHash", "", "str", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalSessionKt {
    public static final String toPhoneHash(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return LoginStateKt.toPhoneHash(str);
    }
}
