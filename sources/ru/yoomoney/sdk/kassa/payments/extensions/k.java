package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class k {
    public static final void a(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter("cipherIv", "key");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Intrinsics.checkNotNull(editorEdit);
        editorEdit.remove("cipherIv");
        editorEdit.apply();
    }

    public static final void a(SharedPreferences sharedPreferences, String key, Object obj) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Intrinsics.checkNotNull(editorEdit);
        if (obj instanceof Boolean) {
            editorEdit.putBoolean(key, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(key, ((Number) obj).floatValue());
        } else if (obj instanceof Integer) {
            editorEdit.putInt(key, ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(key, ((Number) obj).longValue());
        } else if (obj instanceof Set) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            editorEdit.putStringSet(key, (Set) obj);
        } else if (obj instanceof String) {
            editorEdit.putString(key, (String) obj);
        } else if (obj == null) {
            editorEdit.remove(key);
        }
        editorEdit.apply();
    }
}
