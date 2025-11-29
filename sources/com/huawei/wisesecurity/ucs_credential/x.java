package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class x {
    public NetworkCapability a;
    public Context b;
    public p c;

    public x(Context context, p pVar, NetworkCapability networkCapability) {
        this.b = context;
        this.a = networkCapability;
        this.c = pVar;
    }

    public final void a(NetworkResponse networkResponse, g0 g0Var) throws UcsException, IOException {
        if (!networkResponse.isSuccessful()) {
            if (networkResponse.getCode() != 304) {
                LogUcs.i("KeyComponentManger", "file data update failed And statusCode = {0}", Integer.valueOf(networkResponse.getCode()));
                return;
            }
            LogUcs.i("KeyComponentManger", "file data has not modified!", new Object[0]);
            SpUtil.putLong(g0Var.a(), System.currentTimeMillis(), this.b);
            w.a(this.b, g0Var);
            return;
        }
        w.a(this.b, networkResponse.getBody());
        Context context = this.b;
        Map<String, List<String>> headers = networkResponse.getHeaders();
        LogUcs.d("LocalCDNFile", "Update local meta data : ucscomponent", new Object[0]);
        if (headers.containsKey("etag")) {
            LogUcs.d("LocalCDNFile", "Update local meta data -etag: ucscomponent", new Object[0]);
            SpUtil.putString("ETag_ucscomponent", headers.get("etag").get(0), context);
        }
        if (headers.containsKey("last-modified")) {
            LogUcs.d("LocalCDNFile", "Update local meta data -last-modified: ucscomponent", new Object[0]);
            SpUtil.putString("Last-Modified_ucscomponent", headers.get("last-modified").get(0), context);
        }
        SpUtil.putLong(g0Var.a(), System.currentTimeMillis(), this.b);
        String str = this.b.createDeviceProtectedStorageContext().getFilesDir() + "/ucscomponent.jws";
        SpUtil.putString("ucscomponent.jws", str, this.b);
        String body = networkResponse.getBody();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            try {
                fileOutputStream.write(body.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            StringBuilder sbA = f.a("Write file data failed : ");
            sbA.append(e.getMessage());
            LogUcs.e("KeyComponentLocalHandler", sbA.toString(), new Object[0]);
            StringBuilder sbA2 = f.a("Write file data failed : ");
            sbA2.append(e.getMessage());
            throw new UcsException(1011L, sbA2.toString());
        }
    }

    public synchronized void a(boolean z, g0 g0Var) throws UcsException {
        try {
            LogUcs.i("KeyComponentManger", "start download C1 file from Service", new Object[0]);
            try {
                Map map = new HashMap();
                if (!z) {
                    map = g0Var.a(this.b);
                }
                String strA = this.c.a("ucscomponent", "ucscomponent.jws");
                LogUcs.i("KeyComponentManger", "updateFileFromCDN domain is {0}", strA);
                a(this.a.get(new NetworkRequest(strA, map)), g0Var);
                LogUcs.i("KeyComponentManger", "updateFileFromCDN OK", new Object[0]);
            } catch (IOException e) {
                StringBuilder sbA = f.a("Update file data get IOException，exception: ");
                sbA.append(e.getMessage());
                String string = sbA.toString();
                throw h.a("KeyComponentManger", string, new Object[0], 1010L, string);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
