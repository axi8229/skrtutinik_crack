package com.sputnik.common.viewmodels;

import android.app.Application;
import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.instructions.Instruction;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Default;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$DefaultInstructionsViews;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Google;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Honor;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Huawei;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$OnePlus;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Oppo;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Realme;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Samsung;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Vivo;
import com.sputnik.common.entities.instructions.InstructionsByManufacturer$Xiaomi_Redmi_Poco;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: InstructionsViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\r\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0018J#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/common/viewmodels/InstructionsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/InstructionsViewState;", "", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "Lcom/sputnik/common/entities/instructions/Instruction;", "refreshInstructions", "()Ljava/util/List;", "", "id", "getInstructionById", "(Ljava/lang/String;)Lcom/sputnik/common/entities/instructions/Instruction;", "Landroid/content/Context;", "context", "", "isIgnoringBatteryOptimizations", "(Landroid/content/Context;)Z", "getInstructions", "", "navigateToNext", "()V", "navigateToPrevious", "closeInstructions", "clearNavigation", "manufacturer", "", "sdkInt", "changeManufacturerAndSDKInt", "(Ljava/lang/String;I)Ljava/util/List;", "Landroid/app/Application;", "_instructions", "Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstructionsViewModel extends BaseViewModel<InstructionsViewState> {
    private final List<Instruction> _instructions;
    private final Application application;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstructionsViewModel(Application application) {
        super(new InstructionsViewState(null, false, false, false, null, 0, 63, null), "javaClass");
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this._instructions = InstructionsByManufacturer$Samsung.INSTANCE.getSamsung12_and_above();
    }

    public Instruction getInstructionById(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = getCurrentState().getInstructions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Instruction) next).getId(), id)) {
                break;
            }
        }
        return (Instruction) next;
    }

    public final boolean isIgnoringBatteryOptimizations(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) ContextCompat.getSystemService(applicationContext, PowerManager.class);
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(applicationContext.getPackageName());
        }
        return false;
    }

    public List<Instruction> getInstructions() {
        ArrayList arrayList;
        if (isIgnoringBatteryOptimizations(this.application)) {
            List<Instruction> instructions = getCurrentState().getInstructions();
            arrayList = new ArrayList();
            for (Object obj : instructions) {
                if (!Intrinsics.areEqual(((Instruction) obj).getId(), InstructionsByManufacturer$DefaultInstructionsViews.Whitelist.INSTANCE.getId())) {
                    arrayList.add(obj);
                }
            }
        } else {
            List<Instruction> instructions2 = getCurrentState().getInstructions();
            arrayList = new ArrayList();
            for (Object obj2 : instructions2) {
                if (!Intrinsics.areEqual(((Instruction) obj2).getId(), InstructionsByManufacturer$DefaultInstructionsViews.Whitelist.INSTANCE.getId())) {
                    arrayList.add(obj2);
                }
            }
        }
        return arrayList;
    }

    private final List<Instruction> refreshInstructions() {
        List<Instruction> defaultInstructions;
        int androidSDK = getCurrentState().getAndroidSDK();
        String lowerCase = getCurrentState().getManufacturer().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        InstructionsByManufacturer$Samsung instructionsByManufacturer$Samsung = InstructionsByManufacturer$Samsung.INSTANCE;
        if (!Intrinsics.areEqual(lowerCase, instructionsByManufacturer$Samsung.getName())) {
            InstructionsByManufacturer$Xiaomi_Redmi_Poco instructionsByManufacturer$Xiaomi_Redmi_Poco = InstructionsByManufacturer$Xiaomi_Redmi_Poco.INSTANCE;
            if (!Intrinsics.areEqual(lowerCase, instructionsByManufacturer$Xiaomi_Redmi_Poco.getName())) {
                InstructionsByManufacturer$Realme instructionsByManufacturer$Realme = InstructionsByManufacturer$Realme.INSTANCE;
                if (!Intrinsics.areEqual(lowerCase, instructionsByManufacturer$Realme.getName())) {
                    InstructionsByManufacturer$Vivo instructionsByManufacturer$Vivo = InstructionsByManufacturer$Vivo.INSTANCE;
                    if (!Intrinsics.areEqual(lowerCase, instructionsByManufacturer$Vivo.getName())) {
                        InstructionsByManufacturer$Oppo instructionsByManufacturer$Oppo = InstructionsByManufacturer$Oppo.INSTANCE;
                        if (!Intrinsics.areEqual(lowerCase, instructionsByManufacturer$Oppo.getName())) {
                            InstructionsByManufacturer$OnePlus instructionsByManufacturer$OnePlus = InstructionsByManufacturer$OnePlus.INSTANCE;
                            if (Intrinsics.areEqual(lowerCase, instructionsByManufacturer$OnePlus.getName())) {
                                if (31 <= androidSDK && androidSDK < 41) {
                                    defaultInstructions = instructionsByManufacturer$OnePlus.getOneplus_12_13();
                                } else if (androidSDK == 30) {
                                    defaultInstructions = instructionsByManufacturer$OnePlus.getOneplus_11();
                                } else if (androidSDK == 29) {
                                    defaultInstructions = instructionsByManufacturer$OnePlus.getOneplus_10();
                                } else if (androidSDK == 28) {
                                    defaultInstructions = instructionsByManufacturer$OnePlus.getOneplus_9();
                                } else {
                                    defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
                                }
                            } else if (Intrinsics.areEqual(lowerCase, InstructionsByManufacturer$Huawei.INSTANCE.getName()) || Intrinsics.areEqual(lowerCase, InstructionsByManufacturer$Honor.INSTANCE.getName())) {
                                defaultInstructions = CollectionsKt.emptyList();
                            } else {
                                InstructionsByManufacturer$Google instructionsByManufacturer$Google = InstructionsByManufacturer$Google.INSTANCE;
                                if (!Intrinsics.areEqual(lowerCase, instructionsByManufacturer$Google.getName())) {
                                    defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
                                } else if (35 <= androidSDK && androidSDK < 41) {
                                    defaultInstructions = instructionsByManufacturer$Google.getGoogle_15_XX();
                                } else if (23 <= androidSDK && androidSDK < 35) {
                                    defaultInstructions = instructionsByManufacturer$Google.getGoogle_12_XX();
                                } else {
                                    defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
                                }
                            }
                        } else if (33 <= androidSDK && androidSDK < 41) {
                            defaultInstructions = instructionsByManufacturer$Oppo.getOppo_13();
                        } else if (31 <= androidSDK && androidSDK < 33) {
                            defaultInstructions = instructionsByManufacturer$Oppo.getOppo_12();
                        } else if (androidSDK == 30) {
                            defaultInstructions = instructionsByManufacturer$Oppo.getOppo_11();
                        } else if (androidSDK == 29) {
                            defaultInstructions = instructionsByManufacturer$Oppo.getOppo_10();
                        } else {
                            defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
                        }
                    } else if (31 <= androidSDK && androidSDK < 41) {
                        defaultInstructions = instructionsByManufacturer$Vivo.getVivo_12_13_XX();
                    } else if (androidSDK == 30) {
                        defaultInstructions = instructionsByManufacturer$Vivo.getVivo_11();
                    } else if (androidSDK == 29) {
                        defaultInstructions = instructionsByManufacturer$Vivo.getVivo_10();
                    } else {
                        defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
                    }
                } else if (30 <= androidSDK && androidSDK < 41) {
                    defaultInstructions = instructionsByManufacturer$Realme.getRealme_11_XX();
                } else {
                    defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
                }
            } else if (33 <= androidSDK && androidSDK < 41) {
                defaultInstructions = instructionsByManufacturer$Xiaomi_Redmi_Poco.getXiaomi_13();
            } else if (31 <= androidSDK && androidSDK < 33) {
                defaultInstructions = instructionsByManufacturer$Xiaomi_Redmi_Poco.getXiaomi_12();
            } else if (29 <= androidSDK && androidSDK < 31) {
                defaultInstructions = instructionsByManufacturer$Xiaomi_Redmi_Poco.getXiaomi_10_11();
            } else if (androidSDK == 28) {
                defaultInstructions = instructionsByManufacturer$Xiaomi_Redmi_Poco.getXiaomi_9();
            } else {
                defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
            }
        } else if (31 <= androidSDK && androidSDK < 41) {
            defaultInstructions = instructionsByManufacturer$Samsung.getSamsung12_and_above();
        } else if (29 <= androidSDK && androidSDK < 31) {
            defaultInstructions = instructionsByManufacturer$Samsung.getSamsung10_11();
        } else {
            defaultInstructions = InstructionsByManufacturer$Default.INSTANCE.getDefaultInstructions();
        }
        List<Instruction> mutableList = CollectionsKt.toMutableList((Collection) defaultInstructions);
        if (!mutableList.isEmpty()) {
            String id = InstructionsByManufacturer$DefaultInstructionsViews.INSTANCE.getBatterySaverInstruction().getId();
            InstructionsByManufacturer$DefaultInstructionsViews.BatterySaverMode batterySaverMode = InstructionsByManufacturer$DefaultInstructionsViews.BatterySaverMode.INSTANCE;
            mutableList.add(new Instruction(id, batterySaverMode.getViews(), batterySaverMode.getTitle()));
        }
        InstructionsViewState instructionsViewStateCopy$default = InstructionsViewState.copy$default(getCurrentState(), mutableList, false, false, false, null, 0, 62, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(instructionsViewStateCopy$default, this, null), 3, null);
        getState().setValue(instructionsViewStateCopy$default);
        return mutableList;
    }

    public final List<Instruction> changeManufacturerAndSDKInt(String manufacturer, int sdkInt) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        InstructionsViewState instructionsViewStateCopy$default = InstructionsViewState.copy$default(getCurrentState(), null, false, false, false, manufacturer, sdkInt, 15, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(instructionsViewStateCopy$default, this, null), 3, null);
        getState().setValue(instructionsViewStateCopy$default);
        return refreshInstructions();
    }

    public final void clearNavigation() {
        InstructionsViewState instructionsViewStateCopy$default = InstructionsViewState.copy$default(getCurrentState(), null, false, false, false, null, 0, 49, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(instructionsViewStateCopy$default, this, null), 3, null);
        getState().setValue(instructionsViewStateCopy$default);
    }

    public final void closeInstructions() {
        InstructionsViewState instructionsViewStateCopy$default = InstructionsViewState.copy$default(getCurrentState(), null, false, false, true, null, 0, 55, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(instructionsViewStateCopy$default, this, null), 3, null);
        getState().setValue(instructionsViewStateCopy$default);
    }

    public final void navigateToNext() {
        InstructionsViewState instructionsViewStateCopy$default = InstructionsViewState.copy$default(getCurrentState(), null, false, true, false, null, 0, 59, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(instructionsViewStateCopy$default, this, null), 3, null);
        getState().setValue(instructionsViewStateCopy$default);
    }

    public final void navigateToPrevious() {
        InstructionsViewState instructionsViewStateCopy$default = InstructionsViewState.copy$default(getCurrentState(), null, true, false, false, null, 0, 61, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(instructionsViewStateCopy$default, this, null), 3, null);
        getState().setValue(instructionsViewStateCopy$default);
    }
}
