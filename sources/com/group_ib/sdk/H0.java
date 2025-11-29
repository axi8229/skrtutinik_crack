package com.group_ib.sdk;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class H0 implements d1 {
    public final MobileSdkService a;
    public int b = 0;
    public boolean c = false;

    public H0(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    public static int b(int i) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq")), 1000);
            String line = bufferedReader.readLine();
            bufferedReader.close();
            return Integer.parseInt(line);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) {
        b1 b1Var;
        if (i == 128) {
            int i2 = 1;
            this.c = true;
            b1Var = new b1();
            try {
                a(b1Var);
                JSONArray jSONArray = new JSONArray();
                for (String str : Build.SUPPORTED_ABIS) {
                    jSONArray.put(str);
                }
                b1Var.put("ABIs", jSONArray);
                try {
                    File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new F0());
                    int length = (fileArrListFiles == null || fileArrListFiles.length <= 0) ? 1 : fileArrListFiles.length;
                    this.b = length;
                    i2 = length;
                } catch (Exception unused) {
                    this.b = 1;
                }
                this.b = i2;
                b1Var.put("CoreCount", Integer.valueOf(i2));
            } catch (Exception e) {
                c1.b("CpuProvider", "failed to get CPU params", e);
            }
        } else {
            b1Var = null;
        }
        if (this.c) {
            if (i == 4 || i == 8 || i == 16 || i == 32 || i == 128) {
                if (b1Var == null) {
                    b1Var = new b1();
                }
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i3 = 0; i3 < this.b; i3++) {
                        jSONArray2.put(b(i3));
                    }
                    b1Var.put("Frequency", jSONArray2);
                } catch (Exception e2) {
                    c1.b("CpuProvider", "failed to get CPU frequency", e2);
                }
                MobileSdkService mobileSdkService = this.a;
                mobileSdkService.getClass();
                b1Var.a(MobileSdkService.O, "cpu parameters updated:");
                synchronized (mobileSdkService.p) {
                    try {
                        b1 b1Var2 = mobileSdkService.N;
                        if (b1Var2 != null) {
                            b1Var2.putAll(b1Var);
                        } else {
                            mobileSdkService.N = b1Var;
                        }
                    } finally {
                    }
                }
            }
        }
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
    }

    public static void a(b1 b1Var) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split(":");
                if (strArrSplit.length > 1) {
                    String strTrim = strArrSplit[0].trim();
                    if (strTrim.equals("model name") || strTrim.equals("Processor")) {
                        String strTrim2 = strArrSplit[1].trim();
                        if (hashSet.add(strTrim2)) {
                            if (jSONArray == null) {
                                jSONArray = new JSONArray();
                            }
                            jSONArray.put(strTrim2);
                        }
                    }
                }
            }
            if (jSONArray != null) {
                b1Var.put("CPUModels", jSONArray);
            }
            bufferedReader.close();
        } catch (Exception e) {
            c1.b("CpuProvider", "failed to get CPU model", e);
        }
    }
}
