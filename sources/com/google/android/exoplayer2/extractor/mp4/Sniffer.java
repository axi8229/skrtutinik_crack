package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* loaded from: classes2.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153};

    public static boolean sniffFragmented(ExtractorInput input) throws IOException {
        return sniffInternal(input, true);
    }

    public static boolean sniffUnfragmented(ExtractorInput input) throws IOException {
        return sniffInternal(input, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        r5 = r8 ? 1 : 0;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0095, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00da, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00de, code lost:
    
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00df, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e3, code lost:
    
        if (r22 != r0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e7, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean sniffInternal(com.google.android.exoplayer2.extractor.ExtractorInput r21, boolean r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Sniffer.sniffInternal(com.google.android.exoplayer2.extractor.ExtractorInput, boolean):boolean");
    }

    private static boolean isCompatibleBrand(int brand) {
        if ((brand >>> 8) == 3368816) {
            return true;
        }
        for (int i : COMPATIBLE_BRANDS) {
            if (i == brand) {
                return true;
            }
        }
        return false;
    }
}
