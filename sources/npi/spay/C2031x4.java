package npi.spay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.x4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2031x4 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;

    public C2031x4(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2031x4 c2031x4 = new C2031x4(continuation);
        c2031x4.a = obj;
        return c2031x4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C2031x4 c2031x4 = new C2031x4((Continuation) obj2);
        c2031x4.a = (String) obj;
        return c2031x4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        String str = (String) this.a;
        Pattern patternCompile = Pattern.compile("(|^)\\d{5}");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(\"(|^)\\\\d{$OTP_CODE_LENGTH}\")");
        Matcher matcher = patternCompile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "pattern.matcher(it)");
        if (matcher.find()) {
            return new C2064yc(matcher.group(0));
        }
        return null;
    }
}
