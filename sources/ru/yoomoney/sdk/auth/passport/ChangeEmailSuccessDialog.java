package ru.yoomoney.sdk.auth.passport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.databinding.AuthChangeEmailInformationBinding;
import ru.yoomoney.sdk.gui.widget.text.TextTitle3View;
import ru.yoomoney.sdk.gui.widgetV2.dialog.BottomSheetDialogExtentionsKt;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u0011¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/passport/ChangeEmailSuccessDialog;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "()V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthChangeEmailInformationBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthChangeEmailInformationBinding;", "email", "", "getEmail", "()Ljava/lang/String;", "email$delegate", "Lkotlin/Lazy;", ChangeEmailSuccessDialog.KEY_MARKETING_ACCEPTED, "", "getMarketingAccepted", "()Z", "marketingAccepted$delegate", ChangeEmailSuccessDialog.KEY_USER_HAD_EMAIL, "getUserHadEmail", "userHadEmail$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChangeEmailSuccessDialog extends YmBaseBottomSheetDialogFragment {
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MARKETING_ACCEPTED = "marketingAccepted";
    private static final String KEY_USER_HAD_EMAIL = "userHadEmail";
    private AuthChangeEmailInformationBinding _binding;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = ChangeEmailSuccessDialog.class.getName();

    /* renamed from: email$delegate, reason: from kotlin metadata */
    private final Lazy email = LazyKt.lazy(new a());

    /* renamed from: userHadEmail$delegate, reason: from kotlin metadata */
    private final Lazy userHadEmail = LazyKt.lazy(new d());

    /* renamed from: marketingAccepted$delegate, reason: from kotlin metadata */
    private final Lazy marketingAccepted = LazyKt.lazy(new b());

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/passport/ChangeEmailSuccessDialog$Companion;", "", "()V", "KEY_EMAIL", "", "KEY_MARKETING_ACCEPTED", "KEY_USER_HAD_EMAIL", "TAG", "kotlin.jvm.PlatformType", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "email", ChangeEmailSuccessDialog.KEY_USER_HAD_EMAIL, "", ChangeEmailSuccessDialog.KEY_MARKETING_ACCEPTED, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            companion.show(fragmentManager, str, z, z2);
        }

        public final void show(FragmentManager manager, String email, boolean userHadEmail, boolean marketingAccepted) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(ChangeEmailSuccessDialog.TAG);
            ChangeEmailSuccessDialog changeEmailSuccessDialog = fragmentFindFragmentByTag instanceof ChangeEmailSuccessDialog ? (ChangeEmailSuccessDialog) fragmentFindFragmentByTag : null;
            if (changeEmailSuccessDialog == null) {
                changeEmailSuccessDialog = new ChangeEmailSuccessDialog();
            }
            Bundle bundle = new Bundle();
            bundle.putString("email", email);
            bundle.putBoolean(ChangeEmailSuccessDialog.KEY_USER_HAD_EMAIL, userHadEmail);
            bundle.putBoolean(ChangeEmailSuccessDialog.KEY_MARKETING_ACCEPTED, marketingAccepted);
            changeEmailSuccessDialog.setArguments(bundle);
            changeEmailSuccessDialog.show(manager, ChangeEmailSuccessDialog.TAG);
        }
    }

    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = ChangeEmailSuccessDialog.this.getArguments();
            if (arguments != null) {
                return arguments.getString("email");
            }
            return null;
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Bundle arguments = ChangeEmailSuccessDialog.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(ChangeEmailSuccessDialog.KEY_MARKETING_ACCEPTED) : false);
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ View b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(1);
            this.b = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            BottomSheetDialogExtentionsKt.getBehavior(ChangeEmailSuccessDialog.this).setPeekHeight(this.b.getMeasuredHeight());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Boolean> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Bundle arguments = ChangeEmailSuccessDialog.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(ChangeEmailSuccessDialog.KEY_USER_HAD_EMAIL) : true);
        }
    }

    private final AuthChangeEmailInformationBinding getBinding() {
        AuthChangeEmailInformationBinding authChangeEmailInformationBinding = this._binding;
        Intrinsics.checkNotNull(authChangeEmailInformationBinding);
        return authChangeEmailInformationBinding;
    }

    private final String getEmail() {
        return (String) this.email.getValue();
    }

    private final boolean getMarketingAccepted() {
        return ((Boolean) this.marketingAccepted.getValue()).booleanValue();
    }

    private final boolean getUserHadEmail() {
        return ((Boolean) this.userHadEmail.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ChangeEmailSuccessDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthChangeEmailInformationBinding.inflate(inflater, container, false);
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
        YmBaseBottomSheetDialogFragment.attachListener$default(this, new c(view), null, 2, null);
        if (getEmail() != null) {
            TextTitle3View title = getBinding().title;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            title.setVisibility(0);
            getBinding().title.setText(getString(getUserHadEmail() ? R.string.auth_change_email_success_title_change : R.string.auth_change_email_success_title_add, getEmail()));
        }
        getBinding().text.setText(getString(getUserHadEmail() ? R.string.auth_change_email_success_text_changed : getMarketingAccepted() ? R.string.auth_change_email_success_text_add_marketing : R.string.auth_change_email_success_text_add));
        getBinding().button.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.passport.ChangeEmailSuccessDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChangeEmailSuccessDialog.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
    }
}
