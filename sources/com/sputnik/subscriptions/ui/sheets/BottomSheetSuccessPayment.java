package com.sputnik.subscriptions.ui.sheets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionChangedPopupBody;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionChangedPopupLocale;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionPayedPopupBody;
import com.sputnik.common.entities.localization.entities.subscriptions.SubscriptionPayedPopupLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import com.sputnik.subscriptions.databinding.BottomSheetSuccessPaymentBinding;
import com.sputnik.subscriptions.di.SubscriptionsComponentKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: BottomSheetSuccessPayment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0004R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u001d\u00101\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/sputnik/subscriptions/ui/sheets/BottomSheetSuccessPayment;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/subscriptions/databinding/BottomSheetSuccessPaymentBinding;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "state", "", "renderUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "Lkotlin/Lazy;", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "", "buttonColor$delegate", "getButtonColor", "()Ljava/lang/Integer;", "buttonColor", "", "isMigration$delegate", "isMigration", "()Ljava/lang/Boolean;", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetSuccessPayment extends BaseBottomSheetDialogFragment<BottomSheetSuccessPaymentBinding> {
    public Analytics analytics;

    /* renamed from: buttonColor$delegate, reason: from kotlin metadata */
    private final Lazy buttonColor;
    public MultiViewModelFactory factory;

    /* renamed from: isMigration$delegate, reason: from kotlin metadata */
    private final Lazy isMigration;
    public LocalizationStorage localizationStorage;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* compiled from: BottomSheetSuccessPayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetSuccessPaymentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetSuccessPaymentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/subscriptions/databinding/BottomSheetSuccessPaymentBinding;", 0);
        }

        public final BottomSheetSuccessPaymentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetSuccessPaymentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetSuccessPaymentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
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

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    private final Integer getButtonColor() {
        return (Integer) this.buttonColor.getValue();
    }

    private final Boolean isMigration() {
        return (Boolean) this.isMigration.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SubscriptionsComponentKt.subscriptionsComponent(this).inject(this);
        super.onAttach(context);
    }

    /* compiled from: BottomSheetSuccessPayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07781 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        C07781(Object obj) {
            super(1, obj, BottomSheetSuccessPayment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetSuccessPayment) this.receiver).renderUi(p0);
        }
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner, new C07781(this));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        AppCompatButton appCompatButton = getBinding().btnSubscribe;
        Integer buttonColor = getButtonColor();
        if (buttonColor != null) {
            appCompatButton.setBackgroundTintList(ColorStateList.valueOf(buttonColor.intValue()));
        }
        Intrinsics.checkNotNull(appCompatButton);
        SafeClickListenerKt.setSafeOnClickListener$default(appCompatButton, 0L, new Function1<View, Unit>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$initViews$1$1$2
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
                FragmentKt.findNavController(this.this$0).navigateUp();
            }
        }, 1, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle doneButton;
        SubscriptionPayedPopupLocale subscriptionTariffPopup;
        TextTitle doneButton2;
        SubscriptionChangedPopupLocale subscriptionChangedTariffPopup;
        BottomSheetSuccessPaymentBinding binding = getBinding();
        String title = null;
        if (Intrinsics.areEqual(isMigration(), Boolean.TRUE)) {
            LocalizationLocalModel data = getLocalizationStorage().getData();
            SubscriptionChangedPopupBody body = (data == null || (subscriptionChangedTariffPopup = data.getSubscriptionChangedTariffPopup()) == null) ? null : subscriptionChangedTariffPopup.getBody();
            binding.tvHeader.setText(body != null ? body.getTitle() : null);
            binding.tvTitle1.setText(body != null ? body.getSubtitle() : null);
            AppCompatButton appCompatButton = binding.btnSubscribe;
            if (body != null && (doneButton2 = body.getDoneButton()) != null) {
                title = doneButton2.getTitle();
            }
            appCompatButton.setText(title);
            return;
        }
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        SubscriptionPayedPopupBody body2 = (data2 == null || (subscriptionTariffPopup = data2.getSubscriptionTariffPopup()) == null) ? null : subscriptionTariffPopup.getBody();
        binding.tvHeader.setText(body2 != null ? body2.getTitle() : null);
        binding.tvTitle1.setText(body2 != null ? body2.getDescription() : null);
        AppCompatButton appCompatButton2 = binding.btnSubscribe;
        if (body2 != null && (doneButton = body2.getDoneButton()) != null) {
            title = doneButton.getTitle();
        }
        appCompatButton2.setText(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(SubscriptionsViewState state) {
        getBinding();
    }

    public BottomSheetSuccessPayment() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.buttonColor = LazyKt.lazy(new Function0<Integer>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment$buttonColor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (Integer) (arguments != null ? arguments.get(RemoteMessageConst.Notification.COLOR) : null);
            }
        });
        this.isMigration = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment.isMigration.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = BottomSheetSuccessPayment.this.getArguments();
                return (Boolean) (arguments != null ? arguments.get("is_migration_from_other_subscription") : null);
            }
        });
    }
}
