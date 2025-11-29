package ru.yoomoney.sdk.march;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Core.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/march/Effect;", "T", "", "()V", "Cancel", "Input", "Output", "Lru/yoomoney/sdk/march/Effect$Cancel;", "Lru/yoomoney/sdk/march/Effect$Input;", "Lru/yoomoney/sdk/march/Effect$Output;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Effect<T> {
    public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/march/Effect$Input;", "T", "Lru/yoomoney/sdk/march/Effect;", "()V", "Fun", "Sub", "Lru/yoomoney/sdk/march/Effect$Input$Fun;", "Lru/yoomoney/sdk/march/Effect$Input$Sub;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Input<T> extends Effect<T> {
        public /* synthetic */ Input(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: Core.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007R)\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/march/Effect$Input$Fun;", "T", "Lru/yoomoney/sdk/march/Effect$Input;", "func", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "getFunc", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Fun<T> extends Input<T> {
            private final Function1<Continuation<? super T>, Object> func;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Fun(Function1<? super Continuation<? super T>, ? extends Object> func) {
                super(null);
                Intrinsics.checkNotNullParameter(func, "func");
                this.func = func;
            }

            public final Function1<Continuation<? super T>, Object> getFunc() {
                return this.func;
            }
        }

        private Input() {
            super(null);
        }

        /* compiled from: Core.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/march/Effect$Input$Sub;", "T", "Lru/yoomoney/sdk/march/Effect$Input;", "", "key", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Sub<T> extends Input<T> {
            private final Flow<T> flow;
            private final Object key;

            public final Flow<T> getFlow() {
                return this.flow;
            }

            public final Object getKey() {
                return this.key;
            }
        }
    }

    private Effect() {
    }

    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\u0010\bR)\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/march/Effect$Output;", "Lru/yoomoney/sdk/march/Effect;", "", "func", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "getFunc", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Output extends Effect {
        private final Function1<Continuation<? super Unit>, Object> func;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Output(Function1<? super Continuation<? super Unit>, ? extends Object> func) {
            super(null);
            Intrinsics.checkNotNullParameter(func, "func");
            this.func = func;
        }

        public final Function1<Continuation<? super Unit>, Object> getFunc() {
            return this.func;
        }
    }

    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/march/Effect$Cancel;", "Lru/yoomoney/sdk/march/Effect;", "", "", "key", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Cancel extends Effect {
        private final Object key;

        public final Object getKey() {
            return this.key;
        }
    }
}
