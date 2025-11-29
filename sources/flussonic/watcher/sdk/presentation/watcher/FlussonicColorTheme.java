package flussonic.watcher.sdk.presentation.watcher;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import flussonic.watcher.sdk.R$color;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class FlussonicColorTheme {
    private final Map<String, Integer> colors = new HashMap();
    private final Map<String, Integer> defaultColors = new HashMap();
    public boolean themeChanged;

    static class ColorThemeProvider {
        public static final FlussonicColorTheme COLOR_THEME = new FlussonicColorTheme();
    }

    public static FlussonicColorTheme getInstance() {
        return ColorThemeProvider.COLOR_THEME;
    }

    public int getColor(String colorName) {
        Integer num = this.colors.get(colorName);
        if (num != null) {
            return num.intValue();
        }
        Integer num2 = this.defaultColors.get(colorName);
        return num2 != null ? num2.intValue() : Color.parseColor("#ff2222");
    }

    void initDefaultColors(FlussonicWatcherView view) {
        Context context = view.getContext();
        this.defaultColors.put("fs_chart_background", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_chart_background)));
        this.defaultColors.put("fs_ruler_line", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_ruler_line)));
        this.defaultColors.put("fs_loading_range", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_loading_range)));
        this.defaultColors.put("fs_range", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_range)));
        this.defaultColors.put("fs_cut_range", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_cut_range)));
        this.defaultColors.put("fs_pause_button_pressed", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_pause_button_pressed)));
        this.defaultColors.put("fs_progress_bar", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_progress_bar)));
        this.defaultColors.put("fs_camera_status_icon_active", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_camera_status_icon_active)));
        this.defaultColors.put("fs_camera_status_icon_inactive", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_camera_status_icon_inactive)));
        Map<String, Integer> map = this.defaultColors;
        int i = R$color.fs_event;
        map.put("fs_event", Integer.valueOf(ContextCompat.getColor(context, i)));
        this.defaultColors.put("fs_event_vehicle", Integer.valueOf(ContextCompat.getColor(context, i)));
        this.defaultColors.put("fs_event_face", Integer.valueOf(ContextCompat.getColor(context, i)));
        this.defaultColors.put("fs_time_label", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_time_label)));
        this.defaultColors.put("fs_cut_value", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_cut_value)));
        this.defaultColors.put("fs_cut_label", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_cut_label)));
        this.defaultColors.put("fs_cut_timestamp_background", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_cut_timestamp_background)));
        this.defaultColors.put("fs_bottom_bar_gradient1", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_bottom_bar_gradient1)));
        this.defaultColors.put("fs_bottom_bar_gradient2", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_bottom_bar_gradient2)));
        this.defaultColors.put("fs_bottom_bar_date_text", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_bottom_bar_date_text)));
        this.defaultColors.put("fs_bottom_bar_icon", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_bottom_bar_icon)));
        this.defaultColors.put("fs_bottom_bar_divider", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_bottom_bar_divider)));
        this.defaultColors.put("fs_dash", Integer.valueOf(ContextCompat.getColor(context, R$color.fs_dash)));
    }
}
