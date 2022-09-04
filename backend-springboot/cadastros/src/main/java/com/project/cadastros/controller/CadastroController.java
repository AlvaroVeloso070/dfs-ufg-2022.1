package com.project.cadastros.controller;

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

import com.project.cadastros.entities.Cadastros;
import com.project.cadastros.repository.CadastroRepository;
import com.project.cadastros.responses.Response;

@RestController
public class CadastroController {
    
    @Autowired
    private CadastroRepository cadastroRepository;

    @RequestMapping(value = "/cadastros", method = RequestMethod.GET)
    public List<Cadastros> Get(){
        return cadastroRepository.findAll();
    }

    @RequestMapping(value = "/cadastros/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cadastros> GetById(@PathVariable(value = "id") long id){
        Optional<Cadastros>  cadastro = cadastroRepository.findById(id);

        if(cadastro.isPresent()){
            return new ResponseEntity<Cadastros>(cadastro.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/cadastros", method = RequestMethod.POST)
    public ResponseEntity<Response<Cadastros>> Post (@Valid @RequestBody Cadastros cadastro, BindingResult result) {

        Response<Cadastros> response = new Response<Cadastros>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        cadastroRepository.save(cadastro);
        response.setData(cadastro);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/cadastros/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response<Cadastros>> Put (@PathVariable(value = "id") long id, @Valid @RequestBody Cadastros newCadastro, BindingResult result){
        Optional<Cadastros> oldCadastro = cadastroRepository.findById(id);
        Response<Cadastros> response = new Response<Cadastros>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        if(oldCadastro.isPresent()){
            Cadastros cadastro = oldCadastro.get();
            cadastro.setNome(newCadastro.getNome());
            cadastro.setSenha(newCadastro.getSenha());
            cadastro.setEmail(newCadastro.getEmail());
            cadastro.setData_nascimento(newCadastro.getData_nascimento());
            cadastro.setTelefone(newCadastro.getTelefone());
            cadastro.setTipo_pessoa(newCadastro.getTipo_pessoa());


            cadastroRepository.save(cadastro);
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/cadastros/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete (@PathVariable(value = "id") long id){
		
		Optional<Cadastros> cadastro = cadastroRepository.findById(id);
		
		if(cadastro.isPresent()) {
			cadastroRepository.delete(cadastro.get());
			return new ResponseEntity<> (HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
}
