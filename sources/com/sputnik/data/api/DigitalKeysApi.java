package com.sputnik.data.api;

import com.sputnik.data.entities.digital_keys.DataDigitalKey;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: DigitalKeysApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/sputnik/data/api/DigitalKeysApi;", "", "", "addressId", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/digital_keys/DataDigitalKey;", "getDigitalKeysForAddress", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "setDigitalKeyForAddress", "(Ljava/lang/String;Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uuid", "deleteDigitalKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DigitalKeysApi {
    @DELETE("addresses/{addressId}/digital_keys/{uuid}")
    Object deleteDigitalKey(@Path("addressId") String str, @Path("uuid") String str2, Continuation<? super Response<DataDigitalKey>> continuation);

    @GET("addresses/{addressId}/digital_keys")
    Object getDigitalKeysForAddress(@Path("addressId") String str, Continuation<? super Response<List<DataDigitalKey>>> continuation);

    @FormUrlEncoded
    @POST("addresses/{addressId}/digital_keys")
    Object setDigitalKeyForAddress(@Path("addressId") String str, @Field("type") TypeDigitalKey typeDigitalKey, Continuation<? super Response<DataDigitalKey>> continuation);
}
