import { IonBackButton, IonButtons,IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonCol, IonContent, IonGrid, IonHeader, IonItem, IonLabel, IonList, IonPage, IonRouterLink, IonRow, IonThumbnail, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './Joueurs.css';
import { useState, useEffect } from 'react';

const Home: React.FC = () => {
  const [joueurs, setJoueurs] = useState([]);
  const [equipeId, setEquipeId] = useState<number | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        if (equipeId !== null) {
          const reponse = await fetch(`https://nba-spring-production.up.railway.app/statistiques/equipes/${equipeId}`);
          const donnees = await reponse.json();
          console.log(donnees);
          setJoueurs(donnees);
        }
      } catch (erreur) {
        console.error('Erreur lors de la récupération des données :', erreur);
      }
    };

    fetchData();
  }, [equipeId]); 

  useEffect(() => {
    const url = new URL(window.location.href);
    const id = url.searchParams.get("id");

    if (id) {
      setEquipeId(Number(id)); 
    }
  }, [window.location.href]);
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonBackButton defaultHref="/home"></IonBackButton>
          </IonButtons>
          <IonTitle>Joueur Par Equipe</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Liste des joueurs</IonTitle>
          </IonToolbar>
        </IonHeader>
        <div className="table-container">
          <div className="horizontal-scroll">
            <table>
                <tr>
                  <th>Joueur</th>
                  <th>Equipe</th>
                  <th>M</th>
                  <th>MJ</th>
                  <th>PPM</th>
                  <th>RPM</th>
                  <th>PDPM</th>
                  <th>MPM</th>
                  <th>FG%</th>
                  <th>3P%</th>
                  <th>%LF</th>
                </tr>
                {joueurs.map((j) => (
                  <tr>
                     <td>{j['joueur']['nomJoueur']}</td>
                     <td>{j['joueur']['equipe']['abbreviation']}</td>
                     <td>{j['matchEquipe']}</td>
                     <td>{j['matchJoue']}</td>
                     <td>{j['pointParMatch']}</td>
                     <td>{j['rebondParMatch']}</td>
                     <td>{j['passeDecisiveParMatch']}</td>
                     <td>{j['minuteParMatch']}</td>
                     <td>{j['fg']}</td>
                     <td>{j['three']}</td>
                     <td>{j['lf']}</td>
                  </tr>
                ))}
            </table>

         </div>
    </div>
        <ExploreContainer />
      </IonContent>
    </IonPage>
  );
};

export default Home;
