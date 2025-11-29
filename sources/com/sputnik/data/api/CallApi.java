package com.sputnik.data.api;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.data.entities.call.DataCall;
import com.sputnik.data.entities.call.DataSipAccount;
import com.sputnik.data.entities.call_history.DataCallHistory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: CallApi.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJE\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/sputnik/data/api/CallApi;", "", "acceptCall", "Lretrofit2/Response;", "", FailedBinderCallBack.CALLER_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCall", "Lcom/sputnik/data/entities/call/DataCall;", "getCall", "getSipAccount", "Lcom/sputnik/data/entities/call/DataSipAccount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVisitors", "", "Lcom/sputnik/data/entities/call_history/DataCallHistory;", "addressId", "limit", "", "page", "version", "(Ljava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CallApi {
    @PUT("calls/{call_id}/accept")
    Object acceptCall(@Path("call_id") String str, Continuation<? super Response<Unit>> continuation);

    @DELETE("calls/{call_id}")
    Object deleteCall(@Path("call_id") String str, Continuation<? super Response<DataCall>> continuation);

    @GET("calls/{call_id}")
    Object getCall(@Path("call_id") String str, Continuation<? super Response<DataCall>> continuation);

    @GET("account/settings/sip")
    Object getSipAccount(Continuation<? super Response<DataSipAccount>> continuation);

    @GET("addresses/{addressId}/visitors")
    Object getVisitors(@Path("addressId") String str, @Query("limit") int i, @Query("page") int i2, @Query("version") int i3, Continuation<? super Response<List<DataCallHistory>>> continuation);

    /* compiled from: CallApi.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getVisitors$default(CallApi callApi, String str, int i, int i2, int i3, Continuation continuation, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVisitors");
            }
            if ((i4 & 8) != 0) {
                i3 = 2;
            }
            return callApi.getVisitors(str, i, i2, i3, continuation);
        }
    }
}
