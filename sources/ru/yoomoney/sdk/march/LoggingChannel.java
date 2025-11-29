package ru.yoomoney.sdk.march;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Logging.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0013\u001a\u00020\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00050\u0004H\u0097\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096Aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010 \u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00028\u0000H\u0096@¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010'R\u0014\u0010(\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/march/LoggingChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lkotlin/Function1;", "", "log", "<init>", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;)V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "", "", "close", "(Ljava/lang/Throwable;)Z", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "element", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/jvm/functions/Function1;", "isClosedForSend", "()Z", "march_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoggingChannel<E> implements Channel<E> {
    private final Function1<E, Unit> log;
    private final Channel<E> origin;

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public void cancel(CancellationException cause) {
        this.origin.cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this.origin.close(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.origin.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.origin.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this.origin.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return this.origin.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo2787receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object objMo2787receiveCatchingJP2dKIU = this.origin.mo2787receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objMo2787receiveCatchingJP2dKIU;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo2788tryReceivePtdJZtk() {
        return this.origin.mo2788tryReceivePtdJZtk();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoggingChannel(Channel<E> origin, Function1<? super E, Unit> log) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(log, "log");
        this.origin = origin;
        this.log = log;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo2240trySendJP2dKIU(E element) {
        this.log.invoke(element);
        return this.origin.mo2240trySendJP2dKIU(element);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        this.log.invoke(e);
        Object objSend = this.origin.send(e, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }
}
