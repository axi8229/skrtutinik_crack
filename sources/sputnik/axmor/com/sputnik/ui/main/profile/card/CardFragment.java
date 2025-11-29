package sputnik.axmor.com.sputnik.ui.main.profile.card;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
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
import com.sputnik.common.entities.localization.CardActionView;
import com.sputnik.common.entities.localization.CardBody;
import com.sputnik.common.entities.localization.CardLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SubscriptionBuyErrors;
import com.sputnik.common.entities.localization.SubscriptionBuyLocale;
import com.sputnik.common.entities.localization.TextSubtitle;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.entities.profile.ProfileCardInfo;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.card.PaymentState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import sputnik.axmor.com.databinding.FragmentCardBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.card.viewmodel.CardViewState;

/* compiled from: CardFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0003R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010>\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010@\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010?¨\u0006B"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/card/CardFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Lcom/sputnik/domain/common/Event;", "", RemoteMessageConst.DATA, "", "render3ds", "(Lcom/sputnik/domain/common/Event;)V", "haveCard", "()Z", "", "paymentMethod", "initPaymentMethod", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentCardBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentCardBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewModel;", "cardViewModel$delegate", "getCardViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/card/viewmodel/CardViewModel;", "cardViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "startGetPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "start3dsPaymentTokenResult", "CardType", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CardFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentCardBinding;", 0))};

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
    public final FragmentCardBinding getBinding() {
        return (FragmentCardBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final CardViewModel getCardViewModel() {
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
    public static final void startGetPaymentTokenResult$lambda$2(CardFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout loader = this$0.getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            ViewKt.visible(loader);
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            CardViewModel cardViewModel = this$0.getCardViewModel();
            Intrinsics.checkNotNull(tokenizationResultCreateTokenizationResult);
            cardViewModel.addCard(tokenizationResultCreateTokenizationResult.getPaymentToken(), tokenizationResultCreateTokenizationResult.getPaymentMethodType());
            return;
        }
        LinearLayout loader2 = this$0.getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader2, "loader");
        ViewKt.gone(loader2);
        LocalizationLocalModel data2 = this$0.getLocalizationScreen().getData();
        if (data2 == null || (subscriptionBuy = data2.getSubscriptionBuy()) == null || (errors = subscriptionBuy.getErrors()) == null || (operationFailure = errors.getOperationFailure()) == null) {
            return;
        }
        this$0.getCardViewModel().notifyErrorMessage(operationFailure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start3dsPaymentTokenResult$lambda$4(CardFragment this$0, ActivityResult result) {
        SubscriptionBuyLocale subscriptionBuy;
        SubscriptionBuyErrors errors;
        String operationFailure;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            LinearLayout loader = this$0.getBinding().loader;
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            ViewKt.visible(loader);
            this$0.getCardViewModel().getCurrentState();
            return;
        }
        LinearLayout loader2 = this$0.getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader2, "loader");
        ViewKt.gone(loader2);
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
        profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) {
                invoke2(profileViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileViewState it) {
                String paymentMethod;
                Intrinsics.checkNotNullParameter(it, "it");
                ConstraintLayout layoutPaymentMethod = CardFragment.this.getBinding().layoutPaymentMethod;
                Intrinsics.checkNotNullExpressionValue(layoutPaymentMethod, "layoutPaymentMethod");
                Profile profile = it.getProfile();
                ViewBindingUtilsKt.visibilityBasedOn(layoutPaymentMethod, Boolean.valueOf((profile != null ? profile.getPaymentMethod() : null) != null));
                ConstraintLayout layoutNoCard = CardFragment.this.getBinding().layoutNoCard;
                Intrinsics.checkNotNullExpressionValue(layoutNoCard, "layoutNoCard");
                Profile profile2 = it.getProfile();
                ViewBindingUtilsKt.visibilityBasedOn(layoutNoCard, Boolean.valueOf((profile2 != null ? profile2.getPaymentMethod() : null) == null));
                LinearLayout loader = CardFragment.this.getBinding().loader;
                Intrinsics.checkNotNullExpressionValue(loader, "loader");
                ViewBindingUtilsKt.visibilityBasedOn(loader, Boolean.valueOf(it.getServerState() == Resource.Status.LOADING));
                Profile profile3 = it.getProfile();
                if (profile3 == null || (paymentMethod = profile3.getPaymentMethod()) == null) {
                    return;
                }
                CardFragment.this.initPaymentMethod(paymentMethod);
            }
        });
        CardViewModel cardViewModel = getCardViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        cardViewModel.observeSubState(viewLifecycleOwner2, new Function1<CardViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isUpdated();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.3
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
                    CardFragment cardFragment = CardFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        IProfileViewModel.DefaultImpls.loadProfile$default(cardFragment.getProfileViewModel(), false, 1, null);
                    }
                }
            }
        });
        CardViewModel cardViewModel2 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        cardViewModel2.observeSubState(viewLifecycleOwner3, new Function1<CardViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isDeleted();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.5
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
                if (!it.peekContent().booleanValue() || it.getContentIfNotHandled() == null) {
                    return;
                }
                CardFragment.this.getProfileViewModel().loadProfile(false);
            }
        });
        CardViewModel cardViewModel3 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        cardViewModel3.observeSubState(viewLifecycleOwner4, new Function1<CardViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getNeed3ds();
            }
        }, new AnonymousClass7(this));
        CardViewModel cardViewModel4 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        cardViewModel4.observeSubState(viewLifecycleOwner5, new Function1<CardViewState, PaymentState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.8
            @Override // kotlin.jvm.functions.Function1
            public final PaymentState invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getState3ds();
            }
        }, new Function1<PaymentState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.9
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
                    IProfileViewModel.DefaultImpls.loadProfile$default(CardFragment.this.getProfileViewModel(), false, 1, null);
                }
            }
        });
        CardViewModel cardViewModel5 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        cardViewModel5.observeSubState(viewLifecycleOwner6, new Function1<CardViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.10
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(CardViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.11
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
                if (it == Resource.Status.SUCCESS || it == Resource.Status.ERROR) {
                    LinearLayout loader = CardFragment.this.getBinding().loader;
                    Intrinsics.checkNotNullExpressionValue(loader, "loader");
                    ViewKt.gone(loader);
                }
            }
        });
        CardViewModel cardViewModel6 = getCardViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        cardViewModel6.observeNotifications(viewLifecycleOwner7, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.onViewCreated.12
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
                CardFragment cardFragment = CardFragment.this;
                LinearLayout root = cardFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(cardFragment, root, it);
            }
        });
    }

    /* compiled from: CardFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Event<? extends Boolean>, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, CardFragment.class, "render3ds", "render3ds(Lcom/sputnik/domain/common/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
            invoke2((Event<Boolean>) event);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event<Boolean> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CardFragment) this.receiver).render3ds(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render3ds(Event<Boolean> data) {
        Boolean contentIfNotHandled = data.getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        String url3ds = getCardViewModel().getCurrentState().getUrl3ds();
        Intrinsics.checkNotNull(url3ds);
        ActivityResultLauncher<Intent> activityResultLauncher = this.start3dsPaymentTokenResult;
        CardViewModel cardViewModel = getCardViewModel();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        activityResultLauncher.launch(cardViewModel.getConfirmationIntent(contextRequireContext, url3ds));
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        ImageView btnDeletePaymentMethod = getBinding().btnDeletePaymentMethod;
        Intrinsics.checkNotNullExpressionValue(btnDeletePaymentMethod, "btnDeletePaymentMethod");
        SafeClickListenerKt.setSafeOnClickListener$default(btnDeletePaymentMethod, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment.initViews.1
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
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(CardFragment.this), R.id.action_global_to_deletePaymentMethodDialog, null, null, 6, null);
            }
        }, 1, null);
        getBinding().subsButtonGetAccess.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardFragment.initViews$lambda$6(this.f$0, view);
            }
        });
        getBinding().btnChange.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardFragment.initViews$lambda$7(this.f$0, view);
            }
        });
        getBinding().btnDelete.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardFragment.initViews$lambda$8(this.f$0, view);
            }
        });
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        ViewKt.addSystemWindowInsetToPadding$default(scrollView, true, false, true, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6(final CardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCardViewModel().saveCard(new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$initViews$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.startGetPaymentTokenResult.launch(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(final CardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCardViewModel().saveCard(new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$initViews$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.startGetPaymentTokenResult.launch(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8(CardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout loader = this$0.getBinding().loader;
        Intrinsics.checkNotNullExpressionValue(loader, "loader");
        ViewKt.visible(loader);
        this$0.getCardViewModel().deleteCard();
    }

    private final boolean haveCard() {
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        return (profile != null ? profile.getCardInfo() : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPaymentMethod(String paymentMethod) {
        FragmentCardBinding binding = getBinding();
        int iHashCode = paymentMethod.hashCode();
        if (iHashCode != -1787710669) {
            if (iHashCode != -1659384968) {
                if (iHashCode == 113665 && paymentMethod.equals("sbp")) {
                    binding.tvPaymentMethod.setText("СБП");
                    binding.ivPaymentMethod.setImageResource(R.drawable.ic_sbp);
                }
            } else if (paymentMethod.equals("sberbank")) {
                binding.tvPaymentMethod.setText("SberPay");
                binding.ivPaymentMethod.setImageResource(R.drawable.ic_sberpay);
            }
        } else if (paymentMethod.equals("bank_card")) {
            Profile profile = getProfileViewModel().getCurrentState().getProfile();
            CardType cardType = null;
            ProfileCardInfo cardInfo = profile != null ? profile.getCardInfo() : null;
            Intrinsics.checkNotNull(cardInfo);
            CardType[] cardTypeArrValues = CardType.values();
            int length = cardTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                CardType cardType2 = cardTypeArrValues[i];
                String type = cardType2.getType();
                String lowerCase = cardInfo.getCardType().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(type, lowerCase)) {
                    cardType = cardType2;
                    break;
                }
                i++;
            }
            if (cardType == null) {
                cardType = CardType.DEFAULT;
            }
            binding.tvPaymentMethod.setText(cardType.getTitle());
            binding.ivPaymentMethod.setImageResource(cardType.getIcon());
            binding.tvPaymentMethodInfo.setText(" ** " + cardInfo.getLast4());
        }
        ConstraintLayout layoutPaymentMethod = binding.layoutPaymentMethod;
        Intrinsics.checkNotNullExpressionValue(layoutPaymentMethod, "layoutPaymentMethod");
        ViewKt.visible(layoutPaymentMethod);
    }

    public CardFragment() {
        super(R.layout.fragment_card);
        this.binding = new ViewBindingFragmentDelegate(this, CardFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.cardViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CardViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$cardViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CardFragment.startGetPaymentTokenResult$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startGetPaymentTokenResult = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.card.CardFragment$$ExternalSyntheticLambda4
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CardFragment.start3dsPaymentTokenResult$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.start3dsPaymentTokenResult = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CardFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/card/CardFragment$CardType;", "", "", "type", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, RemoteMessageConst.Notification.ICON, "<init>", "(Ljava/lang/String;ILjava/lang/String;II)V", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "I", "getTitle", "()I", "setTitle", "(I)V", "getIcon", "setIcon", "MAESTRO", "MASTER_CARD", "MIR", "VISA", "DEFAULT", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CardType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CardType[] $VALUES;
        private int icon;
        private int title;
        private String type;
        public static final CardType MAESTRO = new CardType("MAESTRO", 0, "maestro", R.string.card_maestro, R.drawable.ic_card_maestro);
        public static final CardType MASTER_CARD = new CardType("MASTER_CARD", 1, "mastercard", R.string.card_mastercard, R.drawable.ic_card_mastercard);
        public static final CardType MIR = new CardType("MIR", 2, "mir", R.string.card_mir, R.drawable.ic_card_mir);
        public static final CardType VISA = new CardType("VISA", 3, "visa", R.string.card_visa, R.drawable.ic_card_visa);
        public static final CardType DEFAULT = new CardType("DEFAULT", 4, "default", R.string.card_default, R.drawable.ic_card_default);

        private static final /* synthetic */ CardType[] $values() {
            return new CardType[]{MAESTRO, MASTER_CARD, MIR, VISA, DEFAULT};
        }

        public static CardType valueOf(String str) {
            return (CardType) Enum.valueOf(CardType.class, str);
        }

        public static CardType[] values() {
            return (CardType[]) $VALUES.clone();
        }

        private CardType(String str, int i, String str2, int i2, int i3) {
            this.type = str2;
            this.title = i2;
            this.icon = i3;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final int getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        static {
            CardType[] cardTypeArr$values = $values();
            $VALUES = cardTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(cardTypeArr$values);
        }
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
        CardLocale card;
        CardBody body4;
        TextTitle topView3;
        CardLocale card2;
        CardBody body5;
        CardActionView actionView2;
        List<String> buttonTitles2;
        CardLocale card3;
        CardBody body6;
        CardActionView actionView3;
        List<String> buttonTitles3;
        CardLocale card4;
        TextTitle navigation2;
        FragmentCardBinding binding = getBinding();
        String title = null;
        if (haveCard()) {
            Toolbar toolbar = binding.toolbar;
            LocalizationLocalModel data = getLocalizationScreen().getData();
            toolbar.setTitle((data == null || (card4 = data.getCard()) == null || (navigation2 = card4.getNavigation()) == null) ? null : navigation2.getTitle());
            TextView textView = binding.tvChange;
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            textView.setText((data2 == null || (card3 = data2.getCard()) == null || (body6 = card3.getBody()) == null || (actionView3 = body6.getActionView()) == null || (buttonTitles3 = actionView3.getButtonTitles()) == null) ? null : (String) CollectionsKt.first((List) buttonTitles3));
            TextView textView2 = binding.tvDelete;
            LocalizationLocalModel data3 = getLocalizationScreen().getData();
            textView2.setText((data3 == null || (card2 = data3.getCard()) == null || (body5 = card2.getBody()) == null || (actionView2 = body5.getActionView()) == null || (buttonTitles2 = actionView2.getButtonTitles()) == null) ? null : (String) CollectionsKt.last((List) buttonTitles2));
            TextView textView3 = binding.tvSubtitleForCard;
            LocalizationLocalModel data4 = getLocalizationScreen().getData();
            if (data4 != null && (card = data4.getCard()) != null && (body4 = card.getBody()) != null && (topView3 = body4.getTopView()) != null) {
                title = topView3.getTitle();
            }
            textView3.setText(title);
            return;
        }
        Toolbar toolbar2 = binding.toolbar;
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        toolbar2.setTitle((data5 == null || (addNewCard4 = data5.getAddNewCard()) == null || (navigation = addNewCard4.getNavigation()) == null) ? null : navigation.getTitle());
        TextView textView4 = binding.tvTitle;
        LocalizationLocalModel data6 = getLocalizationScreen().getData();
        textView4.setText((data6 == null || (addNewCard3 = data6.getAddNewCard()) == null || (body3 = addNewCard3.getBody()) == null || (topView2 = body3.getTopView()) == null) ? null : topView2.getTitle());
        TextView textView5 = binding.tvSubtitleNoCard;
        LocalizationLocalModel data7 = getLocalizationScreen().getData();
        textView5.setText((data7 == null || (addNewCard2 = data7.getAddNewCard()) == null || (body2 = addNewCard2.getBody()) == null || (topView = body2.getTopView()) == null) ? null : topView.getSubtitle());
        TextView textView6 = binding.subsButtonGetAccess;
        LocalizationLocalModel data8 = getLocalizationScreen().getData();
        if (data8 != null && (addNewCard = data8.getAddNewCard()) != null && (body = addNewCard.getBody()) != null && (actionView = body.getActionView()) != null && (buttonTitles = actionView.getButtonTitles()) != null) {
            title = (String) CollectionsKt.first((List) buttonTitles);
        }
        textView6.setText(title);
    }
}
