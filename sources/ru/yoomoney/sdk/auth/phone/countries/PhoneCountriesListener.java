package ru.yoomoney.sdk.auth.phone.countries;

import kotlin.Metadata;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountriesListener;", "", "dismiss", "", "onCountrySelected", "selected", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PhoneCountriesListener {
    void dismiss();

    void onCountrySelected(CountryCallingCode selected);
}
