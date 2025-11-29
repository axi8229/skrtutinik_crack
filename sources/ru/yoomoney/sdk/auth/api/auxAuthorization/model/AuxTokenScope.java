package ru.yoomoney.sdk.auth.api.auxAuthorization.model;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "toString", "CardApi", "Companion", "MerchantDashboard", "Undefined", "UserAuthCenter", "Wallet", "WalletApi", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$MerchantDashboard;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Undefined;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$UserAuthCenter;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Wallet;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$WalletApi;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AuxTokenScope {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "access", "", "(Ljava/lang/String;)V", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "Info", "LoyaltyProgramInfo", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi$Info;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi$LoyaltyProgramInfo;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class CardApi extends AuxTokenScope {
        private final String access;
        private final String group;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi$Info;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Info extends CardApi {
            public static final Info INSTANCE = new Info();

            private Info() {
                super("info", null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi$LoyaltyProgramInfo;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$CardApi;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class LoyaltyProgramInfo extends CardApi {
            public static final LoyaltyProgramInfo INSTANCE = new LoyaltyProgramInfo();

            private LoyaltyProgramInfo() {
                super("loyalty_program_info", null);
            }
        }

        private CardApi(String str) {
            super(null);
            this.access = str;
            this.group = "card_api";
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getAccess() {
            return this.access;
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getGroup() {
            return this.group;
        }

        public /* synthetic */ CardApi(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\f\u0010\b\u001a\u00020\u0004*\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Companion;", "", "()V", RemoteMessageConst.FROM, "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "group", "", "access", "mapToAuxTokenScope", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AuxTokenScope mapToAuxTokenScope(String str) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1967291776) {
                if (iHashCode != -339185956) {
                    if (iHashCode != 4184044) {
                        if (iHashCode == 1091102592 && str.equals("account_info")) {
                            return UserAuthCenter.AccountInfo.INSTANCE;
                        }
                    } else if (str.equals("operations")) {
                        return WalletApi.Operations.INSTANCE;
                    }
                } else if (str.equals("balance")) {
                    return Wallet.Balance.INSTANCE;
                }
            } else if (str.equals("payments_info")) {
                return MerchantDashboard.PaymentsInfo.INSTANCE;
            }
            return Undefined.INSTANCE;
        }

        public final AuxTokenScope from(String group, String access) {
            Intrinsics.checkNotNullParameter(group, "group");
            Intrinsics.checkNotNullParameter(access, "access");
            int iHashCode = group.hashCode();
            return (iHashCode == -1826989868 ? group.equals("wallet_api") : iHashCode == -795192327 ? group.equals("wallet") : iHashCode == 141694173 ? group.equals("merchant_dashboard") : iHashCode == 1708699736 && group.equals("user_auth_center")) ? mapToAuxTokenScope(access) : Undefined.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$MerchantDashboard;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "access", "", "(Ljava/lang/String;)V", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "PaymentsInfo", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$MerchantDashboard$PaymentsInfo;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class MerchantDashboard extends AuxTokenScope {
        private final String access;
        private final String group;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$MerchantDashboard$PaymentsInfo;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$MerchantDashboard;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class PaymentsInfo extends MerchantDashboard {
            public static final PaymentsInfo INSTANCE = new PaymentsInfo();

            private PaymentsInfo() {
                super("payments_info", null);
            }
        }

        private MerchantDashboard(String str) {
            super(null);
            this.access = str;
            this.group = "merchant_dashboard";
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getAccess() {
            return this.access;
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getGroup() {
            return this.group;
        }

        public /* synthetic */ MerchantDashboard(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Undefined;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Undefined extends AuxTokenScope {
        public static final Undefined INSTANCE = new Undefined();
        private static final String group = "";
        private static final String access = "";

        private Undefined() {
            super(null);
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getAccess() {
            return access;
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getGroup() {
            return group;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$UserAuthCenter;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "access", "", "(Ljava/lang/String;)V", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "AccountInfo", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$UserAuthCenter$AccountInfo;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class UserAuthCenter extends AuxTokenScope {
        private final String access;
        private final String group;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$UserAuthCenter$AccountInfo;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$UserAuthCenter;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class AccountInfo extends UserAuthCenter {
            public static final AccountInfo INSTANCE = new AccountInfo();

            private AccountInfo() {
                super("account_info", null);
            }
        }

        private UserAuthCenter(String str) {
            super(null);
            this.access = str;
            this.group = "user_auth_center";
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getAccess() {
            return this.access;
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getGroup() {
            return this.group;
        }

        public /* synthetic */ UserAuthCenter(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Wallet;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "access", "", "(Ljava/lang/String;)V", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "Balance", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Wallet$Balance;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Wallet extends AuxTokenScope {
        private final String access;
        private final String group;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Wallet$Balance;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$Wallet;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Balance extends Wallet {
            public static final Balance INSTANCE = new Balance();

            private Balance() {
                super("balance", null);
            }
        }

        private Wallet(String str) {
            super(null);
            this.access = str;
            this.group = "wallet";
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getAccess() {
            return this.access;
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getGroup() {
            return this.group;
        }

        public /* synthetic */ Wallet(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$WalletApi;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "access", "", "(Ljava/lang/String;)V", "getAccess", "()Ljava/lang/String;", "group", "getGroup", "Operations", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$WalletApi$Operations;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class WalletApi extends AuxTokenScope {
        private final String access;
        private final String group;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$WalletApi$Operations;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope$WalletApi;", "()V", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Operations extends WalletApi {
            public static final Operations INSTANCE = new Operations();

            private Operations() {
                super("operations", null);
            }
        }

        private WalletApi(String str) {
            super(null);
            this.access = str;
            this.group = "wallet_api";
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getAccess() {
            return this.access;
        }

        @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope
        public String getGroup() {
            return this.group;
        }

        public /* synthetic */ WalletApi(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    private AuxTokenScope() {
    }

    public /* synthetic */ AuxTokenScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getAccess();

    public abstract String getGroup();

    public String toString() {
        return getGroup() + ":" + getAccess();
    }
}
