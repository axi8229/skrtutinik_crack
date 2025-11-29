package ru.yoomoney.sdk.auth.yandexAcquire.login.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin;
import ru.yoomoney.sdk.auth.yandexAcquire.login.commands.CommandExecutor;
import ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommand;
import ru.yoomoney.sdk.march.Command;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\tH\u0096B¢\u0006\u0002\u0010\nR \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/login/impl/YandexAcquireLoginCommandProcessor;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$CommandProcessor;", "loginCommandExecutor", "Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/CommandExecutor;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/LoginCommand;", "(Lru/yoomoney/sdk/auth/yandexAcquire/login/commands/CommandExecutor;)V", "invoke", "command", "Lru/yoomoney/sdk/march/Command;", "(Lru/yoomoney/sdk/march/Command;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireLoginCommandProcessor implements YandexAcquireLogin.CommandProcessor {
    private final CommandExecutor<YandexAcquireLogin.Action, LoginCommand<YandexAcquireLogin.Action>> loginCommandExecutor;

    public YandexAcquireLoginCommandProcessor(CommandExecutor<YandexAcquireLogin.Action, LoginCommand<YandexAcquireLogin.Action>> loginCommandExecutor) {
        Intrinsics.checkNotNullParameter(loginCommandExecutor, "loginCommandExecutor");
        this.loginCommandExecutor = loginCommandExecutor;
    }

    @Override // ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin.CommandProcessor
    public Object invoke(Command<?, ? extends YandexAcquireLogin.Action> command, Continuation<? super YandexAcquireLogin.Action> continuation) {
        if (command instanceof LoginCommand) {
            return this.loginCommandExecutor.execute(command, continuation);
        }
        throw new IllegalStateException(("can't execute command " + command).toString());
    }
}
