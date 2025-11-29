package ru.yoomoney.sdk.auth.phone.enter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.ComposeStyle;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.OauthResult;
import ru.yoomoney.sdk.auth.PhoneIdentifier;
import ru.yoomoney.sdk.auth.PrefilledData;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.Style;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterCallCode;
import ru.yoomoney.sdk.auth.analytics.RegistrationEnterSmsCode;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.CountryCallingCode;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.RegistrationProcessError;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPhoneEnterBinding;
import ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesFragment;
import ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesListener;
import ru.yoomoney.sdk.auth.phone.enter.PhoneEnter;
import ru.yoomoney.sdk.auth.phone.enter.utils.PhoneNumberInputFilter;
import ru.yoomoney.sdk.auth.phone.enter.utils.PhoneNumberWatcher;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.support.EmailTechnicalSupportDialog;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.StringExtensionsKt;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.guiCompose.theme.Palette;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.two_fa.FontResource;
import ru.yoomoney.sdk.two_fa.YooMoneyTwoFa;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.two_fa.parcelable.PaletteParcelable;
import ru.yoomoney.sdk.two_fa.utils.ContextExtensionsKt;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u000202H\u0002J\u0010\u0010U\u001a\u00020R2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020R2\u0006\u0010V\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020R2\u0006\u0010[\u001a\u00020)H\u0016J$\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\b\u0010d\u001a\u00020RH\u0016J\u001a\u0010e\u001a\u00020R2\u0006\u0010f\u001a\u00020]2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J \u0010g\u001a\u00020R2\u0006\u0010h\u001a\u0002022\u0006\u0010i\u001a\u0002022\u0006\u0010j\u001a\u000202H\u0002J\u0010\u0010k\u001a\u00020R2\u0006\u0010l\u001a\u00020LH\u0002J\b\u0010m\u001a\u00020RH\u0002J\u0010\u0010n\u001a\u00020R2\u0006\u0010o\u001a\u00020JH\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b#\u0010%R)\u0010'\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010)0)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\"\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\"\u001a\u0004\b7\u00104R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\"\u001a\u0004\b=\u0010>R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR1\u0010H\u001a\u0018\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0Ij\u0002`M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\"\u001a\u0004\bN\u0010OR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006p"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/PhoneEnterFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/auth/phone/countries/PhoneCountriesListener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPhoneEnterBinding;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPhoneEnterBinding;", "confirmLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "currentTextChangeListener", "Landroid/text/TextWatcher;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", "isAddedToBackStack", "", "()Z", "isAddedToBackStack$delegate", "phoneCountries", "", "Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "getPhoneCountries", "()Ljava/util/List;", "phoneCountries$delegate", "prefilledCountryCallingCode", "getPrefilledCountryCallingCode", "()Lru/yoomoney/sdk/auth/api/model/CountryCallingCode;", "prefilledCountryCallingCode$delegate", "prefilledPhone", "", "getPrefilledPhone", "()Ljava/lang/String;", "prefilledPhone$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Action;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;", "Lru/yoomoney/sdk/auth/phone/enter/PhoneEnterViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "dismiss", "", "launch2fa", "authProcessId", "navigateToNextRegistrationStep", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "navigateToNextStep", "Lru/yoomoney/sdk/auth/api/Process;", "onCountrySelected", "selected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupPhone", "phonePrefix", "countryCode", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "showEffect", "effect", "showExpireDialog", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneEnterFragment extends BaseFragment implements PhoneCountriesListener {
    private AuthPhoneEnterBinding _binding;
    private final AnalyticsLogger analyticsLogger;
    private final Config config;
    private final ActivityResultLauncher<Intent> confirmLauncher;
    private TextWatcher currentTextChangeListener;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: isAddedToBackStack$delegate, reason: from kotlin metadata */
    private final Lazy isAddedToBackStack;

    /* renamed from: phoneCountries$delegate, reason: from kotlin metadata */
    private final Lazy phoneCountries;

    /* renamed from: prefilledCountryCallingCode$delegate, reason: from kotlin metadata */
    private final Lazy prefilledCountryCallingCode;

    /* renamed from: prefilledPhone$delegate, reason: from kotlin metadata */
    private final Lazy prefilledPhone;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<OffsetDateTime> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            return PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getExpireAt();
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getIsAddedToBackStack());
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<PhoneEnter.State, Unit> {
        public c(Object obj) {
            super(1, obj, PhoneEnterFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneEnter.State state) {
            PhoneEnter.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneEnterFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<PhoneEnter.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, PhoneEnterFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/phone/enter/PhoneEnter$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneEnter.Effect effect) throws Resources.NotFoundException {
            PhoneEnter.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneEnterFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            ConstraintLayout parent = PhoneEnterFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PhoneEnterFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<List<? extends CountryCallingCode>> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends CountryCallingCode> invoke() {
            CountryCallingCode[] countryCodes = PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getCountryCodes();
            Intrinsics.checkNotNullExpressionValue(countryCodes, "getCountryCodes(...)");
            return ArraysKt.toList(countryCodes);
        }
    }

    public static final class g extends Lambda implements Function0<CountryCallingCode> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CountryCallingCode invoke() {
            return PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getPrefilledCountryCallingCode();
        }
    }

    public static final class h extends Lambda implements Function0<String> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getPrefilledPhone();
        }
    }

    public static final class i extends Lambda implements Function0<String> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String processId = PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class j extends Lambda implements Function0<ProcessType> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            ProcessType processType = PhoneEnterFragmentArgs.fromBundle(PhoneEnterFragment.this.requireArguments()).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class k extends Lambda implements Function1<Boolean, Unit> {
        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            PhoneEnterFragment.this.getViewModel().handleAction(new PhoneEnter.Action.PhoneValidated(bool.booleanValue()));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function0<ViewModelProvider.Factory> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PhoneEnterFragment.this.viewModelFactory;
        }
    }

    public PhoneEnterFragment(ViewModelProvider.Factory viewModelFactory, ResultData resultData, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.resultData = resultData;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        l lVar = new l();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, lVar);
        this.phoneCountries = LazyKt.lazy(new f());
        this.processId = LazyKt.lazy(new i());
        this.expireAt = LazyKt.lazy(new a());
        this.processType = LazyKt.lazy(new j());
        this.prefilledPhone = LazyKt.lazy(new h());
        this.prefilledCountryCallingCode = LazyKt.lazy(new g());
        this.isAddedToBackStack = LazyKt.lazy(new b());
        this.analyticsLogger = new AnalyticsLogger() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$analyticsLogger$1
            @Override // ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger
            public void onNewEvent(AnalyticsEvent event) {
                RuntimeViewModel viewModel;
                PhoneEnter.Action.SendAnalyticsFromTwoFa sendAnalyticsFromTwoFa;
                Intrinsics.checkNotNullParameter(event, "event");
                String eventName = event.getEventName();
                RegistrationEnterCallCode registrationEnterCallCode = RegistrationEnterCallCode.INSTANCE;
                if (Intrinsics.areEqual(eventName, registrationEnterCallCode.getEventName())) {
                    viewModel = this.this$0.getViewModel();
                    sendAnalyticsFromTwoFa = new PhoneEnter.Action.SendAnalyticsFromTwoFa(this.this$0.getProcessType(), registrationEnterCallCode);
                } else {
                    RegistrationEnterSmsCode registrationEnterSmsCode = RegistrationEnterSmsCode.INSTANCE;
                    if (!Intrinsics.areEqual(eventName, registrationEnterSmsCode.getEventName())) {
                        return;
                    }
                    viewModel = this.this$0.getViewModel();
                    sendAnalyticsFromTwoFa = new PhoneEnter.Action.SendAnalyticsFromTwoFa(this.this$0.getProcessType(), registrationEnterSmsCode);
                }
                viewModel.handleAction(sendAnalyticsFromTwoFa);
            }
        };
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$$ExternalSyntheticLambda4
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PhoneEnterFragment.confirmLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.confirmLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmLauncher$lambda$0(PhoneEnterFragment this$0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            this$0.getViewModel().handleAction(new PhoneEnter.Action.ConfirmPhone(this$0.getProcessId()));
        } else {
            if (this$0.isAddedToBackStack()) {
                return;
            }
            FragmentKt.findNavController(this$0).popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPhoneEnterBinding getBinding() {
        AuthPhoneEnterBinding authPhoneEnterBinding = this._binding;
        Intrinsics.checkNotNull(authPhoneEnterBinding);
        return authPhoneEnterBinding;
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final List<CountryCallingCode> getPhoneCountries() {
        return (List) this.phoneCountries.getValue();
    }

    private final CountryCallingCode getPrefilledCountryCallingCode() {
        return (CountryCallingCode) this.prefilledCountryCallingCode.getValue();
    }

    private final String getPrefilledPhone() {
        return (String) this.prefilledPhone.getValue();
    }

    private final String getProcessId() {
        return (String) this.processId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<PhoneEnter.State, PhoneEnter.Action, PhoneEnter.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final boolean isAddedToBackStack() {
        return ((Boolean) this.isAddedToBackStack.getValue()).booleanValue();
    }

    private final void launch2fa(String authProcessId) {
        Palette paletteCurrentThemeToComposePalette;
        PaletteParcelable paletteParcelable;
        ThemeScheme themeScheme;
        ComposeStyle composeStyle;
        List<FontResource> fontResources;
        ComposeStyle composeStyle2;
        ComposeStyle composeStyle3;
        YooMoneyTwoFa yooMoneyTwoFa = YooMoneyTwoFa.INSTANCE;
        yooMoneyTwoFa.initTwoFaAnalyticsLogger(this.analyticsLogger);
        ActivityResultLauncher<Intent> activityResultLauncher = this.confirmLauncher;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String apiHost = this.config.getApiHost();
        String accessToken = this.config.getAccessToken();
        ArrayList arrayList = null;
        String str = (accessToken == null || accessToken.length() == 0) ? null : accessToken;
        boolean confirmationHelpActionVisible = this.config.getConfirmationHelpActionVisible();
        Style style = this.config.getStyle();
        boolean darkTheme = (style == null || (composeStyle3 = style.getComposeStyle()) == null) ? false : composeStyle3.getDarkTheme();
        Style style2 = this.config.getStyle();
        if (((style2 == null || (composeStyle2 = style2.getComposeStyle()) == null) ? null : composeStyle2.getPalette()) != null) {
            paletteParcelable = this.config.getStyle().getComposeStyle().getPalette();
        } else {
            Style style3 = this.config.getStyle();
            if (((style3 == null || (themeScheme = style3.getThemeScheme()) == null) ? null : themeScheme.getAccentColor()) != null) {
                ColorScheme colorScheme = ColorScheme.INSTANCE;
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                paletteCurrentThemeToComposePalette = ContextExtensionsKt.accentColorToComposePalette(colorScheme.getAccentColor(contextRequireContext2));
            } else {
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                paletteCurrentThemeToComposePalette = ContextExtensionsKt.currentThemeToComposePalette(contextRequireContext3);
            }
            paletteParcelable = new PaletteParcelable(paletteCurrentThemeToComposePalette);
        }
        Style style4 = this.config.getStyle();
        if (style4 != null && (composeStyle = style4.getComposeStyle()) != null && (fontResources = composeStyle.getFontResources()) != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fontResources, 10));
            for (FontResource fontResource : fontResources) {
                arrayList.add(new FontResource(fontResource.getResId(), fontResource.getWeight()));
            }
        }
        activityResultLauncher.launch(yooMoneyTwoFa.confirm(contextRequireContext, new ru.yoomoney.sdk.two_fa.Config(authProcessId, apiHost, str, confirmationHelpActionVisible, new ru.yoomoney.sdk.two_fa.Style(darkTheme, paletteParcelable, arrayList))));
    }

    private final void navigateToNextRegistrationStep(RegistrationProcess process) throws Resources.NotFoundException {
        String authProcessId;
        this.resultData.setPhone(String.valueOf(getBinding().phone.getText()));
        if (process instanceof RegistrationProcess.Require2faEmail) {
            authProcessId = ((RegistrationProcess.Require2faEmail) process).getAuthProcessId();
        } else {
            if (!(process instanceof RegistrationProcess.Require2faPhone)) {
                BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
                return;
            }
            authProcessId = ((RegistrationProcess.Require2faPhone) process).getAuthProcessId();
        }
        launch2fa(authProcessId);
    }

    private final void navigateToNextStep(Process process) throws Resources.NotFoundException {
        this.resultData.setPhone(String.valueOf(getBinding().phone.getText()));
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(PhoneEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PhoneEnter.Action.OpenIdentificationInfo.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(PhoneEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PhoneEnter.Action.ShowCountries.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(PhoneEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence text = this$0.getBinding().phone.getText();
        if (text != null) {
            this$0.getViewModel().handleAction(new PhoneEnter.Action.CheckExpiration(this$0.getProcessType(), this$0.getProcessId(), this$0.getExpireAt(), text.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$7(PhoneEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PhoneEnter.Action.ClickToPhoneDisabled.INSTANCE);
        EmailTechnicalSupportDialog.Companion companion = EmailTechnicalSupportDialog.INSTANCE;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        String string = this$0.getString(R.string.auth_password_recovery_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.show(childFragmentManager, string);
    }

    private final void setupPhone(String phonePrefix, String countryCode, String title) {
        AppCompatEditText editText = getBinding().phone.getEditText();
        editText.removeTextChangedListener(this.currentTextChangeListener);
        PhoneNumberWatcher phoneNumberWatcher = new PhoneNumberWatcher(editText, new k(), phonePrefix, countryCode);
        this.currentTextChangeListener = phoneNumberWatcher;
        editText.addTextChangedListener(phoneNumberWatcher);
        editText.setFilters(new InputFilter[]{new PhoneNumberInputFilter(phonePrefix)});
        editText.setText(phonePrefix);
        editText.setSelection(phonePrefix.length());
        getBinding().phone.setLabel(getString(R.string.auth_phone_enter_label, title));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PhoneEnter.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof PhoneEnter.Effect.ShowCountries) {
            PhoneCountriesFragment.Companion companion = PhoneCountriesFragment.INSTANCE;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            companion.show(childFragmentManager, getPhoneCountries(), ((PhoneEnter.Effect.ShowCountries) effect).getSelectedCountry());
            return;
        }
        if (effect instanceof PhoneEnter.Effect.ShowNextStep) {
            navigateToNextStep(((PhoneEnter.Effect.ShowNextStep) effect).getProcess());
            return;
        }
        if (effect instanceof PhoneEnter.Effect.ShowNextRegistrationStep) {
            navigateToNextRegistrationStep(((PhoneEnter.Effect.ShowNextRegistrationStep) effect).getProcess());
            return;
        }
        if (effect instanceof PhoneEnter.Effect.ShowError) {
            PhoneEnter.Effect.ShowError showError = (PhoneEnter.Effect.ShowError) effect;
            if (!(showError.getFailure() instanceof FeatureFailure) || !(((FeatureFailure) showError.getFailure()).getError() instanceof RegistrationProcessError.ProcessExpired)) {
                FragmentManager childFragmentManager2 = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                View viewRequireView = requireView();
                Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
                CoreFragmentExtensions.handleFailure(this, childFragmentManager2, viewRequireView, showError.getFailure(), getResourceMapper());
                return;
            }
        } else if (!(effect instanceof PhoneEnter.Effect.ShowExpireDialog)) {
            if (effect instanceof PhoneEnter.Effect.ResetProcess) {
                FragmentKt.findNavController(this).navigate(getRouter().reset());
                return;
            } else if (effect instanceof PhoneEnter.Effect.FillEditText) {
                getBinding().phone.getEditText().setText(((PhoneEnter.Effect.FillEditText) effect).getData());
                return;
            } else {
                if (effect instanceof PhoneEnter.Effect.ShowIdentificationInfo) {
                    FragmentKt.findNavController(this).navigate(R.id.identificationInfoFragment, BundleKt.bundleOf(), getNavOptions());
                    return;
                }
                return;
            }
        }
        showExpireDialog();
    }

    private final void showExpireDialog() {
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$showExpireDialog$1$1
            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onDismiss() {
                YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onNegativeClick() {
                YmAlertDialog.DialogListener.DefaultImpls.onNegativeClick(this);
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onPositiveClick() {
                this.this$0.getViewModel().handleAction(PhoneEnter.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PhoneEnter.State state) {
        if (state instanceof PhoneEnter.State.Content) {
            AuthPhoneEnterBinding binding = getBinding();
            binding.action.setEnabled(((PhoneEnter.State.Content) state).getPhoneIsValid());
            binding.phone.setEnabled(true);
            binding.countries.setEnabled(true);
            binding.action.showProgress(false);
            return;
        }
        if (state instanceof PhoneEnter.State.Loading) {
            AuthPhoneEnterBinding binding2 = getBinding();
            binding2.phone.setEnabled(false);
            binding2.countries.setEnabled(false);
            binding2.action.showProgress(true);
        }
    }

    @Override // ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesListener
    public void dismiss() {
        getViewModel().handleAction(PhoneEnter.Action.CloseDialog.INSTANCE);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ProcessMapper getProcessMapper() {
        return this.processMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ResourceMapper getResourceMapper() {
        return this.resourceMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public Router getRouter() {
        return this.router;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public TopBarDefault getTopBar() {
        ru.yoomoney.sdk.auth.ui.TopBarDefault appBar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        return appBar;
    }

    @Override // ru.yoomoney.sdk.auth.phone.countries.PhoneCountriesListener
    public void onCountrySelected(CountryCallingCode selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        setupPhone(selected.getPhonePrefix(), selected.getCountryCode(), selected.getTitle());
        getViewModel().handleAction(new PhoneEnter.Action.SelectCountry(selected));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPhoneEnterBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getTopBar().setTitle("");
        TextBodyView textBodyView = getBinding().countries;
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textBodyView.setTextColor(colorScheme.typeColorStateList(contextRequireContext));
        PrefilledData prefilledData = this.config.getPrefilledData();
        Object obj = null;
        PhoneIdentifier phone = prefilledData != null ? prefilledData.getPhone() : null;
        String countryCode = phone != null ? phone.getCountryCode() : null;
        String prefilledPhone = getPrefilledPhone();
        if (prefilledPhone == null) {
            prefilledPhone = phone != null ? phone.getPhone() : null;
        }
        if (getPhoneCountries().isEmpty()) {
            getBinding().phone.setLabel(getString(R.string.auth_password_recovery_phone));
            AppCompatEditText editText = getBinding().phone.getEditText();
            editText.removeTextChangedListener(this.currentTextChangeListener);
            SimpleTextWatcher simpleTextWatcher = new SimpleTextWatcher() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$onViewCreated$3$1
                @Override // ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher, android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    this.this$0.getViewModel().handleAction(new PhoneEnter.Action.PhoneValidated(s != null && s.length() > 0));
                }
            };
            this.currentTextChangeListener = simpleTextWatcher;
            editText.addTextChangedListener(simpleTextWatcher);
            getViewModel().handleAction(new PhoneEnter.Action.LoadData(new CountryCallingCode("", "", ""), getProcessType(), prefilledPhone, this.resultData.getPhone()));
        } else {
            CountryCallingCode prefilledCountryCallingCode = getPrefilledCountryCallingCode();
            if (prefilledCountryCallingCode == null) {
                Iterator<T> it = getPhoneCountries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((CountryCallingCode) next).getCountryCode(), countryCode)) {
                        obj = next;
                        break;
                    }
                }
                prefilledCountryCallingCode = (CountryCallingCode) obj;
                if (prefilledCountryCallingCode == null) {
                    prefilledCountryCallingCode = (CountryCallingCode) CollectionsKt.first((List) getPhoneCountries());
                }
            }
            setupPhone(prefilledCountryCallingCode.getPhonePrefix(), prefilledCountryCallingCode.getCountryCode(), prefilledCountryCallingCode.getTitle());
            getBinding().phone.setLabel(getString(R.string.auth_phone_enter_label, prefilledCountryCallingCode.getTitle()));
            getBinding().countries.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PhoneEnterFragment.onViewCreated$lambda$3(this.f$0, view2);
                }
            });
            RuntimeViewModel<PhoneEnter.State, PhoneEnter.Action, PhoneEnter.Effect> viewModel = getViewModel();
            Intrinsics.checkNotNull(prefilledCountryCallingCode);
            viewModel.handleAction(new PhoneEnter.Action.LoadData(prefilledCountryCallingCode, getProcessType(), prefilledPhone, this.resultData.getPhone()));
        }
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhoneEnterFragment.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
        SecondaryButtonView secondaryButtonView = getBinding().phoneDisabled;
        Intrinsics.checkNotNull(secondaryButtonView);
        ProcessType processType = getProcessType();
        ProcessType processType2 = ProcessType.PASSWORD_RECOVERY;
        ViewExtensions.setVisible(secondaryButtonView, processType == processType2);
        secondaryButtonView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhoneEnterFragment.onViewCreated$lambda$8$lambda$7(this.f$0, view2);
            }
        });
        TextBodyView countries = getBinding().countries;
        Intrinsics.checkNotNullExpressionValue(countries, "countries");
        ViewExtensions.setVisible(countries, getProcessType() != processType2);
        TextCaption1View textCaption1View = getBinding().identificationInformer;
        textCaption1View.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.enter.PhoneEnterFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhoneEnterFragment.onViewCreated$lambda$10$lambda$9(this.f$0, view2);
            }
        });
        String string = getString(R.string.auth_enter_phone_identification_informer_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textCaption1View.setText(StringExtensionsKt.parseHtml(string));
        Intrinsics.checkNotNull(textCaption1View);
        textCaption1View.setVisibility((this.config.getIdentificationAccessible() && this.config.getProcessType() == Config.ProcessType.LOGIN_SBER && this.resultData.getOauthLinkStatus() == OauthResult.OauthLinkStatus.ACCOUNT_CREATED) ? 0 : 8);
        if (getProcessType() == ProcessType.CHANGE_PHONE) {
            getBinding().title.setText(getString(R.string.auth_phone_change_screen_title));
        }
        if (!getPhoneCountries().isEmpty()) {
            RuntimeViewModel<PhoneEnter.State, PhoneEnter.Action, PhoneEnter.Effect> viewModel2 = getViewModel();
            Object objFirst = CollectionsKt.first((List<? extends Object>) getPhoneCountries());
            Intrinsics.checkNotNullExpressionValue(objFirst, "first(...)");
            viewModel2.handleAction(new PhoneEnter.Action.LoadData((CountryCallingCode) objFirst, getProcessType(), null, null, 12, null));
        }
        RuntimeViewModel<PhoneEnter.State, PhoneEnter.Action, PhoneEnter.Effect> viewModel3 = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel3, viewLifecycleOwner, new c(this), new d(this), new e());
    }
}
