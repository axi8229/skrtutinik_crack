package com.sputnik.data.api;

import com.sputnik.data.entities.gorserv.DataCreateTicketRequest;
import com.sputnik.data.entities.gorserv.DataCreateTicketResponse;
import com.sputnik.data.entities.gorserv.DataGorservCatalog;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: GorservApi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007JE\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sputnik/data/api/GorservApi;", "", "createTicket", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/gorserv/DataCreateTicketResponse;", "body", "Lcom/sputnik/data/entities/gorserv/DataCreateTicketRequest;", "(Lcom/sputnik/data/entities/gorserv/DataCreateTicketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCatalogs", "", "Lcom/sputnik/data/entities/gorserv/DataGorservCatalog;", "version", "", "platform", "", "app", "locale", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GorservApi {
    @POST("gorserv/tickets")
    Object createTicket(@Body DataCreateTicketRequest dataCreateTicketRequest, Continuation<? super Response<DataCreateTicketResponse>> continuation);

    @GET("gorserv/catalog")
    Object getCatalogs(@Query("version") int i, @Query("platform") String str, @Query("app") String str2, @Query("locale") String str3, Continuation<? super Response<List<DataGorservCatalog>>> continuation);
}
