package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class SubtitleWebView extends FrameLayout implements SubtitleView.Output {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List<Cue> cues;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;
    private final WebView webView;

    private static int anchorTypeToTranslatePercent(int anchorType) {
        if (anchorType != 1) {
            return anchorType != 2 ? 0 : -100;
        }
        return -50;
    }

    public SubtitleWebView(Context context) {
        this(context, null);
    }

    public SubtitleWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.cues = Collections.emptyList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
        WebView webView = new WebView(context, attrs) { // from class: com.google.android.exoplayer2.ui.SubtitleWebView.1
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                super.onTouchEvent(event);
                return false;
            }

            @Override // android.view.View
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = webView;
        webView.setBackgroundColor(0);
        addView(webView);
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void onCues(List<Cue> cues) {
        this.cues = cues;
        updateWebView();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setTextSize(int textSizeType, float textSize) {
        if (this.textSizeType == textSizeType && this.textSize == textSize) {
            return;
        }
        this.textSizeType = textSizeType;
        this.textSize = textSize;
        updateWebView();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setApplyEmbeddedStyles(boolean applyEmbeddedStyles) {
        if (this.applyEmbeddedStyles == applyEmbeddedStyles && this.applyEmbeddedFontSizes == applyEmbeddedStyles) {
            return;
        }
        this.applyEmbeddedStyles = applyEmbeddedStyles;
        this.applyEmbeddedFontSizes = applyEmbeddedStyles;
        updateWebView();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setApplyEmbeddedFontSizes(boolean applyEmbeddedFontSizes) {
        if (this.applyEmbeddedFontSizes == applyEmbeddedFontSizes) {
            return;
        }
        this.applyEmbeddedFontSizes = applyEmbeddedFontSizes;
        updateWebView();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setStyle(CaptionStyleCompat style) {
        if (this.style == style) {
            return;
        }
        this.style = style;
        updateWebView();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void setBottomPaddingFraction(float bottomPaddingFraction) {
        if (this.bottomPaddingFraction == bottomPaddingFraction) {
            return;
        }
        this.bottomPaddingFraction = bottomPaddingFraction;
        updateWebView();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateWebView() {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.SubtitleWebView.updateWebView():void");
    }

    private String convertVerticalTypeToCss(int verticalType) {
        if (verticalType == 1) {
            return "vertical-rl";
        }
        if (verticalType == 2) {
            return "vertical-lr";
        }
        return "horizontal-tb";
    }

    private String convertAlignmentToCss(Layout.Alignment alignment) {
        if (alignment == null) {
            return "unset";
        }
        int i = AnonymousClass2.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
        if (i == 1) {
            return "start";
        }
        if (i == 2) {
            return "center";
        }
        if (i != 3) {
            return "unset";
        }
        return "end";
    }

    /* renamed from: com.google.android.exoplayer2.ui.SubtitleWebView$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
