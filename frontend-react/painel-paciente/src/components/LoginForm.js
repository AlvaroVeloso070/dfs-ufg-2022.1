import React from 'react';
import { Link } from 'react-router-dom';
import './LoginForm.css';



export const LoginForm = () => {

  const inicialValues = {
    "email": "",
    "senha": ""
  }

  const [values, setValues] = useState(inicialValues);
  function onChange(event) {
    const{name, value} = event.target;

    setValues({...values, [name]: value}); 
}

  return (
    <form className="login-form">       
            <h1>LOGIN</h1>
            <div className="textfield">
              <label for="email">Email</label>
              <input onChange={onChange} type="text" name="email" placeholder="Email" required></input>
            </div>

            <div className="textfield">
              <label for="senha">Senha</label>
              <input onChange={onChange} type="password" name="senha" placeholder="Senha" required></input>
            </div> 

            <button className="btn-login">Login</button>

            <Link to={"/register"} className="btn-cadastrar">Ainda nao tem cadastro? Cadastre-se!</Link>

          </form>
  )
}
