package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.usecases.popups.GetPopupStoriesUseCase;
import com.sputnik.domain.usecases.popups.SendPopupStoriesActionUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PopupStoriesViewModel_Factory implements Factory<PopupStoriesViewModel> {
    private final Provider<IConfig> configProvider;
    private final Provider<NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure>> domainPopupStoriesToPopupStoriesMapperProvider;
    private final Provider<GetPopupStoriesUseCase> getPopupStoriesUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<SendPopupStoriesActionUseCase> sendPopupStoryActionUseCaseProvider;

    public PopupStoriesViewModel_Factory(Provider<PrefManager> provider, Provider<IConfig> provider2, Provider<GetPopupStoriesUseCase> provider3, Provider<SendPopupStoriesActionUseCase> provider4, Provider<NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure>> provider5) {
        this.prefManagerProvider = provider;
        this.configProvider = provider2;
        this.getPopupStoriesUseCaseProvider = provider3;
        this.sendPopupStoryActionUseCaseProvider = provider4;
        this.domainPopupStoriesToPopupStoriesMapperProvider = provider5;
    }

    @Override // javax.inject.Provider
    public PopupStoriesViewModel get() {
        return newInstance(this.prefManagerProvider.get(), this.configProvider.get(), this.getPopupStoriesUseCaseProvider.get(), this.sendPopupStoryActionUseCaseProvider.get(), this.domainPopupStoriesToPopupStoriesMapperProvider.get());
    }

    public static PopupStoriesViewModel_Factory create(Provider<PrefManager> provider, Provider<IConfig> provider2, Provider<GetPopupStoriesUseCase> provider3, Provider<SendPopupStoriesActionUseCase> provider4, Provider<NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure>> provider5) {
        return new PopupStoriesViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PopupStoriesViewModel newInstance(PrefManager prefManager, IConfig iConfig, GetPopupStoriesUseCase getPopupStoriesUseCase, SendPopupStoriesActionUseCase sendPopupStoriesActionUseCase, NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> nullableInputListMapper) {
        return new PopupStoriesViewModel(prefManager, iConfig, getPopupStoriesUseCase, sendPopupStoriesActionUseCase, nullableInputListMapper);
    }
}
