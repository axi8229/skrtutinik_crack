package com.sputnik.common.ui.view.onboarding;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.view.onboarding.animation.AnimationFactory;
import com.sputnik.common.ui.view.onboarding.animation.AnimationListener;
import com.sputnik.common.ui.view.onboarding.shapes.Circle;
import com.sputnik.common.ui.view.onboarding.shapes.Focus;
import com.sputnik.common.ui.view.onboarding.shapes.Shape;
import com.sputnik.common.ui.view.onboarding.shapes.ShapeType;
import com.sputnik.common.ui.view.onboarding.target.Target;
import com.sputnik.common.ui.view.onboarding.target.ViewTarget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingView.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 y2\u00020\u0001:\u0002zyB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0016J\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u0016J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010$J\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0012H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\t2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\t2\u0006\u0010(\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010$J\u0017\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u0012H\u0002¢\u0006\u0004\b<\u0010-J\u0017\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010$J\u0017\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bC\u0010BJ\u0017\u0010D\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bD\u0010BJ\u0017\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0012H\u0002¢\u0006\u0004\bF\u0010-J\u0017\u0010I\u001a\u00020\t2\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\t2\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u0012H\u0002¢\u0006\u0004\bP\u0010-R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010QR\u0016\u0010%\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010SR\u0016\u0010T\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010UR\u0016\u0010W\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010SR\u0018\u0010X\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010fR\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010QR\u0016\u0010g\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010QR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010QR\u0016\u0010;\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010UR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010nR\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010QR\u0016\u0010q\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010UR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010rR\u0016\u0010s\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010UR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010tR\u0016\u0010O\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010UR\u0016\u0010u\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010UR\u0016\u0010v\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010U¨\u0006{"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/OnboardingView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "dismiss", "()V", "Lcom/sputnik/common/ui/view/onboarding/OnboardingViewConfiguration;", "configuration", "setConfiguration", "(Lcom/sputnik/common/ui/view/onboarding/OnboardingViewConfiguration;)V", "init", "Landroid/app/Activity;", "activity", "show", "(Landroid/app/Activity;)V", "removeOnboardingView", "setInfoLayout", "maskColor", "setMaskColor", "(I)V", "delayMillis", "setDelay", "Lcom/sputnik/common/ui/view/onboarding/shapes/ShapeType;", "shape", "setShapeType", "(Lcom/sputnik/common/ui/view/onboarding/shapes/ShapeType;)V", "_isReady", "setReady", "(Z)V", "Lcom/sputnik/common/ui/view/onboarding/target/Target;", "target", "setTarget", "(Lcom/sputnik/common/ui/view/onboarding/target/Target;)V", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "focusType", "setFocusType", "(Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;)V", "Lcom/sputnik/common/ui/view/onboarding/shapes/Shape;", "setShape", "(Lcom/sputnik/common/ui/view/onboarding/shapes/Shape;)V", "padding", "setPadding", "dismissOnTouch", "setDismissOnTouch", "colorTextViewInfo", "setColorTextViewInfo", "", "textViewInfo", "setTextViewTitle", "(Ljava/lang/CharSequence;)V", "setTextViewSubtitle", "setButtonText", "idempotent", "setIdempotent", "", "viewId", "setUsageId", "(Ljava/lang/String;)V", "Lcom/sputnik/common/ui/view/onboarding/OnboardingViewListener;", "onboardingViewListener", "setListener", "(Lcom/sputnik/common/ui/view/onboarding/OnboardingViewListener;)V", "isPerformClick", "setPerformClick", "I", "", "J", "isReady", "Z", "isFadeAnimationEnabled", "fadeAnimationDuration", "targetShape", "Lcom/sputnik/common/ui/view/onboarding/shapes/Shape;", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "targetView", "Lcom/sputnik/common/ui/view/onboarding/target/Target;", "Landroid/graphics/Paint;", "eraser", "Landroid/graphics/Paint;", "Landroid/os/Handler;", "_handler", "Landroid/os/Handler;", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/Canvas;", "_width", "_height", "Landroid/view/View;", "infoView", "Landroid/view/View;", "Landroid/widget/TextView;", "textViewTitle", "Landroid/widget/TextView;", "textViewSubtitle", "buttonOk", "isImageViewEnabled", "Ljava/lang/String;", "isLayoutCompleted", "Lcom/sputnik/common/ui/view/onboarding/OnboardingViewListener;", "isIdempotent", "shapeType", "Lcom/sputnik/common/ui/view/onboarding/shapes/ShapeType;", "usesCustomShape", "Companion", "Builder", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnboardingView extends RelativeLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Handler _handler;
    private int _height;
    private int _width;
    private Bitmap bitmap;
    private TextView buttonOk;
    private Canvas canvas;
    private int colorTextViewInfo;
    private long delayMillis;
    private boolean dismissOnTouch;
    private Paint eraser;
    private long fadeAnimationDuration;
    private Focus focusType;
    private View infoView;
    private boolean isFadeAnimationEnabled;
    private boolean isIdempotent;
    private boolean isImageViewEnabled;
    private boolean isLayoutCompleted;
    private boolean isPerformClick;
    private boolean isReady;
    private int maskColor;
    private OnboardingViewListener onboardingViewListener;
    private int padding;
    private ShapeType shapeType;
    private Shape targetShape;
    private Target targetView;
    private TextView textViewSubtitle;
    private TextView textViewTitle;
    private boolean usesCustomShape;
    private String viewId;

    public final void setConfiguration(OnboardingViewConfiguration configuration) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFadeAnimationEnabled = true;
        this.shapeType = ShapeType.CIRCLE;
        init(context);
    }

    private final void init(Context context) {
        setWillNotDraw(false);
        setVisibility(4);
        Constants constants = Constants.INSTANCE;
        this.maskColor = constants.getDEFAULT_MASK_COLOR();
        this.delayMillis = constants.getDEFAULT_DELAY_MILLIS();
        this.fadeAnimationDuration = constants.getDEFAULT_FADE_DURATION();
        this.padding = constants.getDEFAULT_TARGET_PADDING();
        this.colorTextViewInfo = constants.getDEFAULT_COLOR_TEXTVIEW_INFO();
        this.focusType = Focus.ALL;
        this.shapeType = ShapeType.CIRCLE;
        this.isReady = false;
        this.dismissOnTouch = false;
        this.isLayoutCompleted = false;
        this.isPerformClick = false;
        this.isImageViewEnabled = true;
        this.isIdempotent = false;
        this._handler = new Handler();
        Paint paint = new Paint();
        this.eraser = paint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(-1);
        Paint paint2 = this.eraser;
        Intrinsics.checkNotNull(paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint3 = this.eraser;
        Intrinsics.checkNotNull(paint3);
        paint3.setFlags(1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_onboarding, (ViewGroup) null);
        this.infoView = viewInflate.findViewById(R$id.info_layout);
        this.textViewTitle = (TextView) viewInflate.findViewById(R$id.tv_title);
        this.textViewSubtitle = (TextView) viewInflate.findViewById(R$id.tv_subtitle);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_ok);
        this.buttonOk = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.ui.view.onboarding.OnboardingView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnboardingView.init$lambda$0(this.f$0, view);
                }
            });
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sputnik.common.ui.view.onboarding.OnboardingView.init.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Shape shape = OnboardingView.this.targetShape;
                Intrinsics.checkNotNull(shape);
                shape.reCalculateAll();
                if (OnboardingView.this.targetShape != null) {
                    Shape shape2 = OnboardingView.this.targetShape;
                    Intrinsics.checkNotNull(shape2);
                    Point circlePoint = shape2.getCirclePoint();
                    if ((circlePoint == null || circlePoint.y != 0) && !OnboardingView.this.isLayoutCompleted) {
                        OnboardingView.this.setInfoLayout();
                        OnboardingView.INSTANCE.removeOnGlobalLayoutListener(OnboardingView.this, this);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(OnboardingView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this._width = getMeasuredWidth();
        this._height = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isReady) {
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                if (bitmap != null) {
                    Intrinsics.checkNotNull(bitmap);
                    bitmap.recycle();
                }
                this.bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Bitmap bitmap2 = this.bitmap;
                Intrinsics.checkNotNull(bitmap2);
                this.canvas = new Canvas(bitmap2);
            }
            Canvas canvas2 = this.canvas;
            Intrinsics.checkNotNull(canvas2);
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            Canvas canvas3 = this.canvas;
            Intrinsics.checkNotNull(canvas3);
            canvas3.drawColor(this.maskColor);
            Shape shape = this.targetShape;
            Intrinsics.checkNotNull(shape);
            shape.draw(this.canvas, this.eraser, this.padding);
            Bitmap bitmap3 = this.bitmap;
            Intrinsics.checkNotNull(bitmap3);
            canvas.drawBitmap(bitmap3, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.getX();
        event.getY();
        Target target = this.targetView;
        Intrinsics.checkNotNull(target);
        View view = target.getView();
        if (view == null) {
            return true;
        }
        view.invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void show(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(this);
        setReady(true);
        Handler handler = getHandler();
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.sputnik.common.ui.view.onboarding.OnboardingView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    OnboardingView.show$lambda$1(this.f$0);
                }
            }, this.delayMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1(final OnboardingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimationFactory.INSTANCE.animateFadeIn(this$0, this$0.fadeAnimationDuration, new Function0<Unit>() { // from class: com.sputnik.common.ui.view.onboarding.OnboardingView$show$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.setVisibility(0);
            }
        });
    }

    public final void dismiss() {
        AnimationFactory.INSTANCE.animateFadeOut(this, this.fadeAnimationDuration, new AnimationListener() { // from class: com.sputnik.common.ui.view.onboarding.OnboardingView.dismiss.1
            @Override // com.sputnik.common.ui.view.onboarding.animation.AnimationListener
            public void onAnimationEnd() {
                OnboardingViewListener onboardingViewListener;
                ViewKt.gone(OnboardingView.this);
                OnboardingView.this.removeOnboardingView();
                if (OnboardingView.this.onboardingViewListener == null || (onboardingViewListener = OnboardingView.this.onboardingViewListener) == null) {
                    return;
                }
                onboardingViewListener.onDismissed(OnboardingView.this.viewId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeOnboardingView() {
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInfoLayout() {
        Handler handler = getHandler();
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.sputnik.common.ui.view.onboarding.OnboardingView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                OnboardingView.setInfoLayout$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setInfoLayout$lambda$2(OnboardingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isLayoutCompleted = true;
        View view = this$0.infoView;
        Intrinsics.checkNotNull(view);
        if (view.getParent() != null) {
            View view2 = this$0.infoView;
            Intrinsics.checkNotNull(view2);
            ViewParent parent = view2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this$0.infoView);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        Shape shape = this$0.targetShape;
        Intrinsics.checkNotNull(shape);
        Point circlePoint = shape.getCirclePoint();
        Intrinsics.checkNotNull(circlePoint);
        if (circlePoint.y < this$0.getHeight() / 2) {
            RelativeLayout relativeLayout = (RelativeLayout) this$0.infoView;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setGravity(48);
            Shape shape2 = this$0.targetShape;
            Intrinsics.checkNotNull(shape2);
            Point circlePoint2 = shape2.getCirclePoint();
            Intrinsics.checkNotNull(circlePoint2);
            int i = circlePoint2.y;
            Shape shape3 = this$0.targetShape;
            Intrinsics.checkNotNull(shape3);
            layoutParams.setMargins(0, i + (shape3.getHeight() / 2), 0, 0);
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) this$0.infoView;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setGravity(80);
            int height = this$0.getHeight();
            Shape shape4 = this$0.targetShape;
            Intrinsics.checkNotNull(shape4);
            Point circlePoint3 = shape4.getCirclePoint();
            Intrinsics.checkNotNull(circlePoint3);
            int i2 = circlePoint3.y;
            Shape shape5 = this$0.targetShape;
            Intrinsics.checkNotNull(shape5);
            int height2 = height - (i2 + (shape5.getHeight() / 2));
            Shape shape6 = this$0.targetShape;
            Intrinsics.checkNotNull(shape6);
            layoutParams.setMargins(0, 0, 0, height2 + ((shape6.getHeight() * 2) / 2));
        }
        View view3 = this$0.infoView;
        Intrinsics.checkNotNull(view3);
        view3.setLayoutParams(layoutParams);
        View view4 = this$0.infoView;
        Intrinsics.checkNotNull(view4);
        view4.postInvalidate();
        this$0.addView(this$0.infoView);
        View view5 = this$0.infoView;
        Intrinsics.checkNotNull(view5);
        view5.setVisibility(0);
    }

    private final void setMaskColor(int maskColor) {
        this.maskColor = maskColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDelay(int delayMillis) {
        this.delayMillis = delayMillis;
    }

    private final void setShapeType(ShapeType shape) {
        this.shapeType = shape;
    }

    private final void setReady(boolean _isReady) {
        this.isReady = _isReady;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTarget(Target target) {
        this.targetView = target;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFocusType(Focus focusType) {
        this.focusType = focusType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShape(Shape shape) {
        this.targetShape = shape;
    }

    private final void setPadding(int padding) {
        this.padding = padding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDismissOnTouch(boolean dismissOnTouch) {
        this.dismissOnTouch = dismissOnTouch;
    }

    private final void setColorTextViewInfo(int colorTextViewInfo) {
        this.colorTextViewInfo = colorTextViewInfo;
        TextView textView = this.textViewTitle;
        Intrinsics.checkNotNull(textView);
        textView.setTextColor(this.colorTextViewInfo);
        TextView textView2 = this.textViewSubtitle;
        Intrinsics.checkNotNull(textView2);
        textView2.setTextColor(this.colorTextViewInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextViewTitle(CharSequence textViewInfo) {
        TextView textView = this.textViewTitle;
        Intrinsics.checkNotNull(textView);
        textView.setText(textViewInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextViewSubtitle(CharSequence textViewInfo) {
        TextView textView = this.textViewSubtitle;
        Intrinsics.checkNotNull(textView);
        textView.setText(textViewInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setButtonText(CharSequence textViewInfo) {
        TextView textView = this.buttonOk;
        Intrinsics.checkNotNull(textView);
        textView.setText(textViewInfo);
    }

    private final void setIdempotent(boolean idempotent) {
        this.isIdempotent = idempotent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUsageId(String viewId) {
        this.viewId = viewId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setListener(OnboardingViewListener onboardingViewListener) {
        this.onboardingViewListener = onboardingViewListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPerformClick(boolean isPerformClick) {
        this.isPerformClick = isPerformClick;
    }

    /* compiled from: OnboardingView.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b$\u0010\u001aJ\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020%¢\u0006\u0004\b(\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010,¨\u0006-"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "delayMillis", "setDelayMillis", "(I)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "focusType", "setFocusType", "(Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "Landroid/view/View;", "view", "setTarget", "(Landroid/view/View;)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "", "infoText", "setTitleText", "(Ljava/lang/CharSequence;)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "setSubtitleText", "setButtonText", "", "dismissOnTouch", "(Z)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "", "usageId", "setUsageId", "(Ljava/lang/String;)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "Lcom/sputnik/common/ui/view/onboarding/OnboardingViewListener;", "onboardingViewListener", "setListener", "(Lcom/sputnik/common/ui/view/onboarding/OnboardingViewListener;)Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Builder;", "isPerformClick", "performClick", "Lcom/sputnik/common/ui/view/onboarding/OnboardingView;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lcom/sputnik/common/ui/view/onboarding/OnboardingView;", "show", "Landroid/app/Activity;", "onboardingView", "Lcom/sputnik/common/ui/view/onboarding/OnboardingView;", "Lcom/sputnik/common/ui/view/onboarding/shapes/Focus;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private final Activity activity;
        private final Focus focusType;
        private final OnboardingView onboardingView;

        public Builder(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activity = activity;
            this.onboardingView = new OnboardingView(activity);
            this.focusType = Focus.MINIMUM;
        }

        public final Builder setDelayMillis(int delayMillis) {
            this.onboardingView.setDelay(delayMillis);
            return this;
        }

        public final Builder setFocusType(Focus focusType) {
            Intrinsics.checkNotNullParameter(focusType, "focusType");
            this.onboardingView.setFocusType(focusType);
            return this;
        }

        public final Builder setTarget(View view) {
            OnboardingView onboardingView = this.onboardingView;
            Intrinsics.checkNotNull(view);
            onboardingView.setTarget(new ViewTarget(view));
            return this;
        }

        public final Builder setTitleText(CharSequence infoText) {
            Intrinsics.checkNotNullParameter(infoText, "infoText");
            this.onboardingView.setTextViewTitle(infoText);
            return this;
        }

        public final Builder setSubtitleText(CharSequence infoText) {
            Intrinsics.checkNotNullParameter(infoText, "infoText");
            this.onboardingView.setTextViewSubtitle(infoText);
            return this;
        }

        public final Builder setButtonText(CharSequence infoText) {
            Intrinsics.checkNotNullParameter(infoText, "infoText");
            this.onboardingView.setButtonText(infoText);
            return this;
        }

        public final Builder dismissOnTouch(boolean dismissOnTouch) {
            this.onboardingView.setDismissOnTouch(dismissOnTouch);
            return this;
        }

        public final Builder setUsageId(String usageId) {
            Intrinsics.checkNotNullParameter(usageId, "usageId");
            this.onboardingView.setUsageId(usageId);
            return this;
        }

        public final Builder setListener(OnboardingViewListener onboardingViewListener) {
            Intrinsics.checkNotNullParameter(onboardingViewListener, "onboardingViewListener");
            this.onboardingView.setListener(onboardingViewListener);
            return this;
        }

        public final Builder performClick(boolean isPerformClick) {
            this.onboardingView.setPerformClick(isPerformClick);
            return this;
        }

        public final OnboardingView build() {
            if (this.onboardingView.usesCustomShape) {
                return this.onboardingView;
            }
            this.onboardingView.setShape(new Circle(this.onboardingView.targetView, this.onboardingView.focusType, this.onboardingView.padding));
            return this.onboardingView;
        }

        public final OnboardingView show() {
            build().show(this.activity);
            return this.onboardingView;
        }
    }

    /* compiled from: OnboardingView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/common/ui/view/onboarding/OnboardingView$Companion;", "", "()V", "removeOnGlobalLayoutListener", "", "v", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void removeOnGlobalLayoutListener(View v, ViewTreeObserver.OnGlobalLayoutListener listener) {
            Intrinsics.checkNotNullParameter(v, "v");
            v.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
        }
    }
}
