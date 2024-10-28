# Atelier Doublures pour Architecture Hexagonale

## Pitch 

Vous vous posez des questions sur les doublures de tests ou ce qui est généralement et abusivement dénommé “mocks”.
Venez dans cet atelier apprendre la terminologie précise et ce qu’ils sont : des bouchons, doublures, dummy, stubs, fake, spy et mock. Vous apprendrez également quand et pourquoi les utiliser.
Vous pourrez, par exemple, comparer en situation réaliste, l’usage d’un fake versus un spy. Sur du code qui ressemble vraiment à celui que vous poussez en production. Et même découvrir les coulisses d’un stub ou spy en développant par vous même des doublures de tests au plus près de vos besoins. Sans passer par l’artillerie lourde! 

## Bénéfices attendus

- Comprendre les tests unitaires et le besoin de doublures; clarifier ce que l’on appel doublure de tests.
- Appréhender quand ces doublures de tests sont légitimes dans leurs usages.
- Démystifier ce qu’est un spy, un fake, un mock.
- En produisant (en TDD, toujours) un code emprunt de situations réelles : dialogue avec une base de données, un service web, une librairie générant des uuid… comme exemple couramment rencontrés.
- Apprendre en s’amusant, en collaborant afin de produire, tous ensemble, le code mettant en oeuvre ces doublures de tests (Session Mob Programming). 



A dire plutôt sur la fin... 
- écouter les tests, si ces derniers sont compliqué ou difficile à écrire, ou sont fragile alors il y a certainement un 
problème de design. Trop de resposabilités ? Trop de dépendances ? Par exemple Ticket et horodatage = trop de responsabilités ce n'est pas à lui de déterminer l'origine du temps, 
c'est fonction impure elle dépend de l'état du système et de plus elle possède une dépendance extern, ici l'horloge du système.


