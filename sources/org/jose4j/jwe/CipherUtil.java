package org.jose4j.jwe;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class CipherUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v8, types: [javax.crypto.Cipher] */
    static Cipher getCipher(String str, String str2) throws JoseException {
        try {
            str = str2 == null ? Cipher.getInstance(str) : Cipher.getInstance(str, str2);
            return str;
        } catch (NoSuchAlgorithmException e) {
            e = e;
            throw new JoseException(e.toString(), e);
        } catch (NoSuchProviderException e2) {
            throw new JoseException("Unable to get a Cipher implementation of " + str + " using provider " + str2, e2);
        } catch (NoSuchPaddingException e3) {
            e = e3;
            throw new JoseException(e.toString(), e);
        }
    }
}
