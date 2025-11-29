package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2555s extends ContinuationImpl {
    public /* synthetic */ Object a;
    public final /* synthetic */ K b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2555s(K k, Continuation continuation) {
        super(continuation);
        this.b = k;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        return K.a(this.b, null, this);
    }
}
