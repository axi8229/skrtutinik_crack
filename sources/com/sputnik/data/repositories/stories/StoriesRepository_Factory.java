package com.sputnik.data.repositories.stories;

import com.sputnik.data.api.StoriesApi;
import com.sputnik.data.entities.stories.DataStory;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class StoriesRepository_Factory implements Factory<StoriesRepository> {
    private final Provider<NullableInputListMapper<DataStory, DomainStory>> mapperProvider;
    private final Provider<StoriesApi> storiesApiProvider;

    public StoriesRepository_Factory(Provider<StoriesApi> provider, Provider<NullableInputListMapper<DataStory, DomainStory>> provider2) {
        this.storiesApiProvider = provider;
        this.mapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public StoriesRepository get() {
        return newInstance(this.storiesApiProvider.get(), this.mapperProvider.get());
    }

    public static StoriesRepository_Factory create(Provider<StoriesApi> provider, Provider<NullableInputListMapper<DataStory, DomainStory>> provider2) {
        return new StoriesRepository_Factory(provider, provider2);
    }

    public static StoriesRepository newInstance(StoriesApi storiesApi, NullableInputListMapper<DataStory, DomainStory> nullableInputListMapper) {
        return new StoriesRepository(storiesApi, nullableInputListMapper);
    }
}
