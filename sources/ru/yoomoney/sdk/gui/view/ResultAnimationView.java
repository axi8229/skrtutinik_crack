package ru.yoomoney.sdk.gui.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;

/* compiled from: ResultAnimationView.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u001c\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00101\u001a\n **\u0004\u0018\u00010.0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010'R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010'R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010'R\u0016\u0010\u0015\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00109¨\u0006:"}, d2 = {"Lru/yoomoney/sdk/gui/view/ResultAnimationView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/content/res/TypedArray;", "a", "", "obtainAttrs", "(Landroid/content/res/TypedArray;)V", "Landroid/graphics/Canvas;", "canvas", "", "center", "drawCircle", "(Landroid/graphics/Canvas;F)V", "drawIcon", "drawIconOverlap", "onDraw", "(Landroid/graphics/Canvas;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "backgroundTint", "I", "getBackgroundTint", "()I", "setBackgroundTint", "(I)V", "iconTint", "getIconTint", "setIconTint", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "iconSizeDefault", "F", "circleSizeDefault", "Landroid/animation/PropertyValuesHolder;", "kotlin.jvm.PlatformType", "iconSizeHolder", "Landroid/animation/PropertyValuesHolder;", "circleSizeHolder", "Landroid/animation/ValueAnimator;", "iconAnimator", "Landroid/animation/ValueAnimator;", "overlapAnimator", "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat;", RemoteMessageConst.Notification.ICON, "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat;", "circleRadius", "iconSize", "overlapSize", "", "Z", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResultAnimationView extends View {
    private int backgroundTint;
    private float circleRadius;
    private final float circleSizeDefault;
    private final PropertyValuesHolder circleSizeHolder;
    private boolean drawIcon;
    private VectorDrawableCompat icon;
    private final ValueAnimator iconAnimator;
    private float iconSize;
    private final float iconSizeDefault;
    private final PropertyValuesHolder iconSizeHolder;
    private int iconTint;
    private final ValueAnimator overlapAnimator;
    private float overlapSize;
    private final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResultAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ResultAnimationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R$attr.ym_ProgressDialog_Style : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.backgroundTint = GuiContextExtensions.getThemedColor(context, R$attr.colorTint);
        this.iconTint = ContextCompat.getColor(context, R$color.color_white);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
        float fConvertDpToPx = GuiContextExtensions.convertDpToPx(context, 18.0f);
        this.iconSizeDefault = fConvertDpToPx;
        float fConvertDpToPx2 = GuiContextExtensions.convertDpToPx(context, 60.0f);
        this.circleSizeDefault = fConvertDpToPx2;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("iconSize", 0.0f, fConvertDpToPx);
        this.iconSizeHolder = propertyValuesHolderOfFloat;
        float f = 2;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("circleSize", 0.0f, fConvertDpToPx2 / f);
        this.circleSizeHolder = propertyValuesHolderOfFloat2;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat);
        valueAnimator.setInterpolator(new OvershootInterpolator());
        valueAnimator.setDuration(300L);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.yoomoney.sdk.gui.view.ResultAnimationView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ResultAnimationView.iconAnimator$lambda$2$lambda$1(this.f$0, valueAnimator2);
            }
        });
        this.iconAnimator = valueAnimator;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fConvertDpToPx / f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.yoomoney.sdk.gui.view.ResultAnimationView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ResultAnimationView.overlapAnimator$lambda$4$lambda$3(this.f$0, valueAnimator2);
            }
        });
        this.overlapAnimator = valueAnimatorOfFloat;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ym_ProgressDialog, i, 0);
        Intrinsics.checkNotNull(typedArrayObtainStyledAttributes);
        obtainAttrs(typedArrayObtainStyledAttributes);
    }

    public final int getBackgroundTint() {
        return this.backgroundTint;
    }

    public final void setBackgroundTint(int i) {
        this.backgroundTint = i;
        this.paint.setColor(i);
    }

    public final int getIconTint() {
        return this.iconTint;
    }

    public final void setIconTint(int i) {
        this.iconTint = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void iconAnimator$lambda$2$lambda$1(ResultAnimationView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue("circleSize");
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.circleRadius = ((Float) animatedValue).floatValue();
        Object animatedValue2 = it.getAnimatedValue("iconSize");
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        this$0.iconSize = ((Float) animatedValue2).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void overlapAnimator$lambda$4$lambda$3(ResultAnimationView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.overlapSize = ((Float) animatedValue).floatValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.icon != null) {
            float width = getWidth() / 2;
            drawCircle(canvas, width);
            drawIcon(canvas, width);
            drawIconOverlap(canvas, width);
        }
    }

    private final void obtainAttrs(TypedArray a) {
        setBackgroundTint(a.getColor(R$styleable.ym_ProgressDialog_ym_background_tint, this.backgroundTint));
        this.iconTint = a.getColor(R$styleable.ym_ProgressDialog_ym_icon_tint, this.iconTint);
    }

    private final void drawCircle(Canvas canvas, float center) {
        canvas.drawCircle(center, center, this.circleRadius, this.paint);
    }

    private final void drawIcon(Canvas canvas, float center) {
        VectorDrawableCompat vectorDrawableCompat;
        if (!this.drawIcon || (vectorDrawableCompat = this.icon) == null) {
            return;
        }
        float f = this.iconSize;
        int i = (int) (center - f);
        int i2 = (int) (center + f);
        vectorDrawableCompat.setBounds(i, i, i2, i2);
        DrawableExtensions.tint(vectorDrawableCompat, this.iconTint);
        vectorDrawableCompat.draw(canvas);
    }

    private final void drawIconOverlap(Canvas canvas, float center) {
        float f = (this.iconSize / 2) + 15;
        float f2 = center + f;
        canvas.drawRect(f2 - this.overlapSize, center - f, f2, f2, this.paint);
    }
}
