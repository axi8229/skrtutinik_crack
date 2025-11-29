package com.sputnik.data.repositories.survey;

import com.sputnik.data.entities.survey.DataSurvey;
import com.sputnik.data.mappers.survey.DataSurveyToDomainSurveyMapper;
import com.sputnik.domain.entities.survey.DomainSurvey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SurveyRepository$getSurvey$2$1 extends FunctionReferenceImpl implements Function1<DataSurvey, DomainSurvey> {
    SurveyRepository$getSurvey$2$1(Object obj) {
        super(1, obj, DataSurveyToDomainSurveyMapper.class, "map", "map(Lcom/sputnik/data/entities/survey/DataSurvey;)Lcom/sputnik/domain/entities/survey/DomainSurvey;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainSurvey invoke(DataSurvey p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataSurveyToDomainSurveyMapper) this.receiver).map(p0);
    }
}
