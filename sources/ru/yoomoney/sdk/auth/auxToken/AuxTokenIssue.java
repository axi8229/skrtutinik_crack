package ru.yoomoney.sdk.auth.auxToken;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxToken;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.api.model.Failure;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxTokenIssue {
    public static final AuxTokenIssue INSTANCE = new AuxTokenIssue();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "", "()V", "AuxTokenIssueFailed", "AuxTokenIssued", "IssueAuxToken", "LoadAuxAuthorizationInfo", "LoadAuxAuthorizationInfoFailed", "LoadAuxAuthorizationInfoSuccess", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$AuxTokenIssueFailed;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$AuxTokenIssued;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$IssueAuxToken;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$LoadAuxAuthorizationInfo;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$LoadAuxAuthorizationInfoFailed;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$LoadAuxAuthorizationInfoSuccess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$AuxTokenIssueFailed;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AuxTokenIssueFailed extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuxTokenIssueFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ AuxTokenIssueFailed copy$default(AuxTokenIssueFailed auxTokenIssueFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = auxTokenIssueFailed.failure;
                }
                return auxTokenIssueFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final AuxTokenIssueFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new AuxTokenIssueFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AuxTokenIssueFailed) && Intrinsics.areEqual(this.failure, ((AuxTokenIssueFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "AuxTokenIssueFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$AuxTokenIssued;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", YooMoneyAuth.KEY_AUX_TOKEN, "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;", "(Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;)V", "getAuxToken", "()Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AuxTokenIssued extends Action {
            private final AuxToken auxToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuxTokenIssued(AuxToken auxToken) {
                super(null);
                Intrinsics.checkNotNullParameter(auxToken, "auxToken");
                this.auxToken = auxToken;
            }

            public static /* synthetic */ AuxTokenIssued copy$default(AuxTokenIssued auxTokenIssued, AuxToken auxToken, int i, Object obj) {
                if ((i & 1) != 0) {
                    auxToken = auxTokenIssued.auxToken;
                }
                return auxTokenIssued.copy(auxToken);
            }

            /* renamed from: component1, reason: from getter */
            public final AuxToken getAuxToken() {
                return this.auxToken;
            }

            public final AuxTokenIssued copy(AuxToken auxToken) {
                Intrinsics.checkNotNullParameter(auxToken, "auxToken");
                return new AuxTokenIssued(auxToken);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AuxTokenIssued) && Intrinsics.areEqual(this.auxToken, ((AuxTokenIssued) other).auxToken);
            }

            public final AuxToken getAuxToken() {
                return this.auxToken;
            }

            public int hashCode() {
                return this.auxToken.hashCode();
            }

            public String toString() {
                return "AuxTokenIssued(auxToken=" + this.auxToken + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$IssueAuxToken;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "token", "", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "authCenterClientId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAuthCenterClientId", "()Ljava/lang/String;", "getScopes", "()Ljava/util/List;", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class IssueAuxToken extends Action {
            private final String authCenterClientId;
            private final List<AuxTokenScope> scopes;
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public IssueAuxToken(String token, List<? extends AuxTokenScope> scopes, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                this.token = token;
                this.scopes = scopes;
                this.authCenterClientId = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ IssueAuxToken copy$default(IssueAuxToken issueAuxToken, String str, List list, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = issueAuxToken.token;
                }
                if ((i & 2) != 0) {
                    list = issueAuxToken.scopes;
                }
                if ((i & 4) != 0) {
                    str2 = issueAuxToken.authCenterClientId;
                }
                return issueAuxToken.copy(str, list, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final List<AuxTokenScope> component2() {
                return this.scopes;
            }

            /* renamed from: component3, reason: from getter */
            public final String getAuthCenterClientId() {
                return this.authCenterClientId;
            }

            public final IssueAuxToken copy(String token, List<? extends AuxTokenScope> scopes, String authCenterClientId) {
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                return new IssueAuxToken(token, scopes, authCenterClientId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IssueAuxToken)) {
                    return false;
                }
                IssueAuxToken issueAuxToken = (IssueAuxToken) other;
                return Intrinsics.areEqual(this.token, issueAuxToken.token) && Intrinsics.areEqual(this.scopes, issueAuxToken.scopes) && Intrinsics.areEqual(this.authCenterClientId, issueAuxToken.authCenterClientId);
            }

            public final String getAuthCenterClientId() {
                return this.authCenterClientId;
            }

            public final List<AuxTokenScope> getScopes() {
                return this.scopes;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                int iHashCode = (this.scopes.hashCode() + (this.token.hashCode() * 31)) * 31;
                String str = this.authCenterClientId;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "IssueAuxToken(token=" + this.token + ", scopes=" + this.scopes + ", authCenterClientId=" + this.authCenterClientId + ")";
            }

            public /* synthetic */ IssueAuxToken(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, list, (i & 4) != 0 ? null : str2);
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$LoadAuxAuthorizationInfo;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "token", "", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "authCenterClientId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAuthCenterClientId", "()Ljava/lang/String;", "getScopes", "()Ljava/util/List;", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadAuxAuthorizationInfo extends Action {
            private final String authCenterClientId;
            private final List<AuxTokenScope> scopes;
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public LoadAuxAuthorizationInfo(String token, List<? extends AuxTokenScope> scopes, String authCenterClientId) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
                this.token = token;
                this.scopes = scopes;
                this.authCenterClientId = authCenterClientId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LoadAuxAuthorizationInfo copy$default(LoadAuxAuthorizationInfo loadAuxAuthorizationInfo, String str, List list, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loadAuxAuthorizationInfo.token;
                }
                if ((i & 2) != 0) {
                    list = loadAuxAuthorizationInfo.scopes;
                }
                if ((i & 4) != 0) {
                    str2 = loadAuxAuthorizationInfo.authCenterClientId;
                }
                return loadAuxAuthorizationInfo.copy(str, list, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final List<AuxTokenScope> component2() {
                return this.scopes;
            }

            /* renamed from: component3, reason: from getter */
            public final String getAuthCenterClientId() {
                return this.authCenterClientId;
            }

            public final LoadAuxAuthorizationInfo copy(String token, List<? extends AuxTokenScope> scopes, String authCenterClientId) {
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
                return new LoadAuxAuthorizationInfo(token, scopes, authCenterClientId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadAuxAuthorizationInfo)) {
                    return false;
                }
                LoadAuxAuthorizationInfo loadAuxAuthorizationInfo = (LoadAuxAuthorizationInfo) other;
                return Intrinsics.areEqual(this.token, loadAuxAuthorizationInfo.token) && Intrinsics.areEqual(this.scopes, loadAuxAuthorizationInfo.scopes) && Intrinsics.areEqual(this.authCenterClientId, loadAuxAuthorizationInfo.authCenterClientId);
            }

            public final String getAuthCenterClientId() {
                return this.authCenterClientId;
            }

            public final List<AuxTokenScope> getScopes() {
                return this.scopes;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                return this.authCenterClientId.hashCode() + ((this.scopes.hashCode() + (this.token.hashCode() * 31)) * 31);
            }

            public String toString() {
                return "LoadAuxAuthorizationInfo(token=" + this.token + ", scopes=" + this.scopes + ", authCenterClientId=" + this.authCenterClientId + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$LoadAuxAuthorizationInfoFailed;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadAuxAuthorizationInfoFailed extends Action {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadAuxAuthorizationInfoFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ LoadAuxAuthorizationInfoFailed copy$default(LoadAuxAuthorizationInfoFailed loadAuxAuthorizationInfoFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = loadAuxAuthorizationInfoFailed.failure;
                }
                return loadAuxAuthorizationInfoFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final LoadAuxAuthorizationInfoFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new LoadAuxAuthorizationInfoFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadAuxAuthorizationInfoFailed) && Intrinsics.areEqual(this.failure, ((LoadAuxAuthorizationInfoFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "LoadAuxAuthorizationInfoFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action$LoadAuxAuthorizationInfoSuccess;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LoadAuxAuthorizationInfoSuccess extends Action {
            private final UserAccount account;
            private final ApplicationInfo applicationInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadAuxAuthorizationInfoSuccess(UserAccount account, ApplicationInfo applicationInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                this.account = account;
                this.applicationInfo = applicationInfo;
            }

            public static /* synthetic */ LoadAuxAuthorizationInfoSuccess copy$default(LoadAuxAuthorizationInfoSuccess loadAuxAuthorizationInfoSuccess, UserAccount userAccount, ApplicationInfo applicationInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = loadAuxAuthorizationInfoSuccess.account;
                }
                if ((i & 2) != 0) {
                    applicationInfo = loadAuxAuthorizationInfoSuccess.applicationInfo;
                }
                return loadAuxAuthorizationInfoSuccess.copy(userAccount, applicationInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public final LoadAuxAuthorizationInfoSuccess copy(UserAccount account, ApplicationInfo applicationInfo) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                return new LoadAuxAuthorizationInfoSuccess(account, applicationInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadAuxAuthorizationInfoSuccess)) {
                    return false;
                }
                LoadAuxAuthorizationInfoSuccess loadAuxAuthorizationInfoSuccess = (LoadAuxAuthorizationInfoSuccess) other;
                return Intrinsics.areEqual(this.account, loadAuxAuthorizationInfoSuccess.account) && Intrinsics.areEqual(this.applicationInfo, loadAuxAuthorizationInfoSuccess.applicationInfo);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public int hashCode() {
                return this.applicationInfo.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                return "LoadAuxAuthorizationInfoSuccess(account=" + this.account + ", applicationInfo=" + this.applicationInfo + ")";
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect;", "", "()V", "AuxTokenIssueFailed", "AuxTokenIssued", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect$AuxTokenIssueFailed;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect$AuxTokenIssued;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect$AuxTokenIssueFailed;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AuxTokenIssueFailed extends Effect {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuxTokenIssueFailed(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ AuxTokenIssueFailed copy$default(AuxTokenIssueFailed auxTokenIssueFailed, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = auxTokenIssueFailed.failure;
                }
                return auxTokenIssueFailed.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final AuxTokenIssueFailed copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new AuxTokenIssueFailed(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AuxTokenIssueFailed) && Intrinsics.areEqual(this.failure, ((AuxTokenIssueFailed) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "AuxTokenIssueFailed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect$AuxTokenIssued;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect;", YooMoneyAuth.KEY_AUX_TOKEN, "", "(Ljava/lang/String;)V", "getAuxToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AuxTokenIssued extends Effect {
            private final String auxToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuxTokenIssued(String auxToken) {
                super(null);
                Intrinsics.checkNotNullParameter(auxToken, "auxToken");
                this.auxToken = auxToken;
            }

            public static /* synthetic */ AuxTokenIssued copy$default(AuxTokenIssued auxTokenIssued, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = auxTokenIssued.auxToken;
                }
                return auxTokenIssued.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getAuxToken() {
                return this.auxToken;
            }

            public final AuxTokenIssued copy(String auxToken) {
                Intrinsics.checkNotNullParameter(auxToken, "auxToken");
                return new AuxTokenIssued(auxToken);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AuxTokenIssued) && Intrinsics.areEqual(this.auxToken, ((AuxTokenIssued) other).auxToken);
            }

            public final String getAuxToken() {
                return this.auxToken;
            }

            public int hashCode() {
                return this.auxToken.hashCode();
            }

            public String toString() {
                return "AuxTokenIssued(auxToken=" + this.auxToken + ")";
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", "", "()V", "AuxAuthorizationInfo", "AuxAuthorizationInfoError", "IssuingToken", "LoadingAuxAuthorizationInfo", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfo;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfoError;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$IssuingToken;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$LoadingAuxAuthorizationInfo;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfo;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AuxAuthorizationInfo extends State {
            private final UserAccount account;
            private final ApplicationInfo applicationInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuxAuthorizationInfo(UserAccount account, ApplicationInfo applicationInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                this.account = account;
                this.applicationInfo = applicationInfo;
            }

            public static /* synthetic */ AuxAuthorizationInfo copy$default(AuxAuthorizationInfo auxAuthorizationInfo, UserAccount userAccount, ApplicationInfo applicationInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = auxAuthorizationInfo.account;
                }
                if ((i & 2) != 0) {
                    applicationInfo = auxAuthorizationInfo.applicationInfo;
                }
                return auxAuthorizationInfo.copy(userAccount, applicationInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public final AuxAuthorizationInfo copy(UserAccount account, ApplicationInfo applicationInfo) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                return new AuxAuthorizationInfo(account, applicationInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AuxAuthorizationInfo)) {
                    return false;
                }
                AuxAuthorizationInfo auxAuthorizationInfo = (AuxAuthorizationInfo) other;
                return Intrinsics.areEqual(this.account, auxAuthorizationInfo.account) && Intrinsics.areEqual(this.applicationInfo, auxAuthorizationInfo.applicationInfo);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public int hashCode() {
                return this.applicationInfo.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                return "AuxAuthorizationInfo(account=" + this.account + ", applicationInfo=" + this.applicationInfo + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$AuxAuthorizationInfoError;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "(Lru/yoomoney/sdk/auth/api/model/Failure;)V", "getFailure", "()Lru/yoomoney/sdk/auth/api/model/Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AuxAuthorizationInfoError extends State {
            private final Failure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AuxAuthorizationInfoError(Failure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ AuxAuthorizationInfoError copy$default(AuxAuthorizationInfoError auxAuthorizationInfoError, Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = auxAuthorizationInfoError.failure;
                }
                return auxAuthorizationInfoError.copy(failure);
            }

            /* renamed from: component1, reason: from getter */
            public final Failure getFailure() {
                return this.failure;
            }

            public final AuxAuthorizationInfoError copy(Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new AuxAuthorizationInfoError(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AuxAuthorizationInfoError) && Intrinsics.areEqual(this.failure, ((AuxAuthorizationInfoError) other).failure);
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "AuxAuthorizationInfoError(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$IssuingToken;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "(Lru/yoomoney/sdk/auth/api/account/model/UserAccount;Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;)V", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class IssuingToken extends State {
            private final UserAccount account;
            private final ApplicationInfo applicationInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public IssuingToken(UserAccount account, ApplicationInfo applicationInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                this.account = account;
                this.applicationInfo = applicationInfo;
            }

            public static /* synthetic */ IssuingToken copy$default(IssuingToken issuingToken, UserAccount userAccount, ApplicationInfo applicationInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    userAccount = issuingToken.account;
                }
                if ((i & 2) != 0) {
                    applicationInfo = issuingToken.applicationInfo;
                }
                return issuingToken.copy(userAccount, applicationInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final UserAccount getAccount() {
                return this.account;
            }

            /* renamed from: component2, reason: from getter */
            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public final IssuingToken copy(UserAccount account, ApplicationInfo applicationInfo) {
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
                return new IssuingToken(account, applicationInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IssuingToken)) {
                    return false;
                }
                IssuingToken issuingToken = (IssuingToken) other;
                return Intrinsics.areEqual(this.account, issuingToken.account) && Intrinsics.areEqual(this.applicationInfo, issuingToken.applicationInfo);
            }

            public final UserAccount getAccount() {
                return this.account;
            }

            public final ApplicationInfo getApplicationInfo() {
                return this.applicationInfo;
            }

            public int hashCode() {
                return this.applicationInfo.hashCode() + (this.account.hashCode() * 31);
            }

            public String toString() {
                String simpleName = IssuingToken.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State$LoadingAuxAuthorizationInfo;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class LoadingAuxAuthorizationInfo extends State {
            public static final LoadingAuxAuthorizationInfo INSTANCE = new LoadingAuxAuthorizationInfo();

            private LoadingAuxAuthorizationInfo() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AuxTokenIssue() {
    }
}
