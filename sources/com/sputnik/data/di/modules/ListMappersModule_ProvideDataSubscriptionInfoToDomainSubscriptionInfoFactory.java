package com.sputnik.data.di.modules;

import com.sputnik.data.entities.market.subscription.DataSubscriptionInfo;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionInfoToDomainSubscriptionInfoMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataSubscriptionInfoToDomainSubscriptionInfoFactory implements Factory<NullableInputListMapper<DataSubscriptionInfo, DomainSubscriptionInfo>> {
    public static NullableInputListMapper<DataSubscriptionInfo, DomainSubscriptionInfo> provideDataSubscriptionInfoToDomainSubscriptionInfo(ListMappersModule listMappersModule, DataSubscriptionInfoToDomainSubscriptionInfoMapper dataSubscriptionInfoToDomainSubscriptionInfoMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataSubscriptionInfoToDomainSubscriptionInfo(dataSubscriptionInfoToDomainSubscriptionInfoMapper));
    }
}
