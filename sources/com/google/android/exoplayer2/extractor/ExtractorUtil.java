package com.google.android.exoplayer2.extractor;

import java.io.IOException;

/* loaded from: classes2.dex */
final class ExtractorUtil {
    public static int peekToLength(ExtractorInput input, byte[] target, int offset, int length) throws IOException {
        int i = 0;
        while (i < length) {
            int iPeek = input.peek(target, offset + i, length - i);
            if (iPeek == -1) {
                break;
            }
            i += iPeek;
        }
        return i;
    }
}
