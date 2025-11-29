package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainFlussonicToFlussonicFactory implements Factory<ListMapper<DomainFlussonic, Flussonic>> {
    public static ListMapper<DomainFlussonic, Flussonic> provideDomainFlussonicToFlussonic(DomainListMapperModule domainListMapperModule, DomainFlussonicToFlussonicMapper domainFlussonicToFlussonicMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainFlussonicToFlussonic(domainFlussonicToFlussonicMapper));
    }
}
