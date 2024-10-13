package com.example.CRUD.permissionGroup;

public enum perssionSet {
    SYS_ADM(3),
    GERENTE(2),
    FUNCIONARIO(1),
    CLIENTE(0);

    private int nivelAcesso;

    perssionSet(int nicelAcesso) {
        this.nivelAcesso = nicelAcesso;
    }

    public int getNicelAcesso() {
        return nivelAcesso;
    }
}
