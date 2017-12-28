package br.edu.ufcg.jukeboxdozenanzin.validation;

public interface Validator<T> {

    void validaCadastro(T entity);

    boolean entidadeExiste(T entity);

}
