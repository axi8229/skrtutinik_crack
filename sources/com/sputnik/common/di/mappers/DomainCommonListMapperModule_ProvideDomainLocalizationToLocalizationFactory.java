package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.mappers.localization.DomainLocalizationToLocalizationMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.localization.DomainLocalization;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory implements Factory<ListMapper<DomainLocalization, Localization>> {
    private final Provider<DomainLocalizationToLocalizationMapper> mapperProvider;
    private final DomainCommonListMapperModule module;

    public DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainLocalizationToLocalizationMapper> provider) {
        this.module = domainCommonListMapperModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DomainLocalization, Localization> get() {
        return provideDomainLocalizationToLocalization(this.module, this.mapperProvider.get());
    }

    public static DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory create(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainLocalizationToLocalizationMapper> provider) {
        return new DomainCommonListMapperModule_ProvideDomainLocalizationToLocalizationFactory(domainCommonListMapperModule, provider);
    }

    public static ListMapper<DomainLocalization, Localization> provideDomainLocalizationToLocalization(DomainCommonListMapperModule domainCommonListMapperModule, DomainLocalizationToLocalizationMapper domainLocalizationToLocalizationMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainCommonListMapperModule.provideDomainLocalizationToLocalization(domainLocalizationToLocalizationMapper));
    }
}
