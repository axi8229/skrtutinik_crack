package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.IOUtils;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class w {
    public static void a(Context context, g0 g0Var) throws UcsException {
        String string = SpUtil.getString("ucscomponent.jws", null, context);
        if (string == null || !new File(string).exists()) {
            throw new UcsException(1009L, "Init component from local failed, file error");
        }
        LogUcs.i("KeyComponentLocalHandler", "Start init data =  component through local file", new Object[0]);
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            try {
                a(context, IOUtils.toString(fileInputStream, "UTF-8"));
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e) {
            StringBuilder sbA = f.a("Init data failed, msg = ");
            sbA.append(e.getMessage());
            String string2 = sbA.toString();
            throw h.a("KeyComponentLocalHandler", string2, new Object[0], 1009L, string2);
        }
    }

    public static void a(Context context, String str) throws UcsException {
        try {
            v vVar = new v(str);
            g.a(context, vVar);
            UcsLib.ucsUpdateRootKey(StringUtil.base64Decode(vVar.b.b, 0), 32);
            SpUtil.putInt("Local-C1-Version", vVar.b.a, context);
        } catch (Throwable th) {
            String string = SpUtil.getString("ucscomponent.jws", null, context);
            if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                LogUcs.i("KeyComponentLocalHandler", "tryToDeleteFile failed, file not exists.", new Object[0]);
            } else {
                try {
                    boolean zDelete = new File(string).delete();
                    LogUcs.i("KeyComponentLocalHandler", zDelete ? "deleteFile success." : "deleteFile failed.", new Object[0]);
                    if (zDelete) {
                        SpUtil.putLong("Last-Query-Time_ucscomponent_ucscomponent.jws", 0L, context);
                        SpUtil.putString("ucscomponent.jws", "", context);
                        StringBuilder sb = new StringBuilder();
                        sb.append("ETag_");
                        sb.append("ucscomponent");
                        SpUtil.putString(sb.toString(), "", context);
                        SpUtil.putString("Last-Modified_ucscomponent", "", context);
                    }
                } catch (Throwable th2) {
                    LogUcs.e("KeyComponentLocalHandler", "deleteFile failed, {0}", th2.getMessage());
                }
            }
            StringBuilder sbA = f.a("verify jws error, ");
            sbA.append(th.getMessage());
            String string2 = sbA.toString();
            throw h.a("KeyComponentLocalHandler", string2, new Object[0], 1012L, string2);
        }
    }
}
