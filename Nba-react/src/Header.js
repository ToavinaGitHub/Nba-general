import React from 'react';
import logo from './assets/image/logo.jpg';

const Header = () => {
  const headerStyle = {
    backgroundColor: 'black',
    display: 'flex',
    alignItems: 'center',  
    justifyContent: 'center', 
    height: '100px',
  };

  const textStyle = {
    textAlign: 'center',
  }

  return (
    <><div style={headerStyle}>
       <img src={logo} alt="Logo NBA" style={{ maxWidth: '80%', maxHeight: '80%' }} />
      </div>
      <div>
        <h3 style={textStyle}>Statistiques individuelles</h3>
        <hr></hr>
      </div></>
  );
};

export default Header;
