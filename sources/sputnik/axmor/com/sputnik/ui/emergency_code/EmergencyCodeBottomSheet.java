package sputnik.axmor.com.sputnik.ui.emergency_code;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.EmergencyBody;
import com.sputnik.common.entities.localization.EmergencyCodeLocale;
import com.sputnik.common.entities.localization.EmergencySubTitle;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.view.HighlightedText;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.ui.view.ToggleStateButton;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationAction;
import com.sputnik.common.viewmodels.NavigationScenario;
import com.sputnik.common.viewmodels.NavigationViewModel;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.domain.entities.prefs.EventsSettings;
import com.sputnik.domain.usecases.issues.IssueTypes;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetEmergencyCodeBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewModel;
import sputnik.axmor.com.sputnik.ui.events.viewmodel.EventViewState;

/* compiled from: EmergencyCodeBottomSheet.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u00105R\u001d\u0010:\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b8\u00109R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010)\u001a\u0004\b<\u00109¨\u0006="}, d2 = {"Lsputnik/axmor/com/sputnik/ui/emergency_code/EmergencyCodeBottomSheet;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetEmergencyCodeBinding;", "<init>", "()V", "", "code", "", "shareCode", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "onPause", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "Lkotlin/Lazy;", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewModel;", "eventViewModel$delegate", "getEventViewModel", "()Lsputnik/axmor/com/sputnik/ui/events/viewmodel/EventViewModel;", "eventViewModel", "intercomUUID$delegate", "getIntercomUUID", "()Ljava/lang/String;", "intercomUUID", "code$delegate", "getCode", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmergencyCodeBottomSheet extends BaseBottomSheetDialogFragment<BottomSheetEmergencyCodeBinding> {

    /* renamed from: code$delegate, reason: from kotlin metadata */
    private final Lazy code;

    /* renamed from: eventViewModel$delegate, reason: from kotlin metadata */
    private final Lazy eventViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: intercomUUID$delegate, reason: from kotlin metadata */
    private final Lazy intercomUUID;
    public LocalizationStorage localizationScreen;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* compiled from: EmergencyCodeBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetEmergencyCodeBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetEmergencyCodeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetEmergencyCodeBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetEmergencyCodeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetEmergencyCodeBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetEmergencyCodeBinding.inflate(p0, viewGroup, z);
        }
    }

    public static final /* synthetic */ BottomSheetEmergencyCodeBinding access$getBinding(EmergencyCodeBottomSheet emergencyCodeBottomSheet) {
        return emergencyCodeBottomSheet.getBinding();
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
    public final NavigationViewModel getNavigationViewModel() {
        return (NavigationViewModel) this.navigationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventViewModel getEventViewModel() {
        return (EventViewModel) this.eventViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getIntercomUUID() {
        return (String) this.intercomUUID.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCode() {
        return (String) this.code.getValue();
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
        setStyle(0, R.style.BottomSheet);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventViewModel eventViewModel = getEventViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        eventViewModel.observeState(viewLifecycleOwner, new Function1<EventViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventViewState eventViewState) {
                invoke2(eventViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventViewState state) {
                ToggleStateButton toggleStateButton;
                Intrinsics.checkNotNullParameter(state, "state");
                EventsSettings eventsSettings = state.getEventsSettings();
                if (eventsSettings != null) {
                    EmergencyCodeBottomSheet emergencyCodeBottomSheet = EmergencyCodeBottomSheet.this;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String phone = emergencyCodeBottomSheet.getProfileViewModel().getPrefManager().getPhone();
                    String string = IssueTypes.intercom_offline.toString();
                    String intercomUUID = emergencyCodeBottomSheet.getIntercomUUID();
                    if (intercomUUID == null) {
                        intercomUUID = "";
                    }
                    if (jCurrentTimeMillis - eventsSettings.getLastClick(phone, string, intercomUUID) >= 86400000 || (toggleStateButton = EmergencyCodeBottomSheet.access$getBinding(emergencyCodeBottomSheet).btnReport) == null) {
                        return;
                    }
                    toggleStateButton.lockState(false);
                }
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        final BottomSheetEmergencyCodeBinding binding = getBinding();
        binding.tvCode.setText(getCode());
        CardView cardLayout = binding.cardLayout;
        Intrinsics.checkNotNullExpressionValue(cardLayout, "cardLayout");
        SafeClickListenerKt.setSafeOnClickListener$default(cardLayout, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$initViews$1$1
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
                EmergencyCodeBottomSheet emergencyCodeBottomSheet = this.this$0;
                String code = emergencyCodeBottomSheet.getCode();
                Intrinsics.checkNotNull(code);
                emergencyCodeBottomSheet.shareCode(code);
            }
        }, 1, null);
        ImageView shareButton = binding.shareButton;
        Intrinsics.checkNotNullExpressionValue(shareButton, "shareButton");
        SafeClickListenerKt.setSafeOnClickListener$default(shareButton, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$initViews$1$2
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
                EmergencyCodeBottomSheet emergencyCodeBottomSheet = this.this$0;
                String code = emergencyCodeBottomSheet.getCode();
                Intrinsics.checkNotNull(code);
                emergencyCodeBottomSheet.shareCode(code);
            }
        }, 1, null);
        ToggleStateButton toggleStateButton = binding.btnReport;
        if (toggleStateButton != null) {
            toggleStateButton.setFirstState("Сообщить о проблеме", R.drawable.ic_alert_outline, R.drawable.background_button_pink_12, R.color.white, R.color.white);
        }
        ToggleStateButton toggleStateButton2 = binding.btnReport;
        if (toggleStateButton2 != null) {
            toggleStateButton2.setSecondState("Мы получили ваше обращение", R.drawable.ic_checkmark_outline_green, R.drawable.background_button_transparent_12, R.color.black, R.color.sputnik_green);
        }
        binding.btnReport.setOnToggleListener(new Function1<Boolean, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$initViews$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    this.this$0.getEventViewModel().reportIntercomOfflineIssue(this.this$0.getIntercomUUID());
                    binding.btnReport.lockState(false);
                    TextView tvCompanyContacts = binding.tvCompanyContacts;
                    Intrinsics.checkNotNullExpressionValue(tvCompanyContacts, "tvCompanyContacts");
                    ViewKt.gone(tvCompanyContacts);
                    TextView tvCompanyContactsInfo = binding.tvCompanyContactsInfo;
                    Intrinsics.checkNotNullExpressionValue(tvCompanyContactsInfo, "tvCompanyContactsInfo");
                    ViewKt.visible(tvCompanyContactsInfo);
                }
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        EmergencyCodeLocale emergencyCodeLocale;
        EmergencyBody body;
        String param1;
        BottomSheetEmergencyCodeBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (emergencyCodeLocale = data.getEmergencyCodeLocale()) == null || (body = emergencyCodeLocale.getBody()) == null) {
            return;
        }
        EmergencySubTitle subtitle = body.getSubtitle();
        Integer numValueOf = null;
        String text = subtitle != null ? subtitle.getText() : null;
        Intrinsics.checkNotNull(text);
        EmergencySubTitle subtitle2 = body.getSubtitle();
        String param12 = subtitle2 != null ? subtitle2.getParam1() : null;
        Intrinsics.checkNotNull(param12);
        SpannableString spannableString = new SpannableString(Util.format(text, param12));
        EmergencySubTitle subtitle3 = body.getSubtitle();
        String param13 = subtitle3 != null ? subtitle3.getParam1() : null;
        Intrinsics.checkNotNull(param13);
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, param13, 0, false, 6, (Object) null);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.sputnik_pink));
        EmergencySubTitle subtitle4 = body.getSubtitle();
        if (subtitle4 != null && (param1 = subtitle4.getParam1()) != null) {
            numValueOf = Integer.valueOf(param1.length());
        }
        Intrinsics.checkNotNull(numValueOf);
        spannableString.setSpan(foregroundColorSpan, iIndexOf$default, numValueOf.intValue() + iIndexOf$default, 33);
        binding.tvTitle.setText("У домофона проблема с интернетом :(");
        binding.subTitle.setText("Чтобы открыть дверь, введите код указанный ниже");
        TextView tvCompanyContactsInfo = binding.tvCompanyContactsInfo;
        Intrinsics.checkNotNullExpressionValue(tvCompanyContactsInfo, "tvCompanyContactsInfo");
        ViewUtilsKt.highlightText(tvCompanyContactsInfo, "Срок решения проблемы обычно составляет один рабочий день\n\nПолучить актуальную информацию по статусу вы можете у вашей обслуживающей организации", new HighlightedText("обслуживающей организации", ContextCompat.getColor(requireContext(), R.color.sputnik_blue), null, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$localize$1$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getNavigationViewModel().addDelayedAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_aboutCompany, "", null, null, 12, null))), false, 4, null));
                this.this$0.dismiss();
            }
        }, 0, 0, 52, null));
        TextView tvCompanyContacts = binding.tvCompanyContacts;
        Intrinsics.checkNotNullExpressionValue(tvCompanyContacts, "tvCompanyContacts");
        ViewUtilsKt.highlightText(tvCompanyContacts, "Нажмите на кнопку для передачи информации в %1s и скорейшего устранения проблемы", new HighlightedText("обслуживающую компанию", ContextCompat.getColor(requireContext(), R.color.sputnik_blue), null, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$localize$1$1$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getNavigationViewModel().addDelayedAction(new NavigationScenario(null, new LinkedList(CollectionsKt.listOf(new NavigationAction(R.id.action_global_to_aboutCompany, "", null, null, 12, null))), false, 4, null));
                this.this$0.dismiss();
            }
        }, 0, 0, 52, null));
    }

    public EmergencyCodeBottomSheet() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.eventViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EventViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$eventViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.intercomUUID = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$intercomUUID$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("id");
                }
                return null;
            }
        });
        this.code = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.emergency_code.EmergencyCodeBottomSheet$code$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("code");
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareCode(String code) {
        EmergencyCodeLocale emergencyCodeLocale;
        EmergencyBody body;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", code);
        intent.setType("text/plain");
        LocalizationLocalModel data = getLocalizationScreen().getData();
        startActivity(Intent.createChooser(intent, (data == null || (emergencyCodeLocale = data.getEmergencyCodeLocale()) == null || (body = emergencyCodeLocale.getBody()) == null) ? null : body.getTitle()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentKt.findNavController(this).navigateUp();
    }
}
