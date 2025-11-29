package ru.yoomoney.sdk.two_fa.phoneCall.presentation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.exception.Failure;
import ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;
import ru.yoomoney.sdk.two_fa.phoneCall.presentation.PhoneCallUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: PhoneCallUiStateMapper.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002\u001a8\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¨\u0006\u000f"}, d2 = {"handleInitialError", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$InitialError;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "context", "Landroid/content/Context;", "onBack", "Lkotlin/Function0;", "", "onReload", "mapToUiState", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState;", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$State;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneCallUiStateMapperKt {
    public static final PhoneCallUiState mapToUiState(PhoneCall.State state, ResourceMapper resourceMapper, Context context, Function0<Unit> onBack, Function0<Unit> onReload) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        if (state instanceof PhoneCall.State.Init) {
            return PhoneCallUiState.Init.INSTANCE;
        }
        if (state instanceof PhoneCall.State.InitialError) {
            return handleInitialError(((PhoneCall.State.InitialError) state).getFailure(), resourceMapper, context, onBack, onReload);
        }
        if (state instanceof PhoneCall.State.Confirm) {
            PhoneCall.State.Confirm confirm = (PhoneCall.State.Confirm) state;
            return new PhoneCallUiState.Content(confirm.getConfirmCode(), confirm.getSession().getCodeLength(), confirm.getSession().getAttemptsLeft(), confirm.isEnabledProgressIndicator(), confirm.getSession().getNextAvailableFrom(), confirm.getNextSessionType(), null, 64, null);
        }
        if (state instanceof PhoneCall.State.Content) {
            PhoneCall.State.Content content = (PhoneCall.State.Content) state;
            return new PhoneCallUiState.Content(content.getConfirmCode(), content.getSession().getCodeLength(), content.getSession().getAttemptsLeft(), content.isEnabledProgressIndicator(), content.getSession().getNextAvailableFrom(), content.getNextSessionType(), null, 64, null);
        }
        if (!(state instanceof PhoneCall.State.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        PhoneCall.State.Error error = (PhoneCall.State.Error) state;
        return new PhoneCallUiState.Content(error.getConfirmCode(), error.getSession().getCodeLength(), error.getSession().getAttemptsLeft(), error.isEnabledProgressIndicator(), error.getSession().getNextAvailableFrom(), error.getNextSessionType(), resourceMapper.map(error.getFailure(), Integer.valueOf(error.getSession().getAttemptsLeft())));
    }

    private static final PhoneCallUiState.InitialError handleInitialError(Failure failure, ResourceMapper resourceMapper, Context context, Function0<Unit> function0, Function0<Unit> function02) {
        if (failure instanceof RulesViolationFailure.VelocityCheckFailure) {
            String string = context.getString(R.string.two_fa_error_velocity_check_title);
            String string2 = context.getString(R.string.two_fa_error_velocity_check_descritpion);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(R.string.two_fa_error_velocity_check_action);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return new PhoneCallUiState.InitialError(string, string2, string3, function0);
        }
        String strMap$default = ResourceMapper.map$default(resourceMapper, failure, null, 2, null);
        String string4 = context.getString(R.string.two_fa_technical_error_action);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return new PhoneCallUiState.InitialError(null, strMap$default, string4, function02);
    }
}
