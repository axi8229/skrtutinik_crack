package ru.yoomoney.sdk.two_fa.phoneCall.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.two_fa.domain.SessionType;

/* compiled from: PhoneCallUiState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState;", "", "Content", "Init", "InitialError", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$Content;", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$Init;", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$InitialError;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PhoneCallUiState {

    /* compiled from: PhoneCallUiState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$Init;", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState;", "()V", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Init implements PhoneCallUiState {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        private Init() {
        }
    }

    /* compiled from: PhoneCallUiState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$InitialError;", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState;", "failureTitle", "", "failureDescription", "actionText", "onAction", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getActionText", "()Ljava/lang/String;", "getFailureDescription", "getFailureTitle", "getOnAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class InitialError implements PhoneCallUiState {
        public static final int $stable = 0;
        private final String actionText;
        private final String failureDescription;
        private final String failureTitle;
        private final Function0<Unit> onAction;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InitialError copy$default(InitialError initialError, String str, String str2, String str3, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = initialError.failureTitle;
            }
            if ((i & 2) != 0) {
                str2 = initialError.failureDescription;
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
        public final String getFailureTitle() {
            return this.failureTitle;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFailureDescription() {
            return this.failureDescription;
        }

        /* renamed from: component3, reason: from getter */
        public final String getActionText() {
            return this.actionText;
        }

        public final Function0<Unit> component4() {
            return this.onAction;
        }

        public final InitialError copy(String failureTitle, String failureDescription, String actionText, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(failureDescription, "failureDescription");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            return new InitialError(failureTitle, failureDescription, actionText, onAction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitialError)) {
                return false;
            }
            InitialError initialError = (InitialError) other;
            return Intrinsics.areEqual(this.failureTitle, initialError.failureTitle) && Intrinsics.areEqual(this.failureDescription, initialError.failureDescription) && Intrinsics.areEqual(this.actionText, initialError.actionText) && Intrinsics.areEqual(this.onAction, initialError.onAction);
        }

        public int hashCode() {
            String str = this.failureTitle;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + this.failureDescription.hashCode()) * 31) + this.actionText.hashCode()) * 31) + this.onAction.hashCode();
        }

        public String toString() {
            return "InitialError(failureTitle=" + this.failureTitle + ", failureDescription=" + this.failureDescription + ", actionText=" + this.actionText + ", onAction=" + this.onAction + ")";
        }

        public InitialError(String str, String failureDescription, String actionText, Function0<Unit> onAction) {
            Intrinsics.checkNotNullParameter(failureDescription, "failureDescription");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(onAction, "onAction");
            this.failureTitle = str;
            this.failureDescription = failureDescription;
            this.actionText = actionText;
            this.onAction = onAction;
        }

        public final String getFailureTitle() {
            return this.failureTitle;
        }

        public final String getFailureDescription() {
            return this.failureDescription;
        }

        public final String getActionText() {
            return this.actionText;
        }

        public final Function0<Unit> getOnAction() {
            return this.onAction;
        }
    }

    /* compiled from: PhoneCallUiState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState$Content;", "Lru/yoomoney/sdk/two_fa/phoneCall/presentation/PhoneCallUiState;", "confirmCode", "", "codeLength", "", "attemptsLeft", "isEnabledProgressIndicator", "", "nextAvailableFrom", "Lorg/threeten/bp/LocalDateTime;", "nextAvailableSessionOptionType", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", YooMoneyAuth.KEY_FAILURE, "(Ljava/lang/String;IIZLorg/threeten/bp/LocalDateTime;Lru/yoomoney/sdk/two_fa/domain/SessionType;Ljava/lang/String;)V", "getAttemptsLeft", "()I", "getCodeLength", "getConfirmCode", "()Ljava/lang/String;", "getFailure", "()Z", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "getNextAvailableSessionOptionType", "()Lru/yoomoney/sdk/two_fa/domain/SessionType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Content implements PhoneCallUiState {
        public static final int $stable = 8;
        private final int attemptsLeft;
        private final int codeLength;
        private final String confirmCode;
        private final String failure;
        private final boolean isEnabledProgressIndicator;
        private final LocalDateTime nextAvailableFrom;
        private final SessionType nextAvailableSessionOptionType;

        public static /* synthetic */ Content copy$default(Content content, String str, int i, int i2, boolean z, LocalDateTime localDateTime, SessionType sessionType, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = content.confirmCode;
            }
            if ((i3 & 2) != 0) {
                i = content.codeLength;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = content.attemptsLeft;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                z = content.isEnabledProgressIndicator;
            }
            boolean z2 = z;
            if ((i3 & 16) != 0) {
                localDateTime = content.nextAvailableFrom;
            }
            LocalDateTime localDateTime2 = localDateTime;
            if ((i3 & 32) != 0) {
                sessionType = content.nextAvailableSessionOptionType;
            }
            SessionType sessionType2 = sessionType;
            if ((i3 & 64) != 0) {
                str2 = content.failure;
            }
            return content.copy(str, i4, i5, z2, localDateTime2, sessionType2, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConfirmCode() {
            return this.confirmCode;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCodeLength() {
            return this.codeLength;
        }

        /* renamed from: component3, reason: from getter */
        public final int getAttemptsLeft() {
            return this.attemptsLeft;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsEnabledProgressIndicator() {
            return this.isEnabledProgressIndicator;
        }

        /* renamed from: component5, reason: from getter */
        public final LocalDateTime getNextAvailableFrom() {
            return this.nextAvailableFrom;
        }

        /* renamed from: component6, reason: from getter */
        public final SessionType getNextAvailableSessionOptionType() {
            return this.nextAvailableSessionOptionType;
        }

        /* renamed from: component7, reason: from getter */
        public final String getFailure() {
            return this.failure;
        }

        public final Content copy(String confirmCode, int codeLength, int attemptsLeft, boolean isEnabledProgressIndicator, LocalDateTime nextAvailableFrom, SessionType nextAvailableSessionOptionType, String failure) {
            Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
            Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
            return new Content(confirmCode, codeLength, attemptsLeft, isEnabledProgressIndicator, nextAvailableFrom, nextAvailableSessionOptionType, failure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            return Intrinsics.areEqual(this.confirmCode, content.confirmCode) && this.codeLength == content.codeLength && this.attemptsLeft == content.attemptsLeft && this.isEnabledProgressIndicator == content.isEnabledProgressIndicator && Intrinsics.areEqual(this.nextAvailableFrom, content.nextAvailableFrom) && this.nextAvailableSessionOptionType == content.nextAvailableSessionOptionType && Intrinsics.areEqual(this.failure, content.failure);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.confirmCode.hashCode() * 31) + Integer.hashCode(this.codeLength)) * 31) + Integer.hashCode(this.attemptsLeft)) * 31) + Boolean.hashCode(this.isEnabledProgressIndicator)) * 31) + this.nextAvailableFrom.hashCode()) * 31;
            SessionType sessionType = this.nextAvailableSessionOptionType;
            int iHashCode2 = (iHashCode + (sessionType == null ? 0 : sessionType.hashCode())) * 31;
            String str = this.failure;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Content(confirmCode=" + this.confirmCode + ", codeLength=" + this.codeLength + ", attemptsLeft=" + this.attemptsLeft + ", isEnabledProgressIndicator=" + this.isEnabledProgressIndicator + ", nextAvailableFrom=" + this.nextAvailableFrom + ", nextAvailableSessionOptionType=" + this.nextAvailableSessionOptionType + ", failure=" + this.failure + ")";
        }

        public Content(String confirmCode, int i, int i2, boolean z, LocalDateTime nextAvailableFrom, SessionType sessionType, String str) {
            Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
            Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
            this.confirmCode = confirmCode;
            this.codeLength = i;
            this.attemptsLeft = i2;
            this.isEnabledProgressIndicator = z;
            this.nextAvailableFrom = nextAvailableFrom;
            this.nextAvailableSessionOptionType = sessionType;
            this.failure = str;
        }

        public /* synthetic */ Content(String str, int i, int i2, boolean z, LocalDateTime localDateTime, SessionType sessionType, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, z, localDateTime, sessionType, (i3 & 64) != 0 ? null : str2);
        }

        public final String getConfirmCode() {
            return this.confirmCode;
        }

        public final int getCodeLength() {
            return this.codeLength;
        }

        public final int getAttemptsLeft() {
            return this.attemptsLeft;
        }

        public final boolean isEnabledProgressIndicator() {
            return this.isEnabledProgressIndicator;
        }

        public final LocalDateTime getNextAvailableFrom() {
            return this.nextAvailableFrom;
        }

        public final SessionType getNextAvailableSessionOptionType() {
            return this.nextAvailableSessionOptionType;
        }

        public final String getFailure() {
            return this.failure;
        }
    }
}
