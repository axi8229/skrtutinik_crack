package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
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
import spay.sdk.view.CardLogoCompositeView;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/mi;", "Lnpi/spay/Z7;", "Lnpi/spay/Jj;", "Lnpi/spay/eg;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.mi, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1771mi extends Z7<Jj, C1570eg> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final void a(C1570eg this_with, C1771mi this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_with.e.setEnabled(z);
        ((Jj) this$0.b()).a(new C1708k5(z));
    }

    public static final void b(C1771mi this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Jj) this$0.b()).a(C1609g5.a);
    }

    public static final void c(C1771mi this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Jj) this$0.b()).a(C1683j5.a);
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        final C1570eg c1570eg = (C1570eg) viewBinding;
        c1570eg.e.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.mi$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1771mi.a(this.f$0, view);
            }
        });
        c1570eg.b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.mi$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1771mi.b(this.f$0, view);
            }
        });
        c1570eg.c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.mi$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1771mi.c(this.f$0, view);
            }
        });
        c1570eg.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: npi.spay.mi$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C1771mi.a(c1570eg, this, compoundButton, z);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).k0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        C1570eg c1570eg = (C1570eg) viewBinding;
        Flow flowFilterNotNull = FlowKt.filterNotNull(((Jj) b()).m);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Th(this, state, flowFilterNotNull, null, c1570eg), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Wh(this, state, FlowKt.filterNotNull(((Jj) b()).q), null, c1570eg), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Zh(this, state, FlowKt.filterNotNull(((Jj) b()).n), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1522ci(this, state, FlowKt.filterNotNull(((Jj) b()).r), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1597fi(this, state, FlowKt.filterNotNull(((Jj) b()).p), null, c1570eg, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1671ii(this, state, ((Jj) b()).j, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1746li(this, state, ((Jj) b()).k, null, c1570eg), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() {
        d();
    }

    public static final void a(C1771mi this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Jj) this$0.b()).a(C1634h5.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Jj.class;
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewFindChildViewById;
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_parts_order_bnpl, (ViewGroup) null, false);
        int i = R$id.spay_cancel_btn;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
        if (materialButton != null) {
            i = R$id.spay_card_selection_button;
            CardView cardView = (CardView) ViewBindings.findChildViewById(viewInflate, i);
            if (cardView != null) {
                i = R$id.spay_commission;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatTextView != null) {
                    i = R$id.spay_pay_parts_btn;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton2 != null) {
                        i = R$id.spay_payments_list;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i);
                        if (recyclerView != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, (i = R$id.spay_slo_include_compound_wallet))) != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindChildViewById;
                            int i2 = R$id.spay_silcw_compound_wallet_iv_more_cards;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                            if (appCompatImageView != null) {
                                i2 = R$id.spay_silcw_tv_wallet_amount;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                                if (appCompatTextView2 != null) {
                                    i2 = R$id.spay_silcw_tv_wallet_card_info;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                                    if (appCompatTextView3 != null) {
                                        i2 = R$id.spay_silcw_wallet_logo_cv;
                                        CardLogoCompositeView cardLogoCompositeView = (CardLogoCompositeView) ViewBindings.findChildViewById(viewFindChildViewById, i2);
                                        if (cardLogoCompositeView != null) {
                                            C1500bl c1500bl = new C1500bl(appCompatImageView, appCompatTextView2, appCompatTextView3, constraintLayout, cardLogoCompositeView);
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
                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById2, i4);
                                                        if (appCompatTextView4 != null) {
                                                            i4 = R$id.spay_silsc_tv_card_title;
                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById2, i4);
                                                            if (appCompatTextView5 != null) {
                                                                Bl bl = new Bl(appCompatImageView2, appCompatTextView4, appCompatTextView5, constraintLayout2, cardLogoCompositeView2);
                                                                i3 = R$id.spay_slo_inlude_no_card_error;
                                                                View viewFindChildViewById3 = ViewBindings.findChildViewById(viewInflate, i3);
                                                                if (viewFindChildViewById3 != null) {
                                                                    int i5 = R$id.spay_silnc_iv_alert_image;
                                                                    if (((AppCompatImageView) ViewBindings.findChildViewById(viewFindChildViewById3, i5)) != null) {
                                                                        i5 = R$id.spay_silnc_tv_choose_another_way;
                                                                        if (((AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById3, i5)) != null) {
                                                                            i5 = R$id.spay_silnc_tv_no_card_text;
                                                                            if (((AppCompatTextView) ViewBindings.findChildViewById(viewFindChildViewById3, i5)) != null) {
                                                                                i3 = R$id.spay_slob_actv_agreement_conditions;
                                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                if (appCompatTextView6 != null) {
                                                                                    i3 = R$id.spay_slob_actv_header;
                                                                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                    if (appCompatTextView7 != null) {
                                                                                        i3 = R$id.spay_slob_actv_total;
                                                                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                        if (appCompatTextView8 != null) {
                                                                                            i3 = R$id.spay_slob_chck_agreement_conditions;
                                                                                            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(viewInflate, i3);
                                                                                            if (appCompatCheckBox != null) {
                                                                                                i3 = R$id.spay_slob_fl_total;
                                                                                                if (((FrameLayout) ViewBindings.findChildViewById(viewInflate, i3)) != null) {
                                                                                                    i3 = R$id.spay_slob_root;
                                                                                                    if (((ConstraintLayout) ViewBindings.findChildViewById(viewInflate, i3)) != null) {
                                                                                                        C1570eg c1570eg = new C1570eg((NestedScrollView) viewInflate, materialButton, cardView, appCompatTextView, materialButton2, recyclerView, c1500bl, bl, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatCheckBox);
                                                                                                        Intrinsics.checkNotNullExpressionValue(c1570eg, "inflate(layoutInflater)");
                                                                                                        return c1570eg;
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
