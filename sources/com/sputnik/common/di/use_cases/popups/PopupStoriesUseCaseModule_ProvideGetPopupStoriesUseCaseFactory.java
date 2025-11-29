package com.sputnik.common.di.use_cases.popups;

import com.sputnik.domain.repositories.popups.IPopupStoriesRepository;
import com.sputnik.domain.usecases.popups.GetPopupStoriesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory implements Factory<GetPopupStoriesUseCase> {
    private final PopupStoriesUseCaseModule module;
    private final Provider<IPopupStoriesRepository> repositoryProvider;

    public PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory(PopupStoriesUseCaseModule popupStoriesUseCaseModule, Provider<IPopupStoriesRepository> provider) {
        this.module = popupStoriesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetPopupStoriesUseCase get() {
        return provideGetPopupStoriesUseCase(this.module, this.repositoryProvider.get());
    }

    public static PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory create(PopupStoriesUseCaseModule popupStoriesUseCaseModule, Provider<IPopupStoriesRepository> provider) {
        return new PopupStoriesUseCaseModule_ProvideGetPopupStoriesUseCaseFactory(popupStoriesUseCaseModule, provider);
    }

    public static GetPopupStoriesUseCase provideGetPopupStoriesUseCase(PopupStoriesUseCaseModule popupStoriesUseCaseModule, IPopupStoriesRepository iPopupStoriesRepository) {
        return (GetPopupStoriesUseCase) Preconditions.checkNotNullFromProvides(popupStoriesUseCaseModule.provideGetPopupStoriesUseCase(iPopupStoriesRepository));
    }
}
