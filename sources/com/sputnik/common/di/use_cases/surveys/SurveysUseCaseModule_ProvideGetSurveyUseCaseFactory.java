package com.sputnik.common.di.use_cases.surveys;

import com.sputnik.domain.repositories.survey.ISurveyRepository;
import com.sputnik.domain.usecases.survey.GetSurveyUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class SurveysUseCaseModule_ProvideGetSurveyUseCaseFactory implements Factory<GetSurveyUseCase> {
    public static GetSurveyUseCase provideGetSurveyUseCase(SurveysUseCaseModule surveysUseCaseModule, ISurveyRepository iSurveyRepository) {
        return (GetSurveyUseCase) Preconditions.checkNotNullFromProvides(surveysUseCaseModule.provideGetSurveyUseCase(iSurveyRepository));
    }
}
