package com.sputnik.common.entities.instructions;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.R$drawable;
import com.sputnik.common.entities.views.BaseButtonView;
import com.sputnik.common.entities.views.BaseImageView;
import com.sputnik.common.entities.views.BaseTextView;
import com.sputnik.common.entities.views.BaseView;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstructionsByManufacturer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"com/sputnik/common/entities/instructions/InstructionsByManufacturer$Oppo", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "Lcom/sputnik/common/entities/instructions/Instruction;", "oppo_13", "Ljava/util/List;", "getOppo_13", "()Ljava/util/List;", "oppo_12", "getOppo_12", "oppo_11", "getOppo_11", "oppo_10", "getOppo_10", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstructionsByManufacturer$Oppo {
    public static final InstructionsByManufacturer$Oppo INSTANCE = new InstructionsByManufacturer$Oppo();
    private static final String name = "oppo";
    private static final List<Instruction> oppo_10;
    private static final List<Instruction> oppo_11;
    private static final List<Instruction> oppo_12;
    private static final List<Instruction> oppo_13;

    private InstructionsByManufacturer$Oppo() {
    }

    static {
        String string = UUID.randomUUID().toString();
        List listListOf = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.oppo_13_keep)), new BaseTextView("\"Закрепите\" приложение в списке недавних приложений, для этого:", 0, null, 17, 0, 22, null), new BaseTextView("1. Перейдите в список недавних приложений при помощи системного жеста/нажатия кнопки\n2. Удерживайте пальцем на приложении \"Наш дом\" и затем нажмите \"Закрепить приложение\"", 0, "#404040", 8388611, 0, 18, null), new BaseButtonView("Далее", "next", null, true, 4, null)});
        Intrinsics.checkNotNull(string);
        oppo_13 = CollectionsKt.listOf(new Instruction(string, listListOf, "(Шаг %1s)\nЗакрепление приложения"));
        String string2 = UUID.randomUUID().toString();
        List listListOf2 = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.oppo_12_keep)), new BaseTextView("\"Закрепите\" приложение в списке недавних приложений, для этого:", 0, null, 17, 0, 22, null), new BaseTextView("1. Перейдите в список недавних приложений при помощи системного жеста/нажатия кнопки\n2. Удерживайте пальцем на приложении \"Наш дом\" и затем нажмите \"Закрепить приложение\"", 0, "#404040", 8388611, 0, 18, null), new BaseButtonView("Далее", "next", null, true, 4, null)});
        Intrinsics.checkNotNull(string2);
        Instruction instruction = new Instruction(string2, listListOf2, "(Шаг %1s)\nЗакрепление приложения");
        String string3 = UUID.randomUUID().toString();
        List listListOf3 = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.oppo_12_back)), new BaseTextView("1. Откройте системные настройки приложения по кнопке ниже\n\n2. Откройте раздел \"Использование батареи\" и разрешите работу в фоне\"\"", 0, null, 0, 0, 30, null), new BaseButtonView("Открыть настройки", "system/settings/application", null, true, 4, null)});
        Intrinsics.checkNotNull(string3);
        oppo_12 = CollectionsKt.listOf((Object[]) new Instruction[]{instruction, new Instruction(string3, listListOf3, "(Шаг %1s)\nНастройка работы в фоне")});
        String string4 = UUID.randomUUID().toString();
        List listListOf4 = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.oppo_11_keep)), new BaseTextView("\"Закрепите\" приложение в списке недавних приложений, для этого:", 0, null, 17, 0, 22, null), new BaseTextView("1. Перейдите в список недавних приложений при помощи системного жеста/нажатия кнопки\n2. Удерживайте пальцем на приложении \"Наш дом\" и затем нажмите \"Закрепить приложение\"", 0, "#404040", 8388611, 0, 18, null), new BaseButtonView("Далее", "next", null, true, 4, null)});
        Intrinsics.checkNotNull(string4);
        oppo_11 = CollectionsKt.listOf(new Instruction(string4, listListOf4, "(Шаг %1s)\nЗакрепление приложения"));
        String string5 = UUID.randomUUID().toString();
        List listListOf5 = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.oppo_10_keep)), new BaseTextView("\"Закрепите\" приложение в списке недавних приложений, для этого:", 0, null, 17, 0, 22, null), new BaseTextView("1. Перейдите в список недавних приложений при помощи системного жеста/нажатия кнопки\n2. Удерживайте пальцем на приложении \"Наш дом\" и затем нажмите \"Закрепить приложение\"", 0, "#404040", 8388611, 0, 18, null), new BaseButtonView("Далее", "next", null, true, 4, null)});
        Intrinsics.checkNotNull(string5);
        oppo_10 = CollectionsKt.listOf(new Instruction(string5, listListOf5, "(Шаг %1s)\nЗакрепление приложения"));
    }

    public final String getName() {
        return name;
    }

    public final List<Instruction> getOppo_13() {
        return oppo_13;
    }

    public final List<Instruction> getOppo_12() {
        return oppo_12;
    }

    public final List<Instruction> getOppo_11() {
        return oppo_11;
    }

    public final List<Instruction> getOppo_10() {
        return oppo_10;
    }
}
