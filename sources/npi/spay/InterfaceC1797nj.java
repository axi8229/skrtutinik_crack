package npi.spay;

import kotlin.coroutines.Continuation;
import spay.sdk.domain.model.request.AuthWithOrderIdRequestBody;
import spay.sdk.domain.model.request.AuthWithPurchaseRequestBody;
import spay.sdk.domain.model.request.ConfirmOtpRequestBody;
import spay.sdk.domain.model.request.CreateOtpSdkRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;
import spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody;
import spay.sdk.domain.model.request.PayOnlineRequestBody;
import spay.sdk.domain.model.request.PaymentBnplPlanRequestBody;
import spay.sdk.domain.model.request.PaymentOrderRequestBody;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;
import spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody;
import spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody;

/* renamed from: npi.spay.nj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1797nj {
    Object a(String str, Continuation continuation);

    Object a(String str, AuthWithOrderIdRequestBody authWithOrderIdRequestBody, Continuation continuation);

    Object a(String str, AuthWithPurchaseRequestBody authWithPurchaseRequestBody, Continuation continuation);

    Object a(String str, ConfirmOtpRequestBody confirmOtpRequestBody, Continuation continuation);

    Object a(String str, CreateOtpSdkRequestBody createOtpSdkRequestBody, Continuation continuation);

    Object a(String str, ListOfCardsWithOrderIdRequestBody listOfCardsWithOrderIdRequestBody, Continuation continuation);

    Object a(String str, ListOfCardsWithPurchaseRequestBody listOfCardsWithPurchaseRequestBody, Continuation continuation);

    Object a(String str, PayOnlineRequestBody payOnlineRequestBody, Continuation continuation);

    Object a(String str, PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, Continuation continuation);

    Object a(String str, PaymentOrderRequestBody paymentOrderRequestBody, Continuation continuation);

    Object a(String str, PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Continuation continuation);

    Object a(String str, PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody, Fm fm);

    Object a(String str, PaymentTokenWithPurchaseRequestBody paymentTokenWithPurchaseRequestBody, Continuation continuation);

    Object a(String str, SessionIdWithOrderIdRequestBody sessionIdWithOrderIdRequestBody, Continuation continuation);

    Object b(String str, PaymentBnplPlanRequestBody paymentBnplPlanRequestBody, Continuation continuation);
}
