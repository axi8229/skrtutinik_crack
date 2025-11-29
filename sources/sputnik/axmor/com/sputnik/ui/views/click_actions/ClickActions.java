package sputnik.axmor.com.sputnik.ui.views.click_actions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickActions.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions;", "", "()V", "CloseAction", "DeeplinkAction", "NextAction", "PreviousAction", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$CloseAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$DeeplinkAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$NextAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$PreviousAction;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ClickActions {
    public /* synthetic */ ClickActions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ClickActions() {
    }

    /* compiled from: ClickActions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$DeeplinkAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions;", "deeplink", "", "(Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DeeplinkAction extends ClickActions {
        private final String deeplink;

        public final String getDeeplink() {
            return this.deeplink;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeeplinkAction(String deeplink) {
            super(null);
            Intrinsics.checkNotNullParameter(deeplink, "deeplink");
            this.deeplink = deeplink;
        }
    }

    /* compiled from: ClickActions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$NextAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions;", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NextAction extends ClickActions {
        public NextAction() {
            super(null);
        }
    }

    /* compiled from: ClickActions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$CloseAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions;", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CloseAction extends ClickActions {
        public CloseAction() {
            super(null);
        }
    }

    /* compiled from: ClickActions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions$PreviousAction;", "Lsputnik/axmor/com/sputnik/ui/views/click_actions/ClickActions;", "()V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PreviousAction extends ClickActions {
        public PreviousAction() {
            super(null);
        }
    }
}
