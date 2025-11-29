package ru.yoomoney.sdk.auth.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcherKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.AuthEntryActivity;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\r\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001aJ'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J+\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00180'H\u0000¢\u0006\u0002\b)J+\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020*2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00180'H\u0000¢\u0006\u0002\b)J\u0012\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0017J\u001a\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010(H\u0016J\b\u00103\u001a\u00020\u0018H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00064"}, d2 = {"Lru/yoomoney/sdk/auth/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "navOptions", "Landroidx/navigation/NavOptions;", "getNavOptions", "()Landroidx/navigation/NavOptions;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "back", "", "cancelProcess", "cancelProcess$auth_release", "finishAuthWithResult", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "account", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", YooMoneyAuth.KEY_USER_HAS_MIGRATED, "", "finishAuthWithResult$auth_release", "navigate", "process", "Lru/yoomoney/sdk/auth/api/Process;", "args", "Lkotlin/Function1;", "Landroid/os/Bundle;", "navigate$auth_release", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "onCreate", "savedInstanceState", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "setupToolbar", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseFragment extends Fragment {
    private final NavOptions navOptions = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right).build();

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            new Bundle();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Bundle, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            new Bundle();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<OnBackPressedCallback, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(OnBackPressedCallback onBackPressedCallback) {
            OnBackPressedCallback addCallback = onBackPressedCallback;
            Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            BaseFragment.this.back();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void finishAuthWithResult$auth_release$default(BaseFragment baseFragment, String str, UserAccount userAccount, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishAuthWithResult");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        baseFragment.finishAuthWithResult$auth_release(str, userAccount, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void navigate$auth_release$default(BaseFragment baseFragment, Process process, Function1 function1, int i, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            function1 = a.a;
        }
        baseFragment.navigate$auth_release(process, (Function1<? super Bundle, Unit>) function1);
    }

    private final void setupToolbar() {
        TopBarDefault topBar = getTopBar();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        AppCompatActivity appCompatActivity = fragmentActivityRequireActivity instanceof AppCompatActivity ? (AppCompatActivity) fragmentActivityRequireActivity : null;
        if (appCompatActivity != null) {
            appCompatActivity.setSupportActionBar(topBar.getToolbar());
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
            appCompatActivity.setTitle((CharSequence) null);
        }
    }

    public void back() {
        int iBack = getRouter().back();
        if (iBack == -1 && (getActivity() instanceof AuthEntryActivity)) {
            cancelProcess$auth_release();
        } else {
            FragmentKt.findNavController(this).popBackStack(iBack, false);
        }
    }

    public final void cancelProcess$auth_release() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
            activity.finish();
        }
    }

    public final void finishAuthWithResult$auth_release(String accessToken, UserAccount account, boolean userHasMigrated) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(account, "account");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.AuthEntryActivity");
        ((AuthEntryActivity) fragmentActivityRequireActivity).finishWithResult$auth_release(accessToken, account, userHasMigrated);
    }

    public final NavOptions getNavOptions() {
        return this.navOptions;
    }

    public abstract ProcessMapper getProcessMapper();

    public abstract ResourceMapper getResourceMapper();

    public abstract Router getRouter();

    public abstract TopBarDefault getTopBar();

    public final void navigate$auth_release(Process process, Function1<? super Bundle, Unit> args) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(args, "args");
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        int next = getRouter().next(process);
        Bundle bundle = getProcessMapper().toBundle(process);
        args.invoke(bundle);
        Unit unit = Unit.INSTANCE;
        navControllerFindNavController.navigate(next, bundle, this.navOptions);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), this, false, new c(), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            back();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupToolbar();
        setHasOptionsMenu(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void navigate$auth_release$default(BaseFragment baseFragment, RegistrationProcess registrationProcess, Function1 function1, int i, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 2) != 0) {
            function1 = b.a;
        }
        baseFragment.navigate$auth_release(registrationProcess, (Function1<? super Bundle, Unit>) function1);
    }

    public final void navigate$auth_release(RegistrationProcess process, Function1<? super Bundle, Unit> args) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(args, "args");
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        int next = getRouter().next(process);
        Bundle bundle = getProcessMapper().toBundle(process);
        args.invoke(bundle);
        Unit unit = Unit.INSTANCE;
        navControllerFindNavController.navigate(next, bundle, this.navOptions);
    }
}
