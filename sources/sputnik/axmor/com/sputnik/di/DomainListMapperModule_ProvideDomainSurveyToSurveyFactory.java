package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.mappers.surveys.DomainSurveyToSurveyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.survey.DomainSurvey;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainSurveyToSurveyFactory implements Factory<ListMapper<DomainSurvey, Survey>> {
    public static ListMapper<DomainSurvey, Survey> provideDomainSurveyToSurvey(DomainListMapperModule domainListMapperModule, DomainSurveyToSurveyMapper domainSurveyToSurveyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainSurveyToSurvey(domainSurveyToSurveyMapper));
    }
}
