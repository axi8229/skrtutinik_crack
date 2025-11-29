package ru.yoomoney.sdk.two_fa.confirmationHelp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.Routes;
import ru.yoomoney.sdk.two_fa.domain.SessionType;

/* compiled from: ConfirmationHelpContract.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp;", "", "()V", "Action", "Effect", "State", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationHelp {
    public static final int $stable = 0;
    public static final ConfirmationHelp INSTANCE = new ConfirmationHelp();

    private ConfirmationHelp() {
    }

    /* compiled from: ConfirmationHelpContract.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State;", "", "Content", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State$Content;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface State {

        /* compiled from: ConfirmationHelpContract.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State$Content;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$State;", Routes.sessionTypeArg, "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "isActionVisible", "", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;Z)V", "()Z", "getSessionType", "()Lru/yoomoney/sdk/two_fa/domain/SessionType;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content implements State {
            public static final int $stable = 0;
            private final boolean isActionVisible;
            private final SessionType sessionType;

            public static /* synthetic */ Content copy$default(Content content, SessionType sessionType, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    sessionType = content.sessionType;
                }
                if ((i & 2) != 0) {
                    z = content.isActionVisible;
                }
                return content.copy(sessionType, z);
            }

            /* renamed from: component1, reason: from getter */
            public final SessionType getSessionType() {
                return this.sessionType;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsActionVisible() {
                return this.isActionVisible;
            }

            public final Content copy(SessionType sessionType, boolean isActionVisible) {
                Intrinsics.checkNotNullParameter(sessionType, "sessionType");
                return new Content(sessionType, isActionVisible);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return this.sessionType == content.sessionType && this.isActionVisible == content.isActionVisible;
            }

            public int hashCode() {
                return (this.sessionType.hashCode() * 31) + Boolean.hashCode(this.isActionVisible);
            }

            public String toString() {
                return "Content(sessionType=" + this.sessionType + ", isActionVisible=" + this.isActionVisible + ")";
            }

            public Content(SessionType sessionType, boolean z) {
                Intrinsics.checkNotNullParameter(sessionType, "sessionType");
                this.sessionType = sessionType;
                this.isActionVisible = z;
            }

            public final SessionType getSessionType() {
                return this.sessionType;
            }

            public final boolean isActionVisible() {
                return this.isActionVisible;
            }
        }
    }

    /* compiled from: ConfirmationHelpContract.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;", "", "ShowSupport", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action$ShowSupport;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Action {

        /* compiled from: ConfirmationHelpContract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action$ShowSupport;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Action;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ShowSupport implements Action {
            public static final int $stable = 0;
            public static final ShowSupport INSTANCE = new ShowSupport();

            private ShowSupport() {
            }

            public String toString() {
                String simpleName = ShowSupport.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }
    }

    /* compiled from: ConfirmationHelpContract.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect;", "", "OpenBrowser", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect$OpenBrowser;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Effect {

        /* compiled from: ConfirmationHelpContract.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect$OpenBrowser;", "Lru/yoomoney/sdk/two_fa/confirmationHelp/ConfirmationHelp$Effect;", "()V", "toString", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OpenBrowser implements Effect {
            public static final int $stable = 0;
            public static final OpenBrowser INSTANCE = new OpenBrowser();

            private OpenBrowser() {
            }

            public String toString() {
                String simpleName = OpenBrowser.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                return simpleName;
            }
        }
    }
}
