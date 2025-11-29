package com.sputnik.service_payments.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.blocking.AboutCompanyBody;
import com.sputnik.common.entities.localization.entities.blocking.AboutServiceCompanyLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.VerticalLeafView;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.service_payments.databinding.BottomSheetAboutCompanyBinding;
import com.sputnik.service_payments.di.ServicePaymentComponentKt;
import com.sputnik.service_payments.entities.payments.PartnerInfo;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: BottomSheetAboutCompany.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0004R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/sputnik/service_payments/ui/BottomSheetAboutCompany;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/service_payments/databinding/BottomSheetAboutCompanyBinding;", "<init>", "()V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "servicePaymentsViewState", "", "renderBlockingUi", "(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel$delegate", "Lkotlin/Lazy;", "getServicePaymentsViewModel", "()Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "servicePaymentsViewModel", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetAboutCompany extends BaseBottomSheetDialogFragment<BottomSheetAboutCompanyBinding> {
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: servicePaymentsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy servicePaymentsViewModel;

    /* compiled from: BottomSheetAboutCompany.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.BottomSheetAboutCompany$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetAboutCompanyBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetAboutCompanyBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/service_payments/databinding/BottomSheetAboutCompanyBinding;", 0);
        }

        public final BottomSheetAboutCompanyBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetAboutCompanyBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetAboutCompanyBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
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

    private final ServicePaymentsViewModel getServicePaymentsViewModel() {
        return (ServicePaymentsViewModel) this.servicePaymentsViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ServicePaymentComponentKt.servicePaymentComponent(this).inject(this);
        super.onAttach(context);
    }

    /* compiled from: BottomSheetAboutCompany.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.service_payments.ui.BottomSheetAboutCompany$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07721 extends FunctionReferenceImpl implements Function1<ServicePaymentsViewState, Unit> {
        C07721(Object obj) {
            super(1, obj, BottomSheetAboutCompany.class, "renderBlockingUi", "renderBlockingUi(Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServicePaymentsViewState servicePaymentsViewState) {
            invoke2(servicePaymentsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServicePaymentsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetAboutCompany) this.receiver).renderBlockingUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ServicePaymentsViewModel servicePaymentsViewModel = getServicePaymentsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        servicePaymentsViewModel.observeState(viewLifecycleOwner, new C07721(this));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        getBinding();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        AboutServiceCompanyLocale aboutCompanyPopup;
        BottomSheetAboutCompanyBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        AboutCompanyBody body = (data == null || (aboutCompanyPopup = data.getAboutCompanyPopup()) == null) ? null : aboutCompanyPopup.getBody();
        LogUtilsKt.writeLog(String.valueOf(body));
        binding.tvTitle.setText(body != null ? body.getTitle() : null);
        binding.layoutOrganizationName.setTitle(body != null ? body.getCompanyTitleLabel() : null);
        binding.layoutOrganizationAddress.setTitle(body != null ? body.getAddressTitleLabel() : null);
        binding.layoutOrganizationPhone.setTitle(body != null ? body.getPhoneTitleLabel() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderBlockingUi(ServicePaymentsViewState servicePaymentsViewState) {
        PartnerInfo partner;
        PartnerInfo partner2;
        String address;
        PartnerInfo partner3;
        PartnerInfo partner4;
        String contactPhone;
        PartnerInfo partner5;
        PartnerInfo partner6;
        String organisation;
        BottomSheetAboutCompanyBinding binding = getBinding();
        VerticalLeafView verticalLeafView = binding.layoutOrganizationName;
        Intrinsics.checkNotNull(verticalLeafView);
        ServiceAccountInfo accountInfo = servicePaymentsViewState.getAccountInfo();
        boolean z = false;
        ViewBindingUtilsKt.visibilityBasedOn(verticalLeafView, Boolean.valueOf((accountInfo == null || (partner6 = accountInfo.getPartner()) == null || (organisation = partner6.getOrganisation()) == null || !(StringsKt.isBlank(organisation) ^ true)) ? false : true));
        ServiceAccountInfo accountInfo2 = servicePaymentsViewState.getAccountInfo();
        String address2 = null;
        verticalLeafView.setSubtitle((accountInfo2 == null || (partner5 = accountInfo2.getPartner()) == null) ? null : partner5.getOrganisation());
        VerticalLeafView verticalLeafView2 = binding.layoutOrganizationPhone;
        Intrinsics.checkNotNull(verticalLeafView2);
        ServiceAccountInfo accountInfo3 = servicePaymentsViewState.getAccountInfo();
        ViewBindingUtilsKt.visibilityBasedOn(verticalLeafView2, Boolean.valueOf((accountInfo3 == null || (partner4 = accountInfo3.getPartner()) == null || (contactPhone = partner4.getContactPhone()) == null || !(StringsKt.isBlank(contactPhone) ^ true)) ? false : true));
        ServiceAccountInfo accountInfo4 = servicePaymentsViewState.getAccountInfo();
        verticalLeafView2.setSubtitle((accountInfo4 == null || (partner3 = accountInfo4.getPartner()) == null) ? null : partner3.getContactPhone());
        VerticalLeafView verticalLeafView3 = binding.layoutOrganizationAddress;
        Intrinsics.checkNotNull(verticalLeafView3);
        ServiceAccountInfo accountInfo5 = servicePaymentsViewState.getAccountInfo();
        if (accountInfo5 != null && (partner2 = accountInfo5.getPartner()) != null && (address = partner2.getAddress()) != null && (!StringsKt.isBlank(address))) {
            z = true;
        }
        ViewBindingUtilsKt.visibilityBasedOn(verticalLeafView3, Boolean.valueOf(z));
        ServiceAccountInfo accountInfo6 = servicePaymentsViewState.getAccountInfo();
        if (accountInfo6 != null && (partner = accountInfo6.getPartner()) != null) {
            address2 = partner.getAddress();
        }
        verticalLeafView3.setSubtitle(address2);
    }

    public BottomSheetAboutCompany() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.servicePaymentsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ServicePaymentsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.service_payments.ui.BottomSheetAboutCompany$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.service_payments.ui.BottomSheetAboutCompany$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.service_payments.ui.BottomSheetAboutCompany$servicePaymentsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }
}
