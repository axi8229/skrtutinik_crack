package com.huawei.updatesdk.a.a.d;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.nlp.network.OnlineLocationService;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class c {
    private static final Map<String, String> a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("android.hardware.audio.output", "1");
        map.put("android.hardware.bluetooth", "2");
        map.put("android.hardware.bluetooth_le", "3");
        map.put("android.hardware.camera", OnlineLocationService.SRC_DEFAULT);
        map.put("android.hardware.camera.any", "5");
        map.put("android.hardware.camera.autofocus", "6");
        map.put("android.hardware.camera.capability.manual_post_processing", "7");
        map.put("android.hardware.camera.flash", "8");
        map.put("android.hardware.camera.front", "9");
        map.put("android.hardware.consumerir", "A");
        map.put("android.hardware.faketouch", "B");
        map.put("android.hardware.fingerprint", "C");
        map.put("android.hardware.location", "D");
        map.put("android.hardware.location.gps", "E");
        map.put("android.hardware.location.network", "F");
        map.put("android.hardware.microphone", "G");
        map.put("android.hardware.nfc", "H");
        map.put("android.hardware.nfc.any", "I");
        map.put("android.hardware.nfc.hce", "J");
        map.put("android.hardware.nfc.hcef", "K");
        map.put("android.hardware.opengles.aep", "L");
        map.put("android.hardware.ram.normal", "M");
        map.put("android.hardware.screen.landscape", "N");
        map.put("android.hardware.screen.portrait", "O");
        map.put("android.hardware.sensor.accelerometer", "P");
        map.put("android.hardware.sensor.barometer", "Q");
        map.put("android.hardware.sensor.compass", "R");
        map.put("android.hardware.sensor.gyroscope", "S");
        map.put("android.hardware.sensor.light", "T");
        map.put("android.hardware.sensor.proximity", "U");
        map.put("android.hardware.sensor.stepcounter", "V");
        map.put("android.hardware.sensor.stepdetector", "W");
        map.put("android.hardware.telephony", "X");
        map.put("android.hardware.telephony.gsm", "Y");
        map.put("android.hardware.telephony.ims", "Z");
        map.put("android.hardware.touchscreen", "a");
        map.put("android.hardware.touchscreen.multitouch", "b");
        map.put("android.hardware.touchscreen.multitouch.distinct", "c");
        map.put("android.hardware.touchscreen.multitouch.jazzhand", "d");
        map.put("android.hardware.usb.accessory", "e");
        map.put("android.hardware.usb.host", "f");
        map.put("android.hardware.vulkan.compute", "g");
        map.put("android.hardware.vulkan.level", "h");
        map.put("android.hardware.vulkan.version", "i");
        map.put("android.hardware.wifi", "j");
        map.put("android.hardware.wifi.direct", "k");
        map.put("android.hardware.wifi.passpoint", "l");
        map.put("android.software.activities_on_secondary_displays", "m");
        map.put("android.software.app_widgets", "n");
        map.put("android.software.autofill", "o");
        map.put("android.software.backup", "p");
        map.put("android.software.cant_save_state", "q");
        map.put("android.software.companion_device_setup", "r");
        map.put("android.software.connectionservice", "s");
        map.put("android.software.cts", "t");
        map.put("android.software.device_admin", "u");
        map.put("android.software.file_based_encryption", "v");
        map.put("android.software.freeform_window_management", "w");
        map.put("android.software.home_screen", "x");
        map.put("android.software.input_methods", "y");
        map.put("android.software.ipsec_tunnels", "z");
        map.put("android.software.live_wallpaper", "00");
        map.put("android.software.managed_users", HiAnalyticsConstant.KeyAndValue.NUMBER_01);
        map.put("android.software.midi", "02");
        map.put("android.software.picture_in_picture", "03");
        map.put("android.software.print", "04");
        map.put("android.software.secure_lock_screen", "05");
        map.put("android.software.securely_removes_users", "06");
        map.put("android.software.verified_boot", "07");
        map.put("android.software.voice_recognizers", "08");
        map.put("android.software.webview", "09");
        map.put("android.sofware.nfc.beam", "0A");
        map.put("com.huawei.software.features.china", "0B");
        map.put("com.huawei.software.features.full", "0C");
        map.put("com.huawei.system.feature", "0D");
        map.put("com.nxp.mifare", "0E");
        map.put("huawei.android.hardware.stylus", "0F");
        map.put("android.hardware.audio.low_latency", "0G");
        map.put("android.hardware.camera.capability.raw", "0H");
        map.put("android.hardware.camera.external", "0I");
        map.put("android.hardware.telephony.cdma", "0J");
        map.put("android.software.file_based_encryption", "0K");
        map.put("android.software.sip", "0L");
        map.put("android.software.sip.voip", "0M");
        map.put("android.software.vr.mode", "0N");
        map.put("cn.google.services", "0O");
        map.put("com.google.android.feature.services_updater", "0P");
        map.put("com.google.android.feature.ZERO_TOUCH", "0Q");
        map.put("com.huawei.software.features.oversea", "0R");
    }

    public static String a(String str) {
        Map<String, String> map = a;
        return map.containsKey(str) ? map.get(str) : str;
    }
}
