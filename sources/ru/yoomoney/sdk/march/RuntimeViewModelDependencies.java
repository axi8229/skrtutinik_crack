package ru.yoomoney.sdk.march;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Code.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u00020\u0002Bk\u0012\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\u0010\fR/\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR/\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR)\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/march/RuntimeViewModelDependencies;", "STATE", "", "ACTION", "EFFECT", "showState", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "showEffect", "", "source", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getShowEffect", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getShowState", "getSource", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuntimeViewModelDependencies<STATE, ACTION, EFFECT> {
    private final Function2<EFFECT, Continuation<?>, Object> showEffect;
    private final Function2<STATE, Continuation<? super ACTION>, Object> showState;
    private final Function1<Continuation<? super ACTION>, Object> source;

    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeViewModelDependencies(Function2<? super STATE, ? super Continuation<? super ACTION>, ? extends Object> showState, Function2<? super EFFECT, ? super Continuation<?>, ? extends Object> showEffect, Function1<? super Continuation<? super ACTION>, ? extends Object> source) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        this.showState = showState;
        this.showEffect = showEffect;
        this.source = source;
    }

    public final Function2<STATE, Continuation<? super ACTION>, Object> getShowState() {
        return this.showState;
    }

    public final Function2<EFFECT, Continuation<?>, Object> getShowEffect() {
        return this.showEffect;
    }

    public final Function1<Continuation<? super ACTION>, Object> getSource() {
        return this.source;
    }
}
