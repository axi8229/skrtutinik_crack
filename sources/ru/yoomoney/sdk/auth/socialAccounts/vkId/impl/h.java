package ru.yoomoney.sdk.auth.socialAccounts.vkId.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkId;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;
import ru.yoomoney.sdk.march.RuntimeViewModelDependencies;

/* loaded from: classes4.dex */
public final class h extends Lambda implements Function1<Out.Builder<? extends VkId.State.Progress, VkId.Action>, Unit> {
    public final /* synthetic */ RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> a;
    public final /* synthetic */ VkIdInteractor b;
    public final /* synthetic */ VkIdViewModelFactoryImpl c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RuntimeViewModelDependencies<VkId.State, VkId.Action, VkId.Effect> runtimeViewModelDependencies, VkIdInteractor vkIdInteractor, VkIdViewModelFactoryImpl vkIdViewModelFactoryImpl) {
        super(1);
        this.a = runtimeViewModelDependencies;
        this.b = vkIdInteractor;
        this.c = vkIdViewModelFactoryImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Out.Builder<? extends VkId.State.Progress, VkId.Action> builder) {
        Out.Builder<? extends VkId.State.Progress, VkId.Action> invoke = builder;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new f(this.a, invoke, null));
        CoreKt.input(invoke, new g(this.b, this.c, null));
        return Unit.INSTANCE;
    }
}
