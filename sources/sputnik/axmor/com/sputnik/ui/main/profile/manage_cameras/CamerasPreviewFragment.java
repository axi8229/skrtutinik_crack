package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.CamerasEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.CameraGalleryLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ManageCamerasLocale;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentCamerasPreviewBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.cameras.GlobalCamerasFragment;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.CamerasPreviewAdapter;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewState;

/* compiled from: CamerasPreviewFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010B\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010B\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/CamerasPreviewFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "Lcom/sputnik/common/entities/camera/Camera;", "cameras", "", "initCameras", "(Ljava/util/List;)V", "updateCameraTitle", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentCamerasPreviewBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentCamerasPreviewBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "manageCameraViewModelFactory", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "getManageCameraViewModelFactory", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "setManageCameraViewModelFactory", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel$delegate", "Lkotlin/Lazy;", "getManageCamerasViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter;", "manageCamerasAdapter$delegate", "getManageCamerasAdapter", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/CamerasPreviewAdapter;", "manageCamerasAdapter", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CamerasPreviewFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CamerasPreviewFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentCamerasPreviewBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;
    public ManageCamerasViewModel.Factory.AssistFactory manageCameraViewModelFactory;

    /* renamed from: manageCamerasAdapter$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasAdapter;

    /* renamed from: manageCamerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentCamerasPreviewBinding getBinding() {
        return (FragmentCamerasPreviewBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final ManageCamerasViewModel getManageCamerasViewModel() {
        return (ManageCamerasViewModel) this.manageCamerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final CamerasPreviewAdapter getManageCamerasAdapter() {
        return (CamerasPreviewAdapter) this.manageCamerasAdapter.getValue();
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
        getCamerasViewModel().loadAllCameras();
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.1
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
                LinearLayout layoutLoader = CamerasPreviewFragment.this.getBinding().layoutLoader;
                Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
                ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(it.getAllCamerasState() == Resource.Status.LOADING));
                if (it.getAllCamerasState() == Resource.Status.SUCCESS) {
                    CamerasPreviewFragment.this.initCameras(it.getAllCameras());
                }
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner2, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.2
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
        ManageCamerasViewModel manageCamerasViewModel = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        manageCamerasViewModel.observeSubState(viewLifecycleOwner3, new Function1<ManageCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedOrder();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.4
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
                    CamerasPreviewFragment camerasPreviewFragment = CamerasPreviewFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        camerasPreviewFragment.getCamerasViewModel().handleNeedUpdate(true);
                    }
                }
            }
        });
        ManageCamerasViewModel manageCamerasViewModel2 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        manageCamerasViewModel2.observeSubState(viewLifecycleOwner4, new Function1<ManageCamerasViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedTitle();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.6
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
                    CamerasPreviewFragment camerasPreviewFragment = CamerasPreviewFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        camerasPreviewFragment.getCamerasViewModel().handleNeedUpdate(true);
                        camerasPreviewFragment.updateCameraTitle();
                    }
                }
            }
        });
        ManageCamerasViewModel manageCamerasViewModel3 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        manageCamerasViewModel3.observeNotifications(viewLifecycleOwner5, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment.onViewCreated.7
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
                CamerasPreviewFragment camerasPreviewFragment = CamerasPreviewFragment.this;
                ConstraintLayout root = camerasPreviewFragment.getBinding().root;
                Intrinsics.checkNotNullExpressionValue(root, "root");
                ViewKt.renderNotifications(camerasPreviewFragment, root, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initCameras(List<Camera> cameras) {
        if (getManageCamerasAdapter().getCurrentList().size() != cameras.size() + 2) {
            ArrayList arrayList = new ArrayList();
            List<Camera> listSortedWith = CollectionsKt.sortedWith(cameras, new Comparator() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$initCameras$lambda$2$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
                }
            });
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
            for (Camera camera : listSortedWith) {
                Profile profile = getProfileViewModel().getCurrentState().getProfile();
                arrayList2.add(new ManageCamerasItem.ManageCamera(camera.copy((3145727 & 1) != 0 ? camera.uuid : null, (3145727 & 2) != 0 ? camera.streamUrl : null, (3145727 & 4) != 0 ? camera.previewUrl : null, (3145727 & 8) != 0 ? camera.isIntercom : false, (3145727 & 16) != 0 ? camera.intercomUuid : null, (3145727 & 32) != 0 ? camera.intercomSerial : null, (3145727 & 64) != 0 ? camera.width : 0, (3145727 & 128) != 0 ? camera.height : 0, (3145727 & 256) != 0 ? camera.title : null, (3145727 & 512) != 0 ? camera.order : null, (3145727 & 1024) != 0 ? camera.widget : false, (3145727 & 2048) != 0 ? camera.address : profile != null ? profile.getAddress() : null, (3145727 & 4096) != 0 ? camera.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? camera.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? camera.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? camera.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? camera.extraKeyReader : null, (3145727 & 131072) != 0 ? camera.mainScreen : false, (3145727 & 262144) != 0 ? camera.subscriptionRequried : null, (3145727 & 524288) != 0 ? camera.canOpen : null, (3145727 & 1048576) != 0 ? camera.isLive : false, (3145727 & 2097152) != 0 ? camera.isSelected : false)));
            }
            arrayList.addAll(arrayList2);
            RecyclerView.Adapter adapter = getBinding().rvCameras.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.CamerasPreviewAdapter");
            ((CamerasPreviewAdapter) adapter).submitList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCameraTitle() {
        Object next;
        ArrayList arrayList = new ArrayList(getManageCamerasAdapter().getCurrentList());
        ManageCamerasViewState currentState = getManageCamerasViewModel().getCurrentState();
        Iterator it = arrayList.iterator();
        while (true) {
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
            int iIndexOf = arrayList.indexOf(manageCamerasItem2);
            ManageCamerasItem.ManageCamera manageCamera = (ManageCamerasItem.ManageCamera) manageCamerasItem2;
            Camera item = manageCamera.getItem();
            String title = currentState.getCurCameraObject().getTitle();
            Intrinsics.checkNotNull(title);
            arrayList.set(iIndexOf, manageCamera.copy(item.copy((3145727 & 1) != 0 ? item.uuid : null, (3145727 & 2) != 0 ? item.streamUrl : null, (3145727 & 4) != 0 ? item.previewUrl : null, (3145727 & 8) != 0 ? item.isIntercom : false, (3145727 & 16) != 0 ? item.intercomUuid : null, (3145727 & 32) != 0 ? item.intercomSerial : null, (3145727 & 64) != 0 ? item.width : 0, (3145727 & 128) != 0 ? item.height : 0, (3145727 & 256) != 0 ? item.title : title, (3145727 & 512) != 0 ? item.order : null, (3145727 & 1024) != 0 ? item.widget : false, (3145727 & 2048) != 0 ? item.address : null, (3145727 & 4096) != 0 ? item.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? item.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? item.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? item.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? item.extraKeyReader : null, (3145727 & 131072) != 0 ? item.mainScreen : false, (3145727 & 262144) != 0 ? item.subscriptionRequried : null, (3145727 & 524288) != 0 ? item.canOpen : null, (3145727 & 1048576) != 0 ? item.isLive : false, (3145727 & 2097152) != 0 ? item.isSelected : false)));
            getManageCamerasAdapter().submitList(arrayList);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentCamerasPreviewBinding binding = getBinding();
        RecyclerView recyclerView = binding.rvCameras;
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(getManageCamerasAdapter());
        }
        postponeEnterTransition();
        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return CamerasPreviewFragment.initViews$lambda$7$lambda$6$lambda$5(this.f$0);
            }
        });
        ImageButton btnSettings = binding.btnSettings;
        Intrinsics.checkNotNullExpressionValue(btnSettings, "btnSettings");
        SafeClickListenerKt.setSafeOnClickListener$default(btnSettings, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$initViews$1$2
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
                this.this$0.getAnalytics().trackLogEvent(new CamerasEvents.ClickCamerasSettings());
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_global_to_manage_cameras_navigation, BundleKt.bundleOf(TuplesKt.to("cameras", this.this$0.getCamerasViewModel().getCurrentCameras())), null, 4, null);
            }
        }, 1, null);
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        NestedScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }

    public CamerasPreviewFragment() {
        super(R.layout.fragment_cameras_preview);
        this.binding = new ViewBindingFragmentDelegate(this, CamerasPreviewFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.manageCamerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ManageCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$manageCamerasViewModel$2
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
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$camerasViewModel$2
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
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$special$$inlined$activityViewModels$default$9
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.manageCamerasAdapter = LazyKt.lazy(new Function0<CamerasPreviewAdapter>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$manageCamerasAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CamerasPreviewAdapter invoke() {
                final CamerasPreviewFragment camerasPreviewFragment = this.this$0;
                return new CamerasPreviewAdapter(new Function2<View, Camera, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$manageCamerasAdapter$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Camera camera) throws InterruptedException {
                        invoke2(view, camera);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, Camera camera) throws InterruptedException {
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(camera, "camera");
                        BundleKt.bundleOf(TuplesKt.to("camera", camera));
                        BuildersKt__BuildersKt.runBlocking$default(null, new C03691(camera, camerasPreviewFragment, null), 1, null);
                    }

                    /* compiled from: CamerasPreviewFragment.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$manageCamerasAdapter$2$1$1", f = "CamerasPreviewFragment.kt", l = {}, m = "invokeSuspend")
                    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.CamerasPreviewFragment$manageCamerasAdapter$2$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C03691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Camera $camera;
                        int label;
                        final /* synthetic */ CamerasPreviewFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C03691(Camera camera, CamerasPreviewFragment camerasPreviewFragment, Continuation<? super C03691> continuation) {
                            super(2, continuation);
                            this.$camera = camera;
                            this.this$0 = camerasPreviewFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C03691(this.$camera, this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C03691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            if (this.$camera.getMainScreen()) {
                                if (Intrinsics.areEqual(this.$camera.getSubscriptionRequried(), Boxing.boxBoolean(true))) {
                                    this.this$0.getAnalytics().trackLogEvent(this.$camera.getIsIntercom() ? new CamerasEvents.ShowHomeBlockedIntercomCamera() : new CamerasEvents.ShowHomeBlockedCamera());
                                } else {
                                    this.this$0.getAnalytics().trackLogEvent(this.$camera.getIsIntercom() ? new CamerasEvents.ShowHomeIntercomCamera() : new CamerasEvents.ShowHomeCamera());
                                }
                                GlobalCamerasFragment.INSTANCE.setCameraToSelect(this.$camera);
                                FragmentKt.findNavController(this.this$0).popBackStack();
                            } else {
                                if (Intrinsics.areEqual(this.$camera.getSubscriptionRequried(), Boxing.boxBoolean(true))) {
                                    this.this$0.getAnalytics().trackLogEvent(this.$camera.getIsIntercom() ? new CamerasEvents.ShowFrameBlockedIntercomCamera() : new CamerasEvents.ShowFrameBlockedCamera());
                                } else {
                                    this.this$0.getAnalytics().trackLogEvent(this.$camera.getIsIntercom() ? new CamerasEvents.ShowFrameIntercomCamera() : new CamerasEvents.ShowFrameCamera());
                                }
                                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_global_to_camera_stream, BundleKt.bundleOf(TuplesKt.to("ui.main.cameras.camera", this.$camera)), null, 4, null);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$7$lambda$6$lambda$5(CamerasPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPostponedEnterTransition();
        return true;
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String title;
        CameraGalleryLocale cameraGallery;
        TextTitle navigation;
        FragmentCamerasPreviewBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (cameraGallery = data.getCameraGallery()) == null || (navigation = cameraGallery.getNavigation()) == null || (title = navigation.getTitle()) == null) {
            title = "";
        }
        toolbar.setTitle(title);
        TextView textView = binding.textView3;
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        textView.setText(profile != null ? profile.getAddressWithApartment() : null);
    }
}
