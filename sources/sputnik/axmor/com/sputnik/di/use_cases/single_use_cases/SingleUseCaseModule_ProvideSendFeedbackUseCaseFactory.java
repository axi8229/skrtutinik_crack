package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.survey.ISurveyRepository;
import com.sputnik.domain.usecases.survey.SendFeedbackUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class SingleUseCaseModule_ProvideSendFeedbackUseCaseFactory implements Factory<SendFeedbackUseCase> {
    public static SendFeedbackUseCase provideSendFeedbackUseCase(SingleUseCaseModule singleUseCaseModule, ISurveyRepository iSurveyRepository) {
        return (SendFeedbackUseCase) Preconditions.checkNotNullFromProvides(singleUseCaseModule.provideSendFeedbackUseCase(iSurveyRepository));
    }
}
