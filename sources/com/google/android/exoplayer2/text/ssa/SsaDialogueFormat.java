package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes2.dex */
final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int startTimeIndex, int endTimeIndex, int styleIndex, int textIndex, int length) {
        this.startTimeIndex = startTimeIndex;
        this.endTimeIndex = endTimeIndex;
        this.styleIndex = styleIndex;
        this.textIndex = textIndex;
        this.length = length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.text.ssa.SsaDialogueFormat fromFormatLine(java.lang.String r10) {
        /*
            r0 = 1
            java.lang.String r1 = "Format:"
            boolean r1 = r10.startsWith(r1)
            com.google.android.exoplayer2.util.Assertions.checkArgument(r1)
            r1 = 7
            java.lang.String r10 = r10.substring(r1)
            java.lang.String r1 = ","
            java.lang.String[] r10 = android.text.TextUtils.split(r10, r1)
            r1 = -1
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r7
            r3 = r2
        L1c:
            int r4 = r10.length
            if (r3 >= r4) goto L6d
            r4 = r10[r3]
            java.lang.String r4 = r4.trim()
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r4)
            r4.hashCode()
            int r9 = r4.hashCode()
            switch(r9) {
                case 100571: goto L56;
                case 3556653: goto L4b;
                case 109757538: goto L40;
                case 109780401: goto L35;
                default: goto L33;
            }
        L33:
            r4 = r1
            goto L60
        L35:
            java.lang.String r9 = "style"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L3e
            goto L33
        L3e:
            r4 = 3
            goto L60
        L40:
            java.lang.String r9 = "start"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L49
            goto L33
        L49:
            r4 = 2
            goto L60
        L4b:
            java.lang.String r9 = "text"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L54
            goto L33
        L54:
            r4 = r0
            goto L60
        L56:
            java.lang.String r9 = "end"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L5f
            goto L33
        L5f:
            r4 = r2
        L60:
            switch(r4) {
                case 0: goto L6a;
                case 1: goto L68;
                case 2: goto L66;
                case 3: goto L64;
                default: goto L63;
            }
        L63:
            goto L6b
        L64:
            r7 = r3
            goto L6b
        L66:
            r5 = r3
            goto L6b
        L68:
            r8 = r3
            goto L6b
        L6a:
            r6 = r3
        L6b:
            int r3 = r3 + r0
            goto L1c
        L6d:
            if (r5 == r1) goto L79
            if (r6 == r1) goto L79
            com.google.android.exoplayer2.text.ssa.SsaDialogueFormat r0 = new com.google.android.exoplayer2.text.ssa.SsaDialogueFormat
            int r9 = r10.length
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            goto L7a
        L79:
            r0 = 0
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaDialogueFormat.fromFormatLine(java.lang.String):com.google.android.exoplayer2.text.ssa.SsaDialogueFormat");
    }
}
