package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.survey.ISurveyRepository;
import com.sputnik.domain.usecases.survey.SendResultUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SingleUseCaseModule_ProvideSendResultUseCaseFactory implements Factory<SendResultUseCase> {
    public static SendResultUseCase provideSendResultUseCase(SingleUseCaseModule singleUseCaseModule, ISurveyRepository iSurveyRepository) {
        return (SendResultUseCase) Preconditions.checkNotNullFromProvides(singleUseCaseModule.provideSendResultUseCase(iSurveyRepository));
    }
}
