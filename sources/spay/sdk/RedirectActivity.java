package spay.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import dagger.internal.Preconditions;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import npi.spay.C1502bn;
import npi.spay.C1620gg;
import npi.spay.C1678j0;
import npi.spay.C1895ri;
import npi.spay.C1929t2;
import npi.spay.C1955u3;
import npi.spay.C1975un;
import npi.spay.C1993vg;
import npi.spay.Di;
import npi.spay.E4;
import npi.spay.Ei;
import npi.spay.F9;
import npi.spay.Gk;
import npi.spay.Ih;
import npi.spay.InterfaceC1495bg;
import npi.spay.InterfaceC1626gm;
import npi.spay.InterfaceC1728l0;
import npi.spay.Jh;
import npi.spay.N9;
import npi.spay.On;
import npi.spay.Pj;
import npi.spay.Qb;
import npi.spay.Qg;
import npi.spay.Ql;
import npi.spay.W0;
import npi.spay.W6;
import npi.spay.X6;
import npi.spay.Y6;
import npi.spay.Z6;
import npi.spay.Zf;
import sberid.sdk.auth.login.SberIDLoginManager;
import spay.sdk.api.MerchantError;
import spay.sdk.api.PaymentResult;
import spay.sdk.b;
import spay.sdk.domain.model.PaymentModel;
import spay.sdk.domain.model.response.ErrorEntity;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lspay/sdk/RedirectActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class RedirectActivity extends AppCompatActivity {
    public static final /* synthetic */ int g = 0;
    public Ql a;
    public a b;
    public W0 c;
    public Ih d;
    public F9 e;
    public Gk f;

    public final void a() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: spay.sdk.RedirectActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                RedirectActivity.a(this.f$0, thread, th);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Timber.INSTANCE.i("onConfigurationChanged " + newConfig, new Object[0]);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        N9 n9 = b.a.b;
        a aVar = null;
        byte b = 0;
        byte b2 = 0;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.b0.get();
            Ih ih = (Ih) pj.d.g.get();
            C1955u3 c1955u3B = pj.d.b();
            InterfaceC1626gm interfaceC1626gm = (InterfaceC1626gm) pj.x.get();
            Qb qb = (Qb) pj.d.v.get();
            pj.a.getClass();
            this.c = new W0(ih, c1955u3B, interfaceC1626gm, qb, (SberIDLoginManager) Preconditions.checkNotNullFromProvides(new SberIDLoginManager(b2 == true ? 1 : 0, 1, b == true ? 1 : 0)), (InterfaceC1495bg) pj.j.get(), (InterfaceC1728l0) pj.d.s.get());
            this.d = (Ih) pj.d.g.get();
            C1620gg c1620gg = pj.b;
            Context context = pj.d.a;
            c1620gg.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            this.e = (F9) Preconditions.checkNotNullFromProvides(new F9(context));
            C1895ri c1895ri = pj.c;
            Ih dataContract = (Ih) pj.d.g.get();
            Ei sPayStorage = (Ei) pj.e.get();
            C1993vg featuresHandler = (C1993vg) pj.d.i.get();
            Qb authHandler = (Qb) pj.d.v.get();
            c1895ri.getClass();
            Intrinsics.checkNotNullParameter(dataContract, "dataContract");
            Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
            Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
            Intrinsics.checkNotNullParameter(authHandler, "authHandler");
            this.f = (Gk) Preconditions.checkNotNullFromProvides(new Gk(dataContract, sPayStorage, featuresHandler, authHandler));
        }
        if (this.a != null) {
            Ql ql = this.a;
            if (ql == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                ql = null;
            }
            this.b = (a) new ViewModelProvider(this, ql).get(a.class);
        } else {
            Function1<? super PaymentResult, Unit> function1 = b.a.d;
            if (function1 != null) {
                Ih ih2 = this.d;
                if (ih2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sPayDataContract");
                    ih2 = null;
                }
                function1.invoke(new PaymentResult.Error((String) FlowKt.asStateFlow(((Di) ih2).B).getValue(), new MerchantError.UnexpectedError("Ошибка внутренних компонентов SPaySdk")));
            }
            finish();
        }
        super.onCreate(bundle);
        if (this.b != null) {
            a();
            a aVar2 = this.b;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar2 = null;
            }
            Flow flowFilterNotNull = FlowKt.filterNotNull(aVar2.y);
            Lifecycle.State state = Lifecycle.State.STARTED;
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1678j0(this, state, flowFilterNotNull, null, this), 3, null);
            a aVar3 = this.b;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar3 = null;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1929t2(this, state, FlowKt.asStateFlow(aVar3.v), null, this), 3, null);
            a aVar4 = this.b;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                aVar = aVar4;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new E4(this, state, FlowKt.filterNotNull(FlowKt.asStateFlow(aVar.z)), null, this), 3, null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        a aVar = this.b;
        if (aVar != null) {
            ((C1502bn) aVar.l).b = false;
        }
        Gk gk = this.f;
        if (gk != null) {
            gk.a(true);
        }
        super.onDestroy();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Object payStatus;
        Z6 w6;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Parcelable parcelableExtra = intent.getParcelableExtra("PAYMENT_RESULT");
        PaymentResult paymentResult = parcelableExtra instanceof PaymentResult ? (PaymentResult) parcelableExtra : null;
        if (paymentResult != null) {
            a aVar = this.b;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar = null;
            }
            Intrinsics.checkNotNullParameter(paymentResult, "<this>");
            if (paymentResult instanceof PaymentResult.Error) {
                payStatus = new W6(ErrorEntity.Unknown.INSTANCE);
            } else if (paymentResult instanceof PaymentResult.Processing) {
                payStatus = X6.a;
            } else if (paymentResult instanceof PaymentResult.Success) {
                payStatus = Y6.a;
            } else {
                if (!(paymentResult instanceof PaymentResult.Cancel)) {
                    throw new NoWhenBranchMatchedException();
                }
                payStatus = new W6(ErrorEntity.CanceledByUser.INSTANCE);
            }
            aVar.getClass();
            Intrinsics.checkNotNullParameter(payStatus, "payStatus");
            if (payStatus instanceof W6) {
                w6 = new W6(((W6) payStatus).a);
            } else if (payStatus instanceof X6) {
                w6 = X6.a;
            } else {
                if (!(payStatus instanceof Y6)) {
                    throw new NoWhenBranchMatchedException();
                }
                w6 = Y6.a;
            }
            ((Jh) aVar.m).a(new On(w6));
        }
        if (paymentResult != null) {
            return;
        }
        Parcelable parcelableExtra2 = intent.getParcelableExtra("PAYMENT_DATA");
        PaymentModel paymentData = parcelableExtra2 instanceof PaymentModel ? (PaymentModel) parcelableExtra2 : null;
        if (paymentData != null) {
            a aVar2 = this.b;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar2 = null;
            }
            aVar2.getClass();
            Intrinsics.checkNotNullParameter(paymentData, "paymentData");
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(aVar2), null, null, new Zf(aVar2, paymentData, null), 3, null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        a aVar = this.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        C1502bn c1502bn = (C1502bn) aVar.l;
        if (c1502bn.b) {
            return;
        }
        ((Jh) c1502bn.a).a(C1975un.a);
        c1502bn.b = true;
    }

    public static final void a(RedirectActivity this$0, Thread thread, Throwable exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(exception, "exception");
        aVar.getClass();
        Intrinsics.checkNotNullParameter(exception, "exception");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(aVar), null, null, new Qg(aVar, exception, null), 3, null);
    }
}
