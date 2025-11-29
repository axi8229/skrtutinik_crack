package com.sputnik.data.repositories.auth;

import com.sputnik.data.entities.auth.DataRequestInfo;
import com.sputnik.data.mappers.auth.DataRequestInfoToDomainRequestInfoMapper;
import com.sputnik.domain.entities.auth.DomainRequestInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class AuthRepository$getRequest$2$1 extends FunctionReferenceImpl implements Function1<DataRequestInfo, DomainRequestInfo> {
    AuthRepository$getRequest$2$1(Object obj) {
        super(1, obj, DataRequestInfoToDomainRequestInfoMapper.class, "map", "map(Lcom/sputnik/data/entities/auth/DataRequestInfo;)Lcom/sputnik/domain/entities/auth/DomainRequestInfo;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainRequestInfo invoke(DataRequestInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataRequestInfoToDomainRequestInfoMapper) this.receiver).map(p0);
    }
}
