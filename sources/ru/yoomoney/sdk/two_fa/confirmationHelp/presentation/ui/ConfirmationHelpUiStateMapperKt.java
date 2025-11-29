package ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.confirmationHelp.ConfirmationHelp;
import ru.yoomoney.sdk.two_fa.confirmationHelp.presentation.ui.ConfirmationHelpUiState;
import ru.yoomoney.sdk.two_fa.domain.SessionType;

/* compiled from: ConfirmationHelpUiStateMapper.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\t"}, d2 = {"getScreenText", "Lkotlin/Pair;", "", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "context", "Landroid/content/Context;", "mapToUiState", "Lru/yoomoney/sdk/two_fa/confirmationHelp/presentation/ui/ConfirmationHelpUiState;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationHelpUiStateMapperKt {

    /* compiled from: ConfirmationHelpUiStateMapper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionType.values().length];
            try {
                iArr[SessionType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionType.SMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ConfirmationHelpUiState mapToUiState(ConfirmationHelp.State state, Context context) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(state instanceof ConfirmationHelp.State.Content)) {
            throw new NoWhenBranchMatchedException();
        }
        ConfirmationHelp.State.Content content = (ConfirmationHelp.State.Content) state;
        Pair<String, String> screenText = getScreenText(content.getSessionType(), context);
        return new ConfirmationHelpUiState.Content(screenText.component1(), screenText.component2(), content.isActionVisible());
    }

    private static final Pair<String, String> getScreenText(SessionType sessionType, Context context) {
        int i = WhenMappings.$EnumSwitchMapping$0[sessionType.ordinal()];
        if (i == 1) {
            return new Pair<>(context.getString(R.string.two_fa_email_confirmation_help_title), context.getString(R.string.two_fa_email_confirmation_help_description));
        }
        if (i == 2) {
            return new Pair<>(context.getString(R.string.two_fa_sms_confirmation_help_title), context.getString(R.string.two_fa_sms_confirmation_help_description));
        }
        throw new IllegalArgumentException("Wrong Session Type");
    }
}
