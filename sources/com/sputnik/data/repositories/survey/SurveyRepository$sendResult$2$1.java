package com.sputnik.data.repositories.survey;

import com.sputnik.data.entities.survey.DataSurveyResult;
import com.sputnik.data.mappers.survey.DataSurveyResultToDomainSurveyResultMapper;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SurveyRepository$sendResult$2$1 extends FunctionReferenceImpl implements Function1<DataSurveyResult, DomainSurveyResult> {
    SurveyRepository$sendResult$2$1(Object obj) {
        super(1, obj, DataSurveyResultToDomainSurveyResultMapper.class, "map", "map(Lcom/sputnik/data/entities/survey/DataSurveyResult;)Lcom/sputnik/domain/entities/survey/DomainSurveyResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainSurveyResult invoke(DataSurveyResult p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataSurveyResultToDomainSurveyResultMapper) this.receiver).map(p0);
    }
}
