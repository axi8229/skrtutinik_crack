package com.sputnik.common.entities.instructions;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: InstructionsByManufacturer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/sputnik/common/entities/instructions/InstructionsByManufacturer$Default", "", "<init>", "()V", "", "Lcom/sputnik/common/entities/instructions/Instruction;", "defaultInstructions", "Ljava/util/List;", "getDefaultInstructions", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstructionsByManufacturer$Default {
    public static final InstructionsByManufacturer$Default INSTANCE = new InstructionsByManufacturer$Default();
    private static final List<Instruction> defaultInstructions = CollectionsKt.emptyList();

    private InstructionsByManufacturer$Default() {
    }

    public final List<Instruction> getDefaultInstructions() {
        return defaultInstructions;
    }
}
