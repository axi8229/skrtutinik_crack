package com.sputnik.domain.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mapper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sputnik/domain/common/ListMapperImpl;", "I", "O", "Lcom/sputnik/domain/common/ListMapper;", "mapper", "Lcom/sputnik/domain/common/Mapper;", "(Lcom/sputnik/domain/common/Mapper;)V", "map", "", "input", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ListMapperImpl<I, O> implements ListMapper<I, O> {
    private final Mapper<I, O> mapper;

    public ListMapperImpl(Mapper<I, O> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sputnik.domain.common.Mapper
    public List<O> map(List<? extends I> input) {
        Intrinsics.checkNotNullParameter(input, "input");
        List<? extends I> list = input;
        Mapper<I, O> mapper = this.mapper;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mapper.map(it.next()));
        }
        return arrayList;
    }
}
