package ru.yoomoney.sdk.auth.phone.countries.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.phone.countries.PhoneCountries;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class c extends Lambda implements Function1<Out.Builder<? extends PhoneCountries.State.Content, PhoneCountries.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(RuntimeViewModelDependencies<PhoneCountries.State, PhoneCountries.Action, PhoneCountries.Effect> runtimeViewModelDependencies) {
        super(1);
        this.a = runtimeViewModelDependencies;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends PhoneCountries.State.Content, PhoneCountries.Action> builder) {
        Out.Builder<? extends PhoneCountries.State.Content, PhoneCountries.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new b(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
