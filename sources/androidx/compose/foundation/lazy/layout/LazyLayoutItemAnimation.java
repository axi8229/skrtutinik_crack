package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: LazyLayoutItemAnimation.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 U2\u00020\u0001:\u0001UB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\fJ\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R$\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R+\u0010.\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010+\"\u0004\b/\u00100R+\u00102\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010-\u001a\u0004\b2\u0010+\"\u0004\b3\u00100R+\u00105\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010-\u001a\u0004\b5\u0010+\"\u0004\b6\u00100R+\u00108\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010-\u001a\u0004\b8\u0010+\"\u0004\b9\u00100R(\u0010:\u001a\u00020\r8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010@\u001a\u00020\r8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R(\u0010D\u001a\u0004\u0018\u00010C2\b\u0010(\u001a\u0004\u0018\u00010C8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR \u0010J\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020I0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020L0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010KR1\u0010Q\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bN\u0010-\u001a\u0004\bO\u0010=\"\u0004\bP\u0010?R(\u0010R\u001a\u00020\r8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bR\u0010;\u001a\u0004\bS\u0010=\"\u0004\bT\u0010?\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function0;", "", "onLayerPropertyChanged", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "cancelPlacementAnimation", "()V", "Landroidx/compose/ui/unit/IntOffset;", "delta", "", "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "animatePlacementDelta", "animateAppearance", "animateDisappearance", "release", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/graphics/GraphicsContext;", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "placementSpec", "getPlacementSpec", "setPlacementSpec", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "<set-?>", "isRunningMovingAwayAnimation", "Z", "()Z", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "(Z)V", "isAppearanceAnimationInProgress$delegate", "isAppearanceAnimationInProgress", "setAppearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationFinished$delegate", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "rawOffset", "J", "getRawOffset-nOcc-ac", "()J", "setRawOffset--gyyYBs", "(J)V", "finalOffset", "getFinalOffset-nOcc-ac", "setFinalOffset--gyyYBs", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "visibilityAnimation", "placementDelta$delegate", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutItemAnimation {
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;

    /* renamed from: isAppearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isAppearanceAnimationInProgress;

    /* renamed from: isDisappearanceAnimationFinished$delegate, reason: from kotlin metadata */
    private final MutableState isDisappearanceAnimationFinished;

    /* renamed from: isDisappearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isDisappearanceAnimationInProgress;

    /* renamed from: isPlacementAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isPlacementAnimationInProgress;
    private boolean isRunningMovingAwayAnimation;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0<Unit> onLayerPropertyChanged;

    /* renamed from: placementDelta$delegate, reason: from kotlin metadata */
    private final MutableState placementDelta;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);

    public LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, Function0<Unit> function0) {
        this.coroutineScope = coroutineScope;
        this.graphicsContext = graphicsContext;
        this.onLayerPropertyChanged = function0;
        Boolean bool = Boolean.FALSE;
        this.isPlacementAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isAppearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isDisappearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isDisappearanceAnimationFinished = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        long j = NotInitialized;
        this.rawOffset = j;
        IntOffset.Companion companion = IntOffset.INSTANCE;
        this.finalOffset = companion.m2145getZeronOccac();
        this.layer = graphicsContext != null ? graphicsContext.createGraphicsLayer() : null;
        this.placementDeltaAnimation = new Animatable<>(IntOffset.m2132boximpl(companion.m2145getZeronOccac()), VectorConvertersKt.getVectorConverter(companion), null, null, 12, null);
        this.visibilityAnimation = new Animatable<>(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this.placementDelta = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m2132boximpl(companion.m2145getZeronOccac()), null, 2, null);
        this.lookaheadOffset = j;
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.fadeInSpec = finiteAnimationSpec;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        this.placementSpec = finiteAnimationSpec;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.fadeOutSpec = finiteAnimationSpec;
    }

    /* renamed from: isRunningMovingAwayAnimation, reason: from getter */
    public final boolean getIsRunningMovingAwayAnimation() {
        return this.isRunningMovingAwayAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlacementAnimationInProgress(boolean z) {
        this.isPlacementAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPlacementAnimationInProgress() {
        return ((Boolean) this.isPlacementAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppearanceAnimationInProgress(boolean z) {
        this.isAppearanceAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAppearanceAnimationInProgress() {
        return ((Boolean) this.isAppearanceAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisappearanceAnimationInProgress(boolean z) {
        this.isDisappearanceAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisappearanceAnimationInProgress() {
        return ((Boolean) this.isDisappearanceAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisappearanceAnimationFinished(boolean z) {
        this.isDisappearanceAnimationFinished.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisappearanceAnimationFinished() {
        return ((Boolean) this.isDisappearanceAnimationFinished.getValue()).booleanValue();
    }

    /* renamed from: getRawOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getRawOffset() {
        return this.rawOffset;
    }

    /* renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m378setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    /* renamed from: getFinalOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getFinalOffset() {
        return this.finalOffset;
    }

    /* renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public final void m376setFinalOffsetgyyYBs(long j) {
        this.finalOffset = j;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m370setPlacementDeltagyyYBs(long j) {
        this.placementDelta.setValue(IntOffset.m2132boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m374getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta.getValue()).getPackedValue();
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1", f = "LazyLayoutItemAnimation.kt", l = {115}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1, reason: invalid class name and case insensitive filesystem */
    static final class C04061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04061(Continuation<? super C04061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C04061(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = LazyLayoutItemAnimation.this.placementDeltaAnimation;
                IntOffset intOffsetM2132boximpl = IntOffset.m2132boximpl(IntOffset.INSTANCE.m2145getZeronOccac());
                this.label = 1;
                if (animatable.snapTo(intOffsetM2132boximpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LazyLayoutItemAnimation.this.m370setPlacementDeltagyyYBs(IntOffset.INSTANCE.m2145getZeronOccac());
            LazyLayoutItemAnimation.this.setPlacementAnimationInProgress(false);
            return Unit.INSTANCE;
        }
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C04061(null), 3, null);
        }
    }

    /* renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getLookaheadOffset() {
        return this.lookaheadOffset;
    }

    /* renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public final void m377setLookaheadOffsetgyyYBs(long j) {
        this.lookaheadOffset = j;
    }

    /* renamed from: animatePlacementDelta-ar5cAso, reason: not valid java name */
    public final void m371animatePlacementDeltaar5cAso(long delta, boolean isMovingAway) {
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec = this.placementSpec;
        if (finiteAnimationSpec == null) {
            return;
        }
        long jM2141minusqkQi6aY = IntOffset.m2141minusqkQi6aY(m374getPlacementDeltanOccac(), delta);
        m370setPlacementDeltagyyYBs(jM2141minusqkQi6aY);
        setPlacementAnimationInProgress(true);
        this.isRunningMovingAwayAnimation = isMovingAway;
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, finiteAnimationSpec, jM2141minusqkQi6aY, null), 3, null);
    }

    public final void animateAppearance() {
        GraphicsLayer graphicsLayer = this.layer;
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.fadeInSpec;
        if (isAppearanceAnimationInProgress() || finiteAnimationSpec == null || graphicsLayer == null) {
            if (isDisappearanceAnimationInProgress()) {
                if (graphicsLayer != null) {
                    graphicsLayer.setAlpha(1.0f);
                }
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                return;
            }
            return;
        }
        setAppearanceAnimationInProgress(true);
        boolean zIsDisappearanceAnimationInProgress = isDisappearanceAnimationInProgress();
        boolean z = !zIsDisappearanceAnimationInProgress;
        if (!zIsDisappearanceAnimationInProgress) {
            graphicsLayer.setAlpha(0.0f);
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(z, this, finiteAnimationSpec, graphicsLayer, null), 3, null);
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1", f = "LazyLayoutItemAnimation.kt", l = {pjsip_status_code.PJSIP_SC_QUEUED}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = LazyLayoutItemAnimation.this.visibilityAnimation;
                Float fBoxFloat = Boxing.boxFloat(1.0f);
                this.label = 1;
                if (animatable.snapTo(fBoxFloat, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", l = {195, 197}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ boolean $shouldResetValue;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$shouldResetValue = z;
            this.this$0 = lazyLayoutItemAnimation;
            this.$spec = finiteAnimationSpec;
            this.$layer = graphicsLayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$shouldResetValue) {
                        Animatable animatable = this.this$0.visibilityAnimation;
                        Float fBoxFloat = Boxing.boxFloat(0.0f);
                        this.label = 1;
                        if (animatable.snapTo(fBoxFloat, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.setAppearanceAnimationInProgress(false);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Animatable animatable2 = this.this$0.visibilityAnimation;
                Float fBoxFloat2 = Boxing.boxFloat(1.0f);
                FiniteAnimationSpec<Float> finiteAnimationSpec = this.$spec;
                final GraphicsLayer graphicsLayer = this.$layer;
                final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
                Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.animateAppearance.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable3) {
                        invoke2(animatable3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Animatable<Float, AnimationVector1D> animatable3) {
                        graphicsLayer.setAlpha(animatable3.getValue().floatValue());
                        lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                    }
                };
                this.label = 2;
                if (Animatable.animateTo$default(animatable2, fBoxFloat2, finiteAnimationSpec, null, function1, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.this$0.setAppearanceAnimationInProgress(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.this$0.setAppearanceAnimationInProgress(false);
                throw th;
            }
        }
    }

    public final void animateDisappearance() {
        GraphicsLayer graphicsLayer = this.layer;
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.fadeOutSpec;
        if (graphicsLayer == null || isDisappearanceAnimationInProgress() || finiteAnimationSpec == null) {
            return;
        }
        setDisappearanceAnimationInProgress(true);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C04051(finiteAnimationSpec, graphicsLayer, null), 3, null);
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1", f = "LazyLayoutItemAnimation.kt", l = {216}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1, reason: invalid class name and case insensitive filesystem */
    static final class C04051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04051(FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super C04051> continuation) {
            super(2, continuation);
            this.$spec = finiteAnimationSpec;
            this.$layer = graphicsLayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C04051(this.$spec, this.$layer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = LazyLayoutItemAnimation.this.visibilityAnimation;
                    Float fBoxFloat = Boxing.boxFloat(0.0f);
                    FiniteAnimationSpec<Float> finiteAnimationSpec = this.$spec;
                    final GraphicsLayer graphicsLayer = this.$layer;
                    final LazyLayoutItemAnimation lazyLayoutItemAnimation = LazyLayoutItemAnimation.this;
                    Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.animateDisappearance.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable2) {
                            invoke2(animatable2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animatable<Float, AnimationVector1D> animatable2) {
                            graphicsLayer.setAlpha(animatable2.getValue().floatValue());
                            lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                        }
                    };
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, finiteAnimationSpec, null, function1, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                LazyLayoutItemAnimation.this.setDisappearanceAnimationFinished(true);
                LazyLayoutItemAnimation.this.setDisappearanceAnimationInProgress(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                LazyLayoutItemAnimation.this.setDisappearanceAnimationInProgress(false);
                throw th;
            }
        }
    }

    public final void release() {
        GraphicsContext graphicsContext;
        if (isPlacementAnimationInProgress()) {
            setPlacementAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C04071(null), 3, null);
        }
        if (isAppearanceAnimationInProgress()) {
            setAppearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C04082(null), 3, null);
        }
        if (isDisappearanceAnimationInProgress()) {
            setDisappearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass3(null), 3, null);
        }
        this.isRunningMovingAwayAnimation = false;
        m370setPlacementDeltagyyYBs(IntOffset.INSTANCE.m2145getZeronOccac());
        this.rawOffset = NotInitialized;
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null && (graphicsContext = this.graphicsContext) != null) {
            graphicsContext.releaseGraphicsLayer(graphicsLayer);
        }
        this.layer = null;
        this.fadeInSpec = null;
        this.fadeOutSpec = null;
        this.placementSpec = null;
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1", f = "LazyLayoutItemAnimation.kt", l = {231}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1, reason: invalid class name and case insensitive filesystem */
    static final class C04071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04071(Continuation<? super C04071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C04071(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = LazyLayoutItemAnimation.this.placementDeltaAnimation;
                this.label = 1;
                if (animatable.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2", f = "LazyLayoutItemAnimation.kt", l = {237}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2, reason: invalid class name and case insensitive filesystem */
    static final class C04082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04082(Continuation<? super C04082> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C04082(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = LazyLayoutItemAnimation.this.visibilityAnimation;
                this.label = 1;
                if (animatable.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3", f = "LazyLayoutItemAnimation.kt", l = {243}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable animatable = LazyLayoutItemAnimation.this.visibilityAnimation;
                this.label = 1;
                if (animatable.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m379getNotInitializednOccac() {
            return LazyLayoutItemAnimation.NotInitialized;
        }
    }
}
