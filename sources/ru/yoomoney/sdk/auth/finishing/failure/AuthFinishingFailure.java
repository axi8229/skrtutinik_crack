package ru.yoomoney.sdk.auth.finishing.failure;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure;", "", "()V", "Action", "Effect", "State", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingFailure {
    public static final AuthFinishingFailure INSTANCE = new AuthFinishingFailure();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "", "()V", "Confirm", "Load", "OpenContacts", "OpenEmail", "OpenPhone", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$Confirm;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$Load;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$OpenContacts;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$OpenEmail;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$OpenPhone;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$Confirm;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Confirm extends Action {
            public static final Confirm INSTANCE = new Confirm();

            private Confirm() {
                super(null);
            }

            public String toString() {
                String simpleName = Confirm.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$Load;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "showSupportButton", "", "(Z)V", "getShowSupportButton", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Load extends Action {
            private final boolean showSupportButton;

            public Load(boolean z) {
                super(null);
                this.showSupportButton = z;
            }

            public static /* synthetic */ Load copy$default(Load load, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = load.showSupportButton;
                }
                return load.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowSupportButton() {
                return this.showSupportButton;
            }

            public final Load copy(boolean showSupportButton) {
                return new Load(showSupportButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Load) && this.showSupportButton == ((Load) other).showSupportButton;
            }

            public final boolean getShowSupportButton() {
                return this.showSupportButton;
            }

            public int hashCode() {
                return Boolean.hashCode(this.showSupportButton);
            }

            public String toString() {
                return "Load(showSupportButton=" + this.showSupportButton + ")";
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$OpenContacts;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenContacts extends Action {
            public static final OpenContacts INSTANCE = new OpenContacts();

            private OpenContacts() {
                super(null);
            }

            public String toString() {
                String simpleName = OpenContacts.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$OpenEmail;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenEmail extends Action {
            public static final OpenEmail INSTANCE = new OpenEmail();

            private OpenEmail() {
                super(null);
            }

            public String toString() {
                String simpleName = OpenEmail.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action$OpenPhone;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Action;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenPhone extends Action {
            public static final OpenPhone INSTANCE = new OpenPhone();

            private OpenPhone() {
                super(null);
            }

            public String toString() {
                String simpleName = OpenPhone.class.getSimpleName();
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "", "()V", "CallPhone", "Finish", "SendEmail", "ShowContactsDialog", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$CallPhone;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$Finish;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$SendEmail;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$ShowContactsDialog;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$CallPhone;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class CallPhone extends Effect {
            public static final CallPhone INSTANCE = new CallPhone();

            private CallPhone() {
                super(null);
            }

            public String toString() {
                String simpleName = CallPhone.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$Finish;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$SendEmail;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class SendEmail extends Effect {
            public static final SendEmail INSTANCE = new SendEmail();

            private SendEmail() {
                super(null);
            }

            public String toString() {
                String simpleName = SendEmail.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect$ShowContactsDialog;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$Effect;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowContactsDialog extends Effect {
            public static final ShowContactsDialog INSTANCE = new ShowContactsDialog();

            private ShowContactsDialog() {
                super(null);
            }

            public String toString() {
                String simpleName = ShowContactsDialog.class.getSimpleName();
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;", "", "()V", "Content", "Init", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Content;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Init;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Content;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;", "showSupportButton", "", "(Z)V", "getShowSupportButton", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends State {
            private final boolean showSupportButton;

            public Content() {
                this(false, 1, null);
            }

            public static /* synthetic */ Content copy$default(Content content, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = content.showSupportButton;
                }
                return content.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowSupportButton() {
                return this.showSupportButton;
            }

            public final Content copy(boolean showSupportButton) {
                return new Content(showSupportButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Content) && this.showSupportButton == ((Content) other).showSupportButton;
            }

            public final boolean getShowSupportButton() {
                return this.showSupportButton;
            }

            public int hashCode() {
                return Boolean.hashCode(this.showSupportButton);
            }

            public String toString() {
                return "Content(showSupportButton=" + this.showSupportButton + ")";
            }

            public Content(boolean z) {
                super(null);
                this.showSupportButton = z;
            }

            public /* synthetic */ Content(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State$Init;", "Lru/yoomoney/sdk/auth/finishing/failure/AuthFinishingFailure$State;", "()V", "toString", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Init extends State {
            public static final Init INSTANCE = new Init();

            private Init() {
                super(null);
            }

            public String toString() {
                String simpleName = Init.class.getSimpleName();
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

    private AuthFinishingFailure() {
    }
}
