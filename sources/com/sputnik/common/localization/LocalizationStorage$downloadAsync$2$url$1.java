package com.sputnik.common.localization;

import java.net.URL;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Ljava/net/URL;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.localization.LocalizationStorage$downloadAsync$2$url$1", f = "LocalizationStorage.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class LocalizationStorage$downloadAsync$2$url$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URL>, Object> {
    final /* synthetic */ String $link;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalizationStorage$downloadAsync$2$url$1(String str, Continuation<? super LocalizationStorage$downloadAsync$2$url$1> continuation) {
        super(2, continuation);
        this.$link = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalizationStorage$downloadAsync$2$url$1(this.$link, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URL> continuation) {
        return ((LocalizationStorage$downloadAsync$2$url$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new URL(this.$link);
    }
}
