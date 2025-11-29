package com.sputnik.data.api;

import com.sputnik.data.entities.archive.DataArchiveResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/* compiled from: ServicesApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0001\u0010\t\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/sputnik/data/api/ServicesApi;", "", "", "addressId", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/archive/DataArchiveResponse;", "getArchiveLinksUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/MultipartBody$Part;", "filePart", "", "sendFrData", "(Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServicesApi {
    @GET("addresses/{addressId}/cameras/watch_archive")
    Object getArchiveLinksUrl(@Path("addressId") String str, Continuation<? super Response<DataArchiveResponse>> continuation);

    @POST("face_recognition")
    @Multipart
    Object sendFrData(@Part MultipartBody.Part part, Continuation<? super Response<Unit>> continuation);
}
