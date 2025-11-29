package ru.yoomoney.sdk.march;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Code.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u00020\u0005B?\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/march/RuntimeViewModel;", "", "STATE", "ACTION", "EFFECT", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "states", "Lkotlinx/coroutines/channels/ReceiveChannel;", "effects", "", "exceptions", "Lkotlinx/coroutines/channels/SendChannel;", "actions", "<init>", "(Landroidx/lifecycle/LiveData;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;)V", "action", "", "handleAction", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LiveData;", "getStates", "()Landroidx/lifecycle/LiveData;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getEffects", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "getExceptions", "Lkotlinx/coroutines/channels/SendChannel;", "getActions", "()Lkotlinx/coroutines/channels/SendChannel;", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuntimeViewModel<STATE, ACTION, EFFECT> extends ViewModel {
    private final SendChannel<ACTION> actions;
    private final ReceiveChannel<EFFECT> effects;
    private final ReceiveChannel<Throwable> exceptions;
    private final LiveData<STATE> states;

    public final LiveData<STATE> getStates() {
        return this.states;
    }

    public final ReceiveChannel<EFFECT> getEffects() {
        return this.effects;
    }

    public final ReceiveChannel<Throwable> getExceptions() {
        return this.exceptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeViewModel(LiveData<STATE> states, ReceiveChannel<? extends EFFECT> effects, ReceiveChannel<? extends Throwable> exceptions, SendChannel<? super ACTION> actions) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(effects, "effects");
        Intrinsics.checkNotNullParameter(exceptions, "exceptions");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.states = states;
        this.effects = effects;
        this.exceptions = exceptions;
        this.actions = actions;
    }

    public final void handleAction(ACTION action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.actions.mo2240trySendJP2dKIU(action);
    }
}
