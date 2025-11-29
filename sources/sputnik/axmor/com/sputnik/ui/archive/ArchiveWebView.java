package sputnik.axmor.com.sputnik.ui.archive;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.OnboardingViewState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ArchiveWebViewLayoutBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewModel;

/* compiled from: ArchiveWebView.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/archive/ArchiveWebView;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "localize", "initViews", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "archiveViewModel$delegate", "Lkotlin/Lazy;", "getArchiveViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "archiveViewModel", "", "serviceUrl$delegate", "getServiceUrl", "()Ljava/lang/String;", "serviceUrl", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "Lsputnik/axmor/com/databinding/ArchiveWebViewLayoutBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/ArchiveWebViewLayoutBinding;", "binding", "MyWebViewClient", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArchiveWebView extends BaseFragment {
    private ViewBinding _binding;

    /* renamed from: archiveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy archiveViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;

    /* renamed from: serviceUrl$delegate, reason: from kotlin metadata */
    private final Lazy serviceUrl;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveWebViewLayoutBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.ArchiveWebViewLayoutBinding");
        return (ArchiveWebViewLayoutBinding) viewBinding;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final ArchiveViewModel getArchiveViewModel() {
        return (ArchiveViewModel) this.archiveViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ContextKt.getAppComponent(context).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ArchiveWebViewLayoutBinding.inflate(getLayoutInflater(), null, false);
        return getBinding().getRoot();
    }

    private final String getServiceUrl() {
        return (String) this.serviceUrl.getValue();
    }

    private final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        OnboardingViewModel onboardingViewModel = getOnboardingViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onboardingViewModel.observeState(viewLifecycleOwner, new Function1<OnboardingViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnboardingViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnboardingViewState onboardingViewState) {
                invoke2(onboardingViewState);
                return Unit.INSTANCE;
            }
        });
        if (get_prefManager().getOnboardingSettings().getNeedToShowArchiveInDevelopmentPopup()) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.action_global_to_abottomSheetAboutNewArchive, null, null, 6, null);
            getOnboardingViewModel().disableShowingArchiveInDevelopment();
        }
        getArchiveViewModel().loadArchiveLinks();
        ImageView btnAbout = getBinding().btnAbout;
        Intrinsics.checkNotNullExpressionValue(btnAbout, "btnAbout");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAbout, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(ArchiveWebView.this), R.id.action_global_to_abottomSheetAboutNewArchive, null, null, 6, null);
            }
        }, 1, null);
        ImageView btnBack = getBinding().btnBack;
        Intrinsics.checkNotNullExpressionValue(btnBack, "btnBack");
        SafeClickListenerKt.setSafeOnClickListener$default(btnBack, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FragmentKt.findNavController(ArchiveWebView.this).navigateUp();
            }
        }, 1, null);
        LinearLayout loader = getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader, "loader");
        ViewKt.visible(loader);
        ArchiveViewModel archiveViewModel = getArchiveViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        archiveViewModel.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ArchiveWebView archiveWebView = ArchiveWebView.this;
                LinearLayout root = archiveWebView.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(archiveWebView, root, it);
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    @SuppressLint({"SetJavaScriptEnabled"})
    public void initViews() {
        ArchiveWebViewLayoutBinding binding = getBinding();
        binding.webView.setWebViewClient(new MyWebViewClient());
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        binding.webView.getSettings().setDomStorageEnabled(true);
        binding.webView.getSettings().setDatabaseEnabled(true);
        binding.webView.getSettings().setLoadsImagesAutomatically(true);
        binding.webView.getSettings().setUseWideViewPort(true);
        binding.webView.getSettings().setLoadWithOverviewMode(true);
        binding.webView.getSettings().setBuiltInZoomControls(true);
        binding.webView.getSettings().setDisplayZoomControls(false);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            binding.webView.getSettings().setSafeBrowsingEnabled(true);
        }
        binding.webView.getSettings().setMixedContentMode(0);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(binding.webView, true);
        binding.webView.getSettings().setAllowContentAccess(true);
        binding.webView.getSettings().setAllowFileAccess(true);
        if (i >= 26) {
            binding.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        binding.webView.setWebChromeClient(new WebChromeClient() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$initViews$1$1
        });
        ConstraintLayout toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        WebView webView = binding.webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        ViewKt.addSystemWindowInsetToMargin$default(webView, true, false, true, true, 2, null);
        binding.webView.setDownloadListener(new DownloadListener() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$$ExternalSyntheticLambda1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                ArchiveWebView.initViews$lambda$4$lambda$1(this.f$0, str, str2, str3, str4, j);
            }
        });
        final String serviceUrl = getServiceUrl();
        if (serviceUrl != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ArchiveWebView.initViews$lambda$4$lambda$3$lambda$2(this.f$0, serviceUrl);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$1(ArchiveWebView this$0, String str, String str2, String str3, String str4, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            String strGuessFileName = URLUtil.guessFileName(str, str3, str4);
            DownloadManager.Request allowedOverRoaming = new DownloadManager.Request(Uri.parse(str)).setMimeType(str4).setTitle(strGuessFileName).setDescription(strGuessFileName).setNotificationVisibility(1).setAllowedOverMetered(true).setAllowedOverRoaming(true);
            String cookie = CookieManager.getInstance().getCookie(str);
            if (cookie != null) {
                allowedOverRoaming.addRequestHeader("Cookie", cookie);
            }
            if (str2 != null && str2.length() != 0) {
                allowedOverRoaming.addRequestHeader("User-Agent", str2);
            }
            allowedOverRoaming.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, strGuessFileName);
            Object systemService = this$0.requireContext().getSystemService("download");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
            ((DownloadManager) systemService).enqueue(allowedOverRoaming);
            this$0.getArchiveViewModel().notifyErrorMessage("Загрузка начата");
        } catch (Exception unused) {
            this$0.getArchiveViewModel().notifyErrorMessage("Ошибка загрузки");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4$lambda$3$lambda$2(ArchiveWebView this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.getBinding().webView.loadUrl(it);
    }

    /* compiled from: ArchiveWebView.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/archive/ArchiveWebView$MyWebViewClient;", "Landroid/webkit/WebViewClient;", "(Lsputnik/axmor/com/sputnik/ui/archive/ArchiveWebView;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class MyWebViewClient extends WebViewClient {
        public MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            view.loadUrl(url);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            LinearLayout loader = ArchiveWebView.this.getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            ViewKt.gone(loader);
            if (url != null && StringsKt.contains$default((CharSequence) url, (CharSequence) "#", false, 2, (Object) null)) {
                LinearLayout loader2 = ArchiveWebView.this.getBinding().loader;
                Intrinsics.checkNotNullExpressionValue(loader2, "loader");
                if (loader2.getVisibility() == 0 && view != null) {
                    view.loadUrl(url);
                }
            }
            LinearLayout loader3 = ArchiveWebView.this.getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader3, "loader");
            ViewKt.gone(loader3);
        }
    }

    public ArchiveWebView() {
        super(R.layout.archive_web_view_layout);
        final Function0 function0 = null;
        this.archiveViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ArchiveViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$archiveViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.serviceUrl = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$serviceUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("url");
                }
                return null;
            }
        });
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.archive.ArchiveWebView$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getBinding().webView.destroy();
        super.onDestroy();
        this._binding = null;
    }
}
