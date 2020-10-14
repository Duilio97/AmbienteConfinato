package com.example.ambienteconfinato.model;

import com.example.ambienteconfinato.R;

import java.util.ArrayList;

public class ListDetails {

    public static ArrayList<Model> getList(){
        ArrayList<Model> checklist = new ArrayList<>();
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24, "step 1", "E’ stato verificato se è possibile evitare di accedere nell’ambiente confinato?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 2", "E’ stato verificato se è possibile evitare di accedere nell’ambiente confinato?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24, "step 3", "E’ stato predisposto per tutte le persone che lavorano in spazi confinati un Permesso di lavoro?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 4", "E' stato nominato un responsabile che sovraintenda all'operazione da eseguire, che assicuri l'adozione delle necessarie precauzioni e che verifichi le condizioni di sicurezza di ogni fase dell'intervento?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 5", "Il personale addetto ha la necessaria esperienza per l'intervento da eseguire e ha fruito di un adeguato addestramento?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 6", "E' stato scelto personale con una corporatura adatta tenuto conto della particolare conformazione e ristrettezza dello spazio confinato?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 7", "Il medico competente ha valutato l'idoneità psicofisica e sanitaria del personale addetto tenendo conto di aspetti quali la claustrofobia o la necessità di usare DPI respiratori?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 8", "Sono state spente o segregate eventuali attrezzature meccaniche e elettriche operative o che potrebbero entrare in funzione?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 9", "Tutte le apparecchiature utilizzate sono a sicurezza intrinseca?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 10", "Sono state sezionate eventuali condotte che potrebbero introdurre gas, fumi, vapori, acqua o altri liquidi?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 11", "E ' stata effettuata un’eventuale pulizia o rimozione dall'ambiente confinato di materiali che potrebbero rilasciare vapori, fumi, odori, ecc…?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 12", "Sono stati assicurati un accesso e un’uscita sicuri per lo spazio confinato?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 13", "L'apertura per l'accesso è abbastanza larga da consentire agli addetti di entrare e uscire facilmente con tutto l'equipaggiamento indossato e in caso di emergenza di intervenire rapidamente?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 14", "In caso di aperture ristrette vengono impiegati DPI respiratori a ventilazione assistita al posto di autorespiratori più ingombranti?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 15", "Se non è possibile aumentare il numero di aperture per l'areazione, viene assicurato il ricambio dell'aria con la ventilazione meccanica continua?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 16", "E' stato verificato che la ripresa d'aria di ventilazione dell'ambiente sia lontana da fonti di inquinamento?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 17", "Viene evitato di introdurre nello spazio confinato bombole di gas compresso o attrezzature con motori a combustione interna?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 18", "Nel caso in cui la valutazione dei rischi lo abbia previsto viene testata l'aria da parte di personale competente con strumentazione adatta e opportunamente tarata?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 19", "C’è una registrazione dei test effettuati sull’aria prima che il personale lavori negli ambienti confinati?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 20", "Se la valutazione ha evidenziato che l'atmosfera dello spazio confinato non risulta stabile viene effettuato un monitoraggio continuo dell'aria?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 21", "Se è possibile la presenza di atmosfere infiammabili o potenzialmente esplosive viene vietato l'uso di fiamme libere e previsto l'impiego di attrezzature elettriche (compreso il dispositivo di ventilazione) antideflagranti?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 22", "All'interno di recipienti metallici vengono utilizzati sistemi di illuminazione e utensili elettrici del tipo a tensione di sicurezza (<25V)?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 23", "I recipienti metallici se necessario sono stati collegati a terra per scaricare eventuali correnti statiche?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 24", "Se l'aria è inquinata da gas, vapori o è povera di ossigeno (< 19%) vengono utilizzati autorespiratori?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 25", "Viene vietato l'immissione di ossigeno puro nell'ambiente confinato per rendere l'aria respirabile?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 26", "E' stato predisposto un Piano di emergenza con l'individuazione dei soggetti, dell'equipaggiamento e l'organizzazione dell'addestramento anche con esercitazioni?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 27", "Sono state predisposte linee vita, a cui agganciare posteriormente le imbracature, fissate ad un treppiede esterno all'ambiente confinato munito di argano?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 28", "E' stato predisposto un sistema che renda possibile la comunicazione efficiente tra l'interno e l'esterno dell'ambiente confinato e la rapida chiamata di aiuto in caso di emergenza?"));
        checklist.add(new Model(R.drawable.ic_baseline_check_circle_24,"step 29", "Oltre al sovraintendente è stata prevista la presenza di una terza persona che possa intervenire in caso di emergenza e attivi le procedure di soccorso?"));
        return checklist;

    }
}
