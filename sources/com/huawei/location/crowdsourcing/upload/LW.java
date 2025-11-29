package com.huawei.location.crowdsourcing.upload;

import com.huawei.location.crowdsourcing.upload.entity.FB;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class LW {
    private void yn(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, long j, byte[] bArr) throws IOException {
        int i = fileInputStream.read(bArr, 0, (int) j);
        if (i != -1) {
            bufferedOutputStream.write(bArr, 0, i);
        }
    }

    private boolean yn(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!yn(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc A[LOOP:2: B:35:0x00b6->B:37:0x00bc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da A[LOOP:0: B:3:0x0005->B:40:0x00da, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean yn(java.util.List<com.huawei.location.crowdsourcing.upload.entity.FB.yn> r23, java.lang.String r24, java.io.FileInputStream r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.LW.yn(java.util.List, java.lang.String, java.io.FileInputStream):boolean");
    }

    public boolean yn(List<FB.yn> list, String str) throws IOException {
        File file = new File(str);
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(file.getParent());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("split");
        File file2 = new File(sb.toString());
        yn(file2);
        boolean zYn = false;
        if (!file2.mkdir()) {
            LogLocation.e("UploadFile", "make split dir failed");
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                zYn = yn(list, file2.getCanonicalPath() + str2 + name, fileInputStream);
                fileInputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.i("UploadFile", "IOException:....fileinputstream.");
        }
        yn(file2);
        return zYn;
    }
}
