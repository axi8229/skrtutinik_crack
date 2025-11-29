package ru.yoomoney.sdk.auth.passport.impl;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic$handleContentState$4$1", f = "PassportProfileBusinessLogic.kt", l = {112}, m = "invokeSuspend")
/* renamed from: ru.yoomoney.sdk.auth.passport.impl.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2168y extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ PassportProfileBusinessLogic b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2168y(PassportProfileBusinessLogic passportProfileBusinessLogic, Continuation<? super C2168y> continuation) {
        super(1, continuation);
        this.b = passportProfileBusinessLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C2168y(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return new C2168y(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic.access$getShowEffect$p(ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic):kotlin.jvm.functions.Function2
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:80)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
        	at java.base/java.util.ArrayList.add(ArrayList.java:455)
        	at java.base/java.util.ArrayList.add(ArrayList.java:467)
        	at jadx.core.utils.ListUtils.safeReplace(ListUtils.java:120)
        	at jadx.core.dex.visitors.InlineMethods.lambda$updateUsageInfo$0(InlineMethods.java:182)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:288)
        	at jadx.core.dex.visitors.InlineMethods.updateUsageInfo(InlineMethods.java:162)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:93)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
        	... 1 more
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.a
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r4)
            goto L2b
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L17:
            kotlin.ResultKt.throwOnFailure(r4)
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic r4 = r3.b
            kotlin.jvm.functions.Function2 r4 = ru.yoomoney.sdk.auth.passport.impl.PassportProfileBusinessLogic.access$getShowEffect$p(r4)
            ru.yoomoney.sdk.auth.passport.PassportProfile$Effect$ShowChangeEmailConfirmDialog r1 = ru.yoomoney.sdk.auth.passport.PassportProfile.Effect.ShowChangeEmailConfirmDialog.INSTANCE
            r3.a = r2
            java.lang.Object r4 = r4.invoke(r1, r3)
            if (r4 != r0) goto L2b
            return r0
        L2b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.C2168y.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
