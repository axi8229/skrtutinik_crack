package com.sputnik.oboarding.ui.localization;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.ChooseLanguageBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.ChooseLanguageLocale;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.ChooseLanguageReadyButton;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Resource;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentStartChooseLanguageBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.localization.adapter.LocalizationAdapter;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* compiled from: ChooseRegLanguageFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/sputnik/oboarding/ui/localization/ChooseRegLanguageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/LocalizationViewState;", "serverData", "", "renderUi", "(Lcom/sputnik/common/viewmodels/LocalizationViewState;)V", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentStartChooseLanguageBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentStartChooseLanguageBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "Lkotlin/Lazy;", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChooseRegLanguageFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ChooseRegLanguageFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentStartChooseLanguageBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* compiled from: ChooseRegLanguageFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            try {
                iArr[Resource.Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final FragmentStartChooseLanguageBinding getBinding() {
        return (FragmentStartChooseLanguageBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
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
    public final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initView();
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        localizationViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
    }

    /* compiled from: ChooseRegLanguageFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LocalizationViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, ChooseRegLanguageFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/LocalizationViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LocalizationViewState localizationViewState) {
            invoke2(localizationViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LocalizationViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ChooseRegLanguageFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: ChooseRegLanguageFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$renderUi$1", f = "ChooseRegLanguageFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$renderUi$1, reason: invalid class name and case insensitive filesystem */
    static final class C07471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07471(Continuation<? super C07471> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChooseRegLanguageFragment.this.new C07471(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChooseRegLanguageFragment.this.localize();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(LocalizationViewState serverData) {
        if (serverData.isLoaded().peekContent().booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C07471(null), 3, null);
        }
        if (WhenMappings.$EnumSwitchMapping$0[serverData.getState().ordinal()] == 1) {
            List<Localization> localizationList = serverData.getLocalizationList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(localizationList, 10));
            for (Localization localizationCopy : localizationList) {
                if (Intrinsics.areEqual(localizationCopy.getTag(), serverData.getCurrentTag())) {
                    localizationCopy = localizationCopy.copy((191 & 1) != 0 ? localizationCopy.id : null, (191 & 2) != 0 ? localizationCopy.tag : null, (191 & 4) != 0 ? localizationCopy.createdAt : null, (191 & 8) != 0 ? localizationCopy.name : null, (191 & 16) != 0 ? localizationCopy.platform : null, (191 & 32) != 0 ? localizationCopy.file : null, (191 & 64) != 0 ? localizationCopy.current : true, (191 & 128) != 0 ? localizationCopy.flag : 0);
                }
                arrayList.add(localizationCopy);
            }
            RecyclerView.Adapter adapter = getBinding().rvLanguages.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.sputnik.oboarding.ui.localization.adapter.LocalizationAdapter");
            ((LocalizationAdapter) adapter).submitList(arrayList);
        }
    }

    private final void initView() {
        getBinding().btnAccept.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ChooseRegLanguageFragment.initView$lambda$1(this.f$0, view);
            }
        });
        RecyclerView recyclerView = getBinding().rvLanguages;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new LocalizationAdapter(new Function1<Localization, Unit>() { // from class: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$initView$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Localization localization) throws Resources.NotFoundException {
                invoke2(localization);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Localization selectedLocale) throws Resources.NotFoundException {
                Object next;
                Intrinsics.checkNotNullParameter(selectedLocale, "selectedLocale");
                Iterator<T> it = this.this$0.getLocalizationViewModel().getCurrentState().getLocalizationList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((Localization) next).getTag(), selectedLocale.getTag())) {
                            break;
                        }
                    }
                }
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R$id.startChooseLanguageFragment, R$id.action_startChooseLanguageFragment_to_startChooseLanguageBottomSheet, BundleKt.bundleOf(TuplesKt.to(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, (Localization) next)), null, 8, null);
            }
        }));
        CoordinatorLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ChooseRegLanguageFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.ChooseLanguageDoneEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.startChooseLanguageFragment, R$id.action_startChooseLanguageFragment_to_finishSplashFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void localize() {
        ChooseLanguageLocale chooseLanguage;
        ChooseLanguageBody body;
        ChooseLanguageReadyButton readyButton;
        List<String> titles;
        ChooseLanguageLocale chooseLanguage2;
        ChooseLanguageBody body2;
        List<String> titles2;
        FragmentStartChooseLanguageBinding binding = getBinding();
        TextView textView = binding.title;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String str = null;
        textView.setText((data == null || (chooseLanguage2 = data.getChooseLanguage()) == null || (body2 = chooseLanguage2.getBody()) == null || (titles2 = body2.getTitles()) == null) ? null : (String) CollectionsKt.first((List) titles2));
        AppCompatButton appCompatButton = binding.btnAccept;
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 != null && (chooseLanguage = data2.getChooseLanguage()) != null && (body = chooseLanguage.getBody()) != null && (readyButton = body.getReadyButton()) != null && (titles = readyButton.getTitles()) != null) {
            str = (String) CollectionsKt.first((List) titles);
        }
        appCompatButton.setText(str);
    }

    public ChooseRegLanguageFragment() {
        super(R$layout.fragment_start_choose_language);
        this.binding = new ViewBindingFragmentDelegate(this, ChooseRegLanguageFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.localization.ChooseRegLanguageFragment$localizationViewModel$2
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
