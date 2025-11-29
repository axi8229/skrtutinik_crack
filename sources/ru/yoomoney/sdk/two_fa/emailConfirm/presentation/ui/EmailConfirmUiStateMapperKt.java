package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.emailConfirm.EmailConfirm;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui.EmailConfirmUiState;
import ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: EmailConfirmUiStateMapper.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¨\u0006\f"}, d2 = {"mapToUiState", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "context", "Landroid/content/Context;", "onRetry", "Lkotlin/Function0;", "", "onFinish", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$State$InitialError;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailConfirmUiStateMapperKt {
    public static final EmailConfirmUiState mapToUiState(EmailConfirm.State state, ResourceMapper resourceMapper, Context context, Function0<Unit> onRetry, Function0<Unit> onFinish) {
        EmailConfirmUiState.Content content;
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        if (state instanceof EmailConfirm.State.Init) {
            return EmailConfirmUiState.Init.INSTANCE;
        }
        if (state instanceof EmailConfirm.State.InitialError) {
            return mapToUiState((EmailConfirm.State.InitialError) state, resourceMapper, context, onRetry, onFinish);
        }
        if (state instanceof EmailConfirm.State.Content) {
            EmailConfirm.State.Content content2 = (EmailConfirm.State.Content) state;
            content = new EmailConfirmUiState.Content(content2.getConfirmCode(), content2.getSession().getEmail(), content2.getSession().getNextAvailableFrom(), content2.getEnabledConfirmAction(), content2.isEnabledProgressIndicator(), null);
        } else {
            if (state instanceof EmailConfirm.State.Error) {
                EmailConfirm.State.Error error = (EmailConfirm.State.Error) state;
                return new EmailConfirmUiState.Content(error.getConfirmCode(), error.getSession().getEmail(), error.getSession().getNextAvailableFrom(), false, error.isEnabledProgressIndicator(), resourceMapper.map(error.getFailure(), Integer.valueOf(error.getSession().getAttemptsLeft())));
            }
            if (!(state instanceof EmailConfirm.State.Confirm)) {
                throw new NoWhenBranchMatchedException();
            }
            EmailConfirm.State.Confirm confirm = (EmailConfirm.State.Confirm) state;
            content = new EmailConfirmUiState.Content(confirm.getConfirmCode(), confirm.getSession().getEmail(), confirm.getSession().getNextAvailableFrom(), true, confirm.isEnabledProgressIndicator(), null);
        }
        return content;
    }

    private static final EmailConfirmUiState mapToUiState(EmailConfirm.State.InitialError initialError, ResourceMapper resourceMapper, Context context, Function0<Unit> function0, Function0<Unit> function02) {
        if (initialError.getFailure() instanceof RulesViolationFailure.VelocityCheckFailure) {
            String string = context.getString(R.string.two_fa_error_velocity_check_title);
            String string2 = context.getString(R.string.two_fa_error_velocity_check_descritpion);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(R.string.two_fa_error_velocity_check_action);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return new EmailConfirmUiState.InitialError(string, string2, string3, function02);
        }
        String strMap$default = ResourceMapper.map$default(resourceMapper, initialError.getFailure(), null, 2, null);
        String string4 = context.getString(R.string.two_fa_technical_error_action);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return new EmailConfirmUiState.InitialError(null, strMap$default, string4, function0);
    }
}
