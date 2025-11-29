package sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GeneralEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.localization.DomofonSettingsBody;
import com.sputnik.common.entities.localization.DomofonSettingsLocale;
import com.sputnik.common.entities.localization.DomofonSwitch;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ManageCamerasLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.RadioOptionView;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.experimental.ExperimentalFunctions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentDomofonBinding;
import sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewState;
import sputnik.axmor.com.sputnik.utils.FaqNavigationUtils;

/* compiled from: IntercomSettingsFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/intercom_settings/IntercomSettingsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/ProfileViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "setAllRadioOptionsDisabledWhenNoSubscription", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentDomofonBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentDomofonBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "manageCameraViewModelFactory", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "getManageCameraViewModelFactory", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "setManageCameraViewModelFactory", "(Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel$delegate", "getManageCamerasViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "manageCamerasViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "", "Lcom/sputnik/common/ui/view/RadioOptionView;", "radioOptionViews", "Ljava/util/List;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntercomSettingsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(IntercomSettingsFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentDomofonBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;
    public ManageCamerasViewModel.Factory.AssistFactory manageCameraViewModelFactory;

    /* renamed from: manageCamerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy manageCamerasViewModel;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final List<RadioOptionView> radioOptionViews;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentDomofonBinding getBinding() {
        return (FragmentDomofonBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ManageCamerasViewModel getManageCamerasViewModel() {
        return (ManageCamerasViewModel) this.manageCamerasViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
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
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        ManageCamerasViewModel manageCamerasViewModel = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        manageCamerasViewModel.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.onViewCreated.2
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
                IntercomSettingsFragment intercomSettingsFragment = IntercomSettingsFragment.this;
                ConstraintLayout root = intercomSettingsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(intercomSettingsFragment, root, it);
            }
        });
        ManageCamerasViewModel manageCamerasViewModel2 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        manageCamerasViewModel2.observeSubState(viewLifecycleOwner3, new Function1<ManageCamerasViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ManageCamerasViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getLoadCallsState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.onViewCreated.4
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
                LinearLayout layoutLoader = IntercomSettingsFragment.this.getBinding().layoutLoader;
                Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
                ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(it == Resource.Status.LOADING));
            }
        });
        ManageCamerasViewModel manageCamerasViewModel3 = getManageCamerasViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        manageCamerasViewModel3.observeState(viewLifecycleOwner4, new Function1<ManageCamerasViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ManageCamerasViewState manageCamerasViewState) throws Resources.NotFoundException {
                invoke2(manageCamerasViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ManageCamerasViewState it) throws Resources.NotFoundException {
                Integer id;
                DomofonSettingsLocale domofonSettings;
                DomofonSettingsBody body;
                Intrinsics.checkNotNullParameter(it, "it");
                IntercomSettingsFragment.this.getBinding().layoutAddresses.removeAllViews();
                IntercomSettingsFragment.this.radioOptionViews.clear();
                int iApplyDimension = (int) TypedValue.applyDimension(1, 20.0f, IntercomSettingsFragment.this.getResources().getDisplayMetrics());
                List<CamerasOrder> callsState = it.getCallsState();
                final IntercomSettingsFragment intercomSettingsFragment = IntercomSettingsFragment.this;
                for (final CamerasOrder camerasOrder : callsState) {
                    Context contextRequireContext = intercomSettingsFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    final RadioOptionView radioOptionView = new RadioOptionView(contextRequireContext, null, 0, 6, null);
                    int iIntValue = -1;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(iApplyDimension, iApplyDimension, iApplyDimension, 0);
                    radioOptionView.setLayoutParams(layoutParams);
                    LocalizationLocalModel data = intercomSettingsFragment.getLocalizationScreen().getData();
                    String title = (data == null || (domofonSettings = data.getDomofonSettings()) == null || (body = domofonSettings.getBody()) == null) ? null : body.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    radioOptionView.setTitle(title);
                    UserAddress address = camerasOrder.getAddress();
                    String fullAddressWithApartment = address != null ? address.getFullAddressWithApartment() : null;
                    radioOptionView.setSubtitle(fullAddressWithApartment != null ? fullAddressWithApartment : "");
                    radioOptionView.setSwitch(Intrinsics.areEqual(camerasOrder.getCallEnabled(), Boolean.TRUE));
                    UserAddress address2 = camerasOrder.getAddress();
                    if (address2 != null && (id = address2.getId()) != null) {
                        iIntValue = id.intValue();
                    }
                    radioOptionView.setItemId(iIntValue);
                    radioOptionView.setSwitchListener(new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$onViewCreated$5$1$radioView$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) throws Resources.NotFoundException {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void invoke(boolean r9) throws android.content.res.Resources.NotFoundException {
                            /*
                                r8 = this;
                                sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder r0 = r1
                                com.sputnik.common.entities.addresses.UserAddress r0 = r0.getAddress()
                                if (r0 == 0) goto Lb8
                                java.lang.Integer r0 = r0.getId()
                                if (r0 == 0) goto Lb8
                                sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment r1 = r2
                                sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewState r2 = r3
                                com.sputnik.common.ui.view.RadioOptionView r3 = r4
                                int r0 = r0.intValue()
                                r4 = 0
                                if (r9 == 0) goto L91
                                com.sputnik.common.viewmodels.ProfileViewModel r5 = sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.access$getProfileViewModel(r1)
                                com.sputnik.common.base.VMState r5 = r5.getCurrentState()
                                com.sputnik.common.viewmodels.ProfileViewState r5 = (com.sputnik.common.viewmodels.ProfileViewState) r5
                                com.sputnik.common.entities.profile.Profile r5 = r5.getProfile()
                                if (r5 == 0) goto L36
                                java.lang.Boolean r5 = r5.getRichFunctionalityAvailable()
                                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
                                goto L37
                            L36:
                                r5 = r4
                            L37:
                                if (r5 != 0) goto L93
                                com.sputnik.common.viewmodels.ProfileViewModel r5 = sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.access$getProfileViewModel(r1)
                                com.sputnik.common.entities.addresses.UserAddress r5 = r5.getCurrentAddress()
                                if (r5 == 0) goto L52
                                java.lang.Integer r5 = r5.getId()
                                if (r5 != 0) goto L4a
                                goto L52
                            L4a:
                                int r5 = r5.intValue()
                                if (r5 != r0) goto L52
                                r5 = 1
                                goto L53
                            L52:
                                r5 = r4
                            L53:
                                if (r5 == 0) goto L91
                                java.util.List r2 = r2.getCallsState()
                                java.lang.Iterable r2 = (java.lang.Iterable) r2
                                boolean r5 = r2 instanceof java.util.Collection
                                if (r5 == 0) goto L6a
                                r5 = r2
                                java.util.Collection r5 = (java.util.Collection) r5
                                boolean r5 = r5.isEmpty()
                                if (r5 == 0) goto L6a
                                r5 = r4
                                goto L8f
                            L6a:
                                java.util.Iterator r2 = r2.iterator()
                                r5 = r4
                            L6f:
                                boolean r6 = r2.hasNext()
                                if (r6 == 0) goto L8f
                                java.lang.Object r6 = r2.next()
                                sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder r6 = (sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder) r6
                                java.lang.Boolean r6 = r6.getCallEnabled()
                                java.lang.Boolean r7 = java.lang.Boolean.TRUE
                                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
                                if (r6 == 0) goto L6f
                                int r5 = r5 + 1
                                if (r5 >= 0) goto L6f
                                kotlin.collections.CollectionsKt.throwCountOverflow()
                                goto L6f
                            L8f:
                                if (r5 == 0) goto L93
                            L91:
                                if (r9 != 0) goto L9b
                            L93:
                                sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel r1 = sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.access$getManageCamerasViewModel(r1)
                                r1.setCallsEnabledForAddress(r0, r9)
                                goto Lb8
                            L9b:
                                r3.setSwitch(r4)
                                com.sputnik.common.analytics.Analytics r9 = r1.getAnalytics()
                                com.sputnik.common.analytics.MultiAddressEvents$ShowBlockedAddressCallSettings r0 = new com.sputnik.common.analytics.MultiAddressEvents$ShowBlockedAddressCallSettings
                                r0.<init>()
                                r9.trackLogEvent(r0)
                                androidx.navigation.NavController r2 = androidx.navigation.fragment.FragmentKt.findNavController(r1)
                                r6 = 6
                                r7 = 0
                                r3 = 2131361985(0x7f0a00c1, float:1.8343738E38)
                                r4 = 0
                                r5 = 0
                                com.sputnik.common.extensions.NavControllerKt.safeNavigate$default(r2, r3, r4, r5, r6, r7)
                            Lb8:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$onViewCreated$5$1$radioView$1$1.invoke(boolean):void");
                        }
                    });
                    intercomSettingsFragment.getBinding().layoutAddresses.addView(radioOptionView);
                    intercomSettingsFragment.radioOptionViews.add(radioOptionView);
                }
                IntercomSettingsFragment.this.setAllRadioOptionsDisabledWhenNoSubscription();
            }
        });
        ManageCamerasViewModel manageCamerasViewModel4 = getManageCamerasViewModel();
        List<UserAddress> currentAddresses = getProfileViewModel().getCurrentState().getCurrentAddresses();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentAddresses) {
            if (((UserAddress) obj).isFullyValidated()) {
                arrayList.add(obj);
            }
        }
        manageCamerasViewModel4.getCamerasPreferences(arrayList);
    }

    /* compiled from: IntercomSettingsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ProfileViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, IntercomSettingsFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/ProfileViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) throws Resources.NotFoundException {
            invoke2(profileViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ProfileViewState p0) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((IntercomSettingsFragment) this.receiver).renderUi(p0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setAllRadioOptionsDisabledWhenNoSubscription() throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            com.sputnik.common.viewmodels.ProfileViewModel r0 = r5.getProfileViewModel()
            com.sputnik.common.base.VMState r0 = r0.getCurrentState()
            com.sputnik.common.viewmodels.ProfileViewState r0 = (com.sputnik.common.viewmodels.ProfileViewState) r0
            com.sputnik.common.entities.profile.Profile r0 = r0.getProfile()
            r1 = 0
            if (r0 == 0) goto L1c
            java.lang.Boolean r0 = r0.getRichFunctionalityAvailable()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            goto L1d
        L1c:
            r0 = r1
        L1d:
            if (r0 == 0) goto L57
            java.util.List<com.sputnik.common.ui.view.RadioOptionView> r0 = r5.radioOptionViews
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L27:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L57
            java.lang.Object r2 = r0.next()
            com.sputnik.common.ui.view.RadioOptionView r2 = (com.sputnik.common.ui.view.RadioOptionView) r2
            com.sputnik.common.viewmodels.ProfileViewModel r3 = r5.getProfileViewModel()
            com.sputnik.common.entities.addresses.UserAddress r3 = r3.getCurrentAddress()
            if (r3 == 0) goto L50
            java.lang.Integer r3 = r3.getId()
            int r4 = r2.getItemId()
            if (r3 != 0) goto L48
            goto L50
        L48:
            int r3 = r3.intValue()
            if (r3 != r4) goto L50
            r3 = 1
            goto L51
        L50:
            r3 = r1
        L51:
            if (r3 != 0) goto L27
            r2.setSwitch(r1)
            goto L27
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment.setAllRadioOptionsDisabledWhenNoSubscription():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(ProfileViewState data) throws Resources.NotFoundException {
        DomofonSettingsLocale domofonSettings;
        DomofonSettingsBody body;
        DomofonSwitch domofonSwitch;
        DomofonSettingsLocale domofonSettings2;
        DomofonSettingsBody body2;
        DomofonSwitch domofonSwitch2;
        Boolean callIsEnabled;
        Profile profile = data.getProfile();
        if (profile != null && data.getServerState() == Resource.Status.SUCCESS && profile.getCallIsEnabled() != null) {
            if (!Intrinsics.areEqual(Boolean.valueOf(getBinding().domofonCallsValueView.isChecked()), profile.getCallIsEnabled()) && (callIsEnabled = profile.getCallIsEnabled()) != null) {
                getBinding().domofonCallsValueView.setChecked(callIsEnabled.booleanValue());
            }
            TextView textView = getBinding().domofonCallsHint;
            String titleOff = null;
            if (Intrinsics.areEqual(profile.getCallIsEnabled(), Boolean.TRUE)) {
                LocalizationLocalModel data2 = getLocalizationScreen().getData();
                if (data2 != null && (domofonSettings2 = data2.getDomofonSettings()) != null && (body2 = domofonSettings2.getBody()) != null && (domofonSwitch2 = body2.getSwitch()) != null) {
                    titleOff = domofonSwitch2.getTitleOn();
                }
            } else {
                LocalizationLocalModel data3 = getLocalizationScreen().getData();
                if (data3 != null && (domofonSettings = data3.getDomofonSettings()) != null && (body = domofonSettings.getBody()) != null && (domofonSwitch = body.getSwitch()) != null) {
                    titleOff = domofonSwitch.getTitleOff();
                }
            }
            textView.setText(titleOff);
        }
        LinearLayout layoutLoader = getBinding().layoutLoader;
        Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
        ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(data.getServerState() == Resource.Status.LOADING));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() throws Resources.NotFoundException {
        FragmentDomofonBinding binding = getBinding();
        SwitchCompat switchCompat = binding.switchVideo;
        Boolean webrtcEnabled = getPrefManager().getExperimentalSettings().getWebrtcEnabled();
        switchCompat.setChecked(webrtcEnabled != null ? webrtcEnabled.booleanValue() : false);
        binding.switchVideo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IntercomSettingsFragment.initViews$lambda$7$lambda$4(this.f$0, compoundButton, z);
            }
        });
        binding.domofonCallsValueView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IntercomSettingsFragment.initViews$lambda$7$lambda$5(this.f$0, compoundButton, z);
            }
        });
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNull(toolbar);
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView viewMain = binding.viewMain;
        Intrinsics.checkNotNullExpressionValue(viewMain, "viewMain");
        ViewKt.addSystemWindowInsetToPadding$default(viewMain, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$4(IntercomSettingsFragment this$0, CompoundButton compoundButton, boolean z) {
        GeneralEvents generalEvents;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Analytics analytics = this$0.getAnalytics();
        if (z) {
            generalEvents = new GeneralEvents() { // from class: com.sputnik.common.analytics.ExperimentalEvents$ClickWebrtcOn
            };
        } else {
            generalEvents = new GeneralEvents() { // from class: com.sputnik.common.analytics.ExperimentalEvents$ClickWebrtcOff
            };
        }
        analytics.trackLogEvent(generalEvents);
        this$0.getPrefManager().updateExperimental(new ExperimentalFunctions(Boolean.valueOf(z)));
    }

    public IntercomSettingsFragment() {
        super(R.layout.fragment_domofon);
        this.binding = new ViewBindingFragmentDelegate(this, IntercomSettingsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.manageCamerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ManageCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$manageCamerasViewModel$2
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
        this.radioOptionViews = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$5(IntercomSettingsFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Profile profile = this$0.getProfileViewModel().getCurrentState().getProfile();
        if (profile != null ? Intrinsics.areEqual(profile.getCallIsEnabled(), Boolean.valueOf(z)) : false) {
            return;
        }
        this$0.getProfileViewModel().setCallsEnabled(z);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        DomofonSettingsLocale domofonSettings;
        DomofonSettingsBody body;
        DomofonSettingsLocale domofonSettings2;
        DomofonSettingsBody body2;
        DomofonSettingsLocale domofonSettings3;
        DomofonSettingsBody body3;
        DomofonSettingsLocale domofonSettings4;
        DomofonSettingsBody body4;
        DomofonSettingsLocale domofonSettings5;
        TextTitle navigation;
        DomofonSettingsLocale domofonSettings6;
        DomofonSettingsBody body5;
        FragmentDomofonBinding binding = getBinding();
        TextView textView = binding.tvCallsSubtitle;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String switchWebrtc = null;
        textView.setText((data == null || (domofonSettings6 = data.getDomofonSettings()) == null || (body5 = domofonSettings6.getBody()) == null) ? null : body5.getSubtitle());
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        toolbar.setTitle((data2 == null || (domofonSettings5 = data2.getDomofonSettings()) == null || (navigation = domofonSettings5.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView2 = binding.domofonCallsView;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        textView2.setText((data3 == null || (domofonSettings4 = data3.getDomofonSettings()) == null || (body4 = domofonSettings4.getBody()) == null) ? null : body4.getTitle());
        TextView textView3 = binding.tvCalls;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        textView3.setText((data4 == null || (domofonSettings3 = data4.getDomofonSettings()) == null || (body3 = domofonSettings3.getBody()) == null) ? null : body3.getHeaderCalls());
        TextView textView4 = binding.tvVideoHeader;
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        textView4.setText((data5 == null || (domofonSettings2 = data5.getDomofonSettings()) == null || (body2 = domofonSettings2.getBody()) == null) ? null : body2.getHeaderVideo());
        TextView textView5 = binding.tvVideo;
        LocalizationLocalModel data6 = getLocalizationScreen().getData();
        if (data6 != null && (domofonSettings = data6.getDomofonSettings()) != null && (body = domofonSettings.getBody()) != null) {
            switchWebrtc = body.getSwitchWebrtc();
        }
        textView5.setText(switchWebrtc);
        TextView tvVideoSubtitle = binding.tvVideoSubtitle;
        Intrinsics.checkNotNullExpressionValue(tvVideoSubtitle, "tvVideoSubtitle");
        ViewUtilsKt.highlightText(tvVideoSubtitle, "Во включенном положении уменьшает задержку работы видео, но может вызвать проблемы с воспроизведением.\nБольше рекомендаций по решению проблем с видео", new HighlightedText("Больше рекомендаций по решению проблем с видео", ContextCompat.getColor(requireContext(), R.color.sputnik_blue), null, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.intercom_settings.IntercomSettingsFragment$localize$1$1
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
                FaqNavigationUtils.INSTANCE.navigateToFaqQuestion(FragmentKt.findNavController(this.this$0), 10L, 31L);
            }
        }, 0, 0, 52, null));
    }
}
