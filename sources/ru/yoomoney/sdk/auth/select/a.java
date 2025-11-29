package ru.yoomoney.sdk.auth.select;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.select.SelectAccount;

/* loaded from: classes4.dex */
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SelectAccountFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SelectAccountFragment selectAccountFragment) {
        super(0);
        this.a = selectAccountFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.a.getViewModel().handleAction(new SelectAccount.Action.CreateNewAccount(this.a.getProcessId(), this.a.getPrefilledEmail(), this.a.getShouldRegistrationBeAddedToBackstack(), this.a.getProcessType()));
        return Unit.INSTANCE;
    }
}
