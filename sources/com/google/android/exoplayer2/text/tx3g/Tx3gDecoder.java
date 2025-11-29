package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray;

    public Tx3gDecoder(List<byte[]> initializationData) {
        super("Tx3gDecoder");
        this.parsableByteArray = new ParsableByteArray();
        if (initializationData != null && initializationData.size() == 1 && (initializationData.get(0).length == 48 || initializationData.get(0).length == 53)) {
            byte[] bArr = initializationData.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.defaultFontFamily = "Serif".equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i = bArr[25] * 20;
            this.calculatedVideoTrackHeight = i;
            boolean z = (bArr[0] & 32) != 0;
            this.customVerticalPlacement = z;
            if (z) {
                float f = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i;
                this.defaultVerticalPlacement = f;
                this.defaultVerticalPlacement = Util.constrainValue(f, 0.0f, 0.95f);
                return;
            }
            this.defaultVerticalPlacement = 0.85f;
            return;
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = "sans-serif";
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = 0.85f;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.parsableByteArray.reset(bArr, i);
        String subtitleText = readSubtitleText(this.parsableByteArray);
        if (subtitleText.isEmpty()) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(subtitleText);
        attachFontFace(spannableStringBuilder, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), 16711680);
        attachColor(spannableStringBuilder, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), 16711680);
        attachFontFamily(spannableStringBuilder, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float fConstrainValue = this.defaultVerticalPlacement;
        while (this.parsableByteArray.bytesLeft() >= 8) {
            int position = this.parsableByteArray.getPosition();
            int i2 = this.parsableByteArray.readInt();
            int i3 = this.parsableByteArray.readInt();
            if (i3 == 1937013100) {
                assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                int unsignedShort = this.parsableByteArray.readUnsignedShort();
                for (int i4 = 0; i4 < unsignedShort; i4++) {
                    applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                }
            } else if (i3 == 1952608120 && this.customVerticalPlacement) {
                assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                fConstrainValue = Util.constrainValue(this.parsableByteArray.readUnsignedShort() / this.calculatedVideoTrackHeight, 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(position + i2);
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder, null, fConstrainValue, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f));
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        char cPeekChar;
        assertTrue(parsableByteArray.bytesLeft() >= 2);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        if (unsignedShort == 0) {
            return "";
        }
        if (parsableByteArray.bytesLeft() >= 2 && ((cPeekChar = parsableByteArray.peekChar()) == 65279 || cPeekChar == 65534)) {
            return parsableByteArray.readString(unsignedShort, Charset.forName("UTF-16"));
        }
        return parsableByteArray.readString(unsignedShort, Charset.forName("UTF-8"));
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray, SpannableStringBuilder cueText) throws SubtitleDecoderException {
        assertTrue(parsableByteArray.bytesLeft() >= 12);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int i = parsableByteArray.readInt();
        attachFontFace(cueText, unsignedByte, this.defaultFontFace, unsignedShort, unsignedShort2, 0);
        attachColor(cueText, i, this.defaultColorRgba, unsignedShort, unsignedShort2, 0);
    }

    private static void attachFontFace(SpannableStringBuilder cueText, int fontFace, int defaultFontFace, int start, int end, int spanPriority) {
        if (fontFace != defaultFontFace) {
            int i = spanPriority | 33;
            boolean z = (fontFace & 1) != 0;
            boolean z2 = (fontFace & 2) != 0;
            if (z) {
                if (z2) {
                    cueText.setSpan(new StyleSpan(3), start, end, i);
                } else {
                    cueText.setSpan(new StyleSpan(1), start, end, i);
                }
            } else if (z2) {
                cueText.setSpan(new StyleSpan(2), start, end, i);
            }
            boolean z3 = (fontFace & 4) != 0;
            if (z3) {
                cueText.setSpan(new UnderlineSpan(), start, end, i);
            }
            if (z3 || z || z2) {
                return;
            }
            cueText.setSpan(new StyleSpan(0), start, end, i);
        }
    }

    private static void attachColor(SpannableStringBuilder cueText, int colorRgba, int defaultColorRgba, int start, int end, int spanPriority) {
        if (colorRgba != defaultColorRgba) {
            cueText.setSpan(new ForegroundColorSpan((colorRgba >>> 8) | ((colorRgba & KotlinVersion.MAX_COMPONENT_VALUE) << 24)), start, end, spanPriority | 33);
        }
    }

    private static void attachFontFamily(SpannableStringBuilder cueText, String fontFamily, String defaultFontFamily, int start, int end, int spanPriority) {
        if (fontFamily != defaultFontFamily) {
            cueText.setSpan(new TypefaceSpan(fontFamily), start, end, spanPriority | 33);
        }
    }

    private static void assertTrue(boolean checkValue) throws SubtitleDecoderException {
        if (!checkValue) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
