package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/I5;", "Lnpi/spay/Z7;", "Lnpi/spay/a4;", "Lnpi/spay/Km;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class I5 extends Z7<C1458a4, Km> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public InterfaceC2010w8 d;

    public static final void a(I5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C1458a4) this$0.b()).a(O3.a);
    }

    public static final void b(I5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C1458a4) this$0.b()).a(N3.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C1458a4.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Km km = (Km) viewBinding;
        km.b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.I5$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                I5.a(this.f$0, view);
            }
        });
        km.e.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.I5$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                I5.b(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).l0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C1458a4) b()).e);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new A5(this, state, flowFilterNotNull, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new D5(this, state, FlowKt.filterNotNull(((C1458a4) b()).g), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new G5(this, state, FlowKt.filterNotNull(((C1458a4) b()).h), null, this), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() {
        Object objB = b();
        InterfaceC2010w8 interfaceC2010w8 = objB instanceof InterfaceC2010w8 ? (InterfaceC2010w8) objB : null;
        if (interfaceC2010w8 == null) {
            throw new IllegalStateException("AgreementFragmentViewModel must implement UrlProcessInterface!");
        }
        this.d = interfaceC2010w8;
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Km) viewBinding).c.getLayoutParams().height = requireContext().getResources().getDisplayMetrics().heightPixels - getResources().getDimensionPixelSize(R$dimen.spay_bnpl_return_btn_bottom_margin);
        d();
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        WebView webView = ((Km) viewBinding2).f;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setAllowFileAccess(false);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new M4(this));
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((C1458a4) b()).a(P3.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((C1458a4) b()).a(Q3.a);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_bnpl_agreement, (ViewGroup) null, false);
        int i = R$id.spay_slba_apiv_share_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatImageView != null) {
            i = R$id.spay_slba_fl_header_container;
            if (((FrameLayout) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                i = R$id.spay_slba_tv_btn_return_label;
                if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    i = R$id.spay_slba_tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                    if (textView != null) {
                        i = R$id.f38spay_slba_v_btn_return;
                        CardView cardView = (CardView) ViewBindings.findChildViewById(viewInflate, i);
                        if (cardView != null) {
                            i = R$id.spay_slba_wv_content;
                            WebView webView = (WebView) ViewBindings.findChildViewById(viewInflate, i);
                            if (webView != null) {
                                Km km = new Km(constraintLayout, appCompatImageView, constraintLayout, textView, cardView, webView);
                                Intrinsics.checkNotNullExpressionValue(km, "inflate(layoutInflater)");
                                return km;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
