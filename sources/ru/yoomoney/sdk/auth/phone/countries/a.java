package ru.yoomoney.sdk.auth.phone.countries;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;

/* loaded from: classes4.dex */
public final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<CountryCallingCode, Unit> {
    public a(PhoneCountriesFragment phoneCountriesFragment) {
        super(1, phoneCountriesFragment, PhoneCountriesFragment.class, "onItemSelect", "onItemSelect(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(CountryCallingCode countryCallingCode) {
        CountryCallingCode p0 = countryCallingCode;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((PhoneCountriesFragment) this.receiver).onItemSelect(p0);
        return Unit.INSTANCE;
    }
}
