package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001ac\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0000\"\b\b\u0002\u0010\r*\u00020\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aC\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0001\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\"$\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u001b\u0010!\u001a\u00020\u001c8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"T", "targetState", "", "label", "Landroidx/compose/animation/core/Transition;", "updateTransition", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/TransitionState;", "transitionState", "rememberTransition", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "S", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createDeferredAnimation", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "initialState", "childLabel", "createChildTransitionInternal", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransitionKt {
    private static final Function1<SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged = new Function1<SeekableTransitionState<?>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableTransitionStateTotalDurationChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SeekableTransitionState<?> seekableTransitionState) {
            invoke2(seekableTransitionState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SeekableTransitionState<?> seekableTransitionState) {
            seekableTransitionState.onTotalDurationChanged$animation_core_release();
        }
    };
    private static final Lazy SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                    invoke2((Function0<Unit>) function0);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Function0<Unit> function0) {
                    function0.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });

    public static final <T> Transition<T> updateTransition(T t, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:91)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new Transition(t, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(t, composer, (i & 8) | 48 | (i & 14));
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver) SeekableStateObserver$delegate.getValue();
    }

    public static final <T> Transition<T> rememberTransition(TransitionState<T> transitionState, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, i, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:820)");
        }
        int i3 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && composer.changed(transitionState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Transition((TransitionState) transitionState, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition = (Transition) objRememberedValue;
        if (transitionState instanceof SeekableTransitionState) {
            composer.startReplaceGroup(1030413636);
            T currentState = transitionState.getCurrentState();
            T targetState = transitionState.getTargetState();
            if ((i3 <= 4 || !composer.changed(transitionState)) && (i & 6) != 4) {
                z = false;
            }
            Object objRememberedValue2 = composer.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new TransitionKt$rememberTransition$1$1(transitionState, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(currentState, targetState, (Function2) objRememberedValue2, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1030875195);
            transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
            composer.endReplaceGroup();
        }
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(final Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1779)");
        }
        int i3 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = transition.new DeferredAnimation(twoWayConverter, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        if ((i3 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChangedInstance = composer.changedInstance(deferredAnimation) | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<S> transition2 = transition;
                    final Transition<S>.DeferredAnimation<T, V> deferredAnimation2 = deferredAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(deferredAnimation2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return deferredAnimation;
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(final Transition<S> transition, T t, T t2, String str, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1825)");
        }
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Transition(new MutableTransitionState(t), transition, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition2 = (Transition) objRememberedValue;
        if ((i2 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChanged = composer.changed(transition2) | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition3.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos());
        } else {
            transition2.updateTarget$animation_core_release(t2);
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition2;
    }
}
