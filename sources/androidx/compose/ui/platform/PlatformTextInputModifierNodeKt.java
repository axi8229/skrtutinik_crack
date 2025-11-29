package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* compiled from: PlatformTextInputModifierNode.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001aB\u0010\r\u001a\u00020\u0004*\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0082@¢\u0006\u0004\b\r\u0010\u000e\"\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "", "block", "establishTextInputSession", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "chainedInterceptor", "session", "interceptedTextInputSession", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalChainedPlatformTextInputInterceptor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal<ChainedPlatformTextInputInterceptor> LocalChainedPlatformTextInputInterceptor = CompositionLocalKt.staticCompositionLocalOf(new Function0<ChainedPlatformTextInputInterceptor>() { // from class: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$LocalChainedPlatformTextInputInterceptor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChainedPlatformTextInputInterceptor invoke() {
            return null;
        }
    });

    /* compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", f = "PlatformTextInputModifierNode.kt", l = {143}, m = "establishTextInputSession")
    /* renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlatformTextInputModifierNodeKt.establishTextInputSession(null, null, this);
        }
    }

    /* compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", f = "PlatformTextInputModifierNode.kt", l = {194, 196}, m = "interceptedTextInputSession")
    /* renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1, reason: invalid class name and case insensitive filesystem */
    static final class C04601 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04601(Continuation<? super C04601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlatformTextInputModifierNodeKt.interceptedTextInputSession(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object establishTextInputSession(androidx.compose.ui.platform.PlatformTextInputModifierNode r4, kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1 r0 = (androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1 r0 = new androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5b
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.ui.Modifier$Node r6 = r4.getNode()
            boolean r6 = r6.getIsAttached()
            if (r6 == 0) goto L61
            androidx.compose.ui.node.Owner r6 = androidx.compose.ui.node.DelegatableNodeKt.requireOwner(r4)
            androidx.compose.ui.node.LayoutNode r4 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r4)
            androidx.compose.runtime.CompositionLocalMap r4 = r4.getCompositionLocalMap()
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor> r2 = androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor
            java.lang.Object r4 = r4.get(r2)
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor r4 = (androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor) r4
            r0.label = r3
            java.lang.Object r4 = interceptedTextInputSession(r6, r4, r5, r0)
            if (r4 != r1) goto L5b
            return r1
        L5b:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L61:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "establishTextInputSession called from an unattached node"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.establishTextInputSession(androidx.compose.ui.platform.PlatformTextInputModifierNode, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object interceptedTextInputSession(androidx.compose.ui.node.Owner r5, androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor r6, kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<?> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.C04601
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 r0 = (androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.C04601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 r0 = new androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 == r3) goto L30
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L30:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L46
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 != 0) goto L4c
            r0.label = r4
            java.lang.Object r5 = r5.textInputSession(r7, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L4c:
            r0.label = r3
            java.lang.Object r5 = r6.textInputSession(r5, r7, r0)
            if (r5 != r1) goto L55
            return r1
        L55:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.interceptedTextInputSession(androidx.compose.ui.node.Owner, androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
