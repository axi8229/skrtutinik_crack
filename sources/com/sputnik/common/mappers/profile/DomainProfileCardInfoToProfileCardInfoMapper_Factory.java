package com.sputnik.common.mappers.profile;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainProfileCardInfoToProfileCardInfoMapper_Factory implements Factory<DomainProfileCardInfoToProfileCardInfoMapper> {

    private static final class InstanceHolder {
        private static final DomainProfileCardInfoToProfileCardInfoMapper_Factory INSTANCE = new DomainProfileCardInfoToProfileCardInfoMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainProfileCardInfoToProfileCardInfoMapper get() {
        return newInstance();
    }

    public static DomainProfileCardInfoToProfileCardInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainProfileCardInfoToProfileCardInfoMapper newInstance() {
        return new DomainProfileCardInfoToProfileCardInfoMapper();
    }
}
