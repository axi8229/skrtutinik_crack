package com.huawei.location.lite.common.http.exception;

import com.huawei.location.base.activity.constant.ActivityErrorCode;
import java.util.HashMap;
import java.util.Map;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes3.dex */
public class ErrorCode {
    private static final Map<Integer, String> ERROR_CODE_DESC_MAP;
    public int code;
    public String msg;

    static {
        HashMap map = new HashMap();
        ERROR_CODE_DESC_MAP = map;
        map.put(0, "success");
        map.put(1, "inner error");
        map.put(200, "HTTP_OK");
        map.put(201, "HTTP_CREATED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_ACCEPTED), "HTTP_ACCEPTED");
        map.put(203, "HTTP_NOT_AUTHORITATIVE");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_NO_NOTIFICATION), "HTTP_NO_CONTENT");
        map.put(205, "HTTP_RESET");
        map.put(206, "HTTP_PARTIAL");
        map.put(300, "HTTP_MULT_CHOICE");
        map.put(301, "HTTP_MOVED_PERM");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_MOVED_TEMPORARILY), "HTTP_MOVED_TEMP");
        map.put(303, "HTTP_SEE_OTHER");
        map.put(304, "HTTP_NOT_MODIFIED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_USE_PROXY), "HTTP_USE_PROXY");
        map.put(400, "HTTP_BAD_REQUEST");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_UNAUTHORIZED), "HTTP_UNAUTHORIZED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_PAYMENT_REQUIRED), "HTTP_PAYMENT_REQUIRED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_FORBIDDEN), "HTTP_FORBIDDEN");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_NOT_FOUND), "HTTP_NOT_FOUND");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_METHOD_NOT_ALLOWED), "HTTP_BAD_METHOD");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_NOT_ACCEPTABLE), "HTTP_NOT_ACCEPTABLE");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_PROXY_AUTHENTICATION_REQUIRED), "HTTP_PROXY_AUTH");
        map.put(408, "HTTP_CLIENT_TIMEOUT");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_CONFLICT), "HTTP_CONFLICT");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_GONE), "HTTP_GONE");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_LENGTH_REQUIRED), "HTTP_LENGTH_REQUIRED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_CONDITIONAL_REQUEST_FAILED), "HTTP_PRECON_FAILED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_REQUEST_ENTITY_TOO_LARGE), "HTTP_ENTITY_TOO_LARGE");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_REQUEST_URI_TOO_LONG), "HTTP_REQ_TOO_LONG");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_UNSUPPORTED_MEDIA_TYPE), "HTTP_UNSUPPORTED_TYPE");
        map.put(500, "HTTP_INTERNAL_ERROR");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_NOT_IMPLEMENTED), "HTTP_NOT_IMPLEMENTED");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_BAD_GATEWAY), "HTTP_BAD_GATEWAY");
        map.put(503, "HTTP_UNAVAILABLE");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_SERVER_TIMEOUT), "HTTP_GATEWAY_TIMEOUT");
        map.put(Integer.valueOf(pjsip_status_code.PJSIP_SC_VERSION_NOT_SUPPORTED), "HTTP_VERSION");
        map.put(10000, "internal error");
        map.put(Integer.valueOf(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED), "GET_RESPONSE_FAILED");
        map.put(10302, "no network");
        map.put(10304, "json parse failed");
        map.put(Integer.valueOf(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE), "server response format is error");
        map.put(10315, "server response error code");
        map.put(10307, "okHttp Response is null");
        map.put(10309, "param error");
        map.put(10308, "common network kit not init");
        map.put(10500, "TSS_SIGN_PARAM_ERROR");
        map.put(10501, "TSS_GET_CREDENTIAL_API_FAILED");
        map.put(10502, "TSS_GET_CREDENTIAL_JSON_PARSE_FAILED");
        map.put(10503, "TSS_GET_CREDENTIAL_EXC_FAILED");
        map.put(10504, "TSS_GET_CREDENTIAL_TIME_OUT");
        map.put(10505, "TSS_GET_CREDENTIAL_TIME_OUT_RETURN");
        map.put(10506, "TSS_GET_CREDENTIAL_INTER_EXC");
        map.put(10510, "TSS_GET_SECRET_FAILED_CREDENTIAL_EMPTY");
        map.put(10511, "TSS_GET_SECRET_API_FAILED");
        map.put(10512, "TSS_GET_SECRET_JSON_PARSE_FAILED");
        map.put(10513, "TSS_GET_SECRET_EXC_FAILED");
        map.put(10514, "TSS_GET_SECRET_TIME_OUT");
        map.put(10515, "TSS_GET_SECRET_TIME_OUT_RETURN");
        map.put(10516, "TSS_GET_SECRET_INTER_EXC");
        map.put(10517, "TSS_GET_SECRET_FAILED_OTHER");
        map.put(10518, "TSS_GET_SECRET_DROPPING_CUR_IS_VALID");
        map.put(10519, "TSS_ENCRYPT_FAILED");
        map.put(10520, "TSS_GET_SECRET_SUCCESS");
        map.put(10550, "UCS_SIGN_FAILED");
    }

    public ErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public static ErrorCode valueOf(int i) {
        Map<Integer, String> map = ERROR_CODE_DESC_MAP;
        return map.containsKey(Integer.valueOf(i)) ? new ErrorCode(i, map.get(Integer.valueOf(i))) : new ErrorCode(10000, map.get(10000));
    }

    public static String valueOfKey(int i) {
        Map<Integer, String> map = ERROR_CODE_DESC_MAP;
        if (!map.containsKey(Integer.valueOf(i))) {
            i = 10000;
        }
        return map.get(Integer.valueOf(i));
    }

    public String toString() {
        return "ErrorCode{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
