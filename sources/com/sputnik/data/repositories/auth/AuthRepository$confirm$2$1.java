package com.sputnik.data.repositories.auth;

import com.sputnik.data.entities.auth.DataConfirmResponse;
import com.sputnik.data.mappers.auth.DataConfirmRegistrationToDomainConfirmRegistrationMapper;
import com.sputnik.domain.entities.auth.DomainConfirmResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class AuthRepository$confirm$2$1 extends FunctionReferenceImpl implements Function1<DataConfirmResponse, DomainConfirmResponse> {
    AuthRepository$confirm$2$1(Object obj) {
        super(1, obj, DataConfirmRegistrationToDomainConfirmRegistrationMapper.class, "map", "map(Lcom/sputnik/data/entities/auth/DataConfirmResponse;)Lcom/sputnik/domain/entities/auth/DomainConfirmResponse;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainConfirmResponse invoke(DataConfirmResponse p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataConfirmRegistrationToDomainConfirmRegistrationMapper) this.receiver).map(p0);
    }
}
