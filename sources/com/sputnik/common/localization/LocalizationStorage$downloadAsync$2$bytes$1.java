package com.sputnik.common.localization;

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

/* compiled from: LocalizationStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.localization.LocalizationStorage$downloadAsync$2$bytes$1", f = "LocalizationStorage.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class LocalizationStorage$downloadAsync$2$bytes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ long $length;
    final /* synthetic */ Function2<Long, Long, Unit> $progress;
    final /* synthetic */ URL $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LocalizationStorage$downloadAsync$2$bytes$1(URL url, File file, Function2<? super Long, ? super Long, Unit> function2, long j, Continuation<? super LocalizationStorage$downloadAsync$2$bytes$1> continuation) {
        super(2, continuation);
        this.$url = url;
        this.$file = file;
        this.$progress = function2;
        this.$length = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalizationStorage$downloadAsync$2$bytes$1(this.$url, this.$file, this.$progress, this.$length, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((LocalizationStorage$downloadAsync$2$bytes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InputStream inputStreamOpenStream = this.$url.openStream();
        File file = this.$file;
        Function2<Long, Long, Unit> function2 = this.$progress;
        long j = this.$length;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                long j2 = 0;
                for (int i = inputStreamOpenStream.read(bArr); i >= 0; i = inputStreamOpenStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, i);
                    j2 += i;
                    if (function2 != null) {
                        function2.invoke(Boxing.boxLong(j2), Boxing.boxLong(j));
                    }
                }
                CloseableKt.closeFinally(fileOutputStream, null);
                Long lBoxLong = Boxing.boxLong(j2);
                CloseableKt.closeFinally(inputStreamOpenStream, null);
                return lBoxLong;
            } finally {
            }
        } finally {
        }
    }
}
