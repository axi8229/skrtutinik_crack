package ru.yoomoney.sdk.gui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewAnimator;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.textfield.TextInputLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.gui.gui.R$attr;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.gui.gui.R$drawable;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.gui.R$layout;
import ru.yoomoney.sdk.gui.gui.R$string;
import ru.yoomoney.sdk.gui.gui.R$styleable;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.utils.extensions.GuiContextExtensions;
import ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher;

/* compiled from: TextInputView.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002`aB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u0002052\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000fJ<\u00103\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001092\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;J2\u00103\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;J4\u0010<\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u001a\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u0001052\b\u0010@\u001a\u0004\u0018\u00010AJ\u0016\u0010B\u001a\u00020>2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0014J\u0016\u0010F\u001a\u00020>2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0014J\u000e\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020>J\b\u0010J\u001a\u00020KH\u0004J\u001a\u0010L\u001a\u00020M2\u0006\u00107\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J0\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0014J\u0010\u0010T\u001a\u00020>2\u0006\u0010U\u001a\u00020EH\u0014J\n\u0010V\u001a\u0004\u0018\u00010EH\u0014J\u0010\u0010W\u001a\u00020K2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020\u000eH\u0016J\u0010\u0010Z\u001a\u00020>2\b\b\u0001\u0010[\u001a\u00020\u0007J\u000e\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020^J\b\u0010_\u001a\u00020>H\u0002R0\u0010\t\u001a$\u0012 \u0012\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f\u0012\u0004\u0012\u00020\u00070\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u001dR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010+\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u001dR\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00100\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u001d¨\u0006b"}, d2 = {"Lru/yoomoney/sdk/gui/widget/TextInputView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actions", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "Lru/yoomoney/sdk/gui/widget/ActionShowPredicate;", "actualHint", "", "getActualHint", "()Ljava/lang/CharSequence;", "animator", "Landroid/widget/ViewAnimator;", "editText", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "error", "getError", "setError", "(Ljava/lang/CharSequence;)V", "hint", "getHint", "setHint", "inputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getInputLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "inputOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getInputOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setInputOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "label", "getLabel", "setLabel", "showHint", "Ljava/lang/Runnable;", "text", "getText", "setText", "addAction", "view", "Landroid/view/View;", "predicate", "iconResId", "contentDescription", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "addCloseAction", "addView", "", "child", "params", "Landroid/view/ViewGroup$LayoutParams;", "dispatchRestoreInstanceState", "container", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "displayAction", "index", "displayAppropriateAction", "generateDefaultLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getActionImageView", "Landroid/widget/ImageView;", "onLayout", "changed", "left", "top", "right", "bottom", "onRestoreInstanceState", "state", "onSaveInstanceState", "prepareAnimatorLayoutParams", "setEnabled", "enabled", "tintColor", RemoteMessageConst.Notification.COLOR, "tintColorStateList", "colorStateList", "Landroid/content/res/ColorStateList;", "updateLabelAndHint", "NonFocusableStubView", "SavedState", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class TextInputView extends FrameLayout {
    private final List<Pair<Function1<AppCompatEditText, Boolean>, Integer>> actions;
    private final ViewAnimator animator;
    private final AppCompatEditText editText;
    private CharSequence hint;
    private final TextInputLayout inputLayout;
    private View.OnFocusChangeListener inputOnFocusChangeListener;
    private CharSequence label;
    private final Runnable showHint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TextInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actions = new ArrayList();
        if (isInEditMode()) {
            AppCompatEditText appCompatEditText = new AppCompatEditText(context);
            this.editText = appCompatEditText;
            TextInputLayout textInputLayout = new TextInputLayout(context);
            textInputLayout.addView(appCompatEditText);
            this.inputLayout = textInputLayout;
            addView(textInputLayout, generateDefaultLayoutParams());
            ViewAnimator viewAnimator = new ViewAnimator(context);
            this.animator = viewAnimator;
            addView(viewAnimator, prepareAnimatorLayoutParams(context));
        } else {
            View.inflate(context, R$layout.view_text_input, this);
            View viewFindViewById = findViewById(R$id.input_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.inputLayout = (TextInputLayout) viewFindViewById;
            View viewFindViewById2 = findViewById(R$id.edit_text);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.editText = (AppCompatEditText) viewFindViewById2;
            View viewFindViewById3 = findViewById(R$id.animator);
            ViewAnimator viewAnimator2 = (ViewAnimator) viewFindViewById3;
            NonFocusableStubView nonFocusableStubView = new NonFocusableStubView(context, null, 0, 6, null);
            nonFocusableStubView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewAnimator2.addView(nonFocusableStubView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "apply(...)");
            this.animator = viewAnimator2;
        }
        addCloseAction(R$drawable.ic_close_m, new Function1<AppCompatEditText, Boolean>() { // from class: ru.yoomoney.sdk.gui.widget.TextInputView.3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AppCompatEditText it) {
                Editable text;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.isEnabled() && it.hasFocus() && (text = it.getText()) != null && text.length() != 0);
            }
        }, new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.widget.TextInputView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextInputView._init_$lambda$3(this.f$0, view);
            }
        });
        this.showHint = new Runnable() { // from class: ru.yoomoney.sdk.gui.widget.TextInputView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TextInputView._init_$lambda$4(this.f$0);
            }
        };
        this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.yoomoney.sdk.gui.widget.TextInputView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                TextInputView._init_$lambda$5(this.f$0, view, z);
            }
        });
        this.editText.addTextChangedListener(new SimpleTextWatcher() { // from class: ru.yoomoney.sdk.gui.widget.TextInputView.7
            @Override // ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
                TextInputView.this.displayAppropriateAction();
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TextInputView, i, 0);
        setText(typedArrayObtainStyledAttributes.getString(R$styleable.TextInputView_text));
        setError(typedArrayObtainStyledAttributes.getString(R$styleable.TextInputView_error));
        setHint(typedArrayObtainStyledAttributes.getString(R$styleable.TextInputView_hint));
        setLabel(typedArrayObtainStyledAttributes.getString(R$styleable.TextInputView_label));
        AppCompatEditText appCompatEditText2 = this.editText;
        appCompatEditText2.setInputType(typedArrayObtainStyledAttributes.getInt(R$styleable.TextInputView_android_inputType, 1));
        appCompatEditText2.setMaxLines(typedArrayObtainStyledAttributes.getInt(R$styleable.TextInputView_android_maxLines, Integer.MAX_VALUE));
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.TextInputView_maxLength, Integer.MAX_VALUE);
        InputFilter[] filters = appCompatEditText2.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        appCompatEditText2.setFilters((InputFilter[]) ArraysKt.plus((InputFilter.LengthFilter[]) filters, new InputFilter.LengthFilter(integer)));
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TextInputView_android_textSize, 0);
        if (dimensionPixelSize > 0.0f) {
            appCompatEditText2.setTextSize(0, dimensionPixelSize);
        }
        appCompatEditText2.setHintTextColor(ContextCompat.getColor(context, R$color.color_type_ghost));
        this.inputLayout.setHintEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextInputView_hintEnabled, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final TextInputLayout getInputLayout() {
        return this.inputLayout;
    }

    public final AppCompatEditText getEditText() {
        return this.editText;
    }

    public final CharSequence getError() {
        return this.inputLayout.getError();
    }

    public final void setError(CharSequence charSequence) {
        this.inputLayout.setError(charSequence);
        updateLabelAndHint();
    }

    public final CharSequence getHint() {
        return this.hint;
    }

    public final void setHint(CharSequence charSequence) {
        this.hint = charSequence;
        updateLabelAndHint();
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
        updateLabelAndHint();
    }

    public final CharSequence getText() {
        return this.editText.getText();
    }

    public final void setText(CharSequence charSequence) {
        this.editText.setText(charSequence);
    }

    public final View.OnFocusChangeListener getInputOnFocusChangeListener() {
        return this.inputOnFocusChangeListener;
    }

    public final void setInputOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.inputOnFocusChangeListener = onFocusChangeListener;
    }

    private final CharSequence getActualHint() {
        CharSequence charSequence = this.label;
        return charSequence == null ? this.hint : charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(TextInputView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable text = this$0.editText.getText();
        if (text != null) {
            text.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(TextInputView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.editText.setHint(this$0.hint);
        this$0.inputLayout.setHint(this$0.getActualHint());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(TextInputView this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateLabelAndHint();
        this$0.displayAppropriateAction();
        View.OnFocusChangeListener onFocusChangeListener = this$0.inputOnFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        SavedState savedState = parcelableOnSaveInstanceState != null ? new SavedState(parcelableOnSaveInstanceState) : null;
        if (savedState != null) {
            savedState.setChildrenStates(new SparseArray<>());
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).saveHierarchyState(savedState != null ? savedState.getChildrenStates() : null);
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).restoreHierarchyState(savedState.getChildrenStates());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        Intrinsics.checkNotNullParameter(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Intrinsics.checkNotNullParameter(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = super.generateDefaultLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParamsGenerateDefaultLayoutParams, "generateDefaultLayoutParams(...)");
        return layoutParamsGenerateDefaultLayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            ViewGroup.LayoutParams layoutParams = this.animator.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ViewParent parent = this.editText.getParent();
            FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
            ViewGroup.LayoutParams layoutParams3 = frameLayout != null ? frameLayout.getLayoutParams() : null;
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            int i = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
            layoutParams2.topMargin = ((i + (this.editText.getPaddingTop() / 2)) + this.editText.getLineBounds(r4.getLineCount() - 1, null)) - layoutParams2.height;
            this.animator.setLayoutParams(layoutParams2);
            if (this.editText.isEnabled()) {
                AppCompatEditText appCompatEditText = this.editText;
                appCompatEditText.setPadding(appCompatEditText.getPaddingLeft(), this.editText.getPaddingTop(), layoutParams2.leftMargin + layoutParams2.width + layoutParams2.rightMargin, this.editText.getPaddingBottom());
            }
        }
    }

    static /* synthetic */ int addCloseAction$default(TextInputView textInputView, int i, Function1 function1, View.OnClickListener onClickListener, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCloseAction");
        }
        if ((i2 & 4) != 0) {
            onClickListener = null;
        }
        return textInputView.addCloseAction(i, function1, onClickListener);
    }

    private final int addCloseAction(int iconResId, Function1<? super AppCompatEditText, Boolean> predicate, View.OnClickListener listener) {
        ImageView actionImageView = getActionImageView(iconResId, listener);
        actionImageView.setContentDescription(getContext().getString(R$string.text_input_content_description_clear));
        return addAction(actionImageView, predicate);
    }

    private final ImageView getActionImageView(int iconResId, View.OnClickListener listener) {
        Drawable drawableTint;
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(R$drawable.btn_image_borderless);
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int themedColor = GuiContextExtensions.getThemedColor(context, R$attr.colorTint);
        Drawable drawable = AppCompatResources.getDrawable(imageView.getContext(), iconResId);
        if (drawable != null) {
            Intrinsics.checkNotNull(drawable);
            drawableTint = DrawableExtensions.tint(drawable, themedColor);
        } else {
            drawableTint = null;
        }
        imageView.setImageDrawable(drawableTint);
        imageView.setOnClickListener(listener);
        return imageView;
    }

    public static /* synthetic */ int addAction$default(TextInputView textInputView, int i, Function1 function1, View.OnClickListener onClickListener, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addAction");
        }
        if ((i2 & 4) != 0) {
            onClickListener = null;
        }
        return textInputView.addAction(i, function1, onClickListener);
    }

    public final int addAction(int iconResId, Function1<? super AppCompatEditText, Boolean> predicate, View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return addAction(getActionImageView(iconResId, listener), predicate);
    }

    public static /* synthetic */ int addAction$default(TextInputView textInputView, int i, String str, Function1 function1, View.OnClickListener onClickListener, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addAction");
        }
        if ((i2 & 8) != 0) {
            onClickListener = null;
        }
        return textInputView.addAction(i, str, function1, onClickListener);
    }

    public final int addAction(int iconResId, String contentDescription, Function1<? super AppCompatEditText, Boolean> predicate, View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ImageView actionImageView = getActionImageView(iconResId, listener);
        actionImageView.setContentDescription(contentDescription);
        return addAction(actionImageView, predicate);
    }

    public final int addAction(View view, Function1<? super AppCompatEditText, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int childCount = this.animator.getChildCount();
        this.actions.add(new Pair<>(predicate, Integer.valueOf(childCount)));
        this.animator.addView(view);
        return childCount;
    }

    public final void displayAction(int index) {
        this.animator.setDisplayedChild(index);
    }

    public final void displayAppropriateAction() {
        Pair<Function1<AppCompatEditText, Boolean>, Integer> pairPrevious;
        List<Pair<Function1<AppCompatEditText, Boolean>, Integer>> list = this.actions;
        ListIterator<Pair<Function1<AppCompatEditText, Boolean>, Integer>> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                pairPrevious = null;
                break;
            } else {
                pairPrevious = listIterator.previous();
                if (pairPrevious.component1().invoke(this.editText).booleanValue()) {
                    break;
                }
            }
        }
        Pair<Function1<AppCompatEditText, Boolean>, Integer> pair = pairPrevious;
        int iIntValue = pair != null ? pair.getSecond().intValue() : 0;
        if (this.animator.getDisplayedChild() != iIntValue) {
            this.animator.setDisplayedChild(iIntValue);
        }
    }

    public final void tintColor(int color) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        tintColorStateList(colorStateListValueOf);
    }

    public final void tintColorStateList(final ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        postOnAnimation(new Runnable() { // from class: ru.yoomoney.sdk.gui.widget.TextInputView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TextInputView.tintColorStateList$lambda$15(this.f$0, colorStateList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tintColorStateList$lambda$15(TextInputView this$0, ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(colorStateList, "$colorStateList");
        ViewCompat.setBackgroundTintList(this$0.editText, colorStateList);
        int childCount = this$0.animator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this$0.animator.getChildAt(i);
            ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
            if (imageView != null) {
                ImageViewCompat.setImageTintList(imageView, colorStateList);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.editText.setEnabled(enabled);
        for (View view : SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, this.animator.getChildCount())), new AnonymousClass1(this.animator))) {
            if (view != null) {
                view.setEnabled(enabled);
            }
        }
        this.animator.animate().setDuration(255L).alpha(enabled ? 1.0f : 0.0f);
    }

    /* compiled from: TextInputView.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.gui.widget.TextInputView$setEnabled$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, View> {
        AnonymousClass1(Object obj) {
            super(1, obj, ViewAnimator.class, "getChildAt", "getChildAt(I)Landroid/view/View;", 0);
        }

        public final View invoke(int i) {
            return ((ViewAnimator) this.receiver).getChildAt(i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ View invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    private final void updateLabelAndHint() {
        this.editText.removeCallbacks(this.showHint);
        CharSequence charSequence = this.label;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.editText.setHint(this.hint);
        } else if (this.editText.hasFocus()) {
            this.editText.postDelayed(this.showHint, 150L);
        } else {
            this.editText.setHint((CharSequence) null);
            this.inputLayout.setHint(getActualHint());
        }
    }

    private final FrameLayout.LayoutParams prepareAnimatorLayoutParams(Context context) {
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.gravity = 8388613;
        int iConvertDpToPx = GuiContextExtensions.convertDpToPx(context, 24);
        layoutParamsGenerateDefaultLayoutParams.width = iConvertDpToPx;
        layoutParamsGenerateDefaultLayoutParams.height = iConvertDpToPx;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    /* compiled from: TextInputView.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/gui/widget/TextInputView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "parcel", "Landroid/os/Parcel;", "classLoader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "childrenStates", "Landroid/util/SparseArray;", "getChildrenStates", "()Landroid/util/SparseArray;", "setChildrenStates", "(Landroid/util/SparseArray;)V", "writeToParcel", "", "out", "flags", "", "CREATOR", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SavedState extends View.BaseSavedState {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private SparseArray<Parcelable> childrenStates;

        public /* synthetic */ SavedState(Parcel parcel, ClassLoader classLoader, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel, classLoader);
        }

        public final SparseArray<Parcelable> getChildrenStates() {
            return this.childrenStates;
        }

        public final void setChildrenStates(SparseArray<Parcelable> sparseArray) {
            this.childrenStates = sparseArray;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            Intrinsics.checkNotNullParameter(superState, "superState");
        }

        private SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.childrenStates = parcel.readSparseArray(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            Intrinsics.checkNotNullParameter(out, "out");
            super.writeToParcel(out, flags);
            SparseArray<Parcelable> sparseArray = this.childrenStates;
            Intrinsics.checkNotNull(sparseArray, "null cannot be cast to non-null type android.util.SparseArray<kotlin.Any>");
            out.writeSparseArray(sparseArray);
        }

        /* compiled from: TextInputView.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/gui/widget/TextInputView$SavedState$CREATOR;", "Landroid/os/Parcelable$ClassLoaderCreator;", "Lru/yoomoney/sdk/gui/widget/TextInputView$SavedState;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "newArray", "", "size", "", "(I)[Lru/yoomoney/sdk/gui/widget/TextInputView$SavedState;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* renamed from: ru.yoomoney.sdk.gui.widget.TextInputView$SavedState$CREATOR, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.ClassLoaderCreator<SavedState> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel source, ClassLoader loader) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new SavedState(source, loader, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return createFromParcel(source, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }
    }

    /* compiled from: TextInputView.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/gui/widget/TextInputView$NonFocusableStubView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onFocusChanged", "", "gainFocus", "", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "previouslyFocusedRect", "Landroid/graphics/Rect;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NonFocusableStubView extends View {
        public /* synthetic */ NonFocusableStubView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonFocusableStubView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            setFocusable(false);
        }

        @Override // android.view.View
        protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
            if (gainFocus) {
                setFocusable(false);
            }
            super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        }
    }
}
