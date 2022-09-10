import React from 'react'
import './NavBar.css';
import {FiLogOut} from 'react-icons/fi'

export const NavBar = () => {
  return (
    <div className='nav-bar'>
      <nav className='nav'>
        <img className='logo' src='https://i.imgur.com/HBDe1Wd.png' alt="logo"/>
        <div className='links'>
            <a className='link-home' href=''>Inicio</a>
            <a className='link-sobre' href=''>Sobre</a>
            <a className='link-profile' href="">Meu perfil</a>
            <a className='btn-sair' href="">Sair <FiLogOut/></a>
        </div>
      </nav>
    </div>
  )
}
