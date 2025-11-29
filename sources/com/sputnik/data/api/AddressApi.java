package com.sputnik.data.api;

import com.sputnik.data.entities.address.DataCustomAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: AddressApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJS\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/sputnik/data/api/AddressApi;", "", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/address/DataCustomAddress;", "getCustomAddresses", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "city", "street", "house", "flat", "setCustomAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uuid", "updateCustomAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AddressApi {
    @GET("custom_addresses")
    Object getCustomAddresses(Continuation<? super Response<List<DataCustomAddress>>> continuation);

    @POST("custom_addresses")
    Object setCustomAddress(@Query("city") String str, @Query("street") String str2, @Query("house") String str3, @Query("flat") String str4, Continuation<? super Response<DataCustomAddress>> continuation);

    @PATCH("custom_addresses/{uuid}")
    Object updateCustomAddress(@Path("uuid") String str, @Query("city") String str2, @Query("street") String str3, @Query("house") String str4, @Query("flat") String str5, Continuation<? super Response<DataCustomAddress>> continuation);
}
