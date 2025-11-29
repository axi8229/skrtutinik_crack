package sputnik.axmor.com.sputnik.ui.faq;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
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
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.FaqViewModel;
import com.sputnik.common.viewmodels.FaqViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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

/* compiled from: FaqSubcategoriesFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00105\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/faq/FaqSubcategoriesFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel$delegate", "Lkotlin/Lazy;", "getFaqViewModel", "()Lcom/sputnik/common/viewmodels/FaqViewModel;", "faqViewModel", "", "targetCategoryId", "J", "targetSubCategoryId", "targetQuestionId", "", "hasProcessedNavigation", "Z", "Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesAdapter;", "faqAdapter", "Lsputnik/axmor/com/sputnik/ui/faq/FaqCategoriesAdapter;", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaqSubcategoriesFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FaqSubcategoriesFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    private FaqCategoriesAdapter faqAdapter;

    /* renamed from: faqViewModel$delegate, reason: from kotlin metadata */
    private final Lazy faqViewModel;
    private boolean hasProcessedNavigation;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;
    public ISupportManager supportManager;
    private long targetCategoryId;
    private long targetQuestionId;
    private long targetSubCategoryId;

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
        if (!this.hasProcessedNavigation) {
            Bundle arguments = getArguments();
            this.targetCategoryId = arguments != null ? arguments.getLong("faq_category_id", -1L) : -1L;
            Bundle arguments2 = getArguments();
            this.targetQuestionId = arguments2 != null ? arguments2.getLong("faq_question_id", -1L) : -1L;
            Bundle arguments3 = getArguments();
            this.targetSubCategoryId = arguments3 != null ? arguments3.getLong("faq_subcategory_id", -1L) : -1L;
        }
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        FaqViewModel faqViewModel = getFaqViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        faqViewModel.observeState(viewLifecycleOwner, new Function1<FaqViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment.onViewCreated.1
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
                FaqItem.FaqCategory faqCategory;
                Object next2;
                Intrinsics.checkNotNullParameter(it, "it");
                Toolbar toolbar2 = FaqSubcategoriesFragment.this.getBinding().toolbar;
                FaqItem.FaqGroup selectedSubcategory = it.getSelectedSubcategory();
                Object obj = null;
                toolbar2.setTitle(selectedSubcategory != null ? selectedSubcategory.getTitle() : null);
                FaqItem.FaqGroup selectedSubcategory2 = it.getSelectedSubcategory();
                boolean z = true;
                if (selectedSubcategory2 != null) {
                    FaqSubcategoriesFragment faqSubcategoriesFragment = FaqSubcategoriesFragment.this;
                    List<FaqItem.FaqCategory> subcategories = selectedSubcategory2.getSubcategories();
                    faqSubcategoriesFragment.faqAdapter.submitList(subcategories);
                    if ((faqSubcategoriesFragment.targetCategoryId != -1 || faqSubcategoriesFragment.targetSubCategoryId != -1) && !faqSubcategoriesFragment.hasProcessedNavigation) {
                        faqSubcategoriesFragment.hasProcessedNavigation = true;
                        if (faqSubcategoriesFragment.targetSubCategoryId != -1) {
                            Iterator<T> it2 = subcategories.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                                if (((FaqItem.FaqCategory) next2).getId() != null && r5.intValue() == faqSubcategoriesFragment.targetSubCategoryId) {
                                    break;
                                }
                            }
                            faqCategory = (FaqItem.FaqCategory) next2;
                        } else {
                            Iterator<T> it3 = subcategories.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it3.next();
                                if (((FaqItem.FaqCategory) next).getId() != null && r5.intValue() == faqSubcategoriesFragment.targetCategoryId) {
                                    break;
                                }
                            }
                            faqCategory = (FaqItem.FaqCategory) next;
                        }
                        if (faqCategory != null) {
                            faqSubcategoriesFragment.getFaqViewModel().select(faqCategory);
                            if (faqSubcategoriesFragment.targetQuestionId != -1) {
                                Iterator<T> it4 = faqCategory.getQuestions().iterator();
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    Object next3 = it4.next();
                                    Long id = ((FaqQuestion) next3).getId();
                                    long j = faqSubcategoriesFragment.targetQuestionId;
                                    if (id != null && id.longValue() == j) {
                                        obj = next3;
                                        break;
                                    }
                                }
                                FaqQuestion faqQuestion = (FaqQuestion) obj;
                                if (faqQuestion != null) {
                                    faqQuestion.setExpanded(true);
                                }
                            }
                            NavControllerKt.safeNavigate$default(faqSubcategoriesFragment.getNavController(), R.id.action_global_to_faqFragment, null, null, 6, null);
                        }
                        faqSubcategoriesFragment.targetCategoryId = -1L;
                        faqSubcategoriesFragment.targetQuestionId = -1L;
                    }
                }
                LinearLayout layoutEmpty = FaqSubcategoriesFragment.this.getBinding().layoutEmpty;
                Intrinsics.checkNotNullExpressionValue(layoutEmpty, "layoutEmpty");
                ViewBindingUtilsKt.visibilityBasedOn(layoutEmpty, Boolean.valueOf(it.getFaq2().isEmpty() && (it.getServerState() == Resource.Status.SUCCESS || it.getServerState() == Resource.Status.ERROR)));
                RecyclerView rvNotifications = FaqSubcategoriesFragment.this.getBinding().rvNotifications;
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
        faqViewModel2.observeSubState(viewLifecycleOwner2, new Function1<FaqViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(FaqViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment.onViewCreated.3
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
                LinearLayout layoutLoader = FaqSubcategoriesFragment.this.getBinding().layoutLoader;
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

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }

    public FaqSubcategoriesFragment() {
        super(R.layout.fragment_faq_categories);
        this.binding = new ViewBindingFragmentDelegate(this, FaqSubcategoriesFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.faqViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FaqViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment$faqViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.targetCategoryId = -1L;
        this.targetSubCategoryId = -1L;
        this.targetQuestionId = -1L;
        this.faqAdapter = new FaqCategoriesAdapter(new Function1<FaqItem, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment$faqAdapter$1
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
                this.this$0.getAnalytics().trackNewEvent(new SupportNewEvents.ClickSupportSubcategory(String.valueOf(it.getId())));
                if (it instanceof FaqItem.FaqCategory) {
                    this.this$0.getFaqViewModel().select(it);
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_faqFragment, null, null, 6, null);
                } else if (it instanceof FaqItem.FaqGroup) {
                    NavControllerKt.safeNavigate$default(this.this$0.getNavController(), R.id.action_global_to_faqCategoriesFragment, BundleKt.bundleOf(), null, 4, null);
                }
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.faq.FaqSubcategoriesFragment$navController$2
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
}
