package sputnik.axmor.com.sputnik.ui.main.help;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.SupportEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.help.CompanyContacts;
import com.sputnik.common.entities.localization.AboutCompanyLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.help.CompanyContactsBody;
import com.sputnik.common.entities.localization.entities.help.CompanyContactsLocale;
import com.sputnik.common.entities.localization.entities.help.ViewPhone;
import com.sputnik.common.entities.localization.entities.help.ViewWorkingHours;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentAboutCustomCompaniesBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewState;

/* compiled from: AboutCompanyFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R#\u0010?\u001a\n ;*\u0004\u0018\u00010:0:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00106\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/help/AboutCompanyFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;)V", "", "contact", "handleContact", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentAboutCustomCompaniesBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentAboutCustomCompaniesBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel$delegate", "Lkotlin/Lazy;", "getHelpViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "kotlin.jvm.PlatformType", "phoneParser$delegate", "getPhoneParser", "()Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "phoneParser", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AboutCompanyFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AboutCompanyFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentAboutCustomCompaniesBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: helpViewModel$delegate, reason: from kotlin metadata */
    private final Lazy helpViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: phoneParser$delegate, reason: from kotlin metadata */
    private final Lazy phoneParser;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentAboutCustomCompaniesBinding getBinding() {
        return (FragmentAboutCustomCompaniesBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HelpViewModel getHelpViewModel() {
        return (HelpViewModel) this.helpViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    /* compiled from: AboutCompanyFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<HelpViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, AboutCompanyFragment.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HelpViewState helpViewState) {
            invoke2(helpViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HelpViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AboutCompanyFragment) this.receiver).renderUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        HelpViewModel helpViewModel = getHelpViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        helpViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        getHelpViewModel().loadCompanyContactsIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderUi(sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewState r12) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment.renderUi(sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewState):void");
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNull(toolbar);
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        NestedScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
        FragmentAboutCustomCompaniesBinding binding = getBinding();
        LinearLayout layoutContacts = binding.layoutContacts;
        Intrinsics.checkNotNullExpressionValue(layoutContacts, "layoutContacts");
        SafeClickListenerKt.setSafeOnClickListener$default(layoutContacts, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$initViews$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                String supportPhone;
                Intrinsics.checkNotNullParameter(it, "it");
                AboutCompanyFragment aboutCompanyFragment = this.this$0;
                try {
                    aboutCompanyFragment.getAnalytics().trackLogEvent(new SupportEvents.ClickPhoneNumber());
                    CompanyContacts companyContacts = aboutCompanyFragment.getHelpViewModel().getCurrentState().getCompanyContacts();
                    if (companyContacts == null || (supportPhone = companyContacts.getSupportPhone()) == null) {
                        return;
                    }
                    if (StringsKt.isBlank(supportPhone)) {
                        supportPhone = null;
                    }
                    if (supportPhone != null) {
                        aboutCompanyFragment.handleContact(supportPhone);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1, null);
        LinearLayout layoutAdditionalContacts = binding.layoutAdditionalContacts;
        Intrinsics.checkNotNullExpressionValue(layoutAdditionalContacts, "layoutAdditionalContacts");
        SafeClickListenerKt.setSafeOnClickListener$default(layoutAdditionalContacts, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$initViews$2$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String string = this.this$0.getBinding().tvCompanyAdditionalPhone.getText().toString();
                this.this$0.getAnalytics().trackLogEvent(new SupportEvents.ClickAdditionalContact());
                this.this$0.handleContact(string);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleContact(String contact) {
        if (Patterns.EMAIL_ADDRESS.matcher(contact).matches()) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:" + contact));
            if (intent.resolveActivity(requireContext().getPackageManager()) != null) {
                startActivity(intent);
                return;
            }
            return;
        }
        if (Patterns.PHONE.matcher(contact).matches()) {
            Intent intent2 = new Intent("android.intent.action.DIAL");
            intent2.setData(Uri.parse("tel:" + contact));
            if (intent2.resolveActivity(requireContext().getPackageManager()) != null) {
                startActivity(intent2);
            }
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        CompanyContactsLocale contacts;
        ViewPhone phoneView;
        ViewWorkingHours workHoursView;
        AboutCompanyLocale aboutCompany;
        TextTitle navigation;
        Toolbar toolbar = getBinding().toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        toolbar.setTitle((data == null || (aboutCompany = data.getAboutCompany()) == null || (navigation = aboutCompany.getNavigation()) == null) ? null : navigation.getTitle());
        FragmentAboutCustomCompaniesBinding binding = getBinding();
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 == null || (contacts = data2.getContacts()) == null) {
            return;
        }
        Toolbar toolbar2 = binding.toolbar;
        TextTitle navigation2 = contacts.getNavigation();
        String title2 = navigation2 != null ? navigation2.getTitle() : null;
        if (title2 == null) {
            title2 = "";
        }
        toolbar2.setTitle(title2);
        TextView textView = binding.tvCompanyHours;
        CompanyContactsBody body = contacts.getBody();
        String title3 = (body == null || (workHoursView = body.getWorkHoursView()) == null) ? null : workHoursView.getTitle();
        if (title3 == null) {
            title3 = "";
        }
        textView.setText(title3);
        TextView textView2 = binding.tvCompanyPhoneHeader;
        CompanyContactsBody body2 = contacts.getBody();
        if (body2 != null && (phoneView = body2.getPhoneView()) != null) {
            title = phoneView.getTitle();
        }
        textView2.setText(title != null ? title : "");
        binding.tvCompanyAdditionalPhoneHeader.setText("Дополнительные контакты для связи");
    }

    public AboutCompanyFragment() {
        super(R.layout.fragment_about_custom_companies);
        this.binding = new ViewBindingFragmentDelegate(this, AboutCompanyFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.helpViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HelpViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$helpViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.phoneParser = LazyKt.lazy(new Function0<PhoneNumberUtil>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.AboutCompanyFragment$phoneParser$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PhoneNumberUtil invoke() {
                return PhoneNumberUtil.createInstance(this.this$0.requireContext());
            }
        });
    }
}
