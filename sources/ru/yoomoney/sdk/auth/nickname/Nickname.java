package ru.yoomoney.sdk.auth.nickname;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.model.Failure;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname;", "", "()V", "Action", "AnalyticsLogger", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Nickname {
    public static final Nickname INSTANCE = new Nickname();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", "", "()V", "NicknameChanged", "SetNicknameFail", "SetNicknameSuccess", "Submit", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action$NicknameChanged;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action$SetNicknameFail;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action$SetNicknameSuccess;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action$Submit;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Action$NicknameChanged;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", "nickname", "", "(Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NicknameChanged extends Action {
            private final String nickname;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NicknameChanged(String nickname) {
                super(null);
                Intrinsics.checkNotNullParameter(nickname, "nickname");
                this.nickname = nickname;
            }

            public static /* synthetic */ NicknameChanged copy$default(NicknameChanged nicknameChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = nicknameChanged.nickname;
                }
                return nicknameChanged.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNickname() {
                return this.nickname;
            }

            public final NicknameChanged copy(String nickname) {
                Intrinsics.checkNotNullParameter(nickname, "nickname");
                return new NicknameChanged(nickname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NicknameChanged) && Intrinsics.areEqual(this.nickname, ((NicknameChanged) other).nickname);
            }

            public final String getNickname() {
                return this.nickname;
            }

            public int hashCode() {
                return this.nickname.hashCode();
            }

            public String toString() {
                return "NicknameChanged(nickname=" + this.nickname + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Action$SetNicknameFail;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetNicknameFail extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetNicknameFail(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ SetNicknameFail copy$default(SetNicknameFail setNicknameFail, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = setNicknameFail.failure;
                }
                return setNicknameFail.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final SetNicknameFail copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new SetNicknameFail(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetNicknameFail) && Intrinsics.areEqual(this.failure, ((SetNicknameFail) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "SetNicknameFail(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Action$SetNicknameSuccess;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", YooMoneyAuth.KEY_USER_ACCOUNT, "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;)V", "getUserAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetNicknameSuccess extends Action {
            private final UserAccount userAccount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetNicknameSuccess(UserAccount userAccount) {
                super(null);
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                this.userAccount = userAccount;
            }

            public static /* synthetic */ SetNicknameSuccess copy$default(SetNicknameSuccess setNicknameSuccess, UserAccount userAccount, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = setNicknameSuccess.userAccount;
                }
                return setNicknameSuccess.copy(userAccount);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public final SetNicknameSuccess copy(UserAccount userAccount) {
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                return new SetNicknameSuccess(userAccount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetNicknameSuccess) && Intrinsics.areEqual(this.userAccount, ((SetNicknameSuccess) other).userAccount);
            }

            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public int hashCode() {
                return this.userAccount.hashCode();
            }

            public String toString() {
                return "SetNicknameSuccess(userAccount=" + this.userAccount + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Action$Submit;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "(Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Submit extends Action {
            private final String accessToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Submit(String accessToken) {
                super(null);
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                this.accessToken = accessToken;
            }

            public static /* synthetic */ Submit copy$default(Submit submit, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = submit.accessToken;
                }
                return submit.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAccessToken() {
                return this.accessToken;
            }

            public final Submit copy(String accessToken) {
                Intrinsics.checkNotNullParameter(accessToken, "accessToken");
                return new Submit(accessToken);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Submit) && Intrinsics.areEqual(this.accessToken, ((Submit) other).accessToken);
            }

            public final String getAccessToken() {
                return this.accessToken;
            }

            public int hashCode() {
                return this.accessToken.hashCode();
            }

            public String toString() {
                return "Submit(accessToken=" + this.accessToken + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$AnalyticsLogger;", "", "invoke", "", "state", "Lru/yoomoney/sdk/auth/nickname/Nickname$State;", "action", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AnalyticsLogger {
        void invoke(State state, Action action);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Effect;", "", "()V", "Finish", "ShowError", "Lru/yoomoney/sdk/auth/nickname/Nickname$Effect$Finish;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Effect$ShowError;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Effect$Finish;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Effect;", YooMoneyAuth.KEY_USER_ACCOUNT, "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;)V", "getUserAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Finish extends Effect {
            private final UserAccount userAccount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Finish(UserAccount userAccount) {
                super(null);
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                this.userAccount = userAccount;
            }

            public static /* synthetic */ Finish copy$default(Finish finish, UserAccount userAccount, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = finish.userAccount;
                }
                return finish.copy(userAccount);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public final Finish copy(UserAccount userAccount) {
                Intrinsics.checkNotNullParameter(userAccount, "userAccount");
                return new Finish(userAccount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Finish) && Intrinsics.areEqual(this.userAccount, ((Finish) other).userAccount);
            }

            public final UserAccount getUserAccount() {
                return this.userAccount;
            }

            public int hashCode() {
                return this.userAccount.hashCode();
            }

            public String toString() {
                return "Finish(userAccount=" + this.userAccount + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$Effect$ShowError;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowError extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowError(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ ShowError copy$default(ShowError showError, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = showError.failure;
                }
                return showError.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final ShowError copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new ShowError(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowError) && Intrinsics.areEqual(this.failure, ((ShowError) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "ShowError(failure=" + this.failure + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$State;", "", "()V", "Content", "Progress", "Lru/yoomoney/sdk/auth/nickname/Nickname$State$Content;", "Lru/yoomoney/sdk/auth/nickname/Nickname$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$State$Content;", "Lru/yoomoney/sdk/auth/nickname/Nickname$State;", "newNickname", "", "(Ljava/lang/String;)V", "getNewNickname", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final String newNickname;

            public Content() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Content copy$default(Content content, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.newNickname;
                }
                return content.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewNickname() {
                return this.newNickname;
            }

            public final Content copy(String newNickname) {
                Intrinsics.checkNotNullParameter(newNickname, "newNickname");
                return new Content(newNickname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && Intrinsics.areEqual(this.newNickname, ((Content) other).newNickname);
            }

            public final String getNewNickname() {
                return this.newNickname;
            }

            public int hashCode() {
                return this.newNickname.hashCode();
            }

            public String toString() {
                return "Content(newNickname=" + this.newNickname + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(String newNickname) {
                super(null);
                Intrinsics.checkNotNullParameter(newNickname, "newNickname");
                this.newNickname = newNickname;
            }

            public /* synthetic */ Content(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/Nickname$State$Progress;", "Lru/yoomoney/sdk/auth/nickname/Nickname$State;", "newNickname", "", "(Ljava/lang/String;)V", "getNewNickname", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Progress extends State {
            private final String newNickname;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Progress(String newNickname) {
                super(null);
                Intrinsics.checkNotNullParameter(newNickname, "newNickname");
                this.newNickname = newNickname;
            }

            public static /* synthetic */ Progress copy$default(Progress progress, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = progress.newNickname;
                }
                return progress.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewNickname() {
                return this.newNickname;
            }

            public final Progress copy(String newNickname) {
                Intrinsics.checkNotNullParameter(newNickname, "newNickname");
                return new Progress(newNickname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Progress) && Intrinsics.areEqual(this.newNickname, ((Progress) other).newNickname);
            }

            public final String getNewNickname() {
                return this.newNickname;
            }

            public int hashCode() {
                return this.newNickname.hashCode();
            }

            public String toString() {
                return "Progress(newNickname=" + this.newNickname + ")";
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Nickname() {
    }
}
