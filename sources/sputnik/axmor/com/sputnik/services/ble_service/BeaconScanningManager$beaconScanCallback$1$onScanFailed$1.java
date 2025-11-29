package sputnik.axmor.com.sputnik.services.ble_service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: BeaconScanningManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager$beaconScanCallback$1$onScanFailed$1", f = "BeaconScanningManager.kt", l = {98, 100}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class BeaconScanningManager$beaconScanCallback$1$onScanFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BeaconScanningManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BeaconScanningManager$beaconScanCallback$1$onScanFailed$1(BeaconScanningManager beaconScanningManager, Continuation<? super BeaconScanningManager$beaconScanCallback$1$onScanFailed$1> continuation) {
        super(2, continuation);
        this.this$0 = beaconScanningManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BeaconScanningManager$beaconScanCallback$1$onScanFailed$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BeaconScanningManager$beaconScanCallback$1$onScanFailed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BluetoothAdapter adapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(2500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.startTracking();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        BluetoothManager bluetoothManager = this.this$0.bluetoothManager;
        if (bluetoothManager != null && (adapter = bluetoothManager.getAdapter()) != null) {
            Boxing.boxBoolean(adapter.enable());
        }
        this.label = 2;
        if (DelayKt.delay(500L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.startTracking();
        return Unit.INSTANCE;
    }
}
