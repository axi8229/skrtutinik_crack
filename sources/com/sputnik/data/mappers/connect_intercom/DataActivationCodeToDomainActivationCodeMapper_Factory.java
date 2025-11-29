package com.sputnik.data.mappers.connect_intercom;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataActivationCodeToDomainActivationCodeMapper_Factory implements Factory<DataActivationCodeToDomainActivationCodeMapper> {

    private static final class InstanceHolder {
        private static final DataActivationCodeToDomainActivationCodeMapper_Factory INSTANCE = new DataActivationCodeToDomainActivationCodeMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataActivationCodeToDomainActivationCodeMapper get() {
        return newInstance();
    }

    public static DataActivationCodeToDomainActivationCodeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataActivationCodeToDomainActivationCodeMapper newInstance() {
        return new DataActivationCodeToDomainActivationCodeMapper();
    }
}
