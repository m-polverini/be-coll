# Challenge answers

## A - The entities
![Alt text](diagramma.png?raw=true "diagrama")

Ho scelto di gestire i veicoli su un'unica tabella che è la e_vehicle. Ho pensato di dover gestire la relazione padre
figlio tra il modello principale e i modelli figli all'interno della stessa tabella tramite il campo id_vehicle_parent.

## B - Ingest the data
Per leggere il file xml ho mappato gli elementi di quest'ultimo con degli oggetti specifici. Ho usato poi JAXB e la classe 
Unmarshaller per popolare gli oggetti.
Una volta letto il file xml, nel caso non abbia trovato nessun veicolo da processare ho rilanciato un'eccezione creata
appositamente NoVehiclesFoundException. Per la lettura del catalogo ho usato uno stream per mappare la lista dei 
risultati con i dto da inviare al service per l'inserimento sul DB.

## C - Expose data with a RESTful API
Ho creato due endpoint che rispondono alle url:
1. /vehicles/{idVehicle}
2. /vehicles

Il primo endpoint estrae il veicolo per ID e restituisce il dettaglio. Nel caso del padre all'interno del dettaglio ci
saranno tutti i figli, mentre per quanto riguarda il figlio, all'interno del dettaglio ci sarà il padre.

Il secondo endpoint estrae invece tutti i padri quindi che hanno id_vehicle_parent null ed è possibile effettuare la
ricerca anche per nome tramite query params (?name=aspira).

## D - Adding images
Per aggiungere le immagini nell'ingest dei dati, aggiungerei l'immagine nell'xml codificata in base64 per poterla poi 
leggere e decodificare lato java e salvarla su filesystem. Se l'ingest dei dati non avvenisse tramite XML, ma tramite servizio REST invece
opterei per gestire i file tramite Multipart, che sono più veloci ed occupano il 30% in meno del base64.

## E - Improvements
Nel caso di aggiunta dell'immagine, non l'aggiungerei alla response dei servizi rest, ma esporrei un nuovo servizio rest
che restituisce solo l'immagine.