package sputnik.axmor.com.sputnik.ui.views;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ViewPhoneEditTextBinding;
import sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView;

/* compiled from: PhoneEditTextView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000eJ\u0014\u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/PhoneEditTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lsputnik/axmor/com/databinding/ViewPhoneEditTextBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/ViewPhoneEditTextBinding;", "setBinding", "(Lsputnik/axmor/com/databinding/ViewPhoneEditTextBinding;)V", "countryCode", "", "countryCodesList", "", "Lcom/sputnik/domain/entities/county_code/DomainCountryCode;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsputnik/axmor/com/sputnik/ui/views/PhoneEditTextView$PhoneEditTextListener;", "phone", "textChangedProgrammatically", "", "getCountryCodeEditText", "Landroid/widget/EditText;", "getPhoneEditText", "hideError", "", "init", "isCorrectPhone", "setCountryCode", "code", "setCountryCodesList", "list", "setListener", "showError", "text", "PhoneEditTextListener", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneEditTextView extends ConstraintLayout {
    private ViewPhoneEditTextBinding binding;
    private String countryCode;
    private List<DomainCountryCode> countryCodesList;
    private PhoneEditTextListener listener;
    private String phone;
    private boolean textChangedProgrammatically;

    /* compiled from: PhoneEditTextView.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/PhoneEditTextView$PhoneEditTextListener;", "", "onPhoneChanged", "", "phone", "", "isCorrect", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface PhoneEditTextListener {
        void onPhoneChanged(String phone, boolean isCorrect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.countryCodesList = CollectionsKt.emptyList();
        init();
        this.countryCode = "";
        this.phone = "";
    }

    public final ViewPhoneEditTextBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(ViewPhoneEditTextBinding viewPhoneEditTextBinding) {
        this.binding = viewPhoneEditTextBinding;
    }

    public final void setCountryCodesList(List<DomainCountryCode> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.countryCodesList = list;
    }

    public final void setListener(PhoneEditTextListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final EditText getCountryCodeEditText() {
        ViewPhoneEditTextBinding viewPhoneEditTextBinding = this.binding;
        if (viewPhoneEditTextBinding != null) {
            return viewPhoneEditTextBinding.etCountryCode;
        }
        return null;
    }

    public final EditText getPhoneEditText() {
        ViewPhoneEditTextBinding viewPhoneEditTextBinding = this.binding;
        if (viewPhoneEditTextBinding != null) {
            return viewPhoneEditTextBinding.etPhone;
        }
        return null;
    }

    private final void init() {
        Object systemService = getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        final ViewPhoneEditTextBinding viewPhoneEditTextBindingInflate = ViewPhoneEditTextBinding.inflate((LayoutInflater) systemService, this, true);
        this.binding = viewPhoneEditTextBindingInflate;
        if (viewPhoneEditTextBindingInflate != null) {
            EditText editText = viewPhoneEditTextBindingInflate.etCountryCode;
            MaskedTextChangedListener.Companion companion = MaskedTextChangedListener.INSTANCE;
            MaskedTextChangedListener.ValueListener valueListener = new MaskedTextChangedListener.ValueListener() { // from class: sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView$init$1$1$1$phoneNumberListener$1
                @Override // com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener
                public void onTextChanged(boolean maskFilled, String extractedValue, String formattedValue) {
                    Intrinsics.checkNotNullParameter(extractedValue, "extractedValue");
                    Intrinsics.checkNotNullParameter(formattedValue, "formattedValue");
                    boolean z = false;
                    if (this.this$0.textChangedProgrammatically) {
                        this.this$0.textChangedProgrammatically = false;
                        return;
                    }
                    List list = this.this$0.countryCodesList;
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (hashSet.add(((DomainCountryCode) obj).getCode())) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : arrayList) {
                        if (StringsKt.startsWith$default(((DomainCountryCode) obj2).getCode(), "+" + extractedValue, false, 2, (Object) null)) {
                            arrayList2.add(obj2);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        this.this$0.countryCode = extractedValue;
                        if (this.this$0.countryCode.length() == 4 || arrayList2.size() == 1) {
                            viewPhoneEditTextBindingInflate.etPhone.requestFocus();
                        }
                        PhoneEditTextView.PhoneEditTextListener phoneEditTextListener = this.this$0.listener;
                        if (phoneEditTextListener != null) {
                            String str = this.this$0.countryCode + this.this$0.phone;
                            if (!StringsKt.isBlank(this.this$0.countryCode) && !StringsKt.isBlank(this.this$0.phone) && this.this$0.phone.length() > 9) {
                                z = true;
                            }
                            phoneEditTextListener.onPhoneChanged(str, z);
                            return;
                        }
                        return;
                    }
                    this.this$0.textChangedProgrammatically = true;
                    EditText editText2 = viewPhoneEditTextBindingInflate.etPhone;
                    Object objLastOrNull = StringsKt.lastOrNull(extractedValue);
                    if (objLastOrNull == null) {
                        objLastOrNull = "";
                    }
                    Editable text = viewPhoneEditTextBindingInflate.etPhone.getText();
                    StringBuilder sb = new StringBuilder();
                    sb.append(objLastOrNull);
                    sb.append((Object) text);
                    editText2.setText(sb.toString());
                    viewPhoneEditTextBindingInflate.etCountryCode.setText(this.this$0.countryCode);
                    viewPhoneEditTextBindingInflate.etPhone.requestFocus();
                }
            };
            Intrinsics.checkNotNull(editText);
            MaskedTextChangedListener maskedTextChangedListenerInstallOn = companion.installOn(editText, "+[0000]", (220 & 4) != 0 ? CollectionsKt.emptyList() : null, (220 & 8) != 0 ? CollectionsKt.emptyList() : null, (220 & 16) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : null, (220 & 32) != 0, (220 & 64) != 0 ? false : false, (220 & 128) != 0 ? null : null, (220 & 256) != 0 ? null : valueListener);
            editText.removeTextChangedListener(maskedTextChangedListenerInstallOn);
            editText.addTextChangedListener(maskedTextChangedListenerInstallOn);
            EditText editText2 = viewPhoneEditTextBindingInflate.etPhone;
            editText2.setOnKeyListener(new View.OnKeyListener() { // from class: sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return PhoneEditTextView.init$lambda$4$lambda$3$lambda$2$lambda$1(this.f$0, viewPhoneEditTextBindingInflate, view, i, keyEvent);
                }
            });
            MaskedTextChangedListener.ValueListener valueListener2 = new MaskedTextChangedListener.ValueListener() { // from class: sputnik.axmor.com.sputnik.ui.views.PhoneEditTextView$init$1$1$2$phoneNumberListener$1
                @Override // com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener
                public void onTextChanged(boolean maskFilled, String extractedValue, String formattedValue) {
                    Intrinsics.checkNotNullParameter(extractedValue, "extractedValue");
                    Intrinsics.checkNotNullParameter(formattedValue, "formattedValue");
                    if (viewPhoneEditTextBindingInflate.etPhone.getSelectionStart() == 0) {
                        viewPhoneEditTextBindingInflate.etCountryCode.requestFocus();
                    }
                    this.phone = extractedValue;
                    PhoneEditTextView.PhoneEditTextListener phoneEditTextListener = this.listener;
                    if (phoneEditTextListener != null) {
                        phoneEditTextListener.onPhoneChanged(this.countryCode + this.phone, (StringsKt.isBlank(this.countryCode) || StringsKt.isBlank(this.phone) || this.phone.length() <= 9) ? false : true);
                    }
                }
            };
            Intrinsics.checkNotNull(editText2);
            MaskedTextChangedListener maskedTextChangedListenerInstallOn2 = companion.installOn(editText2, "([000]) [000]-[00]-[00999999]", (220 & 4) != 0 ? CollectionsKt.emptyList() : null, (220 & 8) != 0 ? CollectionsKt.emptyList() : null, (220 & 16) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : null, (220 & 32) != 0, (220 & 64) != 0 ? false : false, (220 & 128) != 0 ? null : null, (220 & 256) != 0 ? null : valueListener2);
            editText2.removeTextChangedListener(maskedTextChangedListenerInstallOn2);
            editText2.addTextChangedListener(maskedTextChangedListenerInstallOn2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$4$lambda$3$lambda$2$lambda$1(PhoneEditTextView this$0, ViewPhoneEditTextBinding this_with, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        if (i != 67 || !StringsKt.isBlank(this$0.phone)) {
            return false;
        }
        this_with.etCountryCode.requestFocus();
        return false;
    }

    public final void setCountryCode(String code) {
        EditText editText;
        Intrinsics.checkNotNullParameter(code, "code");
        this.textChangedProgrammatically = false;
        ViewPhoneEditTextBinding viewPhoneEditTextBinding = this.binding;
        if (viewPhoneEditTextBinding == null || (editText = viewPhoneEditTextBinding.etCountryCode) == null) {
            return;
        }
        editText.setText(code);
    }

    public final boolean isCorrectPhone() {
        return (StringsKt.isBlank(this.countryCode) || StringsKt.isBlank(this.phone) || this.phone.length() <= 9) ? false : true;
    }

    public final void showError(String text) {
        TextView textView;
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(text, "text");
        ViewPhoneEditTextBinding viewPhoneEditTextBinding = this.binding;
        TextView textView2 = viewPhoneEditTextBinding != null ? viewPhoneEditTextBinding.tvError : null;
        if (textView2 != null) {
            textView2.setText(text);
        }
        ViewPhoneEditTextBinding viewPhoneEditTextBinding2 = this.binding;
        if (viewPhoneEditTextBinding2 != null && (constraintLayout = viewPhoneEditTextBinding2.layoutPhone) != null) {
            constraintLayout.setBackgroundResource(R.drawable.bg_edit_text_error);
        }
        ViewPhoneEditTextBinding viewPhoneEditTextBinding3 = this.binding;
        if (viewPhoneEditTextBinding3 == null || (textView = viewPhoneEditTextBinding3.tvError) == null) {
            return;
        }
        ViewKt.visible(textView);
    }

    public final void hideError() {
        TextView textView;
        ConstraintLayout constraintLayout;
        ViewPhoneEditTextBinding viewPhoneEditTextBinding = this.binding;
        TextView textView2 = viewPhoneEditTextBinding != null ? viewPhoneEditTextBinding.tvError : null;
        if (textView2 != null) {
            textView2.setText("");
        }
        ViewPhoneEditTextBinding viewPhoneEditTextBinding2 = this.binding;
        if (viewPhoneEditTextBinding2 != null && (constraintLayout = viewPhoneEditTextBinding2.layoutPhone) != null) {
            constraintLayout.setBackgroundResource(R.drawable.bg_edit_text);
        }
        ViewPhoneEditTextBinding viewPhoneEditTextBinding3 = this.binding;
        if (viewPhoneEditTextBinding3 == null || (textView = viewPhoneEditTextBinding3.tvError) == null) {
            return;
        }
        ViewKt.gone(textView);
    }
}
