package ru.yoomoney.sdk.auth.utils;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.Scopes;
import com.google.android.material.snackbar.Snackbar;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.model.ErrorTooFrequentlyResend;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.waitConfirm.WaitConfirmationFragment;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0000\u001a,\u0010\u000f\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\fH\u0000\u001a,\u0010\u001b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0000¨\u0006\u001f"}, d2 = {"createSnackBar", "Lcom/google/android/material/snackbar/Snackbar;", "parentView", "Landroid/view/View;", CrashHianalyticsData.MESSAGE, "", "noticeError", "", "noticeSuccess", "callPhone", "Landroidx/fragment/app/Fragment;", "phoneNumber", "", "goToStore", "packageName", "handleFailure", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "isAppInstalled", "", "applicationPackage", "openLinkInBrowser", "url", "sendEmail", Scopes.EMAIL, "subject", "text", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoreFragmentExtensions {
    public static final void callPhone(Fragment fragment, String phoneNumber) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        try {
            fragment.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", phoneNumber, null)));
        } catch (ActivityNotFoundException unused) {
            View viewRequireView = fragment.requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
            String string = fragment.getString(R.string.auth_error_no_dialer);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            noticeError(viewRequireView, string);
        }
    }

    private static final Snackbar createSnackBar(View view, CharSequence charSequence) {
        Snackbar snackbarMake = Snackbar.make(view, charSequence, -1);
        Intrinsics.checkNotNullExpressionValue(snackbarMake, "make(...)");
        ((TextView) snackbarMake.getView().findViewById(R.id.snackbar_text)).setMaxLines(Integer.MAX_VALUE);
        return snackbarMake;
    }

    public static final void goToStore(Fragment fragment, String packageName) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            fragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            Log.e(fragment.getClass().getName(), "activity for market:// not found", e);
            try {
                fragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("appmarket://details?id=" + packageName)));
            } catch (ActivityNotFoundException e2) {
                Log.e(fragment.getClass().getName(), "activity for appmarket:// not found", e2);
                View viewRequireView = fragment.requireView();
                Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
                String string = fragment.getString(R.string.auth_error_no_app_market);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                noticeError(viewRequireView, string);
            }
        } catch (IllegalStateException e3) {
            Log.e(fragment.getClass().getName(), "error", e3);
        }
    }

    public static final void handleFailure(Fragment fragment, FragmentManager fragmentManager, View parentView, Failure failure, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(failure, "failure");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        if (failure instanceof FeatureFailure) {
            FeatureFailure featureFailure = (FeatureFailure) failure;
            if (featureFailure.getError() instanceof ErrorTooFrequentlyResend) {
                WaitConfirmationFragment.Companion companion = WaitConfirmationFragment.INSTANCE;
                ProcessError error = featureFailure.getError();
                Intrinsics.checkNotNull(error, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.ErrorTooFrequentlyResend");
                companion.show(fragmentManager, ((ErrorTooFrequentlyResend) error).getNextResendFrom());
                return;
            }
        }
        noticeError(parentView, resourceMapper.map(failure));
    }

    public static final boolean isAppInstalled(Fragment fragment, String applicationPackage) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(applicationPackage, "applicationPackage");
        try {
            return fragment.requireContext().getPackageManager().getPackageInfo(applicationPackage, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static final void noticeError(View parentView, CharSequence message) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(message, "message");
        createSnackBar(parentView, message).setBackgroundTint(ContextCompat.getColor(parentView.getContext(), R.color.color_alert)).setTextColor(ContextCompat.getColor(parentView.getContext(), R.color.color_type_inverse)).show();
    }

    public static final void noticeSuccess(View parentView, CharSequence message) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(message, "message");
        createSnackBar(parentView, message).setBackgroundTint(ContextCompat.getColor(parentView.getContext(), R.color.color_success)).setTextColor(ContextCompat.getColor(parentView.getContext(), R.color.color_type_inverse)).show();
    }

    public static final void openLinkInBrowser(Fragment fragment, View parentView, String url) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            fragment.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            String string = fragment.getString(R.string.auth_error_no_browser);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            noticeError(parentView, string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void sendEmail(androidx.fragment.app.Fragment r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "email"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            if (r11 == 0) goto L25
            java.lang.String r11 = sendEmail$encode(r11)     // Catch: android.content.ActivityNotFoundException -> L79
            if (r11 == 0) goto L25
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: android.content.ActivityNotFoundException -> L79
            r1.<init>()     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r2 = "subject="
            r1.append(r2)     // Catch: android.content.ActivityNotFoundException -> L79
            r1.append(r11)     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r11 = r1.toString()     // Catch: android.content.ActivityNotFoundException -> L79
            goto L26
        L25:
            r11 = r0
        L26:
            if (r12 == 0) goto L3f
            java.lang.String r12 = sendEmail$encode(r12)     // Catch: android.content.ActivityNotFoundException -> L79
            if (r12 == 0) goto L3f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.content.ActivityNotFoundException -> L79
            r0.<init>()     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r1 = "body="
            r0.append(r1)     // Catch: android.content.ActivityNotFoundException -> L79
            r0.append(r12)     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r0 = r0.toString()     // Catch: android.content.ActivityNotFoundException -> L79
        L3f:
            java.lang.String[] r11 = new java.lang.String[]{r11, r0}     // Catch: android.content.ActivityNotFoundException -> L79
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull(r11)     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r1 = "&"
            java.lang.String r2 = "?"
            r7 = 60
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r11 = kotlin.collections.CollectionsKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: android.content.ActivityNotFoundException -> L79
            r12.<init>()     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r0 = "mailto:"
            r12.append(r0)     // Catch: android.content.ActivityNotFoundException -> L79
            r12.append(r10)     // Catch: android.content.ActivityNotFoundException -> L79
            r12.append(r11)     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r10 = r12.toString()     // Catch: android.content.ActivityNotFoundException -> L79
            android.content.Intent r11 = new android.content.Intent     // Catch: android.content.ActivityNotFoundException -> L79
            java.lang.String r12 = "android.intent.action.SENDTO"
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: android.content.ActivityNotFoundException -> L79
            r11.<init>(r12, r10)     // Catch: android.content.ActivityNotFoundException -> L79
            r9.startActivity(r11)     // Catch: android.content.ActivityNotFoundException -> L79
            goto L90
        L79:
            android.view.View r10 = r9.requireView()
            java.lang.String r11 = "requireView(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            int r11 = ru.yoomoney.sdk.auth.R.string.auth_error_no_email_client
            java.lang.String r9 = r9.getString(r11)
            java.lang.String r11 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r11)
            noticeError(r10, r9)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions.sendEmail(androidx.fragment.app.Fragment, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ void sendEmail$default(Fragment fragment, String str, String str2, String str3, int i, Object obj) throws UnsupportedEncodingException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        sendEmail(fragment, str, str2, str3);
    }

    private static final String sendEmail$encode(String str) throws UnsupportedEncodingException {
        String strEncode = URLEncoder.encode(str, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
        return StringsKt.replace$default(strEncode, "+", "%20", false, 4, (Object) null);
    }
}
