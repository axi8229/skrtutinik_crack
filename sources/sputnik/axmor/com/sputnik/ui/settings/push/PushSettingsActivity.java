package sputnik.axmor.com.sputnik.ui.settings.push;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sputnik.common.base.BaseActivity;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.databinding.ActivityPushSettingsBinding;
import sputnik.axmor.com.sputnik.core.push.IPushManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel;
import sputnik.axmor.com.sputnik.ui.settings.SettingsViewState;

/* compiled from: PushSettingsActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/push/PushSettingsActivity;", "Lcom/sputnik/common/base/BaseActivity;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "state", "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/ActivityPushSettingsBinding;", "_binding", "Lsputnik/axmor/com/databinding/ActivityPushSettingsBinding;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel", "getBinding", "()Lsputnik/axmor/com/databinding/ActivityPushSettingsBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushSettingsActivity extends BaseActivity {
    private ActivityPushSettingsBinding _binding;
    public MultiViewModelFactory factory;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public PushSettingsActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityPushSettingsBinding getBinding() {
        ActivityPushSettingsBinding activityPushSettingsBinding = this._binding;
        Intrinsics.checkNotNull(activityPushSettingsBinding);
        return activityPushSettingsBinding;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final SettingsViewModel getViewModel() {
        return (SettingsViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextKt.getAppComponent(this).inject(this);
        this._binding = ActivityPushSettingsBinding.inflate(getLayoutInflater());
        setContentView(getBinding().getRoot());
        getViewModel().observeState(this, new AnonymousClass1(this));
        getViewModel().observeNotifications(this, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity.onCreate.2
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
                PushSettingsActivity pushSettingsActivity = PushSettingsActivity.this;
                ConstraintLayout root = pushSettingsActivity.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(pushSettingsActivity, root, it);
            }
        });
    }

    /* compiled from: PushSettingsActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$onCreate$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, PushSettingsActivity.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewState settingsViewState) {
            invoke2(settingsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PushSettingsActivity) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(SettingsViewState state) {
        getBinding();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final ActivityPushSettingsBinding binding = getBinding();
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$1(this.f$0, view);
            }
        });
        binding.btnPushMarket.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$2(this.f$0, view);
            }
        });
        binding.btnPushMarketSubs.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$3(this.f$0, view);
            }
        });
        binding.btnPushMarketServices.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$4(this.f$0, view);
            }
        });
        binding.btnPushMarketItems.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$5(this.f$0, view);
            }
        });
        binding.btnPushMarketStandard.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$6(this.f$0, view);
            }
        });
        binding.btnPushMarketPremium.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$7(this.f$0, view);
            }
        });
        binding.btnPushMarketToYooStandard.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$8(this.f$0, view);
            }
        });
        binding.btnPushMarketCard.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$9(this.f$0, view);
            }
        });
        binding.btnPushMarketStandardPayment.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$10(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureBle.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$11(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureAcceleratedLoading.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$12(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureDigitalKeys.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$13(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureLicensedKeys.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$14(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureHistory.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$15(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureArchive.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$16(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureExtraCameras.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$17(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureAlice.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$18(this.f$0, view);
            }
        });
        binding.btnPushMarketFeatureMultiAddress.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$19(this.f$0, view);
            }
        });
        binding.btnPushMarketItemsLicensedKeys.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$20(this.f$0, view);
            }
        });
        binding.btnPushMarketItemsYandexCatalog.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$21(this.f$0, view);
            }
        });
        binding.btnPushProfile.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$22(this.f$0, view);
            }
        });
        binding.btnPushVisits.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$23(this.f$0, view);
            }
        });
        binding.btnPushServicePayments.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$24(this.f$0, view);
            }
        });
        binding.btnPushFamily.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$25(this.f$0, view);
            }
        });
        binding.btnPushLicensedKeys.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$26(this.f$0, view);
            }
        });
        binding.btnPushNotifications.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$27(this.f$0, view);
            }
        });
        binding.btnPushCamerasGallery.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$28(this.f$0, view);
            }
        });
        binding.btnPushServicesBle.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$29(this.f$0, view);
            }
        });
        binding.btnPushYandexConnectAlice.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$30(this.f$0, view);
            }
        });
        binding.btnPushAboutCompany.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$31(this.f$0, view);
            }
        });
        binding.btnPushAboutApp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$32(this.f$0, view);
            }
        });
        binding.btnPushAboutCompanyContacts.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$33(this.f$0, view);
            }
        });
        binding.btnPushSupportChat.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$34(this.f$0, view);
            }
        });
        binding.btnPushFaq.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$35(this.f$0, view);
            }
        });
        binding.btnPushFaqCategory.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$36(this.f$0, view);
            }
        });
        binding.btnPushFaqQuestion.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$37(this.f$0, view);
            }
        });
        binding.btnPushFaqSubcategory.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$38(this.f$0, view);
            }
        });
        binding.btnPushBack.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$39(this.f$0, view);
            }
        });
        binding.btnPushEmergencyCode.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$40(this.f$0, view);
            }
        });
        binding.btnPushNotificationDetails.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$41(this.f$0, binding, view);
            }
        });
        binding.btnPushNotificationWithDeeplink.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingsActivity.initViews$lambda$43$lambda$42(this.f$0, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$1(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$2(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market", "Tap to open market", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$3(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Subs", "Tap to open market subscriptions", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/subs")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$4(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Services", "Tap to open market services", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/services")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$5(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Items", "Tap to open market items", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/items")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$6(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Standard", "Tap to open market standard", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$7(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Premium", "Tap to open market premium", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/premium")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$8(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market To Yoo Standard", "Tap to open market to yoo standard", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/to_yoo_standard")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$9(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Card", "Tap to open market card", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/card")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$10(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Standard Payment", "Tap to open market standard payment", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/payment")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$11(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature BLE", "Tap to open market feature BLE", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/ble")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$12(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Accelerated Loading", "Tap to open market feature accelerated loading", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/accelerated_loading")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$13(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Digital Keys", "Tap to open market feature digital keys", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/digital_keys")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$14(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Licensed Keys", "Tap to open market feature licensed keys", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/licensed_keys")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$15(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature History", "Tap to open market feature history", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/history")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$16(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Archive", "Tap to open market feature archive", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/archive")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$17(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Extra Cameras", "Tap to open market feature extra cameras", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/extra_cameras")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$18(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Alice", "Tap to open market feature alice", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/alice")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$19(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Feature Multi Address", "Tap to open market feature multi address", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/standard/features/multi_address")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$20(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Items Licensed Keys", "Tap to open market items licensed keys", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/items/licensed_keys")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$21(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Market Items Yandex Catalog", "Tap to open market items yandex catalog", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://market/items/yandex_catalog")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$22(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Profile", "Tap to open profile", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://profile")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$23(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Visits", "Tap to open visits", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://visits")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$24(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Service Payments", "Tap to open service payments", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://service_payments")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$25(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Test family", "Tap to open", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://family")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$26(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Licensed Keys", "Tap to open licensed keys", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://licensed_keys")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$27(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Deeplink to notifications", "Tap to open", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://notifications")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$28(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Cameras Gallery", "Tap to open cameras gallery", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://cameras/gallery")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$29(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Services BLE", "Tap to open services BLE", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://services/ble")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$30(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Yandex Connect Alice", "Tap to open yandex connect alice", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://yandex/connect-alice")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$31(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("About Company", "Tap to open about company", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://about/company")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$32(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("About App", "Tap to open about app", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://about/app")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$33(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("About Company Contacts", "Tap to open about company contacts", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://about/company-contacts")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$34(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Support Chat", "Tap to open support chat", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://support/chat")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$35(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("FAQ", "Tap to open FAQ", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://faq")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$36(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("FAQ Category", "Tap to open FAQ category", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "faq/2")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$37(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("FAQ Question", "Tap to open FAQ question", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "faq/2/2/4")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$38(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("FAQ Subcategory", "Tap to open FAQ subcategory", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "faq/2/2")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$39(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Back", "Tap to go back", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://back")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$40(PushSettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Emergency Code", "Tap to open emergency code", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://emergency_code")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$41(PushSettingsActivity this$0, ActivityPushSettingsBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Test notification id", "Tap to open", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), "sputnik://notifications/" + ((Object) this_with.etNotificationId.getText()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$43$lambda$42(PushSettingsActivity this$0, ActivityPushSettingsBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        IPushManager.INSTANCE.getInstance(this$0).handleMessage("Test custom deeplink: " + ((Object) this_with.etNotificationDeeplink.getText()), "Tap to open", MapsKt.mapOf(TuplesKt.to(PushMessage.Arguments.deeplink.toString(), String.valueOf(this_with.etNotificationDeeplink.getText()))));
    }
}
