package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheByClass.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "V", "Lkotlin/Function1;", "Ljava/lang/Class;", "compute", "Lkotlin/reflect/jvm/internal/CacheByClass;", "createCache", "(Lkotlin/jvm/functions/Function1;)Lkotlin/reflect/jvm/internal/CacheByClass;", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CacheByClassKt {
    static {
        Object objM2628constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2634isSuccessimpl(objM2628constructorimpl)) {
            objM2628constructorimpl = Boolean.TRUE;
        }
        Object objM2628constructorimpl2 = Result.m2628constructorimpl(objM2628constructorimpl);
        Boolean bool = Boolean.FALSE;
        if (Result.m2633isFailureimpl(objM2628constructorimpl2)) {
            objM2628constructorimpl2 = bool;
        }
        ((Boolean) objM2628constructorimpl2).booleanValue();
    }

    public static final <V> CacheByClass<V> createCache(Function1<? super Class<?>, ? extends V> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        return new ConcurrentHashMapCache(compute);
    }
}
