package ru.yoomoney.sdk.two_fa.exception;

import kotlin.Metadata;

/* compiled from: ExceptionResolver.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/two_fa/exception/ExceptionResolver;", "", "resolve", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "e", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ExceptionResolver {
    Failure resolve(Throwable e);
}
