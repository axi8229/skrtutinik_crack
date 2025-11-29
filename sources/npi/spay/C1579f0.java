package npi.spay;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;
import spay.sdk.utils.receiver.OtpReceiver;
import spay.sdk.view.otpTextView.SpayOtpTextView;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/f0;", "Lnpi/spay/Z7;", "Lnpi/spay/z4;", "Lnpi/spay/Na;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.f0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1579f0 extends Z7<C2081z4, Na> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public OtpReceiver d;
    public final Class e = C2081z4.class;

    public static final void a(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Timber.INSTANCE.e("Failed startSmsUserConsent()", it);
    }

    @Override // npi.spay.Z7
    /* renamed from: c, reason: from getter */
    public final Class getE() {
        return this.e;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.q0.get();
            pj.d.a();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Na na = (Na) viewBinding;
        StateFlow stateFlow = ((C2081z4) b()).x;
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new G(this, state, stateFlow, null, na), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new J(this, state, FlowKt.filterNotNull(((C2081z4) b()).q), null, na, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new M(this, state, ((C2081z4) b()).s, null, na, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new P(this, state, ((C2081z4) b()).y, null, na, this, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new T(this, state, ((C2081z4) b()).u, null, na), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new W(this, state, FlowKt.filterNotNull(((C2081z4) b()).w), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Z(this, state, FlowKt.filterNotNull(((C2081z4) b()).m), null, na), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Na na = (Na) viewBinding;
        MaterialButton spaySlotpMbBtnCancel = na.b;
        Intrinsics.checkNotNullExpressionValue(spaySlotpMbBtnCancel, "spaySlotpMbBtnCancel");
        spaySlotpMbBtnCancel.setOnClickListener(new ViewOnClickListenerC1479b0(new Ref$LongRef(), this));
        MaterialButton spaySlotpMbBtnContinue = na.c;
        Intrinsics.checkNotNullExpressionValue(spaySlotpMbBtnContinue, "spaySlotpMbBtnContinue");
        spaySlotpMbBtnContinue.setOnClickListener(new ViewOnClickListenerC1504c0(new Ref$LongRef(), this));
        TextView spaySlotpTvRetryBtn = na.g;
        Intrinsics.checkNotNullExpressionValue(spaySlotpTvRetryBtn, "spaySlotpTvRetryBtn");
        spaySlotpTvRetryBtn.setOnClickListener(new ViewOnClickListenerC1529d0(new Ref$LongRef(), na, this));
        na.d.setSpayOtpListener(new C1454a0(this));
        h();
    }

    public final void h() {
        SmsRetrieverClient client = SmsRetriever.getClient(requireContext());
        Intrinsics.checkNotNullExpressionValue(client, "getClient(requireContext())");
        Task<Void> taskStartSmsUserConsent = client.startSmsUserConsent(null);
        final C1554e0 c1554e0 = C1554e0.a;
        taskStartSmsUserConsent.addOnSuccessListener(new OnSuccessListener() { // from class: npi.spay.f0$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                C1579f0.a(c1554e0, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: npi.spay.f0$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                C1579f0.a(exc);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) throws NoSuchAlgorithmException {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i != 200 || i2 != -1 || intent == null || (stringExtra = intent.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)) == null) {
            return;
        }
        ((C2081z4) b()).a(new C1701jn(stringExtra));
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() throws NoSuchAlgorithmException {
        super.onStart();
        ((C2081z4) b()).a(C1726kn.a);
        OtpReceiver otpReceiver = new OtpReceiver();
        this.d = otpReceiver;
        C2005w3 listener = new C2005w3(this);
        Intrinsics.checkNotNullParameter(listener, "listener");
        otpReceiver.a = listener;
        ContextCompat.registerReceiver(requireContext(), this.d, new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION), SmsRetriever.SEND_PERMISSION, null, 4);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() throws NoSuchAlgorithmException {
        super.onStop();
        ((C2081z4) b()).a(C1751ln.a);
        requireActivity().unregisterReceiver(this.d);
    }

    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_one_time_password, (ViewGroup) null, false);
        int i = R$id.spay_slotp_mb_btn_cancel;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
        if (materialButton != null) {
            i = R$id.spay_slotp_mb_btn_continue;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
            if (materialButton2 != null) {
                i = R$id.spay_slotp_socecv_code;
                SpayOtpTextView spayOtpTextView = (SpayOtpTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (spayOtpTextView != null) {
                    i = R$id.spay_slotp_tv_error_message;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                    if (textView != null) {
                        i = R$id.spay_slotp_tv_message;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                        if (textView2 != null) {
                            i = R$id.spay_slotp_tv_retry_btn;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                            if (textView3 != null) {
                                Na na = new Na((ConstraintLayout) viewInflate, materialButton, materialButton2, spayOtpTextView, textView, textView2, textView3);
                                Intrinsics.checkNotNullExpressionValue(na, "inflate(layoutInflater)");
                                return na;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
