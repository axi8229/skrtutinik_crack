package com.huawei.location.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.activity.model.FB;
import com.huawei.location.activity.model.LW;
import com.huawei.location.activity.util.JniUtils;
import com.huawei.location.base.activity.AbstractARServiceManager;
import com.huawei.location.base.activity.ActivityRecognitionConstantsMapping;
import com.huawei.location.base.activity.ActivityRecognitionMappingManager;
import com.huawei.location.base.activity.ActivityTransitionMappingManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.entity.MovementEvent;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ObjectCheckUtils;
import com.yandex.varioqub.config.model.ConfigValue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class RiemannSoftArService extends AbstractARServiceManager implements SensorEventListener, com.huawei.location.activity.callback.yn {
    private static final int ACQUISITION_FREQUENCY = 10000;
    public static final long ACTIVITY_TRANSITION_UPDATETIMNE = 1000;
    private static final int BASE_CONFIDENCE = 50;
    private static final int FULL_CONFIDENCE = 100;
    private static final long INIT_VALUE = -1;
    private static final int JUDGE_INVALID_TIME = 100000000;
    private static final int MAX_INVALID_TIME = 10000;
    private static final int ONE = 1;
    private static final int SAMPLE_LIST_SIZE = 100;
    private static final int SAMPLE_SIZE = 4;
    private static final int SENSOR_LIST_ALL = 656;
    private static final int SENSOR_LIST_SIZE = 256;
    private static final String TAG = "RiemannSoftArService";
    private static final int ZERO = 0;
    private static volatile RiemannSoftArService instance;
    private Sensor acc;
    private List<LW> accRecordList;
    private boolean alreadyRegister;
    private boolean alreadyRequestAR;
    private com.huawei.location.activity.model.yn atProvider;
    private Context context;
    private long delay;
    private boolean needToWait;
    private Sensor ori;
    private List<LW> oriRecordList;
    private SensorManager sensorManager;
    private long updatTime;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final byte[] SYNC_LIST_LOCK = new byte[0];

    private class Vw implements Runnable {
        private Vw() {
        }

        /* synthetic */ Vw(RiemannSoftArService riemannSoftArService, yn ynVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.currentThread().setName("Location-ACTIVITY-RiemannSoftArService");
                LogLocation.i(RiemannSoftArService.TAG, "start to get result when data is enough!");
                ((AbstractARServiceManager) RiemannSoftArService.this).recognitionMappingManager.send(RiemannSoftArService.this.getDetectedActivities());
                LogLocation.i(RiemannSoftArService.TAG, "RiemannSoftArService Task run end");
            } catch (LocationServiceException e) {
                throw e;
            } catch (Exception unused) {
                LogLocation.e(RiemannSoftArService.TAG, "RiemannSoftArService Task run exception", true);
            }
        }
    }

    class yn implements Comparator<DetectedActivity> {
        yn(RiemannSoftArService riemannSoftArService) {
        }

        @Override // java.util.Comparator
        public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            return detectedActivity2.getConfidence() - detectedActivity.getConfidence();
        }
    }

    private RiemannSoftArService() {
        super(new ActivityTransitionMappingManager(), new ActivityRecognitionMappingManager());
        this.accRecordList = new CopyOnWriteArrayList();
        this.oriRecordList = new CopyOnWriteArrayList();
        this.context = ContextUtil.getHMSContext();
        this.needToWait = false;
        this.updatTime = System.currentTimeMillis();
        this.alreadyRegister = false;
        this.alreadyRequestAR = false;
        Object systemService = this.context.getSystemService("sensor");
        if (!(systemService instanceof SensorManager)) {
            LogLocation.d(TAG, "no sensorManager service");
            return;
        }
        SensorManager sensorManager = (SensorManager) systemService;
        this.sensorManager = sensorManager;
        this.acc = sensorManager.getDefaultSensor(1);
        this.ori = this.sensorManager.getDefaultSensor(3);
        this.atProvider = new com.huawei.location.activity.model.yn();
    }

    private boolean checkDateVilid(List<LW> list, List<LW> list2) {
        String str;
        if (Math.abs(list.get(0).yn() - list2.get(0).yn()) > 100000000) {
            str = "difference time  is : " + (list.get(0).yn() - list2.get(0).yn());
        } else {
            int size = list.size() - 1;
            if (Math.abs(list.get(size).yn() - list2.get(size).yn()) <= 100000000) {
                return true;
            }
            str = "difference time  is : " + (list.get(size).yn() - list2.get(size).yn());
        }
        LogLocation.i(TAG, str);
        return false;
    }

    private void checkIfValid() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (SYNC_LIST_LOCK) {
            try {
                if (jCurrentTimeMillis - this.updatTime > DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                    LogLocation.i(TAG, "sensor data is not valid !");
                    this.oriRecordList.clear();
                    this.accRecordList.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private List<DetectedActivity> dealWithDatas() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 100;
        int i12 = 3;
        int i13 = 1;
        List<DetectedActivity> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList(this.accRecordList);
        CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList(this.oriRecordList);
        int i14 = 256;
        int i15 = 256;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i16 <= 4 && copyOnWriteArrayList4.size() >= i15 && copyOnWriteArrayList5.size() >= i15) {
            if (checkDateVilid(copyOnWriteArrayList4.subList(i17, i15), copyOnWriteArrayList5.subList(i17, i15))) {
                int i20 = i19 + i13;
                List listSubList = copyOnWriteArrayList4.subList(i17, i15);
                List listSubList2 = copyOnWriteArrayList5.subList(i17, i15);
                LogLocation.i("ResultPredict", "predict...");
                ArrayList arrayList = new ArrayList(i14);
                ArrayList arrayList2 = new ArrayList(i14);
                int i21 = 0;
                while (i21 < i14) {
                    float fVw = ((LW) listSubList.get(i21)).Vw();
                    float fFB = ((LW) listSubList.get(i21)).FB();
                    float fLW = ((LW) listSubList.get(i21)).LW();
                    float[] fArr = new float[i12];
                    fArr[0] = fVw;
                    fArr[1] = fFB;
                    fArr[2] = fLW;
                    float fVw2 = ((LW) listSubList2.get(i21)).Vw();
                    float fFB2 = ((LW) listSubList2.get(i21)).FB();
                    float fLW2 = ((LW) listSubList2.get(i21)).LW();
                    List list = listSubList;
                    float[] fArr2 = new float[i12];
                    fArr2[0] = fVw2;
                    fArr2[1] = fFB2;
                    fArr2[2] = fLW2;
                    arrayList.add(fArr);
                    arrayList2.add(fArr2);
                    i21++;
                    listSubList = list;
                    i12 = 3;
                    i14 = 256;
                }
                int i22 = i14;
                ArrayList<float[]> arrayListYn = com.huawei.location.activity.model.Vw.yn((ArrayList<float[]>) arrayList, i22);
                ArrayList<float[]> arrayListYn2 = com.huawei.location.activity.model.Vw.yn((ArrayList<float[]>) arrayList2, i22);
                int[] iArr = {arrayListYn.size(), arrayListYn.get(0).length};
                Class cls = Float.TYPE;
                float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) cls, iArr);
                copyOnWriteArrayList = copyOnWriteArrayList4;
                char c2 = 0;
                float[][] fArr4 = (float[][]) Array.newInstance((Class<?>) cls, arrayListYn2.size(), arrayListYn2.get(0).length);
                int i23 = 0;
                while (i23 < arrayListYn.size()) {
                    System.arraycopy(arrayListYn.get(i23), 0, fArr3[i23], 0, arrayListYn.get(i23).length);
                    i23++;
                    copyOnWriteArrayList5 = copyOnWriteArrayList5;
                }
                copyOnWriteArrayList2 = copyOnWriteArrayList5;
                int i24 = 1;
                for (int i25 = 0; i25 < arrayListYn2.size(); i25++) {
                    System.arraycopy(arrayListYn2.get(i25), 0, fArr4[i25], 0, arrayListYn2.get(i25).length);
                    i24 = 1;
                }
                if (fArr3.length < i24) {
                    i = i16;
                    i2 = i15;
                    i3 = i17;
                    i4 = i18;
                    i5 = i20;
                } else {
                    int length = fArr3.length;
                    int[] iArr2 = new int[2];
                    iArr2[i24] = fArr3[0].length;
                    iArr2[0] = length;
                    float[][] fArr5 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, iArr2);
                    int i26 = 0;
                    while (i26 < fArr3.length) {
                        float[] fArr6 = fArr4[i26];
                        float f = fArr6[c2];
                        float f2 = fArr6[i24];
                        float f3 = fArr6[2];
                        float[][] fArr7 = fArr4;
                        float[] fArr8 = new float[3];
                        fArr8[c2] = f;
                        fArr8[1] = f2;
                        fArr8[2] = f3;
                        float[] fArr9 = fArr3[i26];
                        float[][] fArr10 = fArr3;
                        float[] fArr11 = new float[1];
                        fArr11[c2] = fArr9[c2];
                        int i27 = i20;
                        float[] fArr12 = new float[1];
                        fArr12[c2] = fArr9[1];
                        float[] fArr13 = new float[1];
                        fArr13[c2] = fArr9[2];
                        float[][] fArr14 = {fArr11, fArr12, fArr13};
                        float f4 = fArr8[c2];
                        float f5 = fArr8[1];
                        float f6 = fArr8[2] * 0.017453292f;
                        double d = f4 * 0.017453292f;
                        int i28 = i16;
                        float fCos = (float) Math.cos(d);
                        float fSin = (float) Math.sin(d);
                        double d2 = f6;
                        int i29 = i15;
                        int i30 = i17;
                        float fCos2 = (float) Math.cos(d2);
                        float fSin2 = (float) Math.sin(d2);
                        double d3 = f5 * 0.017453292f;
                        float fCos3 = (float) Math.cos(d3);
                        float fSin3 = (float) Math.sin(d3);
                        int i31 = i18;
                        float[][] fArr15 = {new float[]{fCos, fSin * (-1.0f), 0.0f}, new float[]{fSin, fCos, 0.0f}, new float[]{0.0f, 0.0f, 1.0f}};
                        float[][] fArr16 = {new float[]{fCos2, 0.0f, fSin2}, new float[]{0.0f, 1.0f, 0.0f}, new float[]{fSin2 * (-1.0f), 0.0f, fCos2}};
                        float[][] fArr17 = {new float[]{1.0f, 0.0f, 0.0f}, new float[]{0.0f, fCos3, fSin3 * (-1.0f)}, new float[]{0.0f, fSin3, fCos3}};
                        ArrayList arrayList3 = new ArrayList(3);
                        for (int i32 = 0; i32 < 3; i32++) {
                            arrayList3.add(fArr17[i32]);
                        }
                        ArrayList arrayList4 = new ArrayList(3);
                        for (int i33 = 0; i33 < 3; i33++) {
                            arrayList4.add(fArr16[i33]);
                        }
                        ArrayList arrayList5 = new ArrayList(3);
                        for (int i34 = 0; i34 < 3; i34++) {
                            arrayList5.add(fArr15[i34]);
                        }
                        ArrayList<float[]> arrayListYn3 = com.huawei.location.activity.model.Vw.yn((ArrayList<float[]>) arrayList3, (ArrayList<float[]>) arrayList4, arrayList3.size());
                        ArrayList<float[]> arrayListYn4 = com.huawei.location.activity.model.Vw.yn(arrayListYn3, (ArrayList<float[]>) arrayList5, arrayListYn3.size());
                        new ArrayList(3);
                        float[][] fArr18 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListYn4.size(), arrayListYn4.get(0).length);
                        for (int i35 = 0; i35 < arrayListYn4.size(); i35++) {
                            System.arraycopy(arrayListYn4.get(i35), 0, fArr18[i35], 0, arrayListYn4.get(i35).length);
                        }
                        int length2 = fArr18.length;
                        int length3 = fArr18[0].length;
                        float[][] fArr19 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, length3, length2);
                        for (int i36 = 0; i36 < length2; i36++) {
                            for (int i37 = 0; i37 < length3; i37++) {
                                fArr19[i37][i36] = fArr18[i36][i37];
                            }
                        }
                        ArrayList arrayList6 = new ArrayList(length2);
                        for (float[] fArr20 : fArr19) {
                            arrayList6.add(fArr20);
                        }
                        ArrayList arrayList7 = new ArrayList(3);
                        int i38 = 0;
                        for (int i39 = 3; i38 < i39; i39 = 3) {
                            arrayList7.add(fArr14[i38]);
                            i38++;
                        }
                        float[][] fArr21 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList6.size(), ((float[]) arrayList6.get(0)).length);
                        for (int i40 = 0; i40 < arrayList6.size(); i40++) {
                            System.arraycopy(arrayList6.get(i40), 0, fArr21[i40], 0, ((float[]) arrayList6.get(i40)).length);
                        }
                        float[][] fArr22 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayList7.size(), ((float[]) arrayList7.get(0)).length);
                        for (int i41 = 0; i41 < arrayList7.size(); i41++) {
                            System.arraycopy(arrayList7.get(i41), 0, fArr22[i41], 0, ((float[]) arrayList7.get(i41)).length);
                        }
                        int i42 = 0;
                        float[][] fArr23 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, fArr21.length, fArr22[0].length);
                        int i43 = 0;
                        while (i43 < fArr21.length) {
                            int i44 = i42;
                            while (i44 < fArr22[i42].length) {
                                float f7 = 0.0f;
                                for (int i45 = 0; i45 < fArr22.length; i45++) {
                                    f7 += fArr21[i43][i45] * fArr22[i45][i44];
                                }
                                fArr23[i43][i44] = f7;
                                i44++;
                                i42 = 0;
                            }
                            i43++;
                            i42 = 0;
                        }
                        float[] fArr24 = fArr5[i26];
                        fArr24[0] = fArr23[0][0];
                        fArr24[1] = fArr23[1][0];
                        fArr24[2] = fArr23[2][0];
                        i26++;
                        i24 = 1;
                        fArr3 = fArr10;
                        fArr4 = fArr7;
                        i20 = i27;
                        i15 = i29;
                        i17 = i30;
                        i16 = i28;
                        i18 = i31;
                        c2 = 0;
                    }
                    i = i16;
                    i2 = i15;
                    i3 = i17;
                    i4 = i18;
                    i5 = i20;
                    int i46 = i24;
                    ArrayList<float[]> arrayList8 = new ArrayList<>(arrayListYn.size());
                    for (int i47 = 0; i47 < fArr5.length; i47 += i46) {
                        arrayList8.add(fArr5[i47]);
                    }
                    arrayListYn = arrayList8;
                }
                for (int i48 = 0; i48 < 256; i48++) {
                    arrayListYn.get(i48)[2] = (float) (arrayListYn.get(i48)[2] - 9.81d);
                }
                float[][] fArr25 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, arrayListYn.size(), arrayListYn.get(0).length);
                for (int i49 = 0; i49 < arrayListYn.size(); i49++) {
                    System.arraycopy(arrayListYn.get(i49), 0, fArr25[i49], 0, arrayListYn.get(i49).length);
                }
                if (fArr25.length == 0) {
                    c = 1;
                } else {
                    float[][] fArr26 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, fArr25.length, fArr25[0].length);
                    int i50 = 0;
                    for (int i51 = 0; i50 < fArr25[i51].length; i51 = 0) {
                        int size = arrayListYn.size();
                        int[] iArr3 = new int[2];
                        iArr3[1] = arrayListYn.get(i51).length;
                        iArr3[i51] = size;
                        float[][] fArr27 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, iArr3);
                        for (int i52 = 0; i52 < arrayListYn.size(); i52++) {
                            System.arraycopy(arrayListYn.get(i52), 0, fArr27[i52], 0, arrayListYn.get(i52).length);
                        }
                        ArrayList arrayList9 = new ArrayList();
                        for (float[] fArr28 : fArr27) {
                            if (i50 >= 0) {
                                if (i50 < fArr28.length) {
                                    arrayList9.add(Float.valueOf(fArr28[i50]));
                                }
                            }
                        }
                        int i53 = (int) 40.5d;
                        ArrayList arrayList10 = new ArrayList();
                        for (int i54 = -i53; i54 < i53 + 1; i54++) {
                            arrayList10.add(Float.valueOf((float) Math.exp((-0.005d) * i54 * i54)));
                        }
                        int size2 = (arrayList10.size() - 1) / 2;
                        int size3 = arrayList9.size();
                        int i55 = (size2 * 2) + size3;
                        ArrayList arrayList11 = new ArrayList(i55);
                        int i56 = 0;
                        while (i56 < i55) {
                            if (i56 < size2) {
                                i7 = size2 - i56;
                            } else {
                                int i57 = size3 + size2;
                                if (i56 < i57) {
                                    i7 = i56 - size2;
                                } else {
                                    i6 = 1;
                                    if (i56 >= i57) {
                                        arrayList11.add(arrayList9.get((((i57 - 1) * 2) - i56) - size2));
                                    }
                                    i56 += i6;
                                }
                            }
                            arrayList11.add(arrayList9.get(i7));
                            i6 = 1;
                            i56 += i6;
                        }
                        int i58 = 1;
                        ArrayList arrayList12 = new ArrayList();
                        int i59 = 0;
                        while (i59 < size3) {
                            int i60 = i59 + size2;
                            ArrayList arrayList13 = new ArrayList(arrayList11.subList(i60 - size2, i60 + size2 + i58));
                            double dFloatValue = ConfigValue.DOUBLE_DEFAULT_VALUE;
                            double dFloatValue2 = 0.0d;
                            int i61 = 0;
                            while (i61 < arrayList10.size()) {
                                dFloatValue += ((Float) arrayList13.get(i61)).floatValue() * ((Float) arrayList10.get(i61)).floatValue();
                                dFloatValue2 += ((Float) arrayList10.get(i61)).floatValue();
                                i61++;
                                size3 = size3;
                                arrayList11 = arrayList11;
                            }
                            arrayList12.add(Float.valueOf((float) (dFloatValue / dFloatValue2)));
                            i59++;
                            arrayList11 = arrayList11;
                            i58 = 1;
                            size3 = size3;
                        }
                        int i62 = i58;
                        for (int i63 = 0; i63 < fArr25.length; i63 += i62) {
                            fArr26[i63][i50] = ((Float) arrayList12.get(i63)).floatValue();
                        }
                        i50 += i62;
                    }
                    c = 1;
                    ArrayList<float[]> arrayList14 = new ArrayList<>(arrayListYn.size());
                    for (float[] fArr29 : fArr26) {
                        arrayList14.add(fArr29);
                    }
                    arrayListYn = arrayList14;
                }
                int i64 = 0;
                while (i64 < 3) {
                    int size4 = arrayListYn.size();
                    int[] iArr4 = new int[2];
                    iArr4[c] = arrayListYn.get(0).length;
                    iArr4[0] = size4;
                    float[][] fArr30 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, iArr4);
                    for (int i65 = 0; i65 < arrayListYn.size(); i65++) {
                        System.arraycopy(arrayListYn.get(i65), 0, fArr30[i65], 0, arrayListYn.get(i65).length);
                    }
                    int length4 = fArr30.length;
                    float[] fArr31 = new float[length4];
                    for (int i66 = 0; i66 < fArr30.length; i66++) {
                        if (i64 >= 0) {
                            float[] fArr32 = fArr30[i66];
                            if (i64 < fArr32.length) {
                                fArr31[i66] = fArr32[i64];
                            }
                        }
                    }
                    float f8 = 0.0f;
                    for (int i67 = 0; i67 < length4; i67++) {
                        f8 += fArr31[i67];
                    }
                    float f9 = f8 / length4;
                    for (int i68 = 0; i68 < 256; i68++) {
                        arrayListYn.get(i68)[i64] = arrayListYn.get(i68)[i64] - f9;
                    }
                    i64++;
                    c = 1;
                }
                i8 = 256;
                float[] fArr33 = new float[768];
                int size5 = arrayListYn.size();
                int[] iArr5 = new int[2];
                iArr5[c] = arrayListYn.get(0).length;
                iArr5[0] = size5;
                float[][] fArr34 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, iArr5);
                for (int i69 = 0; i69 < arrayListYn.size(); i69++) {
                    System.arraycopy(arrayListYn.get(i69), 0, fArr34[i69], 0, arrayListYn.get(i69).length);
                }
                int i70 = 0;
                int length5 = fArr34.length;
                int i71 = 0;
                int i72 = 0;
                while (i71 < length5) {
                    float[] fArr35 = fArr34[i71];
                    int i73 = i70;
                    int i74 = i72;
                    while (i73 < fArr34[i70].length) {
                        fArr33[i74] = fArr35[i73];
                        i73++;
                        i74++;
                        i70 = 0;
                    }
                    i71++;
                    i72 = i74;
                    i70 = 0;
                }
                float[][] fArr36 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 1, 5);
                if (JniUtils.analysisData(fArr33, fArr36) != 0) {
                    LogLocation.e("ResultPredict", "analysis result fail");
                    throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
                }
                float[] fArr37 = fArr36[0];
                FB.yn = new CopyOnWriteArrayList();
                for (int i75 = 0; i75 < fArr37.length; i75++) {
                    DetectedActivity detectedActivity = new DetectedActivity();
                    if (i75 == 0) {
                        detectedActivity.setConfidence((int) (fArr37[i75] * 100.0f));
                        detectedActivity.setType(3);
                    }
                    if (i75 == 1) {
                        detectedActivity.setConfidence((int) (fArr37[i75] * 100.0f));
                        detectedActivity.setType(7);
                    }
                    if (i75 == 2) {
                        detectedActivity.setConfidence((int) (fArr37[i75] * 100.0f));
                        detectedActivity.setType(8);
                    }
                    if (i75 == 3) {
                        detectedActivity.setConfidence((int) (fArr37[i75] * 100.0f));
                        detectedActivity.setType(1);
                    }
                    if (i75 == 4) {
                        detectedActivity.setConfidence((int) (fArr37[i75] * 100.0f));
                        detectedActivity.setType(0);
                    }
                    FB.yn.add(detectedActivity);
                }
                i9 = 3;
                FB.yn.add(new DetectedActivity(2, (int) ((fArr37[1] + fArr37[2]) * 100.0f)));
                i17 = i3 + 100;
                i15 = i2 + 100;
                copyOnWriteArrayList3 = mergeList(copyOnWriteArrayList3, FB.yn);
                i19 = i5;
                i18 = i4;
                i10 = 1;
            } else {
                LogLocation.i(TAG, "data not valid ! drop it ");
                i17 += i11;
                i15 += i11;
                i10 = i13;
                i18 = i10;
                copyOnWriteArrayList = copyOnWriteArrayList4;
                copyOnWriteArrayList2 = copyOnWriteArrayList5;
                i8 = i14;
                i = i16;
                i9 = i12;
            }
            i16 = i + 1;
            i14 = i8;
            i12 = i9;
            copyOnWriteArrayList4 = copyOnWriteArrayList;
            copyOnWriteArrayList5 = copyOnWriteArrayList2;
            i13 = i10;
            i11 = 100;
        }
        int i76 = i18;
        synchronized (SYNC_LIST_LOCK) {
            if (i76 != 0) {
                try {
                    this.oriRecordList.clear();
                    this.accRecordList.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        for (int i77 = 0; i77 < copyOnWriteArrayList3.size(); i77++) {
            copyOnWriteArrayList3.get(i77).setConfidence(copyOnWriteArrayList3.get(i77).getConfidence() / i19);
        }
        Iterator<DetectedActivity> it = copyOnWriteArrayList3.iterator();
        while (it.hasNext()) {
            if (it.next().getConfidence() >= 50) {
                return copyOnWriteArrayList3;
            }
        }
        copyOnWriteArrayList3.add(new DetectedActivity(4, 100));
        return copyOnWriteArrayList3;
    }

    private LW event2Acc(SensorEvent sensorEvent) {
        LW lw = new LW(0.0f, 0.0f, 0.0f);
        lw.yn(sensorEvent.timestamp);
        lw.yn(sensorEvent.values[0]);
        lw.Vw(sensorEvent.values[1]);
        lw.FB(sensorEvent.values[2]);
        return lw;
    }

    private static void freeAssets() {
        JniUtils.freeBuffer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DetectedActivity> getDetectedActivities() {
        checkIfValid();
        try {
            if (this.accRecordList.size() < 256 || this.oriRecordList.size() < 256) {
                LogLocation.i(TAG, "need to wait for data !");
                this.needToWait = true;
                byte[] bArr = SYNC_LOCK;
                synchronized (bArr) {
                    bArr.wait();
                }
                LogLocation.i(TAG, "wait end!");
                this.needToWait = false;
            }
        } catch (InterruptedException unused) {
            LogLocation.d(TAG, "InterruptedException ");
        }
        ArrayList arrayList = new ArrayList(dealWithDatas());
        Collections.sort(arrayList, new yn(this));
        return arrayList;
    }

    public static RiemannSoftArService getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new RiemannSoftArService();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private List<DetectedActivity> mergeList(List<DetectedActivity> list, List<DetectedActivity> list2) {
        if (list2 == null || list2.size() == 0) {
            LogLocation.e(TAG, "ResultPredict.predict result is null !");
            return list;
        }
        if (list == null || list.size() == 0) {
            return list2;
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setConfidence(list.get(i).getConfidence() + list2.get(i).getConfidence());
        }
        return list;
    }

    private void register() {
        if (this.alreadyRegister) {
            LogLocation.i(TAG, " already registered");
        } else {
            new com.huawei.location.activity.yn().yn(this);
        }
    }

    private void unregister() {
        try {
            if (this.alreadyRegister) {
                freeAssets();
                SensorManager sensorManager = this.sensorManager;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.acc);
                    this.sensorManager.unregisterListener(this, this.ori);
                    this.alreadyRegister = false;
                    LogLocation.i(TAG, "unregister acc & ori success");
                }
            }
        } catch (LocationServiceException e) {
            throw e;
        } catch (Exception unused) {
            LogLocation.e(TAG, "unregister sensor listener failed");
        }
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public boolean connectService() {
        return false;
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public boolean disConnectService() {
        return false;
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public ActivityRecognitionResult getDetectedActivity(int i, int i2) {
        LogLocation.i(TAG, "getDetectedActivity");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public Vw getTask() {
        return new Vw(this, null);
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public boolean isConnected() {
        return false;
    }

    public void modelFileLoadFail(int i) {
    }

    @Override // com.huawei.location.activity.callback.yn
    public void modelFileLoadSuccess() {
        try {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager == null) {
                LogLocation.i(TAG, "sensorManager is null");
                throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
            }
            boolean zRegisterListener = sensorManager.registerListener(this, this.acc, 10000);
            boolean zRegisterListener2 = this.sensorManager.registerListener(this, this.ori, 10000);
            LogLocation.i(TAG, "register accResult: " + zRegisterListener + " register oriResult: " + zRegisterListener2);
            if (!zRegisterListener || !zRegisterListener2) {
                throw new LocationServiceException(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
            }
            this.alreadyRegister = true;
            if (this.scheduledExecutorService == null) {
                this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
            }
            this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(getTask(), 0L, this.delay, TimeUnit.MILLISECONDS);
            LogLocation.i(TAG, "startScheduled exit");
        } catch (LocationServiceException e) {
            throw e;
        } catch (Exception unused) {
            LogLocation.e(TAG, "register sensor listener failed");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 || sensorEvent.sensor.getType() == 3) {
            checkIfValid();
            this.updatTime = System.currentTimeMillis();
            if (sensorEvent.sensor.getType() == 1) {
                this.accRecordList.add(event2Acc(sensorEvent));
                synchronized (SYNC_LIST_LOCK) {
                    try {
                        if (this.accRecordList.size() > SENSOR_LIST_ALL) {
                            this.accRecordList.remove(0);
                        }
                    } finally {
                    }
                }
            } else {
                this.oriRecordList.add(event2Acc(sensorEvent));
                synchronized (SYNC_LIST_LOCK) {
                    try {
                        if (this.oriRecordList.size() > SENSOR_LIST_ALL) {
                            this.oriRecordList.remove(0);
                        }
                    } finally {
                    }
                }
            }
            if (!this.needToWait || this.oriRecordList.size() < 256 || this.accRecordList.size() < 256) {
                return;
            }
            byte[] bArr = SYNC_LOCK;
            synchronized (bArr) {
                bArr.notifyAll();
            }
        }
    }

    public void onStatusChanged(int i, int i2) {
        MovementEvent movementEvent = new MovementEvent(ActivityRecognitionConstantsMapping.getActivityType(Integer.valueOf(i)), i2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(movementEvent);
        if (i == 7 || i == 8) {
            arrayList.add(new MovementEvent(ActivityRecognitionConstantsMapping.getActivityType(2), i2));
        }
        this.transitionMappingManager.sendActivityTransitionMappingInfo(arrayList, this.mContext);
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public void removeActivityTransitionUpdates(ATCallback aTCallback, ClientInfo clientInfo) {
        com.huawei.location.activity.model.yn ynVar;
        LogLocation.i(TAG, "removeActivityTransitionUpdates");
        this.transitionMappingManager.removeActivityTransitionMappingInfo(aTCallback);
        if (this.transitionMappingManager.getInfos().size() != 0 || (ynVar = this.atProvider) == null) {
            return;
        }
        this.recognitionMappingManager.removeActivityUpdatesMappingInfo(ynVar.yn());
        scheduleTimer();
        this.atProvider.Vw();
        this.alreadyRequestAR = false;
        LogLocation.i(TAG, "no activity transition request ");
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public synchronized void removeActivityUpdates(ARCallback aRCallback, ClientInfo clientInfo) {
        LogLocation.i(TAG, "removeActivityUpdates");
        this.recognitionMappingManager.removeActivityUpdatesMappingInfo(aRCallback);
        scheduleTimer();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public void requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        com.huawei.location.activity.model.yn ynVar;
        ObjectCheckUtils.checkNullObject(TAG, activityTransitionRequest, ActivityTransitionRequest.class);
        List<ActivityTransition> transitions = activityTransitionRequest.getTransitions();
        if (transitions == null || transitions.size() < 1) {
            LogLocation.i(TAG, "requestActivityTransitionUpdates ,null == transitions || transitions.size() < 1");
            return;
        }
        LogLocation.i(TAG, "requestActivityTransitionUpdates");
        this.transitionMappingManager.addActivityTransitionMappingInfo(transitions, aTCallback, clientInfo);
        if (!this.alreadyRequestAR && (ynVar = this.atProvider) != null) {
            this.recognitionMappingManager.addActivityUpdatesMappingInfo(1000L, ynVar.yn(), clientInfo);
            this.alreadyRequestAR = true;
        }
        scheduleTimer();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public synchronized void requestActivityUpdates(long j, ARCallback aRCallback, ClientInfo clientInfo) {
        LogLocation.i(TAG, "requestActivityUpdates");
        this.recognitionMappingManager.addActivityUpdatesMappingInfo(j, aRCallback, clientInfo);
        scheduleTimer();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    public synchronized void scheduleTimer() {
        long minTime;
        try {
            minTime = this.recognitionMappingManager.getMinTime();
        } catch (LocationServiceException e) {
            throw e;
        } catch (Exception unused) {
            LogLocation.e(TAG, "scheduleTimer exception", true);
        }
        if (-1 == minTime) {
            LogLocation.i(TAG, "scheduleTimer return time is " + minTime);
            this.lastTimeByTimer = -1L;
            stopScheduled();
            return;
        }
        long j = this.lastTimeByTimer;
        if (j == -1) {
            LogLocation.i(TAG, "scheduleTimer begin time is " + minTime);
            this.lastTimeByTimer = minTime;
            startScheduled(minTime);
        } else if (minTime != j) {
            LogLocation.i(TAG, "scheduleTimer begin again time is " + minTime);
            this.lastTimeByTimer = minTime;
            restartScheduled(minTime);
        } else {
            register();
        }
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    protected void startScheduled(long j) {
        this.delay = j;
        LogLocation.i(TAG, "startScheduled enter");
        register();
    }

    @Override // com.huawei.location.base.activity.AbstractARServiceManager
    protected void stopScheduled() {
        LogLocation.i(TAG, "stopScheduled enter");
        unregister();
        try {
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                LogLocation.i(TAG, "stopScheduled exit:" + this.scheduledFuture.cancel(true));
                return;
            }
            LogLocation.i(TAG, "scheduled not init or cancelled");
        } catch (LocationServiceException e) {
            throw e;
        } catch (Exception unused) {
            LogLocation.e(TAG, "stopScheduled exit exception", true);
        }
    }
}
