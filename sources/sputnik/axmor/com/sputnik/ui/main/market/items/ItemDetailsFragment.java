package sputnik.axmor.com.sputnik.ui.main.market.items;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.KeysEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.market.items.ItemsIds;
import com.sputnik.common.entities.market.items.MarketItem;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.TextViewWithImageNew;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewState;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentMarketItemDetailsBinding;
import sputnik.axmor.com.databinding.LayoutMarketItemDetailsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.IntentProcessingUtilsKt;

/* compiled from: ItemDetailsFragment.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J!\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001d\u0010N\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010/\u001a\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006R"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/items/ItemDetailsFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "itemType", "", "trackAnalytics", "(Ljava/lang/String;)V", "checkIfLoadedGone", "imageUrl", "Landroid/widget/ImageView;", "view", "loadImage", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "subscriptionsViewState", "renderUi", "(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", "identifier", "trackClickAnalytics", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "localize", "initViews", "Landroid/view/View;", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentMarketItemDetailsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentMarketItemDetailsBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "marketItemId$delegate", "getMarketItemId", "()Ljava/lang/String;", "marketItemId", "", "progressBarCounter", "I", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ItemDetailsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ItemDetailsFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentMarketItemDetailsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: marketItemId$delegate, reason: from kotlin metadata */
    private final Lazy marketItemId;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private int progressBarCounter;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentMarketItemDetailsBinding getBinding() {
        return (FragmentMarketItemDetailsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
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
    public final String getMarketItemId() {
        return (String) this.marketItemId.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FragmentMarketItemDetailsBinding binding = getBinding();
        LayoutMarketItemDetailsBinding layoutMarketItemDetailsBinding = binding.layout;
        binding.toolbar.setTitle(Intrinsics.areEqual(getMarketItemId(), ItemsIds.licensed_keys.toString()) ? "Ключи" : "");
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment.onViewCreated.1
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
        SubscriptionsViewModel subscriptionsViewModel = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        subscriptionsViewModel.observeState(viewLifecycleOwner2, new AnonymousClass2(this));
        SubscriptionsViewModel subscriptionsViewModel2 = getSubscriptionsViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        subscriptionsViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment.onViewCreated.3
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
                ItemDetailsFragment itemDetailsFragment = ItemDetailsFragment.this;
                ConstraintLayout root = itemDetailsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(itemDetailsFragment, root, it);
            }
        });
        String marketItemId = getMarketItemId();
        if (marketItemId == null) {
            marketItemId = "";
        }
        trackAnalytics(marketItemId);
    }

    /* compiled from: ItemDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SubscriptionsViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, ItemDetailsFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/SubscriptionsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionsViewState subscriptionsViewState) {
            invoke2(subscriptionsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubscriptionsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ItemDetailsFragment) this.receiver).renderUi(p0);
        }
    }

    private final void trackAnalytics(String itemType) {
        if (Intrinsics.areEqual(itemType, ItemsIds.licensed_keys.toString())) {
            getAnalytics().trackLogEvent(new KeysEvents.ShowDetKeys());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfLoadedGone() {
        int i = this.progressBarCounter - 1;
        this.progressBarCounter = i;
        if (i <= 0) {
            LinearLayout mainLoader = getBinding().mainLoader;
            Intrinsics.checkNotNullExpressionValue(mainLoader, "mainLoader");
            ViewKt.gone(mainLoader);
        }
    }

    /* compiled from: ItemDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$loadImage$1", f = "ItemDetailsFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$loadImage$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imageUrl;
        final /* synthetic */ ImageView $view;
        int label;
        final /* synthetic */ ItemDetailsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImageView imageView, String str, ItemDetailsFragment itemDetailsFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$view = imageView;
            this.$imageUrl = str;
            this.this$0 = itemDetailsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$view, this.$imageUrl, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            RequestBuilder requestBuilderDiskCacheStrategy = Glide.with(this.$view).load(this.$imageUrl).diskCacheStrategy(DiskCacheStrategy.ALL);
            final ItemDetailsFragment itemDetailsFragment = this.this$0;
            requestBuilderDiskCacheStrategy.listener(new RequestListener<Drawable>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment.loadImage.1.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    itemDetailsFragment.checkIfLoadedGone();
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    itemDetailsFragment.checkIfLoadedGone();
                    return false;
                }
            }).into(this.$view);
            return Unit.INSTANCE;
        }
    }

    private final void loadImage(String imageUrl, ImageView view) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(view, imageUrl, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(SubscriptionsViewState subscriptionsViewState) {
        String title;
        Object next;
        MarketItem.DetailedLayout detailedLayout;
        final MarketItem.DetailedLayout.Button button;
        MarketItem.DetailedLayout detailedLayout2;
        MarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures;
        MarketItem.DetailedLayout detailedLayout3;
        MarketItem.DetailedLayout.Notice notice;
        MarketItem.DetailedLayout detailedLayout4;
        MarketItem.DetailedLayout.Header header;
        MarketItem.DetailedLayout detailedLayout5;
        MarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures2;
        List<MarketItem.DetailedLayout.Feature> features;
        MarketItem.DetailedLayout detailedLayout6;
        List<MarketItem.DetailedLayout.FeatureObject> features2;
        MarketItem.DetailedLayout.Feature feature;
        MarketItem.DetailedLayout.Feature feature2;
        MarketItem.DetailedLayout detailedLayout7;
        MarketItem.DetailedLayout.UpcomingFeatures upcomingFeatures3;
        List<MarketItem.DetailedLayout.Feature> features3;
        MarketItem.DetailedLayout detailedLayout8;
        List<MarketItem.DetailedLayout.FeatureObject> features4;
        MarketItem.DetailedLayout detailedLayout9;
        MarketItem.DetailedLayout.Header header2;
        MarketItem.DetailedLayout detailedLayout10;
        MarketItem.DetailedLayout.Header header3;
        FragmentMarketItemDetailsBinding binding = getBinding();
        LayoutMarketItemDetailsBinding layoutMarketItemDetailsBinding = binding.layout;
        List<MarketItem> items = subscriptionsViewState.getItems();
        if (items != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                title = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics.areEqual(((MarketItem) next).getIdentifier(), getMarketItemId())) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MarketItem marketItem = (MarketItem) next;
            if (marketItem != null) {
                TextView textView = layoutMarketItemDetailsBinding.tvTitle1;
                MarketItem.MarketItemAppearance appearance = marketItem.getAppearance();
                textView.setText((appearance == null || (detailedLayout10 = appearance.getDetailedLayout()) == null || (header3 = detailedLayout10.getHeader()) == null) ? null : header3.getTitle());
                MarketItem.MarketItemAppearance appearance2 = marketItem.getAppearance();
                if (((appearance2 == null || (detailedLayout9 = appearance2.getDetailedLayout()) == null || (header2 = detailedLayout9.getHeader()) == null) ? null : header2.getImageLink()) != null) {
                    this.progressBarCounter++;
                }
                MarketItem.MarketItemAppearance appearance3 = marketItem.getAppearance();
                if (appearance3 != null && (detailedLayout8 = appearance3.getDetailedLayout()) != null && (features4 = detailedLayout8.getFeatures()) != null) {
                    for (MarketItem.DetailedLayout.FeatureObject featureObject : features4) {
                        this.progressBarCounter++;
                    }
                }
                MarketItem.MarketItemAppearance appearance4 = marketItem.getAppearance();
                if (appearance4 != null && (detailedLayout7 = appearance4.getDetailedLayout()) != null && (upcomingFeatures3 = detailedLayout7.getUpcomingFeatures()) != null && (features3 = upcomingFeatures3.getFeatures()) != null) {
                    for (MarketItem.DetailedLayout.Feature feature3 : features3) {
                        this.progressBarCounter++;
                    }
                }
                MarketItem.MarketItemAppearance appearance5 = marketItem.getAppearance();
                if (appearance5 != null && (detailedLayout6 = appearance5.getDetailedLayout()) != null && (features2 = detailedLayout6.getFeatures()) != null) {
                    for (MarketItem.DetailedLayout.FeatureObject featureObject2 : features2) {
                        LinearLayout linearLayout = getBinding().layout.layoutFeatures;
                        Context contextRequireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        TextViewWithImageNew textViewWithImageNew = new TextViewWithImageNew(contextRequireContext, null, 0, 6, null);
                        loadImage(String.valueOf((featureObject2 == null || (feature2 = featureObject2.getFeature()) == null) ? null : feature2.getImageLink()), textViewWithImageNew.getImageView());
                        textViewWithImageNew.setTitle((featureObject2 == null || (feature = featureObject2.getFeature()) == null) ? null : feature.getDescription());
                        linearLayout.addView(textViewWithImageNew);
                    }
                }
                MarketItem.MarketItemAppearance appearance6 = marketItem.getAppearance();
                if (appearance6 != null && (detailedLayout5 = appearance6.getDetailedLayout()) != null && (upcomingFeatures2 = detailedLayout5.getUpcomingFeatures()) != null && (features = upcomingFeatures2.getFeatures()) != null) {
                    for (MarketItem.DetailedLayout.Feature feature4 : features) {
                        LinearLayout linearLayout2 = getBinding().layout.layoutFeaturesSecond;
                        Context contextRequireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        TextViewWithImageNew textViewWithImageNew2 = new TextViewWithImageNew(contextRequireContext2, null, 0, 6, null);
                        loadImage(String.valueOf(feature4 != null ? feature4.getImageLink() : null), textViewWithImageNew2.getImageView());
                        textViewWithImageNew2.setTitle(feature4.getDescription());
                        linearLayout2.addView(textViewWithImageNew2);
                    }
                }
                MarketItem.MarketItemAppearance appearance7 = marketItem.getAppearance();
                String strValueOf = String.valueOf((appearance7 == null || (detailedLayout4 = appearance7.getDetailedLayout()) == null || (header = detailedLayout4.getHeader()) == null) ? null : header.getImageLink());
                ImageView ivMain = layoutMarketItemDetailsBinding.ivMain;
                Intrinsics.checkNotNullExpressionValue(ivMain, "ivMain");
                loadImage(strValueOf, ivMain);
                TextView textView2 = layoutMarketItemDetailsBinding.tvAttention;
                MarketItem.MarketItemAppearance appearance8 = marketItem.getAppearance();
                textView2.setText((appearance8 == null || (detailedLayout3 = appearance8.getDetailedLayout()) == null || (notice = detailedLayout3.getNotice()) == null) ? null : notice.getBody());
                TextView textView3 = layoutMarketItemDetailsBinding.tvTitleSub;
                MarketItem.MarketItemAppearance appearance9 = marketItem.getAppearance();
                if (appearance9 != null && (detailedLayout2 = appearance9.getDetailedLayout()) != null && (upcomingFeatures = detailedLayout2.getUpcomingFeatures()) != null) {
                    title = upcomingFeatures.getTitle();
                }
                textView3.setText(title);
                MarketItem.MarketItemAppearance appearance10 = marketItem.getAppearance();
                if (appearance10 == null || (detailedLayout = appearance10.getDetailedLayout()) == null || (button = detailedLayout.getButton()) == null) {
                    return;
                }
                binding.btnSubscribe.setText(button.getTitle());
                AppCompatButton btnSubscribe = binding.btnSubscribe;
                Intrinsics.checkNotNullExpressionValue(btnSubscribe, "btnSubscribe");
                SafeClickListenerKt.setSafeOnClickListener$default(btnSubscribe, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$renderUi$1$1$2$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        String marketItemId = this.this$0.getMarketItemId();
                        if (marketItemId != null) {
                            this.this$0.trackClickAnalytics(marketItemId);
                        }
                        IntentProcessingUtilsKt.handleDeeplink(button.getLink(), BundleKt.bundleOf(), this.this$0.getActivity(), this.this$0.getNavigationViewModel(), this.this$0.getProfileViewModel(), (64 & 32) != 0 ? null : this.this$0.getAnalytics(), (64 & 64) != 0 ? null : null);
                    }
                }, 1, null);
            }
        }
    }

    public ItemDetailsFragment() {
        super(R.layout.fragment_market_item_details);
        this.binding = new ViewBindingFragmentDelegate(this, ItemDetailsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.subscriptionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketItemId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.items.ItemDetailsFragment$marketItemId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("id") : null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackClickAnalytics(String identifier) {
        if (Intrinsics.areEqual(identifier, ItemsIds.licensed_keys.toString())) {
            getAnalytics().trackLogEvent(new KeysEvents.ClickGoCatalog());
        }
    }
}
