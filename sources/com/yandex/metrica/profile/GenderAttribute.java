package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.Dn;
import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import com.yandex.metrica.impl.ob.Me;
import com.yandex.metrica.impl.ob.Pe;
import com.yandex.metrica.impl.ob.Ve;
import com.yandex.metrica.impl.ob.We;
import com.yandex.metrica.impl.ob.Xe;
import com.yandex.metrica.impl.ob.Ye;
import com.yandex.metrica.impl.ob.Ym;

/* loaded from: classes3.dex */
public class GenderAttribute {
    private final Pe a = new Pe("appmetrica_gender", new Dn(), new Xe());

    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");

        private final String mStringValue;

        Gender(String str) {
            this.mStringValue = str;
        }

        public String getStringValue() {
            return this.mStringValue;
        }
    }

    GenderAttribute() {
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValue(Gender gender) {
        return new UserProfileUpdate<>(new Ye(this.a.a(), gender.getStringValue(), new Ym(), this.a.b(), new Me(this.a.c())));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueIfUndefined(Gender gender) {
        return new UserProfileUpdate<>(new Ye(this.a.a(), gender.getStringValue(), new Ym(), this.a.b(), new We(this.a.c())));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueReset() {
        return new UserProfileUpdate<>(new Ve(0, this.a.a(), this.a.b(), this.a.c()));
    }
}
