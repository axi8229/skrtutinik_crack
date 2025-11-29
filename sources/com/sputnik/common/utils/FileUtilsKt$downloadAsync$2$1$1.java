package com.sputnik.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.utils.FileUtilsKt$downloadAsync$2$1$1", f = "FileUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FileUtilsKt$downloadAsync$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ URL $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileUtilsKt$downloadAsync$2$1$1(URL url, File file, Continuation<? super FileUtilsKt$downloadAsync$2$1$1> continuation) {
        super(2, continuation);
        this.$url = url;
        this.$file = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileUtilsKt$downloadAsync$2$1$1(this.$url, this.$file, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((FileUtilsKt$downloadAsync$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InputStream inputStreamOpenStream = this.$url.openStream();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.$file);
            try {
                byte[] bArr = new byte[8192];
                long j = 0;
                for (int i = inputStreamOpenStream.read(bArr); i >= 0; i = inputStreamOpenStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, i);
                    j += i;
                }
                CloseableKt.closeFinally(fileOutputStream, null);
                Long lBoxLong = Boxing.boxLong(j);
                CloseableKt.closeFinally(inputStreamOpenStream, null);
                return lBoxLong;
            } finally {
            }
        } finally {
        }
    }
}
