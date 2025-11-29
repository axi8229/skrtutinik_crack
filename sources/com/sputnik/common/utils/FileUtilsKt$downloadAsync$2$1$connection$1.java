package com.sputnik.common.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Ljava/net/HttpURLConnection;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.utils.FileUtilsKt$downloadAsync$2$1$connection$1", f = "FileUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FileUtilsKt$downloadAsync$2$1$connection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpURLConnection>, Object> {
    final /* synthetic */ Ref$BooleanRef $hasErrors;
    final /* synthetic */ URL $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileUtilsKt$downloadAsync$2$1$connection$1(URL url, Ref$BooleanRef ref$BooleanRef, Continuation<? super FileUtilsKt$downloadAsync$2$1$connection$1> continuation) {
        super(2, continuation);
        this.$url = url;
        this.$hasErrors = ref$BooleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileUtilsKt$downloadAsync$2$1$connection$1(this.$url, this.$hasErrors, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpURLConnection> continuation) {
        return ((FileUtilsKt$downloadAsync$2$1$connection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        URLConnection uRLConnectionOpenConnection = this.$url.openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        LogUtilsKt.writeLog("DD: " + httpURLConnection.getResponseCode());
        if (httpURLConnection.getResponseCode() == 404) {
            this.$hasErrors.element = true;
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }
}
