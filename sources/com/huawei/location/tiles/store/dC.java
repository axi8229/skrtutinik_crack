package com.huawei.location.tiles.store;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class dC {
    private static double E5;
    private static final String FB;
    private static final String LW;
    private static final String Vw;
    private static double d2;
    private static String dC;
    public static final String yn;
    private com.huawei.location.tiles.store.Vw Ot;
    private com.huawei.location.tiles.store.yn oc;
    private int zp = 25;
    private int ut = 30;

    class FB extends TypeToken<com.huawei.location.tiles.store.Vw> {
        FB(dC dCVar) {
        }
    }

    class LW implements Runnable {
        final /* synthetic */ String yn;

        LW(String str) {
            this.yn = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
            dC.yn(dC.this, this.yn);
        }
    }

    class Vw implements Runnable {
        final /* synthetic */ String FB;
        final /* synthetic */ String LW;
        final /* synthetic */ String Vw;
        final /* synthetic */ String yn;

        Vw(dC dCVar, String str, String str2, String str3, String str4) {
            this.yn = str;
            this.Vw = str2;
            this.FB = str3;
            this.LW = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
            if (com.huawei.location.activity.model.Vw.yn(this.yn, this.Vw, this.FB, this.LW)) {
                return;
            }
            com.huawei.location.tiles.utils.FB.FB();
        }
    }

    class yn implements Runnable {
        yn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
            dC.yn(dC.this);
            dC.Vw(dC.this);
        }
    }

    static {
        String str;
        try {
            str = ContextUtil.getContext().getCacheDir().getCanonicalPath() + File.separator;
        } catch (IOException unused) {
            LogLocation.e("FileUtils", "Failed to obtain the store dir path.");
            str = null;
        }
        yn = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("CityAdmin");
        String str2 = File.separator;
        sb.append(str2);
        Vw = sb.toString();
        FB = str + "CityInfo" + str2;
        LW = str + "TileList" + str2;
        E5 = ConfigValue.DOUBLE_DEFAULT_VALUE;
        d2 = ConfigValue.DOUBLE_DEFAULT_VALUE;
    }

    public dC(int i, int i2) {
        Vw(i);
        yn(i2);
    }

    private void Vw(int i) {
        if (i > 0) {
            this.zp = i;
        } else {
            LogLocation.i("TileStoreManager", "tileDailyMaxNum is Invalid.");
        }
    }

    static void Vw(dC dCVar) {
        String str;
        String str2;
        synchronized (dCVar) {
            try {
                com.huawei.location.tiles.store.yn ynVar = dCVar.oc;
                if (ynVar != null) {
                    String strYn = ynVar.yn();
                    String strFB = dCVar.oc.FB();
                    String strVw = dCVar.oc.Vw();
                    String str3 = Vw;
                    String strYn2 = com.huawei.location.tiles.utils.yn.yn(str3, strYn);
                    if (TextUtils.isEmpty(strYn2) || TextUtils.isEmpty(strVw)) {
                        str = "TileStoreManager";
                        str2 = "The adminJson file data is abnormal.";
                    } else {
                        File file = new File(strYn2);
                        if (file.exists()) {
                            String strYn3 = com.huawei.location.tiles.utils.LW.yn(strYn2, strFB);
                            if (!TextUtils.isEmpty(strYn3) && strYn3.equals(strVw)) {
                                str = "TileStoreManager";
                                str2 = "The file is the latest version.";
                            } else if (file.getParentFile().delete()) {
                                LogLocation.e("TileStoreManager", "Failed to delete the file.");
                            }
                        }
                        if (com.huawei.location.activity.model.Vw.yn(strYn2, strYn, strFB, strVw) && !com.huawei.location.tiles.utils.yn.yn(strYn2, str3, file.getName().replace(".zip", ""))) {
                            LogLocation.e("TileStoreManager", "Failed to unzip the adminJson file.");
                        }
                    }
                    LogLocation.d(str, str2);
                }
            } finally {
            }
        }
    }

    private synchronized void Vw(String str) {
        LogLocation.i("TileStoreManager", "get cityInfo form cloud");
        ExecutorUtil.getInstance().execute(new LW(str));
    }

    private com.huawei.location.tiles.store.FB yn(String str, List<com.huawei.location.tiles.store.FB> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            for (com.huawei.location.tiles.store.FB fb : list) {
                if (fb != null) {
                    String strYn = fb.yn();
                    if (TextUtils.isEmpty(strYn)) {
                        continue;
                    } else {
                        if (strYn.endsWith(str + ".zip")) {
                            return fb;
                        }
                    }
                }
            }
        }
        return null;
    }

    private com.huawei.location.tiles.store.Vw yn(String str) {
        String str2;
        File file = new File(FB + str);
        if (!file.exists() || System.currentTimeMillis() - file.lastModified() >= 604800000) {
            return null;
        }
        try {
            return (com.huawei.location.tiles.store.Vw) GsonUtil.getInstance().fromJson(com.huawei.location.tiles.utils.yn.Vw(file.getCanonicalPath()), new FB(this).getType());
        } catch (JsonSyntaxException unused) {
            str2 = "json syntax error";
            LogLocation.e("TileStoreManager", str2);
            return null;
        } catch (IOException unused2) {
            str2 = "Invalid file path";
            LogLocation.e("TileStoreManager", str2);
            return null;
        }
    }

    private void yn(int i) {
        if (i > 0) {
            this.ut = i;
        } else {
            LogLocation.i("TileStoreManager", "storeFileMaxNum is Invalid.");
        }
    }

    static void yn(dC dCVar) {
        String str;
        String str2;
        synchronized (dCVar) {
            if (dCVar.oc == null) {
                String strVw = com.huawei.location.activity.model.Vw.Vw("CITYADMIN-WKT");
                if (TextUtils.isEmpty(strVw)) {
                    LogLocation.d("TileStoreManager", "get adminJson from cloud is fail");
                } else {
                    try {
                        List list = (List) GsonUtil.getInstance().fromJson(strVw, new d2(dCVar).getType());
                        if (list == null || list.size() == 0) {
                            str = "TileStoreManager";
                            str2 = "adminJsonList is null";
                        } else {
                            com.huawei.location.tiles.store.yn ynVar = (com.huawei.location.tiles.store.yn) list.get(0);
                            if (ynVar == null) {
                                str = "TileStoreManager";
                                str2 = "tempAdminJson is null";
                            } else {
                                dCVar.oc = ynVar;
                                com.huawei.location.tiles.utils.yn.yn(GsonUtil.getInstance().toJson(dCVar.oc), new File(yn + "CityAdminJson"));
                            }
                        }
                        LogLocation.d(str, str2);
                    } catch (JsonSyntaxException unused) {
                        LogLocation.e("TileStoreManager", "json syntax error");
                    }
                }
            }
        }
    }

    private void yn(String str, String str2, String str3, String str4) {
        if (com.huawei.location.tiles.utils.FB.Vw() >= this.zp) {
            LogLocation.i("TileStoreManager", "The maximum number of downloads per day is exceeded.");
            return;
        }
        com.huawei.location.tiles.utils.FB.yn();
        com.huawei.location.tiles.utils.yn.yn(LW, this.ut);
        ExecutorUtil.getInstance().execute(new Vw(this, str, str2, str3, str4));
    }

    public com.huawei.location.tiles.store.LW FB(String str) throws IOException {
        if (TextUtils.isEmpty(yn)) {
            LogLocation.i("TileStoreManager", "store dir is empty");
            return new com.huawei.location.tiles.store.LW(3, null);
        }
        if (TextUtils.isEmpty(dC)) {
            LogLocation.i("TileStoreManager", "Failed to get tile,currCityCode is empty");
            return new com.huawei.location.tiles.store.LW(3, null);
        }
        if (this.Ot == null) {
            this.Ot = yn(dC);
        }
        com.huawei.location.tiles.store.Vw vw = this.Ot;
        if (vw == null) {
            LogLocation.i("TileStoreManager", "Failed to get tile,cityInfo cache is null");
            Vw(dC);
            return new com.huawei.location.tiles.store.LW(2, null);
        }
        com.huawei.location.tiles.store.FB fbYn = yn(str, vw.Vw());
        if (fbYn == null) {
            LogLocation.d("TileStoreManager", "current location does not have tile info");
            return new com.huawei.location.tiles.store.LW(3, null);
        }
        String strYn = fbYn.yn();
        String strYn2 = com.huawei.location.tiles.utils.yn.yn(LW, strYn);
        String strFB = fbYn.FB();
        String strVw = fbYn.Vw();
        if (TextUtils.isEmpty(strYn2)) {
            LogLocation.d("TileStoreManager", "get filePath from downloadUrl error");
            return new com.huawei.location.tiles.store.LW(3, null);
        }
        File file = new File(strYn2);
        if (!file.exists()) {
            LogLocation.i("TileStoreManager", "tile zip file does not exist");
            yn(strYn2, strYn, strFB, strVw);
            return new com.huawei.location.tiles.store.LW(2, null);
        }
        String strYn3 = com.huawei.location.tiles.utils.LW.yn(strYn2, strFB);
        if (!TextUtils.isEmpty(strYn3) && strYn3.equals(strVw)) {
            LogLocation.i("TileStoreManager", "get tilePath success from the tileStore.");
            return new com.huawei.location.tiles.store.LW(1, strYn2);
        }
        LogLocation.i("TileStoreManager", "The signature information is incorrect.");
        if (file.delete()) {
            LogLocation.e("TileStoreManager", "Failed to delete the file.");
        }
        yn(strYn2, strYn, strFB, strVw);
        return new com.huawei.location.tiles.store.LW(2, null);
    }

    public com.huawei.location.tiles.utils.d2 yn() {
        return new com.huawei.location.tiles.utils.d2(d2, E5);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean Vw() throws java.io.IOException {
        /*
            r10 = this;
            com.huawei.location.tiles.store.yn r0 = r10.oc
            r1 = 604800000(0x240c8400, double:2.988109026E-315)
            java.lang.String r3 = "CityAdminJson"
            r4 = 0
            java.lang.String r5 = "TileStoreManager"
            if (r0 != 0) goto L7a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = com.huawei.location.tiles.store.dC.yn
            r0.append(r6)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r6 = r3.exists()
            if (r6 != 0) goto L29
            goto L49
        L29:
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r3.lastModified()
            long r6 = r6 - r8
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L3f
            boolean r0 = r3.delete()
            if (r0 == 0) goto L49
            java.lang.String r0 = "Failed to delete old adminJson file."
            goto L5a
        L3f:
            java.lang.String r0 = com.huawei.location.tiles.utils.yn.Vw(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L4b
        L49:
            r0 = r4
            goto L5e
        L4b:
            com.google.gson.Gson r1 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch: com.google.gson.JsonSyntaxException -> L58
            java.lang.Class<com.huawei.location.tiles.store.yn> r2 = com.huawei.location.tiles.store.yn.class
            java.lang.Object r0 = r1.fromJson(r0, r2)     // Catch: com.google.gson.JsonSyntaxException -> L58
            com.huawei.location.tiles.store.yn r0 = (com.huawei.location.tiles.store.yn) r0     // Catch: com.google.gson.JsonSyntaxException -> L58
            goto L5e
        L58:
            java.lang.String r0 = "json syntax error"
        L5a:
            com.huawei.location.lite.common.log.LogLocation.e(r5, r0)
            goto L49
        L5e:
            r10.oc = r0
            if (r0 == 0) goto L64
            r0 = 1
            goto L65
        L64:
            r0 = 0
        L65:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "hasAdminJson is: "
        L6c:
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.huawei.location.lite.common.log.LogLocation.i(r5, r1)
            goto L97
        L7a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = com.huawei.location.tiles.store.dC.yn
            r0.append(r6)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.huawei.location.tiles.utils.yn.yn(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adminJson is exist, checking local files are expired: "
            goto L6c
        L97:
            if (r0 != 0) goto Lac
            java.lang.String r1 = "set adminJson is null"
            com.huawei.location.lite.common.log.LogLocation.i(r5, r1)
            r10.oc = r4
            com.huawei.location.lite.common.util.ExecutorUtil r1 = com.huawei.location.lite.common.util.ExecutorUtil.getInstance()
            com.huawei.location.tiles.store.dC$yn r2 = new com.huawei.location.tiles.store.dC$yn
            r2.<init>()
            r1.execute(r2)
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.store.dC.Vw():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069 A[Catch: JsonSyntaxException -> 0x006d, TRY_LEAVE, TryCatch #2 {JsonSyntaxException -> 0x006d, blocks: (B:16:0x0054, B:18:0x0069), top: B:33:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void yn(com.huawei.location.tiles.store.dC r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "json syntax error"
            java.lang.String r1 = "TileStoreManager"
            r7.getClass()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 1
        Ld:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            java.lang.String r5 = "_"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = com.huawei.location.activity.model.Vw.Vw(r4)
            com.huawei.location.tiles.store.zp r5 = new com.huawei.location.tiles.store.zp     // Catch: com.google.gson.JsonSyntaxException -> L3e
            r5.<init>(r7)     // Catch: com.google.gson.JsonSyntaxException -> L3e
            java.lang.reflect.Type r5 = r5.getType()     // Catch: com.google.gson.JsonSyntaxException -> L3e
            com.google.gson.Gson r6 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch: com.google.gson.JsonSyntaxException -> L3e
            java.lang.Object r4 = r6.fromJson(r4, r5)     // Catch: com.google.gson.JsonSyntaxException -> L3e
            java.util.List r4 = (java.util.List) r4     // Catch: com.google.gson.JsonSyntaxException -> L3e
            if (r4 == 0) goto L42
            r2.addAll(r4)     // Catch: com.google.gson.JsonSyntaxException -> L3f
            goto L42
        L3e:
            r4 = 0
        L3f:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r0)
        L42:
            if (r4 == 0) goto L50
            int r4 = r4.size()
            r5 = 59
            if (r4 >= r5) goto L4d
            goto L50
        L4d:
            int r3 = r3 + 1
            goto Ld
        L50:
            java.lang.String r3 = com.huawei.location.activity.model.Vw.Vw(r8)
            com.huawei.location.tiles.store.ut r4 = new com.huawei.location.tiles.store.ut     // Catch: com.google.gson.JsonSyntaxException -> L6d
            r4.<init>(r7)     // Catch: com.google.gson.JsonSyntaxException -> L6d
            java.lang.reflect.Type r4 = r4.getType()     // Catch: com.google.gson.JsonSyntaxException -> L6d
            com.google.gson.Gson r5 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch: com.google.gson.JsonSyntaxException -> L6d
            java.lang.Object r3 = r5.fromJson(r3, r4)     // Catch: com.google.gson.JsonSyntaxException -> L6d
            java.util.List r3 = (java.util.List) r3     // Catch: com.google.gson.JsonSyntaxException -> L6d
            if (r3 == 0) goto L70
            r2.addAll(r3)     // Catch: com.google.gson.JsonSyntaxException -> L6d
            goto L70
        L6d:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r0)
        L70:
            int r0 = r2.size()
            if (r0 <= 0) goto Lb1
            com.huawei.location.tiles.store.Vw r0 = new com.huawei.location.tiles.store.Vw
            r0.<init>(r8, r2)
            r7.Ot = r0
            com.google.gson.Gson r0 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            com.huawei.location.tiles.store.Vw r7 = r7.Ot
            java.lang.String r7 = r0.toJson(r7)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = com.huawei.location.tiles.store.dC.FB
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            java.io.File r8 = r0.getParentFile()
            boolean r8 = r8.exists()
            if (r8 != 0) goto Lae
            java.io.File r8 = r0.getParentFile()
            r8.mkdirs()
        Lae:
            com.huawei.location.tiles.utils.yn.yn(r7, r0)
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.store.dC.yn(com.huawei.location.tiles.store.dC, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean yn(double r10, double r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.store.dC.yn(double, double):boolean");
    }
}
