package com.huawei.location.crowdsourcing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
final class FB implements com.huawei.location.crowdsourcing.common.yn {
    private static int yn;
    private byte[] E5;
    private final LW FB;
    private int LW;
    private final Vw Vw;
    private C0084FB d2;
    private final File dC;

    /* renamed from: com.huawei.location.crowdsourcing.FB$FB, reason: collision with other inner class name */
    private class C0084FB extends BroadcastReceiver {
        private C0084FB() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action == null) {
                LogLocation.e("Recorder", "get null action");
                return;
            }
            if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                LogLocation.e("Recorder", "receive unknown action,action:" + action);
                return;
            }
            LogLocation.i("Recorder", "onReceive action=" + action);
            NetworkInfo networkInfo = (NetworkInfo) safeIntent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                LogLocation.e("Recorder", "no EXTRA_NETWORK_INFO");
            } else if (networkInfo.isConnected() && networkInfo.getType() == 1) {
                FB.this.Vw.obtainMessage(0).sendToTarget();
            }
        }
    }

    private class Vw extends Handler {
        Vw(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IOException {
            if (message.what == 0) {
                FB.yn(FB.this);
                return;
            }
            LogLocation.e("Recorder", "unknown msg:" + message.what);
        }
    }

    FB(Looper looper, String str) {
        this.Vw = new Vw(looper);
        this.FB = new LW(str);
        this.dC = new File(str + File.separator + "crowdsourcing_record");
    }

    private void LW() throws IOException {
        if (!this.dC.exists()) {
            LogLocation.i("Recorder", "file not exists, not upload");
            return;
        }
        try {
            if (!this.FB.Vw(this.dC.getCanonicalPath())) {
                LogLocation.i("Recorder", "not upload file");
            } else if (!this.dC.delete()) {
                LogLocation.e("Recorder", "upload file success but delete file failed");
            } else {
                LogLocation.i("Recorder", "upload file success and delete file success");
                this.LW = 0;
            }
        } catch (IOException unused) {
            LogLocation.e("Recorder", "get path failed");
        }
    }

    static void yn(FB fb) throws IOException {
        fb.getClass();
        LogLocation.i("Recorder", "wifi connected, try upload");
        fb.LW();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean FB() {
        /*
            r5 = this;
            java.io.File r0 = r5.dC
            boolean r1 = r0.exists()
            r2 = 0
            java.lang.String r3 = "Recorder"
            if (r1 == 0) goto L2e
            boolean r1 = r0.isFile()
            java.lang.String r4 = "FileUtil"
            if (r1 != 0) goto L1f
            boolean r0 = r0.delete()
            if (r0 != 0) goto L2e
            java.lang.String r0 = "file delete failed"
        L1b:
            com.huawei.location.lite.common.log.LogLocation.e(r4, r0)
            goto L28
        L1f:
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L2e
            java.lang.String r0 = "file can not write"
            goto L1b
        L28:
            java.lang.String r0 = "regularize file failed"
        L2a:
            com.huawei.location.lite.common.log.LogLocation.e(r3, r0)
            return r2
        L2e:
            com.huawei.location.crowdsourcing.LW r0 = r5.FB
            boolean r0 = r0.Vw()
            if (r0 != 0) goto L39
            java.lang.String r0 = "uploader init failed"
            goto L2a
        L39:
            com.huawei.location.crowdsourcing.FB$FB r0 = new com.huawei.location.crowdsourcing.FB$FB
            r1 = 0
            r0.<init>()
            r5.d2 = r0
            android.content.Context r1 = com.huawei.location.crowdsourcing.Vw.Vw()
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r2.<init>(r4)
            r1.registerReceiver(r0, r2)
            java.lang.String r0 = "wifi connect register success"
            com.huawei.location.lite.common.log.LogLocation.i(r3, r0)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.FB.FB():boolean");
    }

    public void Vw() {
        File file = this.dC;
        if (file == null || !file.delete()) {
            return;
        }
        LogLocation.w("Recorder", "clear file success");
        this.LW = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void yn(android.location.Location r7, java.util.List<android.net.wifi.ScanResult> r8, java.util.List<com.huawei.location.crowdsourcing.common.entity.yn> r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.FB.yn(android.location.Location, java.util.List, java.util.List):void");
    }

    @Override // com.huawei.location.crowdsourcing.common.yn
    public void yn() {
        LogLocation.w("Recorder", "Stop");
        C0084FB c0084fb = this.d2;
        if (c0084fb != null) {
            com.huawei.location.crowdsourcing.Vw.Vw().unregisterReceiver(c0084fb);
        }
        this.FB.getClass();
        LogLocation.w("Uploader", "Stop");
    }
}
