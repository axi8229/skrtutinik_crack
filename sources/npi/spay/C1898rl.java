package npi.spay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

/* renamed from: npi.spay.rl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1898rl {
    public static String a(String source) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            Intrinsics.checkNotNull(messageDigest);
            messageDigest.reset();
            byte[] bytes = source.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest.digest(source.toByteArray())");
            return a(bArrDigest);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "hex.toString()");
        return string;
    }
}
