package ru.yoomoney.sdk.auth.socialAccounts.esia;

import android.net.Uri;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Esia {
    public static final Esia INSTANCE = new Esia();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", "", "Cancel", "DeeplinkReceived", "Open", "WaitForDeeplink", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$Cancel;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$DeeplinkReceived;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$WaitForDeeplink;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Action {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$Cancel;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Cancel implements Action {
            public static final Cancel INSTANCE = new Cancel();

            private Cancel() {
            }

            public String toString() {
                String simpleName = Cancel.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$DeeplinkReceived;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", RemoteMessageConst.DATA, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getData", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DeeplinkReceived implements Action {
            private final Uri data;

            public DeeplinkReceived(Uri data) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public static /* synthetic */ DeeplinkReceived copy$default(DeeplinkReceived deeplinkReceived, Uri uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = deeplinkReceived.data;
                }
                return deeplinkReceived.copy(uri);
            }

            /* renamed from: component1, reason: from getter */
            public final Uri getData() {
                return this.data;
            }

            public final DeeplinkReceived copy(Uri data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new DeeplinkReceived(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DeeplinkReceived) && Intrinsics.areEqual(this.data, ((DeeplinkReceived) other).data);
            }

            public final Uri getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "DeeplinkReceived(data=" + this.data + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Open implements Action {
            public static final Open INSTANCE = new Open();

            private Open() {
            }

            public String toString() {
                String simpleName = Open.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action$WaitForDeeplink;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class WaitForDeeplink implements Action {
            public static final WaitForDeeplink INSTANCE = new WaitForDeeplink();

            private WaitForDeeplink() {
            }

            public String toString() {
                String simpleName = WaitForDeeplink.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;", "", "Finish", "FinishWithData", "Open", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect$Finish;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect$FinishWithData;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect$Open;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect$Finish;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Finish implements Effect {
            public static final Finish INSTANCE = new Finish();

            private Finish() {
            }

            public String toString() {
                String simpleName = Finish.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect$FinishWithData;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;", RemoteMessageConst.DATA, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getData", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FinishWithData implements Effect {
            private final Uri data;

            public FinishWithData(Uri data) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public static /* synthetic */ FinishWithData copy$default(FinishWithData finishWithData, Uri uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = finishWithData.data;
                }
                return finishWithData.copy(uri);
            }

            /* renamed from: component1, reason: from getter */
            public final Uri getData() {
                return this.data;
            }

            public final FinishWithData copy(Uri data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new FinishWithData(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FinishWithData) && Intrinsics.areEqual(this.data, ((FinishWithData) other).data);
            }

            public final Uri getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "FinishWithData(data=" + this.data + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Open implements Effect {
            public static final Open INSTANCE = new Open();

            private Open() {
            }

            public String toString() {
                String simpleName = Open.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;", "", "Empty", "Waiting", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Empty;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Waiting;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Empty;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Empty implements State {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
            }

            public String toString() {
                String simpleName = Empty.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State$Waiting;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Waiting implements State {
            public static final Waiting INSTANCE = new Waiting();

            private Waiting() {
            }

            public String toString() {
                String simpleName = Waiting.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }
    }

    private Esia() {
    }
}
