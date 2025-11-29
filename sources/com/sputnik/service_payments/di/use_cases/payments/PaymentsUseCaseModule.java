package com.sputnik.service_payments.di.use_cases.payments;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.GetPaymentStatusUseCase;
import com.sputnik.domain.usecases.service_payments.GetReceiptByAccrualUseCase;
import com.sputnik.domain.usecases.service_payments.GetServicePaymentsUseCase;
import com.sputnik.domain.usecases.service_payments.PayIntercomUseCase;
import com.sputnik.domain.usecases.service_payments.PromisePaymentUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentsUseCaseModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/sputnik/service_payments/di/use_cases/payments/PaymentsUseCaseModule;", "", "()V", "provideGetPaymentStatusUseCase", "Lcom/sputnik/domain/usecases/service_payments/GetPaymentStatusUseCase;", "repository", "Lcom/sputnik/domain/repositories/service_payments/IServicePaymentsRepository;", "provideGetReceiptByAccrualUseCase", "Lcom/sputnik/domain/usecases/service_payments/GetReceiptByAccrualUseCase;", "provideGetServicePaymentsUseCase", "Lcom/sputnik/domain/usecases/service_payments/GetServicePaymentsUseCase;", "providePayIntercomUseCase", "Lcom/sputnik/domain/usecases/service_payments/PayIntercomUseCase;", "providePromisePaymentUseCase", "Lcom/sputnik/domain/usecases/service_payments/PromisePaymentUseCase;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PaymentsUseCaseModule {
    public final GetServicePaymentsUseCase provideGetServicePaymentsUseCase(IServicePaymentsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetServicePaymentsUseCase(repository);
    }

    public final PromisePaymentUseCase providePromisePaymentUseCase(IServicePaymentsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new PromisePaymentUseCase(repository);
    }

    public final PayIntercomUseCase providePayIntercomUseCase(IServicePaymentsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new PayIntercomUseCase(repository);
    }

    public final GetPaymentStatusUseCase provideGetPaymentStatusUseCase(IServicePaymentsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetPaymentStatusUseCase(repository);
    }

    public final GetReceiptByAccrualUseCase provideGetReceiptByAccrualUseCase(IServicePaymentsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetReceiptByAccrualUseCase(repository);
    }
}
