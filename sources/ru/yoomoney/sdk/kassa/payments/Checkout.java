package ru.yoomoney.sdk.kassa.payments;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavedBankCardPaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.confirmation.ConfirmationActivity;
import ru.yoomoney.sdk.kassa.payments.threeDS.WebViewActivity;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivity;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;
import ru.yoomoney.sdk.kassa.payments.utils.c;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007JD\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J,\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0007J,\u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lru/yoomoney/sdk/kassa/payments/Checkout;", "", "()V", "ERROR_NOT_HTTPS_URL", "", "EXTRA_ERROR_CODE", "", "EXTRA_ERROR_DESCRIPTION", "EXTRA_ERROR_FAILING_URL", "RESULT_ERROR", "create3dsIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "url", "colorScheme", "Lru/yoomoney/sdk/kassa/payments/ui/color/ColorScheme;", "testParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/TestParameters;", "createConfirmationIntent", "confirmationUrl", "paymentMethodType", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentMethodType;", "clientApplicationKey", "shopId", "createSavedCardTokenizeIntent", "savedBankCardPaymentParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/SavedBankCardPaymentParameters;", "uiParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/UiParameters;", "createScanBankCardIntent", BankCardViewKt.EXTRA_CARD_NUMBER, "expirationMonth", "expirationYear", "createTokenizationResult", "Lru/yoomoney/sdk/kassa/payments/TokenizationResult;", RemoteMessageConst.DATA, "createTokenizeIntent", "paymentParameters", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/PaymentParameters;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Checkout {
    public static final int $stable = 0;

    @Keep
    public static final int ERROR_NOT_HTTPS_URL = Integer.MIN_VALUE;

    @Keep
    public static final String EXTRA_ERROR_CODE = "ru.yoomoney.sdk.kassa.payments.extra.ERROR_CODE";

    @Keep
    public static final String EXTRA_ERROR_DESCRIPTION = "ru.yoomoney.sdk.kassa.payments.extra.ERROR_DESCRIPTION";

    @Keep
    public static final String EXTRA_ERROR_FAILING_URL = "ru.yoomoney.sdk.kassa.payments.extra.ERROR_FAILING_URL";
    public static final Checkout INSTANCE = new Checkout();

    @Keep
    public static final int RESULT_ERROR = 1;

    private Checkout() {
    }

    @Deprecated
    @JvmStatic
    @Keep
    public static final Intent create3dsIntent(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        return create3dsIntent$default(context, url, null, null, 12, null);
    }

    public static /* synthetic */ Intent create3dsIntent$default(Context context, String str, ColorScheme colorScheme, TestParameters testParameters, int i, Object obj) {
        if ((i & 4) != 0) {
            colorScheme = ColorScheme.INSTANCE.getDefaultScheme();
        }
        if ((i & 8) != 0) {
            testParameters = new TestParameters(false, false, null, null, null, 31, null);
        }
        return create3dsIntent(context, str, colorScheme, testParameters);
    }

    @JvmStatic
    @Keep
    public static final Intent createConfirmationIntent(Context context, String confirmationUrl, PaymentMethodType paymentMethodType, String clientApplicationKey, String shopId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        return createConfirmationIntent$default(context, confirmationUrl, paymentMethodType, clientApplicationKey, shopId, null, null, 96, null);
    }

    public static /* synthetic */ Intent createConfirmationIntent$default(Context context, String str, PaymentMethodType paymentMethodType, String str2, String str3, ColorScheme colorScheme, TestParameters testParameters, int i, Object obj) {
        return createConfirmationIntent(context, str, paymentMethodType, str2, str3, (i & 32) != 0 ? ColorScheme.INSTANCE.getDefaultScheme() : colorScheme, (i & 64) != 0 ? new TestParameters(false, false, null, null, null, 31, null) : testParameters);
    }

    @JvmStatic
    @Keep
    public static final Intent createSavedCardTokenizeIntent(Context context, SavedBankCardPaymentParameters savedBankCardPaymentParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(savedBankCardPaymentParameters, "savedBankCardPaymentParameters");
        return createSavedCardTokenizeIntent$default(context, savedBankCardPaymentParameters, null, null, 12, null);
    }

    public static /* synthetic */ Intent createSavedCardTokenizeIntent$default(Context context, SavedBankCardPaymentParameters savedBankCardPaymentParameters, TestParameters testParameters, UiParameters uiParameters, int i, Object obj) {
        if ((i & 4) != 0) {
            testParameters = new TestParameters(false, false, null, null, null, 31, null);
        }
        if ((i & 8) != 0) {
            uiParameters = new UiParameters(false, null, 3, null);
        }
        return createSavedCardTokenizeIntent(context, savedBankCardPaymentParameters, testParameters, uiParameters);
    }

    @JvmStatic
    @Keep
    public static final Intent createScanBankCardIntent(String cardNumber, int expirationMonth, int expirationYear) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        if (cardNumber.length() > 23) {
            throw new IllegalArgumentException("cardNumber should be no more than 23 symbols length");
        }
        if (1 > expirationMonth || expirationMonth >= 13) {
            throw new IllegalArgumentException("expirationMonth should be between 1 and 12");
        }
        if (expirationYear < 0 || expirationYear >= 100) {
            throw new IllegalArgumentException("expirationYear should be last 2 digits of year");
        }
        Intent intentPutExtra = new Intent().putExtra(BankCardViewKt.EXTRA_CARD_NUMBER, cardNumber).putExtra(BankCardViewKt.EXTRA_EXPIRY_MONTH, expirationMonth).putExtra(BankCardViewKt.EXTRA_EXPIRY_YEAR, expirationYear);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @JvmStatic
    @Keep
    public static final TokenizationResult createTokenizationResult(Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String stringExtra = data.getStringExtra(CheckoutActivityKt.EXTRA_PAYMENT_TOKEN);
        if (stringExtra == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "requireNotNull(...)");
        Serializable serializableExtra = data.getSerializableExtra("ru.yoomoney.sdk.kassa.payments.extra.PAYMENT_METHOD_TYPE");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType");
        return new TokenizationResult(stringExtra, (PaymentMethodType) serializableExtra);
    }

    @JvmStatic
    @Keep
    public static final Intent createTokenizeIntent(Context context, PaymentParameters paymentParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        return createTokenizeIntent$default(context, paymentParameters, null, null, 12, null);
    }

    public static /* synthetic */ Intent createTokenizeIntent$default(Context context, PaymentParameters paymentParameters, TestParameters testParameters, UiParameters uiParameters, int i, Object obj) {
        if ((i & 4) != 0) {
            testParameters = new TestParameters(false, false, null, null, null, 31, null);
        }
        if ((i & 8) != 0) {
            uiParameters = new UiParameters(false, null, 3, null);
        }
        return createTokenizeIntent(context, paymentParameters, testParameters, uiParameters);
    }

    @Deprecated
    @JvmStatic
    @Keep
    public static final Intent create3dsIntent(Context context, String url, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        return create3dsIntent$default(context, url, colorScheme, null, 8, null);
    }

    @JvmStatic
    @Keep
    public static final Intent createConfirmationIntent(Context context, String confirmationUrl, PaymentMethodType paymentMethodType, String clientApplicationKey, String shopId, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        return createConfirmationIntent$default(context, confirmationUrl, paymentMethodType, clientApplicationKey, shopId, colorScheme, null, 64, null);
    }

    @JvmStatic
    @Keep
    public static final Intent createSavedCardTokenizeIntent(Context context, SavedBankCardPaymentParameters savedBankCardPaymentParameters, TestParameters testParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(savedBankCardPaymentParameters, "savedBankCardPaymentParameters");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        return createSavedCardTokenizeIntent$default(context, savedBankCardPaymentParameters, testParameters, null, 8, null);
    }

    @JvmStatic
    @Keep
    public static final Intent createTokenizeIntent(Context context, PaymentParameters paymentParameters, TestParameters testParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        return createTokenizeIntent$default(context, paymentParameters, testParameters, null, 8, null);
    }

    @Deprecated
    @JvmStatic
    @Keep
    public static final Intent create3dsIntent(Context context, String url, ColorScheme colorScheme, TestParameters testParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        c.a(url);
        InMemoryColorSchemeRepository.INSTANCE.setColorScheme(colorScheme);
        int i = WebViewActivity.$r8$clinit;
        return ru.yoomoney.sdk.kassa.payments.threeDS.a.a(context, url, "openScreen3ds", testParameters);
    }

    @JvmStatic
    @Keep
    public static final Intent createConfirmationIntent(Context context, String confirmationUrl, PaymentMethodType paymentMethodType, String clientApplicationKey, String shopId, ColorScheme colorScheme, TestParameters testParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        InMemoryColorSchemeRepository.INSTANCE.setColorScheme(colorScheme);
        int i = a.a[paymentMethodType.ordinal()];
        if (i != 1 && i != 2) {
            c.a(confirmationUrl);
            int i2 = WebViewActivity.$r8$clinit;
            return ru.yoomoney.sdk.kassa.payments.threeDS.a.a(context, confirmationUrl, "openScreen3ds", testParameters);
        }
        int i3 = ConfirmationActivity.$r8$clinit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentMethodType, "paymentMethodType");
        Intrinsics.checkNotNullParameter(clientApplicationKey, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intent intentPutExtra = new Intent(context, (Class<?>) ConfirmationActivity.class).putExtra("ru.yoomoney.sdk.kassa.payments.extra.EXTRA_CONFIRMATION_URL", confirmationUrl).putExtra("ru.yoomoney.sdk.kassa.payments.extra.PAYMENT_METHOD_TYPE", paymentMethodType).putExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS, testParameters).putExtra("ru.yoomoney.sdk.kassa.payments.extra.EXTRA_SHOP_ID", shopId).putExtra("ru.yoomoney.sdk.kassa.payments.extra.EXTRA_CLIENT_APPLICATION_KEY", clientApplicationKey).putExtra("ru.yoomoney.sdk.kassa.payments.extra.EXTRA_COLOR_SCHEME", colorScheme);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @JvmStatic
    @Keep
    public static final Intent createSavedCardTokenizeIntent(Context context, SavedBankCardPaymentParameters savedBankCardPaymentParameters, TestParameters testParameters, UiParameters uiParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(savedBankCardPaymentParameters, "savedBankCardPaymentParameters");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        Intent intentPutExtra = new Intent(context, (Class<?>) CheckoutActivity.class).putExtra(CheckoutActivityKt.EXTRA_UI_PARAMETERS, uiParameters).putExtra(CheckoutActivityKt.EXTRA_CSC_PARAMETERS, savedBankCardPaymentParameters).putExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS, testParameters).putExtra(CheckoutActivityKt.EXTRA_CREATED_WITH_CHECKOUT_METHOD, true);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @JvmStatic
    @Keep
    public static final Intent createTokenizeIntent(Context context, PaymentParameters paymentParameters, TestParameters testParameters, UiParameters uiParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        Intent intentPutExtra = new Intent(context, (Class<?>) CheckoutActivity.class).putExtra(CheckoutActivityKt.EXTRA_UI_PARAMETERS, uiParameters).putExtra(CheckoutActivityKt.EXTRA_PAYMENT_PARAMETERS, paymentParameters).putExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS, testParameters).putExtra(CheckoutActivityKt.EXTRA_CREATED_WITH_CHECKOUT_METHOD, true);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }
}
