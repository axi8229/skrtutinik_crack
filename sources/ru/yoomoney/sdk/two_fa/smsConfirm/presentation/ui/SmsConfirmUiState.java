package ru.yoomoney.sdk.two_fa.smsConfirm.presentation.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

/* compiled from: SmsConfirmUiState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;", "", "Content", "Init", "InitialError", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$Content;", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$Init;", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$InitialError;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SmsConfirmUiState {

    /* compiled from: SmsConfirmUiState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$Init;", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;", "()V", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Init implements SmsConfirmUiState {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        private Init() {
        }
    }

    /* compiled from: SmsConfirmUiState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$InitialError;", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;", "failureTitle", "", "failureDescription", "actionText", "onAction", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getActionText", "()Ljava/lang/String;", "getFailureDescription", "getFailureTitle", "getOnAction", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class InitialError implements SmsConfirmUiState {
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

    /* compiled from: SmsConfirmUiState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState$Content;", "Lru/yoomoney/sdk/two_fa/smsConfirm/presentation/ui/SmsConfirmUiState;", "confirmCode", "", "phone", "codeLength", "", "attemptsLeft", "isEnabledProgressIndicator", "", "nextAvailableFrom", "Lorg/threeten/bp/LocalDateTime;", YooMoneyAuth.KEY_FAILURE, "(Ljava/lang/String;Ljava/lang/String;IIZLorg/threeten/bp/LocalDateTime;Ljava/lang/String;)V", "getAttemptsLeft", "()I", "getCodeLength", "getConfirmCode", "()Ljava/lang/String;", "getFailure", "()Z", "getNextAvailableFrom", "()Lorg/threeten/bp/LocalDateTime;", "getPhone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Content implements SmsConfirmUiState {
        public static final int $stable = 8;
        private final int attemptsLeft;
        private final int codeLength;
        private final String confirmCode;
        private final String failure;
        private final boolean isEnabledProgressIndicator;
        private final LocalDateTime nextAvailableFrom;
        private final String phone;

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, int i, int i2, boolean z, LocalDateTime localDateTime, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = content.confirmCode;
            }
            if ((i3 & 2) != 0) {
                str2 = content.phone;
            }
            String str4 = str2;
            if ((i3 & 4) != 0) {
                i = content.codeLength;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = content.attemptsLeft;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                z = content.isEnabledProgressIndicator;
            }
            boolean z2 = z;
            if ((i3 & 32) != 0) {
                localDateTime = content.nextAvailableFrom;
            }
            LocalDateTime localDateTime2 = localDateTime;
            if ((i3 & 64) != 0) {
                str3 = content.failure;
            }
            return content.copy(str, str4, i4, i5, z2, localDateTime2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConfirmCode() {
            return this.confirmCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCodeLength() {
            return this.codeLength;
        }

        /* renamed from: component4, reason: from getter */
        public final int getAttemptsLeft() {
            return this.attemptsLeft;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsEnabledProgressIndicator() {
            return this.isEnabledProgressIndicator;
        }

        /* renamed from: component6, reason: from getter */
        public final LocalDateTime getNextAvailableFrom() {
            return this.nextAvailableFrom;
        }

        /* renamed from: component7, reason: from getter */
        public final String getFailure() {
            return this.failure;
        }

        public final Content copy(String confirmCode, String phone, int codeLength, int attemptsLeft, boolean isEnabledProgressIndicator, LocalDateTime nextAvailableFrom, String failure) {
            Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
            return new Content(confirmCode, phone, codeLength, attemptsLeft, isEnabledProgressIndicator, nextAvailableFrom, failure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            return Intrinsics.areEqual(this.confirmCode, content.confirmCode) && Intrinsics.areEqual(this.phone, content.phone) && this.codeLength == content.codeLength && this.attemptsLeft == content.attemptsLeft && this.isEnabledProgressIndicator == content.isEnabledProgressIndicator && Intrinsics.areEqual(this.nextAvailableFrom, content.nextAvailableFrom) && Intrinsics.areEqual(this.failure, content.failure);
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.confirmCode.hashCode() * 31) + this.phone.hashCode()) * 31) + Integer.hashCode(this.codeLength)) * 31) + Integer.hashCode(this.attemptsLeft)) * 31) + Boolean.hashCode(this.isEnabledProgressIndicator)) * 31) + this.nextAvailableFrom.hashCode()) * 31;
            String str = this.failure;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Content(confirmCode=" + this.confirmCode + ", phone=" + this.phone + ", codeLength=" + this.codeLength + ", attemptsLeft=" + this.attemptsLeft + ", isEnabledProgressIndicator=" + this.isEnabledProgressIndicator + ", nextAvailableFrom=" + this.nextAvailableFrom + ", failure=" + this.failure + ")";
        }

        public Content(String confirmCode, String phone, int i, int i2, boolean z, LocalDateTime nextAvailableFrom, String str) {
            Intrinsics.checkNotNullParameter(confirmCode, "confirmCode");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(nextAvailableFrom, "nextAvailableFrom");
            this.confirmCode = confirmCode;
            this.phone = phone;
            this.codeLength = i;
            this.attemptsLeft = i2;
            this.isEnabledProgressIndicator = z;
            this.nextAvailableFrom = nextAvailableFrom;
            this.failure = str;
        }

        public /* synthetic */ Content(String str, String str2, int i, int i2, boolean z, LocalDateTime localDateTime, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, i2, z, localDateTime, (i3 & 64) != 0 ? null : str3);
        }

        public final String getConfirmCode() {
            return this.confirmCode;
        }

        public final String getPhone() {
            return this.phone;
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

        public final String getFailure() {
            return this.failure;
        }
    }
}
