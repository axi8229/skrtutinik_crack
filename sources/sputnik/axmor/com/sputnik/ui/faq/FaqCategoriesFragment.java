package sputnik.axmor.com.sputnik.ui.faq;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.SupportNewEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.faq.FaqItem;
import com.sputnik.common.entities.faq.FaqQuestion;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.faq.FaqEmptyView;
import com.sputnik.common.entities.localization.entities.faq.FaqLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.FaqViewModel;
import com.sputnik.common.viewmodels.FaqViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentFaqCategoriesBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: FaqCategoriesFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010BR\u0016\u0010D\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010J\u001a\u0004\bS\u0010T¨\u0006V"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/domain/common/Event;", "", "categoryId", "Lcom/sputnik/domain/common/Event;", "subId", "Ljava/lang/Integer;", "", "targetCategoryId", "J", "targetSubcategoryId", "targetQuestionId", "", "hasProcessedNavigation", "Z", "Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel$delegate", "Lkotlin/Lazy;", "getFaqViewModel", "()Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel", "Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesAdapter;", "faqAdapter", "Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesAdapter;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaqCategoriesFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FaqCategoriesFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    private Event<Integer> categoryId;
    public MultiViewModelFactory factory;
    private FaqCategoriesAdapter faqAdapter;

    /* renamed from: faqViewModel$delegate, reason: from kotlin metadata */
    private final Lazy faqViewModel;
    private boolean hasProcessedNavigation;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;
    private Integer subId;
    public ISupportManager supportManager;
    private long targetCategoryId;
    private long targetQuestionId;
    private long targetSubcategoryId;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentFaqCategoriesBinding getBinding() {
        return (FragmentFaqCategoriesBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final FaqViewModel getFaqViewModel() {
        return (FaqViewModel) this.faqViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getNavController() {
        return (NavController) this.navController.getValue();
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
        getFaqViewModel().clearExpandState();
        Bundle arguments = getArguments();
        this.categoryId = new Event<>(arguments != null ? Integer.valueOf(arguments.getInt("id")) : null);
        Bundle arguments2 = getArguments();
        this.subId = arguments2 != null ? Integer.valueOf(arguments2.getInt("sub_id")) : null;
        Bundle arguments3 = getArguments();
        this.targetCategoryId = arguments3 != null ? arguments3.getLong("faq_category_id", -1L) : -1L;
        Bundle arguments4 = getArguments();
        this.targetSubcategoryId = arguments4 != null ? arguments4.getLong("faq_subcategory_id", -1L) : -1L;
        Bundle arguments5 = getArguments();
        this.targetQuestionId = arguments5 != null ? arguments5.getLong("faq_question_id", -1L) : -1L;
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        getFaqViewModel().loadFaqIfNeeded();
        FaqViewModel faqViewModel = getFaqViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        faqViewModel.observeState(viewLifecycleOwner, new Function1<FaqViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FaqViewState faqViewState) {
                invoke2(faqViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FaqViewState it) {
                Object next;
                Bundle bundleBundleOf;
                Integer id;
                Intrinsics.checkNotNullParameter(it, "it");
                List<FaqItem> faq2 = it.getFaq2();
                Object obj = null;
                if (faq2.isEmpty()) {
                    faq2 = null;
                }
                boolean z = true;
                if (faq2 != null) {
                    FaqCategoriesFragment faqCategoriesFragment = FaqCategoriesFragment.this;
                    faqCategoriesFragment.faqAdapter.submitList(faq2);
                    if (faqCategoriesFragment.targetCategoryId != -1 && !faqCategoriesFragment.hasProcessedNavigation) {
                        faqCategoriesFragment.hasProcessedNavigation = true;
                        Iterator<T> it2 = faq2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                            FaqItem faqItem = (FaqItem) next;
                            if (!(faqItem instanceof FaqItem.FaqCategory)) {
                                if ((faqItem instanceof FaqItem.FaqGroup) && (id = faqItem.getId()) != null && id.intValue() == faqCategoriesFragment.targetCategoryId) {
                                    break;
                                }
                            } else {
                                if (faqItem.getId() != null && r5.intValue() == faqCategoriesFragment.targetCategoryId) {
                                    break;
                                }
                            }
                        }
                        FaqItem faqItem2 = (FaqItem) next;
                        if (faqItem2 != null) {
                            if (faqItem2 instanceof FaqItem.FaqCategory) {
                                faqCategoriesFragment.getFaqViewModel().select(faqItem2);
                                if (faqCategoriesFragment.targetQuestionId != -1) {
                                    Iterator<T> it3 = ((FaqItem.FaqCategory) faqItem2).getQuestions().iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        Object next2 = it3.next();
                                        Long id2 = ((FaqQuestion) next2).getId();
                                        long j = faqCategoriesFragment.targetQuestionId;
                                        if (id2 != null && id2.longValue() == j) {
                                            obj = next2;
                                            break;
                                        }
                                    }
                                    FaqQuestion faqQuestion = (FaqQuestion) obj;
                                    if (faqQuestion != null) {
                                        faqQuestion.setExpanded(true);
                                    }
                                }
                                NavControllerKt.safeNavigate$default(faqCategoriesFragment.getNavController(), R.id.action_global_to_faqFragment, null, null, 6, null);
                            } else if (faqItem2 instanceof FaqItem.FaqGroup) {
                                faqCategoriesFragment.getFaqViewModel().selectCategory((FaqItem.FaqGroup) faqItem2);
                                if (faqCategoriesFragment.targetSubcategoryId != -1) {
                                    bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("faq_subcategory_id", Long.valueOf(faqCategoriesFragment.targetSubcategoryId)), TuplesKt.to("faq_question_id", Long.valueOf(faqCategoriesFragment.targetQuestionId)));
                                } else {
                                    bundleBundleOf = BundleKt.bundleOf();
                                }
                                NavControllerKt.safeNavigate$default(faqCategoriesFragment.getNavController(), R.id.action_global_to_faqSubcategoriesFragment, bundleBundleOf, null, 4, null);
                            }
                            faqCategoriesFragment.targetCategoryId = -1L;
                            faqCategoriesFragment.targetQuestionId = -1L;
                        }
                    }
                }
                LinearLayout layoutEmpty = FaqCategoriesFragment.this.getBinding().layoutEmpty;
                Intrinsics.checkNotNullExpressionValue(layoutEmpty, "layoutEmpty");
                ViewBindingUtilsKt.visibilityBasedOn(layoutEmpty, Boolean.valueOf(it.getFaq2().isEmpty() && (it.getServerState() == Resource.Status.SUCCESS || it.getServerState() == Resource.Status.ERROR)));
                RecyclerView rvNotifications = FaqCategoriesFragment.this.getBinding().rvNotifications;
                Intrinsics.checkNotNullExpressionValue(rvNotifications, "rvNotifications");
                if (it.getFaq2().isEmpty() || (it.getServerState() != Resource.Status.SUCCESS && it.getServerState() != Resource.Status.ERROR)) {
                    z = false;
                }
                ViewBindingUtilsKt.visibilityBasedOn(rvNotifications, Boolean.valueOf(z));
            }
        });
        FaqViewModel faqViewModel2 = getFaqViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        faqViewModel2.observeSubState(viewLifecycleOwner2, new Function1<FaqViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(FaqViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment.onViewCreated.3
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
                LinearLayout layoutLoader = FaqCategoriesFragment.this.getBinding().layoutLoader;
                Intrinsics.checkNotNullExpressionValue(layoutLoader, "layoutLoader");
                ViewBindingUtilsKt.visibilityBasedOn(layoutLoader, Boolean.valueOf(it == Resource.Status.LOADING));
            }
        });
        Toolbar toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar2, true, true, true, false, 8, null);
        Toolbar toolbar3 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar3, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar3, true, true, true, false, 8, null);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        RecyclerView recyclerView = getBinding().rvNotifications;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.faqAdapter);
    }

    public FaqCategoriesFragment() {
        super(R.layout.fragment_faq_categories);
        this.binding = new ViewBindingFragmentDelegate(this, FaqCategoriesFragment$binding$2.INSTANCE);
        this.targetCategoryId = -1L;
        this.targetSubcategoryId = -1L;
        this.targetQuestionId = -1L;
        final Function0 function0 = null;
        this.faqViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FaqViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment$faqViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.faqAdapter = new FaqCategoriesAdapter(new Function1<FaqItem, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment$faqAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FaqItem faqItem) {
                invoke2(faqItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FaqItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackNewEvent(new SupportNewEvents.ClickSupportCategory(String.valueOf(it.getId())));
                if (it instanceof FaqItem.FaqCategory) {
                    this.this$0.getFaqViewModel().select(it);
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_faqFragment, null, null, 6, null);
                } else if (it instanceof FaqItem.FaqGroup) {
                    this.this$0.getFaqViewModel().selectCategory((FaqItem.FaqGroup) it);
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_faqSubcategoriesFragment, BundleKt.bundleOf(), null, 4, null);
                }
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqCategoriesFragment$navController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavController invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                return ActivityKt.findNavController(fragmentActivityRequireActivity, R.id.root_nav_host_fragment);
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        String toolbar;
        String title;
        FaqEmptyView emptyView;
        String subtitle;
        FaqEmptyView emptyView2;
        LocalizationLocalModel data;
        FragmentFaqCategoriesBinding binding = getBinding();
        LocalizationStorage localizationScreen = getLocalizationScreen();
        FaqLocale faq = (localizationScreen == null || (data = localizationScreen.getData()) == null) ? null : data.getFaq();
        Toolbar toolbar2 = binding.toolbar;
        String str = "";
        if (faq == null || (toolbar = faq.getToolbar()) == null) {
            toolbar = "";
        }
        toolbar2.setTitle(toolbar);
        TextView textView = binding.tvEmptyTitle;
        if (faq == null || (emptyView2 = faq.getEmptyView()) == null || (title = emptyView2.getTitle()) == null) {
            title = "";
        }
        textView.setText(title);
        TextView textView2 = binding.tvEmptySubtitle;
        if (faq != null && (emptyView = faq.getEmptyView()) != null && (subtitle = emptyView.getSubtitle()) != null) {
            str = subtitle;
        }
        textView2.setText(str);
    }
}
