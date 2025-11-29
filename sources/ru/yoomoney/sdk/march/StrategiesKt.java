package ru.yoomoney.sdk.march;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Strategies.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a¬\u0001\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042,\u0010\t\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u00062\u0006\u0010\n\u001a\u00028\u000028\u0010\f\u001a4\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u000bH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f\u001a~\u0010\u0014\u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062,\u0010\u0013\u001a(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015\u001a \u0001\u0010\u001c\u001a\u00020\r\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162,\u0010\u0005\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b0\u0006H\u0086@¢\u0006\u0004\b\u001c\u0010\u001d*\u0080\u0001\u0010\u001e\u001a\u0004\b\u0000\u0010\u0001\u001a\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0002\u0010\u0003\"4\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u000b24\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u000b*«\u0002\u0010!\u001a\u0004\b\u0000\u0010\u0001\u001a\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0002\u0010\u0003\"n\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002` \u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001f2¤\u0001\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u0006\u0012\u0004\u0012\u00028\u0000\u0012L\u0012J\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u000bj\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002` \u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001f*\u009a\u0002\u0010#\u001a\u0004\b\u0000\u0010\u0001\u001a\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0002\u0010\u0003\"\u0080\u0001\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\"2\u0080\u0001\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u00070\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\"*\\\u0010$\u001a\u0004\b\u0000\u0010\u0002\"(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b2(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b*Ô\u0001\u0010&\u001a\u0004\b\u0000\u0010\u0002\"T\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000`%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001f2t\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0006\u0012*\u0012(\b\u0001\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001f¨\u0006'"}, d2 = {"", "STATE", "ACTION", "EFFECT", "Lkotlinx/coroutines/channels/ReceiveChannel;", "input", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/Triple;", "Lru/yoomoney/sdk/march/Command;", "output", "initial", "Lkotlin/Function2;", "businessLogic", "", "BusinessLogicExecutionStrategyV1", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "exceptions", "Lkotlin/coroutines/Continuation;", "commandExecutor", "CommandProcessorExecutionStrategyV1", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "businessLogicDispatcher", "Lkotlin/Function1;", "sendState", "effects", "commands", "BusinessLogicResultDeliveryStrategyV1", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/channels/SendChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BusinessLogic", "Lkotlin/Function5;", "Lru/yoomoney/sdk/march/BusinessLogic;", "BusinessLogicExecutionStrategy", "Lkotlin/Function6;", "BusinessLogicResultDeliveryStrategy", "CommandProcessor", "Lru/yoomoney/sdk/march/CommandProcessor;", "CommandProcessorExecutionStrategy", "march_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StrategiesKt {

    /* compiled from: Strategies.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.StrategiesKt", f = "Strategies.kt", l = {70, 72}, m = "BusinessLogicExecutionStrategyV1")
    /* renamed from: ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicExecutionStrategyV1$1, reason: invalid class name */
    static final class AnonymousClass1<STATE, ACTION, EFFECT> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StrategiesKt.BusinessLogicExecutionStrategyV1(null, null, null, null, this);
        }
    }

    /* compiled from: Strategies.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.StrategiesKt", f = "Strategies.kt", l = {148, 149, 153, 154}, m = "BusinessLogicResultDeliveryStrategyV1")
    /* renamed from: ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicResultDeliveryStrategyV1$1, reason: invalid class name and case insensitive filesystem */
    static final class C25751<STATE, ACTION, EFFECT> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C25751(Continuation<? super C25751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StrategiesKt.BusinessLogicResultDeliveryStrategyV1(null, null, null, null, null, this);
        }
    }

    /* compiled from: Strategies.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.StrategiesKt", f = "Strategies.kt", l = {118, 121, 121, 125}, m = "CommandProcessorExecutionStrategyV1")
    /* renamed from: ru.yoomoney.sdk.march.StrategiesKt$CommandProcessorExecutionStrategyV1$1, reason: invalid class name and case insensitive filesystem */
    static final class C25761<ACTION> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C25761(Continuation<? super C25761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StrategiesKt.CommandProcessorExecutionStrategyV1(null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0099 -> B:27:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <STATE, ACTION, EFFECT> java.lang.Object BusinessLogicExecutionStrategyV1(kotlinx.coroutines.channels.ReceiveChannel<? extends ACTION> r6, kotlinx.coroutines.channels.SendChannel<? super kotlin.Triple<? extends STATE, ? extends ru.yoomoney.sdk.march.Command<?, ? extends ACTION>, ? extends EFFECT>> r7, STATE r8, kotlin.jvm.functions.Function2<? super STATE, ? super ACTION, ? extends kotlin.Triple<? extends STATE, ? extends ru.yoomoney.sdk.march.Command<?, ? extends ACTION>, ? extends EFFECT>> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof ru.yoomoney.sdk.march.StrategiesKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicExecutionStrategyV1$1 r0 = (ru.yoomoney.sdk.march.StrategiesKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicExecutionStrategyV1$1 r0 = new ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicExecutionStrategyV1$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5a
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.L$3
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r9 = (kotlinx.coroutines.channels.SendChannel) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9d
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            java.lang.Object r6 = r0.L$3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$2
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r9 = (kotlinx.coroutines.channels.SendChannel) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r5
            goto L75
        L5a:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
        L61:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r8
            r0.L$3 = r6
            r0.label = r4
            java.lang.Object r10 = r6.hasNext(r0)
            if (r10 != r1) goto L72
            return r1
        L72:
            r5 = r7
            r7 = r6
            r6 = r5
        L75:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto La9
            java.lang.Object r10 = r7.next()
            java.lang.Object r8 = r9.invoke(r8, r10)
            r10 = r8
            kotlin.Triple r10 = (kotlin.Triple) r10
            r0.L$0 = r6
            r0.L$1 = r9
            r0.L$2 = r7
            r0.L$3 = r8
            r0.label = r3
            java.lang.Object r10 = r6.send(r10, r0)
            if (r10 != r1) goto L99
            return r1
        L99:
            r5 = r9
            r9 = r6
            r6 = r8
            r8 = r5
        L9d:
            kotlin.Triple r6 = (kotlin.Triple) r6
            java.lang.Object r6 = r6.getFirst()
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r9
            r9 = r5
            goto L61
        La9:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.march.StrategiesKt.BusinessLogicExecutionStrategyV1(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, java.lang.Object, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ae, code lost:
    
        r10 = r11;
        r11 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <ACTION> java.lang.Object CommandProcessorExecutionStrategyV1(kotlinx.coroutines.channels.ReceiveChannel<? extends ru.yoomoney.sdk.march.Command<?, ? extends ACTION>> r10, kotlinx.coroutines.channels.SendChannel<? super ACTION> r11, kotlinx.coroutines.channels.SendChannel<? super java.lang.Throwable> r12, kotlin.jvm.functions.Function2<? super ru.yoomoney.sdk.march.Command<?, ? extends ACTION>, ? super kotlin.coroutines.Continuation<? super ACTION>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.march.StrategiesKt.CommandProcessorExecutionStrategyV1(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.SendChannel, kotlinx.coroutines.channels.SendChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r10v20, types: [T] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x019f -> B:45:0x01a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <STATE, ACTION, EFFECT> java.lang.Object BusinessLogicResultDeliveryStrategyV1(kotlinx.coroutines.CoroutineDispatcher r19, kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Triple<? extends STATE, ? extends ru.yoomoney.sdk.march.Command<?, ? extends ACTION>, ? extends EFFECT>> r20, kotlin.jvm.functions.Function1<? super STATE, kotlin.Unit> r21, kotlinx.coroutines.channels.SendChannel<? super EFFECT> r22, kotlinx.coroutines.channels.SendChannel<? super ru.yoomoney.sdk.march.Command<?, ? extends ACTION>> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.march.StrategiesKt.BusinessLogicResultDeliveryStrategyV1(kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlinx.coroutines.channels.SendChannel, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: Strategies.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "STATE", "", "ACTION", "EFFECT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicResultDeliveryStrategyV1$2", f = "Strategies.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ru.yoomoney.sdk.march.StrategiesKt$BusinessLogicResultDeliveryStrategyV1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Ref$ObjectRef<STATE> $lastState;
        final /* synthetic */ STATE $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref$ObjectRef<STATE> ref$ObjectRef, STATE state, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$lastState = ref$ObjectRef;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$lastState, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(!Intrinsics.areEqual(this.$lastState.element, this.$state));
        }
    }
}
