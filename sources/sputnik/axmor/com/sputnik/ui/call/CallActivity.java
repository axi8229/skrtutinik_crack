package sputnik.axmor.com.sputnik.ui.call;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import com.axmor.ash.toolset.service.impl.CompositeServiceConnection;
import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.service.AppService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewState;

/* compiled from: CallActivity.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0003R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001d\u0010,\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/CallActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "navigateToRootActivity", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onDestroy", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "callFactory", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "getCallFactory", "()Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;", "setCallFactory", "(Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel$Factory$AssistFactory;)V", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "callViewModel", "Lsputnik/axmor/com/sputnik/ui/call/viewmodel/CallViewModel;", "", "callId$delegate", "Lkotlin/Lazy;", "getCallId", "()Ljava/lang/String;", FailedBinderCallBack.CALLER_ID, "callUuid$delegate", "getCallUuid", "callUuid", "flatUuid$delegate", "getFlatUuid", "flatUuid", "callIsAccepted$delegate", "getCallIsAccepted", "()Ljava/lang/Boolean;", "callIsAccepted", "Lcom/axmor/ash/toolset/service/impl/CompositeServiceConnection;", "compositeServiceConnection$delegate", "getCompositeServiceConnection", "()Lcom/axmor/ash/toolset/service/impl/CompositeServiceConnection;", "compositeServiceConnection", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallActivity extends AppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean callNeedBeAccepted;
    public CallViewModel.Factory.AssistFactory callFactory;

    /* renamed from: callId$delegate, reason: from kotlin metadata */
    private final Lazy callId;

    /* renamed from: callIsAccepted$delegate, reason: from kotlin metadata */
    private final Lazy callIsAccepted;

    /* renamed from: callUuid$delegate, reason: from kotlin metadata */
    private final Lazy callUuid;
    private CallViewModel callViewModel;

    /* renamed from: compositeServiceConnection$delegate, reason: from kotlin metadata */
    private final Lazy compositeServiceConnection;

    /* renamed from: flatUuid$delegate, reason: from kotlin metadata */
    private final Lazy flatUuid;

    public CallActivity() {
        super(R.layout.new_call_activity);
        this.callId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.call.CallActivity$callId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Intent intent = this.this$0.getIntent();
                if (intent != null) {
                    return intent.getStringExtra("sputnik.axmor.com.sputnik.global.call_id");
                }
                return null;
            }
        });
        this.callUuid = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.call.CallActivity$callUuid$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Intent intent = this.this$0.getIntent();
                if (intent != null) {
                    return intent.getStringExtra("sputnik.axmor.com.sputnik.global.uuid");
                }
                return null;
            }
        });
        this.flatUuid = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.call.CallActivity$flatUuid$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Intent intent = this.this$0.getIntent();
                if (intent != null) {
                    return intent.getStringExtra("call.flat_uuid");
                }
                return null;
            }
        });
        this.callIsAccepted = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.call.CallActivity$callIsAccepted$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Intent intent = this.this$0.getIntent();
                if (intent != null) {
                    return Boolean.valueOf(intent.getBooleanExtra("sputnik.axmor.com.sputnik.global.is_accepted", false));
                }
                return null;
            }
        });
        this.compositeServiceConnection = LazyKt.lazy(new Function0<CompositeServiceConnection>() { // from class: sputnik.axmor.com.sputnik.ui.call.CallActivity$compositeServiceConnection$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CompositeServiceConnection invoke() {
                return new CompositeServiceConnection(this.this$0, AppService.class);
            }
        });
    }

    public final CallViewModel.Factory.AssistFactory getCallFactory() {
        CallViewModel.Factory.AssistFactory assistFactory = this.callFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callFactory");
        return null;
    }

    public final String getCallId() {
        return (String) this.callId.getValue();
    }

    public final String getCallUuid() {
        return (String) this.callUuid.getValue();
    }

    public final String getFlatUuid() {
        return (String) this.flatUuid.getValue();
    }

    public final Boolean getCallIsAccepted() {
        return (Boolean) this.callIsAccepted.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextKt.getAppComponent(this).inject(this);
        Boolean callIsAccepted = getCallIsAccepted();
        callNeedBeAccepted = callIsAccepted != null ? callIsAccepted.booleanValue() : false;
        CallViewModel.Factory.AssistFactory callFactory = getCallFactory();
        String callId = getCallId();
        String callUuid = getCallUuid();
        String flatUuid = getFlatUuid();
        Boolean callIsAccepted2 = getCallIsAccepted();
        CallViewModel callViewModel = (CallViewModel) callFactory.create(callId, callUuid, flatUuid, callIsAccepted2 != null ? callIsAccepted2.booleanValue() : false).create(CallViewModel.class);
        this.callViewModel = callViewModel;
        if (callViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callViewModel");
            callViewModel = null;
        }
        callViewModel.observeState(this, new Function1<CallViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.call.CallActivity.onCreate.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CallViewState callViewState) {
                invoke2(callViewState);
                return Unit.INSTANCE;
            }
        });
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getCompositeServiceConnection().onStart();
        getWindow().addFlags(6815873);
        IPushProcessor.Companion.getInstance$default(IPushProcessor.INSTANCE, this, null, 2, null).cancelNotification();
    }

    public final CompositeServiceConnection getCompositeServiceConnection() {
        return (CompositeServiceConnection) this.compositeServiceConnection.getValue();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        navigateToRootActivity();
        super.onBackPressed();
    }

    public final void navigateToRootActivity() {
        SputnikApp.INSTANCE.changeCallState(new SputnikApp.Companion.CallState(false, null, null, null, 8, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0008  */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            r0 = 164(0xa4, float:2.3E-43)
            if (r4 == r0) goto L8
            switch(r4) {
                case 24: goto L8;
                case 25: goto L8;
                case 26: goto L8;
                default: goto L7;
            }
        L7:
            goto L13
        L8:
            sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor$Companion r0 = sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor.INSTANCE
            r1 = 2
            r2 = 0
            sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor r0 = sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor.Companion.getInstance$default(r0, r3, r2, r1, r2)
            r0.cancel()
        L13:
            boolean r4 = super.onKeyDown(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.call.CallActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        getCompositeServiceConnection().onStop();
        super.onDestroy();
    }

    /* compiled from: CallActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/call/CallActivity$Companion;", "", "<init>", "()V", "", "callNeedBeAccepted", "Z", "getCallNeedBeAccepted", "()Z", "setCallNeedBeAccepted", "(Z)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getCallNeedBeAccepted() {
            return CallActivity.callNeedBeAccepted;
        }
    }
}
