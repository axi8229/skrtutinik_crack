package npi.spay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;
import spay.sdk.view.BnplButtonCompositeView;
import spay.sdk.view.CardLogoCompositeView;
import spay.sdk.view.SpayBnplGraphCompositeView;
import spay.sdk.view.SpayBonusOverallCompositeView;
import spay.sdk.view.SpayUserDataCompositeView;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/td;", "Lnpi/spay/Z7;", "Lnpi/spay/Xf;", "Lnpi/spay/nc;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.td, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1940td extends Z7<Xf, C1790nc> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public C1989vc d;
    public Ch e;
    public C1866qd f;

    public static final void a(C1940td this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Xf) this$0.b()).a(C1891re.a);
    }

    public static final void b(C1940td this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Xf) this$0.b()).a(C1842pe.a);
    }

    public static final void c(C1940td this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Xf) this$0.b()).a(C1817oe.a);
    }

    public static final void d(C1940td this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Xf) this$0.b()).a(C1916se.a);
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.d0.get();
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
        C1790nc c1790nc = (C1790nc) viewBinding;
        Flow flowFilterNotNull = FlowKt.filterNotNull(((Xf) b()).q);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Oc(this, state, flowFilterNotNull, null, c1790nc, contextRequireContext, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Uc(this, state, ((Xf) b()).s, null, c1790nc), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Xc(this, state, FlowKt.filterNotNull(((Xf) b()).p), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1467ad(this, state, FlowKt.filterNotNull(((Xf) b()).t), null, c1790nc, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1542dd(this, state, FlowKt.filterNotNull(((Xf) b()).r), null, c1790nc), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1617gd(this, state, FlowKt.filterNotNull(((Xf) b()).v), null, c1790nc), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1691jd(this, state, FlowKt.filterNotNull(((Xf) b()).x), null, c1790nc, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1766md(this, state, null, FlowKt.filterNotNull(((Xf) b()).z), c1790nc, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1841pd(this, state, null, ((Xf) b()).B, c1790nc, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Rc(this, state, ((Xf) b()).n, null, c1790nc), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() throws IllegalStateException {
        this.f = new C1866qd();
        this.d = new C1989vc(new Ea(), new M9());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        RecyclerView recyclerView = ((C1790nc) viewBinding).h;
        recyclerView.setLayoutManager(linearLayoutManager);
        C1989vc c1989vc = this.d;
        if (c1989vc == null) {
            Intrinsics.throwUninitializedPropertyAccessException("amountAdapter");
            c1989vc = null;
        }
        recyclerView.setAdapter(c1989vc);
        C1890rd snapListener = new C1890rd(this);
        Intrinsics.checkNotNullParameter(snapListener, "snapListener");
        new Xj(snapListener).attachToRecyclerView(recyclerView);
        Ch ch = new Ch(new C1568ee(), new C1915sd(this));
        this.e = ch;
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding2).i.setAdapter(ch);
        d();
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((Xf) b()).a(C1966ue.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        ((Xf) b()).a(C1991ve.a);
        super.onStop();
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewFindChildViewById;
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_order, (ViewGroup) null, false);
        int i = R$id.spay_slo_acb_cancel;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatButton != null) {
            i = R$id.spay_slo_composite_btn_bnpl;
            BnplButtonCompositeView bnplButtonCompositeView = (BnplButtonCompositeView) ViewBindings.findChildViewById(viewInflate, i);
            if (bnplButtonCompositeView != null) {
                i = R$id.spay_slo_cv_card_selection_button;
                CardView cardView = (CardView) ViewBindings.findChildViewById(viewInflate, i);
                if (cardView != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i = R$id.spay_slo_include_compound_wallet))) != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) viewFindChildViewById;
                    int i2 = R$id.spay_silcw_compound_wallet_iv_more_cards;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                    if (appCompatImageView != null) {
                        i2 = R$id.spay_silcw_tv_wallet_amount;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                        if (appCompatTextView != null) {
                            i2 = R$id.spay_silcw_tv_wallet_card_info;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                            if (appCompatTextView2 != null) {
                                i2 = R$id.spay_silcw_wallet_logo_cv;
                                CardLogoCompositeView cardLogoCompositeView = (CardLogoCompositeView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                                if (cardLogoCompositeView != null) {
                                    C1500bl c1500bl = new C1500bl(appCompatImageView, appCompatTextView, appCompatTextView2, constraintLayout, cardLogoCompositeView);
                                    int i3 = R$id.spay_slo_include_selected_card;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, i3);
                                    if (viewFindChildViewById2 != null) {
                                        int i4 = R$id.spay_silsc_card_logo_cv;
                                        CardLogoCompositeView cardLogoCompositeView2 = (CardLogoCompositeView) ViewBindings.findChildViewById(viewFindChildViewById2, i4);
                                        if (cardLogoCompositeView2 != null) {
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindChildViewById2;
                                            i4 = R$id.spay_silsc_iv_more_cards;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(viewFindChildViewById2, i4);
                                            if (appCompatImageView2 != null) {
                                                i4 = R$id.spay_silsc_tv_card_description;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById2, i4);
                                                if (appCompatTextView3 != null) {
                                                    i4 = R$id.spay_silsc_tv_card_title;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById2, i4);
                                                    if (appCompatTextView4 != null) {
                                                        Bl bl = new Bl(appCompatImageView2, appCompatTextView3, appCompatTextView4, constraintLayout2, cardLogoCompositeView2);
                                                        i3 = R$id.spay_slo_inlude_no_card_error;
                                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(viewInflate, i3);
                                                        if (viewFindChildViewById3 != null) {
                                                            int i5 = R$id.spay_silnc_iv_alert_image;
                                                            if (((AppCompatImageView) ViewBindings.findChildViewById(viewFindChildViewById3, i5)) != null) {
                                                                i5 = R$id.spay_silnc_tv_choose_another_way;
                                                                if (((AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById3, i5)) != null) {
                                                                    i5 = R$id.spay_silnc_tv_no_card_text;
                                                                    if (((AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById3, i5)) != null) {
                                                                        i3 = R$id.spay_slo_mb_pay;
                                                                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i3);
                                                                        if (materialButton != null) {
                                                                            i3 = R$id.spay_slo_root;
                                                                            if (((ConstraintLayout) ViewBindings.findChildViewById(viewInflate, i3)) != null) {
                                                                                i3 = R$id.spay_slo_rv_amount;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                if (recyclerView != null) {
                                                                                    i3 = R$id.spay_slo_rv_hint_helper;
                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                    if (recyclerView2 != null) {
                                                                                        i3 = R$id.spay_slo_sbgcv_graph;
                                                                                        SpayBnplGraphCompositeView spayBnplGraphCompositeView = (SpayBnplGraphCompositeView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                        if (spayBnplGraphCompositeView != null) {
                                                                                            i3 = R$id.spay_slo_sbocv_bonus;
                                                                                            SpayBonusOverallCompositeView spayBonusOverallCompositeView = (SpayBonusOverallCompositeView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                            if (spayBonusOverallCompositeView != null) {
                                                                                                i3 = R$id.spay_slo_sudcv_user_data;
                                                                                                SpayUserDataCompositeView spayUserDataCompositeView = (SpayUserDataCompositeView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                                if (spayUserDataCompositeView != null) {
                                                                                                    i3 = R$id.spay_slo_tv_client_name;
                                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                                    if (appCompatTextView5 != null) {
                                                                                                        C1790nc c1790nc = new C1790nc((NestedScrollView) viewInflate, appCompatButton, bnplButtonCompositeView, cardView, c1500bl, bl, materialButton, recyclerView, recyclerView2, spayBnplGraphCompositeView, spayBonusOverallCompositeView, spayUserDataCompositeView, appCompatTextView5);
                                                                                                        Intrinsics.checkNotNullExpressionValue(c1790nc, "inflate(layoutInflater)");
                                                                                                        return c1790nc;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindChildViewById3.getResources().getResourceName(i5)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindChildViewById2.getResources().getResourceName(i4)));
                                    }
                                    i = i3;
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindChildViewById.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Xf.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding).g.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.td$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1940td.a(this.f$0, view);
            }
        });
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding2).b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.td$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1940td.b(this.f$0, view);
            }
        });
        ViewBinding viewBinding3 = this.c;
        if (viewBinding3 == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding3).c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.td$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1940td.c(this.f$0, view);
            }
        });
        ViewBinding viewBinding4 = this.c;
        if (viewBinding4 == null) {
            throw C2040xd.a;
        }
        ((C1790nc) viewBinding4).d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.td$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1940td.d(this.f$0, view);
            }
        });
    }
}
