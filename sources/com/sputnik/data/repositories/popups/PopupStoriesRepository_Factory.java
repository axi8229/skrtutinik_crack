package com.sputnik.data.repositories.popups;

import com.sputnik.data.api.PopupStoriesApi;
import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.mappers.popups.DataPopupStoryToDomainPopupStoryMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PopupStoriesRepository_Factory implements Factory<PopupStoriesRepository> {
    private final Provider<NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure>> mapperProvider;
    private final Provider<DataPopupStoryToDomainPopupStoryMapper> objectMapperProvider;
    private final Provider<PopupStoriesApi> popupStoriesApiProvider;

    public PopupStoriesRepository_Factory(Provider<PopupStoriesApi> provider, Provider<NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure>> provider2, Provider<DataPopupStoryToDomainPopupStoryMapper> provider3) {
        this.popupStoriesApiProvider = provider;
        this.mapperProvider = provider2;
        this.objectMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public PopupStoriesRepository get() {
        return newInstance(this.popupStoriesApiProvider.get(), this.mapperProvider.get(), this.objectMapperProvider.get());
    }

    public static PopupStoriesRepository_Factory create(Provider<PopupStoriesApi> provider, Provider<NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure>> provider2, Provider<DataPopupStoryToDomainPopupStoryMapper> provider3) {
        return new PopupStoriesRepository_Factory(provider, provider2, provider3);
    }

    public static PopupStoriesRepository newInstance(PopupStoriesApi popupStoriesApi, NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> nullableInputListMapper, DataPopupStoryToDomainPopupStoryMapper dataPopupStoryToDomainPopupStoryMapper) {
        return new PopupStoriesRepository(popupStoriesApi, nullableInputListMapper, dataPopupStoryToDomainPopupStoryMapper);
    }
}
