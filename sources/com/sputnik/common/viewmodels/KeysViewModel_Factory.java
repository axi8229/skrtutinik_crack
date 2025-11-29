package com.sputnik.common.viewmodels;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.di.use_cases.keys.BlockPhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.CreatePhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.DeletePhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.GetPhysicalKeysUseCase;
import com.sputnik.common.di.use_cases.keys.UnblockPhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.UpdatePhysicalKeyCommentUseCase;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.keys.DomainPhysicalKeyToPhysicalKeyMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class KeysViewModel_Factory implements Factory<KeysViewModel> {
    private final Provider<Analytics> analyticsProvider;
    private final Provider<BlockPhysicalKeyUseCase> blockPhysicalKeyUseCaseProvider;
    private final Provider<IConfig> configProvider;
    private final Provider<CreatePhysicalKeyUseCase> createPhysicalKeyUseCaseProvider;
    private final Provider<DeletePhysicalKeyUseCase> deletePhysicalKeyUseCaseProvider;
    private final Provider<DomainPhysicalKeyToPhysicalKeyMapper> domainMapperProvider;
    private final Provider<GetPhysicalKeysUseCase> getPhysicalKeysUseCaseProvider;
    private final Provider<LocalizationStorage> localizationProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<UnblockPhysicalKeyUseCase> unblockPhysicalKeyUseCaseProvider;
    private final Provider<UpdatePhysicalKeyCommentUseCase> updatePhysicalKeyCommentUseCaseProvider;

    public KeysViewModel_Factory(Provider<GetPhysicalKeysUseCase> provider, Provider<CreatePhysicalKeyUseCase> provider2, Provider<BlockPhysicalKeyUseCase> provider3, Provider<UnblockPhysicalKeyUseCase> provider4, Provider<DeletePhysicalKeyUseCase> provider5, Provider<UpdatePhysicalKeyCommentUseCase> provider6, Provider<DomainPhysicalKeyToPhysicalKeyMapper> provider7, Provider<IConfig> provider8, Provider<PrefManager> provider9, Provider<LocalizationStorage> provider10, Provider<Analytics> provider11) {
        this.getPhysicalKeysUseCaseProvider = provider;
        this.createPhysicalKeyUseCaseProvider = provider2;
        this.blockPhysicalKeyUseCaseProvider = provider3;
        this.unblockPhysicalKeyUseCaseProvider = provider4;
        this.deletePhysicalKeyUseCaseProvider = provider5;
        this.updatePhysicalKeyCommentUseCaseProvider = provider6;
        this.domainMapperProvider = provider7;
        this.configProvider = provider8;
        this.prefManagerProvider = provider9;
        this.localizationProvider = provider10;
        this.analyticsProvider = provider11;
    }

    @Override // javax.inject.Provider
    public KeysViewModel get() {
        return newInstance(this.getPhysicalKeysUseCaseProvider.get(), this.createPhysicalKeyUseCaseProvider.get(), this.blockPhysicalKeyUseCaseProvider.get(), this.unblockPhysicalKeyUseCaseProvider.get(), this.deletePhysicalKeyUseCaseProvider.get(), this.updatePhysicalKeyCommentUseCaseProvider.get(), this.domainMapperProvider.get(), this.configProvider.get(), this.prefManagerProvider.get(), this.localizationProvider.get(), this.analyticsProvider.get());
    }

    public static KeysViewModel_Factory create(Provider<GetPhysicalKeysUseCase> provider, Provider<CreatePhysicalKeyUseCase> provider2, Provider<BlockPhysicalKeyUseCase> provider3, Provider<UnblockPhysicalKeyUseCase> provider4, Provider<DeletePhysicalKeyUseCase> provider5, Provider<UpdatePhysicalKeyCommentUseCase> provider6, Provider<DomainPhysicalKeyToPhysicalKeyMapper> provider7, Provider<IConfig> provider8, Provider<PrefManager> provider9, Provider<LocalizationStorage> provider10, Provider<Analytics> provider11) {
        return new KeysViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static KeysViewModel newInstance(GetPhysicalKeysUseCase getPhysicalKeysUseCase, CreatePhysicalKeyUseCase createPhysicalKeyUseCase, BlockPhysicalKeyUseCase blockPhysicalKeyUseCase, UnblockPhysicalKeyUseCase unblockPhysicalKeyUseCase, DeletePhysicalKeyUseCase deletePhysicalKeyUseCase, UpdatePhysicalKeyCommentUseCase updatePhysicalKeyCommentUseCase, DomainPhysicalKeyToPhysicalKeyMapper domainPhysicalKeyToPhysicalKeyMapper, IConfig iConfig, PrefManager prefManager, LocalizationStorage localizationStorage, Analytics analytics) {
        return new KeysViewModel(getPhysicalKeysUseCase, createPhysicalKeyUseCase, blockPhysicalKeyUseCase, unblockPhysicalKeyUseCase, deletePhysicalKeyUseCase, updatePhysicalKeyCommentUseCase, domainPhysicalKeyToPhysicalKeyMapper, iConfig, prefManager, localizationStorage, analytics);
    }
}
