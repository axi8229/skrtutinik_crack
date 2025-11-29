package sputnik.axmor.com.sputnik.services.ble_service;

import com.sputnik.common.analytics.BleEvents;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: BeaconTrackingService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/sputnik/domain/common/Resource;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService$onIntercomFound$1$1$1", f = "BeaconTrackingService.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class BeaconTrackingService$onIntercomFound$1$1$1 extends SuspendLambda implements Function2<Resource<? extends Unit>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BeaconTrackingService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BeaconTrackingService$onIntercomFound$1$1$1(BeaconTrackingService beaconTrackingService, Continuation<? super BeaconTrackingService$onIntercomFound$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = beaconTrackingService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BeaconTrackingService$onIntercomFound$1$1$1 beaconTrackingService$onIntercomFound$1$1$1 = new BeaconTrackingService$onIntercomFound$1$1$1(this.this$0, continuation);
        beaconTrackingService$onIntercomFound$1$1$1.L$0 = obj;
        return beaconTrackingService$onIntercomFound$1$1$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Resource<Unit> resource, Continuation<? super Unit> continuation) {
        return ((BeaconTrackingService$onIntercomFound$1$1$1) create(resource, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Resource<? extends Unit> resource, Continuation<? super Unit> continuation) {
        return invoke2((Resource<Unit>) resource, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Resource resource = (Resource) this.L$0;
        DomainEmpty errorMsg = resource.getErrorMsg();
        if ((errorMsg != null ? errorMsg.getEmergencyCode() : null) != null) {
            this.this$0.getAnalytics().trackLogEvent(new BleEvents.StateBleOpenDoorFailed());
            BeaconTrackingService beaconTrackingService = this.this$0;
            DomainEmpty errorMsg2 = resource.getErrorMsg();
            beaconTrackingService.showEmergencyCodeNotification(String.valueOf(errorMsg2 != null ? errorMsg2.getEmergencyCode() : null));
            this.this$0.lastOpeningTimeMillis += 50000;
        } else {
            this.this$0.getAnalytics().trackLogEvent(new BleEvents.StateBleOpenDoorSuccessfully());
            BeaconTrackingService beaconTrackingService2 = this.this$0;
            beaconTrackingService2.lastOpeningTimeMillis = beaconTrackingService2.lastOpeningTimeMillis;
        }
        return Unit.INSTANCE;
    }
}
