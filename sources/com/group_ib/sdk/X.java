package com.group_ib.sdk;

import android.os.Debug;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.KotlinVersion;

/* loaded from: classes3.dex */
public abstract class X {
    public static boolean a = false;
    public static final HashMap b = new HashMap();
    public static Cipher c = null;

    public static int a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = (int) (i * (((short) ((int) ((long) 2))) == 9 ? jCurrentTimeMillis / jCurrentTimeMillis : 1L));
        if (!a) {
            try {
                char[] cArr = AbstractC0604j0.a;
                if (1 / i2 > 0 && T.w == null) {
                    try {
                        T.w = Debug.class.getDeclaredMethod(b(0), null);
                    } catch (Exception unused) {
                    }
                }
                int i3 = Q0.$r8$clinit;
                if (((Boolean) T.w.invoke(null, null)).booleanValue()) {
                    i2 += 100;
                }
            } catch (Exception unused2) {
            }
        }
        return i2 % AbstractC0594e0.a.size();
    }

    public static synchronized String b(int i) {
        String str;
        byte[] bArr;
        try {
            str = (String) b.get(Integer.valueOf(i));
            if (str == null) {
                HashMap map = AbstractC0594e0.a;
                ByteBuffer byteBuffer = (ByteBuffer) map.get(Integer.valueOf(a(i)));
                if (byteBuffer != null) {
                    int i2 = i != 0 ? ((i * 11) % 10) * (-1) : -7;
                    int i3 = i != 0 ? (i * 7) % i : -3;
                    try {
                        ByteBuffer byteBuffer2 = (ByteBuffer) map.get(Integer.valueOf(i2));
                        ByteBuffer byteBuffer3 = (ByteBuffer) map.get(Integer.valueOf(i3));
                        if (byteBuffer2 == null || byteBuffer3 == null) {
                            bArr = null;
                        } else {
                            bArr = new byte[16];
                            byte[] bArrArray = byteBuffer2.array();
                            byte[] bArrArray2 = byteBuffer3.array();
                            int length = bArrArray.length;
                            int i4 = i % length;
                            int length2 = bArrArray2.length;
                            int i5 = i % length2;
                            int i6 = 0;
                            while (i6 < 16) {
                                int i7 = i4 + 1;
                                bArr[i6] = (byte) ((bArrArray[i4 % length] ^ bArrArray2[i5]) & KotlinVersion.MAX_COMPONENT_VALUE);
                                i5 -= 2;
                                if (i5 < 0) {
                                    i5 = length2 - 1;
                                }
                                i6++;
                                i4 = i7;
                            }
                        }
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                        if (c == null) {
                            c = Cipher.getInstance("AES");
                        }
                        c.init(2, secretKeySpec);
                        str = new String(c.doFinal(byteBuffer.array()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        str = null;
                    }
                    if (str != null) {
                        b.put(Integer.valueOf(i), str);
                    }
                } else {
                    str = "";
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }
}
