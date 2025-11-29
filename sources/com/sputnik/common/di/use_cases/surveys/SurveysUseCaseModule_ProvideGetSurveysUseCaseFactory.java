package com.sputnik.common.di.use_cases.surveys;

import com.sputnik.domain.repositories.survey.ISurveyRepository;
import com.sputnik.domain.usecases.survey.GetSurveysUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class SurveysUseCaseModule_ProvideGetSurveysUseCaseFactory implements Factory<GetSurveysUseCase> {
    public static GetSurveysUseCase provideGetSurveysUseCase(SurveysUseCaseModule surveysUseCaseModule, ISurveyRepository iSurveyRepository) {
        return (GetSurveysUseCase) Preconditions.checkNotNullFromProvides(surveysUseCaseModule.provideGetSurveysUseCase(iSurveyRepository));
    }
}
