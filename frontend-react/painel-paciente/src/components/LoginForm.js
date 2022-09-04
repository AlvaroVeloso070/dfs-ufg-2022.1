import React from 'react';
import './LoginForm.css';



export const LoginForm = () => {

  return (
    <form className="login-form">       
            <h1>LOGIN</h1>
            <div className="textfield">
              <label for="email">Email</label>
              <input type="text" name="email" placeholder="Email" required></input>
            </div>

            <div className="textfield">
              <label for="senha">Senha</label>
              <input type="password" name="senha" placeholder="Senha" required></input>
            </div> 

            <button className="btn-login">Login</button>

            <span className="btn-cadastrar">Ainda nao tem cadastro? Cadastre-se!</span>

          </form>
  )
}
