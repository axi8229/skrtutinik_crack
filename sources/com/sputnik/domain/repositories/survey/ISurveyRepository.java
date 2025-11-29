package com.sputnik.domain.repositories.survey;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.survey.DomainSurvey;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ISurveyRepository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u00040\u0003H&J6\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H&JG\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/sputnik/domain/repositories/survey/ISurveyRepository;", "", "getSurvey", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/survey/DomainSurvey;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "getSurveys", "", "sendFeedback", "", "like", "", "issues", "", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "sendResult", "Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "surveyId", "optionIds", "starsCount", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ISurveyRepository {
    Flow<Resource<DomainSurvey>> getSurvey(String name);

    Flow<Resource<List<DomainSurvey>>> getSurveys();

    Flow<Resource<Unit>> sendFeedback(boolean like, List<Integer> issues, String comment);

    Flow<Resource<DomainSurveyResult>> sendResult(int surveyId, List<Integer> optionIds, Integer starsCount, String comment);
}
