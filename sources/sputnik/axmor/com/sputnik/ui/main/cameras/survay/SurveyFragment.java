package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.FeedBackBody;
import com.sputnik.common.entities.localization.FeedBackLocale;
import com.sputnik.common.entities.localization.FeedBackNavigation;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.SendButtonSurvey;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Event;
import java.util.Iterator;
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
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSurveyBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewState;

/* compiled from: SurveyFragment.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R!\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentSurveyBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSurveyBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "viewModelSurvey$delegate", "Lkotlin/Lazy;", "getViewModelSurvey", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "viewModelSurvey", "", "Landroid/widget/CheckedTextView;", "checkButtons$delegate", "getCheckButtons", "()[Landroid/widget/CheckedTextView;", "checkButtons", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurveyFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SurveyFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSurveyBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: checkButtons$delegate, reason: from kotlin metadata */
    private final Lazy checkButtons;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: viewModelSurvey$delegate, reason: from kotlin metadata */
    private final Lazy viewModelSurvey;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSurveyBinding getBinding() {
        return (FragmentSurveyBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final SurveyViewModel getViewModelSurvey() {
        return (SurveyViewModel) this.viewModelSurvey.getValue();
    }

    private final CheckedTextView[] getCheckButtons() {
        return (CheckedTextView[]) this.checkButtons.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        Toolbar toolbarSurvey = getBinding().toolbarSurvey;
        Intrinsics.checkNotNullExpressionValue(toolbarSurvey, "toolbarSurvey");
        ToolbarKt.setupWithNavController$default(toolbarSurvey, FragmentKt.findNavController(this), null, 2, null);
        SurveyViewModel viewModelSurvey = getViewModelSurvey();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModelSurvey.observeSubState(viewLifecycleOwner, new Function1<SurveyViewState, String>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment.onViewCreated.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(SurveyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCommentText();
            }
        }, new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (Intrinsics.areEqual(it, SurveyFragment.this.getBinding().etComment.getText().toString())) {
                    return;
                }
                SurveyFragment.this.getBinding().etComment.setText(it);
            }
        });
        SurveyViewModel viewModelSurvey2 = getViewModelSurvey();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        viewModelSurvey2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment.onViewCreated.3
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
                SurveyFragment surveyFragment = SurveyFragment.this;
                LinearLayout root = surveyFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(surveyFragment, root, it);
            }
        });
        SurveyViewModel viewModelSurvey3 = getViewModelSurvey();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        viewModelSurvey3.observeSubState(viewLifecycleOwner3, new Function1<SurveyViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SurveyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSurveyIsSent();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
                FeedBackLocale feedbackMain;
                FeedBackBody body;
                SendButtonSurvey sendButton;
                String feedbackSend;
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    SurveyFragment surveyFragment = SurveyFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        LocalizationLocalModel data = surveyFragment.getLocalizationScreen().getData();
                        if (data != null && (feedbackMain = data.getFeedbackMain()) != null && (body = feedbackMain.getBody()) != null && (sendButton = body.getSendButton()) != null && (feedbackSend = sendButton.getFeedbackSend()) != null) {
                            surveyFragment.getViewModelSurvey().notifySuccessMessage(feedbackSend);
                        }
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(surveyFragment), R.id.surveyFragment, R.id.action_surveyFragment_to_surveyFinishFragment, null, null, 12, null);
                    }
                }
            }
        });
        initView();
    }

    private final void initView() {
        FragmentSurveyBinding binding = getBinding();
        Iterator<T> it = getViewModelSurvey().getCurrentState().getMarks().iterator();
        while (it.hasNext()) {
            getCheckButtons()[((Number) it.next()).intValue()].toggle();
        }
        binding.cbFunctions.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.initView$lambda$8$lambda$1(this.f$0, view);
            }
        });
        binding.cbUncomfortable.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.initView$lambda$8$lambda$2(this.f$0, view);
            }
        });
        binding.cbNoneCalls.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.initView$lambda$8$lambda$3(this.f$0, view);
            }
        });
        binding.cbOther.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.initView$lambda$8$lambda$4(this.f$0, view);
            }
        });
        binding.etComment.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SurveyFragment.initView$lambda$8$lambda$5(this.f$0, view);
            }
        });
        binding.btnSend.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.initView$lambda$8$lambda$7(this.f$0, view);
            }
        });
        Toolbar toolbarSurvey = binding.toolbarSurvey;
        Intrinsics.checkNotNullExpressionValue(toolbarSurvey, "toolbarSurvey");
        ViewKt.addSystemWindowInsetToMargin$default(toolbarSurvey, true, true, true, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$1(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckedTextView");
        CheckedTextView checkedTextView = (CheckedTextView) view;
        checkedTextView.toggle();
        this$0.getViewModelSurvey().updateMark(checkedTextView.isChecked(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$2(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckedTextView");
        CheckedTextView checkedTextView = (CheckedTextView) view;
        checkedTextView.toggle();
        this$0.getViewModelSurvey().updateMark(checkedTextView.isChecked(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$3(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckedTextView");
        CheckedTextView checkedTextView = (CheckedTextView) view;
        checkedTextView.toggle();
        this$0.getViewModelSurvey().updateMark(checkedTextView.isChecked(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$4(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckedTextView");
        CheckedTextView checkedTextView = (CheckedTextView) view;
        checkedTextView.toggle();
        this$0.getViewModelSurvey().updateMark(checkedTextView.isChecked(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$5(SurveyFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.surveyFragment, R.id.action_surveyFragment_to_surveyCommentFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7(SurveyFragment this$0, View view) {
        FeedBackLocale feedbackMain;
        FeedBackBody body;
        SendButtonSurvey sendButton;
        String emptyFields;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getViewModelSurvey().getCurrentState().getMarks().isEmpty() || !StringsKt.isBlank(this$0.getViewModelSurvey().getCurrentState().getCommentText())) {
            this$0.getViewModelSurvey().sendSurvey(false);
            return;
        }
        LocalizationLocalModel data = this$0.getLocalizationScreen().getData();
        if (data == null || (feedbackMain = data.getFeedbackMain()) == null || (body = feedbackMain.getBody()) == null || (sendButton = body.getSendButton()) == null || (emptyFields = sendButton.getEmptyFields()) == null) {
            return;
        }
        this$0.getViewModelSurvey().notifyErrorMessage(emptyFields);
    }

    private final void localize() {
        SendButtonSurvey sendButton;
        TextPlaceHolder commentView;
        TextPlaceHolder commentView2;
        FeedBackLocale feedbackMain;
        FeedBackLocale feedbackMain2;
        FeedBackNavigation navigation;
        FragmentSurveyBinding binding = getBinding();
        Toolbar toolbar = binding.toolbarSurvey;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        toolbar.setTitle((data == null || (feedbackMain2 = data.getFeedbackMain()) == null || (navigation = feedbackMain2.getNavigation()) == null) ? null : navigation.getTitle());
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        FeedBackBody body = (data2 == null || (feedbackMain = data2.getFeedbackMain()) == null) ? null : feedbackMain.getBody();
        binding.surveyHeader.setText(body != null ? body.getTitle() : null);
        binding.cbFunctions.setText(body != null ? body.getSubtitle1() : null);
        binding.cbUncomfortable.setText(body != null ? body.getSubtitle2() : null);
        binding.cbNoneCalls.setText(body != null ? body.getSubtitle3() : null);
        binding.cbOther.setText(body != null ? body.getSubtitle4() : null);
        binding.etHeader.setText((body == null || (commentView2 = body.getCommentView()) == null) ? null : commentView2.getTitle());
        binding.etComment.setText((body == null || (commentView = body.getCommentView()) == null) ? null : commentView.getPlaceholder());
        AppCompatButton appCompatButton = binding.btnSend;
        if (body != null && (sendButton = body.getSendButton()) != null) {
            title = sendButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    public SurveyFragment() {
        super(R.layout.fragment_survey);
        this.binding = new ViewBindingFragmentDelegate(this, SurveyFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.viewModelSurvey = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$viewModelSurvey$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.checkButtons = LazyKt.lazy(new Function0<CheckedTextView[]>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyFragment$checkButtons$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CheckedTextView[] invoke() {
                return new CheckedTextView[]{this.this$0.getBinding().cbOther, this.this$0.getBinding().cbFunctions, this.this$0.getBinding().cbUncomfortable, this.this$0.getBinding().cbNoneCalls};
            }
        });
    }
}
