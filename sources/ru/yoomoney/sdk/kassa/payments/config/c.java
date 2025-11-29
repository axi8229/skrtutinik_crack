package ru.yoomoney.sdk.kassa.payments.config;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function0 {
    public final /* synthetic */ TestParameters a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TestParameters testParameters) {
        super(0);
        this.a = testParameters;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String invoke() {
        return this.a.getHostParameters().getConfigHost() + "/";
    }
}
