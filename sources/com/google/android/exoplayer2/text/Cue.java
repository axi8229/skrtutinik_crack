package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class Cue {
    public static final Cue EMPTY = new Cue("");
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;

    @Deprecated
    public Cue(CharSequence text) {
        this(text, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    @Deprecated
    public Cue(CharSequence text, Layout.Alignment textAlignment, float line, int lineType, int lineAnchor, float position, int positionAnchor, float size) {
        this(text, textAlignment, line, lineType, lineAnchor, position, positionAnchor, size, false, -16777216);
    }

    @Deprecated
    public Cue(CharSequence text, Layout.Alignment textAlignment, float line, int lineType, int lineAnchor, float position, int positionAnchor, float size, boolean windowColorSet, int windowColor) {
        this(text, textAlignment, null, line, lineType, lineAnchor, position, positionAnchor, Integer.MIN_VALUE, -3.4028235E38f, size, -3.4028235E38f, windowColorSet, windowColor, Integer.MIN_VALUE);
    }

    private Cue(CharSequence text, Layout.Alignment textAlignment, Bitmap bitmap, float line, int lineType, int lineAnchor, float position, int positionAnchor, int textSizeType, float textSize, float size, float bitmapHeight, boolean windowColorSet, int windowColor, int verticalType) {
        if (text == null) {
            Assertions.checkNotNull(bitmap);
        } else {
            Assertions.checkArgument(bitmap == null);
        }
        this.text = text;
        this.textAlignment = textAlignment;
        this.bitmap = bitmap;
        this.line = line;
        this.lineType = lineType;
        this.lineAnchor = lineAnchor;
        this.position = position;
        this.positionAnchor = positionAnchor;
        this.size = size;
        this.bitmapHeight = bitmapHeight;
        this.windowColorSet = windowColorSet;
        this.windowColor = windowColor;
        this.textSizeType = textSizeType;
        this.textSize = textSize;
        this.verticalType = verticalType;
    }

    public static final class Builder {
        private CharSequence text = null;
        private Bitmap bitmap = null;
        private Layout.Alignment textAlignment = null;
        private float line = -3.4028235E38f;
        private int lineType = Integer.MIN_VALUE;
        private int lineAnchor = Integer.MIN_VALUE;
        private float position = -3.4028235E38f;
        private int positionAnchor = Integer.MIN_VALUE;
        private int textSizeType = Integer.MIN_VALUE;
        private float textSize = -3.4028235E38f;
        private float size = -3.4028235E38f;
        private float bitmapHeight = -3.4028235E38f;
        private boolean windowColorSet = false;
        private int windowColor = -16777216;
        private int verticalType = Integer.MIN_VALUE;

        public Builder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        public CharSequence getText() {
            return this.text;
        }

        public Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public Builder setTextAlignment(Layout.Alignment textAlignment) {
            this.textAlignment = textAlignment;
            return this;
        }

        public Builder setLine(float line, int lineType) {
            this.line = line;
            this.lineType = lineType;
            return this;
        }

        public Builder setLineAnchor(int lineAnchor) {
            this.lineAnchor = lineAnchor;
            return this;
        }

        public Builder setPosition(float position) {
            this.position = position;
            return this;
        }

        public Builder setPositionAnchor(int positionAnchor) {
            this.positionAnchor = positionAnchor;
            return this;
        }

        public Builder setTextSize(float textSize, int textSizeType) {
            this.textSize = textSize;
            this.textSizeType = textSizeType;
            return this;
        }

        public Builder setSize(float size) {
            this.size = size;
            return this;
        }

        public Builder setBitmapHeight(float bitmapHeight) {
            this.bitmapHeight = bitmapHeight;
            return this;
        }

        public Builder setVerticalType(int verticalType) {
            this.verticalType = verticalType;
            return this;
        }

        public Cue build() {
            return new Cue(this.text, this.textAlignment, this.bitmap, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.textSizeType, this.textSize, this.size, this.bitmapHeight, this.windowColorSet, this.windowColor, this.verticalType);
        }
    }
}
