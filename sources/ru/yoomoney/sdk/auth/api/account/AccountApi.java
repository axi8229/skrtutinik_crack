package ru.yoomoney.sdk.auth.api.account;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.yoomoney.sdk.auth.api.account.method.DisplayNameRequest;
import ru.yoomoney.sdk.auth.api.account.method.LanguageRequest;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/AccountApi;", "", "account", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayName", "request", "Lru/yoomoney/sdk/auth/api/account/method/DisplayNameRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/method/DisplayNameRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "Lru/yoomoney/sdk/auth/api/account/method/LanguageRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/method/LanguageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revoke", "", "revokeAll", "Lretrofit2/Call;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AccountApi {
    @GET("account")
    Object account(@Header("Authorization") String str, Continuation<? super Response<UserAccount>> continuation);

    @POST("account/display-name")
    Object displayName(@Header("Authorization") String str, @Body DisplayNameRequest displayNameRequest, Continuation<? super Response<UserAccount>> continuation);

    @POST("account/language")
    Object language(@Header("Authorization") String str, @Body LanguageRequest languageRequest, Continuation<? super Response<UserAccount>> continuation);

    @POST("account/revoke")
    Object revoke(@Header("Authorization") String str, Continuation<? super Response<Unit>> continuation);

    @POST("account/revoke-all")
    Call<Unit> revokeAll(@Header("Authorization") String token);
}
