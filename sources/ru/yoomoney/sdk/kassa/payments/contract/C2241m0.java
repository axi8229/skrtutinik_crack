package ru.yoomoney.sdk.kassa.payments.contract;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.m0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2241m0 implements TextWatcher {
    public final /* synthetic */ C2264y0 a;

    public C2241m0(C2264y0 c2264y0) {
        this.a = c2264y0;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        C2264y0 c2264y0 = this.a;
        int i = C2264y0.$r8$clinit;
        c2264y0.a().l.setError("");
        this.a.a().l.setHint("");
        PrimaryButtonView primaryButtonView = this.a.a().k;
        String string = s.toString();
        Regex regex = ru.yoomoney.sdk.kassa.payments.extensions.d.a;
        Intrinsics.checkNotNullParameter(string, "<this>");
        primaryButtonView.setEnabled(ru.yoomoney.sdk.kassa.payments.extensions.d.a.matches(string));
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence s, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(s, "s");
    }
}
