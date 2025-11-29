package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer;
import com.google.android.exoplayer2.ext.ffmpeg.FfmpegVideoRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DefaultRenderersFactory implements RenderersFactory {
    private final Context context;
    private boolean enableDecoderFallback;
    private int extensionRendererMode = 0;
    private long allowedVideoJoiningTimeMs = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
    private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
    private int mediaCodecOperationMode = 0;

    protected void buildMiscellaneousRenderers(Context context, Handler eventHandler, int extensionRendererMode, ArrayList<Renderer> out) {
    }

    public DefaultRenderersFactory(Context context) {
        this.context = context;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int extensionRendererMode) {
        this.extensionRendererMode = extensionRendererMode;
        return this;
    }

    public DefaultRenderersFactory experimental_setMediaCodecOperationMode(int mode) {
        this.mediaCodecOperationMode = mode;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean enableDecoderFallback) {
        this.enableDecoderFallback = enableDecoderFallback;
        return this;
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler eventHandler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textRendererOutput, MetadataOutput metadataRendererOutput) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, eventHandler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioProcessors(), eventHandler, audioRendererEventListener, arrayList);
        buildTextRenderers(this.context, textRendererOutput, eventHandler.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataRendererOutput, eventHandler.getLooper(), this.extensionRendererMode, arrayList);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, eventHandler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    protected void buildVideoRenderers(Context context, int extensionRendererMode, MediaCodecSelector mediaCodecSelector, boolean enableDecoderFallback, Handler eventHandler, VideoRendererEventListener eventListener, long allowedVideoJoiningTimeMs, ArrayList<Renderer> out) {
        String str;
        int i;
        int i2;
        MediaCodecVideoRenderer mediaCodecVideoRenderer = new MediaCodecVideoRenderer(context, mediaCodecSelector, allowedVideoJoiningTimeMs, enableDecoderFallback, eventHandler, eventListener, 50);
        mediaCodecVideoRenderer.experimental_setMediaCodecOperationMode(this.mediaCodecOperationMode);
        out.add(mediaCodecVideoRenderer);
        if (extensionRendererMode == 0) {
            return;
        }
        int size = out.size();
        if (extensionRendererMode == 2) {
            size--;
        }
        try {
            try {
                i = size + 1;
                try {
                    out.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(allowedVideoJoiningTimeMs), eventHandler, eventListener, 50));
                    str = "DefaultRenderersFactory";
                } catch (ClassNotFoundException unused) {
                    str = "DefaultRenderersFactory";
                }
                try {
                    Log.i(str, "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused2) {
                    size = i;
                    i = size;
                    try {
                        i2 = i + 1;
                        out.add(i, (Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(allowedVideoJoiningTimeMs), eventHandler, eventListener, 50));
                        Log.i(str, "Loaded Libgav1VideoRenderer.");
                        int i3 = FfmpegVideoRenderer.$r8$clinit;
                        out.add(i2, (Renderer) FfmpegVideoRenderer.class.getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(allowedVideoJoiningTimeMs), eventHandler, eventListener, 50));
                        Log.i(str, "Loaded FfmpegVideoRenderer.");
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating AV1 extension", e);
                    }
                }
            } catch (ClassNotFoundException unused3) {
                str = "DefaultRenderersFactory";
            }
            try {
                i2 = i + 1;
            } catch (ClassNotFoundException unused4) {
            }
            try {
                try {
                    out.add(i, (Renderer) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(allowedVideoJoiningTimeMs), eventHandler, eventListener, 50));
                    Log.i(str, "Loaded Libgav1VideoRenderer.");
                } catch (ClassNotFoundException unused5) {
                    i = i2;
                    i2 = i;
                    int i32 = FfmpegVideoRenderer.$r8$clinit;
                    out.add(i2, (Renderer) FfmpegVideoRenderer.class.getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(allowedVideoJoiningTimeMs), eventHandler, eventListener, 50));
                    Log.i(str, "Loaded FfmpegVideoRenderer.");
                }
                int i322 = FfmpegVideoRenderer.$r8$clinit;
                out.add(i2, (Renderer) FfmpegVideoRenderer.class.getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(allowedVideoJoiningTimeMs), eventHandler, eventListener, 50));
                Log.i(str, "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException e2) {
                Log.e(str, "Error while loading FfmpegVideoRenderer", e2);
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e3);
            }
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating VP9 extension", e4);
        }
    }

    protected void buildAudioRenderers(Context context, int extensionRendererMode, MediaCodecSelector mediaCodecSelector, boolean enableDecoderFallback, AudioProcessor[] audioProcessors, Handler eventHandler, AudioRendererEventListener eventListener, ArrayList<Renderer> out) {
        String str;
        int i;
        int i2;
        MediaCodecAudioRenderer mediaCodecAudioRenderer = new MediaCodecAudioRenderer(context, mediaCodecSelector, enableDecoderFallback, eventHandler, eventListener, new DefaultAudioSink(AudioCapabilities.getCapabilities(context), audioProcessors));
        mediaCodecAudioRenderer.experimental_setMediaCodecOperationMode(this.mediaCodecOperationMode);
        out.add(mediaCodecAudioRenderer);
        if (extensionRendererMode == 0) {
            return;
        }
        int size = out.size();
        if (extensionRendererMode == 2) {
            size--;
        }
        try {
            try {
                i = size + 1;
                try {
                    out.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(eventHandler, eventListener, audioProcessors));
                    str = "DefaultRenderersFactory";
                } catch (ClassNotFoundException unused) {
                    str = "DefaultRenderersFactory";
                }
                try {
                    Log.i(str, "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused2) {
                    size = i;
                    i = size;
                    try {
                        i2 = i + 1;
                        out.add(i, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(eventHandler, eventListener, audioProcessors));
                        Log.i(str, "Loaded LibflacAudioRenderer.");
                        out.add(i2, (Renderer) FfmpegAudioRenderer.class.getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(eventHandler, eventListener, audioProcessors));
                        Log.i(str, "Loaded FfmpegAudioRenderer.");
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating FLAC extension", e);
                    }
                }
            } catch (ClassNotFoundException unused3) {
                str = "DefaultRenderersFactory";
            }
            try {
                i2 = i + 1;
            } catch (ClassNotFoundException unused4) {
            }
            try {
                try {
                    out.add(i, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(eventHandler, eventListener, audioProcessors));
                    Log.i(str, "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                    i = i2;
                    i2 = i;
                    out.add(i2, (Renderer) FfmpegAudioRenderer.class.getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(eventHandler, eventListener, audioProcessors));
                    Log.i(str, "Loaded FfmpegAudioRenderer.");
                }
                out.add(i2, (Renderer) FfmpegAudioRenderer.class.getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(eventHandler, eventListener, audioProcessors));
                Log.i(str, "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException e2) {
                Log.e(str, "Error while loading FfmpegAudioRenderer", e2);
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e3);
            }
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating Opus extension", e4);
        }
    }

    protected void buildTextRenderers(Context context, TextOutput output, Looper outputLooper, int extensionRendererMode, ArrayList<Renderer> out) {
        out.add(new TextRenderer(output, outputLooper));
    }

    protected void buildMetadataRenderers(Context context, MetadataOutput output, Looper outputLooper, int extensionRendererMode, ArrayList<Renderer> out) {
        out.add(new MetadataRenderer(output, outputLooper));
    }

    protected void buildCameraMotionRenderers(Context context, int extensionRendererMode, ArrayList<Renderer> out) {
        out.add(new CameraMotionRenderer());
    }

    protected AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }
}
