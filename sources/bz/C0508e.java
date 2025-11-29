package bz;

import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* renamed from: bz.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0508e extends R0 {
    public final /* synthetic */ C0511f a;

    public C0508e(C0511f c0511f) {
        this.a = c0511f;
    }

    public final /* synthetic */ File a() {
        try {
            return new File(this.a.c.getPackageManager().getPackageInfo(this.a.c.getPackageName(), 128).applicationInfo.sourceDir);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        File file = (File) this.a.a(new Callable() { // from class: bz.e$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a();
            }
        });
        if (file == null) {
            return;
        }
        String string = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        messageDigest.update(bArr, 0, i);
                    }
                }
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    StringBuilder sb2 = new StringBuilder(Integer.toHexString(b & 255));
                    while (sb2.length() < 2) {
                        sb2.insert(0, "0");
                    }
                    sb.append((CharSequence) sb2);
                }
                string = sb.toString();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
        }
        this.a.a(string);
    }
}
