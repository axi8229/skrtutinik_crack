package sputnik.axmor.com.sputnik.ui.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.StaticVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.analytics.SupportEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.alerts.Alert;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SplashBody;
import com.sputnik.common.entities.localization.SplashLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.entities.popup.Appearance;
import com.sputnik.common.entities.popup.Image;
import com.sputnik.common.entities.popup.PopupStory;
import com.sputnik.common.entities.popup.PopupStoryStructure;
import com.sputnik.common.entities.popup.PopupTriggers;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.services.OuterService;
import com.sputnik.common.entities.subscriptions.Badge;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.DetailedLayout;
import com.sputnik.common.entities.subscriptions.IncludedServices;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.onboarding.OnboardingView;
import com.sputnik.common.ui.view.onboarding.OnboardingViewListener;
import com.sputnik.common.ui.view.onboarding.shapes.Focus;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AlertsViewModel;
import com.sputnik.common.viewmodels.AlertsViewState;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.BottomNavigationAction;
import com.sputnik.common.viewmodels.CamerasState;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationTypes;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NavigationViewState;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.NotificationsViewState;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.OnboardingViewState;
import com.sputnik.common.viewmodels.PopupStoriesDataState;
import com.sputnik.common.viewmodels.PopupStoriesViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Errors;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.AppSettings;
import com.sputnik.domain.entities.prefs.CamerasWidget;
import com.sputnik.domain.entities.prefs.VersionModel;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.domain.entities.subscriptions.Subscriptions;
import com.sputnik.oboarding.workmanager.ReminderRegistrationWork;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
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
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.MainHostFragmentBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.notifications.INotificationsManager;
import sputnik.axmor.com.sputnik.core.push.PushTokenManager;
import sputnik.axmor.com.sputnik.core.updates.IUpdatesManager;
import sputnik.axmor.com.sputnik.core.updates.UpdatesManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager;
import sputnik.axmor.com.sputnik.ui.main.MainHostFragment;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewState;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel;
import sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewState;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewState;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: MainHostFragment.kt */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0004*\u0002Þ\u0001\u0018\u0000 è\u00012\u00020\u0001:\u0002è\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u001bH\u0002¢\u0006\u0004\b5\u0010\u001eJ\u0017\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0006H\u0016¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\u0003J\u0019\u0010>\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J!\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u00020@2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\bD\u0010?J\u000f\u0010E\u001a\u00020\u0006H\u0016¢\u0006\u0004\bE\u0010\u0003J\u000f\u0010F\u001a\u00020\u0006H\u0016¢\u0006\u0004\bF\u0010\u0003J\u000f\u0010G\u001a\u00020\u0006H\u0016¢\u0006\u0004\bG\u0010\u0003J\u000f\u0010H\u001a\u00020\u0006H\u0016¢\u0006\u0004\bH\u0010\u0003R\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010f\u001a\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010f\u001a\u0004\bq\u0010rR\u001b\u0010x\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010f\u001a\u0004\bv\u0010wR\u001b\u0010}\u001a\u00020y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010f\u001a\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b\u007f\u0010f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0087\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010f\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R \u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010f\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u0091\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008e\u0001\u0010f\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0096\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0093\u0001\u0010f\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R \u0010\u009b\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0098\u0001\u0010f\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R \u0010 \u0001\u001a\u00030\u009c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0001\u0010f\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R \u0010¥\u0001\u001a\u00030¡\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010f\u001a\u0006\b£\u0001\u0010¤\u0001R \u0010ª\u0001\u001a\u00030¦\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b§\u0001\u0010f\u001a\u0006\b¨\u0001\u0010©\u0001R*\u0010¬\u0001\u001a\u00030«\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R*\u0010³\u0001\u001a\u00030²\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010º\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R \u0010À\u0001\u001a\u00030¼\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b½\u0001\u0010f\u001a\u0006\b¾\u0001\u0010¿\u0001R \u0010Å\u0001\u001a\u00030Á\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÂ\u0001\u0010f\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0018\u0010Ç\u0001\u001a\u00030Æ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R \u0010Ï\u0001\u001a\u00030Ë\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÌ\u0001\u0010f\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u001c\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ê\u0001R\u001d\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001a\u0010Ö\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010»\u0001R,\u0010Ù\u0001\u001a\u0012\u0012\r\u0012\u000b Ø\u0001*\u0004\u0018\u00010\u000e0\u000e0×\u00018\u0006¢\u0006\u0010\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001R3\u0010Ý\u0001\u001a\u001e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e Ø\u0001*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\r0×\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Ú\u0001R\u0018\u0010ß\u0001\u001a\u00030Þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001c\u0010â\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R'\u0010æ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0005\u0012\u00030å\u00010ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001¨\u0006é\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/MainHostFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", "state", "", "updateToken", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "updateLocalization", "updateTimezone", "handleActivityIntent", "updateOnBoardingIsShown", "", "", "permissions", "requestPermissions", "([Ljava/lang/String;)V", "Lkotlin/Pair;", "Lcom/sputnik/domain/common/Resource$Status;", "", "Lcom/sputnik/common/entities/market/market/Market;", "renderMarket", "(Lkotlin/Pair;)V", "cancelReminderRegistrationWork", "addMarketItem", "removeMarketItem", "", "id", "showBadge", "(I)V", "hideBadge", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "servicePaymentsViewState", "renderServicePayments", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "handlePromotionNavigation", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "subscriptionsViewState", "renderSubscriptionsUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "Lcom/sputnik/common/viewmodels/AlertsViewState;", "alertsViewState", "renderAlerts", "(Lcom/sputnik/common/viewmodels/AlertsViewState;)V", "setupBottomNavigationBar", "openStore", "setupTransparentBottomBar", "setupWhiteBottomBar", "hideBottomMenu", "showBottomMenu", "startBleServiceIfNeeded", "destination", "trackNavigationAnalytics", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onStop", "onStart", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewStateRestored", "onResume", "onDestroy", "localize", "initViews", "Lsputnik/axmor/com/databinding/MainHostFragmentBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/MainHostFragmentBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelBuilder", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelBuilder", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelBuilder", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "Lkotlin/Lazy;", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel$delegate", "getHelpViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "helpViewModel", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "surveyViewModel$delegate", "getSurveyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "surveyViewModel", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "Lcom/sputnik/common/viewmodels/AlertsViewModel;", "alertsViewModel$delegate", "getAlertsViewModel", "()Lcom/sputnik/common/viewmodels/AlertsViewModel;", "alertsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel$delegate", "getNotificationsViewModel", "()Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel$delegate", "getPopupStoriesViewModel", "()Lcom/sputnik/common/viewmodels/PopupStoriesViewModel;", "popupStoriesViewModel", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "", "isPaused", "Z", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/google/android/play/core/review/ReviewManager;", "reviewManager$delegate", "getReviewManager", "()Lcom/google/android/play/core/review/ReviewManager;", "reviewManager", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "destinationChangedListener", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "isNewSubscription", "Ljava/lang/Boolean;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lsputnik/axmor/com/sputnik/core/updates/IUpdatesManager;", "updatesManager", "Lsputnik/axmor/com/sputnik/core/updates/IUpdatesManager;", "navigateToProfile", "permissionsArray", "[Ljava/lang/String;", "destinationListenerInstalled", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getRequestPermissionLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "requestMultiplePermissions", "sputnik/axmor/com/sputnik/ui/main/MainHostFragment$beaconScanningListener$1", "beaconScanningListener", "Lsputnik/axmor/com/sputnik/ui/main/MainHostFragment$beaconScanningListener$1;", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "beaconServiceManager", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "", "", "navigationAnalyticsMap", "Ljava/util/Map;", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainHostFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MainHostFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/MainHostFragmentBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isBlockPopupAlreadyShows;
    private static boolean isLocaleSent;
    private static boolean isProfileLoaded;
    private static boolean isPushTokenSent;
    private static boolean updateDialogShowed;

    /* renamed from: alertsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy alertsViewModel;
    public Analytics analytics;
    private final MainHostFragment$beaconScanningListener$1 beaconScanningListener;
    private BeaconServiceManager beaconServiceManager;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelBuilder;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    private final NavController.OnDestinationChangedListener destinationChangedListener;
    private boolean destinationListenerInstalled;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;

    /* renamed from: helpViewModel$delegate, reason: from kotlin metadata */
    private final Lazy helpViewModel;
    private Boolean isNewSubscription;
    private boolean isPaused;
    public LocalizationStorage localizationScreen;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    private Boolean navigateToProfile;
    private Map<Integer, Long> navigationAnalyticsMap;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: notificationsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy notificationsViewModel;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;
    private final String[] permissionsArray;

    /* renamed from: popupStoriesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy popupStoriesViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ActivityResultLauncher<String[]> requestMultiplePermissions;
    private final ActivityResultLauncher<String> requestPermissionLauncher;

    /* renamed from: reviewManager$delegate, reason: from kotlin metadata */
    private final Lazy reviewManager;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* renamed from: surveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveyViewModel;
    private IUpdatesManager updatesManager;

    /* compiled from: MainHostFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Resource.Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BlockingLevel.values().length];
            try {
                iArr2[BlockingLevel.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$1(boolean z) {
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    /* JADX WARN: Type inference failed for: r0v43, types: [sputnik.axmor.com.sputnik.ui.main.MainHostFragment$beaconScanningListener$1] */
    public MainHostFragment() {
        super(R.layout.main_host_fragment);
        this.binding = new ViewBindingFragmentDelegate(this, MainHostFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.helpViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HelpViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$helpViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.surveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$surveyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$17
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$19
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$20
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$22
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$23
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.alertsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AlertsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$25
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$26
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$alertsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$28
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$29
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$31
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$32
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.notificationsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$34
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$35
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$notificationsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$37
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$38
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.popupStoriesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PopupStoriesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$40
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$41
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$popupStoriesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$43
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$special$$inlined$activityViewModels$default$44
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelBuilder = this.this$0.getCameraViewModelBuilder();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return cameraViewModelBuilder.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.reviewManager = LazyKt.lazy(new Function0<ReviewManager>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$reviewManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReviewManager invoke() {
                return ReviewManagerFactory.create(this.this$0.requireContext());
            }
        });
        this.destinationChangedListener = new NavController.OnDestinationChangedListener() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$$ExternalSyntheticLambda1
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
                MainHostFragment.destinationChangedListener$lambda$0(this.f$0, navController, navDestination, bundle);
            }
        };
        Boolean bool = Boolean.FALSE;
        this.isNewSubscription = bool;
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$navController$2
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
        this.navigateToProfile = bool;
        this.permissionsArray = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.POST_NOTIFICATIONS", "android.permission.USE_SIP", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.MODIFY_AUDIO_SETTINGS"} : new String[]{"android.permission.USE_SIP", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.MODIFY_AUDIO_SETTINGS"};
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainHostFragment.requestPermissionLauncher$lambda$1(((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainHostFragment.requestMultiplePermissions$lambda$3((Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.requestMultiplePermissions = activityResultLauncherRegisterForActivityResult2;
        this.beaconScanningListener = new BeaconServiceManager.BeaconServiceConnectionListener() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$beaconScanningListener$1
            @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager.BeaconServiceConnectionListener
            public void onBeaconServiceConnected(boolean isTracking) {
            }
        };
        this.navigationAnalyticsMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MainHostFragmentBinding getBinding() {
        return (MainHostFragmentBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelBuilder() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelBuilder;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelBuilder");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HelpViewModel getHelpViewModel() {
        return (HelpViewModel) this.helpViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SurveyViewModel getSurveyViewModel() {
        return (SurveyViewModel) this.surveyViewModel.getValue();
    }

    private final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    private final AlertsViewModel getAlertsViewModel() {
        return (AlertsViewModel) this.alertsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupStoriesViewModel getPopupStoriesViewModel() {
        return (PopupStoriesViewModel) this.popupStoriesViewModel.getValue();
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
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
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReviewManager getReviewManager() {
        return (ReviewManager) this.reviewManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destinationChangedListener$lambda$0(MainHostFragment this$0, NavController controller, NavDestination destination, Bundle bundle) {
        String debt;
        Float floatOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this$0.trackNavigationAnalytics(destination.getId());
        switch (destination.getId()) {
            case R.id.navigation_camera /* 2131363364 */:
                this$0.setupTransparentBottomBar();
                break;
            case R.id.navigation_help /* 2131363367 */:
                this$0.hideBadge(R.id.navigation_help);
                this$0.setupWhiteBottomBar();
                break;
            case R.id.navigation_market /* 2131363368 */:
                this$0.setupWhiteBottomBar();
                this$0.hideBadge(R.id.navigation_market);
                break;
            case R.id.navigation_profile /* 2131363371 */:
                this$0.setupWhiteBottomBar();
                ServiceAccountInfo accountInfo = this$0.getServicePaymentsViewModel().getCurrentState().getAccountInfo();
                if (((accountInfo == null || (debt = accountInfo.getDebt()) == null || (floatOrNull = StringsKt.toFloatOrNull(debt)) == null) ? 0.0f : floatOrNull.floatValue()) > 0.0f && this$0.getServicePaymentsViewModel().needToShowDebt()) {
                    this$0.hideBadge(R.id.navigation_profile);
                    break;
                }
                break;
            default:
                this$0.setupWhiteBottomBar();
                break;
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/MainHostFragment$Companion;", "", "<init>", "()V", "", "updateDialogShowed", "Z", "getUpdateDialogShowed", "()Z", "setUpdateDialogShowed", "(Z)V", "isProfileLoaded", "setProfileLoaded", "isPushTokenSent", "setPushTokenSent", "isLocaleSent", "setLocaleSent", "", "FULL_SIZE_MENU", "I", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getUpdateDialogShowed() {
            return MainHostFragment.updateDialogShowed;
        }

        public final void setUpdateDialogShowed(boolean z) {
            MainHostFragment.updateDialogShowed = z;
        }

        public final void setProfileLoaded(boolean z) {
            MainHostFragment.isProfileLoaded = z;
        }

        public final boolean isPushTokenSent() {
            return MainHostFragment.isPushTokenSent;
        }

        public final void setPushTokenSent(boolean z) {
            MainHostFragment.isPushTokenSent = z;
        }

        public final boolean isLocaleSent() {
            return MainHostFragment.isLocaleSent;
        }

        public final void setLocaleSent(boolean z) {
            MainHostFragment.isLocaleSent = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestMultiplePermissions$lambda$3(Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : permissions.entrySet()) {
            if (!((Boolean) entry.getValue()).booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.isPaused = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.isPaused = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get("newSubscription") : null;
        this.isNewSubscription = obj instanceof Boolean ? (Boolean) obj : null;
        Bundle arguments2 = getArguments();
        this.navigateToProfile = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("settings")) : null;
        BeaconServiceManager.Companion companion = BeaconServiceManager.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.beaconServiceManager = companion.getInstance(contextRequireContext, this.beaconScanningListener);
        if (isProfileLoaded) {
            return;
        }
        IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        List<String> listEmptyList;
        SplashLocale splash;
        SplashBody body;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        NavigationViewModel navigationViewModel = getNavigationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        navigationViewModel.observeState(viewLifecycleOwner, new Function1<NavigationViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavigationViewState navigationViewState) {
                invoke2(navigationViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavigationViewState it) {
                BottomNavigationAction bottomAction;
                Integer deeplinkInt;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getNeedToHideBottomMenu()) {
                    MainHostFragment.this.hideBottomMenu();
                } else {
                    MainHostFragment.this.showBottomMenu();
                }
                NavigationScenario action = it.getAction();
                if (action == null || (bottomAction = action.getBottomAction()) == null || (deeplinkInt = bottomAction.getDeeplinkInt()) == null) {
                    return;
                }
                MainHostFragment mainHostFragment = MainHostFragment.this;
                try {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainHostFragment), null, null, new MainHostFragment$onViewCreated$1$1$1$1(deeplinkInt.intValue(), mainHostFragment, null), 3, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            if (this.updatesManager == null) {
                UpdatesManager.Companion companion = UpdatesManager.INSTANCE;
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    activity = requireActivity();
                }
                Intrinsics.checkNotNull(activity);
                this.updatesManager = companion.getInstance(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (savedInstanceState == null) {
            setupBottomNavigationBar();
        }
        handleActivityIntent();
        cancelReminderRegistrationWork();
        updateOnBoardingIsShown();
        getMarketViewModel().updateMarketIfNeeded();
        getPrefManager().updateIsNoDomofon(false);
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        familyViewModel.observeSubState(viewLifecycleOwner2, new Function1<FamilyViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(FamilyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.3
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostFragment.getFamilyViewModel().loadFamily();
                    }
                }
            }
        });
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        marketViewModel.observeSubState(viewLifecycleOwner3, new Function1<MarketViewState, Pair<? extends Resource.Status, ? extends List<? extends Market>>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Pair<Resource.Status, List<Market>> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return TuplesKt.to(it.getMarketState(), it.getMarket());
            }
        }, new AnonymousClass5(this));
        MarketViewModel marketViewModel2 = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        marketViewModel2.observeState(viewLifecycleOwner4, new Function1<MarketViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.6
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
                    List<Service> services = it.getServices();
                    Object obj = null;
                    if (services != null) {
                        Iterator<T> it2 = services.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), AndroidConstants.ServicesNames.INSTANCE.getBLE_IDENTIFIER())) {
                                obj = next;
                                break;
                            }
                        }
                        obj = (Service) obj;
                    }
                    if (obj != null) {
                        MainHostFragment.this.getSettingsViewModel().needToShowNoPermissions();
                        MainHostFragment.this.getSettingsViewModel().needLaunchBleServiceAfterRequestingPermissions();
                    } else {
                        BeaconServiceManager beaconServiceManager = MainHostFragment.this.beaconServiceManager;
                        if (beaconServiceManager != null) {
                            beaconServiceManager.stopTracking();
                        }
                        MainHostFragment.this.getSettingsViewModel().disableBleFeature();
                    }
                }
            }
        });
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        camerasViewModel.observeSubState(viewLifecycleOwner5, new Function1<AllCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.8
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostFragment.getCamerasViewModel().loadMainCameras();
                    }
                }
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner6, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.10
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        IProfileViewModel.DefaultImpls.loadProfile$default(mainHostFragment.getProfileViewModel(), false, 1, null);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner7, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.11
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedReloadForNewAddress();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.12
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
                    MainHostFragment.this.getCamerasViewModel().handleNeedUpdate(true);
                }
            }
        });
        SurveyViewModel surveyViewModel = getSurveyViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        surveyViewModel.observeSubState(viewLifecycleOwner8, new Function1<SurveyViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.13
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SurveyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getPositiveIsSent();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.14
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostFragment.getProfileViewModel().handleNeedUpdate(true);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        profileViewModel3.observeSubState(viewLifecycleOwner9, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.15
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isRateLike();
            }
        }, new AnonymousClass16());
        MarketViewModel marketViewModel3 = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        marketViewModel3.observeSubState(viewLifecycleOwner10, new Function1<MarketViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.17
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.18
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostFragment.getMarketViewModel().updateAllMarket();
                    }
                }
            }
        });
        ProfileViewModel profileViewModel4 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "getViewLifecycleOwner(...)");
        profileViewModel4.observeState(viewLifecycleOwner11, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.19
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) throws Resources.NotFoundException {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getServerState() == Resource.Status.ERROR && (it.getException() instanceof Errors.AuthException)) {
                    MainHostFragment.this.getPrefManager().clearPrefs();
                    MainHostFragment.this.requireActivity().getViewModelStore().clear();
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(MainHostFragment.this), R.id.mainHostFragment, R.id.action_mainHostFragment_to_auth_navigation, null, null, 12, null);
                }
                Profile profile = it.getProfile();
                if (profile != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    SubscriptionsViewModel subscriptionsViewModel = mainHostFragment.getSubscriptionsViewModel();
                    Boolean richFunctionalityAvailable = profile.getRichFunctionalityAvailable();
                    Boolean bool = Boolean.TRUE;
                    subscriptionsViewModel.setRichFunctionalityAvailable(Intrinsics.areEqual(richFunctionalityAvailable, bool));
                    String avatar = profile.getAvatar();
                    if (avatar == null || avatar.length() == 0) {
                        SputnikApp.INSTANCE.getAnalyticsService().send("launch", "settings", "no_profile_photo");
                    } else {
                        SputnikApp.INSTANCE.getAnalyticsService().send("launch", "settings", "has_profile_photo");
                    }
                    if (Intrinsics.areEqual(profile.getCallIsEnabled(), bool)) {
                        SputnikApp.INSTANCE.getAnalyticsService().send("launch", "settings", "calls_enabled");
                    } else {
                        SputnikApp.INSTANCE.getAnalyticsService().send("launch", "settings", "calls_disabled");
                    }
                    if (Intrinsics.areEqual(profile.getBlocked(), bool)) {
                        NavControllerKt.safeNavigate$default(mainHostFragment.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockedFragment, BundleKt.bundleOf(TuplesKt.to("reason", profile.getBlockingReason())), null, 8, null);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel5 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner12 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner12, "getViewLifecycleOwner(...)");
        profileViewModel5.observeSubState(viewLifecycleOwner12, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.20
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.21
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends ProfileNavigationState> event) throws Resources.NotFoundException {
                invoke2(event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<? extends ProfileNavigationState> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                ProfileNavigationState contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        SputnikApp.INSTANCE.getAnalyticsService().send("launch", "account_state", "registered");
                        mainHostFragment.getMarketViewModel().handleNeedUpdate(true);
                    } else if (contentIfNotHandled instanceof ProfileNavigationState.ToLoginState) {
                        mainHostFragment.getPrefManager().clearPrefs();
                        mainHostFragment.requireActivity().getViewModelStore().clear();
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(mainHostFragment), R.id.mainHostFragment, R.id.action_mainHostFragment_to_auth_navigation, null, null, 12, null);
                    } else if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(mainHostFragment), R.id.action_global_to_add_address_clear, null, null, 6, null);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel6 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner13 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner13, "getViewLifecycleOwner(...)");
        profileViewModel6.observeSubState(viewLifecycleOwner13, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.22
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isImageUpdated();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.23
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostFragment.getFamilyViewModel().loadFamily();
                    }
                }
            }
        });
        ProfileViewModel profileViewModel7 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner14 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner14, "getViewLifecycleOwner(...)");
        profileViewModel7.observeSubState(viewLifecycleOwner14, new Function1<ProfileViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.24
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.25
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource.Status status) {
                invoke2(status);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource.Status it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it == Resource.Status.ERROR) {
                    ProfileViewModel profileViewModel8 = MainHostFragment.this.getProfileViewModel();
                    final MainHostFragment mainHostFragment = MainHostFragment.this;
                    profileViewModel8.delayRequest(YooProfilerImpl.TIMER_LIMIT, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.25.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mainHostFragment.getProfileViewModel().handleNeedUpdate(true);
                        }
                    });
                }
                if (it == Resource.Status.SUCCESS) {
                    Profile profile = MainHostFragment.this.getProfileViewModel().getCurrentState().getProfile();
                    String address = profile != null ? profile.getAddress() : null;
                    BaseOpenDoorWidget.INSTANCE.updateWidgets();
                    PrefManager prefManager = MainHostFragment.this.getPrefManager();
                    List<CamerasWidget> camerasInWidget = MainHostFragment.this.getPrefManager().getCamerasInWidget();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(camerasInWidget, 10));
                    Iterator<T> it2 = camerasInWidget.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(CamerasWidget.copy$default((CamerasWidget) it2.next(), null, address, null, null, 13, null));
                    }
                    prefManager.updateCamerasInWidgets(arrayList);
                }
            }
        });
        ProfileViewModel profileViewModel8 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner15, "getViewLifecycleOwner(...)");
        profileViewModel8.observeState(viewLifecycleOwner15, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.26
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getUserLocale() == null || Intrinsics.areEqual(it.getUserLocale(), MainHostFragment.this.getPrefManager().getCurLocale())) {
                    return;
                }
                LocalizationViewModel localizationViewModel = MainHostFragment.this.getLocalizationViewModel();
                String userLocale = it.getUserLocale();
                Intrinsics.checkNotNull(userLocale);
                localizationViewModel.loadLocalization(userLocale);
                PrefManager prefManager = MainHostFragment.this.getPrefManager();
                String userLocale2 = it.getUserLocale();
                Intrinsics.checkNotNull(userLocale2);
                prefManager.updateUserLocale(userLocale2);
            }
        });
        ProfileViewModel profileViewModel9 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner16 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner16, "getViewLifecycleOwner(...)");
        profileViewModel9.observeState(viewLifecycleOwner16, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.27
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getProfileServerState() == Resource.Status.SUCCESS) {
                    MainHostFragment.this.updateToken(it);
                    MainHostFragment.this.updateTimezone(it);
                    MainHostFragment.this.updateLocalization(it);
                }
            }
        });
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner17 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner17, "getViewLifecycleOwner(...)");
        localizationViewModel.observeSubState(viewLifecycleOwner17, new Function1<LocalizationViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.28
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.29
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
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        mainHostFragment.requireActivity().recreate();
                    }
                }
            }
        });
        AllCamerasViewModel camerasViewModel2 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner18 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner18, "getViewLifecycleOwner(...)");
        camerasViewModel2.observeSubState(viewLifecycleOwner18, new AnonymousClass30(CamerasState.INSTANCE), new Function1<CamerasState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.31
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CamerasState camerasState) {
                invoke2(camerasState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CamerasState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getServerState() == Resource.Status.SUCCESS) {
                    Profile profile = MainHostFragment.this.getProfileViewModel().getCurrentState().getProfile();
                    String address = profile != null ? profile.getAddress() : null;
                    BaseOpenDoorWidget.INSTANCE.updateWidgets();
                    PrefManager prefManager = MainHostFragment.this.getPrefManager();
                    List<Camera> cameras = it.getCameras();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(cameras, 10));
                    for (Camera camera : cameras) {
                        arrayList.add(camera.getWidget() ? new CamerasWidget(camera.getTitle(), address, camera.getIntercomUuid(), camera.getIntercomSerial()) : null);
                    }
                    prefManager.updateCamerasInWidgets(CollectionsKt.filterNotNull(arrayList));
                    PrefManager prefManager2 = MainHostFragment.this.getPrefManager();
                    List<Camera> cameras2 = it.getCameras();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(cameras2, 10));
                    for (Camera camera2 : cameras2) {
                        arrayList2.add(new com.sputnik.domain.entities.prefs.Camera(camera2.getIntercomUuid(), camera2.getIntercomSerial()));
                    }
                    prefManager2.updateCameras(CollectionsKt.filterNotNull(arrayList2));
                }
            }
        });
        ProfileViewModel profileViewModel10 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner19 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner19, "getViewLifecycleOwner(...)");
        profileViewModel10.observeSubState(viewLifecycleOwner19, new Function1<ProfileViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.32
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getIsShowLoader());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.33
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FrameLayout lockedView = MainHostFragment.this.getBinding().lockedView;
                Intrinsics.checkNotNullExpressionValue(lockedView, "lockedView");
                ViewBindingUtilsKt.visibilityBasedOn(lockedView, Boolean.valueOf(z));
                LinearLayout mainLoader = MainHostFragment.this.getBinding().mainLoader;
                Intrinsics.checkNotNullExpressionValue(mainLoader, "mainLoader");
                ViewBindingUtilsKt.visibilityBasedOn(mainLoader, Boolean.valueOf(z));
            }
        });
        ProfileViewModel profileViewModel11 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner20 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner20, "getViewLifecycleOwner(...)");
        profileViewModel11.observeNotifications(viewLifecycleOwner20, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.34
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
                MainHostFragment mainHostFragment = MainHostFragment.this;
                FrameLayout root = mainHostFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(mainHostFragment, root, it);
            }
        });
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner21 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner21, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner21, new AnonymousClass35(this));
        SubscriptionsViewModel subscriptionsViewModel2 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner22 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner22, "getViewLifecycleOwner(...)");
        subscriptionsViewModel2.observeSubState(viewLifecycleOwner22, new Function1<SubscriptionsViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.36
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedToShowRedPoint());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.37
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
                    MainHostFragment.this.showBadge(R.id.navigation_market);
                }
            }
        });
        HelpViewModel helpViewModel = getHelpViewModel();
        LifecycleOwner viewLifecycleOwner23 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner23, "getViewLifecycleOwner(...)");
        helpViewModel.observeState(viewLifecycleOwner23, new Function1<HelpViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.38
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HelpViewState helpViewState) {
                invoke2(helpViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HelpViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getServerState() == Resource.Status.NONE) {
                    MainHostFragment.this.getHelpViewModel().loadCompaniesList();
                }
            }
        });
        Boolean permissionsRequested = getSettingsViewModel().getAppSettings().getPermissionsRequested();
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.areEqual(permissionsRequested, bool)) {
            requestPermissions(this.permissionsArray);
            getOnboardingViewModel().dontShowGalleryOnboarding();
            getSettingsViewModel().updateAppSettings(AppSettings.copy$default(getPrefManager().getAppSettings(), null, Boolean.TRUE, 1, null));
        }
        Boolean bool2 = this.isNewSubscription;
        Boolean bool3 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool2, bool3)) {
            getBinding().bottomNavigation.setSelectedItemId(R.id.navigation_profile);
            getMarketViewModel().handleNeedUpdate(true);
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.mainHostFragment, R.id.action_mainHostFragment_to_successSubscriptionDialog, null, null, 12, null);
            this.isNewSubscription = bool;
        }
        if (Intrinsics.areEqual(this.navigateToProfile, bool3)) {
            getMarketViewModel().handleNeedUpdate(true);
            getBinding().bottomNavigation.setSelectedItemId(R.id.navigation_profile);
            this.navigateToProfile = bool;
        }
        PrefManager prefManager = getPrefManager();
        List<VersionModel> localesVersions = getPrefManager().getLocalesVersions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(localesVersions, 10));
        for (VersionModel versionModel : localesVersions) {
            if (Intrinsics.areEqual(versionModel.getLocale(), getPrefManager().getCurLocale())) {
                LocalizationLocalModel data = getLocalizationScreen().getData();
                if (data == null || (splash = data.getSplash()) == null || (body = splash.getBody()) == null || (listEmptyList = body.getLoadingText()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                versionModel.setLoadedText(listEmptyList);
            }
            arrayList.add(versionModel);
        }
        prefManager.updateLocaleVersions(arrayList);
        if (!isBlockPopupAlreadyShows) {
            if (GlobalVariables.INSTANCE.getBlockLevel() == BlockingLevel.PARTIAL) {
                NavControllerKt.safeNavigate$default(getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
            }
            isBlockPopupAlreadyShows = true;
        }
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner24 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner24, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeState(viewLifecycleOwner24, new AnonymousClass40(this));
        AlertsViewModel alertsViewModel = getAlertsViewModel();
        LifecycleOwner viewLifecycleOwner25 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner25, "getViewLifecycleOwner(...)");
        alertsViewModel.observeState(viewLifecycleOwner25, new AnonymousClass41(this));
        getServicePaymentsViewModel().getServiceAccountInfo();
        NotificationsViewModel notificationsViewModel = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner26 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner26, "getViewLifecycleOwner(...)");
        notificationsViewModel.observeState(viewLifecycleOwner26, new Function1<NotificationsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.42
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NotificationsViewState notificationsViewState) {
                invoke2(notificationsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NotificationsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getNeedToShowOnboarding()) {
                    MainHostFragment.this.showBadge(R.id.navigation_profile);
                } else {
                    MainHostFragment.this.hideBadge(R.id.navigation_profile);
                }
            }
        });
        SettingsViewModel settingsViewModel = getSettingsViewModel();
        LifecycleOwner viewLifecycleOwner27 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner27, "getViewLifecycleOwner(...)");
        settingsViewModel.observeState(viewLifecycleOwner27, new Function1<SettingsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.43
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SettingsViewState settingsViewState) {
                invoke2(settingsViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SettingsViewState it) {
                Boolean contentIfNotHandled;
                Boolean contentIfNotHandled2;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getAppState().getBluetoothEnabled() && it.getAppState().getGpsEnabled() && it.getAppState().getBlePermissionsGranted() && (contentIfNotHandled2 = it.getNeedLaunchBleServiceAfterRequestingPermissions().getContentIfNotHandled()) != null) {
                    MainHostFragment mainHostFragment = MainHostFragment.this;
                    if (contentIfNotHandled2.booleanValue()) {
                        mainHostFragment.startBleServiceIfNeeded();
                    }
                }
                Event<Boolean> needToShowNoPermissionsScreen = it.getNeedToShowNoPermissionsScreen();
                if (needToShowNoPermissionsScreen == null || (contentIfNotHandled = needToShowNoPermissionsScreen.getContentIfNotHandled()) == null) {
                    return;
                }
                MainHostFragment mainHostFragment2 = MainHostFragment.this;
                if (contentIfNotHandled.booleanValue()) {
                    mainHostFragment2.getOnboardingViewModel().delayNoBlePermissions();
                    NavController navController = mainHostFragment2.getNavController();
                    if (navController != null) {
                        NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_bottomSheetNoBlePermissions, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, "main_screen")), null, 4, null);
                    }
                }
            }
        });
        OnboardingViewModel onboardingViewModel = getOnboardingViewModel();
        LifecycleOwner viewLifecycleOwner28 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner28, "getViewLifecycleOwner(...)");
        onboardingViewModel.observeSubState(viewLifecycleOwner28, new Function1<OnboardingViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.44
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(OnboardingViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedToShowMoveHistory2();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.45
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> event) {
                Intrinsics.checkNotNullParameter(event, "event");
                View viewFindViewById = MainHostFragment.this.getBinding().getRoot().findViewById(R.id.navigation_profile);
                if (viewFindViewById != null) {
                    final MainHostFragment mainHostFragment = MainHostFragment.this;
                    Boolean contentIfNotHandled = event.getContentIfNotHandled();
                    if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
                        return;
                    }
                    FragmentActivity fragmentActivityRequireActivity = mainHostFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                    new OnboardingView.Builder(fragmentActivityRequireActivity).setFocusType(Focus.MINIMUM).performClick(true).setTitleText("История посещений").setSubtitleText("Теперь доступна в разделе Профиль\nв списке ваших услуг").setButtonText("Отлично").setTarget(viewFindViewById).dismissOnTouch(false).setDelayMillis(100).setUsageId(String.valueOf(viewFindViewById.getId())).setListener(new OnboardingViewListener() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$45$1$1$1
                        @Override // com.sputnik.common.ui.view.onboarding.OnboardingViewListener
                        public void onDismissed(String materialIntroViewId) {
                            mainHostFragment.getOnboardingViewModel().lockMoveHistory();
                        }
                    }).show();
                }
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass46(null), 3, null);
        PopupStoriesViewModel popupStoriesViewModel = getPopupStoriesViewModel();
        LifecycleOwner viewLifecycleOwner29 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner29, "getViewLifecycleOwner(...)");
        popupStoriesViewModel.observeState(viewLifecycleOwner29, new Function1<PopupStoriesDataState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.onViewCreated.47
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PopupStoriesDataState popupStoriesDataState) {
                invoke2(popupStoriesDataState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopupStoriesDataState state) {
                List<PopupStoryStructure> stories;
                PopupStoryStructure popupStoryStructure;
                String url;
                Image image;
                Intrinsics.checkNotNullParameter(state, "state");
                if (state.getStories() == null || !(!r0.isEmpty()) || (stories = state.getStories()) == null || (popupStoryStructure = (PopupStoryStructure) CollectionsKt.firstOrNull((List) stories)) == null) {
                    return;
                }
                final MainHostFragment mainHostFragment = MainHostFragment.this;
                for (final PopupStory popupStory : popupStoryStructure.getPopupStories()) {
                    final String url2 = popupStory.getAppearance().getBackground().getUrl();
                    String url3 = null;
                    if (url2 != null) {
                        if (StringsKt.isBlank(url2)) {
                            url2 = null;
                        }
                        if (url2 != null) {
                            PopupStoriesViewModel popupStoriesViewModel2 = mainHostFragment.getPopupStoriesViewModel();
                            if ((popupStoriesViewModel2 != null ? popupStoriesViewModel2.getCachedImage(url2) : null) == null) {
                                Glide.with(mainHostFragment).asBitmap().load(url2).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$47$1$1$2$1
                                    @Override // com.bumptech.glide.request.target.Target
                                    public void onLoadCleared(Drawable placeholder) {
                                    }

                                    @Override // com.bumptech.glide.request.target.Target
                                    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                    }

                                    public void onResourceReady(Bitmap p0, Transition<? super Bitmap> p1) {
                                        Intrinsics.checkNotNullParameter(p0, "p0");
                                        mainHostFragment.getPopupStoriesViewModel().cacheImage(url2, p0);
                                    }
                                });
                            }
                        }
                    }
                    Image image2 = popupStory.getAppearance().getImage();
                    if (image2 != null && (url = image2.getUrl()) != null) {
                        PopupStoriesViewModel popupStoriesViewModel3 = mainHostFragment.getPopupStoriesViewModel();
                        if ((popupStoriesViewModel3 != null ? popupStoriesViewModel3.getCachedImage(url) : null) == null) {
                            RequestBuilder<Bitmap> requestBuilderAsBitmap = Glide.with(mainHostFragment).asBitmap();
                            Appearance appearance = popupStory.getAppearance();
                            if (appearance != null && (image = appearance.getImage()) != null) {
                                url3 = image.getUrl();
                            }
                            requestBuilderAsBitmap.load(url3).into((RequestBuilder<Bitmap>) new CustomTarget<Bitmap>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$47$1$1$3$1
                                @Override // com.bumptech.glide.request.target.Target
                                public void onLoadCleared(Drawable placeholder) {
                                }

                                @Override // com.bumptech.glide.request.target.Target
                                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                }

                                public void onResourceReady(Bitmap p0, Transition<? super Bitmap> p1) {
                                    Image image3;
                                    Intrinsics.checkNotNullParameter(p0, "p0");
                                    PopupStoriesViewModel popupStoriesViewModel4 = mainHostFragment.getPopupStoriesViewModel();
                                    Appearance appearance2 = popupStory.getAppearance();
                                    popupStoriesViewModel4.cacheImage((appearance2 == null || (image3 = appearance2.getImage()) == null) ? null : image3.getUrl(), p0);
                                }
                            });
                        }
                    }
                }
                if (state.getIsStoriesShowed() || !Intrinsics.areEqual(popupStoryStructure.getTrigger(), PopupTriggers.main.toString())) {
                    return;
                }
                mainHostFragment.getPopupStoriesViewModel().markStoriesAsShowed();
                NavController navController = mainHostFragment.getNavController();
                if (navController != null) {
                    NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_popupStories, null, null, 6, null);
                }
            }
        });
        getPopupStoriesViewModel().loadPopupStoriesIfNeeded();
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Pair<? extends Resource.Status, ? extends List<? extends Market>>, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, MainHostFragment.class, "renderMarket", "renderMarket(Lkotlin/Pair;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Resource.Status, ? extends List<? extends Market>> pair) {
            invoke2((Pair<? extends Resource.Status, ? extends List<Market>>) pair);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends Resource.Status, ? extends List<Market>> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainHostFragment) this.receiver).renderMarket(p0);
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/sputnik/domain/common/Event;", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$16, reason: invalid class name */
    static final class AnonymousClass16 extends Lambda implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass16() {
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
            Boolean contentIfNotHandled = it.getContentIfNotHandled();
            if (contentIfNotHandled != null) {
                MainHostFragment mainHostFragment = MainHostFragment.this;
                if (contentIfNotHandled.booleanValue()) {
                    mainHostFragment.getSurveyViewModel().sendPositiveSurvey();
                    Task<ReviewInfo> taskRequestReviewFlow = mainHostFragment.getReviewManager().requestReviewFlow();
                    Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
                    if (!taskRequestReviewFlow.isSuccessful()) {
                        mainHostFragment.openStore();
                        return;
                    }
                    Task<Void> taskLaunchReviewFlow = mainHostFragment.getReviewManager().launchReviewFlow(mainHostFragment.requireActivity(), taskRequestReviewFlow.getResult());
                    Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "launchReviewFlow(...)");
                    taskLaunchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$16$$ExternalSyntheticLambda0
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public final void onComplete(Task task) {
                            Intrinsics.checkNotNullParameter(task, "it");
                        }
                    });
                }
            }
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$30, reason: invalid class name */
    /* synthetic */ class AnonymousClass30 extends FunctionReferenceImpl implements Function1<AllCamerasViewState, CamerasState> {
        AnonymousClass30(Object obj) {
            super(1, obj, CamerasState.Companion.class, "toCamerasState", "toCamerasState(Lcom/sputnik/common/viewmodels/AllCamerasViewState;)Lcom/sputnik/common/viewmodels/CamerasState;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CamerasState invoke(AllCamerasViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((CamerasState.Companion) this.receiver).toCamerasState(p0);
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$35, reason: invalid class name */
    /* synthetic */ class AnonymousClass35 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        AnonymousClass35(Object obj) {
            super(1, obj, MainHostFragment.class, "renderSubscriptionsUi", "renderSubscriptionsUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainHostFragment) this.receiver).renderSubscriptionsUi(p0);
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$40, reason: invalid class name */
    /* synthetic */ class AnonymousClass40 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass40(Object obj) {
            super(1, obj, MainHostFragment.class, "renderServicePayments", "renderServicePayments(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainHostFragment) this.receiver).renderServicePayments(p0);
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$41, reason: invalid class name */
    /* synthetic */ class AnonymousClass41 extends FunctionReferenceImpl implements Function1<AlertsViewState, Unit> {
        AnonymousClass41(Object obj) {
            super(1, obj, MainHostFragment.class, "renderAlerts", "renderAlerts(Lcom/sputnik/common/viewmodels/AlertsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlertsViewState alertsViewState) {
            invoke2(alertsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AlertsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MainHostFragment) this.receiver).renderAlerts(p0);
        }
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$46", f = "MainHostFragment.kt", l = {667}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$46, reason: invalid class name */
    static final class AnonymousClass46 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass46(Continuation<? super AnonymousClass46> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainHostFragment.this.new AnonymousClass46(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass46) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainHostFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$46$1", f = "MainHostFragment.kt", l = {}, m = "invokeSuspend")
        /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$onViewCreated$46$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MainHostFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainHostFragment mainHostFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mainHostFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.handlePromotionNavigation();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainHostFragment mainHostFragment = MainHostFragment.this;
                Lifecycle.State state = Lifecycle.State.RESUMED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(mainHostFragment, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(mainHostFragment, state, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToken(final ProfileViewState state) {
        PushTokenManager.INSTANCE.requestToken(new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment.updateToken.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                String contentIfNotHandled = state.getPushTokenServerState().getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    MainHostFragment mainHostFragment = this;
                    if (Intrinsics.areEqual(token, contentIfNotHandled)) {
                        return;
                    }
                    Companion companion = MainHostFragment.INSTANCE;
                    if (companion.isPushTokenSent()) {
                        return;
                    }
                    mainHostFragment.getProfileViewModel().sendPushToken(token);
                    companion.setPushTokenSent(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocalization(ProfileViewState state) {
        String userLocale = state.getUserLocale();
        if (isLocaleSent) {
            return;
        }
        if (userLocale != null && !StringsKt.isBlank(userLocale)) {
            getProfileViewModel().setLocalization(userLocale);
        }
        isLocaleSent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimezone(ProfileViewState state) {
        String contentIfNotHandled = state.getTimezoneServerState().getContentIfNotHandled();
        if (contentIfNotHandled != null) {
            String string = TimeZone.getDefault().getID().toString();
            if (Intrinsics.areEqual(string, contentIfNotHandled)) {
                return;
            }
            getProfileViewModel().sendTimezone(string);
        }
    }

    private final void handleActivityIntent() {
        FragmentActivity activity = getActivity();
        IntentProcessingUtilsKt.handleIntent(activity != null ? activity.getIntent() : null, getActivity(), getNavigationViewModel(), getNavController(), getAnalytics(), getProfileViewModel());
    }

    private final void updateOnBoardingIsShown() {
        getPrefManager().updateShowStartOnBoarding(false);
    }

    private final void requestPermissions(String[] permissions) {
        this.requestMultiplePermissions.launch(permissions);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        setupBottomNavigationBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderMarket(Pair<? extends Resource.Status, ? extends List<Market>> state) {
        Resource.Status first = state.getFirst();
        state.getSecond();
        if (first == Resource.Status.ERROR) {
            removeMarketItem();
            getPrefManager().updateIsFullMenu(false);
        } else if (first == Resource.Status.SUCCESS) {
            getPrefManager().updateIsFullMenu(true);
        }
    }

    private final void cancelReminderRegistrationWork() {
        ReminderRegistrationWork.Companion companion = ReminderRegistrationWork.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.cancelRegistrationReminderWork(contextRequireContext);
    }

    private final void addMarketItem() {
        MainHostFragmentBinding binding = getBinding();
        if (binding.bottomNavigation.getMenu().size() < 4) {
            Menu menu = binding.bottomNavigation.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            menu.removeItem(R.id.navigation_help);
            menu.add(0, R.id.navigation_market, 0, getString(R.string.nav_market)).setIcon(R.drawable.ic_nav_market);
            menu.add(0, R.id.navigation_help, 0, getString(R.string.nav_help)).setIcon(R.drawable.ic_nav_help);
        }
    }

    private final void removeMarketItem() {
        if (getBinding().bottomNavigation.getMenu().size() == 4) {
            Menu menu = getBinding().bottomNavigation.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            menu.removeItem(R.id.navigation_market);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBadge(int id) {
        BadgeDrawable orCreateBadge = getBinding().bottomNavigation.getOrCreateBadge(id);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideBadge(int id) {
        BadgeDrawable orCreateBadge = getBinding().bottomNavigation.getOrCreateBadge(id);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setVisible(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(512);
        }
        getProfileViewModel().setIsAppLoaded();
        renderServicePayments(getServicePaymentsViewModel().getCurrentState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderServicePayments(ServicePaymentsViewState servicePaymentsViewState) {
        String debt;
        Float floatOrNull;
        ServiceAccountInfo accountInfo = servicePaymentsViewState.getAccountInfo();
        if (((accountInfo == null || (debt = accountInfo.getDebt()) == null || (floatOrNull = StringsKt.toFloatOrNull(debt)) == null) ? 0.0f : floatOrNull.floatValue()) <= 0.0f || !getServicePaymentsViewModel().needToShowDebt()) {
            return;
        }
        showBadge(R.id.navigation_profile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePromotionNavigation() {
        List<BaseSubscription> subscriptions;
        BaseSubscription baseSubscription;
        com.sputnik.common.entities.subscriptions.Service service;
        NavDestination currentDestination;
        Badge badge;
        DetailedLayout detailedLayout;
        IncludedServices includedServices;
        List<com.sputnik.common.entities.subscriptions.Service> services;
        Object next;
        if (!getSubscriptionsViewModel().getCurrentState().getNeedShowButtonPromo() || StaticVariables.INSTANCE.getNavigationClickMethod() == null || (subscriptions = getSubscriptionsViewModel().getCurrentState().getSubscriptions()) == null || (baseSubscription = (BaseSubscription) CollectionsKt.firstOrNull((List) subscriptions)) == null) {
            return;
        }
        SubscriptionAppearance appearance = baseSubscription.getAppearance();
        if (appearance == null || (detailedLayout = appearance.getDetailedLayout()) == null || (includedServices = detailedLayout.getIncludedServices()) == null || (services = includedServices.getServices()) == null) {
            service = null;
        } else {
            Iterator<T> it = services.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((com.sputnik.common.entities.subscriptions.Service) next).getServiceConfigIdentifier(), "accelerated_loading")) {
                        break;
                    }
                }
            }
            service = (com.sputnik.common.entities.subscriptions.Service) next;
        }
        if (service != null) {
            Context contextRequireContext = requireContext();
            SubscriptionAppearance appearance2 = baseSubscription.getAppearance();
            String color = (appearance2 == null || (badge = appearance2.getBadge()) == null) ? null : badge.getColor();
            boolean zAreEqual = Intrinsics.areEqual(color, "blue");
            int i = R.color.sputnik_blue;
            if (!zAreEqual && Intrinsics.areEqual(color, "green")) {
                i = R.color.sputnik_green;
            }
            ContextCompat.getColor(contextRequireContext, i);
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            Integer numValueOf = (navControllerFindNavController == null || (currentDestination = navControllerFindNavController.getCurrentDestination()) == null) ? null : Integer.valueOf(currentDestination.getId());
            ArrayList arrayList = new ArrayList();
            if ((numValueOf == null || numValueOf.intValue() != R.id.fragmentSubscriptionDetails) && (numValueOf == null || numValueOf.intValue() != R.id.bottomSheetAboutService)) {
                arrayList.add(new NavigationAction(R.id.action_to_subscriptions_navigation, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", "accelerated_loading")), null, 8, null));
            }
            if (numValueOf != null && numValueOf.intValue() == R.id.fragmentSubscriptionDetails) {
                arrayList.add(new NavigationAction(0, null, BundleKt.bundleOf(TuplesKt.to("product_id", Subscriptions.standard.toString()), TuplesKt.to("curService", "accelerated_loading")), NavigationTypes.custom));
            }
            StaticVariables.INSTANCE.setNavigationClickMethod(null);
            getNavigationViewModel().addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.toList(arrayList)), false, 4, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSubscriptionsUi(SubscriptionsViewState subscriptionsViewState) {
        List listEmptyList;
        List<OuterService> services;
        if (subscriptionsViewState.getMarketState() == Resource.Status.NONE) {
            getSubscriptionsViewModel().getSubscriptions();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[subscriptionsViewState.getMarketState().ordinal()];
        if (i == 1) {
            removeMarketItem();
            getPrefManager().updateIsFullMenu(false);
            return;
        }
        if (i != 2) {
            return;
        }
        handlePromotionNavigation();
        List<BaseSubscription> subscriptions = subscriptionsViewState.getSubscriptions();
        if (subscriptions == null || (listEmptyList = CollectionsKt.plus((Collection<? extends BaseSubscription>) subscriptions, subscriptionsViewState.getActiveSubscription())) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (!listEmptyList.isEmpty() || ((services = subscriptionsViewState.getServices()) != null && (!services.isEmpty()))) {
            addMarketItem();
            getPrefManager().updateIsFullMenu(true);
        } else {
            removeMarketItem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAlerts(AlertsViewState alertsViewState) {
        Alert alert;
        IUpdatesManager iUpdatesManager;
        if (alertsViewState.getAlerts().isEmpty() || (alert = (Alert) CollectionsKt.firstOrNull((List) alertsViewState.getAlerts())) == null || (iUpdatesManager = this.updatesManager) == null) {
            return;
        }
        iUpdatesManager.isUpdateAvailable(new C26521(alert, this));
    }

    /* compiled from: MainHostFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$renderAlerts$1, reason: invalid class name and case insensitive filesystem */
    static final class C26521 extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ Alert $alert;
        final /* synthetic */ MainHostFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26521(Alert alert, MainHostFragment mainHostFragment) {
            super(1);
            this.$alert = alert;
            this.this$0 = mainHostFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            Alert alert = this.$alert;
            final MainHostFragment mainHostFragment = this.this$0;
            if (z) {
                try {
                    if (Intrinsics.areEqual(alert.getRequired(), Boolean.TRUE)) {
                        View view = mainHostFragment.getView();
                        if (view != null) {
                            view.postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$renderAlerts$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MainHostFragment.C26521.invoke$lambda$2$lambda$0(mainHostFragment);
                                }
                            }, 200L);
                        }
                    } else {
                        Companion companion = MainHostFragment.INSTANCE;
                        if (!companion.getUpdateDialogShowed()) {
                            companion.setUpdateDialogShowed(true);
                            View view2 = mainHostFragment.getView();
                            if (view2 != null) {
                                view2.postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$renderAlerts$1$$ExternalSyntheticLambda1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        MainHostFragment.C26521.invoke$lambda$2$lambda$1(mainHostFragment);
                                    }
                                }, 200L);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$0(MainHostFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_mainHostFragment_to_fragmentUpdateRequired, null, null, 6, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(MainHostFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_mainHostFragment_to_bottomSheetUpdateRequired, null, null, 6, null);
        }
    }

    private final void setupBottomNavigationBar() {
        if (this.destinationListenerInstalled) {
            return;
        }
        if (getPrefManager().getIsFullMenu()) {
            addMarketItem();
        } else {
            removeMarketItem();
        }
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.main_host_fragment);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavController navController = ((NavHostFragment) fragmentFindFragmentById).getNavController();
        GlobalVariables globalVariables = GlobalVariables.INSTANCE;
        globalVariables.setBottomNavigationView(getBinding().bottomNavigation);
        globalVariables.setBottomController(navController);
        BottomNavigationView bottomNavigationView = getBinding().bottomNavigation;
        Intrinsics.checkNotNull(bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setBackground(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.black_800)));
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() { // from class: sputnik.axmor.com.sputnik.ui.main.MainHostFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener
            public final void onNavigationItemReselected(MenuItem menuItem) {
                Intrinsics.checkNotNullParameter(menuItem, "it");
            }
        });
        ViewKt.addSystemWindowInsetToPadding$default(bottomNavigationView, true, false, true, true, 2, null);
        navController.addOnDestinationChangedListener(this.destinationChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openStore() {
        Context context = getContext();
        String packageName = context != null ? context.getPackageName() : null;
        Intrinsics.checkNotNull(packageName);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    private final void setupTransparentBottomBar() {
        int color = ContextCompat.getColor(requireContext(), WhenMappings.$EnumSwitchMapping$1[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1 ? R.color.black_bottom_nav : R.color.black_bottom_nav_transparent);
        getBinding().bottomNavigation.setItemIconTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)));
        getBinding().bottomNavigation.setBackground(new ColorDrawable(color));
    }

    private final void setupWhiteBottomBar() {
        getBinding().bottomNavigation.setItemIconTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.sputnik_header_black)));
        getBinding().bottomNavigation.setBackground(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.white)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GlobalVariables globalVariables = GlobalVariables.INSTANCE;
        globalVariables.setBottomController(null);
        globalVariables.setBottomNavigationView(null);
        this.requestMultiplePermissions.unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideBottomMenu() {
        try {
            BottomNavigationView bottomNavigation = getBinding().bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(bottomNavigation, "bottomNavigation");
            ViewKt.gone(bottomNavigation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBottomMenu() {
        try {
            BottomNavigationView bottomNavigation = getBinding().bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(bottomNavigation, "bottomNavigation");
            ViewKt.visible(bottomNavigation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startBleServiceIfNeeded() {
        String title;
        String body;
        BleLocale ble;
        BleLocale.NoPermissionsNotification noPermissionsNotification;
        BleLocale ble2;
        BleLocale.NoPermissionsNotification noPermissionsNotification2;
        BeaconServiceManager beaconServiceManager;
        if (Intrinsics.areEqual(getSettingsViewModel().getAppSettings().getBleSettings().getEnabled(), Boolean.TRUE)) {
            if (getSettingsViewModel().getCurrentState().getAppState().getBlePermissionsGranted()) {
                BeaconServiceManager beaconServiceManager2 = this.beaconServiceManager;
                if (beaconServiceManager2 == null || beaconServiceManager2.getIsServiceStarted() || (beaconServiceManager = this.beaconServiceManager) == null) {
                    return;
                }
                beaconServiceManager.startTracking(this.beaconScanningListener);
                return;
            }
            BeaconServiceManager beaconServiceManager3 = this.beaconServiceManager;
            if (beaconServiceManager3 != null) {
                beaconServiceManager3.stopTracking();
            }
            INotificationsManager.Companion companion = INotificationsManager.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            INotificationsManager companion2 = companion.getInstance(contextRequireContext);
            LocalizationLocalModel data = getLocalizationScreen().getData();
            if (data == null || (ble2 = data.getBle()) == null || (noPermissionsNotification2 = ble2.getNoPermissionsNotification()) == null || (title = noPermissionsNotification2.getTitle()) == null) {
                title = "❗️Недостаточно разрешений";
            }
            String str = title;
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            if (data2 == null || (ble = data2.getBle()) == null || (noPermissionsNotification = ble.getNoPermissionsNotification()) == null || (body = noPermissionsNotification.getBody()) == null) {
                body = "Для работы функции “Бесключевой доступ” необходимо выдать недостающие разрешения";
            }
            companion2.notifyPush(new PushMessage(4102, str, body, PushMessage.Types.promo, getString(R.string.deeplink_no_permissions), null, 32, null));
        }
    }

    private final void trackNavigationAnalytics(int destination) {
        if (this.isPaused) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l = this.navigationAnalyticsMap.get(Integer.valueOf(destination));
        if (jCurrentTimeMillis - (l != null ? l.longValue() : 301L) > 300) {
            this.navigationAnalyticsMap.put(Integer.valueOf(destination), Long.valueOf(jCurrentTimeMillis));
            switch (destination) {
                case R.id.navigation_help /* 2131363367 */:
                    getAnalytics().trackLogEvent(new SupportEvents.ClickOpenSupport());
                    break;
                case R.id.navigation_market /* 2131363368 */:
                    if (getSubscriptionsViewModel().getCurrentState().getNeedToShowRedPoint()) {
                        getAnalytics().trackLogEvent(new GeneralEvents.ClickMarketRedDot());
                        getSubscriptionsViewModel().clearRedMarketPoint();
                        break;
                    }
                    break;
                case R.id.navigation_profile /* 2131363371 */:
                    getAnalytics().trackLogEvent(new GeneralEvents.ClickProfile());
                    break;
            }
        }
    }
}
