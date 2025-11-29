package ru.yoomoney.sdk.kassa.payments.userAuth;

import android.content.Context;
import android.content.Intent;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.Style;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

/* loaded from: classes5.dex */
public final /* synthetic */ class M extends FunctionReferenceImpl implements Function1 {
    public M(Object obj) {
        super(1, obj, T.class, "showState", "showState(Lru/yoomoney/sdk/kassa/payments/userAuth/MoneyAuth$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AbstractC2554q p0 = (AbstractC2554q) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        T t = (T) this.receiver;
        int i = T.$r8$clinit;
        t.getClass();
        if (p0 instanceof C2550m) {
            AbstractC2549l abstractC2549l = ((C2550m) p0).a;
            if (abstractC2549l instanceof C2548k) {
                YooMoneyAuth yooMoneyAuth = YooMoneyAuth.INSTANCE;
                yooMoneyAuth.initAnalyticsLogger(new L(t));
                Config.Origin origin = Config.Origin.WALLET;
                Config.ProcessType processType = Config.ProcessType.LOGIN;
                PaymentParameters paymentParameters = t.c;
                if (paymentParameters == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentParameters");
                    paymentParameters = null;
                }
                String authCenterClientId = paymentParameters.getAuthCenterClientId();
                if (authCenterClientId == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                TestParameters testParameters = t.d;
                if (testParameters == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("testParameters");
                    testParameters = null;
                }
                String yandexClientId = testParameters.getYandexClientId();
                ru.yoomoney.sdk.kassa.payments.http.a aVar = t.e;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
                    aVar = null;
                }
                String strA = ((ru.yoomoney.sdk.kassa.payments.http.b) aVar).a();
                if (strA == null || strA.length() == 0) {
                    strA = "https://yoomoney.ru";
                }
                String str = strA;
                ru.yoomoney.sdk.kassa.payments.http.a aVar2 = t.e;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
                    aVar2 = null;
                }
                String strA2 = ((ru.yoomoney.sdk.kassa.payments.http.b) aVar2).a();
                boolean z = !(strA2 == null || strA2.length() == 0);
                String string = t.getString(R$string.ym_support_email);
                String string2 = t.getString(R$string.ym_support_help_url);
                String string3 = t.getString(R$string.ym_support_phone);
                Context contextRequireContext = t.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                String strA3 = ru.yoomoney.sdk.kassa.payments.http.l.a(contextRequireContext);
                Style style = new Style(ThemeScheme.Companion.byAccentColor$default(ThemeScheme.INSTANCE, InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor(), null, null, 6, null), null, 2, null);
                String string4 = t.getString(R.string.auth_remote_config_offer_no_email);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String string5 = t.getString(R.string.auth_remote_config_offer_has_email);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                RemoteConfig remoteConfig = new RemoteConfig(false, string4, string5, true, null, null, t.getString(R.string.auth_soft_migration_title), t.getString(R.string.auth_soft_migration_subtitle), t.getString(R.string.auth_soft_migration_action_subtitle), t.getString(R.string.auth_hard_migration_title), t.getString(R.string.auth_hard_migration_subtitle), t.getString(R.string.auth_hard_migration_action_subtitle), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4048, 15, null);
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string3);
                Config config = new Config(origin, authCenterClientId, null, yandexClientId, null, null, processType, null, null, style, str, z, string, string2, string3, false, null, null, null, null, strA3, remoteConfig, null, false, null, null, false, false, null, null, null, false, -3210828, null);
                Context contextRequireContext2 = t.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                t.startActivityForResult(yooMoneyAuth.auth(contextRequireContext2, config), 1);
            } else if (abstractC2549l instanceof C2547j) {
                t.startActivityForResult((Intent) t.f.getValue(), 317);
            }
        } else if (Intrinsics.areEqual(p0, C2552o.a)) {
            FragmentKt.setFragmentResult(t, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_EXTRA", ru.yoomoney.sdk.kassa.payments.navigation.f.a)));
        } else if (Intrinsics.areEqual(p0, C2551n.a)) {
            FragmentKt.setFragmentResult(t, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_EXTRA", ru.yoomoney.sdk.kassa.payments.navigation.f.b)));
        } else {
            Intrinsics.areEqual(p0, C2553p.a);
        }
        return Unit.INSTANCE;
    }
}
