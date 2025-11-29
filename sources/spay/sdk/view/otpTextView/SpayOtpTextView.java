package spay.sdk.view.otpTextView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1977v0;
import npi.spay.C1454a0;
import npi.spay.C1525cl;
import npi.spay.C1676in;
import npi.spay.C2081z4;
import npi.spay.Cl;
import npi.spay.Lm;
import npi.spay.N7;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.R$styleable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b'\u0010+B#\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\b¢\u0006\u0004\b'\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006."}, d2 = {"Lspay/sdk/view/otpTextView/SpayOtpTextView;", "Landroid/widget/FrameLayout;", "Lnpi/spay/cl;", "spayOtpChildEditText", "", "setTextWatcher", "(Lnpi/spay/cl;)V", "setFocusDetection", "", "length", "setFocus", "(I)V", "", "s", "setOTP", "(Ljava/lang/CharSequence;)V", "", "otp", "(Ljava/lang/String;)V", "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Lnpi/spay/Lm;", "c", "Lnpi/spay/Lm;", "getSpayOtpListener", "()Lnpi/spay/Lm;", "setSpayOtpListener", "(Lnpi/spay/Lm;)V", "spayOtpListener", "Landroid/text/InputFilter;", "getFilter", "()Landroid/text/InputFilter;", "filter", "getOtp", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SpayOtpTextView extends FrameLayout {
    public ArrayList a;
    public C1525cl b;

    /* renamed from: c, reason: from kotlin metadata */
    public Lm spayOtpListener;
    public boolean d;
    public String e;
    public int f;

    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable s) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence s, int i, int i2, int i3) throws NoSuchAlgorithmException {
            Intrinsics.checkNotNullParameter(s, "s");
            SpayOtpTextView spayOtpTextView = SpayOtpTextView.this;
            if (i2 > i3) {
                C1525cl c1525cl = spayOtpTextView.b;
                if (c1525cl != null) {
                    c1525cl.setText(R$string.spay_empty_string);
                }
            } else {
                spayOtpTextView.setOTP(s);
                SpayOtpTextView.this.setFocus(s.length());
            }
            Lm spayOtpListener = SpayOtpTextView.this.getSpayOtpListener();
            if (spayOtpListener != null) {
                SpayOtpTextView spayOtpTextView2 = SpayOtpTextView.this;
                String code = s.toString();
                C1454a0 c1454a0 = (C1454a0) spayOtpListener;
                Intrinsics.checkNotNullParameter(code, "code");
                ((C2081z4) c1454a0.a.b()).a(new C1676in(code));
                if (s.length() == spayOtpTextView2.f) {
                    String otp = s.toString();
                    Intrinsics.checkNotNullParameter(otp, "otp");
                    ((C2081z4) c1454a0.a.b()).a(new C1676in(otp));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayOtpTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = "";
        a(null);
    }

    public static final CharSequence a(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            if (!Pattern.compile("[1234567890]*").matcher(String.valueOf(charSequence.charAt(i))).matches()) {
                return "";
            }
            i++;
        }
        return null;
    }

    private final InputFilter getFilter() {
        return new InputFilter() { // from class: spay.sdk.view.otpTextView.SpayOtpTextView$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return SpayOtpTextView.a(charSequence, i, i2, spanned, i3, i4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFocus(int length) {
        C1525cl c1525cl;
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i == length && (c1525cl = this.b) != null && c1525cl.isFocused()) {
                    ((Cl) arrayList.get(i)).setViewState(1);
                } else {
                    ((Cl) arrayList.get(i)).setViewState(0);
                }
            }
            if (length == arrayList.size()) {
                ((Cl) arrayList.get(arrayList.size() - 1)).setViewState(1);
            }
        }
    }

    private final void setFocusDetection(C1525cl spayOtpChildEditText) {
        if (spayOtpChildEditText == null) {
            return;
        }
        spayOtpChildEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: spay.sdk.view.otpTextView.SpayOtpTextView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SpayOtpTextView.a(this.f$0, view, z);
            }
        });
    }

    private final void setTextWatcher(C1525cl spayOtpChildEditText) {
        if (spayOtpChildEditText != null) {
            spayOtpChildEditText.addTextChangedListener(new a());
        }
    }

    public final String getOtp() {
        Editable text;
        C1525cl c1525cl = this.b;
        if (c1525cl == null || (text = c1525cl.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public final Lm getSpayOtpListener() {
        return this.spayOtpListener;
    }

    public final void setOTP(CharSequence s) {
        Intrinsics.checkNotNullParameter(s, "s");
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i < s.length()) {
                    if (this.d) {
                        this.d = false;
                    }
                    ((Cl) arrayList.get(i)).a(String.valueOf(s.charAt(i)), i + 1 == s.length(), false, this.e.length() > s.length());
                } else {
                    ((Cl) arrayList.get(i)).a("", false, this.d, this.e.length() > s.length());
                }
            }
            this.e = s.toString();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener l) {
        Intrinsics.checkNotNullParameter(l, "l");
        super.setOnTouchListener(l);
        C1525cl c1525cl = this.b;
        if (c1525cl != null) {
            c1525cl.setOnTouchListener(l);
        }
    }

    public final void setSpayOtpListener(Lm lm) {
        this.spayOtpListener = lm;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayOtpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = "";
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SpayOtpTextView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.SpayOtpTextView)");
        this.f = typedArrayObtainStyledAttributes.getInt(R$styleable.SpayOtpTextView_spay_length, 4);
        this.a = new ArrayList();
        if (this.f <= 0) {
            throw N7.a;
        }
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.SpayOtpTextView_spay_otp);
        int i = R$styleable.SpayOtpTextView_spay_width;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(i, AbstractC1977v0.a(context, 48));
        int i2 = R$styleable.SpayOtpTextView_spay_height;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(i2, AbstractC1977v0.a(context2, 48));
        int i3 = R$styleable.SpayOtpTextView_spay_box_margin;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        int dimension3 = (int) typedArrayObtainStyledAttributes.getDimension(i3, AbstractC1977v0.a(context3, -1));
        int i4 = R$styleable.SpayOtpTextView_spay_box_margin_left;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        int dimension4 = (int) typedArrayObtainStyledAttributes.getDimension(i4, AbstractC1977v0.a(context4, 4));
        int i5 = R$styleable.SpayOtpTextView_spay_box_margin_right;
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        int dimension5 = (int) typedArrayObtainStyledAttributes.getDimension(i5, AbstractC1977v0.a(context5, 4));
        int i6 = R$styleable.SpayOtpTextView_spay_box_margin_top;
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        int dimension6 = (int) typedArrayObtainStyledAttributes.getDimension(i6, AbstractC1977v0.a(context6, 4));
        int i7 = R$styleable.SpayOtpTextView_spay_box_margin_bottom;
        Context context7 = getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "context");
        int dimension7 = (int) typedArrayObtainStyledAttributes.getDimension(i7, AbstractC1977v0.a(context7, 4));
        LinearLayout.LayoutParams layoutParams = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SpayOtpTextView_spay_otp_box_match_parent, false) ? new LinearLayout.LayoutParams(dimension, dimension2, 1.0f) : new LinearLayout.LayoutParams(dimension, dimension2);
        if (dimension3 > 0) {
            layoutParams.setMargins(dimension3, dimension3, dimension3, dimension3);
        } else {
            layoutParams.setMargins(dimension4, dimension6, dimension5, dimension7);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        Context context8 = getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "context");
        C1525cl c1525cl = new C1525cl(context8);
        this.b = c1525cl;
        c1525cl.setFilters(new InputFilter[]{getFilter(), new InputFilter.LengthFilter(this.f)});
        setTextWatcher(this.b);
        setFocusDetection(this.b);
        addView(this.b, layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        addView(linearLayout, layoutParams3);
        int i8 = this.f;
        for (int i9 = 0; i9 < i8; i9++) {
            Context context9 = getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "context");
            Cl cl = new Cl(context9, attributeSet);
            cl.setViewState(0);
            linearLayout.addView(cl, i9, layoutParams);
            ArrayList arrayList = this.a;
            if (arrayList != null) {
                arrayList.add(cl);
            }
        }
        if (string != null) {
            setOTP(string);
        } else {
            setOTP("");
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void setOTP(String otp) {
        Intrinsics.checkNotNullParameter(otp, "otp");
        C1525cl c1525cl = this.b;
        if (c1525cl != null) {
            c1525cl.setText(otp);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpayOtpTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = "";
        a(attributeSet);
    }

    public static final void a(SpayOtpTextView this$0, View view, boolean z) {
        int length;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.isFocused()) {
            String otp = this$0.getOtp();
            if (otp == null) {
                return;
            } else {
                length = otp.length();
            }
        } else if (this$0.getOtp() == null) {
            return;
        } else {
            length = -1;
        }
        this$0.setFocus(length);
    }
}
