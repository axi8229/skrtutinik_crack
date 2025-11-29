package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.BleEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetNoPermissionsBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BottomSheetNoBlePermissions.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetNoBlePermissions;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetNoPermissionsBinding;", "<init>", "()V", "", "trackAcceptAnalytics", "trackDismissAnalytics", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "", "from$delegate", "getFrom", "()Ljava/lang/String;", RemoteMessageConst.FROM, "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetNoBlePermissions extends BaseBottomSheetDialogFragment<BottomSheetNoPermissionsBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: from$delegate, reason: from kotlin metadata */
    private final Lazy from;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* compiled from: BottomSheetNoBlePermissions.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetNoPermissionsBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetNoPermissionsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetNoPermissionsBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetNoPermissionsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetNoPermissionsBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetNoPermissionsBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetNoBlePermissions() {
        super(AnonymousClass1.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions$navController$2
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
        this.from = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions$from$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString(RemoteMessageConst.FROM, "");
                }
                return null;
            }
        });
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    private final NavController getNavController() {
        return (NavController) this.navController.getValue();
    }

    private final String getFrom() {
        return (String) this.from.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
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

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetNoPermissionsBinding binding = getBinding();
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetNoBlePermissions.initViews$lambda$2$lambda$0(this.f$0, view);
            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetNoBlePermissions$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetNoBlePermissions.initViews$lambda$2$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$0(BottomSheetNoBlePermissions this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.trackAcceptAnalytics();
        this$0.dismiss();
        NavControllerKt.safeNavigate$default(this$0.getNavController(), R.id.action_global_to_permissionsFragment, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1(BottomSheetNoBlePermissions this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.trackDismissAnalytics();
        this$0.dismiss();
    }

    private final void trackAcceptAnalytics() {
        String from = getFrom();
        if (from != null) {
            int iHashCode = from.hashCode();
            if (iHashCode == -748911182) {
                if (from.equals("main_screen")) {
                    getAnalytics().trackLogEvent(new BleEvents.ShowPermissionModalMainScreenTweak());
                }
            } else if (iHashCode == 600199493) {
                if (from.equals("ble_switcher")) {
                    getAnalytics().trackLogEvent(new BleEvents.ShowPermissionModalOnBLETweak());
                }
            } else if (iHashCode == 1070470361 && from.equals("setup_rssi")) {
                getAnalytics().trackLogEvent(new BleEvents.ShowPermissionModalRSSITweak());
            }
        }
    }

    private final void trackDismissAnalytics() {
        String from = getFrom();
        if (from != null) {
            int iHashCode = from.hashCode();
            if (iHashCode == -748911182) {
                if (from.equals("main_screen")) {
                    getAnalytics().trackLogEvent(new BleEvents.ShowPermissionModalMainScreenSkip());
                }
            } else if (iHashCode == 600199493) {
                if (from.equals("ble_switcher")) {
                    getAnalytics().trackLogEvent(new BleEvents.ShowPermissionModalOnBLESkip());
                }
            } else if (iHashCode == 1070470361 && from.equals("setup_rssi")) {
                getAnalytics().trackLogEvent(new BleEvents.ShowPermissionModalRSSISkip());
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        BleLocale ble;
        BleLocale.PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet;
        BottomSheetNoPermissionsBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (ble = data.getBle()) == null || (permissionsNotGrantedBottomSheet = ble.getPermissionsNotGrantedBottomSheet()) == null) {
            return;
        }
        TextView textView = binding.tvTitle;
        String title = permissionsNotGrantedBottomSheet.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        AppCompatButton appCompatButton = binding.btnApply;
        TextTitle okButton = permissionsNotGrantedBottomSheet.getOkButton();
        String title2 = okButton != null ? okButton.getTitle() : null;
        if (title2 == null) {
            title2 = "";
        }
        appCompatButton.setText(title2);
        AppCompatButton appCompatButton2 = binding.btnCancel;
        TextTitle cancelButton = permissionsNotGrantedBottomSheet.getCancelButton();
        String title3 = cancelButton != null ? cancelButton.getTitle() : null;
        appCompatButton2.setText(title3 != null ? title3 : "");
    }
}
