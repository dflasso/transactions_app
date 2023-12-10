import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { HttpClientModule } from '@angular/common/http';
import { TransactionsServices } from './services/trensactions.services';
import { provideAnimations } from '@angular/platform-browser/animations';
import { AuthServices } from './services/auth.services';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    importProvidersFrom(HttpClientModule),
    TransactionsServices,
    AuthServices,
    provideAnimations()
]
};
