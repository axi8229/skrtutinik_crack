package com.sputnik.data.api;

import com.sputnik.data.entities.event.DataEvent;
import com.sputnik.data.entities.issues.DataIssue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: EventApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/sputnik/data/api/EventApi;", "", "Lcom/sputnik/data/entities/event/DataEvent;", "payload", "Lretrofit2/Response;", "", "eventNoVideo", "(Lcom/sputnik/data/entities/event/DataEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sputnik/data/entities/issues/DataIssue;", "event", "createIssue", "(Lcom/sputnik/data/entities/issues/DataIssue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface EventApi {
    @POST("issue_tracker/complaints")
    Object createIssue(@Body DataIssue dataIssue, Continuation<? super Response<Unit>> continuation);

    @POST("events")
    Object eventNoVideo(@Body DataEvent dataEvent, Continuation<? super Response<Unit>> continuation);
}
