package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: npi.spay.ba, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1489ba {
    public abstract Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation);

    public final Object b(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objA = a(obj, coroutineDispatcher, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
