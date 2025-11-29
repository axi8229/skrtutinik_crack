package ru.yoomoney.sdk.auth.select;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.select.SelectAccount;

/* loaded from: classes4.dex */
public final class b extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ SelectAccountFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SelectAccountFragment selectAccountFragment) {
        super(1);
        this.a = selectAccountFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String str) {
        String it = str;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.getViewModel().handleAction(new SelectAccount.Action.SelectAccount(it, this.a.getProcessType(), this.a.getProcessId(), this.a.getExpireAt()));
        return Unit.INSTANCE;
    }
}
