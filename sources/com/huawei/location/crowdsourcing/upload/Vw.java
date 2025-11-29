package com.huawei.location.crowdsourcing.upload;

import android.util.Pair;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.crowdsourcing.upload.entity.FB;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Vw {

    /* renamed from: com.huawei.location.crowdsourcing.upload.Vw$Vw, reason: collision with other inner class name */
    private static class C0086Vw extends com.huawei.location.crowdsourcing.upload.http.yn {

        @SerializedName("patchPolicyList")
        com.huawei.location.crowdsourcing.upload.entity.yn E5;

        @SerializedName("reason")
        String yn = "";

        @SerializedName("resCode")
        int Vw = -1;

        @SerializedName("fileUniqueFlag")
        String FB = "";

        @SerializedName("currentTime")
        String LW = "";

        @SerializedName("uploadInfoList")
        List<yn> dC = new ArrayList();

        /* renamed from: com.huawei.location.crowdsourcing.upload.Vw$Vw$yn */
        static class yn {

            @SerializedName("uploadUrl")
            String yn = "";

            @SerializedName("method")
            String Vw = "";

            @SerializedName("objectId")
            String FB = "";

            @SerializedName("headers")
            Map<String, String> LW = new HashMap();

            yn() {
            }

            public String toString() {
                return "UploadInfo{method='" + this.Vw + '}';
            }
        }

        private C0086Vw() {
        }

        public String toString() {
            return "Resp{reason='" + this.yn + "', resCode='" + this.Vw + "', fileUniqueFlag='" + this.FB + "', currentTime='" + this.LW + "', uploadInfoList=" + this.dC + ", patchPolicyList=" + this.E5 + '}';
        }
    }

    private static class yn {

        @SerializedName("fileSize")
        final long FB;

        @SerializedName("fileSha256")
        final String Vw;

        @SerializedName("fileMd5")
        final String yn = "";

        yn(String str, long j) {
            this.Vw = str;
            this.FB = j;
        }
    }

    private static long yn(com.huawei.location.crowdsourcing.upload.entity.yn ynVar, long j) {
        long jVw = ynVar.Vw();
        long jCeil = (long) Math.ceil(j / ynVar.yn());
        return jCeil > ynVar.Vw() ? jCeil : jVw;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005b A[Catch: all -> 0x0035, LOOP:0: B:4:0x000c->B:34:0x005b, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0035, blocks: (B:5:0x000d, B:7:0x0015, B:16:0x0027, B:20:0x002f, B:24:0x0039, B:34:0x005b, B:25:0x003d, B:28:0x0044), top: B:50:0x000d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0057 A[EDGE_INSN: B:54:0x0057->B:32:0x0057 BREAK  A[LOOP:0: B:4:0x000c->B:34:0x005b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.huawei.location.crowdsourcing.upload.Vw.yn> yn(java.io.File r13, long r14) throws java.io.IOException {
        /*
            java.lang.String r0 = "GetUploadInfo"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.IOException -> L6a
            r2.<init>(r13)     // Catch: java.io.IOException -> L6a
        Lc:
            r13 = 0
            java.lang.String r3 = "SHA-256"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch: java.lang.Throwable -> L35 java.security.NoSuchAlgorithmException -> L52
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]     // Catch: java.lang.Throwable -> L35
            r6 = r14
        L18:
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L3d
            long r10 = (long) r4
            int r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r10 >= 0) goto L25
            int r10 = (int) r6
            goto L26
        L25:
            r10 = r4
        L26:
            r11 = 0
            int r10 = r2.read(r5, r11, r10)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
            r12 = -1
            if (r10 != r12) goto L2f
            goto L3d
        L2f:
            r3.update(r5, r11, r10)     // Catch: java.lang.Throwable -> L35
            long r8 = (long) r10     // Catch: java.lang.Throwable -> L35
            long r6 = r6 - r8
            goto L18
        L35:
            r13 = move-exception
            goto L5f
        L37:
            java.lang.String r3 = "read file error"
        L39:
            com.huawei.location.lite.common.log.LogLocation.e(r0, r3)     // Catch: java.lang.Throwable -> L35
            goto L55
        L3d:
            long r4 = r14 - r6
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L44
            goto L55
        L44:
            com.huawei.location.crowdsourcing.upload.Vw$yn r13 = new com.huawei.location.crowdsourcing.upload.Vw$yn     // Catch: java.lang.Throwable -> L35
            byte[] r3 = r3.digest()     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = com.huawei.secure.android.common.util.HexUtil.byteArray2HexStr(r3)     // Catch: java.lang.Throwable -> L35
            r13.<init>(r3, r4)     // Catch: java.lang.Throwable -> L35
            goto L55
        L52:
            java.lang.String r3 = "NoSuchAlgorithmException SHA-256"
            goto L39
        L55:
            if (r13 != 0) goto L5b
            r2.close()     // Catch: java.io.IOException -> L6a
            goto L6f
        L5b:
            r1.add(r13)     // Catch: java.lang.Throwable -> L35
            goto Lc
        L5f:
            throw r13     // Catch: java.lang.Throwable -> L60
        L60:
            r14 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L65
            goto L69
        L65:
            r15 = move-exception
            r13.addSuppressed(r15)     // Catch: java.io.IOException -> L6a
        L69:
            throw r14     // Catch: java.io.IOException -> L6a
        L6a:
            java.lang.String r13 = "IOException"
            com.huawei.location.lite.common.log.LogLocation.e(r0, r13)
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.Vw.yn(java.io.File, long):java.util.List");
    }

    public Pair<com.huawei.location.crowdsourcing.upload.entity.yn, com.huawei.location.crowdsourcing.upload.entity.FB> yn(com.huawei.location.crowdsourcing.upload.entity.Vw vw, String str, Map<String, String> map, String str2, com.huawei.location.crowdsourcing.upload.entity.yn ynVar) throws IOException {
        com.huawei.location.crowdsourcing.upload.entity.FB fb;
        File file = new File(str);
        if (!file.exists()) {
            LogLocation.e("GetUploadInfo", "file not exist");
            return null;
        }
        long length = file.length();
        com.huawei.location.crowdsourcing.upload.http.FB fb2 = new com.huawei.location.crowdsourcing.upload.http.FB(vw.yn, "/v2/getUploadInfo");
        fb2.yn(map).FB("logType", "0").FB("fileName", file.getName()).FB("fileSize", String.valueOf(length)).FB("encryptKey", "0").FB("others", "others").dC(vw.Vw, str2).Vw("appID", str2);
        com.huawei.location.crowdsourcing.upload.entity.yn ynVar2 = ynVar;
        long jYn = yn(ynVar2, length);
        List<yn> listYn = yn(file, jYn);
        C0086Vw c0086Vw = (C0086Vw) fb2.LW("fileHashList", GsonUtil.getInstance().toJsonTree(listYn, listYn.getClass()).getAsJsonArray().toString()).FB("patchSize", String.valueOf(jYn)).FB("patchNum", String.valueOf(((ArrayList) listYn).size())).FB("patchVer", ynVar.FB()).yn(C0086Vw.class);
        if (c0086Vw == null) {
            LogLocation.e("GetUploadInfo", "server return null");
            return null;
        }
        if (c0086Vw.Vw == 200009) {
            ynVar2 = c0086Vw.E5;
            if (ynVar2 == null) {
                LogLocation.e("GetUploadInfo", "200009 without patchPolicy");
                return null;
            }
            long jYn2 = yn(ynVar2, length);
            listYn = yn(file, jYn2);
            c0086Vw = (C0086Vw) fb2.LW("fileHashList", GsonUtil.getInstance().toJsonTree(listYn, listYn.getClass()).getAsJsonArray().toString()).FB("patchSize", String.valueOf(jYn2)).FB("patchNum", String.valueOf(((ArrayList) listYn).size())).FB("patchVer", ynVar2.FB()).yn(C0086Vw.class);
            if (c0086Vw == null) {
                LogLocation.e("GetUploadInfo", "redo failed");
                return null;
            }
        }
        if (!com.huawei.location.activity.model.Vw.Vw(c0086Vw.Vw)) {
            LogLocation.e("GetUploadInfo", "server return not success. error info:" + com.huawei.location.activity.model.Vw.yn(c0086Vw.Vw));
            return null;
        }
        if (c0086Vw.dC == null || listYn.size() != c0086Vw.dC.size()) {
            LogLocation.e("GetUploadInfo", "size diff");
            fb = null;
        } else {
            String str3 = c0086Vw.FB;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = c0086Vw.LW;
            if (str4 == null) {
                str4 = "";
            }
            fb = new com.huawei.location.crowdsourcing.upload.entity.FB(str3, str4);
            for (int i = 0; i < listYn.size(); i++) {
                C0086Vw.yn ynVar3 = c0086Vw.dC.get(i);
                String str5 = ynVar3.yn;
                if (str5 == null) {
                    str5 = "";
                }
                Map map2 = ynVar3.LW;
                if (map2 == null) {
                    map2 = new HashMap();
                }
                fb.FB.add(new FB.yn(str5, listYn.get(i).FB, map2));
            }
        }
        if (fb == null) {
            return null;
        }
        return new Pair<>(ynVar2, fb);
    }
}
