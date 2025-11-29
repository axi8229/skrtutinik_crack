package ru.yoomoney.sdk.kassa.payments.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.yoomoney.sdk.kassa.payments.api.model.sbp.SbpBanksResponse;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/api/f;", "", "", "confirmationUrl", "Lkotlin/Result;", "Lru/yoomoney/sdk/kassa/payments/api/model/sbp/SbpBanksResponse;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public interface f {
    @GET("/api/frontend/v3/sbp_banks")
    Object a(@Query("confirmation_url") String str, Continuation<? super Result<SbpBanksResponse>> continuation);
}
