package com.sputnik.data.api;

import com.sputnik.data.entities.connect_intercom.DataActivationCode;
import com.sputnik.data.entities.entry.DataEntry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* compiled from: ConnectIntercomApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/sputnik/data/api/ConnectIntercomApi;", "", "connectToIntercom", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/connect_intercom/DataActivationCode;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntry", "Lcom/sputnik/data/entities/entry/DataEntry;", "entryUUID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntrySingleAddress", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ConnectIntercomApi {
    @GET("activation_code")
    Object connectToIntercom(Continuation<? super Response<DataActivationCode>> continuation);

    @GET("entries/{entry_uuid}/flats_range")
    Object getEntry(@Path("entry_uuid") String str, Continuation<? super Response<DataEntry>> continuation);

    @GET("entry/flats_range")
    Object getEntrySingleAddress(Continuation<? super Response<DataEntry>> continuation);
}
