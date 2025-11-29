package npi.spay;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.yoomoney.sdk.kassa.payments.R$string;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class G4 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ A2 b;
    public final /* synthetic */ C2085z8 c;
    public final /* synthetic */ C1874ql d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G4(A2 a2, C2085z8 c2085z8, C1874ql c1874ql, Continuation continuation) {
        super(2, continuation);
        this.b = a2;
        this.c = c2085z8;
        this.d = c1874ql;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new G4(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((G4) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List listB = ((Di) this.b.b).b();
            if (listB != null && listB.size() == 1) {
                ((Jh) this.b.f).a(new C1900rn(new Z5(new C2097zk(R$string.spay_load_cards, CollectionsKt.emptyList()))));
            }
            A2 a2 = this.b;
            C2085z8 c2085z8 = this.c;
            C1874ql c1874ql = this.d;
            this.a = 1;
            obj = A2.a(a2, c2085z8, c1874ql, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        N8 n8 = (N8) obj;
        if (n8 != null) {
            C7 c7 = this.b.h;
            this.a = 2;
            CoroutineDispatcher io2 = Dispatchers.getIO();
            c7.getClass();
            if (c7.a(n8, io2, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            InterfaceC1495bg interfaceC1495bg = this.b.f;
            Intrinsics.checkNotNullParameter(interfaceC1495bg, "<this>");
            Timber.INSTANCE.e("Unpredictable case", new Object[0]);
            ((Jh) interfaceC1495bg).a(Jn.a);
        }
        return Unit.INSTANCE;
    }
}
