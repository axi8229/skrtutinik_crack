package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.localization.FlussonicCameraPicker;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.AllCamerasViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.archive.DomainArchiveItem;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.SelectCamerasBottomSheetBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.adapter.BottomSheetCamerasAdapter;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewModel;
import sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewState;

/* compiled from: SelectArchiveBottomSheet.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0003R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\bE\u0010FR\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020I0H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020L8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/SelectArchiveBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewState;", RemoteMessageConst.DATA, "", "renderArchive", "(Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewState;)V", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "Lkotlin/Lazy;", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "archiveViewModel$delegate", "getArchiveViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "archiveViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "", "", "webUrlByCamera", "Ljava/util/Map;", "Lsputnik/axmor/com/databinding/SelectCamerasBottomSheetBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/SelectCamerasBottomSheetBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectArchiveBottomSheet extends BottomSheetDialogFragment {
    private ViewBinding _binding;

    /* renamed from: archiveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy archiveViewModel;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private Map<String, String> webUrlByCamera;

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectCamerasBottomSheetBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.SelectCamerasBottomSheetBinding");
        return (SelectCamerasBottomSheetBinding) viewBinding;
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

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasFactory");
        return null;
    }

    private final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveViewModel getArchiveViewModel() {
        return (ArchiveViewModel) this.archiveViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SelectCamerasBottomSheetBinding.inflate(getLayoutInflater(), container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet.onViewCreated.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) this.getDialog();
                FrameLayout frameLayout = bottomSheetDialog != null ? (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet) : null;
                Intrinsics.checkNotNull(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
                BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
                bottomSheetBehaviorFrom.setState(3);
                bottomSheetBehaviorFrom.setPeekHeight(0);
                final SelectArchiveBottomSheet selectArchiveBottomSheet = this;
                bottomSheetBehaviorFrom.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$onViewCreated$1$onGlobalLayout$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onSlide(View bottomSheet, float slideOffset) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onStateChanged(View bottomSheet, int newState) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        if (newState == 4) {
                            selectArchiveBottomSheet.dismiss();
                        }
                    }
                });
            }
        });
        if (getCamerasViewModel().getCurrentState().getAllCamerasState() == Resource.Status.NONE || getCamerasViewModel().getCurrentState().getAllCamerasState() == Resource.Status.ERROR || getCamerasViewModel().getCurrentState().getNeedReloadAllCameras()) {
            getCamerasViewModel().loadAllCameras();
        }
        AllCamerasViewModel camerasViewModel = getCamerasViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        camerasViewModel.observeState(viewLifecycleOwner, new Function1<AllCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet.onViewCreated.2
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
                if (it.getAllCamerasState() == Resource.Status.SUCCESS) {
                    SelectArchiveBottomSheet.this.getArchiveViewModel().loadArchiveLinks();
                }
            }
        });
        ArchiveViewModel archiveViewModel = getArchiveViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        archiveViewModel.observeState(viewLifecycleOwner2, new AnonymousClass3(this));
        ArchiveViewModel archiveViewModel2 = getArchiveViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        archiveViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet.onViewCreated.4
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
                SelectArchiveBottomSheet selectArchiveBottomSheet = SelectArchiveBottomSheet.this;
                LinearLayout root = selectArchiveBottomSheet.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(selectArchiveBottomSheet, root, it);
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner4, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet.onViewCreated.5
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
        initView();
    }

    /* compiled from: SelectArchiveBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$onViewCreated$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ArchiveViewState, Unit> {
        AnonymousClass3(Object obj) {
            super(1, obj, SelectArchiveBottomSheet.class, "renderArchive", "renderArchive(Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ArchiveViewState archiveViewState) throws Resources.NotFoundException {
            invoke2(archiveViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ArchiveViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SelectArchiveBottomSheet) this.receiver).renderArchive(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderArchive(ArchiveViewState data) throws Resources.NotFoundException {
        List listEmptyList;
        Object next;
        LinearLayout serviceLoader = getBinding().serviceLoader;
        Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
        Resource.Status serverState = data.getServerState();
        Resource.Status status = Resource.Status.SUCCESS;
        ViewBindingUtilsKt.visibilityBasedOn(serviceLoader, Boolean.valueOf(serverState != status));
        RecyclerView rvCamerasBottomSheet = getBinding().rvCamerasBottomSheet;
        Intrinsics.checkNotNullExpressionValue(rvCamerasBottomSheet, "rvCamerasBottomSheet");
        ViewBindingUtilsKt.visibilityBasedOn(rvCamerasBottomSheet, Boolean.valueOf(data.getServerState() == status));
        if (data.getServerState() != status) {
            if (data.getServerState() == Resource.Status.ERROR) {
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R.id.bottomArchiveFragment, R.id.action_archiveServiceFragment_to_archiveErrorDialog, null, null, 12, null);
                return;
            }
            return;
        }
        List<Camera> allCameras = getCamerasViewModel().getCurrentState().getAllCameras();
        DomainArchiveUrls archive = data.getArchive();
        String way = archive != null ? archive.getWay() : null;
        if (Intrinsics.areEqual(way, "sdk")) {
            List<DomainArchiveItem> data2 = data.getArchive().getData();
            listEmptyList = new ArrayList();
            for (DomainArchiveItem domainArchiveItem : data2) {
                Flussonic flussonic2 = new Flussonic(domainArchiveItem.getDomain(), domainArchiveItem.getSdkUrl(), domainArchiveItem.getCameraUUID(), domainArchiveItem.getArchiveToken(), null);
                Iterator<T> it = allCameras.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (Intrinsics.areEqual(((Camera) next).getUuid(), domainArchiveItem.getCameraUUID())) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                Camera camera = (Camera) next;
                if (camera != null) {
                    camera.setFlussonicData(flussonic2);
                    UserAddress currentAddress = getProfileViewModel().getCurrentAddress();
                    String fullAddress = currentAddress != null ? currentAddress.getFullAddress() : null;
                    if (fullAddress == null) {
                        fullAddress = "";
                    }
                    camera.setAddress(fullAddress);
                } else {
                    camera = null;
                }
                if (camera != null) {
                    listEmptyList.add(camera);
                }
            }
        } else if (Intrinsics.areEqual(way, "web")) {
            List<DomainArchiveItem> data3 = data.getArchive().getData();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(data3, 10)), 16));
            for (DomainArchiveItem domainArchiveItem2 : data3) {
                linkedHashMap.put(domainArchiveItem2.getCameraUUID(), domainArchiveItem2.getPlayerUrl());
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((String) entry.getKey()) != null) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key);
                linkedHashMap3.put((String) key, entry2.getValue());
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                String str = (String) entry3.getValue();
                if (!(str == null || str.length() == 0)) {
                    linkedHashMap4.put(entry3.getKey(), entry3.getValue());
                }
            }
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap4.size()));
            for (Map.Entry entry4 : linkedHashMap4.entrySet()) {
                Object key2 = entry4.getKey();
                Object value = entry4.getValue();
                Intrinsics.checkNotNull(value);
                linkedHashMap5.put(key2, (String) value);
            }
            this.webUrlByCamera = linkedHashMap5;
            ArrayList arrayList = new ArrayList();
            for (Camera camera2 : allCameras) {
                String str2 = (String) linkedHashMap5.get(camera2.getUuid());
                if (str2 == null || str2.length() == 0) {
                    camera2 = null;
                } else {
                    UserAddress currentAddress2 = getProfileViewModel().getCurrentAddress();
                    String fullAddress2 = currentAddress2 != null ? currentAddress2.getFullAddress() : null;
                    if (fullAddress2 == null) {
                        fullAddress2 = "";
                    }
                    camera2.setAddress(fullAddress2);
                }
                if (camera2 != null) {
                    arrayList.add(camera2);
                }
            }
            listEmptyList = arrayList;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.isEmpty()) {
            getArchiveViewModel().handleStatus(Resource.Status.ERROR);
            return;
        }
        RecyclerView.Adapter adapter = getBinding().rvCamerasBottomSheet.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.adapter.BottomSheetCamerasAdapter");
        ((BottomSheetCamerasAdapter) adapter).submitList(listEmptyList);
    }

    private final void initView() {
        RecyclerView recyclerView = getBinding().rvCamerasBottomSheet;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new BottomSheetCamerasAdapter(new Function1<Camera, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$initView$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Camera camera) throws Resources.NotFoundException {
                invoke2(camera);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Camera it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = (String) this.this$0.webUrlByCamera.get(it.getUuid());
                if (str != null && str.length() != 0) {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.action_global_to_archiveWebViewFragment, BundleKt.bundleOf(TuplesKt.to("url", str), TuplesKt.to(AppMeasurementSdk.ConditionalUserProperty.NAME, "archive")), null, 4, null);
                } else {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R.id.bottomArchiveFragment, R.id.action_bottomArchiveFragment_to_flussonicFragment, BundleKt.bundleOf(TuplesKt.to("camera", it)), null, 8, null);
                }
            }
        }));
    }

    public SelectArchiveBottomSheet() {
        final Function0 function0 = null;
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$camerasViewModel$2
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
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$archiveViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.archiveViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ArchiveViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$viewModels$default$4
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
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.SelectArchiveBottomSheet$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.webUrlByCamera = MapsKt.emptyMap();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentKt.findNavController(this).navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this._binding = null;
        super.onDestroy();
    }

    private final void localize() {
        FlussonicCameraPicker flussonicCameraPicker;
        TextTitle body;
        TextView textView = getBinding().title;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText((data == null || (flussonicCameraPicker = data.getFlussonicCameraPicker()) == null || (body = flussonicCameraPicker.getBody()) == null) ? null : body.getTitle());
    }
}
