package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
final class SubtitlePainter {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private int backgroundColor;
    private Rect bitmapRect;
    private float bottomPaddingFraction;
    private Bitmap cueBitmap;
    private float cueBitmapHeight;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private Layout.Alignment cueTextAlignment;
    private float cueTextSizePx;
    private float defaultTextSizePx;
    private int edgeColor;
    private StaticLayout edgeLayout;
    private int edgeType;
    private int foregroundColor;
    private final float outlineWidth;
    private final Paint paint;
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint;
    private int textTop;
    private int windowColor;

    public SubtitlePainter(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.spacingAdd = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.spacingMult = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.outlineWidth = fRound;
        this.shadowRadius = fRound;
        this.shadowOffset = fRound;
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public void draw(Cue cue, boolean applyEmbeddedStyles, boolean applyEmbeddedFontSizes, CaptionStyleCompat style, float defaultTextSizePx, float cueTextSizePx, float bottomPaddingFraction, Canvas canvas, int cueBoxLeft, int cueBoxTop, int cueBoxRight, int cueBoxBottom) {
        int i;
        boolean z = cue.bitmap == null;
        if (!z) {
            i = -16777216;
        } else if (TextUtils.isEmpty(cue.text)) {
            return;
        } else {
            i = (cue.windowColorSet && applyEmbeddedStyles) ? cue.windowColor : style.windowColor;
        }
        if (areCharSequencesEqual(this.cueText, cue.text) && Util.areEqual(this.cueTextAlignment, cue.textAlignment) && this.cueBitmap == cue.bitmap && this.cueLine == cue.line && this.cueLineType == cue.lineType && Util.areEqual(Integer.valueOf(this.cueLineAnchor), Integer.valueOf(cue.lineAnchor)) && this.cuePosition == cue.position && Util.areEqual(Integer.valueOf(this.cuePositionAnchor), Integer.valueOf(cue.positionAnchor)) && this.cueSize == cue.size && this.cueBitmapHeight == cue.bitmapHeight && this.applyEmbeddedStyles == applyEmbeddedStyles && this.applyEmbeddedFontSizes == applyEmbeddedFontSizes && this.foregroundColor == style.foregroundColor && this.backgroundColor == style.backgroundColor && this.windowColor == i && this.edgeType == style.edgeType && this.edgeColor == style.edgeColor && Util.areEqual(this.textPaint.getTypeface(), style.typeface) && this.defaultTextSizePx == defaultTextSizePx && this.cueTextSizePx == cueTextSizePx && this.bottomPaddingFraction == bottomPaddingFraction && this.parentLeft == cueBoxLeft && this.parentTop == cueBoxTop && this.parentRight == cueBoxRight && this.parentBottom == cueBoxBottom) {
            drawLayout(canvas, z);
            return;
        }
        this.cueText = cue.text;
        this.cueTextAlignment = cue.textAlignment;
        this.cueBitmap = cue.bitmap;
        this.cueLine = cue.line;
        this.cueLineType = cue.lineType;
        this.cueLineAnchor = cue.lineAnchor;
        this.cuePosition = cue.position;
        this.cuePositionAnchor = cue.positionAnchor;
        this.cueSize = cue.size;
        this.cueBitmapHeight = cue.bitmapHeight;
        this.applyEmbeddedStyles = applyEmbeddedStyles;
        this.applyEmbeddedFontSizes = applyEmbeddedFontSizes;
        this.foregroundColor = style.foregroundColor;
        this.backgroundColor = style.backgroundColor;
        this.windowColor = i;
        this.edgeType = style.edgeType;
        this.edgeColor = style.edgeColor;
        this.textPaint.setTypeface(style.typeface);
        this.defaultTextSizePx = defaultTextSizePx;
        this.cueTextSizePx = cueTextSizePx;
        this.bottomPaddingFraction = bottomPaddingFraction;
        this.parentLeft = cueBoxLeft;
        this.parentTop = cueBoxTop;
        this.parentRight = cueBoxRight;
        this.parentBottom = cueBoxBottom;
        if (z) {
            Assertions.checkNotNull(this.cueText);
            setupTextLayout();
        } else {
            Assertions.checkNotNull(this.cueBitmap);
            setupBitmapLayout();
        }
        drawLayout(canvas, z);
    }

    private void setupTextLayout() {
        int i;
        int i2;
        int iMax;
        int iMin;
        int i3;
        int iRound;
        int i4;
        CharSequence charSequence = this.cueText;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.cueText);
        int i5 = this.parentRight - this.parentLeft;
        int i6 = this.parentBottom - this.parentTop;
        this.textPaint.setTextSize(this.defaultTextSizePx);
        int i7 = (int) ((this.defaultTextSizePx * 0.125f) + 0.5f);
        int i8 = i7 * 2;
        int i9 = i5 - i8;
        float f = this.cueSize;
        if (f != -3.4028235E38f) {
            i9 = (int) (i9 * f);
        }
        int i10 = i9;
        if (i10 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (!this.applyEmbeddedStyles) {
            for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class)) {
                spannableStringBuilder.removeSpan(obj);
            }
        } else if (!this.applyEmbeddedFontSizes) {
            for (AbsoluteSizeSpan absoluteSizeSpan : (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AbsoluteSizeSpan.class)) {
                spannableStringBuilder.removeSpan(absoluteSizeSpan);
            }
            for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), RelativeSizeSpan.class)) {
                spannableStringBuilder.removeSpan(relativeSizeSpan);
            }
        } else if (this.cueTextSizePx > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.cueTextSizePx), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.edgeType == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.backgroundColor) > 0) {
            int i11 = this.edgeType;
            if (i11 == 0 || i11 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.cueTextAlignment;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.textPaint, i10, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLayout = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.textLayout.getLineCount();
        int iMax2 = 0;
        for (int i12 = 0; i12 < lineCount; i12++) {
            iMax2 = Math.max((int) Math.ceil(this.textLayout.getLineWidth(i12)), iMax2);
        }
        if (this.cueSize == -3.4028235E38f || iMax2 >= i10) {
            i10 = iMax2;
        }
        int i13 = i10 + i8;
        float f2 = this.cuePosition;
        if (f2 != -3.4028235E38f) {
            int iRound2 = Math.round(i5 * f2);
            int i14 = this.parentLeft;
            int i15 = iRound2 + i14;
            int i16 = this.cuePositionAnchor;
            i = 1;
            if (i16 != 1) {
                i2 = 2;
                if (i16 == 2) {
                    i15 -= i13;
                }
            } else {
                i2 = 2;
                i15 = ((i15 * 2) - i13) / 2;
            }
            iMax = Math.max(i15, i14);
            iMin = Math.min(i13 + iMax, this.parentRight);
        } else {
            i = 1;
            i2 = 2;
            iMax = ((i5 - i13) / 2) + this.parentLeft;
            iMin = iMax + i13;
        }
        int i17 = iMin - iMax;
        if (i17 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.cueLine;
        if (f3 != -3.4028235E38f) {
            if (this.cueLineType == 0) {
                iRound = Math.round(i6 * f3);
                i4 = this.parentTop;
            } else {
                int lineBottom = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                float f4 = this.cueLine;
                if (f4 >= 0.0f) {
                    iRound = Math.round(f4 * lineBottom);
                    i4 = this.parentTop;
                } else {
                    iRound = Math.round((f4 + 1.0f) * lineBottom);
                    i4 = this.parentBottom;
                }
            }
            i3 = iRound + i4;
            int i18 = this.cueLineAnchor;
            if (i18 == i2) {
                i3 -= height;
            } else if (i18 == i) {
                i3 = ((i3 * 2) - height) / i2;
            }
            int i19 = i3 + height;
            int i20 = this.parentBottom;
            if (i19 > i20) {
                i3 = i20 - height;
            } else {
                int i21 = this.parentTop;
                if (i3 < i21) {
                    i3 = i21;
                }
            }
        } else {
            i3 = (this.parentBottom - height) - ((int) (i6 * this.bottomPaddingFraction));
        }
        int i22 = i3;
        this.textLayout = new StaticLayout(spannableStringBuilder, this.textPaint, i17, alignment2, this.spacingMult, this.spacingAdd, true);
        this.edgeLayout = new StaticLayout(spannableStringBuilder2, this.textPaint, i17, alignment2, this.spacingMult, this.spacingAdd, true);
        this.textLeft = iMax;
        this.textTop = i22;
        this.textPaddingX = i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setupBitmapLayout() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.cueBitmap
            int r1 = r7.parentRight
            int r2 = r7.parentLeft
            int r1 = r1 - r2
            int r3 = r7.parentBottom
            int r4 = r7.parentTop
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.cuePosition
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.cueLine
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.cueSize
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.cueBitmapHeight
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2e
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L3f
        L2e:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L3f:
            int r3 = r7.cuePositionAnchor
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L48
            float r3 = (float) r1
        L46:
            float r2 = r2 - r3
            goto L4e
        L48:
            if (r3 != r5) goto L4e
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L46
        L4e:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.cueLineAnchor
            if (r3 != r6) goto L59
            float r3 = (float) r0
        L57:
            float r4 = r4 - r3
            goto L5f
        L59:
            if (r3 != r5) goto L5f
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L57
        L5f:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.bitmapRect = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.SubtitlePainter.setupBitmapLayout():void");
    }

    private void drawLayout(Canvas canvas, boolean isTextCue) {
        if (isTextCue) {
            drawTextLayout(canvas);
            return;
        }
        Assertions.checkNotNull(this.bitmapRect);
        Assertions.checkNotNull(this.cueBitmap);
        drawBitmapLayout(canvas);
    }

    private void drawTextLayout(Canvas canvas) {
        StaticLayout staticLayout = this.textLayout;
        StaticLayout staticLayout2 = this.edgeLayout;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.textLeft, this.textTop);
        if (Color.alpha(this.windowColor) > 0) {
            this.paint.setColor(this.windowColor);
            canvas.drawRect(-this.textPaddingX, 0.0f, staticLayout.getWidth() + this.textPaddingX, staticLayout.getHeight(), this.paint);
        }
        int i = this.edgeType;
        if (i == 1) {
            this.textPaint.setStrokeJoin(Paint.Join.ROUND);
            this.textPaint.setStrokeWidth(this.outlineWidth);
            this.textPaint.setColor(this.edgeColor);
            this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.textPaint;
            float f = this.shadowRadius;
            float f2 = this.shadowOffset;
            textPaint.setShadowLayer(f, f2, f2, this.edgeColor);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.edgeColor;
            int i3 = z ? this.edgeColor : -1;
            float f3 = this.shadowRadius / 2.0f;
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.textPaint.setShadowLayer(this.shadowRadius, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.textPaint.setShadowLayer(this.shadowRadius, f3, f3, i3);
        }
        this.textPaint.setColor(this.foregroundColor);
        this.textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    private void drawBitmapLayout(Canvas canvas) {
        canvas.drawBitmap(this.cueBitmap, (Rect) null, this.bitmapRect, (Paint) null);
    }

    private static boolean areCharSequencesEqual(CharSequence first, CharSequence second) {
        return first == second || (first != null && first.equals(second));
    }
}
