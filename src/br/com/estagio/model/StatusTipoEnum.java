/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.model;

/**
 *
 * @author victor
 */
public enum StatusTipoEnum {
    
     D("Disponivel"), I("Indisponivel");

   private final String value;

	StatusTipoEnum(String value) {
		this.value = value;
	}

	public static StatusTipoEnum fromValue(String value) {
		if (value != null) {
			for (StatusTipoEnum status : values()) {
				if (status.value.equals(value)) {
					return status;
				}
			}
		}
		throw new IllegalArgumentException("Sexo invalido: " + value);
	}
    
    public String toValue() {
        return value;
    }
}
