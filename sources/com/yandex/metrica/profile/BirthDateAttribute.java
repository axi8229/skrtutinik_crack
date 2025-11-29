package com.yandex.metrica.profile;

import android.annotation.SuppressLint;
import com.yandex.metrica.impl.ob.Dn;
import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import com.yandex.metrica.impl.ob.Ke;
import com.yandex.metrica.impl.ob.Me;
import com.yandex.metrica.impl.ob.Pe;
import com.yandex.metrica.impl.ob.Ve;
import com.yandex.metrica.impl.ob.We;
import com.yandex.metrica.impl.ob.Xe;
import com.yandex.metrica.impl.ob.Ye;
import com.yandex.metrica.impl.ob.Ym;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class BirthDateAttribute {
    private final Pe a = new Pe("appmetrica_birth_date", new Dn(), new Xe());

    BirthDateAttribute() {
    }

    private Calendar a(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return gregorianCalendar;
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withAge(int i) {
        return a(a(Calendar.getInstance(Locale.US).get(1) - i), "yyyy", new Me(this.a.c()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withAgeIfUndefined(int i) {
        return a(a(Calendar.getInstance(Locale.US).get(1) - i), "yyyy", new We(this.a.c()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDate(int i) {
        return a(a(i), "yyyy", new Me(this.a.c()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDateIfUndefined(int i) {
        return a(a(i), "yyyy", new We(this.a.c()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueReset() {
        return new UserProfileUpdate<>(new Ve(0, this.a.a(), new Dn(), new Xe()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDate(int i, int i2) {
        return a(a(i, i2), "yyyy-MM", new Me(this.a.c()));
    }

    private Calendar a(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return gregorianCalendar;
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDateIfUndefined(int i, int i2) {
        return a(a(i, i2), "yyyy-MM", new We(this.a.c()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDate(int i, int i2, int i3) {
        return a(a(i, i2, i3), "yyyy-MM-dd", new Me(this.a.c()));
    }

    private Calendar a(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return gregorianCalendar;
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDateIfUndefined(int i, int i2, int i3) {
        return a(a(i, i2, i3), "yyyy-MM-dd", new We(this.a.c()));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Me(this.a.c()));
    }

    @SuppressLint({"SimpleDateFormat"})
    UserProfileUpdate<? extends InterfaceC0826bf> a(Calendar calendar, String str, Ke ke) {
        return new UserProfileUpdate<>(new Ye(this.a.a(), new SimpleDateFormat(str).format(calendar.getTime()), new Ym(), new Dn(), ke));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new We(this.a.c()));
    }
}
