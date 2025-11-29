package com.sputnik.data.api;

import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.entities.popups.DataSendActionRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: PopupStoriesApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/sputnik/data/api/PopupStoriesApi;", "", "getPopups", "Lretrofit2/Response;", "", "Lcom/sputnik/data/entities/popups/DataPopupStoryStructure;", "version", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendAction", "popupId", "", "popupStoryId", "request", "Lcom/sputnik/data/entities/popups/DataSendActionRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/data/entities/popups/DataSendActionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface PopupStoriesApi {
    @GET("popups")
    Object getPopups(@Query("version") int i, Continuation<? super Response<List<DataPopupStoryStructure>>> continuation);

    @POST("popups/{popupId}/popup_stories/{popupStoryId}/popup_actions")
    Object sendAction(@Path("popupId") String str, @Path("popupStoryId") String str2, @Body DataSendActionRequest dataSendActionRequest, Continuation<? super Response<DataPopupStoryStructure>> continuation);
}
