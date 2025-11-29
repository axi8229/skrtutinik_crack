package com.sputnik.data.api;

import com.sputnik.data.entities.family.DataFamily;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/* compiled from: FamilyApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ'\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/sputnik/data/api/FamilyApi;", "", "deleteFromFamily", "Lretrofit2/Response;", "", "addressId", "", "citizenId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFamily", "", "Lcom/sputnik/data/entities/family/DataFamily;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeAdmin", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FamilyApi {
    @PATCH("addresses/{addressId}/family/citizens/{citizen_id}/expel")
    Object deleteFromFamily(@Path("addressId") String str, @Path("citizen_id") int i, Continuation<? super Response<Unit>> continuation);

    @GET("addresses/{addressId}/family")
    Object getFamily(@Path("addressId") String str, Continuation<? super Response<List<DataFamily>>> continuation);

    @PATCH("addresses/{addressId}/family/citizens/{citizen_id}/hand_over_head")
    Object makeAdmin(@Path("addressId") String str, @Path("citizen_id") int i, Continuation<? super Response<Unit>> continuation);
}
