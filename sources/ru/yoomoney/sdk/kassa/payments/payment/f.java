package ru.yoomoney.sdk.kassa.payments.payment;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u;
import ru.yoomoney.sdk.kassa.payments.model.C2318b;
import ru.yoomoney.sdk.kassa.payments.model.C2331o;
import ru.yoomoney.sdk.kassa.payments.secure.j;

/* loaded from: classes5.dex */
public final class f implements b {
    public final j a;
    public final SharedPreferences b;

    public f(j tokensStorage, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.a = tokensStorage;
        this.b = sharedPreferences;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.b
    public final AbstractC2336u a() {
        String strD;
        if (!this.b.contains("current_user_name")) {
            return C2318b.a;
        }
        j jVar = this.a;
        String string = jVar.a.getString("userAuthToken", null);
        String str = string != null ? (String) jVar.c.invoke(string) : null;
        if (str == null || str.length() == 0 || (strD = jVar.d()) == null || strD.length() == 0) {
            String strE = this.a.e();
            if (strE == null || strE.length() == 0) {
                C2318b c2318b = C2318b.a;
                a(c2318b);
                return c2318b;
            }
        }
        return new C2331o();
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.b
    public final void a(AbstractC2336u value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences.Editor editorEdit = this.b.edit();
        Intrinsics.checkNotNull(editorEdit);
        if (Intrinsics.areEqual(value, C2318b.a)) {
            editorEdit.remove("current_user_name");
        } else if (value instanceof C2331o) {
            editorEdit.putString("current_user_name", "");
        }
        editorEdit.apply();
    }
}
