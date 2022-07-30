package com.example.soccernews;

import android.app.Application;

//simular mecanismo de injeção de dependêcias, mesmo sendo anti-pattern

// Dagger ou Hilt são as dependências que devem ser usadas nesse caso

public class App extends Application {
    private static App instance;

    public static App getInstance(){ //garante que o meu contexto sempre esteja disponivel de forma statica em qualquer lugar da aplicação
        return instance;
    }

    @Override
    public void  onCreate(){
        super.onCreate();
        instance = this;
    }

}
