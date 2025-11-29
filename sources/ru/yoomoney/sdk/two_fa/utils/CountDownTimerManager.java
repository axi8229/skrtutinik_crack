package ru.yoomoney.sdk.two_fa.utils;

import android.os.CountDownTimer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDateTime;

/* compiled from: CountDownTimerManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ0\u0010\f\u001a\u00020\u0005*\u0004\u0018\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/two_fa/utils/CountDownTimerManager;", "", "onTick", "Lkotlin/Function1;", "", "", "onFinish", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "startTimerIfNeed", "dateTimeLimit", "Lorg/threeten/bp/LocalDateTime;", "checkTime", "onTimeOver", "onHaveTime", "takeDurationFromNow", "", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CountDownTimerManager {
    public static final int $stable = 0;
    private final Function0<Unit> onFinish;
    private final Function1<String, Unit> onTick;

    /* JADX WARN: Multi-variable type inference failed */
    public CountDownTimerManager(Function1<? super String, Unit> onTick, Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(onTick, "onTick");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        this.onTick = onTick;
        this.onFinish = onFinish;
    }

    public final void startTimerIfNeed(LocalDateTime dateTimeLimit) {
        checkTime(dateTimeLimit, new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.utils.CountDownTimerManager.startTimerIfNeed.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CountDownTimerManager.this.onFinish.invoke();
            }
        }, new Function1<LocalDateTime, Unit>() { // from class: ru.yoomoney.sdk.two_fa.utils.CountDownTimerManager.startTimerIfNeed.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalDateTime localDateTime) {
                invoke2(localDateTime);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalDateTime it) {
                Intrinsics.checkNotNullParameter(it, "it");
                final long jTakeDurationFromNow = CountDownTimerManager.this.takeDurationFromNow(it);
                final CountDownTimerManager countDownTimerManager = CountDownTimerManager.this;
                new CountDownTimer(jTakeDurationFromNow) { // from class: ru.yoomoney.sdk.two_fa.utils.CountDownTimerManager$startTimerIfNeed$2$timer$1
                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
                        Function1 function1 = countDownTimerManager.onTick;
                        String str = simpleDateFormat.format(new Date(millisUntilFinished));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        function1.invoke(str);
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        countDownTimerManager.onFinish.invoke();
                    }
                }.start();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long takeDurationFromNow(LocalDateTime localDateTime) {
        if (localDateTime.isAfter(LocalDateTime.now())) {
            return Duration.between(LocalDateTime.now(), localDateTime).toMillis();
        }
        return 0L;
    }

    private final void checkTime(LocalDateTime localDateTime, Function0<Unit> function0, Function1<? super LocalDateTime, Unit> function1) {
        if (localDateTime == null || !localDateTime.isAfter(LocalDateTime.now())) {
            function0.invoke();
        } else {
            function1.invoke(localDateTime);
        }
    }
}
