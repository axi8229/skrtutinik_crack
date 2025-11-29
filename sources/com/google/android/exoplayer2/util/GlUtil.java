package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* loaded from: classes2.dex */
public final class GlUtil {
    public static boolean isProtectedContentExtensionSupported(Context context) {
        String strEglQueryString;
        int i = Util.SDK_INT;
        if (i < 24) {
            return false;
        }
        if (i >= 26 || !("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String strEglQueryString;
        return Util.SDK_INT >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context");
    }

    public static void checkGlError() {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            Log.e("GlUtil", "glError " + GLU.gluErrorString(iGlGetError));
        }
    }

    public static int compileProgram(String[] vertexCode, String[] fragmentCode) {
        return compileProgram(TextUtils.join("\n", vertexCode), TextUtils.join("\n", fragmentCode));
    }

    public static int compileProgram(String vertexCode, String fragmentCode) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        checkGlError();
        addShader(35633, vertexCode, iGlCreateProgram);
        addShader(35632, fragmentCode, iGlCreateProgram);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            throwGlError("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        }
        checkGlError();
        return iGlCreateProgram;
    }

    public static FloatBuffer createBuffer(float[] data) {
        return (FloatBuffer) createBuffer(data.length).put(data).flip();
    }

    public static FloatBuffer createBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static int createExternalTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError();
        return iArr[0];
    }

    private static void addShader(int type, String source, int program) {
        int iGlCreateShader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(iGlCreateShader, source);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            throwGlError(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + source);
        }
        GLES20.glAttachShader(program, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        checkGlError();
    }

    private static void throwGlError(String errorMsg) {
        Log.e("GlUtil", errorMsg);
    }
}
