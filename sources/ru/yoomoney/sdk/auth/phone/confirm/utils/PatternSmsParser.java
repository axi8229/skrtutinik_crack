package ru.yoomoney.sdk.auth.phone.confirm.utils;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/utils/PatternSmsParser;", "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsParser;", "length", "", "(I)V", "pattern", "Ljava/util/regex/Pattern;", "parse", "", CrashHianalyticsData.MESSAGE, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PatternSmsParser implements SmsParser {
    private final Pattern pattern;

    public PatternSmsParser(int i) {
        Pattern patternCompile = Pattern.compile(".*(\\d{" + i + "}).*", 32);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this.pattern = patternCompile;
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsParser
    public String parse(String message) {
        if (message == null) {
            return null;
        }
        Matcher matcher = this.pattern.matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
