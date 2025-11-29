package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.ui;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

/* compiled from: EmailConfirmUiState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;", "", "Content", "Init", "InitialError", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$Content;", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$Init;", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$InitialError;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface EmailConfirmUiState {

    /* compiled from: EmailConfirmUiState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$Init;", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;", "()V", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Init implements EmailConfirmUiState {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        private Init() {
        }
    }

    /* compiled from: EmailConfirmUiState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$InitialError;", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;", "titleText", "", "subtitleText", "actionText", "onAction", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getActionText", "()Ljava/lang/String;", "getOnAction", "()Lkotlin/jvm/functions/Function0;", "getSubtitleText", "getTitleText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class InitialError implements EmailConfirmUiState {
        public static final int $stable = 0;
        private final String actionText;
        private final Function0<Unit> onAction;
        private final String subtitleText;
        private final String titleText;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InitialError copy$default(InitialError initialError, String str, String str2, String str3, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = initialError.titleText;
            }
            if ((i & 2) != 0) {
                str2 = initialError.subtitleText;
            }
            if ((i & 4) != 0) {
                str3 = initialError.actionText;
            }
            if ((i & 8) != 0) {
                function0 = initialError.onAction;
            }
            return initialError.copy(str, str2, str3, function0);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitleText() {
            return this.titleText;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSubtitleText() {
            return this.subtitleText;
        }

        /* renamed from: component3, reason: from getter */
        public final String getActionText() {
            return this.actionText;
        }

        public final Function0<Unit> component4() {
            return this.onAction;
        }

        public final InitialError copy(String titleText, String subtitleText, String actionText, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(subtitleText, "subtitleText");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            return new InitialError(titleText, subtitleText, actionText, onAction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitialError)) {
                return false;
            }
            InitialError initialError = (InitialError) other;
            return Intrinsics.areEqual(this.titleText, initialError.titleText) && Intrinsics.areEqual(this.subtitleText, initialError.subtitleText) && Intrinsics.areEqual(this.actionText, initialError.actionText) && Intrinsics.areEqual(this.onAction, initialError.onAction);
        }

        public int hashCode() {
            String str = this.titleText;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + this.subtitleText.hashCode()) * 31) + this.actionText.hashCode()) * 31) + this.onAction.hashCode();
        }

        public String toString() {
            return "InitialError(titleText=" + this.titleText + ", subtitleText=" + this.subtitleText + ", actionText=" + this.actionText + ", onAction=" + this.onAction + ")";
        }

        public InitialError(String str, String subtitleText, String actionText, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(subtitleText, "subtitleText");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            this.titleText = str;
            this.subtitleText = subtitleText;
            this.actionText = actionText;
            this.onAction = onAction;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final String getSubtitleText() {
            return this.subtitleText;
        }

        public final String getActionText() {
            return this.actionText;
        }

        public final Function0<Unit> getOnAction() {
            return this.onAction;
        }
    }

    /* compiled from: EmailConfirmUiState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState$Content;", "Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/ui/EmailConfirmUiState;", "confirmCode", "", Scopes.EMAIL, "nextAvailableFrom", "Lorg/threeten/bp/LocalDateTime;", "isConfirmEnabled", "", "isEnabledProgressIndicator", YooMoneyAuth.KEY_FAILURE, "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDateTime;ZZLjava/lang/String;)V", "getConfirmCode", "()Ljava/lang/String;", "getEmail", "getFailure", "()Z", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Content implements EmailConfirmUiState {
        public static final int $stable = 8;
        private final String confirmCode;
        private final String email;
        private final String failure;
        private final boolean isConfirmEnabled;
        private final boolean isEnabledProgressIndicator;
        private final LocalDateTime nextAvailableFrom;

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, LocalDateTime localDateTime, boolean z, boolean z2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = content.confirmCode;
            }
            if ((i & 2) != 0) {
                str2 = content.email;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                localDateTime = content.nextAvailableFrom;
            }
            LocalDateTime localDateTime2 = localDateTime;
            if ((i & 8) != 0) {
                z = content.isConfirmEnabled;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = content.isEnabledProgressIndicator;
            }
            boolean z4 = z2;
            if ((i & 32) != 0) {
                str3 = content.failure;
            }
            return content.copy(str, str4, localDateTime2, z3, z4, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConfirmCode() {
            return this.confirmCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component3, reason: from getter */
        public final LocalDateTime getNextAvailableFrom() {
            return this.nextAvailableFrom;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsConfirmEnabled() {
            return this.isConfirmEnabled;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsEnabledProgressIndicator() {
            return this.isEnabledProgressIndicator;
        }

        /* renamed from: component6, reason: from getter */
        public final String getFailure() {
            return this.failure;
        }

        public final Content copy(String confirmCode, String email, LocalDateTime nextAvailableFrom, boolean isConfirmEnabled, boolean isEnabledProgressIndicator, String failure) {
            Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
            return new Content(confirmCode, email, nextAvailableFrom, isConfirmEnabled, isEnabledProgressIndicator, failure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            return Intrinsics.areEqual(this.confirmCode, content.confirmCode) && Intrinsics.areEqual(this.email, content.email) && Intrinsics.areEqual(this.nextAvailableFrom, content.nextAvailableFrom) && this.isConfirmEnabled == content.isConfirmEnabled && this.isEnabledProgressIndicator == content.isEnabledProgressIndicator && Intrinsics.areEqual(this.failure, content.failure);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.confirmCode.hashCode() * 31) + this.email.hashCode()) * 31) + this.nextAvailableFrom.hashCode()) * 31) + Boolean.hashCode(this.isConfirmEnabled)) * 31) + Boolean.hashCode(this.isEnabledProgressIndicator)) * 31;
            String str = this.failure;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Content(confirmCode=" + this.confirmCode + ", email=" + this.email + ", nextAvailableFrom=" + this.nextAvailableFrom + ", isConfirmEnabled=" + this.isConfirmEnabled + ", isEnabledProgressIndicator=" + this.isEnabledProgressIndicator + ", failure=" + this.failure + ")";
        }

        public Content(String confirmCode, String email, LocalDateTime nextAvailableFrom, boolean z, boolean z2, String str) {
            Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
            this.confirmCode = confirmCode;
            this.email = email;
            this.nextAvailableFrom = nextAvailableFrom;
            this.isConfirmEnabled = z;
            this.isEnabledProgressIndicator = z2;
            this.failure = str;
        }

        public final String getConfirmCode() {
            return this.confirmCode;
        }

        public final String getEmail() {
            return this.email;
        }

        public final LocalDateTime getNextAvailableFrom() {
            return this.nextAvailableFrom;
        }

        public final boolean isConfirmEnabled() {
            return this.isConfirmEnabled;
        }

        public final boolean isEnabledProgressIndicator() {
            return this.isEnabledProgressIndicator;
        }

        public final String getFailure() {
            return this.failure;
        }
    }
}
