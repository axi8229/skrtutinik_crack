package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class SubtitleTextView extends View implements SubtitleView.Output {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List<Cue> cues;
    private final List<SubtitlePainter> painters;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;

    public SubtitleTextView(Context context) {
        this(context, null);
    }

    public SubtitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.painters = new ArrayList();
        this.cues = Collections.emptyList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void onCues(List<Cue> cues) {
        List<Cue> list = this.cues;
        if (list != cues) {
            if (list.isEmpty() && cues.isEmpty()) {
                return;
            }
            this.cues = cues;
            while (this.painters.size() < cues.size()) {
                this.painters.add(new SubtitlePainter(getContext()));
            }
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setTextSize(int textSizeType, float textSize) {
        if (this.textSizeType == textSizeType && this.textSize == textSize) {
            return;
        }
        this.textSizeType = textSizeType;
        this.textSize = textSize;
        invalidate();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setApplyEmbeddedStyles(boolean applyEmbeddedStyles) {
        if (this.applyEmbeddedStyles == applyEmbeddedStyles && this.applyEmbeddedFontSizes == applyEmbeddedStyles) {
            return;
        }
        this.applyEmbeddedStyles = applyEmbeddedStyles;
        this.applyEmbeddedFontSizes = applyEmbeddedStyles;
        invalidate();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setApplyEmbeddedFontSizes(boolean applyEmbeddedFontSizes) {
        if (this.applyEmbeddedFontSizes == applyEmbeddedFontSizes) {
            return;
        }
        this.applyEmbeddedFontSizes = applyEmbeddedFontSizes;
        invalidate();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setStyle(CaptionStyleCompat style) {
        if (this.style == style) {
            return;
        }
        this.style = style;
        invalidate();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setBottomPaddingFraction(float bottomPaddingFraction) {
        if (this.bottomPaddingFraction == bottomPaddingFraction) {
            return;
        }
        this.bottomPaddingFraction = bottomPaddingFraction;
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<Cue> list = this.cues;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float fResolveTextSize = SubtitleViewUtils.resolveTextSize(this.textSizeType, this.textSize, height, i);
        if (fResolveTextSize <= 0.0f) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Cue cue = list.get(i2);
            int i3 = paddingBottom;
            int i4 = width;
            this.painters.get(i2).draw(cue, this.applyEmbeddedStyles, this.applyEmbeddedFontSizes, this.style, fResolveTextSize, SubtitleViewUtils.resolveCueTextSize(cue, height, i), this.bottomPaddingFraction, canvas, paddingLeft, paddingTop, i4, i3);
            i2++;
            size = size;
            i = i;
            paddingBottom = i3;
            width = i4;
            paddingTop = paddingTop;
            paddingLeft = paddingLeft;
        }
    }
}
