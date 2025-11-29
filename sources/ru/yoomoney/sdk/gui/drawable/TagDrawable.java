package ru.yoomoney.sdk.gui.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TagDrawable.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001e¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/gui/drawable/TagDrawable;", "Landroid/graphics/drawable/Drawable;", "", "bgColor", "<init>", "(I)V", "Lru/yoomoney/sdk/gui/drawable/TagDrawable$ColorState;", "state", "(Lru/yoomoney/sdk/gui/drawable/TagDrawable$ColorState;)V", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "alpha", "setAlpha", "getOpacity", "()I", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "Lru/yoomoney/sdk/gui/drawable/TagDrawable$ColorState;", "ColorState", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TagDrawable extends Drawable {
    private final Paint paint;
    private final ColorState state;

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        return -1;
    }

    public TagDrawable(int i) {
        this.paint = new Paint(1);
        this.state = new ColorState(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TagDrawable(ColorState state) {
        this(state.getColor());
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float fHeight = getBounds().height() / 2.0f;
        this.paint.setColor(this.state.getColor());
        canvas.drawRoundRect(new RectF(getBounds()), fHeight, fHeight, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        ColorState colorState = this.state;
        Intrinsics.checkNotNull(colorState, "null cannot be cast to non-null type android.graphics.drawable.Drawable.ConstantState");
        return colorState;
    }

    /* compiled from: TagDrawable.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/gui/drawable/TagDrawable$ColorState;", "Landroid/graphics/drawable/Drawable$ConstantState;", RemoteMessageConst.Notification.COLOR, "", "(I)V", "getColor", "()I", "getChangingConfigurations", "newDrawable", "Lru/yoomoney/sdk/gui/drawable/TagDrawable;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ColorState extends Drawable.ConstantState {
        private final int color;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public ColorState(int i) {
            this.color = i;
        }

        public final int getColor() {
            return this.color;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public TagDrawable newDrawable() {
            return new TagDrawable(this);
        }
    }
}
