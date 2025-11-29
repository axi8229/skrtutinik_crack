package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class g0 {
    public String a() {
        return "Last-Query-Time_ucscomponent_ucscomponent.jws";
    }

    public boolean b(Context context) {
        long j = SpUtil.getLong(a(), 0L, context);
        LogUcs.i("LocalCDNFile", "lastQueryTime is " + j, new Object[0]);
        return System.currentTimeMillis() - j > 432000000;
    }

    public Map a(Context context) {
        HashMap map = new HashMap();
        String string = SpUtil.getString("ETag_ucscomponent", "", context);
        String string2 = SpUtil.getString("Last-Modified_ucscomponent", "", context);
        map.put("ETag", string);
        map.put("If-Modified-Since", string2);
        return map;
    }
}
