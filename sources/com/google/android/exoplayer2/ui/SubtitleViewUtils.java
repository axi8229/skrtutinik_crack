package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.text.Cue;

/* loaded from: classes2.dex */
final class SubtitleViewUtils {
    public static float resolveTextSize(int textSizeType, float textSize, int rawViewHeight, int viewHeightMinusPadding) {
        float f;
        if (textSizeType == 0) {
            f = viewHeightMinusPadding;
        } else {
            if (textSizeType != 1) {
                if (textSizeType != 2) {
                    return -3.4028235E38f;
                }
                return textSize;
            }
            f = rawViewHeight;
        }
        return textSize * f;
    }

    public static float resolveCueTextSize(Cue cue, int rawViewHeight, int viewHeightMinusPadding) {
        int i = cue.textSizeType;
        if (i != Integer.MIN_VALUE) {
            float f = cue.textSize;
            if (f != -3.4028235E38f) {
                return Math.max(resolveTextSize(i, f, rawViewHeight, viewHeightMinusPadding), 0.0f);
            }
        }
        return 0.0f;
    }
}
