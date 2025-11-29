package sputnik.axmor.com.sputnik.ui.main.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.Scopes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.analytics.MultiAddressEvents;
import com.sputnik.common.analytics.PermissionsEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.common.entities.localization.ArchiveMainLocale;
import com.sputnik.common.entities.localization.ArchiveMainView;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SettingsBody;
import com.sputnik.common.entities.localization.SettingsLocale;
import com.sputnik.common.entities.localization.SettingsNavigation;
import com.sputnik.common.entities.localization.TextListTitles;
import com.sputnik.common.entities.localization.VisitsLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.market.items.MarketItem;
import com.sputnik.common.entities.market.service.Origin;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.subscriptions.Badge;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.services.ServiceAppearance;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.SettingsMenuView;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.KeysViewModel;
import com.sputnik.common.viewmodels.KeysViewState;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.NotificationsViewState;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.OnboardingViewState;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.common.viewmodels.SurveysState;
import com.sputnik.common.viewmodels.SurveysViewModel;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.service_payments.analytics.yandex.ServicePaymentsEvents;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.ui.ServicePaymentsViewModel;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.interfaces.IServicePaymentsViewModel;
import com.sputnik.subscriptions.analytics.OnlySubscriptionEvents;
import com.sputnik.subscriptions.analytics.SubscriptionsEvents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSettingsProfileBinding;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.adapter.ServicesAdapter;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewState;

/* compiled from: ProfileFragment.kt */
@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 µ\u00012\u00020\u0001:\u0002µ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001f\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0003¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u0019\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J!\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u0002032\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b5\u00106J)\u0010<\u001a\u00020\u00062\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u0002032\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0006H\u0016¢\u0006\u0004\bD\u0010\u0003R\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010L\u001a\u00020K8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0R8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b[\u0010U\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR\"\u0010_\u001a\u00020^8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010g\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010g\u001a\u0004\br\u0010sR\u001b\u0010y\u001a\u00020u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010g\u001a\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010g\u001a\u0004\b|\u0010}R\u001f\u0010\u0083\u0001\u001a\u00020\u007f8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0080\u0001\u0010g\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R \u0010\u0088\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u0010g\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u008d\u0001\u001a\u00030\u0089\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010g\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R \u0010\u0092\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u0010g\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R \u0010\u0097\u0001\u001a\u00030\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0094\u0001\u0010g\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R \u0010\u009c\u0001\u001a\u00030\u0098\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0099\u0001\u0010g\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R \u0010¡\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010g\u001a\u0006\b\u009f\u0001\u0010 \u0001R \u0010¦\u0001\u001a\u00030¢\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b£\u0001\u0010g\u001a\u0006\b¤\u0001\u0010¥\u0001R \u0010«\u0001\u001a\u00030§\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¨\u0001\u0010g\u001a\u0006\b©\u0001\u0010ª\u0001R*\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001¨\u0006¶\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/ProfileFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "settingsViewState", "", "renderSettingsUi", "(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "subscriptionsViewState", "renderSubscriptionsUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;", "renderFamilyUi", "(Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;)V", "Lcom/sputnik/common/viewmodels/MarketViewState;", "renderMarketUi", "(Lcom/sputnik/common/viewmodels/MarketViewState;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewState;", "renderCameraUi", "(Lcom/sputnik/common/viewmodels/AllCamerasViewState;)V", "", "Lcom/sputnik/common/entities/market/service/Service;", "services", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "subscriptions", "renderServicesLayout", "(Ljava/util/List;Ljava/util/List;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "servicePaymentsViewState", "renderBlockingUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "Lcom/sputnik/common/entities/profile/Profile;", Scopes.PROFILE, "doWithSuccess", "(Lcom/sputnik/common/entities/profile/Profile;)V", "navigateToNotifications", "navigateToCallHistory", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/ContextMenu;", "menu", "v", "Landroid/view/ContextMenu$ContextMenuInfo;", "menuInfo", "onCreateContextMenu", "(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V", "Landroid/view/MenuItem;", "item", "", "onContextItemSelected", "(Landroid/view/MenuItem;)Z", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentSettingsProfileBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSettingsProfileBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Ldagger/Lazy;", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Ldagger/Lazy;", "getPrefManager", "()Ldagger/Lazy;", "setPrefManager", "(Ldagger/Lazy;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "getFactory", "setFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactoryBuilder", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactoryBuilder", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactoryBuilder", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel$delegate", "getNotificationsViewModel", "()Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel$delegate", "getSurveysViewModel", "()Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel$delegate", "getSettingsViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "settingsViewModel", "Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel$delegate", "getKeysViewModel", "()Lcom/sputnik/common/viewmodels/KeysViewModel;", "keysViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "needLoader", "Z", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ProfileFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSettingsProfileBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactoryBuilder;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public dagger.Lazy<MultiViewModelFactory> factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;

    /* renamed from: keysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy keysViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;
    private boolean needLoader;

    /* renamed from: notificationsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy notificationsViewModel;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;
    public dagger.Lazy<PrefManager> prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;

    /* renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* renamed from: surveysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveysViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSettingsProfileBinding getBinding() {
        return (FragmentSettingsProfileBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final dagger.Lazy<PrefManager> getPrefManager() {
        dagger.Lazy<PrefManager> lazy = this.prefManager;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    public final dagger.Lazy<MultiViewModelFactory> getFactory() {
        dagger.Lazy<MultiViewModelFactory> lazy = this.factory;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasFactoryBuilder() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasFactoryBuilder;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasFactoryBuilder");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel.getValue();
    }

    private final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    private final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    private final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    private final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SurveysViewModel getSurveysViewModel() {
        return (SurveysViewModel) this.surveysViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    private final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    private final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    private final KeysViewModel getKeysViewModel() {
        return (KeysViewModel) this.keysViewModel.getValue();
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null || !this.needLoader) {
            return;
        }
        this.needLoader = false;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    public ProfileFragment() {
        super(R.layout.fragment_settings_profile);
        this.binding = new ViewBindingFragmentDelegate(this, ProfileFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.notificationsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$notificationsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory camerasFactoryBuilder = this.this$0.getCamerasFactoryBuilder();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return camerasFactoryBuilder.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$11
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$13
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$14
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$familyViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$16
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$17
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$19
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$20
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$22
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$23
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.surveysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$25
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$26
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$surveysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$28
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$29
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$31
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$32
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$34
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$35
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$settingsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.keysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(KeysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$37
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$special$$inlined$activityViewModels$default$38
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$keysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                MultiViewModelFactory multiViewModelFactory = this.this$0.getFactory().get();
                Intrinsics.checkNotNullExpressionValue(multiViewModelFactory, "get(...)");
                return multiViewModelFactory;
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$navController$2
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
        this.needLoader = true;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "show", null, 4, null);
        if (this.needLoader) {
            LinearLayout loader = getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            ViewKt.visible(loader);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileFragment.onViewCreated$lambda$1(this.f$0);
                }
            }, 500L);
        } else {
            LinearLayout loader2 = getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader2, "loader");
            ViewKt.gone(loader2);
            NestedScrollView profileScroll = getBinding().profileScroll;
            Intrinsics.checkNotNullExpressionValue(profileScroll, "profileScroll");
            ViewKt.visible(profileScroll);
            MarketViewModel marketViewModel = getMarketViewModel();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            marketViewModel.observeState(viewLifecycleOwner, new AnonymousClass2(this));
        }
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner2, new AnonymousClass3(this));
        KeysViewModel keysViewModel = getKeysViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        keysViewModel.observeState(viewLifecycleOwner3, new Function1<KeysViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeysViewState keysViewState) {
                invoke2(keysViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeysViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                List<PhysicalKey> listPeekContent = it.getKeys().peekContent();
                if (listPeekContent.isEmpty()) {
                    listPeekContent = null;
                }
                List<PhysicalKey> list = listPeekContent;
                if (list != null) {
                    ProfileFragment.this.getBinding().settingsKeys.setCount(String.valueOf(list.size()));
                }
            }
        });
        NotificationsViewModel notificationsViewModel = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        notificationsViewModel.observeState(viewLifecycleOwner4, new Function1<NotificationsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment.onViewCreated.5
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
                    View viewOnboardingNotifications = ProfileFragment.this.getBinding().viewOnboardingNotifications;
                    Intrinsics.checkNotNullExpressionValue(viewOnboardingNotifications, "viewOnboardingNotifications");
                    ViewKt.visible(viewOnboardingNotifications);
                } else {
                    View viewOnboardingNotifications2 = ProfileFragment.this.getBinding().viewOnboardingNotifications;
                    Intrinsics.checkNotNullExpressionValue(viewOnboardingNotifications2, "viewOnboardingNotifications");
                    ViewKt.gone(viewOnboardingNotifications2);
                }
            }
        });
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        familyViewModel.observeNotifications(viewLifecycleOwner5, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment.onViewCreated.6
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
                ProfileFragment profileFragment = ProfileFragment.this;
                ConstraintLayout root = profileFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(profileFragment, root, it);
            }
        });
        FamilyViewModel familyViewModel2 = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        familyViewModel2.observeState(viewLifecycleOwner6, new AnonymousClass7(this));
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner7, new AnonymousClass8(this));
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeState(viewLifecycleOwner8, new AnonymousClass9(this));
        SettingsViewModel settingsViewModel = getSettingsViewModel();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        settingsViewModel.observeState(viewLifecycleOwner9, new AnonymousClass10(this));
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeSubState(viewLifecycleOwner10, new Function1<SubscriptionsViewState, Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment.onViewCreated.11
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SubscriptionsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getNeedShowButtonPromo());
            }
        }, new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment.onViewCreated.12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                TextView textView = ProfileFragment.this.getBinding().btnWantMore;
                if (textView != null) {
                    boolean z2 = false;
                    if (z) {
                        Profile profile = ProfileFragment.this.getProfileViewModel().getCurrentState().getProfile();
                        if (profile != null ? Intrinsics.areEqual(profile.getRichFunctionalityAvailable(), Boolean.FALSE) : false) {
                            z2 = true;
                        }
                    }
                    ViewBindingUtilsKt.visibilityBasedOn(textView, Boolean.valueOf(z2));
                }
            }
        });
        ImageView ivChooseAddress = getBinding().ivChooseAddress;
        Intrinsics.checkNotNullExpressionValue(ivChooseAddress, "ivChooseAddress");
        ViewBindingUtilsKt.visibilityGoneBasedOn(ivChooseAddress, !getSubscriptionsViewModel().isMarketLocked());
        SubscriptionsViewModel subscriptionsViewModel2 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "getViewLifecycleOwner(...)");
        subscriptionsViewModel2.observeState(viewLifecycleOwner11, new AnonymousClass13(this));
        getSurveysViewModel().observeState(this, new Function1<SurveysState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment.onViewCreated.14
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
                    ProfileFragment profileFragment = ProfileFragment.this;
                    if (contentIfNotHandled.booleanValue() && state.getServerState() == Resource.Status.NONE) {
                        profileFragment.getSurveysViewModel().loadSurveys();
                    }
                }
                if (state.getSurveysDismissed()) {
                    return;
                }
                if (state.getServerState() == Resource.Status.ERROR && Intrinsics.areEqual(state.getLastRequestedSurveyName(), "promo_visitors")) {
                    ProfileFragment.this.getSurveysViewModel().clearState();
                    ProfileFragment.this.navigateToCallHistory();
                    return;
                }
                if ((state.getSurveys() == null || !(!r0.isEmpty())) && state.getRequestedSurvey() == null) {
                    return;
                }
                ProfileFragment.this.getSurveysViewModel().lockSurveys();
                ProfileFragment.this.getNavigationViewModel().addAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.to_navigation_poll, "", null, null, 12, null))), false, 4, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ProfileFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getView() != null) {
            NestedScrollView profileScroll = this$0.getBinding().profileScroll;
            Intrinsics.checkNotNullExpressionValue(profileScroll, "profileScroll");
            ViewKt.visible(profileScroll);
            MarketViewModel marketViewModel = this$0.getMarketViewModel();
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            marketViewModel.observeState(viewLifecycleOwner, new ProfileFragment$onViewCreated$1$1$1(this$0));
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MarketViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, ProfileFragment.class, "renderMarketUi", "renderMarketUi(Lcom/sputnik/common/viewmodels/MarketViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MarketViewState marketViewState) {
            invoke2(marketViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MarketViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderMarketUi(p0);
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ProfileViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, ProfileFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
            invoke2(profileViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<FamilyViewState, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, ProfileFragment.class, "renderFamilyUi", "renderFamilyUi(Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FamilyViewState familyViewState) {
            invoke2(familyViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FamilyViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderFamilyUi(p0);
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$8, reason: invalid class name */
    /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<AllCamerasViewState, Unit> {
        AnonymousClass8(Object obj) {
            super(1, obj, ProfileFragment.class, "renderCameraUi", "renderCameraUi(Lcom/sputnik/common/viewmodels/AllCamerasViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AllCamerasViewState allCamerasViewState) {
            invoke2(allCamerasViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AllCamerasViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderCameraUi(p0);
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$9, reason: invalid class name */
    /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        AnonymousClass9(Object obj) {
            super(1, obj, ProfileFragment.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderBlockingUi(p0);
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$10, reason: invalid class name */
    /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<SettingsViewState, Unit> {
        AnonymousClass10(Object obj) {
            super(1, obj, ProfileFragment.class, "renderSettingsUi", "renderSettingsUi(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewState settingsViewState) {
            invoke2(settingsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderSettingsUi(p0);
        }
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$onViewCreated$13, reason: invalid class name */
    /* synthetic */ class AnonymousClass13 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        AnonymousClass13(Object obj) {
            super(1, obj, ProfileFragment.class, "renderSubscriptionsUi", "renderSubscriptionsUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ProfileFragment) this.receiver).renderSubscriptionsUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSettingsUi(SettingsViewState settingsViewState) {
        getBinding().settingsPermissions.setOnboardingEnabled(getSettingsViewModel().needToShowNoPermissions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSubscriptionsUi(SubscriptionsViewState subscriptionsViewState) {
        MarketItem marketItem;
        int i;
        SubscriptionAppearance appearance;
        Badge badge;
        SubscriptionAppearance appearance2;
        Badge badge2;
        Object next;
        FragmentSettingsProfileBinding binding = getBinding();
        List<MarketItem> items = subscriptionsViewState.getItems();
        String title = null;
        if (items != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((MarketItem) next).getIdentifier(), "licensed_keys")) {
                        break;
                    }
                }
            }
            marketItem = (MarketItem) next;
        } else {
            marketItem = null;
        }
        if (marketItem != null) {
            SettingsMenuView settingsKeys = getBinding().settingsKeys;
            Intrinsics.checkNotNullExpressionValue(settingsKeys, "settingsKeys");
            ViewKt.visible(settingsKeys);
        }
        BaseSubscription activeSubscription = subscriptionsViewState.getActiveSubscription();
        String color = (activeSubscription == null || (appearance2 = activeSubscription.getAppearance()) == null || (badge2 = appearance2.getBadge()) == null) ? null : badge2.getColor();
        if (Intrinsics.areEqual(color, "blue")) {
            i = R.color.sputnik_blue;
        } else {
            Intrinsics.areEqual(color, "green");
            i = R.color.sputnik_green;
        }
        binding.badgeSubscription.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), i));
        TextView textView = binding.badgeSubscription;
        if (activeSubscription != null && (appearance = activeSubscription.getAppearance()) != null && (badge = appearance.getBadge()) != null) {
            title = badge.getTitle();
        }
        textView.setText(String.valueOf(title));
        TextView badgeSubscription = binding.badgeSubscription;
        Intrinsics.checkNotNullExpressionValue(badgeSubscription, "badgeSubscription");
        ViewBindingUtilsKt.visibilityBasedOn(badgeSubscription, Boolean.valueOf(activeSubscription != null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(ProfileViewState data) {
        Profile profile;
        UserAddress currentAddress = getProfileViewModel().getCurrentAddress();
        getBinding().settingsAddress.setText(StringUtilsKt.orEmpty(currentAddress != null ? currentAddress.getFullAddressWithApartment() : null));
        if (data.getProfileServerState() != Resource.Status.SUCCESS || (profile = data.getProfile()) == null) {
            return;
        }
        doWithSuccess(profile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void renderFamilyUi(FamilyViewState data) {
        if (data.getServerState() == Resource.Status.SUCCESS) {
            getBinding().settingsFamily.setCount(String.valueOf(data.getFamilyList().size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void renderMarketUi(MarketViewState data) {
        Resource.Status servicesState = data.getServicesState();
        Resource.Status status = Resource.Status.SUCCESS;
        if (servicesState == status) {
            if (!data.getServices().isEmpty()) {
                renderServicesLayout(data.getServices(), data.getSubscriptions());
                Group servicesLayout = getBinding().servicesLayout;
                Intrinsics.checkNotNullExpressionValue(servicesLayout, "servicesLayout");
                ViewKt.visible(servicesLayout);
            } else if (data.getMarketState() != status || data.getMarket().isEmpty()) {
                LinearLayout loader = getBinding().loader;
                Intrinsics.checkNotNullExpressionValue(loader, "loader");
                ViewKt.gone(loader);
            }
            LinearLayout loader2 = getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader2, "loader");
            ViewKt.gone(loader2);
            this.needLoader = false;
            return;
        }
        LinearLayout loader3 = getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader3, "loader");
        ViewKt.gone(loader3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderCameraUi(AllCamerasViewState data) {
        if (data.getServerState() == Resource.Status.SUCCESS) {
            SettingsMenuView settingsCameras = getBinding().settingsCameras;
            Intrinsics.checkNotNullExpressionValue(settingsCameras, "settingsCameras");
            ViewBindingUtilsKt.visibilityBasedOn(settingsCameras, Boolean.valueOf(!data.getMainCameras().isEmpty()));
            SettingsMenuView settingsDomofon = getBinding().settingsDomofon;
            Intrinsics.checkNotNullExpressionValue(settingsDomofon, "settingsDomofon");
            ViewBindingUtilsKt.visibilityBasedOn(settingsDomofon, Boolean.valueOf(!data.getMainCameras().isEmpty()));
            getBinding().settingsCameras.setCount(String.valueOf(data.getMainCameras().size()));
        }
    }

    private final void renderServicesLayout(List<Service> services, List<Subscription> subscriptions) {
        Object next;
        List<Service> list = services;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Service service : list) {
            Origin origin = service.getOrigin();
            Origin originCopy$default = null;
            if (origin != null) {
                Iterator<T> it = subscriptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    String productId = ((Subscription) next).getProductId();
                    Origin origin2 = service.getOrigin();
                    if (Intrinsics.areEqual(productId, origin2 != null ? origin2.getProductId() : null)) {
                        break;
                    }
                }
                Subscription subscription = (Subscription) next;
                String title = subscription != null ? subscription.getTitle() : null;
                Origin origin3 = service.getOrigin();
                String productId2 = origin3 != null ? origin3.getProductId() : null;
                Origin origin4 = service.getOrigin();
                ServiceAppearance appearance = origin4 != null ? origin4.getAppearance() : null;
                Origin origin5 = service.getOrigin();
                originCopy$default = Origin.copy$default(origin, productId2, title, null, null, origin5 != null ? origin5.getPhone() : null, null, appearance, 44, null);
            }
            arrayList.add(service.copy((1983 & 1) != 0 ? service.title : null, (1983 & 2) != 0 ? service.description : null, (1983 & 4) != 0 ? service.serviceImage : null, (1983 & 8) != 0 ? service.isCompanyService : null, (1983 & 16) != 0 ? service.isSubscriptionService : null, (1983 & 32) != 0 ? service.serviceConfigIdentifier : null, (1983 & 64) != 0 ? service.origin : originCopy$default, (1983 & 128) != 0 ? service.state : null, (1983 & 256) != 0 ? service.activatedAt : null, (1983 & 512) != 0 ? service.badge : null, (1983 & 1024) != 0 ? service.requiresSubscription : null));
        }
        RecyclerView.Adapter adapter = getBinding().rvServices.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.adapter.ServicesAdapter");
        ((ServicesAdapter) adapter).submitList(arrayList);
        View root = getBinding().subsLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewKt.gone(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(ServicePaymentsViewState servicePaymentsViewState) {
        String debtAsString;
        String debt;
        Float floatOrNull;
        try {
            if (isAdded() && isVisible()) {
                FragmentSettingsProfileBinding binding = getBinding();
                ServiceAccountInfo accountInfo = servicePaymentsViewState.getAccountInfo();
                if (((accountInfo == null || (debt = accountInfo.getDebt()) == null || (floatOrNull = StringsKt.toFloatOrNull(debt)) == null) ? 0.0f : floatOrNull.floatValue()) > 0.0f && getServicePaymentsViewModel().needToShowDebt()) {
                    try {
                        binding.paymentItem.setCountColor(ContextCompat.getColor(requireContext(), R.color.sputnik_red));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    IServicePaymentsViewModel.DefaultImpls.updateLastShowingDebtDate$default(getServicePaymentsViewModel(), null, 1, null);
                }
                if (servicePaymentsViewState.getAccountInfo() != null) {
                    ConstraintLayout layoutPaymentItem = binding.layoutPaymentItem;
                    Intrinsics.checkNotNullExpressionValue(layoutPaymentItem, "layoutPaymentItem");
                    ViewKt.visible(layoutPaymentItem);
                    binding.layoutPaymentItem.invalidate();
                    SettingsMenuView paymentItem = binding.paymentItem;
                    Intrinsics.checkNotNullExpressionValue(paymentItem, "paymentItem");
                    ViewKt.visible(paymentItem);
                    TextView servicesLabel = getBinding().servicesLabel;
                    Intrinsics.checkNotNullExpressionValue(servicesLabel, "servicesLabel");
                    ViewKt.visible(servicesLabel);
                    binding.paymentItem.invalidate();
                } else {
                    ConstraintLayout layoutPaymentItem2 = binding.layoutPaymentItem;
                    Intrinsics.checkNotNullExpressionValue(layoutPaymentItem2, "layoutPaymentItem");
                    ViewKt.gone(layoutPaymentItem2);
                    binding.layoutPaymentItem.invalidate();
                    SettingsMenuView paymentItem2 = binding.paymentItem;
                    Intrinsics.checkNotNullExpressionValue(paymentItem2, "paymentItem");
                    ViewKt.gone(paymentItem2);
                    binding.paymentItem.invalidate();
                }
                SettingsMenuView settingsMenuView = binding.paymentItem;
                ServiceAccountInfo accountInfo2 = servicePaymentsViewState.getAccountInfo();
                if (accountInfo2 == null || (debtAsString = accountInfo2.getDebtAsString()) == null) {
                    debtAsString = "";
                }
                settingsMenuView.setCount(debtAsString);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void doWithSuccess(Profile profile) {
        FragmentSettingsProfileBinding binding = getBinding();
        binding.settingsFio.setText(String.valueOf(profile.getFirstName()));
        Glide.with(this).load(profile.getAvatar()).circleCrop().placeholder(R.drawable.ic_group_image).into(binding.settingsPhoto);
        binding.settingsCard.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.doWithSuccess$lambda$15$lambda$14(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doWithSuccess$lambda$15$lambda$14(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_card, null, null, 12, null);
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(v, "v");
        menu.setHeaderTitle("Select account");
        List<LoginState.Session> sessions = get_prefManager().getLoginState().getSessions();
        if (sessions != null) {
            for (LoginState.Session session : sessions) {
                String jwt = session.getJwt();
                if (jwt != null && !StringsKt.isBlank(jwt)) {
                    menu.add(0, v.getId(), 0, session.getPhone());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        LoginState.Session session;
        String jwt;
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        List<LoginState.Session> sessions = get_prefManager().getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((LoginState.Session) next).getPhone(), item.getTitle())) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        if (session != null && (jwt = session.getJwt()) != null) {
            get_prefManager().updateJwtToken(jwt);
            IProfileViewModel.DefaultImpls.loadProfile$default(getProfileViewModel(), false, 1, null);
            getCamerasViewModel().loadMainCameras();
            getMarketViewModel().loadMarket();
            getSubscriptionsViewModel().getSubscriptions();
        }
        return true;
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        ArchiveMainLocale archiveMain;
        ArchiveMainView body;
        TextListTitles partnerView;
        List<String> titles;
        final FragmentSettingsProfileBinding binding = getBinding();
        registerForContextMenu(binding.btnSelectAccount);
        binding.btnSelectAccount.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.initViews$lambda$36$lambda$19(binding, view);
            }
        });
        ConstraintLayout layoutAboutOurHome = binding.layoutAboutOurHome;
        Intrinsics.checkNotNullExpressionValue(layoutAboutOurHome, "layoutAboutOurHome");
        System.currentTimeMillis();
        ViewBindingUtilsKt.visibilityBasedOn(layoutAboutOurHome, Boolean.FALSE);
        binding.layoutAboutOurHome.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$20(this.f$0, view);
            }
        });
        binding.subsLayout.getRoot().setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$21(this.f$0, view);
            }
        });
        binding.settingsFamily.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$22(this.f$0, view);
            }
        });
        binding.buttonExit.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$23(this.f$0, view);
            }
        });
        binding.buttonNotifications.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.initViews$lambda$36$lambda$24(this.f$0, view);
            }
        });
        binding.imageButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.initViews$lambda$36$lambda$25(this.f$0, view);
            }
        });
        binding.settingsDomofon.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$26(this.f$0, view);
            }
        });
        binding.settingsCameras.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$27(this.f$0, view);
            }
        });
        binding.settingsLanguage.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$28(this.f$0, view);
            }
        });
        SettingsMenuView settingsCard = binding.settingsCard;
        Intrinsics.checkNotNullExpressionValue(settingsCard, "settingsCard");
        ViewBindingUtilsKt.visibilityBasedOn(settingsCard, Boolean.valueOf(getPrefManager().get().getIsFullMenu()));
        binding.settingsCard.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$29(this.f$0, view);
            }
        });
        binding.settingsPermissions.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.initViews$lambda$36$lambda$30(this.f$0, view);
            }
        });
        binding.settingsKeys.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$31(this.f$0, view);
            }
        });
        RecyclerView recyclerView = binding.rvServices;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        LocalizationLocalModel data = getLocalizationScreen().getData();
        recyclerView.setAdapter(new ServicesAdapter((data == null || (archiveMain = data.getArchiveMain()) == null || (body = archiveMain.getBody()) == null || (partnerView = body.getPartnerView()) == null || (titles = partnerView.getTitles()) == null) ? null : (String) CollectionsKt.getOrNull(titles, 3), new Function1<Service, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$initViews$1$14$1

            /* compiled from: ProfileFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[BlockingLevel.values().length];
                    try {
                        iArr[BlockingLevel.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BlockingLevel.PARTIAL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[BlockingLevel.FULL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Service service) throws Resources.NotFoundException {
                invoke2(service);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Service it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("curService", it.getServiceConfigIdentifier()));
                String serviceConfigIdentifier = it.getServiceConfigIdentifier();
                AndroidConstants.ServicesNames servicesNames = AndroidConstants.ServicesNames.INSTANCE;
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getDIGITAL_KEY_IDENTIFIER())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickCodesSubsProfile());
                    int i = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i == 1 || i == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_digital_code_navigation, null, null, 12, null);
                        return;
                    } else {
                        if (i != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getFR_SUBS_IDENTIFIER())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickFacerecSubsProfile());
                    int i2 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_fr_navigation, null, null, 12, null);
                        return;
                    } else {
                        if (i2 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getVIDEO_ARCHIVE_3d_IDENTIFIER())) {
                    if (it.getIsCompanyService() != null && (!r9.booleanValue())) {
                        this.this$0.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickProfileArchive());
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickArch3SubsProfile());
                    }
                    int i3 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_archive_navigation, bundleBundleOf, null, 8, null);
                        return;
                    } else {
                        if (i3 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getVIDEO_ARCHIVE_5d_IDENTIFIER())) {
                    if (it.getIsCompanyService() != null && (!r9.booleanValue())) {
                        this.this$0.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickProfileArchive());
                    }
                    int i4 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i4 == 1 || i4 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_archive_navigation, bundleBundleOf, null, 8, null);
                        return;
                    } else {
                        if (i4 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getVIDEO_ARCHIVE_7d_IDENTIFIER())) {
                    if (it.getIsCompanyService() != null && (!r9.booleanValue())) {
                        this.this$0.getAnalytics().trackLogEvent(new OnlySubscriptionEvents.ClickProfileArchive());
                        this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickArch7SubsProfile());
                    }
                    int i5 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_archive_navigation, bundleBundleOf, null, 8, null);
                        return;
                    } else {
                        if (i5 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getMOBILE_PACK())) {
                    int i6 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i6 == 1 || i6 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_mobile_pack, bundleBundleOf, null, 8, null);
                        return;
                    } else {
                        if (i6 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getBLE_IDENTIFIER())) {
                    this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.lickBleSubsProfile());
                    int i7 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i7 == 1 || i7 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_ble_navigation, bundleBundleOf, null, 8, null);
                        return;
                    } else {
                        if (i7 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                if (Intrinsics.areEqual(serviceConfigIdentifier, servicesNames.getALICE_IDENTIFIER())) {
                    int i8 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                    if (i8 == 1 || i8 == 2) {
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_yandex_home, bundleBundleOf, null, 4, null);
                        return;
                    } else {
                        if (i8 != 3) {
                            return;
                        }
                        NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                        return;
                    }
                }
                int i9 = WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()];
                if (i9 == 1 || i9 == 2) {
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_archive_navigation, bundleBundleOf, null, 8, null);
                } else {
                    if (i9 != 3) {
                        return;
                    }
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_blockingNavigation, null, null, 12, null);
                }
            }
        }));
        binding.paymentItem.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$33(this.f$0, view);
            }
        });
        binding.layoutHistory.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ProfileFragment.initViews$lambda$36$lambda$34(this.f$0, view);
            }
        });
        OnboardingViewModel onboardingViewModel = getOnboardingViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onboardingViewModel.observeSubState(viewLifecycleOwner, new Function1<OnboardingViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$initViews$1$17
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(OnboardingViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeedToShowBleFeedback();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$initViews$1$18
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
                    ProfileFragment profileFragment = this.this$0;
                    if (contentIfNotHandled.booleanValue()) {
                        profileFragment.getSurveysViewModel().loadSurvey("ble_feedback_general");
                    }
                }
            }
        });
        ConstraintLayout toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        NestedScrollView profileScroll = binding.profileScroll;
        Intrinsics.checkNotNullExpressionValue(profileScroll, "profileScroll");
        ViewKt.addSystemWindowInsetToPadding$default(profileScroll, true, false, true, true, 2, null);
        TextView btnWantMore = binding.btnWantMore;
        Intrinsics.checkNotNullExpressionValue(btnWantMore, "btnWantMore");
        SafeClickListenerKt.setSafeOnClickListener$default(btnWantMore, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$initViews$1$19
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
                this.this$0.getAnalytics().trackLogEvent(new SubscriptionsEvents.ClickWantPromoInProfile());
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_bottomSheetAboutStandartSubscription, BundleKt.bundleOf(TuplesKt.to(RemoteMessageConst.FROM, 2003)), null, 8, null);
            }
        }, 1, null);
        binding.lAddress.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.ProfileFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.initViews$lambda$36$lambda$35(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$19(FragmentSettingsProfileBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.btnSelectAccount.showContextMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$20(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new GeneralEvents.ClickProfileBetaPromo());
        this$0.getNavController().navigate(R.id.action_global_to_bottomSheetAboutBetaProgram);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$21(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_subscriptionFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$22(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "family_list_open", null, 4, null);
        this$0.getFamilyViewModel().loadFamily();
        this$0.getInvitesViewModel().loadFamilyInvites();
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_familyFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$23(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "profile_open", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_profileSettingsFragment, BundleKt.bundleOf(TuplesKt.to(Scopes.PROFILE, this$0.getProfileViewModel().getCurrentState().getProfile())), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$24(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateToNotifications();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$25(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateToNotifications();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$26(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "address_open", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_intercomSettingsFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$27(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "manage_cameras_open", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_manage_cameras_navigation, BundleKt.bundleOf(TuplesKt.to("cameras", this$0.getCamerasViewModel().getCurrentState().getMainCameras())), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$28(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_localization_navigation, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$29(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "settings", "card_open", null, 4, null);
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_card, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$30(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionProfile());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_mainHostFragment_to_permissions, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$31(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_keys, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$33(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new ServicePaymentsEvents.ClickServInUserProfile());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_servicePaymentNavigation, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$34(ProfileFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Profile profile = this$0.getProfileViewModel().getCurrentState().getProfile();
            if (profile != null ? Intrinsics.areEqual(profile.getIsNeedFeedback(), Boolean.TRUE) : false) {
                this$0.getSurveysViewModel().loadSurvey("promo_visitors");
            } else {
                this$0.navigateToCallHistory();
            }
        } catch (Exception unused) {
            this$0.navigateToCallHistory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$36$lambda$35(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getSubscriptionsViewModel().isMarketLocked()) {
            return;
        }
        this$0.getAnalytics().trackLogEvent(new MultiAddressEvents.ClickProfileAddressTile());
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_global_to_select_address, null, null, 6, null);
    }

    private final void navigateToNotifications() {
        getNotificationsViewModel().loadNotifications();
        getAnalytics().trackLogEvent(new GeneralEvents.ClickProfileNotifications());
        if (getNotificationsViewModel().getCurrentState().getNeedToShowOnboarding()) {
            getAnalytics().trackLogEvent(new GeneralEvents.ClickProfileNotificationsRedDot());
        }
        NavControllerKt.safeNavigate$default(getNavController(), R.id.action_mainHostFragment_to_notifications, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToCallHistory() throws Resources.NotFoundException {
        AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "myCameras", "archive_open", null, 4, null);
        NavControllerKt.safeNavigate$default(getNavController(), R.id.mainHostFragment, R.id.action_mainHostFragment_to_callHistoryNavigation, null, null, 12, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        SettingsBody body;
        SettingsBody body2;
        List<String> settingsItems;
        SettingsBody body3;
        List<String> settingsItems2;
        SettingsBody body4;
        List<String> settingsItems3;
        SettingsBody body5;
        List<String> settingsItems4;
        VisitsLocale visits;
        TextTitle navigation;
        SettingsBody body6;
        List<String> settingsItems5;
        SettingsBody body7;
        List<String> settingsItems6;
        SettingsBody body8;
        List<String> settingsItems7;
        SettingsBody body9;
        List<String> settingsItems8;
        SettingsBody body10;
        List<String> sectionTitles;
        SettingsBody body11;
        List<String> sectionTitles2;
        SettingsBody body12;
        TextTitle updateButton;
        SettingsNavigation navigation2;
        FragmentSettingsProfileBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String btnPromoWantMore = null;
        SettingsLocale settings = data != null ? data.getSettings() : null;
        binding.toolbarTitle.setText((settings == null || (navigation2 = settings.getNavigation()) == null) ? null : navigation2.getTitle());
        binding.btnWantMore.setText((settings == null || (body12 = settings.getBody()) == null || (updateButton = body12.getUpdateButton()) == null) ? null : updateButton.getTitle());
        UserAddress currentAddress = getProfileViewModel().getCurrentAddress();
        binding.settingsAddress.setText(StringUtilsKt.orEmpty(currentAddress != null ? currentAddress.getFullAddressWithApartment() : null));
        binding.settingsLabel.setText((settings == null || (body11 = settings.getBody()) == null || (sectionTitles2 = body11.getSectionTitles()) == null) ? null : (String) CollectionsKt.first((List) sectionTitles2));
        binding.servicesLabel.setText((settings == null || (body10 = settings.getBody()) == null || (sectionTitles = body10.getSectionTitles()) == null) ? null : (String) CollectionsKt.last((List) sectionTitles));
        binding.settingsPermissions.setTitle(StringUtilsKt.orEmpty((settings == null || (body9 = settings.getBody()) == null || (settingsItems8 = body9.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems8, 8)));
        binding.settingsCameras.setTitle(StringUtilsKt.orEmpty((settings == null || (body8 = settings.getBody()) == null || (settingsItems7 = body8.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems7, 2)));
        binding.settingsDomofon.setTitle(StringUtilsKt.orEmpty((settings == null || (body7 = settings.getBody()) == null || (settingsItems6 = body7.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems6, 0)));
        binding.settingsFamily.setTitle(StringUtilsKt.orEmpty((settings == null || (body6 = settings.getBody()) == null || (settingsItems5 = body6.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems5, 1)));
        TextView textView = binding.tvVisitsTitle;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText(String.valueOf((data2 == null || (visits = data2.getVisits()) == null || (navigation = visits.getNavigation()) == null) ? null : navigation.getTitle()));
        binding.settingsCard.setTitle(StringUtilsKt.orEmpty((settings == null || (body5 = settings.getBody()) == null || (settingsItems4 = body5.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems4, 4)));
        binding.settingsKeys.setTitle(StringUtilsKt.orEmpty((settings == null || (body4 = settings.getBody()) == null || (settingsItems3 = body4.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems3, 7)));
        binding.settingsLanguage.setTitle(StringUtilsKt.orEmpty((settings == null || (body3 = settings.getBody()) == null || (settingsItems2 = body3.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems2, 3)));
        binding.paymentItem.setTitle(StringUtilsKt.orEmpty((settings == null || (body2 = settings.getBody()) == null || (settingsItems = body2.getSettingsItems()) == null) ? null : (String) CollectionsKt.getOrNull(settingsItems, 5)));
        TextView textView2 = binding.btnWantMore;
        if (settings != null && (body = settings.getBody()) != null) {
            btnPromoWantMore = body.getBtnPromoWantMore();
        }
        textView2.setText(btnPromoWantMore);
        binding.tvOurHomeTitle.setText("Вступите в программу\nбета-тестирования");
        binding.tvOurHomeDescription.setText("Получите доступ к новейшим\nфункциям среди самых первых!");
    }
}
