package com.sputnik.data.repositories.auth;

import com.sputnik.data.api.AuthApi;
import com.sputnik.data.mappers.auth.DataApplyRegistrationToDomainApplyRegistrationMapper;
import com.sputnik.data.mappers.auth.DataConfirmRegistrationToDomainConfirmRegistrationMapper;
import com.sputnik.data.mappers.auth.DataConfirmToDomainConfirmMapper;
import com.sputnik.data.mappers.auth.DataPhoneRequestToDomainPhoneRequestMapper;
import com.sputnik.data.mappers.auth.DataRequestInfoToDomainRequestInfoMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AuthRepository_Factory implements Factory<AuthRepository> {
    private final Provider<DataApplyRegistrationToDomainApplyRegistrationMapper> applyRegistrationMapperProvider;
    private final Provider<AuthApi> authApiProvider;
    private final Provider<DataConfirmRegistrationToDomainConfirmRegistrationMapper> confirmRegistrationMapperProvider;
    private final Provider<DataConfirmToDomainConfirmMapper> mapperProvider;
    private final Provider<DataPhoneRequestToDomainPhoneRequestMapper> phoneRequestMapperProvider;
    private final Provider<DataRequestInfoToDomainRequestInfoMapper> requestMapperProvider;

    public AuthRepository_Factory(Provider<AuthApi> provider, Provider<DataConfirmToDomainConfirmMapper> provider2, Provider<DataPhoneRequestToDomainPhoneRequestMapper> provider3, Provider<DataApplyRegistrationToDomainApplyRegistrationMapper> provider4, Provider<DataConfirmRegistrationToDomainConfirmRegistrationMapper> provider5, Provider<DataRequestInfoToDomainRequestInfoMapper> provider6) {
        this.authApiProvider = provider;
        this.mapperProvider = provider2;
        this.phoneRequestMapperProvider = provider3;
        this.applyRegistrationMapperProvider = provider4;
        this.confirmRegistrationMapperProvider = provider5;
        this.requestMapperProvider = provider6;
    }

    @Override // javax.inject.Provider
    public AuthRepository get() {
        return newInstance(this.authApiProvider.get(), this.mapperProvider.get(), this.phoneRequestMapperProvider.get(), this.applyRegistrationMapperProvider.get(), this.confirmRegistrationMapperProvider.get(), this.requestMapperProvider.get());
    }

    public static AuthRepository_Factory create(Provider<AuthApi> provider, Provider<DataConfirmToDomainConfirmMapper> provider2, Provider<DataPhoneRequestToDomainPhoneRequestMapper> provider3, Provider<DataApplyRegistrationToDomainApplyRegistrationMapper> provider4, Provider<DataConfirmRegistrationToDomainConfirmRegistrationMapper> provider5, Provider<DataRequestInfoToDomainRequestInfoMapper> provider6) {
        return new AuthRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AuthRepository newInstance(AuthApi authApi, DataConfirmToDomainConfirmMapper dataConfirmToDomainConfirmMapper, DataPhoneRequestToDomainPhoneRequestMapper dataPhoneRequestToDomainPhoneRequestMapper, DataApplyRegistrationToDomainApplyRegistrationMapper dataApplyRegistrationToDomainApplyRegistrationMapper, DataConfirmRegistrationToDomainConfirmRegistrationMapper dataConfirmRegistrationToDomainConfirmRegistrationMapper, DataRequestInfoToDomainRequestInfoMapper dataRequestInfoToDomainRequestInfoMapper) {
        return new AuthRepository(authApi, dataConfirmToDomainConfirmMapper, dataPhoneRequestToDomainPhoneRequestMapper, dataApplyRegistrationToDomainApplyRegistrationMapper, dataConfirmRegistrationToDomainConfirmRegistrationMapper, dataRequestInfoToDomainRequestInfoMapper);
    }
}
