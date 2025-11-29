package npi.spay;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class T5 extends SuspendLambda implements Function2 {
    public final /* synthetic */ U5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T5(U5 u5, Continuation continuation) {
        super(2, continuation);
        this.a = u5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new T5(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new T5(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws JSONException, NoSuchPaddingException, zone.bi.mobile.fingerprint.api.serialize.b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        InterfaceC1847pj interfaceC1847pj = this.a.a;
        zone.bi.mobile.fingerprint.api.f[] fVarArr = zone.bi.mobile.fingerprint.api.d.b.a;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "MIX_BASIC_WITH_COORD.parameterTypes");
        String strA = ((C2022wk) interfaceC1847pj).a(new Rj(ArraysKt.asList(fVarArr)));
        Intrinsics.checkNotNullParameter(strA, "<this>");
        String data = StringsKt.replace$default(strA, "\n", "", false, 4, (Object) null);
        Di di = (Di) this.a.b;
        di.getClass();
        Intrinsics.checkNotNullParameter(data, "data");
        di.C = data;
        return data;
    }
}
