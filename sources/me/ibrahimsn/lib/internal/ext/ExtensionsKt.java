package me.ibrahimsn.lib.internal.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "prependPlus", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "", "startsWithPlus", "(Ljava/lang/CharSequence;)Z", "lib_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtensionsKt {
    public static final String prependPlus(CharSequence charSequence) {
        String str = "+" + charSequence;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        …this)\n        .toString()");
        return str;
    }

    public static final boolean startsWithPlus(CharSequence charSequence) {
        return charSequence != null && StringsKt.startsWith$default(charSequence, (CharSequence) "+", false, 2, (Object) null);
    }
}
