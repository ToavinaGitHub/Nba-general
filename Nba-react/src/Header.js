import React from 'react';

const Header = () => {
  return (
    <nav className="navbar navbar-default">
      <div className="container">
        <div className="navbar-header">
          <a className="navbar-brand" href="#">Mon Site</a>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="nav navbar-nav navbar-right">
            <li><a href="#">Accueil</a></li>
            <li><a href="#">À Propos</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Header;
