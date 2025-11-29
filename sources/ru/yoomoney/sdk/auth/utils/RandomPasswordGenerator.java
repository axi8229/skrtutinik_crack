package ru.yoomoney.sdk.auth.utils;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006R,\u0010\u0003\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR#\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR#\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/utils/RandomPasswordGenerator;", "", "()V", "charGenerator", "Lkotlin/Function1;", "", "", "", "", "random", "Ljava/security/SecureRandom;", "randomDigits", "getRandomDigits", "()Lkotlin/jvm/functions/Function1;", "randomLowercase", "getRandomLowercase", "randomSpecial", "getRandomSpecial", "randomUppercase", "getRandomUppercase", "generate", "", "length", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RandomPasswordGenerator {
    private static final Function1<char[], Function1<Integer, List<Character>>> charGenerator;
    private static final Function1<Integer, List<Character>> randomDigits;
    private static final Function1<Integer, List<Character>> randomLowercase;
    private static final Function1<Integer, List<Character>> randomSpecial;
    private static final Function1<Integer, List<Character>> randomUppercase;
    public static final RandomPasswordGenerator INSTANCE = new RandomPasswordGenerator();
    private static final SecureRandom random = new SecureRandom();

    public static final class a extends Lambda implements Function1<char[], Function1<? super Integer, ? extends List<? extends Character>>> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Function1<? super Integer, ? extends List<? extends Character>> invoke(char[] cArr) {
            char[] alphabet = cArr;
            Intrinsics.checkNotNullParameter(alphabet, "alphabet");
            return new ru.yoomoney.sdk.auth.utils.a(alphabet);
        }
    }

    static {
        a aVar = a.a;
        charGenerator = aVar;
        char[] charArray = "0123456789".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        randomDigits = (Function1) aVar.invoke(charArray);
        char[] charArray2 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray2, "toCharArray(...)");
        randomLowercase = (Function1) aVar.invoke(charArray2);
        char[] charArray3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray3, "toCharArray(...)");
        randomUppercase = (Function1) aVar.invoke(charArray3);
        char[] charArray4 = "`@#$%^&*()_=+!\\[]{}:;\"|,.".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray4, "toCharArray(...)");
        randomSpecial = (Function1) aVar.invoke(charArray4);
    }

    private RandomPasswordGenerator() {
    }

    public final String generate(int length) {
        if (length < 3) {
            throw new IllegalArgumentException("password length can't be less than 3");
        }
        SecureRandom secureRandom = random;
        int iNextInt = SecureRandomExtensionsKt.nextInt(secureRandom, 1, length - 2);
        int i = length - iNextInt;
        int iNextInt2 = SecureRandomExtensionsKt.nextInt(secureRandom, 1, i - 1);
        int i2 = i - iNextInt2;
        int iNextInt3 = SecureRandomExtensionsKt.nextInt(secureRandom, 1, i2);
        return CollectionsKt.joinToString$default(CollectionsKt.shuffled(CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) randomDigits.invoke(Integer.valueOf(iNextInt)), (Iterable) randomLowercase.invoke(Integer.valueOf(iNextInt2))), (Iterable) randomUppercase.invoke(Integer.valueOf(iNextInt3))), (Iterable) randomSpecial.invoke(Integer.valueOf(i2 - iNextInt3)))), "", null, null, 0, null, null, 62, null);
    }

    public final Function1<Integer, List<Character>> getRandomDigits() {
        return randomDigits;
    }

    public final Function1<Integer, List<Character>> getRandomLowercase() {
        return randomLowercase;
    }

    public final Function1<Integer, List<Character>> getRandomSpecial() {
        return randomSpecial;
    }

    public final Function1<Integer, List<Character>> getRandomUppercase() {
        return randomUppercase;
    }
}
