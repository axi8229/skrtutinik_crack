package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.Context;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes5.dex */
public abstract class b {
    public static final /* synthetic */ KProperty[] a = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "roubleSign", "getRoubleSign()Ljava/lang/CharSequence;", 1))};
    public static final ReadWriteProperty b = Delegates.INSTANCE.notNull();

    public static final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((char) 8381);
        b.setValue(null, a[0], spannableStringBuilder);
    }
}
