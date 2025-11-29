package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import spay.sdk.domain.model.FakeBankAuthData;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.SessionIdResponseBody;

/* loaded from: classes4.dex */
public final class C9 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ G8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9(G8 g8, Continuation continuation) {
        super(2, continuation);
        this.b = g8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C9(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C9(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            F4 f4 = this.b.d;
            this.a = 1;
            Dispatchers.getIO();
            ContentResponse.Success success = ((Di) f4.a).c;
            if (success == null) {
                success = null;
            }
            obj = success != null ? (SessionIdResponseBody) success.getData() : null;
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SessionIdResponseBody sessionIdResponseBody = (SessionIdResponseBody) obj;
        this.b.e.setValue(new FakeBankAuthData(Boxing.boxBoolean(true), sessionIdResponseBody != null ? sessionIdResponseBody.getState() : null, sessionIdResponseBody != null ? sessionIdResponseBody.getNonce() : null, "E9604229-C3CC-D584-070A-DE59D36A78C3", null, null, 48, null));
        return Unit.INSTANCE;
    }
}
