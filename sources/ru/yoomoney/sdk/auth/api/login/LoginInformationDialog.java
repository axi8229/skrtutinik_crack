package ru.yoomoney.sdk.auth.api.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.databinding.AuthLoginInformationBinding;
import ru.yoomoney.sdk.gui.widgetV2.dialog.BottomSheetDialogExtentionsKt;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginInformationDialog;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "()V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthLoginInformationBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthLoginInformationBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginInformationDialog extends YmBaseBottomSheetDialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LoginInformationDialog";
    private AuthLoginInformationBinding _binding;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginInformationDialog$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            new LoginInformationDialog().show(manager, LoginInformationDialog.TAG);
        }
    }

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ View b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(1);
            this.b = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            BottomSheetDialogExtentionsKt.getBehavior(LoginInformationDialog.this).setPeekHeight(this.b.getMeasuredHeight());
            return Unit.INSTANCE;
        }
    }

    private final AuthLoginInformationBinding getBinding() {
        AuthLoginInformationBinding authLoginInformationBinding = this._binding;
        Intrinsics.checkNotNull(authLoginInformationBinding);
        return authLoginInformationBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(LoginInformationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthLoginInformationBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YmBaseBottomSheetDialogFragment.attachListener$default(this, new a(view), null, 2, null);
        getBinding().button.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.api.login.LoginInformationDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginInformationDialog.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
    }
}
