// Generated by Dagger (https://dagger.dev).
package com.kipreev.aston_final_project.presentation.di;

import com.kipreev.aston_final_project.domain.characters.GetAllCharactersUseCase;
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharactersListViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PresentationModule_ProvideCharactersViewModelFactory implements Factory<CharactersListViewModel> {
  private final PresentationModule module;

  private final Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider;

  public PresentationModule_ProvideCharactersViewModelFactory(PresentationModule module,
      Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider) {
    this.module = module;
    this.getAllCharactersUseCaseProvider = getAllCharactersUseCaseProvider;
  }

  @Override
  public CharactersListViewModel get() {
    return provideCharactersViewModel(module, getAllCharactersUseCaseProvider.get());
  }

  public static PresentationModule_ProvideCharactersViewModelFactory create(
      PresentationModule module,
      Provider<GetAllCharactersUseCase> getAllCharactersUseCaseProvider) {
    return new PresentationModule_ProvideCharactersViewModelFactory(module, getAllCharactersUseCaseProvider);
  }

  public static CharactersListViewModel provideCharactersViewModel(PresentationModule instance,
      GetAllCharactersUseCase getAllCharactersUseCase) {
    return Preconditions.checkNotNullFromProvides(instance.provideCharactersViewModel(getAllCharactersUseCase));
  }
}