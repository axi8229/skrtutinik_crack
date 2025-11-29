package com.github.razir.progressbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawableButtonExtensions.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u000e\u0010\r\u001a\u001b\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u000f\u001a#\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0014\u0010\u001a\u001a\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a/\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&\u001a9\u0010*\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010+\u001a\u001b\u0010.\u001a\u00020\u0017*\u00020\u001e2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Landroid/widget/TextView;", "Lkotlin/Function1;", "Lcom/github/razir/progressbutton/ProgressParams;", "", "params", "showProgress", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V", "", "isDrawableActive", "(Landroid/widget/TextView;)Z", "", "newText", "hideProgress", "(Landroid/widget/TextView;Ljava/lang/String;)V", "hideDrawable", "(Landroid/widget/TextView;Lcom/github/razir/progressbutton/ProgressParams;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/github/razir/progressbutton/DrawableParams;", "paramValues", "showDrawable", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Lcom/github/razir/progressbutton/DrawableParams;)V", "text", "", "gravity", "textMarginPx", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Ljava/lang/String;II)V", "textView", "setupDrawableCallback", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;)V", "Landroid/content/Context;", "context", "", "progressColors", "progressRadiusPx", "progressStrokePx", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "generateProgressDrawable", "(Landroid/content/Context;[III)Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "drawableMarginPx", "useTextAlpha", "Landroid/text/SpannableString;", "getDrawableSpannable", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;IIZ)Landroid/text/SpannableString;", "", "dpValue", "dpToPixels", "(Landroid/content/Context;F)I", "progressbutton_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class DrawableButtonExtensionsKt {
    public static final void showProgress(TextView showProgress, Function1<? super ProgressParams, Unit> params) {
        Intrinsics.checkParameterIsNotNull(showProgress, "$this$showProgress");
        Intrinsics.checkParameterIsNotNull(params, "params");
        ProgressParams progressParams = new ProgressParams();
        params.invoke(progressParams);
        showProgress(showProgress, progressParams);
    }

    public static final boolean isDrawableActive(TextView isDrawableActive) {
        Intrinsics.checkParameterIsNotNull(isDrawableActive, "$this$isDrawableActive");
        return ProgressButtonHolderKt.getActiveViews().containsKey(isDrawableActive);
    }

    public static final void hideProgress(TextView hideProgress, String str) {
        Intrinsics.checkParameterIsNotNull(hideProgress, "$this$hideProgress");
        hideDrawable(hideProgress, str);
    }

    public static final void hideDrawable(TextView hideDrawable, String str) {
        Intrinsics.checkParameterIsNotNull(hideDrawable, "$this$hideDrawable");
        ProgressButtonHolderKt.cleanUpDrawable(hideDrawable);
        if (ButtonTextAnimatorExtensionsKt.isAnimatorAttached(hideDrawable)) {
            ButtonTextAnimatorExtensionsKt.animateTextChange(hideDrawable, str);
        } else {
            hideDrawable.setText(str);
        }
    }

    public static final void showProgress(TextView showProgress, ProgressParams params) {
        int[] progressColors;
        Intrinsics.checkParameterIsNotNull(showProgress, "$this$showProgress");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Context context = showProgress.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        Resources resources = context.getResources();
        Integer progressStrokeRes = params.getProgressStrokeRes();
        int dimensionPixelSize = progressStrokeRes != null ? resources.getDimensionPixelSize(progressStrokeRes.intValue()) : params.getProgressStrokePx();
        Integer progressRadiusRes = params.getProgressRadiusRes();
        int dimensionPixelSize2 = progressRadiusRes != null ? resources.getDimensionPixelSize(progressRadiusRes.intValue()) : params.getProgressRadiusPx();
        if (params.getProgressColorRes() != null) {
            Context context2 = showProgress.getContext();
            Integer progressColorRes = params.getProgressColorRes();
            if (progressColorRes == null) {
                Intrinsics.throwNpe();
            }
            progressColors = new int[]{ContextCompat.getColor(context2, progressColorRes.intValue())};
        } else if (params.getProgressColor() != null) {
            Integer progressColor = params.getProgressColor();
            if (progressColor == null) {
                Intrinsics.throwNpe();
            }
            progressColors = new int[]{progressColor.intValue()};
        } else if (params.getProgressColors() != null) {
            progressColors = params.getProgressColors();
            if (progressColors == null) {
                Intrinsics.throwNpe();
            }
        } else {
            progressColors = new int[0];
        }
        Context context3 = showProgress.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, "context");
        showDrawable(showProgress, generateProgressDrawable(context3, progressColors, dimensionPixelSize2, dimensionPixelSize), params);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showDrawable(android.widget.TextView r3, android.graphics.drawable.Drawable r4, com.github.razir.progressbutton.DrawableParams r5) {
        /*
            java.lang.String r0 = "$this$showDrawable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "drawable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "paramValues"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.content.res.Resources r0 = r0.getResources()
            java.lang.Integer r1 = r5.getButtonTextRes()
            if (r1 == 0) goto L31
            int r1 = r1.intValue()
            android.content.Context r2 = r3.getContext()
            java.lang.String r1 = r2.getString(r1)
            if (r1 == 0) goto L31
            goto L35
        L31:
            java.lang.String r1 = r5.getButtonText()
        L35:
            java.lang.Integer r2 = r5.getTextMarginRes()
            if (r2 == 0) goto L44
            int r2 = r2.intValue()
            int r0 = r0.getDimensionPixelSize(r2)
            goto L48
        L44:
            int r0 = r5.getTextMarginPx()
        L48:
            int r5 = r5.getGravity()
            showDrawable(r3, r4, r1, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.razir.progressbutton.DrawableButtonExtensionsKt.showDrawable(android.widget.TextView, android.graphics.drawable.Drawable, com.github.razir.progressbutton.DrawableParams):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showDrawable(TextView textView, Drawable drawable, String str, int i, int i2) {
        if (isDrawableActive(textView)) {
            ProgressButtonHolderKt.cleanUpDrawable(textView);
        }
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (Intrinsics.areEqual(transformationMethod != null ? transformationMethod.getClass().getName() : null, "android.text.method.AllCapsTransformationMethod") || (textView.getTransformationMethod() instanceof AllCapsTransformationMethod)) {
            Context context = textView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            textView.setTransformationMethod(new AllCapsSpannedTransformationMethod(context));
        }
        if (i2 == -1) {
            Context context2 = textView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            i2 = dpToPixels(context2, 10.0f);
        }
        boolean zIsAnimatorAttached = ButtonTextAnimatorExtensionsKt.isAnimatorAttached(textView);
        SpannableString drawableSpannable = getDrawableSpannable(drawable, str, i, i2, zIsAnimatorAttached);
        if (zIsAnimatorAttached) {
            ButtonTextAnimatorExtensionsKt.animateTextChange(textView, drawableSpannable);
        } else {
            textView.setText(drawableSpannable);
        }
        ProgressButtonHolderKt.addDrawableAttachViewListener(textView);
        setupDrawableCallback(textView, drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void setupDrawableCallback(final TextView textView, Drawable drawable) {
        Drawable.Callback callback = new Drawable.Callback() { // from class: com.github.razir.progressbutton.DrawableButtonExtensionsKt$setupDrawableCallback$callback$1
            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable who, Runnable what, long when) {
                Intrinsics.checkParameterIsNotNull(who, "who");
                Intrinsics.checkParameterIsNotNull(what, "what");
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable who, Runnable what) {
                Intrinsics.checkParameterIsNotNull(who, "who");
                Intrinsics.checkParameterIsNotNull(what, "what");
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable who) {
                Intrinsics.checkParameterIsNotNull(who, "who");
                textView.invalidate();
            }
        };
        ProgressButtonHolderKt.getActiveViews().put(textView, new DrawableViewData(drawable, callback));
        drawable.setCallback(callback);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    private static final CircularProgressDrawable generateProgressDrawable(Context context, int[] iArr, int i, int i2) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStyle(1);
        if (!(iArr.length == 0)) {
            circularProgressDrawable.setColorSchemeColors(Arrays.copyOf(iArr, iArr.length));
        }
        if (i != -1) {
            circularProgressDrawable.setCenterRadius(i);
        }
        if (i2 != -1) {
            circularProgressDrawable.setStrokeWidth(i2);
        }
        int centerRadius = ((int) (circularProgressDrawable.getCenterRadius() + circularProgressDrawable.getStrokeWidth())) * 2;
        circularProgressDrawable.setBounds(0, 0, centerRadius, centerRadius);
        return circularProgressDrawable;
    }

    private static final SpannableString getDrawableSpannable(Drawable drawable, String str, int i, int i2, boolean z) {
        SpannableString spannableString;
        DrawableSpan drawableSpan = new DrawableSpan(drawable, 0, 0, z, 6, null);
        if (i == 0) {
            drawableSpan.setPaddingEnd(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            if (str == null) {
                str = "";
            }
            sb.append(str);
            spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(drawableSpan, 0, 1, 33);
        } else {
            if (i != 1) {
                if (i == 2) {
                    SpannableString spannableString2 = new SpannableString(" ");
                    spannableString2.setSpan(drawableSpan, 0, 1, 33);
                    return spannableString2;
                }
                throw new IllegalArgumentException("Please set the correct gravity");
            }
            drawableSpan.setPaddingStart(i2);
            StringBuilder sb2 = new StringBuilder();
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            sb2.append(' ');
            spannableString = new SpannableString(sb2.toString());
            spannableString.setSpan(drawableSpan, spannableString.length() - 1, spannableString.length(), 33);
        }
        return spannableString;
    }

    private static final int dpToPixels(Context context, float f) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
