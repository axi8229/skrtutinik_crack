package npi.spay;

import com.google.gson.Gson;
import okhttp3.ResponseBody;
import spay.sdk.data.dto.response.SPayErrorDto;

/* renamed from: npi.spay.u2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1954u2 {
    public static final SPayErrorDto a(ResponseBody responseBody) {
        return (SPayErrorDto) new Gson().fromJson(responseBody != null ? responseBody.charStream() : null, SPayErrorDto.class);
    }
}
