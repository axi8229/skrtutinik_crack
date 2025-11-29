package sputnik.axmor.com.sputnik.core.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import sputnik.axmor.com.sputnik.core.push.IPushManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.call_service.CallNotificationService;
import sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor;

/* compiled from: PushIntentService.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lsputnik/axmor/com/sputnik/core/push/PushIntentService;", "Lcom/huawei/hms/push/HmsMessageService;", "<init>", "()V", "", "onCreate", "Lcom/huawei/hms/push/RemoteMessage;", "remoteMessage", "onMessageReceived", "(Lcom/huawei/hms/push/RemoteMessage;)V", "", "newToken", "onNewToken", "(Ljava/lang/String;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "errHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getErrHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "setErrHandler", "(Lkotlinx/coroutines/CoroutineExceptionHandler;)V", "Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;", "sendPushTokenUseCase", "Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;", "getSendPushTokenUseCase", "()Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;", "setSendPushTokenUseCase", "(Lcom/sputnik/domain/usecases/profile/SendPushTokenUseCase;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushIntentService extends HmsMessageService {
    public CoroutineExceptionHandler errHandler;
    public PrefManager prefManager;
    public CoroutineScope scope;
    public SendPushTokenUseCase sendPushTokenUseCase;

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    public final CoroutineScope getScope() {
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scope");
        return null;
    }

    public final SendPushTokenUseCase getSendPushTokenUseCase() {
        SendPushTokenUseCase sendPushTokenUseCase = this.sendPushTokenUseCase;
        if (sendPushTokenUseCase != null) {
            return sendPushTokenUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sendPushTokenUseCase");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        ContextKt.getAppComponent(this).inject(this);
        super.onCreate();
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Log.e("push notification", remoteMessage.getData().toString());
        remoteMessage.getDataOfMap();
        new Intent(getApplicationContext(), (Class<?>) CallNotificationService.class);
        new Bundle();
        if (Intrinsics.areEqual(remoteMessage.getDataOfMap().get(PushMessage.Arguments.body.toString()), PushMessage.Types.call.toString())) {
            IPushProcessor instance$default = IPushProcessor.Companion.getInstance$default(IPushProcessor.INSTANCE, this, null, 2, null);
            Map<String, String> dataOfMap = remoteMessage.getDataOfMap();
            Intrinsics.checkNotNullExpressionValue(dataOfMap, "getDataOfMap(...)");
            instance$default.process(dataOfMap);
            return;
        }
        IPushManager.Companion companion = IPushManager.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        IPushManager companion2 = companion.getInstance(applicationContext);
        Map<String, String> dataOfMap2 = remoteMessage.getDataOfMap();
        if (dataOfMap2 == null) {
            dataOfMap2 = MapsKt.emptyMap();
        }
        String strValueOf = String.valueOf(dataOfMap2.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE));
        String strValueOf2 = String.valueOf(dataOfMap2.get("subtitle"));
        Map<String, String> dataOfMap3 = remoteMessage.getDataOfMap();
        Intrinsics.checkNotNullExpressionValue(dataOfMap3, "getDataOfMap(...)");
        companion2.handleMessage(strValueOf, strValueOf2, dataOfMap3);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String newToken) {
        Intrinsics.checkNotNullParameter(newToken, "newToken");
        if (StringsKt.isBlank(newToken) || Intrinsics.areEqual(newToken, getPrefManager().getPushToken())) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new AnonymousClass1(newToken, null), 3, null);
    }

    /* compiled from: PushIntentService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.core.push.PushIntentService$onNewToken$1", f = "PushIntentService.kt", l = {88}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.core.push.PushIntentService$onNewToken$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newToken;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PushIntentService.this.new AnonymousClass1(this.$newToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Resource<Unit>> flowInvoke = PushIntentService.this.getSendPushTokenUseCase().invoke(this.$newToken);
                final PushIntentService pushIntentService = PushIntentService.this;
                final String str = this.$newToken;
                FlowCollector<? super Resource<Unit>> flowCollector = new FlowCollector() { // from class: sputnik.axmor.com.sputnik.core.push.PushIntentService.onNewToken.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Resource<Unit>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Resource<Unit> resource, Continuation<? super Unit> continuation) {
                        if (resource.getStatus() == Resource.Status.SUCCESS) {
                            pushIntentService.getPrefManager().updatePushToken(str);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowInvoke.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
