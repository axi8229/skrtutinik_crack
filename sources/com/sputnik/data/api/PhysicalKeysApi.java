package com.sputnik.data.api;

import com.sputnik.data.entities.keys.DataPhysicalKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: PhysicalKeysApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0001\u0010\f\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0001\u0010\f\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\bJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000bJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\b\b\u0001\u0010\f\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sputnik/data/api/PhysicalKeysApi;", "", "", "addressId", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/keys/DataPhysicalKey;", "getKeys", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "body", "createKey", "(Ljava/lang/String;Lcom/sputnik/data/entities/keys/DataPhysicalKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uuid", "blockKey", "unblockKey", "updateComment", "", "deleteKey", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PhysicalKeysApi {
    @PATCH("licensed_keys/{uuid}/block")
    Object blockKey(@Path("uuid") String str, Continuation<? super Response<DataPhysicalKey>> continuation);

    @POST("addresses/{addressId}/licensed_keys")
    Object createKey(@Path("addressId") String str, @Body DataPhysicalKey dataPhysicalKey, Continuation<? super Response<DataPhysicalKey>> continuation);

    @DELETE("licensed_keys/{uuid}")
    Object deleteKey(@Path("uuid") String str, Continuation<? super Response<Unit>> continuation);

    @GET("addresses/{addressId}/licensed_keys")
    Object getKeys(@Path("addressId") String str, Continuation<? super Response<List<DataPhysicalKey>>> continuation);

    @PATCH("licensed_keys/{uuid}/unblock")
    Object unblockKey(@Path("uuid") String str, Continuation<? super Response<DataPhysicalKey>> continuation);

    @PATCH("licensed_keys/{uuid}")
    Object updateComment(@Path("uuid") String str, @Body DataPhysicalKey dataPhysicalKey, Continuation<? super Response<DataPhysicalKey>> continuation);
}
