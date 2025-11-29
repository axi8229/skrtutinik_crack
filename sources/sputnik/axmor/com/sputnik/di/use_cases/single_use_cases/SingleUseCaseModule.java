package sputnik.axmor.com.sputnik.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.archive.IArchiveRepository;
import com.sputnik.domain.repositories.fr_service.IFrServiceRepository;
import com.sputnik.domain.repositories.help.IHelpRepository;
import com.sputnik.domain.repositories.survey.ISurveyRepository;
import com.sputnik.domain.usecases.archive.GetArchiveSdkUrlUseCase;
import com.sputnik.domain.usecases.archive.GetArchiveUrlsUseCase;
import com.sputnik.domain.usecases.fr_service.UpdateFrUseCase;
import com.sputnik.domain.usecases.help.GetCompaniesUseCase;
import com.sputnik.domain.usecases.survey.SendFeedbackUseCase;
import com.sputnik.domain.usecases.survey.SendResultUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;

/* compiled from: SingleUseCaseModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u000eH\u0007J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/single_use_cases/SingleUseCaseModule;", "", "()V", "provideGetArchiveSdkUrlUseCase", "Lcom/sputnik/domain/usecases/archive/GetArchiveSdkUrlUseCase;", "repository", "Lcom/sputnik/domain/repositories/archive/IArchiveRepository;", "provideGetArchiveUrlsUseCase", "Lcom/sputnik/domain/usecases/archive/GetArchiveUrlsUseCase;", "provideGetCompaniesUseCase", "Lcom/sputnik/domain/usecases/help/GetCompaniesUseCase;", "Lcom/sputnik/domain/repositories/help/IHelpRepository;", "provideSendFeedbackUseCase", "Lcom/sputnik/domain/usecases/survey/SendFeedbackUseCase;", "Lcom/sputnik/domain/repositories/survey/ISurveyRepository;", "provideSendResultUseCase", "Lcom/sputnik/domain/usecases/survey/SendResultUseCase;", "provideUpdateFrUseCase", "Lcom/sputnik/domain/usecases/fr_service/UpdateFrUseCase;", "Lokhttp3/MultipartBody$Part;", "Lcom/sputnik/domain/repositories/fr_service/IFrServiceRepository;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleUseCaseModule {
    public final GetArchiveSdkUrlUseCase provideGetArchiveSdkUrlUseCase(IArchiveRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetArchiveSdkUrlUseCase(repository);
    }

    public final GetArchiveUrlsUseCase provideGetArchiveUrlsUseCase(IArchiveRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetArchiveUrlsUseCase(repository);
    }

    public final UpdateFrUseCase<MultipartBody.Part> provideUpdateFrUseCase(IFrServiceRepository<MultipartBody.Part> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new UpdateFrUseCase<>(repository);
    }

    public final GetCompaniesUseCase provideGetCompaniesUseCase(IHelpRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCompaniesUseCase(repository);
    }

    public final SendFeedbackUseCase provideSendFeedbackUseCase(ISurveyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendFeedbackUseCase(repository);
    }

    public final SendResultUseCase provideSendResultUseCase(ISurveyRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendResultUseCase(repository);
    }
}
