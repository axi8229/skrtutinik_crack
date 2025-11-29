package ru.yoomoney.sdk.auth.email.select;

import com.google.android.gms.common.Scopes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.Suggestion;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailSelect {
    public static final EmailSelect INSTANCE = new EmailSelect();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "", "()V", "CheckExpiration", "CloseSelectorDialog", "Expired", "InitData", "OpenEmailSelectorDialog", "RestartProcess", "SelectEmail", "SendEmail", "SendEmailFailure", "SendEmailSuccess", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$CloseSelectorDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$Expired;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$InitData;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$OpenEmailSelectorDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SelectEmail;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SendEmail;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SendEmailFailure;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SendEmailSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$CheckExpiration;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;)V", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "getProcessId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CheckExpiration extends Action {
            private final OffsetDateTime expireAt;
            private final String processId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CheckExpiration(String processId, OffsetDateTime expireAt) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                this.processId = processId;
                this.expireAt = expireAt;
            }

            public static /* synthetic */ CheckExpiration copy$default(CheckExpiration checkExpiration, String str, OffsetDateTime offsetDateTime, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = checkExpiration.processId;
                }
                if ((i & 2) != 0) {
                    offsetDateTime = checkExpiration.expireAt;
                }
                return checkExpiration.copy(str, offsetDateTime);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            /* renamed from: component2, reason: from getter */
            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final CheckExpiration copy(String processId, OffsetDateTime expireAt) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                Intrinsics.checkNotNullParameter(expireAt, "expireAt");
                return new CheckExpiration(processId, expireAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CheckExpiration)) {
                    return false;
                }
                CheckExpiration checkExpiration = (CheckExpiration) other;
                return Intrinsics.areEqual(this.processId, checkExpiration.processId) && Intrinsics.areEqual(this.expireAt, checkExpiration.expireAt);
            }

            public final OffsetDateTime getExpireAt() {
                return this.expireAt;
            }

            public final String getProcessId() {
                return this.processId;
            }

            public int hashCode() {
                return this.expireAt.hashCode() + (this.processId.hashCode() * 31);
            }

            public String toString() {
                return "CheckExpiration(processId=" + this.processId + ", expireAt=" + this.expireAt + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$CloseSelectorDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class CloseSelectorDialog extends Action {
            public static final CloseSelectorDialog INSTANCE = new CloseSelectorDialog();

            private CloseSelectorDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = CloseSelectorDialog.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$Expired;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Expired extends Action {
            public static final Expired INSTANCE = new Expired();

            private Expired() {
                super(null);
            }

            public String toString() {
                String simpleName = Expired.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$InitData;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "suggestions", "", "Lru/yoomoney/sdk/auth/api/model/Suggestion;", "(Ljava/util/List;)V", "getSuggestions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class InitData extends Action {
            private final List<Suggestion> suggestions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitData(List<Suggestion> suggestions) {
                super(null);
                Intrinsics.checkNotNullParameter(suggestions, "suggestions");
                this.suggestions = suggestions;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ InitData copy$default(InitData initData, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = initData.suggestions;
                }
                return initData.copy(list);
            }

            public final List<Suggestion> component1() {
                return this.suggestions;
            }

            public final InitData copy(List<Suggestion> suggestions) {
                Intrinsics.checkNotNullParameter(suggestions, "suggestions");
                return new InitData(suggestions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InitData) && Intrinsics.areEqual(this.suggestions, ((InitData) other).suggestions);
            }

            public final List<Suggestion> getSuggestions() {
                return this.suggestions;
            }

            public int hashCode() {
                return this.suggestions.hashCode();
            }

            public String toString() {
                return "InitData(suggestions=" + this.suggestions + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$OpenEmailSelectorDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenEmailSelectorDialog extends Action {
            public static final OpenEmailSelectorDialog INSTANCE = new OpenEmailSelectorDialog();

            private OpenEmailSelectorDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = OpenEmailSelectorDialog.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$RestartProcess;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RestartProcess extends Action {
            public static final RestartProcess INSTANCE = new RestartProcess();

            private RestartProcess() {
                super(null);
            }

            public String toString() {
                String simpleName = RestartProcess.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SelectEmail;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", Scopes.EMAIL, "Lru/yoomoney/sdk/auth/api/model/Suggestion;", "(Lru/yoomoney/sdk/auth/api/model/Suggestion;)V", "getEmail", "()Lru/yoomoney/sdk/auth/api/model/Suggestion;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SelectEmail extends Action {
            private final Suggestion email;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectEmail(Suggestion email) {
                super(null);
                Intrinsics.checkNotNullParameter(email, "email");
                this.email = email;
            }

            public static /* synthetic */ SelectEmail copy$default(SelectEmail selectEmail, Suggestion suggestion, int i, Object obj) {
                if ((i & 1) != 0) {
                    suggestion = selectEmail.email;
                }
                return selectEmail.copy(suggestion);
            }

            /* renamed from: component1, reason: from getter */
            public final Suggestion getEmail() {
                return this.email;
            }

            public final SelectEmail copy(Suggestion email) {
                Intrinsics.checkNotNullParameter(email, "email");
                return new SelectEmail(email);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectEmail) && Intrinsics.areEqual(this.email, ((SelectEmail) other).email);
            }

            public final Suggestion getEmail() {
                return this.email;
            }

            public int hashCode() {
                return this.email.hashCode();
            }

            public String toString() {
                return "SelectEmail(email=" + this.email + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SendEmail;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;)V", "getProcessId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendEmail extends Action {
            private final String processId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendEmail(String processId) {
                super(null);
                Intrinsics.checkNotNullParameter(processId, "processId");
                this.processId = processId;
            }

            public static /* synthetic */ SendEmail copy$default(SendEmail sendEmail, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sendEmail.processId;
                }
                return sendEmail.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getProcessId() {
                return this.processId;
            }

            public final SendEmail copy(String processId) {
                Intrinsics.checkNotNullParameter(processId, "processId");
                return new SendEmail(processId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendEmail) && Intrinsics.areEqual(this.processId, ((SendEmail) other).processId);
            }

            public final String getProcessId() {
                return this.processId;
            }

            public int hashCode() {
                return this.processId.hashCode();
            }

            public String toString() {
                return "SendEmail(processId=" + this.processId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SendEmailFailure;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendEmailFailure extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendEmailFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ SendEmailFailure copy$default(SendEmailFailure sendEmailFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = sendEmailFailure.failure;
                }
                return sendEmailFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final SendEmailFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new SendEmailFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendEmailFailure) && Intrinsics.areEqual(this.failure, ((SendEmailFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "SendEmailFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action$SendEmailSuccess;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SendEmailSuccess extends Action {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendEmailSuccess(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ SendEmailSuccess copy$default(SendEmailSuccess sendEmailSuccess, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = sendEmailSuccess.process;
                }
                return sendEmailSuccess.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final SendEmailSuccess copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new SendEmailSuccess(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendEmailSuccess) && Intrinsics.areEqual(this.process, ((SendEmailSuccess) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "SendEmailSuccess(process=" + this.process + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "action", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", "", "()V", "ResetProcess", "ShowExpireDialog", "ShowFailure", "ShowNextStep", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ShowNextStep;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ResetProcess;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ResetProcess extends Effect {
            public static final ResetProcess INSTANCE = new ResetProcess();

            private ResetProcess() {
                super(null);
            }

            public String toString() {
                String simpleName = ResetProcess.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ShowExpireDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowExpireDialog extends Effect {
            public static final ShowExpireDialog INSTANCE = new ShowExpireDialog();

            private ShowExpireDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowExpireDialog.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ShowFailure;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowFailure extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFailure(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowFailure copy$default(ShowFailure showFailure, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showFailure.failure;
                }
                return showFailure.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowFailure copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowFailure) && Intrinsics.areEqual(this.failure, ((ShowFailure) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowFailure(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect$ShowNextStep;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Effect;", "process", "Lru/yoomoney/sdk/auth/api/Process;", "(Lru/yoomoney/sdk/auth/api/Process;)V", "getProcess", "()Lru/yoomoney/sdk/auth/api/Process;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowNextStep extends Effect {
            private final Process process;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowNextStep(Process process) {
                super(null);
                Intrinsics.checkNotNullParameter(process, "process");
                this.process = process;
            }

            public static /* synthetic */ ShowNextStep copy$default(ShowNextStep showNextStep, Process process, int i, Object obj) {
                if ((i & 1) != 0) {
                    process = showNextStep.process;
                }
                return showNextStep.copy(process);
            }

            /* renamed from: component1, reason: from getter */
            public final Process getProcess() {
                return this.process;
            }

            public final ShowNextStep copy(Process process) {
                Intrinsics.checkNotNullParameter(process, "process");
                return new ShowNextStep(process);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowNextStep) && Intrinsics.areEqual(this.process, ((ShowNextStep) other).process);
            }

            public final Process getProcess() {
                return this.process;
            }

            public int hashCode() {
                return this.process.hashCode();
            }

            public String toString() {
                return "ShowNextStep(process=" + this.process + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "", "()V", "Content", "Initial", "Progress", "SelectionDialog", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Initial;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Progress;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$SelectionDialog;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "suggestions", "", "Lru/yoomoney/sdk/auth/api/model/Suggestion;", "selectedSuggestion", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Ljava/util/List;Lru/yoomoney/sdk/auth/api/model/Suggestion;Lru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "getSelectedSuggestion", "()Lru/yoomoney/sdk/auth/api/model/Suggestion;", "getSuggestions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final ProcessError error;
            private final Suggestion selectedSuggestion;
            private final List<Suggestion> suggestions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(List<Suggestion> suggestions, Suggestion selectedSuggestion, ProcessError processError) {
                super(null);
                Intrinsics.checkNotNullParameter(suggestions, "suggestions");
                Intrinsics.checkNotNullParameter(selectedSuggestion, "selectedSuggestion");
                this.suggestions = suggestions;
                this.selectedSuggestion = selectedSuggestion;
                this.error = processError;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Content copy$default(Content content, List list, Suggestion suggestion, ProcessError processError, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = content.suggestions;
                }
                if ((i & 2) != 0) {
                    suggestion = content.selectedSuggestion;
                }
                if ((i & 4) != 0) {
                    processError = content.error;
                }
                return content.copy(list, suggestion, processError);
            }

            public final List<Suggestion> component1() {
                return this.suggestions;
            }

            /* renamed from: component2, reason: from getter */
            public final Suggestion getSelectedSuggestion() {
                return this.selectedSuggestion;
            }

            /* renamed from: component3, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            public final Content copy(List<Suggestion> suggestions, Suggestion selectedSuggestion, ProcessError error) {
                Intrinsics.checkNotNullParameter(suggestions, "suggestions");
                Intrinsics.checkNotNullParameter(selectedSuggestion, "selectedSuggestion");
                return new Content(suggestions, selectedSuggestion, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.suggestions, content.suggestions) && Intrinsics.areEqual(this.selectedSuggestion, content.selectedSuggestion) && Intrinsics.areEqual(this.error, content.error);
            }

            public final ProcessError getError() {
                return this.error;
            }

            public final Suggestion getSelectedSuggestion() {
                return this.selectedSuggestion;
            }

            public final List<Suggestion> getSuggestions() {
                return this.suggestions;
            }

            public int hashCode() {
                int iHashCode = (this.selectedSuggestion.hashCode() + (this.suggestions.hashCode() * 31)) * 31;
                ProcessError processError = this.error;
                return iHashCode + (processError == null ? 0 : processError.hashCode());
            }

            public String toString() {
                return "Content(suggestions=" + this.suggestions + ", selectedSuggestion=" + this.selectedSuggestion + ", error=" + this.error + ")";
            }

            public /* synthetic */ Content(List list, Suggestion suggestion, ProcessError processError, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, suggestion, (i & 4) != 0 ? null : processError);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Initial;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Initial extends State {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }

            public String toString() {
                String simpleName = Initial.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Progress;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "content", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;", "(Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;)V", "getContent", "()Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$Content;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress extends State {
            private final Content content;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(Content content) {
                super(null);
                Intrinsics.checkNotNullParameter(content, "content");
                this.content = content;
            }

            public static /* synthetic */ Progress copy$default(Progress progress, Content content, int i, Object obj) {
                if ((i & 1) != 0) {
                    content = progress.content;
                }
                return progress.copy(content);
            }

            /* renamed from: component1, reason: from getter */
            public final Content getContent() {
                return this.content;
            }

            public final Progress copy(Content content) {
                Intrinsics.checkNotNullParameter(content, "content");
                return new Progress(content);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Progress) && Intrinsics.areEqual(this.content, ((Progress) other).content);
            }

            public final Content getContent() {
                return this.content;
            }

            public int hashCode() {
                return this.content.hashCode();
            }

            public String toString() {
                return "Progress(content=" + this.content + ")";
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/EmailSelect$State$SelectionDialog;", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$State;", "suggestions", "", "Lru/yoomoney/sdk/auth/api/model/Suggestion;", "selectedSuggestion", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "(Ljava/util/List;Lru/yoomoney/sdk/auth/api/model/Suggestion;Lru/yoomoney/sdk/auth/api/model/ProcessError;)V", "getError", "()Lru/yoomoney/sdk/auth/api/model/ProcessError;", "getSelectedSuggestion", "()Lru/yoomoney/sdk/auth/api/model/Suggestion;", "getSuggestions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SelectionDialog extends State {
            private final ProcessError error;
            private final Suggestion selectedSuggestion;
            private final List<Suggestion> suggestions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectionDialog(List<Suggestion> suggestions, Suggestion selectedSuggestion, ProcessError processError) {
                super(null);
                Intrinsics.checkNotNullParameter(suggestions, "suggestions");
                Intrinsics.checkNotNullParameter(selectedSuggestion, "selectedSuggestion");
                this.suggestions = suggestions;
                this.selectedSuggestion = selectedSuggestion;
                this.error = processError;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectionDialog copy$default(SelectionDialog selectionDialog, List list, Suggestion suggestion, ProcessError processError, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = selectionDialog.suggestions;
                }
                if ((i & 2) != 0) {
                    suggestion = selectionDialog.selectedSuggestion;
                }
                if ((i & 4) != 0) {
                    processError = selectionDialog.error;
                }
                return selectionDialog.copy(list, suggestion, processError);
            }

            public final List<Suggestion> component1() {
                return this.suggestions;
            }

            /* renamed from: component2, reason: from getter */
            public final Suggestion getSelectedSuggestion() {
                return this.selectedSuggestion;
            }

            /* renamed from: component3, reason: from getter */
            public final ProcessError getError() {
                return this.error;
            }

            public final SelectionDialog copy(List<Suggestion> suggestions, Suggestion selectedSuggestion, ProcessError error) {
                Intrinsics.checkNotNullParameter(suggestions, "suggestions");
                Intrinsics.checkNotNullParameter(selectedSuggestion, "selectedSuggestion");
                return new SelectionDialog(suggestions, selectedSuggestion, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectionDialog)) {
                    return false;
                }
                SelectionDialog selectionDialog = (SelectionDialog) other;
                return Intrinsics.areEqual(this.suggestions, selectionDialog.suggestions) && Intrinsics.areEqual(this.selectedSuggestion, selectionDialog.selectedSuggestion) && Intrinsics.areEqual(this.error, selectionDialog.error);
            }

            public final ProcessError getError() {
                return this.error;
            }

            public final Suggestion getSelectedSuggestion() {
                return this.selectedSuggestion;
            }

            public final List<Suggestion> getSuggestions() {
                return this.suggestions;
            }

            public int hashCode() {
                int iHashCode = (this.selectedSuggestion.hashCode() + (this.suggestions.hashCode() * 31)) * 31;
                ProcessError processError = this.error;
                return iHashCode + (processError == null ? 0 : processError.hashCode());
            }

            public String toString() {
                return "SelectionDialog(suggestions=" + this.suggestions + ", selectedSuggestion=" + this.selectedSuggestion + ", error=" + this.error + ")";
            }

            public /* synthetic */ SelectionDialog(List list, Suggestion suggestion, ProcessError processError, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, suggestion, (i & 4) != 0 ? null : processError);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private EmailSelect() {
    }
}
