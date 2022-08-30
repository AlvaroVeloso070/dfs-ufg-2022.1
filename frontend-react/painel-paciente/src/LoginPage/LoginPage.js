import React from "react";
import './LoginPage.css';


export default () => {
  return(
    <div className="page">
      <div className="main">
        <div className="left-section">
          <h1>Faça Login,<br/>ou crie seu cadastro!</h1>
        </div>
        <div className="right-section">
          <div className="login-form">

            <h1>LOGIN</h1>

            <div className="textfield">
              <label for="usuario">Usuário</label>
              <input type="text" name="usuario" placeholder="Usuário"></input>
            </div>

            <div className="textfield">
              <label for="senha">Senha</label>
              <input type="password" name="senha" placeholder="Senha"></input>
            </div> 

            <button className="btn-login">Login</button>

            <span className="btn-cadastrar">Ainda nao tem cadastro? Cadastre-se!</span>

          </div>
        </div>
      </div> 
    </div>
  );

}