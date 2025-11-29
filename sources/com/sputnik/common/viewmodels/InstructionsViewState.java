package com.sputnik.common.viewmodels;

import android.os.Build;
import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.instructions.Instruction;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstructionsViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJR\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\u0012R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0014¨\u0006%"}, d2 = {"Lcom/sputnik/common/viewmodels/InstructionsViewState;", "Lcom/sputnik/common/base/VMState;", "", "Lcom/sputnik/common/entities/instructions/Instruction;", "instructions", "", "needNavigateToPrevious", "needNavigateToNext", "needToBeClosed", "", "manufacturer", "", "androidSDK", "<init>", "(Ljava/util/List;ZZZLjava/lang/String;I)V", "copy", "(Ljava/util/List;ZZZLjava/lang/String;I)Lcom/sputnik/common/viewmodels/InstructionsViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getInstructions", "()Ljava/util/List;", "Z", "getNeedNavigateToPrevious", "()Z", "getNeedNavigateToNext", "getNeedToBeClosed", "Ljava/lang/String;", "getManufacturer", "I", "getAndroidSDK", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InstructionsViewState implements VMState {
    private final int androidSDK;
    private final List<Instruction> instructions;
    private final String manufacturer;
    private final boolean needNavigateToNext;
    private final boolean needNavigateToPrevious;
    private final boolean needToBeClosed;

    public InstructionsViewState() {
        this(null, false, false, false, null, 0, 63, null);
    }

    public static /* synthetic */ InstructionsViewState copy$default(InstructionsViewState instructionsViewState, List list, boolean z, boolean z2, boolean z3, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = instructionsViewState.instructions;
        }
        if ((i2 & 2) != 0) {
            z = instructionsViewState.needNavigateToPrevious;
        }
        boolean z4 = z;
        if ((i2 & 4) != 0) {
            z2 = instructionsViewState.needNavigateToNext;
        }
        boolean z5 = z2;
        if ((i2 & 8) != 0) {
            z3 = instructionsViewState.needToBeClosed;
        }
        boolean z6 = z3;
        if ((i2 & 16) != 0) {
            str = instructionsViewState.manufacturer;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            i = instructionsViewState.androidSDK;
        }
        return instructionsViewState.copy(list, z4, z5, z6, str2, i);
    }

    public final InstructionsViewState copy(List<Instruction> instructions, boolean needNavigateToPrevious, boolean needNavigateToNext, boolean needToBeClosed, String manufacturer, int androidSDK) {
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        return new InstructionsViewState(instructions, needNavigateToPrevious, needNavigateToNext, needToBeClosed, manufacturer, androidSDK);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstructionsViewState)) {
            return false;
        }
        InstructionsViewState instructionsViewState = (InstructionsViewState) other;
        return Intrinsics.areEqual(this.instructions, instructionsViewState.instructions) && this.needNavigateToPrevious == instructionsViewState.needNavigateToPrevious && this.needNavigateToNext == instructionsViewState.needNavigateToNext && this.needToBeClosed == instructionsViewState.needToBeClosed && Intrinsics.areEqual(this.manufacturer, instructionsViewState.manufacturer) && this.androidSDK == instructionsViewState.androidSDK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.instructions.hashCode() * 31;
        boolean z = this.needNavigateToPrevious;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z2 = this.needNavigateToNext;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.needToBeClosed;
        return ((((i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.manufacturer.hashCode()) * 31) + Integer.hashCode(this.androidSDK);
    }

    public String toString() {
        return "InstructionsViewState(instructions=" + this.instructions + ", needNavigateToPrevious=" + this.needNavigateToPrevious + ", needNavigateToNext=" + this.needNavigateToNext + ", needToBeClosed=" + this.needToBeClosed + ", manufacturer=" + this.manufacturer + ", androidSDK=" + this.androidSDK + ")";
    }

    public InstructionsViewState(List<Instruction> instructions, boolean z, boolean z2, boolean z3, String manufacturer, int i) {
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        this.instructions = instructions;
        this.needNavigateToPrevious = z;
        this.needNavigateToNext = z2;
        this.needToBeClosed = z3;
        this.manufacturer = manufacturer;
        this.androidSDK = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InstructionsViewState(List list, boolean z, boolean z2, boolean z3, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        list = (i2 & 1) != 0 ? CollectionsKt.emptyList() : list;
        boolean z4 = (i2 & 2) != 0 ? false : z;
        boolean z5 = (i2 & 4) != 0 ? false : z2;
        boolean z6 = (i2 & 8) == 0 ? z3 : false;
        if ((i2 & 16) != 0) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            str = MANUFACTURER.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        this(list, z4, z5, z6, str, (i2 & 32) != 0 ? Build.VERSION.SDK_INT : i);
    }

    public final List<Instruction> getInstructions() {
        return this.instructions;
    }

    public final boolean getNeedNavigateToPrevious() {
        return this.needNavigateToPrevious;
    }

    public final boolean getNeedNavigateToNext() {
        return this.needNavigateToNext;
    }

    public final boolean getNeedToBeClosed() {
        return this.needToBeClosed;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final int getAndroidSDK() {
        return this.androidSDK;
    }
}
