package com.sputnik.common.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.country_code.ICountryCodeRepository;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountryCodeUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/di/use_cases/single_use_cases/CountryCodeUseCaseModule;", "", "()V", "provideGetCountryCodeUseCase", "Lcom/sputnik/domain/usecases/country_code/GetCountryCodeUseCase;", "repository", "Lcom/sputnik/domain/repositories/country_code/ICountryCodeRepository;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CountryCodeUseCaseModule {
    public final GetCountryCodeUseCase provideGetCountryCodeUseCase(ICountryCodeRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetCountryCodeUseCase(repository);
    }
}
