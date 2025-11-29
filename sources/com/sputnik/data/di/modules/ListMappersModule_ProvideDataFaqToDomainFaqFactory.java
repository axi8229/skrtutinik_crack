package com.sputnik.data.di.modules;

import com.sputnik.data.entities.faq.DataFaq;
import com.sputnik.data.mappers.faq.DataFaqToDomainFaqMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.faq.DomainFaq;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataFaqToDomainFaqFactory implements Factory<ListMapper<DataFaq, DomainFaq>> {
    public static ListMapper<DataFaq, DomainFaq> provideDataFaqToDomainFaq(ListMappersModule listMappersModule, DataFaqToDomainFaqMapper dataFaqToDomainFaqMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataFaqToDomainFaq(dataFaqToDomainFaqMapper));
    }
}
