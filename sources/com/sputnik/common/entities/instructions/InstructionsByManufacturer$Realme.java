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
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/sputnik/common/entities/instructions/InstructionsByManufacturer$Realme", "", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "Lcom/sputnik/common/entities/instructions/Instruction;", "realme_11_XX", "Ljava/util/List;", "getRealme_11_XX", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstructionsByManufacturer$Realme {
    public static final InstructionsByManufacturer$Realme INSTANCE = new InstructionsByManufacturer$Realme();
    private static final String name = "realme";
    private static final List<Instruction> realme_11_XX;

    private InstructionsByManufacturer$Realme() {
    }

    static {
        String string = UUID.randomUUID().toString();
        List listListOf = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.realme_11_keep)), new BaseTextView("\"Закрепите\" приложение в списке недавних приложений, для этого:", 0, null, 17, 0, 22, null), new BaseTextView("1. Перейдите в список недавних приложений при помощи системного жеста/нажатия кнопки\n2. Удерживайте пальцем на приложении \"Наш дом\" и затем нажмите \"Закрепить/Заблокировать\"", 0, "#404040", 8388611, 0, 18, null), new BaseButtonView("Далее", "next", null, true, 4, null)});
        Intrinsics.checkNotNull(string);
        realme_11_XX = CollectionsKt.listOf(new Instruction(string, listListOf, "(Шаг %1s)\nЗакрепление приложения"));
    }

    public final String getName() {
        return name;
    }

    public final List<Instruction> getRealme_11_XX() {
        return realme_11_XX;
    }
}
