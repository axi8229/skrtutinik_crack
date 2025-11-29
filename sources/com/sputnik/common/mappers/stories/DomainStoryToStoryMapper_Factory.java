package com.sputnik.common.mappers.stories;

import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainStoryToStoryMapper_Factory implements Factory<DomainStoryToStoryMapper> {
    private final Provider<NullableInputListMapper<DomainStoriesButton, StoryButton>> mapperProvider;

    public DomainStoryToStoryMapper_Factory(Provider<NullableInputListMapper<DomainStoriesButton, StoryButton>> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DomainStoryToStoryMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DomainStoryToStoryMapper_Factory create(Provider<NullableInputListMapper<DomainStoriesButton, StoryButton>> provider) {
        return new DomainStoryToStoryMapper_Factory(provider);
    }

    public static DomainStoryToStoryMapper newInstance(NullableInputListMapper<DomainStoriesButton, StoryButton> nullableInputListMapper) {
        return new DomainStoryToStoryMapper(nullableInputListMapper);
    }
}
