package ru.yoomoney.sdk.kassa.payments.model.mapper;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.ConfirmationType;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.ConfirmationAttrsExternalRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.ConfirmationAttrsMobileApplicationRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.ConfirmationAttrsRedirectRequest;
import ru.yoomoney.sdk.kassa.payments.api.model.tokens.ConfirmationRequest;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.C2340y;
import ru.yoomoney.sdk.kassa.payments.model.I;
import ru.yoomoney.sdk.kassa.payments.model.a0;

/* loaded from: classes5.dex */
public abstract class l {
    public static final Amount a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount amount) {
        Intrinsics.checkNotNullParameter(amount, "<this>");
        String string = amount.getValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new Amount(string, amount.getCurrency());
    }

    public static final ConfirmationRequest a(AbstractC2335t abstractC2335t) {
        ConfirmationRequest confirmationAttrsMobileApplicationRequest;
        Intrinsics.checkNotNullParameter(abstractC2335t, "<this>");
        if (abstractC2335t instanceof C2340y) {
            return new ConfirmationAttrsExternalRequest(ConfirmationType.EXTERNAL);
        }
        if (abstractC2335t instanceof a0) {
            confirmationAttrsMobileApplicationRequest = new ConfirmationAttrsRedirectRequest(ConfirmationType.REDIRECT, ((a0) abstractC2335t).a);
        } else {
            if (!(abstractC2335t instanceof I)) {
                throw new NoWhenBranchMatchedException();
            }
            confirmationAttrsMobileApplicationRequest = new ConfirmationAttrsMobileApplicationRequest(ConfirmationType.MOBILE_APPLICATION, ((I) abstractC2335t).a);
        }
        return confirmationAttrsMobileApplicationRequest;
    }
}
