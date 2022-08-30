package com.project.painelpaciente.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.painelpaciente.entities.Medico;
import com.project.painelpaciente.repository.MedicosRepository;
import com.project.painelpaciente.responses.Response;

@RestController
public class MedicoController {
    
    @Autowired
    private MedicosRepository medicosRepository;

    @RequestMapping(value = "/medicos", method = RequestMethod.GET)
    public List<Medico> Get(){
        return medicosRepository.findAll();
    }

    @RequestMapping(value = "/medicos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medico> GetById(@PathVariable(value = "id") long id){
        Optional<Medico>  medico = medicosRepository.findById(id);

        if(medico.isPresent()){
            return new ResponseEntity<Medico>(medico.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/medicos",method = RequestMethod.POST)
    public ResponseEntity<Response<Medico>> Post (@Valid @RequestBody Medico medico, BindingResult result) {

        Response<Medico> response = new Response<Medico>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        medicosRepository.save(medico);
        response.setData(medico);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/medicos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response<Medico>> Put (@PathVariable(value = "id") long id, @Valid @RequestBody Medico newMedico, BindingResult result){
        Optional<Medico> oldMedico = medicosRepository.findById(id);
        Response<Medico> response = new Response<Medico>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        if(oldMedico.isPresent()){
            Medico medico = oldMedico.get();
            medico.setNome(newMedico.getNome());
            medico.setEspecialidade(newMedico.getEspecialidade());
            medico.setEmail(newMedico.getEmail());
            medico.setUsername(newMedico.getUsername());


            medicosRepository.save(medico);
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/medicos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete (@PathVariable(value = "id") long id){
		
		Optional<Medico> medico = medicosRepository.findById(id);
		
		if(medico.isPresent()) {
			medicosRepository.delete(medico.get());
			return new ResponseEntity<> (HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
}
