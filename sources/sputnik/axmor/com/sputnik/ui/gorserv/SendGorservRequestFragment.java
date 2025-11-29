package sputnik.axmor.com.sputnik.ui.gorserv;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
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
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GorservEvents;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.gorserv.GorservCatalog;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.GorservViewModel;
import com.sputnik.common.viewmodels.GorservViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
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
import sputnik.axmor.com.databinding.FragmentSendGorservRequestBinding;
import sputnik.axmor.com.sputnik.entities.gorserv.GorservCategoriesKt;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: SendGorservRequestFragment.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u00105\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/gorserv/SendGorservRequestFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentSendGorservRequestBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSendGorservRequestBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/GorservViewModel;", "gorservViewModel$delegate", "getGorservViewModel", "()Lcom/sputnik/common/viewmodels/GorservViewModel;", "gorservViewModel", "", "itemId$delegate", "getItemId", "()Ljava/lang/String;", "itemId", "Landroidx/navigation/NavController;", "navController$delegate", "getNavController", "()Landroidx/navigation/NavController;", "navController", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendGorservRequestFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SendGorservRequestFragment.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSendGorservRequestBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: gorservViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gorservViewModel;

    /* renamed from: itemId$delegate, reason: from kotlin metadata */
    private final Lazy itemId;
    public LocalizationStorage localizationScreen;

    /* renamed from: navController$delegate, reason: from kotlin metadata */
    private final Lazy navController;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSendGorservRequestBinding getBinding() {
        return (FragmentSendGorservRequestBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GorservViewModel getGorservViewModel() {
        return (GorservViewModel) this.gorservViewModel.getValue();
    }

    private final String getItemId() {
        return (String) this.itemId.getValue();
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
        ConstraintLayout toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ViewKt.addSystemWindowInsetToMargin$default(toolbar, true, true, true, false, 8, null);
        ConstraintLayout toolbar2 = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        ViewKt.addSystemWindowInsetToPadding$default(toolbar2, true, true, true, false, 8, null);
        GorservViewModel gorservViewModel = getGorservViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        gorservViewModel.observeState(viewLifecycleOwner, new Function1<GorservViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GorservViewState gorservViewState) {
                invoke2(gorservViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GorservViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SendGorservRequestFragment.this.getBinding().tvUserPhone.setText(it.getCurrentPhone());
            }
        });
        GorservViewModel gorservViewModel2 = getGorservViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        gorservViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment.onViewCreated.2
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
                SendGorservRequestFragment sendGorservRequestFragment = SendGorservRequestFragment.this;
                NestedScrollView root = sendGorservRequestFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(sendGorservRequestFragment, root, it);
            }
        });
        GorservViewModel gorservViewModel3 = getGorservViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        gorservViewModel3.observeSubState(viewLifecycleOwner3, new Function1<GorservViewState, Resource.Status>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(GorservViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCreateTicketState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment.onViewCreated.4

            /* compiled from: SendGorservRequestFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$onViewCreated$4$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
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
                int i = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                if (i == 1) {
                    GorservViewModel.clearCreateTicketState$default(SendGorservRequestFragment.this.getGorservViewModel(), false, 1, null);
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(SendGorservRequestFragment.this), R.id.action_sendGorservRequestFragment_to_gorservErrorDialog, null, null, 6, null);
                } else if (i == 2) {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(SendGorservRequestFragment.this), R.id.action_sendGorservRequestFragment_to_bottomSheetGorservRequestSent, null, null, 6, null);
                }
                AppCompatButton btnSendRequest = SendGorservRequestFragment.this.getBinding().btnSendRequest;
                Intrinsics.checkNotNullExpressionValue(btnSendRequest, "btnSendRequest");
                ViewBindingUtilsKt.showProgressBasedOn$default(btnSendRequest, it == Resource.Status.LOADING, "Отправить заявку", 0, false, 12, null);
            }
        });
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        Object next;
        final FragmentSendGorservRequestBinding binding = getBinding();
        ImageView imageView = binding.ivIcon;
        List<GorservCatalog> catalogs = getGorservViewModel().getCurrentState().getCatalogs();
        String id = null;
        if (catalogs != null) {
            Iterator<T> it = catalogs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((GorservCatalog) next).getId(), String.valueOf(getItemId()))) {
                        break;
                    }
                }
            }
            GorservCatalog gorservCatalog = (GorservCatalog) next;
            if (gorservCatalog != null) {
                id = gorservCatalog.getId();
            }
        }
        imageView.setImageResource(GorservCategoriesKt.getIconForCategory(String.valueOf(id)));
        binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendGorservRequestFragment.initViews$lambda$6$lambda$1(this.f$0, view);
            }
        });
        binding.btnEditPhone.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendGorservRequestFragment.initViews$lambda$6$lambda$2(this.f$0, view);
            }
        });
        binding.btnSendRequest.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendGorservRequestFragment.initViews$lambda$6$lambda$4(this.f$0, binding, view);
            }
        });
        binding.btnAbout.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendGorservRequestFragment.initViews$lambda$6$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$1(SendGorservRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$2(SendGorservRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickNumberEditing());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_sendGorservRequestFragment_to_changeGorservUserPhoneDialog, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$4(SendGorservRequestFragment this$0, FragmentSendGorservRequestBinding this_with, View view) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        GorservViewModel gorservViewModel = this$0.getGorservViewModel();
        String string = this_with.etComment.getText().toString();
        List<GorservCatalog> catalogs = this$0.getGorservViewModel().getCurrentState().getCatalogs();
        String id = null;
        if (catalogs != null) {
            Iterator<T> it = catalogs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((GorservCatalog) next).getId(), String.valueOf(this$0.getItemId()))) {
                        break;
                    }
                }
            }
            GorservCatalog gorservCatalog = (GorservCatalog) next;
            if (gorservCatalog != null) {
                id = gorservCatalog.getId();
            }
        }
        gorservViewModel.createTicket(string, String.valueOf(id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$5(SendGorservRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickAboutGorserv());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_selectGorservCategoryFragment_to_aboutGorservFragment, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    @Override // com.sputnik.common.base.IBaseMethods
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void localize() {
        /*
            r7 = this;
            sputnik.axmor.com.databinding.FragmentSendGorservRequestBinding r0 = r7.getBinding()
            android.widget.TextView r1 = r0.tvToolbarTitle
            java.lang.String r2 = "Бытовые услуги"
            r1.setText(r2)
            android.widget.TextView r1 = r0.tvGorservTitle
            java.lang.String r2 = "Вызвать мастера на дом"
            r1.setText(r2)
            android.widget.TextView r1 = r0.tvCallHint
            java.lang.String r2 = "Категория услуг"
            r1.setText(r2)
            android.widget.TextView r1 = r0.tvSelectedCategoryTitle
            com.sputnik.common.viewmodels.GorservViewModel r2 = r7.getGorservViewModel()
            com.sputnik.common.base.VMState r2 = r2.getCurrentState()
            com.sputnik.common.viewmodels.GorservViewState r2 = (com.sputnik.common.viewmodels.GorservViewState) r2
            java.util.List r2 = r2.getCatalogs()
            r3 = 0
            if (r2 == 0) goto L5c
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L32:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L52
            java.lang.Object r4 = r2.next()
            r5 = r4
            com.sputnik.common.entities.gorserv.GorservCatalog r5 = (com.sputnik.common.entities.gorserv.GorservCatalog) r5
            java.lang.String r5 = r5.getId()
            java.lang.String r6 = r7.getItemId()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L32
            goto L53
        L52:
            r4 = r3
        L53:
            com.sputnik.common.entities.gorserv.GorservCatalog r4 = (com.sputnik.common.entities.gorserv.GorservCatalog) r4
            if (r4 == 0) goto L5c
            java.lang.String r2 = r4.getTitle()
            goto L5d
        L5c:
            r2 = r3
        L5d:
            r1.setText(r2)
            android.widget.TextView r1 = r0.tvCommentHint
            java.lang.String r2 = "Опишите задачу (опционально)"
            r1.setText(r2)
            android.widget.TextView r1 = r0.tvPhoneDetails
            java.lang.String r2 = "Для уточнения деталей мы свяжемся с Вами по этому номеру"
            r1.setText(r2)
            androidx.appcompat.widget.AppCompatButton r1 = r0.btnSendRequest
            java.lang.String r2 = "Отправить заявку"
            r1.setText(r2)
            com.sputnik.data.local.PrefManager r1 = r7.getPrefManager()
            com.sputnik.domain.entities.prefs.LoginState r1 = r1.getLoginState()
            java.util.List r1 = r1.getSessions()
            if (r1 == 0) goto Lc6
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L89:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lc4
            java.lang.Object r2 = r1.next()
            r4 = r2
            com.sputnik.domain.entities.prefs.LoginState$Session r4 = (com.sputnik.domain.entities.prefs.LoginState.Session) r4
            java.lang.String r5 = r4.getCountryCode()
            java.lang.String r4 = r4.getPhone()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r4 = com.sputnik.common.utils.StringUtilsKt.toPhoneHash(r4)
            com.sputnik.data.local.PrefManager r5 = r7.getPrefManager()
            java.lang.String r5 = r5.getPhone()
            java.lang.String r5 = com.sputnik.common.utils.StringUtilsKt.toPhoneHash(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L89
            r3 = r2
        Lc4:
            com.sputnik.domain.entities.prefs.LoginState$Session r3 = (com.sputnik.domain.entities.prefs.LoginState.Session) r3
        Lc6:
            if (r3 == 0) goto Le4
            android.widget.TextView r0 = r0.tvUserPhone
            java.lang.String r1 = r3.getCountryCode()
            java.lang.String r2 = r3.getPhone()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            r0.setText(r1)
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment.localize():void");
    }

    public SendGorservRequestFragment() {
        super(R.layout.fragment_send_gorserv_request);
        this.binding = new ViewBindingFragmentDelegate(this, SendGorservRequestFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.gorservViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GorservViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$gorservViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.itemId = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$itemId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("item", null);
                }
                return null;
            }
        });
        this.navController = LazyKt.lazy(new Function0<NavController>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.SendGorservRequestFragment$navController$2
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
