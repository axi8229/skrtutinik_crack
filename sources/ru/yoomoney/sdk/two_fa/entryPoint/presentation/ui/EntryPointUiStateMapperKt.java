package ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.entryPoint.EntryPoint;
import ru.yoomoney.sdk.two_fa.entryPoint.presentation.ui.EntryPointUiState;
import ru.yoomoney.sdk.two_fa.utils.ResourceMapper;

/* compiled from: EntryPointUiStateMapper.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¨\u0006\n"}, d2 = {"mapToUiState", "Lru/yoomoney/sdk/two_fa/entryPoint/presentation/ui/EntryPointUiState;", "Lru/yoomoney/sdk/two_fa/entryPoint/EntryPoint$State;", "resourceMapper", "Lru/yoomoney/sdk/two_fa/utils/ResourceMapper;", "context", "Landroid/content/Context;", "onReload", "Lkotlin/Function0;", "", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EntryPointUiStateMapperKt {
    public static final EntryPointUiState mapToUiState(EntryPoint.State state, ResourceMapper resourceMapper, Context context, Function0<Unit> onReload) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        if (state instanceof EntryPoint.State.Init) {
            return EntryPointUiState.Init.INSTANCE;
        }
        if (!(state instanceof EntryPoint.State.InitialError)) {
            throw new NoWhenBranchMatchedException();
        }
        String strMap$default = ResourceMapper.map$default(resourceMapper, ((EntryPoint.State.InitialError) state).getFailure(), null, 2, null);
        String string = context.getString(R.string.two_fa_technical_error_action);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new EntryPointUiState.InitialError(null, strMap$default, string, onReload);
    }
}
