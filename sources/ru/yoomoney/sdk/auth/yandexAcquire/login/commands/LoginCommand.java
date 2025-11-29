package ru.yoomoney.sdk.auth.yandexAcquire.login.commands;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.login.method.LoginResponse;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bR&\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/LoginCommand;", "ACTION", "", "Lru/yoomoney/sdk/march/Command;", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/login/method/LoginResponse;", "transform", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "getTransform", "()Lkotlin/jvm/functions/Function1;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoginCommand<ACTION> implements Command<Result<? extends LoginResponse>, ACTION> {
    private final Function1<Result<? extends LoginResponse>, ACTION> transform;

    /* JADX WARN: Multi-variable type inference failed */
    public LoginCommand(Function1<? super Result<? extends LoginResponse>, ? extends ACTION> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.transform = transform;
    }

    public Function1<Result<? extends LoginResponse>, ACTION> getTransform() {
        return this.transform;
    }
}
