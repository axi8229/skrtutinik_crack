package com.sputnik.data.api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.entities.notifications.DataNotification;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/* compiled from: NotificationsApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/sputnik/data/api/NotificationsApi;", "", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/notifications/DataNotification;", "getNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnviewedNotifications", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "body", "updateNotification", "(Ljava/lang/String;Lcom/sputnik/data/entities/notifications/DataNotification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface NotificationsApi {
    @GET("notifications")
    Object getNotifications(Continuation<? super Response<List<DataNotification>>> continuation);

    @GET("notifications?unviewed=1&limit=1")
    Object getUnviewedNotifications(Continuation<? super Response<List<DataNotification>>> continuation);

    @PATCH("notifications/{id}")
    Object updateNotification(@Path("id") String str, @Body DataNotification dataNotification, Continuation<? super Response<DataNotification>> continuation);
}
