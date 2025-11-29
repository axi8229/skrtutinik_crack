package com.sputnik.data.repositories.registration;

import com.sputnik.data.api.ConnectIntercomApi;
import com.sputnik.data.mappers.connect_intercom.DataActivationCodeToDomainActivationCodeMapper;
import com.sputnik.data.mappers.entry.DataEntryToDomainEntryMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ConnectIntercomRepository_Factory implements Factory<ConnectIntercomRepository> {
    private final Provider<ConnectIntercomApi> connectIntercomApiProvider;
    private final Provider<DataActivationCodeToDomainActivationCodeMapper> dataActivationCodeToDomainActivationCodeMapperProvider;
    private final Provider<DataEntryToDomainEntryMapper> dataEntryToDomainEntryMapperProvider;

    public ConnectIntercomRepository_Factory(Provider<ConnectIntercomApi> provider, Provider<DataActivationCodeToDomainActivationCodeMapper> provider2, Provider<DataEntryToDomainEntryMapper> provider3) {
        this.connectIntercomApiProvider = provider;
        this.dataActivationCodeToDomainActivationCodeMapperProvider = provider2;
        this.dataEntryToDomainEntryMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public ConnectIntercomRepository get() {
        return newInstance(this.connectIntercomApiProvider.get(), this.dataActivationCodeToDomainActivationCodeMapperProvider.get(), this.dataEntryToDomainEntryMapperProvider.get());
    }

    public static ConnectIntercomRepository_Factory create(Provider<ConnectIntercomApi> provider, Provider<DataActivationCodeToDomainActivationCodeMapper> provider2, Provider<DataEntryToDomainEntryMapper> provider3) {
        return new ConnectIntercomRepository_Factory(provider, provider2, provider3);
    }

    public static ConnectIntercomRepository newInstance(ConnectIntercomApi connectIntercomApi, DataActivationCodeToDomainActivationCodeMapper dataActivationCodeToDomainActivationCodeMapper, DataEntryToDomainEntryMapper dataEntryToDomainEntryMapper) {
        return new ConnectIntercomRepository(connectIntercomApi, dataActivationCodeToDomainActivationCodeMapper, dataEntryToDomainEntryMapper);
    }
}
