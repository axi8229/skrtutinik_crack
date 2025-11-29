package com.sputnik.domain.usecases.survey;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import com.sputnik.domain.repositories.survey.ISurveyRepository;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SendResultUseCase.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/sputnik/domain/usecases/survey/SendResultUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/survey/ISurveyRepository;", "(Lcom/sputnik/domain/repositories/survey/ISurveyRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", "surveyId", "", "optionIds", "", "starsCount", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendResultUseCase {
    private final ISurveyRepository repository;

    public SendResultUseCase(ISurveyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainSurveyResult>> invoke(int surveyId, List<Integer> optionIds, Integer starsCount, String comment) {
        Intrinsics.checkNotNullParameter(optionIds, "optionIds");
        return this.repository.sendResult(surveyId, optionIds, starsCount, comment);
    }
}
