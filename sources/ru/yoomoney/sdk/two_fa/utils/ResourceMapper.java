package ru.yoomoney.sdk.two_fa.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.exception.Failure;
import ru.yoomoney.sdk.two_fa.exception.NetworkConnectionFailure;
import ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure;

/* compiled from: ResourceMapper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "map", "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/two_fa/exception/Failure;", "attemptsLeft", "", "(Lru/yoomoney/sdk/two_fa/exception/Failure;Ljava/lang/Integer;)Ljava/lang/String;", "Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;", "(Lru/yoomoney/sdk/two_fa/exception/RulesViolationFailure;Ljava/lang/Integer;)Ljava/lang/String;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResourceMapper {
    public static final int $stable = 8;
    private final Context context;

    public ResourceMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public static /* synthetic */ String map$default(ResourceMapper resourceMapper, Failure failure, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return resourceMapper.map(failure, num);
    }

    public final String map(Failure failure, Integer attemptsLeft) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failure instanceof NetworkConnectionFailure) {
            String string = this.context.getString(R.string.two_fa_network_connection_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (failure instanceof RulesViolationFailure) {
            return map((RulesViolationFailure) failure, attemptsLeft);
        }
        String string2 = this.context.getString(R.string.two_fa_default_error);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private final String map(RulesViolationFailure failure, Integer attemptsLeft) {
        String string;
        if (failure instanceof RulesViolationFailure.VelocityCheckFailure) {
            String string2 = this.context.getString(R.string.two_fa_error_velocity_check_descritpion);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (failure instanceof RulesViolationFailure.ActiveSessionIsExpiredFailure) {
            String string3 = this.context.getString(R.string.two_fa_error_code_expired_error);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (failure instanceof RulesViolationFailure.NoAttemptsLeftFailure) {
            String string4 = this.context.getString(R.string.two_fa_error_invalid_code_no_attempts);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (!(failure instanceof RulesViolationFailure.InvalidSecretFailure)) {
            throw new NoWhenBranchMatchedException();
        }
        if (attemptsLeft != null && attemptsLeft.intValue() == 2) {
            string = this.context.getString(R.string.two_fa_error_invalid_code_two_attempt_left);
        } else if (attemptsLeft != null && attemptsLeft.intValue() == 1) {
            string = this.context.getString(R.string.two_fa_error_invalid_code_one_attempt_left);
        } else {
            string = (attemptsLeft != null && attemptsLeft.intValue() == 0) ? this.context.getString(R.string.two_fa_error_invalid_code_no_attempts) : this.context.getString(R.string.two_fa_error_invalid_code);
        }
        Intrinsics.checkNotNull(string);
        return string;
    }
}
