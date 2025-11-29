package ru.yoomoney.sdk.auth.api.migration.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/model/PhoneInputRaw;", "", "countryCallingCodes", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Ljava/util/List;)V", "getCountryCallingCodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhoneInputRaw {

    @SerializedName("countryCallingCodes")
    private final List<CountryCallingCode> countryCallingCodes;

    public PhoneInputRaw(List<CountryCallingCode> countryCallingCodes) {
        Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
        this.countryCallingCodes = countryCallingCodes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PhoneInputRaw copy$default(PhoneInputRaw phoneInputRaw, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = phoneInputRaw.countryCallingCodes;
        }
        return phoneInputRaw.copy(list);
    }

    public final List<CountryCallingCode> component1() {
        return this.countryCallingCodes;
    }

    public final PhoneInputRaw copy(List<CountryCallingCode> countryCallingCodes) {
        Intrinsics.checkNotNullParameter(countryCallingCodes, "countryCallingCodes");
        return new PhoneInputRaw(countryCallingCodes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PhoneInputRaw) && Intrinsics.areEqual(this.countryCallingCodes, ((PhoneInputRaw) other).countryCallingCodes);
    }

    public final List<CountryCallingCode> getCountryCallingCodes() {
        return this.countryCallingCodes;
    }

    public int hashCode() {
        return this.countryCallingCodes.hashCode();
    }

    public String toString() {
        return "PhoneInputRaw(countryCallingCodes=" + this.countryCallingCodes + ")";
    }
}
