package com.sputnik.data.repositories.profile;

import com.sputnik.data.entities.profile.DataProfile;
import com.sputnik.data.mappers.profile.DataProfileToDomainProfileMapper;
import com.sputnik.domain.entities.profile.DomainProfile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ProfileRepository$getProfile$2$1 extends FunctionReferenceImpl implements Function1<DataProfile, DomainProfile> {
    ProfileRepository$getProfile$2$1(Object obj) {
        super(1, obj, DataProfileToDomainProfileMapper.class, "map", "map(Lcom/sputnik/data/entities/profile/DataProfile;)Lcom/sputnik/domain/entities/profile/DomainProfile;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainProfile invoke(DataProfile p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataProfileToDomainProfileMapper) this.receiver).map(p0);
    }
}
