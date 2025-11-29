package com.sputnik.common.entities.instructions;

import com.sputnik.common.R$drawable;
import com.sputnik.common.entities.views.BaseButtonView;
import com.sputnik.common.entities.views.BaseImageView;
import com.sputnik.common.entities.views.BaseTextView;
import com.sputnik.common.entities.views.BaseView;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: InstructionsByManufacturer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"com/sputnik/common/entities/instructions/InstructionsByManufacturer$DefaultInstructionsViews", "", "<init>", "()V", "Lcom/sputnik/common/entities/instructions/Instruction;", "batterySaverInstruction", "Lcom/sputnik/common/entities/instructions/Instruction;", "getBatterySaverInstruction", "()Lcom/sputnik/common/entities/instructions/Instruction;", "BatterySaverMode", "Whitelist", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstructionsByManufacturer$DefaultInstructionsViews {
    public static final InstructionsByManufacturer$DefaultInstructionsViews INSTANCE = new InstructionsByManufacturer$DefaultInstructionsViews();
    private static final Instruction batterySaverInstruction = new Instruction("instruction_battery_saver", CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.instructions_battery_saver)), new BaseTextView("Режим энергосбрежения может негативно влиять на работу приложения в фоне, поэтому если у Вас нет необходимости в использовании энергосбережения - отключите его 🙏", 0, null, 17, 0, 22, null), new BaseButtonView("Настройки энергосбережения", "system/settings/battery_saver", null, true, 4, null)}), "(Шаг %1s)\nРежим энергосбережения");

    /* compiled from: InstructionsByManufacturer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/sputnik/common/entities/instructions/InstructionsByManufacturer$DefaultInstructionsViews$Whitelist;", "", "<init>", "()V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "", "Lcom/sputnik/common/entities/views/BaseView;", "views", "Ljava/util/List;", "getViews", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Whitelist {
        public static final Whitelist INSTANCE = new Whitelist();
        private static final String id = "whitelist_instruction";
        private static final String title = "(Шаг %1s)\nБелый список приложений";
        private static final List<BaseView> views = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseTextView("Для более надёжной работы в фоне вам нужно добавить приложение в \"Белый список\" и исключить приложение из списка для оптимизации", 0, null, 17, 0, 22, null), new BaseButtonView("К настройкам", "system/settings/whitelist", null, true, 4, null)});

        private Whitelist() {
        }

        public final String getId() {
            return id;
        }
    }

    private InstructionsByManufacturer$DefaultInstructionsViews() {
    }

    public final Instruction getBatterySaverInstruction() {
        return batterySaverInstruction;
    }

    /* compiled from: InstructionsByManufacturer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/sputnik/common/entities/instructions/InstructionsByManufacturer$DefaultInstructionsViews$BatterySaverMode;", "", "()V", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "getTitle", "()Ljava/lang/String;", "views", "", "Lcom/sputnik/common/entities/views/BaseView;", "getViews", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BatterySaverMode {
        public static final BatterySaverMode INSTANCE = new BatterySaverMode();
        private static final String title = "(Шаг %1s)\nРежим энергосбережения";
        private static final List<BaseView> views = CollectionsKt.listOf((Object[]) new BaseView[]{new BaseImageView(Integer.valueOf(R$drawable.instructions_battery_saver)), new BaseTextView("Режим энергосбрежения может негативно влиять на работу приложения в фоне, поэтому если у Вас нет необходимости в использовании энергосбережения - отключите его 🙏", 0, null, 17, 0, 22, null), new BaseButtonView("Настройки энергосбережения", "system/settings/battery_saver", null, true, 4, null)});

        private BatterySaverMode() {
        }

        public final String getTitle() {
            return title;
        }

        public final List<BaseView> getViews() {
            return views;
        }
    }
}
