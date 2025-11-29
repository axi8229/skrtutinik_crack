package com.sputnik.common.di.use_cases.tiles;

import com.sputnik.domain.repositories.tiles.ITilesRepository;
import com.sputnik.domain.usecases.tiles.GetTilesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class TilesUseCaseModule_ProvideGetTilesUseCaseFactory implements Factory<GetTilesUseCase> {
    public static GetTilesUseCase provideGetTilesUseCase(TilesUseCaseModule tilesUseCaseModule, ITilesRepository iTilesRepository) {
        return (GetTilesUseCase) Preconditions.checkNotNullFromProvides(tilesUseCaseModule.provideGetTilesUseCase(iTilesRepository));
    }
}
