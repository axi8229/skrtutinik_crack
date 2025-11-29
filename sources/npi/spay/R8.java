package npi.spay;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class R8 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ I9 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R8(I9 i9, Continuation continuation) {
        super(2, continuation);
        this.b = i9;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        R8 r8 = new R8(this.b, continuation);
        r8.a = obj;
        return r8;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        R8 r8 = new R8(this.b, (Continuation) obj2);
        r8.a = (CoroutineScope) obj;
        return r8.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM2628constructorimpl;
        String text;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        I9 i9 = this.b;
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = i9.a;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("SDK_logs", "directory");
            File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
            Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "getExternalFilesDirs(context, null)");
            File file = new File((File) ArraysKt.firstOrNull(externalFilesDirs), "SDK_logs");
            if (!file.exists()) {
                file.mkdir();
            }
            int i = AbstractC2037xa.$r8$clinit;
            InputStream inputStreamOpenInputStream = i9.a.getContentResolver().openInputStream(Uri.fromFile(new File(file, "")));
            BufferedReader bufferedReader = inputStreamOpenInputStream != null ? new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, Charsets.UTF_8), 8192) : null;
            if (bufferedReader != null) {
                try {
                    text = TextStreamsKt.readText(bufferedReader);
                } finally {
                }
            } else {
                text = null;
            }
            CloseableKt.closeFinally(bufferedReader, null);
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            objM2628constructorimpl = Result.m2628constructorimpl(text);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(objM2628constructorimpl);
        if (thM2631exceptionOrNullimpl != null) {
            Timber.INSTANCE.i(thM2631exceptionOrNullimpl, "Error while parsing log file", new Object[0]);
        }
        if (Result.m2633isFailureimpl(objM2628constructorimpl)) {
            return null;
        }
        return objM2628constructorimpl;
    }
}
