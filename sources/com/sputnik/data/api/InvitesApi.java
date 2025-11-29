package com.sputnik.data.api;

import com.sputnik.data.entities.invites.DataFamilyInvite;
import com.sputnik.data.entities.invites.DataFamilyInvites;
import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.data.entities.invites.DataManageInvites;
import com.sputnik.domain.entities.invites.DomainInvite;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: InvitesApi.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011JE\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u001d\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/api/InvitesApi;", "", "acceptInvite", "Lretrofit2/Response;", "Lcom/sputnik/domain/entities/invites/DomainInvite;", "id", "", "body", "Lcom/sputnik/data/entities/invites/DataManageInvites;", "(Ljava/lang/String;Lcom/sputnik/data/entities/invites/DataManageInvites;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "declineInvite", "deleteFamilyInvite", "Lcom/sputnik/data/entities/invites/DataFamilyInvite;", "addressId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFamilyInvites", "Lcom/sputnik/data/entities/invites/DataFamilyInvites;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInvites", "", "Lcom/sputnik/data/entities/invites/DataInvite;", "version", "", "platform", "app", "locale", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendFamilyInvite", "sendFamilyInvite", "phone", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface InvitesApi {
    @POST("citizen_invites/{id}/accept")
    Object acceptInvite(@Path("id") String str, @Body DataManageInvites dataManageInvites, Continuation<? super Response<DomainInvite>> continuation);

    @POST("citizen_invites/{id}/decline")
    Object declineInvite(@Path("id") String str, @Body DataManageInvites dataManageInvites, Continuation<? super Response<DomainInvite>> continuation);

    @DELETE("addresses/{addressId}/family/invites/{id}")
    Object deleteFamilyInvite(@Path("addressId") String str, @Path("id") String str2, Continuation<? super Response<DataFamilyInvite>> continuation);

    @GET("addresses/{addressId}/family/invites")
    Object getFamilyInvites(@Path("addressId") String str, Continuation<? super Response<DataFamilyInvites>> continuation);

    @GET("citizen_invites")
    Object getInvites(@Query("version") int i, @Query("platform") String str, @Query("app") String str2, @Query("locale") String str3, Continuation<? super Response<List<DataInvite>>> continuation);

    @PUT("addresses/{addressId}/family/invites/{id}/resend")
    Object resendFamilyInvite(@Path("addressId") String str, @Path("id") String str2, Continuation<? super Response<DataFamilyInvite>> continuation);

    @POST("addresses/{addressId}/family/invites")
    Object sendFamilyInvite(@Path("addressId") String str, @Query("phone") String str2, Continuation<? super Response<DataFamilyInvite>> continuation);
}
