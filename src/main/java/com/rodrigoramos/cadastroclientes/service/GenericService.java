package com.rodrigoramos.cadastroclientes.service;

import java.util.List;

public interface GenericService<E, M> {

    E save(E entity);

    E findById(M id);

    E findByNomeCompleto(String nomeCompleto);

    List<E> findAll();


//   List<E> save(List<E> entities);

//    void deleteById(M id);

    //   Optional<E> findById(M id);

//

//    Page<E> findAll(Pageable pageable);

  //  E update(Optional<E> entity, E id);
}