package ru.roadar.facerecog;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import ru.roadar.facerecog.FaceProcessNative;

/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lru/roadar/facerecog/Constants;", "", "<init>", "()V", "", "Lru/roadar/facerecog/FaceProcessNative$ProcessState;", "", "statesBorders", "Ljava/util/Map;", "getStatesBorders", "()Ljava/util/Map;", "facesStates", "getFacesStates", "facerecog_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();
    private static final Map<FaceProcessNative.ProcessState, Integer> facesStates;
    private static final Map<FaceProcessNative.ProcessState, Integer> statesBorders;

    private Constants() {
    }

    public final Map<FaceProcessNative.ProcessState, Integer> getStatesBorders() {
        return statesBorders;
    }

    static {
        Pair pair = TuplesKt.to(FaceProcessNative.ProcessState.None, 0);
        FaceProcessNative.ProcessState processState = FaceProcessNative.ProcessState.Portrait;
        Pair pair2 = TuplesKt.to(processState, 33);
        FaceProcessNative.ProcessState processState2 = FaceProcessNative.ProcessState.Right;
        Pair pair3 = TuplesKt.to(processState2, 66);
        FaceProcessNative.ProcessState processState3 = FaceProcessNative.ProcessState.Left;
        statesBorders = MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to(processState3, 99), TuplesKt.to(FaceProcessNative.ProcessState.Done, 100), TuplesKt.to(FaceProcessNative.ProcessState.Error, 0));
        facesStates = MapsKt.mapOf(TuplesKt.to(processState, Integer.valueOf(R$drawable.ic_vector_face_portrait)), TuplesKt.to(processState3, Integer.valueOf(R$drawable.ic_vector_face_right)), TuplesKt.to(processState2, Integer.valueOf(R$drawable.ic_vector_face_left)));
    }

    public final Map<FaceProcessNative.ProcessState, Integer> getFacesStates() {
        return facesStates;
    }
}
