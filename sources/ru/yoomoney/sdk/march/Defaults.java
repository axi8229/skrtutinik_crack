package ru.yoomoney.sdk.march;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Defaults.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¸\u0001\u0010\u000f\u001a\u008e\u0001\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\n0\t\u0012\u0004\u0012\u00028\u0000\u00126\u00124\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\n0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\b\b\u0001\u0010\u0005*\u00020\u0001\"\b\b\u0002\u0010\u0006*\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0089\u0001\u0010\u0012\u001at\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t\u0012*\u0012(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\"\b\b\u0000\u0010\u0005*\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0010Jª\u0001\u0010\u0016\u001a\u0080\u0001\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\n0\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\b\b\u0001\u0010\u0005*\u00020\u0001\"\b\b\u0002\u0010\u0006*\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\b\b\u0000\u0010\u0005*\u00020\u00012\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010\u001d\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\n0\u001a\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\b\b\u0001\u0010\u0005*\u00020\u0001\"\b\b\u0002\u0010\u0006*\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001eJE\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b0\u001a\"\b\b\u0000\u0010\u0005*\u00020\u00012\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u001f\u0010\u001cJ5\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00062\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b \u0010\u001cJ/\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a2\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b!\u0010\u001cJO\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0015\"\u0004\b\u0000\u0010\u00042\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u00152\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\"\u0010#J)\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010$\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lru/yoomoney/sdk/march/Defaults;", "", "<init>", "()V", "STATE", "ACTION", "EFFECT", "Lkotlin/Function5;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "businessLogicExecutionStrategy", "()Lkotlin/jvm/functions/Function5;", "", "commandProcessorExecutionStrategy", "Lkotlin/Function6;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/Function1;", "businessLogicResultDeliveryStrategy", "()Lkotlin/jvm/functions/Function6;", "", "log", "Lkotlinx/coroutines/channels/Channel;", "actionsChannel", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/Channel;", "businessLogicOutput", "()Lkotlinx/coroutines/channels/Channel;", "commandsChannel", "effectsChannel", "exceptionChannel", "sendState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "featureName", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function2;", "", "isLoggingEnable", "Z", "()Z", "setLoggingEnable", "(Z)V", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Defaults {
    public static final Defaults INSTANCE = new Defaults();
    private static boolean isLoggingEnable;

    private Defaults() {
    }

    public final boolean isLoggingEnable() {
        return isLoggingEnable;
    }

    /* JADX INFO: Add missing generic type declarations: [ACTION, EFFECT, STATE] */
    /* compiled from: Defaults.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.march.Defaults$businessLogicExecutionStrategy$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C25671<ACTION, EFFECT, STATE> extends FunctionReferenceImpl implements Function5<ReceiveChannel<? extends ACTION>, SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, STATE, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Continuation<? super Unit>, Object> {
        public static final C25671 INSTANCE = new C25671();

        C25671() {
            super(5, StrategiesKt.class, "BusinessLogicExecutionStrategyV1", "BusinessLogicExecutionStrategyV1(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Continuation<? super Unit> continuation) {
            return invoke((ReceiveChannel) obj, (SendChannel<? super Triple<? extends SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>) obj2, (SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>) obj3, (Function2<? super SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? super ACTION, ? extends Triple<? extends SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>) obj4, continuation);
        }

        public final Object invoke(ReceiveChannel<? extends ACTION> receiveChannel, SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> sendChannel, STATE state, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> function2, Continuation<? super Unit> continuation) {
            return StrategiesKt.BusinessLogicExecutionStrategyV1(receiveChannel, sendChannel, state, function2, continuation);
        }
    }

    public final <STATE, ACTION, EFFECT> Function5<ReceiveChannel<? extends ACTION>, SendChannel<? super Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, STATE, Function2<? super STATE, ? super ACTION, ? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Continuation<? super Unit>, Object> businessLogicExecutionStrategy() {
        return C25671.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [ACTION] */
    /* compiled from: Defaults.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.march.Defaults$commandProcessorExecutionStrategy$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C25691<ACTION> extends FunctionReferenceImpl implements Function5<ReceiveChannel<? extends Command<?, ? extends ACTION>>, SendChannel<? super ACTION>, SendChannel<? super Throwable>, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, Continuation<? super Unit>, Object> {
        public static final C25691 INSTANCE = new C25691();

        C25691() {
            super(5, StrategiesKt.class, "CommandProcessorExecutionStrategyV1", "CommandProcessorExecutionStrategyV1(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function5
        public final Object invoke(ReceiveChannel<? extends Command<?, ? extends ACTION>> receiveChannel, SendChannel<? super ACTION> sendChannel, SendChannel<? super Throwable> sendChannel2, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object> function2, Continuation<? super Unit> continuation) {
            return StrategiesKt.CommandProcessorExecutionStrategyV1(receiveChannel, sendChannel, sendChannel2, function2, continuation);
        }
    }

    public final <ACTION> Function5<ReceiveChannel<? extends Command<?, ? extends ACTION>>, SendChannel<? super ACTION>, SendChannel<? super Throwable>, Function2<? super Command<?, ? extends ACTION>, ? super Continuation<? super ACTION>, ? extends Object>, Continuation<? super Unit>, Object> commandProcessorExecutionStrategy() {
        return C25691.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [ACTION, EFFECT, STATE] */
    /* compiled from: Defaults.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.yoomoney.sdk.march.Defaults$businessLogicResultDeliveryStrategy$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C25681<ACTION, EFFECT, STATE> extends FunctionReferenceImpl implements Function6<CoroutineDispatcher, ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Function1<? super STATE, ? extends Unit>, SendChannel<? super EFFECT>, SendChannel<? super Command<?, ? extends ACTION>>, Continuation<? super Unit>, Object> {
        public static final C25681 INSTANCE = new C25681();

        C25681() {
            super(6, StrategiesKt.class, "BusinessLogicResultDeliveryStrategyV1", "BusinessLogicResultDeliveryStrategyV1(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/channels/SendChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function6
        public final Object invoke(CoroutineDispatcher coroutineDispatcher, ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>> receiveChannel, Function1<? super STATE, Unit> function1, SendChannel<? super EFFECT> sendChannel, SendChannel<? super Command<?, ? extends ACTION>> sendChannel2, Continuation<? super Unit> continuation) {
            return StrategiesKt.BusinessLogicResultDeliveryStrategyV1(coroutineDispatcher, receiveChannel, function1, sendChannel, sendChannel2, continuation);
        }
    }

    public final <STATE, ACTION, EFFECT> Function6<CoroutineDispatcher, ReceiveChannel<? extends Triple<? extends STATE, ? extends Command<?, ? extends ACTION>, ? extends EFFECT>>, Function1<? super STATE, Unit>, SendChannel<? super EFFECT>, SendChannel<? super Command<?, ? extends ACTION>>, Continuation<? super Unit>, Object> businessLogicResultDeliveryStrategy() {
        return C25681.INSTANCE;
    }

    public final <ACTION> Channel<ACTION> actionsChannel(final Function2<? super String, Object, Unit> log) {
        Intrinsics.checkNotNullParameter(log, "log");
        return new LoggingChannel(ChannelKt.Channel$default(-1, null, null, 6, null), new Function1<ACTION, Unit>() { // from class: ru.yoomoney.sdk.march.Defaults.actionsChannel.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((AnonymousClass1<ACTION>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ACTION it) {
                Intrinsics.checkNotNullParameter(it, "it");
                log.invoke("Action:    ", it);
            }
        });
    }

    public final <STATE, ACTION, EFFECT> Channel<Triple<STATE, Command<?, ACTION>, EFFECT>> businessLogicOutput() {
        return ChannelKt.Channel$default(0, null, null, 6, null);
    }

    public final <ACTION> Channel<Command<?, ACTION>> commandsChannel(final Function2<? super String, Object, Unit> log) {
        Intrinsics.checkNotNullParameter(log, "log");
        return new LoggingChannel(ChannelKt.Channel$default(-1, null, null, 6, null), new Function1<Command<?, ? extends ACTION>, Unit>() { // from class: ru.yoomoney.sdk.march.Defaults.commandsChannel.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((Command) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Command<?, ? extends ACTION> command) {
                log.invoke("Command:   ", command);
            }
        });
    }

    public final <EFFECT> Channel<EFFECT> effectsChannel(final Function2<? super String, Object, Unit> log) {
        Intrinsics.checkNotNullParameter(log, "log");
        return new LoggingChannel(ChannelKt.Channel$default(-1, null, null, 6, null), new Function1<EFFECT, Unit>() { // from class: ru.yoomoney.sdk.march.Defaults.effectsChannel.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((C25711<EFFECT>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EFFECT effect) {
                log.invoke("Effect:    ", effect);
            }
        });
    }

    public final Channel<Throwable> exceptionChannel(final Function2<? super String, Object, Unit> log) {
        Intrinsics.checkNotNullParameter(log, "log");
        return new LoggingChannel(ChannelKt.Channel$default(-1, null, null, 6, null), new Function1<Throwable, Unit>() { // from class: ru.yoomoney.sdk.march.Defaults.exceptionChannel.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                log.invoke("Exception: ", it);
            }
        });
    }

    public final <STATE> Function1<STATE, Unit> sendState(Function1<? super STATE, Unit> sendState, final Function2<? super String, Object, Unit> log) {
        Intrinsics.checkNotNullParameter(sendState, "sendState");
        Intrinsics.checkNotNullParameter(log, "log");
        return new LoggingFunction(sendState, new Function1<STATE, Unit>() { // from class: ru.yoomoney.sdk.march.Defaults.sendState.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((C25741<STATE>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(STATE state) {
                log.invoke("State:     ", state);
            }
        });
    }

    public final Function2<String, Object, Unit> log(final String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return new Function2<String, Object, Unit>() { // from class: ru.yoomoney.sdk.march.Defaults.log.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Object obj) {
                invoke2(str, obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String contentTag, Object obj) {
                Intrinsics.checkNotNullParameter(contentTag, "contentTag");
                if (Defaults.INSTANCE.isLoggingEnable()) {
                    try {
                        String str = featureName;
                        String string = obj != null ? obj.toString() : null;
                        if (string == null) {
                            string = "";
                        }
                        Log.d(str, contentTag + string);
                    } catch (Throwable th) {
                        Log.e(featureName, "error occurred during log: ", th);
                    }
                }
            }
        };
    }
}
