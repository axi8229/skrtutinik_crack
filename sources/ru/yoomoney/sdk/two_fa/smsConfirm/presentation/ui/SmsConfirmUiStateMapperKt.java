package ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure;
import ru.yoomoney.sdk.two_fa.smsConfirm.SmsConfirm;
import ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui.SmsConfirmUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: SmsConfirmUiStateMapper.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001a8\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¨\u0006\r"}, d2 = {"mapToUiState", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "context", "Landroid/content/Context;", "onBack", "Lkotlin/Function0;", "", "onReload", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$InitialError;", "Lru/yoomoney/sdk/two_fa/smsConfirm/SmsConfirm$State$InitialError;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsConfirmUiStateMapperKt {
    public static final SmsConfirmUiState mapToUiState(SmsConfirm.State state, ResourceMapper resourceMapper, Context context, Function0<Unit> onBack, Function0<Unit> onReload) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        if (state instanceof SmsConfirm.State.Init) {
            return SmsConfirmUiState.Init.INSTANCE;
        }
        if (state instanceof SmsConfirm.State.InitialError) {
            return mapToUiState((SmsConfirm.State.InitialError) state, resourceMapper, context, onBack, onReload);
        }
        if (state instanceof SmsConfirm.State.Confirm) {
            SmsConfirm.State.Confirm confirm = (SmsConfirm.State.Confirm) state;
            return new SmsConfirmUiState.Content(confirm.getConfirmCode(), confirm.getSession().getPhone(), confirm.getSession().getCodeLength(), confirm.getSession().getAttemptsLeft(), confirm.isEnabledProgressIndicator(), confirm.getSession().getNextAvailableFrom(), null, 64, null);
        }
        if (state instanceof SmsConfirm.State.Content) {
            SmsConfirm.State.Content content = (SmsConfirm.State.Content) state;
            return new SmsConfirmUiState.Content(content.getConfirmCode(), content.getSession().getPhone(), content.getSession().getCodeLength(), content.getSession().getAttemptsLeft(), content.isEnabledProgressIndicator(), content.getSession().getNextAvailableFrom(), null, 64, null);
        }
        if (!(state instanceof SmsConfirm.State.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        SmsConfirm.State.Error error = (SmsConfirm.State.Error) state;
        return new SmsConfirmUiState.Content(error.getConfirmCode(), error.getSession().getPhone(), error.getSession().getCodeLength(), error.getSession().getAttemptsLeft(), error.isEnabledProgressIndicator(), error.getSession().getNextAvailableFrom(), resourceMapper.map(error.getFailure(), Integer.valueOf(error.getSession().getAttemptsLeft())));
    }

    public static final SmsConfirmUiState.InitialError mapToUiState(SmsConfirm.State.InitialError initialError, ResourceMapper resourceMapper, Context context, Function0<Unit> onBack, Function0<Unit> onReload) {
        Intrinsics.checkNotNullParameter(initialError, "<this>");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        if (initialError.getFailure() instanceof RulesViolationFailure.VelocityCheckFailure) {
            String string = context.getString(R.string.two_fa_error_velocity_check_title);
            String string2 = context.getString(R.string.two_fa_error_velocity_check_descritpion);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(R.string.two_fa_error_velocity_check_action);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return new SmsConfirmUiState.InitialError(string, string2, string3, onBack);
        }
        String strMap$default = ResourceMapper.map$default(resourceMapper, initialError.getFailure(), null, 2, null);
        String string4 = context.getString(R.string.two_fa_technical_error_action);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return new SmsConfirmUiState.InitialError(null, strMap$default, string4, onReload);
    }
}
