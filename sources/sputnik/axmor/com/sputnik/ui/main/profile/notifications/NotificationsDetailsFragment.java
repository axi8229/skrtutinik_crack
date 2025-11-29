package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
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
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.NotificationsEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.notifications.NotificationsBody;
import com.sputnik.common.entities.notifications.Notification;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.NotificationsViewModel;
import com.sputnik.common.viewmodels.NotificationsViewState;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.buttons.ColorsButton;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentNotificationDetailsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: NotificationsDetailsFragment.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010A\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010A\u001a\u0004\bQ\u0010RR\u001d\u0010X\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010A\u001a\u0004\bV\u0010WR\u001d\u0010[\u001a\u0004\u0018\u00010Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010A\u001a\u0004\b[\u0010\\R\u001d\u0010a\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010A\u001a\u0004\b_\u0010`¨\u0006b"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/notifications/NotificationsDetailsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/notifications/Notification$Button;", "options", "", "renderButtons", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentNotificationDetailsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentNotificationDetailsBinding;", "binding", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "settingsProfileFactoryBuilder", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "getSettingsProfileFactoryBuilder", "()Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "setSettingsProfileFactoryBuilder", "(Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel$delegate", "getNotificationsViewModel", "()Lcom/sputnik/common/viewmodels/NotificationsViewModel;", "notificationsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "itemId$delegate", "getItemId", "()Ljava/lang/Integer;", "itemId", "", "isDebug$delegate", "isDebug", "()Ljava/lang/Boolean;", "Lcom/sputnik/common/entities/notifications/Notification;", "item$delegate", "getItem", "()Lcom/sputnik/common/entities/notifications/Notification;", "item", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsDetailsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NotificationsDetailsFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentNotificationDetailsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: isDebug$delegate, reason: from kotlin metadata */
    private final Lazy isDebug;

    /* renamed from: item$delegate, reason: from kotlin metadata */
    private final Lazy item;

    /* renamed from: itemId$delegate, reason: from kotlin metadata */
    private final Lazy itemId;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: notificationsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy notificationsViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    public SettingsProfileViewModel.Factory.AssistFactory settingsProfileFactoryBuilder;

    /* compiled from: NotificationsDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorsButton.values().length];
            try {
                iArr[ColorsButton.blue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorsButton.red.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorsButton.green.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorsButton.transparent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final FragmentNotificationDetailsBinding getBinding() {
        return (FragmentNotificationDetailsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel.getValue();
    }

    private final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getItemId() {
        return (Integer) this.itemId.getValue();
    }

    private final Boolean isDebug() {
        return (Boolean) this.isDebug.getValue();
    }

    private final Notification getItem() {
        return (Notification) this.item.getValue();
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
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        NotificationsViewModel notificationsViewModel = getNotificationsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        notificationsViewModel.observeState(viewLifecycleOwner, new Function1<NotificationsViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NotificationsViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NotificationsViewState notificationsViewState) {
                invoke2(notificationsViewState);
                return Unit.INSTANCE;
            }
        });
        Notification item = getItem();
        if (item != null) {
            Intrinsics.areEqual(isDebug(), Boolean.TRUE);
            List<Notification.Button> buttons = item.getButtons();
            if (buttons != null) {
                renderButtons(buttons);
            }
            if (Intrinsics.areEqual(item.getViewed(), Boolean.FALSE)) {
                getNotificationsViewModel().readNotification(item);
            }
        }
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        Toolbar toolbar3 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar3, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar3, true, true, true, false, 8, null);
    }

    public NotificationsDetailsFragment() {
        super(R.layout.fragment_notification_details);
        this.binding = new ViewBindingFragmentDelegate(this, NotificationsDetailsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.notificationsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$notificationsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$navController$2
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
        this.itemId = LazyKt.lazy(new Function0<Integer>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$itemId$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return Integer.valueOf(arguments.getInt("item"));
                }
                return null;
            }
        });
        this.isDebug = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment.isDebug.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = NotificationsDetailsFragment.this.getArguments();
                if (arguments != null) {
                    return Boolean.valueOf(arguments.getBoolean("is_debug"));
                }
                return null;
            }
        });
        this.item = LazyKt.lazy(new Function0<Notification>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$item$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Notification invoke() {
                Object next;
                List<Notification> notifications = this.this$0.getNotificationsViewModel().getCurrentState().getNotifications();
                NotificationsDetailsFragment notificationsDetailsFragment = this.this$0;
                Iterator<T> it = notifications.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((Notification) next).getId(), notificationsDetailsFragment.getItemId())) {
                        break;
                    }
                }
                return (Notification) next;
            }
        });
    }

    private final void renderButtons(List<Notification.Button> options) {
        ColorsButton color;
        FragmentNotificationDetailsBinding binding = getBinding();
        for (final Notification.Button button : options) {
            if ((button != null ? button.getColor() : null) == null && button != null) {
                button.setColor(ColorsButton.blue);
            }
            if (button != null && (color = button.getColor()) != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[color.ordinal()];
                View viewInflate = getLayoutInflater().inflate(i != 1 ? i != 2 ? i != 3 ? R.layout.layout_button_transparent : R.layout.layout_button_green : R.layout.layout_button_pink : R.layout.layout_button_blue, (ViewGroup) null);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatButton");
                final AppCompatButton appCompatButton = (AppCompatButton) viewInflate;
                appCompatButton.setText(button.getTitle());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                Resources resources = appCompatButton.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                layoutParams.setMargins(0, DpUtilsKt.convertPxToDb(16.0f, resources), 0, 0);
                appCompatButton.setLayoutParams(layoutParams);
                appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.notifications.NotificationsDetailsFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NotificationsDetailsFragment.renderButtons$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(button, this, appCompatButton, view);
                    }
                });
                binding.layoutButtons.addView(appCompatButton);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderButtons$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(Notification.Button serverButton, NotificationsDetailsFragment this$0, AppCompatButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(serverButton, "$serverButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (serverButton.getDeeplink() != null) {
            if (Intrinsics.areEqual(serverButton.getDeeplink(), "market/standard")) {
                this$0.getAnalytics().trackLogEvent(new NotificationsEvents.ClickBtnFromNotificationsTransitionMarketStandart());
            }
            IntentProcessingUtilsKt.handleDeeplink(serverButton.getDeeplink(), BundleKt.bundleOf(), this$0.getActivity(), this$0.getNavigationViewModel(), this$0.getProfileViewModel(), this$0.getAnalytics(), androidx.navigation.ViewKt.findNavController(this_apply));
        } else {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                IntentUtilsKt.openBrowser(activity, serverButton.getLink());
            }
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentNotificationDetailsBinding binding = getBinding();
        TextView textView = binding.tvNotificationTitle;
        Notification item = getItem();
        textView.setText(item != null ? item.getTitle() : null);
        TextView textView2 = binding.tvNotificationMessage;
        Notification item2 = getItem();
        textView2.setText(item2 != null ? item2.getMessage() : null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String title;
        LocalizationLocalModel data;
        FragmentNotificationDetailsBinding binding = getBinding();
        LocalizationStorage localizationScreen = getLocalizationScreen();
        NotificationsBody notifications = (localizationScreen == null || (data = localizationScreen.getData()) == null) ? null : data.getNotifications();
        Toolbar toolbar = binding.toolbar;
        if (notifications == null || (title = notifications.getTitle()) == null) {
            title = "";
        }
        toolbar.setTitle(title);
    }
}
