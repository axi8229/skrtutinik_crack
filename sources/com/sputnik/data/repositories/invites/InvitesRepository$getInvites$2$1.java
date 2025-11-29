package com.sputnik.data.repositories.invites;

import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.invites.DomainInvite;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvitesRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class InvitesRepository$getInvites$2$1 extends FunctionReferenceImpl implements Function1<List<? extends DataInvite>, List<? extends DomainInvite>> {
    InvitesRepository$getInvites$2$1(Object obj) {
        super(1, obj, ListMapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends DomainInvite> invoke(List<? extends DataInvite> list) {
        return invoke2((List<DataInvite>) list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<DomainInvite> invoke2(List<DataInvite> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) ((ListMapper) this.receiver).map(p0);
    }
}
