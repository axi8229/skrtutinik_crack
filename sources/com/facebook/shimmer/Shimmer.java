package com.facebook.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public class Shimmer {
    long repeatDelay;
    final float[] positions = new float[4];
    final int[] colors = new int[4];
    final RectF bounds = new RectF();
    int direction = 0;
    int highlightColor = -1;
    int baseColor = 1291845631;
    int shape = 0;
    int fixedWidth = 0;
    int fixedHeight = 0;
    float widthRatio = 1.0f;
    float heightRatio = 1.0f;
    float intensity = 0.0f;
    float dropoff = 0.5f;
    float tilt = 20.0f;
    boolean clipToChildren = true;
    boolean autoStart = true;
    boolean alphaShimmer = true;
    int repeatCount = -1;
    int repeatMode = 1;
    long animationDuration = 1000;

    Shimmer() {
    }

    int width(int i) {
        int i2 = this.fixedWidth;
        return i2 > 0 ? i2 : Math.round(this.widthRatio * i);
    }

    int height(int i) {
        int i2 = this.fixedHeight;
        return i2 > 0 ? i2 : Math.round(this.heightRatio * i);
    }

    void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i = this.baseColor;
            iArr[0] = i;
            int i2 = this.highlightColor;
            iArr[1] = i2;
            iArr[2] = i2;
            iArr[3] = i;
            return;
        }
        int[] iArr2 = this.colors;
        int i3 = this.highlightColor;
        iArr2[0] = i3;
        iArr2[1] = i3;
        int i4 = this.baseColor;
        iArr2[2] = i4;
        iArr2[3] = i4;
    }

    void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f);
            this.positions[1] = Math.max(((1.0f - this.intensity) - 0.001f) / 2.0f, 0.0f);
            this.positions[2] = Math.min(((this.intensity + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    public static abstract class Builder<T extends Builder<T>> {
        final Shimmer mShimmer = new Shimmer();

        protected abstract T getThis();

        T consumeAttributes(TypedArray typedArray) {
            int i = R$styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i)) {
                setClipToChildren(typedArray.getBoolean(i, this.mShimmer.clipToChildren));
            }
            int i2 = R$styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i2)) {
                setAutoStart(typedArray.getBoolean(i2, this.mShimmer.autoStart));
            }
            int i3 = R$styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i3)) {
                setBaseAlpha(typedArray.getFloat(i3, 0.3f));
            }
            int i4 = R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i4)) {
                setHighlightAlpha(typedArray.getFloat(i4, 1.0f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_duration)) {
                setDuration(typedArray.getInt(r0, (int) this.mShimmer.animationDuration));
            }
            int i5 = R$styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i5)) {
                setRepeatCount(typedArray.getInt(i5, this.mShimmer.repeatCount));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                setRepeatDelay(typedArray.getInt(r0, (int) this.mShimmer.repeatDelay));
            }
            int i6 = R$styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i6)) {
                setRepeatMode(typedArray.getInt(i6, this.mShimmer.repeatMode));
            }
            int i7 = R$styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i7)) {
                int i8 = typedArray.getInt(i7, this.mShimmer.direction);
                if (i8 == 1) {
                    setDirection(1);
                } else if (i8 == 2) {
                    setDirection(2);
                } else if (i8 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            int i9 = R$styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i9)) {
                if (typedArray.getInt(i9, this.mShimmer.shape) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            int i10 = R$styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i10)) {
                setDropoff(typedArray.getFloat(i10, this.mShimmer.dropoff));
            }
            int i11 = R$styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i11)) {
                setFixedWidth(typedArray.getDimensionPixelSize(i11, this.mShimmer.fixedWidth));
            }
            int i12 = R$styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i12)) {
                setFixedHeight(typedArray.getDimensionPixelSize(i12, this.mShimmer.fixedHeight));
            }
            int i13 = R$styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i13)) {
                setIntensity(typedArray.getFloat(i13, this.mShimmer.intensity));
            }
            int i14 = R$styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i14)) {
                setWidthRatio(typedArray.getFloat(i14, this.mShimmer.widthRatio));
            }
            int i15 = R$styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i15)) {
                setHeightRatio(typedArray.getFloat(i15, this.mShimmer.heightRatio));
            }
            int i16 = R$styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i16)) {
                setTilt(typedArray.getFloat(i16, this.mShimmer.tilt));
            }
            return (T) getThis();
        }

        public T setDirection(int i) {
            this.mShimmer.direction = i;
            return (T) getThis();
        }

        public T setShape(int i) {
            this.mShimmer.shape = i;
            return (T) getThis();
        }

        public T setFixedWidth(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Given invalid width: " + i);
            }
            this.mShimmer.fixedWidth = i;
            return (T) getThis();
        }

        public T setFixedHeight(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Given invalid height: " + i);
            }
            this.mShimmer.fixedHeight = i;
            return (T) getThis();
        }

        public T setWidthRatio(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid width ratio: " + f);
            }
            this.mShimmer.widthRatio = f;
            return (T) getThis();
        }

        public T setHeightRatio(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid height ratio: " + f);
            }
            this.mShimmer.heightRatio = f;
            return (T) getThis();
        }

        public T setIntensity(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid intensity value: " + f);
            }
            this.mShimmer.intensity = f;
            return (T) getThis();
        }

        public T setDropoff(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid dropoff value: " + f);
            }
            this.mShimmer.dropoff = f;
            return (T) getThis();
        }

        public T setTilt(float f) {
            this.mShimmer.tilt = f;
            return (T) getThis();
        }

        public T setBaseAlpha(float f) {
            int iClamp = (int) (clamp(0.0f, 1.0f, f) * 255.0f);
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (iClamp << 24) | (shimmer.baseColor & 16777215);
            return (T) getThis();
        }

        public T setHighlightAlpha(float f) {
            int iClamp = (int) (clamp(0.0f, 1.0f, f) * 255.0f);
            Shimmer shimmer = this.mShimmer;
            shimmer.highlightColor = (iClamp << 24) | (shimmer.highlightColor & 16777215);
            return (T) getThis();
        }

        public T setClipToChildren(boolean z) {
            this.mShimmer.clipToChildren = z;
            return (T) getThis();
        }

        public T setAutoStart(boolean z) {
            this.mShimmer.autoStart = z;
            return (T) getThis();
        }

        public T setRepeatCount(int i) {
            this.mShimmer.repeatCount = i;
            return (T) getThis();
        }

        public T setRepeatMode(int i) {
            this.mShimmer.repeatMode = i;
            return (T) getThis();
        }

        public T setRepeatDelay(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("Given a negative repeat delay: " + j);
            }
            this.mShimmer.repeatDelay = j;
            return (T) getThis();
        }

        public T setDuration(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("Given a negative duration: " + j);
            }
            this.mShimmer.animationDuration = j;
            return (T) getThis();
        }

        public Shimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        private static float clamp(float f, float f2, float f3) {
            return Math.min(f2, Math.max(f, f3));
        }
    }

    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public AlphaHighlightBuilder getThis() {
            return this;
        }

        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }
    }

    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        public ColorHighlightBuilder setHighlightColor(int i) {
            this.mShimmer.highlightColor = i;
            return getThis();
        }

        public ColorHighlightBuilder setBaseColor(int i) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (i & 16777215) | (shimmer.baseColor & (-16777216));
            return getThis();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            int i = R$styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i)) {
                setBaseColor(typedArray.getColor(i, this.mShimmer.baseColor));
            }
            int i2 = R$styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i2)) {
                setHighlightColor(typedArray.getColor(i2, this.mShimmer.highlightColor));
            }
            return getThis();
        }
    }
}
