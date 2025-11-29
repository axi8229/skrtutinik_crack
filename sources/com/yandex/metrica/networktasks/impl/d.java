package com.yandex.metrica.networktasks.impl;

import android.text.TextUtils;
import com.yandex.metrica.network.NetworkClient;
import com.yandex.metrica.network.Request;
import com.yandex.metrica.network.Response;
import com.yandex.metrica.networktasks.api.FullUrlFormer;
import com.yandex.metrica.networktasks.api.NetworkTask;
import com.yandex.metrica.networktasks.api.RequestDataHolder;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import com.yandex.metrica.networktasks.api.UnderlyingNetworkTask;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class d {
    private final void a(Request.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            builder.addHeader((String) entry.getKey(), CollectionsKt.joinToString$default((Iterable) entry.getValue(), ",", null, null, 0, null, null, 62, null));
        }
    }

    public final boolean a(NetworkTask task) {
        byte[] postData;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.onPerformRequest()) {
            String url = task.getUrl();
            if (url == null || TextUtils.isEmpty(StringsKt.trim(url).toString())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Task ");
                sb.append(task.description());
                sb.append(" url is `");
                sb.append(url);
                sb.append("`. ");
                sb.append("All hosts = ");
                UnderlyingNetworkTask underlyingTask = task.getUnderlyingTask();
                Intrinsics.checkNotNullExpressionValue(underlyingTask, "task.underlyingTask");
                FullUrlFormer fullUrlFormer = underlyingTask.getFullUrlFormer();
                Intrinsics.checkNotNullExpressionValue(fullUrlFormer, "task.underlyingTask.fullUrlFormer");
                List allHosts = fullUrlFormer.getAllHosts();
                sb.append(allHosts != null ? allHosts.toString() : null);
                task.onRequestError(new IllegalArgumentException(sb.toString()));
                return false;
            }
            Request.Builder builderAddHeader = new Request.Builder(url).addHeader("Accept", "application/json").addHeader("User-Agent", task.getUserAgent());
            Intrinsics.checkNotNullExpressionValue(builderAddHeader, "Request.Builder(url)\n   …erAgent\n                )");
            RequestDataHolder requestDataHolder = task.getRequestDataHolder();
            Intrinsics.checkNotNullExpressionValue(requestDataHolder, "task.requestDataHolder");
            Map headers = requestDataHolder.getHeaders();
            Intrinsics.checkNotNullExpressionValue(headers, "requestDataHolder.headers");
            a(builderAddHeader, headers);
            if (NetworkTask.Method.POST == requestDataHolder.getMethod() && (postData = requestDataHolder.getPostData()) != null) {
                if (!(postData.length == 0)) {
                    builderAddHeader.post(postData);
                    Long it = requestDataHolder.getSendTimestamp();
                    if (it != null) {
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        builderAddHeader.addHeader("Send-Timestamp", String.valueOf(timeUnit.toSeconds(it.longValue())));
                    }
                    Integer sendTimezoneSec = requestDataHolder.getSendTimezoneSec();
                    if (sendTimezoneSec != null) {
                        builderAddHeader.addHeader("Send-Timezone", String.valueOf(sendTimezoneSec.intValue()));
                    }
                }
            }
            NetworkClient.Builder builder = new NetworkClient.Builder();
            int i = a.a;
            NetworkClient networkClientBuild = builder.withConnectTimeout(i).withReadTimeout(i).withSslSocketFactory(task.getSslSocketFactory()).build();
            Intrinsics.checkNotNullExpressionValue(networkClientBuild, "NetworkClient.Builder()\n…\n                .build()");
            Response responseExecute = networkClientBuild.newCall(builderAddHeader.build()).execute();
            Intrinsics.checkNotNullExpressionValue(responseExecute, "client.newCall(requestBuilder.build()).execute()");
            int code = responseExecute.getCode();
            ResponseDataHolder responseDataHolder = task.getResponseDataHolder();
            Intrinsics.checkNotNullExpressionValue(responseDataHolder, "task.responseDataHolder");
            responseDataHolder.setResponseCode(code);
            responseDataHolder.setResponseHeaders(responseExecute.getHeaders());
            if (responseDataHolder.isValidResponse()) {
                responseDataHolder.setResponseData(responseExecute.getResponseData());
            }
            if (responseExecute.isCompleted()) {
                return task.onRequestComplete();
            }
            task.onRequestError(responseExecute.getException());
        } else {
            task.onRequestError(null);
        }
        return false;
    }
}
