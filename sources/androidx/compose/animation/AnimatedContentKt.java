package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a9\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0081\u0001\u0010\u001d\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u001a\b\u0002\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u00020\f0\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00132\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"", "clip", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "sizeAnimationSpec", "Landroidx/compose/animation/SizeTransform;", "SizeTransform", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/animation/SizeTransform;", "Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/ExitTransition;", "exit", "Landroidx/compose/animation/ContentTransform;", "togetherWith", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;)Landroidx/compose/animation/ContentTransform;", "S", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "transitionSpec", "Landroidx/compose/ui/Alignment;", "contentAlignment", "", "contentKey", "Landroidx/compose/animation/AnimatedContentScope;", "", "content", "AnimatedContent", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt.SizeTransform.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m86invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m86invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2151boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x023c A[LOOP:2: B:151:0x023a->B:152:0x023c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S> void AnimatedContent(final androidx.compose.animation.core.Transition<S> r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r22, androidx.compose.ui.Alignment r23, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r24, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
