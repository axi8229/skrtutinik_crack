package ru.yoomoney.sdk.marchcompose.extensions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: ObservingExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aO\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u0010\u001a\u00020\u000e\"\b\b\u0000\u0010\n*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00000\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "STATE", "UI_STATE", "Landroidx/lifecycle/LiveData;", "initial", "Lkotlin/Function1;", "mapToUiState", "Landroidx/compose/runtime/State;", "observeAsUiState", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "onElement", "observe", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "marchcompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObservingExtensionsKt {
    public static final <STATE, UI_STATE> State<UI_STATE> observeAsUiState(LiveData<STATE> liveData, UI_STATE initial, final Function1<? super STATE, ? extends UI_STATE> mapToUiState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(mapToUiState, "mapToUiState");
        composer.startReplaceableGroup(2124930601);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2124930601, i, -1, "ru.yoomoney.sdk.marchcompose.extensions.observeAsUiState (ObservingExtensions.kt:20)");
        }
        composer.startReplaceableGroup(-1039059205);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = Transformations.map(liveData, new Function1<STATE, UI_STATE>() { // from class: ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt$observeAsUiState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final UI_STATE invoke(STATE state) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    return mapToUiState.invoke(state);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        State<UI_STATE> stateObserveAsState = LiveDataAdapterKt.observeAsState((LiveData) objRememberedValue, initial, composer, (((i >> 3) & 8) << 3) | 8 | (i & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateObserveAsState;
    }

    public static final <E> void observe(final ReceiveChannel<? extends E> receiveChannel, final Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> onElement, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(receiveChannel, "<this>");
        Intrinsics.checkNotNullParameter(onElement, "onElement");
        Composer composerStartRestartGroup = composer.startRestartGroup(50099747);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(50099747, i, -1, "ru.yoomoney.sdk.marchcompose.extensions.observe (ObservingExtensions.kt:39)");
        }
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AnonymousClass1((LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()), receiveChannel, onElement, null), composerStartRestartGroup, 70);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt.observe.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ObservingExtensionsKt.observe(receiveChannel, onElement, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* compiled from: ObservingExtensions.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt$observe$1", f = "ObservingExtensions.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt$observe$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ Function2<E, Continuation<? super Unit>, Object> $onElement;
        final /* synthetic */ ReceiveChannel<E> $this_observe;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(LifecycleOwner lifecycleOwner, ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lifecycleOwner = lifecycleOwner;
            this.$this_observe = receiveChannel;
            this.$onElement = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$lifecycleOwner, this.$this_observe, this.$onElement, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ObservingExtensions.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt$observe$1$1", f = "ObservingExtensions.kt", l = {44, 45}, m = "invokeSuspend")
        /* renamed from: ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt$observe$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<E, Continuation<? super Unit>, Object> $onElement;
            final /* synthetic */ ReceiveChannel<E> $this_observe;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C03101(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C03101> continuation) {
                super(2, continuation);
                this.$this_observe = receiveChannel;
                this.$onElement = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03101(this.$this_observe, this.$onElement, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0054 -> B:7:0x0015). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r6.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L27
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r6.L$0
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    kotlin.ResultKt.throwOnFailure(r7)
                L15:
                    r7 = r1
                    goto L30
                L17:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1f:
                    java.lang.Object r1 = r6.L$0
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L3e
                L27:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.channels.ReceiveChannel<E> r7 = r6.$this_observe
                    kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
                L30:
                    r6.L$0 = r7
                    r6.label = r3
                    java.lang.Object r1 = r7.hasNext(r6)
                    if (r1 != r0) goto L3b
                    return r0
                L3b:
                    r5 = r1
                    r1 = r7
                    r7 = r5
                L3e:
                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                    boolean r7 = r7.booleanValue()
                    if (r7 == 0) goto L57
                    java.lang.Object r7 = r1.next()
                    kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r6.$onElement
                    r6.L$0 = r1
                    r6.label = r2
                    java.lang.Object r7 = r4.invoke(r7, r6)
                    if (r7 != r0) goto L15
                    return r0
                L57:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt.AnonymousClass1.C03101.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LifecycleOwnerKt.getLifecycleScope(this.$lifecycleOwner).launchWhenResumed(new C03101(this.$this_observe, this.$onElement, null));
            return Unit.INSTANCE;
        }
    }
}
