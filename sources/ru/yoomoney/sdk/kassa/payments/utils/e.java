package ru.yoomoney.sdk.kassa.payments.utils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$drawable;

/* loaded from: classes5.dex */
public abstract class e {
    public static final void a(EditText editText, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Drawable drawable = ContextCompat.getDrawable(editText.getContext(), R$drawable.ym_edit_text_cursor);
        if (drawable != null) {
            DrawableCompat.setTint(DrawableCompat.wrap(drawable), i);
        } else {
            drawable = null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            editText.setTextCursorDrawable(drawable);
            return;
        }
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(declaredField);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "getDeclaredField(...)");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(declaredField);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            Drawable drawable2 = ContextCompat.getDrawable(editText.getContext(), i2);
            if (drawable2 != null) {
                drawable2.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, new Drawable[]{drawable2, drawable2});
        } catch (Exception unused) {
            Log.d("EditText", "Failed to change cursor color");
        }
    }
}
