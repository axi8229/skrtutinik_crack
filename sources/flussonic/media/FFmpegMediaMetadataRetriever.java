package flussonic.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class FFmpegMediaMetadataRetriever {
    public static Bitmap.Config IN_PREFERRED_CONFIG = null;
    private static final String[] JNI_LIBRARIES = {"c++_shared", "crypto", "ssl", "avutil", "swscale", "avcodec", "avformat", "ffmpeg_mediametadataretriever_jni"};
    private static final String JNI_LOAD_ERROR = "Native library: %s load error";
    public static final String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FILESIZE = "filesize";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_HEIGHT = "video_height";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final String METADATA_KEY_VIDEO_WIDTH = "video_width";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final String TAG = "FFmpegMediaMetadataRetriever";
    private static String lastLoadLib = "";
    private static boolean libsLoaded = false;
    private long mNativeContext;

    public class Metadata {
        public Metadata() {
        }
    }

    static {
        int i = 0;
        while (true) {
            try {
                String[] strArr = JNI_LIBRARIES;
                if (i >= strArr.length) {
                    lastLoadLib = "";
                    native_init();
                    libsLoaded = true;
                    return;
                } else {
                    String str = strArr[i];
                    lastLoadLib = str;
                    System.loadLibrary(str);
                    i++;
                }
            } catch (UnsatisfiedLinkError e) {
                libsLoaded = false;
                Log.e(FFmpegMediaMetadataRetriever.class.getName(), String.format("Error while loading lib: %s", lastLoadLib), e);
                return;
            }
        }
    }

    public FFmpegMediaMetadataRetriever() {
        if (libsLoaded) {
            native_setup();
        }
    }

    private native byte[] _getFrameAtTime(long timeUs, int option);

    private native byte[] _getScaledFrameAtTime(long timeUs, int option, int width, int height);

    private native void _setDataSource(String uri, String[] keys, String[] values) throws IllegalArgumentException;

    private void checkLibsLoaded() throws IllegalArgumentException {
        if (!libsLoaded) {
            throw new IllegalArgumentException(String.format(JNI_LOAD_ERROR, lastLoadLib));
        }
    }

    private final native void native_finalize();

    private final native HashMap<String, String> native_getMetadata(boolean update_only, boolean apply_filter, HashMap<String, String> reply);

    private static native void native_init();

    private native void native_setup();

    public native String extractMetadata(String keyCode);

    public native String extractMetadataFromChapter(String keyCode, int chapter);

    public void finalize() throws Throwable {
        try {
            if (libsLoaded) {
                native_finalize();
            }
        } finally {
            super.finalize();
        }
    }

    public native byte[] getEmbeddedPicture();

    public Bitmap getFrameAtTime(long timeUs, int option) {
        byte[] bArr_getFrameAtTime;
        if (option < 0 || option > 3) {
            throw new IllegalArgumentException("Unsupported option: " + option);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        try {
            bArr_getFrameAtTime = _getFrameAtTime(timeUs, option);
        } catch (Exception e) {
            Log.e(getClass().getName(), String.format("Error till decoding bitmap with time: %d, options: %d", Long.valueOf(timeUs), Integer.valueOf(option)), e);
        }
        if (bArr_getFrameAtTime != null) {
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeByteArray(bArr_getFrameAtTime, 0, bArr_getFrameAtTime.length, options);
        }
        Log.d(getClass().getName(), String.format("frame is null", new Object[0]));
        return null;
    }

    public Metadata getMetadata() {
        Metadata metadata = new Metadata();
        if (native_getMetadata(false, false, null) == null) {
            return null;
        }
        return metadata;
    }

    public Bitmap getScaledFrameAtTime(long timeUs, int option, int width, int height) {
        byte[] bArr_getScaledFrameAtTime;
        if (option < 0 || option > 3) {
            throw new IllegalArgumentException("Unsupported option: " + option);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        try {
            bArr_getScaledFrameAtTime = _getScaledFrameAtTime(timeUs, option, width, height);
        } catch (Exception e) {
            Log.e(getClass().getName(), String.format("Error till decoding bitmap with time: %d, options: %d", Long.valueOf(timeUs), Integer.valueOf(option)), e);
        }
        if (bArr_getScaledFrameAtTime != null) {
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeByteArray(bArr_getScaledFrameAtTime, 0, bArr_getScaledFrameAtTime.length, options);
        }
        Log.d(getClass().getName(), String.format("frame is null", new Object[0]));
        return null;
    }

    public native void native_release();

    public void release() {
        try {
            if (libsLoaded) {
                native_release();
            }
        } catch (UnsatisfiedLinkError e) {
            Log.e(getClass().getName(), "Error while calling native_release", e);
        }
    }

    public native void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalArgumentException;

    public native void setDataSource(String path) throws IllegalArgumentException;

    public void setDataSource(String uri, Map<String, String> headers) throws IllegalArgumentException {
        checkLibsLoaded();
        String[] strArr = new String[headers.size()];
        String[] strArr2 = new String[headers.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        _setDataSource(uri, strArr, strArr2);
    }

    public native void setSurface(Object surface);

    public void setDataSource(FileDescriptor fd) throws IllegalArgumentException {
        checkLibsLoaded();
        setDataSource(fd, 0L, 576460752303423487L);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, SecurityException, IllegalArgumentException {
        if (uri != null) {
            checkLibsLoaded();
            String scheme = uri.getScheme();
            if (scheme != null && !scheme.equals("file")) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                            FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
                            if (fileDescriptor.valid()) {
                                if (assetFileDescriptorOpenAssetFileDescriptor.getDeclaredLength() < 0) {
                                    setDataSource(fileDescriptor);
                                } else {
                                    setDataSource(fileDescriptor, assetFileDescriptorOpenAssetFileDescriptor.getStartOffset(), assetFileDescriptorOpenAssetFileDescriptor.getDeclaredLength());
                                }
                                try {
                                    assetFileDescriptorOpenAssetFileDescriptor.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    } catch (FileNotFoundException unused2) {
                        throw new IllegalArgumentException();
                    }
                } catch (SecurityException unused3) {
                    if (0 != 0) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused4) {
                        }
                    }
                    setDataSource(uri.toString());
                    return;
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
            setDataSource(uri.getPath());
            return;
        }
        throw new IllegalArgumentException();
    }

    public Bitmap getFrameAtTime(long timeUs) {
        return getFrameAtTime(timeUs, 2);
    }

    public Bitmap getScaledFrameAtTime(long timeUs, int width, int height) {
        return getScaledFrameAtTime(timeUs, 2, width, height);
    }

    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1L);
    }
}
