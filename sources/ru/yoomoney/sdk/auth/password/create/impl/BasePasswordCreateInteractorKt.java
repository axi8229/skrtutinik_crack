package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"MAX_VALID_PASSWORD_LENGTH", "", "MIN_VALID_PASSWORD_LENGTH", "REGEX_VALID_SYMBOLS", "Lkotlin/text/Regex;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BasePasswordCreateInteractorKt {
    private static final int MAX_VALID_PASSWORD_LENGTH = 30;
    private static final int MIN_VALID_PASSWORD_LENGTH = 8;
    private static final Regex REGEX_VALID_SYMBOLS = new Regex("^[A-Za-z0-9`@#$%^&*()_=+!\\\\\\[\\]{}:;\"|,.]+$");
}
