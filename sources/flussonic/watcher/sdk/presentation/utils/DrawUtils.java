package flussonic.watcher.sdk.presentation.utils;

import android.view.View;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes3.dex */
public class DrawUtils {
    public static void forceRedraw(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH));
        view.layout(view.getLeft(), view.getTop(), view.getLeft() + view.getMeasuredWidth(), view.getTop() + view.getMeasuredHeight());
        view.getViewTreeObserver().dispatchOnGlobalLayout();
    }
}
