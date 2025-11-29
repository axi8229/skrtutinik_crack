package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.mappers.popup.DomainPopupStoriesToPopupStoriesMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory implements Factory<NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure>> {
    private final Provider<DomainPopupStoriesToPopupStoriesMapper> mapperProvider;
    private final DomainCommonListMapperModule module;

    public DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainPopupStoriesToPopupStoriesMapper> provider) {
        this.module = domainCommonListMapperModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> get() {
        return provideDomainPopupStoriesToPopupStories(this.module, this.mapperProvider.get());
    }

    public static DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory create(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainPopupStoriesToPopupStoriesMapper> provider) {
        return new DomainCommonListMapperModule_ProvideDomainPopupStoriesToPopupStoriesFactory(domainCommonListMapperModule, provider);
    }

    public static NullableInputListMapper<DomainPopupStoryStructure, PopupStoryStructure> provideDomainPopupStoriesToPopupStories(DomainCommonListMapperModule domainCommonListMapperModule, DomainPopupStoriesToPopupStoriesMapper domainPopupStoriesToPopupStoriesMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(domainCommonListMapperModule.provideDomainPopupStoriesToPopupStories(domainPopupStoriesToPopupStoriesMapper));
    }
}
