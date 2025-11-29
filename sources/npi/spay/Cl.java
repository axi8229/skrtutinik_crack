package npi.spay;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$color;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$styleable;

/* loaded from: classes4.dex */
public final class Cl extends FrameLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public TextView a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        float f;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SpayOtpTextView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.SpayOtpTextView)");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(context, "<this>");
        float fApplyDimension = (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Intrinsics.checkNotNullParameter(context2, "<this>");
        float fApplyDimension2 = (int) TypedValue.applyDimension(1, 24.0f, context2.getResources().getDisplayMetrics());
        int i = R$styleable.SpayOtpTextView_android_textColor;
        Resources resources = getContext().getResources();
        int i2 = R$color.spay_otp_code_input_text_color;
        int color = typedArrayObtainStyledAttributes.getColor(i, ResourcesCompat.getColor(resources, i2, null));
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.SpayOtpTextView_spay_bar_height, fApplyDimension);
        int i3 = R$styleable.SpayOtpTextView_spay_bar_margin;
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(i3, AbstractC1977v0.a(r10, 0));
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.SpayOtpTextView_spay_bar_margin_bottom, 2.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(R$styleable.SpayOtpTextView_spay_bar_margin_right, 2.0f);
        float dimension5 = typedArrayObtainStyledAttributes.getDimension(R$styleable.SpayOtpTextView_spay_bar_margin_left, 2.0f);
        float dimension6 = typedArrayObtainStyledAttributes.getDimension(R$styleable.SpayOtpTextView_spay_bar_margin_top, 2.0f);
        this.j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SpayOtpTextView_spay_hide_otp, false);
        this.f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayOtpTextView_spay_hide_otp_drawable, R$drawable.spay_masked_pin);
        int i4 = R$styleable.SpayOtpTextView_spay_hide_otp_error_drawable;
        this.g = typedArrayObtainStyledAttributes.getResourceId(i4, R$drawable.spay_pin);
        Resources resources2 = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
        int i5 = R$color.spay_transparent;
        this.h = M0.a(resources2, i5);
        this.i = typedArrayObtainStyledAttributes.getResourceId(i4, R$drawable.spay_error_pin);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SpayOtpTextView_spay_bar_enabled, false);
        float dimension7 = typedArrayObtainStyledAttributes.getDimension(R$styleable.SpayOtpTextView_spay_otp_text_size, fApplyDimension2);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.SpayOtpTextView_spay_text_typeface);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayOtpTextView_spay_otp_box_background, i5);
        this.b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayOtpTextView_spay_otp_box_background_active, resourceId);
        this.c = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayOtpTextView_spay_otp_box_background_inactive, resourceId);
        this.d = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayOtpTextView_spay_otp_box_background_success, resourceId);
        this.e = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SpayOtpTextView_spay_otp_box_background_error, resourceId);
        int i6 = R$styleable.SpayOtpTextView_spay_bar_active_color;
        Resources resources3 = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "context.resources");
        typedArrayObtainStyledAttributes.getColor(i6, M0.a(resources3, R$color.spay_main_text_color));
        int i7 = R$styleable.SpayOtpTextView_spay_bar_inactive_color;
        Resources resources4 = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources4, "context.resources");
        typedArrayObtainStyledAttributes.getColor(i7, M0.a(resources4, R$color.spay_otp_code_input_hint_color));
        int i8 = R$styleable.SpayOtpTextView_spay_bar_error_color;
        Resources resources5 = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources5, "context.resources");
        typedArrayObtainStyledAttributes.getColor(i8, M0.a(resources5, R$color.spay_otp_code_error_text_color));
        int i9 = R$styleable.SpayOtpTextView_spay_bar_success_color;
        Resources resources6 = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources6, "context.resources");
        typedArrayObtainStyledAttributes.getColor(i9, M0.a(resources6, i2));
        setBackgroundResource(resourceId);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        this.a = textView;
        textView.setGravity(17);
        if (string != null) {
            try {
                Typeface typefaceCreateFromAsset = Typeface.createFromAsset(getContext().getAssets(), string);
                TextView textView2 = this.a;
                if (textView2 != null) {
                    textView2.setTypeface(typefaceCreateFromAsset);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TextView textView3 = this.a;
        if (textView3 != null) {
            textView3.setTextColor(color);
        }
        TextView textView4 = this.a;
        if (textView4 != null) {
            textView4.setTextSize(0, dimension7);
        }
        addView(this.a, layoutParams);
        if (z) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) dimension);
            layoutParams2.gravity = 80;
            if (dimension2 == 0.0f) {
                f = dimension3;
                dimension2 = dimension6;
            } else {
                f = dimension2;
                dimension4 = f;
                dimension5 = dimension4;
            }
            layoutParams2.leftMargin = (int) dimension5;
            layoutParams2.rightMargin = (int) dimension4;
            layoutParams2.bottomMargin = (int) f;
            layoutParams2.topMargin = (int) dimension2;
            addView((View) null, layoutParams2);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void setViewState(int i) {
        int i2;
        if (i == -1) {
            i2 = this.e;
        } else if (i == 0) {
            i2 = this.c;
        } else if (i == 1) {
            i2 = this.b;
        } else if (i != 2) {
            return;
        } else {
            i2 = this.d;
        }
        setBackgroundResource(i2);
    }

    public final void a(final String value, boolean z, final boolean z2, boolean z3) {
        TextView textView;
        int i;
        TextView textView2;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!this.j && (textView2 = this.a) != null) {
            textView2.setText(value);
            return;
        }
        if (z3 && Intrinsics.areEqual(value, "")) {
            textView = this.a;
            if (textView == null) {
                return;
            } else {
                i = this.g;
            }
        } else {
            if (!z3 || Intrinsics.areEqual(value, "")) {
                if (z) {
                    TextView textView3 = this.a;
                    if (textView3 != null) {
                        textView3.setBackgroundResource(this.h);
                    }
                    TextView textView4 = this.a;
                    if (textView4 != null) {
                        textView4.setText(value);
                    }
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: npi.spay.Cl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Cl.a(this.f$0, value, z2);
                    }
                }, 300L);
                return;
            }
            textView = this.a;
            if (textView == null) {
                return;
            } else {
                i = this.f;
            }
        }
        textView.setBackgroundResource(i);
    }

    public static final void a(Cl this$0, String value, boolean z) {
        TextView textView;
        int i;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(value, "$value");
        TextView textView2 = this$0.a;
        if (textView2 != null) {
            textView2.setText("");
        }
        if (Intrinsics.areEqual(value, "") && z) {
            textView = this$0.a;
            if (textView == null) {
                return;
            } else {
                i = this$0.i;
            }
        } else if (!Intrinsics.areEqual(value, "") || z) {
            textView = this$0.a;
            if (textView == null) {
                return;
            } else {
                i = this$0.f;
            }
        } else {
            textView = this$0.a;
            if (textView == null) {
                return;
            } else {
                i = this$0.g;
            }
        }
        textView.setBackgroundResource(i);
    }
}
