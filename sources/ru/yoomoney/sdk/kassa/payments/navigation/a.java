package ru.yoomoney.sdk.kassa.payments.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;
import ru.yoomoney.sdk.kassa.payments.contract.C2264y0;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.PaymentIdCscConfirmation;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.SBP;
import ru.yoomoney.sdk.kassa.payments.model.SberBank;
import ru.yoomoney.sdk.kassa.payments.model.x0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.C2382m;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.O0;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2487j0;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2505q;
import ru.yoomoney.sdk.kassa.payments.ui.BottomSheetFragmentTransition;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;
import ru.yoomoney.sdk.kassa.payments.ui.ContextExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.userAuth.C2545h;
import ru.yoomoney.sdk.kassa.payments.userAuth.T;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class a implements c {
    public final boolean a;
    public FragmentManager b;
    public FragmentActivity c;

    public a(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = z;
    }

    public final void a(v screen) {
        ru.yoomoney.sdk.kassa.payments.unbind.ui.g gVar;
        PaymentMethodType paymentMethodType;
        List<Fragment> fragments;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (ru.yoomoney.sdk.kassa.payments.utils.d.a() && this.a) {
            Log.d(b.a, "Navigating to " + screen);
        }
        FragmentManager fragmentManager = this.b;
        fragmentManager = null;
        FragmentManager fragmentManager2 = null;
        Fragment fragment = (fragmentManager == null || (fragments = fragmentManager.getFragments()) == null) ? null : (Fragment) CollectionsKt.lastOrNull((List) fragments);
        if (screen instanceof e) {
            if (fragment == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i = C2264y0.$r8$clinit;
            e eVar = (e) screen;
            int i2 = eVar.a;
            String str = eVar.b;
            C2264y0 c2264y0 = new C2264y0();
            c2264y0.setArguments(BundleKt.bundleOf(TuplesKt.to("PAYMENT_METHOD_ID", Integer.valueOf(i2)), TuplesKt.to("INSTRUMENT_ID", str)));
            a(fragment, c2264y0, "contractFragment");
            return;
        }
        if (screen instanceof j) {
            FragmentManager fragmentManager3 = this.b;
            if (fragmentManager3 != null) {
                Fragment fragmentFindFragmentByTag = fragmentManager3.findFragmentByTag("paymentOptionListFragment");
                Intrinsics.checkNotNull(fragmentFindFragmentByTag, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.paymentOptionList.PaymentOptionListFragment");
                C2487j0 c2487j0 = (C2487j0) fragmentFindFragmentByTag;
                if (c2487j0.isHidden()) {
                    if (!fragmentManager3.isStateSaved() && c2487j0.isAdded()) {
                        fragmentManager2 = fragmentManager3;
                    }
                    if (fragmentManager2 != null) {
                        fragmentManager2.popBackStack();
                    }
                }
                ((RuntimeViewModel) c2487j0.e.getValue()).handleAction(C2505q.a);
                return;
            }
            return;
        }
        if (screen instanceof g) {
            FragmentManager fragmentManager4 = this.b;
            LifecycleOwner lifecycleOwnerFindFragmentByTag = fragmentManager4 != null ? fragmentManager4.findFragmentByTag("authFragment") : null;
            T t = lifecycleOwnerFindFragmentByTag instanceof T ? (T) lifecycleOwnerFindFragmentByTag : null;
            if (t != null) {
                RuntimeViewModel runtimeViewModel = (RuntimeViewModel) t.g.getValue();
                FragmentActivity fragmentActivityRequireActivity = t.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                Intent intent = (Intent) t.f.getValue();
                Intrinsics.checkNotNullParameter(fragmentActivityRequireActivity, "<this>");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity.getPackageManager().queryIntentActivities(intent, pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1), "queryIntentActivities(...)");
                runtimeViewModel.handleAction(new C2545h(!r1.isEmpty()));
                return;
            }
            return;
        }
        if (screen instanceof o) {
            if (fragment == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i3 = ru.yoomoney.sdk.kassa.payments.tokenize.ui.n.$r8$clinit;
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.i tokenizeInputModel = ((o) screen).a;
            Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
            ru.yoomoney.sdk.kassa.payments.tokenize.ui.n nVar = new ru.yoomoney.sdk.kassa.payments.tokenize.ui.n();
            Bundle bundle = new Bundle();
            bundle.putParcelable("tokenizeInputModel", tokenizeInputModel);
            nVar.setArguments(bundle);
            a(fragment, nVar, "tokenizeFragment");
            return;
        }
        if (screen instanceof q) {
            q qVar = (q) screen;
            Intent intentPutExtra = new Intent().putExtra(CheckoutActivityKt.EXTRA_PAYMENT_TOKEN, qVar.a.a);
            ru.yoomoney.sdk.kassa.payments.model.T t2 = qVar.a.b;
            Intrinsics.checkNotNullParameter(t2, "<this>");
            if (t2 instanceof BankCardPaymentOption) {
                paymentMethodType = PaymentMethodType.BANK_CARD;
            } else if (t2 instanceof x0) {
                paymentMethodType = PaymentMethodType.YOO_MONEY;
            } else if (t2 instanceof SberBank) {
                paymentMethodType = PaymentMethodType.SBERBANK;
            } else if (t2 instanceof SBP) {
                paymentMethodType = PaymentMethodType.SBP;
            } else {
                if (!(t2 instanceof PaymentIdCscConfirmation)) {
                    throw new NoWhenBranchMatchedException();
                }
                paymentMethodType = PaymentMethodType.BANK_CARD;
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra("ru.yoomoney.sdk.kassa.payments.extra.PAYMENT_METHOD_TYPE", paymentMethodType);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra2, "putExtra(...)");
            FragmentActivity fragmentActivity = this.c;
            if (fragmentActivity != null) {
                fragmentActivity.setResult(-1, intentPutExtra2);
                fragmentActivity.finish();
                return;
            }
            return;
        }
        if (screen instanceof p) {
            FragmentActivity fragmentActivity2 = this.c;
            if (fragmentActivity2 != null) {
                fragmentActivity2.setResult(0);
                fragmentActivity2.finish();
                return;
            }
            return;
        }
        if (screen instanceof i) {
            if (fragment == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i4 = O0.$r8$clinit;
            i iVar = (i) screen;
            Amount amount = iVar.a;
            boolean z = iVar.b;
            Intrinsics.checkNotNullParameter(amount, "amount");
            O0 o0 = new O0();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.AMOUNT_KEY", amount);
            bundle2.putBoolean("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.LINK_WALLET_KEY", z);
            o0.setArguments(bundle2);
            a(fragment, o0, "paymentAuthFragment");
            return;
        }
        if (screen instanceof u) {
            if (fragment == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i5 = ru.yoomoney.sdk.kassa.payments.unbind.ui.g.$r8$clinit;
            ru.yoomoney.sdk.kassa.payments.model.T t3 = ((u) screen).a;
            Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.model.LinkedCard");
            LinkedCard linkedCard = (LinkedCard) t3;
            Intrinsics.checkNotNullParameter(linkedCard, "linkedCard");
            gVar = new ru.yoomoney.sdk.kassa.payments.unbind.ui.g();
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("ru.yoomoney.sdk.kassa.payments.unbind.PAYMENT_OPTION_LINKED_CARD", linkedCard);
            gVar.setArguments(bundle3);
        } else {
            if (!(screen instanceof t)) {
                if ((screen instanceof k) || Intrinsics.areEqual(screen, m.a)) {
                    FragmentActivity fragmentActivity3 = this.c;
                    if (fragmentActivity3 != null) {
                        fragmentActivity3.setResult(-1);
                        fragmentActivity3.finish();
                        return;
                    }
                    return;
                }
                if (screen instanceof l) {
                    FragmentActivity fragmentActivity4 = this.c;
                    if (fragmentActivity4 != null) {
                        fragmentActivity4.setResult(1, new Intent().putExtra(Checkout.EXTRA_ERROR_CODE, Integer.MIN_VALUE).putExtra(Checkout.EXTRA_ERROR_DESCRIPTION, ((l) screen).a));
                        fragmentActivity4.finish();
                        return;
                    }
                    return;
                }
                if (screen instanceof d) {
                    if (fragment == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    int i6 = C2382m.$r8$clinit;
                    d dVar = (d) screen;
                    String confirmationUrl = dVar.a;
                    String paymentId = dVar.b;
                    Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
                    Intrinsics.checkNotNullParameter(paymentId, "paymentId");
                    C2382m c2382m = new C2382m();
                    c2382m.setArguments(BundleKt.bundleOf(TuplesKt.to("CONFIRMATION_URL_KEY", confirmationUrl), TuplesKt.to("PAYMENT_ID_KEY", paymentId)));
                    a(fragment, c2382m, "listBanksFragment");
                    return;
                }
                return;
            }
            if (fragment == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            int i7 = ru.yoomoney.sdk.kassa.payments.unbind.ui.g.$r8$clinit;
            Q instrumentBankCard = ((t) screen).a;
            Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
            gVar = new ru.yoomoney.sdk.kassa.payments.unbind.ui.g();
            Bundle bundle4 = new Bundle();
            bundle4.putParcelable("ru.yoomoney.sdk.kassa.payments.unbind.PAYMENT_OPTION_INSTRUMENT", instrumentBankCard);
            gVar.setArguments(bundle4);
        }
        a(fragment, gVar, "unbindCardFragment");
    }

    public final void a(Fragment fragment, Fragment fragment2, String str) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionAddToBackStack;
        View viewRequireView = fragment.requireView();
        Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
        FragmentManager fragmentManager = this.b;
        if (fragmentManager == null || (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) == null) {
            return;
        }
        Context contextRequireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (!ContextExtensionsKt.isTablet(contextRequireContext) && viewRequireView.getTransitionName() != null) {
            fragmentTransactionBeginTransaction.addSharedElement(viewRequireView, viewRequireView.getTransitionName());
            fragmentTransactionBeginTransaction.setReorderingAllowed(true);
            fragment2.setSharedElementEnterTransition(new BottomSheetFragmentTransition());
        }
        FragmentTransaction fragmentTransactionReplace = fragmentTransactionBeginTransaction.replace(R$id.containerBottomSheet, fragment2, str);
        if (fragmentTransactionReplace == null || (fragmentTransactionAddToBackStack = fragmentTransactionReplace.addToBackStack(fragment2.getClass().getName())) == null) {
            return;
        }
        fragmentTransactionAddToBackStack.commit();
    }
}
