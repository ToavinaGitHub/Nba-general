// Home.tsx
import React, { useState, useEffect } from 'react';
import {
  IonCard,
  IonCardContent,
  IonCardHeader,
  IonCardSubtitle,
  IonContent,
  IonHeader,
  IonItem,
  IonList,
  IonPage,
  IonRouterLink,
  IonThumbnail,
  IonTitle,
  IonToolbar
} from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';

// Import the NBA logo image
import nbaLogo from './nba.png'; // Replace with the actual path to your NBA logo image

const Home: React.FC = () => {
  const [equipes, setEquipes] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const reponse = await fetch('https://nba-spring-production.up.railway.app/equipes');
        const donnees = await reponse.json();
        setEquipes(donnees);
      } catch (erreur) {
        console.error('Erreur lors de la récupération des données :', erreur);
      }
    };

    fetchData();
  }, []);

  return (
    <IonPage>
      <IonHeader className="header">
        <IonToolbar>
          <IonThumbnail slot="start">
            <img src={nbaLogo} alt="NBA Logo" className="nba-logo" />
          </IonThumbnail>
          <IonTitle> Statistique NBA par Equipe</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonCard className="card">
          <IonCardHeader>
            <IonCardSubtitle className="card-subtitle">Liste des équipes</IonCardSubtitle>
          </IonCardHeader>
          <IonCardContent>
            <IonList>
              {equipes.map((equipe) => (
                <IonItem className="list-item" key={equipe['idEquipe']}>
                  <IonRouterLink className="list-link" href={`Joueurs?id=${equipe['idEquipe']}`}>
                    {equipe['nomEquipe']}
                  </IonRouterLink>
                </IonItem>
              ))}
            </IonList>
          </IonCardContent>
        </IonCard>
        <ExploreContainer />
      </IonContent>
    </IonPage>
  );
};

export default Home;
