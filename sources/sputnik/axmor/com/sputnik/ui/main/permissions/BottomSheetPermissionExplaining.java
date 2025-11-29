package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.api.location.common.LocationConstant;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.PermissionsEvents;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.permissions.PermissionsLocale;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.view.LeafView;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.BottomSheetPermissionBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: BottomSheetPermissionExplaining.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0004R\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00106\u001a\u0004\b?\u0010@R\"\u0010D\u001a\u0010\u0012\f\u0012\n C*\u0004\u0018\u00010\u00050\u00050B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetPermissionExplaining;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lsputnik/axmor/com/databinding/BottomSheetPermissionBinding;", "<init>", "()V", "", AttributionReporter.SYSTEM_PERMISSION, "", "trackAnalyticsForPermission", "(Ljava/lang/String;)V", "Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetPermissionExplaining$PermissionExplaining;", "getExplainMessageByPermission", "(Ljava/lang/String;)Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetPermissionExplaining$PermissionExplaining;", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/navigation/NavController;", "navController$delegate", "Lkotlin/Lazy;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "permission$delegate", "getPermission", "()Ljava/lang/String;", "", "needRequestPermission$delegate", "getNeedRequestPermission", "()Z", "needRequestPermission", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "PermissionExplaining", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetPermissionExplaining extends BaseBottomSheetDialogFragment<BottomSheetPermissionBinding> {
    public Analytics analytics;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;

    /* renamed from: needRequestPermission$delegate, reason: from kotlin metadata */
    private final Lazy needRequestPermission;

    /* renamed from: permission$delegate, reason: from kotlin metadata */
    private final Lazy permission;
    private final ActivityResultLauncher<String> requestPermissionLauncher;

    /* compiled from: BottomSheetPermissionExplaining.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetPermissionBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetPermissionBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lsputnik/axmor/com/databinding/BottomSheetPermissionBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetPermissionBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }

        public final BottomSheetPermissionBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetPermissionBinding.inflate(p0, viewGroup, z);
        }
    }

    public BottomSheetPermissionExplaining() {
        super(AnonymousClass1.INSTANCE);
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining$navController$2
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
        this.permission = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining$permission$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("item");
                }
                return null;
            }
        });
        this.needRequestPermission = LazyKt.lazy(new Function0<Boolean>() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining$needRequestPermission$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = this.this$0.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("need_request_permission") : false);
            }
        });
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetPermissionExplaining.requestPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = activityResultLauncherRegisterForActivityResult;
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

    private final String getPermission() {
        return (String) this.permission.getValue();
    }

    private final boolean getNeedRequestPermission() {
        return ((Boolean) this.needRequestPermission.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$0(BottomSheetPermissionExplaining this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.dismiss();
            return;
        }
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        IntentUtilsKt.openSystemAppSettings(contextRequireContext);
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
        getBinding().btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPermissionExplaining.initViews$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r3.equals(com.huawei.hms.support.api.location.common.LocationConstant.BACKGROUND_PERMISSION) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r3.equals("android.permission.ACCESS_FINE_LOCATION") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r3.equals("android.permission.POST_NOTIFICATIONS") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r3.equals("android.permission.BLUETOOTH_SCAN") == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void initViews$lambda$3$lambda$2(sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining r2, android.view.View r3) {
        /*
            java.lang.String r3 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = r2.getPermission()
            if (r3 == 0) goto L74
            r2.trackAnalyticsForPermission(r3)
            int r0 = r3.hashCode()
            java.lang.String r1 = "requireContext(...)"
            switch(r0) {
                case -1925850455: goto L47;
                case -1888586689: goto L3e;
                case -784330217: goto L2a;
                case 2024715147: goto L21;
                case 2062356686: goto L18;
                default: goto L17;
            }
        L17:
            goto L6a
        L18:
            java.lang.String r0 = "android.permission.BLUETOOTH_SCAN"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L4f
            goto L6a
        L21:
            java.lang.String r0 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L4f
            goto L6a
        L2a:
            java.lang.String r0 = "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L33
            goto L6a
        L33:
            android.content.Context r2 = r2.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.sputnik.common.utils.IntentUtilsKt.openIgnoreBatteryOptimisationsSettings(r2)
            goto L74
        L3e:
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L4f
            goto L6a
        L47:
            java.lang.String r0 = "android.permission.POST_NOTIFICATIONS"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L6a
        L4f:
            boolean r3 = r2.getNeedRequestPermission()
            if (r3 == 0) goto L5f
            androidx.activity.result.ActivityResultLauncher<java.lang.String> r3 = r2.requestPermissionLauncher
            java.lang.String r2 = r2.getPermission()
            r3.launch(r2)
            goto L74
        L5f:
            android.content.Context r2 = r2.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.sputnik.common.utils.IntentUtilsKt.openSystemAppSettings(r2)
            goto L74
        L6a:
            android.content.Context r2 = r2.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.sputnik.common.utils.IntentUtilsKt.openSystemAppSettings(r2)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining.initViews$lambda$3$lambda$2(sputnik.axmor.com.sputnik.ui.main.permissions.BottomSheetPermissionExplaining, android.view.View):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final void trackAnalyticsForPermission(String permission) {
        switch (permission.hashCode()) {
            case -1925850455:
                if (permission.equals("android.permission.POST_NOTIFICATIONS")) {
                    getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionNotificationsDetOn());
                    break;
                }
                break;
            case -1888586689:
                if (permission.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionLocationDetOn());
                    break;
                }
                break;
            case -784330217:
                if (permission.equals("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionWhitelistDetOn());
                    break;
                }
                break;
            case -339880686:
                if (permission.equals("permission_background_work")) {
                    getAnalytics().trackLogEvent(new PermissionsEvents.ClickSetupWorkInDetBackground());
                    break;
                }
                break;
            case 2024715147:
                if (permission.equals(LocationConstant.BACKGROUND_PERMISSION)) {
                    getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionLocationDetOn());
                    break;
                }
                break;
            case 2062356686:
                if (permission.equals("android.permission.BLUETOOTH_SCAN")) {
                    getAnalytics().trackLogEvent(new PermissionsEvents.ClickPermissionDeviceSearchDetOn());
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        PermissionsLocale permissions;
        PermissionsLocale permissions2;
        TextTitle openSettingsBtn;
        BottomSheetPermissionBinding binding = getBinding();
        AppCompatButton appCompatButton = binding.btnApply;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String locationExplaining = null;
        String title = (data == null || (permissions2 = data.getPermissions()) == null || (openSettingsBtn = permissions2.getOpenSettingsBtn()) == null) ? null : openSettingsBtn.getTitle();
        if (title == null) {
            title = "";
        }
        appCompatButton.setText(title);
        String permission = getPermission();
        if (permission != null) {
            Intrinsics.checkNotNull(permission);
            PermissionExplaining explainMessageByPermission = getExplainMessageByPermission(permission);
            int iHashCode = permission.hashCode();
            if (iHashCode == -1888586689 ? permission.equals("android.permission.ACCESS_FINE_LOCATION") : iHashCode == 2024715147 && permission.equals(LocationConstant.BACKGROUND_PERMISSION)) {
                TextView textView = binding.tvAttention;
                LocalizationLocalModel data2 = getLocalizationStorage().getData();
                if (data2 != null && (permissions = data2.getPermissions()) != null) {
                    locationExplaining = permissions.getLocationExplaining();
                }
                textView.setText(locationExplaining != null ? locationExplaining : "");
                TextView tvAttention = binding.tvAttention;
                Intrinsics.checkNotNullExpressionValue(tvAttention, "tvAttention");
                ViewKt.visible(tvAttention);
            }
            binding.tvTitle.setText(explainMessageByPermission.getTitle());
            int i = 0;
            for (Object obj : explainMessageByPermission.getOptions()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                LeafView leafView = new LeafView(contextRequireContext, null, 0, 6, null);
                leafView.setImage(R.drawable.ic_leaf_blue);
                leafView.setNumberation(String.valueOf(i2));
                int dpFromPx = ViewKt.getDpFromPx(leafView, 16.0f);
                leafView.setPadding(dpFromPx, dpFromPx, dpFromPx, dpFromPx);
                leafView.setText((SpannableString) obj);
                binding.layoutOptions.addView(leafView);
                i = i2;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final PermissionExplaining getExplainMessageByPermission(String permission) {
        PermissionsLocale permissions;
        PermissionsLocale.Permission notifications;
        List<TitleWithParam> items;
        TitleWithParam titleWithParam;
        PermissionsLocale permissions2;
        PermissionsLocale.Permission notifications2;
        List<TitleWithParam> items2;
        TitleWithParam titleWithParam2;
        PermissionsLocale permissions3;
        PermissionsLocale.Permission notifications3;
        List<TitleWithParam> items3;
        TitleWithParam titleWithParam3;
        PermissionsLocale permissions4;
        PermissionsLocale.Permission notifications4;
        List<TitleWithParam> items4;
        TitleWithParam titleWithParam4;
        PermissionsLocale permissions5;
        TitleWithParam tapPermissions;
        PermissionsLocale permissions6;
        TitleWithParam tapPermissions2;
        PermissionsLocale permissions7;
        PermissionsLocale.Permission notifications5;
        PermissionsLocale permissions8;
        PermissionsLocale.Permission location;
        List<TitleWithParam> items5;
        TitleWithParam titleWithParam5;
        PermissionsLocale permissions9;
        PermissionsLocale.Permission location2;
        List<TitleWithParam> items6;
        TitleWithParam titleWithParam6;
        PermissionsLocale permissions10;
        PermissionsLocale.Permission location3;
        List<TitleWithParam> items7;
        TitleWithParam titleWithParam7;
        PermissionsLocale permissions11;
        PermissionsLocale.Permission location4;
        List<TitleWithParam> items8;
        TitleWithParam titleWithParam8;
        PermissionsLocale permissions12;
        TitleWithParam tapPermissions3;
        PermissionsLocale permissions13;
        TitleWithParam tapPermissions4;
        PermissionsLocale permissions14;
        PermissionsLocale.Permission location5;
        PermissionsLocale permissions15;
        PermissionsLocale.Permission whitelist;
        List<TitleWithParam> items9;
        TitleWithParam titleWithParam9;
        PermissionsLocale permissions16;
        PermissionsLocale.Permission whitelist2;
        List<TitleWithParam> items10;
        TitleWithParam titleWithParam10;
        PermissionsLocale permissions17;
        PermissionsLocale.Permission whitelist3;
        List<TitleWithParam> items11;
        TitleWithParam titleWithParam11;
        PermissionsLocale permissions18;
        PermissionsLocale.Permission whitelist4;
        List<TitleWithParam> items12;
        TitleWithParam titleWithParam12;
        PermissionsLocale permissions19;
        PermissionsLocale.Permission whitelist5;
        List<TitleWithParam> items13;
        TitleWithParam titleWithParam13;
        PermissionsLocale permissions20;
        PermissionsLocale.Permission whitelist6;
        List<TitleWithParam> items14;
        TitleWithParam titleWithParam14;
        PermissionsLocale permissions21;
        PermissionsLocale.Permission whitelist7;
        PermissionsLocale permissions22;
        PermissionsLocale.Permission backgroundWork;
        List<TitleWithParam> items15;
        TitleWithParam titleWithParam15;
        PermissionsLocale permissions23;
        PermissionsLocale.Permission backgroundWork2;
        List<TitleWithParam> items16;
        TitleWithParam titleWithParam16;
        PermissionsLocale permissions24;
        PermissionsLocale.Permission backgroundWork3;
        List<TitleWithParam> items17;
        TitleWithParam titleWithParam17;
        PermissionsLocale permissions25;
        PermissionsLocale.Permission backgroundWork4;
        List<TitleWithParam> items18;
        TitleWithParam titleWithParam18;
        PermissionsLocale permissions26;
        PermissionsLocale.Permission backgroundWork5;
        PermissionsLocale permissions27;
        PermissionsLocale.Permission location6;
        List<TitleWithParam> items19;
        TitleWithParam titleWithParam19;
        PermissionsLocale permissions28;
        PermissionsLocale.Permission location7;
        List<TitleWithParam> items20;
        TitleWithParam titleWithParam20;
        PermissionsLocale permissions29;
        PermissionsLocale.Permission location8;
        List<TitleWithParam> items21;
        TitleWithParam titleWithParam21;
        PermissionsLocale permissions30;
        PermissionsLocale.Permission location9;
        List<TitleWithParam> items22;
        TitleWithParam titleWithParam22;
        PermissionsLocale permissions31;
        TitleWithParam tapPermissions5;
        PermissionsLocale permissions32;
        TitleWithParam tapPermissions6;
        PermissionsLocale permissions33;
        PermissionsLocale.Permission location10;
        PermissionsLocale permissions34;
        PermissionsLocale.Permission nearbyDevices;
        List<TitleWithParam> items23;
        TitleWithParam titleWithParam23;
        PermissionsLocale permissions35;
        PermissionsLocale.Permission nearbyDevices2;
        List<TitleWithParam> items24;
        TitleWithParam titleWithParam24;
        PermissionsLocale permissions36;
        PermissionsLocale.Permission nearbyDevices3;
        List<TitleWithParam> items25;
        TitleWithParam titleWithParam25;
        PermissionsLocale permissions37;
        PermissionsLocale.Permission nearbyDevices4;
        List<TitleWithParam> items26;
        TitleWithParam titleWithParam26;
        PermissionsLocale permissions38;
        TitleWithParam tapPermissions7;
        PermissionsLocale permissions39;
        TitleWithParam tapPermissions8;
        PermissionsLocale permissions40;
        PermissionsLocale.Permission nearbyDevices5;
        String param1 = null;
        switch (permission.hashCode()) {
            case -1925850455:
                if (permission.equals("android.permission.POST_NOTIFICATIONS")) {
                    LocalizationLocalModel data = getLocalizationStorage().getData();
                    String title = (data == null || (permissions7 = data.getPermissions()) == null || (notifications5 = permissions7.getNotifications()) == null) ? null : notifications5.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    LocalizationLocalModel data2 = getLocalizationStorage().getData();
                    String title2 = (data2 == null || (permissions6 = data2.getPermissions()) == null || (tapPermissions2 = permissions6.getTapPermissions()) == null) ? null : tapPermissions2.getTitle();
                    if (title2 == null) {
                        title2 = "";
                    }
                    LocalizationLocalModel data3 = getLocalizationStorage().getData();
                    String param12 = (data3 == null || (permissions5 = data3.getPermissions()) == null || (tapPermissions = permissions5.getTapPermissions()) == null) ? null : tapPermissions.getParam1();
                    if (param12 == null) {
                        param12 = "";
                    }
                    SpannableString spannableStringHighlightText = ViewUtilsKt.highlightText(title2, param12, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data4 = getLocalizationStorage().getData();
                    String title3 = (data4 == null || (permissions4 = data4.getPermissions()) == null || (notifications4 = permissions4.getNotifications()) == null || (items4 = notifications4.getItems()) == null || (titleWithParam4 = (TitleWithParam) CollectionsKt.getOrNull(items4, 0)) == null) ? null : titleWithParam4.getTitle();
                    if (title3 == null) {
                        title3 = "";
                    }
                    LocalizationLocalModel data5 = getLocalizationStorage().getData();
                    String param13 = (data5 == null || (permissions3 = data5.getPermissions()) == null || (notifications3 = permissions3.getNotifications()) == null || (items3 = notifications3.getItems()) == null || (titleWithParam3 = (TitleWithParam) CollectionsKt.getOrNull(items3, 0)) == null) ? null : titleWithParam3.getParam1();
                    if (param13 == null) {
                        param13 = "";
                    }
                    SpannableString spannableStringHighlightText2 = ViewUtilsKt.highlightText(title3, param13, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data6 = getLocalizationStorage().getData();
                    String title4 = (data6 == null || (permissions2 = data6.getPermissions()) == null || (notifications2 = permissions2.getNotifications()) == null || (items2 = notifications2.getItems()) == null || (titleWithParam2 = (TitleWithParam) CollectionsKt.getOrNull(items2, 1)) == null) ? null : titleWithParam2.getTitle();
                    if (title4 == null) {
                        title4 = "";
                    }
                    LocalizationLocalModel data7 = getLocalizationStorage().getData();
                    if (data7 != null && (permissions = data7.getPermissions()) != null && (notifications = permissions.getNotifications()) != null && (items = notifications.getItems()) != null && (titleWithParam = (TitleWithParam) CollectionsKt.getOrNull(items, 1)) != null) {
                        param1 = titleWithParam.getParam1();
                    }
                    return new PermissionExplaining(title, CollectionsKt.listOf((Object[]) new SpannableString[]{spannableStringHighlightText, spannableStringHighlightText2, ViewUtilsKt.highlightText(title4, param1 != null ? param1 : "", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
                }
                break;
            case -1888586689:
                if (permission.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    LocalizationLocalModel data8 = getLocalizationStorage().getData();
                    String title5 = (data8 == null || (permissions14 = data8.getPermissions()) == null || (location5 = permissions14.getLocation()) == null) ? null : location5.getTitle();
                    if (title5 == null) {
                        title5 = "";
                    }
                    LocalizationLocalModel data9 = getLocalizationStorage().getData();
                    String title6 = (data9 == null || (permissions13 = data9.getPermissions()) == null || (tapPermissions4 = permissions13.getTapPermissions()) == null) ? null : tapPermissions4.getTitle();
                    if (title6 == null) {
                        title6 = "";
                    }
                    LocalizationLocalModel data10 = getLocalizationStorage().getData();
                    String param14 = (data10 == null || (permissions12 = data10.getPermissions()) == null || (tapPermissions3 = permissions12.getTapPermissions()) == null) ? null : tapPermissions3.getParam1();
                    if (param14 == null) {
                        param14 = "";
                    }
                    SpannableString spannableStringHighlightText3 = ViewUtilsKt.highlightText(title6, param14, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data11 = getLocalizationStorage().getData();
                    String title7 = (data11 == null || (permissions11 = data11.getPermissions()) == null || (location4 = permissions11.getLocation()) == null || (items8 = location4.getItems()) == null || (titleWithParam8 = (TitleWithParam) CollectionsKt.getOrNull(items8, 0)) == null) ? null : titleWithParam8.getTitle();
                    if (title7 == null) {
                        title7 = "";
                    }
                    LocalizationLocalModel data12 = getLocalizationStorage().getData();
                    String param15 = (data12 == null || (permissions10 = data12.getPermissions()) == null || (location3 = permissions10.getLocation()) == null || (items7 = location3.getItems()) == null || (titleWithParam7 = (TitleWithParam) CollectionsKt.getOrNull(items7, 0)) == null) ? null : titleWithParam7.getParam1();
                    if (param15 == null) {
                        param15 = "";
                    }
                    SpannableString spannableStringHighlightText4 = ViewUtilsKt.highlightText(title7, param15, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data13 = getLocalizationStorage().getData();
                    String title8 = (data13 == null || (permissions9 = data13.getPermissions()) == null || (location2 = permissions9.getLocation()) == null || (items6 = location2.getItems()) == null || (titleWithParam6 = (TitleWithParam) CollectionsKt.getOrNull(items6, 1)) == null) ? null : titleWithParam6.getTitle();
                    if (title8 == null) {
                        title8 = "";
                    }
                    LocalizationLocalModel data14 = getLocalizationStorage().getData();
                    if (data14 != null && (permissions8 = data14.getPermissions()) != null && (location = permissions8.getLocation()) != null && (items5 = location.getItems()) != null && (titleWithParam5 = (TitleWithParam) CollectionsKt.getOrNull(items5, 1)) != null) {
                        param1 = titleWithParam5.getParam1();
                    }
                    return new PermissionExplaining(title5, CollectionsKt.listOf((Object[]) new SpannableString[]{spannableStringHighlightText3, spannableStringHighlightText4, ViewUtilsKt.highlightText(title8, param1 != null ? param1 : "", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
                }
                break;
            case -784330217:
                if (permission.equals("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    LocalizationLocalModel data15 = getLocalizationStorage().getData();
                    String title9 = (data15 == null || (permissions21 = data15.getPermissions()) == null || (whitelist7 = permissions21.getWhitelist()) == null) ? null : whitelist7.getTitle();
                    if (title9 == null) {
                        title9 = "";
                    }
                    LocalizationLocalModel data16 = getLocalizationStorage().getData();
                    String title10 = (data16 == null || (permissions20 = data16.getPermissions()) == null || (whitelist6 = permissions20.getWhitelist()) == null || (items14 = whitelist6.getItems()) == null || (titleWithParam14 = (TitleWithParam) CollectionsKt.getOrNull(items14, 0)) == null) ? null : titleWithParam14.getTitle();
                    if (title10 == null) {
                        title10 = "";
                    }
                    LocalizationLocalModel data17 = getLocalizationStorage().getData();
                    String param16 = (data17 == null || (permissions19 = data17.getPermissions()) == null || (whitelist5 = permissions19.getWhitelist()) == null || (items13 = whitelist5.getItems()) == null || (titleWithParam13 = (TitleWithParam) CollectionsKt.getOrNull(items13, 0)) == null) ? null : titleWithParam13.getParam1();
                    if (param16 == null) {
                        param16 = "";
                    }
                    SpannableString spannableStringHighlightText5 = ViewUtilsKt.highlightText(title10, param16, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data18 = getLocalizationStorage().getData();
                    String title11 = (data18 == null || (permissions18 = data18.getPermissions()) == null || (whitelist4 = permissions18.getWhitelist()) == null || (items12 = whitelist4.getItems()) == null || (titleWithParam12 = (TitleWithParam) CollectionsKt.getOrNull(items12, 1)) == null) ? null : titleWithParam12.getTitle();
                    if (title11 == null) {
                        title11 = "";
                    }
                    LocalizationLocalModel data19 = getLocalizationStorage().getData();
                    String param17 = (data19 == null || (permissions17 = data19.getPermissions()) == null || (whitelist3 = permissions17.getWhitelist()) == null || (items11 = whitelist3.getItems()) == null || (titleWithParam11 = (TitleWithParam) CollectionsKt.getOrNull(items11, 1)) == null) ? null : titleWithParam11.getParam1();
                    if (param17 == null) {
                        param17 = "";
                    }
                    SpannableString spannableStringHighlightText6 = ViewUtilsKt.highlightText(title11, param17, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data20 = getLocalizationStorage().getData();
                    String title12 = (data20 == null || (permissions16 = data20.getPermissions()) == null || (whitelist2 = permissions16.getWhitelist()) == null || (items10 = whitelist2.getItems()) == null || (titleWithParam10 = (TitleWithParam) CollectionsKt.getOrNull(items10, 2)) == null) ? null : titleWithParam10.getTitle();
                    if (title12 == null) {
                        title12 = "";
                    }
                    LocalizationLocalModel data21 = getLocalizationStorage().getData();
                    if (data21 != null && (permissions15 = data21.getPermissions()) != null && (whitelist = permissions15.getWhitelist()) != null && (items9 = whitelist.getItems()) != null && (titleWithParam9 = (TitleWithParam) CollectionsKt.getOrNull(items9, 2)) != null) {
                        param1 = titleWithParam9.getParam1();
                    }
                    return new PermissionExplaining(title9, CollectionsKt.listOf((Object[]) new SpannableString[]{spannableStringHighlightText5, spannableStringHighlightText6, ViewUtilsKt.highlightText(title12, param1 != null ? param1 : "", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
                }
                break;
            case -339880686:
                if (permission.equals("permission_background_work")) {
                    LocalizationLocalModel data22 = getLocalizationStorage().getData();
                    String title13 = (data22 == null || (permissions26 = data22.getPermissions()) == null || (backgroundWork5 = permissions26.getBackgroundWork()) == null) ? null : backgroundWork5.getTitle();
                    if (title13 == null) {
                        title13 = "";
                    }
                    LocalizationLocalModel data23 = getLocalizationStorage().getData();
                    String title14 = (data23 == null || (permissions25 = data23.getPermissions()) == null || (backgroundWork4 = permissions25.getBackgroundWork()) == null || (items18 = backgroundWork4.getItems()) == null || (titleWithParam18 = (TitleWithParam) CollectionsKt.getOrNull(items18, 0)) == null) ? null : titleWithParam18.getTitle();
                    if (title14 == null) {
                        title14 = "";
                    }
                    LocalizationLocalModel data24 = getLocalizationStorage().getData();
                    String param18 = (data24 == null || (permissions24 = data24.getPermissions()) == null || (backgroundWork3 = permissions24.getBackgroundWork()) == null || (items17 = backgroundWork3.getItems()) == null || (titleWithParam17 = (TitleWithParam) CollectionsKt.getOrNull(items17, 0)) == null) ? null : titleWithParam17.getParam1();
                    if (param18 == null) {
                        param18 = "";
                    }
                    SpannableString spannableStringHighlightText7 = ViewUtilsKt.highlightText(title14, param18, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data25 = getLocalizationStorage().getData();
                    String title15 = (data25 == null || (permissions23 = data25.getPermissions()) == null || (backgroundWork2 = permissions23.getBackgroundWork()) == null || (items16 = backgroundWork2.getItems()) == null || (titleWithParam16 = (TitleWithParam) CollectionsKt.getOrNull(items16, 1)) == null) ? null : titleWithParam16.getTitle();
                    if (title15 == null) {
                        title15 = "";
                    }
                    LocalizationLocalModel data26 = getLocalizationStorage().getData();
                    if (data26 != null && (permissions22 = data26.getPermissions()) != null && (backgroundWork = permissions22.getBackgroundWork()) != null && (items15 = backgroundWork.getItems()) != null && (titleWithParam15 = (TitleWithParam) CollectionsKt.getOrNull(items15, 1)) != null) {
                        param1 = titleWithParam15.getParam1();
                    }
                    return new PermissionExplaining(title13, CollectionsKt.listOf((Object[]) new SpannableString[]{spannableStringHighlightText7, ViewUtilsKt.highlightText(title15, param1 != null ? param1 : "", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
                }
                break;
            case 2024715147:
                if (permission.equals(LocationConstant.BACKGROUND_PERMISSION)) {
                    LocalizationLocalModel data27 = getLocalizationStorage().getData();
                    String title16 = (data27 == null || (permissions33 = data27.getPermissions()) == null || (location10 = permissions33.getLocation()) == null) ? null : location10.getTitle();
                    if (title16 == null) {
                        title16 = "";
                    }
                    LocalizationLocalModel data28 = getLocalizationStorage().getData();
                    String title17 = (data28 == null || (permissions32 = data28.getPermissions()) == null || (tapPermissions6 = permissions32.getTapPermissions()) == null) ? null : tapPermissions6.getTitle();
                    if (title17 == null) {
                        title17 = "";
                    }
                    LocalizationLocalModel data29 = getLocalizationStorage().getData();
                    String param19 = (data29 == null || (permissions31 = data29.getPermissions()) == null || (tapPermissions5 = permissions31.getTapPermissions()) == null) ? null : tapPermissions5.getParam1();
                    if (param19 == null) {
                        param19 = "";
                    }
                    SpannableString spannableStringHighlightText8 = ViewUtilsKt.highlightText(title17, param19, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data30 = getLocalizationStorage().getData();
                    String title18 = (data30 == null || (permissions30 = data30.getPermissions()) == null || (location9 = permissions30.getLocation()) == null || (items22 = location9.getItems()) == null || (titleWithParam22 = (TitleWithParam) CollectionsKt.getOrNull(items22, 0)) == null) ? null : titleWithParam22.getTitle();
                    if (title18 == null) {
                        title18 = "";
                    }
                    LocalizationLocalModel data31 = getLocalizationStorage().getData();
                    String param110 = (data31 == null || (permissions29 = data31.getPermissions()) == null || (location8 = permissions29.getLocation()) == null || (items21 = location8.getItems()) == null || (titleWithParam21 = (TitleWithParam) CollectionsKt.getOrNull(items21, 0)) == null) ? null : titleWithParam21.getParam1();
                    if (param110 == null) {
                        param110 = "";
                    }
                    SpannableString spannableStringHighlightText9 = ViewUtilsKt.highlightText(title18, param110, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data32 = getLocalizationStorage().getData();
                    String title19 = (data32 == null || (permissions28 = data32.getPermissions()) == null || (location7 = permissions28.getLocation()) == null || (items20 = location7.getItems()) == null || (titleWithParam20 = (TitleWithParam) CollectionsKt.getOrNull(items20, 1)) == null) ? null : titleWithParam20.getTitle();
                    if (title19 == null) {
                        title19 = "";
                    }
                    LocalizationLocalModel data33 = getLocalizationStorage().getData();
                    if (data33 != null && (permissions27 = data33.getPermissions()) != null && (location6 = permissions27.getLocation()) != null && (items19 = location6.getItems()) != null && (titleWithParam19 = (TitleWithParam) CollectionsKt.getOrNull(items19, 1)) != null) {
                        param1 = titleWithParam19.getParam1();
                    }
                    return new PermissionExplaining(title16, CollectionsKt.listOf((Object[]) new SpannableString[]{spannableStringHighlightText8, spannableStringHighlightText9, ViewUtilsKt.highlightText(title19, param1 != null ? param1 : "", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
                }
                break;
            case 2062356686:
                if (permission.equals("android.permission.BLUETOOTH_SCAN")) {
                    LocalizationLocalModel data34 = getLocalizationStorage().getData();
                    String title20 = (data34 == null || (permissions40 = data34.getPermissions()) == null || (nearbyDevices5 = permissions40.getNearbyDevices()) == null) ? null : nearbyDevices5.getTitle();
                    if (title20 == null) {
                        title20 = "";
                    }
                    LocalizationLocalModel data35 = getLocalizationStorage().getData();
                    String title21 = (data35 == null || (permissions39 = data35.getPermissions()) == null || (tapPermissions8 = permissions39.getTapPermissions()) == null) ? null : tapPermissions8.getTitle();
                    if (title21 == null) {
                        title21 = "";
                    }
                    LocalizationLocalModel data36 = getLocalizationStorage().getData();
                    String param111 = (data36 == null || (permissions38 = data36.getPermissions()) == null || (tapPermissions7 = permissions38.getTapPermissions()) == null) ? null : tapPermissions7.getParam1();
                    if (param111 == null) {
                        param111 = "";
                    }
                    SpannableString spannableStringHighlightText10 = ViewUtilsKt.highlightText(title21, param111, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data37 = getLocalizationStorage().getData();
                    String title22 = (data37 == null || (permissions37 = data37.getPermissions()) == null || (nearbyDevices4 = permissions37.getNearbyDevices()) == null || (items26 = nearbyDevices4.getItems()) == null || (titleWithParam26 = (TitleWithParam) CollectionsKt.getOrNull(items26, 0)) == null) ? null : titleWithParam26.getTitle();
                    if (title22 == null) {
                        title22 = "";
                    }
                    LocalizationLocalModel data38 = getLocalizationStorage().getData();
                    String param112 = (data38 == null || (permissions36 = data38.getPermissions()) == null || (nearbyDevices3 = permissions36.getNearbyDevices()) == null || (items25 = nearbyDevices3.getItems()) == null || (titleWithParam25 = (TitleWithParam) CollectionsKt.getOrNull(items25, 0)) == null) ? null : titleWithParam25.getParam1();
                    if (param112 == null) {
                        param112 = "";
                    }
                    SpannableString spannableStringHighlightText11 = ViewUtilsKt.highlightText(title22, param112, ContextCompat.getColor(requireContext(), R.color.sputnik_blue));
                    LocalizationLocalModel data39 = getLocalizationStorage().getData();
                    String title23 = (data39 == null || (permissions35 = data39.getPermissions()) == null || (nearbyDevices2 = permissions35.getNearbyDevices()) == null || (items24 = nearbyDevices2.getItems()) == null || (titleWithParam24 = (TitleWithParam) CollectionsKt.getOrNull(items24, 1)) == null) ? null : titleWithParam24.getTitle();
                    if (title23 == null) {
                        title23 = "";
                    }
                    LocalizationLocalModel data40 = getLocalizationStorage().getData();
                    if (data40 != null && (permissions34 = data40.getPermissions()) != null && (nearbyDevices = permissions34.getNearbyDevices()) != null && (items23 = nearbyDevices.getItems()) != null && (titleWithParam23 = (TitleWithParam) CollectionsKt.getOrNull(items23, 1)) != null) {
                        param1 = titleWithParam23.getParam1();
                    }
                    return new PermissionExplaining(title20, CollectionsKt.listOf((Object[]) new SpannableString[]{spannableStringHighlightText10, spannableStringHighlightText11, ViewUtilsKt.highlightText(title23, param1 != null ? param1 : "", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
                }
                break;
        }
        return new PermissionExplaining("Разрешите приложению “Наш дом” определение вашего местоположения", CollectionsKt.listOf((Object[]) new SpannableString[]{ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue)), ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue)), ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue)), ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue)), ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue)), ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue)), ViewUtilsKt.highlightText("Нажмите ”Разрешения Местоположение”", "”Разрешения Местоположение”", ContextCompat.getColor(requireContext(), R.color.sputnik_blue))}));
    }

    /* compiled from: BottomSheetPermissionExplaining.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/permissions/BottomSheetPermissionExplaining$PermissionExplaining;", "", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Landroid/text/SpannableString;", "options", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PermissionExplaining {
        private final List<SpannableString> options;
        private final String title;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionExplaining)) {
                return false;
            }
            PermissionExplaining permissionExplaining = (PermissionExplaining) other;
            return Intrinsics.areEqual(this.title, permissionExplaining.title) && Intrinsics.areEqual(this.options, permissionExplaining.options);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.options.hashCode();
        }

        public String toString() {
            return "PermissionExplaining(title=" + this.title + ", options=" + this.options + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PermissionExplaining(String title, List<? extends SpannableString> options) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(options, "options");
            this.title = title;
            this.options = options;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<SpannableString> getOptions() {
            return this.options;
        }
    }
}
