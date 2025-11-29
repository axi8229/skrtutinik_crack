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
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"com/sputnik/common/entities/instructions/InstructionsByManufacturer$Google", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "Lcom/sputnik/common/entities/instructions/Instruction;", "google_12_XX", "Ljava/util/List;", "getGoogle_12_XX", "()Ljava/util/List;", "google_15_XX", "getGoogle_15_XX", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstructionsByManufacturer$Google {
    private static final List<Instruction> google_12_XX;
    private static final List<Instruction> google_15_XX;
    public static final InstructionsByManufacturer$Google INSTANCE = new InstructionsByManufacturer$Google();
    private static final String name = "google";

    private InstructionsByManufacturer$Google() {
    }

    static {
        String string = UUID.randomUUID().toString();
        List listListOf = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.google_12_back)), new BaseTextView("1. Откройте системные настройки приложения по кнопке ниже\n\n2. Откройте раздел \"Батарея/Расход заряда батареи\" и выберите пункт \"Без ограничений\"", 0, null, 0, 0, 30, null), new BaseButtonView("Открыть настройки", "system/settings/application", null, true, 4, null)});
        Intrinsics.checkNotNull(string);
        google_12_XX = CollectionsKt.listOf(new Instruction(string, listListOf, "(Шаг %1s)\nНастройка работы в фоне"));
        String string2 = UUID.randomUUID().toString();
        List listListOf2 = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.google_15_back)), new BaseTextView("1. Откройте системные настройки приложения по кнопке ниже\n\n2. Откройте раздел \"Батарея/Расход заряда батареи\" и разрешите использование в фоновом режиме", 0, null, 0, 0, 30, null), new BaseButtonView("Открыть настройки", "system/settings/application", null, true, 4, null)});
        Intrinsics.checkNotNull(string2);
        google_15_XX = CollectionsKt.listOf(new Instruction(string2, listListOf2, "(Шаг %1s)\nНастройка работы в фоне"));
    }

    public final String getName() {
        return name;
    }

    public final List<Instruction> getGoogle_12_XX() {
        return google_12_XX;
    }

    public final List<Instruction> getGoogle_15_XX() {
        return google_15_XX;
    }
}
