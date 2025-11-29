package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.DpUtilsKt;
import com.sputnik.common.viewmodels.InstructionsViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetBackgroundWorkBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BottomSheetBackgroundWork.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JI\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0016¢\u0006\u0004\b#\u0010\u0004R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetBackgroundWork;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetBackgroundWorkBinding;", "<init>", "()V", "", "label", "manufacturer", "range", "", "sdkInt", "Lkotlin/Function2;", "", "onClickListener", "renderButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "changeManufacturerAndSDKInt", "(Ljava/lang/String;I)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel$delegate", "Lkotlin/Lazy;", "getInstructionsViewModel", "()Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "instructionsViewModel", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetBackgroundWork extends BaseBottomSheetDialogFragment<BottomSheetBackgroundWorkBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: instructionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy instructionsViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* compiled from: BottomSheetBackgroundWork.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetBackgroundWorkBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetBackgroundWorkBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetBackgroundWorkBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetBackgroundWorkBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetBackgroundWorkBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetBackgroundWorkBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetBackgroundWork() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.instructionsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InstructionsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork$instructionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork$navController$2
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final InstructionsViewModel getInstructionsViewModel() {
        return (InstructionsViewModel) this.instructionsViewModel.getValue();
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
    }

    private final void renderButton(String label, final String manufacturer, String range, final int sdkInt, final Function2<? super String, ? super Integer, Unit> onClickListener) {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_button_blue, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatButton");
        AppCompatButton appCompatButton = (AppCompatButton) viewInflate;
        appCompatButton.setText(label + " " + range);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Resources resources = appCompatButton.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int iConvertPxToDb = DpUtilsKt.convertPxToDb(16.0f, resources);
        Resources resources2 = appCompatButton.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        int iConvertPxToDb2 = DpUtilsKt.convertPxToDb(20.0f, resources2);
        layoutParams.setMargins(iConvertPxToDb2, iConvertPxToDb, iConvertPxToDb2, 0);
        appCompatButton.setLayoutParams(layoutParams);
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetBackgroundWork$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetBackgroundWork.renderButton$lambda$1$lambda$0(onClickListener, manufacturer, sdkInt, view);
            }
        });
        getBinding().layoutManufacturers.addView(appCompatButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderButton$lambda$1$lambda$0(Function2 onClickListener, String manufacturer, int i, View view) {
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(manufacturer, "$manufacturer");
        onClickListener.invoke(manufacturer, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeManufacturerAndSDKInt(String manufacturer, int sdkInt) {
        getInstructionsViewModel().changeManufacturerAndSDKInt(manufacturer, sdkInt);
        dismiss();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        LinearLayout linearLayout = getBinding().layoutManufacturers;
        renderButton("Samsung", "Samsung", "12-XX", 31, new BottomSheetBackgroundWork$initViews$1$1$1(this));
        renderButton("Samsung", "Samsung", "10-11", 29, new BottomSheetBackgroundWork$initViews$1$1$2(this));
        renderButton("Samsung", "Samsung", "8-9", 26, new BottomSheetBackgroundWork$initViews$1$1$3(this));
        renderButton("Xiaomi_Redmi_Poco", "Xiaomi", "13-XX", 33, new BottomSheetBackgroundWork$initViews$1$1$4(this));
        renderButton("Xiaomi_Redmi_Poco", "Xiaomi", "12", 31, new BottomSheetBackgroundWork$initViews$1$1$5(this));
        renderButton("Xiaomi_Redmi_Poco", "Xiaomi", "10-11", 29, new BottomSheetBackgroundWork$initViews$1$1$6(this));
        renderButton("Xiaomi_Redmi_Poco", "Xiaomi", "6-9?", 28, new BottomSheetBackgroundWork$initViews$1$1$7(this));
        renderButton("Realme", "Realme", "11-XX", 30, new BottomSheetBackgroundWork$initViews$1$1$8(this));
        renderButton("Vivo", "Vivo", "12-XX", 31, new BottomSheetBackgroundWork$initViews$1$1$9(this));
        renderButton("Vivo", "Vivo", "11", 30, new BottomSheetBackgroundWork$initViews$1$1$10(this));
        renderButton("Vivo", "Vivo", "6-10?", 29, new BottomSheetBackgroundWork$initViews$1$1$11(this));
        renderButton("Oppo", "Oppo", "13-XX", 31, new BottomSheetBackgroundWork$initViews$1$1$12(this));
        renderButton("Oppo", "Oppo", "12", 31, new BottomSheetBackgroundWork$initViews$1$1$13(this));
        renderButton("Oppo", "Oppo", "5-11", 30, new BottomSheetBackgroundWork$initViews$1$1$14(this));
        renderButton("OnePlus", "OnePlus", "13-XX", 33, new BottomSheetBackgroundWork$initViews$1$1$15(this));
        renderButton("OnePlus", "OnePlus", "12", 31, new BottomSheetBackgroundWork$initViews$1$1$16(this));
        renderButton("OnePlus", "OnePlus", "9-11", 30, new BottomSheetBackgroundWork$initViews$1$1$17(this));
        renderButton("Huawei", "Huawei", "XX", 33, new BottomSheetBackgroundWork$initViews$1$1$18(this));
        renderButton("Honor", "Honor", "XX", 33, new BottomSheetBackgroundWork$initViews$1$1$19(this));
        renderButton("Google", "Google", "15", 35, new BottomSheetBackgroundWork$initViews$1$1$20(this));
        renderButton("Google", "Google", "12-14", 31, new BottomSheetBackgroundWork$initViews$1$1$21(this));
        renderButton("Google", "Google", "6-11", 30, new BottomSheetBackgroundWork$initViews$1$1$22(this));
        renderButton("Default", "Default", "XX", 30, new BottomSheetBackgroundWork$initViews$1$1$23(this));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        getBinding();
    }
}
