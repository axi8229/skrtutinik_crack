package com.sputnik.data.di.modules;

import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.data.mappers.stories.DataStoryToDomainStoryMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataStoryToDomainStoryFactory implements Factory<NullableInputListMapper<DataStory, DomainStory>> {
    private final Provider<DataStoryToDomainStoryMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataStoryToDomainStoryFactory(ListMappersModule listMappersModule, Provider<DataStoryToDomainStoryMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DataStory, DomainStory> get() {
        return provideDataStoryToDomainStory(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataStoryToDomainStoryFactory create(ListMappersModule listMappersModule, Provider<DataStoryToDomainStoryMapper> provider) {
        return new ListMappersModule_ProvideDataStoryToDomainStoryFactory(listMappersModule, provider);
    }

    public static NullableInputListMapper<DataStory, DomainStory> provideDataStoryToDomainStory(ListMappersModule listMappersModule, DataStoryToDomainStoryMapper dataStoryToDomainStoryMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataStoryToDomainStory(dataStoryToDomainStoryMapper));
    }
}
