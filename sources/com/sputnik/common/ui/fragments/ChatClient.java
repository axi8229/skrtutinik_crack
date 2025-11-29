package com.sputnik.common.ui.fragments;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.utils.LogUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatClient.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/sputnik/common/ui/fragments/ChatClient;", "Landroid/webkit/WebViewClient;", "", "phone", AppMeasurementSdk.ConditionalUserProperty.NAME, "flatUUID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/WebView;", "view", "url", "", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "getName", "getFlatUUID", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatClient extends WebViewClient {
    private final String flatUUID;
    private final String name;
    private final String phone;

    public ChatClient(String phone, String str, String str2) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.phone = phone;
        this.name = str;
        this.flatUUID = str2;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        LogUtilsKt.writeLog("GGGG: on page finished");
        if (view != null) {
            String str = this.name;
            if (str == null) {
                str = "";
            }
            view.evaluateJavascript("window.postMessage({type: 'init', payload: {name: '" + str + "', email:'" + this.phone + "_" + this.flatUUID + "@sdk.test'}})", null);
        }
    }
}
