package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.fragment.FragmentNavigatorExtrasKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.BlockingLevel;
import com.sputnik.common.GlobalVariables;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.analytics.CamerasEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.camera.CameraObject;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ManageCamerasBody;
import com.sputnik.common.entities.localization.ManageCamerasBottomView;
import com.sputnik.common.entities.localization.ManageCamerasLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentManageCamerasBinding;
import sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewState;

/* compiled from: ManageCamerasFragment.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001mB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010G\u001a\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010G\u001a\u0004\bZ\u0010[R\u001b\u0010_\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010G\u001a\u0004\b^\u0010[R\u0017\u0010a\u001a\u00020`8\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010G\u001a\u0004\bg\u0010hR\u001b\u0010l\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010G\u001a\u0004\bk\u0010h¨\u0006n"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "updateCameraTitle", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasFragment$Move;", "move", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;", "adapterType", "trackMoveAnalytics", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasFragment$Move;Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$ManageCamerasAdapterTypes;)V", "openCamerasTab", "openCamerasInWidgetTab", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "onDestroy", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentManageCamerasBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentManageCamerasBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "manageCameraViewModelFactory", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "getManageCameraViewModelFactory", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "setManageCameraViewModelFactory", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel$delegate", "Lkotlin/Lazy;", "getManageCamerasViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "", "camerasLoaded", "Z", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter;", "manageCamerasAdapter$delegate", "getManageCamerasAdapter", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter;", "manageCamerasAdapter", "manageCamerasInWidgetAdapter$delegate", "getManageCamerasInWidgetAdapter", "manageCamerasInWidgetAdapter", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "simpleItemTouchCallback", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "getSimpleItemTouchCallback", "()Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper$delegate", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "itemTouchWidgetHelper$delegate", "getItemTouchWidgetHelper", "itemTouchWidgetHelper", "Move", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageCamerasFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ManageCamerasFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentManageCamerasBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;
    private boolean camerasLoaded;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: itemTouchHelper$delegate, reason: from kotlin metadata */
    private final Lazy itemTouchHelper;

    /* renamed from: itemTouchWidgetHelper$delegate, reason: from kotlin metadata */
    private final Lazy itemTouchWidgetHelper;
    public LocalizationStorage localizationScreen;
    public ManageCamerasViewModel.Factory.AssistFactory manageCameraViewModelFactory;

    /* renamed from: manageCamerasAdapter$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasAdapter;

    /* renamed from: manageCamerasInWidgetAdapter$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasInWidgetAdapter;

    /* renamed from: manageCamerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ItemTouchHelper.SimpleCallback simpleItemTouchCallback;

    /* compiled from: ManageCamerasFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockingLevel.values().length];
            try {
                iArr[BlockingLevel.PARTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentManageCamerasBinding getBinding() {
        return (FragmentManageCamerasBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final ManageCamerasViewModel.Factory.AssistFactory getManageCameraViewModelFactory() {
        ManageCamerasViewModel.Factory.AssistFactory assistFactory = this.manageCameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("manageCameraViewModelFactory");
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

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ManageCamerasViewModel getManageCamerasViewModel() {
        return (ManageCamerasViewModel) this.manageCamerasViewModel.getValue();
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
    public final ManageCamerasAdapter getManageCamerasAdapter() {
        return (ManageCamerasAdapter) this.manageCamerasAdapter.getValue();
    }

    private final ManageCamerasAdapter getManageCamerasInWidgetAdapter() {
        return (ManageCamerasAdapter) this.manageCamerasInWidgetAdapter.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getManageCamerasViewModel().getCurrentState().getIsWidgetTabSelected()) {
            openCamerasInWidgetTab();
        } else {
            openCamerasTab();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getManageCamerasViewModel().clearSelectedTab();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AllCamerasViewState allCamerasViewState) {
                invoke2(allCamerasViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Resource.Status widgetState = it.getWidgetState();
                Resource.Status status = Resource.Status.LOADING;
                if (widgetState == status || it.getAllCamerasState() == status) {
                    LinearLayout serviceLoader = ManageCamerasFragment.this.getBinding().serviceLoader;
                    Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
                    ViewKt.visible(serviceLoader);
                }
                Resource.Status widgetState2 = it.getWidgetState();
                Resource.Status status2 = Resource.Status.SUCCESS;
                if (widgetState2 == status2 && it.getAllCamerasState() == status2) {
                    LinearLayout serviceLoader2 = ManageCamerasFragment.this.getBinding().serviceLoader;
                    Intrinsics.checkNotNullExpressionValue(serviceLoader2, "serviceLoader");
                    ViewKt.gone(serviceLoader2);
                    NestedScrollView scrollView = ManageCamerasFragment.this.getBinding().scrollView;
                    Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
                    ViewKt.visible(scrollView);
                }
                if (it.getWidgetState() != status2 && it.getAllCamerasState() != status2) {
                    NestedScrollView scrollView2 = ManageCamerasFragment.this.getBinding().scrollView;
                    Intrinsics.checkNotNullExpressionValue(scrollView2, "scrollView");
                    ViewKt.gone(scrollView2);
                }
                if (it.getServerState() != status2) {
                    BaseViewModel.delayRequestWithBlocking$default(ManageCamerasFragment.this.getCamerasViewModel(), 0L, "load_cameras", 0L, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, 5, null);
                }
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner2, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }
        });
        if (!this.camerasLoaded) {
            this.camerasLoaded = true;
            getCamerasViewModel().loadAllCameras();
            getCamerasViewModel().loadWidgetCameras();
        }
        AllCamerasViewModel camerasViewModel2 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        camerasViewModel2.observeSubState(viewLifecycleOwner3, new Function1<AllCamerasViewState, List<? extends Camera>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final List<Camera> invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getWidgetCameras();
            }
        }, new Function1<List<? extends Camera>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Camera> list) {
                invoke2((List<Camera>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Camera> it) {
                ManageCamerasLocale manageCameras;
                ManageCamerasBody body;
                List<String> sectionTitles;
                String str;
                ManageCamerasLocale manageCameras2;
                ManageCamerasBody body2;
                List<String> sectionTitles2;
                String str2;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ManageCamerasFragment manageCamerasFragment = ManageCamerasFragment.this;
                    LocalizationLocalModel data = manageCamerasFragment.getLocalizationScreen().getData();
                    if (data != null && (manageCameras2 = data.getManageCameras()) != null && (body2 = manageCameras2.getBody()) != null && (sectionTitles2 = body2.getSectionTitles()) != null && (str2 = (String) CollectionsKt.getOrNull(sectionTitles2, 0)) != null) {
                        arrayList.add(new ManageCamerasItem.ManageTitle(str2));
                    }
                    List<Camera> list = it;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (((Camera) obj).getWidget()) {
                            arrayList2.add(obj);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        String address = null;
                        if (!it2.hasNext()) {
                            break;
                        }
                        Camera camera = (Camera) it2.next();
                        Profile profile = manageCamerasFragment.getProfileViewModel().getCurrentState().getProfile();
                        if (profile != null) {
                            address = profile.getAddress();
                        }
                        arrayList3.add(new ManageCamerasItem.ManageCamera(camera.copy((3145727 & 1) != 0 ? camera.uuid : null, (3145727 & 2) != 0 ? camera.streamUrl : null, (3145727 & 4) != 0 ? camera.previewUrl : null, (3145727 & 8) != 0 ? camera.isIntercom : false, (3145727 & 16) != 0 ? camera.intercomUuid : null, (3145727 & 32) != 0 ? camera.intercomSerial : null, (3145727 & 64) != 0 ? camera.width : 0, (3145727 & 128) != 0 ? camera.height : 0, (3145727 & 256) != 0 ? camera.title : null, (3145727 & 512) != 0 ? camera.order : null, (3145727 & 1024) != 0 ? camera.widget : false, (3145727 & 2048) != 0 ? camera.address : address, (3145727 & 4096) != 0 ? camera.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? camera.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? camera.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? camera.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? camera.extraKeyReader : null, (3145727 & 131072) != 0 ? camera.mainScreen : false, (3145727 & 262144) != 0 ? camera.subscriptionRequried : null, (3145727 & 524288) != 0 ? camera.canOpen : null, (3145727 & 1048576) != 0 ? camera.isLive : false, (3145727 & 2097152) != 0 ? camera.isSelected : false)));
                    }
                    arrayList.addAll(arrayList3);
                    LocalizationLocalModel data2 = manageCamerasFragment.getLocalizationScreen().getData();
                    if (data2 != null && (manageCameras = data2.getManageCameras()) != null && (body = manageCameras.getBody()) != null && (sectionTitles = body.getSectionTitles()) != null && (str = (String) CollectionsKt.getOrNull(sectionTitles, 1)) != null) {
                        arrayList.add(new ManageCamerasItem.ManageTitle(str));
                    }
                    ArrayList<Camera> arrayList4 = new ArrayList();
                    for (Object obj2 : list) {
                        if (!((Camera) obj2).getWidget()) {
                            arrayList4.add(obj2);
                        }
                    }
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                    for (Camera camera2 : arrayList4) {
                        Profile profile2 = manageCamerasFragment.getProfileViewModel().getCurrentState().getProfile();
                        arrayList5.add(new ManageCamerasItem.ManageCamera(camera2.copy((3145727 & 1) != 0 ? camera2.uuid : null, (3145727 & 2) != 0 ? camera2.streamUrl : null, (3145727 & 4) != 0 ? camera2.previewUrl : null, (3145727 & 8) != 0 ? camera2.isIntercom : false, (3145727 & 16) != 0 ? camera2.intercomUuid : null, (3145727 & 32) != 0 ? camera2.intercomSerial : null, (3145727 & 64) != 0 ? camera2.width : 0, (3145727 & 128) != 0 ? camera2.height : 0, (3145727 & 256) != 0 ? camera2.title : null, (3145727 & 512) != 0 ? camera2.order : null, (3145727 & 1024) != 0 ? camera2.widget : false, (3145727 & 2048) != 0 ? camera2.address : profile2 != null ? profile2.getAddress() : null, (3145727 & 4096) != 0 ? camera2.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? camera2.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? camera2.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? camera2.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? camera2.extraKeyReader : null, (3145727 & 131072) != 0 ? camera2.mainScreen : false, (3145727 & 262144) != 0 ? camera2.subscriptionRequried : null, (3145727 & 524288) != 0 ? camera2.canOpen : null, (3145727 & 1048576) != 0 ? camera2.isLive : false, (3145727 & 2097152) != 0 ? camera2.isSelected : false)));
                    }
                    arrayList.addAll(arrayList5);
                    RecyclerView.Adapter adapter = ManageCamerasFragment.this.getBinding().rvCamerasInWidget.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter");
                    ((ManageCamerasAdapter) adapter).submitList(arrayList);
                }
            }
        });
        AllCamerasViewModel camerasViewModel3 = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        camerasViewModel3.observeSubState(viewLifecycleOwner4, new Function1<AllCamerasViewState, List<? extends Camera>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final List<Camera> invoke(AllCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getAllCameras();
            }
        }, new Function1<List<? extends Camera>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Camera> list) {
                invoke2((List<Camera>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Camera> it) {
                ManageCamerasLocale manageCameras;
                ManageCamerasBody body;
                List<String> sectionTitlesMainScreen;
                String str;
                ManageCamerasLocale manageCameras2;
                ManageCamerasBody body2;
                List<String> sectionTitlesMainScreen2;
                String str2;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ManageCamerasFragment manageCamerasFragment = ManageCamerasFragment.this;
                    LocalizationLocalModel data = manageCamerasFragment.getLocalizationScreen().getData();
                    if (data != null && (manageCameras2 = data.getManageCameras()) != null && (body2 = manageCameras2.getBody()) != null && (sectionTitlesMainScreen2 = body2.getSectionTitlesMainScreen()) != null && (str2 = (String) CollectionsKt.getOrNull(sectionTitlesMainScreen2, 0)) != null) {
                        arrayList.add(new ManageCamerasItem.ManageTitle(str2));
                    }
                    List<Camera> list = it;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (((Camera) obj).getMainScreen()) {
                            arrayList2.add(obj);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        String address = null;
                        if (!it2.hasNext()) {
                            break;
                        }
                        Camera camera = (Camera) it2.next();
                        Profile profile = manageCamerasFragment.getProfileViewModel().getCurrentState().getProfile();
                        if (profile != null) {
                            address = profile.getAddress();
                        }
                        arrayList3.add(new ManageCamerasItem.ManageCamera(camera.copy((3145727 & 1) != 0 ? camera.uuid : null, (3145727 & 2) != 0 ? camera.streamUrl : null, (3145727 & 4) != 0 ? camera.previewUrl : null, (3145727 & 8) != 0 ? camera.isIntercom : false, (3145727 & 16) != 0 ? camera.intercomUuid : null, (3145727 & 32) != 0 ? camera.intercomSerial : null, (3145727 & 64) != 0 ? camera.width : 0, (3145727 & 128) != 0 ? camera.height : 0, (3145727 & 256) != 0 ? camera.title : null, (3145727 & 512) != 0 ? camera.order : null, (3145727 & 1024) != 0 ? camera.widget : false, (3145727 & 2048) != 0 ? camera.address : address, (3145727 & 4096) != 0 ? camera.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? camera.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? camera.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? camera.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? camera.extraKeyReader : null, (3145727 & 131072) != 0 ? camera.mainScreen : false, (3145727 & 262144) != 0 ? camera.subscriptionRequried : null, (3145727 & 524288) != 0 ? camera.canOpen : null, (3145727 & 1048576) != 0 ? camera.isLive : false, (3145727 & 2097152) != 0 ? camera.isSelected : false)));
                    }
                    arrayList.addAll(arrayList3);
                    LocalizationLocalModel data2 = manageCamerasFragment.getLocalizationScreen().getData();
                    if (data2 != null && (manageCameras = data2.getManageCameras()) != null && (body = manageCameras.getBody()) != null && (sectionTitlesMainScreen = body.getSectionTitlesMainScreen()) != null && (str = (String) CollectionsKt.getOrNull(sectionTitlesMainScreen, 1)) != null) {
                        arrayList.add(new ManageCamerasItem.ManageTitle(str));
                    }
                    ArrayList<Camera> arrayList4 = new ArrayList();
                    for (Object obj2 : list) {
                        if (!((Camera) obj2).getMainScreen()) {
                            arrayList4.add(obj2);
                        }
                    }
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                    for (Camera camera2 : arrayList4) {
                        Profile profile2 = manageCamerasFragment.getProfileViewModel().getCurrentState().getProfile();
                        arrayList5.add(new ManageCamerasItem.ManageCamera(camera2.copy((3145727 & 1) != 0 ? camera2.uuid : null, (3145727 & 2) != 0 ? camera2.streamUrl : null, (3145727 & 4) != 0 ? camera2.previewUrl : null, (3145727 & 8) != 0 ? camera2.isIntercom : false, (3145727 & 16) != 0 ? camera2.intercomUuid : null, (3145727 & 32) != 0 ? camera2.intercomSerial : null, (3145727 & 64) != 0 ? camera2.width : 0, (3145727 & 128) != 0 ? camera2.height : 0, (3145727 & 256) != 0 ? camera2.title : null, (3145727 & 512) != 0 ? camera2.order : null, (3145727 & 1024) != 0 ? camera2.widget : false, (3145727 & 2048) != 0 ? camera2.address : profile2 != null ? profile2.getAddress() : null, (3145727 & 4096) != 0 ? camera2.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? camera2.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? camera2.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? camera2.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? camera2.extraKeyReader : null, (3145727 & 131072) != 0 ? camera2.mainScreen : false, (3145727 & 262144) != 0 ? camera2.subscriptionRequried : null, (3145727 & 524288) != 0 ? camera2.canOpen : null, (3145727 & 1048576) != 0 ? camera2.isLive : false, (3145727 & 2097152) != 0 ? camera2.isSelected : false)));
                    }
                    arrayList.addAll(arrayList5);
                    RecyclerView.Adapter adapter = ManageCamerasFragment.this.getBinding().rvCameras.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter");
                    ((ManageCamerasAdapter) adapter).submitList(arrayList);
                }
            }
        });
        ManageCamerasViewModel manageCamerasViewModel = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        manageCamerasViewModel.observeSubState(viewLifecycleOwner5, new Function1<ManageCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedTitle();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.8
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
                    ManageCamerasFragment manageCamerasFragment = ManageCamerasFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        manageCamerasFragment.updateCameraTitle();
                        AllCamerasViewModel camerasViewModel4 = manageCamerasFragment.getCamerasViewModel();
                        List<CameraObject> cameras = manageCamerasFragment.getManageCamerasViewModel().getCurrentState().getOrderCameras().getCameras();
                        if (cameras == null) {
                            cameras = CollectionsKt.emptyList();
                        }
                        camerasViewModel4.updateCamerasList(cameras);
                        manageCamerasFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        manageCamerasFragment.getManageCamerasViewModel().clearSavedTitle();
                    }
                }
            }
        });
        ManageCamerasViewModel manageCamerasViewModel2 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        manageCamerasViewModel2.observeSubState(viewLifecycleOwner6, new Function1<ManageCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedOrder();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.10
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
                    ManageCamerasFragment manageCamerasFragment = ManageCamerasFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        AllCamerasViewModel camerasViewModel4 = manageCamerasFragment.getCamerasViewModel();
                        List<CameraObject> cameras = manageCamerasFragment.getManageCamerasViewModel().getCurrentState().getOrderCameras().getCameras();
                        if (cameras == null) {
                            cameras = CollectionsKt.emptyList();
                        }
                        camerasViewModel4.updateCamerasList(cameras);
                        manageCamerasFragment.getCamerasViewModel().handleNeedUpdate(true);
                    }
                }
            }
        });
        ManageCamerasViewModel manageCamerasViewModel3 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        manageCamerasViewModel3.observeNotifications(viewLifecycleOwner7, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.11
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
                ManageCamerasFragment manageCamerasFragment = ManageCamerasFragment.this;
                ConstraintLayout root = manageCamerasFragment.getBinding().root;
                Intrinsics.checkNotNullExpressionValue(root, "root");
                ViewKt.renderNotifications(manageCamerasFragment, root, it);
            }
        });
        ManageCamerasViewModel manageCamerasViewModel4 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        manageCamerasViewModel4.observeSubState(viewLifecycleOwner8, new Function1<ManageCamerasViewState, CamerasOrder>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.12
            @Override // kotlin.jvm.functions.Function1
            public final CamerasOrder invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getOrderCameras();
            }
        }, new Function1<CamerasOrder, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment.onViewCreated.13
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CamerasOrder orderCameras) {
                Intrinsics.checkNotNullParameter(orderCameras, "orderCameras");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CamerasOrder camerasOrder) {
                invoke2(camerasOrder);
                return Unit.INSTANCE;
            }
        });
        if (WhenMappings.$EnumSwitchMapping$0[GlobalVariables.INSTANCE.getBlockLevel().ordinal()] == 1) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.mainHostFragment, R.id.action_manageCamerasFragment_to_blockingNavigation, null, null, 12, null);
        }
    }

    public ManageCamerasFragment() {
        super(R.layout.fragment_manage_cameras);
        this.binding = new ViewBindingFragmentDelegate(this, ManageCamerasFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.manageCamerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ManageCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ManageCamerasLocale manageCameras;
                ManageCamerasViewModel.Factory.AssistFactory manageCameraViewModelFactory = this.this$0.getManageCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return manageCameraViewModelFactory.create((data == null || (manageCameras = data.getManageCameras()) == null) ? null : manageCameras.getErrorInWidget());
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$camerasViewModel$2
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
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$special$$inlined$activityViewModels$default$9
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.manageCamerasAdapter = LazyKt.lazy(new Function0<ManageCamerasAdapter>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasAdapter$2
            {
                super(0);
            }

            /* compiled from: ManageCamerasFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasAdapter$2$1, reason: invalid class name */
            /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<List<? extends ManageCamerasItem>, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, ManageCamerasViewModel.class, "handleSaveNewOrder", "handleSaveNewOrder(Ljava/util/List;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ManageCamerasItem> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends ManageCamerasItem> p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    ((ManageCamerasViewModel) this.receiver).handleSaveNewOrder(p0);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final ManageCamerasAdapter invoke() {
                ManageCamerasLocale manageCameras;
                String errorTooMuch;
                ManageCamerasLocale manageCameras2;
                String errorInMainScreen;
                ItemTouchHelper itemTouchHelper = this.this$0.getItemTouchHelper();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0.getManageCamerasViewModel());
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                String str = (data == null || (manageCameras2 = data.getManageCameras()) == null || (errorInMainScreen = manageCameras2.getErrorInMainScreen()) == null) ? "" : errorInMainScreen;
                LocalizationLocalModel data2 = this.this$0.getLocalizationScreen().getData();
                String str2 = (data2 == null || (manageCameras = data2.getManageCameras()) == null || (errorTooMuch = manageCameras.getErrorTooMuch()) == null) ? "" : errorTooMuch;
                ManageCamerasAdapter.ManageCamerasAdapterTypes manageCamerasAdapterTypes = ManageCamerasAdapter.ManageCamerasAdapterTypes.MAIN_CAMERAS;
                final ManageCamerasFragment manageCamerasFragment = this.this$0;
                return new ManageCamerasAdapter(itemTouchHelper, anonymousClass1, 15, new Function2<View, Camera, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasAdapter$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Camera camera) throws Resources.NotFoundException {
                        invoke2(view, camera);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, Camera camera) throws Resources.NotFoundException {
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(camera, "camera");
                        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("camera", camera));
                        String transitionName = camera.getTransitionName();
                        Intrinsics.checkNotNull(transitionName);
                        Log.e("transationName", transitionName);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(manageCamerasFragment), R.id.manageCamerasFragment, R.id.action_manageCamerasFragment_to_manageCamerasDetails, bundleBundleOf, null, 8, null);
                    }
                }, str, str2, manageCamerasAdapterTypes);
            }
        });
        this.manageCamerasInWidgetAdapter = LazyKt.lazy(new Function0<ManageCamerasAdapter>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasInWidgetAdapter$2
            {
                super(0);
            }

            /* compiled from: ManageCamerasFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasInWidgetAdapter$2$1, reason: invalid class name */
            /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<List<? extends ManageCamerasItem>, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, ManageCamerasViewModel.class, "handleSaveNewOrderForWidgets", "handleSaveNewOrderForWidgets(Ljava/util/List;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ManageCamerasItem> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends ManageCamerasItem> p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    ((ManageCamerasViewModel) this.receiver).handleSaveNewOrderForWidgets(p0);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final ManageCamerasAdapter invoke() {
                ManageCamerasLocale manageCameras;
                String errorTooMuch;
                ManageCamerasLocale manageCameras2;
                String errorInWidget;
                ItemTouchHelper itemTouchWidgetHelper = this.this$0.getItemTouchWidgetHelper();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0.getManageCamerasViewModel());
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                String str = (data == null || (manageCameras2 = data.getManageCameras()) == null || (errorInWidget = manageCameras2.getErrorInWidget()) == null) ? "" : errorInWidget;
                LocalizationLocalModel data2 = this.this$0.getLocalizationScreen().getData();
                String str2 = (data2 == null || (manageCameras = data2.getManageCameras()) == null || (errorTooMuch = manageCameras.getErrorTooMuch()) == null) ? "" : errorTooMuch;
                ManageCamerasAdapter.ManageCamerasAdapterTypes manageCamerasAdapterTypes = ManageCamerasAdapter.ManageCamerasAdapterTypes.WIDGETS;
                final ManageCamerasFragment manageCamerasFragment = this.this$0;
                return new ManageCamerasAdapter(itemTouchWidgetHelper, anonymousClass1, 4, new Function2<View, Camera, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$manageCamerasInWidgetAdapter$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Camera camera) throws Resources.NotFoundException {
                        invoke2(view, camera);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, Camera camera) throws Resources.NotFoundException {
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(camera, "camera");
                        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("camera", camera));
                        String transitionName = camera.getTransitionName();
                        Intrinsics.checkNotNull(transitionName);
                        Log.e("transationName", transitionName);
                        String transitionName2 = camera.getTransitionName();
                        Intrinsics.checkNotNull(transitionName2);
                        NavControllerKt.safeNavigate(FragmentKt.findNavController(manageCamerasFragment), R.id.manageCamerasFragment, R.id.action_manageCamerasFragment_to_manageCamerasDetails, bundleBundleOf, FragmentNavigatorExtrasKt.FragmentNavigatorExtras(TuplesKt.to(view, transitionName2)));
                    }
                }, str, str2, manageCamerasAdapterTypes);
            }
        });
        this.simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$simpleItemTouchCallback$1
            private ManageCamerasFragment.Move currentMove;

            /* compiled from: ManageCamerasFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ManageCamerasAdapter.MoveRestrictions.values().length];
                    try {
                        iArr[ManageCamerasAdapter.MoveRestrictions.TOO_MUCH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ManageCamerasAdapter.MoveRestrictions.EMPTY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return false;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            }

            {
                super(3, 0);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                Intrinsics.checkNotNullParameter(target, "target");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
                int bindingAdapterPosition2 = target.getBindingAdapterPosition();
                if (bindingAdapterPosition2 != 0) {
                    ManageCamerasAdapter manageCamerasAdapter = adapter instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter : null;
                    if (manageCamerasAdapter != null) {
                        this.currentMove = new ManageCamerasFragment.Move(bindingAdapterPosition, bindingAdapterPosition2, manageCamerasAdapter.getList(), null, null, 24, null);
                        manageCamerasAdapter.moveItem(bindingAdapterPosition, bindingAdapterPosition2);
                        ManageCamerasFragment.Move move = this.currentMove;
                        if (move != null) {
                            move.setNewList(manageCamerasAdapter.getList());
                        }
                    }
                    this.this$0.getBinding().btnSave.setEnabled(true);
                }
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
                if (actionState == 2) {
                    View view = viewHolder != null ? viewHolder.itemView : null;
                    if (view == null) {
                        return;
                    }
                    view.setAlpha(0.5f);
                }
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(current, "current");
                Intrinsics.checkNotNullParameter(target, "target");
                return current.getItemViewType() == 0;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                ArrayList<ManageCamerasItem> list;
                List mutableList;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                super.clearView(recyclerView, viewHolder);
                ManageCamerasFragment.Move move = this.currentMove;
                if (move != null) {
                    ManageCamerasFragment manageCamerasFragment = this.this$0;
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    ManageCamerasAdapter manageCamerasAdapter = adapter instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter : null;
                    ManageCamerasAdapter.MoveRestrictions moveRestrictionsCanMoveToFirstSection$default = manageCamerasAdapter != null ? ManageCamerasAdapter.canMoveToFirstSection$default(manageCamerasAdapter, move.getFrom(), move.getTo(), null, 4, null) : null;
                    LogUtilsKt.writeLog("GGGG: CAN MOVE=" + moveRestrictionsCanMoveToFirstSection$default);
                    RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                    ManageCamerasAdapter manageCamerasAdapter2 = adapter2 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter2 : null;
                    if (manageCamerasAdapter2 != null) {
                        manageCamerasAdapter2.printList(move.getOriginalList(), "clear-old");
                    }
                    RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
                    ManageCamerasAdapter manageCamerasAdapter3 = adapter3 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter3 : null;
                    if (manageCamerasAdapter3 != null) {
                        manageCamerasAdapter3.printList(move.getNewList(), "clear-new");
                    }
                    int i = moveRestrictionsCanMoveToFirstSection$default == null ? -1 : WhenMappings.$EnumSwitchMapping$0[moveRestrictionsCanMoveToFirstSection$default.ordinal()];
                    if (i == 1) {
                        RecyclerView.Adapter adapter4 = recyclerView.getAdapter();
                        ManageCamerasAdapter manageCamerasAdapter4 = adapter4 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter4 : null;
                        if (manageCamerasAdapter4 != null) {
                            ManageCamerasAdapter.notifyItems$default(manageCamerasAdapter4, CollectionsKt.toMutableList((Collection) move.getOriginalList()), false, false, 6, null);
                        }
                        ManageCamerasViewModel manageCamerasViewModel = manageCamerasFragment.getManageCamerasViewModel();
                        RecyclerView.Adapter adapter5 = recyclerView.getAdapter();
                        ManageCamerasAdapter manageCamerasAdapter5 = adapter5 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter5 : null;
                        manageCamerasViewModel.notifyErrorMessage(manageCamerasAdapter5 != null ? manageCamerasAdapter5.getErrorFull() : null);
                    } else if (i == 2) {
                        RecyclerView.Adapter adapter6 = recyclerView.getAdapter();
                        ManageCamerasAdapter manageCamerasAdapter6 = adapter6 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter6 : null;
                        if (manageCamerasAdapter6 != null) {
                            ManageCamerasAdapter.notifyItems$default(manageCamerasAdapter6, CollectionsKt.toMutableList((Collection) move.getOriginalList()), false, false, 6, null);
                        }
                        ManageCamerasViewModel manageCamerasViewModel2 = manageCamerasFragment.getManageCamerasViewModel();
                        RecyclerView.Adapter adapter7 = recyclerView.getAdapter();
                        ManageCamerasAdapter manageCamerasAdapter7 = adapter7 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter7 : null;
                        manageCamerasViewModel2.notifyErrorMessage(manageCamerasAdapter7 != null ? manageCamerasAdapter7.getErrorEmpty() : null);
                    } else {
                        RecyclerView.Adapter adapter8 = recyclerView.getAdapter();
                        Intrinsics.checkNotNull(adapter8, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasAdapter");
                        ManageCamerasAdapter manageCamerasAdapter8 = (ManageCamerasAdapter) adapter8;
                        manageCamerasFragment.trackMoveAnalytics(move, manageCamerasAdapter8 != null ? manageCamerasAdapter8.getAdapterType() : null);
                        RecyclerView.Adapter adapter9 = recyclerView.getAdapter();
                        ManageCamerasAdapter manageCamerasAdapter9 = adapter9 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter9 : null;
                        if (manageCamerasAdapter9 != null && (list = manageCamerasAdapter9.getList()) != null && (mutableList = CollectionsKt.toMutableList((Collection) list)) != null) {
                            RecyclerView.Adapter adapter10 = recyclerView.getAdapter();
                            ManageCamerasAdapter manageCamerasAdapter10 = adapter10 instanceof ManageCamerasAdapter ? (ManageCamerasAdapter) adapter10 : null;
                            if (manageCamerasAdapter10 != null) {
                                ManageCamerasAdapter.notifyItems$default(manageCamerasAdapter10, mutableList, true, false, 4, null);
                            }
                        }
                    }
                }
                viewHolder.itemView.setAlpha(1.0f);
            }
        };
        this.itemTouchHelper = LazyKt.lazy(new Function0<ItemTouchHelper>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$itemTouchHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ItemTouchHelper invoke() {
                return new ItemTouchHelper(this.this$0.getSimpleItemTouchCallback());
            }
        });
        this.itemTouchWidgetHelper = LazyKt.lazy(new Function0<ItemTouchHelper>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$itemTouchWidgetHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ItemTouchHelper invoke() {
                return new ItemTouchHelper(this.this$0.getSimpleItemTouchCallback());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCameraTitle() {
        Object obj;
        Object next;
        ManageCamerasViewState currentState = getManageCamerasViewModel().getCurrentState();
        ArrayList arrayList = new ArrayList(getManageCamerasAdapter().getCurrentList());
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ManageCamerasItem manageCamerasItem = (ManageCamerasItem) next;
            if ((manageCamerasItem instanceof ManageCamerasItem.ManageCamera) && Intrinsics.areEqual(((ManageCamerasItem.ManageCamera) manageCamerasItem).getItem().getUuid(), currentState.getCameraUuid())) {
                break;
            }
        }
        ManageCamerasItem manageCamerasItem2 = (ManageCamerasItem) next;
        if (manageCamerasItem2 != null) {
            final int iIndexOf = arrayList.indexOf(manageCamerasItem2);
            ManageCamerasItem.ManageCamera manageCamera = (ManageCamerasItem.ManageCamera) manageCamerasItem2;
            Camera item = manageCamera.getItem();
            String title = currentState.getCurCameraObject().getTitle();
            Intrinsics.checkNotNull(title);
            arrayList.set(iIndexOf, manageCamera.copy(item.copy((3145727 & 1) != 0 ? item.uuid : null, (3145727 & 2) != 0 ? item.streamUrl : null, (3145727 & 4) != 0 ? item.previewUrl : null, (3145727 & 8) != 0 ? item.isIntercom : false, (3145727 & 16) != 0 ? item.intercomUuid : null, (3145727 & 32) != 0 ? item.intercomSerial : null, (3145727 & 64) != 0 ? item.width : 0, (3145727 & 128) != 0 ? item.height : 0, (3145727 & 256) != 0 ? item.title : title, (3145727 & 512) != 0 ? item.order : null, (3145727 & 1024) != 0 ? item.widget : false, (3145727 & 2048) != 0 ? item.address : null, (3145727 & 4096) != 0 ? item.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? item.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? item.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? item.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? item.extraKeyReader : null, (3145727 & 131072) != 0 ? item.mainScreen : false, (3145727 & 262144) != 0 ? item.subscriptionRequried : null, (3145727 & 524288) != 0 ? item.canOpen : null, (3145727 & 1048576) != 0 ? item.isLive : false, (3145727 & 2097152) != 0 ? item.isSelected : false)));
            getManageCamerasAdapter().submitList(arrayList, new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ManageCamerasFragment.updateCameraTitle$lambda$2$lambda$1(this.f$0, iIndexOf);
                }
            });
        }
        ArrayList arrayList2 = new ArrayList(getManageCamerasInWidgetAdapter().getCurrentList());
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            ManageCamerasItem manageCamerasItem3 = (ManageCamerasItem) next2;
            if ((manageCamerasItem3 instanceof ManageCamerasItem.ManageCamera) && Intrinsics.areEqual(((ManageCamerasItem.ManageCamera) manageCamerasItem3).getItem().getUuid(), currentState.getCameraUuid())) {
                obj = next2;
                break;
            }
        }
        ManageCamerasItem manageCamerasItem4 = (ManageCamerasItem) obj;
        if (manageCamerasItem4 != null) {
            final int iIndexOf2 = arrayList2.indexOf(manageCamerasItem4);
            ManageCamerasItem.ManageCamera manageCamera2 = (ManageCamerasItem.ManageCamera) manageCamerasItem4;
            Camera item2 = manageCamera2.getItem();
            String title2 = currentState.getCurCameraObject().getTitle();
            Intrinsics.checkNotNull(title2);
            arrayList2.set(iIndexOf2, manageCamera2.copy(item2.copy((3145727 & 1) != 0 ? item2.uuid : null, (3145727 & 2) != 0 ? item2.streamUrl : null, (3145727 & 4) != 0 ? item2.previewUrl : null, (3145727 & 8) != 0 ? item2.isIntercom : false, (3145727 & 16) != 0 ? item2.intercomUuid : null, (3145727 & 32) != 0 ? item2.intercomSerial : null, (3145727 & 64) != 0 ? item2.width : 0, (3145727 & 128) != 0 ? item2.height : 0, (3145727 & 256) != 0 ? item2.title : title2, (3145727 & 512) != 0 ? item2.order : null, (3145727 & 1024) != 0 ? item2.widget : false, (3145727 & 2048) != 0 ? item2.address : null, (3145727 & 4096) != 0 ? item2.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? item2.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? item2.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? item2.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? item2.extraKeyReader : null, (3145727 & 131072) != 0 ? item2.mainScreen : false, (3145727 & 262144) != 0 ? item2.subscriptionRequried : null, (3145727 & 524288) != 0 ? item2.canOpen : null, (3145727 & 1048576) != 0 ? item2.isLive : false, (3145727 & 2097152) != 0 ? item2.isSelected : false)));
            getManageCamerasInWidgetAdapter().submitList(arrayList2, new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    ManageCamerasFragment.updateCameraTitle$lambda$5$lambda$4(this.f$0, iIndexOf2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCameraTitle$lambda$2$lambda$1(ManageCamerasFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getManageCamerasAdapter().notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCameraTitle$lambda$5$lambda$4(ManageCamerasFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getManageCamerasInWidgetAdapter().notifyItemChanged(i);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentManageCamerasBinding binding = getBinding();
        binding.btnSettings.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageCamerasFragment.initViews$lambda$11$lambda$6(this.f$0, view);
            }
        });
        Button btnCamerasInWidget = binding.btnCamerasInWidget;
        Intrinsics.checkNotNullExpressionValue(btnCamerasInWidget, "btnCamerasInWidget");
        SafeClickListenerKt.setSafeOnClickListener(btnCamerasInWidget, 500L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$initViews$1$2
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
                this.this$0.openCamerasInWidgetTab();
            }
        });
        Button btnCameras = binding.btnCameras;
        Intrinsics.checkNotNullExpressionValue(btnCameras, "btnCameras");
        SafeClickListenerKt.setSafeOnClickListener(btnCameras, 500L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$initViews$1$3
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
                this.this$0.openCamerasTab();
            }
        });
        RecyclerView recyclerView = binding.rvCameras;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(getManageCamerasAdapter());
        postponeEnterTransition();
        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return ManageCamerasFragment.initViews$lambda$11$lambda$8$lambda$7(this.f$0);
            }
        });
        RecyclerView recyclerView2 = binding.rvCamerasInWidget;
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView2.setAdapter(getManageCamerasInWidgetAdapter());
        postponeEnterTransition();
        recyclerView2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return ManageCamerasFragment.initViews$lambda$11$lambda$10$lambda$9(this.f$0);
            }
        });
        getItemTouchHelper().attachToRecyclerView(binding.rvCameras);
        getItemTouchWidgetHelper().attachToRecyclerView(binding.rvCamerasInWidget);
        AppCompatButton btnSave = binding.btnSave;
        Intrinsics.checkNotNullExpressionValue(btnSave, "btnSave");
        SafeClickListenerKt.setSafeOnClickListener$default(btnSave, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.ManageCamerasFragment$initViews$1$6
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
                ManageCamerasViewModel manageCamerasViewModel = this.this$0.getManageCamerasViewModel();
                List<ManageCamerasItem> currentList = this.this$0.getManageCamerasAdapter().getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                manageCamerasViewModel.handleSaveNewOrder(currentList);
            }
        }, 1, null);
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        NestedScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11$lambda$6(ManageCamerasFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_manageCamerasFragment_to_clearCameraPreferencesDialog, null, null, 6, null);
        this$0.getManageCamerasViewModel().handleSaveNewOrder(CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$11$lambda$8$lambda$7(ManageCamerasFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPostponedEnterTransition();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$11$lambda$10$lambda$9(ManageCamerasFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPostponedEnterTransition();
        return true;
    }

    /* compiled from: ManageCamerasFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0011R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/ManageCamerasFragment$Move;", "", "", RemoteMessageConst.FROM, RemoteMessageConst.TO, "", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "originalList", "newList", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;", "canMove", "<init>", "(IILjava/util/List;Ljava/util/List;Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFrom", "getTo", "Ljava/util/List;", "getOriginalList", "()Ljava/util/List;", "getNewList", "setNewList", "(Ljava/util/List;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;", "getCanMove", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;", "setCanMove", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasAdapter$MoveRestrictions;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Move {
        private ManageCamerasAdapter.MoveRestrictions canMove;
        private final int from;
        private List<? extends ManageCamerasItem> newList;
        private final List<ManageCamerasItem> originalList;
        private final int to;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Move)) {
                return false;
            }
            Move move = (Move) other;
            return this.from == move.from && this.to == move.to && Intrinsics.areEqual(this.originalList, move.originalList) && Intrinsics.areEqual(this.newList, move.newList) && this.canMove == move.canMove;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.from) * 31) + Integer.hashCode(this.to)) * 31) + this.originalList.hashCode()) * 31) + this.newList.hashCode()) * 31) + this.canMove.hashCode();
        }

        public String toString() {
            return "Move(from=" + this.from + ", to=" + this.to + ", originalList=" + this.originalList + ", newList=" + this.newList + ", canMove=" + this.canMove + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Move(int i, int i2, List<? extends ManageCamerasItem> originalList, List<? extends ManageCamerasItem> newList, ManageCamerasAdapter.MoveRestrictions canMove) {
            Intrinsics.checkNotNullParameter(originalList, "originalList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            Intrinsics.checkNotNullParameter(canMove, "canMove");
            this.from = i;
            this.to = i2;
            this.originalList = originalList;
            this.newList = newList;
            this.canMove = canMove;
        }

        public final int getFrom() {
            return this.from;
        }

        public final int getTo() {
            return this.to;
        }

        public /* synthetic */ Move(int i, int i2, List list, List list2, ManageCamerasAdapter.MoveRestrictions moveRestrictions, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 16) != 0 ? ManageCamerasAdapter.MoveRestrictions.NONE : moveRestrictions);
        }

        public final List<ManageCamerasItem> getOriginalList() {
            return this.originalList;
        }

        public final List<ManageCamerasItem> getNewList() {
            return this.newList;
        }

        public final void setNewList(List<? extends ManageCamerasItem> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.newList = list;
        }

        public final ManageCamerasAdapter.MoveRestrictions getCanMove() {
            return this.canMove;
        }
    }

    public final ItemTouchHelper.SimpleCallback getSimpleItemTouchCallback() {
        return this.simpleItemTouchCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackMoveAnalytics(Move move, ManageCamerasAdapter.ManageCamerasAdapterTypes adapterType) {
        AnalyticsTracker.Event stateDelCameraFromWidgetScreen;
        AnalyticsTracker.Event stateAddCameraOnWidgetScreen;
        if (adapterType != null && move.getCanMove() == ManageCamerasAdapter.MoveRestrictions.NONE) {
            Iterable iterableWithIndex = CollectionsKt.withIndex(move.getNewList());
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterableWithIndex) {
                if (((IndexedValue) obj).getValue() instanceof ManageCamerasItem.ManageTitle) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(((IndexedValue) it.next()).getIndex()));
            }
            if (arrayList2.size() < 2) {
                return;
            }
            if (move.getTo() < ((Number) arrayList2.get(1)).intValue()) {
                Analytics analytics = getAnalytics();
                ManageCamerasAdapter.ManageCamerasAdapterTypes manageCamerasAdapterTypes = ManageCamerasAdapter.ManageCamerasAdapterTypes.MAIN_CAMERAS;
                if (adapterType == manageCamerasAdapterTypes) {
                    stateAddCameraOnWidgetScreen = new CamerasEvents.StateAddCameraOnHomeScreen();
                } else {
                    stateAddCameraOnWidgetScreen = new CamerasEvents.StateAddCameraOnWidgetScreen();
                }
                analytics.trackLogEvent(stateAddCameraOnWidgetScreen);
                LogUtilsKt.writeLog("GGGG: MOVED TO FIRST SECTION " + (adapterType == manageCamerasAdapterTypes ? "main" : "widget"));
                return;
            }
            Analytics analytics2 = getAnalytics();
            ManageCamerasAdapter.ManageCamerasAdapterTypes manageCamerasAdapterTypes2 = ManageCamerasAdapter.ManageCamerasAdapterTypes.MAIN_CAMERAS;
            if (adapterType == manageCamerasAdapterTypes2) {
                stateDelCameraFromWidgetScreen = new CamerasEvents.StateDelCameraFromHomeScreen();
            } else {
                stateDelCameraFromWidgetScreen = new CamerasEvents.StateDelCameraFromWidgetScreen();
            }
            analytics2.trackLogEvent(stateDelCameraFromWidgetScreen);
            LogUtilsKt.writeLog("GGGG: MOVED TO SECOND SECTION " + (adapterType == manageCamerasAdapterTypes2 ? "main" : "widget"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemTouchHelper getItemTouchHelper() {
        return (ItemTouchHelper) this.itemTouchHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemTouchHelper getItemTouchWidgetHelper() {
        return (ItemTouchHelper) this.itemTouchWidgetHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCamerasTab() {
        String titleMainScreen;
        ManageCamerasLocale manageCameras;
        ManageCamerasBody body;
        ManageCamerasBottomView bottomView;
        FragmentManageCamerasBinding binding = getBinding();
        TextView textView = binding.textView3;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (manageCameras = data.getManageCameras()) == null || (body = manageCameras.getBody()) == null || (bottomView = body.getBottomView()) == null || (titleMainScreen = bottomView.getTitleMainScreen()) == null) {
            titleMainScreen = "";
        }
        textView.setText(titleMainScreen);
        Button btnCamerasInWidget = binding.btnCamerasInWidget;
        Intrinsics.checkNotNullExpressionValue(btnCamerasInWidget, "btnCamerasInWidget");
        ViewKt.disactivate(btnCamerasInWidget);
        Button btnCameras = binding.btnCameras;
        Intrinsics.checkNotNullExpressionValue(btnCameras, "btnCameras");
        ViewKt.activate(btnCameras);
        RecyclerView rvCameras = binding.rvCameras;
        Intrinsics.checkNotNullExpressionValue(rvCameras, "rvCameras");
        ViewKt.visible(rvCameras);
        RecyclerView rvCamerasInWidget = binding.rvCamerasInWidget;
        Intrinsics.checkNotNullExpressionValue(rvCamerasInWidget, "rvCamerasInWidget");
        ViewKt.gone(rvCamerasInWidget);
        getManageCamerasViewModel().setWidgetTabSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCamerasInWidgetTab() {
        String titleWidget;
        ManageCamerasLocale manageCameras;
        ManageCamerasBody body;
        ManageCamerasBottomView bottomView;
        FragmentManageCamerasBinding binding = getBinding();
        TextView textView = binding.textView3;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (manageCameras = data.getManageCameras()) == null || (body = manageCameras.getBody()) == null || (bottomView = body.getBottomView()) == null || (titleWidget = bottomView.getTitleWidget()) == null) {
            titleWidget = "";
        }
        textView.setText(titleWidget);
        Button btnCamerasInWidget = binding.btnCamerasInWidget;
        Intrinsics.checkNotNullExpressionValue(btnCamerasInWidget, "btnCamerasInWidget");
        ViewKt.activate(btnCamerasInWidget);
        Button btnCameras = binding.btnCameras;
        Intrinsics.checkNotNullExpressionValue(btnCameras, "btnCameras");
        ViewKt.disactivate(btnCameras);
        RecyclerView rvCamerasInWidget = binding.rvCamerasInWidget;
        Intrinsics.checkNotNullExpressionValue(rvCamerasInWidget, "rvCamerasInWidget");
        ViewKt.visible(rvCamerasInWidget);
        RecyclerView rvCameras = binding.rvCameras;
        Intrinsics.checkNotNullExpressionValue(rvCameras, "rvCameras");
        ViewKt.gone(rvCameras);
        getManageCamerasViewModel().setWidgetTabSelected(true);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String str;
        String str2;
        ManageCamerasLocale manageCameras;
        ManageCamerasBody body;
        ManageCamerasBottomView bottomView;
        TextTitle saveButton;
        ManageCamerasLocale manageCameras2;
        ManageCamerasBody body2;
        ManageCamerasBottomView bottomView2;
        String titleMainScreen;
        ManageCamerasLocale manageCameras3;
        TextTitle navigation;
        ManageCamerasLocale manageCameras4;
        ManageCamerasBody body3;
        List<String> tabs;
        ManageCamerasLocale manageCameras5;
        ManageCamerasBody body4;
        List<String> tabs2;
        FragmentManageCamerasBinding binding = getBinding();
        Button button = binding.btnCameras;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String str3 = "";
        if (data == null || (manageCameras5 = data.getManageCameras()) == null || (body4 = manageCameras5.getBody()) == null || (tabs2 = body4.getTabs()) == null || (str = (String) CollectionsKt.getOrNull(tabs2, 0)) == null) {
            str = "";
        }
        button.setText(str);
        Button button2 = binding.btnCamerasInWidget;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 == null || (manageCameras4 = data2.getManageCameras()) == null || (body3 = manageCameras4.getBody()) == null || (tabs = body3.getTabs()) == null || (str2 = (String) CollectionsKt.getOrNull(tabs, 1)) == null) {
            str2 = "";
        }
        button2.setText(str2);
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        String title = null;
        toolbar.setTitle((data3 == null || (manageCameras3 = data3.getManageCameras()) == null || (navigation = manageCameras3.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView = binding.textView3;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (manageCameras2 = data4.getManageCameras()) != null && (body2 = manageCameras2.getBody()) != null && (bottomView2 = body2.getBottomView()) != null && (titleMainScreen = bottomView2.getTitleMainScreen()) != null) {
            str3 = titleMainScreen;
        }
        textView.setText(str3);
        AppCompatButton appCompatButton = binding.btnSave;
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        if (data5 != null && (manageCameras = data5.getManageCameras()) != null && (body = manageCameras.getBody()) != null && (bottomView = body.getBottomView()) != null && (saveButton = bottomView.getSaveButton()) != null) {
            title = saveButton.getTitle();
        }
        appCompatButton.setText(title);
    }
}
