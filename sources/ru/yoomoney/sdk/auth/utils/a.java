package ru.yoomoney.sdk.auth.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* loaded from: classes4.dex */
public final class a extends Lambda implements Function1<Integer, List<? extends Character>> {
    public final /* synthetic */ char[] a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(char[] cArr) {
        super(1);
        this.a = cArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<? extends Character> invoke(Integer num) {
        IntRange intRange = new IntRange(1, num.intValue());
        char[] cArr = this.a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Character.valueOf(cArr[SecureRandomExtensionsKt.nextInt(RandomPasswordGenerator.random, 0, cArr.length)]));
        }
        return arrayList;
    }
}
