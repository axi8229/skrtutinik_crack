package ru.yoomoney.sdk.auth.support;

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
import ru.yoomoney.sdk.auth.databinding.AuthEmailConfirmSupportBinding;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.gui.widgetV2.dialog.BottomSheetDialogExtentionsKt;
import ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/support/EmailTechnicalSupportDialog;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/YmBaseBottomSheetDialogFragment;", "()V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthEmailConfirmSupportBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthEmailConfirmSupportBinding;", EmailTechnicalSupportDialog.KEY_EXPLANATION_TEXT, "", "getExplanationText", "()Ljava/lang/String;", "explanationText$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailTechnicalSupportDialog extends YmBaseBottomSheetDialogFragment {
    private static final String KEY_EXPLANATION_TEXT = "explanationText";
    private AuthEmailConfirmSupportBinding _binding;

    /* renamed from: explanationText$delegate, reason: from kotlin metadata */
    private final Lazy explanationText = LazyKt.lazy(new a());

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = EmailTechnicalSupportDialog.class.getName();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/support/EmailTechnicalSupportDialog$Companion;", "", "()V", "KEY_EXPLANATION_TEXT", "", "TAG", "kotlin.jvm.PlatformType", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", EmailTechnicalSupportDialog.KEY_EXPLANATION_TEXT, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(FragmentManager manager, String explanationText) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(explanationText, "explanationText");
            Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(EmailTechnicalSupportDialog.TAG);
            EmailTechnicalSupportDialog emailTechnicalSupportDialog = fragmentFindFragmentByTag instanceof EmailTechnicalSupportDialog ? (EmailTechnicalSupportDialog) fragmentFindFragmentByTag : null;
            if (emailTechnicalSupportDialog == null) {
                emailTechnicalSupportDialog = new EmailTechnicalSupportDialog();
            }
            Bundle bundle = new Bundle();
            bundle.putString(EmailTechnicalSupportDialog.KEY_EXPLANATION_TEXT, explanationText);
            emailTechnicalSupportDialog.setArguments(bundle);
            emailTechnicalSupportDialog.show(manager, EmailTechnicalSupportDialog.TAG);
        }
    }

    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = EmailTechnicalSupportDialog.this.getArguments();
            String string = arguments != null ? arguments.getString(EmailTechnicalSupportDialog.KEY_EXPLANATION_TEXT) : null;
            if (string == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Intrinsics.checkNotNullExpressionValue(string, "requireNotNull(...)");
            return string;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ View b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(1);
            this.b = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            BottomSheetDialogExtentionsKt.getBehavior(EmailTechnicalSupportDialog.this).setPeekHeight(this.b.getMeasuredHeight());
            return Unit.INSTANCE;
        }
    }

    private final AuthEmailConfirmSupportBinding getBinding() {
        AuthEmailConfirmSupportBinding authEmailConfirmSupportBinding = this._binding;
        Intrinsics.checkNotNull(authEmailConfirmSupportBinding);
        return authEmailConfirmSupportBinding;
    }

    private final String getExplanationText() {
        return (String) this.explanationText.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(EmailTechnicalSupportDialog this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        CoreFragmentExtensions.openLinkInBrowser(this$0, view, EmailTechnicalSupportDialogKt.FEEDBACK_URL);
        this$0.dismiss();
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.YmBaseBottomSheetDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthEmailConfirmSupportBinding.inflate(inflater, container, false);
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
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YmBaseBottomSheetDialogFragment.attachListener$default(this, new b(view), null, 2, null);
        getBinding().text.setText(getExplanationText());
        getBinding().button.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.support.EmailTechnicalSupportDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EmailTechnicalSupportDialog.onViewCreated$lambda$0(this.f$0, view, view2);
            }
        });
    }
}
