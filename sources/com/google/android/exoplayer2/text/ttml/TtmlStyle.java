package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;

/* loaded from: classes2.dex */
final class TtmlStyle {
    private int backgroundColor;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private String id;
    private Layout.Alignment textAlign;
    private int linethrough = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int fontSizeUnit = -1;
    private int rubyType = -1;
    private int rubyPosition = -1;
    private int textCombine = -1;
    private int verticalType = Integer.MIN_VALUE;

    public int getStyle() {
        int i = this.bold;
        if (i == -1 && this.italic == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public TtmlStyle setLinethrough(boolean z) {
        this.linethrough = z ? 1 : 0;
        return this;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    public TtmlStyle setUnderline(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public TtmlStyle setBold(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public TtmlStyle setItalic(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public TtmlStyle setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public int getFontColor() {
        if (!this.hasFontColor) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.fontColor;
    }

    public TtmlStyle setFontColor(int fontColor) {
        this.fontColor = fontColor;
        this.hasFontColor = true;
        return this;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    public int getBackgroundColor() {
        if (!this.hasBackgroundColor) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public TtmlStyle setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.hasBackgroundColor = true;
        return this;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public TtmlStyle chain(TtmlStyle ancestor) {
        return inherit(ancestor, true);
    }

    private TtmlStyle inherit(TtmlStyle ancestor, boolean chaining) {
        int i;
        int i2;
        Layout.Alignment alignment;
        String str;
        if (ancestor != null) {
            if (!this.hasFontColor && ancestor.hasFontColor) {
                setFontColor(ancestor.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ancestor.bold;
            }
            if (this.italic == -1) {
                this.italic = ancestor.italic;
            }
            if (this.fontFamily == null && (str = ancestor.fontFamily) != null) {
                this.fontFamily = str;
            }
            if (this.linethrough == -1) {
                this.linethrough = ancestor.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ancestor.underline;
            }
            if (this.rubyPosition == -1) {
                this.rubyPosition = ancestor.rubyPosition;
            }
            if (this.textAlign == null && (alignment = ancestor.textAlign) != null) {
                this.textAlign = alignment;
            }
            if (this.textCombine == -1) {
                this.textCombine = ancestor.textCombine;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ancestor.fontSizeUnit;
                this.fontSize = ancestor.fontSize;
            }
            if (chaining && !this.hasBackgroundColor && ancestor.hasBackgroundColor) {
                setBackgroundColor(ancestor.backgroundColor);
            }
            if (chaining && this.rubyType == -1 && (i2 = ancestor.rubyType) != -1) {
                this.rubyType = i2;
            }
            if (chaining && this.verticalType == Integer.MIN_VALUE && (i = ancestor.verticalType) != Integer.MIN_VALUE) {
                setVerticalType(i);
            }
        }
        return this;
    }

    public TtmlStyle setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public TtmlStyle setRubyType(int rubyType) {
        this.rubyType = rubyType;
        return this;
    }

    public int getRubyType() {
        return this.rubyType;
    }

    public TtmlStyle setRubyPosition(int position) {
        this.rubyPosition = position;
        return this;
    }

    public int getRubyPosition() {
        return this.rubyPosition;
    }

    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public TtmlStyle setTextAlign(Layout.Alignment textAlign) {
        this.textAlign = textAlign;
        return this;
    }

    public boolean getTextCombine() {
        return this.textCombine == 1;
    }

    public TtmlStyle setTextCombine(boolean z) {
        this.textCombine = z ? 1 : 0;
        return this;
    }

    public TtmlStyle setFontSize(float fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public TtmlStyle setFontSizeUnit(int fontSizeUnit) {
        this.fontSizeUnit = fontSizeUnit;
        return this;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public TtmlStyle setVerticalType(int verticalType) {
        this.verticalType = verticalType;
        return this;
    }

    public int getVerticalType() {
        return this.verticalType;
    }
}
