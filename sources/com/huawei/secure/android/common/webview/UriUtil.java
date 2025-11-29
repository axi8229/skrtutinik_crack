package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class UriUtil {
    @TargetApi(9)
    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i("UriUtil", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            LogsUtil.e("UriUtil", "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e) {
            LogsUtil.e("UriUtil", "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }
}
