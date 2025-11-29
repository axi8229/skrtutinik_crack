package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.NotificationsEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.notifications.NotificationsBody;
import com.sputnik.common.entities.localization.entities.notifications.NotificationsEmptyView;
import com.sputnik.common.entities.notifications.Notification;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.NotificationsViewState;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentNotificationsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: NotificationsFragment.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010A\u001a\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentNotificationsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentNotificationsBinding;", "binding", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "settingsProfileFactoryBuilder", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "getSettingsProfileFactoryBuilder", "()Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "setSettingsProfileFactoryBuilder", "(Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;)V", "", "notificationId", "Ljava/lang/Integer;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel$delegate", "getNotificationsViewModel", "()Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsAdapter;", "notificationsAdapter", "Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsAdapter;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NotificationsFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentNotificationsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    private Integer notificationId;
    private NotificationsAdapter notificationsAdapter;

    /* renamed from: notificationsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy notificationsViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    public SettingsProfileViewModel.Factory.AssistFactory settingsProfileFactoryBuilder;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentNotificationsBinding getBinding() {
        return (FragmentNotificationsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.notificationId = arguments != null ? Integer.valueOf(arguments.getInt("item")) : null;
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        if (getNotificationsViewModel().getCurrentState().getServerState() == Resource.Status.NONE) {
            getNotificationsViewModel().loadNotifications();
        }
        NotificationsViewModel notificationsViewModel = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        notificationsViewModel.observeState(viewLifecycleOwner, new Function1<NotificationsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment.onViewCreated.1
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
                String phoneLocale;
                Integer num;
                Intrinsics.checkNotNullParameter(it, "it");
                NotificationsAdapter notificationsAdapter = NotificationsFragment.this.notificationsAdapter;
                LocalizationLocalModel data = NotificationsFragment.this.getLocalizationScreen().getData();
                if (data == null || (phoneLocale = data.getTag()) == null) {
                    phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
                }
                notificationsAdapter.setLocale(phoneLocale);
                List<Notification> notifications = it.getNotifications();
                if (notifications.isEmpty()) {
                    notifications = null;
                }
                if (notifications != null) {
                    NotificationsFragment notificationsFragment = NotificationsFragment.this;
                    if (notificationsFragment.notificationId != null && ((num = notificationsFragment.notificationId) == null || num.intValue() != 0)) {
                        NavControllerKt.safeNavigate$default(notificationsFragment.getNavController(), R.id.action_notificationsFragment_to_notificationDetailsFragment, BundleKt.bundleOf(TuplesKt.to("item", notificationsFragment.notificationId)), null, 4, null);
                        notificationsFragment.notificationId = null;
                        Bundle arguments = notificationsFragment.getArguments();
                        if (arguments != null) {
                            arguments.putString("item", null);
                        }
                    }
                    notificationsFragment.notificationsAdapter.submitList(notifications);
                }
                LinearLayout layoutEmpty = NotificationsFragment.this.getBinding().layoutEmpty;
                Intrinsics.checkNotNullExpressionValue(layoutEmpty, "layoutEmpty");
                ViewBindingUtilsKt.visibilityBasedOn(layoutEmpty, Boolean.valueOf(it.getNotifications().isEmpty() && it.getServerState() == Resource.Status.SUCCESS));
            }
        });
        NotificationsViewModel notificationsViewModel2 = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        notificationsViewModel2.observeSubState(viewLifecycleOwner2, new Function1<NotificationsViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(NotificationsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment.onViewCreated.3
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
                LinearLayout layoutLoader = NotificationsFragment.this.getBinding().layoutLoader;
                Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
                ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(it == Resource.Status.LOADING));
                RecyclerView rvNotifications = NotificationsFragment.this.getBinding().rvNotifications;
                Intrinsics.checkNotNullExpressionValue(rvNotifications, "rvNotifications");
                ViewBindingUtilsKt.visibilityBasedOn(rvNotifications, Boolean.valueOf(it == Resource.Status.SUCCESS));
            }
        });
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        Toolbar toolbar3 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar3, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar3, true, true, true, false, 8, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        RecyclerView recyclerView = getBinding().rvNotifications;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.notificationsAdapter);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String title;
        String title2;
        NotificationsEmptyView emptyView;
        String subtitle;
        NotificationsEmptyView emptyView2;
        LocalizationLocalModel data;
        FragmentNotificationsBinding binding = getBinding();
        LocalizationStorage localizationScreen = getLocalizationScreen();
        NotificationsBody notifications = (localizationScreen == null || (data = localizationScreen.getData()) == null) ? null : data.getNotifications();
        Toolbar toolbar = binding.toolbar;
        String str = "";
        if (notifications == null || (title = notifications.getTitle()) == null) {
            title = "";
        }
        toolbar.setTitle(title);
        TextView textView = binding.tvNotificationsEmpty;
        if (notifications == null || (emptyView2 = notifications.getEmptyView()) == null || (title2 = emptyView2.getTitle()) == null) {
            title2 = "";
        }
        textView.setText(title2);
        TextView textView2 = binding.tvNotificationsEmptyDetails;
        if (notifications != null && (emptyView = notifications.getEmptyView()) != null && (subtitle = emptyView.getSubtitle()) != null) {
            str = subtitle;
        }
        textView2.setText(str);
    }

    public NotificationsFragment() {
        super(R.layout.fragment_notifications);
        this.binding = new ViewBindingFragmentDelegate(this, NotificationsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.notificationsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$notificationsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.notificationsAdapter = new NotificationsAdapter(new Function1<Notification, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$notificationsAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification notification) {
                invoke2(notification);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notification it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (Intrinsics.areEqual(it.getIdentifier(), "promo")) {
                    this.this$0.getAnalytics().trackLogEvent(new NotificationsEvents.ClickNotificationPromo1rubTrial());
                }
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_notificationsFragment_to_notificationDetailsFragment, BundleKt.bundleOf(TuplesKt.to("item", it.getId())), null, 4, null);
            }
        }, new Function1<Notification, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$notificationsAdapter$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification notification) {
                invoke2(notification);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notification it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (Intrinsics.areEqual(it.getIdentifier(), "promo")) {
                    this.this$0.getAnalytics().trackLogEvent(new NotificationsEvents.ClickNotificationPromo1rubTrial());
                }
                NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_notificationsFragment_to_notificationDetailsFragment, BundleKt.bundleOf(TuplesKt.to("item", it.getId()), TuplesKt.to("is_debug", Boolean.TRUE)), null, 4, null);
            }
        }, null, 4, null);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsFragment$navController$2
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
}
