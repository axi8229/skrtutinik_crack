package ru.yoomoney.sdk.kassa.payments.contract.di;

import java.io.FileNotFoundException;
import java.security.KeyStoreException;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.extensions.k;
import ru.yoomoney.sdk.kassa.payments.secure.i;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {
    public final /* synthetic */ i a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.a b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.g c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.f d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(i iVar, ru.yoomoney.sdk.kassa.payments.secure.a aVar, ru.yoomoney.sdk.kassa.payments.secure.g gVar, ru.yoomoney.sdk.kassa.payments.secure.f fVar) {
        super(0);
        this.a = iVar;
        this.b = aVar;
        this.c = gVar;
        this.d = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws KeyStoreException, FileNotFoundException {
        i iVar = this.a;
        iVar.getClass();
        Intrinsics.checkNotNullParameter("cipherIv", "key");
        k.a(iVar.a);
        ru.yoomoney.sdk.kassa.payments.secure.a aVar = this.b;
        aVar.getClass();
        Intrinsics.checkNotNullParameter("cipherKey", "key");
        aVar.c.deleteEntry("cipherKey");
        aVar.a();
        ru.yoomoney.sdk.kassa.payments.secure.g gVar = this.c;
        gVar.getClass();
        gVar.d = LazyKt.lazy(new ru.yoomoney.sdk.kassa.payments.secure.c(gVar));
        ru.yoomoney.sdk.kassa.payments.secure.f fVar = this.d;
        fVar.getClass();
        fVar.d = LazyKt.lazy(new ru.yoomoney.sdk.kassa.payments.secure.c(fVar));
        return Unit.INSTANCE;
    }
}
