package com.google.android.exoplayer2.text;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class CaptionStyleCompat {
    public static final CaptionStyleCompat DEFAULT = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final Typeface typeface;
    public final int windowColor;

    public static CaptionStyleCompat createFromCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
        if (Util.SDK_INT >= 21) {
            return createFromCaptionStyleV21(captionStyle);
        }
        return createFromCaptionStyleV19(captionStyle);
    }

    public CaptionStyleCompat(int foregroundColor, int backgroundColor, int windowColor, int edgeType, int edgeColor, Typeface typeface) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.windowColor = windowColor;
        this.edgeType = edgeType;
        this.edgeColor = edgeColor;
        this.typeface = typeface;
    }

    private static CaptionStyleCompat createFromCaptionStyleV19(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static CaptionStyleCompat createFromCaptionStyleV21(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : DEFAULT.foregroundColor, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : DEFAULT.backgroundColor, captionStyle.hasWindowColor() ? captionStyle.windowColor : DEFAULT.windowColor, captionStyle.hasEdgeType() ? captionStyle.edgeType : DEFAULT.edgeType, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : DEFAULT.edgeColor, captionStyle.getTypeface());
    }
}
