package npi.spay;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.RedirectActivity;

/* loaded from: classes4.dex */
public final class P0 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ mo b;
    public final /* synthetic */ List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P0(mo moVar, List list, Continuation continuation) {
        super(2, continuation);
        this.b = moVar;
        this.c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new P0(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new P0(this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C2009w7 c2009w7 = this.b.f;
            if (c2009w7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emissionsAuth");
                c2009w7 = null;
            }
            List list = this.c;
            FragmentActivity fragmentActivityRequireActivity = this.b.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type spay.sdk.RedirectActivity");
            this.a = 1;
            obj = c2009w7.a(list, (RedirectActivity) fragmentActivityRequireActivity, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Eg authResult = (Eg) obj;
        A2 a2 = (A2) this.b.b();
        a2.getClass();
        Intrinsics.checkNotNullParameter(authResult, "authResult");
        if (authResult.a()) {
            ((Jh) a2.f).a(authResult instanceof C1874ql ? new C1925sn(C1825om.a, authResult, true) : authResult instanceof Mi ? new C1925sn(C1825om.a, null, false) : Jn.a);
        } else {
            ((Jh) a2.f).a(Zn.a);
        }
        return Unit.INSTANCE;
    }
}
