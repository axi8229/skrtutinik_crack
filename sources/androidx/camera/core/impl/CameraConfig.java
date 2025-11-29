package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface CameraConfig extends ReadableConfig {
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = Config.Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);
    public static final Config.Option<Identifier> OPTION_COMPATIBILITY_ID = Config.Option.create("camerax.core.camera.compatibilityId", Identifier.class);
    public static final Config.Option<Integer> OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = Config.Option.create("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
    public static final Config.Option<SessionProcessor> OPTION_SESSION_PROCESSOR = Config.Option.create("camerax.core.camera.SessionProcessor", SessionProcessor.class);
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.camera.isZslDisabled", Boolean.class);

    Identifier getCompatibilityId();

    default UseCaseConfigFactory getUseCaseConfigFactory() {
        return (UseCaseConfigFactory) retrieveOption(OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE);
    }

    default int getUseCaseCombinationRequiredRule() {
        return ((Integer) retrieveOption(OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, 0)).intValue();
    }

    default SessionProcessor getSessionProcessor(SessionProcessor sessionProcessor) {
        return (SessionProcessor) retrieveOption(OPTION_SESSION_PROCESSOR, sessionProcessor);
    }
}
