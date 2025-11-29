package com.sputnik.data.api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.entities.profile.DataProfile;
import com.sputnik.data.entities.profile.UpdateCallEnabled;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/* compiled from: ProfileApi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010!\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010#\u001a\u00020\u000b2\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/sputnik/data/api/ProfileApi;", "", "bindToFlat", "Lretrofit2/Response;", "", "number", "", "addressId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeAvatar", "avatar", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivateAccount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivateAddress", "id", "deleteAccount", "deleteFr", "getProfile", "Lcom/sputnik/data/entities/profile/DataProfile;", "logout", "resetAddress", "sendCallEnabled", "body", "Lcom/sputnik/data/entities/profile/UpdateCallEnabled;", "(Lcom/sputnik/data/entities/profile/UpdateCallEnabled;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPushToken", "token", "sendTimezone", "timezone", "unlinkAddress", "updateUserLocalization", "localization", "updateUserName", AppMeasurementSdk.ConditionalUserProperty.NAME, "surName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyAddress", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ProfileApi {
    @FormUrlEncoded
    @POST("account/bind_to_flat")
    Object bindToFlat(@Field("apartment") int i, @Field("address_id") int i2, Continuation<? super Response<Unit>> continuation);

    @FormUrlEncoded
    @PUT("account/settings")
    Object changeAvatar(@Field("avatar") String str, Continuation<? super Response<Unit>> continuation);

    @PUT("account/deactivate")
    Object deactivateAccount(Continuation<? super Response<Unit>> continuation);

    @PATCH("addresses/{id}/deactivate")
    Object deactivateAddress(@Path("id") String str, Continuation<? super Response<Unit>> continuation);

    @DELETE("account")
    Object deleteAccount(Continuation<? super Response<Unit>> continuation);

    @DELETE("face_recognition")
    Object deleteFr(Continuation<? super Response<Unit>> continuation);

    @GET("account/settings")
    Object getProfile(Continuation<? super Response<DataProfile>> continuation);

    @POST("account/logout")
    Object logout(Continuation<? super Response<Unit>> continuation);

    @PATCH("account/reset_address")
    Object resetAddress(Continuation<? super Response<Unit>> continuation);

    @PUT("account/settings")
    Object sendCallEnabled(@Body UpdateCallEnabled updateCallEnabled, Continuation<? super Response<Unit>> continuation);

    @FormUrlEncoded
    @PUT("account/settings")
    Object sendPushToken(@Field("device_push_token") String str, Continuation<? super Response<Unit>> continuation);

    @FormUrlEncoded
    @PUT("account/settings")
    Object sendTimezone(@Field("timezone") String str, Continuation<? super Response<Unit>> continuation);

    @PATCH("addresses/{id}/reset")
    Object unlinkAddress(@Path("id") String str, Continuation<? super Response<Unit>> continuation);

    @FormUrlEncoded
    @PUT("account/settings")
    Object updateUserLocalization(@Field("localization") String str, Continuation<? super Response<Unit>> continuation);

    @FormUrlEncoded
    @PUT("account/settings")
    Object updateUserName(@Field("first_name") String str, @Field("last_name") String str2, Continuation<? super Response<Unit>> continuation);

    @PUT("addresses/{id}/verify")
    Object verifyAddress(@Path("id") String str, Continuation<? super Response<Unit>> continuation);

    /* compiled from: ProfileApi.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object updateUserName$default(ProfileApi profileApi, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateUserName");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return profileApi.updateUserName(str, str2, continuation);
        }
    }
}
