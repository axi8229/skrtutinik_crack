package com.redmadrobot.inputmask.helper;

import kotlin.Metadata;

/* compiled from: RTLMask.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, d2 = {"reversedFormat", "", "format", "input-mask-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RTLMaskKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e A[PHI: r4
  0x004e: PHI (r4v4 char) = (r4v2 char), (r4v3 char) binds: [B:9:0x004c, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004a A[PHI: r3
  0x004a: PHI (r3v4 char) = (r3v2 char), (r3v3 char) binds: [B:7:0x0048, B:12:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String reversedFormat(java.lang.String r12) {
        /*
            if (r12 == 0) goto L73
            java.lang.CharSequence r12 = kotlin.text.StringsKt.reversed(r12)
            java.lang.String r0 = r12.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "[\\"
            java.lang.String r2 = "\\]"
            r3 = 0
            java.lang.String r6 = kotlin.text.StringsKt.replace$default(r0, r1, r2, r3, r4, r5)
            r10 = 4
            r11 = 0
            java.lang.String r7 = "]\\"
            java.lang.String r8 = "\\["
            r9 = 0
            java.lang.String r0 = kotlin.text.StringsKt.replace$default(r6, r7, r8, r9, r10, r11)
            java.lang.String r1 = "{\\"
            java.lang.String r2 = "\\}"
            java.lang.String r6 = kotlin.text.StringsKt.replace$default(r0, r1, r2, r3, r4, r5)
            java.lang.String r7 = "}\\"
            java.lang.String r8 = "\\{"
            java.lang.String r12 = kotlin.text.StringsKt.replace$default(r6, r7, r8, r9, r10, r11)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.length()
            r0.<init>(r1)
            r1 = 0
        L3a:
            int r2 = r12.length()
            if (r1 >= r2) goto L64
            char r2 = r12.charAt(r1)
            r3 = 93
            r4 = 91
            if (r2 != r4) goto L4c
        L4a:
            r2 = r3
            goto L5a
        L4c:
            if (r2 != r3) goto L50
        L4e:
            r2 = r4
            goto L5a
        L50:
            r3 = 125(0x7d, float:1.75E-43)
            r4 = 123(0x7b, float:1.72E-43)
            if (r2 != r4) goto L57
            goto L4a
        L57:
            if (r2 != r3) goto L5a
            goto L4e
        L5a:
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r0.add(r2)
            int r1 = r1 + 1
            goto L3a
        L64:
            r7 = 62
            r8 = 0
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r12 = kotlin.collections.CollectionsKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            return r12
        L73:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.redmadrobot.inputmask.helper.RTLMaskKt.reversedFormat(java.lang.String):java.lang.String");
    }
}
