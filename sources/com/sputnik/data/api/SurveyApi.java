package com.sputnik.data.api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.data.entities.survey.DataSurvey;
import com.sputnik.data.entities.survey.DataSurveyRequest;
import com.sputnik.data.entities.survey.DataSurveyResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: SurveyApi.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\r\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/sputnik/data/api/SurveyApi;", "", "getSurvey", "Lretrofit2/Response;", "Lcom/sputnik/data/entities/survey/DataSurvey;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSurveys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFeedback", "", "surveyRequest", "Lcom/sputnik/data/entities/survey/DataSurveyRequest;", "(Lcom/sputnik/data/entities/survey/DataSurveyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendResult", "Lcom/sputnik/data/entities/survey/DataSurveyResult;", "(Lcom/sputnik/data/entities/survey/DataSurveyResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SurveyApi {
    @GET("surveys/{name}")
    Object getSurvey(@Path(AppMeasurementSdk.ConditionalUserProperty.NAME) String str, Continuation<? super Response<DataSurvey>> continuation);

    @GET("surveys")
    Object getSurveys(Continuation<? super Response<List<DataSurvey>>> continuation);

    @POST("feedbacks")
    Object sendFeedback(@Body DataSurveyRequest dataSurveyRequest, Continuation<? super Response<Unit>> continuation);

    @POST("surveys/result")
    Object sendResult(@Body DataSurveyResult dataSurveyResult, Continuation<? super Response<DataSurveyResult>> continuation);
}
