package com.sputnik.data.repositories.archive;

import com.sputnik.data.entities.archive.DataArchiveResponse;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArchiveRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ArchiveRepository$getArchiveUrls$2$1 extends FunctionReferenceImpl implements Function1<DataArchiveResponse, DomainArchiveUrls> {
    ArchiveRepository$getArchiveUrls$2$1(Object obj) {
        super(1, obj, Mapper.class, "map", "map(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DomainArchiveUrls invoke(DataArchiveResponse p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (DomainArchiveUrls) ((Mapper) this.receiver).map(p0);
    }
}
