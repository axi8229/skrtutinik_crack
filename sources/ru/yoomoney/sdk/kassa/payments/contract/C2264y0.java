package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView;
import ru.yoomoney.sdk.kassa.payments.R$drawable;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2333q;
import ru.yoomoney.sdk.kassa.payments.model.Wallet;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutAlertDialog;
import ru.yoomoney.sdk.kassa.payments.ui.ContextExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.SwitchWithDescriptionView;
import ru.yoomoney.sdk.kassa.payments.ui.SwitchWithDescriptionViewKt;
import ru.yoomoney.sdk.kassa.payments.ui.ViewExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardView;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;
import ru.yoomoney.sdk.kassa.payments.ui.view.PicassoExtensionsKt;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/contract/y0;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.y0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2264y0 extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b a;
    public P0 b;
    public ru.yoomoney.sdk.kassa.payments.navigation.c c;
    public TestParameters d;
    public ru.yoomoney.sdk.kassa.payments.metrics.F e;
    public final Lazy f = LazyKt.lazy(new C2258v0(this, new C2262x0(this)));
    public final Lazy g = LazyKt.lazy(new C2260w0(this));
    public final Lazy h = LazyKt.lazy(new C2217a0(this));
    public final Lazy i = LazyKt.lazy(new T(this));
    public final U j = new U(this);
    public ru.yoomoney.sdk.kassa.payments.databinding.c k;

    public static final RuntimeViewModel a(C2264y0 c2264y0) {
        return (RuntimeViewModel) c2264y0.f.getValue();
    }

    public final ru.yoomoney.sdk.kassa.payments.navigation.c b() {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.c;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("router");
        return null;
    }

    public final void c() throws Resources.NotFoundException {
        final float dimension = requireContext().getResources().getDimension(R$dimen.ym_elevationXS);
        a().f.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                C2264y0.a(this.f$0, dimension);
            }
        });
    }

    public final void d() {
        ConstraintLayout constraintLayout = a().s.a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
        Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
        ru.yoomoney.sdk.kassa.payments.utils.m.a(constraintLayout, true);
        a().k.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2264y0.a(this.f$0, view);
            }
        });
    }

    public final void e() throws Resources.NotFoundException {
        if (ContextExtensionsKt.isTablet(this)) {
            ViewAnimator rootContainer = a().n;
            Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
            ViewGroup.LayoutParams layoutParams = rootContainer.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.height = getResources().getDimensionPixelSize(ru.yoomoney.sdk.kassa.payments.R$dimen.ym_dialogHeight);
            rootContainer.setLayoutParams(layoutParams);
        }
        AppCompatEditText editText = a().l.getEditText();
        Intrinsics.checkNotNullParameter(editText, "<this>");
        new MaskFormatWatcher(MaskImpl.createTerminated(new PhoneNumberUnderscoreSlotsParser().parseSlots("+7 ___ ___-__-__"))).installOn(editText);
        a().l.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return C2264y0.a(this.f$0, textView, i, keyEvent);
            }
        });
        a().l.getEditText().addTextChangedListener(new C2241m0(this));
        SwitchWithDescriptionView allowWalletLinking = a().b;
        Intrinsics.checkNotNullExpressionValue(allowWalletLinking, "allowWalletLinking");
        SwitchWithDescriptionViewKt.onCheckedChangedListener(allowWalletLinking, new C2243n0(this));
        c();
        a().c.setBankCardAnalyticsLogger(new C2245o0(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) throws IOException {
        Bundle extras;
        String string;
        if (i != 14269 || i2 != -1 || intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString(BankCardViewKt.EXTRA_CARD_NUMBER);
        if (string2 != null) {
            Intrinsics.checkNotNull(string2);
            StringBuilder sb = new StringBuilder();
            int length = string2.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = string2.charAt(i3);
                if (Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else {
            string = null;
        }
        int i4 = extras.getInt(BankCardViewKt.EXTRA_EXPIRY_MONTH);
        Integer numValueOf = Integer.valueOf(i4);
        if (i4 <= 0) {
            numValueOf = null;
        }
        int i5 = extras.getInt(BankCardViewKt.EXTRA_EXPIRY_YEAR);
        Integer numValueOf2 = Integer.valueOf(i5);
        if (i5 <= 0) {
            numValueOf2 = null;
        }
        a().c.setBankCardInfo(string, numValueOf2 != null ? Integer.valueOf(numValueOf2.intValue() % 100) : null, numValueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.a aVar = ru.yoomoney.sdk.kassa.payments.di.a.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutComponent");
            aVar = null;
        }
        this.a = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) aVar.d.k.get();
        this.b = (P0) aVar.p.get();
        this.c = (ru.yoomoney.sdk.kassa.payments.navigation.c) aVar.d.h.get();
        ru.yoomoney.sdk.kassa.payments.di.component.c cVar = aVar.d;
        this.d = cVar.b;
        this.e = (ru.yoomoney.sdk.kassa.payments.metrics.F) cVar.m.get();
        super.onAttach(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0206 A[PHI: r1
  0x0206: PHI (r1v3 int) = 
  (r1v2 int)
  (r1v6 int)
  (r1v7 int)
  (r1v8 int)
  (r1v9 int)
  (r1v10 int)
  (r1v11 int)
  (r1v12 int)
  (r1v13 int)
  (r1v14 int)
  (r1v15 int)
  (r1v16 int)
  (r1v17 int)
  (r1v18 int)
  (r1v19 int)
  (r1v20 int)
  (r1v21 int)
 binds: [B:3:0x001b, B:5:0x0026, B:7:0x0031, B:9:0x003c, B:11:0x0047, B:13:0x0052, B:15:0x005d, B:17:0x0068, B:19:0x0073, B:21:0x007e, B:23:0x0086, B:25:0x0094, B:27:0x00a0, B:29:0x00b0, B:31:0x00bc, B:33:0x00c8, B:35:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onCreateView(android.view.LayoutInflater r36, android.view.ViewGroup r37, android.os.Bundle r38) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.contract.C2264y0.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        View view = getView();
        if (view != null) {
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view);
        }
        super.onDestroyView();
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.g.getValue();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        this.k = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!ContextExtensionsKt.isTablet(this)) {
            postponeEnterTransition();
        }
        super.onViewCreated(view, bundle);
        e();
        FragmentKt.setFragmentResultListener(this, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.TOKENIZE_RESULT_KEY", new V(this));
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.f.getValue();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(runtimeViewModel, viewLifecycleOwner, new W(this), new X(this), new Z(this));
    }

    public static final void c(C2264y0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.getView();
        if (view2 != null) {
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view2);
        }
        CharSequence text = this$0.a().l.getText();
        if (text != null) {
            Regex regex = ru.yoomoney.sdk.kassa.payments.extensions.d.a;
            Intrinsics.checkNotNullParameter(text, "<this>");
            if (ru.yoomoney.sdk.kassa.payments.extensions.d.a.matches(text)) {
                ((RuntimeViewModel) this$0.f.getValue()).handleAction(new C2230h(new ru.yoomoney.sdk.kassa.payments.model.n0(text.toString())));
                return;
            }
        }
        this$0.a().l.setError(" ");
    }

    public final void b(final ru.yoomoney.sdk.kassa.payments.model.Q q) {
        BankCardView bankCardView = a().c;
        bankCardView.setCardData(q.f);
        bankCardView.setChangeCardAvailable(false);
        bankCardView.hideAdditionalInfo();
        bankCardView.showBankLogo(ru.yoomoney.sdk.kassa.payments.utils.b.a(q.f, q.e));
        a().k.setEnabled(true);
        a().k.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2264y0.a(this.f$0, q, view);
            }
        });
    }

    public final ru.yoomoney.sdk.kassa.payments.databinding.c a() {
        ru.yoomoney.sdk.kassa.payments.databinding.c cVar = this.k;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static final void a(C2264y0 this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this$0.g.getValue();
            Unit unit = null;
            if (viewPropertyAnimator != null) {
                NestedScrollView nestedScrollView = this$0.a().f;
                if ((nestedScrollView != null ? Integer.valueOf(nestedScrollView.getScrollY()) : null) == null) {
                    viewPropertyAnimator = null;
                }
                if (viewPropertyAnimator != null) {
                    if (this$0.a().f.getScrollY() <= 0) {
                        f = 0.0f;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorTranslationZ = viewPropertyAnimator.translationZ(f);
                    if (viewPropertyAnimatorTranslationZ != null) {
                        viewPropertyAnimatorTranslationZ.start();
                        unit = Unit.INSTANCE;
                    }
                }
            }
            Result.m2628constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m2628constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final void d(C2264y0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.getView();
        if (view2 != null) {
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view2);
        }
        ((RuntimeViewModel) this$0.f.getValue()).handleAction(new C2230h(null));
    }

    public static final void b(C2264y0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((RuntimeViewModel) this$0.f.getValue()).handleAction(new C2230h(ru.yoomoney.sdk.kassa.payments.model.l0.a));
    }

    public final void a(final F0 f0, final Wallet wallet) {
        ConstraintLayout constraintLayout = a().y.a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
        Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
        ru.yoomoney.sdk.kassa.payments.utils.m.a(constraintLayout, true);
        TextView yooSubtitle = a().y.d;
        Intrinsics.checkNotNullExpressionValue(yooSubtitle, "yooSubtitle");
        Intrinsics.checkNotNullParameter(yooSubtitle, "<this>");
        ru.yoomoney.sdk.kassa.payments.utils.m.a(yooSubtitle, true);
        TextView yooAction = a().y.b;
        Intrinsics.checkNotNullExpressionValue(yooAction, "yooAction");
        Intrinsics.checkNotNullParameter(yooAction, "<this>");
        ru.yoomoney.sdk.kassa.payments.utils.m.a(yooAction, true);
        TextView textView = a().y.e;
        String walletId = f0.b;
        if (walletId == null) {
            walletId = wallet.getWalletId();
        }
        textView.setText(walletId);
        TextView textView2 = a().y.d;
        Amount balance = wallet.getBalance();
        Unit unit = null;
        textView2.setText(balance != null ? ru.yoomoney.sdk.kassa.payments.extensions.a.a(balance) : null);
        a().b.setChecked(f0.e);
        String str = f0.c;
        if (str != null) {
            RequestCreator requestCreatorPlaceholder = Picasso.get().load(Uri.parse(str)).placeholder(R$drawable.ym_user_avatar);
            Intrinsics.checkNotNullExpressionValue(requestCreatorPlaceholder, "placeholder(...)");
            PicassoExtensionsKt.cropToCircle(requestCreatorPlaceholder).into(a().y.c);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            a().y.c.setImageResource(R$drawable.ym_user_avatar);
        }
        a().y.b.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2264y0.a(this.f$0, f0, wallet, view);
            }
        });
    }

    public static final void a(C2264y0 this$0, F0 contractInfo, Wallet wallet, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contractInfo, "$contractInfo");
        Intrinsics.checkNotNullParameter(wallet, "$wallet");
        int i = R$string.ym_logout_dialog_message;
        String walletId = contractInfo.b;
        if (walletId == null) {
            walletId = wallet.getWalletId();
        }
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(this$0.getString(i, walletId), null, this$0.getString(R$string.ym_logout_dialog_button_positive), this$0.getString(R$string.ym_logout_dialog_button_negative), true, false, 32, null);
        CheckoutAlertDialog.Companion companion = CheckoutAlertDialog.INSTANCE;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        CheckoutAlertDialog checkoutAlertDialogCreate$default = CheckoutAlertDialog.Companion.create$default(companion, childFragmentManager, dialogContent, false, Float.valueOf(0.6f), 4, null);
        checkoutAlertDialogCreate$default.attachListener(new C2219b0(this$0));
        FragmentManager childFragmentManager2 = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        checkoutAlertDialogCreate$default.show(childFragmentManager2);
    }

    public final void a(ru.yoomoney.sdk.kassa.payments.model.Q q) {
        BankCardView bankCardView = a().c;
        Intrinsics.checkNotNull(bankCardView);
        Intrinsics.checkNotNullParameter(bankCardView, "<this>");
        ru.yoomoney.sdk.kassa.payments.utils.m.a(bankCardView, true);
        if (q == null) {
            bankCardView.setOnBankCardReadyListener(new C2221c0(this));
            bankCardView.setOnBankCardScanListener(new C2223d0(this));
        } else if (q.d) {
            BankCardView bankCardView2 = a().c;
            bankCardView2.presetBankCardInfo(q.f);
            bankCardView2.showBankLogo(ru.yoomoney.sdk.kassa.payments.utils.b.a(q.f, q.e));
            bankCardView2.setOnPresetBankCardReadyListener(new C2229g0(this, q));
        } else {
            b(q);
        }
        bankCardView.setOnBankCardNotReadyListener(new C2225e0(this));
        bankCardView.setOnBankCardScanListener(new C2227f0(this));
    }

    public static final void a(C2264y0 this$0, ru.yoomoney.sdk.kassa.payments.model.Q instrumentBankCard, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instrumentBankCard, "$instrumentBankCard");
        ((RuntimeViewModel) this$0.f.getValue()).handleAction(new C2234j(instrumentBankCard, null));
    }

    public static final void a(C2264y0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.getView();
        if (view2 != null) {
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view2);
        }
        ViewAnimator rootContainer = this$0.a().n;
        Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
        LoadingView child = this$0.a().j;
        Intrinsics.checkNotNullExpressionValue(child, "loadingView");
        Intrinsics.checkNotNullParameter(rootContainer, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        rootContainer.setDisplayedChild(rootContainer.indexOfChild(child));
        ((RuntimeViewModel) this$0.f.getValue()).handleAction(new C2230h(ru.yoomoney.sdk.kassa.payments.model.h0.a));
    }

    public final void a(C2246p c2246p, String str) {
        boolean zMatches;
        if (str != null) {
            a().l.setText(str);
        }
        if (c2246p.h instanceof ru.yoomoney.sdk.kassa.payments.model.I) {
            ConstraintLayout constraintLayout = a().r.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
            Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
            ru.yoomoney.sdk.kassa.payments.utils.m.a(constraintLayout, true);
            a().k.setEnabled(true);
            a().k.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C2264y0.b(this.f$0, view);
                }
            });
            return;
        }
        PrimaryButtonView primaryButtonView = a().k;
        CharSequence text = a().l.getText();
        if (text != null) {
            Regex regex = ru.yoomoney.sdk.kassa.payments.extensions.d.a;
            Intrinsics.checkNotNullParameter(text, "<this>");
            zMatches = ru.yoomoney.sdk.kassa.payments.extensions.d.a.matches(text);
        } else {
            zMatches = false;
        }
        primaryButtonView.setEnabled(zMatches);
        LinearLayout phoneInputContainer = a().m;
        Intrinsics.checkNotNullExpressionValue(phoneInputContainer, "phoneInputContainer");
        Intrinsics.checkNotNullParameter(phoneInputContainer, "<this>");
        ru.yoomoney.sdk.kassa.payments.utils.m.a(phoneInputContainer, true);
        a().k.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.y0$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2264y0.c(this.f$0, view);
            }
        });
    }

    public static final boolean a(C2264y0 this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = i == 6;
        if (z) {
            this$0.a().k.performClick();
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(this$0.a().l.getEditText());
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(ru.yoomoney.sdk.kassa.payments.contract.C2246p r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.contract.C2264y0.a(ru.yoomoney.sdk.kassa.payments.contract.p):void");
    }

    public final void a(C2246p c2246p, H0 h0) {
        ru.yoomoney.sdk.kassa.payments.model.Q qB;
        if (h0 instanceof F0) {
            F0 f0 = (F0) h0;
            boolean zC = f0.c();
            SwitchWithDescriptionView allowWalletLinking = a().b;
            Intrinsics.checkNotNullExpressionValue(allowWalletLinking, "allowWalletLinking");
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(allowWalletLinking, zC);
            a().b.setTitle(getString(R$string.ym_contract_link_wallet_title));
            a().b.setDescription(a().b.getContext().getString(R$string.ym_allow_wallet_linking));
            a(f0, f0.b());
            LinearLayout switches = a().v;
            Intrinsics.checkNotNullExpressionValue(switches, "switches");
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(switches, f0.c());
        } else if (h0 instanceof G0) {
            G0 g0 = (G0) h0;
            boolean zC2 = g0.c();
            SwitchWithDescriptionView allowWalletLinking2 = a().b;
            Intrinsics.checkNotNullExpressionValue(allowWalletLinking2, "allowWalletLinking");
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(allowWalletLinking2, zC2);
            a().b.setTitle(getString(R$string.ym_contract_link_wallet_title));
            a().b.setDescription(a().b.getContext().getString(R$string.ym_allow_wallet_linking));
            a().b.setChecked(true);
            String strReplace$default = StringsKt.replace$default(g0.b().getPan(), "*", "•", false, 4, (Object) null);
            EnumC2333q brand = g0.b().getBrand();
            BankCardView bankCardView = a().c;
            Intrinsics.checkNotNull(bankCardView);
            Intrinsics.checkNotNullParameter(bankCardView, "<this>");
            ru.yoomoney.sdk.kassa.payments.utils.m.a(bankCardView, true);
            bankCardView.presetBankCardInfo(strReplace$default);
            a().c.showBankLogo(ru.yoomoney.sdk.kassa.payments.utils.b.a(strReplace$default, brand));
            bankCardView.setOnPresetBankCardReadyListener(new C2231h0(this));
            bankCardView.setOnBankCardNotReadyListener(new C2233i0(this));
            LinearLayout switches2 = a().v;
            Intrinsics.checkNotNullExpressionValue(switches2, "switches");
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(switches2, g0.c());
        } else if (h0 instanceof C0) {
            C0 c0 = (C0) h0;
            String first = c0.b().getFirst();
            String last = c0.b().getLast();
            EnumC2333q brand2 = c0.b().getBrand();
            a().b.setChecked(true);
            String str = first + "••••••" + last;
            BankCardView bankCardView2 = a().c;
            Intrinsics.checkNotNull(bankCardView2);
            Intrinsics.checkNotNullParameter(bankCardView2, "<this>");
            ru.yoomoney.sdk.kassa.payments.utils.m.a(bankCardView2, true);
            bankCardView2.presetBankCardInfo(str);
            a().c.showBankLogo(ru.yoomoney.sdk.kassa.payments.utils.b.a(str, brand2));
            bankCardView2.setOnPresetBankCardReadyListener(new C2231h0(this));
            bankCardView2.setOnBankCardNotReadyListener(new C2233i0(this));
        } else {
            if (h0 instanceof A0) {
                qB = ((A0) h0).b();
            } else if (h0 instanceof B0) {
                qB = null;
            } else if (h0 instanceof E0) {
                a(c2246p, ((E0) h0).b());
            } else if (h0 instanceof C2266z0) {
                ((ru.yoomoney.sdk.kassa.payments.navigation.a) b()).a(ru.yoomoney.sdk.kassa.payments.navigation.g.a);
            } else if (h0 instanceof D0) {
                d();
            }
            a(qB);
        }
        TextView textView = a().i;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String strA = c2246p.l;
        if (strA == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            strA = R0.a(contextRequireContext);
        }
        spannableStringBuilder.append((CharSequence) ru.yoomoney.sdk.kassa.payments.utils.l.a(strA, new Q(this)));
        if (c2246p.i) {
            spannableStringBuilder.append((CharSequence) "\n");
            Context context = requireContext();
            Intrinsics.checkNotNullExpressionValue(context, "requireContext(...)");
            int i = R$string.ym_safe_payments_agreement_part_1;
            int i2 = R$string.ym_safe_payments_agreement_part_2;
            S action = new S(this);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(action, "action");
            CharSequence text = context.getText(i);
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            CharSequence text2 = context.getText(i2);
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            spannableStringBuilder.append((CharSequence) ru.yoomoney.sdk.kassa.payments.utils.l.a(text, text2, action));
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void a(Throwable th, Function0 function0) {
        ComposeView composeView = a().d;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-366823341, true, new C2252s0(this, th, function0)));
        ViewAnimator rootContainer = a().n;
        Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
        ComposeView child = a().d;
        Intrinsics.checkNotNullExpressionValue(child, "composeContainerError");
        Intrinsics.checkNotNullParameter(rootContainer, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        rootContainer.setDisplayedChild(rootContainer.indexOfChild(child));
        LoadingView loadingView = a().j;
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        ViewGroup.LayoutParams layoutParams = loadingView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        ViewAnimator rootContainer2 = a().n;
        Intrinsics.checkNotNullExpressionValue(rootContainer2, "rootContainer");
        layoutParams.height = ViewExtensionsKt.getViewHeight(rootContainer2);
        loadingView.setLayoutParams(layoutParams);
    }
}
