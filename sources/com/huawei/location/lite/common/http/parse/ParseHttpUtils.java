package com.huawei.location.lite.common.http.parse;

import android.text.TextUtils;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseBodyAdapter;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.HttpUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

/* loaded from: classes3.dex */
public class ParseHttpUtils {
    private static HashMap<String, String> getHeaders(Headers headers) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : headers.names()) {
            List<String> listValues = headers.values(str);
            if (!listValues.isEmpty()) {
                Iterator<String> it = listValues.iterator();
                while (it.hasNext()) {
                    map.put(str, it.next());
                }
            }
        }
        return map;
    }

    public static Request parseRequest(BaseRequest baseRequest, Request.Builder builder) throws OnErrorException {
        if (baseRequest == null) {
            return null;
        }
        LogLocation.d("ParseHttpUtils", "baseRequest:" + baseRequest);
        String method = baseRequest.getMethod();
        try {
            builder.url(baseRequest.getFullUrl()).method(method, TextUtils.equals("POST", method) ? RequestBody.create(MediaType.parse(!TextUtils.isEmpty(baseRequest.getContentType()) ? baseRequest.getContentType() : "application/json; charset=utf-8"), ByteString.of(baseRequest.getBody())) : null);
            HashMap<String, String> headers = baseRequest.getHeads().getHeaders();
            if (headers == null) {
                return builder.build();
            }
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            return builder.build();
        } catch (IllegalArgumentException unused) {
            throw new OnErrorException(ErrorCode.valueOf(10309));
        }
    }

    public static ResponseAdapter parseResponseAdapter(Response response) throws OnFailureException {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            throw new OnFailureException(ErrorCode.valueOf(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED));
        }
        HashMap<String, String> headers = getHeaders(response.headers());
        MediaType mediaType = responseBodyBody.get$contentType();
        return new ResponseAdapter.Builder().body(new ResponseBodyAdapter.Builder().bytes(HttpUtils.toByteArray(responseBodyBody.byteStream())).contentType(mediaType != null ? mediaType.getMediaType() : "").contentLength(responseBodyBody.getContentLength()).build()).headers(new HeadBuilder().addAll(headers)).message(response.message()).code(response.code()).url(response.request().url().getUrl()).build();
    }
}
