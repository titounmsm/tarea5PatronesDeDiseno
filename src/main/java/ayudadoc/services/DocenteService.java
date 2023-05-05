package ayudadoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import ayudadoc.entities.DocenteEntity;
import ayudadoc.helpers.error.AyudaDocException;
import ayudadoc.models.docente.Docente;
import ayudadoc.repositories.DocenteRepository;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public Flux<Docente> getAll() {
        return docenteRepository.findAll().flatMap(DocenteEntity::toDomainModelMono);
    }

    public Mono<Docente> getById(Long id) {
        
        Docente doc = docenteRepository.findById(id).block().toDomainModel();

        if (doc!=null)
            System.out.println( doc.toString() );
        else 
            return Mono.error(
                new AyudaDocException("Docente no existe", "Docente con Id:" + id + " no existe.")
            );

        return Mono.just(doc);
    }

    public Mono<Docente> saveDocente(Docente docente) {

        DocenteEntity d1 = docenteRepository.findByCodigo(docente.getCodigo()).block();
        if ( d1!=null )    {

            return Mono.error(
                new AyudaDocException("Codigo no unico", "El codigo ya existe para otro docente")
            );
        }

        DocenteEntity d2 = docenteRepository.findByEmail(docente.getEmail()).block();
        if ( d2!=null )  {

            return Mono.error(
                new AyudaDocException("Email ya existente", "El email ya existe en otro docente")
            );
        }
        
        System.out.println("*********** Ingreso a crear... ***********************");
        docente.setEstado( "1" );

        DocenteEntity docenteEntity = DocenteEntity.fromDomainModel( docente ); 
        return Mono.just( docenteRepository.save(docenteEntity).doOnSuccess(pl -> {}).block().toDomainModel() );
        
      }
}
