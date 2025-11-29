package ru.yoomoney.sdk.auth.auxToken;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.api.model.Scope;
import ru.yoomoney.sdk.auth.auxToken.AuxTokenIssue;
import ru.yoomoney.sdk.auth.databinding.FragmentAuxTokenIssueBinding;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.PicassoExtensionsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010$\u001a\u00020%H\u0002J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020%H\u0016J\u001a\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0003J\u0010\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u001fH\u0002J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R1\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001cj\u0002` 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssueFragment;", "Landroidx/fragment/app/Fragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/FragmentAuxTokenIssueBinding;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "getAccessToken", "()Ljava/lang/String;", "accessToken$delegate", "Lkotlin/Lazy;", "authCenterClientId", "getAuthCenterClientId", "authCenterClientId$delegate", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/FragmentAuxTokenIssueBinding;", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "getScopes", "()Ljava/util/List;", "scopes$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Action;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect;", "Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssueViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "initUi", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showAccessContent", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "showEffect", "effect", "showState", "state", "showUserInfo", YooMoneyAuth.KEY_USER_ACCOUNT, "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxTokenIssueFragment extends Fragment {
    private FragmentAuxTokenIssueBinding _binding;

    /* renamed from: accessToken$delegate, reason: from kotlin metadata */
    private final Lazy accessToken;

    /* renamed from: authCenterClientId$delegate, reason: from kotlin metadata */
    private final Lazy authCenterClientId;
    private final ResourceMapper resourceMapper;

    /* renamed from: scopes$delegate, reason: from kotlin metadata */
    private final Lazy scopes;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = AuxTokenIssueFragment.this.getArguments();
            if (arguments != null) {
                return AuxTokenIssueFragmentArgs.fromBundle(arguments).getToken();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = AuxTokenIssueFragment.this.getArguments();
            if (arguments != null) {
                return AuxTokenIssueFragmentArgs.fromBundle(arguments).getAuthCenterClientId();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<AuxTokenIssue.State, Unit> {
        public c(Object obj) {
            super(1, obj, AuxTokenIssueFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuxTokenIssue.State state) {
            AuxTokenIssue.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuxTokenIssueFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<AuxTokenIssue.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, AuxTokenIssueFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/auxToken/AuxTokenIssue$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuxTokenIssue.Effect effect) {
            AuxTokenIssue.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuxTokenIssueFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            FrameLayout root = AuxTokenIssueFragment.this.getBinding().root;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            String string = AuxTokenIssueFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(root, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<List<? extends AuxTokenScope>> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AuxTokenScope> invoke() {
            Bundle arguments = AuxTokenIssueFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String[] scopes = AuxTokenIssueFragmentArgs.fromBundle(arguments).getScopes();
            Intrinsics.checkNotNullExpressionValue(scopes, "getScopes(...)");
            ArrayList arrayList = new ArrayList();
            for (String str : scopes) {
                Intrinsics.checkNotNull(str);
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                if (listSplit$default.size() != 2) {
                    listSplit$default = null;
                }
                AuxTokenScope auxTokenScopeFrom = listSplit$default != null ? AuxTokenScope.INSTANCE.from((String) CollectionsKt.first(listSplit$default), (String) CollectionsKt.last(listSplit$default)) : null;
                if (auxTokenScopeFrom != null) {
                    arrayList.add(auxTokenScopeFrom);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(((AuxTokenScope) next) instanceof AuxTokenScope.Undefined)) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
    }

    public static final class g extends Lambda implements Function1<String, CharSequence> {
        public static final g a = new g();

        public g() {
            super(1);
        }

        public static String a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "— " + it + "\n";
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ CharSequence invoke(String str) {
            return a(str);
        }
    }

    public static final class h extends Lambda implements Function0<Unit> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RuntimeViewModel viewModel = AuxTokenIssueFragment.this.getViewModel();
            String accessToken = AuxTokenIssueFragment.this.getAccessToken();
            Intrinsics.checkNotNullExpressionValue(accessToken, "access$getAccessToken(...)");
            List scopes = AuxTokenIssueFragment.this.getScopes();
            String authCenterClientId = AuxTokenIssueFragment.this.getAuthCenterClientId();
            Intrinsics.checkNotNullExpressionValue(authCenterClientId, "access$getAuthCenterClientId(...)");
            viewModel.handleAction(new AuxTokenIssue.Action.LoadAuxAuthorizationInfo(accessToken, scopes, authCenterClientId));
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function0<ViewModelProvider.Factory> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return AuxTokenIssueFragment.this.viewModelFactory;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuxTokenIssueFragment(ViewModelProvider.Factory viewModelFactory, ResourceMapper resourceMapper) {
        super(R.layout.fragment_aux_token_issue);
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.resourceMapper = resourceMapper;
        i iVar = new i();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, iVar);
        this.accessToken = LazyKt.lazy(new a());
        this.authCenterClientId = LazyKt.lazy(new b());
        this.scopes = LazyKt.lazy(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAccessToken() {
        return (String) this.accessToken.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAuthCenterClientId() {
        return (String) this.authCenterClientId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentAuxTokenIssueBinding getBinding() {
        FragmentAuxTokenIssueBinding fragmentAuxTokenIssueBinding = this._binding;
        Intrinsics.checkNotNull(fragmentAuxTokenIssueBinding);
        return fragmentAuxTokenIssueBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AuxTokenScope> getScopes() {
        return (List) this.scopes.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<AuxTokenIssue.State, AuxTokenIssue.Action, AuxTokenIssue.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void initUi() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ImageView imageView = getBinding().close;
        Drawable drawable = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_close);
        imageView.setImageDrawable(drawable != null ? DrawableExtensions.tint(drawable, ColorScheme.INSTANCE.getAccentColor(contextRequireContext)) : null);
        getBinding().close.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuxTokenIssueFragment.initUi$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUi$lambda$1(AuxTokenIssueFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        fragmentActivityRequireActivity.finish();
    }

    @SuppressLint({"SetTextI18n"})
    private final void showAccessContent(ApplicationInfo applicationInfo) {
        getBinding().title.setText(getString(R.string.auth_allow_access_title));
        TextBodyView textBodyView = getBinding().subtitle;
        String string = getString(R.string.auth_allow_access_subtitle, applicationInfo.getTitle());
        List<Scope> scopes = applicationInfo.getScopes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = scopes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Scope) it.next()).getTitles());
        }
        textBodyView.setText(string + CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, g.a, 30, null));
        getBinding().primaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuxTokenIssueFragment.showAccessContent$lambda$4(this.f$0, view);
            }
        });
        getBinding().secondaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuxTokenIssueFragment.showAccessContent$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAccessContent$lambda$4(AuxTokenIssueFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RuntimeViewModel<AuxTokenIssue.State, AuxTokenIssue.Action, AuxTokenIssue.Effect> viewModel = this$0.getViewModel();
        String accessToken = this$0.getAccessToken();
        Intrinsics.checkNotNullExpressionValue(accessToken, "<get-accessToken>(...)");
        viewModel.handleAction(new AuxTokenIssue.Action.IssueAuxToken(accessToken, this$0.getScopes(), this$0.getAuthCenterClientId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAccessContent$lambda$6(final AuxTokenIssueFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(this$0.getString(R.string.auth_allow_access_dialog_title), this$0.getString(R.string.auth_allow_access_dialog_message), this$0.getString(R.string.auth_allow_access_dialog_negative_action), this$0.getString(R.string.auth_allow_access_dialog_positive_action), true, false, 32, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        final AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.auxToken.AuxTokenIssueFragment$showAccessContent$4$1$1
            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onDismiss() {
                YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onNegativeClick() {
                RuntimeViewModel viewModel = this$0.getViewModel();
                String accessToken = this$0.getAccessToken();
                Intrinsics.checkNotNullExpressionValue(accessToken, "access$getAccessToken(...)");
                viewModel.handleAction(new AuxTokenIssue.Action.IssueAuxToken(accessToken, this$0.getScopes(), this$0.getAuthCenterClientId()));
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onPositiveClick() {
                FragmentActivity fragmentActivityRequireActivity = alertDialogCreate.requireActivity();
                fragmentActivityRequireActivity.setResult(0);
                fragmentActivityRequireActivity.finish();
            }
        });
        FragmentManager childFragmentManager2 = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(AuxTokenIssue.Effect effect) {
        if (effect instanceof AuxTokenIssue.Effect.AuxTokenIssued) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.setResult(-1, new Intent().putExtra(YooMoneyAuth.KEY_AUX_TOKEN, ((AuxTokenIssue.Effect.AuxTokenIssued) effect).getAuxToken()));
            fragmentActivityRequireActivity.finish();
        } else if (effect instanceof AuxTokenIssue.Effect.AuxTokenIssueFailed) {
            FrameLayout root = getBinding().root;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            CoreFragmentExtensions.noticeError(root, this.resourceMapper.map(((AuxTokenIssue.Effect.AuxTokenIssueFailed) effect).getFailure()));
            getBinding().primaryAction.showProgress(false);
            getBinding().secondaryAction.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(AuxTokenIssue.State state) {
        if (state instanceof AuxTokenIssue.State.LoadingAuxAuthorizationInfo) {
            getBinding().stateFlipper.showProgress();
            return;
        }
        if (state instanceof AuxTokenIssue.State.AuxAuthorizationInfoError) {
            getBinding().errorContainer.setSubtitle(this.resourceMapper.map(((AuxTokenIssue.State.AuxAuthorizationInfoError) state).getFailure()));
            getBinding().errorContainer.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close_m));
            getBinding().errorContainer.setAction(getString(R.string.auth_action_try_again));
            getBinding().errorContainer.setActionListener(new h());
            getBinding().stateFlipper.showError();
            return;
        }
        if (state instanceof AuxTokenIssue.State.AuxAuthorizationInfo) {
            getBinding().stateFlipper.showContent();
            AuxTokenIssue.State.AuxAuthorizationInfo auxAuthorizationInfo = (AuxTokenIssue.State.AuxAuthorizationInfo) state;
            showAccessContent(auxAuthorizationInfo.getApplicationInfo());
            showUserInfo(auxAuthorizationInfo.getAccount());
            return;
        }
        if (state instanceof AuxTokenIssue.State.IssuingToken) {
            getBinding().primaryAction.showProgress(true);
            getBinding().secondaryAction.setEnabled(false);
        }
    }

    private final void showUserInfo(UserAccount userAccount) {
        Unit unit;
        String url = userAccount.getAvatar().getUrl();
        if (url != null) {
            RequestCreator requestCreatorPlaceholder = Picasso.get().load(Uri.parse(url)).placeholder(R.drawable.auth_ic_avatar_placeholder);
            Intrinsics.checkNotNullExpressionValue(requestCreatorPlaceholder, "placeholder(...)");
            PicassoExtensionsKt.cropToCircle(requestCreatorPlaceholder).into(getBinding().avatar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getBinding().avatar.setImageResource(R.drawable.auth_ic_avatar_placeholder);
        }
        getBinding().userName.setText(userAccount.getDisplayName().getTitle());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentAuxTokenIssueBinding.inflate(inflater, container, false);
        FrameLayout root = getBinding().root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUi();
        RuntimeViewModel<AuxTokenIssue.State, AuxTokenIssue.Action, AuxTokenIssue.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new c(this), new d(this), new e());
        RuntimeViewModel<AuxTokenIssue.State, AuxTokenIssue.Action, AuxTokenIssue.Effect> viewModel2 = getViewModel();
        String accessToken = getAccessToken();
        Intrinsics.checkNotNullExpressionValue(accessToken, "<get-accessToken>(...)");
        List<AuxTokenScope> scopes = getScopes();
        String authCenterClientId = getAuthCenterClientId();
        Intrinsics.checkNotNullExpressionValue(authCenterClientId, "<get-authCenterClientId>(...)");
        viewModel2.handleAction(new AuxTokenIssue.Action.LoadAuxAuthorizationInfo(accessToken, scopes, authCenterClientId));
    }
}
