package ru.yoomoney.sdk.auth.select.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.analytics.LoginChoiceAccount;
import ru.yoomoney.sdk.auth.analytics.LoginChoiceAccountTapOnAccountFromList;
import ru.yoomoney.sdk.auth.analytics.MigrationChoiceAccount;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordChoiceAccount;
import ru.yoomoney.sdk.auth.analytics.RecoveryPasswordChoiceAccountTapOnAccountFromList;
import ru.yoomoney.sdk.auth.analytics.RegistrationChoiceAccount;
import ru.yoomoney.sdk.auth.analytics.RegistrationChoiceAccountTapOnAccountFromList;
import ru.yoomoney.sdk.auth.analytics.RegistrationChoiceAccountTapOnCreateNewAccount;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.select.SelectAccount;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/select/impl/SelectAccountAnalyticsLogger;", "Lru/yoomoney/sdk/auth/select/SelectAccount$AnalyticsLogger;", "analyticsLogger", "Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;", "(Lru/yoomoney/sdk/auth/analytics/AnalyticsLogger;)V", "handleContentState", "", "action", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "handleCreateNewAccount", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$CreateNewAccount;", "handleSelectAccount", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SelectAccount;", "handleSendAnalyticsForScreen", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action$SendAnalyticsForScreen;", "invoke", "state", "Lru/yoomoney/sdk/auth/select/SelectAccount$State;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccountAnalyticsLogger implements SelectAccount.AnalyticsLogger {
    private final AnalyticsLogger analyticsLogger;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.ENROLLMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProcessType.REGISTRATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProcessType.MIGRATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProcessType.PASSWORD_RECOVERY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SelectAccountAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        Intrinsics.checkNotNullParameter(analyticsLogger, "analyticsLogger");
        this.analyticsLogger = analyticsLogger;
    }

    private final void handleContentState(SelectAccount.Action action) {
        if (action instanceof SelectAccount.Action.SendAnalyticsForScreen) {
            handleSendAnalyticsForScreen((SelectAccount.Action.SendAnalyticsForScreen) action);
        } else if (action instanceof SelectAccount.Action.CreateNewAccount) {
            handleCreateNewAccount((SelectAccount.Action.CreateNewAccount) action);
        } else if (action instanceof SelectAccount.Action.SelectAccount) {
            handleSelectAccount((SelectAccount.Action.SelectAccount) action);
        }
    }

    private final void handleCreateNewAccount(SelectAccount.Action.CreateNewAccount action) {
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 2 || i == 3) {
            this.analyticsLogger.onNewEvent(RegistrationChoiceAccountTapOnCreateNewAccount.INSTANCE);
        }
    }

    private final void handleSelectAccount(SelectAccount.Action.SelectAccount action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = LoginChoiceAccountTapOnAccountFromList.INSTANCE;
        } else if (i == 2 || i == 3) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationChoiceAccountTapOnAccountFromList.INSTANCE;
        } else {
            if (i != 5) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordChoiceAccountTapOnAccountFromList.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    private final void handleSendAnalyticsForScreen(SelectAccount.Action.SendAnalyticsForScreen action) {
        AnalyticsLogger analyticsLogger;
        AnalyticsEvent analyticsEvent;
        int i = WhenMappings.$EnumSwitchMapping$0[action.getProcessType().ordinal()];
        if (i == 1) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = LoginChoiceAccount.INSTANCE;
        } else if (i == 2 || i == 3) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RegistrationChoiceAccount.INSTANCE;
        } else if (i == 4) {
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = MigrationChoiceAccount.INSTANCE;
        } else {
            if (i != 5) {
                return;
            }
            analyticsLogger = this.analyticsLogger;
            analyticsEvent = RecoveryPasswordChoiceAccount.INSTANCE;
        }
        analyticsLogger.onNewEvent(analyticsEvent);
    }

    @Override // ru.yoomoney.sdk.auth.select.SelectAccount.AnalyticsLogger
    public void invoke(SelectAccount.State state, SelectAccount.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof SelectAccount.State.Content) {
            handleContentState(action);
        }
    }
}
