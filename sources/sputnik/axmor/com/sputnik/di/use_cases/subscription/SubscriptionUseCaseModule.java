package sputnik.axmor.com.sputnik.di.use_cases.subscription;

import com.sputnik.domain.repositories.subscription.ISubscriptionRepository;
import com.sputnik.domain.usecases.subscription.GetLastCardPaymentUseCase;
import com.sputnik.domain.usecases.subscription.StartSubscriptionUseCase;
import com.sputnik.domain.usecases.subscription.StopSubscriptionUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionUseCaseModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/di/use_cases/subscription/SubscriptionUseCaseModule;", "", "()V", "provideGetLastCardPaymentUseCase", "Lcom/sputnik/domain/usecases/subscription/GetLastCardPaymentUseCase;", "repository", "Lcom/sputnik/domain/repositories/subscription/ISubscriptionRepository;", "provideStartSubscriptionUseCase", "Lcom/sputnik/domain/usecases/subscription/StartSubscriptionUseCase;", "provideStopSubscriptionUseCase", "Lcom/sputnik/domain/usecases/subscription/StopSubscriptionUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionUseCaseModule {
    public final GetLastCardPaymentUseCase provideGetLastCardPaymentUseCase(ISubscriptionRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetLastCardPaymentUseCase(repository);
    }

    public final StartSubscriptionUseCase provideStartSubscriptionUseCase(ISubscriptionRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new StartSubscriptionUseCase(repository);
    }

    public final StopSubscriptionUseCase provideStopSubscriptionUseCase(ISubscriptionRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new StopSubscriptionUseCase(repository);
    }
}
