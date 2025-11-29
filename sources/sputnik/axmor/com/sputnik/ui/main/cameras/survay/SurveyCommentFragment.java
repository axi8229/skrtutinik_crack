package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.FeedbackCommentBody;
import com.sputnik.common.entities.localization.FeedbackCommentLocale;
import com.sputnik.common.entities.localization.FeedbackCommentNavigation;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextPlaceHolder;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentCommentSurveyBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewModel;
import sputnik.axmor.com.sputnik.ui.main.cameras.survay.viewmodel.SurveyViewState;

/* compiled from: SurveyCommentFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/SurveyCommentFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewState;)V", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lsputnik/axmor/com/databinding/FragmentCommentSurveyBinding;", "kotlin.jvm.PlatformType", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentCommentSurveyBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "surveyViewModel$delegate", "Lkotlin/Lazy;", "getSurveyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewModel;", "surveyViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurveyCommentFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SurveyCommentFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentCommentSurveyBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: surveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveyViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentCommentSurveyBinding getBinding() {
        return (FragmentCommentSurveyBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final SurveyViewModel getSurveyViewModel() {
        return (SurveyViewModel) this.surveyViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
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
        SurveyViewModel surveyViewModel = getSurveyViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        surveyViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        initView();
    }

    /* compiled from: SurveyCommentFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SurveyViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, SurveyCommentFragment.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/main/cameras/survay/viewmodel/SurveyViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SurveyViewState surveyViewState) {
            invoke2(surveyViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SurveyViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SurveyCommentFragment) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(SurveyViewState data) {
        if (data.getCommentText().length() <= 0 || Intrinsics.areEqual(getBinding().etTextComment.getText().toString(), data.getCommentText())) {
            return;
        }
        getBinding().etTextComment.setText(data.getCommentText());
    }

    private final void initView() {
        EditText etTextComment = getBinding().etTextComment;
        Intrinsics.checkNotNullExpressionValue(etTextComment, "etTextComment");
        etTextComment.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment$initView$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getSurveyViewModel().handleComment(String.valueOf(s));
                this.this$0.getBinding().acceptButton.setEnabled(s != null ? !StringsKt.isBlank(s) : false);
            }
        });
        getBinding().acceptButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyCommentFragment.initView$lambda$1(this.f$0, view);
            }
        });
        LinearLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToMargin(rootView, true, true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SurveyCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view);
        ViewKt.hideKeyboard(view);
        FragmentKt.findNavController(this$0).navigateUp();
    }

    private final void localize() {
        FeedbackCommentLocale feedbackComment;
        TextTitle applyButton;
        TextPlaceHolder textField;
        TextPlaceHolder textField2;
        FragmentCommentSurveyBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (feedbackComment = data.getFeedbackComment()) == null) {
            return;
        }
        Toolbar toolbar = binding.toolbarSurvey;
        FeedbackCommentNavigation navigation = feedbackComment.getNavigation();
        String title = null;
        toolbar.setTitle(navigation != null ? navigation.getTitle() : null);
        TextView textView = binding.etHeader;
        FeedbackCommentBody body = feedbackComment.getBody();
        textView.setText((body == null || (textField2 = body.getTextField()) == null) ? null : textField2.getTitle());
        EditText editText = binding.etTextComment;
        FeedbackCommentBody body2 = feedbackComment.getBody();
        editText.setHint((body2 == null || (textField = body2.getTextField()) == null) ? null : textField.getPlaceholder());
        AppCompatButton appCompatButton = binding.acceptButton;
        FeedbackCommentNavigation navigation2 = feedbackComment.getNavigation();
        if (navigation2 != null && (applyButton = navigation2.getApplyButton()) != null) {
            title = applyButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    public SurveyCommentFragment() {
        super(R.layout.fragment_comment_survey);
        this.binding = new ViewBindingFragmentDelegate(this, SurveyCommentFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.surveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.survay.SurveyCommentFragment$surveyViewModel$2
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
