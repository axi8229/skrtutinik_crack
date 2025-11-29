package ru.yoomoney.sdk.auth.yandexAcquire.registration.impl;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistration;
import ru.yoomoney.sdk.auth.yandexAcquire.registration.commands.RegistrationCommand;
import ru.yoomoney.sdk.march.Command;
import ru.yoomoney.sdk.march.TripleBuildersKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J8\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J9\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0002¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/registration/impl/YandexAcquireRegistrationBusinessLogic;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$BusinessLogic;", "()V", "handleContentState", "Lkotlin/Triple;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State;", "Lru/yoomoney/sdk/march/Command;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Effect;", "state", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State$Content;", "action", "handleProgressState", "Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$State$Progress;", "invoke", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireRegistrationBusinessLogic implements YandexAcquireRegistration.BusinessLogic {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Result<? extends RegistrationInit>, YandexAcquireRegistration.Action> {
        public static final a a = new a();

        public a() {
            super(1, YandexAcquireRegistrationBusinessLogicKt.class, "transformRegistration", "transformRegistration(Ljava/lang/Object;)Lru/yoomoney/sdk/auth/yandexAcquire/registration/YandexAcquireRegistration$Action;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final YandexAcquireRegistration.Action invoke(Result<? extends RegistrationInit> result) {
            return YandexAcquireRegistrationBusinessLogicKt.transformRegistration(result.getValue());
        }
    }

    private final Triple<YandexAcquireRegistration.State, Command<?, YandexAcquireRegistration.Action>, YandexAcquireRegistration.Effect> handleContentState(YandexAcquireRegistration.State.Content state, YandexAcquireRegistration.Action action) {
        Object obj;
        if (action instanceof YandexAcquireRegistration.Action.Confirm) {
            return TripleBuildersKt.with(YandexAcquireRegistration.State.Progress.INSTANCE, (Command) new RegistrationCommand(a.a));
        }
        if (Intrinsics.areEqual(action, YandexAcquireRegistration.Action.OpenContacts.INSTANCE)) {
            obj = YandexAcquireRegistration.Effect.ShowContactsDialog.INSTANCE;
        } else if (Intrinsics.areEqual(action, YandexAcquireRegistration.Action.OpenFaq.INSTANCE)) {
            obj = YandexAcquireRegistration.Effect.ShowFAQ.INSTANCE;
        } else if (Intrinsics.areEqual(action, YandexAcquireRegistration.Action.OpenPhone.INSTANCE)) {
            obj = YandexAcquireRegistration.Effect.CallPhone.INSTANCE;
        } else {
            if (!Intrinsics.areEqual(action, YandexAcquireRegistration.Action.OpenEmail.INSTANCE)) {
                return TripleBuildersKt.just(state);
            }
            obj = YandexAcquireRegistration.Effect.SendEmail.INSTANCE;
        }
        return TripleBuildersKt.with(state, obj);
    }

    private final Triple<YandexAcquireRegistration.State, Command<?, YandexAcquireRegistration.Action>, YandexAcquireRegistration.Effect> handleProgressState(YandexAcquireRegistration.State.Progress state, YandexAcquireRegistration.Action action) {
        YandexAcquireRegistration.State.Content content;
        Object showFailure;
        if (action instanceof YandexAcquireRegistration.Action.RegistrationSuccess) {
            content = YandexAcquireRegistration.State.Content.INSTANCE;
            showFailure = new YandexAcquireRegistration.Effect.ShowNextStep(((YandexAcquireRegistration.Action.RegistrationSuccess) action).getProcess());
        } else {
            if (!(action instanceof YandexAcquireRegistration.Action.Fail)) {
                return TripleBuildersKt.just(state);
            }
            content = YandexAcquireRegistration.State.Content.INSTANCE;
            showFailure = new YandexAcquireRegistration.Effect.ShowFailure(((YandexAcquireRegistration.Action.Fail) action).getFailure());
        }
        return TripleBuildersKt.with(content, showFailure);
    }

    @Override // ru.yoomoney.sdk.auth.yandexAcquire.registration.YandexAcquireRegistration.BusinessLogic, kotlin.jvm.functions.Function2
    public Triple<YandexAcquireRegistration.State, Command<?, YandexAcquireRegistration.Action>, YandexAcquireRegistration.Effect> invoke(YandexAcquireRegistration.State state, YandexAcquireRegistration.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof YandexAcquireRegistration.State.Content) {
            return handleContentState((YandexAcquireRegistration.State.Content) state, action);
        }
        if (state instanceof YandexAcquireRegistration.State.Progress) {
            return handleProgressState((YandexAcquireRegistration.State.Progress) state, action);
        }
        throw new NoWhenBranchMatchedException();
    }
}
