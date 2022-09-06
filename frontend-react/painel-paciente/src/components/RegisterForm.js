import React, { useState } from 'react'

const inicialValues = {
    "nome": "",
    "email": "",
    "senha": "",
    "tipo_pessoa": "",
    "data_nascimento": "",
    "telefone": ""
}

const RegisterForm = () => {

    const [values, setValues] = useState(inicialValues);

    function onChange(event) {
        const{name, value} = event.target;

        setValues({...values, [name]: value}); 
    }

    const persist = () => {
        const requestOptions = {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*'
            },

            body: JSON.stringify({
                nome: values.nome,
                email: values.email,
                senha: values.senha,
                tipo_pessoa: values.tipo_pessoa,
                data_nascimento: values.data_nascimento,
                telefone: values.telefone
            })
        };

        const url = "http://localhost:8080/cadastros";

        fetch(url, requestOptions)
            .then(alert("O usuário foi cadastrado com sucesso!"))
            .catch(erro => console.log(erro))
    }

  return (
    <form className='register-form'>
        <h1>CADASTRO</h1>
        <div className="textfield">
              <label htmlFor="nome">Nome</label>
              <input onChange={onChange} id='nome' type="text" name="nome" placeholder="Nome" required/>
        </div>
        <div className="textfield">
              <label htmlFor="email">Email</label>
              <input onChange={onChange} type="text" id='email' name="email" placeholder="Email" required></input>
        </div>
        <div className="textfield">
              <label htmlFor='password'>Senha</label>
              <input onChange={onChange} type="password" id='password' name="senha" placeholder="Senha" required></input>
        </div>
        <div className='inline-content'>
            <div className='textfield' id='tipoPessoaLabel'>
                <label htmlFor='tipoPessoa'>Você é: </label>
                <select onChange={onChange} className="select-pessoa" name="tipo_pessoa" id="pessoa" required>
                    <option value="Escolha uma opção..." disabled>Escolha uma opção...</option>
                    <option value="Paciente">Paciente</option>
                    <option value="Médico">Médico</option>
                    <option value="Acompanhante">Acompanhante</option>
                </select>
            </div>
            <div className='textfield' id="dataNascimentoLabel">
                <label htmlFor="dataNascimento">Data de nascimento: </label>
                <input onChange={onChange} type="date" name="data_nascimento" id="dataNascimento" required />
            </div>
            <div className='textfield' id='telefoneLabel'>
                <label htmlFor="telefone">Telefone</label>
                <input onChange={onChange} type="text" name="telefone" id="telefone" placeholder='Telefone' required/>
            </div>
        </div>

        <button onClick={persist} type="submit" className='btn-register'>Cadastrar</button>

    </form>
  )
}

export default RegisterForm