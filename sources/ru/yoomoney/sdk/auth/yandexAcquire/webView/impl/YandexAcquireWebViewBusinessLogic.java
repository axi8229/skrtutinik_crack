package ru.yoomoney.sdk.auth.yandexAcquire.webView.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersFailure;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.commands.SetYandexTokenCommand;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J8\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J8\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J8\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J9\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/impl/YandexAcquireWebViewBusinessLogic;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$BusinessLogic;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "analyticsLogger", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/impl/YandexAcquireWebViewAnalyticsLogger;", "(Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/yandexAcquire/webView/impl/YandexAcquireWebViewAnalyticsLogger;)V", "handleContentState", "Lkotlin/Triple;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "state", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Content;", "action", "handleErrorState", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Error;", "handleInitState", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Init;", "handleLoadingtate", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Loading;", "invoke", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireWebViewBusinessLogic implements YandexAcquireWebView.BusinessLogic {
    private final YandexAcquireWebViewAnalyticsLogger analyticsLogger;
    private final ServerTimeRepository serverTimeRepository;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Result<? extends MigrationSetYandexTokenResponse>, YandexAcquireWebView.Action> {
        public static final a a = new a();

        public a() {
            super(1, YandexAcquireWebViewBusinessLogicKt.class, "transformAcquire", "transformAcquire(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final YandexAcquireWebView.Action invoke(Result<? extends MigrationSetYandexTokenResponse> result) {
            return YandexAcquireWebViewBusinessLogicKt.transformAcquire(result.getValue());
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Result<? extends MigrationSetYandexTokenResponse>, YandexAcquireWebView.Action> {
        public static final b a = new b();

        public b() {
            super(1, YandexAcquireWebViewBusinessLogicKt.class, "transformAcquire", "transformAcquire(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final YandexAcquireWebView.Action invoke(Result<? extends MigrationSetYandexTokenResponse> result) {
            return YandexAcquireWebViewBusinessLogicKt.transformAcquire(result.getValue());
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<Result<? extends MigrationSetYandexTokenResponse>, YandexAcquireWebView.Action> {
        public static final c a = new c();

        public c() {
            super(1, YandexAcquireWebViewBusinessLogicKt.class, "transformAcquire", "transformAcquire(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final YandexAcquireWebView.Action invoke(Result<? extends MigrationSetYandexTokenResponse> result) {
            return YandexAcquireWebViewBusinessLogicKt.transformAcquire(result.getValue());
        }
    }

    public YandexAcquireWebViewBusinessLogic(ServerTimeRepository serverTimeRepository, YandexAcquireWebViewAnalyticsLogger yandexAcquireWebViewAnalyticsLogger) {
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.serverTimeRepository = serverTimeRepository;
        this.analyticsLogger = yandexAcquireWebViewAnalyticsLogger;
    }

    private final Triple<YandexAcquireWebView.State, Command<?, YandexAcquireWebView.Action>, YandexAcquireWebView.Effect> handleContentState(YandexAcquireWebView.State.Content state, YandexAcquireWebView.Action action) {
        if (!(action instanceof YandexAcquireWebView.Action.SetYandexToken)) {
            return TripleBuildersKt.just(state);
        }
        YandexAcquireWebView.Action.SetYandexToken setYandexToken = (YandexAcquireWebView.Action.SetYandexToken) action;
        return TripleBuildersKt.with(new YandexAcquireWebView.State.Loading(setYandexToken.getToken()), (Command) new SetYandexTokenCommand(setYandexToken.getProcessId(), setYandexToken.getToken(), a.a));
    }

    private final Triple<YandexAcquireWebView.State, Command<?, YandexAcquireWebView.Action>, YandexAcquireWebView.Effect> handleErrorState(YandexAcquireWebView.State.Error state, YandexAcquireWebView.Action action) {
        Object obj;
        if (action instanceof YandexAcquireWebView.Action.SetYandexToken) {
            YandexAcquireWebView.Action.SetYandexToken setYandexToken = (YandexAcquireWebView.Action.SetYandexToken) action;
            if (setYandexToken.getExpireAt().isAfter(this.serverTimeRepository.getCurrentDateTime())) {
                return TripleBuildersKt.with(new YandexAcquireWebView.State.Loading(state.getToken()), (Command) new SetYandexTokenCommand(setYandexToken.getProcessId(), setYandexToken.getToken(), b.a));
            }
            obj = YandexAcquireWebView.Effect.ShowExpireDialog.INSTANCE;
        } else {
            if (!(action instanceof YandexAcquireWebView.Action.RestartProcess)) {
                return TripleBuildersKt.just(state);
            }
            obj = YandexAcquireWebView.Effect.ResetProcess.INSTANCE;
        }
        return TripleBuildersKt.with(state, obj);
    }

    private final Triple<YandexAcquireWebView.State, Command<?, YandexAcquireWebView.Action>, YandexAcquireWebView.Effect> handleInitState(YandexAcquireWebView.State.Init state, YandexAcquireWebView.Action action) {
        YandexAcquireWebView.State state2;
        if (action instanceof YandexAcquireWebView.Action.PageLoaded) {
            state2 = YandexAcquireWebView.State.Content.INSTANCE;
        } else {
            state2 = state;
            if (action instanceof YandexAcquireWebView.Action.SetYandexToken) {
                YandexAcquireWebView.Action.SetYandexToken setYandexToken = (YandexAcquireWebView.Action.SetYandexToken) action;
                return TripleBuildersKt.with(new YandexAcquireWebView.State.Loading(setYandexToken.getToken()), (Command) new SetYandexTokenCommand(setYandexToken.getProcessId(), setYandexToken.getToken(), c.a));
            }
        }
        return TripleBuildersKt.just(state2);
    }

    private final Triple<YandexAcquireWebView.State, Command<?, YandexAcquireWebView.Action>, YandexAcquireWebView.Effect> handleLoadingtate(YandexAcquireWebView.State.Loading state, YandexAcquireWebView.Action action) {
        List<String> parameterNames;
        if (action instanceof YandexAcquireWebView.Action.AcquireSuccess) {
            return TripleBuildersKt.with(state, new YandexAcquireWebView.Effect.ShowNextStep(((YandexAcquireWebView.Action.AcquireSuccess) action).getProcess()));
        }
        YandexAcquireWebView.State error = state;
        if (action instanceof YandexAcquireWebView.Action.AcquireFail) {
            YandexAcquireWebView.Action.AcquireFail acquireFail = (YandexAcquireWebView.Action.AcquireFail) action;
            error = ((acquireFail.getFailure() instanceof IllegalParametersFailure) && (parameterNames = ((IllegalParametersFailure) acquireFail.getFailure()).getParameterNames()) != null && parameterNames.contains(AppMeasurementSdk.ConditionalUserProperty.VALUE)) ? YandexAcquireWebView.State.Content.INSTANCE : new YandexAcquireWebView.State.Error(state.getToken(), acquireFail.getFailure());
        }
        return TripleBuildersKt.just(error);
    }

    @Override // ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView.BusinessLogic, kotlin.jvm.functions.Function2
    public Triple<YandexAcquireWebView.State, Command<?, YandexAcquireWebView.Action>, YandexAcquireWebView.Effect> invoke(YandexAcquireWebView.State state, YandexAcquireWebView.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        YandexAcquireWebViewAnalyticsLogger yandexAcquireWebViewAnalyticsLogger = this.analyticsLogger;
        if (yandexAcquireWebViewAnalyticsLogger != null) {
            yandexAcquireWebViewAnalyticsLogger.invoke(state, action);
        }
        if (state instanceof YandexAcquireWebView.State.Init) {
            return handleInitState((YandexAcquireWebView.State.Init) state, action);
        }
        if (state instanceof YandexAcquireWebView.State.Content) {
            return handleContentState((YandexAcquireWebView.State.Content) state, action);
        }
        if (state instanceof YandexAcquireWebView.State.Loading) {
            return handleLoadingtate((YandexAcquireWebView.State.Loading) state, action);
        }
        if (state instanceof YandexAcquireWebView.State.Error) {
            return handleErrorState((YandexAcquireWebView.State.Error) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
