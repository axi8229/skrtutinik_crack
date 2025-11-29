package ru.yoomoney.sdk.auth.utils;

import android.os.Build;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0007H\u0000¨\u0006\t"}, d2 = {"runOnSdkVersion", "", "version", "", "block", "Lkotlin/Function0;", "applyPasswordAutofillHint", "Landroid/widget/EditText;", "applyUserNameAutofillHint", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EditTextExtensionsKt {

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditText a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EditText editText) {
            super(0);
            this.a = editText;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.a.setAutofillHints(new String[]{"password"});
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditText a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EditText editText) {
            super(0);
            this.a = editText;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.a.setAutofillHints(new String[]{"username"});
            return Unit.INSTANCE;
        }
    }

    public static final void applyPasswordAutofillHint(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        runOnSdkVersion(26, new a(editText));
    }

    public static final void applyUserNameAutofillHint(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        runOnSdkVersion(26, new b(editText));
    }

    private static final void runOnSdkVersion(int i, Function0<Unit> function0) {
        if (Build.VERSION.SDK_INT >= i) {
            function0.invoke();
        }
    }
}
