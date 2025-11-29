package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs_credential.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ErrorBody {

    @KfsStringNotEmpty
    private String errorCode;

    @KfsStringNotEmpty
    private String errorMessage;

    public static ErrorBody fromString(String str) throws UcsException {
        try {
            ErrorBody errorBody = new ErrorBody();
            JSONObject jSONObject = new JSONObject(str);
            errorBody.errorCode = jSONObject.optString("errorCode");
            errorBody.errorMessage = jSONObject.optString("errorMessage");
            KfsValidator.validate(errorBody);
            return errorBody;
        } catch (KfsValidationException e) {
            StringBuilder sbA = f.a("ErrorBody param invalid : ");
            sbA.append(e.getMessage());
            throw new UcsException(1001L, sbA.toString());
        } catch (JSONException e2) {
            StringBuilder sbA2 = f.a("ErrorBody param is not a valid json string : ");
            sbA2.append(e2.getMessage());
            throw new UcsException(1001L, sbA2.toString());
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
