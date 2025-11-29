package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u000289B'\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR1\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R,\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0(0'8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R*\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00105\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<²\u0006\u0014\u0010;\u001a\u00020:\"\u0004\b\u0000\u0010\u00018\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "S", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/core/Transition;", "transition", "Landroidx/compose/ui/Alignment;", "contentAlignment", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/animation/ContentTransform;", "contentTransform", "Landroidx/compose/ui/Modifier;", "createSizeAnimationModifier$animation_release", "(Landroidx/compose/animation/ContentTransform;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "createSizeAnimationModifier", "Landroidx/compose/animation/core/Transition;", "getTransition$animation_release", "()Landroidx/compose/animation/core/Transition;", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "setContentAlignment", "(Landroidx/compose/ui/Alignment;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection$animation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$animation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/unit/IntSize;", "<set-?>", "measuredSize$delegate", "Landroidx/compose/runtime/MutableState;", "getMeasuredSize-YbymL2g$animation_release", "()J", "setMeasuredSize-ozmzZPI$animation_release", "(J)V", "measuredSize", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/State;", "targetSizeMap", "Landroidx/collection/MutableScatterMap;", "getTargetSizeMap$animation_release", "()Landroidx/collection/MutableScatterMap;", "animatedSize", "Landroidx/compose/runtime/State;", "getAnimatedSize$animation_release", "()Landroidx/compose/runtime/State;", "setAnimatedSize$animation_release", "(Landroidx/compose/runtime/State;)V", "getInitialState", "()Ljava/lang/Object;", "initialState", "getTargetState", "targetState", "ChildData", "SizeModifier", "", "shouldAnimateSize", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl<S> implements AnimatedContentTransitionScope<S> {
    private State<IntSize> animatedSize;
    private Alignment contentAlignment;
    private LayoutDirection layoutDirection;

    /* renamed from: measuredSize$delegate, reason: from kotlin metadata */
    private final MutableState measuredSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m2151boximpl(IntSize.INSTANCE.m2160getZeroYbymL2g()), null, 2, null);
    private final MutableScatterMap<S, State<IntSize>> targetSizeMap = ScatterMapKt.mutableScatterMapOf();
    private final Transition<S> transition;

    private static final boolean createSizeAnimationModifier$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public AnimatedContentTransitionScopeImpl(Transition<S> transition, Alignment alignment, LayoutDirection layoutDirection) {
        this.transition = transition;
        this.contentAlignment = alignment;
        this.layoutDirection = layoutDirection;
    }

    public Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    public void setContentAlignment(Alignment alignment) {
        this.contentAlignment = alignment;
    }

    public final void setLayoutDirection$animation_release(LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    /* renamed from: setMeasuredSize-ozmzZPI$animation_release, reason: not valid java name */
    public final void m88setMeasuredSizeozmzZPI$animation_release(long j) {
        this.measuredSize.setValue(IntSize.m2151boximpl(j));
    }

    public final MutableScatterMap<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    public final void setAnimatedSize$animation_release(State<IntSize> state) {
        this.animatedSize = state;
    }

    public final Modifier createSizeAnimationModifier$animation_release(ContentTransform contentTransform, Composer composer, int i) {
        Modifier modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(93755870, i, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:573)");
        }
        boolean zChanged = composer.changed(this);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer, 0);
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            createSizeAnimationModifier$lambda$3(mutableState, false);
        } else if (stateRememberUpdatedState.getValue() != null) {
            createSizeAnimationModifier$lambda$3(mutableState, true);
        }
        if (createSizeAnimationModifier$lambda$2(mutableState)) {
            composer.startReplaceGroup(249037309);
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), null, composer, 0, 2);
            boolean zChanged2 = composer.changed(deferredAnimationCreateDeferredAnimation);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                SizeTransform sizeTransform = (SizeTransform) stateRememberUpdatedState.getValue();
                objRememberedValue2 = ((sizeTransform == null || sizeTransform.getClip()) ? ClipKt.clipToBounds(Modifier.INSTANCE) : Modifier.INSTANCE).then(new SizeModifier(deferredAnimationCreateDeferredAnimation, stateRememberUpdatedState));
                composer.updateRememberedValue(objRememberedValue2);
            }
            modifier = (Modifier) objRememberedValue2;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(249353726);
            composer.endReplaceGroup();
            this.animatedSize = null;
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modifier;
    }

    private static final void createSizeAnimationModifier$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* compiled from: AnimatedContent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$ChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "isTarget", "", "(Z)V", "<set-?>", "()Z", "setTarget", "isTarget$delegate", "Landroidx/compose/runtime/MutableState;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ChildData implements ParentDataModifier {

        /* renamed from: isTarget$delegate, reason: from kotlin metadata */
        private final MutableState isTarget;

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public Object modifyParentData(Density density, Object obj) {
            return this;
        }

        public ChildData(boolean z) {
            this.isTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean isTarget() {
            return ((Boolean) this.isTarget.getValue()).booleanValue();
        }

        public final void setTarget(boolean z) {
            this.isTarget.setValue(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedContent.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B5\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R-\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeAnimation", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "sizeTransform", "<init>", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/runtime/State;", "getSizeTransform", "()Landroidx/compose/runtime/State;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {
        private final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
        private final State<SizeTransform> sizeTransform;

        /* JADX WARN: Multi-variable type inference failed */
        public SizeModifier(Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, State<? extends SizeTransform> state) {
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = state;
        }

        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        @Override // androidx.compose.ui.layout.LayoutModifier
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            final long packedValue;
            final Placeable placeableMo1420measureBRTryo0 = measurable.mo1420measureBRTryo0(j);
            Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = AnimatedContentTransitionScopeImpl.this;
            Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> function1 = new Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<S> segment) {
                    FiniteAnimationSpec<IntSize> finiteAnimationSpecMo118createAnimationSpecTemP2vQ;
                    State<IntSize> state = animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().get(segment.getInitialState());
                    long packedValue2 = state != null ? state.getValue().getPackedValue() : IntSize.INSTANCE.m2160getZeroYbymL2g();
                    State<IntSize> state2 = animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().get(segment.getTargetState());
                    long packedValue3 = state2 != null ? state2.getValue().getPackedValue() : IntSize.INSTANCE.m2160getZeroYbymL2g();
                    SizeTransform value = this.getSizeTransform().getValue();
                    return (value == null || (finiteAnimationSpecMo118createAnimationSpecTemP2vQ = value.mo118createAnimationSpecTemP2vQ(packedValue2, packedValue3)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : finiteAnimationSpecMo118createAnimationSpecTemP2vQ;
                }
            };
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = AnimatedContentTransitionScopeImpl.this;
            State<IntSize> stateAnimate = deferredAnimation.animate(function1, new Function1<S, IntSize>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(Object obj) {
                    return IntSize.m2151boximpl(m90invokeYEO4UFw(obj));
                }

                /* renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m90invokeYEO4UFw(S s) {
                    State<IntSize> state = animatedContentTransitionScopeImpl2.getTargetSizeMap$animation_release().get(s);
                    return state != null ? state.getValue().getPackedValue() : IntSize.INSTANCE.m2160getZeroYbymL2g();
                }
            });
            AnimatedContentTransitionScopeImpl.this.setAnimatedSize$animation_release(stateAnimate);
            if (measureScope.isLookingAhead()) {
                packedValue = IntSizeKt.IntSize(placeableMo1420measureBRTryo0.getWidth(), placeableMo1420measureBRTryo0.getHeight());
            } else {
                packedValue = stateAnimate.getValue().getPackedValue();
            }
            int iM2156getWidthimpl = IntSize.m2156getWidthimpl(packedValue);
            int iM2155getHeightimpl = IntSize.m2155getHeightimpl(packedValue);
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl3 = AnimatedContentTransitionScopeImpl.this;
            return MeasureScope.layout$default(measureScope, iM2156getWidthimpl, iM2155getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.m1444place70tqf50$default(placementScope, placeableMo1420measureBRTryo0, animatedContentTransitionScopeImpl3.getContentAlignment().mo752alignKFBX0sM(IntSizeKt.IntSize(placeableMo1420measureBRTryo0.getWidth(), placeableMo1420measureBRTryo0.getHeight()), packedValue, LayoutDirection.Ltr), 0.0f, 2, null);
                }
            }, 4, null);
        }
    }
}
