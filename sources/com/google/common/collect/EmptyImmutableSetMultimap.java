package com.google.common.collect;

/* loaded from: classes2.dex */
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0, null);
    }
}
