package sputnik.axmor.com.sputnik.ui.polls;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.alerts.Button;
import com.sputnik.common.entities.localization.FeedbackCommentLocale;
import com.sputnik.common.entities.localization.FeedbackCommentNavigation;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.surveys.Survey;
import com.sputnik.common.entities.surveys.SurveyOption;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import com.sputnik.common.viewmodels.SurveysState;
import com.sputnik.common.viewmodels.SurveysViewModel;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.survey.DomainSurveyResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widgetV2.dialog.BottomSheetDialogExtentionsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetRatePollBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.polls.adapters.CheckBoxAdapter;
import sputnik.axmor.com.sputnik.ui.polls.adapters.ReasonItem;

/* compiled from: BottomSheetRatePoll.kt */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0019\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00150\n2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010\u0004J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bF\u00103\u001a\u0004\bG\u00105\"\u0004\bH\u00107R\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001b\u0010c\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010[\u001a\u0004\ba\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetRatePoll;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetRatePollBinding;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/SurveysState;", "state", "", "renderSurveys", "(Lcom/sputnik/common/viewmodels/SurveysState;)V", "", "Lcom/sputnik/common/entities/surveys/SurveyOption;", "options", "", "multiOptions", "renderOptions", "(Ljava/util/List;Z)V", "Lcom/sputnik/common/entities/surveys/Survey$RichBody;", "richBody", "renderNotice", "(Lcom/sputnik/common/entities/surveys/Survey$RichBody;)V", "Lcom/sputnik/common/entities/alerts/Button;", "needDelay", "", "delay", "renderButtons", "(Ljava/util/List;ZJ)V", "", "rate", "onStarChanged", "(I)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "localizationScreen", "getLocalizationScreen", "setLocalizationScreen", "currentRate", "I", "Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetRatePoll$PollTypes;", "currentPollType", "Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetRatePoll$PollTypes;", "Lcom/sputnik/common/entities/surveys/Survey;", "currentSurvey", "Lcom/sputnik/common/entities/surveys/Survey;", "otherFieldChosen", "Z", "", "closeBtnTitle", "Ljava/lang/String;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel$delegate", "Lkotlin/Lazy;", "getSurveysViewModel", "()Lcom/sputnik/common/viewmodels/SurveysViewModel;", "surveysViewModel", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter;", "reasonsAdapter", "Lsputnik/axmor/com/sputnik/ui/polls/adapters/CheckBoxAdapter;", "Ljava/lang/Runnable;", "delayedTask", "Ljava/lang/Runnable;", "PollTypes", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetRatePoll extends BaseBottomSheetDialogFragment<BottomSheetRatePollBinding> {
    public Analytics analytics;
    private String closeBtnTitle;
    private PollTypes currentPollType;
    private int currentRate;
    private Survey currentSurvey;
    private final Runnable delayedTask;
    public MultiViewModelFactory factory;
    private final Handler handler;
    public LocalizationStorage localizationScreen;
    public LocalizationStorage localizationStorage;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;
    private boolean otherFieldChosen;
    private CheckBoxAdapter reasonsAdapter;

    /* renamed from: surveysViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveysViewModel;

    /* compiled from: BottomSheetRatePoll.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PollTypes.values().length];
            try {
                iArr[PollTypes.POLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PollTypes.RATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ BottomSheetRatePollBinding access$getBinding(BottomSheetRatePoll bottomSheetRatePoll) {
        return bottomSheetRatePoll.getBinding();
    }

    /* compiled from: BottomSheetRatePoll.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetRatePollBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetRatePollBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetRatePollBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetRatePollBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetRatePollBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetRatePollBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetRatePoll() {
        super(AnonymousClass1.INSTANCE);
        this.currentPollType = PollTypes.POLL;
        this.closeBtnTitle = "";
        this.handler = new Handler(Looper.getMainLooper());
        final Function0 function0 = null;
        this.surveysViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SurveysViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$surveysViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$onboardingViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.delayedTask = new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BottomSheetRatePoll.delayedTask$lambda$21(this.f$0);
            }
        };
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BottomSheetRatePoll.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/polls/BottomSheetRatePoll$PollTypes;", "", "(Ljava/lang/String;I)V", "RATE", "POLL", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PollTypes {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PollTypes[] $VALUES;
        public static final PollTypes RATE = new PollTypes("RATE", 0);
        public static final PollTypes POLL = new PollTypes("POLL", 1);

        private static final /* synthetic */ PollTypes[] $values() {
            return new PollTypes[]{RATE, POLL};
        }

        public static PollTypes valueOf(String str) {
            return (PollTypes) Enum.valueOf(PollTypes.class, str);
        }

        public static PollTypes[] values() {
            return (PollTypes[]) $VALUES.clone();
        }

        private PollTypes(String str, int i) {
        }

        static {
            PollTypes[] pollTypesArr$values = $values();
            $VALUES = pollTypesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pollTypesArr$values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SurveysViewModel getSurveysViewModel() {
        return (SurveysViewModel) this.surveysViewModel.getValue();
    }

    private final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.DialogStyle);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setCancelable(false);
        BottomSheetDialogExtentionsKt.getBehavior(this).setDraggable(false);
        getSurveysViewModel().lockSurveys();
        SurveysViewModel surveysViewModel = getSurveysViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        surveysViewModel.observeState(viewLifecycleOwner, new C27011(this));
        SurveysViewModel surveysViewModel2 = getSurveysViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        surveysViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.onViewCreated.2
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
                BottomSheetRatePoll bottomSheetRatePoll = BottomSheetRatePoll.this;
                LinearLayout root = BottomSheetRatePoll.access$getBinding(bottomSheetRatePoll).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(bottomSheetRatePoll, root, it);
            }
        });
        SurveysViewModel surveysViewModel3 = getSurveysViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        surveysViewModel3.observeSubState(viewLifecycleOwner3, new Function1<SurveysState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(SurveysState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.onViewCreated.4

            /* compiled from: BottomSheetRatePoll.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$onViewCreated$4$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                if (WhenMappings.$EnumSwitchMapping$0[it.ordinal()] == 1) {
                    LinearLayout layoutProgress = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).layoutProgress;
                    Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                    ViewKt.visible(layoutProgress);
                    ScrollView layoutContent = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).layoutContent;
                    Intrinsics.checkNotNullExpressionValue(layoutContent, "layoutContent");
                    ViewKt.gone(layoutContent);
                    return;
                }
                LinearLayout layoutProgress2 = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).layoutProgress;
                Intrinsics.checkNotNullExpressionValue(layoutProgress2, "layoutProgress");
                ViewKt.gone(layoutProgress2);
                ScrollView layoutContent2 = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).layoutContent;
                Intrinsics.checkNotNullExpressionValue(layoutContent2, "layoutContent");
                ViewKt.visible(layoutContent2);
            }
        });
        SurveysViewModel surveysViewModel4 = getSurveysViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        surveysViewModel4.observeSubState(viewLifecycleOwner4, new Function1<SurveysState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(SurveysState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getUploadResultState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.onViewCreated.6

            /* compiled from: BottomSheetRatePoll.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$onViewCreated$6$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                SurveysState currentState;
                DomainSurveyResult uploadResultData;
                Integer starsCount;
                Survey survey;
                List<Button> buttons;
                String title;
                Survey survey2;
                List<Button> buttons2;
                String title2;
                Intrinsics.checkNotNullParameter(it, "it");
                int i = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                if (i == 1) {
                    AppCompatButton btnApply = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).btnApply;
                    Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                    ButtonsExtensionsKt.showProgress$default(btnApply, 0, 1, null);
                    return;
                }
                String str = "";
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    AppCompatButton btnApply2 = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).btnApply;
                    Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                    List<Survey> surveys = BottomSheetRatePoll.this.getSurveysViewModel().getCurrentState().getSurveys();
                    if (surveys != null && (survey2 = (Survey) CollectionsKt.firstOrNull((List) surveys)) != null && (buttons2 = survey2.getButtons()) != null) {
                        Iterator<T> it2 = buttons2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.areEqual(((Button) next).getDeeplink(), "send")) {
                                obj = next;
                                break;
                            }
                        }
                        Button button = (Button) obj;
                        if (button != null && (title2 = button.getTitle()) != null) {
                            str = title2;
                        }
                    }
                    ButtonsExtensionsKt.hideProgress(btnApply2, str);
                    return;
                }
                SurveysViewModel surveysViewModel5 = BottomSheetRatePoll.this.getSurveysViewModel();
                if (surveysViewModel5 != null && (currentState = surveysViewModel5.getCurrentState()) != null && (uploadResultData = currentState.getUploadResultData()) != null && (starsCount = uploadResultData.getStarsCount()) != null && starsCount.intValue() == 0) {
                    BottomSheetRatePoll.this.dismiss();
                    AppCompatButton btnApply3 = BottomSheetRatePoll.access$getBinding(BottomSheetRatePoll.this).btnApply;
                    Intrinsics.checkNotNullExpressionValue(btnApply3, "btnApply");
                    List<Survey> surveys2 = BottomSheetRatePoll.this.getSurveysViewModel().getCurrentState().getSurveys();
                    if (surveys2 != null && (survey = (Survey) CollectionsKt.firstOrNull((List) surveys2)) != null && (buttons = survey.getButtons()) != null) {
                        Iterator<T> it3 = buttons.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            Object next2 = it3.next();
                            if (Intrinsics.areEqual(((Button) next2).getDeeplink(), "send")) {
                                obj = next2;
                                break;
                            }
                        }
                        Button button2 = (Button) obj;
                        if (button2 != null && (title = button2.getTitle()) != null) {
                            str = title;
                        }
                    }
                    ButtonsExtensionsKt.hideProgress(btnApply3, str);
                } else {
                    NavController navControllerFindNavController = FragmentKt.findNavController(BottomSheetRatePoll.this);
                    Pair pair = TuplesKt.to("need_to_open_market", Boolean.valueOf(BottomSheetRatePoll.this.currentRate == 5 || BottomSheetRatePoll.this.currentRate == 4));
                    Survey survey3 = BottomSheetRatePoll.this.currentSurvey;
                    NavControllerKt.safeNavigate$default(navControllerFindNavController, R.id.action_bottomSheetPoll_to_bottomSheetPollSuccess, BundleKt.bundleOf(pair, TuplesKt.to("is_from_review", Boolean.valueOf(Intrinsics.areEqual(survey3 != null ? survey3.getName() : null, "promo_visitors")))), null, 4, null);
                }
                BottomSheetRatePoll.this.getSurveysViewModel().clearState();
            }
        });
    }

    /* compiled from: BottomSheetRatePoll.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C27011 extends FunctionReferenceImpl implements Function1<SurveysState, Unit> {
        C27011(Object obj) {
            super(1, obj, BottomSheetRatePoll.class, "renderSurveys", "renderSurveys(Lcom/sputnik/common/viewmodels/SurveysState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SurveysState surveysState) {
            invoke2(surveysState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SurveysState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BottomSheetRatePoll) this.receiver).renderSurveys(p0);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final BottomSheetRatePollBinding binding = getBinding();
        binding.btnStar1.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetRatePoll.initViews$lambda$7$lambda$0(binding, this, view);
            }
        });
        binding.btnStar2.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetRatePoll.initViews$lambda$7$lambda$1(binding, this, view);
            }
        });
        binding.btnStar3.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetRatePoll.initViews$lambda$7$lambda$2(binding, this, view);
            }
        });
        binding.btnStar4.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetRatePoll.initViews$lambda$7$lambda$3(binding, this, view);
            }
        });
        binding.btnStar5.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetRatePoll.initViews$lambda$7$lambda$4(binding, this, view);
            }
        });
        RecyclerView recyclerView = binding.rvReasons;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        Intrinsics.checkNotNull(recyclerView);
        ViewKt.addSystemWindowInsetToPadding$default(recyclerView, true, false, true, true, 2, null);
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$initViews$1$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x00f9  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(android.view.View r9) {
                /*
                    Method dump skipped, instructions count: 287
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$initViews$1$7.invoke2(android.view.View):void");
            }
        }, 1, null);
        AppCompatButton btnCancel = binding.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
        SafeClickListenerKt.setSafeOnClickListener$default(btnCancel, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$initViews$1$8
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
                Survey survey = this.this$0.currentSurvey;
                if (survey != null) {
                    BottomSheetRatePoll bottomSheetRatePoll = this.this$0;
                    Integer id = survey.getId();
                    if (id != null) {
                        bottomSheetRatePoll.getSurveysViewModel().sendResult(id.intValue(), CollectionsKt.emptyList(), 0, "");
                    }
                }
            }
        }, 1, null);
        EditText etComment = binding.etComment;
        Intrinsics.checkNotNullExpressionValue(etComment, "etComment");
        etComment.addTextChangedListener(new TextWatcher() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$initViews$lambda$7$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                binding.tvCounter.setText((text != null ? Integer.valueOf(text.length()) : null) + "/250");
                if (text != null && text.length() == 0) {
                    if (this.otherFieldChosen) {
                        binding.etComment.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.bg_comment_error));
                        binding.layoutComment.startAnimation(AnimationUtils.loadAnimation(this.requireContext(), R.anim.shake));
                    }
                    AppCompatButton btnApply2 = binding.btnApply;
                    Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                    ViewKt.disable(btnApply2);
                    return;
                }
                AppCompatButton btnApply3 = binding.btnApply;
                Intrinsics.checkNotNullExpressionValue(btnApply3, "btnApply");
                ViewKt.enable(btnApply3);
                binding.etComment.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.bg_comment));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$0(BottomSheetRatePollBinding this_with, BottomSheetRatePoll this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_with.btnStar1.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar2.setImageResource(R.drawable.drawable_rating_empty);
        this_with.btnStar3.setImageResource(R.drawable.drawable_rating_empty);
        this_with.btnStar4.setImageResource(R.drawable.drawable_rating_empty);
        this_with.btnStar5.setImageResource(R.drawable.drawable_rating_empty);
        this$0.onStarChanged(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$1(BottomSheetRatePollBinding this_with, BottomSheetRatePoll this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_with.btnStar1.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar2.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar3.setImageResource(R.drawable.drawable_rating_empty);
        this_with.btnStar4.setImageResource(R.drawable.drawable_rating_empty);
        this_with.btnStar5.setImageResource(R.drawable.drawable_rating_empty);
        this$0.onStarChanged(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$2(BottomSheetRatePollBinding this_with, BottomSheetRatePoll this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_with.btnStar1.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar2.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar3.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar4.setImageResource(R.drawable.drawable_rating_empty);
        this_with.btnStar5.setImageResource(R.drawable.drawable_rating_empty);
        this$0.onStarChanged(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$3(BottomSheetRatePollBinding this_with, BottomSheetRatePoll this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_with.btnStar1.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar2.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar3.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar4.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar5.setImageResource(R.drawable.drawable_rating_empty);
        this$0.onStarChanged(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$4(BottomSheetRatePollBinding this_with, BottomSheetRatePoll this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_with.btnStar1.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar2.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar3.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar4.setImageResource(R.drawable.drawable_rating_filled);
        this_with.btnStar5.setImageResource(R.drawable.drawable_rating_filled);
        this$0.onStarChanged(5);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        FeedbackCommentLocale feedbackComment;
        FeedbackCommentNavigation navigation;
        TextView textView = getBinding().tvComment;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText((data == null || (feedbackComment = data.getFeedbackComment()) == null || (navigation = feedbackComment.getNavigation()) == null) ? null : navigation.getTitle());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getSurveysViewModel().lockSurveys();
        Survey survey = this.currentSurvey;
        if (Intrinsics.areEqual(survey != null ? survey.getName() : null, "ble_feedback_general")) {
            getOnboardingViewModel().disableBleFeedback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderSurveys(com.sputnik.common.viewmodels.SurveysState r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.renderSurveys(com.sputnik.common.viewmodels.SurveysState):void");
    }

    private final void renderOptions(List<SurveyOption> options, boolean multiOptions) {
        List<ReasonItem> selectedItems;
        final BottomSheetRatePollBinding binding = getBinding();
        RecyclerView recyclerView = binding.rvReasons;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        CheckBoxAdapter checkBoxAdapter = this.reasonsAdapter;
        if ((checkBoxAdapter != null && (selectedItems = checkBoxAdapter.getSelectedItems()) != null && selectedItems.size() == 0) || this.reasonsAdapter == null) {
            CheckBoxAdapter checkBoxAdapter2 = new CheckBoxAdapter(new CheckBoxAdapter.AppPollCallback() { // from class: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll$renderOptions$1$1$1

                /* compiled from: BottomSheetRatePoll.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[CheckBoxAdapter.AppPollCallback.AppPollActions.values().length];
                        try {
                            iArr[CheckBoxAdapter.AppPollCallback.AppPollActions.UNLOCK_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[CheckBoxAdapter.AppPollCallback.AppPollActions.LOCK_BUTTON.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // sputnik.axmor.com.sputnik.ui.polls.adapters.CheckBoxAdapter.AppPollCallback
                public void onItemClick(ReasonItem item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (Intrinsics.areEqual(item.getIdentifier(), "1")) {
                        this.this$0.otherFieldChosen = item.getIsChecked();
                        if (item.getIsChecked()) {
                            Editable text = binding.etComment.getText();
                            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                            if (text.length() <= 0) {
                                boolean unused = this.this$0.otherFieldChosen;
                                return;
                            } else {
                                binding.etComment.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), R.drawable.bg_comment));
                                return;
                            }
                        }
                        binding.etComment.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), R.drawable.bg_comment));
                    }
                }

                @Override // sputnik.axmor.com.sputnik.ui.polls.adapters.CheckBoxAdapter.AppPollCallback
                public void onAction(CheckBoxAdapter.AppPollCallback.AppPollActions action) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    int i = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
                    if (i == 1) {
                        AppCompatButton btnApply = binding.btnApply;
                        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
                        ViewKt.enable(btnApply);
                    } else {
                        if (i != 2) {
                            return;
                        }
                        AppCompatButton btnApply2 = binding.btnApply;
                        Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
                        ViewKt.disable(btnApply2);
                    }
                }
            });
            this.reasonsAdapter = checkBoxAdapter2;
            List<SurveyOption> list = options;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SurveyOption surveyOption : list) {
                arrayList.add(new ReasonItem(String.valueOf(surveyOption.getId()), String.valueOf(surveyOption.getBody()), false, 4, null));
            }
            checkBoxAdapter2.submitList(arrayList);
            recyclerView.setAdapter(this.reasonsAdapter);
        }
        Intrinsics.checkNotNull(recyclerView);
        ViewKt.addSystemWindowInsetToPadding$default(recyclerView, true, false, true, true, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void renderNotice(com.sputnik.common.entities.surveys.Survey.RichBody r5) {
        /*
            r4 = this;
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            sputnik.axmor.com.databinding.BottomSheetRatePollBinding r0 = (sputnik.axmor.com.databinding.BottomSheetRatePollBinding) r0
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.layoutAttention
            java.lang.String r2 = "layoutAttention"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 0
            if (r5 == 0) goto L26
            com.sputnik.common.entities.surveys.Survey$RichBody$Notice r3 = r5.getNotice()
            if (r3 == 0) goto L26
            com.sputnik.common.entities.surveys.Survey$RichBody$Notice r3 = r5.getNotice()
            if (r3 == 0) goto L21
            java.lang.String r3 = r3.getBody()
            goto L22
        L21:
            r3 = r2
        L22:
            if (r3 == 0) goto L26
            r3 = 1
            goto L27
        L26:
            r3 = 0
        L27:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            com.sputnik.common.utils.ViewBindingUtilsKt.visibilityBasedOn(r1, r3)
            if (r5 == 0) goto L62
            android.widget.TextView r0 = r0.tvHint
            com.sputnik.common.entities.surveys.Survey$RichBody$Notice r1 = r5.getNotice()
            if (r1 == 0) goto L3d
            java.lang.String r1 = r1.getBody()
            goto L3e
        L3d:
            r1 = r2
        L3e:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.sputnik.common.entities.surveys.Survey$RichBody$Notice r5 = r5.getNotice()
            if (r5 == 0) goto L4c
            java.lang.String r2 = r5.getParam()
        L4c:
            java.lang.String r5 = java.lang.String.valueOf(r2)
            android.content.Context r2 = r4.requireContext()
            r3 = 2131100748(0x7f06044c, float:1.7813886E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            android.text.SpannableString r5 = com.sputnik.common.utils.ViewUtilsKt.highlightText(r1, r5, r2)
            r0.setText(r5)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.polls.BottomSheetRatePoll.renderNotice(com.sputnik.common.entities.surveys.Survey$RichBody):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayedTask$lambda$21(BottomSheetRatePoll this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            AppCompatButton btnCancel = this$0.getBinding().btnCancel;
            Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
            ViewKt.visible(btnCancel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void renderButtons$default(BottomSheetRatePoll bottomSheetRatePoll, List list, boolean z, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
        }
        bottomSheetRatePoll.renderButtons(list, z, j);
    }

    private final void renderButtons(List<Button> options, boolean needDelay, long delay) {
        Object next;
        Object next2;
        String title;
        BottomSheetRatePollBinding binding = getBinding();
        List<Button> list = options;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((Button) next).getDeeplink(), "send")) {
                    break;
                }
            }
        }
        Button button = (Button) next;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it2.next();
                if (Intrinsics.areEqual(((Button) next2).getDeeplink(), "close")) {
                    break;
                }
            }
        }
        Button button2 = (Button) next2;
        binding.btnApply.setText(button != null ? button.getTitle() : null);
        binding.btnCancel.setText(button2 != null ? button2.getTitle() : null);
        if (button2 == null || (title = button2.getTitle()) == null) {
            title = "";
        }
        this.closeBtnTitle = title;
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        ViewBindingUtilsKt.visibilityBasedOn(btnApply, Boolean.valueOf(button != null));
        if (needDelay) {
            AppCompatButton btnCancel = binding.btnCancel;
            Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
            ViewKt.gone(btnCancel);
            this.handler.postDelayed(this.delayedTask, delay);
            return;
        }
        AppCompatButton btnCancel2 = binding.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel2, "btnCancel");
        ViewBindingUtilsKt.visibilityBasedOn(btnCancel2, Boolean.valueOf(button2 != null));
    }

    private final void onStarChanged(int rate) {
        List<ReasonItem> selectedItems;
        this.handler.removeCallbacks(this.delayedTask);
        this.currentRate = rate;
        if (rate == 5) {
            NestedScrollView layoutTroubles = getBinding().layoutTroubles;
            Intrinsics.checkNotNullExpressionValue(layoutTroubles, "layoutTroubles");
            ViewKt.gone(layoutTroubles);
            AppCompatButton btnApply = getBinding().btnApply;
            Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
            ViewKt.enable(btnApply);
            return;
        }
        if (1 > rate || rate >= 5) {
            return;
        }
        CheckBoxAdapter checkBoxAdapter = this.reasonsAdapter;
        if (checkBoxAdapter != null && (selectedItems = checkBoxAdapter.getSelectedItems()) != null && selectedItems.size() == 0) {
            AppCompatButton btnApply2 = getBinding().btnApply;
            Intrinsics.checkNotNullExpressionValue(btnApply2, "btnApply");
            ViewKt.disable(btnApply2);
        }
        NestedScrollView layoutTroubles2 = getBinding().layoutTroubles;
        Intrinsics.checkNotNullExpressionValue(layoutTroubles2, "layoutTroubles");
        ViewExtensions.show(layoutTroubles2);
    }
}
