package spay.sdk.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Fe;
import npi.spay.M0;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$styleable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lspay/sdk/view/SpayDotsLoaderView;", "Landroid/widget/LinearLayout;", "Landroid/view/animation/TranslateAnimation;", "getTranslateAnim", "", "d", "I", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SpayDotsLoaderView extends LinearLayout {
    public static final /* synthetic */ int m = 0;
    public int a;
    public int b;
    public int c;

    /* renamed from: d, reason: from kotlin metadata */
    public int dotsColor;
    public int e;
    public int f;
    public int g;
    public Fe h;
    public Fe i;
    public Fe j;
    public int k;
    public int l;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ SpayDotsLoaderView b;

        public a(SpayDotsLoaderView spayDotsLoaderView) {
            this.b = spayDotsLoaderView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            SpayDotsLoaderView spayDotsLoaderView = SpayDotsLoaderView.this;
            int i = SpayDotsLoaderView.m;
            spayDotsLoaderView.b();
            this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            SpayDotsLoaderView spayDotsLoaderView = SpayDotsLoaderView.this;
            int i = SpayDotsLoaderView.m;
            spayDotsLoaderView.b();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public SpayDotsLoaderView(Context context) {
        super(context);
        this.a = 500;
        new LinearInterpolator();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.dotsColor = M0.a(resources, R$color.spay_loader_dot_default);
        this.k = 100;
        this.l = 200;
        a();
    }

    private final TranslateAnimation getTranslateAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -(this.b * 3));
        translateAnimation.setDuration(this.a);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setInterpolator(translateAnimation.getInterpolator());
        return translateAnimation;
    }

    public final void a() {
        removeAllViews();
        removeAllViewsInLayout();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.h = new Fe(context, this.b, this.e);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.i = new Fe(context2, this.b, this.f);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.j = new Fe(context3, this.b, this.g);
        int i = this.b;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i * 2, i * 3);
        layoutParams.leftMargin = this.c;
        setVerticalGravity(80);
        View view = this.h;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCircle");
            view = null;
        }
        addView(view);
        View view3 = this.i;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCircle");
            view3 = null;
        }
        addView(view3, layoutParams);
        View view4 = this.j;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thirdCircle");
        } else {
            view2 = view4;
        }
        addView(view2, layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public final void b() {
        TranslateAnimation translateAnim = getTranslateAnim();
        Fe fe = this.h;
        if (fe == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCircle");
            fe = null;
        }
        fe.startAnimation(translateAnim);
        final TranslateAnimation translateAnim2 = getTranslateAnim();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: spay.sdk.view.SpayDotsLoaderView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SpayDotsLoaderView.a(this.f$0, translateAnim2);
            }
        }, this.k);
        final TranslateAnimation translateAnim3 = getTranslateAnim();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: spay.sdk.view.SpayDotsLoaderView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SpayDotsLoaderView.b(this.f$0, translateAnim3);
            }
        }, this.l);
        translateAnim3.setAnimationListener(new b());
    }

    public final int getDotsColor() {
        return this.dotsColor;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.b;
        setMeasuredDimension(((this.c * 2) + (i3 * 7)) * 2, i3 * 14);
    }

    public final void setDotsColor(int i) {
        this.dotsColor = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayDotsLoaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.a = 500;
        new LinearInterpolator();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.dotsColor = M0.a(resources, R$color.spay_loader_dot_default);
        this.k = 100;
        this.l = 200;
        a(attrs);
        a();
    }

    public static final void b(SpayDotsLoaderView this$0, TranslateAnimation trans3Anim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(trans3Anim, "$trans3Anim");
        Fe fe = this$0.j;
        if (fe == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thirdCircle");
            fe = null;
        }
        fe.startAnimation(trans3Anim);
    }

    public final void a(AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$styleable.SpayDotsLoaderView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…SpayDotsLoaderView, 0, 0)");
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SpayDotsLoaderView_spay_loader_dots_radius, getResources().getDimensionPixelSize(R$dimen.spay_loader_dot_size));
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SpayDotsLoaderView_spay_loader_dots_dist, getResources().getDimensionPixelSize(R$dimen.spay_loader_dot_distance));
        int i = R$styleable.SpayDotsLoaderView_spay_loader_first_dot_color;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int i2 = R$color.spay_loader_dot_default;
        this.e = typedArrayObtainStyledAttributes.getColor(i, M0.a(resources, i2));
        int i3 = R$styleable.SpayDotsLoaderView_spay_loader_second_dot_color;
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        this.f = typedArrayObtainStyledAttributes.getColor(i3, M0.a(resources2, i2));
        int i4 = R$styleable.SpayDotsLoaderView_spay_loader_third_dot_color;
        Resources resources3 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "resources");
        this.g = typedArrayObtainStyledAttributes.getColor(i4, M0.a(resources3, i2));
        typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SpayDotsLoaderView_spay_loader_dots_view_height, getResources().getDimensionPixelSize(R$dimen.spay_loader_dots_view_height));
        typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SpayDotsLoaderView_spay_loader_dots_view_width, getResources().getDimensionPixelSize(R$dimen.spay_loader_dots_view_width));
        this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.SpayDotsLoaderView_spay_loader_anim_duration, 500);
        Intrinsics.checkNotNullExpressionValue(AnimationUtils.loadInterpolator(getContext(), typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayDotsLoaderView_spay_loader_interpolator, R.anim.linear_interpolator)), "loadInterpolator(\n      …r\n            )\n        )");
        this.k = typedArrayObtainStyledAttributes.getInt(R$styleable.SpayDotsLoaderView_spay_loader_first_delay_duration, 100);
        this.l = typedArrayObtainStyledAttributes.getInt(R$styleable.SpayDotsLoaderView_spay_loader_second_delay_duration, 200);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayDotsLoaderView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.a = 500;
        new LinearInterpolator();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.dotsColor = M0.a(resources, R$color.spay_loader_dot_default);
        this.k = 100;
        this.l = 200;
        a(attrs);
        a();
    }

    public static final void a(SpayDotsLoaderView this$0, TranslateAnimation trans2Anim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(trans2Anim, "$trans2Anim");
        Fe fe = this$0.i;
        if (fe == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCircle");
            fe = null;
        }
        fe.startAnimation(trans2Anim);
    }
}
