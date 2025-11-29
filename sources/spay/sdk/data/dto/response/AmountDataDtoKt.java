package spay.sdk.data.dto.response;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"takeKopecksFromDouble", "", "", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AmountDataDtoKt {
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: NumberFormatException -> 0x009c, TryCatch #0 {NumberFormatException -> 0x009c, blocks: (B:3:0x0005, B:6:0x000d, B:12:0x001c, B:24:0x0094, B:25:0x0098, B:13:0x002a, B:15:0x003a, B:16:0x004c, B:18:0x0059, B:21:0x006a, B:23:0x0077, B:9:0x0016), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int takeKopecksFromDouble(java.lang.String r13) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = "this as java.lang.String).substring(startIndex)"
            r2 = 0
            int r3 = r13.length()     // Catch: java.lang.NumberFormatException -> L9c
            r4 = r2
        La:
            r5 = -1
            if (r4 >= r3) goto L19
            char r6 = r13.charAt(r4)     // Catch: java.lang.NumberFormatException -> L9c
            r7 = 46
            if (r6 != r7) goto L16
            goto L1a
        L16:
            int r4 = r4 + 1
            goto La
        L19:
            r4 = r5
        L1a:
            if (r4 != r5) goto L2a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L9c
            r0.<init>()     // Catch: java.lang.NumberFormatException -> L9c
            r0.append(r13)     // Catch: java.lang.NumberFormatException -> L9c
            java.lang.String r13 = "00"
            r0.append(r13)     // Catch: java.lang.NumberFormatException -> L9c
            goto L94
        L2a:
            int r3 = r4 + 1
            java.lang.String r5 = r13.substring(r3)     // Catch: java.lang.NumberFormatException -> L9c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch: java.lang.NumberFormatException -> L9c
            int r5 = r5.length()     // Catch: java.lang.NumberFormatException -> L9c
            r6 = 2
            if (r5 < r6) goto L4c
            java.lang.String r8 = "."
            java.lang.String r9 = ""
            r11 = 4
            r12 = 0
            r10 = 0
            r7 = r13
            java.lang.String r13 = kotlin.text.StringsKt.replace$default(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.NumberFormatException -> L9c
            int r4 = r4 + r6
            java.lang.String r13 = kotlin.text.StringsKt.take(r13, r4)     // Catch: java.lang.NumberFormatException -> L9c
            goto L98
        L4c:
            java.lang.String r5 = r13.substring(r3)     // Catch: java.lang.NumberFormatException -> L9c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch: java.lang.NumberFormatException -> L9c
            int r5 = r5.length()     // Catch: java.lang.NumberFormatException -> L9c
            if (r5 >= r6) goto L6a
            java.lang.String r4 = r13.substring(r2, r4)     // Catch: java.lang.NumberFormatException -> L9c
            java.lang.String r5 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch: java.lang.NumberFormatException -> L9c
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)     // Catch: java.lang.NumberFormatException -> L9c
            if (r4 == 0) goto L6a
            r13 = r0
            goto L98
        L6a:
            java.lang.String r0 = r13.substring(r3)     // Catch: java.lang.NumberFormatException -> L9c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.NumberFormatException -> L9c
            int r0 = r0.length()     // Catch: java.lang.NumberFormatException -> L9c
            if (r0 >= r6) goto L98
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L9c
            r0.<init>()     // Catch: java.lang.NumberFormatException -> L9c
            java.lang.String r5 = "."
            java.lang.String r6 = ""
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r13
            java.lang.String r13 = kotlin.text.StringsKt.replace$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.NumberFormatException -> L9c
            java.lang.String r13 = kotlin.text.StringsKt.take(r13, r3)     // Catch: java.lang.NumberFormatException -> L9c
            r0.append(r13)     // Catch: java.lang.NumberFormatException -> L9c
            r13 = 48
            r0.append(r13)     // Catch: java.lang.NumberFormatException -> L9c
        L94:
            java.lang.String r13 = r0.toString()     // Catch: java.lang.NumberFormatException -> L9c
        L98:
            int r2 = java.lang.Integer.parseInt(r13)     // Catch: java.lang.NumberFormatException -> L9c
        L9c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.data.dto.response.AmountDataDtoKt.takeKopecksFromDouble(java.lang.String):int");
    }
}
