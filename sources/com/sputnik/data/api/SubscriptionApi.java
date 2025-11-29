package com.sputnik.data.api;

import com.sputnik.data.entities.card.DataPaymentState;
import com.sputnik.data.entities.market.subscription.DataSubscriptionStart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: SubscriptionApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007JC\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/sputnik/data/api/SubscriptionApi;", "", "cancelSubscription", "Lretrofit2/Response;", "", "productId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastPaymentStatus", "Lcom/sputnik/data/entities/card/DataPaymentState;", "startSubscription", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionStart;", "plan", "paymentToken", "paymentMethod", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SubscriptionApi {
    @PATCH("subscriptions/{product_id}/stop_or_cancel")
    Object cancelSubscription(@Path("product_id") String str, Continuation<? super Response<Unit>> continuation);

    @GET("subscriptions/{product_id}/payments/last")
    Object getLastPaymentStatus(@Path("product_id") String str, Continuation<? super Response<DataPaymentState>> continuation);

    @FormUrlEncoded
    @POST("subscriptions/start")
    Object startSubscription(@Field("product_id") String str, @Field("plan") String str2, @Field("payment_token") String str3, @Field("payment_method") String str4, Continuation<? super Response<DataSubscriptionStart>> continuation);
}
