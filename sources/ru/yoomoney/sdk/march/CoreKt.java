package ru.yoomoney.sdk.march;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import ru.yoomoney.sdk.march.Effect;
import ru.yoomoney.sdk.march.Out;

/* compiled from: Core.kt */
@Metadata(d1 = {"\u0000r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aG\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\b\n\u0010\t\u001aq\u0010\u0014\u001aD\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f0\u000e\"\b\b\u0000\u0010\u0001*\u00020\u0005*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015\u001aË\u0001\u0010\u001e\u001a\u00020\u0010\"\b\b\u0000\u0010\u0000*\u00020\u0005\"\b\b\u0001\u0010\u0001*\u00020\u0005*\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001624\u0010\u001a\u001a0\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u0018j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00192\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2J\b\u0002\u0010\u001d\u001aD\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0010\u0010!\u001a\u00020 H\u0086@¢\u0006\u0004\b!\u0010\"\u001ag\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0018\"\b\b\u0000\u0010\u0000*\u00020\u0005\"\b\b\u0001\u0010\u0001*\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010&¢\u0006\u0004\b(\u0010)\u001aA\u0010,\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0018\"\b\b\u0000\u0010**\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b,\u0010-*R\u0010.\u001a\u0004\b\u0000\u0010\u0000\u001a\u0004\b\u0001\u0010\u0001\" \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u00182 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u0018¨\u0006/"}, d2 = {"STATE", "INPUT", "Lru/yoomoney/sdk/march/Out$Builder;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "func", "", "input", "(Lru/yoomoney/sdk/march/Out$Builder;Lkotlin/jvm/functions/Function1;)V", "output", "Lkotlinx/coroutines/CoroutineScope;", "noKeysScope", "withKeysScope", "Lkotlin/Function3;", "", "Lkotlinx/coroutines/Job;", "", "Lru/yoomoney/sdk/march/Effect;", "Lkotlinx/coroutines/channels/SendChannel;", "createSourcesListener", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/jvm/functions/Function3;", "Lru/yoomoney/sdk/march/Out;", "initial", "Lkotlin/Function2;", "Lru/yoomoney/sdk/march/Logic;", "logic", "Lkotlinx/coroutines/channels/Channel;", "inputChannel", "listenSources", "launchRuntime", "(Lkotlinx/coroutines/CoroutineScope;Lru/yoomoney/sdk/march/Out;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/Job;", "", "suspendUntilCancelled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "main", "showState", "Lkotlinx/coroutines/channels/ReceiveChannel;", "actions", "androidShowState", "(Lkotlinx/coroutines/MainCoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function2;", "EFFECT", "effects", "showEffect", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlin/jvm/functions/Function2;", "Logic", "march_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CoreKt {

    /* compiled from: Core.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt", f = "Core.kt", l = {195}, m = "suspendUntilCancelled")
    /* renamed from: ru.yoomoney.sdk.march.CoreKt$suspendUntilCancelled$1, reason: invalid class name and case insensitive filesystem */
    static final class C25661 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C25661(Continuation<? super C25661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoreKt.suspendUntilCancelled(this);
        }
    }

    public static final <STATE, INPUT> void input(Out.Builder<? extends STATE, INPUT> builder, Function1<? super Continuation<? super INPUT>, ? extends Object> func) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(func, "func");
        builder.getSources().add(new Effect.Input.Fun(func));
    }

    public static final <STATE, INPUT> void output(Out.Builder<? extends STATE, INPUT> builder, Function1<? super Continuation<? super Unit>, ? extends Object> func) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(func, "func");
        builder.getSources().add(new Effect.Output(func));
    }

    public static /* synthetic */ Function3 createSourcesListener$default(CoroutineScope coroutineScope, CoroutineScope coroutineScope2, CoroutineScope coroutineScope3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope2 = CoroutineScopeKt.plus(coroutineScope, SupervisorKt.SupervisorJob((Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE)));
        }
        if ((i & 2) != 0) {
            coroutineScope3 = CoroutineScopeKt.plus(coroutineScope, SupervisorKt.SupervisorJob((Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE)));
        }
        return createSourcesListener(coroutineScope, coroutineScope2, coroutineScope3);
    }

    public static final <INPUT> Function3<Map<Object, ? extends Job>, List<? extends Effect<? extends INPUT>>, SendChannel<? super INPUT>, Map<Object, Job>> createSourcesListener(final CoroutineScope coroutineScope, final CoroutineScope noKeysScope, final CoroutineScope withKeysScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(noKeysScope, "noKeysScope");
        Intrinsics.checkNotNullParameter(withKeysScope, "withKeysScope");
        return new Function3<Map<Object, ? extends Job>, List<? extends Effect<? extends INPUT>>, SendChannel<? super INPUT>, Map<Object, ? extends Job>>() { // from class: ru.yoomoney.sdk.march.CoreKt.createSourcesListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* compiled from: Core.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "INPUT", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt$createSourcesListener$1$1", f = "Core.kt", l = {119}, m = "invokeSuspend")
            /* renamed from: ru.yoomoney.sdk.march.CoreKt$createSourcesListener$1$1, reason: invalid class name and collision with other inner class name */
            static final class C03091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<Effect<INPUT>> $effects;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C03091(List<? extends Effect<? extends INPUT>> list, Continuation<? super C03091> continuation) {
                    super(2, continuation);
                    this.$effects = list;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C03091(this.$effects, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C03091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Iterator it;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        List<Effect<INPUT>> list = this.$effects;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            if (obj2 instanceof Effect.Output) {
                                arrayList.add(obj2);
                            }
                        }
                        it = arrayList.iterator();
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (Iterator) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    while (it.hasNext()) {
                        Function1<Continuation<? super Unit>, Object> func = ((Effect.Output) it.next()).getFunc();
                        this.L$0 = it;
                        this.label = 1;
                        if (func.invoke(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public final Map<Object, Job> invoke(Map<Object, ? extends Job> running, List<? extends Effect<? extends INPUT>> effects, SendChannel<? super INPUT> inputs) {
                Object key;
                Intrinsics.checkNotNullParameter(running, "running");
                Intrinsics.checkNotNullParameter(effects, "effects");
                Intrinsics.checkNotNullParameter(inputs, "inputs");
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03091(effects, null), 3, null);
                List<? extends Effect<? extends INPUT>> list = effects;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof Effect.Input.Fun) {
                        arrayList.add(obj);
                    }
                }
                CoroutineScope coroutineScope2 = noKeysScope;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CoreKt$createSourcesListener$1$2$1(inputs, (Effect.Input.Fun) it.next(), null), 3, null);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    Effect effect = (Effect) it2.next();
                    if (effect instanceof Effect.Input.Sub) {
                        Effect.Input.Sub sub = (Effect.Input.Sub) effect;
                        Job job = running.get(sub.getKey());
                        if (job != null) {
                            job.cancel(new CancellationException("New func with same key " + sub.getKey()));
                            key = sub.getKey();
                        } else {
                            key = null;
                        }
                    } else {
                        if (effect instanceof Effect.Cancel) {
                            Effect.Cancel cancel = (Effect.Cancel) effect;
                            Job job2 = running.get(cancel.getKey());
                            if (job2 != null) {
                                job2.cancel(new CancellationException("Cancelled by key " + cancel.getKey()));
                                key = cancel.getKey();
                            }
                        } else if (!(effect instanceof Effect.Input.Fun) && !(effect instanceof Effect.Output)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        key = null;
                    }
                    if (key != null) {
                        arrayList2.add(key);
                    }
                }
                Map mapMinus = MapsKt.minus(running, arrayList2);
                ArrayList<Effect.Input.Sub> arrayList3 = new ArrayList();
                for (Object obj2 : list) {
                    if (obj2 instanceof Effect.Input.Sub) {
                        arrayList3.add(obj2);
                    }
                }
                CoroutineScope coroutineScope3 = withKeysScope;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (Effect.Input.Sub sub2 : arrayList3) {
                    arrayList4.add(TuplesKt.to(sub2.getKey(), BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new CoreKt$createSourcesListener$1$3$1(sub2, inputs, null), 3, null)));
                }
                return MapsKt.plus(mapMinus, arrayList4);
            }
        };
    }

    public static /* synthetic */ Job launchRuntime$default(CoroutineScope coroutineScope, Out out, Function2 function2, Channel channel, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            channel = ChannelKt.Channel$default(-1, null, null, 6, null);
        }
        if ((i & 8) != 0) {
            function3 = createSourcesListener$default(coroutineScope, null, null, 3, null);
        }
        return launchRuntime(coroutineScope, out, function2, channel, function3);
    }

    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "INPUT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt$launchRuntime$1", f = "Core.kt", l = {165}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CoreKt$launchRuntime$1, reason: invalid class name and case insensitive filesystem */
    static final class C25641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Out<STATE, INPUT> $initial;
        final /* synthetic */ Channel<INPUT> $inputChannel;
        final /* synthetic */ Function3<Map<Object, ? extends Job>, List<? extends Effect<? extends INPUT>>, SendChannel<? super INPUT>, Map<Object, Job>> $listenSources;
        final /* synthetic */ Function2<STATE, INPUT, Out<STATE, INPUT>> $logic;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25641(Out<? extends STATE, ? extends INPUT> out, Function3<? super Map<Object, ? extends Job>, ? super List<? extends Effect<? extends INPUT>>, ? super SendChannel<? super INPUT>, ? extends Map<Object, ? extends Job>> function3, Channel<INPUT> channel, Function2<? super STATE, ? super INPUT, ? extends Out<? extends STATE, ? extends INPUT>> function2, Continuation<? super C25641> continuation) {
            super(2, continuation);
            this.$initial = out;
            this.$listenSources = function3;
            this.$inputChannel = channel;
            this.$logic = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25641(this.$initial, this.$listenSources, this.$inputChannel, this.$logic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Path cross not found for [B:19:0x0091, B:25:0x00a6], limit reached: 31 */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0056 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0054 -> B:12:0x0057). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r9.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r3 = r9.L$1
                java.util.Map r3 = (java.util.Map) r3
                java.lang.Object r4 = r9.L$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L57
            L19:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L21:
                kotlin.ResultKt.throwOnFailure(r10)
                ru.yoomoney.sdk.march.Out<STATE, INPUT> r10 = r9.$initial
                java.lang.Object r10 = r10.getState()
                kotlin.jvm.functions.Function3<java.util.Map<java.lang.Object, ? extends kotlinx.coroutines.Job>, java.util.List<? extends ru.yoomoney.sdk.march.Effect<? extends INPUT>>, kotlinx.coroutines.channels.SendChannel<? super INPUT>, java.util.Map<java.lang.Object, kotlinx.coroutines.Job>> r1 = r9.$listenSources
                java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
                ru.yoomoney.sdk.march.Out<STATE, INPUT> r4 = r9.$initial
                java.util.List r4 = r4.getSources()
                kotlinx.coroutines.channels.Channel<INPUT> r5 = r9.$inputChannel
                java.lang.Object r1 = r1.invoke(r3, r4, r5)
                java.util.Map r1 = (java.util.Map) r1
                kotlinx.coroutines.channels.Channel<INPUT> r3 = r9.$inputChannel
                kotlinx.coroutines.channels.ChannelIterator r3 = r3.iterator()
                r4 = r10
                r8 = r3
                r3 = r1
                r1 = r8
            L48:
                r9.L$0 = r4
                r9.L$1 = r3
                r9.L$2 = r1
                r9.label = r2
                java.lang.Object r10 = r1.hasNext(r9)
                if (r10 != r0) goto L57
                return r0
            L57:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto Lb3
                java.lang.Object r10 = r1.next()
                kotlin.jvm.functions.Function2<STATE, INPUT, ru.yoomoney.sdk.march.Out<STATE, INPUT>> r5 = r9.$logic
                java.lang.Object r10 = r5.invoke(r4, r10)
                ru.yoomoney.sdk.march.Out r10 = (ru.yoomoney.sdk.march.Out) r10
                java.lang.Object r4 = r10.getState()
                kotlin.jvm.functions.Function3<java.util.Map<java.lang.Object, ? extends kotlinx.coroutines.Job>, java.util.List<? extends ru.yoomoney.sdk.march.Effect<? extends INPUT>>, kotlinx.coroutines.channels.SendChannel<? super INPUT>, java.util.Map<java.lang.Object, kotlinx.coroutines.Job>> r5 = r9.$listenSources
                java.util.List r6 = r10.getSources()
                kotlinx.coroutines.channels.Channel<INPUT> r7 = r9.$inputChannel
                java.lang.Object r3 = r5.invoke(r3, r6, r7)
                java.util.Map r3 = (java.util.Map) r3
                java.util.List r10 = r10.getSources()
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                boolean r5 = r10 instanceof java.util.Collection
                if (r5 == 0) goto L91
                r5 = r10
                java.util.Collection r5 = (java.util.Collection) r5
                boolean r5 = r5.isEmpty()
                if (r5 == 0) goto L91
                goto La6
            L91:
                java.util.Iterator r10 = r10.iterator()
            L95:
                boolean r5 = r10.hasNext()
                if (r5 == 0) goto La6
                java.lang.Object r5 = r10.next()
                ru.yoomoney.sdk.march.Effect r5 = (ru.yoomoney.sdk.march.Effect) r5
                boolean r5 = r5 instanceof ru.yoomoney.sdk.march.Effect.Input
                if (r5 == 0) goto L95
                goto L48
            La6:
                boolean r10 = r3.isEmpty()
                if (r10 == 0) goto L48
                kotlinx.coroutines.channels.Channel<INPUT> r10 = r9.$inputChannel
                r5 = 0
                kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r10, r5, r2, r5)
                goto L48
            Lb3:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.march.CoreKt.C25641.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <STATE, INPUT> Job launchRuntime(CoroutineScope coroutineScope, Out<? extends STATE, ? extends INPUT> initial, Function2<? super STATE, ? super INPUT, ? extends Out<? extends STATE, ? extends INPUT>> logic, Channel<INPUT> inputChannel, Function3<? super Map<Object, ? extends Job>, ? super List<? extends Effect<? extends INPUT>>, ? super SendChannel<? super INPUT>, ? extends Map<Object, ? extends Job>> listenSources) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(inputChannel, "inputChannel");
        Intrinsics.checkNotNullParameter(listenSources, "listenSources");
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C25641(initial, listenSources, inputChannel, logic, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object suspendUntilCancelled(kotlin.coroutines.Continuation<?> r4) {
        /*
            boolean r0 = r4 instanceof ru.yoomoney.sdk.march.CoreKt.C25661
            if (r0 == 0) goto L13
            r0 = r4
            ru.yoomoney.sdk.march.CoreKt$suspendUntilCancelled$1 r0 = (ru.yoomoney.sdk.march.CoreKt.C25661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.march.CoreKt$suspendUntilCancelled$1 r0 = new ru.yoomoney.sdk.march.CoreKt$suspendUntilCancelled$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            kotlin.ResultKt.throwOnFailure(r4)
            goto L52
        L31:
            kotlin.ResultKt.throwOnFailure(r4)
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r4 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r4.<init>(r2, r3)
            r4.initCancellability()
            java.lang.Object r4 = r4.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r2) goto L4f
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.march.CoreKt.suspendUntilCancelled(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Add missing generic type declarations: [INPUT, STATE] */
    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "INPUT", "STATE", "", "state"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt$androidShowState$1", f = "Core.kt", l = {184, 185}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CoreKt$androidShowState$1, reason: invalid class name */
    static final class AnonymousClass1<INPUT, STATE> extends SuspendLambda implements Function2<STATE, Continuation<? super INPUT>, Object> {
        final /* synthetic */ ReceiveChannel<INPUT> $actions;
        final /* synthetic */ MainCoroutineDispatcher $main;
        final /* synthetic */ Function1<STATE, Unit> $showState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MainCoroutineDispatcher mainCoroutineDispatcher, ReceiveChannel<? extends INPUT> receiveChannel, Function1<? super STATE, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$main = mainCoroutineDispatcher;
            this.$actions = receiveChannel;
            this.$showState = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$main, this.$actions, this.$showState, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass1<INPUT, STATE>) obj, (Continuation) obj2);
        }

        public final Object invoke(STATE state, Continuation<? super INPUT> continuation) {
            return ((AnonymousClass1) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Core.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "INPUT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt$androidShowState$1$1", f = "Core.kt", l = {}, m = "invokeSuspend")
        /* renamed from: ru.yoomoney.sdk.march.CoreKt$androidShowState$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<STATE, Unit> $showState;
            final /* synthetic */ STATE $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C03081(Function1<? super STATE, Unit> function1, STATE state, Continuation<? super C03081> continuation) {
                super(2, continuation);
                this.$showState = function1;
                this.$state = state;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03081(this.$showState, this.$state, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$showState.invoke(this.$state);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                MainCoroutineDispatcher mainCoroutineDispatcher = this.$main;
                C03081 c03081 = new C03081(this.$showState, obj2, null);
                this.label = 1;
                if (BuildersKt.withContext(mainCoroutineDispatcher, c03081, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReceiveChannel<INPUT> receiveChannel = this.$actions;
            this.label = 2;
            obj = receiveChannel.receive(this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        }
    }

    public static final <STATE, INPUT> Function2<STATE, Continuation<? super INPUT>, Object> androidShowState(MainCoroutineDispatcher main, Function1<? super STATE, Unit> showState, ReceiveChannel<? extends INPUT> actions) {
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(actions, "actions");
        return new AnonymousClass1(main, actions, showState, null);
    }

    /* JADX INFO: Add missing generic type declarations: [EFFECT] */
    /* compiled from: Core.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "EFFECT", "", "effect"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt$showEffect$1", f = "Core.kt", l = {191, 192}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.CoreKt$showEffect$1, reason: invalid class name and case insensitive filesystem */
    static final class C25651<EFFECT> extends SuspendLambda implements Function2<EFFECT, Continuation<?>, Object> {
        final /* synthetic */ SendChannel<EFFECT> $effects;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25651(SendChannel<? super EFFECT> sendChannel, Continuation<? super C25651> continuation) {
            super(2, continuation);
            this.$effects = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C25651 c25651 = new C25651(this.$effects, continuation);
            c25651.L$0 = obj;
            return c25651;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<?> continuation) {
            return invoke2((C25651<EFFECT>) obj, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(EFFECT effect, Continuation<?> continuation) {
            return ((C25651) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                SendChannel<EFFECT> sendChannel = this.$effects;
                this.label = 1;
                if (sendChannel.send(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    throw new KotlinNothingValueException();
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (CoreKt.suspendUntilCancelled(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw new KotlinNothingValueException();
        }
    }

    public static final <EFFECT> Function2<EFFECT, Continuation<?>, Object> showEffect(SendChannel<? super EFFECT> effects) {
        Intrinsics.checkNotNullParameter(effects, "effects");
        return new C25651(effects, null);
    }
}
