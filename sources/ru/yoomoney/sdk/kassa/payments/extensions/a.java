package ru.yoomoney.sdk.kassa.payments.extensions;

import android.text.SpannableStringBuilder;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public abstract class a {
    public static final CharSequence a(Amount amount) throws IOException {
        NumberFormat decimalFormat;
        Intrinsics.checkNotNullParameter(amount, "<this>");
        Currency currency = amount.getCurrency();
        Currency currency2 = h.a;
        Intrinsics.checkNotNullParameter(currency, "<this>");
        Intrinsics.checkNotNullParameter(currency, "<this>");
        Currency currency3 = h.a;
        if (Intrinsics.areEqual(currency, currency3)) {
            decimalFormat = new DecimalFormat("#,##0.00");
        } else {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            currencyInstance.setCurrency(currency);
            Intrinsics.checkNotNullExpressionValue(currencyInstance, "apply(...)");
            decimalFormat = currencyInstance;
        }
        String str = decimalFormat.format(amount.getValue());
        Currency currency4 = amount.getCurrency();
        Intrinsics.checkNotNullParameter(currency4, "<this>");
        if (!Intrinsics.areEqual(currency4, currency3)) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(str).append(' ');
        KProperty[] kPropertyArr = b.a;
        Intrinsics.checkNotNullParameter(spannableStringBuilderAppend, "<this>");
        spannableStringBuilderAppend.append((CharSequence) b.b.getValue(null, b.a[0]));
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilderAppend, "appendRoubleSpan(...)");
        return spannableStringBuilderAppend;
    }
}
