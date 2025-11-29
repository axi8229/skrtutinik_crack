package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\u000f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0012\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a6\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aI\u0010\u001f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aI\u0010#\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\u00002\b\b\u0002\u0010!\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b#\u0010$\u001a5\u0010'\u001a\u00020\u00042\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\fH\u0007¢\u0006\u0004\b'\u0010\u0010\u001a5\u0010)\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00002\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\fH\u0007¢\u0006\u0004\b)\u0010\u0013\u001aA\u00103\u001a\u000202*\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\b2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0.2\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b3\u00104\u001a!\u00105\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020\u0004H\u0001¢\u0006\u0004\b5\u00106\u001a!\u00107\u001a\u00020\b*\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010-\u001a\u00020\bH\u0001¢\u0006\u0004\b7\u00108\u001a1\u0010:\u001a\u000209*\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0003¢\u0006\u0004\b:\u0010;\" \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?\"\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B\"\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000b0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010B\"\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010B\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\u000e\u0010E\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010F\u001a\u00020\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "animationSpec", "initialAlpha", "Landroidx/compose/animation/EnterTransition;", "fadeIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;F)Landroidx/compose/animation/EnterTransition;", "targetAlpha", "Landroidx/compose/animation/ExitTransition;", "fadeOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;F)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "initialOffset", "slideIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "targetOffset", "slideOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "initialScale", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleIn", "Landroidx/compose/ui/Alignment;", "expandFrom", "", "clip", "initialSize", "expandIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "shrinkTowards", "targetSize", "shrinkOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "", "initialOffsetX", "slideInHorizontally", "targetOffsetX", "slideOutHorizontally", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "Lkotlin/Function0;", "isEnabled", "", "label", "Landroidx/compose/ui/Modifier;", "createModifier", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createGraphicsLayerBlock", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/AnimationVector2D;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/SpringSpec;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "DefaultSizeAnimationSpec", "activeEnter", "activeExit", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m97invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m97invoke__ExYCQ(long j) {
            return new AnimationVector2D(TransformOrigin.m1104getPivotFractionXimpl(j), TransformOrigin.m1105getPivotFractionYimpl(j));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m1100boximpl(m98invokeLIALnN8(animationVector2D));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m98invokeLIALnN8(AnimationVector2D animationVector2D) {
            return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m2132boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2151boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    private static final EnterTransition trackActiveEnter$lambda$5(MutableState<EnterTransition> mutableState) {
        return mutableState.getValue();
    }

    private static final ExitTransition trackActiveExit$lambda$8(MutableState<ExitTransition> mutableState) {
        return mutableState.getValue();
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m96scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m1109getCenterSzJe1aQ();
        }
        return m95scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m95scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), false, null, 55, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2151boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandIn.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m2151boximpl(m100invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m100invokemzRDjE0(long j) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, false, null, 59, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2151boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkOut.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m2151boximpl(m101invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m101invokemzRDjE0(long j) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, false, null, 59, null));
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m2132boximpl(m102invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m102invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf(IntSize.m2156getWidthimpl(j))).intValue(), 0);
            }
        });
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m2132boximpl(m103invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m103invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf(IntSize.m2156getWidthimpl(j))).intValue(), 0);
            }
        });
    }

    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, String str, Composer composer, int i, int i2) {
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        ChangeSize changeSize;
        final Function0<Boolean> function02 = (i2 & 4) != 0 ? new Function0<Boolean>() { // from class: androidx.compose.animation.EnterExitTransitionKt.createModifier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        } : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(28261782, i, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:869)");
        }
        int i3 = i & 14;
        EnterTransition enterTransitionTrackActiveEnter = trackActiveEnter(transition, enterTransition, composer, i & 126);
        int i4 = i >> 3;
        ExitTransition exitTransitionTrackActiveExit = trackActiveExit(transition, exitTransition, composer, (i4 & 112) | i3);
        boolean z = true;
        boolean z2 = (enterTransitionTrackActiveEnter.getData().getSlide() == null && exitTransitionTrackActiveExit.getData().getSlide() == null) ? false : true;
        boolean z3 = (enterTransitionTrackActiveEnter.getData().getChangeSize() == null && exitTransitionTrackActiveExit.getData().getChangeSize() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimation3 = null;
        if (z2) {
            composer.startReplaceGroup(-821375963);
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = str + " slide";
                composer.updateRememberedValue(objRememberedValue);
            }
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) objRememberedValue, composer, i3 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation = deferredAnimationCreateDeferredAnimation;
        } else {
            composer.startReplaceGroup(-821278096);
            composer.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z3) {
            composer.startReplaceGroup(-821202177);
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = str + " shrink/expand";
                composer.updateRememberedValue(objRememberedValue2);
            }
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2 = TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) objRememberedValue2, composer, i3 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation2 = deferredAnimationCreateDeferredAnimation2;
        } else {
            composer.startReplaceGroup(-821099041);
            composer.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z3) {
            composer.startReplaceGroup(-821034002);
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = str + " InterruptionHandlingOffset";
                composer.updateRememberedValue(objRememberedValue3);
            }
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation3 = TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) objRememberedValue3, composer, i3 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation3 = deferredAnimationCreateDeferredAnimation3;
        } else {
            composer.startReplaceGroup(-820883777);
            composer.endReplaceGroup();
        }
        ChangeSize changeSize2 = enterTransitionTrackActiveEnter.getData().getChangeSize();
        final boolean z4 = ((changeSize2 == null || changeSize2.getClip()) && ((changeSize = exitTransitionTrackActiveExit.getData().getChangeSize()) == null || changeSize.getClip()) && z3) ? false : true;
        GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExitCreateGraphicsLayerBlock = createGraphicsLayerBlock(transition, enterTransitionTrackActiveEnter, exitTransitionTrackActiveExit, str, composer, i3 | (i4 & 7168));
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean zChanged = composer.changed(z4);
        if ((((i & 7168) ^ 3072) <= 2048 || !composer.changed(function02)) && (i & 3072) != 2048) {
            z = false;
        }
        boolean z5 = zChanged | z;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                    graphicsLayerScope.setClip(!z4 && function02.invoke().booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierThen = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue4).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionTrackActiveEnter, exitTransitionTrackActiveExit, function02, graphicsLayerBlockForEnterExitCreateGraphicsLayerBlock));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modifierThen;
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:910)");
        }
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(enterTransition);
            } else {
                mutableState.setValue(EnterTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            mutableState.setValue(trackActiveEnter$lambda$5(mutableState).plus(enterTransition));
        }
        EnterTransition enterTransitionTrackActiveEnter$lambda$5 = trackActiveEnter$lambda$5(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return enterTransitionTrackActiveEnter$lambda$5;
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:930)");
        }
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(exitTransition);
            } else {
                mutableState.setValue(ExitTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            mutableState.setValue(trackActiveExit$lambda$8(mutableState).plus(exitTransition));
        }
        ExitTransition exitTransitionTrackActiveExit$lambda$8 = trackActiveExit$lambda$8(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return exitTransitionTrackActiveExit$lambda$8;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.animation.GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(final androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r20, final androidx.compose.animation.EnterTransition r21, final androidx.compose.animation.ExitTransition r22, java.lang.String r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.animation.GraphicsLayerBlockForEnterExit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.jvm.functions.Function1 createGraphicsLayerBlock$lambda$13$lambda$12(androidx.compose.animation.core.Transition.DeferredAnimation r3, androidx.compose.animation.core.Transition.DeferredAnimation r4, androidx.compose.animation.core.Transition r5, final androidx.compose.animation.EnterTransition r6, final androidx.compose.animation.ExitTransition r7, androidx.compose.animation.core.Transition.DeferredAnimation r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L12
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            r1.<init>()
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2
            r2.<init>()
            androidx.compose.runtime.State r3 = r3.animate(r1, r2)
            goto L13
        L12:
            r3 = r0
        L13:
            if (r4 == 0) goto L24
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            r1.<init>()
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2
            r2.<init>()
            androidx.compose.runtime.State r4 = r4.animate(r1, r2)
            goto L25
        L24:
            r4 = r0
        L25:
            java.lang.Object r5 = r5.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r5 != r1) goto L4d
            androidx.compose.animation.TransitionData r5 = r6.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L40
        L37:
            long r1 = r5.getTransformOrigin()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m1100boximpl(r1)
            goto L6b
        L40:
            androidx.compose.animation.TransitionData r5 = r7.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L4b
            goto L37
        L4b:
            r5 = r0
            goto L6b
        L4d:
            androidx.compose.animation.TransitionData r5 = r7.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L60
        L57:
            long r1 = r5.getTransformOrigin()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m1100boximpl(r1)
            goto L6b
        L60:
            androidx.compose.animation.TransitionData r5 = r6.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L4b
            goto L57
        L6b:
            if (r8 == 0) goto L78
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState>, androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                static {
                    /*
                        androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1) androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.INSTANCE androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.TransformOrigin> invoke(androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState> r3) {
                    /*
                        r2 = this;
                        r3 = 0
                        r0 = 7
                        r1 = 0
                        androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r1, r1, r3, r0, r3)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.invoke(androidx.compose.animation.core.Transition$Segment):androidx.compose.animation.core.FiniteAnimationSpec");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.TransformOrigin> invoke(androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState> r1) {
                    /*
                        r0 = this;
                        androidx.compose.animation.core.Transition$Segment r1 = (androidx.compose.animation.core.Transition.Segment) r1
                        androidx.compose.animation.core.FiniteAnimationSpec r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2
            r1.<init>()
            androidx.compose.runtime.State r0 = r8.animate(r0, r1)
        L78:
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1 r5 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, androidx.compose.animation.core.Transition$DeferredAnimation):kotlin.jvm.functions.Function1");
    }
}
