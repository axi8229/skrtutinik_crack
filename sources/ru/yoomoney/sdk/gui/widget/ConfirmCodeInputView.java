package ru.yoomoney.sdk.gui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$style;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;
import ru.yoomoney.sdk.gui.widget.text.TextTitle3View;

/* compiled from: ConfirmCodeInputView.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0014¢\u0006\u0004\b+\u0010\fJ\u0017\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010.R*\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0017R0\u00107\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\n\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010?\u001a\u00060=j\u0002`>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR$\u0010/\u001a\u0002062\u0006\u0010E\u001a\u0002068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lru/yoomoney/sdk/gui/widget/ConfirmCodeInputView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "onDeleteKeyPressed", "()V", "", "char", "onDigitKeyPressed", "(C)V", "displayValue", "notifyListener", "showKeyboard", "hideKeyboard", "length", "createInputCells", "(I)V", "Landroid/graphics/drawable/StateListDrawable;", "generateTransparentStateListDrawable", "()Landroid/graphics/drawable/StateListDrawable;", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "", "onCheckIsTextEditor", "()Z", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "(ILandroid/view/KeyEvent;)Z", "onDetachedFromWindow", "enabled", "setEnabled", "(Z)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "maxLength", "I", "getMaxLength", "()I", "setMaxLength", "Lkotlin/Function1;", "", "onValueChangedListener", "Lkotlin/jvm/functions/Function1;", "getOnValueChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnValueChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilder", "Ljava/lang/StringBuilder;", "Landroid/view/inputmethod/InputMethodManager;", "getInputMethodManager", "()Landroid/view/inputmethod/InputMethodManager;", "inputMethodManager", "code", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConfirmCodeInputView extends LinearLayout {
    private int maxLength;
    private Function1<? super String, Unit> onValueChangedListener;
    private final StringBuilder stringBuilder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConfirmCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    public /* synthetic */ ConfirmCodeInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxLength = 6;
        this.stringBuilder = new StringBuilder(6);
        setOrientation(0);
        setFocusableInTouchMode(true);
        setGravity(1);
        setBackground(generateTransparentStateListDrawable());
        createInputCells(6);
        showKeyboard();
    }

    public final String getValue() {
        String string = this.stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void setValue(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        StringsKt.clear(this.stringBuilder);
        this.stringBuilder.append(code);
        displayValue();
        notifyListener();
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final void setMaxLength(int i) {
        this.maxLength = i;
        StringsKt.clear(this.stringBuilder);
        createInputCells(i);
    }

    public final Function1<String, Unit> getOnValueChangedListener() {
        return this.onValueChangedListener;
    }

    public final void setOnValueChangedListener(Function1<? super String, Unit> function1) {
        this.onValueChangedListener = function1;
    }

    private final InputMethodManager getInputMethodManager() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        outAttrs.inputType = 2;
        outAttrs.imeOptions = 33554432;
        return new BaseInputConnection(this, false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onTouchEvent(event);
        int action = event.getAction();
        if (action == 0) {
            return true;
        }
        if (action != 1) {
            return false;
        }
        showKeyboard();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 67) {
            onDeleteKeyPressed();
            return true;
        }
        if (keyCode == 66) {
            hideKeyboard();
            return true;
        }
        char unicodeChar = (char) event.getUnicodeChar();
        if (Character.isDigit(unicodeChar)) {
            onDigitKeyPressed(unicodeChar);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        hideKeyboard();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        if (enabled) {
            showKeyboard();
        } else {
            hideKeyboard();
        }
    }

    private final void onDeleteKeyPressed() {
        if (this.stringBuilder.length() > 0) {
            this.stringBuilder.setLength(r0.length() - 1);
            displayValue();
            notifyListener();
        }
    }

    private final void onDigitKeyPressed(char c) {
        if (this.stringBuilder.length() < this.maxLength) {
            this.stringBuilder.append(c);
            displayValue();
            notifyListener();
        }
    }

    private final void displayValue() {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) childAt).setText(i < this.stringBuilder.length() ? String.valueOf(this.stringBuilder.charAt(i)) : "");
            i++;
        }
    }

    private final void notifyListener() {
        Function1<? super String, Unit> function1 = this.onValueChangedListener;
        if (function1 != null) {
            String string = this.stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            function1.invoke(string);
        }
    }

    private final void showKeyboard() {
        if (requestFocus() && requestFocusFromTouch()) {
            getInputMethodManager().showSoftInput(this, 1);
        }
    }

    private final void hideKeyboard() {
        getInputMethodManager().hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private final void createInputCells(int length) {
        Drawable drawableTint;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R$dimen.ym_space2XL), getResources().getDimensionPixelSize(R$dimen.ym_space4XL));
        Resources resources = getResources();
        int i = R$dimen.ym_spaceXS;
        layoutParams.setMarginStart(resources.getDimensionPixelSize(i));
        layoutParams.setMarginEnd(getResources().getDimensionPixelSize(i));
        removeAllViews();
        int i2 = 1;
        if (1 > length) {
            return;
        }
        while (true) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            TextTitle3View textTitle3View = new TextTitle3View(context, null, 0, 6, null);
            textTitle3View.setGravity(17);
            Drawable drawable = AppCompatResources.getDrawable(textTitle3View.getContext(), R$drawable.bg_rounded_corners);
            if (drawable != null) {
                Context context2 = textTitle3View.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                drawableTint = DrawableExtensions.tint(drawable, GuiContextExtensions.getThemedColor(context2, R$attr.colorCardTint));
            } else {
                drawableTint = null;
            }
            textTitle3View.setBackground(drawableTint);
            TextViewCompat.setTextAppearance(textTitle3View, R$style.Text_Title3_Medium);
            addView(textTitle3View, layoutParams);
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    private final StateListDrawable generateTransparentStateListDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        stateListDrawable.addState(new int[]{-16842919}, colorDrawable);
        stateListDrawable.addState(new int[]{-16842908}, colorDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, colorDrawable);
        return stateListDrawable;
    }
}
