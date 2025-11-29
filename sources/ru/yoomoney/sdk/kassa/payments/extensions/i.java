package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.b0;
import ru.yoomoney.sdk.kassa.payments.metrics.P;
import ru.yoomoney.sdk.kassa.payments.metrics.S;
import ru.yoomoney.sdk.kassa.payments.metrics.U;
import ru.yoomoney.sdk.kassa.payments.metrics.W;
import ru.yoomoney.sdk.kassa.payments.metrics.X;
import ru.yoomoney.sdk.kassa.payments.metrics.Y;
import ru.yoomoney.sdk.kassa.payments.metrics.Z;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.AbstractWallet;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;
import ru.yoomoney.sdk.kassa.payments.model.C2340y;
import ru.yoomoney.sdk.kassa.payments.model.I;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.PaymentIdCscConfirmation;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.SBP;
import ru.yoomoney.sdk.kassa.payments.model.SberBank;
import ru.yoomoney.sdk.kassa.payments.model.T;
import ru.yoomoney.sdk.kassa.payments.model.Wallet;
import ru.yoomoney.sdk.kassa.payments.model.a0;
import ru.yoomoney.sdk.kassa.payments.model.x0;
import spay.sdk.SPaySdkApp;

/* loaded from: classes5.dex */
public abstract class i {
    public static final String a = T.class.getSimpleName();

    public static final AbstractC2335t a(T t, Context context, String returnUrl, String appScheme) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(returnUrl, "returnUrl");
        Intrinsics.checkNotNullParameter(appScheme, "appScheme");
        if ((t instanceof x0) || (t instanceof BankCardPaymentOption) || (t instanceof PaymentIdCscConfirmation)) {
            return new a0(returnUrl);
        }
        if (t instanceof SberBank) {
            SberBank sberBank = (SberBank) t;
            Context context2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
            Intrinsics.checkNotNullParameter(context2, "context");
            return sberBank.canPayWithSberPay(context, !b0.a ? false : SPaySdkApp.INSTANCE.getInstance().isReadyForSPaySdk(context2)) ? new I(a(appScheme)) : C2340y.a;
        }
        if (!(t instanceof SBP)) {
            throw new NoWhenBranchMatchedException();
        }
        if (appScheme.length() == 0) {
            Log.d(a, "Note that you didn't specify a parameter ym_app_scheme\nThere will be no return to your application");
        }
        return new I(appScheme + "://sbp-invoicing");
    }

    public static final CharSequence b(T t, Context context) {
        int i;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (t instanceof BankCardPaymentOption) {
            i = R$string.ym_payment_option_new_card;
        } else if ((t instanceof Wallet) || (t instanceof AbstractWallet)) {
            i = R$string.ym_payment_option_yoomoney;
        } else {
            if (t instanceof LinkedCard) {
                LinkedCard linkedCard = (LinkedCard) t;
                String name = linkedCard.getName();
                if (name == null || name.length() == 0) {
                    name = null;
                }
                if (name != null) {
                    return name;
                }
                return "•••• " + StringsKt.takeLast(linkedCard.getPan(), 4);
            }
            if (t instanceof SberBank) {
                i = R$string.ym_sberbank;
            } else if (t instanceof PaymentIdCscConfirmation) {
                i = R$string.ym_saved_card;
            } else {
                if (!(t instanceof SBP)) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R$string.ym_sbp;
            }
        }
        CharSequence text = context.getText(i);
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return text;
    }

    public static final Drawable a(T t, Context context) {
        int iA;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if ((t instanceof BankCardPaymentOption) || (t instanceof PaymentIdCscConfirmation)) {
            iA = R$drawable.ym_ic_add_card;
        } else if ((t instanceof Wallet) || (t instanceof AbstractWallet)) {
            iA = R$drawable.ym_ic_yoomoney;
        } else if (t instanceof LinkedCard) {
            LinkedCard linkedCard = (LinkedCard) t;
            iA = ru.yoomoney.sdk.kassa.payments.utils.b.a(linkedCard.getPan(), linkedCard.getBrand());
        } else if (t instanceof SberBank) {
            iA = R$drawable.ym_ic_sberbank;
        } else {
            if (!(t instanceof SBP)) {
                throw new NoWhenBranchMatchedException();
            }
            iA = R$drawable.ym_ic_sbp;
        }
        Drawable drawable = AppCompatResources.getDrawable(context, iA);
        if (drawable != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "checkNotNull(...)");
            return drawable;
        }
        throw new IllegalStateException(("icon not found for " + t).toString());
    }

    public static final String a(String appScheme) {
        Intrinsics.checkNotNullParameter(appScheme, "appScheme");
        return appScheme + "://invoicing/sberpay";
    }

    public static final P a(T t, Context context, Q q) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if ((t instanceof Wallet) || (t instanceof AbstractWallet)) {
            return new ru.yoomoney.sdk.kassa.payments.metrics.a0();
        }
        if (t instanceof LinkedCard) {
            return new S();
        }
        if (t instanceof BankCardPaymentOption) {
            if (q == null || !q.d) {
                return q != null ? new ru.yoomoney.sdk.kassa.payments.metrics.T() : new ru.yoomoney.sdk.kassa.payments.metrics.Q();
            }
            return new U();
        }
        if (t instanceof SberBank) {
            Context context2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
            Intrinsics.checkNotNullParameter(context2, "context");
            return ((SberBank) t).canPayWithSberPay(context, !b0.a ? false : SPaySdkApp.INSTANCE.getInstance().isReadyForSPaySdk(context2)) ? new Y() : new Z();
        }
        if (t instanceof PaymentIdCscConfirmation) {
            return new W();
        }
        if (t instanceof SBP) {
            return new X();
        }
        throw new NoWhenBranchMatchedException();
    }
}
