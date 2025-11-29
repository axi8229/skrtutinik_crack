package ru.yoomoney.sdk.auth.yandexAcquire.webView.utils;

import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/utils/AuthWebViewClient;", "Landroid/webkit/WebViewClient;", "isDebugMode", "", "onPageLoaded", "Lkotlin/Function0;", "", "onAuthTokenReceived", "Lkotlin/Function1;", "", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getQueryParameterOrNull", "url", "Landroid/net/Uri;", AppMeasurementSdk.ConditionalUserProperty.NAME, "isTokenReceivedFromUrl", "onPageCommitVisible", "view", "Landroid/webkit/WebView;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthWebViewClient extends WebViewClient {
    private final boolean isDebugMode;
    private final Function1<String, Unit> onAuthTokenReceived;
    private final Function0<Unit> onPageLoaded;

    /* JADX WARN: Multi-variable type inference failed */
    public AuthWebViewClient(boolean z, Function0<Unit> onPageLoaded, Function1<? super String, Unit> onAuthTokenReceived) {
        Intrinsics.checkNotNullParameter(onPageLoaded, "onPageLoaded");
        Intrinsics.checkNotNullParameter(onAuthTokenReceived, "onAuthTokenReceived");
        this.isDebugMode = z;
        this.onPageLoaded = onPageLoaded;
        this.onAuthTokenReceived = onAuthTokenReceived;
    }

    private final String getQueryParameterOrNull(Uri url, String name) {
        String fragment;
        Object next;
        if (url == null || (fragment = url.getFragment()) == null) {
            return null;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) fragment, new char[]{'&'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new char[]{'='}, false, 0, 6, (Object) null);
            arrayList.add(new Pair(listSplit$default2.get(0), listSplit$default2.get(1)));
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((Pair) next).getFirst(), name)) {
                break;
            }
        }
        Pair pair = (Pair) next;
        if (pair != null) {
            return (String) pair.getSecond();
        }
        return null;
    }

    private final boolean isTokenReceivedFromUrl(Uri url) {
        String string;
        String queryParameterOrNull;
        String str = this.isDebugMode ? "oauth-test.yandex.ru/auth/finish" : "oauth.yandex.ru/auth/finish";
        if (url == null || (string = url.toString()) == null || !StringsKt.contains$default((CharSequence) string, (CharSequence) str, false, 2, (Object) null) || (queryParameterOrNull = getQueryParameterOrNull(url, "access_token")) == null) {
            return false;
        }
        this.onAuthTokenReceived.invoke(queryParameterOrNull);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
        this.onPageLoaded.invoke();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.isDebugMode) {
            Log.w(Reflection.getOrCreateKotlinClass(AuthWebViewClient.class).getSimpleName(), error.toString());
            handler.proceed();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        if (isTokenReceivedFromUrl(request.getUrl())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        if (isTokenReceivedFromUrl(Uri.parse(url))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}
