package com.sputnik.common.localization;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocalizationStorage.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Ljava/net/URLConnection;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.localization.LocalizationStorage$downloadAsync$2$connection$1", f = "LocalizationStorage.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class LocalizationStorage$downloadAsync$2$connection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URLConnection>, Object> {
    final /* synthetic */ URL $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalizationStorage$downloadAsync$2$connection$1(URL url, Continuation<? super LocalizationStorage$downloadAsync$2$connection$1> continuation) {
        super(2, continuation);
        this.$url = url;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalizationStorage$downloadAsync$2$connection$1(this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URLConnection> continuation) {
        return ((LocalizationStorage$downloadAsync$2$connection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        URLConnection uRLConnectionOpenConnection = this.$url.openConnection();
        uRLConnectionOpenConnection.connect();
        return uRLConnectionOpenConnection;
    }
}
