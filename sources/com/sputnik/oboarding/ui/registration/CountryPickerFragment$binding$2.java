package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentChooseCountryPhoneCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountryPickerFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class CountryPickerFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentChooseCountryPhoneCodeBinding> {
    public static final CountryPickerFragment$binding$2 INSTANCE = new CountryPickerFragment$binding$2();

    CountryPickerFragment$binding$2() {
        super(1, FragmentChooseCountryPhoneCodeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentChooseCountryPhoneCodeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentChooseCountryPhoneCodeBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentChooseCountryPhoneCodeBinding.bind(p0);
    }
}
