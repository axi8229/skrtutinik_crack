package com.sputnik.data.mappers.stories;

import com.sputnik.data.entities.stories.DataStoriesButton;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataStoryToDomainStoryMapper_Factory implements Factory<DataStoryToDomainStoryMapper> {
    private final Provider<NullableInputListMapper<DataStoriesButton, DomainStoriesButton>> mapperProvider;

    public DataStoryToDomainStoryMapper_Factory(Provider<NullableInputListMapper<DataStoriesButton, DomainStoriesButton>> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataStoryToDomainStoryMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DataStoryToDomainStoryMapper_Factory create(Provider<NullableInputListMapper<DataStoriesButton, DomainStoriesButton>> provider) {
        return new DataStoryToDomainStoryMapper_Factory(provider);
    }

    public static DataStoryToDomainStoryMapper newInstance(NullableInputListMapper<DataStoriesButton, DomainStoriesButton> nullableInputListMapper) {
        return new DataStoryToDomainStoryMapper(nullableInputListMapper);
    }
}
