package br.com.estagio.model;

public enum SexoTipoEnum {

    M("Masculino"), F("Feminino");

    private String sexo;

    SexoTipoEnum(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

}
