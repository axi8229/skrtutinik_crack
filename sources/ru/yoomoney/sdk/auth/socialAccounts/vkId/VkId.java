package ru.yoomoney.sdk.auth.socialAccounts.vkId;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.domain.VkIdSdkParameters;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VkId {
    public static final VkId INSTANCE = new VkId();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "", "()V", "Cancel", "DataReceived", "Init", "Open", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$Cancel;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$DataReceived;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$Init;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$Open;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$Cancel;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Cancel extends Action {
            public static final Cancel INSTANCE = new Cancel();

            private Cancel() {
                super(null);
            }

            public String toString() {
                String simpleName = Cancel.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$DataReceived;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "token", "", "uuid", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getUuid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DataReceived extends Action {
            private final String token;
            private final String uuid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DataReceived(String token, String uuid) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                this.token = token;
                this.uuid = uuid;
            }

            public static /* synthetic */ DataReceived copy$default(DataReceived dataReceived, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = dataReceived.token;
                }
                if ((i & 2) != 0) {
                    str2 = dataReceived.uuid;
                }
                return dataReceived.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            public final DataReceived copy(String token, String uuid) {
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                return new DataReceived(token, uuid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DataReceived)) {
                    return false;
                }
                DataReceived dataReceived = (DataReceived) other;
                return Intrinsics.areEqual(this.token, dataReceived.token) && Intrinsics.areEqual(this.uuid, dataReceived.uuid);
            }

            public final String getToken() {
                return this.token;
            }

            public final String getUuid() {
                return this.uuid;
            }

            public int hashCode() {
                return this.uuid.hashCode() + (this.token.hashCode() * 31);
            }

            public String toString() {
                return "DataReceived(token=" + this.token + ", uuid=" + this.uuid + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$Init;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "parameters", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;", "(Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;)V", "getParameters", "()Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Init extends Action {
            private final VkIdSdkParameters parameters;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Init(VkIdSdkParameters parameters) {
                super(null);
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                this.parameters = parameters;
            }

            public static /* synthetic */ Init copy$default(Init init, VkIdSdkParameters vkIdSdkParameters, int i, Object obj) {
                if ((i & 1) != 0) {
                    vkIdSdkParameters = init.parameters;
                }
                return init.copy(vkIdSdkParameters);
            }

            /* renamed from: component1, reason: from getter */
            public final VkIdSdkParameters getParameters() {
                return this.parameters;
            }

            public final Init copy(VkIdSdkParameters parameters) {
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                return new Init(parameters);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Init) && Intrinsics.areEqual(this.parameters, ((Init) other).parameters);
            }

            public final VkIdSdkParameters getParameters() {
                return this.parameters;
            }

            public int hashCode() {
                return this.parameters.hashCode();
            }

            public String toString() {
                return "Init(parameters=" + this.parameters + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Open extends Action {
            public static final Open INSTANCE = new Open();

            private Open() {
                super(null);
            }

            public String toString() {
                String simpleName = Open.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        private Action() {
        }

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;", "", "()V", "Finish", "FinishWithData", "Init", "Open", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$Finish;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$FinishWithData;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$Init;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$Open;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$Finish;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Finish extends Effect {
            public static final Finish INSTANCE = new Finish();

            private Finish() {
                super(null);
            }

            public String toString() {
                String simpleName = Finish.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$FinishWithData;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;", "token", "", "uuid", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getUuid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FinishWithData extends Effect {
            private final String token;
            private final String uuid;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FinishWithData(String token, String uuid) {
                super(null);
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                this.token = token;
                this.uuid = uuid;
            }

            public static /* synthetic */ FinishWithData copy$default(FinishWithData finishWithData, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = finishWithData.token;
                }
                if ((i & 2) != 0) {
                    str2 = finishWithData.uuid;
                }
                return finishWithData.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            public final FinishWithData copy(String token, String uuid) {
                Intrinsics.checkNotNullParameter(token, "token");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                return new FinishWithData(token, uuid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FinishWithData)) {
                    return false;
                }
                FinishWithData finishWithData = (FinishWithData) other;
                return Intrinsics.areEqual(this.token, finishWithData.token) && Intrinsics.areEqual(this.uuid, finishWithData.uuid);
            }

            public final String getToken() {
                return this.token;
            }

            public final String getUuid() {
                return this.uuid;
            }

            public int hashCode() {
                return this.uuid.hashCode() + (this.token.hashCode() * 31);
            }

            public String toString() {
                return "FinishWithData(token=" + this.token + ", uuid=" + this.uuid + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$Init;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;", "parameters", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;", "(Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;)V", "getParameters", "()Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Init extends Effect {
            private final VkIdSdkParameters parameters;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Init(VkIdSdkParameters parameters) {
                super(null);
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                this.parameters = parameters;
            }

            public static /* synthetic */ Init copy$default(Init init, VkIdSdkParameters vkIdSdkParameters, int i, Object obj) {
                if ((i & 1) != 0) {
                    vkIdSdkParameters = init.parameters;
                }
                return init.copy(vkIdSdkParameters);
            }

            /* renamed from: component1, reason: from getter */
            public final VkIdSdkParameters getParameters() {
                return this.parameters;
            }

            public final Init copy(VkIdSdkParameters parameters) {
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                return new Init(parameters);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Init) && Intrinsics.areEqual(this.parameters, ((Init) other).parameters);
            }

            public final VkIdSdkParameters getParameters() {
                return this.parameters;
            }

            public int hashCode() {
                return this.parameters.hashCode();
            }

            public String toString() {
                return "Init(parameters=" + this.parameters + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Open extends Effect {
            public static final Open INSTANCE = new Open();

            private Open() {
                super(null);
            }

            public String toString() {
                String simpleName = Open.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        private Effect() {
        }

        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$State;", "", "()V", "Progress", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$State$Progress;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$State$Progress;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Progress extends State {
            public static final Progress INSTANCE = new Progress();

            private Progress() {
                super(null);
            }

            public String toString() {
                String simpleName = Progress.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private VkId() {
    }
}
