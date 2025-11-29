package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class UrlTemplate {
    private final int identifierCount;
    private final String[] identifierFormatTags;
    private final int[] identifiers;
    private final String[] urlPieces;

    public static UrlTemplate compile(String template) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new UrlTemplate(strArr, iArr, strArr2, parseTemplate(template, strArr, iArr, strArr2));
    }

    private UrlTemplate(String[] urlPieces, int[] identifiers, String[] identifierFormatTags, int identifierCount) {
        this.urlPieces = urlPieces;
        this.identifiers = identifiers;
        this.identifierFormatTags = identifierFormatTags;
        this.identifierCount = identifierCount;
    }

    public String buildUri(String representationId, long segmentNumber, int bandwidth, long time) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = this.identifierCount;
            if (i < i2) {
                sb.append(this.urlPieces[i]);
                int i3 = this.identifiers[i];
                if (i3 == 1) {
                    sb.append(representationId);
                } else if (i3 == 2) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i], Long.valueOf(segmentNumber)));
                } else if (i3 == 3) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i], Integer.valueOf(bandwidth)));
                } else if (i3 == 4) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i], Long.valueOf(time)));
                }
                i++;
            } else {
                sb.append(this.urlPieces[i2]);
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int parseTemplate(java.lang.String r12, java.lang.String[] r13, int[] r14, java.lang.String[] r15) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.UrlTemplate.parseTemplate(java.lang.String, java.lang.String[], int[], java.lang.String[]):int");
    }
}
