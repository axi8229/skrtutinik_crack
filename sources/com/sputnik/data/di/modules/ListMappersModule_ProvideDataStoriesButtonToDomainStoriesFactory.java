package com.sputnik.data.di.modules;

import com.sputnik.data.entities.stories.DataStoriesButton;
import com.sputnik.data.mappers.stories.DataStoriesButtonToDomainStoriesButtonMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory implements Factory<NullableInputListMapper<DataStoriesButton, DomainStoriesButton>> {
    private final Provider<DataStoriesButtonToDomainStoriesButtonMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory(ListMappersModule listMappersModule, Provider<DataStoriesButtonToDomainStoriesButtonMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DataStoriesButton, DomainStoriesButton> get() {
        return provideDataStoriesButtonToDomainStories(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory create(ListMappersModule listMappersModule, Provider<DataStoriesButtonToDomainStoriesButtonMapper> provider) {
        return new ListMappersModule_ProvideDataStoriesButtonToDomainStoriesFactory(listMappersModule, provider);
    }

    public static NullableInputListMapper<DataStoriesButton, DomainStoriesButton> provideDataStoriesButtonToDomainStories(ListMappersModule listMappersModule, DataStoriesButtonToDomainStoriesButtonMapper dataStoriesButtonToDomainStoriesButtonMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataStoriesButtonToDomainStories(dataStoriesButtonToDomainStoriesButtonMapper));
    }
}
