package com.sputnik.data.api;

import com.sputnik.data.entities.auth.DataApplyRegistration;
import com.sputnik.data.entities.auth.DataApplyRegistrationResponse;
import com.sputnik.data.entities.auth.DataConfirmRequest;
import com.sputnik.data.entities.auth.DataConfirmResponse;
import com.sputnik.data.entities.auth.DataRequestInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: AuthApi.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sputnik/data/api/AuthApi;", "", "Lcom/sputnik/data/entities/auth/DataApplyRegistration;", "request", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/auth/DataApplyRegistrationResponse;", "apply", "(Lcom/sputnik/data/entities/auth/DataApplyRegistration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "sign", "requestId", "Lcom/sputnik/data/entities/auth/DataRequestInfo;", "getRequest", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sputnik/data/entities/auth/DataConfirmRequest;", "Lcom/sputnik/data/entities/auth/DataConfirmResponse;", "confirm", "(Ljava/lang/String;Lcom/sputnik/data/entities/auth/DataConfirmRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AuthApi {
    @POST("auth2/apply")
    Object apply(@Body DataApplyRegistration dataApplyRegistration, Continuation<? super Response<DataApplyRegistrationResponse>> continuation);

    @POST("auth2/{request_id}/confirm")
    Object confirm(@Path("request_id") String str, @Body DataConfirmRequest dataConfirmRequest, Continuation<? super Response<DataConfirmResponse>> continuation);

    @GET("auth2/{request_id}")
    Object getRequest(@Header("X-Sign") String str, @Path("request_id") String str2, Continuation<? super Response<DataRequestInfo>> continuation);
}
