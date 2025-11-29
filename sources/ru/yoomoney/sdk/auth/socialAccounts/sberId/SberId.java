package ru.yoomoney.sdk.auth.socialAccounts.sberId;

import android.net.Uri;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SberId {
    public static final SberId INSTANCE = new SberId();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", "", "()V", "Cancel", "DeeplinkReceived", "Open", "ShowDialog", "WaitForDeeplink", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$Cancel;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$DeeplinkReceived;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$ShowDialog;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$WaitForDeeplink;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$Cancel;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$DeeplinkReceived;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", RemoteMessageConst.DATA, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getData", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DeeplinkReceived extends Action {
            private final Uri data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeeplinkReceived(Uri data) {
                super(null);
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$ShowDialog;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowDialog extends Action {
            public static final ShowDialog INSTANCE = new ShowDialog();

            private ShowDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowDialog.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action$WaitForDeeplink;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class WaitForDeeplink extends Action {
            public static final WaitForDeeplink INSTANCE = new WaitForDeeplink();

            private WaitForDeeplink() {
                super(null);
            }

            public String toString() {
                String simpleName = WaitForDeeplink.class.getSimpleName();
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect;", "", "()V", "Finish", "FinishWithData", "Open", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect$Finish;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect$FinishWithData;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect$Open;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect$Finish;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect$FinishWithData;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect;", RemoteMessageConst.DATA, "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getData", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FinishWithData extends Effect {
            private final Uri data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FinishWithData(Uri data) {
                super(null);
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect$Open;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State;", "", "()V", "Empty", "OpenSberDialog", "Waiting", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Empty;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$OpenSberDialog;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Waiting;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Empty;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Empty extends State {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }

            public String toString() {
                String simpleName = Empty.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$OpenSberDialog;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenSberDialog extends State {
            public static final OpenSberDialog INSTANCE = new OpenSberDialog();

            private OpenSberDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = OpenSberDialog.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State$Waiting;", "Lru/yoomoney/sdk/auth/socialAccounts/sberId/SberId$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Waiting extends State {
            public static final Waiting INSTANCE = new Waiting();

            private Waiting() {
                super(null);
            }

            public String toString() {
                String simpleName = Waiting.class.getSimpleName();
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

    private SberId() {
    }
}
