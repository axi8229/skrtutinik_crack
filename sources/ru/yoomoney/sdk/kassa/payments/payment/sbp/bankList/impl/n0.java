package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.kassa.payments.R$raw;
import ru.yoomoney.sdk.kassa.payments.api.JacksonBaseObjectMapperKt;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.PrioritySbpBanksConfig;

/* loaded from: classes5.dex */
public final class n0 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(Context context, Continuation continuation) {
        super(2, continuation);
        this.b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        n0 n0Var = new n0(this.b, continuation);
        n0Var.a = obj;
        return n0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        n0 n0Var = new n0(this.b, (Continuation) obj2);
        n0Var.a = (CoroutineScope) obj;
        return n0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM2628constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Context context = this.b;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(R$raw.ym_sbp_priority_banks_config);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, Charsets.UTF_8), 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                objM2628constructorimpl = Result.m2628constructorimpl(((PrioritySbpBanksConfig) JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper().readValue(text, PrioritySbpBanksConfig.class)).getBanks());
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2627boximpl(objM2628constructorimpl);
    }
}
