package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.adapters.VerticalTabAdapter;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.CamerasEvents;
import com.sputnik.common.analytics.MainScreenEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.base.adapters.ChildFragmentStateAdapter;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.demo.DemoModeLocale;
import com.sputnik.common.entities.localization.CamerasBody;
import com.sputnik.common.entities.localization.CamerasDoor;
import com.sputnik.common.entities.localization.CamerasLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.market.MarketItems;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.tiles.Tile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.VerticalTabLayout;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.CamerasState;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SingleCamera;
import com.sputnik.common.viewmodels.StateViewModel;
import com.sputnik.common.viewmodels.StateViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.common.viewmodels.SurveysState;
import com.sputnik.common.viewmodels.SurveysViewModel;
import com.sputnik.common.viewmodels.TilesState;
import com.sputnik.common.viewmodels.TilesViewModel;
import com.sputnik.common.viewmodels.interfaces.ICamerasViewModel;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Errors$DoorError$DeviceOffline;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.ui.FragmentNavigation;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.PaymentsViewModel;
import com.sputnik.service_payments.viewmodel.PaymentsViewState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.GlobalCamerasFragmentBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCameraFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.market.NewMarketFragment;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;
import sputnik.axmor.com.sputnik.ui.views.OpenDoorButtonView;
import sputnik.axmor.com.sputnik.ui.views.SecondaryOpenDoorButtonView;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: GlobalCamerasFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ®\u00012\u00020\u0001:\u0002®\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0019\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u0003J\u0017\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\u0003J!\u00104\u001a\u00020\b2\u0006\u0010\r\u001a\u0002012\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\bH\u0016¢\u0006\u0004\b6\u0010\u0003J\u000f\u00107\u001a\u00020\bH\u0016¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\bH\u0016¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010\u0003R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010_\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010_\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010_\u001a\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010_\u001a\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010_\u001a\u0004\by\u0010zR\u001c\u0010\u0080\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b}\u0010_\u001a\u0004\b~\u0010\u007fR \u0010\u0085\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010_\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u008a\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0087\u0001\u0010_\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008f\u0001\u001a\u00030\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u0010_\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0094\u0001\u001a\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010_\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R \u0010\u0099\u0001\u001a\u00030\u0095\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010_\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009e\u0001\u001a\u00030\u009a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009b\u0001\u0010_\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0017\u0010\u009f\u0001\u001a\u00020\u00048\u0002X\u0082D¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001a\u0010¢\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R*\u0010¥\u0001\u001a\u00030¤\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010¬\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001¨\u0006¯\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCamerasFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "tilesCount", "calculateSmartCardWidth", "(I)I", "", "handleServicesInfo", "", "imageUrl", "Landroid/widget/ImageView;", "view", "loadImage", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "Lcom/sputnik/common/viewmodels/CamerasState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/CamerasState;)V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", "renderProfileUi", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "Lcom/sputnik/common/viewmodels/SingleCamera;", "camera", "renderCurrentCamera", "(Lcom/sputnik/common/viewmodels/SingleCamera;)V", "Lcom/sputnik/common/entities/camera/Camera;", "doWithCamera", "(Lcom/sputnik/common/entities/camera/Camera;)V", "", "cameras", "doWithCameras", "(Ljava/util/List;)V", "doWithNoCamera", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "setTitleDoor", "(Ljava/lang/String;)V", "setTitleSecondDoor", "showBlocking", "hideBlocking", "openDoor", "openSecondDoor", "navigateToCallHistory", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onStart", "Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "initViews", "onDestroyView", "onDestroy", "localize", "Lsputnik/axmor/com/databinding/GlobalCamerasFragmentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/GlobalCamerasFragmentBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "Lkotlin/Lazy;", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel$delegate", "getPaymentsViewModel", "()Lcom/sputnik/service_payments/viewmodel/PaymentsViewModel;", "paymentsViewModel", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "Lcom/sputnik/common/viewmodels/TilesViewModel;", "tilesViewModel$delegate", "getTilesViewModel", "()Lcom/sputnik/common/viewmodels/TilesViewModel;", "tilesViewModel", "Lcom/sputnik/common/viewmodels/StateViewModel;", "stateViewModel$delegate", "getStateViewModel", "()Lcom/sputnik/common/viewmodels/StateViewModel;", "stateViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel$delegate", "getSurveysViewModel", "()Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "PAGE_LIMIT", "I", "Lcom/sputnik/common/base/adapters/ChildFragmentStateAdapter;", "adapter", "Lcom/sputnik/common/base/adapters/ChildFragmentStateAdapter;", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/adapters/VerticalTabAdapter;", "tabsAdapter", "Lcom/sputnik/common/adapters/VerticalTabAdapter;", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalCamerasFragment extends BaseFragment {
    private static Camera cameraToSelect;
    private final int PAGE_LIMIT;
    private ChildFragmentStateAdapter adapter;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;

    /* renamed from: paymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy paymentsViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;

    /* renamed from: stateViewModel$delegate, reason: from kotlin metadata */
    private final Lazy stateViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* renamed from: surveysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveysViewModel;
    private final VerticalTabAdapter tabsAdapter;

    /* renamed from: tilesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy tilesViewModel;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GlobalCamerasFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/GlobalCamerasFragmentBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isPortrait = true;

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockingLevel.values().length];
            try {
                iArr[BlockingLevel.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GlobalCamerasFragmentBinding getBinding() {
        return (GlobalCamerasFragmentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentsViewModel getPaymentsViewModel() {
        return (PaymentsViewModel) this.paymentsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    private final TilesViewModel getTilesViewModel() {
        return (TilesViewModel) this.tilesViewModel.getValue();
    }

    private final StateViewModel getStateViewModel() {
        return (StateViewModel) this.stateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SurveysViewModel getSurveysViewModel() {
        return (SurveysViewModel) this.surveysViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(512);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        this.adapter = new ChildFragmentStateAdapter(childFragmentManager, getViewLifecycleOwner().getLifecycle(), null, 4, null);
        ViewPager2 viewPager2 = getBinding().viewpager2;
        ChildFragmentStateAdapter childFragmentStateAdapter = this.adapter;
        if (childFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            childFragmentStateAdapter = null;
        }
        viewPager2.setAdapter(childFragmentStateAdapter);
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.1
                {
                    super(true);
                }

                @Override // androidx.view.OnBackPressedCallback
                public void handleOnBackPressed() {
                    if (getIsEnabled()) {
                        setEnabled(false);
                        SputnikRootActivity.INSTANCE.setChangingOrientation(true);
                        Companion companion = GlobalCamerasFragment.INSTANCE;
                        if (companion.isPortrait()) {
                            return;
                        }
                        FragmentActivity activity2 = GlobalCamerasFragment.this.getActivity();
                        if (activity2 != null) {
                            activity2.setRequestedOrientation(1);
                        }
                        GlobalCamerasFragment.this.getNavigationViewModel().showBottomNavigationMenu();
                        companion.setPortrait(true);
                    }
                }
            });
        }
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        camerasViewModel.observeSubState(viewLifecycleOwner2, new Function1<AllCamerasViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedReloadCameras());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    if (GlobalCamerasFragment.this.getPrefManager().getIsNoDomofon()) {
                        GlobalCamerasFragment.this.getCamerasViewModel().loadDemoCameras();
                    } else {
                        GlobalCamerasFragment.this.getCamerasViewModel().loadMainCameras();
                    }
                    GlobalCamerasFragment.this.getCamerasViewModel().setNeedLoadCameras(false);
                }
            }
        });
        AllCamerasViewModel camerasViewModel2 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        camerasViewModel2.observeSubState(viewLifecycleOwner3, new AnonymousClass4(CamerasState.INSTANCE), new AnonymousClass5(this));
        AllCamerasViewModel camerasViewModel3 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        camerasViewModel3.observeSubState(viewLifecycleOwner4, new AnonymousClass6(SingleCamera.INSTANCE), new AnonymousClass7(this));
        AllCamerasViewModel camerasViewModel4 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        camerasViewModel4.observeSubState(viewLifecycleOwner5, new Function1<AllCamerasViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.8
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getIsLoadingCamera());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.9
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
        AllCamerasViewModel camerasViewModel5 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        camerasViewModel5.observeSubState(viewLifecycleOwner6, new Function1<AllCamerasViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.10
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getZoomMode());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (GlobalCamerasFragment.INSTANCE.isPortrait()) {
                    GlobalCamerasFragment.this.getBinding().viewpager2.setUserInputEnabled(!z);
                } else {
                    GlobalCamerasFragment.this.getBinding().viewpager2.setUserInputEnabled(false);
                }
            }
        });
        AllCamerasViewModel camerasViewModel6 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        camerasViewModel6.observeSubState(viewLifecycleOwner7, new Function1<AllCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.12
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getDoorIsOpen();
            }
        }, new AnonymousClass13());
        AllCamerasViewModel camerasViewModel7 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        camerasViewModel7.observeNotifications(viewLifecycleOwner8, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.14
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
                GlobalCamerasFragment globalCamerasFragment = GlobalCamerasFragment.this;
                ConstraintLayout root = globalCamerasFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(globalCamerasFragment, root, it);
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner9, new AnonymousClass15(this));
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeSubState(viewLifecycleOwner10, new Function1<ServicePaymentsViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.16
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ServicePaymentsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedToReload();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.17
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.peekContent().booleanValue()) {
                    GlobalCamerasFragment.this.getCamerasViewModel().loadMainCameras();
                    IProfileViewModel.DefaultImpls.loadProfile$default(GlobalCamerasFragment.this.getProfileViewModel(), false, 1, null);
                }
            }
        });
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "getViewLifecycleOwner(...)");
        marketViewModel.observeState(viewLifecycleOwner11, new Function1<MarketViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.18
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MarketViewState marketViewState) {
                invoke2(marketViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getServicesState() == Resource.Status.SUCCESS) {
                    GlobalCamerasFragment.this.handleServicesInfo();
                }
            }
        });
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner12 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner12, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner12, new Function1<SubscriptionsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.19
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
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getMarketState() == Resource.Status.SUCCESS) {
                    GlobalCamerasFragment.this.handleServicesInfo();
                }
                ImageView imageView = GlobalCamerasFragment.this.getBinding().btnChangeAddress;
                if (imageView != null) {
                    ViewBindingUtilsKt.visibilityGoneBasedOn(imageView, !GlobalCamerasFragment.this.getSubscriptionsViewModel().isMarketLocked());
                }
            }
        });
        getCamerasViewModel().loadCamerasIfNeeded();
        PaymentsViewModel paymentsViewModel = getPaymentsViewModel();
        LifecycleOwner viewLifecycleOwner13 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner13, "getViewLifecycleOwner(...)");
        paymentsViewModel.observeSubState(viewLifecycleOwner13, new Function1<PaymentsViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.20
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(PaymentsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isPayed();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.21
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.peekContent().booleanValue()) {
                    IProfileViewModel.DefaultImpls.loadProfile$default(GlobalCamerasFragment.this.getProfileViewModel(), false, 1, null);
                    GlobalCamerasFragment.this.getCamerasViewModel().loadMainCameras();
                    GlobalCamerasFragment.this.getPaymentsViewModel().clearPaymentState();
                    NavController navController = GlobalCamerasFragment.this.getNavController();
                    Pair pair = TuplesKt.to(RemoteMessageConst.FROM, 2002);
                    PaymentHistory payment = GlobalCamerasFragment.this.getServicePaymentsViewModel().getCurrentState().getPayment();
                    NavControllerKt.safeNavigate$default(navController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_fragmentSuccessPayment, BundleKt.bundleOf(pair, TuplesKt.to("accrual_uuid", payment != null ? payment.getId() : null)), null, 8, null);
                }
            }
        });
        View view2 = getBinding().viewLocked;
        if (view2 != null) {
            SafeClickListenerKt.setSafeOnClickListener$default(view2, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.22
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                    invoke2(view3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GlobalCamerasFragment.this.getOnboardingViewModel().lockGalleryOnboarding();
                    View view3 = GlobalCamerasFragment.this.getBinding().viewLocked;
                    if (view3 != null) {
                        ViewKt.gone(view3);
                    }
                    TextView textView = GlobalCamerasFragment.this.getBinding().tvGalleryOnboarding;
                    if (textView != null) {
                        ViewKt.gone(textView);
                    }
                    ImageView imageView = GlobalCamerasFragment.this.getBinding().ivGalleryOnboarding;
                    if (imageView != null) {
                        ViewKt.gone(imageView);
                    }
                }
            }, 1, null);
        }
        getSurveysViewModel().observeState(this, new Function1<SurveysState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.23
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurveysState surveysState) throws Resources.NotFoundException {
                invoke2(surveysState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurveysState state) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(state, "state");
                Boolean contentIfNotHandled = state.getNeedToReload().getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    GlobalCamerasFragment globalCamerasFragment = GlobalCamerasFragment.this;
                    if (contentIfNotHandled.booleanValue() && state.getServerState() == Resource.Status.NONE) {
                        globalCamerasFragment.getSurveysViewModel().loadSurveys();
                    }
                }
                if (state.getSurveysDismissed()) {
                    return;
                }
                if (state.getServerState() == Resource.Status.ERROR || state.getServerState() == Resource.Status.SUCCESS) {
                    try {
                        ImageView imageView = GlobalCamerasFragment.this.getBinding().btnVisitsHistory;
                        if (imageView != null) {
                            Intrinsics.checkNotNull(imageView);
                            ViewKt.enable(imageView);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (state.getServerState() == Resource.Status.ERROR && Intrinsics.areEqual(state.getLastRequestedSurveyName(), "promo_visitors")) {
                    GlobalCamerasFragment.this.getSurveysViewModel().clearState();
                    GlobalCamerasFragment.this.navigateToCallHistory();
                    return;
                }
                if ((state.getSurveys() == null || !(!r0.isEmpty())) && state.getRequestedSurvey() == null) {
                    return;
                }
                GlobalCamerasFragment.this.getSurveysViewModel().lockSurveys();
                GlobalCamerasFragment.this.getNavigationViewModel().addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.to_navigation_poll, "", null, null, 12, null))), false, 4, null));
            }
        });
        TilesViewModel tilesViewModel = getTilesViewModel();
        LifecycleOwner viewLifecycleOwner14 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner14, "getViewLifecycleOwner(...)");
        tilesViewModel.observeState(viewLifecycleOwner14, new Function1<TilesState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.24
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TilesState tilesState) {
                invoke2(tilesState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TilesState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LinearLayout linearLayout = GlobalCamerasFragment.this.getBinding().layoutTilesList;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                }
                List<Tile> tiles = it.getTiles();
                if (tiles != null) {
                    final GlobalCamerasFragment globalCamerasFragment = GlobalCamerasFragment.this;
                    int i = 0;
                    for (Object obj : tiles) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        final Tile tile = (Tile) obj;
                        List<Tile> tiles2 = it.getTiles();
                        int iCalculateSmartCardWidth = globalCamerasFragment.calculateSmartCardWidth(tiles2 != null ? tiles2.size() : 0);
                        ImageView imageView = new ImageView(globalCamerasFragment.requireContext());
                        SafeClickListenerKt.setSafeOnClickListener(imageView, 500L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$24$1$imageView$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                                invoke2(view3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(View it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                Analytics analytics = globalCamerasFragment.getAnalytics();
                                String identifier = tile.getIdentifier();
                                if (identifier == null) {
                                    identifier = "";
                                }
                                analytics.trackLogEvent(new MainScreenEvents.ClickStoryTile(identifier));
                                String identifier2 = tile.getIdentifier();
                                if (Intrinsics.areEqual(identifier2 != null ? identifier2 : "", "ble")) {
                                    if (globalCamerasFragment.getSubscriptionsViewModel().hasSubscription()) {
                                        IntentProcessingUtilsKt.handleDeeplink(globalCamerasFragment.getString(R.string.deeplink_services_ble), BundleKt.bundleOf(), globalCamerasFragment.requireActivity(), globalCamerasFragment.getNavigationViewModel(), globalCamerasFragment.getProfileViewModel(), globalCamerasFragment.getAnalytics(), globalCamerasFragment.getNavController());
                                        return;
                                    } else {
                                        IntentProcessingUtilsKt.handleDeeplink(globalCamerasFragment.getString(R.string.deeplink_market_feature_ble), BundleKt.bundleOf(), globalCamerasFragment.requireActivity(), globalCamerasFragment.getNavigationViewModel(), globalCamerasFragment.getProfileViewModel(), globalCamerasFragment.getAnalytics(), globalCamerasFragment.getNavController());
                                        return;
                                    }
                                }
                                IntentProcessingUtilsKt.handleDeeplink(tile.getDeeplink(), BundleKt.bundleOf(), globalCamerasFragment.requireActivity(), globalCamerasFragment.getNavigationViewModel(), globalCamerasFragment.getProfileViewModel(), globalCamerasFragment.getAnalytics(), globalCamerasFragment.getNavController());
                            }
                        });
                        Context contextRequireContext = globalCamerasFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iCalculateSmartCardWidth, DpUtilsKt.dpToPx(contextRequireContext, 72));
                        Context contextRequireContext2 = globalCamerasFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        layoutParams.setMarginStart(DpUtilsKt.dpToPx(contextRequireContext2, 20));
                        List<Tile> tiles3 = it.getTiles();
                        if (tiles3 != null && i == CollectionsKt.getLastIndex(tiles3)) {
                            Context contextRequireContext3 = globalCamerasFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                            layoutParams.setMarginEnd(DpUtilsKt.dpToPx(contextRequireContext3, 20));
                        }
                        imageView.setLayoutParams(layoutParams);
                        globalCamerasFragment.loadImage(String.valueOf(tile.getImgLink()), imageView);
                        LinearLayout linearLayout2 = globalCamerasFragment.getBinding().layoutTilesList;
                        if (linearLayout2 != null) {
                            linearLayout2.addView(imageView);
                        }
                        i = i2;
                    }
                }
            }
        });
        StateViewModel stateViewModel = getStateViewModel();
        LifecycleOwner viewLifecycleOwner15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner15, "getViewLifecycleOwner(...)");
        stateViewModel.observeState(viewLifecycleOwner15, new Function1<StateViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.onViewCreated.25
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StateViewState stateViewState) {
                invoke2(stateViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StateViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ImageView viewVpn = GlobalCamerasFragment.this.getBinding().viewVpn;
                Intrinsics.checkNotNullExpressionValue(viewVpn, "viewVpn");
                ViewBindingUtilsKt.visibilityBasedOn(viewVpn, Boolean.valueOf(it.getIsVpnEnabled()));
                GlobalCamerasFragment.INSTANCE.isPortrait();
            }
        });
    }

    public GlobalCamerasFragment() {
        super(R.layout.global_cameras_fragment);
        this.binding = new ViewBindingFragmentDelegate(this, GlobalCamerasFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.paymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$17
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$paymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$19
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$20
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$22
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$23
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.tilesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TilesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$25
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$26
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$tilesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.stateViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(StateViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$28
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$29
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$stateViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$31
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$32
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.surveysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$34
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$special$$inlined$activityViewModels$default$35
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$surveysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$navController$2
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
        this.PAGE_LIMIT = 15;
        this.tabsAdapter = new VerticalTabAdapter(new ArrayList(), new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$tabsAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                this.this$0.getCamerasViewModel().handleCamera(i);
                this.this$0.getBinding().viewpager2.setCurrentItem(i);
                VerticalTabLayout verticalTabLayout = this.this$0.getBinding().tabs;
                Intrinsics.checkNotNull(verticalTabLayout, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
                verticalTabLayout.setCurrentItem(i);
            }
        });
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<AllCamerasViewState, CamerasState> {
        AnonymousClass4(Object obj) {
            super(1, obj, CamerasState.Companion.class, "toCamerasState", "toCamerasState(Lcom/sputnik/common/viewmodels/AllCamerasViewState;)Lcom/sputnik/common/viewmodels/CamerasState;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CamerasState invoke(AllCamerasViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((CamerasState.Companion) this.receiver).toCamerasState(p0);
        }
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<CamerasState, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, GlobalCamerasFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/CamerasState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CamerasState camerasState) {
            invoke2(camerasState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CamerasState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((GlobalCamerasFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<AllCamerasViewState, SingleCamera> {
        AnonymousClass6(Object obj) {
            super(1, obj, SingleCamera.Companion.class, "toSingleCamera", "toSingleCamera(Lcom/sputnik/common/viewmodels/AllCamerasViewState;)Lcom/sputnik/common/viewmodels/SingleCamera;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final SingleCamera invoke(AllCamerasViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((SingleCamera.Companion) this.receiver).toSingleCamera(p0);
        }
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<SingleCamera, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, GlobalCamerasFragment.class, "renderCurrentCamera", "renderCurrentCamera(Lcom/sputnik/common/viewmodels/SingleCamera;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SingleCamera singleCamera) {
            invoke2(singleCamera);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SingleCamera p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((GlobalCamerasFragment) this.receiver).renderCurrentCamera(p0);
        }
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/sputnik/domain/common/Event;", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$13, reason: invalid class name */
    static final class AnonymousClass13 extends Lambda implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass13() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
            CamerasLocale cameraList;
            CamerasBody body;
            CamerasDoor doorLabels;
            CamerasLocale cameraList2;
            CamerasBody body2;
            CamerasDoor doorLabels2;
            Intrinsics.checkNotNullParameter(it, "it");
            Boolean contentIfNotHandled = it.getContentIfNotHandled();
            if (contentIfNotHandled != null) {
                final GlobalCamerasFragment globalCamerasFragment = GlobalCamerasFragment.this;
                if (contentIfNotHandled.booleanValue()) {
                    TextView textView = globalCamerasFragment.getBinding().mainTextButton;
                    LocalizationLocalModel data = globalCamerasFragment.getLocalizationScreen().getData();
                    if (data != null && (cameraList2 = data.getCameraList()) != null && (body2 = cameraList2.getBody()) != null && (doorLabels2 = body2.getDoorLabels()) != null) {
                        titleOpen = doorLabels2.getTitleOpen();
                    }
                    textView.setText(titleOpen);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$13$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            GlobalCamerasFragment.AnonymousClass13.invoke$lambda$3$lambda$1(globalCamerasFragment);
                        }
                    }, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
                    return;
                }
                TextView textView2 = globalCamerasFragment.getBinding().mainTextButton;
                LocalizationLocalModel data2 = globalCamerasFragment.getLocalizationScreen().getData();
                textView2.setText((data2 == null || (cameraList = data2.getCameraList()) == null || (body = cameraList.getBody()) == null || (doorLabels = body.getDoorLabels()) == null) ? null : doorLabels.getTitleClose());
                if (globalCamerasFragment.getCamerasViewModel().getCurrentState().getException() instanceof Errors$DoorError$DeviceOffline) {
                    if (globalCamerasFragment.getCamerasViewModel().getCurrentState().getEmergencyCode() == null) {
                        NavControllerKt.safeNavigate$default(globalCamerasFragment.getNavController(), R.id.action_global_to_info_dialog, null, null, 6, null);
                    }
                    String emergencyCode = globalCamerasFragment.getCamerasViewModel().getCurrentState().getEmergencyCode();
                    if (emergencyCode != null) {
                        NavController navController = globalCamerasFragment.getNavController();
                        Pair pair = TuplesKt.to("code", emergencyCode);
                        Camera currentCamera = globalCamerasFragment.getCamerasViewModel().getCurrentState().getCurrentCamera();
                        NavControllerKt.safeNavigate$default(navController, R.id.mainHostFragment, R.id.action_mainHostFragment_to_emergencyCodeBottomSheet, BundleKt.bundleOf(pair, TuplesKt.to("id", currentCamera != null ? currentCamera.getIntercomUuid() : null)), null, 8, null);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$1(GlobalCamerasFragment this$0) {
            CamerasLocale cameraList;
            CamerasBody body;
            CamerasDoor doorLabels;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getView() != null) {
                TextView textView = this$0.getBinding().mainTextButton;
                LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
                textView.setText((data == null || (cameraList = data.getCameraList()) == null || (body = cameraList.getBody()) == null || (doorLabels = body.getDoorLabels()) == null) ? null : doorLabels.getTitleClose());
            }
        }
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$onViewCreated$15, reason: invalid class name */
    /* synthetic */ class AnonymousClass15 extends FunctionReferenceImpl implements Function1<ProfileViewState, Unit> {
        AnonymousClass15(Object obj) {
            super(1, obj, GlobalCamerasFragment.class, "renderProfileUi", "renderProfileUi(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
            invoke2(profileViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((GlobalCamerasFragment) this.receiver).renderProfileUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateSmartCardWidth(int tilesCount) {
        HorizontalScrollView horizontalScrollView = getBinding().layoutTiles;
        int width = horizontalScrollView != null ? horizontalScrollView.getWidth() : 0;
        if (width == 0) {
            width = requireContext().getResources().getDisplayMetrics().widthPixels;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iDpToPx = DpUtilsKt.dpToPx(contextRequireContext, 16);
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        int iDpToPx2 = DpUtilsKt.dpToPx(contextRequireContext2, 4);
        int i = width - (iDpToPx * 2);
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        int iDpToPx3 = DpUtilsKt.dpToPx(contextRequireContext3, 128);
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        DpUtilsKt.dpToPx(contextRequireContext4, 72);
        if (tilesCount == 0) {
            HorizontalScrollView horizontalScrollView2 = getBinding().layoutTiles;
            if (horizontalScrollView2 == null) {
                return 0;
            }
            horizontalScrollView2.setVisibility(8);
            return 0;
        }
        if (tilesCount == 1) {
            HorizontalScrollView horizontalScrollView3 = getBinding().layoutTiles;
            if (horizontalScrollView3 != null) {
                horizontalScrollView3.setVisibility(0);
            }
            return Math.min((int) (i * 0.7f), iDpToPx3);
        }
        if (tilesCount == 2) {
            HorizontalScrollView horizontalScrollView4 = getBinding().layoutTiles;
            if (horizontalScrollView4 != null) {
                horizontalScrollView4.setVisibility(0);
            }
            return Math.min((int) ((i - iDpToPx2) / 1.3f), iDpToPx3);
        }
        HorizontalScrollView horizontalScrollView5 = getBinding().layoutTiles;
        if (horizontalScrollView5 != null) {
            horizontalScrollView5.setVisibility(0);
        }
        int iMin = Math.min((int) ((i - iDpToPx2) / 2.5f), iDpToPx3);
        Context contextRequireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
        return RangesKt.coerceAtLeast(iMin, DpUtilsKt.dpToPx(contextRequireContext5, 90));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleServicesInfo() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.handleServicesInfo():void");
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$loadImage$1", f = "GlobalCamerasFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$loadImage$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imageUrl;
        final /* synthetic */ ImageView $view;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImageView imageView, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$view = imageView;
            this.$imageUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$view, this.$imageUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Glide.with(this.$view).load(this.$imageUrl).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new RequestListener<Drawable>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.loadImage.1.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    return false;
                }
            }).into(this.$view);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadImage(String imageUrl, ImageView view) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, imageUrl, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    GlobalCamerasFragment.onResume$lambda$11(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$11(GlobalCamerasFragment this$0) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Camera camera = cameraToSelect;
        if (camera != null) {
            Iterator<T> it = this$0.getCamerasViewModel().getCurrentCameras().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((Camera) next).getUuid(), camera.getUuid())) {
                        break;
                    }
                }
            }
            Camera camera2 = (Camera) next;
            if (camera2 != null) {
                this$0.tabsAdapter.select(camera2);
                this$0.getBinding().viewpager2.setCurrentItem(this$0.getCamerasViewModel().getCurrentCameras().indexOf(camera2));
            }
            this$0.getCamerasViewModel().handleCamera(CollectionsKt.indexOf((List<? extends Camera>) this$0.getCamerasViewModel().getCurrentCameras(), camera2));
            cameraToSelect = null;
        }
        this$0.getCamerasViewModel().loadCamerasIfNeeded();
        GlobalVariables globalVariables = GlobalVariables.INSTANCE;
        if (globalVariables.getNeedNavigateToMarket()) {
            try {
                NavController bottomController = globalVariables.getBottomController();
                if (bottomController != null) {
                    Uri uri = Uri.parse(this$0.getString(R.string.deeplink_market));
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                    bottomController.navigate(uri);
                }
                NewMarketFragment.INSTANCE.setDestination(MarketItems.SUBS);
                globalVariables.setNeedNavigateToMarket(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(CamerasState data) {
        if (data.getServerState() == Resource.Status.SUCCESS) {
            if (!getProfileViewModel().getIsInDemoMode()) {
                ImageView imageView = getBinding().ivGallery;
                if (imageView != null) {
                    ViewKt.visible(imageView);
                }
                getOnboardingViewModel().getCurrentState().getNeedToShowGalleryOnboarding().getContentIfNotHandled();
            }
            List<Camera> cameras = data.getCameras();
            ArrayList arrayList = new ArrayList();
            for (Object obj : cameras) {
                if (((Camera) obj).getMainScreen()) {
                    arrayList.add(obj);
                }
            }
            doWithCameras(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderProfileUi(ProfileViewState data) {
        LogUtilsKt.writeLog(String.valueOf(data.getBlockLevel()));
        BlockingLevel blockLevel = data.getBlockLevel();
        if ((blockLevel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[blockLevel.ordinal()]) == 1) {
            showBlocking();
        } else {
            hideBlocking();
        }
        if (data.getProfileServerState() == Resource.Status.SUCCESS) {
            Intrinsics.checkNotNull(data.getProfile());
            ImageView imageView = getBinding().historyButton;
            if (imageView != null) {
                SafeClickListenerKt.setSafeOnClickListener$default(imageView, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.renderProfileUi.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View it) throws Resources.NotFoundException {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Companion companion = GlobalCamerasFragment.INSTANCE;
                        if (companion.isPortrait()) {
                            try {
                                Profile profile = GlobalCamerasFragment.this.getProfileViewModel().getCurrentState().getProfile();
                                if (profile != null ? Intrinsics.areEqual(profile.getIsNeedFeedback(), Boolean.TRUE) : false) {
                                    ImageView imageView2 = GlobalCamerasFragment.this.getBinding().historyButton;
                                    if (imageView2 != null) {
                                        ViewKt.disable(imageView2);
                                    }
                                    GlobalCamerasFragment.this.getSurveysViewModel().loadSurvey("promo_visitors");
                                    return;
                                }
                                GlobalCamerasFragment.this.navigateToCallHistory();
                                return;
                            } catch (Exception unused) {
                                GlobalCamerasFragment.this.navigateToCallHistory();
                                return;
                            }
                        }
                        FragmentActivity activity = GlobalCamerasFragment.this.getActivity();
                        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity");
                        ((SputnikRootActivity) activity).changeOrientation();
                        GlobalCamerasFragment.this.getNavigationViewModel().showBottomNavigationMenu();
                        companion.setPortrait(true);
                    }
                }, 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderCurrentCamera(SingleCamera camera) {
        Camera camera2 = cameraToSelect;
        if (camera2 != null) {
            Intrinsics.checkNotNull(camera2);
            doWithCamera(camera2);
        } else if (camera.getCurrentCamera() != null) {
            Camera currentCamera = camera.getCurrentCamera();
            Intrinsics.checkNotNull(currentCamera);
            doWithCamera(currentCamera);
        }
    }

    private final void doWithCamera(Camera camera) {
        CamerasLocale cameraList;
        CamerasBody body;
        CamerasDoor doorLabels;
        CamerasLocale cameraList2;
        CamerasBody body2;
        CamerasDoor doorLabels2;
        GlobalCamerasFragmentBinding binding = getBinding();
        setTitleDoor(camera.getTitle());
        Camera.ExtraKeyReader extraKeyReader = camera.getExtraKeyReader();
        String titleAuth = null;
        setTitleSecondDoor(extraKeyReader != null ? extraKeyReader.getAlias() : null);
        VerticalTabLayout verticalTabLayout = getBinding().tabs;
        Intrinsics.checkNotNull(verticalTabLayout, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
        verticalTabLayout.setLiveStateForCamera(camera);
        Boolean canOpen = camera.getCanOpen();
        Boolean bool = Boolean.TRUE;
        boolean z = Intrinsics.areEqual(canOpen, bool) || getPrefManager().getIsNoDomofon();
        OpenDoorButtonView mainOpenDoorBtn = binding.mainOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(mainOpenDoorBtn, "mainOpenDoorBtn");
        ViewBindingUtilsKt.visibilityHideBasedOn(mainOpenDoorBtn, z);
        SecondaryOpenDoorButtonView secondaryOpenDoorBtn = binding.secondaryOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(secondaryOpenDoorBtn, "secondaryOpenDoorBtn");
        ViewBindingUtilsKt.visibilityBasedOn(secondaryOpenDoorBtn, Boolean.valueOf(extraKeyReader != null && Intrinsics.areEqual(camera.getCanOpen(), bool)));
        TextView textView = binding.mainTextButton;
        if (!getPrefManager().getIsNoDomofon()) {
            LocalizationLocalModel data = getLocalizationScreen().getData();
            if (data != null && (cameraList2 = data.getCameraList()) != null && (body2 = cameraList2.getBody()) != null && (doorLabels2 = body2.getDoorLabels()) != null) {
                titleAuth = doorLabels2.getTitleClose();
            }
        } else {
            TextView textView2 = binding.tvTitleCamera;
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            if (data2 != null && (cameraList = data2.getCameraList()) != null && (body = cameraList.getBody()) != null && (doorLabels = body.getDoorLabels()) != null) {
                titleAuth = doorLabels.getTitleAuth();
            }
            textView2.setText(titleAuth);
            TextView tvTitleCamera = binding.tvTitleCamera;
            Intrinsics.checkNotNullExpressionValue(tvTitleCamera, "tvTitleCamera");
            ViewKt.visible(tvTitleCamera);
            OpenDoorButtonView mainOpenDoorBtn2 = binding.mainOpenDoorBtn;
            Intrinsics.checkNotNullExpressionValue(mainOpenDoorBtn2, "mainOpenDoorBtn");
            ViewKt.gone(mainOpenDoorBtn2);
            TextView textView3 = binding.secondTextButton;
            if (textView3 != null) {
                Intrinsics.checkNotNull(textView3);
                ViewKt.gone(textView3);
            }
            titleAuth = "";
        }
        textView.setText(titleAuth);
    }

    private final void doWithCameras(List<Camera> cameras) {
        ChildFragmentStateAdapter childFragmentStateAdapter = null;
        getBinding().viewpager2.setAdapter(null);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        this.adapter = new ChildFragmentStateAdapter(childFragmentManager, getViewLifecycleOwner().getLifecycle(), null, 4, null);
        ViewPager2 viewPager2 = getBinding().viewpager2;
        ChildFragmentStateAdapter childFragmentStateAdapter2 = this.adapter;
        if (childFragmentStateAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            childFragmentStateAdapter2 = null;
        }
        viewPager2.setAdapter(childFragmentStateAdapter2);
        if (cameras.isEmpty()) {
            doWithNoCamera();
            return;
        }
        if (getBinding().viewpager2.getAdapter() == null) {
            this.tabsAdapter.submitList(CollectionsKt.toMutableList((Collection) cameras));
            VerticalTabLayout verticalTabLayout = getBinding().tabs;
            Intrinsics.checkNotNull(verticalTabLayout, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
            verticalTabLayout.setCamerasSize(cameras.size());
            VerticalTabLayout verticalTabLayout2 = getBinding().tabs;
            Intrinsics.checkNotNull(verticalTabLayout2, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
            verticalTabLayout2.setCurrentItem(getCamerasViewModel().getCurrentState().getCurrentIndex());
            ChildFragmentStateAdapter childFragmentStateAdapter3 = this.adapter;
            if (childFragmentStateAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                childFragmentStateAdapter = childFragmentStateAdapter3;
            }
            childFragmentStateAdapter.clear();
            int i = 0;
            int i2 = 0;
            for (Object obj : cameras) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Camera camera = (Camera) obj;
                if (!camera.getIsIntercom()) {
                    i2++;
                }
                childFragmentStateAdapter.addFragment(GlobalCameraFragment.INSTANCE.newInstance(camera));
                i = i3;
            }
            childFragmentStateAdapter.notifyDataSetChanged();
            getBinding().viewpager2.setCurrentItem(getCamerasViewModel().getCurrentState().getCurrentIndex(), false);
            final int currentIndex = getCamerasViewModel().getCurrentState().getCurrentIndex();
            getBinding().viewpager2.setOffscreenPageLimit(this.PAGE_LIMIT);
            VerticalTabLayout tabs = getBinding().tabs;
            Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
            ViewBindingUtilsKt.visibilityGoneBasedOn(tabs, isPortrait && i2 > 1);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GlobalCamerasFragment.doWithCameras$lambda$18(this.f$0, currentIndex);
                }
            });
            return;
        }
        this.tabsAdapter.submitList(CollectionsKt.toMutableList((Collection) cameras));
        ChildFragmentStateAdapter childFragmentStateAdapter4 = this.adapter;
        if (childFragmentStateAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            childFragmentStateAdapter = childFragmentStateAdapter4;
        }
        childFragmentStateAdapter.clear();
        int i4 = 0;
        int i5 = 0;
        for (Object obj2 : cameras) {
            int i6 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Camera camera2 = (Camera) obj2;
            if (!camera2.getIsIntercom()) {
                i5++;
            }
            childFragmentStateAdapter.addFragment(GlobalCameraFragment.INSTANCE.newInstance(camera2));
            i4 = i6;
        }
        childFragmentStateAdapter.notifyDataSetChanged();
        VerticalTabLayout verticalTabLayout3 = getBinding().tabs;
        Intrinsics.checkNotNull(verticalTabLayout3, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
        verticalTabLayout3.setCamerasSize(cameras.size());
        VerticalTabLayout verticalTabLayout4 = getBinding().tabs;
        Intrinsics.checkNotNull(verticalTabLayout4, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
        verticalTabLayout4.setCurrentItem(getCamerasViewModel().getCurrentState().getCurrentIndex());
        getBinding().viewpager2.setCurrentItem(getCamerasViewModel().getCurrentState().getCurrentIndex(), false);
        final int currentIndex2 = getCamerasViewModel().getCurrentState().getCurrentIndex();
        getBinding().viewpager2.setOffscreenPageLimit(this.PAGE_LIMIT);
        VerticalTabLayout tabs2 = getBinding().tabs;
        Intrinsics.checkNotNullExpressionValue(tabs2, "tabs");
        ViewBindingUtilsKt.visibilityGoneBasedOn(tabs2, isPortrait && i5 > 1);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GlobalCamerasFragment.doWithCameras$lambda$22(this.f$0, currentIndex2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doWithCameras$lambda$18(GlobalCamerasFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getView() != null) {
            this$0.getBinding().viewpager2.setCurrentItem(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doWithCameras$lambda$22(GlobalCamerasFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getView() != null) {
            this$0.getBinding().viewpager2.setCurrentItem(i, false);
        }
    }

    private final void doWithNoCamera() {
        ChildFragmentStateAdapter childFragmentStateAdapter = this.adapter;
        if (childFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            childFragmentStateAdapter = null;
        }
        childFragmentStateAdapter.clear();
        childFragmentStateAdapter.addFragment(new NoCamerasFragment());
        getBinding().viewpager2.setOffscreenPageLimit(1);
        VerticalTabLayout tabs = getBinding().tabs;
        Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
        ViewKt.invisible(tabs);
        getCamerasViewModel().handleLoading(false);
        OpenDoorButtonView mainOpenDoorBtn = getBinding().mainOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(mainOpenDoorBtn, "mainOpenDoorBtn");
        ViewKt.gone(mainOpenDoorBtn);
        TextView mainTextButton = getBinding().mainTextButton;
        Intrinsics.checkNotNullExpressionValue(mainTextButton, "mainTextButton");
        ViewKt.gone(mainTextButton);
        HorizontalScrollView horizontalScrollView = getBinding().layoutTiles;
        if (horizontalScrollView != null) {
            ViewKt.addSystemWindowInsetToPadding(horizontalScrollView, true);
        }
        HorizontalScrollView horizontalScrollView2 = getBinding().layoutTiles;
        if (horizontalScrollView2 != null) {
            ViewKt.addSystemWindowInsetToMargin(horizontalScrollView2, true, true, true, true);
        }
    }

    private final void setTitleDoor(String title) {
        if (getPrefManager().getIsNoDomofon() || title == null || title.length() == 0) {
            return;
        }
        final TextView textView = getBinding().tvTitleCamera;
        Intrinsics.checkNotNull(textView);
        ViewKt.visible(textView);
        textView.setAlpha(1.0f);
        textView.setText(title);
        textView.animate().alpha(0.0f).setDuration(DeviceOrientationRequest.OUTPUT_PERIOD_FAST).setListener(new Animator.AnimatorListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$setTitleDoor$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                textView.clearAnimation();
            }
        });
    }

    private final void setTitleSecondDoor(String title) {
        if (getPrefManager().getIsNoDomofon() || title == null || title.length() == 0) {
            return;
        }
        final TextView textView = getBinding().tvTitleSecondCamera;
        Intrinsics.checkNotNull(textView);
        ViewKt.visible(textView);
        textView.setAlpha(1.0f);
        textView.setText(title);
        textView.animate().alpha(0.0f).setDuration(DeviceOrientationRequest.OUTPUT_PERIOD_FAST).setListener(new Animator.AnimatorListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$setTitleSecondDoor$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                textView.clearAnimation();
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final GlobalCamerasFragmentBinding binding = getBinding();
        try {
            VerticalTabLayout verticalTabLayout = binding.tabs;
            Intrinsics.checkNotNull(verticalTabLayout, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
            verticalTabLayout.setAdapter(this.tabsAdapter);
            verticalTabLayout.getRecyclerView().setLayoutManager(new LinearLayoutManager(requireContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageView imageView = binding.ivGallery;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            SafeClickListenerKt.setSafeOnClickListener$default(imageView, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$2
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
                    this.this$0.getAnalytics().trackLogEvent(new CamerasEvents.ClickGridIcon());
                    NavController navController = this.this$0.getNavController();
                    if (navController != null) {
                        NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_cameras_preview, BundleKt.bundleOf(TuplesKt.to("cameras", this.this$0.getCamerasViewModel().getCurrentCameras())), null, 4, null);
                    }
                }
            }, 1, null);
        }
        binding.viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (!this.this$0.tabsAdapter.getItems().isEmpty()) {
                    this.this$0.tabsAdapter.select(position);
                    VerticalTabLayout verticalTabLayout2 = this.this$0.getBinding().tabs;
                    Intrinsics.checkNotNull(verticalTabLayout2, "null cannot be cast to non-null type com.sputnik.common.ui.view.VerticalTabLayout");
                    verticalTabLayout2.setCurrentItem(position);
                    RecyclerView.Adapter adapter = binding.viewpager2.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(position);
                    }
                    this.this$0.getCamerasViewModel().handleCamera(position);
                }
                if (GlobalCamerasFragment.INSTANCE.getCameraToSelect() == null) {
                    this.this$0.getCamerasViewModel().handleCamera(position);
                }
            }
        });
        OpenDoorButtonView mainOpenDoorBtn = binding.mainOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(mainOpenDoorBtn, "mainOpenDoorBtn");
        SafeClickListenerKt.setSafeOnClickListener$default(mainOpenDoorBtn, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$4
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
                this.this$0.openDoor();
            }
        }, 1, null);
        SecondaryOpenDoorButtonView secondaryOpenDoorBtn = binding.secondaryOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(secondaryOpenDoorBtn, "secondaryOpenDoorBtn");
        SafeClickListenerKt.setSafeOnClickListener$default(secondaryOpenDoorBtn, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$5
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
                this.this$0.openSecondDoor();
            }
        }, 1, null);
        if (getPrefManager().getIsNoDomofon()) {
            ImageView imageView2 = binding.btnVisitsHistory;
            if (imageView2 != null) {
                Intrinsics.checkNotNull(imageView2);
                ViewKt.gone(imageView2);
            }
            ImageView imageView3 = binding.btnChangeAddress;
            if (imageView3 != null) {
                Intrinsics.checkNotNull(imageView3);
                ViewKt.gone(imageView3);
            }
            OpenDoorButtonView mainOpenDoorBtn2 = binding.mainOpenDoorBtn;
            Intrinsics.checkNotNullExpressionValue(mainOpenDoorBtn2, "mainOpenDoorBtn");
            ViewKt.gone(mainOpenDoorBtn2);
            TextView mainTextButton = binding.mainTextButton;
            Intrinsics.checkNotNullExpressionValue(mainTextButton, "mainTextButton");
            ViewKt.gone(mainTextButton);
            AppCompatButton appCompatButton = binding.btnComplete;
            if (appCompatButton != null) {
                Intrinsics.checkNotNull(appCompatButton);
                ViewKt.visible(appCompatButton);
            }
        } else {
            AppCompatButton appCompatButton2 = binding.btnComplete;
            if (appCompatButton2 != null) {
                Intrinsics.checkNotNull(appCompatButton2);
                ViewKt.gone(appCompatButton2);
            }
        }
        AppCompatButton appCompatButton3 = binding.btnComplete;
        if (appCompatButton3 != null) {
            Intrinsics.checkNotNull(appCompatButton3);
            SafeClickListenerKt.setSafeOnClickListener$default(appCompatButton3, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$6
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
                    this.this$0.getProfileViewModel().cleanEvents();
                    this.this$0.getInvitesViewModel().clearInvites();
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_mainNoIntercomFragment_to_connectIntercomFragment, null, null, 6, null);
                }
            }, 1, null);
        }
        ImageView viewVpn = binding.viewVpn;
        Intrinsics.checkNotNullExpressionValue(viewVpn, "viewVpn");
        SafeClickListenerKt.setSafeOnClickListener$default(viewVpn, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$7
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
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_dialog_about_vpn, null, null, 6, null);
            }
        }, 1, null);
        ImageView imageView4 = binding.ivFullscreen;
        if (imageView4 != null) {
            Intrinsics.checkNotNull(imageView4);
            SafeClickListenerKt.setSafeOnClickListener$default(imageView4, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$8
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
                    GlobalCamerasFragment.Companion companion = GlobalCamerasFragment.INSTANCE;
                    if (companion.isPortrait()) {
                        FragmentActivity activity = this.this$0.getActivity();
                        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity");
                        ((SputnikRootActivity) activity).changeOrientation();
                        this.this$0.getNavigationViewModel().hideBottomNavigationMenu();
                        companion.setPortrait(false);
                    }
                }
            }, 1, null);
        }
        ImageView imageView5 = binding.btnAccessCodes;
        if (imageView5 != null) {
            Intrinsics.checkNotNull(imageView5);
            SafeClickListenerKt.setSafeOnClickListener$default(imageView5, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$9
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
                    if (this.this$0.getSubscriptionsViewModel().hasSubscription()) {
                        this.this$0.getAnalytics().trackLogEvent(new MainScreenEvents.ClickCodeFamily());
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_mainHostFragment_to_digital_code_navigation, null, null, 6, null);
                    } else {
                        this.this$0.getAnalytics().trackLogEvent(new MainScreenEvents.ClickCodeStandart());
                        IntentProcessingUtilsKt.handleDeeplink("market/standard/features/digital_keys", BundleKt.bundleOf(), this.this$0.getActivity(), this.this$0.getNavigationViewModel(), this.this$0.getProfileViewModel(), this.this$0.getAnalytics(), this.this$0.getNavController());
                    }
                }
            }, 1, null);
        }
        ImageView imageView6 = binding.btnVideoArchive;
        if (imageView6 != null) {
            Intrinsics.checkNotNull(imageView6);
            SafeClickListenerKt.setSafeOnClickListener$default(imageView6, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
                
                    if (r1 != null) goto L15;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(android.view.View r9) {
                    /*
                        r8 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.viewmodels.SubscriptionsViewModel r9 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getSubscriptionsViewModel(r9)
                        boolean r9 = r9.hasSubscription()
                        if (r9 != 0) goto L83
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.viewmodels.SubscriptionsViewModel r9 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getSubscriptionsViewModel(r9)
                        boolean r9 = r9.isMarketLocked()
                        if (r9 == 0) goto L4d
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.viewmodels.MarketViewModel r9 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getMarketViewModel(r9)
                        java.util.List r9 = r9.getActiveServices()
                        java.lang.Iterable r9 = (java.lang.Iterable) r9
                        java.util.Iterator r9 = r9.iterator()
                    L2d:
                        boolean r0 = r9.hasNext()
                        r1 = 0
                        if (r0 == 0) goto L4a
                        java.lang.Object r0 = r9.next()
                        r2 = r0
                        com.sputnik.common.entities.market.service.ServiceInfo r2 = (com.sputnik.common.entities.market.service.ServiceInfo) r2
                        java.lang.String r2 = r2.getId()
                        r3 = 0
                        r4 = 2
                        java.lang.String r5 = "archive"
                        boolean r1 = kotlin.text.StringsKt.contains$default(r2, r5, r3, r4, r1)
                        if (r1 == 0) goto L2d
                        r1 = r0
                    L4a:
                        if (r1 == 0) goto L4d
                        goto L83
                    L4d:
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.analytics.Analytics r9 = r9.getAnalytics()
                        com.sputnik.common.analytics.MainScreenEvents$ClickArhiveStandart r0 = new com.sputnik.common.analytics.MainScreenEvents$ClickArhiveStandart
                        r0.<init>()
                        r9.trackLogEvent(r0)
                        android.os.Bundle r2 = androidx.core.os.BundleKt.bundleOf()
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        androidx.fragment.app.FragmentActivity r3 = r9.getActivity()
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.viewmodels.NavigationViewModel r4 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getNavigationViewModel(r9)
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.viewmodels.ProfileViewModel r5 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getProfileViewModel(r9)
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.analytics.Analytics r6 = r9.getAnalytics()
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        androidx.navigation.NavController r7 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getNavController(r9)
                        java.lang.String r1 = "market/standard/features/archive"
                        sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt.handleDeeplink(r1, r2, r3, r4, r5, r6, r7)
                        goto Lb4
                    L83:
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        com.sputnik.common.analytics.Analytics r9 = r9.getAnalytics()
                        com.sputnik.common.analytics.MainScreenEvents$ClickArhiveFamily r0 = new com.sputnik.common.analytics.MainScreenEvents$ClickArhiveFamily
                        r0.<init>()
                        r9.trackLogEvent(r0)
                        sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment r9 = r8.this$0
                        androidx.navigation.NavController r0 = sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment.access$getNavController(r9)
                        com.sputnik.common.AndroidConstants$ServicesNames r9 = com.sputnik.common.AndroidConstants.ServicesNames.INSTANCE
                        java.lang.String r9 = r9.getVIDEO_ARCHIVE_3d_IDENTIFIER()
                        java.lang.String r1 = "curService"
                        kotlin.Pair r9 = kotlin.TuplesKt.to(r1, r9)
                        kotlin.Pair[] r9 = new kotlin.Pair[]{r9}
                        android.os.Bundle r2 = androidx.core.os.BundleKt.bundleOf(r9)
                        r4 = 4
                        r5 = 0
                        r1 = 2131362002(0x7f0a00d2, float:1.8343772E38)
                        r3 = 0
                        com.sputnik.common.extensions.NavControllerKt.safeNavigate$default(r0, r1, r2, r3, r4, r5)
                    Lb4:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$10.invoke2(android.view.View):void");
                }
            }, 1, null);
        }
        ImageView imageView7 = binding.btnVisitsHistory;
        if (imageView7 != null) {
            Intrinsics.checkNotNull(imageView7);
            SafeClickListenerKt.setSafeOnClickListener$default(imageView7, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) throws Resources.NotFoundException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (this.this$0.getSubscriptionsViewModel().hasSubscription()) {
                        this.this$0.getAnalytics().trackLogEvent(new MainScreenEvents.ClickVisitHistoryFamily());
                    } else {
                        this.this$0.getAnalytics().trackLogEvent(new MainScreenEvents.ClickVisitHistoryStandart());
                    }
                    Profile profile = this.this$0.getProfileViewModel().getCurrentState().getProfile();
                    if (profile != null ? Intrinsics.areEqual(profile.getIsNeedFeedback(), Boolean.TRUE) : false) {
                        ImageView imageView8 = this.this$0.getBinding().btnVisitsHistory;
                        if (imageView8 != null) {
                            ViewKt.disable(imageView8);
                        }
                        this.this$0.getSurveysViewModel().loadSurvey("promo_visitors");
                        return;
                    }
                    this.this$0.navigateToCallHistory();
                }
            }, 1, null);
        }
        ImageView imageView8 = binding.btnChangeAddress;
        if (imageView8 != null) {
            Intrinsics.checkNotNull(imageView8);
            SafeClickListenerKt.setSafeOnClickListener$default(imageView8, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment$initViews$1$12
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
                    if (this.this$0.getSubscriptionsViewModel().hasSubscription()) {
                        this.this$0.getAnalytics().trackLogEvent(new MainScreenEvents.ClickAddressFamily());
                    } else {
                        this.this$0.getAnalytics().trackLogEvent(new MainScreenEvents.ClickAddressStandart());
                    }
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_select_address, null, null, 6, null);
                }
            }, 1, null);
        }
    }

    private final void showBlocking() {
        GlobalCamerasFragmentBinding binding = getBinding();
        ImageView imageView = binding.btnVisitsHistory;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            ViewKt.gone(imageView);
        }
        OpenDoorButtonView mainOpenDoorBtn = binding.mainOpenDoorBtn;
        Intrinsics.checkNotNullExpressionValue(mainOpenDoorBtn, "mainOpenDoorBtn");
        ViewKt.gone(mainOpenDoorBtn);
        TextView mainTextButton = binding.mainTextButton;
        Intrinsics.checkNotNullExpressionValue(mainTextButton, "mainTextButton");
        ViewKt.gone(mainTextButton);
        LinearLayout videoLoader = binding.videoLoader;
        Intrinsics.checkNotNullExpressionValue(videoLoader, "videoLoader");
        ViewKt.gone(videoLoader);
        ChildFragmentStateAdapter childFragmentStateAdapter = this.adapter;
        if (childFragmentStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            childFragmentStateAdapter = null;
        }
        childFragmentStateAdapter.clear();
        childFragmentStateAdapter.addFragment(new FragmentNavigation());
    }

    private final void hideBlocking() {
        LogUtilsKt.writeLog(String.valueOf(getBinding().viewpager2.getAdapter()));
        getBinding().viewpager2.getAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openDoor() {
        if (getPrefManager().getIsNoDomofon()) {
            getPrefManager().updateIsNoDomofon(false);
            getNavController().navigateUp();
        } else {
            AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "myCameras", "door_open", null, 4, null);
            ICamerasViewModel.DefaultImpls.openDoor$default(getCamerasViewModel(), null, null, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSecondDoor() {
        if (getPrefManager().getIsNoDomofon()) {
            getPrefManager().updateIsNoDomofon(false);
            getNavController().navigateUp();
        } else {
            AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "myCameras", "door_second_open", null, 4, null);
            getCamerasViewModel().openSecondDoor();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            GlobalCameraFragment.Companion companion = GlobalCameraFragment.INSTANCE;
            SimpleExoPlayer player = companion.getPlayer();
            if (player != null) {
                player.release();
            }
            companion.setPlayer(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        CamerasLocale cameraList;
        String onboarding;
        CamerasLocale cameraList2;
        CamerasBody body;
        DemoModeLocale demo;
        TextTitle endRegistrationButton;
        TextTitle loader;
        GlobalCamerasFragmentBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (cameraList = data.getCameraList()) == null) {
            return;
        }
        TextView textView = binding.tvLoader;
        CamerasBody body2 = cameraList.getBody();
        String title = null;
        textView.setText((body2 == null || (loader = body2.getLoader()) == null) ? null : loader.getTitle());
        AppCompatButton appCompatButton = binding.btnComplete;
        if (appCompatButton != null) {
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            if (data2 != null && (demo = data2.getDemo()) != null && (endRegistrationButton = demo.getEndRegistrationButton()) != null) {
                title = endRegistrationButton.getTitle();
            }
            appCompatButton.setText(title);
        }
        TextView textView2 = binding.tvGalleryOnboarding;
        if (textView2 == null) {
            return;
        }
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        if (data3 == null || (cameraList2 = data3.getCameraList()) == null || (body = cameraList2.getBody()) == null || (onboarding = body.getOnboarding()) == null) {
            onboarding = "";
        }
        textView2.setText(onboarding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToCallHistory() throws Resources.NotFoundException {
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "myCameras", "archive_open", null, 4, null);
        NavControllerKt.safeNavigate$default(getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_callHistoryNavigation, null, null, 12, null);
    }

    /* compiled from: GlobalCamerasFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/GlobalCamerasFragment$Companion;", "", "()V", "cameraToSelect", "Lcom/sputnik/common/entities/camera/Camera;", "getCameraToSelect", "()Lcom/sputnik/common/entities/camera/Camera;", "setCameraToSelect", "(Lcom/sputnik/common/entities/camera/Camera;)V", "isOnboardingShowed", "", "isPortrait", "()Z", "setPortrait", "(Z)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPortrait() {
            return GlobalCamerasFragment.isPortrait;
        }

        public final void setPortrait(boolean z) {
            GlobalCamerasFragment.isPortrait = z;
        }

        public final Camera getCameraToSelect() {
            return GlobalCamerasFragment.cameraToSelect;
        }

        public final void setCameraToSelect(Camera camera) {
            GlobalCamerasFragment.cameraToSelect = camera;
        }
    }
}
