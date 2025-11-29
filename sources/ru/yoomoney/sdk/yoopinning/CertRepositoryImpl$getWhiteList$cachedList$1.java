package ru.yoomoney.sdk.yoopinning;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertRepository.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CertRepositoryImpl$getWhiteList$cachedList$1 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
    CertRepositoryImpl$getWhiteList$cachedList$1(Object obj) {
        super(1, obj, CertRepositoryImpl.class, "decryptCerts", "decryptCerts(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<String> invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((CertRepositoryImpl) this.receiver).decryptCerts(p0);
    }
}
