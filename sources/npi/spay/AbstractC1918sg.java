package npi.spay;

import android.content.SharedPreferences;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.sg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1918sg {
    public static void a(InterfaceC1943tg interfaceC1943tg, String key, String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesA = interfaceC1943tg.a();
        if (sharedPreferencesA != null) {
            SharedPreferences.Editor editor = sharedPreferencesA.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            if (str != null) {
                editor.putString(key, str);
            } else if (str != null) {
                throw C1837p9.a;
            }
            editor.apply();
            editor.apply();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw Q9.a;
        }
    }

    public static void a(InterfaceC1943tg interfaceC1943tg, String[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        SharedPreferences sharedPreferencesA = interfaceC1943tg.a();
        if (sharedPreferencesA != null) {
            SharedPreferences.Editor editor = sharedPreferencesA.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            for (String str : keys) {
                editor.remove(str);
            }
            editor.apply();
            editor.apply();
        }
    }
}
