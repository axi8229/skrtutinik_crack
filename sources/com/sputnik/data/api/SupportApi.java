package com.sputnik.data.api;

import com.sputnik.data.entities.faq.DataFaqObject;
import com.sputnik.data.entities.support.DataAnnounce;
import com.sputnik.data.entities.support.DataCompanyContacts;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: SupportApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/sputnik/data/api/SupportApi;", "", "", "locale", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/faq/DataFaqObject;", "getFaq2", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sputnik/data/entities/support/DataAnnounce;", "getAnnounce", "addressId", "Lcom/sputnik/data/entities/support/DataCompanyContacts;", "getCompanyContacts", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SupportApi {
    @GET("support/announce")
    Object getAnnounce(@Query("locale") String str, Continuation<? super Response<DataAnnounce>> continuation);

    @GET("support/addresses/{addressId}/contacts")
    Object getCompanyContacts(@Path("addressId") String str, Continuation<? super Response<DataCompanyContacts>> continuation);

    @GET("support/faq")
    Object getFaq2(@Query("locale") String str, Continuation<? super Response<List<DataFaqObject>>> continuation);
}
