package ru.yoomoney.sdk.auth.utils;

import android.os.Build;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\u001a!\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002¢\u0006\u0002\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000\u001a \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0005H\u0000\u001a \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0000\u001a \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000\u001a\b\u0010\u001d\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"DEFAULT_BUFFER_SIZE", "", "FORMAT_INDICATOR", "", "HASHING_ALGORITHM_HMAC_SHA_256", "", "INITIAL_VECTOR_SIZE", "catchExceptionAndThrowNewOne", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "decodeCryptogram", "Lru/yoomoney/sdk/auth/utils/DecodedCryptogram;", YooMoneyAuth.KEY_CRYPTOGRAM, "decryptByChaCha20Poly1305", "", "json", "initVector", "cipherKey", "decryptCryptogram", "serverKey", "encodeHMac", "algorithm", "key", CrashHianalyticsData.MESSAGE, "encryptByChaCha20Poly1305", "encryptCryptogram", "sessionTicket", "getDeviceInfo", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CipherChaCha20Poly1305Kt {
    private static final int DEFAULT_BUFFER_SIZE = 2;
    private static final short FORMAT_INDICATOR = 1;
    public static final String HASHING_ALGORITHM_HMAC_SHA_256 = "HmacSHA256";
    private static final int INITIAL_VECTOR_SIZE = 32;

    public static final class a extends Lambda implements Function0<DecodedCryptogram> {
        public final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DecodedCryptogram invoke() {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(Base64.urlSafeDecode(this.a)).order(ByteOrder.LITTLE_ENDIAN);
            short s = byteBufferOrder.getShort();
            if (s != 1) {
                throw new IllegalStateException("Corrupted formatIndicator=" + ((int) s));
            }
            int i = byteBufferOrder.getShort();
            Character[] chArr = new Character[i];
            for (int i2 = 0; i2 < i; i2++) {
                chArr[i2] = Character.valueOf(byteBufferOrder.getChar());
            }
            String strJoinToString$default = ArraysKt.joinToString$default(chArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            byte[] bArrArray = ByteBuffer.allocate(32).array();
            byteBufferOrder.get(bArrArray);
            ArrayList arrayList = new ArrayList();
            while (byteBufferOrder.hasRemaining()) {
                arrayList.add(Character.valueOf(byteBufferOrder.getChar()));
            }
            byte[] bArrDecode = Base64.decode(CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null));
            Intrinsics.checkNotNull(bArrArray);
            Intrinsics.checkNotNull(bArrDecode);
            return new DecodedCryptogram(strJoinToString$default, bArrArray, bArrDecode);
        }
    }

    public static final class b extends Lambda implements Function0<byte[]> {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ byte[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            super(0);
            this.a = bArr;
            this.b = bArr2;
            this.c = bArr3;
        }

        @Override // kotlin.jvm.functions.Function0
        public final byte[] invoke() {
            return new ChaCha20Poly1305(this.a).decrypt(this.b, this.c);
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ DecodedCryptogram b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DecodedCryptogram decodedCryptogram, String str) {
            super(0);
            this.a = str;
            this.b = decodedCryptogram;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() throws IllegalStateException, GeneralSecurityException {
            TinkConfig.register();
            String deviceInfo = CipherChaCha20Poly1305Kt.getDeviceInfo();
            String str = this.a;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = deviceInfo.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return new String(CipherChaCha20Poly1305Kt.decryptByChaCha20Poly1305(this.b.getEncryptedJson(), this.b.getInitialVector(), CipherChaCha20Poly1305Kt.encodeHMac(CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256, bytes, bytes2)), charset);
        }
    }

    public static final class d extends Lambda implements Function0<byte[]> {
        public final /* synthetic */ String a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ byte[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, byte[] bArr, byte[] bArr2) {
            super(0);
            this.a = str;
            this.b = bArr;
            this.c = bArr2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final byte[] invoke() throws NoSuchAlgorithmException, InvalidKeyException {
            Mac mac = Mac.getInstance(this.a);
            mac.init(new SecretKeySpec(this.b, this.a));
            return mac.doFinal(this.c);
        }
    }

    public static final class e extends Lambda implements Function0<byte[]> {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ byte[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            super(0);
            this.a = bArr;
            this.b = bArr2;
            this.c = bArr3;
        }

        @Override // kotlin.jvm.functions.Function0
        public final byte[] invoke() {
            return new ChaCha20Poly1305(this.a).encrypt(this.b, this.c);
        }
    }

    public static final class f extends Lambda implements Function0<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, String str2, String str3) {
            super(0);
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() throws IllegalStateException, GeneralSecurityException {
            TinkConfig.register();
            byte[] bArrGenerateSeed = new SecureRandom().generateSeed(32);
            String deviceInfo = CipherChaCha20Poly1305Kt.getDeviceInfo();
            String str = this.a;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = deviceInfo.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] bArrEncodeHMac = CipherChaCha20Poly1305Kt.encodeHMac(CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256, bytes, bytes2);
            byte[] bytes3 = this.b.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            Intrinsics.checkNotNull(bArrGenerateSeed);
            String strEncode = Base64.encode(CipherChaCha20Poly1305Kt.encryptByChaCha20Poly1305(bytes3, bArrGenerateSeed, bArrEncodeHMac));
            ByteBuffer byteBufferOrder = ByteBuffer.allocate((strEncode.length() * 2) + (this.c.length() * 2) + 36).order(ByteOrder.LITTLE_ENDIAN);
            String str2 = this.c;
            byteBufferOrder.putShort(CipherChaCha20Poly1305Kt.FORMAT_INDICATOR);
            byteBufferOrder.putShort((short) str2.length());
            for (int i = 0; i < str2.length(); i++) {
                byteBufferOrder.putChar(str2.charAt(i));
            }
            byteBufferOrder.put(bArrGenerateSeed);
            Intrinsics.checkNotNull(strEncode);
            for (int i2 = 0; i2 < strEncode.length(); i2++) {
                byteBufferOrder.putChar(strEncode.charAt(i2));
            }
            return Base64.urlSafeEncode(byteBufferOrder.array());
        }
    }

    private static final <T> T catchExceptionAndThrowNewOne(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Exception e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    public static final DecodedCryptogram decodeCryptogram(String cryptogram) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(cryptogram, "cryptogram");
        return (DecodedCryptogram) catchExceptionAndThrowNewOne(new a(cryptogram));
    }

    public static final byte[] decryptByChaCha20Poly1305(byte[] json, byte[] initVector, byte[] cipherKey) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(initVector, "initVector");
        Intrinsics.checkNotNullParameter(cipherKey, "cipherKey");
        Object objCatchExceptionAndThrowNewOne = catchExceptionAndThrowNewOne(new b(initVector, json, cipherKey));
        Intrinsics.checkNotNullExpressionValue(objCatchExceptionAndThrowNewOne, "catchExceptionAndThrowNewOne(...)");
        return (byte[]) objCatchExceptionAndThrowNewOne;
    }

    public static final String decryptCryptogram(DecodedCryptogram cryptogram, String serverKey) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(cryptogram, "cryptogram");
        Intrinsics.checkNotNullParameter(serverKey, "serverKey");
        return (String) catchExceptionAndThrowNewOne(new c(cryptogram, serverKey));
    }

    public static final byte[] encodeHMac(String algorithm, byte[] key, byte[] message) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Object objCatchExceptionAndThrowNewOne = catchExceptionAndThrowNewOne(new d(algorithm, key, message));
        Intrinsics.checkNotNullExpressionValue(objCatchExceptionAndThrowNewOne, "catchExceptionAndThrowNewOne(...)");
        return (byte[]) objCatchExceptionAndThrowNewOne;
    }

    public static final byte[] encryptByChaCha20Poly1305(byte[] json, byte[] initVector, byte[] cipherKey) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(initVector, "initVector");
        Intrinsics.checkNotNullParameter(cipherKey, "cipherKey");
        Object objCatchExceptionAndThrowNewOne = catchExceptionAndThrowNewOne(new e(initVector, json, cipherKey));
        Intrinsics.checkNotNullExpressionValue(objCatchExceptionAndThrowNewOne, "catchExceptionAndThrowNewOne(...)");
        return (byte[]) objCatchExceptionAndThrowNewOne;
    }

    public static final String encryptCryptogram(String message, String sessionTicket, String serverKey) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sessionTicket, "sessionTicket");
        Intrinsics.checkNotNullParameter(serverKey, "serverKey");
        Object objCatchExceptionAndThrowNewOne = catchExceptionAndThrowNewOne(new f(serverKey, message, sessionTicket));
        Intrinsics.checkNotNullExpressionValue(objCatchExceptionAndThrowNewOne, "catchExceptionAndThrowNewOne(...)");
        return (String) objCatchExceptionAndThrowNewOne;
    }

    public static final String getDeviceInfo() {
        return Build.BOARD + Build.BRAND + Build.DEVICE + Build.DISPLAY + Build.MANUFACTURER + Build.MODEL + Build.PRODUCT;
    }
}
