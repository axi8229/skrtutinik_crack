package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010 \u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001aJ&\u0010)\u001a\u00020&*\u00020!2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J \u0010+\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b*\u0010\u001aR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R:\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R:\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00101\u001a\u0004\b6\u00103\"\u0004\b7\u00105R:\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010D\u001a\u0004\b\u0012\u0010E\"\u0004\bF\u0010GR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bO\u0010PR*\u0010R\u001a\u00020$2\u0006\u0010Q\u001a\u00020$8\u0002@BX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bR\u0010P\"\u0004\bS\u0010TR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R/\u0010_\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030]\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060^0\\8\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR/\u0010c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030]\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0^0\\8\u0006¢\u0006\f\n\u0004\bc\u0010`\u001a\u0004\bd\u0010bR\u0013\u0010f\u001a\u0004\u0018\u00010U8F¢\u0006\u0006\u001a\u0004\be\u0010Y\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006g"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "transition", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "sizeAnimation", "Landroidx/compose/ui/unit/IntOffset;", "offsetAnimation", "slideAnimation", "Landroidx/compose/animation/EnterTransition;", "enter", "Landroidx/compose/animation/ExitTransition;", "exit", "Lkotlin/Function0;", "", "isEnabled", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "graphicsLayerBlock", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "sizeByState", "", "onAttach", "()V", "targetOffsetByState-oFUgxo0", "targetOffsetByState", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "slideTargetValueByState-oFUgxo0", "slideTargetValueByState", "Landroidx/compose/animation/core/Transition;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getOffsetAnimation", "setOffsetAnimation", "getSlideAnimation", "setSlideAnimation", "Landroidx/compose/animation/EnterTransition;", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "Landroidx/compose/animation/ExitTransition;", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "lookaheadConstraintsAvailable", "Z", "lookaheadSize", "J", AppMeasurementSdk.ConditionalUserProperty.VALUE, "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "Landroidx/compose/ui/Alignment;", "currentAlignment", "Landroidx/compose/ui/Alignment;", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "sizeTransitionSpec", "Lkotlin/jvm/functions/Function1;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "slideSpec", "getSlideSpec", "getAlignment", "alignment", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment currentAlignment;
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private boolean lookaheadConstraintsAvailable;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> slideAnimation;
    private Transition<EnterExitState> transition;
    private long lookaheadSize = AnimationModifierKt.getInvalidSize();
    private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$sizeTransitionSpec$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<EnterExitState> segment) {
            EnterExitState enterExitState = EnterExitState.PreEnter;
            EnterExitState enterExitState2 = EnterExitState.Visible;
            FiniteAnimationSpec<IntSize> animationSpec = null;
            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                ChangeSize changeSize = this.this$0.getEnter().getData().getChangeSize();
                if (changeSize != null) {
                    animationSpec = changeSize.getAnimationSpec();
                }
            } else if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                animationSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
            } else {
                ChangeSize changeSize2 = this.this$0.getExit().getData().getChangeSize();
                if (changeSize2 != null) {
                    animationSpec = changeSize2.getAnimationSpec();
                }
            }
            return animationSpec == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : animationSpec;
        }
    };
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
            FiniteAnimationSpec<IntOffset> animationSpec;
            FiniteAnimationSpec<IntOffset> animationSpec2;
            EnterExitState enterExitState = EnterExitState.PreEnter;
            EnterExitState enterExitState2 = EnterExitState.Visible;
            if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                Slide slide = this.this$0.getEnter().getData().getSlide();
                return (slide == null || (animationSpec2 = slide.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : animationSpec2;
            }
            if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            }
            Slide slide2 = this.this$0.getExit().getData().getSlide();
            return (slide2 == null || (animationSpec = slide2.getAnimationSpec()) == null) ? EnterExitTransitionKt.DefaultOffsetAnimationSpec : animationSpec;
        }
    };

    /* compiled from: EnterExitTransition.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void setTransition(Transition<EnterExitState> transition) {
        this.transition = transition;
    }

    public final void setSizeAnimation(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation) {
        this.sizeAnimation = deferredAnimation;
    }

    public final void setOffsetAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.offsetAnimation = deferredAnimation;
    }

    public final void setSlideAnimation(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation) {
        this.slideAnimation = deferredAnimation;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final void setEnter(EnterTransition enterTransition) {
        this.enter = enterTransition;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final void setExit(ExitTransition exitTransition) {
        this.exit = exitTransition;
    }

    public final void setEnabled(Function0<Boolean> function0) {
        this.isEnabled = function0;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    public EnterExitTransitionModifierNode(Transition<EnterExitState> transition, Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransition;
        this.exit = exitTransition;
        this.isEnabled = function0;
        this.graphicsLayerBlock = graphicsLayerBlockForEnterExit;
    }

    /* renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
    private final void m104setLookaheadConstraintsBRTryo0(long j) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = j;
    }

    public final Alignment getAlignment() {
        Alignment alignment;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            ChangeSize changeSize = this.enter.getData().getChangeSize();
            if (changeSize == null || (alignment = changeSize.getAlignment()) == null) {
                ChangeSize changeSize2 = this.exit.getData().getChangeSize();
                if (changeSize2 != null) {
                    return changeSize2.getAlignment();
                }
                return null;
            }
        } else {
            ChangeSize changeSize3 = this.exit.getData().getChangeSize();
            if (changeSize3 == null || (alignment = changeSize3.getAlignment()) == null) {
                ChangeSize changeSize4 = this.enter.getData().getChangeSize();
                if (changeSize4 != null) {
                    return changeSize4.getAlignment();
                }
                return null;
            }
        }
        return alignment;
    }

    /* renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m106sizeByStateUzc_VyU(EnterExitState targetState, long fullSize) {
        Function1<IntSize, IntSize> size;
        Function1<IntSize, IntSize> size2;
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i == 1) {
            return fullSize;
        }
        if (i == 2) {
            ChangeSize changeSize = this.enter.getData().getChangeSize();
            return (changeSize == null || (size = changeSize.getSize()) == null) ? fullSize : size.invoke(IntSize.m2151boximpl(fullSize)).getPackedValue();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ChangeSize changeSize2 = this.exit.getData().getChangeSize();
        return (changeSize2 == null || (size2 = changeSize2.getSize()) == null) ? fullSize : size2.invoke(IntSize.m2151boximpl(fullSize)).getPackedValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    /* renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m108targetOffsetByStateoFUgxo0(EnterExitState targetState, long fullSize) {
        if (this.currentAlignment != null && getAlignment() != null && !Intrinsics.areEqual(this.currentAlignment, getAlignment())) {
            int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
            if (i == 1) {
                return IntOffset.INSTANCE.m2145getZeronOccac();
            }
            if (i == 2) {
                return IntOffset.INSTANCE.m2145getZeronOccac();
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            ChangeSize changeSize = this.exit.getData().getChangeSize();
            if (changeSize != null) {
                long packedValue = changeSize.getSize().invoke(IntSize.m2151boximpl(fullSize)).getPackedValue();
                Alignment alignment = getAlignment();
                Intrinsics.checkNotNull(alignment);
                LayoutDirection layoutDirection = LayoutDirection.Ltr;
                long jMo752alignKFBX0sM = alignment.mo752alignKFBX0sM(fullSize, packedValue, layoutDirection);
                Alignment alignment2 = this.currentAlignment;
                Intrinsics.checkNotNull(alignment2);
                return IntOffset.m2141minusqkQi6aY(jMo752alignKFBX0sM, alignment2.mo752alignKFBX0sM(fullSize, packedValue, layoutDirection));
            }
            return IntOffset.INSTANCE.m2145getZeronOccac();
        }
        return IntOffset.INSTANCE.m2145getZeronOccac();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo105measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        State<IntOffset> stateAnimate;
        State<IntOffset> stateAnimate2;
        if (this.transition.getCurrentState() == this.transition.getTargetState()) {
            this.currentAlignment = null;
        } else if (this.currentAlignment == null) {
            Alignment alignment = getAlignment();
            if (alignment == null) {
                alignment = Alignment.INSTANCE.getTopStart();
            }
            this.currentAlignment = alignment;
        }
        if (measureScope.isLookingAhead()) {
            final Placeable placeableMo1420measureBRTryo0 = measurable.mo1420measureBRTryo0(j);
            long jIntSize = IntSizeKt.IntSize(placeableMo1420measureBRTryo0.getWidth(), placeableMo1420measureBRTryo0.getHeight());
            this.lookaheadSize = jIntSize;
            m104setLookaheadConstraintsBRTryo0(j);
            return MeasureScope.layout$default(measureScope, IntSize.m2156getWidthimpl(jIntSize), IntSize.m2155getHeightimpl(jIntSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$1
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
                    Placeable.PlacementScope.place$default(placementScope, placeableMo1420measureBRTryo0, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        if (this.isEnabled.invoke().booleanValue()) {
            final Function1<GraphicsLayerScope, Unit> function1Init = this.graphicsLayerBlock.init();
            final Placeable placeableMo1420measureBRTryo02 = measurable.mo1420measureBRTryo0(j);
            long jIntSize2 = IntSizeKt.IntSize(placeableMo1420measureBRTryo02.getWidth(), placeableMo1420measureBRTryo02.getHeight());
            final long j2 = AnimationModifierKt.m93isValidozmzZPI(this.lookaheadSize) ? this.lookaheadSize : jIntSize2;
            Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            State<IntSize> stateAnimate3 = deferredAnimation != null ? deferredAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(EnterExitState enterExitState) {
                    return IntSize.m2151boximpl(m109invokeYEO4UFw(enterExitState));
                }

                /* renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m109invokeYEO4UFw(EnterExitState enterExitState) {
                    return this.this$0.m106sizeByStateUzc_VyU(enterExitState, j2);
                }
            }) : null;
            if (stateAnimate3 != null) {
                jIntSize2 = stateAnimate3.getValue().getPackedValue();
            }
            long jM2095constrain4WqzIAM = ConstraintsKt.m2095constrain4WqzIAM(j, jIntSize2);
            Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2 = this.offsetAnimation;
            final long jM2145getZeronOccac = (deferredAnimation2 == null || (stateAnimate2 = deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$1
                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
                    return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                }
            }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                    return IntOffset.m2132boximpl(m110invokeBjo55l4(enterExitState));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m110invokeBjo55l4(EnterExitState enterExitState) {
                    return this.this$0.m108targetOffsetByStateoFUgxo0(enterExitState, j2);
                }
            })) == null) ? IntOffset.INSTANCE.m2145getZeronOccac() : stateAnimate2.getValue().getPackedValue();
            Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation3 = this.slideAnimation;
            long jM2145getZeronOccac2 = (deferredAnimation3 == null || (stateAnimate = deferredAnimation3.animate(this.slideSpec, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$slideOffset$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(EnterExitState enterExitState) {
                    return IntOffset.m2132boximpl(m111invokeBjo55l4(enterExitState));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m111invokeBjo55l4(EnterExitState enterExitState) {
                    return this.this$0.m107slideTargetValueByStateoFUgxo0(enterExitState, j2);
                }
            })) == null) ? IntOffset.INSTANCE.m2145getZeronOccac() : stateAnimate.getValue().getPackedValue();
            Alignment alignment2 = this.currentAlignment;
            final long jM2142plusqkQi6aY = IntOffset.m2142plusqkQi6aY(alignment2 != null ? alignment2.mo752alignKFBX0sM(j2, jM2095constrain4WqzIAM, LayoutDirection.Ltr) : IntOffset.INSTANCE.m2145getZeronOccac(), jM2145getZeronOccac2);
            return MeasureScope.layout$default(measureScope, IntSize.m2156getWidthimpl(jM2095constrain4WqzIAM), IntSize.m2155getHeightimpl(jM2095constrain4WqzIAM), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    placementScope.placeWithLayer(placeableMo1420measureBRTryo02, IntOffset.m2138getXimpl(jM2145getZeronOccac) + IntOffset.m2138getXimpl(jM2142plusqkQi6aY), IntOffset.m2139getYimpl(jM2145getZeronOccac) + IntOffset.m2139getYimpl(jM2142plusqkQi6aY), 0.0f, function1Init);
                }
            }, 4, null);
        }
        final Placeable placeableMo1420measureBRTryo03 = measurable.mo1420measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo1420measureBRTryo03.getWidth(), placeableMo1420measureBRTryo03.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$3$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo1420measureBRTryo03, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* renamed from: slideTargetValueByState-oFUgxo0, reason: not valid java name */
    public final long m107slideTargetValueByStateoFUgxo0(EnterExitState targetState, long fullSize) {
        Function1<IntSize, IntOffset> slideOffset;
        Function1<IntSize, IntOffset> slideOffset2;
        Slide slide = this.enter.getData().getSlide();
        long jM2145getZeronOccac = (slide == null || (slideOffset2 = slide.getSlideOffset()) == null) ? IntOffset.INSTANCE.m2145getZeronOccac() : slideOffset2.invoke(IntSize.m2151boximpl(fullSize)).getPackedValue();
        Slide slide2 = this.exit.getData().getSlide();
        long jM2145getZeronOccac2 = (slide2 == null || (slideOffset = slide2.getSlideOffset()) == null) ? IntOffset.INSTANCE.m2145getZeronOccac() : slideOffset.invoke(IntSize.m2151boximpl(fullSize)).getPackedValue();
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i == 1) {
            return IntOffset.INSTANCE.m2145getZeronOccac();
        }
        if (i == 2) {
            return jM2145getZeronOccac;
        }
        if (i == 3) {
            return jM2145getZeronOccac2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
