package com.sputnik.common.di.use_cases.popups;

import com.sputnik.domain.repositories.popups.IPopupStoriesRepository;
import com.sputnik.domain.usecases.popups.SendPopupStoriesActionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory implements Factory<SendPopupStoriesActionUseCase> {
    private final PopupStoriesUseCaseModule module;
    private final Provider<IPopupStoriesRepository> repositoryProvider;

    public PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory(PopupStoriesUseCaseModule popupStoriesUseCaseModule, Provider<IPopupStoriesRepository> provider) {
        this.module = popupStoriesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public SendPopupStoriesActionUseCase get() {
        return provideSendPopupStoriesUseCase(this.module, this.repositoryProvider.get());
    }

    public static PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory create(PopupStoriesUseCaseModule popupStoriesUseCaseModule, Provider<IPopupStoriesRepository> provider) {
        return new PopupStoriesUseCaseModule_ProvideSendPopupStoriesUseCaseFactory(popupStoriesUseCaseModule, provider);
    }

    public static SendPopupStoriesActionUseCase provideSendPopupStoriesUseCase(PopupStoriesUseCaseModule popupStoriesUseCaseModule, IPopupStoriesRepository iPopupStoriesRepository) {
        return (SendPopupStoriesActionUseCase) Preconditions.checkNotNullFromProvides(popupStoriesUseCaseModule.provideSendPopupStoriesUseCase(iPopupStoriesRepository));
    }
}
