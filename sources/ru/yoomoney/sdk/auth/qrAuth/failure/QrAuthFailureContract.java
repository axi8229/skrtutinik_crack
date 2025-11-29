package ru.yoomoney.sdk.auth.qrAuth.failure;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthFailureContract {
    public static final QrAuthFailureContract INSTANCE = new QrAuthFailureContract();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action;", "", "()V", "Close", "RetryScan", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action$Close;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action$RetryScan;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action$Close;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Close extends Action {
            public static final Close INSTANCE = new Close();

            private Close() {
                super(null);
            }

            public String toString() {
                String simpleName = Close.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action$RetryScan;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class RetryScan extends Action {
            public static final RetryScan INSTANCE = new RetryScan();

            private RetryScan() {
                super(null);
            }

            public String toString() {
                String simpleName = RetryScan.class.getSimpleName();
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect;", "", "()V", "CloseScreen", "ShowScanScreen", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect$CloseScreen;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect$ShowScanScreen;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect$CloseScreen;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class CloseScreen extends Effect {
            public static final CloseScreen INSTANCE = new CloseScreen();

            private CloseScreen() {
                super(null);
            }

            public String toString() {
                String simpleName = CloseScreen.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect$ShowScanScreen;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowScanScreen extends Effect {
            public static final ShowScanScreen INSTANCE = new ShowScanScreen();

            private ShowScanScreen() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowScanScreen.class.getSimpleName();
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$State;", "", "()V", "Content", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$State$Content;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$State$Content;", "Lru/yoomoney/sdk/auth/qrAuth/failure/QrAuthFailureContract$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Content extends State {
            public static final Content INSTANCE = new Content();

            private Content() {
                super(null);
            }

            public String toString() {
                String simpleName = Content.class.getSimpleName();
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

    private QrAuthFailureContract() {
    }
}
