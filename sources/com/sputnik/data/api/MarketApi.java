package com.sputnik.data.api;

import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.entities.subscriptions.DataMarketV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: MarketApi.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0003\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/sputnik/data/api/MarketApi;", "", "getMarket", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/market/DataMarket;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarketNew", "Lcom/sputnik/data/entities/subscriptions/DataMarketV2;", "version", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServices", "Lcom/sputnik/data/entities/market/service/DataService;", "addressId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptions", "Lcom/sputnik/data/entities/market/subscription/DataSubscription;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface MarketApi {
    @GET("market")
    Object getMarket(Continuation<? super Response<List<DataMarket>>> continuation);

    @GET("market")
    Object getMarketNew(@Query("version") int i, Continuation<? super Response<DataMarketV2>> continuation);

    @GET("addresses/{addressId}/services")
    Object getServices(@Path("addressId") String str, Continuation<? super Response<List<DataService>>> continuation);

    @GET("subscriptions")
    Object getSubscriptions(Continuation<? super Response<List<DataSubscription>>> continuation);

    /* compiled from: MarketApi.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getMarketNew$default(MarketApi marketApi, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMarketNew");
            }
            if ((i2 & 1) != 0) {
                i = 2;
            }
            return marketApi.getMarketNew(i, continuation);
        }
    }
}
