package ru.yoomoney.sdk.auth.router;

import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H&R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/router/Router;", "", "()V", "backStack", "Ljava/util/Stack;", "", "getBackStack$auth_release", "()Ljava/util/Stack;", "currentFragmentId", "getCurrentFragmentId$auth_release", "()I", "setCurrentFragmentId$auth_release", "(I)V", "homeId", "getHomeId$auth_release", "back", "next", "process", "Lru/yoomoney/sdk/auth/api/Process;", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "reset", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Router {
    private final Stack<Integer> backStack = new Stack<>();
    private int currentFragmentId = -1;
    private final int homeId = -1;

    public final int back() {
        if (this.backStack.empty()) {
            return getHomeId();
        }
        int i = this.currentFragmentId;
        Integer numPeek = this.backStack.peek();
        if (numPeek != null && i == numPeek.intValue()) {
            this.backStack.pop();
        }
        if (this.backStack.empty()) {
            return getHomeId();
        }
        Integer numPeek2 = this.backStack.peek();
        Integer num = numPeek2;
        Intrinsics.checkNotNull(num);
        this.currentFragmentId = num.intValue();
        Intrinsics.checkNotNullExpressionValue(numPeek2, "also(...)");
        return numPeek2.intValue();
    }

    public final Stack<Integer> getBackStack$auth_release() {
        return this.backStack;
    }

    /* renamed from: getCurrentFragmentId$auth_release, reason: from getter */
    public final int getCurrentFragmentId() {
        return this.currentFragmentId;
    }

    /* renamed from: getHomeId$auth_release, reason: from getter */
    public int getHomeId() {
        return this.homeId;
    }

    public abstract int next(Process process);

    public int next(RegistrationProcess process) {
        Intrinsics.checkNotNullParameter(process, "process");
        return getHomeId();
    }

    public abstract int reset();

    public final void setCurrentFragmentId$auth_release(int i) {
        this.currentFragmentId = i;
    }
}
