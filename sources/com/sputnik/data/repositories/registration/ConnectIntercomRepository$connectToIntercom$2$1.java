package com.sputnik.data.repositories.registration;

import com.sputnik.data.entities.connect_intercom.DataActivationCode;
import com.sputnik.data.mappers.connect_intercom.DataActivationCodeToDomainActivationCodeMapper;
import com.sputnik.domain.entities.connect_intercom.DomainActivationCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectIntercomRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ConnectIntercomRepository$connectToIntercom$2$1 extends FunctionReferenceImpl implements Function1<DataActivationCode, DomainActivationCode> {
    ConnectIntercomRepository$connectToIntercom$2$1(Object obj) {
        super(1, obj, DataActivationCodeToDomainActivationCodeMapper.class, "map", "map(Lcom/sputnik/data/entities/connect_intercom/DataActivationCode;)Lcom/sputnik/domain/entities/connect_intercom/DomainActivationCode;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainActivationCode invoke(DataActivationCode p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataActivationCodeToDomainActivationCodeMapper) this.receiver).map(p0);
    }
}
