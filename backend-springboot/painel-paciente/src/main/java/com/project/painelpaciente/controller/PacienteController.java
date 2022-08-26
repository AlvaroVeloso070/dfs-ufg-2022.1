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

import com.project.painelpaciente.repository.PacientesRepository;
import com.project.painelpaciente.responses.Response;
import  com.project.painelpaciente.entities.Paciente;

@RestController
public class PacienteController {
 
    @Autowired
    private PacientesRepository pacientesRepository;

    @RequestMapping(value = "/pacientes", method = RequestMethod.GET)
    public List<Paciente> Get(){
        return pacientesRepository.findAll();
    }

    @RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Paciente> GetById(@PathVariable(value = "id") long id){
        Optional<Paciente> paciente = pacientesRepository.findById(id);

        if(paciente.isPresent()){
            return new ResponseEntity<Paciente>(paciente.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pacientes",method = RequestMethod.POST)
    public ResponseEntity<Response<Paciente>> Post (@Valid @RequestBody Paciente paciente, BindingResult result) {

        Response<Paciente> response = new Response<Paciente>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        pacientesRepository.save(paciente);
        response.setData(paciente);
        return ResponseEntity.ok(response);
    }
    

    @RequestMapping(value = "/pacientes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response<Paciente>> Put (@PathVariable(value = "id") long id, @Valid @RequestBody Paciente newPaciente, BindingResult result){
        Optional<Paciente> oldPaciente = pacientesRepository.findById(id);
        Response<Paciente> response = new Response<Paciente>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        if(oldPaciente.isPresent()){
            Paciente paciente = oldPaciente.get();
            paciente.setNome(newPaciente.getNome());
            paciente.setCpf(newPaciente.getCpf());
            paciente.setDataNascimento(newPaciente.getDataNascimento());
            paciente.setTelefone(newPaciente.getTelefone());
            paciente.setEmail(newPaciente.getEmail());
            paciente.setSintomas(newPaciente.getSintomas());
            
            pacientesRepository.save(paciente);
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pacientes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete (@PathVariable(value = "id") long id){
		
		Optional<Paciente> paciente = pacientesRepository.findById(id);
		
		if(paciente.isPresent()) {
			pacientesRepository.delete(paciente.get());
			return new ResponseEntity<> (HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
}
