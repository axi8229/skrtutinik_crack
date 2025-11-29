package ru.yoomoney.sdk.auth.phone.countries;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneCountries {
    public static final PhoneCountries INSTANCE = new PhoneCountries();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action;", "", "()V", "PhoneCountrySelected", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action$PhoneCountrySelected;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action$PhoneCountrySelected;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Action;", "selected", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;)V", "getSelected", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PhoneCountrySelected extends Action {
            private final CountryCallingCode selected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PhoneCountrySelected(CountryCallingCode selected) {
                super(null);
                Intrinsics.checkNotNullParameter(selected, "selected");
                this.selected = selected;
            }

            public static /* synthetic */ PhoneCountrySelected copy$default(PhoneCountrySelected phoneCountrySelected, CountryCallingCode countryCallingCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = phoneCountrySelected.selected;
                }
                return phoneCountrySelected.copy(countryCallingCode);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelected() {
                return this.selected;
            }

            public final PhoneCountrySelected copy(CountryCallingCode selected) {
                Intrinsics.checkNotNullParameter(selected, "selected");
                return new PhoneCountrySelected(selected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PhoneCountrySelected) && Intrinsics.areEqual(this.selected, ((PhoneCountrySelected) other).selected);
            }

            public final CountryCallingCode getSelected() {
                return this.selected;
            }

            public int hashCode() {
                return this.selected.hashCode();
            }

            public String toString() {
                return "PhoneCountrySelected(selected=" + this.selected + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect;", "", "()V", "CloseScreen", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect$CloseScreen;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect$CloseScreen;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$Effect;", "selected", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;)V", "getSelected", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CloseScreen extends Effect {
            private final CountryCallingCode selected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CloseScreen(CountryCallingCode selected) {
                super(null);
                Intrinsics.checkNotNullParameter(selected, "selected");
                this.selected = selected;
            }

            public static /* synthetic */ CloseScreen copy$default(CloseScreen closeScreen, CountryCallingCode countryCallingCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    countryCallingCode = closeScreen.selected;
                }
                return closeScreen.copy(countryCallingCode);
            }

            /* renamed from: component1, reason: from getter */
            public final CountryCallingCode getSelected() {
                return this.selected;
            }

            public final CloseScreen copy(CountryCallingCode selected) {
                Intrinsics.checkNotNullParameter(selected, "selected");
                return new CloseScreen(selected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CloseScreen) && Intrinsics.areEqual(this.selected, ((CloseScreen) other).selected);
            }

            public final CountryCallingCode getSelected() {
                return this.selected;
            }

            public int hashCode() {
                return this.selected.hashCode();
            }

            public String toString() {
                return "CloseScreen(selected=" + this.selected + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State;", "", "()V", "Content", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State$Content;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State$Content;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountries$State;", "list", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final List<CountryCallingCode> list;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(List<CountryCallingCode> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "list");
                this.list = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Content copy$default(Content content, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = content.list;
                }
                return content.copy(list);
            }

            public final List<CountryCallingCode> component1() {
                return this.list;
            }

            public final Content copy(List<CountryCallingCode> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                return new Content(list);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && Intrinsics.areEqual(this.list, ((Content) other).list);
            }

            public final List<CountryCallingCode> getList() {
                return this.list;
            }

            public int hashCode() {
                return this.list.hashCode();
            }

            public String toString() {
                return "Content(list=" + this.list + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private PhoneCountries() {
    }
}
