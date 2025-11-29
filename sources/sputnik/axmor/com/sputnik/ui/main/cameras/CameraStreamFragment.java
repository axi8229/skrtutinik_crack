package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.target.Target;
import com.google.android.exoplayer2.ui.PlayerView;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.CallLoader;
import com.sputnik.common.entities.localization.CallLocale;
import com.sputnik.common.entities.localization.CamerasBody;
import com.sputnik.common.entities.localization.CamerasLocale;
import com.sputnik.common.entities.localization.CamerasStream;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyBody;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentCameraStreamPreviewBinding;
import sputnik.axmor.com.sputnik.core.players.interfaces.PlayersCallback;
import sputnik.axmor.com.sputnik.core.players.manager.PlayersManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.views.ZoomOnDoubleTapListener;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: CameraStreamFragment.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010)\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010)\u001a\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010)\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010)\u001a\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010)\u001a\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010)\u001a\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006f"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/CameraStreamFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "loadImage", "showErrorLoadCamera", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentCameraStreamPreviewBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentCameraStreamPreviewBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel$delegate", "Lkotlin/Lazy;", "getCameraViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "cameraViewModel", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "playersManager", "Lsputnik/axmor/com/sputnik/core/players/manager/PlayersManager;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/entities/camera/Camera;", "camera$delegate", "getCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "camera", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "playersCallback", "Lsputnik/axmor/com/sputnik/core/players/interfaces/PlayersCallback;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraStreamFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CameraStreamFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentCameraStreamPreviewBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: camera$delegate, reason: from kotlin metadata */
    private final Lazy camera;

    /* renamed from: cameraViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cameraViewModel;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactory;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private final PlayersCallback playersCallback;
    private PlayersManager playersManager;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentCameraStreamPreviewBinding getBinding() {
        return (FragmentCameraStreamPreviewBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasFactory");
        return null;
    }

    private final AllCamerasViewModel getCameraViewModel() {
        return (AllCamerasViewModel) this.cameraViewModel.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
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

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    private final Camera getCamera() {
        return (Camera) this.camera.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Boolean contentIfNotHandled = getCameraViewModel().getCurrentState().getNeedUpdate().getContentIfNotHandled();
        if (contentIfNotHandled != null && contentIfNotHandled.booleanValue()) {
            getCameraViewModel().loadMainCameras();
        }
        LogUtilsKt.writeLog("GGGG: " + getCamera().getSubscriptionRequried());
        if (Intrinsics.areEqual(getCamera().getSubscriptionRequried(), Boolean.FALSE) || getCamera().getSubscriptionRequried() == null) {
            PlayersManager playersManager = this.playersManager;
            String strValueOf = String.valueOf(getCamera().getStreamUrl());
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            PlayerView playerView = getBinding().playerExo;
            SurfaceViewRenderer playerWebrtc = getBinding().playerWebrtc;
            Intrinsics.checkNotNullExpressionValue(playerWebrtc, "playerWebrtc");
            LinearLayout videoLoader = getBinding().videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            PlayersCallback playersCallback = this.playersCallback;
            Analytics analytics = getAnalytics();
            Boolean webrtcEnabled = getPrefManager().getExperimentalSettings().getWebrtcEnabled();
            playersManager.play(strValueOf, lifecycle, fragmentActivityRequireActivity, playerView, playerWebrtc, videoLoader, playersCallback, analytics, webrtcEnabled != null ? webrtcEnabled.booleanValue() : true);
        } else {
            LinearLayout layoutCameraLocked = getBinding().layoutCameraLocked;
            Intrinsics.checkNotNullExpressionValue(layoutCameraLocked, "layoutCameraLocked");
            ViewKt.visible(layoutCameraLocked);
            View viewDimSubscriptionRequired = getBinding().viewDimSubscriptionRequired;
            Intrinsics.checkNotNullExpressionValue(viewDimSubscriptionRequired, "viewDimSubscriptionRequired");
            ViewKt.visible(viewDimSubscriptionRequired);
            loadImage();
        }
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner, new Function1<SubscriptionsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
                invoke2(subscriptionsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubscriptionsViewState it) {
                BaseSubscription baseSubscription;
                SubscriptionAppearance appearance;
                SubscriptionBuyLocale subscriptionBuy;
                SubscriptionBuyBody body;
                TextTitle buyButton;
                SubscriptionAppearance appearance2;
                SubscriptionBuyLocale subscriptionBuy2;
                SubscriptionBuyBody body2;
                TextTitle buyButton2;
                SubscriptionDetails subscriptionDetails;
                List<Plan> plans;
                Plan plan;
                SubscriptionDetails subscriptionDetails2;
                List<Plan> plans2;
                Plan plan2;
                Plan.Promo promo;
                Object next;
                Intrinsics.checkNotNullParameter(it, "it");
                List<BaseSubscription> subscriptions = it.getSubscriptions();
                String priceText = null;
                if (subscriptions != null) {
                    Iterator<T> it2 = subscriptions.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it2.next();
                            if (Intrinsics.areEqual(((BaseSubscription) next).getIdentifier(), Subscriptions.standard.toString())) {
                                break;
                            }
                        }
                    }
                    baseSubscription = (BaseSubscription) next;
                } else {
                    baseSubscription = null;
                }
                Integer discountPrice = (baseSubscription == null || (subscriptionDetails2 = baseSubscription.getSubscriptionDetails()) == null || (plans2 = subscriptionDetails2.getPlans()) == null || (plan2 = (Plan) CollectionsKt.firstOrNull((List) plans2)) == null || (promo = plan2.getPromo()) == null) ? null : promo.getDiscountPrice();
                Integer price = (baseSubscription == null || (subscriptionDetails = baseSubscription.getSubscriptionDetails()) == null || (plans = subscriptionDetails.getPlans()) == null || (plan = (Plan) CollectionsKt.firstOrNull((List) plans)) == null) ? null : plan.getPrice();
                if (discountPrice == null) {
                    AppCompatButton appCompatButton = CameraStreamFragment.this.getBinding().btnSubscribe;
                    LocalizationLocalModel data = CameraStreamFragment.this.getLocalizationScreen().getData();
                    String strValueOf2 = String.valueOf((data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (body = subscriptionBuy.getBody()) == null || (buyButton = body.getBuyButton()) == null) ? null : buyButton.getTitle());
                    String strOrEmpty = price != null ? StringUtilsKt.orEmpty(price) : null;
                    if (baseSubscription != null && (appearance = baseSubscription.getAppearance()) != null) {
                        priceText = appearance.getPriceText();
                    }
                    appCompatButton.setText(StringUtilsKt.formatSafe(strValueOf2, strOrEmpty + " " + priceText));
                    return;
                }
                LocalizationLocalModel data2 = CameraStreamFragment.this.getLocalizationScreen().getData();
                String strValueOf3 = String.valueOf((data2 == null || (subscriptionBuy2 = data2.getSubscriptionBuy()) == null || (body2 = subscriptionBuy2.getBody()) == null || (buyButton2 = body2.getBuyButton()) == null) ? null : buyButton2.getTitle());
                String strOrEmpty2 = price != null ? StringUtilsKt.orEmpty(price) : null;
                String strOrEmpty3 = StringUtilsKt.orEmpty(discountPrice);
                if (baseSubscription != null && (appearance2 = baseSubscription.getAppearance()) != null) {
                    priceText = appearance2.getPriceText();
                }
                String safe = StringUtilsKt.formatSafe(strValueOf3, strOrEmpty2 + " " + strOrEmpty3 + " " + priceText);
                AppCompatButton btnSubscribe = CameraStreamFragment.this.getBinding().btnSubscribe;
                Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
                ViewUtilsKt.strikeThrouth(btnSubscribe, safe, String.valueOf(price), Integer.valueOf(ContextCompat.getColor(CameraStreamFragment.this.requireContext(), R.color.track_gray)));
            }
        });
    }

    public CameraStreamFragment() {
        super(R.layout.fragment_camera_stream_preview);
        this.binding = new ViewBindingFragmentDelegate(this, CameraStreamFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.cameraViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$cameraViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory camerasFactory = this.this$0.getCamerasFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return camerasFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function02);
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$special$$inlined$activityViewModels$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.playersManager = new PlayersManager();
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                return ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.call_nav_host_fragment);
            }
        });
        this.camera = LazyKt.lazy(new Function0<Camera>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$camera$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Camera invoke() {
                Bundle arguments = this.this$0.getArguments();
                Object obj = arguments != null ? arguments.get("ui.main.cameras.camera") : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.sputnik.common.entities.camera.Camera");
                return (Camera) obj;
            }
        });
        this.playersCallback = new CameraStreamFragment$playersCallback$1(this);
    }

    private final void loadImage() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ImageRequest imageRequestBuild = new ImageRequest.Builder(contextRequireContext).data(getCamera().getPreviewUrl()).target(new Target(this) { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$loadImage$$inlined$target$default$1
            @Override // coil.target.Target
            public void onStart(Drawable placeholder) {
            }

            @Override // coil.target.Target
            public void onError(Drawable error) {
                Log.e("camera error", String.valueOf(error));
                LinearLayout videoLoader = this.this$0.getBinding().videoLoader;
                Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
                ViewKt.gone(videoLoader);
            }

            @Override // coil.target.Target
            public void onSuccess(Drawable result) {
                if (this.this$0.getView() != null) {
                    this.this$0.getBinding().preview.setImageDrawable(result);
                    LinearLayout videoLoader = this.this$0.getBinding().videoLoader;
                    Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
                    ViewKt.gone(videoLoader);
                    HorizontalScrollView horizontalScrollView = this.this$0.getBinding().hsPreview;
                    final CameraStreamFragment cameraStreamFragment = this.this$0;
                    horizontalScrollView.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment$loadImage$request$2$1$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (cameraStreamFragment.getView() != null) {
                                CameraStreamFragment cameraStreamFragment2 = cameraStreamFragment;
                                cameraStreamFragment2.getBinding().hsPreview.scrollTo(cameraStreamFragment2.getBinding().preview.getWidth() / 3, 0);
                            }
                        }
                    });
                }
            }
        }).build();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        new ImageLoader.Builder(contextRequireContext2).build().enqueue(imageRequestBuild);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorLoadCamera() {
        CamerasLocale cameraList;
        CamerasStream stream;
        TextTitle noStream;
        if (getView() != null) {
            FragmentCameraStreamPreviewBinding binding = getBinding();
            LinearLayout previewError = binding.previewError;
            Intrinsics.checkNotNullExpressionValue(previewError, "previewError");
            ViewKt.visible(previewError);
            LinearLayout videoLoader = binding.videoLoader;
            Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
            ViewKt.gone(videoLoader);
            TextView textView = binding.tvError;
            LocalizationLocalModel data = getLocalizationScreen().getData();
            textView.setText((data == null || (cameraList = data.getCameraList()) == null || (stream = cameraList.getStream()) == null || (noStream = stream.getNoStream()) == null) ? null : noStream.getTitle());
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        AppCompatButton appCompatButton = getBinding().btnSubscribe;
        if (appCompatButton != null) {
            SafeClickListenerKt.setSafeOnClickListener$default(appCompatButton, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment.initViews.1
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
                    IntentProcessingUtilsKt.handleDeeplink(CameraStreamFragment.this.getString(R.string.deeplink_market_feature_extra_cameras), BundleKt.bundleOf(), CameraStreamFragment.this.getActivity(), CameraStreamFragment.this.getNavigationViewModel(), CameraStreamFragment.this.getProfileViewModel(), (64 & 32) != 0 ? null : null, (64 & 64) != 0 ? null : null);
                }
            }, 1, null);
        }
        ImageView btnBack = getBinding().btnBack;
        Intrinsics.checkNotNullExpressionValue(btnBack, "btnBack");
        ViewKt.addSystemWindowInsetToMargin$default(btnBack, true, true, false, false, 12, null);
        ImageView btnBack2 = getBinding().btnBack;
        Intrinsics.checkNotNullExpressionValue(btnBack2, "btnBack");
        SafeClickListenerKt.setSafeOnClickListener$default(btnBack2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment.initViews.2
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
                FragmentKt.findNavController(CameraStreamFragment.this).navigateUp();
            }
        }, 1, null);
        getBinding().layoutZoom.setMaxScale(12.0f);
        getBinding().layoutZoom2.setMaxScale(12.0f);
        getBinding().layoutZoom.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        getBinding().layoutZoom2.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false, 0.3f));
        getBinding().layoutZoom.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment.initViews.3
            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoom(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomBegin(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomEnd(ZoomLayout view, float scale) {
            }
        });
        getBinding().layoutZoom2.addOnZoomListener(new ZoomLayout.OnZoomListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.CameraStreamFragment.initViews.4
            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoom(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomBegin(ZoomLayout view, float scale) {
            }

            @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnZoomListener
            public void onZoomEnd(ZoomLayout view, float scale) {
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        CallLocale call;
        String locked;
        LocalizationLocalModel data;
        CamerasLocale cameraList;
        CamerasBody body;
        FragmentCameraStreamPreviewBinding binding = getBinding();
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 == null || (call = data2.getCall()) == null) {
            return;
        }
        TextView textView = binding.tvSubscriptionRequired;
        LocalizationStorage localizationScreen = getLocalizationScreen();
        if (localizationScreen == null || (data = localizationScreen.getData()) == null || (cameraList = data.getCameraList()) == null || (body = cameraList.getBody()) == null || (locked = body.getLocked()) == null) {
            locked = "";
        }
        textView.setText(locked);
        TextView textView2 = binding.tvLoader;
        CallLoader stream = call.getStream();
        textView2.setText(stream != null ? stream.getTitle() : null);
    }
}
