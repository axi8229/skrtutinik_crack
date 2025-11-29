package ru.yoomoney.sdk.auth.identification.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lru/yoomoney/sdk/auth/identification/info/IdentificationInfoFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "action", "Lru/yoomoney/sdk/auth/ui/PrimaryButtonView;", "getAction", "()Lru/yoomoney/sdk/auth/ui/PrimaryButtonView;", "action$delegate", "Lkotlin/Lazy;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "topBar$delegate", "back", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IdentificationInfoFragment extends BaseFragment {

    /* renamed from: action$delegate, reason: from kotlin metadata */
    private final Lazy action;
    private final ProcessMapper processMapper;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: topBar$delegate, reason: from kotlin metadata */
    private final Lazy topBar;

    public static final class a extends Lambda implements Function0<PrimaryButtonView> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final PrimaryButtonView invoke() {
            View viewFindViewById = IdentificationInfoFragment.this.requireView().findViewById(R.id.action);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.ui.PrimaryButtonView");
            return (PrimaryButtonView) viewFindViewById;
        }
    }

    public static final class b extends Lambda implements Function0<TopBarDefault> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TopBarDefault invoke() {
            View viewFindViewById = IdentificationInfoFragment.this.requireView().findViewById(R.id.top_bar);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type ru.yoomoney.sdk.gui.widget.TopBarDefault");
            return (TopBarDefault) viewFindViewById;
        }
    }

    public IdentificationInfoFragment(Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        this.topBar = LazyKt.lazy(new b());
        this.action = LazyKt.lazy(new a());
    }

    private final PrimaryButtonView getAction() {
        return (PrimaryButtonView) this.action.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IdentificationInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.back();
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public void back() {
        FragmentKt.findNavController(this).popBackStack();
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ProcessMapper getProcessMapper() {
        return this.processMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ResourceMapper getResourceMapper() {
        return this.resourceMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public Router getRouter() {
        return this.router;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public TopBarDefault getTopBar() {
        return (TopBarDefault) this.topBar.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.auth_identification_info, container, false);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getAction().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.identification.info.IdentificationInfoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IdentificationInfoFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
    }
}
