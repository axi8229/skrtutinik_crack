package com.huawei.location.crowdsourcing;

import android.os.Build;
import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/* loaded from: classes3.dex */
final class LW implements com.huawei.location.crowdsourcing.common.yn {
    private com.huawei.location.crowdsourcing.upload.entity.yn FB = com.huawei.location.crowdsourcing.upload.entity.yn.yn;
    private final Map<String, String> LW = new TreeMap();
    private com.huawei.location.crowdsourcing.upload.entity.Vw Vw;
    private final File dC;
    private com.huawei.location.crowdsourcing.upload.entity.Vw yn;

    LW(String str) {
        this.dC = new File(str + File.separator + "crowdsourcing_upload");
        FB();
    }

    private void FB() {
        String strG3 = Config.FB.yn.G3();
        if (!strG3.isEmpty()) {
            LogLocation.i("Uploader", "read patch policy");
            try {
                this.FB = (com.huawei.location.crowdsourcing.upload.entity.yn) GsonUtil.getInstance().fromJson(strG3, com.huawei.location.crowdsourcing.upload.entity.yn.class);
            } catch (JsonSyntaxException unused) {
                LogLocation.e("Uploader", "read patch policy failed");
            }
        }
        if (this.FB == null) {
            this.FB = com.huawei.location.crowdsourcing.upload.entity.yn.yn;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void LW() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.LW():void");
    }

    private static String yn(String str) {
        return str.replaceAll("[^a-zA-Z0-9().]", "-");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        r11 = "HexUtil.hexStr2ByteArray Exception";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean yn(byte[] r11, java.lang.String r12, java.lang.String r13) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.yn(byte[], java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean Vw() {
        /*
            r5 = this;
            java.io.File r0 = r5.dC
            boolean r1 = r0.exists()
            r2 = 0
            java.lang.String r3 = "Uploader"
            if (r1 == 0) goto L2e
            boolean r1 = r0.isDirectory()
            java.lang.String r4 = "FileUtil"
            if (r1 != 0) goto L1f
            boolean r0 = r0.delete()
            if (r0 != 0) goto L2e
            java.lang.String r0 = "folder delete failed"
        L1b:
            com.huawei.location.lite.common.log.LogLocation.e(r4, r0)
            goto L28
        L1f:
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L2e
            java.lang.String r0 = "folder can not write"
            goto L1b
        L28:
            java.lang.String r0 = "regularize folder failed"
        L2a:
            com.huawei.location.lite.common.log.LogLocation.e(r3, r0)
            return r2
        L2e:
            java.io.File r0 = r5.dC
            boolean r0 = r0.exists()
            if (r0 != 0) goto L41
            java.io.File r0 = r5.dC
            boolean r0 = r0.mkdir()
            if (r0 != 0) goto L41
            java.lang.String r0 = "create folder failed"
            goto L2a
        L41:
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            com.huawei.location.crowdsourcing.Config r1 = com.huawei.location.crowdsourcing.Config.FB.yn()
            java.lang.String r1 = r1.Yx()
            java.lang.String r2 = "shaSN"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r2 = "model"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getVersion()
            java.lang.String r2 = "romVersion"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getEMUIVersion()
            java.lang.String r2 = "emuiVersion"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.LW
            java.lang.String r1 = com.huawei.location.lite.common.util.SystemPropertiesUtil.getAndroidVersion()
            java.lang.String r2 = "osVersion"
            r0.put(r2, r1)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.LW.Vw():boolean");
    }

    @Override // com.huawei.location.crowdsourcing.common.yn
    public void yn() {
        LogLocation.w("Uploader", "Stop");
    }

    boolean Vw(String str) throws IOException {
        LogLocation.i("Uploader", "packageName is " + Vw.Vw().getPackageName());
        if (!Config.FB.yn.Eu()) {
            LogLocation.d("Uploader", "not reach upload interval");
            return false;
        }
        LogLocation.i("Uploader", "start upload");
        if (!this.dC.isDirectory()) {
            LogLocation.e("Uploader", "not folder");
            return false;
        }
        File[] fileArrListFiles = this.dC.listFiles();
        if (fileArrListFiles == null) {
            LogLocation.e("Uploader", "upload folder not valid");
        } else {
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    long jAbs = Math.abs(System.currentTimeMillis() - file.lastModified());
                    Config unused = Config.FB.yn;
                    if (jAbs >= 2592000000L) {
                        if (file.delete()) {
                            LogLocation.i("Uploader", "delete expired success");
                        } else {
                            LogLocation.e("Uploader", "delete expired failed");
                        }
                    }
                } else {
                    LogLocation.e("Uploader", file.delete() ? "delete invalid success" : "delete invalid failed");
                }
            }
        }
        LW();
        LogLocation.i("Uploader", "first upload end");
        String[] list = this.dC.list();
        if (list == null) {
            LogLocation.e("Uploader", "upload folder not valid");
        } else if (list.length != 0) {
            LogLocation.e("Uploader", "upload folder not empty, can not compress");
        } else {
            try {
                String canonicalPath = this.dC.getCanonicalPath();
                String string = UUID.randomUUID().toString();
                StringBuilder sb = new StringBuilder();
                sb.append(canonicalPath);
                sb.append(File.separator);
                String str2 = Build.PRODUCT;
                sb.append(String.format(Locale.ENGLISH, "%s_%s_%s_%s.zip", yn(str2), yn(SystemPropertiesUtil.getVersion()), string, new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(System.currentTimeMillis()))));
                String string2 = sb.toString();
                String strValueOf = String.valueOf('\r');
                String strValueOf2 = String.valueOf('\n');
                String strYn = yn(str2);
                String strYn2 = yn(SystemPropertiesUtil.getVersion());
                String packageName = Vw.Vw().getPackageName();
                String emuiVerName = ROMUtil.getEmuiVerName();
                if (TextUtils.isEmpty(emuiVerName)) {
                    emuiVerName = Build.VERSION.RELEASE;
                }
                if (emuiVerName == null) {
                    emuiVerName = "";
                }
                if (yn(("{\"LogVersion\":\"002\",\"LogSubversion\":\"101\",\"ProductName\":\"" + strYn + "\",\"ProductVersion\":\"" + strYn2 + "\",\"hms\":\"true\",\"S1\":\"" + string + "\",\"VERSION\":\"" + APKUtil.getVersionName() + "\",\"PVer\":\"\",\"package_name\":\"" + packageName + "\",\"Os_version\":\"" + emuiVerName + "\",\"Product_info\":\"" + (Build.BRAND + " " + Build.MODEL) + "\"}" + strValueOf + strValueOf2).getBytes(StandardCharsets.UTF_8), str, string2)) {
                    LW();
                    return true;
                }
                LogLocation.e("Uploader", "compress file failed");
                if (new File(string2).delete()) {
                    LogLocation.i("Uploader", "delete failed file success");
                }
            } catch (IOException unused2) {
                LogLocation.e("Uploader", "get path failed");
            }
        }
        return false;
    }
}
