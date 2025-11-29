package sputnik.axmor.com.sputnik.ui.main.profile.card;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.AddNewCardBody;
import com.sputnik.common.entities.localization.AddNewCardButtonTitles;
import com.sputnik.common.entities.localization.AddNewCardLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyErrors;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.TextSubtitle;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.PaymentState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentEmptyCardBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewState;
import sputnik.axmor.com.sputnik.viewmodels.ICardViewModel;

/* compiled from: NewCardFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00108\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010606058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010606058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109¨\u0006;"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/card/NewCardFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/domain/common/Event;", "", RemoteMessageConst.DATA, "", "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentEmptyCardBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentEmptyCardBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewModel;", "cardViewModel$delegate", "getCardViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewModel;", "cardViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startGetPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "start3dsPaymentTokenResult", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewCardFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NewCardFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentEmptyCardBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: cardViewModel$delegate, reason: from kotlin metadata */
    private final Lazy cardViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ActivityResultLauncher<Intent> start3dsPaymentTokenResult;
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentEmptyCardBinding getBinding() {
        return (FragmentEmptyCardBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CardViewModel getCardViewModel() {
        return (CardViewModel) this.cardViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGetPaymentTokenResult$lambda$2(NewCardFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            CardViewModel cardViewModel = this$0.getCardViewModel();
            Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
            ICardViewModel.DefaultImpls.addCard$default(cardViewModel, tokenizationResultCreateTokenizationResult.getPaymentToken(), null, 2, null);
            return;
        }
        LocalizationLocalModel data2 = this$0.getLocalizationScreen().getData();
        if (data2 == null || (subscriptionBuy = data2.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getCardViewModel().notifyErrorMessage(operationFailure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start3dsPaymentTokenResult$lambda$4(NewCardFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout serviceLoader = this$0.getBinding().serviceLoader;
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
            ViewKt.visible(serviceLoader);
            this$0.getCardViewModel().getCurrentState();
            return;
        }
        LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
        if (data == null || (subscriptionBuy = data.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getCardViewModel().notifyErrorMessage(operationFailure);
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
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) throws Resources.NotFoundException {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getServerState() == Resource.Status.SUCCESS) {
                    Profile profile = it.getProfile();
                    Intrinsics.checkNotNull(profile);
                    if (profile.getCardInfo() != null) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(NewCardFragment.this), R.id.newCardFragment, R.id.action_newCardFragment_to_cardFragment, null, null, 12, null);
                        LinearLayout serviceLoader = NewCardFragment.this.getBinding().serviceLoader;
                        Intrinsics.checkNotNullExpressionValue(serviceLoader, "serviceLoader");
                        ViewKt.gone(serviceLoader);
                    }
                }
            }
        });
        CardViewModel cardViewModel = getCardViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        cardViewModel.observeSubState(viewLifecycleOwner2, new Function1<CardViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isUpdated();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.3
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
                    NewCardFragment newCardFragment = NewCardFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        IProfileViewModel.DefaultImpls.loadProfile$default(newCardFragment.getProfileViewModel(), false, 1, null);
                    }
                }
            }
        });
        CardViewModel cardViewModel2 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        cardViewModel2.observeSubState(viewLifecycleOwner3, new Function1<CardViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass5(this));
        CardViewModel cardViewModel3 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        cardViewModel3.observeSubState(viewLifecycleOwner4, new Function1<CardViewState, PaymentState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final PaymentState invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getState3ds();
            }
        }, new Function1<PaymentState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PaymentState paymentState) {
                invoke2(paymentState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PaymentState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it == PaymentState.canceled) {
                    IProfileViewModel.DefaultImpls.loadProfile$default(NewCardFragment.this.getProfileViewModel(), false, 1, null);
                }
            }
        });
        CardViewModel cardViewModel4 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        cardViewModel4.observeNotifications(viewLifecycleOwner5, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.onViewCreated.8
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
                NewCardFragment newCardFragment = NewCardFragment.this;
                LinearLayout root = newCardFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(newCardFragment, root, it);
            }
        });
    }

    /* compiled from: NewCardFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, NewCardFragment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((NewCardFragment) this.receiver).render3ds(p0);
        }
    }

    public NewCardFragment() {
        super(R.layout.fragment_empty_card);
        this.binding = new ViewBindingFragmentDelegate(this, NewCardFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$cardViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.cardViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CardViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$special$$inlined$viewModels$default$4
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
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                NewCardFragment.startGetPaymentTokenResult$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                NewCardFragment.start3dsPaymentTokenResult$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render3ds(Event<Boolean> data) {
        data.getContentIfNotHandled();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        TextView subsButtonGetAccess = getBinding().subsButtonGetAccess;
        Intrinsics.checkNotNullExpressionValue(subsButtonGetAccess, "subsButtonGetAccess");
        SafeClickListenerKt.setSafeOnClickListener$default(subsButtonGetAccess, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.initViews.1
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
                CardViewModel cardViewModel = NewCardFragment.this.getCardViewModel();
                final NewCardFragment newCardFragment = NewCardFragment.this;
                cardViewModel.saveCard(new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.NewCardFragment.initViews.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                        invoke2(intent);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Intent it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        newCardFragment.startGetPaymentTokenResult.launch(it2);
                    }
                });
            }
        }, 1, null);
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        AddNewCardLocale addNewCard;
        AddNewCardBody body;
        AddNewCardButtonTitles actionView;
        List<String> buttonTitles;
        AddNewCardLocale addNewCard2;
        AddNewCardBody body2;
        TextSubtitle topView;
        AddNewCardLocale addNewCard3;
        AddNewCardBody body3;
        TextSubtitle topView2;
        AddNewCardLocale addNewCard4;
        TextTitle navigation;
        FragmentEmptyCardBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String str = null;
        toolbar.setTitle((data == null || (addNewCard4 = data.getAddNewCard()) == null || (navigation = addNewCard4.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView = binding.tvTitle;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView.setText((data2 == null || (addNewCard3 = data2.getAddNewCard()) == null || (body3 = addNewCard3.getBody()) == null || (topView2 = body3.getTopView()) == null) ? null : topView2.getTitle());
        TextView textView2 = binding.tvSubtitle;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        textView2.setText((data3 == null || (addNewCard2 = data3.getAddNewCard()) == null || (body2 = addNewCard2.getBody()) == null || (topView = body2.getTopView()) == null) ? null : topView.getSubtitle());
        TextView textView3 = binding.subsButtonGetAccess;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (addNewCard = data4.getAddNewCard()) != null && (body = addNewCard.getBody()) != null && (actionView = body.getActionView()) != null && (buttonTitles = actionView.getButtonTitles()) != null) {
            str = (String) CollectionsKt.first((List) buttonTitles);
        }
        textView3.setText(str);
    }
}
