package sputnik.axmor.com.sputnik.ui.main.help;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.ViewKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.AboutBody;
import com.sputnik.common.entities.localization.AboutLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.localization.LocalizationStorage;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentAboutBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: AboutAppFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/help/AboutAppFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "url", "", "openLink", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentAboutBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentAboutBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AboutAppFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AboutAppFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentAboutBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    public AboutAppFragment() {
        super(R.layout.fragment_about);
        this.binding = new ViewBindingFragmentDelegate(this, AboutAppFragment$binding$2.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutAppFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                return ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.root_nav_host_fragment);
            }
        });
    }

    private final FragmentAboutBinding getBinding() {
        return (FragmentAboutBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        LocalizationLocalModel data;
        AboutLocale about;
        AboutBody body;
        String copyrightLabel;
        AboutLocale about2;
        AboutBody body2;
        String subtitle;
        FragmentAboutBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNull(toolbar);
        ToolbarKt.setupWithNavController$default(toolbar, ViewKt.findNavController(toolbar), null, 2, null);
        com.sputnik.common.extensions.ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        com.sputnik.common.extensions.ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (about2 = data2.getAbout()) != null && (body2 = about2.getBody()) != null && (subtitle = body2.getSubtitle()) != null) {
            binding.tvAppVersion.setText(String.format(subtitle, "6.24.3"));
        }
        binding.btnSkolkovo.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutAppFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutAppFragment.initViews$lambda$4$lambda$2(this.f$0, view);
            }
        });
        int i = Calendar.getInstance().get(1);
        LocalizationStorage localizationScreen = getLocalizationScreen();
        if (localizationScreen == null || (data = localizationScreen.getData()) == null || (about = data.getAbout()) == null || (body = about.getBody()) == null || (copyrightLabel = body.getCopyrightLabel()) == null) {
            return;
        }
        binding.tvCopyright.setText(String.format(copyrightLabel, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$2(AboutAppFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openLink("https://sk.ru/");
    }

    private final void openLink(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.white)).build();
        Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "build(...)");
        builder.setDefaultColorSchemeParams(customTabColorSchemeParamsBuild);
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        customTabsIntentBuild.intent.addFlags(268435456);
        customTabsIntentBuild.launchUrl(requireContext(), Uri.parse(url));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        AboutLocale about;
        AboutBody body;
        AboutLocale about2;
        TextTitle navigation;
        FragmentAboutBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        toolbar.setTitle((data == null || (about2 = data.getAbout()) == null || (navigation = about2.getNavigation()) == null) ? null : navigation.getTitle());
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 == null || (about = data2.getAbout()) == null || (body = about.getBody()) == null) {
            return;
        }
        binding.tvSkolkovo.setText(body.getDescriptionLabel());
        binding.tvTitle.setText(body.getTitle());
        binding.tvSkolkovoInfo.setText(body.getSkolkovo());
        TextView textView = binding.btnPrivacyPolicy;
        TextTitle rulesButton = body.getRulesButton();
        String title = rulesButton != null ? rulesButton.getTitle() : null;
        SpannableString spannableString = new SpannableString(title);
        Intrinsics.checkNotNull(title);
        SpansKt.addLink$default(spannableString, title, "https://storage.yandexcloud.net/sputnik-systems-citizen-app/mobile_privacy.html", null, 4, null);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = binding.btnUserLicense;
        TextTitle licenseButton = body.getLicenseButton();
        String title2 = licenseButton != null ? licenseButton.getTitle() : null;
        SpannableString spannableString2 = new SpannableString(title2);
        Intrinsics.checkNotNull(title2);
        SpansKt.addLink$default(spannableString2, title2, "https://sso.sputnik.systems/mobile_licence.pdf", null, 4, null);
        textView2.setText(spannableString2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
