package ru.yoomoney.sdk.auth.yandexAcquire.login.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.login.method.LoginResponse;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin;
import ru.yoomoney.sdk.auth.yandexAcquire.login.commands.LoginCommand;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J8\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J9\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0002¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/login/impl/YandexAcquireLoginBusinessLogic;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$BusinessLogic;", "()V", "handleContentState", "Lkotlin/Triple;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$State;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Effect;", "state", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$State$Content;", "action", "handleProgressState", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$State$Progress;", "invoke", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireLoginBusinessLogic implements YandexAcquireLogin.BusinessLogic {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Result<? extends LoginResponse>, YandexAcquireLogin.Action> {
        public static final a a = new a();

        public a() {
            super(1, YandexAcquireLoginBusinessLogicKt.class, "transformLogin", "transformLogin(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final YandexAcquireLogin.Action invoke(Result<? extends LoginResponse> result) {
            return YandexAcquireLoginBusinessLogicKt.transformLogin(result.getValue());
        }
    }

    private final Triple<YandexAcquireLogin.State, Command<?, YandexAcquireLogin.Action>, YandexAcquireLogin.Effect> handleContentState(YandexAcquireLogin.State.Content state, YandexAcquireLogin.Action action) {
        return action instanceof YandexAcquireLogin.Action.Confirm ? TripleBuildersKt.with(YandexAcquireLogin.State.Progress.INSTANCE, (Command) new LoginCommand(a.a)) : TripleBuildersKt.just(state);
    }

    private final Triple<YandexAcquireLogin.State, Command<?, YandexAcquireLogin.Action>, YandexAcquireLogin.Effect> handleProgressState(YandexAcquireLogin.State.Progress state, YandexAcquireLogin.Action action) {
        YandexAcquireLogin.State.Content content;
        Object showFailure;
        if (action instanceof YandexAcquireLogin.Action.LoginSuccess) {
            content = YandexAcquireLogin.State.Content.INSTANCE;
            showFailure = new YandexAcquireLogin.Effect.ShowNextStep(((YandexAcquireLogin.Action.LoginSuccess) action).getProcess());
        } else {
            if (!(action instanceof YandexAcquireLogin.Action.Fail)) {
                return TripleBuildersKt.just(state);
            }
            content = YandexAcquireLogin.State.Content.INSTANCE;
            showFailure = new YandexAcquireLogin.Effect.ShowFailure(((YandexAcquireLogin.Action.Fail) action).getFailure());
        }
        return TripleBuildersKt.with(content, showFailure);
    }

    @Override // ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin.BusinessLogic, kotlin.jvm.functions.Function2
    public Triple<YandexAcquireLogin.State, Command<?, YandexAcquireLogin.Action>, YandexAcquireLogin.Effect> invoke(YandexAcquireLogin.State state, YandexAcquireLogin.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof YandexAcquireLogin.State.Content) {
            return handleContentState((YandexAcquireLogin.State.Content) state, action);
        }
        if (state instanceof YandexAcquireLogin.State.Progress) {
            return handleProgressState((YandexAcquireLogin.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
