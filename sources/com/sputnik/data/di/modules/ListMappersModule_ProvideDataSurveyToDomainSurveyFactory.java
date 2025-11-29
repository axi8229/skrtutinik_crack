package com.sputnik.data.di.modules;

import com.sputnik.data.entities.survey.DataSurvey;
import com.sputnik.data.mappers.survey.DataSurveyToDomainSurveyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.survey.DomainSurvey;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataSurveyToDomainSurveyFactory implements Factory<ListMapper<DataSurvey, DomainSurvey>> {
    public static ListMapper<DataSurvey, DomainSurvey> provideDataSurveyToDomainSurvey(ListMappersModule listMappersModule, DataSurveyToDomainSurveyMapper dataSurveyToDomainSurveyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataSurveyToDomainSurvey(dataSurveyToDomainSurveyMapper));
    }
}
