package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.domain.model.response.UserInfo;

/* renamed from: npi.spay.qc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1865qc extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C1865qc(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1865qc c1865qc = new C1865qc(continuation);
        c1865qc.a = obj;
        return c1865qc;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C1865qc c1865qc = new C1865qc((Continuation) obj2);
        c1865qc.a = (UserInfo) obj;
        return c1865qc.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        UserInfo userInfo = (UserInfo) this.a;
        int i = R$string.spay_user_name_pattern;
        Object[] args = {userInfo.getFirstName(), userInfo.getLastName()};
        Intrinsics.checkNotNullParameter(args, "args");
        C2097zk c2097zk = new C2097zk(i, ArraysKt.toList(args));
        Integer gender = userInfo.getGender();
        return new C1840pc(c2097zk, (gender != null && gender.intValue() == 1) ? R$drawable.spay_img_ava_male_4x : (gender != null && gender.intValue() == 2) ? R$drawable.spay_img_ava_female_4x : R$drawable.spay_img_ava_neutral_4x, userInfo.getMobilePhone());
    }
}
