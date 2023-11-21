import { IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonCol, IonContent, IonGrid, IonHeader, IonItem, IonLabel, IonList, IonPage, IonRouterLink, IonRow, IonThumbnail, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './Joueurs.css';
import { useState, useEffect } from 'react';

const Home: React.FC = () => {
  const [joueurs, setJoueurs] = useState([]);
  const [equipeId, setEquipeId] = useState<number | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Assurez-vous que equipeId a une valeur avant de faire la requête
        if (equipeId !== null) {
          const reponse = await fetch(`http://192.168.113.227:8080/equipes/joueurs/${equipeId}`);
          const donnees = await reponse.json();
          setJoueurs(donnees);
        }
      } catch (erreur) {
        console.error('Erreur lors de la récupération des données :', erreur);
      }
    };

    fetchData();
  }, [equipeId]); // Utilisez equipeId comme dépendance pour que cela se déclenche à chaque changement

  useEffect(() => {
    // Analyser l'URL pour extraire l'ID de l'équipe
    const url = new URL(window.location.href);
    const id = url.searchParams.get("id");
    

    if (id) {
      setEquipeId(Number(id)); // Assurez-vous que l'ID est de type number
    }
  }, [window.location.href]);
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
            <IonTitle size="large">Joueurs</IonTitle>
          </IonToolbar>
        </IonHeader>
        <div className="table-container">
          <div className="horizontal-scroll">
        <IonGrid>
              <IonRow className='table-header'>
                <IonCol>Classement</IonCol>
                <IonCol>Nom</IonCol>
                <IonCol>M</IonCol>
                <IonCol>MJ</IonCol>
                <IonCol>PPM</IonCol>
                <IonCol>RPM</IonCol>
                <IonCol>PDPM</IonCol>
                <IonCol>MPM</IonCol>
                <IonCol>EFF</IonCol>
                <IonCol>FG%</IonCol>
                <IonCol>3P%</IonCol>
                <IonCol>%LF</IonCol>
                <IonCol>Désactivé</IonCol>


              </IonRow>

              {joueurs.map((joueur) => (
    <IonRow key={joueur['idJoueur']} className='table-row'>
      <IonCol>{joueur['idJoueur']}</IonCol>
      <IonCol>{joueur['nomJoueur']}</IonCol>
      <IonCol>{joueur['equipe']['abbreviation']}</IonCol>
      {/* <IonCol>{joueur.matchJoue}</IonCol>
      <IonCol>{joueur.matchJoue}</IonCol>
      <IonCol>{joueur.pointParMatch}</IonCol>
      <IonCol>{joueur.rebondParMatch}</IonCol>
      <IonCol>{joueur.passeDecisiveParMatch}</IonCol>
      <IonCol>{joueur.minuteParMatch}</IonCol>
      <IonCol>{joueur.efficacite}</IonCol>
      <IonCol>{joueur.fg}</IonCol>
      <IonCol>{joueur.lf}</IonCol>
      <IonCol>{joueur.desactive}</IonCol> */}
    </IonRow>
  ))}
            </IonGrid>
    </div>
    </div>
        <ExploreContainer />
      </IonContent>
    </IonPage>
  );
};

export default Home;
