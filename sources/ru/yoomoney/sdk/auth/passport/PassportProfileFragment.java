package ru.yoomoney.sdk.auth.passport;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountEnterOAuthCode;
import ru.yoomoney.sdk.auth.api.account.model.SocialAccount;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.EsiaOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.SberOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.VkOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.model.ErrorContactTechnicalSupport;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPassportProfileBinding;
import ru.yoomoney.sdk.auth.passport.ChangeEmailSuccessDialog;
import ru.yoomoney.sdk.auth.passport.ChangePhoneSuccessDialog;
import ru.yoomoney.sdk.auth.passport.PassportProfile;
import ru.yoomoney.sdk.auth.passport.SocialAccountBindingDialog;
import ru.yoomoney.sdk.auth.passport.adapter.SocialAccountListAdapter;
import ru.yoomoney.sdk.auth.passport.adapter.item.SocialAccountListItem;
import ru.yoomoney.sdk.auth.passport.adapter.item.SocialAccountResourceManager;
import ru.yoomoney.sdk.auth.passport.domain.OauthServiceProviderType;
import ru.yoomoney.sdk.auth.passport.domain.OauthServiceProviderTypeKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.socialAccounts.esia.EsiaActivity;
import ru.yoomoney.sdk.auth.socialAccounts.sberId.SberIdActivity;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity;
import ru.yoomoney.sdk.auth.support.EmailTechnicalSupportDialog;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.FormSelectView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;
import ru.yoomoney.sdk.auth.utils.PicassoExtensionsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.SberIdUtilsKt;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.headline.HeadlineSecondaryLargeView;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u001a\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010P\u001a\u00020QH\u0014J\u0012\u0010R\u001a\u00020Q2\b\u0010S\u001a\u0004\u0018\u00010TH\u0002J$\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020QH\u0016J\b\u0010^\u001a\u00020QH\u0016J\u001a\u0010_\u001a\u00020Q2\u0006\u0010`\u001a\u00020V2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u0012\u0010a\u001a\u00020Q2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0012\u0010d\u001a\u00020Q2\b\u0010b\u001a\u0004\u0018\u00010eH\u0002J\u0010\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020hH\u0002J\u0012\u0010i\u001a\u00020Q2\b\u0010b\u001a\u0004\u0018\u00010jH\u0002J\b\u0010k\u001a\u00020QH\u0002J\u0010\u0010l\u001a\u00020Q2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020Q2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020KH\u0002J\b\u0010t\u001a\u00020QH\u0002J\u0010\u0010u\u001a\u00020Q2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010v\u001a\u00020Q2\u0006\u0010m\u001a\u00020IH\u0002J\u0010\u0010w\u001a\u00020Q2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010x\u001a\u00020Q2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010y\u001a\u00020Q2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010{2\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010{H\u0002J\u0018\u0010~\u001a\u00020Q*\u00020\u007f2\n\b\u0001\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b%\u0010\"R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b'\u0010)R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u00100R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u0001060605X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u0001060605X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u0001060605X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR1\u0010G\u001a\u0018\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0Hj\u0002`L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0018\u001a\u0004\bM\u0010NR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lru/yoomoney/sdk/auth/passport/PassportProfileFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/RemoteConfig;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPassportProfileBinding;", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "getAccount", "()Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "account$delegate", "Lkotlin/Lazy;", "avatarLoaderTarget", "ru/yoomoney/sdk/auth/passport/PassportProfileFragment$avatarLoaderTarget$1", "Lru/yoomoney/sdk/auth/passport/PassportProfileFragment$avatarLoaderTarget$1;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPassportProfileBinding;", "holder", "Landroid/graphics/drawable/Drawable;", "getHolder", "()Landroid/graphics/drawable/Drawable;", "holder$delegate", "holderBackground", "getHolderBackground", "holderBackground$delegate", "isEmailProcess", "", "()Z", "isEmailProcess$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultEsiaActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "resultSberIdActivityLauncher", "resultVkIdActivityLauncher", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "socialAccountListAdapter", "Lru/yoomoney/sdk/auth/passport/adapter/SocialAccountListAdapter;", "successMessage", "", "getSuccessMessage", "()Ljava/lang/String;", "successMessage$delegate", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;", "Lru/yoomoney/sdk/auth/passport/PassportProfileViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "back", "", "finishWithCancel", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onStop", "onViewCreated", "view", "openEsia", "oauthCodeParameters", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/EsiaOauthCodeParameters;", "openSbol", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/SberOauthCodeParameters;", "openSocialAccountService", "process", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountEnterOAuthCode;", "openVk", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/VkOauthCodeParameters;", "retry", "setupErrorView", "state", "Lru/yoomoney/sdk/auth/passport/PassportProfile$State$Error;", "showBindSuccessDialog", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "showEffect", "effect", "showErrorMessage", "showOpenSocialAccountDialog", "showState", "showUnbindSocialAccountDialog", "updateContentView", "updateSocialAccounts", "socialAccounts", "", "Lru/yoomoney/sdk/auth/api/account/model/SocialAccount;", "availableSocialAccounts", "replaceValueIdForTest", "Lru/yoomoney/sdk/auth/ui/FormSelectView;", "id", "", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileFragment extends BaseFragment {
    private AuthPassportProfileBinding _binding;

    /* renamed from: account$delegate, reason: from kotlin metadata */
    private final Lazy account;
    private final PassportProfileFragment$avatarLoaderTarget$1 avatarLoaderTarget;
    private final Config config;

    /* renamed from: holder$delegate, reason: from kotlin metadata */
    private final Lazy holder;

    /* renamed from: holderBackground$delegate, reason: from kotlin metadata */
    private final Lazy holderBackground;

    /* renamed from: isEmailProcess$delegate, reason: from kotlin metadata */
    private final Lazy isEmailProcess;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final RemoteConfig remoteConfig;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final ActivityResultLauncher<Intent> resultEsiaActivityLauncher;
    private final ActivityResultLauncher<Intent> resultSberIdActivityLauncher;
    private final ActivityResultLauncher<Intent> resultVkIdActivityLauncher;
    private final Router router;
    private final SocialAccountListAdapter socialAccountListAdapter;

    /* renamed from: successMessage$delegate, reason: from kotlin metadata */
    private final Lazy successMessage;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OauthServiceProvider.values().length];
            try {
                iArr[OauthServiceProvider.SBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OauthServiceProvider.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OauthServiceProvider.ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class a extends Lambda implements Function0<UserAccount> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final UserAccount invoke() {
            Bundle arguments = PassportProfileFragment.this.getArguments();
            if (arguments != null) {
                return PassportProfileFragmentArgs.fromBundle(arguments).getAccount();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class b extends Lambda implements Function0<Drawable> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Drawable invoke() {
            Drawable drawable = AppCompatResources.getDrawable(PassportProfileFragment.this.requireContext(), R.drawable.auth_ic_contact_l);
            if (drawable == null) {
                return null;
            }
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Context contextRequireContext = PassportProfileFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            return DrawableExtensions.tint(drawable, colorScheme.getAccentFadeColor(contextRequireContext));
        }
    }

    public static final class c extends Lambda implements Function0<Drawable> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Drawable invoke() {
            Drawable drawable = AppCompatResources.getDrawable(PassportProfileFragment.this.requireContext(), R.drawable.ic_round_mask);
            if (drawable == null) {
                return null;
            }
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Context contextRequireContext = PassportProfileFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            return DrawableExtensions.tint(drawable, colorScheme.getAccentGhostColor(contextRequireContext));
        }
    }

    public static final class d extends Lambda implements Function0<Boolean> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(PassportProfileFragment.this.config.getProcessType() == Config.ProcessType.EMAIL);
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<PassportProfile.State, Unit> {
        public e(Object obj) {
            super(1, obj, PassportProfileFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/passport/PassportProfile$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PassportProfile.State state) {
            PassportProfile.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PassportProfileFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1<PassportProfile.Effect, Unit> {
        public f(Object obj) {
            super(1, obj, PassportProfileFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/passport/PassportProfile$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PassportProfile.Effect effect) throws Resources.NotFoundException {
            PassportProfile.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PassportProfileFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Throwable, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            PassportProfileFragment.this.showErrorMessage();
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<ProcessType> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            int processTypeCode = PassportProfileFragmentArgs.fromBundle(PassportProfileFragment.this.requireArguments()).getProcessTypeCode();
            if (processTypeCode > 0) {
                return ProcessType.values()[processTypeCode];
            }
            return null;
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            PassportProfileFragment.this.retry();
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function2<OauthServiceProvider, Boolean, Unit> {
        public j() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(OauthServiceProvider oauthServiceProvider, Boolean bool) {
            RuntimeViewModel viewModel;
            PassportProfile.Action openSocialAccountDialog;
            OauthServiceProvider service = oauthServiceProvider;
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(service, "service");
            if (zBooleanValue) {
                viewModel = PassportProfileFragment.this.getViewModel();
                openSocialAccountDialog = new PassportProfile.Action.StartUnbindSocialAccount(service);
            } else {
                viewModel = PassportProfileFragment.this.getViewModel();
                openSocialAccountDialog = new PassportProfile.Action.OpenSocialAccountDialog(service);
            }
            viewModel.handleAction(openSocialAccountDialog);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<String> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return PassportProfileFragmentArgs.fromBundle(PassportProfileFragment.this.requireArguments()).getSuccessMessage();
        }
    }

    public static final class l extends Lambda implements Function0<ViewModelProvider.Factory> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PassportProfileFragment.this.viewModelFactory;
        }
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [ru.yoomoney.sdk.auth.passport.PassportProfileFragment$avatarLoaderTarget$1] */
    public PassportProfileFragment(ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        this.resultData = resultData;
        this.remoteConfig = remoteConfig;
        l lVar = new l();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$special$$inlined$viewModels$default$4
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
        this.holderBackground = LazyKt.lazy(new c());
        this.holder = LazyKt.lazy(new b());
        this.account = LazyKt.lazy(new a());
        this.processType = LazyKt.lazy(new h());
        this.isEmailProcess = LazyKt.lazy(new d());
        this.successMessage = LazyKt.lazy(new k());
        this.avatarLoaderTarget = new Target() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$avatarLoaderTarget$1
            @Override // com.squareup.picasso.Target
            public void onBitmapFailed(Exception e2, Drawable errorDrawable) {
                Intrinsics.checkNotNullParameter(e2, "e");
                ImageView imageView = this.this$0.getBinding().avatar;
                PassportProfileFragment passportProfileFragment = this.this$0;
                imageView.setBackground(passportProfileFragment.getHolderBackground());
                imageView.setImageDrawable(passportProfileFragment.getHolder());
            }

            @Override // com.squareup.picasso.Target
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                Intrinsics.checkNotNullParameter(from, "from");
                ImageView imageView = this.this$0.getBinding().avatar;
                imageView.setBackground(this.this$0.getHolderBackground());
                imageView.setImageDrawable(new BitmapDrawable(imageView.getResources(), bitmap));
            }

            @Override // com.squareup.picasso.Target
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                ImageView imageView = this.this$0.getBinding().avatar;
                PassportProfileFragment passportProfileFragment = this.this$0;
                imageView.setBackground(passportProfileFragment.getHolderBackground());
                imageView.setImageDrawable(passportProfileFragment.getHolder());
            }
        };
        this.socialAccountListAdapter = new SocialAccountListAdapter(new j());
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PassportProfileFragment.resultSberIdActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.resultSberIdActivityLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PassportProfileFragment.resultVkIdActivityLauncher$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.resultVkIdActivityLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PassportProfileFragment.resultEsiaActivityLauncher$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.resultEsiaActivityLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    private final void finishWithCancel(Failure failure) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0, failure != null ? new Intent().putExtra(YooMoneyAuth.KEY_FAILURE, (Parcelable) failure) : null);
            activity.finish();
        }
    }

    private final UserAccount getAccount() {
        return (UserAccount) this.account.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPassportProfileBinding getBinding() {
        AuthPassportProfileBinding authPassportProfileBinding = this._binding;
        Intrinsics.checkNotNull(authPassportProfileBinding);
        return authPassportProfileBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable getHolder() {
        return (Drawable) this.holder.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable getHolderBackground() {
        return (Drawable) this.holderBackground.getValue();
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final String getSuccessMessage() {
        return (String) this.successMessage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final boolean isEmailProcess() {
        return ((Boolean) this.isEmailProcess.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(PassportProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PassportProfile.Action.ChangePassword.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3(PassportProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PassportProfile.Action.ChangeEmail.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$5(PassportProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PassportProfile.Action.ChangePhone.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$7(PassportProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PassportProfile.Action.ChangeName.INSTANCE);
    }

    private final void openEsia(EsiaOauthCodeParameters oauthCodeParameters) {
        if (oauthCodeParameters == null) {
            showErrorMessage();
            return;
        }
        EsiaActivity.Companion companion = EsiaActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.resultEsiaActivityLauncher.launch(companion.createIntent(contextRequireContext, this.config, oauthCodeParameters));
    }

    private final void openSbol(SberOauthCodeParameters oauthCodeParameters) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String sberIdReturnUrl = SberIdUtilsKt.getSberIdReturnUrl(contextRequireContext);
        if (oauthCodeParameters == null || sberIdReturnUrl == null) {
            showErrorMessage();
            return;
        }
        SberIdActivity.Companion companion = SberIdActivity.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        this.resultSberIdActivityLauncher.launch(companion.createIntent(contextRequireContext2, this.config, oauthCodeParameters, sberIdReturnUrl, this.remoteConfig.getOpenSberIdDialogText()));
    }

    private final void openSocialAccountService(ConnectSocialAccountEnterOAuthCode process) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[process.getOauthService().ordinal()];
        if (i2 == 1) {
            OauthCodeParameters oauthCodeParameters = process.getOauthCodeParameters();
            openSbol(oauthCodeParameters instanceof SberOauthCodeParameters ? (SberOauthCodeParameters) oauthCodeParameters : null);
        } else if (i2 == 2) {
            OauthCodeParameters oauthCodeParameters2 = process.getOauthCodeParameters();
            openVk(oauthCodeParameters2 instanceof VkOauthCodeParameters ? (VkOauthCodeParameters) oauthCodeParameters2 : null);
        } else {
            if (i2 != 3) {
                return;
            }
            OauthCodeParameters oauthCodeParameters3 = process.getOauthCodeParameters();
            openEsia(oauthCodeParameters3 instanceof EsiaOauthCodeParameters ? (EsiaOauthCodeParameters) oauthCodeParameters3 : null);
        }
    }

    private final void openVk(VkOauthCodeParameters oauthCodeParameters) {
        if (oauthCodeParameters == null) {
            showErrorMessage();
            return;
        }
        VkIdActivity.Companion companion = VkIdActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.resultVkIdActivityLauncher.launch(companion.createIntent(contextRequireContext, this.config));
    }

    private final void replaceValueIdForTest(FormSelectView formSelectView, int i2) {
        formSelectView.findViewById(R.id.value).setId(i2);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(formSelectView);
        int i3 = R.id.arrow;
        constraintSet.connect(i3, 3, i2, 3);
        constraintSet.connect(i3, 4, i2, 4);
        constraintSet.applyTo(formSelectView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resultEsiaActivityLauncher$lambda$2(PassportProfileFragment this$0, ActivityResult result) {
        RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> viewModel;
        PassportProfile.Action handleBindEsiaResponse;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        Uri data2 = data != null ? data.getData() : null;
        if (result.getResultCode() != -1 || data2 == null) {
            viewModel = this$0.getViewModel();
            handleBindEsiaResponse = PassportProfile.Action.CancelBinding.INSTANCE;
        } else {
            viewModel = this$0.getViewModel();
            handleBindEsiaResponse = new PassportProfile.Action.HandleBindEsiaResponse(data2);
        }
        viewModel.handleAction(handleBindEsiaResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resultSberIdActivityLauncher$lambda$0(PassportProfileFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        Uri data2 = data != null ? data.getData() : null;
        if (result.getResultCode() != -1 || data2 == null) {
            this$0.getViewModel().handleAction(PassportProfile.Action.CancelBinding.INSTANCE);
            return;
        }
        RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> viewModel = this$0.getViewModel();
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        viewModel.handleAction(new PassportProfile.Action.HandleBindSberIdResponse(data2, SberIdUtilsKt.getSberIdReturnUrl(contextRequireContext)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resultVkIdActivityLauncher$lambda$1(PassportProfileFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() != -1) {
            this$0.getViewModel().handleAction(PassportProfile.Action.CancelBinding.INSTANCE);
            return;
        }
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra(VkIdActivity.EXTRA_VK_ID_SILENT_TOKEN) : null;
        Intent data2 = result.getData();
        String stringExtra2 = data2 != null ? data2.getStringExtra(VkIdActivity.EXTRA_VK_ID_UUID) : null;
        String string = this$0.getString(R.string.vk_external_oauth_redirect_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this$0.getViewModel().handleAction(new PassportProfile.Action.HandleBindVkIdResponse(stringExtra, stringExtra2, string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retry() {
        RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> viewModel;
        PassportProfile.Action init;
        if (isEmailProcess()) {
            viewModel = getViewModel();
            String accessToken = this.config.getAccessToken();
            Intrinsics.checkNotNull(accessToken);
            init = new PassportProfile.Action.InitEmailProcess(accessToken);
        } else {
            viewModel = getViewModel();
            String accessToken2 = this.config.getAccessToken();
            Intrinsics.checkNotNull(accessToken2);
            init = new PassportProfile.Action.Init(accessToken2);
        }
        viewModel.handleAction(init);
    }

    private final void setupErrorView(PassportProfile.State.Error state) {
        EmptyStateLargeView emptyStateLargeView = getBinding().errorContainer;
        emptyStateLargeView.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close_m));
        emptyStateLargeView.setAction(getString(R.string.auth_action_try_again));
        emptyStateLargeView.setSubtitle(getResourceMapper().map(state.getFailure()));
        emptyStateLargeView.setActionListener(new i());
    }

    private final void showBindSuccessDialog(OauthServiceProvider serviceProvider) {
        String string = getString(R.string.auth_social_account_binding_success_dialog_title, getResourceMapper().mapServiceProviderToStringName(serviceProvider));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SocialAccountBindingDialog.Companion companion = SocialAccountBindingDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        String sberIdBoundSuccessText = this.remoteConfig.getSberIdBoundSuccessText();
        if (sberIdBoundSuccessText != null) {
            string = sberIdBoundSuccessText;
        }
        String string2 = getString(R.string.auth_social_account_binding_success_dialog_action);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        companion.show(childFragmentManager, string, string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PassportProfile.Effect effect) throws Resources.NotFoundException {
        AlertDialog alertDialogCreate;
        YmAlertDialog.DialogListener dialogListener;
        if (effect instanceof PassportProfile.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((PassportProfile.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (effect instanceof PassportProfile.Effect.ShowFailure) {
            PassportProfile.Effect.ShowFailure showFailure = (PassportProfile.Effect.ShowFailure) effect;
            if (!(showFailure.getFailure() instanceof FeatureFailure) || !(((FeatureFailure) showFailure.getFailure()).getError() instanceof ErrorContactTechnicalSupport)) {
                LinearLayout parent = getBinding().parent;
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(showFailure.getFailure()));
                return;
            } else {
                EmailTechnicalSupportDialog.Companion companion = EmailTechnicalSupportDialog.INSTANCE;
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                companion.show(childFragmentManager, getResourceMapper().map(showFailure.getFailure()));
                return;
            }
        }
        if (effect instanceof PassportProfile.Effect.ShowChangeEmailConfirmDialog) {
            YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_change_email_confirmation_dialog_title), getString(R.string.auth_change_email_confirmation_dialog_text), getString(R.string.auth_change_email_confirmation_dialog_accept), getString(R.string.auth_change_email_confirmation_dialog_decline), false, false, 48, null);
            AlertDialog.Companion companion2 = AlertDialog.INSTANCE;
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            alertDialogCreate = companion2.create(childFragmentManager2, dialogContent);
            dialogListener = new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$showEffect$1$1
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
                    this.this$0.getViewModel().handleAction(PassportProfile.Action.ConfirmChangeEmail.INSTANCE);
                }
            };
        } else if (effect instanceof PassportProfile.Effect.ShowChangePasswordConfirmDialog) {
            YmAlertDialog.DialogContent dialogContent2 = new YmAlertDialog.DialogContent(getString(R.string.auth_change_password_confirmation_dialog_title), getString(R.string.auth_change_password_confirmation_dialog_text), getString(R.string.auth_change_password_confirmation_dialog_accept), getString(R.string.auth_change_password_confirmation_dialog_decline), false, false, 48, null);
            AlertDialog.Companion companion3 = AlertDialog.INSTANCE;
            FragmentManager childFragmentManager3 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
            alertDialogCreate = companion3.create(childFragmentManager3, dialogContent2);
            dialogListener = new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$showEffect$2$1
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
                    this.this$0.getViewModel().handleAction(PassportProfile.Action.ConfirmChangePassword.INSTANCE);
                }
            };
        } else {
            if (!(effect instanceof PassportProfile.Effect.ShowChangePhoneConfirmDialog)) {
                if (effect instanceof PassportProfile.Effect.ShowChangePhoneSuccessDialog) {
                    ChangePhoneSuccessDialog.Companion companion4 = ChangePhoneSuccessDialog.INSTANCE;
                    FragmentManager childFragmentManager4 = getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "getChildFragmentManager(...)");
                    companion4.show(childFragmentManager4, ((PassportProfile.Effect.ShowChangePhoneSuccessDialog) effect).getPhone());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.ChangeName) {
                    FragmentKt.findNavController(this).navigate(R.id.nicknameFragment, BundleKt.bundleOf(TuplesKt.to("nickname", ((PassportProfile.Effect.ChangeName) effect).getName())), getNavOptions());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.ShowSuccessMessage) {
                    LinearLayout parent2 = getBinding().parent;
                    Intrinsics.checkNotNullExpressionValue(parent2, "parent");
                    CoreFragmentExtensions.noticeSuccess(parent2, ((PassportProfile.Effect.ShowSuccessMessage) effect).getMessage());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.ShowChangeEmailSuccessDialog) {
                    ChangeEmailSuccessDialog.Companion companion5 = ChangeEmailSuccessDialog.INSTANCE;
                    FragmentManager childFragmentManager5 = getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager5, "getChildFragmentManager(...)");
                    PassportProfile.Effect.ShowChangeEmailSuccessDialog showChangeEmailSuccessDialog = (PassportProfile.Effect.ShowChangeEmailSuccessDialog) effect;
                    companion5.show(childFragmentManager5, showChangeEmailSuccessDialog.getEmail(), showChangeEmailSuccessDialog.getUserHadEmail(), showChangeEmailSuccessDialog.getMarketingAccepted());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.OpenSocialAccountService) {
                    openSocialAccountService(((PassportProfile.Effect.OpenSocialAccountService) effect).getProcess());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.ShowBindSuccessDialog) {
                    showBindSuccessDialog(((PassportProfile.Effect.ShowBindSuccessDialog) effect).getProvider());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.ShowBindErrorDialog) {
                    SocialAccountBindingDialog.Companion companion6 = SocialAccountBindingDialog.INSTANCE;
                    FragmentManager childFragmentManager6 = getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager6, "getChildFragmentManager(...)");
                    String map = getResourceMapper().map(((PassportProfile.Effect.ShowBindErrorDialog) effect).getFailure());
                    String string = getString(R.string.auth_social_account_binding_error_dialog_action);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    companion6.show(childFragmentManager6, map, string);
                    return;
                }
                if (effect instanceof PassportProfile.Effect.ShowUnbindSocialAccountDialog) {
                    showUnbindSocialAccountDialog(((PassportProfile.Effect.ShowUnbindSocialAccountDialog) effect).getServiceProvider());
                    return;
                }
                if (effect instanceof PassportProfile.Effect.FinishWithCancel) {
                    finishWithCancel(((PassportProfile.Effect.FinishWithCancel) effect).getFailure());
                    return;
                } else if (effect instanceof PassportProfile.Effect.ShowSocialAccountDialog) {
                    showOpenSocialAccountDialog(((PassportProfile.Effect.ShowSocialAccountDialog) effect).getServiceProvider());
                    return;
                } else {
                    if (effect instanceof PassportProfile.Effect.Finish) {
                        back();
                        return;
                    }
                    return;
                }
            }
            YmAlertDialog.DialogContent dialogContent3 = new YmAlertDialog.DialogContent(getString(R.string.auth_change_phone_confirmation_dialog_title), getString(R.string.auth_change_phone_confirmation_dialog_text), getString(R.string.auth_change_phone_confirmation_dialog_accept), getString(R.string.auth_change_phone_confirmation_dialog_decline), false, false, 48, null);
            AlertDialog.Companion companion7 = AlertDialog.INSTANCE;
            FragmentManager childFragmentManager7 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager7, "getChildFragmentManager(...)");
            alertDialogCreate = companion7.create(childFragmentManager7, dialogContent3);
            dialogListener = new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$showEffect$3$1
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
                    this.this$0.getViewModel().handleAction(PassportProfile.Action.ConfirmChangePhone.INSTANCE);
                }
            };
        }
        alertDialogCreate.attachListener(dialogListener);
        FragmentManager childFragmentManager8 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager8, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorMessage() {
        LinearLayout parent = getBinding().parent;
        Intrinsics.checkNotNullExpressionValue(parent, "parent");
        String string = getString(R.string.auth_default_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CoreFragmentExtensions.noticeError(parent, string);
    }

    private final void showOpenSocialAccountDialog(final OauthServiceProvider serviceProvider) {
        OauthServiceProviderType oauthServiceProviderType = OauthServiceProviderTypeKt.toOauthServiceProviderType(serviceProvider);
        if (oauthServiceProviderType != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            AlertDialog alertDialogCreateOpenSocialAccountDialog = PresentationExtensionKt.createOpenSocialAccountDialog(contextRequireContext, childFragmentManager, oauthServiceProviderType);
            alertDialogCreateOpenSocialAccountDialog.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$showOpenSocialAccountDialog$1$1$1
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
                    this.this$0.getViewModel().handleAction(new PassportProfile.Action.StartBindingSocialAccount(serviceProvider));
                }
            });
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            alertDialogCreateOpenSocialAccountDialog.show(childFragmentManager2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PassportProfile.State state) {
        if ((state instanceof PassportProfile.State.Init) || (state instanceof PassportProfile.State.Loading) || (state instanceof PassportProfile.State.BindingProcess)) {
            getBinding().stateFlipper.showProgress();
            return;
        }
        if (state instanceof PassportProfile.State.Content) {
            PassportProfile.State.Content content = (PassportProfile.State.Content) state;
            this.resultData.setUserHasEmail(content.getAccount().getEmail().getTitle() != null);
            updateContentView(content.getAccount());
            getBinding().stateFlipper.showContent();
            return;
        }
        if (state instanceof PassportProfile.State.Error) {
            setupErrorView((PassportProfile.State.Error) state);
            getBinding().stateFlipper.showError();
        }
    }

    private final void showUnbindSocialAccountDialog(final OauthServiceProvider serviceProvider) {
        String string;
        if (serviceProvider != OauthServiceProvider.SBER || this.remoteConfig.getSberIdUnboundDialogText() == null) {
            string = getString(R.string.auth_unbind_social_account_dialog_title, getResourceMapper().mapServiceProviderToStringName(serviceProvider));
            Intrinsics.checkNotNull(string);
        } else {
            string = this.remoteConfig.getSberIdUnboundDialogText();
        }
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(string, getString(R.string.auth_unbind_social_account_dialog_message), getString(R.string.auth_unbind_social_account_dialog_action_positive), getString(R.string.auth_unbind_social_account_dialog_action_negative), true, false, 32, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$showUnbindSocialAccountDialog$1$1
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
                this.this$0.getViewModel().handleAction(new PassportProfile.Action.UnbindSocialAccount(serviceProvider));
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    private final void updateContentView(UserAccount account) {
        String title;
        String title2;
        String title3;
        String title4;
        String title5 = account.getEmail().getTitle();
        if (title5 != null) {
            getBinding().email.setValue(title5);
        }
        String title6 = account.getDisplayName().getTitle();
        if (title6 != null) {
            getBinding().name.setValue(title6);
        }
        String title7 = account.getPhone().getTitle();
        if (title7 != null) {
            getBinding().phone.setValue(title7);
        }
        getBinding().email.setEnabled(account.getEmail().getModifiable());
        getBinding().name.setEnabled(account.getDisplayName().getModifiable());
        getBinding().phone.setEnabled(account.getPhone().getModifiable());
        FormSelectView phone = getBinding().phone;
        Intrinsics.checkNotNullExpressionValue(phone, "phone");
        phone.setVisibility((account.getPhone().getModifiable() || !((title4 = account.getPhone().getTitle()) == null || StringsKt.isBlank(title4))) ? 0 : 8);
        FormSelectView email = getBinding().email;
        Intrinsics.checkNotNullExpressionValue(email, "email");
        email.setVisibility((account.getEmail().getModifiable() || !((title3 = account.getEmail().getTitle()) == null || StringsKt.isBlank(title3))) ? 0 : 8);
        FormSelectView name = getBinding().name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        name.setVisibility((account.getDisplayName().getModifiable() || !((title2 = account.getDisplayName().getTitle()) == null || StringsKt.isBlank(title2))) ? 0 : 8);
        FormSelectView phone2 = getBinding().phone;
        Intrinsics.checkNotNullExpressionValue(phone2, "phone");
        phone2.setVisibility((account.getPhone().getModifiable() || !((title = account.getPhone().getTitle()) == null || StringsKt.isBlank(title))) ? 0 : 8);
        HeadlineSecondaryLargeView security = getBinding().security;
        Intrinsics.checkNotNullExpressionValue(security, "security");
        security.setVisibility(account.getPassword().getModifiable() ? 0 : 8);
        FormSelectView password = getBinding().password;
        Intrinsics.checkNotNullExpressionValue(password, "password");
        password.setVisibility(account.getPassword().getModifiable() ? 0 : 8);
        updateSocialAccounts(account.getSocialAccounts(), this.config.getAvailableSocialAccounts());
        Picasso picasso = Picasso.get();
        String url = account.getAvatar().getUrl();
        if (url == null) {
            url = "";
        }
        RequestCreator requestCreatorLoad = picasso.load(Uri.parse(url));
        Intrinsics.checkNotNullExpressionValue(requestCreatorLoad, "load(...)");
        PicassoExtensionsKt.cropToCircle(requestCreatorLoad).into(this.avatarLoaderTarget);
    }

    private final void updateSocialAccounts(List<SocialAccount> socialAccounts, List<? extends OauthServiceProvider> availableSocialAccounts) {
        List<SocialAccountListItem> listCreateList = SocialAccountResourceManager.INSTANCE.createList(socialAccounts, availableSocialAccounts);
        HeadlineSecondaryLargeView socialAccountsTitle = getBinding().socialAccountsTitle;
        Intrinsics.checkNotNullExpressionValue(socialAccountsTitle, "socialAccountsTitle");
        socialAccountsTitle.setVisibility(!listCreateList.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().socialAccountRecyclerView;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        recyclerView.addItemDecoration(new PaddingItemDecoration(context, recyclerView.getResources().getDimensionPixelSize(R$dimen.ym_space5XL), 0, 4, null));
        SocialAccountListAdapter socialAccountListAdapter = this.socialAccountListAdapter;
        socialAccountListAdapter.submitList(listCreateList);
        recyclerView.setAdapter(socialAccountListAdapter);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public void back() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!this.resultData.getUserAccountWasUpdated()) {
                getViewModel().handleAction(PassportProfile.Action.FinishWithCancel.INSTANCE);
            } else {
                activity.setResult(-1, new Intent().putExtra(YooMoneyAuth.KEY_USER_ACCOUNT, getAccount()));
                activity.finish();
            }
        }
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPassportProfileBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Picasso.get().cancelRequest(this.avatarLoaderTarget);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> viewModel;
        PassportProfile.Action init;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FormSelectView formSelectView = getBinding().email;
        formSelectView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PassportProfileFragment.onViewCreated$lambda$4$lambda$3(this.f$0, view2);
            }
        });
        Intrinsics.checkNotNull(formSelectView);
        replaceValueIdForTest(formSelectView, R.id.value_email);
        FormSelectView formSelectView2 = getBinding().phone;
        formSelectView2.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PassportProfileFragment.onViewCreated$lambda$6$lambda$5(this.f$0, view2);
            }
        });
        Intrinsics.checkNotNull(formSelectView2);
        replaceValueIdForTest(formSelectView2, R.id.value_phone);
        FormSelectView formSelectView3 = getBinding().name;
        formSelectView3.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PassportProfileFragment.onViewCreated$lambda$8$lambda$7(this.f$0, view2);
            }
        });
        Intrinsics.checkNotNull(formSelectView3);
        replaceValueIdForTest(formSelectView3, R.id.value_nickname);
        FormSelectView formSelectView4 = getBinding().password;
        formSelectView4.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.passport.PassportProfileFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PassportProfileFragment.onViewCreated$lambda$10$lambda$9(this.f$0, view2);
            }
        });
        Intrinsics.checkNotNull(formSelectView4);
        replaceValueIdForTest(formSelectView4, R.id.value_password);
        RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> viewModel2 = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel2, viewLifecycleOwner, new e(this), new f(this), new g());
        if (getAccount() != null) {
            if (getSuccessMessage() != null) {
                viewModel = getViewModel();
                UserAccount account = getAccount();
                if (account == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                String successMessage = getSuccessMessage();
                if (successMessage == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                init = new PassportProfile.Action.AccountWithMessage(account, successMessage);
            } else {
                this.resultData.setUserAccountWasUpdated(true);
                viewModel = getViewModel();
                UserAccount account2 = getAccount();
                if (account2 == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                init = new PassportProfile.Action.AccountSuccess(account2, getProcessType());
            }
        } else {
            if (isEmailProcess()) {
                RuntimeViewModel<PassportProfile.State, PassportProfile.Action, PassportProfile.Effect> viewModel3 = getViewModel();
                String accessToken = this.config.getAccessToken();
                Intrinsics.checkNotNull(accessToken);
                viewModel3.handleAction(new PassportProfile.Action.InitEmailProcess(accessToken));
                return;
            }
            viewModel = getViewModel();
            String accessToken2 = this.config.getAccessToken();
            if (accessToken2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            init = new PassportProfile.Action.Init(accessToken2);
        }
        viewModel.handleAction(init);
    }
}
