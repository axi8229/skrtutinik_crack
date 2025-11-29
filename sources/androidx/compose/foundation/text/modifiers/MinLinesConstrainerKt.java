package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: MinLinesConstrainer.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"", "EmptyTextReplacement", "Ljava/lang/String;", "TwoLineTextReplacement", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MinLinesConstrainerKt {
    private static final String EmptyTextReplacement;
    private static final String TwoLineTextReplacement;

    static {
        String strRepeat = StringsKt.repeat("H", 10);
        EmptyTextReplacement = strRepeat;
        TwoLineTextReplacement = strRepeat + '\n' + strRepeat;
    }
}
