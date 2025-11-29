package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SubtitleView extends FrameLayout implements TextOutput {
    private View innerSubtitleView;
    private Output output;
    private int viewType;

    interface Output {
        void onCues(List<Cue> cues);

        void setApplyEmbeddedFontSizes(boolean applyEmbeddedFontSizes);

        void setApplyEmbeddedStyles(boolean applyEmbeddedStyles);

        void setBottomPaddingFraction(float bottomPaddingFraction);

        void setStyle(CaptionStyleCompat style);

        void setTextSize(int textSizeType, float textSize);
    }

    public SubtitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        SubtitleTextView subtitleTextView = new SubtitleTextView(context, attrs);
        this.output = subtitleTextView;
        this.innerSubtitleView = subtitleTextView;
        addView(subtitleTextView);
        this.viewType = 1;
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public void onCues(List<Cue> cues) {
        setCues(cues);
    }

    public void setCues(List<Cue> cues) {
        Output output = this.output;
        if (cues == null) {
            cues = Collections.emptyList();
        }
        output.onCues(cues);
    }

    public void setViewType(int viewType) {
        if (this.viewType == viewType) {
            return;
        }
        if (viewType == 1) {
            setView(new SubtitleTextView(getContext()));
        } else if (viewType == 2) {
            setView(new SubtitleWebView(getContext()));
        } else {
            throw new IllegalArgumentException();
        }
        this.viewType = viewType;
    }

    private <T extends View & Output> void setView(T view) {
        removeView(this.innerSubtitleView);
        this.innerSubtitleView = view;
        this.output = view;
        addView(view);
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(((Util.SDK_INT < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
    }

    public void setFractionalTextSize(float fractionOfHeight) {
        setFractionalTextSize(fractionOfHeight, false);
    }

    public void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    private void setTextSize(int textSizeType, float textSize) {
        this.output.setTextSize(textSizeType, textSize);
    }

    public void setApplyEmbeddedStyles(boolean applyEmbeddedStyles) {
        this.output.setApplyEmbeddedStyles(applyEmbeddedStyles);
    }

    public void setApplyEmbeddedFontSizes(boolean applyEmbeddedFontSizes) {
        this.output.setApplyEmbeddedFontSizes(applyEmbeddedFontSizes);
    }

    public void setUserDefaultStyle() {
        setStyle((Util.SDK_INT < 19 || !isCaptionManagerEnabled() || isInEditMode()) ? CaptionStyleCompat.DEFAULT : getUserCaptionStyleV19());
    }

    public void setStyle(CaptionStyleCompat style) {
        this.output.setStyle(style);
    }

    public void setBottomPaddingFraction(float bottomPaddingFraction) {
        this.output.setBottomPaddingFraction(bottomPaddingFraction);
    }

    private boolean isCaptionManagerEnabled() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).isEnabled();
    }

    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyleV19() {
        return CaptionStyleCompat.createFromCaptionStyle(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
