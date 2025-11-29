package ru.yoomoney.sdk.kassa.payments.secure;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.extensions.k;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;
import ru.yoomoney.sdk.kassa.payments.userAuth.U;

/* loaded from: classes5.dex */
public final class j implements ru.yoomoney.sdk.kassa.payments.payment.a, U, r1 {
    public final SharedPreferences a;
    public final Function1 b;
    public final Function1 c;
    public String d;

    public j(SharedPreferences preferences, g encrypt, f decrypt) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(encrypt, "encrypt");
        Intrinsics.checkNotNullParameter(decrypt, "decrypt");
        this.a = preferences;
        this.b = encrypt;
        this.c = decrypt;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.r1
    public final void a() {
        SharedPreferences sharedPreferences = this.a;
        String strD = d();
        k.a(sharedPreferences, "paymentAuthToken", strD != null ? (String) this.b.invoke(strD) : null);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.a
    public final boolean b() {
        return this.d == null && this.a.getString("paymentAuthToken", null) == null;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.a
    public final boolean c() {
        return this.a.getBoolean("isYooUserRemember", false);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.r1
    public final String d() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String string = this.a.getString("paymentAuthToken", null);
        if (string != null) {
            return (String) this.c.invoke(string);
        }
        return null;
    }

    public final String e() {
        String string = this.a.getString("yooUserAuthToken", null);
        if (string != null) {
            return (String) this.c.invoke(string);
        }
        return null;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.r1
    public final void a(String str) {
        this.d = str;
        if (str == null) {
            k.a(this.a, "paymentAuthToken", null);
        }
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.r1
    public final void a(boolean z) {
        k.a(this.a, "isYooUserRemember", Boolean.valueOf(z));
    }
}
