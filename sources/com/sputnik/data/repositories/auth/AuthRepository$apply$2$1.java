package com.sputnik.data.repositories.auth;

import com.sputnik.data.entities.auth.DataApplyRegistrationResponse;
import com.sputnik.data.mappers.auth.DataApplyRegistrationToDomainApplyRegistrationMapper;
import com.sputnik.domain.entities.auth.DomainApplyRegistration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class AuthRepository$apply$2$1 extends FunctionReferenceImpl implements Function1<DataApplyRegistrationResponse, DomainApplyRegistration> {
    AuthRepository$apply$2$1(Object obj) {
        super(1, obj, DataApplyRegistrationToDomainApplyRegistrationMapper.class, "map", "map(Lcom/sputnik/data/entities/auth/DataApplyRegistrationResponse;)Lcom/sputnik/domain/entities/auth/DomainApplyRegistration;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainApplyRegistration invoke(DataApplyRegistrationResponse p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataApplyRegistrationToDomainApplyRegistrationMapper) this.receiver).map(p0);
    }
}
