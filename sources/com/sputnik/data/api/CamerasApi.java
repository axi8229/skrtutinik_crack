package com.sputnik.data.api;

import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.entities.cameras.DataCameraObject;
import com.sputnik.data.entities.cameras.DataCameraPatchObject;
import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import java.util.List;
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
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: CamerasApi.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JC\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\fJ1\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0011H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0017H§@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJC\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\b\b\u0001\u0010 \u001a\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J9\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020!0\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/sputnik/data/api/CamerasApi;", "", "", "addressId", "list", "order", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/cameras/DataCamera;", "getCameras", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCamerasDemo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercomUUID", "flatUUID", "getCameraByIntercomUUID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sputnik/data/entities/cameras/DataCamerasOrder;", "getCamerasPreferences", "camerasOrder", "setCamerasOrder", "(Ljava/lang/String;Lcom/sputnik/data/entities/cameras/DataCamerasOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cameraUuid", "Lcom/sputnik/data/entities/cameras/DataCameraPatchObject;", "camera", "Lcom/sputnik/data/entities/cameras/DataCameraObject;", "setCameraParams", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/data/entities/cameras/DataCameraPatchObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceUuid", "", "isWidget", "Lcom/sputnik/domain/entities/door/OpenDoorProducers;", "producer", "", "openDoor", "(Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/domain/entities/door/OpenDoorProducers;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSecondDoor", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCamerasPreferences", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CamerasApi {
    @DELETE("addresses/{addressId}/preferences")
    Object clearCamerasPreferences(@Path("addressId") String str, Continuation<? super Response<Unit>> continuation);

    @GET("intercoms/{intercomId}/camera")
    Object getCameraByIntercomUUID(@Path("intercomId") String str, @Query("flat_uuid") String str2, Continuation<? super Response<DataCamera>> continuation);

    @GET("addresses/{addressId}/cameras?version=2")
    Object getCameras(@Path("addressId") String str, @Query("list") String str2, @Query("order") String str3, Continuation<? super Response<List<DataCamera>>> continuation);

    @GET("addresses/cameras/demo")
    Object getCamerasDemo(Continuation<? super Response<List<DataCamera>>> continuation);

    @GET("addresses/preferences")
    Object getCamerasPreferences(Continuation<? super Response<List<DataCamerasOrder>>> continuation);

    @FormUrlEncoded
    @POST("addresses/{addressId}/devices/{device_uuid}/open_door")
    Object openDoor(@Path("addressId") String str, @Path("device_uuid") String str2, @Field("widget") boolean z, @Field("producer") OpenDoorProducers openDoorProducers, Continuation<? super Response<Unit>> continuation);

    @FormUrlEncoded
    @POST("addresses/{addressId}/devices/{device_uuid}/open_second_door")
    Object openSecondDoor(@Path("addressId") String str, @Path("device_uuid") String str2, @Field("widget") boolean z, Continuation<? super Response<Unit>> continuation);

    @PATCH("addresses/{addressId}/preferences/cameras/{camera_uuid}")
    Object setCameraParams(@Path("addressId") String str, @Path("camera_uuid") String str2, @Body DataCameraPatchObject dataCameraPatchObject, Continuation<? super Response<DataCameraObject>> continuation);

    @PATCH("addresses/{addressId}/preferences")
    Object setCamerasOrder(@Path("addressId") String str, @Body DataCamerasOrder dataCamerasOrder, Continuation<? super Response<DataCamerasOrder>> continuation);
}
