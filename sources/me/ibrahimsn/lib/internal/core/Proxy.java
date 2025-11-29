package me.ibrahimsn.lib.internal.core;

import android.content.Context;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ibrahimsn.lib.internal.ext.ExtensionsKt;

/* compiled from: Proxy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lme/ibrahimsn/lib/internal/core/Proxy;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "number", "defaultRegion", "Lio/michaelrocks/libphonenumber/android/Phonenumber$PhoneNumber;", "parsePhoneNumber", "(Ljava/lang/String;Ljava/lang/String;)Lio/michaelrocks/libphonenumber/android/Phonenumber$PhoneNumber;", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "phoneUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "lib_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class Proxy {
    private PhoneNumberUtil phoneUtil;

    public Proxy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PhoneNumberUtil phoneNumberUtilCreateInstance = PhoneNumberUtil.createInstance(context);
        Intrinsics.checkNotNullExpressionValue(phoneNumberUtilCreateInstance, "createInstance(context)");
        this.phoneUtil = phoneNumberUtilCreateInstance;
    }

    public final Phonenumber$PhoneNumber parsePhoneNumber(String number, String defaultRegion) {
        String upperCase;
        try {
            PhoneNumberUtil phoneNumberUtil = this.phoneUtil;
            if (!ExtensionsKt.startsWithPlus(number)) {
                number = ExtensionsKt.prependPlus(number);
            }
            if (defaultRegion == null) {
                upperCase = null;
            } else {
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                upperCase = defaultRegion.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            }
            return phoneNumberUtil.parseAndKeepRawInput(number, upperCase);
        } catch (NumberParseException unused) {
            return null;
        }
    }
}
