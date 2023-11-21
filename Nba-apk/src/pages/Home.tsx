import { IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonContent, IonHeader, IonItem, IonLabel, IonList, IonPage, IonRouterLink, IonThumbnail, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';
import { useState, useEffect } from 'react';

const Home: React.FC = () => {
  const [equipes, setEquipes] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const reponse = await fetch('http://192.168.113.227:8080/equipes');
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
      <IonHeader>
        <IonToolbar>
          <IonTitle>Blank</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Nba</IonTitle>
          </IonToolbar>
        </IonHeader>

        <IonCard>
      <IonCardHeader>
        <IonCardSubtitle>list des equipes</IonCardSubtitle>
      </IonCardHeader>
      <IonCardContent>
      <IonList>
              {equipes.map((equipe) => (
                <IonItem key={equipe['idEquipe']}>
                  <IonThumbnail slot="start">
                    {/* Vous pouvez afficher une image ici si vos données incluent des URL d'images */}
                  </IonThumbnail>
                  <IonRouterLink href={`Joueurs?id=${equipe['idEquipe']}`}>{equipe['nomEquipe']}</IonRouterLink>
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
