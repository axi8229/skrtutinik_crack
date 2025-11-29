package com.sputnik.data.api;

import com.sputnik.data.entities.card.DataConfirmation;
import com.sputnik.data.entities.card.DataPayment;
import com.sputnik.data.entities.card.DataPaymentState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: CardApi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/sputnik/data/api/CardApi;", "", "addNewCard", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/card/DataConfirmation;", "body", "Lcom/sputnik/data/entities/card/DataPayment;", "(Lcom/sputnik/data/entities/card/DataPayment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastPaymentStatus", "Lcom/sputnik/data/entities/card/DataPaymentState;", "productId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCard", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CardApi {
    @POST("account/settings/tie_new_payment_method")
    Object addNewCard(@Body DataPayment dataPayment, Continuation<? super Response<DataConfirmation>> continuation);

    @GET("subscriptions/{product_id}/payments/last")
    Object getLastPaymentStatus(@Path("product_id") String str, Continuation<? super Response<DataPaymentState>> continuation);

    @PATCH("account/settings/untie_payment_method")
    Object removeCard(Continuation<? super Response<Unit>> continuation);
}
