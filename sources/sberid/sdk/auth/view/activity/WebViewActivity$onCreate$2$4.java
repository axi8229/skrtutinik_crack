package sberid.sdk.auth.view.activity;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import sberid.sdk.auth.R$string;
import sberid.sdk.auth.utils.SberIDBrowserUtilsKt;

/* compiled from: WebViewActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class WebViewActivity$onCreate$2$4 extends Lambda implements Function1<Uri, Unit> {
    final /* synthetic */ WebView $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewActivity$onCreate$2$4(WebView webView) {
        super(1);
        this.$this_apply = webView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
        invoke2(uri);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Context context = this.$this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (SberIDBrowserUtilsKt.launchCustomTabs(context, uri)) {
            return;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        if (StringsKt.contains$default((CharSequence) string, (CharSequence) ".pdf", false, 2, (Object) null)) {
            this.$this_apply.post(new Runnable() { // from class: sberid.sdk.auth.view.activity.WebViewActivity$onCreate$2$4$$special$$inlined$run$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.$this_apply.loadUrl("https://docs.google.com/gview?embedded=true&url=" + uri);
                }
            });
        } else {
            Toast.makeText(this.$this_apply.getContext(), this.$this_apply.getContext().getText(R$string.browser_not_found_toast), 0).show();
        }
    }
}
